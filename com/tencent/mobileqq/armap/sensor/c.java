package com.tencent.mobileqq.armap.sensor;

import android.annotation.TargetApi;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.os.Build;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes11.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final int f199767a;

    /* renamed from: b, reason: collision with root package name */
    private static float[] f199768b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70873);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f199767a = Build.VERSION.SDK_INT;
        }
    }

    public static float[] a(float[] fArr) {
        float sin = (float) Math.sin(fArr[1]);
        float cos = (float) Math.cos(fArr[1]);
        float sin2 = (float) Math.sin(fArr[2]);
        float cos2 = (float) Math.cos(fArr[2]);
        float sin3 = (float) Math.sin(fArr[0]);
        float cos3 = (float) Math.cos(fArr[0]);
        return e(new float[]{cos3, sin3, 0.0f, -sin3, cos3, 0.0f, 0.0f, 0.0f, 1.0f}, e(new float[]{1.0f, 0.0f, 0.0f, 0.0f, cos, sin, 0.0f, -sin, cos}, new float[]{cos2, 0.0f, sin2, 0.0f, 1.0f, 0.0f, -sin2, 0.0f, cos2}));
    }

    public static void b(float[] fArr, SensorEvent sensorEvent) {
        float[] fArr2 = sensorEvent.values;
        if (sensorEvent.sensor.getType() == 11) {
            if (fArr2.length > 4) {
                if (f199767a >= 9) {
                    c(fArr, (float[]) fArr2.clone());
                    return;
                }
                if (f199768b == null) {
                    f199768b = new float[4];
                }
                System.arraycopy(fArr2, 0, f199768b, 0, 4);
                c(fArr, f199768b);
                return;
            }
            c(fArr, (float[]) fArr2.clone());
            return;
        }
        c(fArr, (float[]) fArr2.clone());
    }

    public static void c(float[] fArr, float[] fArr2) {
        float f16;
        if (f199767a >= 9) {
            f(fArr, fArr2);
            return;
        }
        float f17 = fArr2[0];
        float f18 = fArr2[1];
        float f19 = fArr2[2];
        if (fArr2.length == 4) {
            f16 = fArr2[3];
        } else {
            float f26 = ((1.0f - (f17 * f17)) - (f18 * f18)) - (f19 * f19);
            if (f26 > 0.0f) {
                f16 = (float) Math.sqrt(f26);
            } else {
                f16 = 0.0f;
            }
        }
        float f27 = f17 * 2.0f;
        float f28 = f17 * f27;
        float f29 = f18 * 2.0f;
        float f36 = f29 * f18;
        float f37 = 2.0f * f19;
        float f38 = f37 * f19;
        float f39 = f18 * f27;
        float f46 = f37 * f16;
        float f47 = f27 * f19;
        float f48 = f29 * f16;
        float f49 = f29 * f19;
        float f56 = f27 * f16;
        if (fArr.length == 9) {
            fArr[0] = (1.0f - f36) - f38;
            fArr[1] = f39 - f46;
            fArr[2] = f47 + f48;
            fArr[3] = f39 + f46;
            float f57 = 1.0f - f28;
            fArr[4] = f57 - f38;
            fArr[5] = f49 - f56;
            fArr[6] = f47 - f48;
            fArr[7] = f49 + f56;
            fArr[8] = f57 - f36;
            return;
        }
        if (fArr.length == 16) {
            fArr[0] = (1.0f - f36) - f38;
            fArr[1] = f39 - f46;
            fArr[2] = f47 + f48;
            fArr[3] = 0.0f;
            fArr[4] = f39 + f46;
            float f58 = 1.0f - f28;
            fArr[5] = f58 - f38;
            fArr[6] = f49 - f56;
            fArr[7] = 0.0f;
            fArr[8] = f47 - f48;
            fArr[9] = f49 + f56;
            fArr[10] = f58 - f36;
            fArr[11] = 0.0f;
            fArr[14] = 0.0f;
            fArr[13] = 0.0f;
            fArr[12] = 0.0f;
            fArr[15] = 1.0f;
        }
    }

    public static void d(float[] fArr, float[] fArr2) {
        for (int i3 = 0; i3 < fArr2.length; i3++) {
            if (i3 < 3) {
                fArr2[i3] = fArr[i3];
            } else if (i3 > 3 && i3 <= 6) {
                fArr2[i3] = fArr[i3 - 1];
            } else if (i3 != 3 && i3 != 7 && i3 != 11) {
                if (i3 != 12 && i3 != 13 && i3 != 14) {
                    if (i3 == 15) {
                        fArr2[i3] = 1.0f;
                    } else if (i3 > 7 && i3 <= 10) {
                        fArr2[i3] = fArr[i3 - 2];
                    }
                } else {
                    fArr2[i3] = 0.0f;
                }
            } else {
                fArr2[i3] = 0.0f;
            }
        }
    }

    public static float[] e(float[] fArr, float[] fArr2) {
        float f16 = fArr[0] * fArr2[0];
        float f17 = fArr[1];
        float f18 = fArr2[3];
        float f19 = fArr[2];
        float f26 = fArr2[6];
        float f27 = fArr[0];
        float f28 = fArr2[1] * f27;
        float f29 = fArr2[4];
        float f36 = fArr2[7];
        float f37 = f27 * fArr2[2];
        float f38 = fArr[1];
        float f39 = fArr2[5];
        float f46 = fArr2[8];
        float f47 = fArr[3];
        float f48 = fArr2[0];
        float f49 = fArr[4];
        float f56 = (f47 * f48) + (f18 * f49);
        float f57 = fArr[5];
        float f58 = fArr[3];
        float f59 = fArr2[1];
        float f65 = fArr2[2];
        float f66 = fArr[6] * f48;
        float f67 = fArr[7];
        float f68 = f66 + (fArr2[3] * f67);
        float f69 = fArr[8];
        float f75 = fArr[6];
        return new float[]{f16 + (f17 * f18) + (f19 * f26), f28 + (f17 * f29) + (f19 * f36), f37 + (f38 * f39) + (f19 * f46), f56 + (f57 * f26), (f58 * f59) + (f49 * f29) + (f57 * f36), (f58 * f65) + (fArr[4] * f39) + (f57 * f46), f68 + (f26 * f69), (f59 * f75) + (f67 * fArr2[4]) + (f36 * f69), (f75 * f65) + (fArr[7] * fArr2[5]) + (f69 * f46)};
    }

    @TargetApi(9)
    public static void f(float[] fArr, float[] fArr2) {
        SensorManager.getRotationMatrixFromVector(fArr, fArr2);
    }
}
