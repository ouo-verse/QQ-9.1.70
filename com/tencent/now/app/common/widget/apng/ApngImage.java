package com.tencent.now.app.common.widget.apng;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.component.core.log.LogUtil;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.RejectedExecutionException;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ApngImage implements Runnable {

    /* renamed from: t0, reason: collision with root package name */
    private static Handler f337939t0;

    /* renamed from: v0, reason: collision with root package name */
    private static ArgumentsRunnable<WeakReference<ApngImage>> f337941v0;

    /* renamed from: b0, reason: collision with root package name */
    private byte[] f337943b0;

    /* renamed from: c0, reason: collision with root package name */
    private byte[] f337944c0;

    /* renamed from: d, reason: collision with root package name */
    private CRC32 f337945d;

    /* renamed from: d0, reason: collision with root package name */
    private byte[] f337946d0;

    /* renamed from: e, reason: collision with root package name */
    private byte[] f337947e;

    /* renamed from: f, reason: collision with root package name */
    private int[] f337949f;

    /* renamed from: g0, reason: collision with root package name */
    protected RandomAccessFile f337951g0;

    /* renamed from: h, reason: collision with root package name */
    private int f337952h;

    /* renamed from: i, reason: collision with root package name */
    private int f337954i;

    /* renamed from: i0, reason: collision with root package name */
    public Bitmap f337955i0;

    /* renamed from: j0, reason: collision with root package name */
    private Bitmap f337956j0;

    /* renamed from: k0, reason: collision with root package name */
    private Bitmap f337957k0;

    /* renamed from: l0, reason: collision with root package name */
    protected long f337958l0;

    /* renamed from: m, reason: collision with root package name */
    private int f337959m;

    /* renamed from: m0, reason: collision with root package name */
    protected int f337960m0;

    /* renamed from: q0, reason: collision with root package name */
    private boolean f337964q0;

    /* renamed from: r0, reason: collision with root package name */
    private static final byte[] f337937r0 = {-119, 80, 78, 71, 13, 10, 26, 10};

    /* renamed from: s0, reason: collision with root package name */
    protected static boolean f337938s0 = false;

    /* renamed from: u0, reason: collision with root package name */
    protected static final ArrayList<WeakReference<ApngImage>> f337940u0 = new ArrayList<WeakReference<ApngImage>>(105) { // from class: com.tencent.now.app.common.widget.apng.ApngImage.1
        private void d() {
            if (size() > 100) {
                removeRange(0, (r0 - 100) - 1);
            }
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean add(WeakReference<ApngImage> weakReference) {
            boolean add = super.add((AnonymousClass1) weakReference);
            d();
            return add;
        }
    };
    private int C = 0;
    private int D = 0;
    private int E = 0;
    private int F = 0;
    private int G = 0;
    private int H = 0;
    private int I = 0;
    private int J = 0;
    private int K = 0;
    private int L = 0;
    private int M = 0;
    private int N = 0;
    private int P = 0;
    private int Q = 0;
    private int R = 0;
    private int S = 0;
    private int T = 0;
    private int U = 0;
    private int V = 0;
    private int W = 0;
    private int X = 0;
    private int Y = 0;
    private int Z = 0;

    /* renamed from: a0, reason: collision with root package name */
    private int f337942a0 = 0;

    /* renamed from: e0, reason: collision with root package name */
    private Paint f337948e0 = new Paint();

    /* renamed from: f0, reason: collision with root package name */
    private Paint f337950f0 = new Paint();

    /* renamed from: h0, reason: collision with root package name */
    private boolean f337953h0 = false;

    /* renamed from: n0, reason: collision with root package name */
    private Vector<WeakReference<com.tencent.now.app.common.widget.apng.a>> f337961n0 = new Vector<>();

    /* renamed from: o0, reason: collision with root package name */
    protected boolean f337962o0 = false;

    /* renamed from: p0, reason: collision with root package name */
    private boolean f337963p0 = true;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private class DoAccumulativeRunnable extends ArgumentsRunnable<WeakReference<ApngImage>> {

        /* renamed from: e, reason: collision with root package name */
        private long f337965e = 0;

        DoAccumulativeRunnable() {
        }

        @Override // com.tencent.now.app.common.widget.apng.ArgumentsRunnable
        protected void f(List<WeakReference<ApngImage>> list) {
            ApngImage apngImage;
            for (WeakReference<ApngImage> weakReference : list) {
                if (weakReference != null && (apngImage = weakReference.get()) != null) {
                    apngImage.m();
                }
            }
            this.f337965e = SystemClock.uptimeMillis();
        }

        @Override // com.tencent.now.app.common.widget.apng.ArgumentsRunnable
        protected void g() {
            long uptimeMillis = SystemClock.uptimeMillis();
            long j3 = this.f337965e;
            if (j3 != 0 && uptimeMillis - j3 <= 100) {
                ApngImage.f337939t0.postDelayed(this, 100 - (uptimeMillis - this.f337965e));
            } else {
                run();
                this.f337965e = uptimeMillis;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a extends AsyncTask<Void, Void, Object> {

        /* renamed from: a, reason: collision with root package name */
        long f337966a;

        public a(long j3) {
            this.f337966a = j3;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object doInBackground(Void... voidArr) {
            try {
                ApngImage.this.A(ApngImage.this.t(), this.f337966a);
                return null;
            } catch (Throwable th5) {
                return th5;
            }
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            ApngImage.this.y();
        }

        @Override // android.os.AsyncTask
        protected void onPostExecute(Object obj) {
            if (obj instanceof Throwable) {
                ApngImage.this.z((Throwable) obj);
            }
        }
    }

    public ApngImage(File file, boolean z16) throws IOException {
        try {
            this.f337951g0 = new RandomAccessFile(file, "r");
            w(z16);
        } catch (IOException e16) {
            RandomAccessFile randomAccessFile = this.f337951g0;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (Exception unused) {
                    LogUtil.e("ApngImage", "ApngImage error1:" + e16, new Object[0]);
                }
            }
            throw e16;
        }
    }

    private void B() throws IOException {
        F(this.f337947e, 0, 8);
        this.f337952h = J(this.f337947e, 0);
        this.f337954i = J(this.f337947e, 4);
        this.f337959m = this.f337952h;
        this.f337945d.reset();
        this.f337945d.update(this.f337947e, 4, 4);
    }

    private void C(int i3) throws IOException {
        B();
        if (this.f337954i == i3) {
            return;
        }
        throw new IOException("Expected chunk: " + Integer.toHexString(i3));
    }

    private int D(byte[] bArr, int i3, int i16) throws IOException {
        int i17 = this.f337959m;
        if (i16 > i17) {
            i16 = i17;
        }
        F(bArr, i3, i16);
        this.f337945d.update(bArr, i3, i16);
        this.f337959m -= i16;
        return i16;
    }

    private void E(Inflater inflater, byte[] bArr, int i3, int i16, int i17) throws IOException {
        do {
            try {
                int inflate = inflater.inflate(bArr, i3, i16);
                if (inflate <= 0) {
                    if (!inflater.finished()) {
                        if (inflater.needsInput()) {
                            Q(inflater, i17);
                        } else {
                            throw new IOException("Can't inflate " + i16 + " bytes");
                        }
                    } else {
                        throw new EOFException();
                    }
                } else {
                    i3 += inflate;
                    i16 -= inflate;
                }
            } catch (DataFormatException e16) {
                throw ((IOException) new IOException("inflate error").initCause(e16));
            }
        } while (i16 > 0);
    }

    private void F(byte[] bArr, int i3, int i16) throws IOException {
        do {
            int read = this.f337951g0.read(bArr, i3, i16);
            if (read < 0 && read != -1) {
                throw new EOFException();
            }
            i3 += read;
            i16 -= read;
        } while (i16 > 0);
    }

    private void G() throws IOException {
        Bitmap createBitmap = Bitmap.createBitmap(Bitmap.createBitmap(l(1229209940, this.W, this.X), this.W, this.X, Bitmap.Config.ARGB_8888));
        this.f337957k0 = createBitmap;
        if (this.f337964q0) {
            this.f337955i0 = createBitmap;
        }
    }

    private void I() throws IOException {
        i(13);
        D(this.f337947e, 0, 13);
        this.W = J(this.f337947e, 0);
        int J = J(this.f337947e, 4);
        this.X = J;
        byte[] bArr = this.f337947e;
        int i3 = bArr[8] & 255;
        this.Y = i3;
        int i16 = bArr[9] & 255;
        this.Z = i16;
        this.f337949f = new int[this.W * J];
        if (i16 != 0) {
            if (i16 != 6) {
                if (i16 != 2) {
                    if (i16 != 3) {
                        if (i16 == 4) {
                            if (i3 == 8) {
                                this.f337942a0 = 2;
                            } else {
                                throw new IOException("Unsupported bit depth: " + this.Y);
                            }
                        } else {
                            throw new IOException("unsupported color format: " + this.Z);
                        }
                    } else {
                        if (i3 != 1 && i3 != 2 && i3 != 4 && i3 != 8) {
                            throw new IOException("Unsupported bit depth: " + this.Y);
                        }
                        this.f337942a0 = 1;
                    }
                } else if (i3 == 8) {
                    this.f337942a0 = 3;
                } else {
                    throw new IOException("Unsupported bit depth: " + this.Y);
                }
            } else if (i3 == 8) {
                this.f337942a0 = 4;
            } else {
                throw new IOException("Unsupported bit depth: " + this.Y);
            }
        } else if (i3 == 8) {
            this.f337942a0 = 1;
        } else {
            throw new IOException("Unsupported bit depth: " + this.Y);
        }
        if (bArr[10] == 0) {
            if (bArr[11] == 0) {
                if (bArr[12] == 0) {
                    return;
                } else {
                    throw new IOException("unsupported interlace method");
                }
            }
            throw new IOException("unsupported filtering method");
        }
        throw new IOException("unsupported compression method");
    }

    private int J(byte[] bArr, int i3) {
        return (bArr[i3 + 3] & 255) | (bArr[i3] << 24) | ((bArr[i3 + 1] & 255) << 16) | ((bArr[i3 + 2] & 255) << 8);
    }

    private void K() throws IOException {
        int i3 = this.f337952h;
        int i16 = i3 / 3;
        if (i16 >= 1 && i16 <= 256 && i3 % 3 == 0) {
            byte[] bArr = new byte[i16 * 3];
            this.f337943b0 = bArr;
            D(bArr, 0, bArr.length);
            return;
        }
        throw new IOException("PLTE chunk has wrong length");
    }

    private int L(byte[] bArr, int i3) {
        return (bArr[i3 + 1] & 255) | (bArr[i3] << 8);
    }

    private void M() throws IOException {
        this.f337958l0 = this.f337951g0.getFilePointer();
        i(8);
        D(this.f337947e, 0, 8);
        int J = J(this.f337947e, 0);
        this.C = J;
        if (J == 1) {
            this.f337953h0 = true;
        }
        this.D = J(this.f337947e, 4);
    }

    private void N() throws IOException {
        i(26);
        D(this.f337947e, 0, 26);
        this.N = J(this.f337947e, 4);
        this.P = J(this.f337947e, 8);
        this.Q = J(this.f337947e, 12);
        this.R = J(this.f337947e, 16);
        this.S = L(this.f337947e, 20);
        int L = L(this.f337947e, 22);
        this.T = L;
        byte[] bArr = this.f337947e;
        this.U = bArr[24];
        this.V = bArr[25];
        if (L == 0) {
            this.E = 100;
        } else {
            this.E = (this.S * 1000) / L;
        }
    }

    private void O() throws IOException {
        D(this.f337947e, 0, 4);
        int[] l3 = l(1717846356, this.N, this.P);
        Bitmap createBitmap = Bitmap.createBitmap(l3, this.N, this.P, Bitmap.Config.ARGB_8888);
        Bitmap copy = this.f337956j0.copy(Bitmap.Config.ARGB_8888, true);
        int i3 = this.U;
        if (i3 != 0 && i3 != 1 && i3 != 2) {
            throw new IOException("Incorrect frame dispose: " + Integer.toHexString(this.U));
        }
        int[] iArr = this.f337949f;
        int i16 = this.F;
        copy.getPixels(iArr, 0, i16, this.H, this.I, i16, this.G);
        int i17 = this.V;
        if (i17 == 0) {
            int i18 = this.U;
            if (i18 == 0) {
                int i19 = this.L;
                if (i19 == 1) {
                    int[] iArr2 = new int[this.F * this.G];
                    Arrays.fill(iArr2, 0);
                    int i26 = this.F;
                    copy.setPixels(iArr2, 0, i26, this.H, this.I, i26, this.G);
                } else if (i19 == 2) {
                    int[] iArr3 = this.f337949f;
                    int i27 = this.F;
                    copy.setPixels(iArr3, 0, i27, this.H, this.I, i27, this.G);
                }
            } else if (i18 == 1) {
                int[] iArr4 = new int[this.F * this.G];
                Arrays.fill(iArr4, 0);
                int i28 = this.F;
                copy.setPixels(iArr4, 0, i28, this.H, this.I, i28, this.G);
            } else if (i18 == 2 && this.L == 1) {
                int[] iArr5 = new int[this.F * this.G];
                Arrays.fill(iArr5, 0);
                int i29 = this.F;
                copy.setPixels(iArr5, 0, i29, this.H, this.I, i29, this.G);
            }
            int i36 = this.N;
            copy.setPixels(l3, 0, i36, this.Q, this.R, i36, this.P);
        } else if (i17 == 1) {
            int i37 = this.U;
            if (i37 == 0) {
                new Canvas(copy).drawBitmap(createBitmap, this.Q, this.R, this.f337948e0);
            } else if (i37 == 1) {
                Arrays.fill(l3, 0);
                int i38 = this.N;
                copy.setPixels(l3, 0, i38, this.Q, this.R, i38, this.P);
                new Canvas(copy).drawBitmap(createBitmap, this.Q, this.R, this.f337948e0);
            } else if (i37 == 2) {
                new Canvas(copy).drawBitmap(createBitmap, this.Q, this.R, this.f337948e0);
            }
        }
        new Canvas(copy).drawBitmap(createBitmap, this.Q, this.R, this.f337948e0);
        this.f337957k0 = Bitmap.createBitmap(copy);
    }

    private void P() throws IOException {
        int i3 = this.Z;
        if (i3 != 0) {
            if (i3 != 2) {
                if (i3 == 3) {
                    byte[] bArr = this.f337943b0;
                    if (bArr != null) {
                        byte[] bArr2 = new byte[bArr.length / 3];
                        this.f337944c0 = bArr2;
                        Arrays.fill(bArr2, (byte) -1);
                        byte[] bArr3 = this.f337944c0;
                        D(bArr3, 0, bArr3.length);
                        return;
                    }
                    throw new IOException("tRNS chunk without PLTE chunk");
                }
                return;
            }
            i(6);
            byte[] bArr4 = new byte[6];
            this.f337946d0 = bArr4;
            D(bArr4, 0, 6);
            return;
        }
        i(2);
        byte[] bArr5 = new byte[2];
        this.f337946d0 = bArr5;
        D(bArr5, 0, 2);
    }

    private void Q(Inflater inflater, int i3) throws IOException {
        int i16 = 0;
        while (this.f337959m == 0) {
            k();
            C(i3);
            if (i3 == 1717846356) {
                i16 = 4;
            }
        }
        byte[] bArr = this.f337947e;
        inflater.setInput(this.f337947e, i16, D(bArr, 0, bArr.length) - i16);
    }

    public static int S(int i3, int i16, int i17) {
        if (i16 != 0 && i16 != i17) {
            return ((i3 * i17) + (i16 >> 1)) / i16;
        }
        return i3;
    }

    private void T(byte[] bArr, byte[] bArr2) throws IOException {
        byte b16 = bArr[0];
        if (b16 != 0) {
            if (b16 != 1) {
                if (b16 != 2) {
                    if (b16 != 3) {
                        if (b16 == 4) {
                            V(bArr, bArr2);
                            return;
                        }
                        throw new IOException("invalide filter type in scanline: " + ((int) bArr[0]));
                    }
                    U(bArr, bArr2);
                    return;
                }
                X(bArr, bArr2);
                return;
            }
            W(bArr);
        }
    }

    private void U(byte[] bArr, byte[] bArr2) {
        int i3 = this.f337942a0;
        int i16 = 1;
        while (i16 <= i3) {
            bArr[i16] = (byte) (bArr[i16] + ((byte) ((bArr2[i16] & 255) >>> 1)));
            i16++;
        }
        int length = bArr.length;
        while (i16 < length) {
            bArr[i16] = (byte) (bArr[i16] + ((byte) (((bArr2[i16] & 255) + (bArr[i16 - i3] & 255)) >>> 1)));
            i16++;
        }
    }

    private void V(byte[] bArr, byte[] bArr2) {
        int i3 = this.f337942a0;
        int i16 = 1;
        while (i16 <= i3) {
            bArr[i16] = (byte) (bArr[i16] + bArr2[i16]);
            i16++;
        }
        int length = bArr.length;
        while (i16 < length) {
            int i17 = i16 - i3;
            int i18 = bArr[i17] & 255;
            int i19 = bArr2[i16] & 255;
            int i26 = bArr2[i17] & 255;
            int i27 = (i18 + i19) - i26;
            int i28 = i27 - i18;
            if (i28 < 0) {
                i28 = -i28;
            }
            int i29 = i27 - i19;
            if (i29 < 0) {
                i29 = -i29;
            }
            int i36 = i27 - i26;
            if (i36 < 0) {
                i36 = -i36;
            }
            if (i28 > i29 || i28 > i36) {
                if (i29 <= i36) {
                    i18 = i19;
                } else {
                    i18 = i26;
                }
            }
            bArr[i16] = (byte) (bArr[i16] + ((byte) i18));
            i16++;
        }
    }

    private void W(byte[] bArr) {
        int i3 = this.f337942a0;
        int length = bArr.length;
        for (int i16 = i3 + 1; i16 < length; i16++) {
            bArr[i16] = (byte) (bArr[i16] + bArr[i16 - i3]);
        }
    }

    private void X(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        for (int i3 = 1; i3 < length; i3++) {
            bArr[i3] = (byte) (bArr[i3] + bArr2[i3]);
        }
    }

    private int h(byte b16, byte b17, byte b18, byte b19) {
        return (b16 << 24) | ((b17 & 255) << 16) | ((b18 & 255) << 8) | (b19 & 255);
    }

    private void i(int i3) throws IOException {
        if (this.f337952h == i3) {
        } else {
            throw new IOException("Chunk has wrong size");
        }
    }

    private static boolean j(byte[] bArr) {
        int i3 = 0;
        while (true) {
            byte[] bArr2 = f337937r0;
            if (i3 < bArr2.length) {
                if (bArr[i3] != bArr2[i3]) {
                    return false;
                }
                i3++;
            } else {
                return true;
            }
        }
    }

    private void k() throws IOException {
        if (this.f337959m > 0) {
            RandomAccessFile randomAccessFile = this.f337951g0;
            randomAccessFile.seek(randomAccessFile.getFilePointer() + this.f337959m + 4);
        } else {
            F(this.f337947e, 0, 4);
            if (((int) this.f337945d.getValue()) != J(this.f337947e, 0)) {
                throw new IOException("Invalid CRC");
            }
        }
        this.f337959m = 0;
        this.f337952h = 0;
        this.f337954i = 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x000e. Please report as an issue. */
    private void p(byte[] bArr, byte[] bArr2) {
        int length = bArr2.length;
        for (int i3 = 1; i3 < length; i3 += 8) {
            int i16 = bArr[(i3 >> 3) + 1] & 255;
            switch (length - i3) {
                case 1:
                    break;
                case 2:
                    bArr2[i3 + 1] = (byte) ((i16 >> 6) & 1);
                    break;
                case 3:
                    bArr2[i3 + 2] = (byte) ((i16 >> 5) & 1);
                    bArr2[i3 + 1] = (byte) ((i16 >> 6) & 1);
                    break;
                case 4:
                    bArr2[i3 + 3] = (byte) ((i16 >> 4) & 1);
                    bArr2[i3 + 2] = (byte) ((i16 >> 5) & 1);
                    bArr2[i3 + 1] = (byte) ((i16 >> 6) & 1);
                    break;
                case 5:
                    bArr2[i3 + 4] = (byte) ((i16 >> 3) & 1);
                    bArr2[i3 + 3] = (byte) ((i16 >> 4) & 1);
                    bArr2[i3 + 2] = (byte) ((i16 >> 5) & 1);
                    bArr2[i3 + 1] = (byte) ((i16 >> 6) & 1);
                    break;
                case 6:
                    bArr2[i3 + 5] = (byte) ((i16 >> 2) & 1);
                    bArr2[i3 + 4] = (byte) ((i16 >> 3) & 1);
                    bArr2[i3 + 3] = (byte) ((i16 >> 4) & 1);
                    bArr2[i3 + 2] = (byte) ((i16 >> 5) & 1);
                    bArr2[i3 + 1] = (byte) ((i16 >> 6) & 1);
                    break;
                case 7:
                    bArr2[i3 + 6] = (byte) ((i16 >> 1) & 1);
                    bArr2[i3 + 5] = (byte) ((i16 >> 2) & 1);
                    bArr2[i3 + 4] = (byte) ((i16 >> 3) & 1);
                    bArr2[i3 + 3] = (byte) ((i16 >> 4) & 1);
                    bArr2[i3 + 2] = (byte) ((i16 >> 5) & 1);
                    bArr2[i3 + 1] = (byte) ((i16 >> 6) & 1);
                    break;
                default:
                    bArr2[i3 + 7] = (byte) (i16 & 1);
                    bArr2[i3 + 6] = (byte) ((i16 >> 1) & 1);
                    bArr2[i3 + 5] = (byte) ((i16 >> 2) & 1);
                    bArr2[i3 + 4] = (byte) ((i16 >> 3) & 1);
                    bArr2[i3 + 3] = (byte) ((i16 >> 4) & 1);
                    bArr2[i3 + 2] = (byte) ((i16 >> 5) & 1);
                    bArr2[i3 + 1] = (byte) ((i16 >> 6) & 1);
                    break;
            }
            bArr2[i3] = (byte) (i16 >> 7);
        }
    }

    private void q(byte[] bArr, byte[] bArr2) {
        int length = bArr2.length;
        for (int i3 = 1; i3 < length; i3 += 4) {
            int i16 = bArr[(i3 >> 2) + 1] & 255;
            int i17 = length - i3;
            if (i17 != 1) {
                if (i17 != 2) {
                    if (i17 != 3) {
                        bArr2[i3 + 3] = (byte) (i16 & 3);
                    }
                    bArr2[i3 + 2] = (byte) ((i16 >> 2) & 3);
                }
                bArr2[i3 + 1] = (byte) ((i16 >> 4) & 3);
            }
            bArr2[i3] = (byte) (i16 >> 6);
        }
    }

    private void r(byte[] bArr, byte[] bArr2) {
        int length = bArr2.length;
        for (int i3 = 1; i3 < length; i3 += 2) {
            int i16 = bArr[(i3 >> 1) + 1] & 255;
            if (length - i3 != 1) {
                bArr2[i3 + 1] = (byte) (i16 & 15);
            }
            bArr2[i3] = (byte) (i16 >> 4);
        }
    }

    private void w(boolean z16) throws IOException {
        this.f337945d = new CRC32();
        this.f337947e = new byte[4096];
        this.f337948e0.setAntiAlias(true);
        this.f337950f0.setAntiAlias(true);
        this.f337950f0.setColor(0);
        F(this.f337947e, 0, f337937r0.length);
        if (j(this.f337947e)) {
            this.f337964q0 = z16;
            try {
                t();
                g();
            } catch (Exception e16) {
                LogUtil.printStackTrace(e16);
            }
            if (z16) {
                this.f337955i0 = this.f337956j0;
            }
            if (this.f337953h0) {
                this.f337955i0 = this.f337956j0;
                this.f337957k0 = null;
                return;
            }
            return;
        }
        throw new IOException("Not a valid PNG file");
    }

    private void x() {
        int i3 = 0;
        while (i3 < this.f337961n0.size()) {
            WeakReference<com.tencent.now.app.common.widget.apng.a> weakReference = this.f337961n0.get(i3);
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().invalidateSelf();
            } else {
                this.f337961n0.remove(i3);
                i3--;
            }
            i3++;
        }
    }

    void A(boolean z16, long j3) {
        if (z16) {
            long uptimeMillis = SystemClock.uptimeMillis();
            if (uptimeMillis < j3) {
                f337939t0.postDelayed(this, j3 - uptimeMillis);
            } else {
                f337939t0.post(this);
            }
        }
    }

    public void R(com.tencent.now.app.common.widget.apng.a aVar) {
        int i3 = 0;
        while (i3 < this.f337961n0.size()) {
            WeakReference<com.tencent.now.app.common.widget.apng.a> weakReference = this.f337961n0.get(i3);
            if (weakReference != null && weakReference.get() != null) {
                if (weakReference.get() == aVar) {
                    this.f337961n0.remove(i3);
                    return;
                }
            } else {
                this.f337961n0.remove(i3);
                i3--;
            }
            i3++;
        }
    }

    public void f(com.tencent.now.app.common.widget.apng.a aVar) {
        if (aVar != null) {
            this.f337961n0.add(new WeakReference<>(aVar));
        }
    }

    public synchronized void g() {
        this.f337956j0 = this.f337957k0;
        this.F = this.N;
        this.G = this.P;
        this.H = this.Q;
        this.I = this.R;
        this.J = this.S;
        this.K = this.T;
        this.L = this.U;
        this.M = this.V;
        System.out.println("delay:" + this.E);
        this.f337960m0 = this.E;
    }

    public int[] l(int i3, int i16, int i17) throws IOException {
        byte[] bArr;
        int i18 = this.Y;
        int i19 = 8;
        int i26 = 1;
        int i27 = ((((i16 * i18) + 7) / 8) * this.f337942a0) + 1;
        byte[] bArr2 = new byte[i27];
        byte[] bArr3 = new byte[i27];
        if (i18 < 8) {
            bArr = new byte[i16 + 1];
        } else {
            bArr = null;
        }
        int[] iArr = new int[i16 * i17];
        Inflater inflater = new Inflater();
        byte[] bArr4 = bArr;
        byte[] bArr5 = bArr3;
        byte[] bArr6 = bArr2;
        int i28 = 0;
        int i29 = 0;
        while (i28 < i17) {
            try {
                int i36 = i28;
                E(inflater, bArr6, 0, bArr6.length, i3);
                T(bArr6, bArr5);
                int i37 = this.Z;
                if (i37 != 0) {
                    if (i37 != 6) {
                        byte b16 = -1;
                        if (i37 != 2) {
                            if (i37 != 3) {
                                if (i37 == 4) {
                                    int length = bArr6.length;
                                    int i38 = i26;
                                    while (i38 < length) {
                                        iArr[i29] = (bArr6[i38] * 65793) + (bArr6[i38 + 1] << 6);
                                        i38 += 2;
                                        i29++;
                                    }
                                } else {
                                    throw new UnsupportedOperationException("Not yet implemented");
                                }
                            } else {
                                int i39 = this.Y;
                                if (i39 != i26) {
                                    if (i39 != 2) {
                                        if (i39 != 4) {
                                            if (i39 == i19) {
                                                bArr4 = bArr6;
                                            } else {
                                                throw new UnsupportedOperationException("Unsupported bitdepth for this image");
                                            }
                                        } else {
                                            r(bArr6, bArr4);
                                        }
                                    } else {
                                        q(bArr6, bArr4);
                                    }
                                } else {
                                    p(bArr6, bArr4);
                                }
                                if (this.f337944c0 != null) {
                                    int length2 = bArr6.length;
                                    int i46 = i26;
                                    while (i46 < length2) {
                                        int i47 = bArr6[i46] & 255;
                                        byte[] bArr7 = this.f337943b0;
                                        int i48 = i47 * 3;
                                        byte b17 = bArr7[i48 + 0];
                                        byte b18 = bArr7[i48 + 1];
                                        byte b19 = bArr7[i48 + 2];
                                        iArr[i29] = h(this.f337944c0[i47], b17, b18, b19);
                                        i46++;
                                        i29++;
                                    }
                                } else {
                                    int length3 = bArr6.length;
                                    int i49 = i26;
                                    while (i49 < length3) {
                                        int i56 = bArr6[i49] & 255;
                                        byte[] bArr8 = this.f337943b0;
                                        int i57 = i56 * 3;
                                        iArr[i29] = h((byte) -1, bArr8[i57 + 0], bArr8[i57 + 1], bArr8[i57 + 2]);
                                        i49++;
                                        i29++;
                                    }
                                }
                            }
                        } else {
                            byte[] bArr9 = this.f337946d0;
                            if (bArr9 != null) {
                                byte b26 = bArr9[i26];
                                byte b27 = bArr9[3];
                                byte b28 = bArr9[5];
                                int length4 = bArr6.length;
                                int i58 = i26;
                                while (i58 < length4) {
                                    byte b29 = bArr6[i58];
                                    byte b36 = bArr6[i58 + 1];
                                    byte b37 = bArr6[i58 + 2];
                                    if (b29 == b26 && b36 == b27 && b37 == b28) {
                                        b16 = 0;
                                    }
                                    iArr[i29] = h(b16, b29, b36, b37);
                                    i58 += 3;
                                    i29++;
                                    b16 = -1;
                                }
                            } else {
                                int length5 = bArr6.length;
                                int i59 = 1;
                                while (i59 < length5) {
                                    iArr[i29] = h((byte) -1, bArr6[i59], bArr6[i59 + 1], bArr6[i59 + 2]);
                                    i59 += 3;
                                    i29++;
                                }
                            }
                        }
                    } else {
                        int length6 = bArr6.length;
                        int i65 = 1;
                        while (i65 < length6) {
                            iArr[i29] = h(bArr6[i65 + 3], bArr6[i65], bArr6[i65 + 1], bArr6[i65 + 2]);
                            i65 += 4;
                            i29++;
                        }
                    }
                } else {
                    int length7 = bArr6.length;
                    int i66 = 1;
                    while (i66 < length7) {
                        int i67 = i29 + 1;
                        iArr[i29] = bArr6[i66] * 65793;
                        i66++;
                        i29 = i67;
                    }
                }
                i28 = i36 + 1;
                i19 = 8;
                i26 = 1;
                byte[] bArr10 = bArr5;
                bArr5 = bArr6;
                bArr6 = bArr10;
            } finally {
                inflater.end();
            }
        }
        return iArr;
    }

    protected void m() {
        g();
        this.f337963p0 = true;
        if (!f337938s0) {
            x();
        } else if (!this.f337962o0) {
            f337940u0.add(new WeakReference<>(this));
            this.f337962o0 = true;
        }
    }

    public void n(Canvas canvas, Rect rect, Paint paint, boolean z16) {
        if (f337939t0 == null) {
            f337939t0 = new Handler();
            f337941v0 = new DoAccumulativeRunnable();
        }
        if (!this.f337953h0 && (z16 || this.f337955i0 == null)) {
            Bitmap bitmap = this.f337956j0;
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, (Rect) null, rect, paint);
            }
            if (!f337938s0) {
                o();
                return;
            } else {
                if (!this.f337962o0) {
                    f337940u0.add(new WeakReference<>(this));
                    this.f337962o0 = true;
                    return;
                }
                return;
            }
        }
        canvas.drawBitmap(this.f337955i0, (Rect) null, rect, paint);
    }

    protected void o() {
        if (this.f337963p0) {
            this.f337963p0 = false;
            try {
                c.a(new a(SystemClock.uptimeMillis() + s()), null);
            } catch (RejectedExecutionException e16) {
                LogUtil.e("ApngImage", "executeNewTask error:" + e16, new Object[0]);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        f337941v0.a(new WeakReference<>(this));
    }

    public int s() {
        System.out.println("currentFrameDelay:" + this.f337960m0);
        return this.f337960m0;
    }

    protected synchronized boolean t() throws IOException {
        for (int i3 = 0; i3 < 10000; i3++) {
            B();
            switch (this.f337954i) {
                case 1229209940:
                    G();
                    k();
                    return true;
                case 1229278788:
                    H();
                    this.f337951g0.seek(this.f337958l0 + 4);
                    break;
                case 1229472850:
                    I();
                    break;
                case 1347179589:
                    K();
                    break;
                case 1633899596:
                    M();
                    this.f337958l0 = this.f337951g0.getFilePointer();
                    break;
                case 1717785676:
                    N();
                    break;
                case 1717846356:
                    O();
                    k();
                    return true;
                case 1951551059:
                    P();
                    break;
            }
            if (this.f337954i != 1229278788) {
                k();
            }
        }
        if (this.Z == 3 && this.f337943b0 == null) {
            throw new IOException("Missing PLTE chunk");
        }
        return false;
    }

    public int u(int i3) {
        return S(this.X, 160, i3);
    }

    public int v(int i3) {
        return S(this.W, 160, i3);
    }

    void y() {
        this.f337963p0 = true;
    }

    void z(Throwable th5) {
        this.f337963p0 = true;
    }

    private void H() throws IOException {
    }
}
