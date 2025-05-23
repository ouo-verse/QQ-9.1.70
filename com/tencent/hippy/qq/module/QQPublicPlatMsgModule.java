package com.tencent.hippy.qq.module;

import android.text.TextUtils;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHippyApi;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.nt.api.IQQGamePubMsgApi;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;

@HippyNativeModule(name = QQPublicPlatMsgModule.CLASSNAME)
/* loaded from: classes7.dex */
public class QQPublicPlatMsgModule extends QQBaseModule {
    private static final int CALL_MSG_API_FREQUENCY_PER_MIN = 60;
    static final String CLASSNAME = "QQPublicPlatMsgModule";
    private static final int MAX_REQUEST_MSG_LIST_FREQUENCY = 5;
    private static final int ONE_SECOND_IN_MILLISECONDS = 1000;
    private static final int RESULT_CODE_ENV_ERROR = -3;
    private static final int RESULT_CODE_NO_PERMISSION = -2;
    private static final int RESULT_CODE_OK = 0;
    private static final int RESULT_CODE_PARAMS_ERROR = -1;
    private static final int RESULT_CODE_TOO_FAST = -4;
    private int mCurrentRequestGameMallMsgListCount;
    private int mCurrentRequestGamePubMsgListCount;
    private long mLastRequestGameMallMsgListTime;
    private long mLastRequestGamePubMsgListTime;

    public QQPublicPlatMsgModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
    }

    private boolean checkRequestGameMallMsgListFrequency() {
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = this.mLastRequestGameMallMsgListTime;
        if (currentTimeMillis >= j3 && currentTimeMillis - j3 <= 1000) {
            int i3 = this.mCurrentRequestGameMallMsgListCount;
            if (i3 >= 5) {
                return false;
            }
            this.mCurrentRequestGameMallMsgListCount = i3 + 1;
            return true;
        }
        this.mCurrentRequestGameMallMsgListCount = 1;
        this.mLastRequestGameMallMsgListTime = System.currentTimeMillis();
        return true;
    }

    private boolean checkRequestGamePubMsgListFrequency() {
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = this.mLastRequestGamePubMsgListTime;
        if (currentTimeMillis >= j3 && currentTimeMillis - j3 <= 1000) {
            int i3 = this.mCurrentRequestGamePubMsgListCount;
            if (i3 >= 5) {
                return false;
            }
            this.mCurrentRequestGamePubMsgListCount = i3 + 1;
            return true;
        }
        this.mCurrentRequestGamePubMsgListCount = 1;
        this.mLastRequestGamePubMsgListTime = System.currentTimeMillis();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getGamePubMsgList$1(String str, Promise promise, ArrayList arrayList) {
        long j3;
        QQGameMsgInfo qQGameMsgInfo;
        if (arrayList != null && arrayList.size() > 0 && (qQGameMsgInfo = (QQGameMsgInfo) arrayList.get(arrayList.size() - 1)) != null) {
            j3 = qQGameMsgInfo.msgId;
        } else {
            j3 = 0;
        }
        onGetMsgList(0, j3, GamePubAccountHelper.o(arrayList, System.currentTimeMillis(), 0L, str), promise);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getMsgList$0(int i3, final Promise promise) {
        ((IQQGameHelper) QRoute.api(IQQGameHelper.class)).findGameMallRecentMessage(i3, new IQQGameHelper.a() { // from class: com.tencent.hippy.qq.module.QQPublicPlatMsgModule.1
            @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHelper.a
            public void onGetMsgInfo(JSONArray jSONArray) {
                QQPublicPlatMsgModule.this.onGetMsgList(0, 0L, jSONArray, promise);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onGetMsgList(int i3, long j3, JSONArray jSONArray, Promise promise) {
        try {
            HippyMap hippyMap = new HippyMap();
            hippyMap.pushInt("retCode", i3);
            if (jSONArray != null) {
                HippyArray hippyArray = new HippyArray();
                hippyArray.pushJSONArray(jSONArray);
                hippyMap.pushArray(TabPreloadItem.TAB_NAME_MESSAGE, hippyArray);
            }
            if (j3 != 0) {
                hippyMap.pushString("nextRequestRawMsgId", String.valueOf(j3));
            }
            promise.resolve(hippyMap);
        } catch (Throwable th5) {
            QLog.e(CLASSNAME, 1, "onGetMsgList error,", th5);
        }
    }

    @HippyMethod(name = "getGamePubMsgList")
    public void getGamePubMsgList(HippyMap hippyMap, final Promise promise) {
        Long l3;
        QLog.e(CLASSNAME, 1, "Hippy getGamePubMsgList start");
        if (hippyMap != null && promise != null) {
            String string = hippyMap.getString("rawMsgId");
            final String string2 = hippyMap.getString("gameAppId");
            int i3 = hippyMap.getInt("count");
            if (i3 <= 0) {
                onGetMsgList(-1, 0L, null, promise);
                return;
            }
            if (!((IQQGameHippyApi) QRoute.api(IQQGameHippyApi.class)).isQQGameCenterBundle(getBundleName())) {
                onGetMsgList(-2, 0L, null, promise);
                QLog.e(CLASSNAME, 1, "getGamePubMsgList not permission");
                return;
            }
            if (!checkRequestGamePubMsgListFrequency()) {
                onGetMsgList(-4, 0L, null, promise);
                QLog.e(CLASSNAME, 1, "call getGamePubMsgList two fast");
                return;
            }
            try {
                l3 = 0L;
                if (!TextUtils.isEmpty(string)) {
                    l3 = Long.valueOf(Long.parseLong(string));
                }
            } catch (NumberFormatException unused) {
            }
            try {
                ((IQQGamePubMsgApi) QRoute.api(IQQGamePubMsgApi.class)).getBusinessMsgListByMsgId(l3.longValue(), i3, i3 + 10, new IQQGamePubMsgApi.a() { // from class: com.tencent.hippy.qq.module.i
                    @Override // com.tencent.mobileqq.qqgamepub.nt.api.IQQGamePubMsgApi.a
                    public final void onSuccess(ArrayList arrayList) {
                        QQPublicPlatMsgModule.this.lambda$getGamePubMsgList$1(string2, promise, arrayList);
                    }
                }, "hippy");
            } catch (NumberFormatException unused2) {
                onGetMsgList(-1, 0L, null, promise);
                QLog.e(CLASSNAME, 1, "getHistoryMsgsWithMsgId rawMsgId error");
            }
        }
    }

    @HippyMethod(name = "getMsgList")
    public void getMsgList(final int i3, final Promise promise) {
        QLog.e(CLASSNAME, 1, "Hippy getGameMallMsgList start");
        if (promise == null) {
            return;
        }
        if (i3 <= 0) {
            onGetMsgList(-1, 0L, null, promise);
            return;
        }
        String bundleName = getBundleName();
        String gameMallBundleName = ((IQQGameConfigUtil) QRoute.api(IQQGameConfigUtil.class)).getGameMallBundleName();
        if (bundleName != null && bundleName.equals(gameMallBundleName)) {
            if (!checkRequestGameMallMsgListFrequency()) {
                onGetMsgList(-4, 0L, null, promise);
                QLog.e(CLASSNAME, 1, "call getGameMallMsgList two fast");
                return;
            } else {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.hippy.qq.module.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        QQPublicPlatMsgModule.this.lambda$getMsgList$0(i3, promise);
                    }
                }, 32, null, true);
                return;
            }
        }
        onGetMsgList(-2, 0L, null, promise);
        QLog.e(CLASSNAME, 1, "getMsgList not permission");
    }
}
