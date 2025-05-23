package com.tencent.mobileqq.troop.qrcode;

import android.content.SharedPreferences;
import com.tencent.biz.richframework.download.RFWDownloadStrategy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/troop/qrcode/a;", "Lcom/tencent/biz/richframework/download/RFWDownloadStrategy;", "", "getBusinessKey", "getDownloadRootPath", "Landroid/content/SharedPreferences;", "getSP", "", "supportUnZipFile", "supportBreakPointDownload", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a extends RFWDownloadStrategy {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f298164a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62039);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f298164a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
    @NotNull
    public String getBusinessKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "QRCodeDownloadStrategy";
    }

    @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
    @NotNull
    public String getDownloadRootPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return MobileQQ.sMobileQQ.getFilesDir().getAbsolutePath() + "/qrcode/";
    }

    @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
    @Nullable
    public SharedPreferences getSP() {
        AppRuntime peekAppRuntime;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (SharedPreferences) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null && (peekAppRuntime = mobileQQ.peekAppRuntime()) != null) {
            return peekAppRuntime.getPreferences();
        }
        return null;
    }

    @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
    public boolean supportBreakPointDownload() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
    public boolean supportUnZipFile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return false;
    }
}
