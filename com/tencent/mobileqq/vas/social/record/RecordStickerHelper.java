package com.tencent.mobileqq.vas.social.record;

import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.zplan.model.ZPlanStickerInfo;
import com.tencent.mobileqq.zplan.servlet.n;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0002H\u0002JV\u0010\u0015\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2<\u0010\u0013\u001a8\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00110\u0010\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00070\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/vas/social/record/RecordStickerHelper;", "", "", "id", "", "startTime", "errorCode", "", "f", "", "idArray", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "success", "", "Lcom/tencent/mobileqq/zplan/model/ZPlanStickerInfo;", "result", "callback", WadlProxyConsts.PARAM_TIME_OUT, "c", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class RecordStickerHelper {

    /* renamed from: a */
    public static final RecordStickerHelper f310804a = new RecordStickerHelper();

    RecordStickerHelper() {
    }

    public static final void e(AtomicBoolean isCallback, Function2 callback, int[] idArray, long j3) {
        Integer firstOrNull;
        Intrinsics.checkNotNullParameter(isCallback, "$isCallback");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(idArray, "$idArray");
        if (isCallback.compareAndSet(false, true)) {
            callback.invoke(Boolean.FALSE, new ZPlanStickerInfo[0]);
            RecordStickerHelper recordStickerHelper = f310804a;
            firstOrNull = ArraysKt___ArraysKt.firstOrNull(idArray);
            recordStickerHelper.f(firstOrNull != null ? firstOrNull.intValue() : 0, j3, -99001);
        }
        QLog.e("RecordStickerHelper", 1, "getStickerInfo time out");
    }

    public final void f(int id5, long startTime, int errorCode) {
        Map<String, Object> mutableMapOf;
        id3.d dVar = new id3.d(null, 1, null);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_sticker_id", Integer.valueOf(id5)), TuplesKt.to("zplan_time_cost", Long.valueOf((System.nanoTime() - startTime) / 1000000)), TuplesKt.to("zplan_error_code", Integer.valueOf(errorCode)));
        dVar.d("ev_zplan_square_query_sticker", mutableMapOf);
    }

    public final void c(final int[] idArray, final Function2<? super Boolean, ? super ZPlanStickerInfo[], Unit> callback, long r17) {
        Intrinsics.checkNotNullParameter(idArray, "idArray");
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            callback.invoke(Boolean.FALSE, new ZPlanStickerInfo[0]);
            return;
        }
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final long nanoTime = System.nanoTime();
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.vas.social.record.h
            @Override // java.lang.Runnable
            public final void run() {
                RecordStickerHelper.e(atomicBoolean, callback, idArray, nanoTime);
            }
        }, r17);
        n.INSTANCE.a(appInterface, idArray, new com.tencent.mobileqq.zootopia.api.e<ZPlanStickerInfo[]>() { // from class: com.tencent.mobileqq.vas.social.record.RecordStickerHelper$getStickerInfo$2
            @Override // com.tencent.mobileqq.zootopia.api.e
            public void onResultFailure(int error, String message) {
                Integer firstOrNull;
                if (atomicBoolean.compareAndSet(false, true)) {
                    callback.invoke(Boolean.FALSE, new ZPlanStickerInfo[0]);
                    RecordStickerHelper recordStickerHelper = RecordStickerHelper.f310804a;
                    firstOrNull = ArraysKt___ArraysKt.firstOrNull(idArray);
                    recordStickerHelper.f(firstOrNull != null ? firstOrNull.intValue() : 0, nanoTime, error);
                }
                QLog.e("RecordStickerHelper", 1, "getStickerInfo failed " + error + ", " + message + ", idArray:" + idArray);
            }

            @Override // com.tencent.mobileqq.zootopia.api.e
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResultSuccess(ZPlanStickerInfo[] result) {
                String joinToString$default;
                Integer firstOrNull;
                Intrinsics.checkNotNullParameter(result, "result");
                if (atomicBoolean.compareAndSet(false, true)) {
                    callback.invoke(Boolean.TRUE, result);
                    RecordStickerHelper recordStickerHelper = RecordStickerHelper.f310804a;
                    firstOrNull = ArraysKt___ArraysKt.firstOrNull(idArray);
                    RecordStickerHelper.g(recordStickerHelper, firstOrNull != null ? firstOrNull.intValue() : 0, nanoTime, 0, 4, null);
                }
                joinToString$default = ArraysKt___ArraysKt.joinToString$default(result, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1<ZPlanStickerInfo, CharSequence>() { // from class: com.tencent.mobileqq.vas.social.record.RecordStickerHelper$getStickerInfo$2$onResultSuccess$1
                    @Override // kotlin.jvm.functions.Function1
                    public final CharSequence invoke(ZPlanStickerInfo it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return it.getStickerId() + "-" + it.getData() + ",\n";
                    }
                }, 31, (Object) null);
                QLog.d("RecordStickerHelper", 1, "getStickerInfo success " + joinToString$default);
            }
        });
    }

    public static /* synthetic */ void g(RecordStickerHelper recordStickerHelper, int i3, long j3, int i16, int i17, Object obj) {
        if ((i17 & 4) != 0) {
            i16 = 0;
        }
        recordStickerHelper.f(i3, j3, i16);
    }

    public static /* synthetic */ void d(RecordStickerHelper recordStickerHelper, int[] iArr, Function2 function2, long j3, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            j3 = 2000;
        }
        recordStickerHelper.c(iArr, function2, j3);
    }
}
