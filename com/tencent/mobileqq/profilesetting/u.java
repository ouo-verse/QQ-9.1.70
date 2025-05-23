package com.tencent.mobileqq.profilesetting;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b)\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b-\u0010\rB\u0019\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u00a2\u0006\u0004\b-\u0010.B)\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\"\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u00a2\u0006\u0004\b-\u0010/J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\b\u0010\b\u001a\u00020\u0007H\u0016R\"\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\"\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\rR\"\u0010\u001c\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\t\u001a\u0004\b\u001d\u0010\u000b\"\u0004\b\u001e\u0010\rR\"\u0010\"\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\t\u001a\u0004\b \u0010\u000b\"\u0004\b!\u0010\rR\"\u0010'\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010#\u001a\u0004\b\u000f\u0010$\"\u0004\b%\u0010&R\"\u0010)\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\t\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b(\u0010\rR\"\u0010,\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010#\u001a\u0004\b*\u0010$\"\u0004\b+\u0010&\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/profilesetting/u;", "", "", "f", "", "a", "e", "", "toString", "I", "k", "()I", "setType", "(I)V", "type", "b", "c", "setFieldId", "fieldId", "j", "setTitleResId", "titleResId", "d", "Ljava/lang/String;", "i", "()Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Ljava/lang/String;)V", "titleReplace", "g", "setSecDescResId", "secDescResId", tl.h.F, "o", "state", "Z", "()Z", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Z)V", "changed", DomainData.DOMAIN_NAME, "formItemBgType", "l", "p", "isSwitchVisible", "<init>", "(II)V", "(IIII)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class u {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int fieldId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int titleResId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String titleReplace;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int secDescResId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int state;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean changed;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int formItemBgType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isSwitchVisible;

    public u(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
            return;
        }
        this.fieldId = -1;
        this.titleResId = -1;
        this.titleReplace = "";
        this.secDescResId = -1;
        this.state = -1;
        this.formItemBgType = -1;
        this.isSwitchVisible = true;
        this.type = i3;
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this)).intValue();
        }
        int i3 = this.state;
        if (i3 != 0 && i3 != 1 && i3 != 2) {
            return 0;
        }
        return i3;
    }

    public final boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return this.changed;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.fieldId;
    }

    public final int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return this.formItemBgType;
    }

    public final int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this)).intValue();
        }
        int i3 = this.state;
        if (i3 != 1 && i3 != 2 && i3 != 3) {
            return 3;
        }
        return i3;
    }

    public final boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        int i3 = this.state;
        boolean z16 = true;
        if (i3 != 0 && i3 == 1) {
            z16 = false;
        }
        if (w.INSTANCE.o(this.fieldId)) {
            z16 = !z16;
        }
        if (this.fieldId == 47201 && this.state == 2) {
            return false;
        }
        return z16;
    }

    public final int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.secDescResId;
    }

    public final int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.state;
    }

    @NotNull
    public final String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.titleReplace;
    }

    public final int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.titleResId;
    }

    public final int k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Integer) iPatchRedirector.redirect((short) 1, (Object) this)).intValue();
        }
        return this.type;
    }

    public final boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        return this.isSwitchVisible;
    }

    public final void m(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
        } else {
            this.changed = z16;
        }
    }

    public final void n(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3);
        } else {
            this.formItemBgType = i3;
        }
    }

    public final void o(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        } else {
            this.state = i3;
        }
    }

    public final void p(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, z16);
        } else {
            this.isSwitchVisible = z16;
        }
    }

    public final void q(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.titleReplace = str;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (String) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        return "ProfileDisplaySettingItem(type=" + this.type + ", fieldId=" + this.fieldId + ", titleResId=" + this.titleResId + ", state=" + this.state + ", changed=" + this.changed + ")";
    }

    public u(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.fieldId = -1;
        this.titleReplace = "";
        this.secDescResId = -1;
        this.state = -1;
        this.formItemBgType = -1;
        this.isSwitchVisible = true;
        this.type = i3;
        this.titleResId = i16;
    }

    public u(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        this.titleReplace = "";
        this.secDescResId = -1;
        this.formItemBgType = -1;
        this.isSwitchVisible = true;
        this.type = i3;
        this.fieldId = i16;
        this.titleResId = i18;
        this.state = i17;
    }
}
