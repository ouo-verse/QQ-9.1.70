package com.android.volley;

/* compiled from: P */
/* loaded from: classes.dex */
public class d implements j {

    /* renamed from: a, reason: collision with root package name */
    private int f31325a;

    /* renamed from: b, reason: collision with root package name */
    private int f31326b;

    /* renamed from: c, reason: collision with root package name */
    private final int f31327c;

    /* renamed from: d, reason: collision with root package name */
    private final float f31328d;

    public d() {
        this(2500, 1, 1.0f);
    }

    protected boolean a() {
        if (this.f31326b <= this.f31327c) {
            return true;
        }
        return false;
    }

    @Override // com.android.volley.j
    public int getCurrentRetryCount() {
        return this.f31326b;
    }

    @Override // com.android.volley.j
    public int getCurrentTimeout() {
        return this.f31325a;
    }

    @Override // com.android.volley.j
    public void retry(VolleyError volleyError) throws VolleyError {
        this.f31326b++;
        int i3 = this.f31325a;
        this.f31325a = i3 + ((int) (i3 * this.f31328d));
        if (a()) {
        } else {
            throw volleyError;
        }
    }

    public d(int i3, int i16, float f16) {
        this.f31325a = i3;
        this.f31327c = i16;
        this.f31328d = f16;
    }
}
