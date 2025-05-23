package com.tencent.mobileqq.qzoneplayer.report;

import com.tencent.oskplayer.util.PlayerUtils;

/* compiled from: P */
/* loaded from: classes35.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private static final String f279535b = "b";

    /* renamed from: c, reason: collision with root package name */
    private static final wl2.a<b, Void> f279536c = new a();

    /* renamed from: a, reason: collision with root package name */
    private float f279537a;

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class a extends wl2.a<b, Void> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // wl2.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public b a(Void r16) {
            return new b();
        }
    }

    public static b c() {
        return f279536c.b(null);
    }

    public void a(float f16) {
        if (d(f16)) {
            float f17 = this.f279537a;
            if (f17 == 0.0f) {
                this.f279537a = f16;
            } else {
                this.f279537a = (f17 + f16) / 2.0f;
            }
            PlayerUtils.log(3, f279535b, "video download speed == " + this.f279537a + "KB/s");
        }
    }

    public float b() {
        return this.f279537a;
    }

    private boolean d(float f16) {
        if (f16 <= 0.0f) {
            return false;
        }
        float f17 = this.f279537a;
        if (f17 != 0.0f) {
            return f16 <= 10.0f * f17 && ((double) f16) >= ((double) f17) * 0.1d;
        }
        return true;
    }
}
