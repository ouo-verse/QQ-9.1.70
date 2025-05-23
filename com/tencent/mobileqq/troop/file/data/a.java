package com.tencent.mobileqq.troop.file.data;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes35.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    String f295451a;

    /* renamed from: b, reason: collision with root package name */
    String f295452b;

    /* renamed from: c, reason: collision with root package name */
    int f295453c;

    public a(Context context, String str, String str2) {
        this.f295451a = str;
        this.f295452b = str2;
        this.f295453c = str2.length();
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.f295451a != null) {
            sb5.append(", hanzi = " + this.f295451a);
        }
        if (this.f295452b != null) {
            sb5.append(", pinyin = " + this.f295452b);
        }
        return sb5.toString();
    }
}
