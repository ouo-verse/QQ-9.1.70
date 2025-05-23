package com.tencent.mobileqq.aio.shop;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.ArkMsgItem;
import com.tencent.mobileqq.aio.msg.k;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010!\u001a\u00020\t\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\"\u0010\u0014\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0018\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\"\u0010 \u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/aio/shop/g;", "Lcom/tencent/mobileqq/aio/msg/ArkMsgItem;", "Lcom/tencent/mobileqq/aio/msg/k;", "", "getViewType", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "newMsgItem", "", "l", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "targetMsgRecord", "b0", "", "c", "b1", "Z", "w2", "()Z", "x2", "(Z)V", "mIsTheLastMsg", "c1", "getMIsShowedShake", "setMIsShowedShake", "mIsShowedShake", "", "d1", "J", "getMVideoCurrentPositionMs", "()J", "setMVideoCurrentPositionMs", "(J)V", "mVideoCurrentPositionMs", "msgRecord", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class g extends ArkMsgItem implements k {
    static IPatchRedirector $redirector_;

    /* renamed from: b1, reason: collision with root package name and from kotlin metadata */
    private boolean mIsTheLastMsg;

    /* renamed from: c1, reason: collision with root package name and from kotlin metadata */
    private boolean mIsShowedShake;

    /* renamed from: d1, reason: collision with root package name and from kotlin metadata */
    private long mVideoCurrentPositionMs;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@NotNull MsgRecord msgRecord) {
        super(msgRecord);
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgRecord);
        }
    }

    @Override // com.tencent.mobileqq.aio.msg.ArkMsgItem, com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public AIOMsgItem b0(@NotNull MsgRecord targetMsgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (AIOMsgItem) iPatchRedirector.redirect((short) 10, (Object) this, (Object) targetMsgRecord);
        }
        Intrinsics.checkNotNullParameter(targetMsgRecord, "targetMsgRecord");
        return new g(targetMsgRecord);
    }

    @Override // com.tencent.mobileqq.aio.msg.k
    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return this.mIsTheLastMsg;
    }

    @Override // com.tencent.mobileqq.aio.msg.ArkMsgItem, com.tencent.mobileqq.aio.msg.AIOMsgItem, com.tencent.aio.data.msglist.a
    public int getViewType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        if (com.tencent.mobileqq.aio.utils.d.V(getMsgRecord())) {
            return 92;
        }
        return super.getViewType();
    }

    @Override // com.tencent.mobileqq.aio.msg.ArkMsgItem, com.tencent.mobileqq.aio.msg.AIOMsgItem
    public void l(@NotNull AIOMsgItem newMsgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) newMsgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(newMsgItem, "newMsgItem");
        super.l(newMsgItem);
        g gVar = (g) newMsgItem;
        gVar.mIsTheLastMsg = this.mIsTheLastMsg;
        gVar.mIsShowedShake = this.mIsShowedShake;
        gVar.mVideoCurrentPositionMs = this.mVideoCurrentPositionMs;
    }

    public final boolean w2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.mIsTheLastMsg;
    }

    public final void x2(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.mIsTheLastMsg = z16;
        }
    }
}
