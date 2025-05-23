package com.tencent.luggage.wxa.cp;

import android.net.Uri;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b0 implements Comparable {

    /* renamed from: f, reason: collision with root package name */
    public static final b0 f123724f = new b0(null, null, null, null, null);

    /* renamed from: a, reason: collision with root package name */
    public final String f123725a;

    /* renamed from: b, reason: collision with root package name */
    public final String f123726b;

    /* renamed from: c, reason: collision with root package name */
    public final String f123727c;

    /* renamed from: d, reason: collision with root package name */
    public final String f123728d;

    /* renamed from: e, reason: collision with root package name */
    public final String f123729e;

    public b0(String str, String str2, String str3, String str4, String str5) {
        this.f123725a = str;
        this.f123726b = str2;
        this.f123727c = (str == null && str2 == null) ? str3 : a(str3);
        this.f123728d = str4;
        this.f123729e = str5;
    }

    public static String a(String str) {
        if (str == null || str.isEmpty() || str.charAt(0) == '/') {
            return str;
        }
        return "/" + str;
    }

    public static b0 b(String str) {
        String str2;
        String str3;
        String str4;
        int indexOf;
        if (!str.isEmpty() && str.charAt(0) != '/' && (indexOf = str.indexOf(58)) >= 0) {
            String substring = str.substring(0, indexOf);
            int length = str.length();
            int i3 = indexOf + 2;
            if (length > i3 && str.charAt(indexOf + 1) == '/' && str.charAt(i3) == '/') {
                int i16 = indexOf + 3;
                int i17 = i16;
                while (i17 < length) {
                    char charAt = str.charAt(i17);
                    if (charAt == '#' || charAt == '/' || charAt == '?') {
                        break;
                    }
                    i17++;
                }
                String substring2 = str.substring(i16, i17);
                if (i17 < length) {
                    str2 = str.substring(i17 + 1);
                    str3 = substring;
                } else {
                    str3 = substring;
                    str2 = null;
                }
                str4 = substring2;
            } else {
                str2 = str.substring(indexOf + 1);
                str3 = substring;
                str4 = null;
            }
        } else {
            str2 = str;
            str3 = null;
            str4 = null;
        }
        return new b0(str3, str4, str2, null, null);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        if (!c0.a(this.f123725a, b0Var.f123725a) || !c0.a(this.f123726b, b0Var.f123726b) || !c0.a(this.f123727c, b0Var.f123727c) || !c0.a(this.f123728d, b0Var.f123728d) || !c0.a(this.f123729e, b0Var.f123729e)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new String[]{this.f123725a, this.f123726b, this.f123727c, this.f123728d, this.f123729e});
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        String str = this.f123725a;
        if (str != null && !str.isEmpty()) {
            sb5.append(this.f123725a);
            sb5.append(':');
        }
        String str2 = this.f123726b;
        if (str2 != null && !str2.isEmpty()) {
            sb5.append("//");
            sb5.append(this.f123726b);
        }
        String str3 = this.f123727c;
        if (str3 != null) {
            sb5.append(str3);
        }
        return sb5.toString();
    }

    public boolean a() {
        return this.f123725a != null;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(b0 b0Var) {
        return toString().compareTo(b0Var.toString());
    }

    public b0(Uri uri) {
        this.f123725a = uri.getScheme();
        this.f123726b = uri.getAuthority();
        this.f123727c = uri.getPath();
        this.f123728d = uri.getQuery();
        this.f123729e = uri.getFragment();
    }
}
