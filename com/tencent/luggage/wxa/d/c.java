package com.tencent.luggage.wxa.d;

import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.github.henryye.nativeiv.api.IImageDecodeService;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c {

    /* renamed from: f, reason: collision with root package name */
    public static final Object f123871f = new Object();

    /* renamed from: a, reason: collision with root package name */
    public BitmapType f123872a = null;

    /* renamed from: b, reason: collision with root package name */
    public IBitmap f123873b = new a();

    /* renamed from: c, reason: collision with root package name */
    public IImageDecodeService.b f123874c;

    /* renamed from: d, reason: collision with root package name */
    public com.tencent.luggage.wxa.e.a f123875d;

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.luggage.wxa.d.b f123876e;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b implements IBitmap {
        @Override // com.github.henryye.nativeiv.bitmap.IBitmap
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public NativeBitmapStruct provide() {
            return null;
        }

        @Override // com.github.henryye.nativeiv.bitmap.IBitmap
        public void decodeInputStream(InputStream inputStream, ImageDecodeConfig imageDecodeConfig, com.tencent.luggage.wxa.f.c cVar) {
            a(inputStream);
        }

        @Override // com.github.henryye.nativeiv.bitmap.IBitmap
        public long getDecodeTime() {
            return 0L;
        }

        @Override // com.github.henryye.nativeiv.bitmap.IBitmap
        public BitmapType getType() {
            return BitmapType.Native;
        }

        public final void a(InputStream inputStream) {
            if (inputStream == null) {
                throw new IOException("Null input stream");
            }
        }

        @Override // com.github.henryye.nativeiv.bitmap.IBitmap
        public void recycle() {
        }
    }

    public c(com.tencent.luggage.wxa.d.b bVar, com.tencent.luggage.wxa.e.a aVar) {
        this.f123876e = bVar;
        this.f123875d = aVar;
    }

    public void a(IImageDecodeService.b bVar) {
        this.f123874c = bVar;
    }

    public IBitmap b() {
        return this.f123873b;
    }

    public com.tencent.luggage.wxa.f.d a(InputStream inputStream) {
        a();
        if (inputStream != null) {
            return b(inputStream);
        }
        return null;
    }

    public com.tencent.luggage.wxa.f.d b(InputStream inputStream) {
        return com.tencent.luggage.wxa.j.d.a(inputStream);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0067 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String str, InputStream inputStream, ImageDecodeConfig imageDecodeConfig, com.tencent.luggage.wxa.f.c cVar) {
        boolean z16;
        long j3;
        if (inputStream == null) {
            return;
        }
        a(inputStream, imageDecodeConfig, cVar);
        boolean z17 = true;
        try {
            this.f123873b.decodeInputStream(inputStream, imageDecodeConfig, cVar);
        } catch (IOException e16) {
            com.tencent.luggage.wxa.h.b.a("Ni.BitmapWrapper", e16, "hy: decodeInputStream", new Object[0]);
            this.f123874c.a(str, IImageDecodeService.b.a.IO_ERROR, this.f123875d);
            this.f123873b.recycle();
            z16 = false;
            if (!z17) {
            }
        } catch (OutOfMemoryError e17) {
            com.tencent.luggage.wxa.h.b.a("Ni.BitmapWrapper", e17, "hy: decodeInputStream", new Object[0]);
            this.f123874c.a(str, IImageDecodeService.b.a.OUT_OF_MEMORY, this.f123875d);
            this.f123873b.recycle();
            z16 = false;
            if (!z17) {
            }
        } catch (Throwable th5) {
            com.tencent.luggage.wxa.h.b.a("Ni.BitmapWrapper", th5, "hy: decode image exception", new Object[0]);
            this.f123874c.a(str, IImageDecodeService.b.a.NATIVE_DECODE_ERROR, this.f123875d);
            this.f123873b.recycle();
        }
        if (this.f123873b.provide() != null) {
            z16 = true;
            z17 = false;
            if (!z17) {
                com.tencent.luggage.wxa.j.b.a(inputStream);
                return;
            }
            try {
                j3 = inputStream.available();
            } catch (IOException | IllegalStateException e18) {
                com.tencent.luggage.wxa.h.b.a("Ni.BitmapWrapper", e18, "hy: get stream len failed!", new Object[0]);
                j3 = 0;
            }
            if (!z16 && this.f123873b.getType() == BitmapType.Native) {
                com.tencent.luggage.wxa.h.b.c("Ni.BitmapWrapper", "hy: decode switch to legacy mode!", new Object[0]);
                IBitmap b16 = this.f123876e.b();
                this.f123873b = b16;
                try {
                    b16.decodeInputStream(inputStream, imageDecodeConfig, cVar);
                } catch (IOException e19) {
                    com.tencent.luggage.wxa.h.b.a("Ni.BitmapWrapper", e19, "hy: IOException when use legacy", new Object[0]);
                    this.f123874c.a(str, IImageDecodeService.b.a.IO_ERROR, this.f123875d);
                } catch (OutOfMemoryError e26) {
                    com.tencent.luggage.wxa.h.b.a("Ni.BitmapWrapper", e26, "hy: decodeInputStream", new Object[0]);
                    this.f123874c.a(str, IImageDecodeService.b.a.OUT_OF_MEMORY, this.f123875d);
                } catch (Throwable th6) {
                    com.tencent.luggage.wxa.h.b.a("Ni.BitmapWrapper", th6, "hy: decode image exception", new Object[0]);
                    this.f123874c.a(str, IImageDecodeService.b.a.NATIVE_DECODE_ERROR, this.f123875d);
                }
            }
            this.f123875d.b(j3);
            this.f123875d.a(this.f123873b.getDecodeTime());
            this.f123874c.a(str, IImageDecodeService.b.a.OK, this.f123875d);
            if (this.f123873b.getType() == BitmapType.Legacy) {
                this.f123874c.a(str, IImageDecodeService.b.a.LEGACY_MODE, this.f123875d);
            }
            if (this.f123873b.provide() == null) {
                this.f123873b.recycle();
                this.f123873b = null;
            }
            com.tencent.luggage.wxa.j.b.a(inputStream);
            return;
        }
        z17 = false;
        z16 = false;
        if (!z17) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a implements IBitmap {
        @Override // com.github.henryye.nativeiv.bitmap.IBitmap
        public void decodeInputStream(InputStream inputStream, ImageDecodeConfig imageDecodeConfig, com.tencent.luggage.wxa.f.c cVar) {
            throw new IOException("Stub");
        }

        @Override // com.github.henryye.nativeiv.bitmap.IBitmap
        public long getDecodeTime() {
            return 0L;
        }

        @Override // com.github.henryye.nativeiv.bitmap.IBitmap
        public BitmapType getType() {
            return BitmapType.Undefined;
        }

        @Override // com.github.henryye.nativeiv.bitmap.IBitmap
        public Object provide() {
            return null;
        }

        @Override // com.github.henryye.nativeiv.bitmap.IBitmap
        public void recycle() {
        }
    }

    public void a() {
        IBitmap iBitmap = this.f123873b;
        if (iBitmap != null) {
            iBitmap.recycle();
        }
    }

    public final void a(InputStream inputStream, ImageDecodeConfig imageDecodeConfig, com.tencent.luggage.wxa.f.c cVar) {
        if (this.f123872a != null) {
            this.f123873b = this.f123876e.a(hashCode(), this.f123872a);
        } else {
            this.f123873b = this.f123876e.a(hashCode(), inputStream, imageDecodeConfig.mConfig, cVar);
        }
    }

    public void a(BitmapType bitmapType) {
        this.f123872a = bitmapType;
    }

    public void a(com.tencent.luggage.wxa.f.b bVar) {
        a(BitmapType.Legacy, bVar);
    }

    public final void a(BitmapType bitmapType, com.tencent.luggage.wxa.f.b bVar) {
        synchronized (f123871f) {
            if (this.f123873b.getType() == bitmapType) {
                a();
            }
            this.f123876e.a(hashCode(), bitmapType, bVar);
        }
    }
}
