package com.tencent.mobileqq.troop.widget.pag;

import bh3.DownloadTask;
import bh3.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.z1.download.ZPlanFileCategory;
import com.tencent.mobileqq.zplan.download.api.IFileDownloadHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001'B\t\b\u0002\u00a2\u0006\u0004\b%\u0010&J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0002J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fR \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0018R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001b\u0010$\u001a\u00020!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\"\u001a\u0004\b\u001e\u0010#\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/troop/widget/pag/TroopPAGLoader;", "", "", "url", "path", "", tl.h.F, "i", "d", "absFilePath", "k", "pagUrl", "", "isAutoDownload", "f", "Lvk3/a;", "listener", "c", "j", "", "b", "Ljava/util/Map;", "absFilePathMap", "", "I", "CATEGORY_PAG", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "pagDownloadListenerList", "Lbh3/f;", "e", "Lbh3/f;", "downloadListener", "Lcom/tencent/mobileqq/zplan/download/api/IFileDownloadHelper;", "Lkotlin/Lazy;", "()Lcom/tencent/mobileqq/zplan/download/api/IFileDownloadHelper;", "downloadHelper", "<init>", "()V", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopPAGLoader {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final TroopPAGLoader f302618a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, String> absFilePathMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final int CATEGORY_PAG;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CopyOnWriteArrayList<vk3.a> pagDownloadListenerList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final bh3.f downloadListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy downloadHelper;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/troop/widget/pag/TroopPAGLoader$a;", "", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public interface a {
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/troop/widget/pag/TroopPAGLoader$b", "Lbh3/e;", "Lbh3/d;", "task", "", "b", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements bh3.e {
        static IPatchRedirector $redirector_;

        b() {
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
                TroopPAGLoader.f302618a.h(task.getUrl(), task.getPath());
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62084);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        TroopPAGLoader troopPAGLoader = new TroopPAGLoader();
        f302618a = troopPAGLoader;
        absFilePathMap = new LinkedHashMap();
        CATEGORY_PAG = ZPlanFileCategory.PAG.getValue();
        pagDownloadListenerList = new CopyOnWriteArrayList<>();
        bh3.f a16 = bh3.e.INSTANCE.a(new b());
        downloadListener = a16;
        lazy = LazyKt__LazyJVMKt.lazy(TroopPAGLoader$downloadHelper$2.INSTANCE);
        downloadHelper = lazy;
        troopPAGLoader.e().addFileDownloadListener(a16);
    }

    TroopPAGLoader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String d(String url) {
        return com.tencent.mobileqq.troop.config.a.n(com.tencent.mobileqq.troop.config.a.f294689a, url, "", false, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IFileDownloadHelper e() {
        return (IFileDownloadHelper) downloadHelper.getValue();
    }

    public static /* synthetic */ String g(TroopPAGLoader troopPAGLoader, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        return troopPAGLoader.f(str, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(String url, String path) {
        QLog.i("TroopPAGLoader", 4, "onComplete :: url == " + url + ", filePath == " + path);
        Map<String, String> map = absFilePathMap;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("TROOP_PAG_");
        sb5.append(url);
        map.put(sb5.toString(), path);
        k("TROOP_PAG_" + url, path);
        i(url, path);
    }

    private final void i(String url, String path) {
        Iterator<T> it = pagDownloadListenerList.iterator();
        while (it.hasNext()) {
            ((vk3.a) it.next()).a(url, path);
        }
    }

    private final void k(String url, String absFilePath) {
        com.tencent.mobileqq.troop.config.a.z(com.tencent.mobileqq.troop.config.a.f294689a, url, absFilePath, false, 4, null);
    }

    public final void c(@NotNull vk3.a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            pagDownloadListenerList.add(listener);
        }
    }

    @Nullable
    public final String f(@NotNull final String pagUrl, boolean isAutoDownload) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, this, pagUrl, Boolean.valueOf(isAutoDownload));
        }
        Intrinsics.checkNotNullParameter(pagUrl, "pagUrl");
        String str = absFilePathMap.get("TROOP_PAG_" + pagUrl);
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            str = d("TROOP_PAG_" + pagUrl);
        }
        if (!isAutoDownload) {
            return str;
        }
        if (str.length() == 0) {
            z17 = true;
        }
        if (z17) {
            QLog.i("TroopPAGLoader", 4, "getPAGFileByUrl :: file not exist , url == " + pagUrl);
            e().download(ZPlanFileCategory.PAG, pagUrl);
            return null;
        }
        File file = new File(str);
        if (file.exists()) {
            QLog.i("TroopPAGLoader", 4, "getPAGFileByUrl :: file exist , absFilePath == " + str);
            return file.getAbsolutePath();
        }
        QLog.i("TroopPAGLoader", 4, "getPAGFileByUrl :: file not exist , maybe deleted by others , url == " + pagUrl);
        e().delete(ZPlanFileCategory.PAG, pagUrl, new Function0<Unit>(pagUrl) { // from class: com.tencent.mobileqq.troop.widget.pag.TroopPAGLoader$getPAGFilePath$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $pagUrl;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$pagUrl = pagUrl;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) pagUrl);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IFileDownloadHelper e16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                QLog.i("TroopPAGLoader", 4, "deleteTask & reDownload -> " + this.$pagUrl);
                e16 = TroopPAGLoader.f302618a.e();
                e16.download(ZPlanFileCategory.PAG, this.$pagUrl);
            }
        });
        return null;
    }

    public final void j(@NotNull vk3.a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            pagDownloadListenerList.remove(listener);
        }
    }
}
