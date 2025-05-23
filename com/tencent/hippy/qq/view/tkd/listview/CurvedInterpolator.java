package com.tencent.hippy.qq.view.tkd.listview;

import android.view.animation.Interpolator;

/* compiled from: P */
/* loaded from: classes7.dex */
public class CurvedInterpolator implements Interpolator {
    public static final int ease_in = 0;
    public static final int ease_in_android = 3;
    public static final int ease_out = 1;
    public static final int ease_out_android = 2;
    private float[] mX;
    private float[] mY;
    private static final float[] mX_easein = {0.0f, 0.09829712f, 0.18754883f, 0.26867065f, 0.34257814f, 0.41018677f, 0.4724121f, 0.5301697f, 0.584375f, 0.63594365f, 0.685791f, 0.73483276f, 0.7839844f, 0.8341614f, 0.8862793f, 0.94125366f, 1.0f};
    private static final float[] mY_easein = {0.0f, 0.0113952635f, 0.025537109f, 0.04329712f, 0.06554688f, 0.09315796f, 0.12700196f, 0.16795044f, 0.216875f, 0.27464724f, 0.34213868f, 0.42022094f, 0.5097656f, 0.61164427f, 0.7267285f, 0.8558899f, 1.0f};
    private static final float[] mX_easeout_android = {0.0f, 0.033203125f, 0.059375f, 0.08085938f, 0.1f, 0.119140625f, 0.140625f, 0.16679688f, 0.2f, 0.24257812f, 0.296875f, 0.32915038f, 0.36523438f, 0.40541992f, 0.45f, 0.49926758f, 0.5535156f, 0.6130371f, 0.678125f, 0.74907225f, 0.8261719f, 0.9097168f, 1.0f};
    private static final float[] mY_easeout_android = {0.0f, 0.12658691f, 0.24394532f, 0.35222167f, 0.4515625f, 0.54211426f, 0.62402344f, 0.6974365f, 0.7625f, 0.8193604f, 0.86816406f, 0.88959044f, 0.9090576f, 0.9265839f, 0.9421875f, 0.95588684f, 0.9677002f, 0.9776459f, 0.9857422f, 0.99200743f, 0.99645996f, 0.99911803f, 1.0f};
    private static final float[] mX_easein_android = {0.0f, 0.0902832f, 0.17382812f, 0.25092775f, 0.321875f, 0.3869629f, 0.4464844f, 0.5007324f, 0.55f, 0.59458005f, 0.6347656f, 0.6708496f, 0.703125f, 0.75742185f, 0.8f, 0.83320314f, 0.859375f, 0.8808594f, 0.9f, 0.91914064f, 0.940625f, 0.9667969f, 1.0f};
    private static final float[] mY_easein_android = {0.0f, 8.8195805E-4f, 0.0035400393f, 0.007992554f, 0.014257813f, 0.022354126f, 0.032299805f, 0.04411316f, 0.0578125f, 0.07341614f, 0.09094238f, 0.11040955f, 0.13183594f, 0.18063965f, 0.23750001f, 0.3025635f, 0.37597656f, 0.45788574f, 0.5484375f, 0.64777833f, 0.7560547f, 0.8734131f, 1.0f};
    private static final float[] mX_easeout = {0.0f, 0.039575197f, 0.07824219f, 0.116850585f, 0.15625f, 0.19729003f, 0.24082032f, 0.28769043f, 0.33875f, 0.39484864f, 0.45683593f, 0.5255615f, 0.601875f, 0.68662596f, 0.7806641f, 0.8848389f, 1.0f};
    private static final float[] mY_easeout = {0.0f, 0.11175537f, 0.21810548f, 0.31880128f, 0.41359377f, 0.50223386f, 0.58447266f, 0.660061f, 0.72875f, 0.79029053f, 0.8444336f, 0.8909302f, 0.9295313f, 0.95998776f, 0.9820508f, 0.9954712f, 1.0f};

    public CurvedInterpolator(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        this.mX = mX_easein_android;
                        this.mY = mY_easein_android;
                        return;
                    }
                    return;
                }
                this.mX = mX_easeout_android;
                this.mY = mY_easeout_android;
                return;
            }
            this.mX = mX_easeout;
            this.mY = mY_easeout;
            return;
        }
        this.mX = mX_easein;
        this.mY = mY_easein;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f16) {
        if (f16 <= 0.0f) {
            return 0.0f;
        }
        if (f16 >= 1.0f) {
            return 1.0f;
        }
        int length = this.mX.length - 1;
        int i3 = 0;
        while (length - i3 > 1) {
            int i16 = (i3 + length) / 2;
            if (f16 < this.mX[i16]) {
                length = i16;
            } else {
                i3 = i16;
            }
        }
        float[] fArr = this.mX;
        float f17 = fArr[length];
        float f18 = fArr[i3];
        float f19 = f17 - f18;
        if (f19 == 0.0f) {
            return this.mY[i3];
        }
        float f26 = (f16 - f18) / f19;
        float[] fArr2 = this.mY;
        float f27 = fArr2[i3];
        return f27 + (f26 * (fArr2[length] - f27));
    }
}
