package pn2;

import android.os.Bundle;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public String f426498a;

    /* renamed from: b, reason: collision with root package name */
    public Bundle f426499b;

    /* renamed from: c, reason: collision with root package name */
    public int f426500c;

    public b(String str, int i3) {
        this.f426498a = str;
        this.f426500c = i3;
    }

    public boolean a(String str) {
        if (!TextUtils.isEmpty(this.f426498a)) {
            return this.f426498a.equals(str);
        }
        return false;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder(20);
        sb5.append("keyword:");
        sb5.append(this.f426498a);
        sb5.append(" status:");
        sb5.append(this.f426500c);
        return sb5.toString();
    }
}
