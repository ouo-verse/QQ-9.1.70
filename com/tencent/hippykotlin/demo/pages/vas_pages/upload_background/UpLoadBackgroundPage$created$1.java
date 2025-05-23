package com.tencent.hippykotlin.demo.pages.vas_pages.upload_background;

import com.tencent.commonsdk.util.notification.NotificationUtil;
import com.tencent.kuikly.core.coroutines.b;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage$created$1", f = "UploadBackgroundPage.kt", i = {}, l = {NotificationUtil.Constants.NOTIFY_ID_UNIFORM_DOWNLOAD_END}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class UpLoadBackgroundPage$created$1 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    public UpLoadBackgroundPage L$0;
    public int label;
    public final /* synthetic */ UpLoadBackgroundPage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpLoadBackgroundPage$created$1(UpLoadBackgroundPage upLoadBackgroundPage, Continuation<? super UpLoadBackgroundPage$created$1> continuation) {
        super(2, continuation);
        this.this$0 = upLoadBackgroundPage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UpLoadBackgroundPage$created$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return ((UpLoadBackgroundPage$created$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        UpLoadBackgroundPage upLoadBackgroundPage;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            UpLoadBackgroundPage upLoadBackgroundPage2 = this.this$0;
            UploadBackgroundRequest uploadBackgroundRequest = new UploadBackgroundRequest();
            this.L$0 = upLoadBackgroundPage2;
            this.label = 1;
            Object isSuperVip2 = uploadBackgroundRequest.isSuperVip2(upLoadBackgroundPage2, this);
            if (isSuperVip2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            upLoadBackgroundPage = upLoadBackgroundPage2;
            obj = isSuperVip2;
        } else if (i3 == 1) {
            upLoadBackgroundPage = this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        upLoadBackgroundPage.isSVIP$delegate.setValue(upLoadBackgroundPage, UpLoadBackgroundPage.$$delegatedProperties[4], Boolean.valueOf(((Boolean) obj).booleanValue()));
        return Unit.INSTANCE;
    }
}
