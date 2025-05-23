package com.tencent.qqnt.msg.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.FreqLimitInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\n\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/msg/data/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "a", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "b", "()Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "peer", "Z", "getBFind", "()Z", "bFind", "Lcom/tencent/qqnt/kernel/nativeinterface/FreqLimitInfo;", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/FreqLimitInfo;", "()Lcom/tencent/qqnt/kernel/nativeinterface/FreqLimitInfo;", "freqLimitInfo", "<init>", "(Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;ZLcom/tencent/qqnt/kernel/nativeinterface/FreqLimitInfo;)V", "msg_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final /* data */ class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Contact peer;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean bFind;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final FreqLimitInfo freqLimitInfo;

    public b(@Nullable Contact contact, boolean z16, @Nullable FreqLimitInfo freqLimitInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, contact, Boolean.valueOf(z16), freqLimitInfo);
            return;
        }
        this.peer = contact;
        this.bFind = z16;
        this.freqLimitInfo = freqLimitInfo;
    }

    @Nullable
    public final FreqLimitInfo a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (FreqLimitInfo) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.freqLimitInfo;
    }

    @Nullable
    public final Contact b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Contact) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.peer;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof b)) {
            return false;
        }
        b bVar = (b) other;
        if (Intrinsics.areEqual(this.peer, bVar.peer) && this.bFind == bVar.bFind && Intrinsics.areEqual(this.freqLimitInfo, bVar.freqLimitInfo)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        Contact contact = this.peer;
        int i3 = 0;
        if (contact == null) {
            hashCode = 0;
        } else {
            hashCode = contact.hashCode();
        }
        int i16 = hashCode * 31;
        boolean z16 = this.bFind;
        int i17 = z16;
        if (z16 != 0) {
            i17 = 1;
        }
        int i18 = (i16 + i17) * 31;
        FreqLimitInfo freqLimitInfo = this.freqLimitInfo;
        if (freqLimitInfo != null) {
            i3 = freqLimitInfo.hashCode();
        }
        return i18 + i3;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "ChannelFreqLimitInfoData(peer=" + this.peer + ", bFind=" + this.bFind + ", freqLimitInfo=" + this.freqLimitInfo + ")";
    }
}
