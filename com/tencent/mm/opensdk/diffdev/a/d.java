package com.tencent.mm.opensdk.diffdev.a;

/* compiled from: P */
/* loaded from: classes9.dex */
public enum d {
    UUID_EXPIRED(402),
    UUID_CANCELED(403),
    UUID_SCANED(404),
    UUID_CONFIRM(405),
    UUID_KEEP_CONNECT(408),
    UUID_ERROR(500);


    /* renamed from: a, reason: collision with root package name */
    private int f151802a;

    d(int i3) {
        this.f151802a = i3;
    }

    public int a() {
        return this.f151802a;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "UUIDStatusCode:" + this.f151802a;
    }
}
