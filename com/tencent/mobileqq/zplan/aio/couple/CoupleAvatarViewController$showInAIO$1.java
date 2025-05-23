package com.tencent.mobileqq.zplan.aio.couple;

import android.view.View;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aio.couple.CoupleAvatarViewController$showInAIO$1", f = "CoupleAvatarViewController.kt", i = {}, l = {249, 250}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
final class CoupleAvatarViewController$showInAIO$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CoupleAvatarViewController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoupleAvatarViewController$showInAIO$1(CoupleAvatarViewController coupleAvatarViewController, Continuation<? super CoupleAvatarViewController$showInAIO$1> continuation) {
        super(2, continuation);
        this.this$0 = coupleAvatarViewController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CoupleAvatarViewController$showInAIO$1 coupleAvatarViewController$showInAIO$1 = new CoupleAvatarViewController$showInAIO$1(this.this$0, continuation);
        coupleAvatarViewController$showInAIO$1.L$0 = obj;
        return coupleAvatarViewController$showInAIO$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Object i06;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            QLog.i("CoupleAvatarViewController", 1, "showInAIO " + ((CoroutineScope) this.L$0));
            this.this$0.d(CoupleAvatarSubScene.AIO);
            this.this$0.e0();
            CoupleAvatarViewController coupleAvatarViewController = this.this$0;
            this.label = 1;
            i06 = coupleAvatarViewController.i0(this);
            if (i06 == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.getMAIOContext().e().h(new AIOMsgListEvent.AddAvatarAreaView((View) obj));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        CoupleAvatarViewController coupleAvatarViewController2 = this.this$0;
        this.label = 2;
        obj = coupleAvatarViewController2.S(this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        this.this$0.getMAIOContext().e().h(new AIOMsgListEvent.AddAvatarAreaView((View) obj));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CoupleAvatarViewController$showInAIO$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
