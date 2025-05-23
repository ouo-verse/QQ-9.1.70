package com.tencent.ecommerce.repo.blindbox;

import com.tencent.ecommerce.base.network.api.d;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J'\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ'\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/tencent/ecommerce/repo/blindbox/b;", "", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "Lcom/tencent/ecommerce/base/network/api/d;", "Lcom/tencent/ecommerce/repo/blindbox/a;", "a", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "orderIds", "b", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "c", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public interface b {
    Object a(String str, Continuation<? super d<a>> continuation);

    Object b(List<String> list, Continuation<? super d<a>> continuation);

    Object c(List<String> list, Continuation<? super d<a>> continuation);
}
