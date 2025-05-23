package com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.processor;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.FoldMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.msgtail.ui.AIOEmoReplyAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.FoldingInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\"\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\rH\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/tailitem/processor/d;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/tailitem/processor/a;", "", "c", "d", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/ui/AIOEmoReplyAdapter;", "aioEmoReplyAdapter", "Lcom/tencent/mobileqq/aio/msglist/holder/component/c;", "parentVB", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/tailitem/ui/c;", "a", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "aioMsgItem", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/data/g;", "b", "msgItem", "", "f", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class d extends a {
    static IPatchRedirector $redirector_;

    public d() {
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
        return new com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.ui.f(com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.ui.f.INSTANCE.a(context), aioEmoReplyAdapter);
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
        return new com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.e(msgRecord);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.processor.a
    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return 2;
        }
        return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.processor.a
    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 5;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.processor.a
    public boolean f(@NotNull AIOMsgItem msgItem) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) msgItem)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (!(msgItem instanceof FoldMsgItem) || !com.tencent.mobileqq.aio.utils.d.A(msgItem) || msgItem.isSelf()) {
            return false;
        }
        FoldingInfo foldingInfo = msgItem.getMsgRecord().foldingInfo;
        if (foldingInfo != null) {
            str = foldingInfo.greyPrompt;
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return true;
    }
}
