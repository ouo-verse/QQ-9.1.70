package com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.processor;

import android.content.Context;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.PicMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.msgtail.ui.AIOEmoReplyAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msg.MsgExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\"\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0011H\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/tailitem/processor/b;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/tailitem/processor/a;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "", "g", "", "c", "d", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/ui/AIOEmoReplyAdapter;", "aioEmoReplyAdapter", "Lcom/tencent/mobileqq/aio/msglist/holder/component/c;", "parentVB", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/tailitem/ui/c;", "a", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "aioMsgItem", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/data/g;", "b", "msgItem", "f", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class b extends a {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean g(MsgRecord msgRecord) {
        int i3 = msgRecord.chatType;
        if (i3 == 1 || i3 == 2) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.processor.a
    @NotNull
    public com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.ui.c a(@NotNull Context context, @NotNull AIOEmoReplyAdapter aioEmoReplyAdapter, @Nullable com.tencent.mobileqq.aio.msglist.holder.component.c parentVB) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.ui.c) iPatchRedirector.redirect((short) 4, this, context, aioEmoReplyAdapter, parentVB);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(aioEmoReplyAdapter, "aioEmoReplyAdapter");
        return new com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.ui.d(com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.ui.d.INSTANCE.a(context), aioEmoReplyAdapter);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.processor.a
    @NotNull
    public com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.g b(@NotNull AIOMsgItem aioMsgItem, @NotNull MsgRecord msgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.g) iPatchRedirector.redirect((short) 5, (Object) this, (Object) aioMsgItem, (Object) msgRecord);
        }
        Intrinsics.checkNotNullParameter(aioMsgItem, "aioMsgItem");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        return new com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.c(msgRecord);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.processor.a
    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 5;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.processor.a
    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 8;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.processor.a
    public boolean f(@NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) msgItem)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (com.tencent.mobileqq.aio.utils.d.L(msgItem) && (msgItem instanceof PicMsgItem)) {
            PicMsgItem picMsgItem = (PicMsgItem) msgItem;
            if (MsgExtKt.s(picMsgItem.p2())) {
                return true;
            }
            if ((MsgExtKt.a0(picMsgItem.p2()) || MsgExtKt.o(picMsgItem.p2())) && g(msgItem.getMsgRecord())) {
                return true;
            }
        }
        return false;
    }
}
