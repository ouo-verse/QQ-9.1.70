package com.xiaomi.push;

/* compiled from: P */
/* loaded from: classes28.dex */
public class t implements w {

    /* renamed from: a, reason: collision with root package name */
    private final String f389856a;

    /* renamed from: b, reason: collision with root package name */
    private final String f389857b;

    public t(String str, String str2) {
        if (str != null) {
            this.f389856a = str;
            this.f389857b = str2;
            return;
        }
        throw new IllegalArgumentException("Name may not be null");
    }

    @Override // com.xiaomi.push.w
    public String a() {
        return this.f389856a;
    }

    @Override // com.xiaomi.push.w
    public String b() {
        return this.f389857b;
    }
}
