package com.tencent.qne.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qne.model.DependencyLibrary;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0006\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\fB%\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0013\u0010\t\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qne/util/SoLoader;", "", "Lcom/tencent/qne/model/DependencyLibrary;", "dependency", "", QzoneZipCacheHelper.DIR, "", "f", "Lcom/tencent/qne/util/d;", "e", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/qne/delegate/d;", "a", "Lcom/tencent/qne/delegate/d;", "shiply", "b", "Ljava/lang/String;", "unzipPath", "", "c", "Ljava/util/List;", "<init>", "(Lcom/tencent/qne/delegate/d;Ljava/lang/String;Ljava/util/List;)V", "d", "qne_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes22.dex */
public final class SoLoader {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final a f344367d;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qne.delegate.d shiply;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String unzipPath;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<DependencyLibrary> dependency;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qne/util/SoLoader$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qne_debug"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes22.dex */
    private static final class a {
        static IPatchRedirector $redirector_;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15497);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f344367d = new a(null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SoLoader(@NotNull com.tencent.qne.delegate.d shiply, @NotNull String unzipPath, @NotNull List<? extends DependencyLibrary> dependency) {
        Intrinsics.checkNotNullParameter(shiply, "shiply");
        Intrinsics.checkNotNullParameter(unzipPath, "unzipPath");
        Intrinsics.checkNotNullParameter(dependency, "dependency");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, shiply, unzipPath, dependency);
            return;
        }
        this.shiply = shiply;
        this.unzipPath = unzipPath;
        this.dependency = dependency;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean f(DependencyLibrary dependency, String dir) {
        boolean z16;
        List<String> preloadList = dependency.getPreloadList();
        if (preloadList != null) {
            for (String str : preloadList) {
                String e16 = com.tencent.qne.util.a.e(dir, str);
                if (e16 != null && e16.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    Logger.e("[qne]SoLoader", "load so not found, soName:" + str + ", soPath:" + ((Object) e16) + ", dir:" + dir);
                    return false;
                }
                try {
                    System.load(e16);
                    Logger.i("[qne]SoLoader", Intrinsics.stringPlus("load so success, soPath:", e16));
                } catch (Throwable th5) {
                    Logger.e("[qne]SoLoader", Intrinsics.stringPlus("load so failed, soPath:", e16), th5);
                    return false;
                }
            }
        }
        return true;
    }

    @Nullable
    public final Object e(@NotNull Continuation<? super d> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, (Object) continuation);
        }
        return BuildersKt.withContext(Dispatchers.getIO(), new SoLoader$load$2(this, null), continuation);
    }
}
