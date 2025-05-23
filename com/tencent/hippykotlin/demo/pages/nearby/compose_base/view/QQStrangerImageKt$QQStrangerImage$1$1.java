package com.tencent.hippykotlin.demo.pages.nearby.compose_base.view;

import androidx.compose.runtime.MutableState;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.BDHService;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import n35.v;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.nearby.compose_base.view.QQStrangerImageKt$QQStrangerImage$1$1", f = "QQStrangerImage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class QQStrangerImageKt$QQStrangerImage$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ MutableState<Object> $url;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerImageKt$QQStrangerImage$1$1(MutableState<Object> mutableState, Continuation<? super QQStrangerImageKt$QQStrangerImage$1$1> continuation) {
        super(2, continuation);
        this.$url = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QQStrangerImageKt$QQStrangerImage$1$1(this.$url, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((QQStrangerImageKt$QQStrangerImage$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        BDHService bDHService = BDHService.INSTANCE;
        Object value = this.$url.getValue();
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.IndexNode");
        final MutableState<Object> mutableState = this.$url;
        bDHService.reqDownPhoto((v) value, new Function1<String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.compose_base.view.QQStrangerImageKt$QQStrangerImage$1$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(String str) {
                mutableState.setValue(str);
                return Unit.INSTANCE;
            }
        });
        return Unit.INSTANCE;
    }
}
