package com.tencent.ecommerce.biz.detail.repo.shop;

import com.tencent.commonsdk.util.notification.NotificationUtil;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0096@"}, d2 = {"", "shopId", "spuId", "Lkotlin/coroutines/Continuation;", "Lxh0/a;", "continuation", "", "checkApplySampleQualified"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.detail.repo.shop.ECShopProductDetailRepository", f = "ECShopProductDetailRepository.kt", i = {}, l = {NotificationUtil.Constants.NOTIFY_ID_APPCENTER_BEGIN}, m = "checkApplySampleQualified", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECShopProductDetailRepository$checkApplySampleQualified$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ECShopProductDetailRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECShopProductDetailRepository$checkApplySampleQualified$1(ECShopProductDetailRepository eCShopProductDetailRepository, Continuation continuation) {
        super(continuation);
        this.this$0 = eCShopProductDetailRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.checkApplySampleQualified(null, null, this);
    }
}
