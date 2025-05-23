package com.tencent.luggage.wxa.af;

import java.util.Objects;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public final int f121277a;

    /* renamed from: b, reason: collision with root package name */
    public final String f121278b;

    public c(int i3) {
        this(i3, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass() && this.f121277a == ((c) obj).f121277a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.f121277a));
    }

    public String toString() {
        return "ErrorInfo{errno=" + this.f121277a + ", errMsg='" + this.f121278b + "'}";
    }

    public c(int i3, String str) {
        this.f121277a = i3;
        this.f121278b = str;
    }
}
