package com.tencent.mobileqq.aio.msglist.holder.component.msgtail;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.base.route.h;
import com.tencent.qqnt.aio.holder.IMsgItemMviUIState;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/AIOEmoReplySetVisibleState;", "Lcom/tencent/qqnt/aio/holder/IMsgItemMviUIState;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "getMsg", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msg", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOEmoReplySetVisibleState implements IMsgItemMviUIState {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MsgRecord msg;

    public AIOEmoReplySetVisibleState(@NotNull MsgRecord msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msg2);
        } else {
            this.msg = msg2;
        }
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }
}
