package com.tencent.mobileqq.qqlive.widget.chat.message;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\f\u00a2\u0006\u0004\b\u0015\u0010\u0016J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u00d6\u0003R\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/chat/message/d;", "Lcom/tencent/mobileqq/qqlive/widget/chat/message/f;", "Lcom/tencent/mobileqq/qqlive/widget/chat/message/i;", "getHeader", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/qqlive/data/gift/GiftMessage;", "d", "Lcom/tencent/mobileqq/qqlive/data/gift/GiftMessage;", "b", "()Lcom/tencent/mobileqq/qqlive/data/gift/GiftMessage;", "giftMessage", "e", "Lcom/tencent/mobileqq/qqlive/widget/chat/message/i;", "msgHeader", "<init>", "(Lcom/tencent/mobileqq/qqlive/data/gift/GiftMessage;)V", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final /* data */ class d implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GiftMessage giftMessage;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final i msgHeader;

    public d(@NotNull GiftMessage giftMessage) {
        Intrinsics.checkNotNullParameter(giftMessage, "giftMessage");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) giftMessage);
        } else {
            this.giftMessage = giftMessage;
            this.msgHeader = new i();
        }
    }

    @NotNull
    public final GiftMessage b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (GiftMessage) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.giftMessage;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if ((other instanceof d) && Intrinsics.areEqual(this.giftMessage, ((d) other).giftMessage)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqlive.widget.chat.message.f
    @Nullable
    public i getHeader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (i) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.msgHeader;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.giftMessage.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "GiftScreenMsg(giftMessage=" + this.giftMessage + ')';
    }
}
