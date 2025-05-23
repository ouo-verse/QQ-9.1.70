package com.tencent.mobileqq.qqlive.sail.ui.follow;

import android.app.Dialog;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.sail.ui.huyaprivacy.c;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.liveroom.impl.room.follow.TGLiveFollowManager;
import com.tencent.timi.game.liveroom.impl.room.followguide.FollowGuideConfigModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import lj4.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.qqlive.sail.ui.follow.QQLiveFollowGuidePart$doShowDialog$1", f = "QQLiveFollowGuidePart.kt", i = {0, 0}, l = {150, 174}, m = "invokeSuspend", n = {"$this$launchWhenResumed", "delayMs"}, s = {"L$0", "J$0"})
/* loaded from: classes17.dex */
public final class QQLiveFollowGuidePart$doShowDialog$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ int $from;
    long J$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ QQLiveFollowGuidePart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQLiveFollowGuidePart$doShowDialog$1(int i3, QQLiveFollowGuidePart qQLiveFollowGuidePart, Continuation<? super QQLiveFollowGuidePart$doShowDialog$1> continuation) {
        super(2, continuation);
        this.$from = i3;
        this.this$0 = qQLiveFollowGuidePart;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), qQLiveFollowGuidePart, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        QQLiveFollowGuidePart$doShowDialog$1 qQLiveFollowGuidePart$doShowDialog$1 = new QQLiveFollowGuidePart$doShowDialog$1(this.$from, this.this$0, continuation);
        qQLiveFollowGuidePart$doShowDialog$1.L$0 = obj;
        return qQLiveFollowGuidePart$doShowDialog$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x013c A[Catch: Exception -> 0x0027, TryCatch #0 {Exception -> 0x0027, blocks: (B:13:0x0022, B:14:0x0134, B:16:0x013c, B:17:0x013f, B:23:0x0039, B:24:0x0065, B:26:0x0098, B:28:0x00a1, B:30:0x00af, B:32:0x00b8, B:34:0x00c0, B:36:0x00c9, B:38:0x00cf, B:40:0x00d7, B:41:0x00da, B:43:0x00ed, B:44:0x00f0, B:45:0x0101, B:49:0x0045, B:51:0x0049, B:52:0x0056, B:55:0x0050), top: B:9:0x001c }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        CoroutineScope coroutineScope;
        int e16;
        long j3;
        com.tencent.mobileqq.qqlive.sail.ui.clearscreen.a va5;
        Dialog pa5;
        Dialog dialog;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            try {
            } catch (Exception e17) {
                QLog.e("Audience|QQLiveFollowGuidePart", 1, "doShowDialog exception:", e17);
            }
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        ResultKt.throwOnFailure(obj);
                        dialog = this.this$0.dialog;
                        if (dialog != null) {
                            dialog.dismiss();
                        }
                        QLog.d("Audience|QQLiveFollowGuidePart", 1, "doShowDialog dismiss");
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j3 = this.J$0;
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                coroutineScope = (CoroutineScope) this.L$0;
                if (this.$from == 0) {
                    e16 = d.f414903a.f();
                } else {
                    e16 = d.f414903a.e();
                }
                j3 = e16 * 1000;
                this.L$0 = coroutineScope;
                this.J$0 = j3;
                this.label = 1;
                if (DelayKt.delay(j3, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            QLog.d("Audience|QQLiveFollowGuidePart", 1, "doShowDialog delay " + j3 + " ms to show");
            va5 = this.this$0.va();
            if (Intrinsics.areEqual(va5.L1().getValue(), Boxing.boxBoolean(true))) {
                QLog.d("Audience|QQLiveFollowGuidePart", 1, "doShowDialog in clear screen state");
                return Unit.INSTANCE;
            }
            if (TGLiveFollowManager.f377684a.n(this.this$0.C9())) {
                QLog.d("Audience|QQLiveFollowGuidePart", 1, "doShowDialog already followed");
                return Unit.INSTANCE;
            }
            if (c.f272776a.a()) {
                QLog.d("Audience|QQLiveFollowGuidePart", 1, "doShowDialog isHuyaPrivacyShowing");
                return Unit.INSTANCE;
            }
            if (CoroutineScopeKt.isActive(coroutineScope)) {
                Dialog dialog2 = this.this$0.dialog;
                if (dialog2 != null) {
                    dialog2.dismiss();
                }
                QQLiveFollowGuidePart qQLiveFollowGuidePart = this.this$0;
                pa5 = qQLiveFollowGuidePart.pa(this.$from);
                qQLiveFollowGuidePart.dialog = pa5;
                Dialog dialog3 = this.this$0.dialog;
                if (dialog3 != null) {
                    dialog3.show();
                }
                QLog.d("Audience|QQLiveFollowGuidePart", 1, "doShowDialog show");
                d.f414903a.j(this.this$0.H9());
            }
            long stayDismissDuration = FollowGuideConfigModel.INSTANCE.a().getStayDismissDuration() * 1000;
            QLog.d("Audience|QQLiveFollowGuidePart", 1, "doShowDialog showDuration " + stayDismissDuration + " ms");
            this.L$0 = null;
            this.label = 2;
            if (DelayKt.delay(stayDismissDuration, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            dialog = this.this$0.dialog;
            if (dialog != null) {
            }
            QLog.d("Audience|QQLiveFollowGuidePart", 1, "doShowDialog dismiss");
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((QQLiveFollowGuidePart$doShowDialog$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
