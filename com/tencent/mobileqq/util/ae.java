package com.tencent.mobileqq.util;

import android.os.Bundle;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ae {

    /* renamed from: a, reason: collision with root package name */
    public int f306540a;

    /* renamed from: b, reason: collision with root package name */
    public String f306541b;

    /* renamed from: c, reason: collision with root package name */
    public String f306542c;

    /* renamed from: d, reason: collision with root package name */
    public Object f306543d;

    /* renamed from: e, reason: collision with root package name */
    public Bundle f306544e;

    /* renamed from: f, reason: collision with root package name */
    public long f306545f;

    public ae() {
    }

    public boolean a() {
        String str;
        String str2;
        Object obj;
        int i3 = this.f306540a;
        if (i3 < 1 || i3 > 4 || (str = this.f306541b) == null || "".equals(str.trim())) {
            return false;
        }
        if (this.f306540a == 3 && (((str2 = this.f306542c) == null || "".equals(str2)) && ((obj = this.f306543d) == null || "".equals(obj)))) {
            return false;
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ae) {
            ae aeVar = (ae) obj;
            if (aeVar.f306540a == this.f306540a && Utils.p(this.f306541b, aeVar.f306541b)) {
                if (3 != this.f306540a) {
                    return true;
                }
                if (Utils.p(this.f306542c, aeVar.f306542c) && Utils.p(this.f306543d, aeVar.f306543d) && Utils.p(this.f306544e, aeVar.f306544e)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int i3 = this.f306540a;
        String str = this.f306541b;
        int i16 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i17 = i3 + hashCode;
        String str2 = this.f306542c;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i18 = i17 + hashCode2;
        Object obj = this.f306543d;
        if (obj == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = obj.hashCode();
        }
        int i19 = i18 + hashCode3;
        Bundle bundle = this.f306544e;
        if (bundle != null) {
            i16 = bundle.hashCode();
        }
        return i19 + i16;
    }

    public String toString() {
        return "[iType = " + this.f306540a + ", strKey = " + this.f306541b + ", strSubKey = " + this.f306542c + ", obj = " + this.f306543d + ", extraUpdateTargetParams = " + this.f306544e + ']';
    }

    public ae(int i3, String str, String str2, Object obj, Bundle bundle) {
        this.f306540a = i3;
        this.f306541b = str;
        this.f306542c = str2;
        this.f306543d = obj;
        this.f306544e = bundle;
    }
}
