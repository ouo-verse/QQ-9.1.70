package com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.request;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.request.BannerRequest", f = "BannerRequest.kt", i = {}, l = {14}, m = "fetchBanners", n = {}, s = {})
/* loaded from: classes33.dex */
public final class BannerRequest$fetchBanners$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ BannerRequest this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BannerRequest$fetchBanners$1(BannerRequest bannerRequest, Continuation<? super BannerRequest$fetchBanners$1> continuation) {
        super(continuation);
        this.this$0 = bannerRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.fetchBanners(null, null, this);
    }
}
