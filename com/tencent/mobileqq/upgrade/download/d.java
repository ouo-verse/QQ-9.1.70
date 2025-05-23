package com.tencent.mobileqq.upgrade.download;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 %2\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u00a2\u0006\u0004\b#\u0010$J\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\f\u001a\u00020\u00062\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nH\u0016J(\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001c\u0010\u0015\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u0010\u0016\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u0010\u0017\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000eH\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR$\u0010\"\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/upgrade/download/d;", "Lcom/tencent/open/downloadnew/DownloadListener;", "", "d", "Lcom/tencent/open/downloadnew/DownloadInfo;", "info", "", "onDownloadPause", "onDownloadWait", "onDownloadCancel", "", "infos", "onDownloadUpdate", "errorCode", "", "errorMsg", "state", "onDownloadError", "onDownloadFinish", "appid", "packageName", "installSucceed", "uninstallSucceed", "packageReplaced", "Lcom/tencent/mobileqq/upgrade/download/c;", "a", "Lcom/tencent/mobileqq/upgrade/download/c;", "download", "b", "Lcom/tencent/open/downloadnew/DownloadInfo;", "e", "()Lcom/tencent/open/downloadnew/DownloadInfo;", "f", "(Lcom/tencent/open/downloadnew/DownloadInfo;)V", "mDownloadInfo", "<init>", "(Lcom/tencent/mobileqq/upgrade/download/c;)V", "c", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class d implements DownloadListener {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c download;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private DownloadInfo mDownloadInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/upgrade/download/d$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.upgrade.download.d$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63122);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public d(@NotNull c download) {
        Intrinsics.checkNotNullParameter(download, "download");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) download);
        } else {
            this.download = download;
        }
    }

    public final int d() {
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        DownloadInfo downloadInfo = this.mDownloadInfo;
        if (downloadInfo != null) {
            num = Integer.valueOf(downloadInfo.f());
        } else {
            num = null;
        }
        if (num == null || num.intValue() != 10) {
            if (num != null && num.intValue() == 4) {
                return 4;
            }
            if (num != null && num.intValue() == 2) {
                return 1;
            }
            if (num == null || num.intValue() != 1) {
                if (num != null && num.intValue() == 3) {
                    return 2;
                }
                if (num != null && num.intValue() == 20) {
                    return 3;
                }
            }
        }
        return 0;
    }

    @Nullable
    public final DownloadInfo e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (DownloadInfo) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mDownloadInfo;
    }

    public final void f(@Nullable DownloadInfo downloadInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) downloadInfo);
        } else {
            this.mDownloadInfo = downloadInfo;
        }
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void installSucceed(@Nullable String appid, @Nullable String packageName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) appid, (Object) packageName);
        }
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void onDownloadCancel(@NotNull DownloadInfo info) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) info);
            return;
        }
        Intrinsics.checkNotNullParameter(info, "info");
        if (!Intrinsics.areEqual("100686848", info.f341184e)) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("UpgradeController_DownloadListener", 2, "onDownloadCancel");
        }
        this.mDownloadInfo = info;
        this.download.p(false);
        this.download.t();
        this.download.i(d());
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void onDownloadError(@NotNull DownloadInfo info, int errorCode, @NotNull String errorMsg, int state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, info, Integer.valueOf(errorCode), errorMsg, Integer.valueOf(state));
            return;
        }
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        if (!Intrinsics.areEqual("100686848", info.f341184e)) {
            return;
        }
        QLog.d("UpgradeController_DownloadListener", 1, "onDownloadError, " + errorCode + ", " + errorMsg, new Exception());
        this.mDownloadInfo = info;
        this.download.p(false);
        this.download.t();
        this.download.i(d());
        this.download.l(false, errorCode, errorMsg);
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void onDownloadFinish(@NotNull DownloadInfo info) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) info);
            return;
        }
        Intrinsics.checkNotNullParameter(info, "info");
        if (!Intrinsics.areEqual("100686848", info.f341184e)) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("UpgradeController_DownloadListener", 2, "onDownloadFinish");
        }
        this.mDownloadInfo = info;
        this.download.p(false);
        this.download.b(info);
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void onDownloadPause(@NotNull DownloadInfo info) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) info);
            return;
        }
        Intrinsics.checkNotNullParameter(info, "info");
        if (!Intrinsics.areEqual("100686848", info.f341184e)) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("UpgradeController_DownloadListener", 2, "onDownloadPause");
        }
        this.mDownloadInfo = info;
        this.download.i(d());
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void onDownloadUpdate(@Nullable List<DownloadInfo> infos) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) infos);
            return;
        }
        if (infos == null) {
            return;
        }
        Iterator<T> it = infos.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual("100686848", ((DownloadInfo) obj).f341184e)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        DownloadInfo downloadInfo = (DownloadInfo) obj;
        if (downloadInfo == null) {
            return;
        }
        this.mDownloadInfo = downloadInfo;
        if (QLog.isColorLevel()) {
            DownloadInfo downloadInfo2 = this.mDownloadInfo;
            Intrinsics.checkNotNull(downloadInfo2);
            QLog.d("UpgradeController_DownloadListener", 2, "onDownloadUpdate, status: " + downloadInfo2.f());
        }
        this.download.i(d());
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void onDownloadWait(@NotNull DownloadInfo info) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) info);
            return;
        }
        Intrinsics.checkNotNullParameter(info, "info");
        if (!Intrinsics.areEqual("100686848", info.f341184e)) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("UpgradeController_DownloadListener", 2, "onDownloadWait");
        }
        this.mDownloadInfo = info;
        this.download.i(d());
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void packageReplaced(@Nullable String appid, @Nullable String packageName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) appid, (Object) packageName);
        }
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void uninstallSucceed(@Nullable String appid, @Nullable String packageName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) appid, (Object) packageName);
        }
    }
}
