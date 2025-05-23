package com.tencent.mobileqq.zplan.cc.camera;

import android.app.Activity;
import android.graphics.Point;
import android.hardware.Camera;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes35.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f332503a = "b";

    /* renamed from: b, reason: collision with root package name */
    public static Camera.Parameters f332504b;

    /* renamed from: c, reason: collision with root package name */
    private static final SimpleDateFormat f332505c = new SimpleDateFormat("'IMG'_yyyyMMdd_HHmmss");

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class a implements Comparator<Camera.Size> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Camera.Size size, Camera.Size size2) {
            return size2.width - size.width;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.zplan.cc.camera.b$b, reason: collision with other inner class name */
    /* loaded from: classes35.dex */
    private static class C9160b {

        /* renamed from: a, reason: collision with root package name */
        public int f332506a;

        /* renamed from: b, reason: collision with root package name */
        public Camera.Size f332507b;

        public C9160b(int i3, Camera.Size size) {
            this.f332506a = i3;
            this.f332507b = size;
        }

        public String toString() {
            return "CandidateSize{index=" + this.f332506a + ", size=" + this.f332507b + '}';
        }
    }

    public static int a() {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i3 = 0; i3 < numberOfCameras; i3++) {
            Camera.getCameraInfo(i3, cameraInfo);
            if (cameraInfo.facing == 0) {
                return i3;
            }
        }
        return -1;
    }

    public static int b() {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i3 = 0; i3 < numberOfCameras; i3++) {
            Camera.getCameraInfo(i3, cameraInfo);
            if (cameraInfo.facing == 1) {
                return i3;
            }
        }
        return -1;
    }

    public static Point c(Activity activity, Point point) {
        activity.getWindowManager().getDefaultDisplay().getSize(point);
        return point;
    }

    public static float d(Activity activity) {
        Point c16 = c(activity, new Point());
        return c16.x / c16.y;
    }

    public static Camera.Size e(Point point, List<Camera.Size> list, float f16) {
        String str = f332503a;
        Log.d(str, "[getOptimalPreviewSize] + BEGIN");
        double d16 = f16 == 1.0f ? 0.75d : f16;
        if (list != null && !list.isEmpty() && d16 > 0.0d) {
            Log.d(str, "[getOptimalPreviewSize] screen size = " + point);
            int max = Math.max(point.x, point.y);
            int min = Math.min(point.x, point.y);
            double d17 = (double) ((((float) min) * 1.0f) / ((float) max));
            Log.d(str, "[getOptimalPreviewSize] screenShortSide = " + min + ", screenLongSide = " + max + ", screenRatio = " + d17);
            if (d16 == 0.5625d) {
                d16 = d17;
            }
            Collections.sort(list, new a());
            ArrayList arrayList = new ArrayList();
            Log.v(str, "[getOptimalPreviewSize] try to find an high match size, targetRatio = " + d16);
            for (int i3 = 0; i3 < list.size(); i3++) {
                Camera.Size size = list.get(i3);
                int min2 = Math.min(size.width, size.height);
                int max2 = Math.max(size.width, size.height);
                ArrayList arrayList2 = arrayList;
                double d18 = min2 / max2;
                if (Math.abs(d18 - d16) > 0.02d) {
                    Log.w(f332503a, "[getOptimalPreviewSize] i = " + i3 + ", size = " + size.width + " * " + size.height + ", ratio = " + d18 + ", over ASPECT_TOLERANCE");
                } else if (max2 < min / 2) {
                    Log.w(f332503a, "[getOptimalPreviewSize] i = " + i3 + ", size = " + size.width + " * " + size.height + ", ratio = " + d18 + " is right, but size is too small, do SKIP");
                } else if (max2 >= max * 2) {
                    Log.w(f332503a, "[getOptimalPreviewSize] i = " + i3 + ", size = " + size.width + " * " + size.height + ", ratio = " + d18 + " is right, but size is too large, do SKIP");
                } else {
                    Log.i(f332503a, "[getOptimalPreviewSize] i = " + i3 + ", size = " + size.width + " * " + size.height + ", ratio = " + d18 + ", add to candidateList");
                    arrayList = arrayList2;
                    arrayList.add(new C9160b(i3, size));
                }
                arrayList = arrayList2;
            }
            String str2 = f332503a;
            Log.i(str2, "[getOptimalPreviewSize] candidateList.size = " + arrayList.size());
            if (!arrayList.isEmpty()) {
                C9160b c9160b = (C9160b) arrayList.get(0);
                Camera.Size size2 = c9160b.f332507b;
                int max3 = Math.max(size2.width, size2.height);
                Camera.Size size3 = c9160b.f332507b;
                Log.i(str2, "[getOptimalPreviewSize] find match high candidate size = " + max3 + " * " + Math.min(size3.width, size3.height));
                return c9160b.f332507b;
            }
            Log.v(str2, "[getOptimalPreviewSize] cannot find high match size, try to find a size over screen size");
            for (int i16 = 0; i16 < list.size(); i16++) {
                Camera.Size size4 = list.get(i16);
                int min3 = Math.min(size4.width, size4.height);
                int max4 = Math.max(size4.width, size4.height);
                if (min3 >= min && max4 >= max) {
                    arrayList.add(new C9160b(i16, size4));
                    Log.d(f332503a, "[getOptimalPreviewSize] i = " + i16 + ", over screen size = " + max4 + " * " + min3 + ", add to candidateList");
                }
            }
            String str3 = f332503a;
            Log.i(str3, "[getOptimalPreviewSize] candidateList.size = " + arrayList.size());
            if (!arrayList.isEmpty()) {
                C9160b c9160b2 = (C9160b) arrayList.get(arrayList.size() - 1);
                Camera.Size size5 = c9160b2.f332507b;
                int max5 = Math.max(size5.width, size5.height);
                Camera.Size size6 = c9160b2.f332507b;
                Log.i(str3, "[getOptimalPreviewSize] + END, find first over screen size = " + max5 + " * " + Math.min(size6.width, size6.height));
                return c9160b2.f332507b;
            }
            Camera.Size size7 = list.get(0);
            Log.i(str3, "[getOptimalPreviewSize] + END, cannot find high match and over screen size, return first max size = " + Math.max(size7.width, size7.height) + " * " + Math.min(size7.width, size7.height));
            return size7;
        }
        Log.e(str, "[getOptimalPreviewSize] supported list is empty");
        return null;
    }

    public static int[] g(List<int[]> list) {
        if (list != null && list.size() != 0) {
            int i3 = 400000;
            for (int[] iArr : list) {
                int i16 = iArr[0];
                if (iArr[1] >= 30000 && i16 <= 30000 && i16 < i3) {
                    i3 = i16;
                }
            }
            int i17 = -1;
            int i18 = 0;
            for (int i19 = 0; i19 < list.size(); i19++) {
                int[] iArr2 = list.get(i19);
                int i26 = iArr2[0];
                int i27 = iArr2[1];
                if (i26 == i3 && i18 < i27) {
                    i17 = i19;
                    i18 = i27;
                }
            }
            if (i17 >= 0) {
                return list.get(i17);
            }
        }
        return null;
    }

    public static int[] f(Camera.Parameters parameters) {
        if (parameters == null) {
            return null;
        }
        return g(parameters.getSupportedPreviewFpsRange());
    }
}
