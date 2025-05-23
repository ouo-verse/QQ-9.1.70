package com.tencent.qqnt.aio.refresher;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\b\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010 \u001a\u00020\u0004\u0012\u0006\u0010\"\u001a\u00020\u0004\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010#\u00a2\u0006\u0004\b)\u0010*J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001a\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0011\u001a\u0004\b\u000b\u0010\u0013R\"\u0010 \u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0015\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010\"\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u001c\u001a\u0004\b\u0010\u0010\u001d\"\u0004\b!\u0010\u001fR$\u0010(\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010$\u001a\u0004\b\u001b\u0010%\"\u0004\b&\u0010'\u00a8\u0006+"}, d2 = {"Lcom/tencent/qqnt/aio/refresher/ar;", "Lcom/tencent/mobileqq/aio/msglist/holder/external/h;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "a", "J", "d", "()J", "msgId", "b", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "uin", "c", "Z", "g", "()Z", "isSelf", "bubbleId", "e", "I", "()I", "setLocW", "(I)V", "locW", "setLocH", "locH", "Lcom/tencent/qqnt/aio/refresher/as;", "Lcom/tencent/qqnt/aio/refresher/as;", "()Lcom/tencent/qqnt/aio/refresher/as;", tl.h.F, "(Lcom/tencent/qqnt/aio/refresher/as;)V", "rsp", "<init>", "(JLjava/lang/String;ZLjava/lang/String;IILcom/tencent/qqnt/aio/refresher/as;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final /* data */ class ar implements com.tencent.mobileqq.aio.msglist.holder.external.h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long msgId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String uin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean isSelf;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String bubbleId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int locW;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int locH;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private as rsp;

    public ar(long j3, @NotNull String uin, boolean z16, @NotNull String bubbleId, int i3, int i16, @Nullable as asVar) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(bubbleId, "bubbleId");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), uin, Boolean.valueOf(z16), bubbleId, Integer.valueOf(i3), Integer.valueOf(i16), asVar);
            return;
        }
        this.msgId = j3;
        this.uin = uin;
        this.isSelf = z16;
        this.bubbleId = bubbleId;
        this.locW = i3;
        this.locH = i16;
        this.rsp = asVar;
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.bubbleId;
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.locH;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.locW;
    }

    public final long d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.msgId;
    }

    @Nullable
    public final as e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (as) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.rsp;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof ar)) {
            return false;
        }
        ar arVar = (ar) other;
        if (this.msgId == arVar.msgId && Intrinsics.areEqual(this.uin, arVar.uin) && this.isSelf == arVar.isSelf && Intrinsics.areEqual(this.bubbleId, arVar.bubbleId) && this.locW == arVar.locW && this.locH == arVar.locH && Intrinsics.areEqual(this.rsp, arVar.rsp)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.uin;
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.isSelf;
    }

    public final void h(@Nullable as asVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) asVar);
        } else {
            this.rsp = asVar;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        int a16 = ((androidx.fragment.app.a.a(this.msgId) * 31) + this.uin.hashCode()) * 31;
        boolean z16 = this.isSelf;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int hashCode2 = (((((((a16 + i3) * 31) + this.bubbleId.hashCode()) * 31) + this.locW) * 31) + this.locH) * 31;
        as asVar = this.rsp;
        if (asVar == null) {
            hashCode = 0;
        } else {
            hashCode = asVar.hashCode();
        }
        return hashCode2 + hashCode;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return "ShootBubbleRefreshRequest(msgId=" + this.msgId + ", uin=" + this.uin + ", isSelf=" + this.isSelf + ", bubbleId=" + this.bubbleId + ", locW=" + this.locW + ", locH=" + this.locH + ", rsp=" + this.rsp + ")";
    }

    public /* synthetic */ ar(long j3, String str, boolean z16, String str2, int i3, int i16, as asVar, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, str, z16, str2, i3, i16, (i17 & 64) != 0 ? null : asVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), str, Boolean.valueOf(z16), str2, Integer.valueOf(i3), Integer.valueOf(i16), asVar, Integer.valueOf(i17), defaultConstructorMarker);
    }
}
