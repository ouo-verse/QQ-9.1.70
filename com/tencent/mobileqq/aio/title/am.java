package com.tencent.mobileqq.aio.title;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0012\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0012\u0010\fR\u0017\u0010\u0014\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0013\u0010\fR\u0017\u0010\u0016\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0018\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0015\u0010\f\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/aio/title/am;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "b", "()Z", "scaleChat", "I", "c", "()I", "unreadCount", "isTroopGuild", "d", "isSelectedMode", "e", "needTransparentBg", "f", "isUseTextColorCache", "<init>", "(ZIZZZZ)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final /* data */ class am {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean scaleChat;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int unreadCount;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean isTroopGuild;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean isSelectedMode;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean needTransparentBg;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final boolean isUseTextColorCache;

    public am(boolean z16, int i3, boolean z17, boolean z18, boolean z19, boolean z26) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Integer.valueOf(i3), Boolean.valueOf(z17), Boolean.valueOf(z18), Boolean.valueOf(z19), Boolean.valueOf(z26));
            return;
        }
        this.scaleChat = z16;
        this.unreadCount = i3;
        this.isTroopGuild = z17;
        this.isSelectedMode = z18;
        this.needTransparentBg = z19;
        this.isUseTextColorCache = z26;
    }

    public final boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.needTransparentBg;
    }

    public final boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.scaleChat;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.unreadCount;
    }

    public final boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.isSelectedMode;
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.isUseTextColorCache;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof am)) {
            return false;
        }
        am amVar = (am) other;
        if (this.scaleChat == amVar.scaleChat && this.unreadCount == amVar.unreadCount && this.isTroopGuild == amVar.isTroopGuild && this.isSelectedMode == amVar.isSelectedMode && this.needTransparentBg == amVar.needTransparentBg && this.isUseTextColorCache == amVar.isUseTextColorCache) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v5, types: [boolean] */
    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        boolean z16 = this.scaleChat;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i16 = ((r06 * 31) + this.unreadCount) * 31;
        ?? r26 = this.isTroopGuild;
        int i17 = r26;
        if (r26 != 0) {
            i17 = 1;
        }
        int i18 = (i16 + i17) * 31;
        ?? r27 = this.isSelectedMode;
        int i19 = r27;
        if (r27 != 0) {
            i19 = 1;
        }
        int i26 = (i18 + i19) * 31;
        ?? r28 = this.needTransparentBg;
        int i27 = r28;
        if (r28 != 0) {
            i27 = 1;
        }
        int i28 = (i26 + i27) * 31;
        boolean z17 = this.isUseTextColorCache;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return i28 + i3;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return "TitleData(scaleChat=" + this.scaleChat + ", unreadCount=" + this.unreadCount + ", isTroopGuild=" + this.isTroopGuild + ", isSelectedMode=" + this.isSelectedMode + ", needTransparentBg=" + this.needTransparentBg + ", isUseTextColorCache=" + this.isUseTextColorCache + ")";
    }
}
