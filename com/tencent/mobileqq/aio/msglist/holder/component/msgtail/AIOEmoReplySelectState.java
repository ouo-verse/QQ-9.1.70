package com.tencent.mobileqq.aio.msglist.holder.component.msgtail;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.holder.IMsgItemMviUIState;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0017\u0010\u000f\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u0003\u0010\u000eR$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/AIOEmoReplySelectState;", "Lcom/tencent/qqnt/aio/holder/IMsgItemMviUIState;", "", "d", "I", "b", "()I", "emojiId", "e", "c", "emojiType", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "f", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msg", "Lcom/tencent/qqnt/aio/emoreply/h;", h.F, "Lcom/tencent/qqnt/aio/emoreply/h;", "a", "()Lcom/tencent/qqnt/aio/emoreply/h;", "setEmoReplyAnimationInfo", "(Lcom/tencent/qqnt/aio/emoreply/h;)V", "emoReplyAnimationInfo", "<init>", "(IILcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;Lcom/tencent/qqnt/aio/emoreply/h;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOEmoReplySelectState implements IMsgItemMviUIState {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int emojiId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int emojiType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MsgRecord msg;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.aio.emoreply.h emoReplyAnimationInfo;

    public AIOEmoReplySelectState(int i3, int i16, @NotNull MsgRecord msg2, @Nullable com.tencent.qqnt.aio.emoreply.h hVar) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), msg2, hVar);
            return;
        }
        this.emojiId = i3;
        this.emojiType = i16;
        this.msg = msg2;
        this.emoReplyAnimationInfo = hVar;
    }

    @Nullable
    public final com.tencent.qqnt.aio.emoreply.h a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.qqnt.aio.emoreply.h) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.emoReplyAnimationInfo;
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.emojiId;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.emojiType;
    }

    @NotNull
    public final MsgRecord d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MsgRecord) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.msg;
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }
}
