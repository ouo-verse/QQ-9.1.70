package com.tencent.mobileqq.qrscan.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qrscan.api.IQRScanIpcApi;
import com.tencent.mobileqq.qrscan.e;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes17.dex */
public class d extends QIPCModule {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private static volatile d f276663e;

    /* renamed from: f, reason: collision with root package name */
    public static volatile boolean f276664f;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<e> f276665d;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a implements EIPCResultCallback {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eIPCResult);
                return;
            }
            Object[] objArr = new Object[2];
            boolean z16 = false;
            objArr[0] = "action_call_download_res";
            if (eIPCResult != null && eIPCResult.isSuccess()) {
                z16 = true;
            }
            objArr[1] = Boolean.valueOf(z16);
            QLog.d("MiniRecog.QRScanSubQIPCModule", 1, String.format("callServer_%s result=%b", objArr));
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28396);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f276664f = false;
        }
    }

    public d(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
    }

    public static d c() {
        if (f276663e == null) {
            synchronized (d.class) {
                if (f276663e == null) {
                    f276663e = new d(IQRScanIpcApi.MODULUE_SUB);
                }
            }
        }
        return f276663e;
    }

    public void b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("key_res_type", i3);
        bundle.putString("key_call_proc", BaseApplication.processName);
        QLog.d("MiniRecog.QRScanSubQIPCModule", 1, String.format("downloadQRScanRes resType=%d proc=%s", Integer.valueOf(i3), BaseApplication.processName));
        QIPCClientHelper.getInstance().callServer(IQRScanIpcApi.MODULUE_MAIN, "action_call_download_res", bundle, new a());
    }

    public void d(e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) eVar);
        } else if (eVar == null) {
            this.f276665d = null;
        } else {
            this.f276665d = new WeakReference<>(eVar);
        }
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        e eVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 2, this, str, bundle, Integer.valueOf(i3));
        }
        WeakReference<e> weakReference = this.f276665d;
        if (weakReference == null) {
            eVar = null;
        } else {
            eVar = weakReference.get();
        }
        if ("action_notify_download_process".equalsIgnoreCase(str)) {
            int i16 = bundle.getInt("key_res_type", -1);
            int i17 = bundle.getInt("key_download_progress", 0);
            if (eVar != null) {
                eVar.e(i16, i17);
            }
        } else if ("action_notify_download_result".equalsIgnoreCase(str)) {
            int i18 = bundle.getInt("key_res_type", -1);
            boolean z16 = bundle.getBoolean("key_download_result", false);
            QLog.d("MiniRecog.QRScanSubQIPCModule", 1, String.format("onCall_%s resType=%d suc=%b", str, Integer.valueOf(i18), Boolean.valueOf(z16)));
            if (eVar != null) {
                eVar.d(i18, z16);
            }
        }
        return null;
    }

    public synchronized void register() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (!f276664f) {
            try {
                QIPCClientHelper.getInstance().register(this);
                f276664f = true;
            } catch (Exception e16) {
                QLog.d("MiniRecog.QRScanSubQIPCModule", 1, "register", e16);
            }
        }
    }

    public synchronized void unregister() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        try {
            if (QIPCClientHelper.getInstance().getClient() != null) {
                QIPCClientHelper.getInstance().getClient().unRegisterModule(this);
                f276664f = false;
            }
        } catch (Exception e16) {
            QLog.d("MiniRecog.QRScanSubQIPCModule", 1, "unregister", e16);
        }
    }
}
