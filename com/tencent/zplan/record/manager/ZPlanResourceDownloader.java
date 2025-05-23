package com.tencent.zplan.record.manager;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.zplan.common.utils.LogUtil;
import com.tencent.zplan.common.utils.c;
import com.tencent.zplan.meme.Constant;
import com.tencent.zplan.record.model.ZPlanRecordResource;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
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
import kotlin.text.StringsKt__StringsKt;
import lx4.d;
import nx4.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\b\u00c0\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002J\f\u0010\t\u001a\u00020\u0002*\u00020\u0002H\u0002J\f\u0010\n\u001a\u00020\u0002*\u00020\u0002H\u0002J\u001d\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000eR&\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0019\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/zplan/record/manager/ZPlanResourceDownloader;", "", "", "url", "", "success", "remoteUrl", "", "e", "g", "d", "Lcom/tencent/zplan/record/model/ZPlanRecordResource;", "resource", "b", "(Lcom/tencent/zplan/record/model/ZPlanRecordResource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "", "Lcom/tencent/zplan/record/manager/ZPlanResourceDownloader$a;", "a", "Ljava/util/Map;", "downloadingMap", "", "Lkotlin/Lazy;", "c", "()I", "downloadTimeout", "<init>", "()V", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class ZPlanResourceDownloader {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Lazy downloadTimeout;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final ZPlanResourceDownloader f386006c = new ZPlanResourceDownloader();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, List<a>> downloadingMap = new LinkedHashMap();

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\u0017\u0012\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b\u00a2\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0096\u0002R\u001c\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/zplan/record/manager/ZPlanResourceDownloader$a;", "Lkotlin/Function2;", "", "", "", "success", "remoteUrl", "a", "Lkotlin/coroutines/Continuation;", "d", "Lkotlin/coroutines/Continuation;", "continuation", "<init>", "(Lkotlin/coroutines/Continuation;)V", "record_debug"}, k = 1, mv = {1, 4, 2})
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

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J$\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/zplan/record/manager/ZPlanResourceDownloader$b", "Lnx4/a;", "", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "", "errorMsg", "", "onDownloadFailed", "filePath", "Lnx4/a$b;", "result", "a", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class b implements nx4.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f386008a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f386009b;

        b(String str, AtomicBoolean atomicBoolean) {
            this.f386008a = str;
            this.f386009b = atomicBoolean;
        }

        @Override // nx4.a
        public void a(int statusCode, @Nullable String filePath, @Nullable a.b result) {
            boolean h16 = c.f385288a.h(filePath);
            d a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                d.a.c(a16, "[ZPlanRRC]ZPlanResourceDownloader", 1, "download success, remoteUrl:" + this.f386008a + ", fileExist:" + h16 + ", filePath:" + filePath + ", hasResume:" + this.f386009b.get(), null, 8, null);
            }
            if (this.f386009b.get()) {
                return;
            }
            this.f386009b.set(true);
            ZPlanResourceDownloader.f386006c.e(this.f386008a, h16, filePath);
        }

        @Override // nx4.a
        public void onDownloadFailed(int statusCode, @Nullable String errorMsg) {
            d a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                d.a.d(a16, "[ZPlanRRC]ZPlanResourceDownloader", 1, "download fail, remoteUrl:" + this.f386008a + ", statusCode:" + statusCode + ", errorMessage:" + errorMsg + ", hasResume:" + this.f386009b.get(), null, 8, null);
            }
            if (this.f386009b.get()) {
                return;
            }
            this.f386009b.set(true);
            ZPlanResourceDownloader.f(ZPlanResourceDownloader.f386006c, this.f386008a, false, null, 4, null);
        }

        @Override // nx4.a
        public void onDownloadProgress(float f16, long j3, long j16) {
            a.C10870a.a(this, f16, j3, j16);
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.zplan.record.manager.ZPlanResourceDownloader$downloadTimeout$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                Object a16 = mx4.a.f417748a.a(yx4.c.class);
                Intrinsics.checkNotNull(a16);
                int b16 = ((yx4.c) a16).b();
                d a17 = LogUtil.f385285b.a();
                if (a17 != null) {
                    d.a.c(a17, "[ZPlanRRC]ZPlanResourceDownloader", 1, "downloadTimeout:" + b16, null, 8, null);
                }
                return b16;
            }
        });
        downloadTimeout = lazy;
    }

    ZPlanResourceDownloader() {
    }

    private final int c() {
        return ((Number) downloadTimeout.getValue()).intValue();
    }

    private final String d(String str) {
        int indexOf$default;
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, 0, false, 6, (Object) null);
        if (indexOf$default != -1) {
            if (str != null) {
                String substring = str.substring(0, indexOf$default);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                return substring;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(String url, boolean success, String remoteUrl) {
        List<a> remove;
        boolean z16;
        Map<String, List<a>> map = downloadingMap;
        synchronized (map) {
            remove = map.remove(url);
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

    static /* synthetic */ void f(ZPlanResourceDownloader zPlanResourceDownloader, String str, boolean z16, String str2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str2 = null;
        }
        zPlanResourceDownloader.e(str, z16, str2);
    }

    private final String g(String str) {
        int lastIndexOf$default;
        String c16;
        lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) str, "/", 0, false, 6, (Object) null);
        if (lastIndexOf$default > 0) {
            int i3 = lastIndexOf$default + 1;
            if (str != null) {
                c16 = str.substring(i3);
                Intrinsics.checkNotNullExpressionValue(c16, "(this as java.lang.String).substring(startIndex)");
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
        } else {
            c16 = com.tencent.zplan.common.utils.d.c(str);
        }
        return Constant.f385743c.b() + '/' + c16;
    }

    @Nullable
    public final Object b(@NotNull ZPlanRecordResource zPlanRecordResource, @NotNull Continuation<? super String> continuation) {
        Continuation intercepted;
        List<a> mutableListOf;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        ZPlanRecordResource f16 = ZPlanRecordResource.f(zPlanRecordResource, null, null, null, 0L, 0, 0, null, 127, null);
        if (f16.o()) {
            safeContinuation.resumeWith(Result.m476constructorimpl(f16.getLocalPath()));
        } else if (!f16.p()) {
            safeContinuation.resumeWith(Result.m476constructorimpl(null));
        } else {
            String remoteUrl = f16.getRemoteUrl();
            Intrinsics.checkNotNull(remoteUrl);
            a aVar = new a(safeContinuation);
            Map<String, List<a>> map = downloadingMap;
            synchronized (map) {
                List<a> list = map.get(remoteUrl);
                if (list == null) {
                    mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(aVar);
                    map.put(remoteUrl, mutableListOf);
                    Unit unit = Unit.INSTANCE;
                    lx4.c cVar = (lx4.c) mx4.a.f417748a.a(lx4.c.class);
                    if (cVar == null) {
                        f(f386006c, remoteUrl, false, null, 4, null);
                    } else {
                        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                        ZPlanResourceDownloader zPlanResourceDownloader = f386006c;
                        cVar.a(remoteUrl, zPlanResourceDownloader.g(zPlanResourceDownloader.d(remoteUrl)), null, true, zPlanResourceDownloader.c(), new b(remoteUrl, atomicBoolean));
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
}
