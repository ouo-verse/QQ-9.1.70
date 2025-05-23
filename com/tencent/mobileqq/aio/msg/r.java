package com.tencent.mobileqq.aio.msg;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PrologueMsgElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\b\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0001H\u0016R$\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r8\u0006@BX\u0086.\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/r;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "", "getViewType", "Landroid/content/Context;", "context", "", "Y0", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "targetMsgRecord", "b0", "newMsgItem", "l", "", "<set-?>", "W0", "Ljava/lang/String;", "i2", "()Ljava/lang/String;", "mWelcomeText", "msgRecord", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class r extends AIOMsgItem {
    static IPatchRedirector $redirector_;

    /* renamed from: W0, reason: from kotlin metadata */
    private String mWelcomeText;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(@NotNull MsgRecord msgRecord) {
        super(msgRecord);
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgRecord);
        }
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public void Y0(@Nullable Context context) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
            return;
        }
        super.Y0(context);
        PrologueMsgElement d16 = com.tencent.qqnt.aio.msg.d.d(this);
        if (d16 != null) {
            str = d16.text;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        this.mWelcomeText = str;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public AIOMsgItem b0(@NotNull MsgRecord targetMsgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (AIOMsgItem) iPatchRedirector.redirect((short) 5, (Object) this, (Object) targetMsgRecord);
        }
        Intrinsics.checkNotNullParameter(targetMsgRecord, "targetMsgRecord");
        return new r(targetMsgRecord);
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem, com.tencent.aio.data.msglist.a
    public int getViewType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 95;
    }

    @NotNull
    public final String i2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        String str = this.mWelcomeText;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mWelcomeText");
        return null;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public void l(@NotNull AIOMsgItem newMsgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) newMsgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(newMsgItem, "newMsgItem");
        super.l(newMsgItem);
        ((r) newMsgItem).mWelcomeText = i2();
    }
}
