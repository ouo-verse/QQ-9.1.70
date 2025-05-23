package com.tencent.qqnt.chats.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0007\u0012\b\b\u0002\u0010 \u001a\u00020\u001d\u0012\b\b\u0002\u0010!\u001a\u00020\u001d\u00a2\u0006\u0004\b\"\u0010#J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0011\u001a\u0004\b\t\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001a\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0019\u0010\u0016R\u0017\u0010\u001c\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016R\u0017\u0010 \u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001e\u001a\u0004\b\u000e\u0010\u001fR\u0017\u0010!\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001e\u001a\u0004\b\u0018\u0010\u001f\u00a8\u0006$"}, d2 = {"Lcom/tencent/qqnt/chats/data/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "peerUid", "b", "d", "peerUin", "I", "()I", "chatType", "Z", "f", "()Z", "isHidden", "e", h.F, "isPushOnlineNotify", "g", "isPushAVOnlineNotify", "", "J", "()J", "msgTime", "version", "<init>", "(Ljava/lang/String;Ljava/lang/String;IZZZJJ)V", "chats_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final /* data */ class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String peerUid;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String peerUin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int chatType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean isHidden;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean isPushOnlineNotify;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final boolean isPushAVOnlineNotify;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final long msgTime;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final long version;

    public d(@Nullable String str, @NotNull String peerUin, int i3, boolean z16, boolean z17, boolean z18, long j3, long j16) {
        Intrinsics.checkNotNullParameter(peerUin, "peerUin");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, peerUin, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        this.peerUid = str;
        this.peerUin = peerUin;
        this.chatType = i3;
        this.isHidden = z16;
        this.isPushOnlineNotify = z17;
        this.isPushAVOnlineNotify = z18;
        this.msgTime = j3;
        this.version = j16;
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.chatType;
    }

    public final long b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, (Object) this)).longValue();
        }
        return this.msgTime;
    }

    @Nullable
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.peerUid;
    }

    @NotNull
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.peerUin;
    }

    public final long e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Long) iPatchRedirector.redirect((short) 10, (Object) this)).longValue();
        }
        return this.version;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof d)) {
            return false;
        }
        d dVar = (d) other;
        if (Intrinsics.areEqual(this.peerUid, dVar.peerUid) && Intrinsics.areEqual(this.peerUin, dVar.peerUin) && this.chatType == dVar.chatType && this.isHidden == dVar.isHidden && this.isPushOnlineNotify == dVar.isPushOnlineNotify && this.isPushAVOnlineNotify == dVar.isPushAVOnlineNotify && this.msgTime == dVar.msgTime && this.version == dVar.version) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.isHidden;
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.isPushAVOnlineNotify;
    }

    public final boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.isPushOnlineNotify;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        String str = this.peerUid;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int hashCode2 = ((((hashCode * 31) + this.peerUin.hashCode()) * 31) + this.chatType) * 31;
        boolean z16 = this.isHidden;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (hashCode2 + i16) * 31;
        boolean z17 = this.isPushOnlineNotify;
        int i18 = z17;
        if (z17 != 0) {
            i18 = 1;
        }
        int i19 = (i17 + i18) * 31;
        boolean z18 = this.isPushAVOnlineNotify;
        if (!z18) {
            i3 = z18 ? 1 : 0;
        }
        return ((((i19 + i3) * 31) + androidx.fragment.app.a.a(this.msgTime)) * 31) + androidx.fragment.app.a.a(this.version);
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return "NTHiddenChatEntity(peerUid=" + this.peerUid + ", peerUin=" + this.peerUin + ", chatType=" + this.chatType + ", isHidden=" + this.isHidden + ", isPushOnlineNotify=" + this.isPushOnlineNotify + ", isPushAVOnlineNotify=" + this.isPushAVOnlineNotify + ", msgTime=" + this.msgTime + ", version=" + this.version + ")";
    }

    public /* synthetic */ d(String str, String str2, int i3, boolean z16, boolean z17, boolean z18, long j3, long j16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i3, z16, (i16 & 16) != 0 ? false : z17, (i16 & 32) != 0 ? false : z18, (i16 & 64) != 0 ? 0L : j3, (i16 & 128) != 0 ? 0L : j16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, str2, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i16), defaultConstructorMarker);
    }
}
