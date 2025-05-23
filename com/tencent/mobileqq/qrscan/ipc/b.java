package com.tencent.mobileqq.qrscan.ipc;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qrscan.api.IQRScanIpcApi;
import com.tencent.mobileqq.qrscan.earlydown.QBarSoDownloader;
import com.tencent.mobileqq.qrscan.ipc.QRScanResDownloadManager;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b extends QIPCModule {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static volatile b f276656d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class a implements QRScanResDownloadManager.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f276657a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f276658b;

        a(int i3, String str) {
            this.f276657a = i3;
            this.f276658b = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, b.this, Integer.valueOf(i3), str);
            }
        }

        @Override // com.tencent.mobileqq.qrscan.ipc.QRScanResDownloadManager.a
        public void a(int i3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            } else if (i3 == this.f276657a) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("key_download_result", z16);
                bundle.putInt("key_res_type", i3);
                QIPCServerHelper.getInstance().callClient(this.f276658b, IQRScanIpcApi.MODULUE_SUB, "action_notify_download_result", bundle, null);
            }
        }

        @Override // com.tencent.mobileqq.qrscan.ipc.QRScanResDownloadManager.a
        public void onProgress(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
            }
        }
    }

    public b(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
    }

    private void b() {
        QBarSoDownloader.h().o();
    }

    private void c(int i3, String str) {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (!(waitAppRuntime instanceof AppInterface)) {
            return;
        }
        QRScanResDownloadManager.a(new a(i3, str));
        QLog.i("MiniRecog.QRScanMainQIPCModule", 1, String.format("downloadQRScanRes resType=%d procName=%s", Integer.valueOf(i3), str));
        QRScanResDownloadManager.c(i3, (AppInterface) waitAppRuntime);
    }

    public static b d() {
        if (f276656d == null) {
            synchronized (b.class) {
                if (f276656d == null) {
                    f276656d = new b(IQRScanIpcApi.MODULUE_MAIN);
                }
            }
        }
        return f276656d;
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 2, this, str, bundle, Integer.valueOf(i3));
        }
        String string = bundle.getString("key_call_proc", "");
        QLog.i("MiniRecog.QRScanMainQIPCModule", 1, String.format("onCall_%s procName=%s", str, string));
        if ("action_call_download_res".equalsIgnoreCase(str)) {
            c(bundle.getInt("key_res_type", -1), string);
            return null;
        }
        if ("action_call_download_qbar_so".equalsIgnoreCase(str)) {
            b();
            return null;
        }
        return null;
    }
}
