package com.tencent.filament.zplan.scene.square;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.zplan.zplantracing.ZPlanSpanFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.scene.square.SquareMapResourceHelper$startDownloadJob$1", f = "SquareMapResourceHelper.kt", i = {}, l = {101}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class SquareMapResourceHelper$startDownloadJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $savePath;
    final /* synthetic */ String $url;
    final /* synthetic */ com.tencent.zplan.zplantracing.c $zplanSpanContext;
    Object L$0;
    int label;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J6\u0010\f\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\n\u0018\u00010\tH\u0016\u00a8\u0006\r\u00b8\u0006\u0000"}, d2 = {"com/tencent/filament/zplan/scene/square/SquareMapResourceHelper$startDownloadJob$1$1$2", "Lgl0/a;", "", "errorMsg", "", "b", "filePath", "", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "", "", "rspHeader", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class a implements gl0.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.zplan.zplantracing.b f106089a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f106090b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ SquareMapResourceHelper$startDownloadJob$1 f106091c;

        a(com.tencent.zplan.zplantracing.b bVar, String str, SquareMapResourceHelper$startDownloadJob$1 squareMapResourceHelper$startDownloadJob$1) {
            this.f106089a = bVar;
            this.f106090b = str;
            this.f106091c = squareMapResourceHelper$startDownloadJob$1;
        }

        @Override // gl0.a
        public void a(@Nullable String filePath, int statusCode, @Nullable Map<String, ? extends List<String>> rspHeader) {
            File parentFile;
            FLog fLog = FLog.INSTANCE;
            fLog.i("SquareMapResourceHelper", "download end. url: " + this.f106091c.$url);
            com.tencent.zplan.zplantracing.b bVar = this.f106089a;
            if (bVar != null) {
                bVar.b();
            }
            if (filePath == null) {
                fLog.e("SquareMapResourceHelper", "download fail. filePath is null, url: " + this.f106091c.$url);
                SquareMapResourceHelper.f106088j.j(this.f106090b, 301001, "filePath is null");
                return;
            }
            File file = new File(this.f106091c.$savePath);
            File parentFile2 = file.getParentFile();
            if ((parentFile2 == null || !parentFile2.exists()) && (parentFile = file.getParentFile()) != null) {
                parentFile.mkdirs();
            }
            if (com.tencent.filament.zplanservice.util.b.a(new File(filePath), file)) {
                SquareMapResourceHelper.f106088j.k(this.f106090b);
                return;
            }
            fLog.e("SquareMapResourceHelper", "copy file fail. url: " + this.f106091c.$url + ", savePath: " + this.f106091c.$savePath);
            SquareMapResourceHelper.f106088j.j(this.f106090b, 301001, "copy file fail");
        }

        @Override // gl0.a
        public void b(@NotNull String errorMsg) {
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            FLog.INSTANCE.e("SquareMapResourceHelper", "download fail. errorMsg: " + errorMsg + ", url: " + this.f106091c.$url);
            com.tencent.zplan.zplantracing.b bVar = this.f106089a;
            if (bVar != null) {
                bVar.a(errorMsg);
            }
            SquareMapResourceHelper.f106088j.j(this.f106090b, 301001, errorMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareMapResourceHelper$startDownloadJob$1(String str, String str2, com.tencent.zplan.zplantracing.c cVar, Continuation continuation) {
        super(2, continuation);
        this.$savePath = str;
        this.$url = str2;
        this.$zplanSpanContext = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new SquareMapResourceHelper$startDownloadJob$1(this.$savePath, this.$url, this.$zplanSpanContext, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SquareMapResourceHelper$startDownloadJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Continuation intercepted;
        ReentrantLock reentrantLock;
        Map map;
        Map map2;
        dl0.b bVar;
        Map map3;
        Object coroutine_suspended2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        boolean z16 = true;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            this.L$0 = this;
            this.label = 1;
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(this);
            SafeContinuation safeContinuation = new SafeContinuation(intercepted);
            if (new File(this.$savePath).exists()) {
                safeContinuation.resumeWith(Result.m476constructorimpl(Unit.INSTANCE));
            } else {
                String str = this.$url + "_" + this.$savePath;
                SquareMapResourceHelper squareMapResourceHelper = SquareMapResourceHelper.f106088j;
                reentrantLock = SquareMapResourceHelper.taskMapLock;
                reentrantLock.lock();
                try {
                    map = SquareMapResourceHelper.taskMap;
                    if (map.containsKey(str)) {
                        map3 = SquareMapResourceHelper.taskMap;
                        List list = (List) map3.get(str);
                        if (list != null) {
                            Boxing.boxBoolean(list.add(safeContinuation));
                        }
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(safeContinuation);
                        map2 = SquareMapResourceHelper.taskMap;
                        map2.put(str, arrayList);
                        z16 = false;
                    }
                    Unit unit = Unit.INSTANCE;
                    if (!z16) {
                        com.tencent.zplan.zplantracing.b startSpan = ZPlanSpanFactory.INSTANCE.startSpan("download", this.$zplanSpanContext);
                        if (startSpan != null) {
                            startSpan.e("url", this.$url);
                        }
                        FLog.INSTANCE.i("SquareMapResourceHelper", "download start. url: " + this.$url);
                        bVar = SquareMapResourceHelper.com.tencent.component.network.module.base.QDLog.TAG_DOWNLOAD java.lang.String;
                        if (bVar != null) {
                            bVar.a(this.$url, null, new a(startSpan, str, this));
                        }
                    }
                } finally {
                    reentrantLock.unlock();
                }
            }
            Object orThrow = safeContinuation.getOrThrow();
            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (orThrow == coroutine_suspended2) {
                DebugProbes.probeCoroutineSuspended(this);
            }
            if (orThrow == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
