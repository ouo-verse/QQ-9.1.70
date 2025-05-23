package com.tencent.tmdownloader;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.tmassistant.aidl.b;
import com.tencent.tmassistantbase.util.r;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TMAssistantDownloadSettingClient extends a {
    static IPatchRedirector $redirector_ = null;
    protected static final String DOWNDLOADSDKSERVICENAME = "com.tencent.tmdownloader.TMAssistantDownloadService";
    protected static final String TAG = "TMAssistantDownloadSettingClient";

    public TMAssistantDownloadSettingClient(Context context, String str) {
        super(context, str, DOWNDLOADSDKSERVICENAME);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) str);
        }
    }

    @Override // com.tencent.tmdownloader.a
    protected Intent getBindServiceIntent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Intent) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return new Intent(this.mContext, Class.forName(this.mServiceName));
    }

    public synchronized int getVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        com.tencent.tmassistant.aidl.b bVar = (com.tencent.tmassistant.aidl.b) super.getServiceInterface();
        if (bVar != null) {
            return bVar.c();
        }
        super.initTMAssistantDownloadSDK();
        return 0;
    }

    public synchronized boolean isAllDownloadFinished() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        r.b(TAG, BaseConstants.BROADCAST_USERSYNC_ENTER);
        com.tencent.tmassistant.aidl.b bVar = (com.tencent.tmassistant.aidl.b) super.getServiceInterface();
        if (bVar != null) {
            z16 = bVar.h();
            r.b(TAG, "isAllDownloadFinished");
        } else {
            super.initTMAssistantDownloadSDK();
            r.b(TAG, "initTMAssistantDownloadSDK");
            z16 = false;
        }
        r.b(TAG, "isAllDownloadFinished ret:" + z16);
        r.b(TAG, "exit");
        return z16;
    }

    @Override // com.tencent.tmdownloader.a
    protected void onDownloadSDKServiceInvalid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    @Override // com.tencent.tmdownloader.a
    protected void registerServiceCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            ((com.tencent.tmassistant.aidl.b) this.mServiceInterface).a(this.mClientKey, (com.tencent.tmassistant.aidl.a) this.mServiceCallback);
        }
    }

    public synchronized void setDownloadSDKMaxTaskNum(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        r.b(TAG, BaseConstants.BROADCAST_USERSYNC_ENTER);
        r.b(TAG, "maxTaskNum: " + i3);
        if (i3 >= 1 && i3 <= 10) {
            com.tencent.tmassistant.aidl.b bVar = (com.tencent.tmassistant.aidl.b) super.getServiceInterface();
            if (bVar != null) {
                bVar.a(i3);
                r.b(TAG, "setServiceSetingMaxTaskNum");
            } else {
                super.initTMAssistantDownloadSDK();
                r.b(TAG, "initTMAssistantDownloadSDK");
            }
            r.b(TAG, "exit");
            return;
        }
        r.b(TAG, "maxTaskNum < 1 || maxTaskNum > 10");
        r.b(TAG, "exit");
    }

    public synchronized void setDownloadSDKWifiOnly(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
            return;
        }
        r.b(TAG, BaseConstants.BROADCAST_USERSYNC_ENTER);
        r.b(TAG, "isDownloadWifiOnly: " + z16);
        com.tencent.tmassistant.aidl.b bVar = (com.tencent.tmassistant.aidl.b) super.getServiceInterface();
        if (bVar != null) {
            bVar.a(z16);
            r.b(TAG, "setDownloadWifiOnly");
        } else {
            super.initTMAssistantDownloadSDK();
            r.b(TAG, "initTMAssistantDownloadSDK");
        }
        r.b(TAG, "exit");
    }

    @Override // com.tencent.tmdownloader.a
    protected void stubAsInterface(IBinder iBinder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) iBinder);
        } else {
            this.mServiceInterface = b.a.a(iBinder);
        }
    }

    @Override // com.tencent.tmdownloader.a
    protected void unRegisterServiceCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            ((com.tencent.tmassistant.aidl.b) this.mServiceInterface).b(this.mClientKey, (com.tencent.tmassistant.aidl.a) this.mServiceCallback);
        }
    }
}
