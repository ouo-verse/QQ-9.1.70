package n63;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes21.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private int f418526a;

    /* renamed from: b, reason: collision with root package name */
    private int f418527b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f418528c;

    /* renamed from: d, reason: collision with root package name */
    private int f418529d;

    /* renamed from: e, reason: collision with root package name */
    private int f418530e;

    public d(int i3, int i16) {
        if (i3 <= 0 || i16 <= 0 || i3 <= i16) {
            QLog.e("WinkFrameDropper", 1, " src & dst error " + i3 + "  " + i16);
            this.f418528c = true;
        }
        this.f418526a = i3;
        this.f418527b = i16;
    }

    public boolean a(int i3) {
        boolean z16 = false;
        if (this.f418528c) {
            return false;
        }
        if (i3 == 0) {
            this.f418530e++;
            return false;
        }
        float f16 = (r7 - this.f418527b) / this.f418526a;
        int i16 = this.f418529d;
        int i17 = this.f418530e;
        if (Math.abs(((i16 + 1) / (i16 + i17)) - f16) < Math.abs((i16 / ((i16 + i17) + 1)) - f16)) {
            z16 = true;
        }
        if (z16) {
            this.f418529d++;
        } else {
            this.f418530e++;
        }
        return z16;
    }
}
