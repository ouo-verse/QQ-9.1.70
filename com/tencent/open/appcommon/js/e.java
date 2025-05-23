package com.tencent.open.appcommon.js;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes22.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    String f340698a;

    /* renamed from: b, reason: collision with root package name */
    String f340699b;

    /* renamed from: c, reason: collision with root package name */
    int f340700c;

    /* renamed from: d, reason: collision with root package name */
    long f340701d = System.currentTimeMillis();

    public e(String str, String str2, int i3) {
        this.f340698a = str;
        this.f340699b = str2;
        this.f340700c = i3;
    }

    public boolean a(String str, String str2, int i3) {
        boolean z16 = false;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.f340698a) && this.f340700c == i3 && this.f340698a.equals(str) && this.f340699b.equals(str2) && System.currentTimeMillis() - this.f340701d < 1000) {
            z16 = true;
        }
        if (!z16) {
            this.f340698a = str;
            this.f340699b = str2;
            this.f340700c = i3;
            this.f340701d = System.currentTimeMillis();
        }
        return z16;
    }
}
