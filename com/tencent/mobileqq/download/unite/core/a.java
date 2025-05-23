package com.tencent.mobileqq.download.unite.core;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.download.unite.config.DownloadConfigProcessor;
import com.tencent.mobileqq.download.unite.util.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.download.unite.core.a$a, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C7484a implements b.InterfaceC7486b {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Runnable f203591d;

        C7484a(Runnable runnable) {
            this.f203591d = runnable;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) runnable);
            }
        }

        @Override // com.tencent.mobileqq.download.unite.util.b.InterfaceC7486b
        public void a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
            } else if (i3 == 0) {
                ThreadManagerV2.excute(this.f203591d, 16, null, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final a f203593a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71523);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f203593a = new a();
            }
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean a(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("[UniteDownload] DownloadManagerInterceptor", 2, "[check] businessInBlackList: invoked. ", " businessName: ", str);
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean contains = DownloadConfigProcessor.a().f203573a.contains(str);
        if (QLog.isColorLevel()) {
            QLog.d("[UniteDownload] DownloadManagerInterceptor", 2, "[check] businessInBlackList: invoked. ", " inBlack: ", Boolean.valueOf(contains));
        }
        return contains;
    }

    public static boolean b(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("[UniteDownload] DownloadManagerInterceptor", 2, "[check] businessInSilentWhiteList: invoked. ", " businessName: ", str);
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean contains = DownloadConfigProcessor.a().f203574b.contains(str);
        if (QLog.isColorLevel()) {
            QLog.d("[UniteDownload] DownloadManagerInterceptor", 2, "[check] businessInSilentWhiteList: invoked. ", " inWhite: ", Boolean.valueOf(contains));
        }
        return contains;
    }

    public static a c() {
        return b.f203593a;
    }

    public static boolean d(DownloadInfo downloadInfo) {
        if (downloadInfo.Z == TMAssistantDownloadConst.SHOW_NOTIFICATION_FALSE) {
            return true;
        }
        return false;
    }

    private void f(DownloadInfo downloadInfo, Runnable runnable) {
        com.tencent.mobileqq.download.unite.util.b.e(downloadInfo, new C7484a(runnable));
    }

    private void g(DownloadInfo downloadInfo, Runnable runnable) {
        if (QLog.isColorLevel()) {
            QLog.d("[UniteDownload] DownloadManagerInterceptor", 2, "[check] uniteSilentDownload: invoked. in silent white list.", " downloadInfo: ", downloadInfo);
        }
        ThreadManagerV2.excute(runnable, 16, null, true);
    }

    private void h(DownloadInfo downloadInfo, Runnable runnable) {
        if (QLog.isColorLevel()) {
            QLog.d("[UniteDownload] DownloadManagerInterceptor", 2, "[check] uniteUniversalDownload: invoked. in silent white list.", " downloadInfo: ", downloadInfo);
        }
        if (!d(downloadInfo)) {
            downloadInfo.Z = TMAssistantDownloadConst.SHOW_NOTIFICATION_FALSE;
        }
        f(downloadInfo, runnable);
    }

    public void e(DownloadInfo downloadInfo, Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloadInfo, (Object) runnable);
            return;
        }
        String str = downloadInfo.M;
        if (a(str)) {
            QLog.d("[UniteDownload] DownloadManagerInterceptor", 1, "[check] uniteDownload: invoked. in black list.", " sourceBusinessName: ", str);
            return;
        }
        if (downloadInfo.f() == 3) {
            if (QLog.isColorLevel()) {
                QLog.d("[UniteDownload] DownloadManagerInterceptor", 2, "[check] uniteDownload: invoked. pause continue");
            }
            ThreadManagerV2.excute(runnable, 16, null, true);
            return;
        }
        boolean b16 = b(str);
        boolean z16 = downloadInfo.f341202r0;
        boolean z17 = !downloadInfo.f341203s0;
        boolean z18 = !DownloadConfigProcessor.a().f203580h;
        if (QLog.isColorLevel()) {
            QLog.d("[UniteDownload] DownloadManagerInterceptor", 2, "[check] uniteDownload: invoked. ", " inWhite: ", Boolean.valueOf(b16), " isFromRockDownloader: ", Boolean.valueOf(z16), " notUniteDownload: ", Boolean.valueOf(z17), " disableUniteDownloadDialog: ", Boolean.valueOf(z18));
        }
        if (!b16 && !z16 && !z17 && !z18) {
            h(downloadInfo, runnable);
        } else {
            g(downloadInfo, runnable);
        }
    }
}
