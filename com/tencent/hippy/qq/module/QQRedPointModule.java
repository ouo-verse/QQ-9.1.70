package com.tencent.hippy.qq.module;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emosm.t;
import com.tencent.mobileqq.redtouch.RedAppInfo;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.utils.RedTouchUtil;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

@HippyNativeModule(name = QQRedPointModule.CLASSNAME)
/* loaded from: classes7.dex */
public class QQRedPointModule extends QQBaseWebIpcModule {
    static final String CLASSNAME = "QQRedPointModule";
    private static final int SET_APPINFO_ERR_CODE_NO_APPINFO = -3;
    private static final int SET_APPINFO_ERR_CODE_SET_FAILED = -4;
    private static final int SET_APPINFO_ERR_CODE_UNKNOWN = -1;

    public QQRedPointModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext, MobileQQ.sProcessId != 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getAppInfoInSubThread, reason: merged with bridge method [inline-methods] */
    public void lambda$getAppInfo$0(String str, long j3, Promise promise) {
        HashMap<String, Object> hashMap;
        AppInterface appInterface = getAppInterface();
        if (appInterface == null) {
            return;
        }
        try {
            if (new JSONObject(str).has("pathList")) {
                hashMap = RedTouchUtil.parseGetAppInfoList(appInterface, j3, str);
            } else {
                hashMap = RedTouchUtil.parseGetAppInfo(appInterface, j3, str);
            }
        } catch (JSONException e16) {
            QLog.e(CLASSNAME, 1, "parseGetAppInfoParams error", e16);
            hashMap = null;
        }
        if (hashMap == null) {
            return;
        }
        promise.resolve((String) hashMap.get("jsonResult"));
        if (isInMainProcess()) {
            reportGetAppInfoInMainProcess(hashMap);
        } else {
            reportGetAppInfoByWebIpc(hashMap, promise);
        }
    }

    private void handleSetAppInfo(int i3, Promise promise) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", i3);
            if (i3 == -3) {
                jSONObject.put("errorMessage", "appInfo not found");
            } else if (i3 == -4) {
                jSONObject.put("errorMessage", "failed to set appInfo");
            }
            if (QLog.isColorLevel()) {
                QLog.i(CLASSNAME, 2, "setAppInfo:" + jSONObject);
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        if (promise != null) {
            promise.resolve(jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reportGetAppInfoByWebIpc$1(Promise promise, HashMap hashMap) {
        sendRemoteReq(com.tencent.mobileqq.emosm.a.a("redTouch_getAppInfo_report", promise.getCallbackId(), getIPCRequestKey(), (Bundle) hashMap.get("req")), false, true);
    }

    private void reportGetAppInfoByWebIpc(final HashMap<String, Object> hashMap, final Promise promise) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.hippy.qq.module.k
            @Override // java.lang.Runnable
            public final void run() {
                QQRedPointModule.this.lambda$reportGetAppInfoByWebIpc$1(promise, hashMap);
            }
        });
    }

    private void reportGetAppInfoInMainProcess(HashMap<String, Object> hashMap) {
        Bundle bundle = (Bundle) hashMap.get("req");
        String string = bundle.getString("ret");
        String string2 = bundle.getString("buffer");
        String string3 = bundle.getString("red");
        String string4 = bundle.getString("path");
        String string5 = bundle.getString(SemanticAttributes.DbCassandraConsistencyLevelValues.SERIAL);
        String string6 = bundle.getString("callback");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("missions");
        IRedTouchManager iRedTouchManager = (IRedTouchManager) getAppInterface().getRuntimeService(IRedTouchManager.class, "");
        iRedTouchManager.getAndSetAppInfoJsReport(12, stringArrayList, string3, string, string2, string5, string6, iRedTouchManager.getAppIdByPath(string4));
    }

    private void setAppInfoByWebIpc(HashMap<String, Object> hashMap, Promise promise) {
        String callbackId = promise.getCallbackId();
        saveCallback(promise);
        super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("redTouch_setAppInfo", callbackId, getIPCRequestKey(), (Bundle) hashMap.get("req")), false, true);
    }

    private void setAppInfoInMainProcess(HashMap<String, Object> hashMap, Promise promise) {
        BusinessInfoCheckUpdate.AppInfo e16 = com.tencent.mobileqq.redtouch.g.e((RedAppInfo) ((Bundle) hashMap.get("req")).getParcelable("red"));
        IRedTouchManager iRedTouchManager = (IRedTouchManager) getAppInterface().getRuntimeService(IRedTouchManager.class, "");
        if (e16 != null) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.addAll(e16.missions.get());
            iRedTouchManager.getAndSetAppInfoJsReport(13, arrayList, e16.iNewFlag.get() + "", "", iRedTouchManager.getSetAppInfoReportMsg(e16.path.get(), e16.buffer.get()), "", "", iRedTouchManager.getAppIdByPath(e16.path.get()));
        }
        handleSetAppInfo(iRedTouchManager.updateAppInfo(e16, false), promise);
    }

    @HippyMethod(name = "getAppInfo")
    public void getAppInfo(final String str, final Promise promise) {
        final long currentTimeMillis = System.currentTimeMillis();
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.hippy.qq.module.j
            @Override // java.lang.Runnable
            public final void run() {
                QQRedPointModule.this.lambda$getAppInfo$0(str, currentTimeMillis, promise);
            }
        }, 8, null, true);
    }

    protected int getIPCRequestKey() {
        t tVar = this.mOnRemoteResp;
        if (tVar != null) {
            return tVar.key;
        }
        return 0;
    }

    @HippyMethod(name = "isEnterFromRedPoint")
    public void isEnterFromRedPoint(String str, Promise promise) {
        HippyMap hippyMap = new HippyMap();
        if (TextUtils.isEmpty(str)) {
            hippyMap.pushInt("code", -1);
            hippyMap.pushString("errorMessage", "path params is empty");
            promise.resolve(hippyMap);
        } else {
            boolean equals = RedTouchUtil.getLastClickPath(getAppInterface()).equals(str);
            hippyMap.pushInt("code", 0);
            hippyMap.pushInt("data", equals ? 1 : 0);
            promise.resolve(hippyMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.hippy.qq.module.QQBaseWebIpcModule
    public void onResponse(Bundle bundle) {
        int i3;
        if (bundle != null && bundle.getInt("respkey", 0) == getIPCRequestKey()) {
            String string = bundle.getString("cmd");
            String string2 = bundle.getString("callbackid");
            Bundle bundle2 = bundle.getBundle("response");
            if ("redTouch_setAppInfo".equals(string)) {
                if (bundle2 == null) {
                    i3 = -1;
                } else {
                    i3 = bundle2.getInt("iret");
                }
                handleSetAppInfo(i3, getCallback(string2));
            }
        }
    }

    @HippyMethod(name = "setAppInfo")
    public void setAppInfo(String str, Promise promise) {
        HashMap<String, Object> parseSetAppInfoParam = RedTouchUtil.parseSetAppInfoParam(str);
        if (((Integer) parseSetAppInfoParam.get("code")).intValue() != 0) {
            promise.resolve((String) parseSetAppInfoParam.get("errorJson"));
        } else if (isInMainProcess()) {
            setAppInfoInMainProcess(parseSetAppInfoParam, promise);
        } else {
            setAppInfoByWebIpc(parseSetAppInfoParam, promise);
        }
    }
}
