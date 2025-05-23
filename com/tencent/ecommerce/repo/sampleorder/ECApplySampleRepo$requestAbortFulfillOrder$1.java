package com.tencent.ecommerce.repo.sampleorder;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00002\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00000\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0096@"}, d2 = {"", "token", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "Lcom/tencent/ecommerce/repo/aftersale/apply/j;", "reason", "desc", "", "imageUrls", "Lkotlin/coroutines/Continuation;", "", "continuation", "", "requestAbortFulfillOrder"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.repo.sampleorder.ECApplySampleRepo", f = "ECApplySampleRepo.kt", i = {}, l = {124}, m = "requestAbortFulfillOrder", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECApplySampleRepo$requestAbortFulfillOrder$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ECApplySampleRepo this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECApplySampleRepo$requestAbortFulfillOrder$1(ECApplySampleRepo eCApplySampleRepo, Continuation continuation) {
        super(continuation);
        this.this$0 = eCApplySampleRepo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(null, null, null, null, null, this);
    }
}
