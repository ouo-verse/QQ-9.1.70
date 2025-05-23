package com.tencent.mobileqq.qqlive.sail.room;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.qqlive.sail.room.RoomTrtcProxyImpl", f = "RoomTrtcProxyImpl.kt", i = {}, l = {237}, m = "enterTrtcRoom", n = {}, s = {})
/* loaded from: classes17.dex */
public final class RoomTrtcProxyImpl$enterTrtcRoom$1 extends ContinuationImpl {
    static IPatchRedirector $redirector_;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RoomTrtcProxyImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomTrtcProxyImpl$enterTrtcRoom$1(RoomTrtcProxyImpl roomTrtcProxyImpl, Continuation<? super RoomTrtcProxyImpl$enterTrtcRoom$1> continuation) {
        super(continuation);
        this.this$0 = roomTrtcProxyImpl;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) roomTrtcProxyImpl, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(null, this);
    }
}
