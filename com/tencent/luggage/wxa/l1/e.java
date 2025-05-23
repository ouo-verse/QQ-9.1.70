package com.tencent.luggage.wxa.l1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.media.CamcorderProfile;
import android.util.Size;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.luggage.wxa.k.h;
import com.tencent.luggage.wxa.k.q;
import com.tencent.luggage.wxa.l1.d;
import com.tencent.luggage.wxa.l1.i;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e implements d {

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.luggage.wxa.k.h f132924a;

    /* renamed from: b, reason: collision with root package name */
    public String f132925b;

    /* renamed from: c, reason: collision with root package name */
    public int f132926c;

    /* renamed from: d, reason: collision with root package name */
    public int f132927d;

    /* renamed from: e, reason: collision with root package name */
    public int f132928e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f132929f;

    /* renamed from: g, reason: collision with root package name */
    public Point f132930g;

    /* renamed from: h, reason: collision with root package name */
    public Point f132931h;

    /* renamed from: i, reason: collision with root package name */
    public CamcorderProfile f132932i;

    /* renamed from: j, reason: collision with root package name */
    public d.c f132933j;

    /* renamed from: k, reason: collision with root package name */
    public d.b f132934k;

    /* renamed from: l, reason: collision with root package name */
    public d.a f132935l;

    /* renamed from: m, reason: collision with root package name */
    public d.e f132936m;

    /* renamed from: n, reason: collision with root package name */
    public d.f f132937n;

    /* renamed from: o, reason: collision with root package name */
    public i f132938o = null;

    /* renamed from: p, reason: collision with root package name */
    public Point f132939p = new Point(0, 0);

    /* renamed from: q, reason: collision with root package name */
    public float[] f132940q;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends h.d {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.k.h.d
        public void a(com.tencent.luggage.wxa.k.h hVar) {
            super.a(hVar);
        }

        @Override // com.tencent.luggage.wxa.k.h.d
        public void b(com.tencent.luggage.wxa.k.h hVar) {
            super.b(hVar);
            w.d("MicroMsg.LuggageRecordView", "onCameraOpened: open success");
            e.this.o();
            if (e.this.f132934k != null) {
                e.this.f132934k.a();
            }
        }

        @Override // com.tencent.luggage.wxa.k.h.d
        public void c(com.tencent.luggage.wxa.k.h hVar) {
            super.c(hVar);
            if (e.this.f132933j != null) {
                e.this.f132933j.a();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x00b8 A[Catch: Exception -> 0x012b, TryCatch #0 {Exception -> 0x012b, blocks: (B:4:0x000e, B:6:0x0034, B:8:0x0062, B:9:0x0069, B:11:0x0071, B:13:0x007b, B:14:0x008a, B:18:0x009b, B:22:0x00a9, B:23:0x00b2, B:25:0x00b8, B:26:0x00be, B:28:0x00c4, B:30:0x00c8, B:33:0x00cd, B:36:0x00f0, B:38:0x0121, B:41:0x00ae, B:42:0x00a0, B:43:0x003e, B:45:0x0050), top: B:3:0x000e }] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00c4 A[Catch: Exception -> 0x012b, TryCatch #0 {Exception -> 0x012b, blocks: (B:4:0x000e, B:6:0x0034, B:8:0x0062, B:9:0x0069, B:11:0x0071, B:13:0x007b, B:14:0x008a, B:18:0x009b, B:22:0x00a9, B:23:0x00b2, B:25:0x00b8, B:26:0x00be, B:28:0x00c4, B:30:0x00c8, B:33:0x00cd, B:36:0x00f0, B:38:0x0121, B:41:0x00ae, B:42:0x00a0, B:43:0x003e, B:45:0x0050), top: B:3:0x000e }] */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0121 A[Catch: Exception -> 0x012b, TRY_LEAVE, TryCatch #0 {Exception -> 0x012b, blocks: (B:4:0x000e, B:6:0x0034, B:8:0x0062, B:9:0x0069, B:11:0x0071, B:13:0x007b, B:14:0x008a, B:18:0x009b, B:22:0x00a9, B:23:0x00b2, B:25:0x00b8, B:26:0x00be, B:28:0x00c4, B:30:0x00c8, B:33:0x00cd, B:36:0x00f0, B:38:0x0121, B:41:0x00ae, B:42:0x00a0, B:43:0x003e, B:45:0x0050), top: B:3:0x000e }] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00bd  */
        @Override // com.tencent.luggage.wxa.k.h.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(com.tencent.luggage.wxa.k.h hVar, byte[] bArr) {
            boolean z16;
            int width;
            int height;
            Point a16;
            super.a(hVar, bArr);
            if (e.this.f132936m == null) {
                return;
            }
            try {
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                Matrix matrix = new Matrix();
                int a17 = com.tencent.luggage.wxa.l.b.a(hVar.getCameraOrientation());
                if ((hVar.getPreviewSize().a() <= hVar.getPreviewSize().b() || decodeByteArray.getHeight() <= decodeByteArray.getWidth()) && (hVar.getPreviewSize().a() >= hVar.getPreviewSize().b() || decodeByteArray.getHeight() >= decodeByteArray.getWidth() || !(a17 == 90 || a17 == 270))) {
                    z16 = false;
                } else {
                    matrix.postRotate(a17);
                    z16 = true;
                }
                if (e.this.n()) {
                    matrix.postScale(-1.0f, 1.0f);
                    z16 = true;
                }
                if (z16) {
                    decodeByteArray = Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix, true);
                }
                int a18 = com.tencent.luggage.wxa.l.b.a(e.this.a());
                if (a18 != 0 && a18 != 180) {
                    width = decodeByteArray.getHeight();
                    if (a18 != 0 && a18 != 180) {
                        height = decodeByteArray.getWidth();
                        com.tencent.luggage.wxa.k.h hVar2 = e.this.f132924a;
                        a16 = com.tencent.luggage.wxa.l.a.a(width, height, a18, hVar2 == null ? hVar2.getDisplayRatio() : 0.0f);
                        if (a16 != null) {
                            e.this.f132936m.a(decodeByteArray);
                            return;
                        }
                        if (a16.x <= width && a16.y <= height) {
                            int width2 = (decodeByteArray.getWidth() - a16.x) >> 1;
                            int height2 = decodeByteArray.getHeight();
                            int i3 = a16.y;
                            Bitmap createBitmap = Bitmap.createBitmap(decodeByteArray, width2, (height2 - i3) >> 1, a16.x, i3);
                            decodeByteArray.recycle();
                            e.this.f132936m.a(createBitmap);
                            return;
                        }
                        w.h("MicroMsg.LuggageRecordView", "crop over size, width: %d, height: %d, cropWidth: %d, cropHeight: %d", Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(a16.x), Integer.valueOf(a16.y));
                        e.this.f132936m.a(decodeByteArray);
                        return;
                    }
                    height = decodeByteArray.getHeight();
                    com.tencent.luggage.wxa.k.h hVar22 = e.this.f132924a;
                    a16 = com.tencent.luggage.wxa.l.a.a(width, height, a18, hVar22 == null ? hVar22.getDisplayRatio() : 0.0f);
                    if (a16 != null) {
                    }
                }
                width = decodeByteArray.getWidth();
                if (a18 != 0) {
                    height = decodeByteArray.getWidth();
                    com.tencent.luggage.wxa.k.h hVar222 = e.this.f132924a;
                    a16 = com.tencent.luggage.wxa.l.a.a(width, height, a18, hVar222 == null ? hVar222.getDisplayRatio() : 0.0f);
                    if (a16 != null) {
                    }
                }
                height = decodeByteArray.getHeight();
                com.tencent.luggage.wxa.k.h hVar2222 = e.this.f132924a;
                a16 = com.tencent.luggage.wxa.l.a.a(width, height, a18, hVar2222 == null ? hVar2222.getDisplayRatio() : 0.0f);
                if (a16 != null) {
                }
            } catch (Exception e16) {
                com.tencent.luggage.wxa.k.f.a("MicroMsg.LuggageRecordView", "onPictureTaken decode bitmap error", (Throwable) e16);
                e.this.f132936m.a();
            }
        }

        @Override // com.tencent.luggage.wxa.k.h.d
        public void a(com.tencent.luggage.wxa.k.h hVar, String str) {
            super.a(hVar, str);
            if (e.this.f132937n != null) {
                e.this.f132937n.a(false);
            }
        }

        @Override // com.tencent.luggage.wxa.k.h.d
        public void a(com.tencent.luggage.wxa.k.h hVar, byte[] bArr, int i3, int i16, int i17) {
            super.a(hVar, bArr, i3, i16, i17);
            e.this.a(hVar, bArr, i3, i16, i17);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f132924a.l();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements i.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.InterfaceC6416d f132943a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ByteBuffer f132944b;

        public c(d.InterfaceC6416d interfaceC6416d, ByteBuffer byteBuffer) {
            this.f132943a = interfaceC6416d;
            this.f132944b = byteBuffer;
        }

        @Override // com.tencent.luggage.wxa.l1.i.c
        public ByteBuffer a() {
            return this.f132944b;
        }

        @Override // com.tencent.luggage.wxa.l1.i.c
        public void b() {
            d.InterfaceC6416d interfaceC6416d = this.f132943a;
            if (interfaceC6416d != null) {
                interfaceC6416d.a();
            }
        }
    }

    public e() {
    }

    @Override // com.tencent.luggage.wxa.l1.d
    public void d(int i3) {
    }

    @Override // com.tencent.luggage.wxa.l1.d
    public Point e() {
        w.d("MicroMsg.LuggageRecordView", "getDrawSizePoint : %s", this.f132939p.toString());
        return this.f132939p;
    }

    @Override // com.tencent.luggage.wxa.l1.d
    public void g() {
        this.f132924a.f();
    }

    @Override // com.tencent.luggage.wxa.l1.d
    public Bitmap h() {
        byte[] currentFrameData = this.f132924a.getCurrentFrameData();
        if (currentFrameData == null) {
            w.d("MicroMsg.LuggageRecordView", "getCurrentFramePicture sourceData is null");
            return null;
        }
        int b16 = this.f132924a.getPreviewSize().b();
        int a16 = this.f132924a.getPreviewSize().a();
        YuvImage yuvImage = new YuvImage(currentFrameData, 17, b16, a16, null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        yuvImage.compressToJpeg(new Rect(0, 0, b16, a16), 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        Bitmap a17 = com.tencent.luggage.wxa.tn.d.a(decodeByteArray, this.f132924a.getCameraOrientation());
        w.d("MicroMsg.LuggageRecordView", "bitmap recycle %s", decodeByteArray);
        decodeByteArray.recycle();
        return a17;
    }

    @Override // com.tencent.luggage.wxa.l1.d
    public void handlePluginTouch(MotionEvent motionEvent) {
        com.tencent.luggage.wxa.k.h hVar = this.f132924a;
        if (hVar == null) {
            return;
        }
        hVar.a(motionEvent);
    }

    @Override // com.tencent.luggage.wxa.l1.d
    public String i() {
        return this.f132925b;
    }

    @Override // com.tencent.luggage.wxa.l1.d
    public void j() {
        this.f132924a.g();
    }

    public Point k() {
        q pictureSize;
        Point point;
        com.tencent.luggage.wxa.k.h hVar = this.f132924a;
        if (hVar == null || (pictureSize = hVar.getPictureSize()) == null) {
            return null;
        }
        int a16 = com.tencent.luggage.wxa.l.b.a(a());
        try {
            if (this.f132930g == null) {
                if (a16 != 0 && a16 != 180) {
                    return new Point(pictureSize.a(), pictureSize.b());
                }
                return new Point(pictureSize.b(), pictureSize.a());
            }
            if (a16 != 0 && a16 != 180) {
                Point point2 = this.f132930g;
                point = new Point(point2.y, point2.x);
                return point;
            }
            Point point3 = this.f132930g;
            point = new Point(point3.x, point3.y);
            return point;
        } catch (Exception e16) {
            w.b("MicroMsg.LuggageRecordView", "getPictureSize: %s", e16.getMessage());
            return null;
        }
    }

    public Point l() {
        q previewSize;
        Point point;
        com.tencent.luggage.wxa.k.h hVar = this.f132924a;
        if (hVar == null || (previewSize = hVar.getPreviewSize()) == null) {
            return null;
        }
        int a16 = com.tencent.luggage.wxa.l.b.a(a());
        try {
            if (this.f132931h == null) {
                if (a16 != 0 && a16 != 180) {
                    return new Point(previewSize.a(), previewSize.b());
                }
                return new Point(previewSize.b(), previewSize.a());
            }
            if (a16 != 0 && a16 != 180) {
                Point point2 = this.f132931h;
                point = new Point(point2.y, point2.x);
                return point;
            }
            Point point3 = this.f132931h;
            point = new Point(point3.x, point3.y);
            return point;
        } catch (Exception e16) {
            w.b("MicroMsg.LuggageRecordView", "getPreviewSize: %s", e16.getMessage());
            return null;
        }
    }

    public void m() {
        this.f132924a.a(new a());
        this.f132924a.setAutoFocus(true);
    }

    public boolean n() {
        if (this.f132924a.getFacing() == 1) {
            return true;
        }
        return false;
    }

    public void o() {
        q previewSize = this.f132924a.getPreviewSize();
        int a16 = com.tencent.luggage.wxa.l.b.a(a());
        Point point = this.f132939p;
        point.y = this.f132928e;
        point.x = (previewSize.b() * this.f132928e) / previewSize.a();
        if (com.tencent.luggage.wxa.l.b.a(this.f132924a.getCameraOrientation()) == 90 || com.tencent.luggage.wxa.l.b.a(this.f132924a.getCameraOrientation()) == 270) {
            Point point2 = this.f132939p;
            int i3 = point2.y;
            point2.y = point2.x;
            point2.x = i3;
        }
        i iVar = this.f132938o;
        if (iVar != null) {
            Point point3 = this.f132939p;
            iVar.a(a16, point3.x, point3.y);
        }
    }

    @Override // com.tencent.luggage.wxa.l1.d
    public void release() {
        w.d("MicroMsg.LuggageRecordView", "release: cameraview stop now");
        this.f132924a.j();
        this.f132930g = null;
        this.f132931h = null;
        i iVar = this.f132938o;
        if (iVar != null) {
            iVar.a();
        }
    }

    @Override // com.tencent.luggage.wxa.l1.d
    public void setDisplayScreenSize(Size size) {
        this.f132924a.setDisplayScreenSize(size);
    }

    @Override // com.tencent.luggage.wxa.l1.d
    public void a(d.c cVar) {
        this.f132933j = cVar;
    }

    @Override // com.tencent.luggage.wxa.l1.d
    public void b(boolean z16) {
        this.f132924a.setFacing(!z16 ? 1 : 0);
    }

    @Override // com.tencent.luggage.wxa.l1.d
    public void c(int i3) {
        this.f132924a.setPreviewSizeLimit(i3);
    }

    @Override // com.tencent.luggage.wxa.l1.d
    public void a(d.b bVar) {
        this.f132934k = bVar;
    }

    @Override // com.tencent.luggage.wxa.l1.d
    public void b() {
        if (this.f132924a.getFacing() == 0) {
            this.f132924a.setFacing(1);
        } else {
            this.f132924a.setFacing(0);
        }
    }

    @Override // com.tencent.luggage.wxa.l1.d
    public void c(boolean z16) {
        this.f132924a.setClipVideoSize(z16);
    }

    @Override // com.tencent.luggage.wxa.l1.d
    public View d() {
        return this.f132924a;
    }

    public e(Context context) {
        this.f132924a = new com.tencent.luggage.wxa.k.h(context, false);
        m();
    }

    @Override // com.tencent.luggage.wxa.l1.d
    public void a(float f16) {
        this.f132924a.setDisplayRatio(f16);
    }

    @Override // com.tencent.luggage.wxa.l1.d
    public float[] c() {
        com.tencent.luggage.wxa.k.h hVar = this.f132924a;
        if (hVar == null) {
            return new float[0];
        }
        if (this.f132940q == null) {
            this.f132940q = hVar.getSupportZoomRatios();
        }
        return this.f132940q;
    }

    @Override // com.tencent.luggage.wxa.l1.d
    public void d(boolean z16) {
        com.tencent.luggage.wxa.k.h hVar;
        this.f132929f = z16;
        if (z16 && (hVar = this.f132924a) != null && hVar.e()) {
            this.f132930g = com.tencent.luggage.wxa.l.a.a(k().x, k().y, com.tencent.luggage.wxa.l.b.a(a()), this.f132924a.getDisplayRatio());
            this.f132931h = com.tencent.luggage.wxa.l.a.a(l().x, l().y, com.tencent.luggage.wxa.l.b.a(a()), this.f132924a.getDisplayRatio());
        }
    }

    @Override // com.tencent.luggage.wxa.l1.d
    public void a(int i3, int i16, int i17, int i18, int i19) {
        this.f132927d = i3;
        try {
            this.f132932i = CamcorderProfile.get(this.f132926c, 5);
        } catch (RuntimeException e16) {
            w.h("MicroMsg.LuggageRecordView", "get 720p camcorder profile fail, try to get default high profile", e16);
            this.f132932i = CamcorderProfile.get(this.f132926c, 1);
        }
        CamcorderProfile camcorderProfile = this.f132932i;
        camcorderProfile.videoBitRate = i16;
        camcorderProfile.videoFrameRate = i17;
        camcorderProfile.audioBitRate = i18;
        camcorderProfile.audioSampleRate = i19;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x000b, code lost:
    
        if (r4 != 4) goto L12;
     */
    @Override // com.tencent.luggage.wxa.l1.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(int i3) {
        int i16 = 1;
        if (i3 != 1) {
            i16 = 2;
            if (i3 != 2) {
                if (i3 == 3) {
                    i16 = 3;
                }
            }
            i16 = 0;
        }
        this.f132924a.setFlash(i16);
    }

    @Override // com.tencent.luggage.wxa.l1.d
    public void a(String str) {
        w.d("MicroMsg.LuggageRecordView", "setVideoFilePath: %s", str);
        this.f132925b = str;
    }

    @Override // com.tencent.luggage.wxa.l1.d
    public boolean a(boolean z16) {
        return this.f132924a.a(this.f132925b, this.f132927d, 500000000, true, this.f132932i, true);
    }

    @Override // com.tencent.luggage.wxa.l1.d
    public void a(d.f fVar) {
        this.f132937n = fVar;
        this.f132924a.k();
    }

    @Override // com.tencent.luggage.wxa.l1.d
    public void a(d.e eVar, boolean z16) {
        if (z16) {
            b(1);
        }
        this.f132936m = eVar;
        if (z16) {
            c0.a(new b(), 100L);
        } else {
            this.f132924a.l();
        }
    }

    @Override // com.tencent.luggage.wxa.l1.d
    public void a(d.a aVar) {
        this.f132935l = aVar;
        com.tencent.luggage.wxa.k.h hVar = this.f132924a;
        if (hVar != null) {
            hVar.setScanning(aVar != null);
        }
    }

    @Override // com.tencent.luggage.wxa.l1.d
    public void f() {
    }

    @Override // com.tencent.luggage.wxa.l1.d
    public int a() {
        return this.f132924a.getCameraOrientation();
    }

    @Override // com.tencent.luggage.wxa.l1.d
    public void a(int i3) {
        w.d("MicroMsg.LuggageRecordView", "setRGBSizeLimit: %s", Integer.valueOf(i3));
        this.f132928e = i3;
    }

    @Override // com.tencent.luggage.wxa.l1.d
    public void a(ByteBuffer byteBuffer, d.InterfaceC6416d interfaceC6416d) {
        if (interfaceC6416d == null && byteBuffer == null) {
            i iVar = this.f132938o;
            if (iVar != null) {
                iVar.a();
                this.f132938o = null;
                return;
            }
            return;
        }
        if (this.f132938o == null) {
            i iVar2 = new i();
            this.f132938o = iVar2;
            int a16 = com.tencent.luggage.wxa.l.b.a(a());
            Point point = this.f132939p;
            iVar2.a(a16, point.x, point.y);
            this.f132938o.a(new c(interfaceC6416d, byteBuffer));
            this.f132938o.b();
        }
    }

    public void a(com.tencent.luggage.wxa.k.h hVar, byte[] bArr, int i3, int i16, int i17) {
        i iVar = this.f132938o;
        if (iVar != null) {
            iVar.a(bArr, i3, i16, i17);
        }
        d.a aVar = this.f132935l;
        if (aVar != null) {
            aVar.a(bArr, i3, i16);
        }
    }
}
