package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.gifdecoder.GifDecoder;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes.dex */
public class d implements GifDecoder {

    /* renamed from: u, reason: collision with root package name */
    private static final String f31531u = "d";

    /* renamed from: a, reason: collision with root package name */
    @ColorInt
    private int[] f31532a;

    /* renamed from: b, reason: collision with root package name */
    @ColorInt
    private final int[] f31533b;

    /* renamed from: c, reason: collision with root package name */
    private final GifDecoder.a f31534c;

    /* renamed from: d, reason: collision with root package name */
    private ByteBuffer f31535d;

    /* renamed from: e, reason: collision with root package name */
    private byte[] f31536e;

    /* renamed from: f, reason: collision with root package name */
    private short[] f31537f;

    /* renamed from: g, reason: collision with root package name */
    private byte[] f31538g;

    /* renamed from: h, reason: collision with root package name */
    private byte[] f31539h;

    /* renamed from: i, reason: collision with root package name */
    private byte[] f31540i;

    /* renamed from: j, reason: collision with root package name */
    @ColorInt
    private int[] f31541j;

    /* renamed from: k, reason: collision with root package name */
    private int f31542k;

    /* renamed from: l, reason: collision with root package name */
    private b f31543l;

    /* renamed from: m, reason: collision with root package name */
    private Bitmap f31544m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f31545n;

    /* renamed from: o, reason: collision with root package name */
    private int f31546o;

    /* renamed from: p, reason: collision with root package name */
    private int f31547p;

    /* renamed from: q, reason: collision with root package name */
    private int f31548q;

    /* renamed from: r, reason: collision with root package name */
    private int f31549r;

    /* renamed from: s, reason: collision with root package name */
    @Nullable
    private Boolean f31550s;

    /* renamed from: t, reason: collision with root package name */
    @NonNull
    private Bitmap.Config f31551t;

    public d(@NonNull GifDecoder.a aVar, b bVar, ByteBuffer byteBuffer, int i3) {
        this(aVar);
        l(bVar, byteBuffer, i3);
    }

    @ColorInt
    private int d(int i3, int i16, int i17) {
        int i18 = 0;
        int i19 = 0;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        for (int i29 = i3; i29 < this.f31547p + i3; i29++) {
            byte[] bArr = this.f31540i;
            if (i29 >= bArr.length || i29 >= i16) {
                break;
            }
            int i36 = this.f31532a[bArr[i29] & 255];
            if (i36 != 0) {
                i18 += (i36 >> 24) & 255;
                i19 += (i36 >> 16) & 255;
                i26 += (i36 >> 8) & 255;
                i27 += i36 & 255;
                i28++;
            }
        }
        int i37 = i3 + i17;
        for (int i38 = i37; i38 < this.f31547p + i37; i38++) {
            byte[] bArr2 = this.f31540i;
            if (i38 >= bArr2.length || i38 >= i16) {
                break;
            }
            int i39 = this.f31532a[bArr2[i38] & 255];
            if (i39 != 0) {
                i18 += (i39 >> 24) & 255;
                i19 += (i39 >> 16) & 255;
                i26 += (i39 >> 8) & 255;
                i27 += i39 & 255;
                i28++;
            }
        }
        if (i28 == 0) {
            return 0;
        }
        return ((i18 / i28) << 24) | ((i19 / i28) << 16) | ((i26 / i28) << 8) | (i27 / i28);
    }

