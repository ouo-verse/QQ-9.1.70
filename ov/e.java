package ov;

import com.tencent.util.AssertUtil;

/* compiled from: P */
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private float f424132a = 1.0f;

    /* renamed from: b, reason: collision with root package name */
    private int f424133b = 0;

    public int a() {
        return this.f424133b;
    }

    public float b() {
        return this.f424132a;
    }

    public void c(int i3) {
        this.f424133b = i3;
    }

    public void d(float f16) {
        boolean z16;
        if (f16 >= 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        AssertUtil.assertTrue(z16);
        this.f424132a = f16;
    }
}
