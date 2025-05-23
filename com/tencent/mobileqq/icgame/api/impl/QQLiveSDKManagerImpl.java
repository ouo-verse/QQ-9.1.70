package com.tencent.mobileqq.icgame.api.impl;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.IQQLiveSDKManager;
import com.tencent.mobileqq.icgame.data.anchor.room.QQLiveAnchorRecord;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes15.dex */
public class QQLiveSDKManagerImpl implements IQQLiveSDKManager {
    private static final String TAG = "ICGameAnchor_SDK_Manager";
    private final ConcurrentHashMap<String, IQQLiveSDK> sdkImpls = new ConcurrentHashMap<>();
    private IAegisLogApi mAegisLog = (IAegisLogApi) QRoute.api(IAegisLogApi.class);

    private boolean isValidProcess() {
        int i3 = MobileQQ.sProcessId;
        if (i3 == 1 || i3 == 7 || i3 == 2) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveSDKManager
    public void destroy() {
        this.mAegisLog.i(TAG, 1, "sdk manager destroy");
        if (!this.sdkImpls.isEmpty()) {
            Iterator<Map.Entry<String, IQQLiveSDK>> it = this.sdkImpls.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().destroy();
            }
        }
        this.sdkImpls.clear();
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveSDKManager
    public void destroySDKImpl(String str) {
        QLog.i(TAG, 1, "destroy sdk step1, appId:" + str);
        IQQLiveSDK remove = this.sdkImpls.remove(str);
        if (remove != null) {
            QLog.i(TAG, 1, "destroy sdk step2, appId:" + str);
            synchronized (this) {
                if (!remove.isDestroyed()) {
                    QLog.i(TAG, 1, "destroy sdk step3, appId:" + str);
                    remove.destroy();
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveSDKManager
    public QQLiveAnchorRecord getExistAnchorRecord(String str, String str2) {
        return null;
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveSDKManager
    public IQQLiveSDK getSDKImpl(String str) {
        if (!isValidProcess()) {
            this.mAegisLog.a(TAG, 1, "cannot create IQQLiveSDK instance in " + MobileQQ.processName);
            return null;
        }
        if (!QQVideoPlaySDKManager.isSDKReady()) {
            QQVideoPlaySDKManager.initSDKAsync(BaseApplication.getContext(), new SDKInitListener() { // from class: com.tencent.mobileqq.icgame.api.impl.QQLiveSDKManagerImpl.1
                @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
                public void onSDKInited(boolean z16) {
                    QQLiveSDKManagerImpl.this.mAegisLog.i("QQLiveSDKManagerImpl", 1, "QQVideoPlaySDKManagerInit " + z16);
                }
            });
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        IQQLiveSDK iQQLiveSDK = this.sdkImpls.get(str);
        if (iQQLiveSDK == null) {
            synchronized (this) {
                iQQLiveSDK = this.sdkImpls.get(str);
                if (iQQLiveSDK == null) {
                    this.mAegisLog.i(TAG, 1, "create sdk for appId:" + str);
                    iQQLiveSDK = new QQLiveSDKImpl(str);
                    this.sdkImpls.put(str, iQQLiveSDK);
                }
            }
        }
        return iQQLiveSDK;
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveSDKManager
    public void openDemo(Context context) {
        try {
            context.startActivity(new Intent(context, Class.forName("com.tencent.qqlive.sdk.demo.TestActivity")));
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "find class error", th5);
        }
    }
}
