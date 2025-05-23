package com.tencent.gamecenter.wadl.sdk.common.b;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public String f106997a;

    /* renamed from: b, reason: collision with root package name */
    public int f106998b;

    /* renamed from: c, reason: collision with root package name */
    public byte f106999c;

    /* renamed from: d, reason: collision with root package name */
    public byte f107000d;

    public a() {
        this.f106997a = "";
        this.f106998b = -1;
        this.f107000d = (byte) 1;
    }

    private int a(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
            return -1;
        }
    }

    public boolean b() {
        if (!TextUtils.isEmpty(this.f106997a) && this.f106997a.charAt(0) == '[') {
            String str = this.f106997a;
            if (str.charAt(str.length() - 1) == ']') {
                return true;
            }
        }
        return false;
    }

    public boolean c() {
        byte b16 = this.f106999c;
        if (b16 != 3 && b16 != 4) {
            return true;
        }
        return false;
    }

    public String d() {
        return "" + this.f106997a + ":" + this.f106998b;
    }

    public String toString() {
        return "" + this.f106997a + ":" + this.f106998b + ",protocalType:" + ((int) this.f107000d) + ",ipType:" + ((int) this.f106999c);
    }

    public a(String str, int i3) {
        this.f107000d = (byte) 1;
        this.f106997a = str;
        this.f106998b = i3;
    }

    public void a(byte b16) {
        this.f106999c = b16;
    }

    public boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.startsWith("[")) {
            String[] split = str.split(":");
            if (split.length != 2) {
                return false;
            }
            String str2 = split[0];
            this.f106997a = str2;
            if (!com.tencent.gamecenter.wadl.sdk.common.e.g.f(str2)) {
                return false;
            }
            int a16 = a(split[1]);
            this.f106998b = a16;
            return a(a16);
        }
        if (str.contains("]")) {
            String[] split2 = str.split("]");
            if (split2.length == 2 && split2[1].startsWith(":")) {
                String substring = split2[0].substring(1);
                if (!com.tencent.gamecenter.wadl.sdk.common.e.c.c(substring)) {
                    return false;
                }
                int a17 = a(split2[1].substring(1));
                if (!a(a17)) {
                    return false;
                }
                this.f106997a = "[" + substring + "]";
                this.f106998b = a17;
                return true;
            }
        }
        return false;
    }

    public boolean a() {
        return this.f106999c == 3;
    }

    private boolean a(int i3) {
        return i3 >= 0 && i3 <= 65535;
    }
}
