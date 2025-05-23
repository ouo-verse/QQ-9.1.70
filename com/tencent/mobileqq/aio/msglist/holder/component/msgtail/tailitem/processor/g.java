package com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.processor;

import android.content.Context;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.AniStickerMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.ui.k;
import com.tencent.mobileqq.aio.msglist.holder.component.msgtail.ui.AIOEmoReplyAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.FaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\"\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\rH\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/tailitem/processor/g;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/tailitem/processor/a;", "", "c", "d", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/ui/AIOEmoReplyAdapter;", "aioEmoReplyAdapter", "Lcom/tencent/mobileqq/aio/msglist/holder/component/c;", "parentVB", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/tailitem/ui/c;", "a", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "aioMsgItem", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/data/g;", "b", "msgItem", "", "f", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class g extends a {
    static IPatchRedirector $redirector_;

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
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
        return new k(k.INSTANCE.a(context), aioEmoReplyAdapter, parentVB);
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
        return new com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.i(msgRecord);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.processor.a
    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 6;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.processor.a
    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 9;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.processor.a
    public boolean f(@NotNull AIOMsgItem msgItem) {
        MsgElement firstTypeElement;
        FaceElement faceElement;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) msgItem)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        com.tencent.mobileqq.emoticon.rare.config.c cVar = com.tencent.mobileqq.emoticon.rare.config.c.f204869a;
        if (!cVar.g() || !(msgItem instanceof AniStickerMsgItem) || (msgItem instanceof com.tencent.mobileqq.aio.msg.e) || (firstTypeElement = msgItem.getFirstTypeElement(6)) == null || (faceElement = firstTypeElement.faceElement) == null) {
            return false;
        }
        return cVar.b().e(faceElement.faceIndex);
    }
}
