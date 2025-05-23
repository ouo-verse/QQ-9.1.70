package com.tencent.mobileqq.ark.dict;

/* compiled from: P */
/* loaded from: classes11.dex */
class e {

    /* renamed from: a, reason: collision with root package name */
    String f199455a;

    /* renamed from: b, reason: collision with root package name */
    int f199456b;

    /* renamed from: c, reason: collision with root package name */
    int f199457c;

    public e(String str) {
        this.f199456b = 0;
        this.f199457c = 0;
        str = str == null ? "" : str;
        this.f199455a = str;
        this.f199456b = 0;
        this.f199457c = str.length();
    }

    public String a(int i3) {
        int i16 = this.f199456b;
        if (i16 >= this.f199457c) {
            return "";
        }
        try {
            int offsetByCodePoints = this.f199455a.offsetByCodePoints(i16, i3);
            String substring = this.f199455a.substring(this.f199456b, offsetByCodePoints);
            this.f199456b = offsetByCodePoints;
            return substring;
        } catch (IndexOutOfBoundsException unused) {
            String substring2 = this.f199455a.substring(this.f199456b);
            this.f199456b = this.f199457c;
            return substring2;
        }
    }
}
