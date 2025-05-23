package com.tencent.halley.common.a;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f113194a;

    /* renamed from: b, reason: collision with root package name */
    public int f113195b;

    /* renamed from: c, reason: collision with root package name */
    public String f113196c;

    /* renamed from: d, reason: collision with root package name */
    public int f113197d;

    /* renamed from: e, reason: collision with root package name */
    public byte f113198e;

    /* renamed from: f, reason: collision with root package name */
    private byte f113199f;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.f113194a = -1;
        this.f113195b = -1;
        this.f113196c = "";
        this.f113197d = -1;
        this.f113199f = (byte) 1;
    }

    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f113196c + ":" + this.f113197d;
    }

    public final boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? this.f113198e == 3 : ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (!TextUtils.isEmpty(this.f113196c) && this.f113196c.charAt(0) == '[') {
            String str = this.f113196c;
            if (str.charAt(str.length() - 1) == ']') {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f113196c + ":" + this.f113197d + ",protocalType:" + ((int) this.f113199f) + ",ipType:" + ((int) this.f113198e);
    }

    public a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.f113194a = -1;
        this.f113195b = -1;
        this.f113199f = (byte) 1;
        this.f113196c = str;
        this.f113197d = -1;
    }

    private boolean b(String str) {
        if (str.contains("]")) {
            String[] split = str.split("]");
            if (split.length != 2 || !split[1].startsWith(":")) {
                return false;
            }
            String substring = split[0].substring(1);
            if (!com.tencent.halley.common.utils.e.c(substring)) {
                return false;
            }
            try {
                int parseInt = Integer.parseInt(split[1].substring(1));
                if (parseInt < 0 || parseInt > 65535) {
                    return false;
                }
                this.f113196c = "[" + substring + "]";
                this.f113197d = parseInt;
                return true;
            } catch (NumberFormatException e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    private boolean c(String str) {
        String[] split = str.split(":");
        if (split.length != 2) {
            return false;
        }
        String str2 = split[0];
        this.f113196c = str2;
        if (!com.tencent.halley.common.utils.j.d(str2)) {
            return false;
        }
        try {
            int parseInt = Integer.parseInt(split[1]);
            this.f113197d = parseInt;
            return parseInt >= 0 && parseInt <= 65535;
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public final boolean a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str)).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("[") ? b(str) : c(str);
    }
}
