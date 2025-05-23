package com.tencent.hippykotlin.demo.pages.vas_base.krequest.adapter;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.RequestConfig;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import java.util.Map;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.vas_base.krequest.adapter.HttpAdapter", f = "HttpAdapter.kt", i = {0, 0, 0, 1, 1, 1}, l = {34, 41}, m = Const.BUNDLE_KEY_REQUEST, n = {DownloadInfo.spKey_Config, "cookiesStr", "finalUrl", DownloadInfo.spKey_Config, "cookiesStr", "finalUrl"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
/* loaded from: classes33.dex */
public final class HttpAdapter$request$1 extends ContinuationImpl {
    public RequestConfig L$0;
    public String L$1;
    public String L$2;
    public Map L$3;
    public String L$4;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ HttpAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpAdapter$request$1(HttpAdapter httpAdapter, Continuation<? super HttpAdapter$request$1> continuation) {
        super(continuation);
        this.this$0 = httpAdapter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.request(null, this);
    }
}
