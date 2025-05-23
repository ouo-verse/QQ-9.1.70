package com.tencent.mobileqq.troop.flame.widget;

import bh3.DownloadTask;
import bh3.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.z1.download.ZPlanFileCategory;
import com.tencent.mobileqq.zplan.download.api.IFileDownloadHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002R \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001b\u0010\u0013\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/troop/flame/widget/TroopFlameLottieDownLoader;", "", "", "url", "path", "", "g", "f", h.F, "c", "e", "", "b", "Ljava/util/Map;", "filePathMap", "Lcom/tencent/mobileqq/zplan/download/api/IFileDownloadHelper;", "Lkotlin/Lazy;", "d", "()Lcom/tencent/mobileqq/zplan/download/api/IFileDownloadHelper;", "downloadHelper", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopFlameLottieDownLoader {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final TroopFlameLottieDownLoader f296150a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, String> filePathMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy downloadHelper;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/troop/flame/widget/TroopFlameLottieDownLoader$a", "Lbh3/e;", "Lbh3/d;", "task", "", "b", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a implements e {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // bh3.a
        public void a(@NotNull DownloadTask downloadTask) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) downloadTask);
            } else {
                e.b.e(this, downloadTask);
            }
        }

        @Override // bh3.a
        public void b(@NotNull DownloadTask task) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) task);
            } else {
                Intrinsics.checkNotNullParameter(task, "task");
                TroopFlameLottieDownLoader.f296150a.g(task.getUrl(), task.getPath());
            }
        }

        @Override // bh3.a
        public void c(@NotNull DownloadTask downloadTask) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) downloadTask);
            } else {
                e.b.h(this, downloadTask);
            }
        }

        @Override // bh3.a
        public void d(@NotNull DownloadTask downloadTask) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) downloadTask);
            } else {
                e.b.g(this, downloadTask);
            }
        }

        @Override // bh3.e
        public boolean e(@NotNull DownloadTask downloadTask) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) downloadTask)).booleanValue();
            }
            return e.b.a(this, downloadTask);
        }

        @Override // bh3.a
        public void f(@NotNull DownloadTask downloadTask) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) downloadTask);
            } else {
                e.b.c(this, downloadTask);
            }
        }

        @Override // bh3.a
        public void g(@NotNull DownloadTask downloadTask, int i3, @Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, downloadTask, Integer.valueOf(i3), str);
            } else {
                e.b.d(this, downloadTask, i3, str);
            }
        }

        @Override // bh3.a
        public void h(@NotNull DownloadTask downloadTask) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) downloadTask);
            } else {
                e.b.f(this, downloadTask);
            }
        }
    }

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36833);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        TroopFlameLottieDownLoader troopFlameLottieDownLoader = new TroopFlameLottieDownLoader();
        f296150a = troopFlameLottieDownLoader;
        filePathMap = new LinkedHashMap();
        lazy = LazyKt__LazyJVMKt.lazy(TroopFlameLottieDownLoader$downloadHelper$2.INSTANCE);
        downloadHelper = lazy;
        troopFlameLottieDownLoader.d().addFileDownloadListener(e.INSTANCE.a(new a()));
    }

    TroopFlameLottieDownLoader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IFileDownloadHelper d() {
        return (IFileDownloadHelper) downloadHelper.getValue();
    }

    private final String f(String url) {
        return com.tencent.mobileqq.troop.config.a.n(com.tencent.mobileqq.troop.config.a.f294689a, h(url), "", false, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(String url, String path) {
        QLog.i("TroopFlameLottieDownLoader", 1, "[handleDownloadSuccess] onComplete url == " + url + ", filePath == " + path);
        filePathMap.put(h(url), path);
        com.tencent.mobileqq.troop.config.a.z(com.tencent.mobileqq.troop.config.a.f294689a, h(url), path, false, 4, null);
    }

    private final String h(String url) {
        return "TROOP_LOTTIE_" + url;
    }

    public final void c(@NotNull final String url) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) url);
            return;
        }
        Intrinsics.checkNotNullParameter(url, "url");
        String str = filePathMap.get(h(url));
        boolean z17 = false;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            str = f(h(url));
        }
        if (str.length() == 0) {
            z17 = true;
        }
        if (z17) {
            QLog.i("TroopFlameLottieDownLoader", 1, "[downloadAndCachePath] file not exist , url == " + url);
            d().download(ZPlanFileCategory.PAG, url);
            return;
        }
        if (!new File(str).exists()) {
            QLog.i("TroopFlameLottieDownLoader", 1, "[downloadAndCachePath] file not exist , maybe deleted by others , url == " + url);
            d().delete(ZPlanFileCategory.PAG, url, new Function0<Unit>(url) { // from class: com.tencent.mobileqq.troop.flame.widget.TroopFlameLottieDownLoader$downloadAndCachePath$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ String $url;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$url = url;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) url);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IFileDownloadHelper d16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    QLog.i("TroopFlameLottieDownLoader", 1, "[downloadAndCachePath] deleteTask & reDownload -> " + this.$url);
                    d16 = TroopFlameLottieDownLoader.f296150a.d();
                    d16.download(ZPlanFileCategory.PAG, this.$url);
                }
            });
        }
    }

    @NotNull
    public final String e(@NotNull String url) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) url);
        }
        Intrinsics.checkNotNullParameter(url, "url");
        String h16 = h(url);
        Map<String, String> map = filePathMap;
        String str = map.get(h16);
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            map.put(h16, f(url));
        }
        String str2 = map.get(h16);
        if (str2 == null) {
            return "";
        }
        return str2;
    }
}
