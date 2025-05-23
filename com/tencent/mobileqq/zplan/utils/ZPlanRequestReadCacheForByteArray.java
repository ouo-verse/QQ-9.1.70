package com.tencent.mobileqq.zplan.utils;

import com.tencent.mobileqq.zplan.utils.av;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;
import java.io.ObjectInputStream;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u0002`\u0004BP\u0012\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u0002`\u0004\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b\u0012!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\u0010\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0096B\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007R$\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u0002`\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\f\u001a\u0004\b\r\u0010\u000eR2\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/ZPlanRequestReadCacheForByteArray;", "Lcom/tencent/mobileqq/zplan/utils/o;", "Lcom/tencent/mobileqq/zplan/utils/au;", "Lcom/tencent/mobileqq/zplan/utils/av;", "Lcom/tencent/mobileqq/zplan/utils/IZPlanRequest;", "req", "b", "(Lcom/tencent/mobileqq/zplan/utils/au;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "Lcom/tencent/mobileqq/zplan/utils/o;", "impl", "Lcom/tencent/mobileqq/zplan/utils/d;", "Lcom/tencent/mobileqq/zplan/utils/d;", "getCache", "()Lcom/tencent/mobileqq/zplan/utils/d;", "cache", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/zplan/utils/ByteArrayData;", "Lkotlin/ParameterName;", "name", "data", "", "c", "Lkotlin/jvm/functions/Function1;", "isTimeout", "()Lkotlin/jvm/functions/Function1;", "<init>", "(Lcom/tencent/mobileqq/zplan/utils/o;Lcom/tencent/mobileqq/zplan/utils/d;Lkotlin/jvm/functions/Function1;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanRequestReadCacheForByteArray implements o<ZPlanRequestReq, av> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final o<ZPlanRequestReq, av> impl;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final d<ZPlanRequestReq> cache;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Function1<ByteArrayData, Boolean> isTimeout;

    /* JADX WARN: Multi-variable type inference failed */
    public ZPlanRequestReadCacheForByteArray(o<? super ZPlanRequestReq, ? extends av> impl, d<? super ZPlanRequestReq> cache, Function1<? super ByteArrayData, Boolean> isTimeout) {
        Intrinsics.checkNotNullParameter(impl, "impl");
        Intrinsics.checkNotNullParameter(cache, "cache");
        Intrinsics.checkNotNullParameter(isTimeout, "isTimeout");
        this.impl = impl;
        this.cache = cache;
        this.isTimeout = isTimeout;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00c1 A[PHI: r12
  0x00c1: PHI (r12v12 java.lang.Object) = (r12v8 java.lang.Object), (r12v1 java.lang.Object) binds: [B:22:0x00be, B:10:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0076 A[Catch: all -> 0x0046, TryCatch #1 {all -> 0x0046, blocks: (B:17:0x0042, B:18:0x0066, B:20:0x0076, B:24:0x007c), top: B:16:0x0042 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007c A[Catch: all -> 0x0046, TRY_LEAVE, TryCatch #1 {all -> 0x0046, blocks: (B:17:0x0042, B:18:0x0066, B:20:0x0076, B:24:0x007c), top: B:16:0x0042 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.tencent.mobileqq.zplan.utils.o
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(final ZPlanRequestReq zPlanRequestReq, Continuation<? super av> continuation) {
        ZPlanRequestReadCacheForByteArray$invoke$1 zPlanRequestReadCacheForByteArray$invoke$1;
        Object coroutine_suspended;
        int i3;
        ZPlanRequestReadCacheForByteArray zPlanRequestReadCacheForByteArray;
        ZPlanRequestReq zPlanRequestReq2;
        Throwable th5;
        ZPlanRequestReadCacheForByteArray zPlanRequestReadCacheForByteArray2;
        ByteArrayData byteArrayData;
        if (continuation instanceof ZPlanRequestReadCacheForByteArray$invoke$1) {
            zPlanRequestReadCacheForByteArray$invoke$1 = (ZPlanRequestReadCacheForByteArray$invoke$1) continuation;
            int i16 = zPlanRequestReadCacheForByteArray$invoke$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                zPlanRequestReadCacheForByteArray$invoke$1.label = i16 - Integer.MIN_VALUE;
                Object obj = zPlanRequestReadCacheForByteArray$invoke$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = zPlanRequestReadCacheForByteArray$invoke$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        final d<ZPlanRequestReq> dVar = this.cache;
                        Function0<ByteArrayData> function0 = new Function0<ByteArrayData>() { // from class: com.tencent.mobileqq.zplan.utils.ZPlanRequestReadCacheForByteArray$invoke$lambda$0$$inlined$typedGet$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final ByteArrayData invoke() {
                                InputStream a16 = d.this.a(zPlanRequestReq);
                                try {
                                    ObjectInputStream objectInputStream = new ObjectInputStream(a16);
                                    try {
                                        Object readObject = objectInputStream.readObject();
                                        if (readObject != null) {
                                            ByteArrayData byteArrayData2 = (ByteArrayData) readObject;
                                            CloseableKt.closeFinally(objectInputStream, null);
                                            CloseableKt.closeFinally(a16, null);
                                            return byteArrayData2;
                                        }
                                        throw new NullPointerException("null cannot be cast to non-null type com.tencent.mobileqq.zplan.utils.ByteArrayData");
                                    } finally {
                                    }
                                } finally {
                                }
                            }
                        };
                        zPlanRequestReadCacheForByteArray$invoke$1.L$0 = this;
                        zPlanRequestReadCacheForByteArray$invoke$1.L$1 = zPlanRequestReq;
                        zPlanRequestReadCacheForByteArray$invoke$1.L$2 = this;
                        zPlanRequestReadCacheForByteArray$invoke$1.label = 1;
                        obj = dVar.c(function0, zPlanRequestReadCacheForByteArray$invoke$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        zPlanRequestReadCacheForByteArray = this;
                        zPlanRequestReq2 = zPlanRequestReq;
                        zPlanRequestReadCacheForByteArray2 = zPlanRequestReadCacheForByteArray;
                    } catch (Throwable th6) {
                        zPlanRequestReadCacheForByteArray = this;
                        zPlanRequestReq2 = zPlanRequestReq;
                        th5 = th6;
                        Result.Companion companion2 = Result.INSTANCE;
                        Result.m476constructorimpl(ResultKt.createFailure(th5));
                        o<ZPlanRequestReq, av> oVar = zPlanRequestReadCacheForByteArray.impl;
                        zPlanRequestReadCacheForByteArray$invoke$1.L$0 = null;
                        zPlanRequestReadCacheForByteArray$invoke$1.L$1 = null;
                        zPlanRequestReadCacheForByteArray$invoke$1.L$2 = null;
                        zPlanRequestReadCacheForByteArray$invoke$1.label = 2;
                        obj = oVar.a(zPlanRequestReq2, zPlanRequestReadCacheForByteArray$invoke$1);
                        if (obj == coroutine_suspended) {
                        }
                    }
                } else {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            ResultKt.throwOnFailure(obj);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    zPlanRequestReadCacheForByteArray2 = (ZPlanRequestReadCacheForByteArray) zPlanRequestReadCacheForByteArray$invoke$1.L$2;
                    zPlanRequestReq2 = (ZPlanRequestReq) zPlanRequestReadCacheForByteArray$invoke$1.L$1;
                    zPlanRequestReadCacheForByteArray = (ZPlanRequestReadCacheForByteArray) zPlanRequestReadCacheForByteArray$invoke$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th7) {
                        th5 = th7;
                        Result.Companion companion22 = Result.INSTANCE;
                        Result.m476constructorimpl(ResultKt.createFailure(th5));
                        o<ZPlanRequestReq, av> oVar2 = zPlanRequestReadCacheForByteArray.impl;
                        zPlanRequestReadCacheForByteArray$invoke$1.L$0 = null;
                        zPlanRequestReadCacheForByteArray$invoke$1.L$1 = null;
                        zPlanRequestReadCacheForByteArray$invoke$1.L$2 = null;
                        zPlanRequestReadCacheForByteArray$invoke$1.label = 2;
                        obj = oVar2.a(zPlanRequestReq2, zPlanRequestReadCacheForByteArray$invoke$1);
                        if (obj == coroutine_suspended) {
                        }
                    }
                }
                byteArrayData = (ByteArrayData) obj;
                if (!zPlanRequestReadCacheForByteArray2.isTimeout.invoke(byteArrayData).booleanValue()) {
                    Result.m476constructorimpl(Unit.INSTANCE);
                    o<ZPlanRequestReq, av> oVar22 = zPlanRequestReadCacheForByteArray.impl;
                    zPlanRequestReadCacheForByteArray$invoke$1.L$0 = null;
                    zPlanRequestReadCacheForByteArray$invoke$1.L$1 = null;
                    zPlanRequestReadCacheForByteArray$invoke$1.L$2 = null;
                    zPlanRequestReadCacheForByteArray$invoke$1.label = 2;
                    obj = oVar22.a(zPlanRequestReq2, zPlanRequestReadCacheForByteArray$invoke$1);
                    return obj == coroutine_suspended ? coroutine_suspended : obj;
                }
                QLog.i("SknNetworkUtil", 1, "\u8bfb\u53d6\u7f13\u5b58\u6210\u529f, timestampMillis: " + byteArrayData.getTimestampMillis());
                return new av.a(byteArrayData.getData());
            }
        }
        zPlanRequestReadCacheForByteArray$invoke$1 = new ZPlanRequestReadCacheForByteArray$invoke$1(this, continuation);
        Object obj2 = zPlanRequestReadCacheForByteArray$invoke$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = zPlanRequestReadCacheForByteArray$invoke$1.label;
        if (i3 != 0) {
        }
        byteArrayData = (ByteArrayData) obj2;
        if (!zPlanRequestReadCacheForByteArray2.isTimeout.invoke(byteArrayData).booleanValue()) {
        }
    }
}
