package com.tencent.mobileqq.addfriend.ui.fornt.verify.part;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/AddFriendSendEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "msg", "", PreloadTRTCPlayerParams.KEY_SIG, "", "ticket", "(Ljava/lang/String;[BLjava/lang/String;)V", "getMsg", "()Ljava/lang/String;", "getSig", "()[B", "getTicket", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes10.dex */
public final class AddFriendSendEvent extends SimpleBaseEvent {
    static IPatchRedirector $redirector_;

    @Nullable
    private final String msg;

    @Nullable
    private final byte[] sig;

    @Nullable
    private final String ticket;

    public AddFriendSendEvent(@Nullable String str, @Nullable byte[] bArr, @Nullable String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, bArr, str2);
            return;
        }
        this.msg = str;
        this.sig = bArr;
        this.ticket = str2;
    }

    @Nullable
    public final String getMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.msg;
    }

    @Nullable
    public final byte[] getSig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (byte[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.sig;
    }

    @Nullable
    public final String getTicket() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.ticket;
    }
}
