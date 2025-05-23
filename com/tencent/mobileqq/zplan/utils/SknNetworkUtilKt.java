package com.tencent.mobileqq.zplan.utils;

import androidx.exifinterface.media.ExifInterface;
import com.google.protobuf.nano.MessageNano;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.mobileqq.zplan.utils.av;
import com.tencent.mobileqq.zplan.utils.g;
import java.io.File;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\b\u001aF\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u001aB\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0003j\u0002`\u000b*\u0012\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0003j\u0002`\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\f2\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u001ap\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0003j\u0002`\u000b*\u0012\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0003j\u0002`\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\f26\u0010\u0017\u001a2\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\u0010\u001a8\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0003j\u0002`\u000b*\u0012\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0003j\u0002`\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\f\u001aB\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0003j\u0002`\u000b*\u0012\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0003j\u0002`\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\f2\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u001a*\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u0003j\u0002`\u001d*\u0012\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u0003j\u0002`\u001d\u001a#\u0010#\u001a\u00028\u0000\"\b\b\u0000\u0010 *\u00020\u001f*\u00020!2\u0006\u0010\"\u001a\u00028\u0000\u00a2\u0006\u0004\b#\u0010$\u001a\u001b\u0010%\u001a\u00020!\"\b\b\u0000\u0010 *\u00020\u001f*\u00028\u0000\u00a2\u0006\u0004\b%\u0010&*\"\u0010'\"\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u00032\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u0003*\"\u0010(\"\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u00032\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0003\u00a8\u0006)"}, d2 = {ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mobileqq/zplan/utils/w;", "B", "Lcom/tencent/mobileqq/zplan/utils/o;", "", "durationMillis", "", Element.ELEMENT_NAME_TIMES, "g", "Lcom/tencent/mobileqq/zplan/utils/au;", "Lcom/tencent/mobileqq/zplan/utils/av;", "Lcom/tencent/mobileqq/zplan/utils/IZPlanRequest;", "Lcom/tencent/mobileqq/zplan/utils/d;", "cache", "timeoutMillis", "d", "Lkotlin/Function2;", "Lcom/tencent/mobileqq/zplan/utils/av$a;", "Lkotlin/ParameterName;", "name", "cachedRsp", "timestampMillis", "", "isTimeout", "e", "j", "b", "Lcom/tencent/mobileqq/zplan/utils/f;", "Lcom/tencent/mobileqq/zplan/utils/g;", "Lcom/tencent/mobileqq/zplan/utils/IDownload;", "a", "Lcom/google/protobuf/nano/MessageNano;", "T", "", "data", "c", "([BLcom/google/protobuf/nano/MessageNano;)Lcom/google/protobuf/nano/MessageNano;", "i", "(Lcom/google/protobuf/nano/MessageNano;)[B", "IDownload", "IZPlanRequest", "zplan_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class SknNetworkUtilKt {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u0002`\u0004J\u001b\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0096B\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/utils/SknNetworkUtilKt$a", "Lcom/tencent/mobileqq/zplan/utils/o;", "Lcom/tencent/mobileqq/zplan/utils/f;", "Lcom/tencent/mobileqq/zplan/utils/g;", "Lcom/tencent/mobileqq/zplan/utils/IDownload;", "req", "b", "(Lcom/tencent/mobileqq/zplan/utils/f;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements o<f, g> {

        /* renamed from: a */
        final /* synthetic */ o<f, g> f335730a;

        /* JADX WARN: Multi-variable type inference failed */
        a(o<? super f, ? extends g> oVar) {
            this.f335730a = oVar;
        }

        @Override // com.tencent.mobileqq.zplan.utils.o
        /* renamed from: b */
        public Object a(f fVar, Continuation<? super g> continuation) {
            File file = new File(fVar.getSavePath());
            if (file.isFile()) {
                return new g.a(file);
            }
            return this.f335730a.a(fVar, continuation);
        }
    }

    public static final o<f, g> a(o<? super f, ? extends g> oVar) {
        Intrinsics.checkNotNullParameter(oVar, "<this>");
        return new a(oVar);
    }

    public static final o<ZPlanRequestReq, av> b(o<? super ZPlanRequestReq, ? extends av> oVar, d<? super ZPlanRequestReq> cache, long j3) {
        Intrinsics.checkNotNullParameter(oVar, "<this>");
        Intrinsics.checkNotNullParameter(cache, "cache");
        return j(d(oVar, cache, j3), cache);
    }

    public static final <T extends MessageNano> T c(byte[] bArr, T data) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(data, "data");
        T t16 = (T) MessageNano.mergeFrom(data, bArr);
        Intrinsics.checkNotNullExpressionValue(t16, "mergeFrom(data, this)");
        return t16;
    }

    public static final o<ZPlanRequestReq, av> d(o<? super ZPlanRequestReq, ? extends av> oVar, d<? super ZPlanRequestReq> cache, final long j3) {
        Intrinsics.checkNotNullParameter(oVar, "<this>");
        Intrinsics.checkNotNullParameter(cache, "cache");
        return new ZPlanRequestReadCacheForByteArray(oVar, cache, new Function1<ByteArrayData, Boolean>() { // from class: com.tencent.mobileqq.zplan.utils.SknNetworkUtilKt$readCacheForByteArray$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(ByteArrayData it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(System.currentTimeMillis() - it.getTimestampMillis() > j3);
            }
        });
    }

    public static final o<ZPlanRequestReq, av> e(o<? super ZPlanRequestReq, ? extends av> oVar, d<? super ZPlanRequestReq> cache, final Function2<? super av.a, ? super Long, Boolean> isTimeout) {
        Intrinsics.checkNotNullParameter(oVar, "<this>");
        Intrinsics.checkNotNullParameter(cache, "cache");
        Intrinsics.checkNotNullParameter(isTimeout, "isTimeout");
        return new ZPlanRequestReadCacheForByteArray(oVar, cache, new Function1<ByteArrayData, Boolean>() { // from class: com.tencent.mobileqq.zplan.utils.SknNetworkUtilKt$readCacheForByteArray$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(ByteArrayData it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return isTimeout.invoke(new av.a(it.getData()), Long.valueOf(it.getTimestampMillis()));
            }
        });
    }

    public static final <A, B extends w> o<A, B> g(o<? super A, ? extends B> oVar, long j3, int i3) {
        Intrinsics.checkNotNullParameter(oVar, "<this>");
        return new SknNetworkUtilKt$retryIfFailed$1(i3, oVar, j3);
    }

    public static final <T extends MessageNano> byte[] i(T t16) {
        Intrinsics.checkNotNullParameter(t16, "<this>");
        byte[] byteArray = MessageNano.toByteArray(t16);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(this)");
        return byteArray;
    }

    public static final o<ZPlanRequestReq, av> j(o<? super ZPlanRequestReq, ? extends av> oVar, d<? super ZPlanRequestReq> cache) {
        Intrinsics.checkNotNullParameter(oVar, "<this>");
        Intrinsics.checkNotNullParameter(cache, "cache");
        return new ZPlanRequestWriteCacheForByteArray(oVar, cache);
    }

    public static /* synthetic */ o f(o oVar, d dVar, long j3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            j3 = Long.MAX_VALUE;
        }
        return d(oVar, dVar, j3);
    }

    public static /* synthetic */ o h(o oVar, long j3, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            j3 = 1000;
        }
        if ((i16 & 2) != 0) {
            i3 = 3;
        }
        return g(oVar, j3, i3);
    }
}
