package com.tencent.ecommerce.repo.comment;

import com.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ/\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ecommerce/repo/comment/f;", "", "Lcom/tencent/ecommerce/repo/comment/a;", "commentInfo", "Lcom/tencent/ecommerce/repo/comment/e;", "b", "(Lcom/tencent/ecommerce/repo/comment/a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", WSAutoShowCommentParams.KEY_COMMENT_ID, "Lcom/tencent/ecommerce/repo/comment/c;", "c", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "skuId", "spuId", "a", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public interface f {
    Object a(String str, String str2, String str3, Continuation<? super c> continuation);

    Object b(ECQShopOrderCommentInfo eCQShopOrderCommentInfo, Continuation<? super e> continuation);

    Object c(String str, Continuation<? super c> continuation);
}
