package com.tencent.aegiskmm;

import com.tencent.aegiskmm.bean.RequestPayLoad;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.aegiskmm.CoreApiImpl$send$1", f = "CoreApiImpl.kt", i = {}, l = {311}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes37.dex */
public final class CoreApiImpl$send$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CoreApiImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoreApiImpl$send$1(CoreApiImpl coreApiImpl, Continuation continuation) {
        super(1, continuation);
        this.this$0 = coreApiImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new CoreApiImpl$send$1(this.this$0, completion);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((CoreApiImpl$send$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            com.tencent.aegiskmm.utils.a b16 = a.f61726d.b();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("\u8282\u6d41\u4e0a\u62a5\u5f00\u59cb\uff0c\u6570\u91cf\uff1a");
            arrayList = this.this$0.dataItemQueue;
            sb5.append(arrayList.size());
            b16.d("KA", sb5.toString());
            CoreApiImpl coreApiImpl = this.this$0;
            String appId = coreApiImpl.getCom.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String().getAppId();
            arrayList2 = this.this$0.dataItemQueue;
            RequestPayLoad requestPayLoad = new RequestPayLoad(appId, arrayList2);
            this.label = 1;
            if (coreApiImpl.j(requestPayLoad, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        a aVar = a.f61726d;
        com.tencent.aegiskmm.utils.a b17 = aVar.b();
        StringBuilder sb6 = new StringBuilder();
        sb6.append("\u8282\u6d41\u4e0a\u62a5\u5b8c\u6210\uff0c\u6570\u91cf\uff1a");
        arrayList3 = this.this$0.dataItemQueue;
        sb6.append(arrayList3.size());
        b17.d("KA", sb6.toString());
        arrayList4 = this.this$0.dataItemQueue;
        arrayList4.clear();
        com.tencent.aegiskmm.utils.a b18 = aVar.b();
        StringBuilder sb7 = new StringBuilder();
        sb7.append("\u8282\u6d41\u961f\u5217\u6e05\u7406\u5b8c\u6210\uff0c\u6570\u91cf\uff1a");
        arrayList5 = this.this$0.dataItemQueue;
        sb7.append(arrayList5.size());
        b18.d("KA", sb7.toString());
        return Unit.INSTANCE;
    }
}
