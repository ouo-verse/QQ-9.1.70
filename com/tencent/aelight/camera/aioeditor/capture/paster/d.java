package com.tencent.aelight.camera.aioeditor.capture.paster;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.io.File;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes32.dex */
public class d implements Handler.Callback {
    private volatile long C;
    long D;
    int E;
    protected Bitmap F;
    protected Bitmap G;
    protected int H;
    private HandlerThread I;
    private Handler J;
    protected int K;

    /* renamed from: d, reason: collision with root package name */
    int[] f66855d = new int[7];

    /* renamed from: e, reason: collision with root package name */
    public int f66856e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f66857f = 0;

    /* renamed from: h, reason: collision with root package name */
    private int f66858h = 0;

    /* renamed from: i, reason: collision with root package name */
    private Paint f66859i = new Paint();

    /* renamed from: m, reason: collision with root package name */
    private Paint f66860m = new Paint();
    private long L = 0;
    private boolean M = false;

    public d(File file) {
        int i3;
        this.C = 0L;
        this.H = -1;
        if (file != null) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("gif_decode_thread");
            this.I = baseHandlerThread;
            baseHandlerThread.start();
            this.J = new Handler(this.I.getLooper(), this);
            this.f66859i.setAntiAlias(true);
            this.f66860m.setAntiAlias(true);
            this.f66860m.setColor(0);
            a(file);
            int i16 = this.f66856e;
            if (i16 > 0 && (i3 = this.f66857f) > 0) {
                try {
                    this.F = Bitmap.createBitmap(i16, i3, Bitmap.Config.ARGB_8888);
                    this.G = Bitmap.createBitmap(this.f66856e, this.f66857f, Bitmap.Config.ARGB_8888);
                } catch (OutOfMemoryError unused) {
                    URLDrawable.clearMemoryCache();
                    try {
                        this.F = Bitmap.createBitmap(this.f66856e, this.f66857f, Bitmap.Config.ARGB_8888);
                        this.G = Bitmap.createBitmap(this.f66856e, this.f66857f, Bitmap.Config.ARGB_8888);
                    } catch (OutOfMemoryError unused2) {
                        QLog.e("NativeApngDecoder", 1, "APNG create Bitmap OOM");
                    }
                }
            }
            this.C = ApngImage.nativeGetNextFrame(this.D, this.C, this.F, this.f66855d);
            int[] iArr = this.f66855d;
            if (iArr[5] == 0) {
                this.K = iArr[4];
            }
            this.H = 0;
            return;
        }
        throw new NullPointerException("Source is null");
    }

    private void a(File file) {
        this.D = ApngImage.nativeStartDecode(file.getAbsolutePath(), this.f66855d, this.E);
        int[] iArr = this.f66855d;
        if (iArr[5] == 0) {
            this.f66856e = iArr[0];
            this.f66857f = iArr[1];
            this.f66858h = iArr[2];
            if (QLog.isColorLevel()) {
                QLog.d("NativeApngDecoder", 2, "start decode success width = " + this.f66856e + " height = " + this.f66857f + " frameCount = " + this.f66858h);
                return;
            }
            return;
        }
        QLog.e("NativeApngDecoder", 1, "start decode error: " + this.f66855d[5]);
    }

    public Bitmap b(long j3) {
        Bitmap bitmap;
        long currentTimeMillis = System.currentTimeMillis();
        long j16 = this.K * 1000 * 1000;
        if (QLog.isColorLevel()) {
            QLog.d("NativeApngDecoder", 2, "getNextFrameBitmap| timestamp = " + j3);
        }
        long j17 = j3 - this.L;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getNextFrameBitmap| interval = ");
            sb5.append(j17 < j16);
            QLog.d("NativeApngDecoder", 2, sb5.toString());
        }
        if (j17 < j16) {
            if (!this.M) {
                Message obtain = Message.obtain();
                obtain.what = 2;
                obtain.arg1 = this.H;
                obtain.arg2 = 0;
                this.J.sendMessage(obtain);
            }
        } else if (this.M) {
            this.H = this.H == 0 ? 1 : 0;
            this.L = j3;
            this.M = false;
            Message obtain2 = Message.obtain();
            obtain2.what = 2;
            obtain2.arg1 = this.H;
            obtain2.arg2 = 1;
            this.J.sendMessage(obtain2);
        } else if (QLog.isColorLevel()) {
            QLog.e("NativeApngDecoder", 2, "getNextFrameBitmap| had not preLoad ");
        }
        int i3 = this.H;
        if (i3 == 0) {
            bitmap = this.F;
        } else {
            bitmap = i3 == 1 ? this.G : null;
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (QLog.isColorLevel()) {
            QLog.d("NativeApngDecoder", 2, "getNextFrameBitmap| gifTime= " + j16 + ",cost=" + currentTimeMillis2);
        }
        return bitmap;
    }

    protected void finalize() throws Throwable {
        if (this.C != 0) {
            ApngImage.nativeFreeFrame(this.C);
        }
        long j3 = this.D;
        if (j3 != 0) {
            ApngImage.nativeFreeImage(j3);
        }
        super.finalize();
    }

    public String toString() {
        return String.format(Locale.US, "Size: %dx%d, %d frames, error: %d", Integer.valueOf(this.f66855d[0]), Integer.valueOf(this.f66855d[1]), Integer.valueOf(this.f66855d[2]), Integer.valueOf(this.f66855d[3]));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3 = message.what;
        if (i3 == 1) {
            int i16 = this.H;
            if (i16 == -1 || i16 == 1) {
                this.C = ApngImage.nativeGetNextFrame(this.D, this.C, this.F, this.f66855d);
                this.H = 0;
            } else if (i16 == 0) {
                this.C = ApngImage.nativeGetNextFrame(this.D, this.C, this.G, this.f66855d);
                this.H = 1;
            }
        } else if (i3 == 2) {
            long currentTimeMillis = System.currentTimeMillis();
            int i17 = message.arg1;
            int i18 = message.arg2;
            if (QLog.isColorLevel()) {
                QLog.d("NativeApngDecoder", 2, "getNextFrameBitmap| PRE_LOAD_FRAME Begin + type:" + i18);
            }
            if (i17 == 0) {
                this.C = ApngImage.nativeGetNextFrame(this.D, this.C, this.G, this.f66855d);
            } else if (i17 == 1) {
                this.C = ApngImage.nativeGetNextFrame(this.D, this.C, this.F, this.f66855d);
            }
            int[] iArr = this.f66855d;
            if (iArr[5] == 0) {
                this.K = iArr[4];
            } else if (QLog.isColorLevel()) {
                QLog.d("NativeApngDecoder", 2, "getNextFrameBitmap|error");
            }
            this.M = true;
            int i19 = this.f66855d[3];
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (QLog.isColorLevel()) {
                QLog.d("NativeApngDecoder", 2, "getNextFrameBitmap| PRE_LOAD_FRAME END curIndex= " + i19 + ", cost=" + currentTimeMillis2);
            }
        }
        return false;
    }
}
