package com.tencent.ecommerce.biz.retain.repo;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&J\n\u0010\t\u001a\u0004\u0018\u00010\u0004H&J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002H&J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0002H&J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0002H&J\b\u0010\u0010\u001a\u00020\u0007H&\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ecommerce/biz/retain/repo/IECRetainRepository;", "", "", "spuId", "Lcom/tencent/ecommerce/biz/retain/repo/b;", "asyncGetRetainInfo", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "refreshRetainInfo", "getRetainInfo", "reportRetainPopup", "retainId", "", "isNeedRetain", "markRetainShowed", "markInvalidRetainID", "markPaySuccess", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public interface IECRetainRepository {
    Object asyncGetRetainInfo(String str, Continuation<? super ECRetainInfoModel> continuation);

    ECRetainInfoModel getRetainInfo();

    boolean isNeedRetain(String retainId);

    void markInvalidRetainID(String retainId);

    void markPaySuccess();

    void markRetainShowed(String retainId);

    void refreshRetainInfo(String spuId);

    void reportRetainPopup(String spuId);
}
