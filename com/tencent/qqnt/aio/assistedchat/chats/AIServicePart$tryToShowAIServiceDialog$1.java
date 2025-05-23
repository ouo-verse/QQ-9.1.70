package com.tencent.qqnt.aio.assistedchat.chats;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.qqnt.aio.assistedchat.api.IAssistedChatApi;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.aio.assistedchat.chats.AIServicePart$tryToShowAIServiceDialog$1", f = "AIServicePart.kt", i = {0, 1}, l = {88, 90}, m = "invokeSuspend", n = {"$this$qLaunch", "$this$qLaunch"}, s = {"L$0", "L$0"})
/* loaded from: classes34.dex */
final class AIServicePart$tryToShowAIServiceDialog$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AIServicePart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIServicePart$tryToShowAIServiceDialog$1(AIServicePart aIServicePart, Continuation<? super AIServicePart$tryToShowAIServiceDialog$1> continuation) {
        super(2, continuation);
        this.this$0 = aIServicePart;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AIServicePart$tryToShowAIServiceDialog$1 aIServicePart$tryToShowAIServiceDialog$1 = new AIServicePart$tryToShowAIServiceDialog$1(this.this$0, continuation);
        aIServicePart$tryToShowAIServiceDialog$1.L$0 = obj;
        return aIServicePart$tryToShowAIServiceDialog$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        CoroutineScope coroutineScope;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            if (!ABTestController.getInstance().isTabInited(ABTestController.APPID_1505)) {
                this.L$0 = coroutineScope2;
                this.label = 1;
                if (DelayKt.delay(5000L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                this.L$0 = coroutineScope2;
                this.label = 2;
                if (DelayKt.delay(1000L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            coroutineScope = coroutineScope2;
        } else {
            if (i3 != 1 && i3 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        Activity activity = this.this$0.getActivity();
        FragmentActivity fragmentActivity = activity instanceof FragmentActivity ? (FragmentActivity) activity : null;
        if (fragmentActivity == null) {
            return Unit.INSTANCE;
        }
        ((IAssistedChatApi) QRoute.api(IAssistedChatApi.class)).tryToShowAIServiceDialog(fragmentActivity, coroutineScope);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AIServicePart$tryToShowAIServiceDialog$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
