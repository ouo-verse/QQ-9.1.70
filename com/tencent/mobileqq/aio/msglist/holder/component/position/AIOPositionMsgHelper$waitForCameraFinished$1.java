package com.tencent.mobileqq.aio.msglist.holder.component.position;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.aio.msglist.holder.component.position.AIOPositionMsgHelper", f = "AIOPositionMsgHelper.kt", i = {0, 0, 0}, l = {235, 255}, m = "waitForCameraFinished", n = {"tencentMap", "latLng", "mapView"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes11.dex */
public final class AIOPositionMsgHelper$waitForCameraFinished$1 extends ContinuationImpl {
    static IPatchRedirector $redirector_;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIOPositionMsgHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOPositionMsgHelper$waitForCameraFinished$1(AIOPositionMsgHelper aIOPositionMsgHelper, Continuation<? super AIOPositionMsgHelper$waitForCameraFinished$1> continuation) {
        super(continuation);
        this.this$0 = aIOPositionMsgHelper;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aIOPositionMsgHelper, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object B;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        B = this.this$0.B(null, null, null, this);
        return B;
    }
}
