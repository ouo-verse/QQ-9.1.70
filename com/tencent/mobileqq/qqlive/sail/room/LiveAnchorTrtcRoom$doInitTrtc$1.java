package com.tencent.mobileqq.qqlive.sail.room;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.qqlive.sail.room.LiveAnchorTrtcRoom", f = "LiveAnchorTrtcRoom.kt", i = {0, 1}, l = {246, 255}, m = "doInitTrtc", n = {"this", "this"}, s = {"L$0", "L$0"})
/* loaded from: classes17.dex */
public final class LiveAnchorTrtcRoom$doInitTrtc$1 extends ContinuationImpl {
    static IPatchRedirector $redirector_;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LiveAnchorTrtcRoom this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveAnchorTrtcRoom$doInitTrtc$1(LiveAnchorTrtcRoom liveAnchorTrtcRoom, Continuation<? super LiveAnchorTrtcRoom$doInitTrtc$1> continuation) {
        super(continuation);
        this.this$0 = liveAnchorTrtcRoom;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) liveAnchorTrtcRoom, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object Z;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Z = this.this$0.Z(this);
        return Z;
    }
}
