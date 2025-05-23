package com.tencent.mobileqq.opr.utils;

import android.annotation.SuppressLint;
import com.tencent.mobileqq.opr.utils.log.OprLogger;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qne.delegate.d;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00132\u00020\u0001:\u0001\u000bB\u0017\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0003J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0013\u0010\b\u001a\u00020\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/opr/utils/SoLoader;", "", "", "path", "", "g", "f", "Lcom/tencent/qne/util/d;", "e", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/qne/delegate/d;", "a", "Lcom/tencent/qne/delegate/d;", "shiply", "b", "Ljava/lang/String;", "unzipPath", "<init>", "(Lcom/tencent/qne/delegate/d;Ljava/lang/String;)V", "c", "opr_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class SoLoader {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d shiply;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String unzipPath;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/opr/utils/SoLoader$a;", "", "", "OPR_SHIPLY_RESOURCE_ID", "Ljava/lang/String;", "", "OPR_SHIPLY_RESOURCE_SPECIFIC_TASK_ID", "J", "TAG", "<init>", "()V", "opr_debug"}, k = 1, mv = {1, 5, 1})
    /* renamed from: com.tencent.mobileqq.opr.utils.SoLoader$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10869);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public SoLoader(@NotNull d shiply, @NotNull String unzipPath) {
        Intrinsics.checkNotNullParameter(shiply, "shiply");
        Intrinsics.checkNotNullParameter(unzipPath, "unzipPath");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) shiply, (Object) unzipPath);
        } else {
            this.shiply = shiply;
            this.unzipPath = unzipPath;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean f() {
        try {
            System.loadLibrary("opencv");
            System.loadLibrary("opr");
            return true;
        } catch (Throwable th5) {
            OprLogger.e("[opr]SoLoader", "loadInternalSo exception", th5);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    public final boolean g(String path) {
        List listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"libopencv.so", "libopr.so"});
        Iterator it = listOf.iterator();
        while (true) {
            boolean z16 = true;
            if (!it.hasNext()) {
                return true;
            }
            String str = (String) it.next();
            String e16 = com.tencent.qne.util.a.e(path, str);
            if (e16 != null && e16.length() != 0) {
                z16 = false;
            }
            if (z16) {
                OprLogger.e("[opr]SoLoader", "load so not found, name: " + str + ", path:" + ((Object) e16));
                return false;
            }
            try {
                System.load(e16);
                OprLogger.i("[opr]SoLoader", Intrinsics.stringPlus("load so success, soPath:", e16));
            } catch (Throwable th5) {
                OprLogger.e("[opr]SoLoader", Intrinsics.stringPlus("load so failed, soPath:", e16), th5);
                return false;
            }
        }
    }

    @Nullable
    public final Object e(@NotNull Continuation<? super com.tencent.qne.util.d> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, (Object) continuation);
        }
        return BuildersKt.withContext(Dispatchers.getIO(), new SoLoader$load$2(this, null), continuation);
    }
}
