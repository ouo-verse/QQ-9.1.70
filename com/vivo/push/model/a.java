package com.vivo.push.model;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private String f387743a;

    /* renamed from: b, reason: collision with root package name */
    private String f387744b;

    public a(String str, String str2) {
        this.f387743a = str;
        this.f387744b = str2;
    }

    public final String a() {
        return this.f387743a;
    }

    public final String b() {
        return this.f387744b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        String str = this.f387743a;
        if (str == null) {
            if (aVar.f387743a != null) {
                return false;
            }
        } else if (!str.equals(aVar.f387743a)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int hashCode;
        String str = this.f387743a;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return hashCode + 31;
    }

    public final String toString() {
        return "ConfigItem{mKey='" + this.f387743a + "', mValue='" + this.f387744b + "'}";
    }
}