    private void e(a aVar) {
        boolean z16;
        boolean booleanValue;
        int i3;
        int i16;
        boolean z17;
        int i17;
        int i18;
        int i19;
        int[] iArr = this.f31541j;
        int i26 = aVar.f31506d;
        int i27 = this.f31547p;
        int i28 = i26 / i27;
        int i29 = aVar.f31504b / i27;
        int i36 = aVar.f31505c / i27;
        int i37 = aVar.f31503a / i27;
        if (this.f31542k == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i38 = this.f31549r;
        int i39 = this.f31548q;
        byte[] bArr = this.f31540i;
        int[] iArr2 = this.f31532a;
        Boolean bool = this.f31550s;
        int i46 = 8;
        int i47 = 0;
        int i48 = 0;
        int i49 = 1;
        while (i48 < i28) {
            Boolean bool2 = bool;
            if (aVar.f31507e) {
                if (i47 >= i28) {
                    int i56 = i49 + 1;
                    i3 = i28;
                    if (i56 != 2) {
                        if (i56 != 3) {
                            if (i56 == 4) {
                                i49 = i56;
                                i47 = 1;
                                i46 = 2;
                            }
                        } else {
                            i46 = 4;
                            i49 = i56;
                            i47 = 2;
                        }
                    } else {
                        i47 = 4;
                    }
                    i49 = i56;
                } else {
                    i3 = i28;
                }
                i16 = i47 + i46;
            } else {
                i3 = i28;
                i16 = i47;
                i47 = i48;
            }
            int i57 = i47 + i29;
            if (i27 == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (i57 < i39) {
                int i58 = i57 * i38;
                int i59 = i58 + i37;
                int i65 = i59 + i36;
                int i66 = i58 + i38;
                if (i66 < i65) {
                    i65 = i66;
                }
                i17 = i16;
                int i67 = i48 * i27 * aVar.f31505c;
                if (z17) {
                    int i68 = i59;
                    while (i68 < i65) {
                        int i69 = i29;
                        int i75 = iArr2[bArr[i67] & 255];
                        if (i75 != 0) {
                            iArr[i68] = i75;
                        } else if (z16 && bool2 == null) {
                            bool2 = Boolean.TRUE;
                        }
                        i67 += i27;
                        i68++;
                        i29 = i69;
                    }
                } else {
                    i19 = i29;
                    int i76 = ((i65 - i59) * i27) + i67;
                    int i77 = i59;
                    while (true) {
                        i18 = i36;
                        if (i77 < i65) {
                            int d16 = d(i67, i76, aVar.f31505c);
                            if (d16 != 0) {
                                iArr[i77] = d16;
                            } else if (z16 && bool2 == null) {
                                bool2 = Boolean.TRUE;
                            }
                            i67 += i27;
                            i77++;
                            i36 = i18;
                        }
                    }
                    bool = bool2;
                    i48++;
                    i29 = i19;
                    i28 = i3;
                    i36 = i18;
                    i47 = i17;
                }
            } else {
                i17 = i16;
            }
            i19 = i29;
            i18 = i36;
            bool = bool2;
            i48++;
            i29 = i19;
            i28 = i3;
            i36 = i18;
            i47 = i17;
        }
        Boolean bool3 = bool;
        if (this.f31550s == null) {
            if (bool3 == null) {
                booleanValue = false;
            } else {
                booleanValue = bool3.booleanValue();
            }
            this.f31550s = Boolean.valueOf(booleanValue);
        }
    }

    private void f(a aVar) {
        boolean z16;
        boolean z17;
        a aVar2 = aVar;
        int[] iArr = this.f31541j;
        int i3 = aVar2.f31506d;
        int i16 = aVar2.f31504b;
        int i17 = aVar2.f31505c;
        int i18 = aVar2.f31503a;
        if (this.f31542k == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i19 = this.f31549r;
        byte[] bArr = this.f31540i;
        int[] iArr2 = this.f31532a;
        int i26 = 0;
        byte b16 = -1;
        while (i26 < i3) {
            int i27 = (i26 + i16) * i19;
            int i28 = i27 + i18;
            int i29 = i28 + i17;
            int i36 = i27 + i19;
            if (i36 < i29) {
                i29 = i36;
            }
            int i37 = aVar2.f31505c * i26;
            int i38 = i28;
            while (i38 < i29) {
                byte b17 = bArr[i37];
                int i39 = i3;
                int i46 = b17 & 255;
                if (i46 != b16) {
                    int i47 = iArr2[i46];
                    if (i47 != 0) {
                        iArr[i38] = i47;
                    } else {
                        b16 = b17;
                    }
                }
                i37++;
                i38++;
                i3 = i39;
            }
            i26++;
            aVar2 = aVar;
        }
        Boolean bool = this.f31550s;
        if ((bool != null && bool.booleanValue()) || (this.f31550s == null && z16 && b16 != -1)) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.f31550s = Boolean.valueOf(z17);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v15, types: [short] */
    /* JADX WARN: Type inference failed for: r7v17 */
    private void g(a aVar) {
        int i3;
        int i16;
        short s16;
        d dVar = this;
        if (aVar != null) {
            dVar.f31535d.position(aVar.f31512j);
        }
        if (aVar == null) {
            b bVar = dVar.f31543l;
            i3 = bVar.f31519f;
            i16 = bVar.f31520g;
        } else {
            i3 = aVar.f31505c;
            i16 = aVar.f31506d;
        }
        int i17 = i3 * i16;
        byte[] bArr = dVar.f31540i;
        if (bArr == null || bArr.length < i17) {
            dVar.f31540i = dVar.f31534c.c(i17);
        }
        byte[] bArr2 = dVar.f31540i;
        if (dVar.f31537f == null) {
            dVar.f31537f = new short[4096];
        }
        short[] sArr = dVar.f31537f;
        if (dVar.f31538g == null) {
            dVar.f31538g = new byte[4096];
        }
        byte[] bArr3 = dVar.f31538g;
        if (dVar.f31539h == null) {
            dVar.f31539h = new byte[4097];
        }
        byte[] bArr4 = dVar.f31539h;
        int k3 = k();
        int i18 = 1 << k3;
        int i19 = i18 + 1;
        int i26 = i18 + 2;
        int i27 = k3 + 1;
        int i28 = (1 << i27) - 1;
        int i29 = 0;
        for (int i36 = 0; i36 < i18; i36++) {
            sArr[i36] = 0;
            bArr3[i36] = (byte) i36;
        }
        byte[] bArr5 = dVar.f31536e;
        int i37 = i27;
        int i38 = i26;
        int i39 = i28;
        int i46 = 0;
        int i47 = 0;
        int i48 = 0;
        int i49 = 0;
        int i56 = 0;
        int i57 = 0;
        int i58 = 0;
        int i59 = -1;
        while (true) {
            if (i29 >= i17) {
                break;
            }
            if (i46 == 0) {
                i46 = j();
                if (i46 <= 0) {
                    dVar.f31546o = 3;
                    break;
                }
                i47 = 0;
            }
            i49 += (bArr5[i47] & 255) << i48;
            i47++;
            i46--;
            int i65 = i48 + 8;
            int i66 = i38;
            int i67 = i59;
            int i68 = i37;
            int i69 = i27;
            int i75 = i58;
            while (true) {
                if (i65 >= i68) {
                    int i76 = i26;
                    int i77 = i49 & i39;
                    i49 >>= i68;
                    i65 -= i68;
                    if (i77 == i18) {
                        i39 = i28;
                        i68 = i69;
                        i66 = i76;
                        i26 = i66;
                        i67 = -1;
                    } else {
                        if (i77 == i19) {
                            i48 = i65;
                            i58 = i75;
                            i38 = i66;
                            i27 = i69;
                            i26 = i76;
                            i59 = i67;
                            i37 = i68;
                            break;
                        }
                        if (i67 == -1) {
                            bArr2[i56] = bArr3[i77];
                            i56++;
                            i29++;
                            i67 = i77;
                            i75 = i67;
                            i26 = i76;
                            i65 = i65;
                        } else {
                            if (i77 >= i66) {
                                bArr4[i57] = (byte) i75;
                                i57++;
                                s16 = i67;
                            } else {
                                s16 = i77;
                            }
                            while (s16 >= i18) {
                                bArr4[i57] = bArr3[s16];
                                i57++;
                                s16 = sArr[s16];
                            }
                            i75 = bArr3[s16] & 255;
                            byte b16 = (byte) i75;
                            bArr2[i56] = b16;
                            while (true) {
                                i56++;
                                i29++;
                                if (i57 <= 0) {
                                    break;
                                }
                                i57--;
                                bArr2[i56] = bArr4[i57];
                            }
                            byte[] bArr6 = bArr4;
                            if (i66 < 4096) {
                                sArr[i66] = (short) i67;
                                bArr3[i66] = b16;
                                i66++;
                                if ((i66 & i39) == 0 && i66 < 4096) {
                                    i68++;
                                    i39 += i66;
                                }
                            }
                            i67 = i77;
                            i26 = i76;
                            i65 = i65;
                            bArr4 = bArr6;
                        }
                    }
                } else {
                    i38 = i66;
                    i37 = i68;
                    i48 = i65;
                    i58 = i75;
                    i27 = i69;
                    i59 = i67;
                    break;
                }
            }
            dVar = this;
        }
        Arrays.fill(bArr2, i56, i17, (byte) 0);
    }

    private Bitmap i() {
        Bitmap.Config config;
        Boolean bool = this.f31550s;
        if (bool != null && !bool.booleanValue()) {
            config = this.f31551t;
        } else {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap e16 = this.f31534c.e(this.f31549r, this.f31548q, config);
        e16.setHasAlpha(true);
        return e16;
    }

    private int j() {
        int k3 = k();
        if (k3 <= 0) {
            return k3;
        }
        ByteBuffer byteBuffer = this.f31535d;
        byteBuffer.get(this.f31536e, 0, Math.min(k3, byteBuffer.remaining()));
        return k3;
    }

    private int k() {
        return this.f31535d.get() & 255;
    }

    private Bitmap m(a aVar, a aVar2) {
        int i3;
        int i16;
        Bitmap bitmap;
        int[] iArr = this.f31541j;
        int i17 = 0;
        if (aVar2 == null) {
            Bitmap bitmap2 = this.f31544m;
            if (bitmap2 != null) {
                this.f31534c.f(bitmap2);
            }
            this.f31544m = null;
            Arrays.fill(iArr, 0);
        }
        if (aVar2 != null && aVar2.f31509g == 3 && this.f31544m == null) {
            Arrays.fill(iArr, 0);
        }
        if (aVar2 != null && (i16 = aVar2.f31509g) > 0) {
            if (i16 == 2) {
                if (!aVar.f31508f) {
                    b bVar = this.f31543l;
                    int i18 = bVar.f31525l;
                    if (aVar.f31513k == null || bVar.f31523j != aVar.f31510h) {
                        i17 = i18;
                    }
                }
                int i19 = aVar2.f31506d;
                int i26 = this.f31547p;
                int i27 = i19 / i26;
                int i28 = aVar2.f31504b / i26;
                int i29 = aVar2.f31505c / i26;
                int i36 = aVar2.f31503a / i26;
                int i37 = this.f31549r;
                int i38 = (i28 * i37) + i36;
                int i39 = (i27 * i37) + i38;
                while (i38 < i39) {
                    int i46 = i38 + i29;
                    for (int i47 = i38; i47 < i46; i47++) {
                        iArr[i47] = i17;
                    }
                    i38 += this.f31549r;
                }
            } else if (i16 == 3 && (bitmap = this.f31544m) != null) {
                int i48 = this.f31549r;
                bitmap.getPixels(iArr, 0, i48, 0, 0, i48, this.f31548q);
            }
        }
        g(aVar);
        if (!aVar.f31507e && this.f31547p == 1) {
            f(aVar);
        } else {
            e(aVar);
        }
        if (this.f31545n && ((i3 = aVar.f31509g) == 0 || i3 == 1)) {
            if (this.f31544m == null) {
                this.f31544m = i();
            }
            Bitmap bitmap3 = this.f31544m;
            int i49 = this.f31549r;
            bitmap3.setPixels(iArr, 0, i49, 0, 0, i49, this.f31548q);
        }
        Bitmap i56 = i();
        int i57 = this.f31549r;
        i56.setPixels(iArr, 0, i57, 0, 0, i57, this.f31548q);
        return i56;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void a(@NonNull Bitmap.Config config) {
        if (config != Bitmap.Config.ARGB_8888 && config != Bitmap.Config.RGB_565) {
            throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
        }
        this.f31551t = config;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void advance() {
        this.f31542k = (this.f31542k + 1) % this.f31543l.f31516c;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void b() {
        this.f31542k = -1;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int c() {
        int i3;
        if (this.f31543l.f31516c > 0 && (i3 = this.f31542k) >= 0) {
            return h(i3);
        }
        return 0;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void clear() {
        this.f31543l = null;
        byte[] bArr = this.f31540i;
        if (bArr != null) {
            this.f31534c.a(bArr);
        }
        int[] iArr = this.f31541j;
        if (iArr != null) {
            this.f31534c.b(iArr);
        }
        Bitmap bitmap = this.f31544m;
        if (bitmap != null) {
            this.f31534c.f(bitmap);
        }
        this.f31544m = null;
        this.f31535d = null;
        this.f31550s = null;
        byte[] bArr2 = this.f31536e;
        if (bArr2 != null) {
            this.f31534c.a(bArr2);
        }
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getByteSize() {
        return this.f31535d.limit() + this.f31540i.length + (this.f31541j.length * 4);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getCurrentFrameIndex() {
        return this.f31542k;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    @NonNull
    public ByteBuffer getData() {
        return this.f31535d;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getFrameCount() {
        return this.f31543l.f31516c;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    @Nullable
    public synchronized Bitmap getNextFrame() {
        a aVar;
        if (this.f31543l.f31516c <= 0 || this.f31542k < 0) {
            String str = f31531u;
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Unable to decode frame, frameCount=" + this.f31543l.f31516c + ", framePointer=" + this.f31542k);
            }
            this.f31546o = 1;
        }
        int i3 = this.f31546o;
        if (i3 != 1 && i3 != 2) {
            this.f31546o = 0;
            if (this.f31536e == null) {
                this.f31536e = this.f31534c.c(255);
            }
            a aVar2 = this.f31543l.f31518e.get(this.f31542k);
            int i16 = this.f31542k - 1;
            if (i16 >= 0) {
                aVar = this.f31543l.f31518e.get(i16);
            } else {
                aVar = null;
            }
            int[] iArr = aVar2.f31513k;
            if (iArr == null) {
                iArr = this.f31543l.f31514a;
            }
            this.f31532a = iArr;
            if (iArr == null) {
                String str2 = f31531u;
                if (Log.isLoggable(str2, 3)) {
                    Log.d(str2, "No valid color table found for frame #" + this.f31542k);
                }
                this.f31546o = 1;
                return null;
            }
            if (aVar2.f31508f) {
                System.arraycopy(iArr, 0, this.f31533b, 0, iArr.length);
                int[] iArr2 = this.f31533b;
                this.f31532a = iArr2;
                iArr2[aVar2.f31510h] = 0;
                if (aVar2.f31509g == 2 && this.f31542k == 0) {
                    this.f31550s = Boolean.TRUE;
                }
            }
            return m(aVar2, aVar);
        }
        String str3 = f31531u;
        if (Log.isLoggable(str3, 3)) {
            Log.d(str3, "Unable to decode frame, status=" + this.f31546o);
        }
        return null;
    }

    public int h(int i3) {
        if (i3 >= 0) {
            b bVar = this.f31543l;
            if (i3 < bVar.f31516c) {
                return bVar.f31518e.get(i3).f31511i;
            }
        }
        return -1;
    }

    public synchronized void l(@NonNull b bVar, @NonNull ByteBuffer byteBuffer, int i3) {
        if (i3 > 0) {
            int highestOneBit = Integer.highestOneBit(i3);
            this.f31546o = 0;
            this.f31543l = bVar;
            this.f31542k = -1;
            ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            this.f31535d = asReadOnlyBuffer;
            asReadOnlyBuffer.position(0);
            this.f31535d.order(ByteOrder.LITTLE_ENDIAN);
            this.f31545n = false;
            Iterator<a> it = bVar.f31518e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().f31509g == 3) {
                    this.f31545n = true;
                    break;
                }
            }
            this.f31547p = highestOneBit;
            int i16 = bVar.f31519f;
            this.f31549r = i16 / highestOneBit;
            int i17 = bVar.f31520g;
            this.f31548q = i17 / highestOneBit;
            this.f31540i = this.f31534c.c(i16 * i17);
            this.f31541j = this.f31534c.d(this.f31549r * this.f31548q);
        } else {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i3);
        }
    }

    public d(@NonNull GifDecoder.a aVar) {
        this.f31533b = new int[256];
        this.f31551t = Bitmap.Config.ARGB_8888;
        this.f31534c = aVar;
        this.f31543l = new b();
    }
}
