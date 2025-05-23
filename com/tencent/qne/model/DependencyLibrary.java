package com.tencent.qne.model;

import androidx.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qne.util.ShiplySoDownloader;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Keep
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B+\b\u0002\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b\u001c\u0010\u001dJ#\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001f\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006("}, d2 = {"Lcom/tencent/qne/model/DependencyLibrary;", "", "Lcom/tencent/qne/delegate/d;", "shiply", "", "unzipPath", "Lcom/tencent/qne/util/c;", "prepare", "(Lcom/tencent/qne/delegate/d;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shiplyResourceId", "Ljava/lang/String;", "getShiplyResourceId", "()Ljava/lang/String;", "", "specificTaskId", "J", "getSpecificTaskId", "()J", "", "preloadList", "Ljava/util/List;", "getPreloadList", "()Ljava/util/List;", "prepareResult", "Lcom/tencent/qne/util/c;", "Ljava/util/concurrent/locks/ReentrantLock;", JoinPoint.SYNCHRONIZATION_LOCK, "Ljava/util/concurrent/locks/ReentrantLock;", "<init>", "(Ljava/lang/String;ILjava/lang/String;JLjava/util/List;)V", "QNE_CORE", "SNPE_COMMON", "SNPE_HTP_V68", "SNPE_HTP_V69", "SNPE_HTP_V73", "SNPE_HTP_V75", "SNPE_HTP_V79", "KIRIN_COMMON", "DIMENSITY_TFLITE", "NCNN_COMMON", "qne_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes22.dex */
public final class DependencyLibrary {
    private static final /* synthetic */ DependencyLibrary[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final DependencyLibrary DIMENSITY_TFLITE;
    public static final DependencyLibrary KIRIN_COMMON;
    public static final DependencyLibrary NCNN_COMMON;
    public static final DependencyLibrary QNE_CORE;
    public static final DependencyLibrary SNPE_COMMON;
    public static final DependencyLibrary SNPE_HTP_V68;
    public static final DependencyLibrary SNPE_HTP_V69;
    public static final DependencyLibrary SNPE_HTP_V73;
    public static final DependencyLibrary SNPE_HTP_V75;
    public static final DependencyLibrary SNPE_HTP_V79;

    @NotNull
    private final ReentrantLock lock;

    @Nullable
    private final List<String> preloadList;

    @Nullable
    private com.tencent.qne.util.c prepareResult;

    @NotNull
    private final String shiplyResourceId;
    private final long specificTaskId;

    private static final /* synthetic */ DependencyLibrary[] $values() {
        return new DependencyLibrary[]{QNE_CORE, SNPE_COMMON, SNPE_HTP_V68, SNPE_HTP_V69, SNPE_HTP_V73, SNPE_HTP_V75, SNPE_HTP_V79, KIRIN_COMMON, DIMENSITY_TFLITE, NCNN_COMMON};
    }

    static {
        List listOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14792);
        $redirector_ = redirector;
        if (redirector == null || !redirector.hasPatch((short) 7)) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf("libqqneuroedge.so");
            QNE_CORE = new DependencyLibrary("QNE_CORE", 0, "qne_core_libs_arm64", 2369818L, listOf);
            List list = null;
            int i3 = 4;
            DefaultConstructorMarker defaultConstructorMarker = null;
            SNPE_COMMON = new DependencyLibrary("SNPE_COMMON", 1, "qne_snpe_common_libs_arm64", 2331689L, list, i3, defaultConstructorMarker);
            List list2 = null;
            int i16 = 4;
            DefaultConstructorMarker defaultConstructorMarker2 = null;
            SNPE_HTP_V68 = new DependencyLibrary("SNPE_HTP_V68", 2, "qne_snpe_htp_v68_libs_arm64", 0L, list2, i16, defaultConstructorMarker2);
            SNPE_HTP_V69 = new DependencyLibrary("SNPE_HTP_V69", 3, "qne_snpe_htp_v69_libs_arm64", 2213532L, list, i3, defaultConstructorMarker);
            SNPE_HTP_V73 = new DependencyLibrary("SNPE_HTP_V73", 4, "qne_snpe_htp_v73_libs_arm64", 2213388L, list2, i16, defaultConstructorMarker2);
            SNPE_HTP_V75 = new DependencyLibrary("SNPE_HTP_V75", 5, "qne_snpe_htp_v75_libs_arm64", 2213538L, list, i3, defaultConstructorMarker);
            SNPE_HTP_V79 = new DependencyLibrary("SNPE_HTP_V79", 6, "qne_snpe_htp_v79_libs_arm64", 2170054L, list2, i16, defaultConstructorMarker2);
            KIRIN_COMMON = new DependencyLibrary("KIRIN_COMMON", 7, "qne_kirin_common_libs_arm64", 2203268L, list, i3, defaultConstructorMarker);
            DIMENSITY_TFLITE = new DependencyLibrary("DIMENSITY_TFLITE", 8, "qne_neuro_pilot_common_libs_arm64", 2368993L, list2, i16, defaultConstructorMarker2);
            NCNN_COMMON = new DependencyLibrary("NCNN_COMMON", 9, "qne_ncnn_common_libs_arm64", 2356901L, list, i3, defaultConstructorMarker);
            $VALUES = $values();
            return;
        }
        redirector.redirect((short) 7);
    }

    DependencyLibrary(String str, int i3, String str2, long j3, List list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), str2, Long.valueOf(j3), list);
            return;
        }
        this.shiplyResourceId = str2;
        this.specificTaskId = j3;
        this.preloadList = list;
        this.lock = new ReentrantLock();
    }

    public static DependencyLibrary valueOf(String str) {
        return (DependencyLibrary) Enum.valueOf(DependencyLibrary.class, str);
    }

    public static DependencyLibrary[] values() {
        return (DependencyLibrary[]) $VALUES.clone();
    }

    @Nullable
    public final List<String> getPreloadList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.preloadList;
    }

    @NotNull
    public final String getShiplyResourceId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.shiplyResourceId;
    }

    public final long getSpecificTaskId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return this.specificTaskId;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004b  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object prepare(@NotNull com.tencent.qne.delegate.d dVar, @NotNull String str, @NotNull Continuation<? super com.tencent.qne.util.c> continuation) {
        DependencyLibrary$prepare$1 dependencyLibrary$prepare$1;
        Object coroutine_suspended;
        int i3;
        boolean z16;
        DependencyLibrary dependencyLibrary;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return iPatchRedirector.redirect((short) 6, this, dVar, str, continuation);
        }
        if (continuation instanceof DependencyLibrary$prepare$1) {
            dependencyLibrary$prepare$1 = (DependencyLibrary$prepare$1) continuation;
            int i16 = dependencyLibrary$prepare$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                dependencyLibrary$prepare$1.label = i16 - Integer.MIN_VALUE;
                Object obj = dependencyLibrary$prepare$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = dependencyLibrary$prepare$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        dependencyLibrary = (DependencyLibrary) dependencyLibrary$prepare$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    ReentrantLock reentrantLock = this.lock;
                    reentrantLock.lock();
                    try {
                        com.tencent.qne.util.c cVar = this.prepareResult;
                        if (cVar != null && cVar.b()) {
                            z16 = false;
                        } else {
                            z16 = true;
                        }
                        ShiplySoDownloader shiplySoDownloader = new ShiplySoDownloader(dVar, getShiplyResourceId(), Boxing.boxLong(getSpecificTaskId()), str);
                        dependencyLibrary$prepare$1.L$0 = this;
                        dependencyLibrary$prepare$1.label = 1;
                        obj = shiplySoDownloader.c(z16, dependencyLibrary$prepare$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        dependencyLibrary = this;
                    } finally {
                        reentrantLock.unlock();
                    }
                }
                dependencyLibrary.prepareResult = (com.tencent.qne.util.c) obj;
                return obj;
            }
        }
        dependencyLibrary$prepare$1 = new DependencyLibrary$prepare$1(this, continuation);
        Object obj2 = dependencyLibrary$prepare$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = dependencyLibrary$prepare$1.label;
        if (i3 == 0) {
        }
        dependencyLibrary.prepareResult = (com.tencent.qne.util.c) obj2;
        return obj2;
    }

    /* synthetic */ DependencyLibrary(String str, int i3, String str2, long j3, List list, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, str2, j3, (i16 & 4) != 0 ? null : list);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), str2, Long.valueOf(j3), list, Integer.valueOf(i16), defaultConstructorMarker);
    }
}
