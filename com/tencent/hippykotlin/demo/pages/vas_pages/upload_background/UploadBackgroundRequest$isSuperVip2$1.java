package com.tencent.hippykotlin.demo.pages.vas_pages.upload_background;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UploadBackgroundRequest", f = "UploadBackgroundRequest.kt", i = {}, l = {233}, m = "isSuperVip2", n = {}, s = {})
/* loaded from: classes33.dex */
public final class UploadBackgroundRequest$isSuperVip2$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ UploadBackgroundRequest this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadBackgroundRequest$isSuperVip2$1(UploadBackgroundRequest uploadBackgroundRequest, Continuation<? super UploadBackgroundRequest$isSuperVip2$1> continuation) {
        super(continuation);
        this.this$0 = uploadBackgroundRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.isSuperVip2(null, this);
    }
}
