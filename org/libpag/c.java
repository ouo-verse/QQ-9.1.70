package org.libpag;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.hardware.HardwareBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class c {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        int f423781a;

        /* renamed from: b, reason: collision with root package name */
        int f423782b;

        /* renamed from: c, reason: collision with root package name */
        long f423783c;

        /* renamed from: d, reason: collision with root package name */
        private PAGDecoder f423784d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public synchronized boolean a() {
            return this.f423784d != null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public synchronized boolean b() {
            boolean z16;
            if (this.f423781a > 0) {
                if (this.f423782b > 0) {
                    z16 = true;
                }
            }
            z16 = false;
            return z16;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public synchronized int c() {
            int numFrames;
            PAGDecoder pAGDecoder = this.f423784d;
            if (pAGDecoder == null) {
                numFrames = 0;
            } else {
                numFrames = pAGDecoder.numFrames();
            }
            return numFrames;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public synchronized void d() {
            PAGDecoder pAGDecoder = this.f423784d;
            if (pAGDecoder != null) {
                pAGDecoder.release();
                this.f423784d = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public synchronized void e() {
            d();
            this.f423781a = 0;
            this.f423782b = 0;
            this.f423783c = 0L;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public synchronized boolean a(int i3) {
            boolean z16;
            PAGDecoder pAGDecoder = this.f423784d;
            if (pAGDecoder != null) {
                z16 = pAGDecoder.checkFrameChanged(i3);
            }
            return z16;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public synchronized boolean a(int i3, HardwareBuffer hardwareBuffer) {
            boolean z16;
            PAGDecoder pAGDecoder = this.f423784d;
            if (pAGDecoder != null && hardwareBuffer != null) {
                z16 = pAGDecoder.readFrame(i3, hardwareBuffer);
            }
            return z16;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public synchronized boolean a(Bitmap bitmap, int i3) {
            boolean z16;
            PAGDecoder pAGDecoder = this.f423784d;
            if (pAGDecoder != null && bitmap != null) {
                z16 = pAGDecoder.copyFrameTo(bitmap, i3);
            }
            return z16;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public synchronized boolean a(PAGComposition pAGComposition, int i3, int i16, float f16) {
            float f17;
            int height;
            if (pAGComposition == null || i3 <= 0 || i16 <= 0 || f16 <= 0.0f) {
                return false;
            }
            if (pAGComposition.width() >= pAGComposition.height()) {
                f17 = i3 * 1.0f;
                height = pAGComposition.width();
            } else {
                f17 = i16 * 1.0f;
                height = pAGComposition.height();
            }
            PAGDecoder Make = PAGDecoder.Make(pAGComposition, f16, f17 / height);
            this.f423784d = Make;
            this.f423781a = Make.width();
            this.f423782b = this.f423784d.height();
            this.f423783c = pAGComposition.duration();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static double a(int i3, int i16) {
        if (i16 <= 1 || i3 < 0) {
            return 0.0d;
        }
        if (i3 >= i16 - 1) {
            return 1.0d;
        }
        return ((i3 * 1.0d) + 0.1d) / i16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Matrix a(int i3, int i16, int i17, int i18, int i19) {
        Matrix matrix = new Matrix();
        if (i3 != 0 && i16 > 0 && i17 > 0 && i18 > 0 && i19 > 0) {
            float f16 = i18;
            float f17 = i16;
            float f18 = (f16 * 1.0f) / f17;
            float f19 = i19;
            float f26 = i17;
            float f27 = (1.0f * f19) / f26;
            if (i3 == 1) {
                matrix.setScale(f18, f27);
            } else if (i3 != 3) {
                float min = Math.min(f18, f27);
                matrix.setScale(min, min);
                if (f18 < f27) {
                    matrix.postTranslate(0.0f, (f19 - (f26 * min)) * 0.5f);
                } else {
                    matrix.postTranslate((f16 - (f17 * min)) * 0.5f, 0.0f);
                }
            } else {
                float max = Math.max(f18, f27);
                matrix.setScale(max, max);
                if (f18 > f27) {
                    matrix.postTranslate(0.0f, (f19 - (f26 * max)) * 0.5f);
                } else {
                    matrix.postTranslate((f16 - (f17 * max)) * 0.5f, 0.0f);
                }
            }
        }
        return matrix;
    }

    private static double a(double d16, double d17) {
        return d16 - (((int) Math.floor(d16 / d17)) * d17);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int a(double d16, int i3) {
        if (i3 <= 1) {
            return 0;
        }
        double a16 = a(d16, 1.0d);
        if (a16 <= 0.0d && d16 != 0.0d) {
            a16 += 1.0d;
        }
        int floor = (int) Math.floor(a16 * i3);
        return floor == i3 ? i3 - 1 : floor;
    }
}
