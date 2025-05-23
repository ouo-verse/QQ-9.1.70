package e40;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes4.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    private a f395667a;

    /* renamed from: b, reason: collision with root package name */
    private a f395668b;

    /* renamed from: c, reason: collision with root package name */
    private a f395669c;

    /* renamed from: d, reason: collision with root package name */
    private long f395670d;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private float f395671a;

        /* renamed from: b, reason: collision with root package name */
        private float f395672b;

        public a(float f16, float f17) {
            this.f395671a = f16;
            this.f395672b = f17;
        }

        public float a() {
            return this.f395671a;
        }

        public float b() {
            return this.f395672b;
        }

        public void c(float f16) {
            this.f395671a = f16;
        }

        public void d(float f16) {
            this.f395672b = f16;
        }
    }

    public a a() {
        if (this.f395667a == null) {
            if (QLog.isColorLevel()) {
                QLog.d("QFSTouchBean", 1, "[getDeltaTouchPoint] down touch point not is null.");
            }
            return null;
        }
        a aVar = this.f395668b;
        if (aVar == null) {
            if (QLog.isColorLevel()) {
                QLog.d("QFSTouchBean", 1, "[getDeltaTouchPoint] move touch point not is null.");
            }
            return null;
        }
        float a16 = aVar.a();
        float b16 = this.f395668b.b();
        float a17 = a16 - this.f395667a.a();
        float b17 = b16 - this.f395667a.b();
        a aVar2 = this.f395669c;
        if (aVar2 == null) {
            this.f395669c = new a(a17, b17);
        } else {
            aVar2.c(a17);
            this.f395669c.d(b17);
        }
        return this.f395669c;
    }

    public a b() {
        return this.f395667a;
    }

    public long c() {
        return this.f395670d;
    }

    public void d(float f16, float f17) {
        this.f395670d = System.currentTimeMillis();
        a aVar = this.f395667a;
        if (aVar == null) {
            this.f395667a = new a(f16, f17);
        } else {
            aVar.d(f16);
            this.f395667a.d(f17);
        }
    }

    public void e(float f16, float f17) {
        a aVar = this.f395668b;
        if (aVar == null) {
            this.f395668b = new a(f16, f17);
        } else {
            aVar.d(f16);
            this.f395668b.d(f17);
        }
    }
}
