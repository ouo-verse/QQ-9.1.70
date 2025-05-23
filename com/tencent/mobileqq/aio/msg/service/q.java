package com.tencent.mobileqq.aio.msg.service;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015R\u0017\u0010\u001b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/service/q;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "a", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "()Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "contact", "", "b", "J", "()J", "msgId", "c", "I", "()I", "result", "d", "Ljava/lang/String;", "getErrMsg", "()Ljava/lang/String;", "errMsg", "<init>", "(Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;JILjava/lang/String;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final /* data */ class q {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Contact contact;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final long msgId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int result;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String errMsg;

    public q(@NotNull Contact contact, long j3, int i3, @NotNull String errMsg) {
        Intrinsics.checkNotNullParameter(contact, "contact");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, contact, Long.valueOf(j3), Integer.valueOf(i3), errMsg);
            return;
        }
        this.contact = contact;
        this.msgId = j3;
        this.result = i3;
        this.errMsg = errMsg;
    }

    @NotNull
    public final Contact a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Contact) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.contact;
    }

    public final long b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.msgId;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.result;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof q)) {
            return false;
        }
        q qVar = (q) other;
        if (Intrinsics.areEqual(this.contact, qVar.contact) && this.msgId == qVar.msgId && this.result == qVar.result && Intrinsics.areEqual(this.errMsg, qVar.errMsg)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return (((((this.contact.hashCode() * 31) + androidx.fragment.app.a.a(this.msgId)) * 31) + this.result) * 31) + this.errMsg.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return "OperateRsp(contact=" + this.contact + ", msgId=" + this.msgId + ", result=" + this.result + ", errMsg=" + this.errMsg + ")";
    }
}
