package com.tencent.mobileqq.qfix.redirect.field;

import java.lang.ref.WeakReference;

/* loaded from: classes16.dex */
public class PatchField {

    /* renamed from: a, reason: collision with root package name */
    final boolean f261891a;

    /* renamed from: b, reason: collision with root package name */
    final WeakReference<Object> f261892b;

    /* renamed from: c, reason: collision with root package name */
    Object f261893c;

    /* renamed from: d, reason: collision with root package name */
    private final String f261894d;

    public PatchField(boolean z16, String str, Object obj, String str2, Object obj2) {
        WeakReference<Object> weakReference;
        if (!z16) {
            if (obj != null) {
                weakReference = new WeakReference<>(obj);
            } else {
                throw new RuntimeException("instance must not be null.");
            }
        } else {
            weakReference = null;
        }
        this.f261891a = z16;
        this.f261892b = weakReference;
        this.f261894d = a(z16, str, obj, str2);
        this.f261893c = obj2;
    }

    public static String a(boolean z16, String str, Object obj, String str2) {
        StringBuilder sb5;
        if (z16) {
            sb5 = new StringBuilder();
            sb5.append(str);
        } else {
            sb5 = new StringBuilder();
            sb5.append(str);
            sb5.append("@");
            sb5.append(obj.hashCode());
        }
        sb5.append("#");
        sb5.append(str2);
        return sb5.toString();
    }

    public String toString() {
        return "PatchField{key=" + this.f261894d + ", value=" + this.f261893c + '}';
    }

    public final boolean a(Object obj) {
        return (this.f261891a || obj == null || this.f261892b.get() != obj) ? false : true;
    }
}
