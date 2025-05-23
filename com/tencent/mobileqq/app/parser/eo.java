package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.VasConstant;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.mobileqq.vas.theme.ThemeSwitcher;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.toggle.VasLongToggle;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URLDecoder;

/* compiled from: P */
/* loaded from: classes11.dex */
public class eo extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;
    private static String Q;
    private static String R;
    private static String S;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements Downloader.DownloadListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ File f196479a;

        a(File file) {
            this.f196479a = file;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) eo.this, (Object) file);
            }
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadCanceled(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            } else {
                QLog.i("VasChangeTest", 1, "download theme canceled");
            }
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadFailed(String str, DownloadResult downloadResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) downloadResult);
            } else {
                QLog.i("VasChangeTest", 1, "download theme failed");
            }
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadProgress(String str, long j3, float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, str, Long.valueOf(j3), Float.valueOf(f16));
            }
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadSucceed(String str, DownloadResult downloadResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) downloadResult);
                return;
            }
            QLog.i("VasChangeTest", 1, "download theme success: " + downloadResult);
            ThemeUtil.validLocalTheme(eo.this.f307437b, this.f196479a.getAbsolutePath(), null);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70621);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        Q = "theme";
        R = "theme_url";
        S = "page";
    }

    public eo(QQAppInterface qQAppInterface, Context context) {
        super(qQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) context);
        }
    }

    public boolean F(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).booleanValue();
        }
        QLog.i("VasChangeTest", 1, "download theme :" + str);
        File file = new File(VasConstant.INTERNAL_CACHE_DIR, "theme.zip");
        DownloaderFactory.getInstance(BaseApplication.getContext()).getCommonDownloader().download(str, file.getAbsolutePath(), new a(file));
        return true;
    }

    public boolean G(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        return ThemeSwitcher.startSwitch(str, ThemeReporter.FROM_SIMPLE, null);
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (!VasLongToggle.AUTO_TEST.isEnable(false)) {
            return false;
        }
        try {
            if (TextUtils.equals(this.f307440e, "change_theme")) {
                String str = this.f307441f.get(R);
                if (str != null) {
                    return F(URLDecoder.decode(str, "UTF-8"));
                }
                return G(this.f307441f.get(Q));
            }
            if (TextUtils.equals(this.f307440e, "change_page")) {
                this.f307441f.get(S);
            }
            return true;
        } catch (Exception e16) {
            QLog.e("VasChangeTest", 4, "doAction error: " + e16.getMessage());
            i("VasChangeTest");
            return false;
        }
    }
}
