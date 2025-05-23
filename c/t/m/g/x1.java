package c.t.m.g;

import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class x1 {

    /* renamed from: f, reason: collision with root package name */
    public static x1 f30094f;

    /* renamed from: a, reason: collision with root package name */
    public float f30095a = 0.0f;

    /* renamed from: b, reason: collision with root package name */
    public float f30096b = 0.0f;

    /* renamed from: c, reason: collision with root package name */
    public float f30097c = 100.0f;

    /* renamed from: d, reason: collision with root package name */
    public boolean f30098d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f30099e = false;

    public static x1 a() {
        if (f30094f == null) {
            synchronized (x1.class) {
                if (f30094f == null) {
                    f30094f = new x1();
                }
            }
        }
        return f30094f;
    }

    public boolean a(List<Float> list, int i3) {
        float f16;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(i3);
        sb5.append("\u9897\u536b\u661f,");
        if (list.size() >= 5) {
            int size = list.size();
            float[] fArr = new float[size];
            int i16 = 0;
            while (true) {
                f16 = 0.0f;
                if (i16 >= size) {
                    break;
                }
                Float f17 = list.get(i16);
                if (f17 != null) {
                    f16 = f17.floatValue();
                }
                fArr[i16] = f16;
                i16++;
            }
            Arrays.sort(fArr);
            float[] fArr2 = new float[5];
            for (int i17 = 0; i17 < 5; i17++) {
                float f18 = fArr[(size - 1) - i17];
                fArr2[i17] = f18;
                f16 += f18;
            }
            float f19 = f16 / 5.0f;
            if (fArr2[0] > 35.0f) {
                this.f30098d = true;
            } else if (f19 > 30.0f) {
                this.f30098d = true;
            }
            if (f19 < 22.0f) {
                this.f30098d = false;
            }
            StringBuilder sb6 = new StringBuilder();
            sb6.append("avg");
            sb6.append(f19);
            StringBuilder sb7 = new StringBuilder();
            sb7.append("avg'");
            sb7.append(f19 - this.f30095a);
            StringBuilder sb8 = new StringBuilder();
            sb8.append("avgMax");
            sb8.append(this.f30096b);
            StringBuilder sb9 = new StringBuilder();
            sb9.append("avgMin");
            sb9.append(this.f30097c);
            boolean z16 = this.f30098d;
            if (this.f30096b < f19) {
                this.f30096b = f19;
            }
            if (this.f30097c > f19) {
                this.f30097c = f19;
            }
            this.f30095a = f19;
            if (f19 - f19 > 2.0f) {
                this.f30099e = false;
            }
            if (f19 > (this.f30096b + this.f30097c) / 2.0f) {
                this.f30099e = true;
            } else if (f19 < 22.0f) {
                this.f30099e = false;
            }
            if (z16 != this.f30099e) {
                StringBuilder sb10 = new StringBuilder();
                sb10.append("\n\u51b2\u7a81");
                sb10.append(this.f30098d);
                sb10.append("|");
                sb10.append(this.f30099e);
            }
            StringBuilder sb11 = new StringBuilder();
            sb11.append("\n\u6700\u7ec8\u7ed3\u679c");
            sb11.append(this.f30099e);
        }
        return this.f30099e;
    }
}
