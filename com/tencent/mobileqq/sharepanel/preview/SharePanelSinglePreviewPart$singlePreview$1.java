package com.tencent.mobileqq.sharepanel.preview;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.sharepanel.model.SharePanelContactItem;
import com.tencent.qqlive.module.videoreport.constants.EventKey;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.sharepanel.preview.SharePanelSinglePreviewPart$singlePreview$1", f = "SharePanelSinglePreviewPart.kt", i = {0, 0, 0}, l = {75}, m = "invokeSuspend", n = {EventKey.ACT, "forwardIntent", "previewView"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes18.dex */
public final class SharePanelSinglePreviewPart$singlePreview$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ SharePanelContactItem $contact;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ SharePanelSinglePreviewPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharePanelSinglePreviewPart$singlePreview$1(SharePanelSinglePreviewPart sharePanelSinglePreviewPart, SharePanelContactItem sharePanelContactItem, Continuation<? super SharePanelSinglePreviewPart$singlePreview$1> continuation) {
        super(2, continuation);
        this.this$0 = sharePanelSinglePreviewPart;
        this.$contact = sharePanelContactItem;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, sharePanelSinglePreviewPart, sharePanelContactItem, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new SharePanelSinglePreviewPart$singlePreview$1(this.this$0, this.$contact, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        FragmentActivity fragmentActivity;
        Intent f16;
        View O9;
        k P9;
        FragmentActivity fragmentActivity2;
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 == 1) {
                    view = (View) this.L$2;
                    f16 = (Intent) this.L$1;
                    fragmentActivity2 = (FragmentActivity) this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                Activity activity = this.this$0.getActivity();
                if (activity instanceof FragmentActivity) {
                    fragmentActivity = (FragmentActivity) activity;
                } else {
                    fragmentActivity = null;
                }
                if (fragmentActivity == null) {
                    return Unit.INSTANCE;
                }
                f16 = this.this$0.F9().f();
                if (f16 != null) {
                    O9 = this.this$0.O9(fragmentActivity, f16);
                    P9 = this.this$0.P9();
                    P9.L1().postValue(null);
                    this.L$0 = fragmentActivity;
                    this.L$1 = f16;
                    this.L$2 = O9;
                    this.label = 1;
                    if (DelayKt.delay(120L, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    fragmentActivity2 = fragmentActivity;
                    view = O9;
                } else {
                    return Unit.INSTANCE;
                }
            }
            this.this$0.T9(fragmentActivity2, f16, this.$contact, view);
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((SharePanelSinglePreviewPart$singlePreview$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
