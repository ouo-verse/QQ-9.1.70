package com.tencent.zplan.record.manager;

import com.tencent.zplan.common.model.UploadConfig;
import com.tencent.zplan.common.utils.LogUtil;
import com.tencent.zplan.record.model.ZPlanRecordResource;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import lx4.d;
import lx4.g;
import mx4.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yx4.c;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002J-\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ/\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u000fR\u001b\u0010\u0016\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R&\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/zplan/record/manager/ZPlanResourceUploader;", "", "", "localPath", "", "success", "remoteUrl", "", "c", "Lcom/tencent/zplan/record/model/ZPlanRecordResource;", "resource", "uuid", "Lcom/tencent/zplan/common/model/UploadConfig$UploadTarget;", "uploadTarget", "f", "(Lcom/tencent/zplan/record/model/ZPlanRecordResource;Ljava/lang/String;Lcom/tencent/zplan/common/model/UploadConfig$UploadTarget;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "e", "", "a", "Lkotlin/Lazy;", "b", "()I", "retryCount", "", "", "Lcom/tencent/zplan/record/manager/ZPlanResourceUploader$a;", "Ljava/util/Map;", "uploadingMap", "<init>", "()V", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class ZPlanResourceUploader {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Lazy retryCount;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, List<a>> uploadingMap;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final ZPlanResourceUploader f386016c = new ZPlanResourceUploader();

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\u0017\u0012\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b\u00a2\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0096\u0002R\u001c\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/zplan/record/manager/ZPlanResourceUploader$a;", "Lkotlin/Function2;", "", "", "", "success", "remoteUrl", "a", "Lkotlin/coroutines/Continuation;", "d", "Lkotlin/coroutines/Continuation;", "continuation", "<init>", "(Lkotlin/coroutines/Continuation;)V", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class a implements Function2<Boolean, String, Unit> {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final Continuation<String> continuation;

        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull Continuation<? super String> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "continuation");
            this.continuation = continuation;
        }

        public void a(boolean success, @Nullable String remoteUrl) {
            Continuation<String> continuation = this.continuation;
            if (!success) {
                remoteUrl = null;
            }
            continuation.resumeWith(Result.m476constructorimpl(remoteUrl));
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str) {
            a(bool.booleanValue(), str);
            return Unit.INSTANCE;
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.zplan.record.manager.ZPlanResourceUploader$retryCount$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                Object a16 = a.f417748a.a(c.class);
                Intrinsics.checkNotNull(a16);
                return ((c) a16).g();
            }
        });
        retryCount = lazy;
        uploadingMap = new LinkedHashMap();
    }

    ZPlanResourceUploader() {
    }

    private final int b() {
        return ((Number) retryCount.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(String localPath, boolean success, String remoteUrl) {
        List<a> remove;
        boolean z16;
        Map<String, List<a>> map = uploadingMap;
        synchronized (map) {
            remove = map.remove(localPath);
        }
        List<a> list = remove;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        Iterator<T> it = remove.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(success, remoteUrl);
        }
    }

    static /* synthetic */ void d(ZPlanResourceUploader zPlanResourceUploader, String str, boolean z16, String str2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str2 = null;
        }
        zPlanResourceUploader.c(str, z16, str2);
    }

    @Nullable
    public final Object e(@NotNull final ZPlanRecordResource zPlanRecordResource, @NotNull final String str, @NotNull final UploadConfig.UploadTarget uploadTarget, @NotNull Continuation<? super String> continuation) {
        Continuation intercepted;
        List<a> mutableListOf;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        ZPlanRecordResource f16 = ZPlanRecordResource.f(zPlanRecordResource, null, null, null, 0L, 0, 0, null, 127, null);
        if (f16.p()) {
            safeContinuation.resumeWith(Result.m476constructorimpl(f16.getRemoteUrl()));
        } else if (!f16.o()) {
            safeContinuation.resumeWith(Result.m476constructorimpl(null));
        } else {
            final String localPath = f16.getLocalPath();
            Intrinsics.checkNotNull(localPath);
            a aVar = new a(safeContinuation);
            Map<String, List<a>> map = uploadingMap;
            synchronized (map) {
                List<a> list = map.get(localPath);
                if (list == null) {
                    mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(aVar);
                    map.put(localPath, mutableListOf);
                    Unit unit = Unit.INSTANCE;
                    g gVar = (g) mx4.a.f417748a.a(g.class);
                    if (gVar == null) {
                        d(f386016c, localPath, false, null, 4, null);
                    } else {
                        d a16 = LogUtil.f385285b.a();
                        if (a16 != null) {
                            d.a.c(a16, "[ZPlanRRC]ZPlanResourceUploader", 1, "upload localPath:" + localPath + ", uuid:" + str + ", uploadTarget:" + uploadTarget, null, 8, null);
                        }
                        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                        gVar.a(localPath, str, uploadTarget, new Function2<Boolean, String, Unit>() { // from class: com.tencent.zplan.record.manager.ZPlanResourceUploader$upload$$inlined$suspendCoroutine$lambda$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str2) {
                                invoke(bool.booleanValue(), str2);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(boolean z16, @Nullable String str2) {
                                if (atomicBoolean.get()) {
                                    return;
                                }
                                atomicBoolean.set(true);
                                d a17 = LogUtil.f385285b.a();
                                if (a17 != null) {
                                    d.a.c(a17, "[ZPlanRRC]ZPlanResourceUploader", 1, "upload success:" + z16 + ", localPath:" + localPath + ", uuid:" + str + ", uploadTarget:" + uploadTarget + ", remoteUrl:" + str2, null, 8, null);
                                }
                                ZPlanResourceUploader.f386016c.c(localPath, z16, str2);
                            }
                        });
                    }
                } else {
                    list.add(aVar);
                }
            }
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0088 -> B:10:0x008e). Please report as a decompilation issue!!! */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object f(@NotNull ZPlanRecordResource zPlanRecordResource, @NotNull String str, @NotNull UploadConfig.UploadTarget uploadTarget, @NotNull Continuation<? super String> continuation) {
        ZPlanResourceUploader$uploadWithRetry$1 zPlanResourceUploader$uploadWithRetry$1;
        ZPlanResourceUploader zPlanResourceUploader;
        Object coroutine_suspended;
        int i3;
        String str2;
        ZPlanResourceUploader$uploadWithRetry$1 zPlanResourceUploader$uploadWithRetry$12;
        ZPlanResourceUploader zPlanResourceUploader2;
        Object obj;
        int i16;
        ZPlanRecordResource zPlanRecordResource2;
        String str3;
        UploadConfig.UploadTarget uploadTarget2;
        boolean z16;
        if (continuation instanceof ZPlanResourceUploader$uploadWithRetry$1) {
            zPlanResourceUploader$uploadWithRetry$1 = (ZPlanResourceUploader$uploadWithRetry$1) continuation;
            int i17 = zPlanResourceUploader$uploadWithRetry$1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                zPlanResourceUploader$uploadWithRetry$1.label = i17 - Integer.MIN_VALUE;
                zPlanResourceUploader = this;
                Object obj2 = zPlanResourceUploader$uploadWithRetry$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = zPlanResourceUploader$uploadWithRetry$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        int i18 = zPlanResourceUploader$uploadWithRetry$1.I$0;
                        UploadConfig.UploadTarget uploadTarget3 = (UploadConfig.UploadTarget) zPlanResourceUploader$uploadWithRetry$1.L$3;
                        String str4 = (String) zPlanResourceUploader$uploadWithRetry$1.L$2;
                        ZPlanRecordResource zPlanRecordResource3 = (ZPlanRecordResource) zPlanResourceUploader$uploadWithRetry$1.L$1;
                        zPlanResourceUploader2 = (ZPlanResourceUploader) zPlanResourceUploader$uploadWithRetry$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        zPlanResourceUploader$uploadWithRetry$12 = zPlanResourceUploader$uploadWithRetry$1;
                        str3 = str4;
                        obj = coroutine_suspended;
                        uploadTarget2 = uploadTarget3;
                        String str5 = (String) obj2;
                        d a16 = LogUtil.f385285b.a();
                        if (a16 != null) {
                            d.a.c(a16, "[ZPlanRRC]ZPlanResourceUploader", 1, "doUploadWithRetry, remoteUrl:" + str5 + ", tryCount: " + i18 + ", resource:" + zPlanRecordResource3, null, 8, null);
                        }
                        int i19 = i18 + 1;
                        str2 = str5;
                        zPlanRecordResource2 = zPlanRecordResource3;
                        i16 = i19;
                        if (i16 < zPlanResourceUploader2.b()) {
                            if (str2 != null && str2.length() != 0) {
                                z16 = false;
                            } else {
                                z16 = true;
                            }
                            if (z16) {
                                zPlanResourceUploader$uploadWithRetry$12.L$0 = zPlanResourceUploader2;
                                zPlanResourceUploader$uploadWithRetry$12.L$1 = zPlanRecordResource2;
                                zPlanResourceUploader$uploadWithRetry$12.L$2 = str3;
                                zPlanResourceUploader$uploadWithRetry$12.L$3 = uploadTarget2;
                                zPlanResourceUploader$uploadWithRetry$12.I$0 = i16;
                                zPlanResourceUploader$uploadWithRetry$12.label = 1;
                                Object e16 = zPlanResourceUploader2.e(zPlanRecordResource2, str3, uploadTarget2, zPlanResourceUploader$uploadWithRetry$12);
                                if (e16 == obj) {
                                    return obj;
                                }
                                int i26 = i16;
                                zPlanRecordResource3 = zPlanRecordResource2;
                                obj2 = e16;
                                i18 = i26;
                                String str52 = (String) obj2;
                                d a162 = LogUtil.f385285b.a();
                                if (a162 != null) {
                                }
                                int i192 = i18 + 1;
                                str2 = str52;
                                zPlanRecordResource2 = zPlanRecordResource3;
                                i16 = i192;
                                if (i16 < zPlanResourceUploader2.b()) {
                                }
                            }
                        }
                        return str2;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj2);
                str2 = null;
                zPlanResourceUploader$uploadWithRetry$12 = zPlanResourceUploader$uploadWithRetry$1;
                zPlanResourceUploader2 = zPlanResourceUploader;
                obj = coroutine_suspended;
                i16 = 0;
                zPlanRecordResource2 = zPlanRecordResource;
                str3 = str;
                uploadTarget2 = uploadTarget;
                if (i16 < zPlanResourceUploader2.b()) {
                }
                return str2;
            }
        }
        zPlanResourceUploader = this;
        zPlanResourceUploader$uploadWithRetry$1 = new ZPlanResourceUploader$uploadWithRetry$1(zPlanResourceUploader, continuation);
        Object obj22 = zPlanResourceUploader$uploadWithRetry$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = zPlanResourceUploader$uploadWithRetry$1.label;
        if (i3 == 0) {
        }
    }
}
