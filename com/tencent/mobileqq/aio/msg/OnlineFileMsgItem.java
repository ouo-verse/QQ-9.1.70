package com.tencent.mobileqq.aio.msg;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\u001b\u0010\u0013\u001a\u00020\u000e8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0018\u001a\u00020\u00148FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/OnlineFileMsgItem;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "Landroid/content/Context;", "context", "", "Y0", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "targetMsgRecord", "b0", "", "f1", "toString", "", "getViewType", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "W0", "Lkotlin/Lazy;", "i2", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "Lcom/tencent/qqnt/kernel/nativeinterface/FileElement;", "X0", "j2", "()Lcom/tencent/qqnt/kernel/nativeinterface/FileElement;", "onlineFileElement", "msgRecord", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class OnlineFileMsgItem extends AIOMsgItem {
    static IPatchRedirector $redirector_;

    /* renamed from: W0, reason: from kotlin metadata */
    @NotNull
    private final Lazy msgElement;

    /* renamed from: X0, reason: from kotlin metadata */
    @NotNull
    private final Lazy onlineFileElement;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnlineFileMsgItem(@NotNull MsgRecord msgRecord) {
        super(msgRecord);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<MsgElement>() { // from class: com.tencent.mobileqq.aio.msg.OnlineFileMsgItem$msgElement$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) OnlineFileMsgItem.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final MsgElement invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (MsgElement) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    MsgElement firstTypeElement = OnlineFileMsgItem.this.getFirstTypeElement(23);
                    Intrinsics.checkNotNull(firstTypeElement);
                    return firstTypeElement;
                }
            });
            this.msgElement = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<FileElement>() { // from class: com.tencent.mobileqq.aio.msg.OnlineFileMsgItem$onlineFileElement$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) OnlineFileMsgItem.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final FileElement invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? OnlineFileMsgItem.this.i2().fileElement : (FileElement) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.onlineFileElement = lazy2;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgRecord);
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public void Y0(@Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
        } else {
            super.Y0(context);
            Y1(com.tencent.mobileqq.aio.utils.n.f194168a.f(context, this));
        }
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public AIOMsgItem b0(@NotNull MsgRecord targetMsgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (AIOMsgItem) iPatchRedirector.redirect((short) 5, (Object) this, (Object) targetMsgRecord);
        }
        Intrinsics.checkNotNullParameter(targetMsgRecord, "targetMsgRecord");
        return new OnlineFileMsgItem(targetMsgRecord);
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public String f1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        if (isSelf()) {
            return HardCodeUtil.qqStr(R.string.ypb) + HardCodeUtil.qqStr(R.string.ypd) + HardCodeUtil.qqStr(R.string.f170201yp4);
        }
        CharSequence x16 = x();
        return ((Object) x16) + HardCodeUtil.qqStr(R.string.ypc) + HardCodeUtil.qqStr(R.string.f170201yp4);
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem, com.tencent.aio.data.msglist.a
    public int getViewType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return 81;
    }

    @NotNull
    public final MsgElement i2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MsgElement) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return (MsgElement) this.msgElement.getValue();
    }

    @NotNull
    public final FileElement j2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (FileElement) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        Object value = this.onlineFileElement.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-onlineFileElement>(...)");
        return (FileElement) value;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return OnlineFileMsgItem.class.getSimpleName() + ":msgId=" + getMsgRecord().msgId;
    }
}
