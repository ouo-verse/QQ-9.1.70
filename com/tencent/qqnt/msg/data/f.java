package com.tencent.qqnt.msg.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0015\u001a\u0004\b\n\u0010\u0016R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0010\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/qqnt/msg/data/f;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "getMsgId", "()J", "msgId", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "b", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "c", "()Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "peer", "I", "()I", "errorCode", "d", "Ljava/lang/String;", "()Ljava/lang/String;", "errorMsg", "<init>", "(JLcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;ILjava/lang/String;)V", "msg_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final /* data */ class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long msgId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Contact peer;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int errorCode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String errorMsg;

    public f(long j3, @Nullable Contact contact, int i3, @Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), contact, Integer.valueOf(i3), str);
            return;
        }
        this.msgId = j3;
        this.peer = contact;
        this.errorCode = i3;
        this.errorMsg = str;
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.errorCode;
    }

    @Nullable
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.errorMsg;
    }

    @Nullable
    public final Contact c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Contact) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.peer;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof f)) {
            return false;
        }
        f fVar = (f) other;
        if (this.msgId == fVar.msgId && Intrinsics.areEqual(this.peer, fVar.peer) && this.errorCode == fVar.errorCode && Intrinsics.areEqual(this.errorMsg, fVar.errorMsg)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        int a16 = androidx.fragment.app.a.a(this.msgId) * 31;
        Contact contact = this.peer;
        int i3 = 0;
        if (contact == null) {
            hashCode = 0;
        } else {
            hashCode = contact.hashCode();
        }
        int i16 = (((a16 + hashCode) * 31) + this.errorCode) * 31;
        String str = this.errorMsg;
        if (str != null) {
            i3 = str.hashCode();
        }
        return i16 + i3;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return "MsgSendError(msgId=" + this.msgId + ", peer=" + this.peer + ", errorCode=" + this.errorCode + ", errorMsg=" + this.errorMsg + ")";
    }
}
