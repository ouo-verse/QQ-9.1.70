package com.tencent.mobileqq.qqlive.api.impl;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorHelperFastResume;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDKManager;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRecord;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.IAegisLogApi;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveSDKManagerImpl implements IQQLiveSDKManager {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "QQLiveAnchor_SDK_Manager";
    private IAegisLogApi mAegisLog;
    private final ConcurrentHashMap<String, IQQLiveSDK> sdkImpls;

    public QQLiveSDKManagerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.sdkImpls = new ConcurrentHashMap<>();
            this.mAegisLog = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
        }
    }

    private boolean isValidProcess() {
        int i3 = MobileQQ.sProcessId;
        if (i3 == 1 || i3 == 7 || i3 == 2) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveSDKManager
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.mAegisLog.i(TAG, 1, "sdk manager destroy");
        if (!this.sdkImpls.isEmpty()) {
            Iterator<Map.Entry<String, IQQLiveSDK>> it = this.sdkImpls.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().destroy();
            }
        }
        this.sdkImpls.clear();
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveSDKManager
    public void destroySDKImpl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
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

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveSDKManager
    public QQLiveAnchorRecord getExistAnchorRecord(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (QQLiveAnchorRecord) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) str2);
        }
        return QQLiveAnchorHelperFastResume.j(null, str, str2, null);
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveSDKManager
    public IQQLiveSDK getSDKImpl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IQQLiveSDK) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        if (!isValidProcess()) {
            this.mAegisLog.a(TAG, 1, "cannot create IQQLiveSDK instance in " + MobileQQ.processName);
            return null;
        }
        if (!QQVideoPlaySDKManager.isSDKReady()) {
            QQVideoPlaySDKManager.initSDKAsync(BaseApplication.getContext(), new SDKInitListener() { // from class: com.tencent.mobileqq.qqlive.api.impl.QQLiveSDKManagerImpl.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveSDKManagerImpl.this);
                    }
                }

                @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
                public void onSDKInited(boolean z16) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        QQLiveSDKManagerImpl.this.mAegisLog.i("QQLiveSDKManagerImpl", 1, "QQVideoPlaySDKManagerInit " + z16);
                        return;
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this, z16);
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

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveSDKManager
    public void openDemo(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
            return;
        }
        try {
            context.startActivity(new Intent(context, Class.forName("com.tencent.qqlive.sdk.demo.TestActivity")));
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "find class error", th5);
        }
    }
}
