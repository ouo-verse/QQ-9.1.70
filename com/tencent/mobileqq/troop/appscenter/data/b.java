package com.tencent.mobileqq.troop.appscenter.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\u0006\u0010\u0016\u001a\u00020\b\u0012\u0006\u0010\u0018\u001a\u00020\b\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0013\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0016\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\"\u0010\u0018\u001a\u00020\b8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\n\u0010\u000f\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/troop/appscenter/data/b;", "Lcom/tencent/mobileqq/troop/appscenter/data/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "b", "Z", "c", "()Z", "setCanShowSwitch", "(Z)V", "canShowSwitch", "d", "f", "switchState", "e", "setOwnerOrAdmin", "isOwnerOrAdmin", "a", "isEditManage", "<init>", "(ZZZZ)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final /* data */ class b extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean canShowSwitch;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean switchState;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isOwnerOrAdmin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isEditManage;

    public b(boolean z16, boolean z17, boolean z18, boolean z19) {
        super(z19, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Boolean.valueOf(z19));
            return;
        }
        this.canShowSwitch = z16;
        this.switchState = z17;
        this.isOwnerOrAdmin = z18;
        this.isEditManage = z19;
    }

    @Override // com.tencent.mobileqq.troop.appscenter.data.a
    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.isEditManage;
    }

    @Override // com.tencent.mobileqq.troop.appscenter.data.a
    public void b(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
        } else {
            this.isEditManage = z16;
        }
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.canShowSwitch;
    }

    public final boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.switchState;
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.isOwnerOrAdmin;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof b)) {
            return false;
        }
        b bVar = (b) other;
        if (this.canShowSwitch == bVar.canShowSwitch && this.switchState == bVar.switchState && this.isOwnerOrAdmin == bVar.isOwnerOrAdmin && a() == bVar.a()) {
            return true;
        }
        return false;
    }

    public final void f(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.switchState = z16;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        boolean z16 = this.canShowSwitch;
        ?? r16 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i3 = r06 * 31;
        ?? r26 = this.switchState;
        int i16 = r26;
        if (r26 != 0) {
            i16 = 1;
        }
        int i17 = (i3 + i16) * 31;
        ?? r27 = this.isOwnerOrAdmin;
        int i18 = r27;
        if (r27 != 0) {
            i18 = 1;
        }
        int i19 = (i17 + i18) * 31;
        boolean a16 = a();
        if (!a16) {
            r16 = a16;
        }
        return i19 + r16;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return "TroopAppsSwitchData(canShowSwitch=" + this.canShowSwitch + ", switchState=" + this.switchState + ", isOwnerOrAdmin=" + this.isOwnerOrAdmin + ", isEditManage=" + a() + ")";
    }
}
