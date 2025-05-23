package com.tencent.luggage.wxa.z3;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import com.tencent.luggage.scanner.camera.ScanUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class a implements p {

    /* renamed from: a, reason: collision with root package name */
    public Camera f146219a;

    /* renamed from: h, reason: collision with root package name */
    public boolean f146226h;

    /* renamed from: i, reason: collision with root package name */
    public int f146227i;

    /* renamed from: m, reason: collision with root package name */
    public int f146231m;

    /* renamed from: n, reason: collision with root package name */
    public int f146232n;

    /* renamed from: o, reason: collision with root package name */
    public int f146233o;

    /* renamed from: b, reason: collision with root package name */
    public volatile boolean f146220b = false;

    /* renamed from: c, reason: collision with root package name */
    public volatile boolean f146221c = false;

    /* renamed from: d, reason: collision with root package name */
    public Point f146222d = null;

    /* renamed from: e, reason: collision with root package name */
    public Point f146223e = null;

    /* renamed from: f, reason: collision with root package name */
    public Point f146224f = null;

    /* renamed from: g, reason: collision with root package name */
    public float f146225g = 1.0f;

    /* renamed from: j, reason: collision with root package name */
    public boolean f146228j = false;

    /* renamed from: k, reason: collision with root package name */
    public boolean f146229k = false;

    /* renamed from: l, reason: collision with root package name */
    public int f146230l = -1;

    /* renamed from: p, reason: collision with root package name */
    public boolean f146234p = false;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class b implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Camera.Size size, Camera.Size size2) {
            int i3 = size.height * size.width;
            int i16 = size2.height * size2.width;
            if (i16 < i3) {
                return -1;
            }
            if (i16 > i3) {
                return 1;
            }
            return 0;
        }
    }

    @Override // com.tencent.luggage.wxa.z3.p
    public void a(SurfaceTexture surfaceTexture) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f146219a == null || this.f146221c) {
            return;
        }
        if (surfaceTexture != null) {
            this.f146219a.setPreviewTexture(surfaceTexture);
        }
        if (this.f146222d == null) {
            Point b16 = b(this.f146223e);
            this.f146222d = b16;
            this.f146224f = c(b16);
        }
        Camera.Parameters parameters = this.f146219a.getParameters();
        Point point = this.f146222d;
        parameters.setPreviewSize(point.x, point.y);
        this.f146219a.setParameters(parameters);
        this.f146219a.startPreview();
        this.f146221c = true;
        com.tencent.luggage.wxa.yp.b.a("BaseScanCamera", String.format("startPreview done costTime=[%s]", Integer.valueOf((int) (System.currentTimeMillis() - currentTimeMillis))));
    }

    @Override // com.tencent.luggage.wxa.z3.p
    public Point b() {
        return this.f146224f;
    }

    public final Point c(Point point) {
        float f16;
        float f17;
        int i3;
        if (i()) {
            Point point2 = this.f146223e;
            f16 = (point2.x * 1.0f) / point.y;
            f17 = point2.y * 1.0f;
            i3 = point.x;
        } else {
            Point point3 = this.f146223e;
            f16 = (point3.x * 1.0f) / point.x;
            f17 = point3.y * 1.0f;
            i3 = point.y;
        }
        this.f146225g = Math.max(f16, f17 / i3);
        float f18 = point.x;
        float f19 = this.f146225g;
        return new Point((int) (f18 * f19), (int) (point.y * f19));
    }

    @Override // com.tencent.luggage.wxa.z3.p
    public void close() {
        com.tencent.luggage.wxa.yp.b.c("BaseScanCamera", "close(), previewing " + this.f146221c);
        if (this.f146219a != null) {
            this.f146220b = false;
            long currentTimeMillis = System.currentTimeMillis();
            this.f146219a.setPreviewCallback(null);
            this.f146219a.stopPreview();
            this.f146221c = false;
            com.tencent.luggage.wxa.yp.b.c("BaseScanCamera", "stopPreview costTime " + (System.currentTimeMillis() - currentTimeMillis));
            long currentTimeMillis2 = System.currentTimeMillis();
            this.f146219a.release();
            this.f146219a = null;
            com.tencent.luggage.wxa.yp.b.c("BaseScanCamera", "camera.close() costTime " + (System.currentTimeMillis() - currentTimeMillis2));
        }
        this.f146229k = false;
        this.f146228j = false;
        this.f146230l = -1;
        this.f146226h = false;
    }

    @Override // com.tencent.luggage.wxa.z3.p
    public Point d() {
        return this.f146222d;
    }

    @Override // com.tencent.luggage.wxa.z3.p
    public boolean e() {
        return this.f146221c;
    }

    @Override // com.tencent.luggage.wxa.z3.p
    public void f() {
        Camera camera2 = this.f146219a;
        if (camera2 != null) {
            camera2.stopPreview();
            this.f146221c = false;
        }
    }

    public int g() {
        Camera camera2 = this.f146219a;
        if (camera2 != null && camera2.getParameters() != null && this.f146219a.getParameters().getZoomRatios() != null && this.f146219a.getParameters().getZoomRatios().size() > 0) {
            return this.f146219a.getParameters().getZoomRatios().get(this.f146231m).intValue();
        }
        return 100;
    }

    public boolean h() {
        return "auto".equals(c());
    }

    public boolean i() {
        return this.f146226h;
    }

    @Override // com.tencent.luggage.wxa.z3.p
    public boolean isOpen() {
        return this.f146220b;
    }

    public void j() {
        try {
            com.tencent.luggage.wxa.yp.b.c("BaseScanCamera", "set scan focus");
            List<String> supportedFocusModes = this.f146219a.getParameters().getSupportedFocusModes();
            if (supportedFocusModes != null) {
                com.tencent.luggage.wxa.yp.b.c("BaseScanCamera", "supported focus modes size = " + supportedFocusModes.size());
                Iterator<String> it = supportedFocusModes.iterator();
                while (it.hasNext()) {
                    com.tencent.luggage.wxa.yp.b.c("BaseScanCamera", "supported focus modes : " + it.next());
                }
                if (supportedFocusModes.contains("continuous-video")) {
                    com.tencent.luggage.wxa.yp.b.a("BaseScanCamera", "camera support continuous video focus");
                    a("continuous-video");
                } else if (supportedFocusModes.contains("auto")) {
                    com.tencent.luggage.wxa.yp.b.a("BaseScanCamera", "camera support auto focus");
                    a("auto");
                }
            }
        } catch (Exception e16) {
            com.tencent.luggage.wxa.yp.b.b("BaseScanCamera", "setScanFocus error: " + e16.getMessage());
        }
    }

    public final Point b(Point point) {
        Point point2;
        Camera.Parameters parameters = this.f146219a.getParameters();
        String str = parameters.get("preview-size-values");
        if (str == null) {
            str = parameters.get("preview-size-value");
        }
        if (str != null) {
            com.tencent.luggage.wxa.yp.b.a("BaseScanCamera", "preview-size-values parameter: " + str);
            point2 = a(parameters, point);
        } else {
            point2 = null;
        }
        return point2 == null ? new Point((point.x >> 3) << 3, (point.y >> 3) << 3) : point2;
    }

    public Point d(Point point) {
        Point point2 = this.f146224f;
        int i3 = point2.x;
        Point point3 = this.f146223e;
        int i16 = (i3 - point3.x) / 2;
        int i17 = (point2.y - point3.y) / 2;
        Point point4 = new Point(point.x + i16, point.y + i17);
        if (i()) {
            Point point5 = this.f146224f;
            int i18 = point5.y;
            Point point6 = this.f146223e;
            i16 = (i18 - point6.x) / 2;
            i17 = (point5.x - point6.y) / 2;
            point4 = new Point(point.y + i17, (this.f146223e.x - point.x) + i16);
        }
        com.tencent.luggage.wxa.yp.b.a("BaseScanCamera", String.format("dx %d, dy %d", Integer.valueOf(i16), Integer.valueOf(i17)));
        float f16 = point4.x;
        float f17 = this.f146225g;
        Point point7 = new Point((int) (f16 / f17), (int) (point4.y / f17));
        com.tencent.luggage.wxa.yp.b.c("BaseScanCamera", "viewPoint " + point + ", previewPoint " + point4 + ", scanPoint " + point7);
        return point7;
    }

    public void b(int i3) {
        if (this.f146219a == null || !this.f146221c) {
            return;
        }
        try {
            Camera.Parameters parameters = this.f146219a.getParameters();
            List<Integer> zoomRatios = parameters.getZoomRatios();
            if (zoomRatios != null && zoomRatios.size() > 0) {
                com.tencent.luggage.wxa.yp.b.c("BaseScanCamera", String.format("zoom action:%d,beforeZoom:%d", Integer.valueOf(i3), Integer.valueOf(parameters.getZoom())));
                if (i3 == 0) {
                    this.f146231m = 0;
                } else if (i3 == 1) {
                    this.f146231m = this.f146232n;
                } else if (i3 == 2) {
                    int i16 = this.f146231m;
                    int i17 = this.f146233o;
                    if (i16 < i17) {
                        int i18 = i16 + 1;
                        this.f146231m = i18;
                        if (i18 <= i17) {
                            i17 = i18;
                        }
                        this.f146231m = i17;
                    }
                } else if (i3 == 3) {
                    int i19 = this.f146231m;
                    int i26 = this.f146232n;
                    if (i19 > i26) {
                        int i27 = i19 - 1;
                        this.f146231m = i27;
                        if (i27 >= i26) {
                            i26 = i27;
                        }
                        this.f146231m = i26;
                    }
                } else if (i3 == 4) {
                    this.f146231m = this.f146233o;
                } else if (i3 == 5) {
                    int i28 = this.f146231m;
                    int i29 = this.f146232n;
                    if (i28 != i29) {
                        this.f146231m = i29;
                    } else {
                        this.f146231m = this.f146233o;
                    }
                }
                parameters.setZoom(this.f146231m);
                this.f146219a.setParameters(parameters);
                com.tencent.luggage.wxa.yp.b.c("BaseScanCamera", String.format("zoom action:%d,afterZoom:%d", Integer.valueOf(i3), Integer.valueOf(parameters.getZoom())));
            }
        } catch (Exception e16) {
            com.tencent.luggage.wxa.yp.b.b("BaseScanCamera", "zoom action exception:" + e16.getMessage());
        }
    }

    public void c(int i3) {
        int i16;
        if (this.f146219a == null || !this.f146221c || i3 <= 0) {
            return;
        }
        try {
            Camera.Parameters parameters = this.f146219a.getParameters();
            List<Integer> zoomRatios = parameters.getZoomRatios();
            if (zoomRatios != null && zoomRatios.size() > 0) {
                com.tencent.luggage.wxa.yp.b.a("BaseScanCamera", String.format("zoom to ratio:%d", Integer.valueOf(i3)));
                if (i3 >= zoomRatios.get(this.f146232n).intValue() && i3 <= zoomRatios.get(this.f146233o).intValue()) {
                    i16 = a(zoomRatios, i3);
                } else if (i3 < zoomRatios.get(this.f146232n).intValue()) {
                    i16 = this.f146232n;
                } else {
                    com.tencent.luggage.wxa.yp.b.c("BaseScanCamera", "exceed max zoom");
                    int i17 = this.f146231m;
                    int i18 = this.f146233o;
                    i16 = i17 + ((i18 - i17) / 5);
                    if (i16 > i18) {
                        i16 = i18;
                    }
                }
                com.tencent.luggage.wxa.yp.b.c("BaseScanCamera", String.format("zoom:%d,ratio:%d", Integer.valueOf(i16), zoomRatios.get(i16)));
                this.f146231m = i16;
                parameters.setZoom(i16);
                this.f146219a.setParameters(parameters);
            }
        } catch (Exception e16) {
            com.tencent.luggage.wxa.yp.b.b("BaseScanCamera", "zoom scale exception:" + e16.getMessage());
        }
    }

    @Override // com.tencent.luggage.wxa.z3.p
    public void a(Camera.PreviewCallback previewCallback) {
        Camera camera2 = this.f146219a;
        if (camera2 != null) {
            try {
                camera2.setOneShotPreviewCallback(previewCallback);
            } catch (RuntimeException e16) {
                com.tencent.luggage.wxa.yp.b.e("BaseScanCamera", "takeOneShot() " + e16.getMessage());
            }
        }
    }

    @Override // com.tencent.luggage.wxa.z3.p
    public void a(int i3) {
        boolean z16;
        if (this.f146220b) {
            com.tencent.luggage.wxa.yp.b.e("BaseScanCamera", "in open(), is open already");
            return;
        }
        if (this.f146234p) {
            com.tencent.luggage.wxa.yp.b.e("BaseScanCamera", "in open(). is background ignore");
            return;
        }
        int a16 = r.a();
        long currentTimeMillis = System.currentTimeMillis();
        q a17 = r.a(a16, i3);
        if (a17 == null) {
            com.tencent.luggage.wxa.yp.b.b("BaseScanCamera", "in open(), openCameraRes == null");
            return;
        }
        this.f146229k = false;
        this.f146230l = -1;
        int i16 = a17.f146265b;
        this.f146227i = i16;
        boolean z17 = true;
        this.f146226h = i16 % 180 != 0;
        com.tencent.luggage.wxa.yp.b.a("BaseScanCamera", String.format("openCamera done, cameraId=[%s] costTime=[%s] rotation[%d]", Integer.valueOf(a16), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(this.f146227i)));
        Camera camera2 = a17.f146264a;
        this.f146219a = camera2;
        if (camera2 == null) {
            com.tencent.luggage.wxa.yp.b.b("BaseScanCamera", "in open(), camera == null, bNeedRotate " + this.f146226h);
            return;
        }
        this.f146220b = true;
        Camera.Parameters parameters = this.f146219a.getParameters();
        a(parameters);
        List<Integer> supportedPreviewFormats = parameters.getSupportedPreviewFormats();
        com.tencent.luggage.wxa.yp.b.c("BaseScanCamera", "supportedPreviewFormat:" + supportedPreviewFormats);
        if (supportedPreviewFormats.contains(17)) {
            z16 = false;
        } else if (supportedPreviewFormats.contains(Integer.valueOf(IjkMediaPlayer.SDL_FCC_YV12))) {
            z16 = true;
            z17 = false;
        } else {
            z16 = false;
            z17 = false;
        }
        if (z17) {
            com.tencent.luggage.wxa.yp.b.c("BaseScanCamera", "Preview support NV21");
            parameters.setPreviewFormat(17);
        } else if (z16) {
            com.tencent.luggage.wxa.yp.b.c("BaseScanCamera", "Preview not support NV21, but support YV12");
            parameters.setPreviewFormat(IjkMediaPlayer.SDL_FCC_YV12);
        } else {
            com.tencent.luggage.wxa.yp.b.c("BaseScanCamera", "Preview not support NV21 and YV12. Use format: " + supportedPreviewFormats.get(0));
            parameters.setPreviewFormat(supportedPreviewFormats.get(0).intValue());
        }
        this.f146219a.setParameters(parameters);
        try {
            j();
        } catch (Exception e16) {
            com.tencent.luggage.wxa.yp.b.b("BaseScanCamera", "set focus mode error: " + e16.getMessage());
        }
    }

    @Override // com.tencent.luggage.wxa.z3.p
    public String c() {
        try {
            Camera camera2 = this.f146219a;
            return camera2 != null ? camera2.getParameters().getFocusMode() : "";
        } catch (Exception e16) {
            com.tencent.luggage.wxa.yp.b.e("BaseScanCamera", "getFocusMode() " + e16.getMessage());
            return "";
        }
    }

    @Override // com.tencent.luggage.wxa.z3.p
    public int a() {
        return this.f146227i;
    }

    public Rect a(Rect rect) {
        Rect rect2 = new Rect();
        com.tencent.luggage.wxa.yp.b.c("BaseScanCamera", String.format("visibleResolution:%s, previewResolution:%s", this.f146223e, this.f146224f));
        Point d16 = d(i() ? new Point(rect.right, rect.top) : new Point(rect.left, rect.top));
        Point d17 = d(i() ? new Point(rect.left, rect.bottom) : new Point(rect.right, rect.bottom));
        rect2.set(d16.x, d16.y, d17.x, d17.y);
        com.tencent.luggage.wxa.yp.b.c("BaseScanCamera", String.format("uiRect %s, scanRect %s", rect, rect2));
        return rect2;
    }

    @Override // com.tencent.luggage.wxa.z3.p
    public void a(Point point) {
        this.f146223e = new Point(point);
        com.tencent.luggage.wxa.yp.b.a("BaseScanCamera", "set visible resolution: " + this.f146223e);
        try {
            Point b16 = b(this.f146223e);
            this.f146222d = b16;
            this.f146224f = c(b16);
        } catch (Exception e16) {
            com.tencent.luggage.wxa.yp.b.b("BaseScanCamera", "set preview size" + e16.getMessage());
        }
    }

    public final Point a(Camera.Parameters parameters, Point point) {
        ArrayList<Camera.Size> arrayList = new ArrayList(parameters.getSupportedPreviewSizes());
        Point point2 = null;
        Collections.sort(arrayList, new b());
        arrayList.remove(0);
        int i3 = point.x;
        float f16 = i3 / point.y;
        com.tencent.luggage.wxa.yp.b.a("BaseScanCamera", String.format("visible.x: %d, visible.y: %d, ratio: %f", Integer.valueOf(i3), Integer.valueOf(point.y), Float.valueOf(f16)));
        com.tencent.luggage.wxa.yp.b.c("BaseScanCamera", String.format("SCREEN_PIXELS: %s", Integer.valueOf(point.x * point.y)));
        float f17 = Float.POSITIVE_INFINITY;
        for (Camera.Size size : arrayList) {
            int i16 = size.width;
            int i17 = size.height;
            com.tencent.luggage.wxa.yp.b.c("BaseScanCamera", String.format("realWidth: %d, realHeight: %d", Integer.valueOf(i16), Integer.valueOf(i17)));
            int min = !i() ? i16 : Math.min(i16, i17);
            int max = !i() ? i17 : Math.max(i16, i17);
            com.tencent.luggage.wxa.yp.b.a("BaseScanCamera", String.format("maybeFlippedWidth: %d, maybeFlippedHeight: %d", Integer.valueOf(min), Integer.valueOf(max)));
            if (min == point.x && max == point.y) {
                Point point3 = new Point(i16, i17);
                com.tencent.luggage.wxa.yp.b.c("BaseScanCamera", "Found preview size exactly matching screen size: " + point3);
                return point3;
            }
            if (i16 * i17 >= 307200) {
                float abs = Math.abs((min / max) - f16);
                if (abs < f17) {
                    point2 = new Point(i16, i17);
                    f17 = abs;
                }
                com.tencent.luggage.wxa.yp.b.c("BaseScanCamera", String.format("diff:[%s] newdiff:[%s] w:[%s] h:[%s]", Float.valueOf(f17), Float.valueOf(abs), Integer.valueOf(i16), Integer.valueOf(i17)));
            }
        }
        if (point2 == null) {
            Camera.Size previewSize = parameters.getPreviewSize();
            point2 = new Point(previewSize.width, previewSize.height);
            com.tencent.luggage.wxa.yp.b.c("BaseScanCamera", "No suitable preview sizes, using default: " + point2);
        }
        com.tencent.luggage.wxa.yp.b.c("BaseScanCamera", "Found best approximate preview size: " + point2);
        return point2;
    }

    public final void a(Camera.Parameters parameters) {
        try {
            if (this.f146219a != null) {
                String str = parameters.get("zoom-supported");
                if (!ScanUtil.isNullOrNil(str) && Boolean.parseBoolean(str)) {
                    List<Integer> zoomRatios = parameters.getZoomRatios();
                    if (zoomRatios != null && zoomRatios.size() > 0) {
                        this.f146232n = 0;
                        this.f146233o = (int) (zoomRatios.size() / 1.5d);
                        com.tencent.luggage.wxa.yp.b.a("BaseScanCamera", String.format("divideRatio: %f,max zoom: %d", Double.valueOf(1.5d), Integer.valueOf(this.f146233o)));
                        int i3 = this.f146233o;
                        int i16 = this.f146232n;
                        if (i3 < i16) {
                            this.f146233o = i16;
                        } else if (zoomRatios.get(i3).intValue() > 400) {
                            this.f146233o = a(zoomRatios, 400);
                        }
                        com.tencent.luggage.wxa.yp.b.c("BaseScanCamera", String.format("default zoom:%d,default ratio:%d,max zoom:%d,max ratio:%d", Integer.valueOf(this.f146232n), zoomRatios.get(this.f146232n), Integer.valueOf(this.f146233o), zoomRatios.get(this.f146233o)));
                        return;
                    }
                    return;
                }
                com.tencent.luggage.wxa.yp.b.c("BaseScanCamera", "not support zoom");
            }
        } catch (Exception e16) {
            com.tencent.luggage.wxa.yp.b.b("BaseScanCamera", "init zoom exception! " + e16.getMessage());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0074, code lost:
    
        if ((((java.lang.Integer) r7.get(r1)).intValue() - r8) > (r8 - ((java.lang.Integer) r7.get(r2)).intValue())) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int a(List list, int i3) {
        if (list == null || list.size() <= 0) {
            return 0;
        }
        com.tencent.luggage.wxa.yp.b.c("BaseScanCamera", String.format("zoomRatios: %s,size: %d", list, Integer.valueOf(list.size())));
        int binarySearch = Collections.binarySearch(list, Integer.valueOf(i3));
        com.tencent.luggage.wxa.yp.b.c("BaseScanCamera", "insert index: " + binarySearch);
        if (binarySearch < 0) {
            binarySearch = -(binarySearch + 1);
            int i16 = binarySearch - 1;
            if (binarySearch < 0 || binarySearch > list.size() - 1 || i16 < 0 || i16 > list.size() - 1) {
                if (binarySearch < 0 || binarySearch > list.size() - 1) {
                    if (i16 < 0 || i16 > list.size() - 1) {
                        return 0;
                    }
                    return i16;
                }
            }
        }
        return binarySearch;
    }

    @Override // com.tencent.luggage.wxa.z3.p
    public void a(Camera.AutoFocusCallback autoFocusCallback) {
        if (this.f146219a == null || !this.f146221c) {
            return;
        }
        try {
            this.f146219a.autoFocus(autoFocusCallback);
        } catch (Exception e16) {
            com.tencent.luggage.wxa.yp.b.e("BaseScanCamera", "autoFocus() " + e16.getMessage());
        }
    }

    @Override // com.tencent.luggage.wxa.z3.p
    public void a(String str) {
        Camera.Parameters parameters;
        List<String> supportedFocusModes;
        try {
            Camera camera2 = this.f146219a;
            if (camera2 == null || (supportedFocusModes = (parameters = camera2.getParameters()).getSupportedFocusModes()) == null || !supportedFocusModes.contains(str)) {
                return;
            }
            parameters.setFocusMode(str);
            this.f146219a.setParameters(parameters);
        } catch (Exception e16) {
            com.tencent.luggage.wxa.yp.b.e("BaseScanCamera", "setFocusMode " + e16.getMessage());
        }
    }

    @Override // com.tencent.luggage.wxa.z3.p
    public void a(boolean z16) {
        this.f146234p = z16;
    }
}
