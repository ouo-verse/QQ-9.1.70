package n63;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes21.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.mobileqq.wink.editor.export.compress.base.b f418517a;

    /* renamed from: b, reason: collision with root package name */
    private float f418518b;

    /* renamed from: c, reason: collision with root package name */
    private float f418519c;

    /* renamed from: d, reason: collision with root package name */
    private int f418520d;

    /* renamed from: e, reason: collision with root package name */
    private int f418521e;

    public a(com.tencent.mobileqq.wink.editor.export.compress.base.b bVar) {
        this.f418517a = bVar;
    }

    public void a(float f16) {
        if (f16 >= 0.0f && f16 <= 1.0f) {
            this.f418519c = f16;
            com.tencent.mobileqq.wink.editor.export.compress.base.b bVar = this.f418517a;
            if (bVar != null) {
                bVar.b(this.f418518b, 0L, 0L, 0L);
            }
        }
    }

    public void b(long j3) {
        float f16;
        com.tencent.mobileqq.wink.editor.export.compress.base.b bVar = this.f418517a;
        if (bVar != null) {
            if (this.f418521e - this.f418520d >= 0) {
                float f17 = (((float) j3) / 1000.0f) / (r1 - r2);
                this.f418518b = f17;
                if (f17 < 0.0f) {
                    f17 = 0.0f;
                }
                this.f418518b = f17;
                if (f17 > 1.0f) {
                    f16 = 1.0f;
                } else {
                    f16 = f17;
                }
                this.f418518b = f16;
                bVar.b(f16, 0L, 0L, 0L);
            }
        }
    }

    public void c(int i3) {
        if (i3 > this.f418520d) {
            this.f418521e = i3;
            return;
        }
        QLog.e("WinkPublish-NCompress-WinkCompressProgressCalculate", 1, "endTimeMs < mStartTimeMs" + i3 + " mStartTimeMs = " + this.f418520d);
    }

    public void d(int i3) {
        if (i3 >= 0) {
            this.f418520d = i3;
        }
    }
}
