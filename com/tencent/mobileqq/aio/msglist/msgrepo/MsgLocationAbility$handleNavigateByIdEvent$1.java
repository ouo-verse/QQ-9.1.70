package com.tencent.mobileqq.aio.msglist.msgrepo;

import android.os.Bundle;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgList;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mobileqq.aio.event.MsgNavigationEvent;
import com.tencent.mobileqq.aio.msglist.AIOMsgRepo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.aio.msglist.msgrepo.MsgLocationAbility$handleNavigateByIdEvent$1", f = "MsgLocationAbility.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes11.dex */
public final class MsgLocationAbility$handleNavigateByIdEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ MsgNavigationEvent.NavigateByIdEvent $intent;
    int label;
    final /* synthetic */ MsgLocationAbility this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgLocationAbility$handleNavigateByIdEvent$1(MsgNavigationEvent.NavigateByIdEvent navigateByIdEvent, MsgLocationAbility msgLocationAbility, Continuation<? super MsgLocationAbility$handleNavigateByIdEvent$1> continuation) {
        super(2, continuation);
        this.$intent = navigateByIdEvent;
        this.this$0 = msgLocationAbility;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, navigateByIdEvent, msgLocationAbility, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new MsgLocationAbility$handleNavigateByIdEvent$1(this.$intent, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Ref.LongRef longRef = new Ref.LongRef();
                longRef.element = this.$intent.a();
                MsgList M = this.this$0.q().M();
                Iterator<com.tencent.aio.data.msglist.a> it = M.iterator();
                int i3 = 0;
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().getMsgId() == longRef.element) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            break;
                        }
                        i3++;
                    } else {
                        i3 = -1;
                        break;
                    }
                }
                QLog.d("MsgLocationAbility", 1, "[handleNavigateByIdEvent]: navigateToMsg msgId=" + longRef.element + ", pop=" + i3);
                this.this$0.focusBottomOnBackground = false;
                Bundle bundle = new Bundle();
                bundle.putBoolean(HippyQQPagView.FunctionName.FLUSH, this.$intent.b());
                bundle.putLong("navigate_id", longRef.element);
                if (i3 != -1) {
                    if (this.$intent.c()) {
                        bundle.putBoolean("navigate_order_down", true);
                    }
                    this.this$0.q().g(IMsgListRepository.MsgListRepoOpType.OtherOperation, M, bundle);
                } else if (longRef.element > 0) {
                    if (this.$intent.c()) {
                        bundle.remove("navigate_id");
                        bundle.putBoolean("navigate_order_down", true);
                        bundle.putBoolean("set_bottom", true);
                        bundle.putBoolean("check_current_focus", false);
                    }
                    bundle.putInt("extra_count", 3);
                    AIOMsgRepo.v1(this.this$0.q(), longRef.element, bundle, false, 4, null);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((MsgLocationAbility$handleNavigateByIdEvent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
