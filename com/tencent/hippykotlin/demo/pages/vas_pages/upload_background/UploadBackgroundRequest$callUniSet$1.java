package com.tencent.hippykotlin.demo.pages.vas_pages.upload_background;

import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UploadBackgroundRequest", f = "UploadBackgroundRequest.kt", i = {0, 0}, l = {66}, m = "callUniSet", n = {"cxt", "params"}, s = {"L$0", "L$1"})
/* loaded from: classes33.dex */
public final class UploadBackgroundRequest$callUniSet$1 extends ContinuationImpl {
    public UpLoadBackgroundPage L$0;
    public e L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ UploadBackgroundRequest this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadBackgroundRequest$callUniSet$1(UploadBackgroundRequest uploadBackgroundRequest, Continuation<? super UploadBackgroundRequest$callUniSet$1> continuation) {
        super(continuation);
        this.this$0 = uploadBackgroundRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.callUniSet(null, null, 0, 0, this);
    }
}
