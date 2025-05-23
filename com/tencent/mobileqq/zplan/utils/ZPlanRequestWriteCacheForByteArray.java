package com.tencent.mobileqq.zplan.utils;

import com.tencent.mobileqq.zplan.utils.av;
import com.tencent.qphone.base.util.QLog;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u0002`\u0004B-\u0012\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u0002`\u0004\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0096B\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007R$\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u0002`\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\f\u001a\u0004\b\r\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/ZPlanRequestWriteCacheForByteArray;", "Lcom/tencent/mobileqq/zplan/utils/o;", "Lcom/tencent/mobileqq/zplan/utils/au;", "Lcom/tencent/mobileqq/zplan/utils/av;", "Lcom/tencent/mobileqq/zplan/utils/IZPlanRequest;", "req", "b", "(Lcom/tencent/mobileqq/zplan/utils/au;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "Lcom/tencent/mobileqq/zplan/utils/o;", "impl", "Lcom/tencent/mobileqq/zplan/utils/d;", "Lcom/tencent/mobileqq/zplan/utils/d;", "getCache", "()Lcom/tencent/mobileqq/zplan/utils/d;", "cache", "<init>", "(Lcom/tencent/mobileqq/zplan/utils/o;Lcom/tencent/mobileqq/zplan/utils/d;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanRequestWriteCacheForByteArray implements o<ZPlanRequestReq, av> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final o<ZPlanRequestReq, av> impl;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final d<ZPlanRequestReq> cache;

    /* JADX WARN: Multi-variable type inference failed */
    public ZPlanRequestWriteCacheForByteArray(o<? super ZPlanRequestReq, ? extends av> impl, d<? super ZPlanRequestReq> cache) {
        Intrinsics.checkNotNullParameter(impl, "impl");
        Intrinsics.checkNotNullParameter(cache, "cache");
        this.impl = impl;
        this.cache = cache;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:1|(2:3|(12:5|6|(1:(1:(8:10|11|12|13|14|15|(1:17)|18)(2:23|24))(1:25))(2:43|(1:45)(1:46))|26|27|28|(2:35|(1:37)(6:38|13|14|15|(0)|18))|40|14|15|(0)|18))|47|6|(0)(0)|26|27|28|(4:30|32|35|(0)(0))|40|14|15|(0)|18|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00be, code lost:
    
        r11 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00bf, code lost:
    
        r0 = r12;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0099 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    @Override // com.tencent.mobileqq.zplan.utils.o
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(final ZPlanRequestReq zPlanRequestReq, Continuation<? super av> continuation) {
        ZPlanRequestWriteCacheForByteArray$invoke$1 zPlanRequestWriteCacheForByteArray$invoke$1;
        Object coroutine_suspended;
        int i3;
        ZPlanRequestWriteCacheForByteArray zPlanRequestWriteCacheForByteArray;
        av avVar;
        av avVar2;
        final d<ZPlanRequestReq> dVar;
        Function0<Unit> function0;
        ByteArrayData byteArrayData;
        Object m476constructorimpl;
        Throwable m479exceptionOrNullimpl;
        if (continuation instanceof ZPlanRequestWriteCacheForByteArray$invoke$1) {
            zPlanRequestWriteCacheForByteArray$invoke$1 = (ZPlanRequestWriteCacheForByteArray$invoke$1) continuation;
            int i16 = zPlanRequestWriteCacheForByteArray$invoke$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                zPlanRequestWriteCacheForByteArray$invoke$1.label = i16 - Integer.MIN_VALUE;
                Object obj = zPlanRequestWriteCacheForByteArray$invoke$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = zPlanRequestWriteCacheForByteArray$invoke$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    o<ZPlanRequestReq, av> oVar = this.impl;
                    zPlanRequestWriteCacheForByteArray$invoke$1.L$0 = this;
                    zPlanRequestWriteCacheForByteArray$invoke$1.L$1 = zPlanRequestReq;
                    zPlanRequestWriteCacheForByteArray$invoke$1.label = 1;
                    obj = oVar.a(zPlanRequestReq, zPlanRequestWriteCacheForByteArray$invoke$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    zPlanRequestWriteCacheForByteArray = this;
                } else {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            byteArrayData = (ByteArrayData) zPlanRequestWriteCacheForByteArray$invoke$1.L$1;
                            avVar2 = (av) zPlanRequestWriteCacheForByteArray$invoke$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                QLog.i("SknNetworkUtil", 1, "\u5199\u5165\u7f13\u5b58\u6210\u529f, timestampMillis: " + byteArrayData.getTimestampMillis());
                                m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
                            } catch (Throwable th5) {
                                th = th5;
                                Result.Companion companion = Result.INSTANCE;
                                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th));
                                m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                                if (m479exceptionOrNullimpl != null) {
                                }
                                return avVar2;
                            }
                            m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                            if (m479exceptionOrNullimpl != null) {
                                QLog.e("SknNetworkUtil", 1, "\u5199\u5165\u7f13\u5b58\u5931\u8d25, ", m479exceptionOrNullimpl);
                            }
                            return avVar2;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    zPlanRequestReq = (ZPlanRequestReq) zPlanRequestWriteCacheForByteArray$invoke$1.L$1;
                    zPlanRequestWriteCacheForByteArray = (ZPlanRequestWriteCacheForByteArray) zPlanRequestWriteCacheForByteArray$invoke$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                avVar = (av) obj;
                Result.Companion companion2 = Result.INSTANCE;
                if ((avVar instanceof av.c) && (avVar.getData() instanceof byte[]) && !(avVar instanceof av.a)) {
                    final ByteArrayData byteArrayData2 = new ByteArrayData((byte[]) avVar.getData(), System.currentTimeMillis());
                    dVar = zPlanRequestWriteCacheForByteArray.cache;
                    function0 = new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.utils.Cache$typedSet$$inlined$write$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            OutputStream b16 = d.this.b(zPlanRequestReq);
                            try {
                                ObjectOutputStream objectOutputStream = new ObjectOutputStream(b16);
                                try {
                                    objectOutputStream.writeObject(byteArrayData2);
                                    Unit unit = Unit.INSTANCE;
                                    CloseableKt.closeFinally(objectOutputStream, null);
                                    CloseableKt.closeFinally(b16, null);
                                } finally {
                                }
                            } finally {
                            }
                        }
                    };
                    zPlanRequestWriteCacheForByteArray$invoke$1.L$0 = avVar;
                    zPlanRequestWriteCacheForByteArray$invoke$1.L$1 = byteArrayData2;
                    zPlanRequestWriteCacheForByteArray$invoke$1.label = 2;
                    if (dVar.c(function0, zPlanRequestWriteCacheForByteArray$invoke$1) != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    avVar2 = avVar;
                    byteArrayData = byteArrayData2;
                    QLog.i("SknNetworkUtil", 1, "\u5199\u5165\u7f13\u5b58\u6210\u529f, timestampMillis: " + byteArrayData.getTimestampMillis());
                    m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
                    m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                    if (m479exceptionOrNullimpl != null) {
                    }
                    return avVar2;
                }
                avVar2 = avVar;
                m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
                m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                if (m479exceptionOrNullimpl != null) {
                }
                return avVar2;
            }
        }
        zPlanRequestWriteCacheForByteArray$invoke$1 = new ZPlanRequestWriteCacheForByteArray$invoke$1(this, continuation);
        Object obj2 = zPlanRequestWriteCacheForByteArray$invoke$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = zPlanRequestWriteCacheForByteArray$invoke$1.label;
        if (i3 != 0) {
        }
        avVar = (av) obj2;
        Result.Companion companion22 = Result.INSTANCE;
        if (avVar instanceof av.c) {
            final Object byteArrayData22 = new ByteArrayData((byte[]) avVar.getData(), System.currentTimeMillis());
            dVar = zPlanRequestWriteCacheForByteArray.cache;
            function0 = new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.utils.Cache$typedSet$$inlined$write$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    OutputStream b16 = d.this.b(zPlanRequestReq);
                    try {
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(b16);
                        try {
                            objectOutputStream.writeObject(byteArrayData22);
                            Unit unit = Unit.INSTANCE;
                            CloseableKt.closeFinally(objectOutputStream, null);
                            CloseableKt.closeFinally(b16, null);
                        } finally {
                        }
                    } finally {
                    }
                }
            };
            zPlanRequestWriteCacheForByteArray$invoke$1.L$0 = avVar;
            zPlanRequestWriteCacheForByteArray$invoke$1.L$1 = byteArrayData22;
            zPlanRequestWriteCacheForByteArray$invoke$1.label = 2;
            if (dVar.c(function0, zPlanRequestWriteCacheForByteArray$invoke$1) != coroutine_suspended) {
            }
        }
        avVar2 = avVar;
        m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
        m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
        }
        return avVar2;
    }
}
