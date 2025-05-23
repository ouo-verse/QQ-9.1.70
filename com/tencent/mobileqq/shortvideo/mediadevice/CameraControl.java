package com.tencent.mobileqq.shortvideo.mediadevice;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import com.tencent.aelight.camera.api.ICameraCompatible;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.richmedia.f;
import com.tencent.mobileqq.activity.richmedia.view.CameraCover;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.bm;
import com.tencent.qmethod.pandoraex.monitor.CameraMonitor;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.DebugKt;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: P */
@TargetApi(11)
/* loaded from: classes18.dex */
public class CameraControl extends yq2.b {

    /* renamed from: p, reason: collision with root package name */
    public static String f288075p = "CameraControl";

    /* renamed from: q, reason: collision with root package name */
    public static double f288076q = 0.009999999776482582d;

    /* renamed from: r, reason: collision with root package name */
    static CameraControl f288077r = null;

    /* renamed from: s, reason: collision with root package name */
    private static boolean f288078s = false;

    /* renamed from: t, reason: collision with root package name */
    private static ArrayList<Float> f288079t = new ArrayList<>();

    /* renamed from: u, reason: collision with root package name */
    private static boolean f288080u = false;

    /* renamed from: v, reason: collision with root package name */
    private static ArrayList<Float> f288081v = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    public Camera f288082c;

    /* renamed from: f, reason: collision with root package name */
    int f288085f;

    /* renamed from: g, reason: collision with root package name */
    b f288086g;

    /* renamed from: h, reason: collision with root package name */
    int[] f288087h;

    /* renamed from: i, reason: collision with root package name */
    int f288088i;

    /* renamed from: j, reason: collision with root package name */
    b f288089j;

    /* renamed from: k, reason: collision with root package name */
    boolean f288090k;

    /* renamed from: l, reason: collision with root package name */
    boolean f288091l;

    /* renamed from: n, reason: collision with root package name */
    private byte[] f288093n;

    /* renamed from: o, reason: collision with root package name */
    private byte[] f288094o;

    /* renamed from: d, reason: collision with root package name */
    a f288083d = new a();

    /* renamed from: e, reason: collision with root package name */
    public int f288084e = -1;

    /* renamed from: m, reason: collision with root package name */
    com.tencent.mobileqq.camera.a f288092m = com.tencent.mobileqq.camera.a.d();

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        int f288107a = -1;

        /* renamed from: b, reason: collision with root package name */
        int f288108b = -1;

        /* renamed from: c, reason: collision with root package name */
        int f288109c = -1;

        public a() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f288111a;

        /* renamed from: b, reason: collision with root package name */
        public int f288112b;

        /* renamed from: c, reason: collision with root package name */
        private double f288113c;

        public b() {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f288111a == bVar.f288111a && this.f288112b == bVar.f288112b) {
                return true;
            }
            return false;
        }

        public String toString() {
            return "CustomSize[width=" + this.f288111a + ", height=" + this.f288112b + ", scaleWH='" + this.f288113c + ']';
        }

        public b(int i3, int i16) {
            this.f288111a = i3;
            this.f288112b = i16;
            this.f288113c = i3 / i16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        byte[] f288114a;

        /* renamed from: b, reason: collision with root package name */
        File f288115b;

        /* renamed from: c, reason: collision with root package name */
        Rect f288116c;

        /* renamed from: d, reason: collision with root package name */
        CameraCover.a f288117d;

        /* renamed from: e, reason: collision with root package name */
        int f288118e;

        /* renamed from: f, reason: collision with root package name */
        int f288119f;

        /* renamed from: g, reason: collision with root package name */
        boolean f288120g;

        /* renamed from: h, reason: collision with root package name */
        int f288121h;

        /* renamed from: i, reason: collision with root package name */
        int f288122i;

        /* renamed from: j, reason: collision with root package name */
        Camera.Size f288123j;

        c() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    private class d extends AsyncTask<Void, Void, String> {

        /* renamed from: a, reason: collision with root package name */
        c f288125a;

        public d(c cVar) {
            this.f288125a = cVar;
            bm.a();
        }

        private String c() {
            boolean z16;
            c cVar = this.f288125a;
            byte[] bArr = cVar.f288114a;
            File file = cVar.f288115b;
            bm.a();
            if (file == null) {
                return null;
            }
            if (bArr != null) {
                CameraControl cameraControl = CameraControl.this;
                int f16 = com.tencent.mobileqq.camera.utils.a.f(cameraControl.f288092m, cameraControl.f288084e, this.f288125a.f288118e);
                if (QLog.isColorLevel()) {
                    QLog.i(CameraControl.f288075p, 2, "[onPictureTaken] mirror=" + this.f288125a.f288120g + " frontFlip=" + CameraControl.this.f288092m.b().l() + " jpegRotation=" + f16);
                }
                try {
                    CameraControl cameraControl2 = CameraControl.this;
                    c cVar2 = this.f288125a;
                    Camera.Size size = cVar2.f288123j;
                    boolean P = cameraControl2.P(size.width, size.height, cVar2.f288116c.width(), this.f288125a.f288116c.height());
                    if (this.f288125a.f288120g && !CameraControl.this.f288092m.b().l()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    boolean z17 = z16;
                    Bitmap a16 = com.tencent.mobileqq.camera.utils.a.a(bArr, this.f288125a.f288116c, z17, f16);
                    f.c("clip_rotate;");
                    BaseImageUtil.saveBitmapFileAsJPEG(a16, this.f288125a.f288121h, file);
                    c cVar3 = this.f288125a;
                    Camera.Size size2 = cVar3.f288123j;
                    f.n(false, size2.width, size2.height, cVar3.f288116c.width(), this.f288125a.f288116c.height(), P, f16, z17);
                    f.c("save jpg;");
                } catch (IOException e16) {
                    e16.printStackTrace();
                } catch (OutOfMemoryError e17) {
                    QLog.e(CameraControl.f288075p, 2, "[onPictureTaken] createBitmap failed orientation:" + this.f288125a.f288118e + ", " + e17.getMessage(), e17);
                }
            }
            bm.b(CameraControl.f288075p, "TakePictureTask_writeTmpFile_needClip");
            if (!file.exists()) {
                return null;
            }
            return file.getAbsolutePath();
        }

        private String d() {
            c cVar = this.f288125a;
            byte[] bArr = cVar.f288114a;
            Rect rect = cVar.f288116c;
            File file = cVar.f288115b;
            if (QLog.isColorLevel()) {
                QLog.i(CameraControl.f288075p, 2, "Do not clip photo");
            }
            bm.a();
            e(file, bArr);
            int i3 = 6;
            if (((ICameraCompatible) QRoute.api(ICameraCompatible.class)).isFoundProduct(com.tencent.aelight.camera.constants.a.f68996j)) {
                BaseImageUtil.updateExif(file.getAbsolutePath(), "Orientation", String.valueOf(6));
            } else if (((ICameraCompatible) QRoute.api(ICameraCompatible.class)).isFoundProduct(com.tencent.aelight.camera.constants.a.f68997k)) {
                int i16 = this.f288125a.f288118e % 360;
                if (i16 != 0) {
                    if (i16 != 90) {
                        if (i16 != 180) {
                            if (i16 == 270) {
                                i3 = 8;
                            }
                        } else {
                            i3 = 3;
                        }
                    }
                    BaseImageUtil.updateExif(file.getAbsolutePath(), "Orientation", String.valueOf(i3));
                }
                i3 = 0;
                BaseImageUtil.updateExif(file.getAbsolutePath(), "Orientation", String.valueOf(i3));
            }
            bm.b(CameraControl.f288075p, "TakePictureTask_writePhotoFile");
            if (file.exists()) {
                return file.getAbsolutePath();
            }
            return null;
        }

        private void e(File file, byte[] bArr) {
            FileOutputStream fileOutputStream;
            FileOutputStream fileOutputStream2 = null;
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Exception e16) {
                e = e16;
            }
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (Exception e17) {
                e = e17;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e18) {
                        e18.printStackTrace();
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String doInBackground(Void... voidArr) {
            int i3 = this.f288125a.f288122i;
            if (i3 == 0) {
                return d();
            }
            if (i3 == 1) {
                return c();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(String str) {
            bm.a();
            CameraCover.a aVar = this.f288125a.f288117d;
            if (aVar != null) {
                aVar.a(str);
                if (str == null && QLog.isColorLevel()) {
                    QLog.i(CameraControl.f288075p, 2, "Picture bitmap data error or output file not exist");
                }
            }
            bm.b(CameraControl.f288075p, "TakePictureTask_onPictureTokenCb");
            Camera camera2 = CameraControl.this.f288082c;
            if (camera2 != null) {
                try {
                    camera2.startPreview();
                    CameraControl.this.f288090k = true;
                } catch (RuntimeException e16) {
                    e16.printStackTrace();
                }
            } else if (QLog.isColorLevel()) {
                QLog.i(CameraControl.f288075p, 2, "[onPostExecute]mCamera is " + ((Object) null));
            }
            bm.b(CameraControl.f288075p, "TakePictureTask");
        }
    }

    private int C() {
        int bitsPerPixel = ImageFormat.getBitsPerPixel(this.f288085f);
        float f16 = (bitsPerPixel * 1.0f) / 8.0f;
        b bVar = this.f288086g;
        int i3 = (int) (bVar.f288112b * bVar.f288111a * f16);
        if (QLog.isColorLevel()) {
            QLog.i(f288075p, 2, "startPreview getPreviewBufferSize:bitpixel=" + bitsPerPixel + " byteNum=" + f16 + " bufSize=" + i3);
        }
        return i3;
    }

    private b G(List<Camera.Size> list, int i3, int i16, int i17, int i18) {
        int i19;
        double d16 = i18 / i17;
        if (QLog.isColorLevel()) {
            QLog.i(f288075p, 2, "[@] getPreviewSize[self-adaption] physicRatio=" + d16);
        }
        b bVar = new b();
        if (list != null && !list.isEmpty()) {
            long j3 = Long.MAX_VALUE;
            for (Camera.Size size : list) {
                if (size != null && (i19 = size.width) >= i3) {
                    int i26 = size.height;
                    if (i26 >= i16 && i19 / i26 >= d16) {
                        long j16 = i19 * i26;
                        if (j16 < j3) {
                            bVar.f288111a = i19;
                            bVar.f288112b = i26;
                            j3 = j16;
                        } else if (j16 == j3 && i19 < bVar.f288111a) {
                            bVar.f288111a = i19;
                            bVar.f288112b = i26;
                        }
                    }
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i(f288075p, 2, "[@] getPreviewSize[self-adaption] have no resolution >= (w*h)");
        }
        if ((bVar.f288111a <= 0 || bVar.f288112b <= 0) && list != null && !list.isEmpty()) {
            long j17 = 0;
            for (Camera.Size size2 : list) {
                if (size2 != null) {
                    int i27 = size2.width;
                    int i28 = size2.height;
                    if (i27 / i28 >= d16) {
                        long j18 = i27 * i28;
                        if (j18 > j17) {
                            bVar.f288111a = i27;
                            bVar.f288112b = i28;
                            j17 = j18;
                        } else if (j18 == j17 && i27 < bVar.f288111a) {
                            bVar.f288111a = i27;
                            bVar.f288112b = i28;
                        }
                    }
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i(f288075p, 2, "[@] getPreviewSize[self-adaption] cSize.width=" + bVar.f288111a + "  cSize.height=" + bVar.f288112b);
        }
        if (bVar.f288111a > 0 && bVar.f288112b > 0) {
            return bVar;
        }
        if (list != null && !list.isEmpty() && list.get(0) != null) {
            bVar.f288111a = list.get(0).width;
            bVar.f288112b = list.get(0).height;
            return bVar;
        }
        return null;
    }

    private int[] K(List<int[]> list) {
        int i3;
        int[] iArr = {0, 0};
        ArrayList arrayList = new ArrayList();
        int i16 = 0;
        for (int[] iArr2 : list) {
            if (iArr2 != null && iArr2.length >= 2 && (i3 = iArr2[1]) >= i16) {
                i16 = i3;
            }
        }
        if (i16 <= 0) {
            return null;
        }
        for (int[] iArr3 : list) {
            if (iArr3 != null && iArr3.length >= 2 && iArr3[1] == i16) {
                arrayList.add(iArr3);
            }
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        Iterator it = arrayList.iterator();
        int i17 = Integer.MAX_VALUE;
        int i18 = 0;
        while (it.hasNext()) {
            int i19 = ((int[]) it.next())[0];
            int i26 = i19 >= 15000 ? i19 - 15000 : 15000 - i19;
            if (i26 < i17) {
                i18 = i19;
                i17 = i26;
            }
        }
        if (i17 != Integer.MAX_VALUE) {
            iArr[0] = i18;
            iArr[1] = i16;
        } else {
            iArr[0] = i16;
            iArr[1] = i16;
        }
        if (iArr[0] <= 0 || iArr[1] <= 0) {
            return null;
        }
        return iArr;
    }

    private int[] M(List<int[]> list, int i3) {
        int i16;
        int i17;
        int i18;
        int i19;
        int[] iArr = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        for (int[] iArr2 : list) {
            if (iArr2 != null && iArr2.length >= 2 && (i18 = iArr2[0]) >= i3 && (i19 = iArr2[1]) < iArr[1]) {
                iArr[0] = i18;
                iArr[1] = i19;
            }
        }
        if (iArr[0] == Integer.MAX_VALUE || iArr[1] == Integer.MAX_VALUE) {
            iArr[1] = 0;
            iArr[0] = 0;
            for (int[] iArr3 : list) {
                if (iArr3 != null && iArr3.length >= 2 && (i16 = iArr3[0]) <= i3 && (i17 = iArr3[1]) > iArr[1]) {
                    iArr[0] = i16;
                    iArr[1] = i17;
                }
            }
        }
        if (iArr[0] != Integer.MAX_VALUE && iArr[1] != Integer.MAX_VALUE) {
            return iArr;
        }
        return null;
    }

    private boolean N(ArrayList<Camera.Size> arrayList, int i3, int i16) {
        if (arrayList != null && arrayList.size() > 0) {
            for (int i17 = 0; i17 < arrayList.size(); i17++) {
                Camera.Size size = arrayList.get(i17);
                if (size.width == i3 && size.height == i16) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void O(ArrayList<Float> arrayList) {
        List<Camera.Size> e16 = com.tencent.mobileqq.shortvideo.mediadevice.a.d().e();
        if (e16 != null) {
            for (Camera.Size size : e16) {
                float f16 = size.width / size.height;
                if (!arrayList.contains(Float.valueOf(f16))) {
                    arrayList.add(Float.valueOf(f16));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean P(int i3, int i16, int i17, int i18) {
        boolean z16;
        float max = Math.max(i3, i16) / Math.min(i3, i16);
        float max2 = Math.max(i17, i18) / Math.min(i17, i18);
        if (Math.abs(max2 - max) > f288076q) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.i(f288075p, 2, "needClip " + z16 + " screenRatio" + max2 + " previewRatio" + max);
        }
        return z16;
    }

    private void R(List<int[]> list) {
        if (list != null && list.size() > 0) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                int[] iArr = list.get(i3);
                if (iArr != null && iArr.length >= 2) {
                    if (QLog.isColorLevel()) {
                        QLog.i(f288075p, 2, "printFpsRange[i=" + i3 + " fps[low]=" + iArr[0] + " fps[high]=" + iArr[1] + "]");
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.i(f288075p, 2, "printFpsRange[i=" + i3 + " ele=null]");
                }
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(f288075p, 2, "printFpsRange[listFpsRange=null]");
        }
    }

    private boolean i(int i3) {
        if (i3 <= 0) {
            return false;
        }
        try {
            byte[] bArr = this.f288093n;
            if (bArr == null || bArr.length != i3) {
                this.f288093n = new byte[i3];
            }
            byte[] bArr2 = this.f288094o;
            if (bArr2 == null || bArr2.length != i3) {
                this.f288094o = new byte[i3];
                return true;
            }
            return true;
        } catch (OutOfMemoryError unused) {
            URLDrawable.clearMemoryCache();
            try {
                byte[] bArr3 = this.f288093n;
                if (bArr3 == null || bArr3.length != i3) {
                    this.f288093n = new byte[i3];
                }
                byte[] bArr4 = this.f288094o;
                if (bArr4 == null || bArr4.length != i3) {
                    this.f288094o = new byte[i3];
                    return true;
                }
                return true;
            } catch (OutOfMemoryError e16) {
                QLog.e(f288075p, 2, "allocateFrame failed , size:" + i3 + ", " + e16.getMessage());
                return false;
            }
        }
    }

    private boolean k() {
        return !((ICameraCompatible) QRoute.api(ICameraCompatible.class)).isFoundProduct(com.tencent.aelight.camera.constants.a.f68987a);
    }

    private boolean l(int i3, int i16, int i17, int i18, int i19) {
        if (i18 / i19 <= 1.0d) {
            return false;
        }
        if ((i16 * i19) / ((i17 * i19) / i18) < i3) {
            return false;
        }
        return true;
    }

    public static String m(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            return "unknown";
                        }
                        return "RM_CAMERA_GET_PARAM";
                    }
                    return "RM_CAMERA_OPEN_FAILED";
                }
                return "RM_CAMERA_COUNT_ZERO";
            }
            return "RM_CAMERA_USED_AV";
        }
        return "RM_CAMERA_OPEN_SUCCESS";
    }

    private int n(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                return com.tencent.mobileqq.shortvideo.mediadevice.a.b();
            }
            if (com.tencent.mobileqq.shortvideo.mediadevice.a.h()) {
                return com.tencent.mobileqq.shortvideo.mediadevice.a.b();
            }
        } else if (com.tencent.mobileqq.shortvideo.mediadevice.a.k()) {
            return com.tencent.mobileqq.shortvideo.mediadevice.a.c();
        }
        return -1;
    }

    private int[] q(List<int[]> list, int i3) {
        int[] K = K(list);
        if (K == null) {
            return M(list, i3);
        }
        return K;
    }

    private b s(List<Camera.Size> list, int i3, int i16) {
        int i17;
        if (QLog.isColorLevel()) {
            QLog.i(f288075p, 2, "[@] getHighVersionPreviewSize[wantedPreviewSize]: width=" + i3 + "  height=" + i16);
        }
        b bVar = new b();
        int i18 = -1;
        if (list != null && !list.isEmpty()) {
            for (Camera.Size size : list) {
                if (size != null && size.height == i16 && (i17 = size.width) >= i3 && (i18 < 0 || i17 <= i18)) {
                    i18 = i17;
                }
            }
        }
        if (i18 > 0) {
            bVar.f288112b = i16;
            bVar.f288111a = i18;
            if (i18 / 4 == i16 / 3) {
                if (QLog.isColorLevel()) {
                    QLog.i(f288075p, 2, "[@] getHighVersionPreviewSize[4:3]...");
                }
                return bVar;
            }
            if (QLog.isColorLevel()) {
                QLog.i(f288075p, 2, "[@] getHighVersionPreviewSize: RATIO_MUST_EQUAL=false");
            }
            return bVar;
        }
        return null;
    }

    private b t(List<Camera.Size> list, int i3, int i16, int i17, int i18, int i19, int i26) {
        if (QLog.isColorLevel()) {
            QLog.i(f288075p, 2, "[@] getHighVersionPreviewSizeV3[wantedPreviewSize]: width=" + i3 + "  height=" + i16);
        }
        float f16 = i3 / i16;
        ArrayList<b> arrayList = new ArrayList();
        ArrayList<b> arrayList2 = new ArrayList();
        if (list != null && !list.isEmpty()) {
            Iterator<Camera.Size> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Camera.Size next = it.next();
                if (next != null) {
                    int max = Math.max(next.width, next.height);
                    int min = Math.min(next.width, next.height);
                    if (next.height == i16 && max == i3) {
                        arrayList2.add(new b(i3, i16));
                        if (QLog.isColorLevel()) {
                            QLog.i(f288075p, 2, "[@] getHighVersionPreviewSizeV3 first: width=" + i3 + "  height=" + i16);
                        }
                    } else if (max > i19 && max < i17) {
                        if (min > i26 && min < i18) {
                            arrayList.add(new b(max, min));
                        }
                    }
                }
            }
        }
        float f17 = 10000.0f;
        if (arrayList2.size() == 0) {
            for (b bVar : arrayList) {
                if (bVar != null) {
                    float max2 = f16 - (Math.max(bVar.f288111a, bVar.f288112b) / Math.min(bVar.f288111a, bVar.f288112b));
                    if (Math.abs(max2) < f288076q) {
                        arrayList2.add(bVar);
                    }
                    if (Math.abs(max2) < f17) {
                        f17 = Math.abs(max2);
                    }
                }
            }
            if (QLog.isColorLevel()) {
                for (int i27 = 0; i27 < arrayList2.size(); i27++) {
                    QLog.i(f288075p, 2, "[@] getHighVersionPreviewSizeV2 secend: width=" + ((b) arrayList2.get(i27)).f288111a + " height=" + ((b) arrayList2.get(i27)).f288112b + " w/h=" + (((b) arrayList2.get(i27)).f288111a / ((b) arrayList2.get(i27)).f288112b));
                }
            }
        }
        if (arrayList2.size() == 0) {
            for (b bVar2 : arrayList) {
                if (bVar2 != null) {
                    if (Math.abs(Math.abs(f16 - (Math.max(bVar2.f288111a, bVar2.f288112b) / Math.min(bVar2.f288111a, bVar2.f288112b))) - f17) < f288076q) {
                        arrayList2.add(bVar2);
                    }
                }
            }
            if (QLog.isColorLevel()) {
                for (int i28 = 0; i28 < arrayList2.size(); i28++) {
                    QLog.i(f288075p, 2, "[@] getHighVersionPreviewSizeV2 third: width=" + ((b) arrayList2.get(i28)).f288111a + " height=" + ((b) arrayList2.get(i28)).f288112b + " w/h=" + (((b) arrayList2.get(i28)).f288111a / ((b) arrayList2.get(i28)).f288112b));
                }
            }
        }
        if (arrayList2.size() > 0) {
            b bVar3 = (b) arrayList2.get(0);
            for (b bVar4 : arrayList2) {
                if (bVar4 != null && bVar4.f288111a * bVar4.f288112b > bVar3.f288111a * bVar3.f288112b) {
                    bVar3 = bVar4;
                }
            }
            return bVar3;
        }
        return null;
    }

    public static CameraControl u() {
        if (f288077r == null) {
            synchronized (CameraControl.class) {
                if (f288077r == null) {
                    f288077r = new CameraControl();
                }
            }
        }
        return f288077r;
    }

    public b[] A(int i3, int i16, int i17, int i18) {
        if (QLog.isColorLevel()) {
            QLog.i(f288075p, 2, "[@] getPreviewAndPictureSizeV2 wanted size=" + i3 + " " + i16 + " cliped=" + i17 + " " + i18);
        }
        b[] bVarArr = new b[2];
        b I = I(i3, i16, i17, i18, true);
        if (I != null) {
            bVarArr[0] = I;
            if (QLog.isColorLevel()) {
                QLog.i(f288075p, 2, "[@] getPreviewAndPictureSizeGuarantee way2 preview=" + I.f288111a + " " + I.f288112b);
            }
            b x16 = x(I.f288111a, I.f288112b, i17, i18, 1);
            bVarArr[1] = x16;
            if (x16 != null) {
                if (QLog.isColorLevel()) {
                    QLog.i(f288075p, 2, "[@] getPreviewAndPictureSizeGuarantee way2 picture=" + x16.f288111a + " " + x16.f288112b);
                }
                f.m(true, I.f288111a, I.f288112b, x16.f288111a, x16.f288112b);
            } else {
                f.m(true, I.f288111a, I.f288112b, -1, -1);
            }
        }
        return bVarArr;
    }

    public b[] B(int i3, int i16, int i17, int i18) {
        if (QLog.isColorLevel()) {
            QLog.i(f288075p, 2, "[@] getPreviewAndPictureSizeV3 wanted size=" + i3 + " " + i16 + " cliped=" + i17 + " " + i18);
        }
        b[] bVarArr = new b[2];
        b J = J(i3, i16, i17, i18, true);
        if (J != null) {
            bVarArr[0] = J;
            if (QLog.isColorLevel()) {
                QLog.i(f288075p, 2, "[@] getPreviewAndPictureSizeGuarantee way2 preview=" + J.f288111a + " " + J.f288112b);
            }
            b x16 = x(J.f288111a, J.f288112b, i17, i18, 1);
            bVarArr[1] = x16;
            if (x16 != null) {
                if (QLog.isColorLevel()) {
                    QLog.i(f288075p, 2, "[@] getPreviewAndPictureSizeGuarantee way2 picture=" + x16.f288111a + " " + x16.f288112b);
                }
                f.m(true, J.f288111a, J.f288112b, x16.f288111a, x16.f288112b);
            } else {
                f.m(true, J.f288111a, J.f288112b, -1, -1);
            }
        }
        return bVarArr;
    }

    public int D() {
        return this.f288085f;
    }

    public int[] E() {
        return this.f288087h;
    }

    public int F() {
        int i3 = this.f288088i;
        if (com.tencent.mobileqq.activity.richmedia.c.f185845b == 1) {
            if (i3 == 270) {
                i3 -= 180;
            } else {
                i3 += 180;
            }
            if (QLog.isColorLevel()) {
                QLog.i(f288075p, 2, "getPreviewOrientation:blackPhone= orientation=" + i3);
            }
        }
        return i3;
    }

    public b H(int i3, int i16, int i17, int i18, boolean z16) {
        int i19;
        if (QLog.isColorLevel()) {
            QLog.i(f288075p, 2, "[@] getPreviewSizeGuaranteeOK: dstwidth=" + i3 + "  dstheight=" + i16);
        }
        List<Camera.Size> g16 = com.tencent.mobileqq.shortvideo.mediadevice.a.d().g();
        int i26 = 0;
        if (QLog.isColorLevel() && g16 != null) {
            for (int i27 = 0; i27 < g16.size(); i27++) {
                QLog.i(f288075p, 2, "[@] getPreviewSizeGuaranteeOK[list]: width=" + g16.get(i27).width + " height=" + g16.get(i27).height + " w/h=" + (g16.get(i27).width / g16.get(i27).height));
            }
        }
        b s16 = s(g16, yq2.a.f450989f, yq2.a.f450990g);
        if (s16 != null) {
            if (QLog.isColorLevel()) {
                QLog.i(f288075p, 2, "[@] getPreviewSizeGuaranteeOK: DEFAULT resolution os OK.");
            }
            if (z16) {
                f.j(2, yq2.a.f450989f, yq2.a.f450990g, s16.f288111a, s16.f288112b);
            }
            return s16;
        }
        if (QLog.isColorLevel()) {
            QLog.i(f288075p, 2, "[@] getPreviewSizeGuaranteeOK: Degeneration to 640*480...");
        }
        b s17 = s(g16, yq2.a.f450991h[1], yq2.a.f450992i[1]);
        if (s17 != null) {
            if (QLog.isColorLevel()) {
                QLog.i(f288075p, 2, "[@] getPreviewSizeGuaranteeOK: 640*480 resolution os OK.");
            }
            if (z16) {
                f.j(3, yq2.a.f450989f, yq2.a.f450990g, s17.f288111a, s17.f288112b);
            }
            return s17;
        }
        b G = G(g16, i3, i16, i17, i18);
        if (z16) {
            if (G == null) {
                i19 = 0;
            } else {
                i19 = G.f288111a;
            }
            if (G != null) {
                i26 = G.f288112b;
            }
            f.j(4, yq2.a.f450989f, yq2.a.f450990g, i19, i26);
        }
        return G;
    }

    public b I(int i3, int i16, int i17, int i18, boolean z16) {
        int i19;
        if (QLog.isColorLevel()) {
            QLog.i(f288075p, 2, "[@] getPreviewSizeV2: dstwidth=" + i3 + "  dstheight=" + i16);
        }
        List<Camera.Size> g16 = com.tencent.mobileqq.shortvideo.mediadevice.a.d().g();
        int i26 = 0;
        if (QLog.isColorLevel() && g16 != null) {
            for (int i27 = 0; i27 < g16.size(); i27++) {
                QLog.i(f288075p, 2, "[@] getPreviewSizeGuaranteeOK[list]: width=" + g16.get(i27).width + " height=" + g16.get(i27).height + " w/h=" + (g16.get(i27).width / g16.get(i27).height));
            }
        }
        b s16 = s(g16, i3, i16);
        if (s16 != null) {
            if (QLog.isColorLevel()) {
                QLog.i(f288075p, 2, "[@] getPreviewSizeGuaranteeOK: DEFAULT resolution os OK.");
            }
            if (z16) {
                f.j(2, i3, i16, s16.f288111a, s16.f288112b);
            }
            return s16;
        }
        b s17 = s(g16, 960, 720);
        if (s17 != null) {
            if (QLog.isColorLevel()) {
                QLog.i(f288075p, 2, "[@] getPreviewSizeGuaranteeOK: 640*480 resolution os OK.");
            }
            if (z16) {
                f.j(3, i3, i16, s17.f288111a, s17.f288112b);
            }
            return s17;
        }
        b G = G(g16, i3, i16, i17, i18);
        if (z16) {
            if (G == null) {
                i19 = 0;
            } else {
                i19 = G.f288111a;
            }
            if (G != null) {
                i26 = G.f288112b;
            }
            f.j(4, i3, i16, i19, i26);
        }
        return G;
    }

    public b J(int i3, int i16, int i17, int i18, boolean z16) {
        int i19;
        if (QLog.isColorLevel()) {
            QLog.i(f288075p, 2, "[@] getPreviewSizeV3: dstwidth=" + i3 + "  dstheight=" + i16);
        }
        List<Camera.Size> g16 = com.tencent.mobileqq.shortvideo.mediadevice.a.d().g();
        int i26 = 0;
        if (QLog.isColorLevel() && g16 != null) {
            for (int i27 = 0; i27 < g16.size(); i27++) {
                QLog.i(f288075p, 2, "[@] getPreviewSizeGuaranteeOK[list]: width=" + g16.get(i27).width + " height=" + g16.get(i27).height + " w/h=" + (g16.get(i27).width / g16.get(i27).height));
            }
        }
        float f16 = (i3 * 1.0f) / i16;
        float f17 = 1000.0f;
        float f18 = f16 * 1000.0f;
        if (f18 > 1700.0f) {
            f18 = 1700.0f;
        }
        b t16 = t(g16, i3, i16, 2600, 1500, (int) f18, 1000);
        if (t16 != null) {
            if (QLog.isColorLevel()) {
                QLog.i(f288075p, 2, "[@] getPreviewSizeGuaranteeOK: DEFAULT resolution os OK.");
            }
            if (z16) {
                f.j(2, i3, i16, t16.f288111a, t16.f288112b);
            }
            return t16;
        }
        float f19 = f16 * 700.0f;
        if (f19 <= 1000.0f) {
            f17 = f19;
        }
        b t17 = t(g16, i3, i16, 2600, 1500, (int) f17, 700);
        if (t17 != null) {
            if (QLog.isColorLevel()) {
                QLog.i(f288075p, 2, "[@] getPreviewSizeGuaranteeOK: 640*480 resolution os OK.");
            }
            if (z16) {
                f.j(3, i3, i16, t17.f288111a, t17.f288112b);
            }
            return t17;
        }
        b G = G(g16, i3, i16, i17, i18);
        if (z16) {
            if (G == null) {
                i19 = 0;
            } else {
                i19 = G.f288111a;
            }
            if (G != null) {
                i26 = G.f288112b;
            }
            f.j(4, i3, i16, i19, i26);
        }
        return G;
    }

    public b L(int i3) {
        List<Camera.Size> g16 = com.tencent.mobileqq.shortvideo.mediadevice.a.d().g();
        if (QLog.isColorLevel() && g16 != null) {
            for (int i16 = 0; i16 < g16.size(); i16++) {
                QLog.i(f288075p, 2, "[@] getStarPhotoPreviewSize[list]: width=" + g16.get(i16).width + " height=" + g16.get(i16).height + " w/h=" + (g16.get(i16).width / g16.get(i16).height));
            }
        }
        ArrayList<Camera.Size> arrayList = new ArrayList();
        b bVar = new b();
        if (g16 != null && g16.size() > 0) {
            for (Camera.Size size : g16) {
                if (size != null && size.height >= i3) {
                    arrayList.add(size);
                }
            }
        }
        if (arrayList.size() > 0) {
            int i17 = Integer.MAX_VALUE;
            for (Camera.Size size2 : arrayList) {
                int i18 = size2.width;
                if (i18 < i17) {
                    bVar.f288112b = size2.height;
                    bVar.f288111a = i18;
                    i17 = i18;
                }
            }
        }
        if (bVar.f288111a > 0) {
            return bVar;
        }
        return null;
    }

    public int Q(int i3) {
        if (com.tencent.mobileqq.activity.richmedia.d.a()) {
            return 1;
        }
        if (!com.tencent.mobileqq.shortvideo.mediadevice.a.i()) {
            if (QLog.isColorLevel()) {
                QLog.i(f288075p, 2, "[@] openCamera[failed]hasCameras=false");
            }
            return 2;
        }
        if (this.f288091l) {
            if (QLog.isColorLevel()) {
                QLog.i(f288075p, 2, "[openCamera]Camera is opened, Camera object " + this.f288082c);
                return 5;
            }
            return 5;
        }
        int i16 = 0;
        int i17 = 0;
        while (true) {
            if (i16 >= 10) {
                break;
            }
            try {
                this.f288084e = n(i3);
                if (VersionUtils.isGingerBread()) {
                    if (QLog.isColorLevel()) {
                        QLog.d(f288075p, 2, "openCamera:currentCount= " + i16);
                    }
                    ms.a.f(f288075p, "\u3010Real Old openCamera\u3011:" + this.f288084e);
                    ms.a.f(f288075p, "\u3010Real Old openCamera\u3011:currentCount= " + i16);
                    this.f288082c = CameraMonitor.open(this.f288084e);
                } else {
                    this.f288082c = CameraMonitor.open();
                }
                i17 = 0;
            } catch (Exception e16) {
                e16.printStackTrace();
                this.f288082c = null;
                i16++;
                if (QLog.isColorLevel()) {
                    QLog.i(f288075p, 2, "[@] openCamera[failed][RM_CAMERA_OPEN_FAILED]currentCount=" + i16, e16);
                }
                if (i16 < 10) {
                    try {
                        LockMethodProxy.sleep(300L);
                    } catch (InterruptedException unused) {
                    }
                }
                i17 = 3;
            }
        }
        if (this.f288082c == null) {
            return i17;
        }
        if (!com.tencent.mobileqq.shortvideo.mediadevice.a.d().a(this.f288082c)) {
            if (QLog.isColorLevel()) {
                QLog.i(f288075p, 2, "[@] openCamera[failed]bindCamera=false");
                return 4;
            }
            return 4;
        }
        this.f288083d = new a();
        this.f288091l = true;
        return 0;
    }

    @TargetApi(14)
    public void S() {
        if (QLog.isColorLevel()) {
            QLog.i(f288075p, 2, "release camera");
        }
        if (!this.f288091l) {
            return;
        }
        com.tencent.mobileqq.shortvideo.mediadevice.a.d().p();
        if (this.f288082c == null) {
            return;
        }
        l0();
        try {
            this.f288082c.release();
            this.f288082c = null;
            this.f288085f = -1;
            this.f288087h = null;
            this.f288086g = null;
            this.f288091l = false;
            T();
        } catch (Exception unused) {
        }
    }

    public void T() {
        this.f288093n = null;
        this.f288094o = null;
        if (QLog.isColorLevel()) {
            QLog.i(f288075p, 2, "releasePreviewFrameBuffer");
        }
    }

    public boolean U(CameraProxy.g gVar) {
        Camera.Parameters o16 = o();
        if (o16 == null) {
            if (QLog.isColorLevel()) {
                QLog.i(f288075p, 2, "[@] setParamsPreviewFormat[failed]getCameraParameters=null");
            }
            return false;
        }
        o16.setPreviewFormat(gVar.f288162b);
        b bVar = gVar.f288165e;
        o16.setPreviewSize(bVar.f288111a, bVar.f288112b);
        o16.setPreviewFpsRange(gVar.f288163c, gVar.f288164d);
        if (gVar.f288166f) {
            b bVar2 = gVar.f288167g;
            o16.setPictureSize(bVar2.f288111a, bVar2.f288112b);
        }
        boolean V = V(o16);
        if (V) {
            this.f288085f = gVar.f288162b;
            this.f288086g = gVar.f288165e;
            this.f288087h = new int[]{gVar.f288163c, gVar.f288164d};
            this.f288089j = gVar.f288167g;
        }
        return V;
    }

    public boolean V(Camera.Parameters parameters) {
        if (parameters == null) {
            return false;
        }
        try {
            this.f288082c.setParameters(parameters);
            return true;
        } catch (Exception e16) {
            QLog.e(f288075p, 2, e16, new Object[0]);
            return false;
        }
    }

    public boolean W() {
        boolean z16;
        boolean isFoundProduct;
        boolean z17;
        String upperCase = DeviceInfoMonitor.getModel().toUpperCase();
        if (Build.MANUFACTURER.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HUAWEI) && (upperCase.contains("RLI-AN00") || upperCase.contains("RLI-N29") || upperCase.contains("TAH-AN00") || upperCase.contains("TAH-N29"))) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i3 = 90;
        if (z16 || Build.VERSION.SDK_INT >= 28) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(this.f288084e, cameraInfo);
            int rotation = ((WindowManager) BaseApplicationImpl.getApplication().getSystemService("window")).getDefaultDisplay().getRotation();
            if (rotation != 0) {
                if (rotation != 1) {
                    if (rotation != 2) {
                        if (rotation == 3) {
                            i3 = 270;
                        }
                    } else {
                        i3 = 180;
                    }
                }
            } else {
                i3 = 0;
            }
            if (cameraInfo.facing == 1) {
                i3 = (360 - ((cameraInfo.orientation + i3) % 360)) % 360;
            } else {
                i3 = ((cameraInfo.orientation - i3) + 360) % 360;
            }
        }
        try {
            if (this.f288084e == 1) {
                isFoundProduct = ((ICameraCompatible) QRoute.api(ICameraCompatible.class)).isFoundProduct(com.tencent.aelight.camera.constants.a.f68991e);
                z17 = ((ICameraCompatible) QRoute.api(ICameraCompatible.class)).isFoundProductFeatureRom(com.tencent.aelight.camera.constants.a.f68992f);
                if (isFoundProduct || z17) {
                    i3 += 180;
                }
            } else {
                isFoundProduct = ((ICameraCompatible) QRoute.api(ICameraCompatible.class)).isFoundProduct(com.tencent.aelight.camera.constants.a.f68993g);
                if (isFoundProduct) {
                    i3 += 180;
                }
                z17 = false;
            }
            this.f288082c.setDisplayOrientation(i3);
            this.f288088i = i3;
            if (QLog.isColorLevel()) {
                QLog.i(f288075p, 2, "setDisplayOrientation degrees=" + i3 + " blackPhone=" + isFoundProduct + " camera=" + com.tencent.mobileqq.activity.richmedia.c.f185845b + " rom_black=" + z17);
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @TargetApi(14)
    public void X(Camera.FaceDetectionListener faceDetectionListener) {
        try {
            this.f288082c.setFaceDetectionListener(faceDetectionListener);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (QLog.isColorLevel()) {
            QLog.i(f288075p, 2, "setFaceDetectionListener");
        }
    }

    public boolean Y(String str) {
        boolean z16 = false;
        if (!k()) {
            return false;
        }
        try {
            this.f288082c.cancelAutoFocus();
        } catch (RuntimeException e16) {
            if (QLog.isColorLevel()) {
                QLog.i(f288075p, 2, "", e16);
            }
        }
        Camera.Parameters o16 = o();
        if (o16 == null) {
            return false;
        }
        String focusMode = o16.getFocusMode();
        if (QLog.isColorLevel()) {
            QLog.i(f288075p, 2, "[@] setParamsFocusMode getFocusMode=" + focusMode);
        }
        if (focusMode != null && focusMode.equals(str)) {
            return true;
        }
        boolean m3 = com.tencent.mobileqq.shortvideo.mediadevice.a.d().m(str);
        if (m3) {
            o16.setFocusMode(str);
            z16 = V(o16);
        }
        if (QLog.isColorLevel()) {
            QLog.i(f288075p, 2, "[@] setParamsFocusMode support=" + m3 + " success=" + z16 + " setTo=" + str);
        }
        return z16;
    }

    public boolean Z() {
        Camera.Parameters o16 = o();
        if (o16 == null) {
            if (QLog.isColorLevel()) {
                QLog.i(f288075p, 2, "[@] setParamsPreviewFormat[failed]getCameraParameters=null");
            }
            return false;
        }
        if (com.tencent.mobileqq.shortvideo.mediadevice.a.d().n(17)) {
            o16.setPreviewFormat(17);
            this.f288085f = 17;
            boolean V = V(o16);
            if (QLog.isColorLevel()) {
                QLog.i(f288075p, 2, "[@] setParamsPreviewFormat:success=" + V + ", isSupportPreviewFormat=NV21 ok");
            }
            return V;
        }
        if (com.tencent.mobileqq.shortvideo.mediadevice.a.d().n(IjkMediaPlayer.SDL_FCC_YV12)) {
            o16.setPreviewFormat(IjkMediaPlayer.SDL_FCC_YV12);
            this.f288085f = IjkMediaPlayer.SDL_FCC_YV12;
            boolean V2 = V(o16);
            if (QLog.isColorLevel()) {
                QLog.i(f288075p, 2, "[@] setParamsPreviewFormat:success=" + V2 + "isSupportPreviewFormat=YV12 OK");
            }
            return V2;
        }
        if (com.tencent.mobileqq.shortvideo.mediadevice.a.d().n(20)) {
            o16.setPreviewFormat(20);
            this.f288085f = 20;
            boolean V3 = V(o16);
            if (QLog.isColorLevel()) {
                QLog.i(f288075p, 2, "[@] setParamsPreviewFormat:success=" + V3 + "isSupportPreviewFormat=YUY2 OK");
            }
            return V3;
        }
        if (com.tencent.mobileqq.shortvideo.mediadevice.a.d().n(4)) {
            o16.setPreviewFormat(4);
            this.f288085f = 4;
            boolean V4 = V(o16);
            if (QLog.isColorLevel()) {
                QLog.i(f288075p, 2, "[@] setParamsPreviewFormat:success=" + V4 + "isSupportPreviewFormat=RGB_565 OK");
            }
            return V4;
        }
        if (com.tencent.mobileqq.shortvideo.mediadevice.a.d().n(256)) {
            o16.setPreviewFormat(256);
            this.f288085f = 256;
            boolean V5 = V(o16);
            if (QLog.isColorLevel()) {
                QLog.i(f288075p, 2, "[@] setParamsPreviewFormat:success=" + V5 + "isSupportPreviewFormat=JPEG OK");
            }
            return V5;
        }
        if (!com.tencent.mobileqq.shortvideo.mediadevice.a.d().n(16)) {
            return false;
        }
        o16.setPreviewFormat(16);
        this.f288085f = 16;
        boolean V6 = V(o16);
        if (QLog.isColorLevel()) {
            QLog.i(f288075p, 2, "[@] setParamsPreviewFormat:success=" + V6 + "isSupportPreviewFormat=NV16 OK");
        }
        return V6;
    }

    public boolean a0(int i3) {
        if (QLog.isColorLevel()) {
            QLog.i(f288075p, 2, "setParamsPreviewFps[fps_wanted=" + i3 + "]");
        }
        boolean e06 = e0(i3, false);
        if (QLog.isColorLevel()) {
            QLog.i(f288075p, 2, "setParamsPreviewFps[fps_wanted=" + i3 + " force=false success=" + e06 + "]");
        }
        if (!e06) {
            e06 = e0(i3, true);
            if (QLog.isColorLevel()) {
                QLog.i(f288075p, 2, "setParamsPreviewFps[fps_wanted=" + i3 + " force=true success=" + e06 + "]");
            }
        }
        return e06;
    }

    public boolean b0(b bVar) {
        Camera.Parameters o16 = o();
        if (o16 == null) {
            if (QLog.isColorLevel()) {
                QLog.i(f288075p, 2, "[@] setParamsPreviewSize[failed]getCameraParameters=null");
            }
            return false;
        }
        try {
            o16.setPreviewSize(bVar.f288111a, bVar.f288112b);
            this.f288086g = bVar;
            boolean V = V(o16);
            if (QLog.isColorLevel()) {
                QLog.i(f288075p, 2, "[@] setParamsPreviewSize, result = " + V + ",size.width = " + bVar.f288111a + ",size.height = " + bVar.f288112b);
            }
            return V;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public boolean c0(int i3) {
        Camera.Parameters o16;
        int i16 = 0;
        if (!com.tencent.mobileqq.shortvideo.mediadevice.a.d().o() || (o16 = o()) == null) {
            return false;
        }
        int maxZoom = o16.getMaxZoom();
        int zoom = o16.getZoom() + i3;
        if (zoom >= 0) {
            i16 = zoom;
        }
        if (i16 <= maxZoom) {
            maxZoom = i16;
        }
        o16.setZoom(maxZoom);
        return V(o16);
    }

    public boolean d0(Camera.PreviewCallback previewCallback, boolean z16) {
        Camera camera2 = this.f288082c;
        if (camera2 != null && previewCallback != null) {
            try {
                if (z16) {
                    if (i(C())) {
                        this.f288082c.addCallbackBuffer(this.f288093n);
                        this.f288082c.addCallbackBuffer(this.f288094o);
                        this.f288082c.setPreviewCallbackWithBuffer(previewCallback);
                        return true;
                    }
                    this.f288082c.setPreviewCallback(previewCallback);
                    return true;
                }
                camera2.setPreviewCallback(previewCallback);
                return true;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    public boolean e0(int i3, boolean z16) {
        Camera.Parameters o16 = o();
        if (o16 == null) {
            if (QLog.isColorLevel()) {
                QLog.i(f288075p, 2, "[@] setPreviewFps[failed]getCameraParameters=null");
            }
            return false;
        }
        int[] p16 = p(i3, z16);
        if (p16 != null && p16.length >= 2) {
            if (QLog.isColorLevel()) {
                QLog.i(f288075p, 2, "setPreviewFps[ fps[low]=" + p16[0] + " fps[high]=" + p16[1] + "]");
            }
            try {
                o16.setPreviewFpsRange(p16[0], p16[1]);
                this.f288087h = p16;
                return V(o16);
            } catch (Exception unused) {
                return false;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i(f288075p, 2, "setPreviewFps[getFpsRange=null]");
        }
        return false;
    }

    public boolean f0(SurfaceTexture surfaceTexture) {
        Camera camera2 = this.f288082c;
        if (camera2 != null && surfaceTexture != null) {
            if (this.f288090k) {
                if (QLog.isColorLevel()) {
                    QLog.i(f288075p, 2, "@$[setPreviewTexture] mIsPreviewing=" + this.f288090k);
                }
                return true;
            }
            try {
                camera2.setPreviewTexture(surfaceTexture);
                return true;
            } catch (Exception e16) {
                e16.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.i(f288075p, 2, "@$[setPreviewTexture] exp=", e16);
                }
            }
        }
        return false;
    }

    public void g(boolean z16, byte[] bArr) {
        Camera camera2;
        if (z16 && (camera2 = this.f288082c) != null && bArr != null) {
            camera2.addCallbackBuffer(bArr);
        }
    }

    public boolean g0(b bVar) {
        Camera.Parameters o16 = o();
        if (o16 == null) {
            return false;
        }
        try {
            o16.setPictureSize(bVar.f288111a, bVar.f288112b);
            this.f288089j = bVar;
            boolean V = V(o16);
            if (QLog.isColorLevel()) {
                QLog.i(f288075p, 2, "setRawPictureSize w " + bVar.f288111a + ", h " + bVar.f288112b + ", success=" + V);
            }
            return V;
        } catch (Exception e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.i(f288075p, 2, "setParamsPictureSize", e16);
            }
            return false;
        }
    }

    public void h(boolean z16) {
        if (z16 && this.f288082c != null && i(C())) {
            this.f288082c.addCallbackBuffer(this.f288093n);
            this.f288082c.addCallbackBuffer(this.f288094o);
        }
    }

    public boolean h0(String str) {
        if (!com.tencent.mobileqq.shortvideo.mediadevice.a.d().l(str)) {
            return false;
        }
        Camera.Parameters o16 = o();
        String sceneMode = o16.getSceneMode();
        if (sceneMode == null || sceneMode.equals(str)) {
            return true;
        }
        o16.setSceneMode(str);
        boolean V = V(o16);
        if (QLog.isColorLevel()) {
            QLog.e(f288075p, 2, "setSceneMode success: ", Boolean.valueOf(V));
        }
        return V;
    }

    public boolean i0(SurfaceHolder surfaceHolder) {
        Camera camera2 = this.f288082c;
        if (camera2 != null && surfaceHolder != null) {
            if (this.f288090k) {
                if (QLog.isColorLevel()) {
                    QLog.i(f288075p, 2, "@$[setSurfaceHolder] mIsPreviewing=" + this.f288090k);
                }
                return true;
            }
            try {
                camera2.setPreviewDisplay(surfaceHolder);
                return true;
            } catch (Exception e16) {
                e16.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.i(f288075p, 2, "@$[setSurfaceHolder] exp=", e16);
                }
            }
        }
        return false;
    }

    public boolean j(Camera.AutoFocusCallback autoFocusCallback) {
        if (this.f288082c != null && this.f288090k && k()) {
            try {
                this.f288082c.cancelAutoFocus();
                this.f288082c.autoFocus(autoFocusCallback);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    @TargetApi(14)
    public void j0() {
        try {
            this.f288082c.startFaceDetection();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (QLog.isColorLevel()) {
            QLog.i(f288075p, 2, "startFaceDetection");
        }
    }

    public boolean k0() {
        Camera camera2 = this.f288082c;
        if (camera2 == null) {
            return false;
        }
        if (this.f288090k) {
            return true;
        }
        try {
            camera2.startPreview();
            this.f288090k = true;
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    @TargetApi(14)
    public void l0() {
        try {
            this.f288082c.setFaceDetectionListener(null);
            this.f288082c.stopFaceDetection();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (QLog.isColorLevel()) {
            QLog.i(f288075p, 2, "stopFaceDetection");
        }
    }

    public boolean m0() {
        if (this.f288082c == null) {
            return false;
        }
        if (!this.f288090k) {
            return true;
        }
        try {
            this.f288090k = false;
            if (k()) {
                try {
                    this.f288082c.cancelAutoFocus();
                } catch (RuntimeException unused) {
                }
            }
            this.f288082c.stopPreview();
            this.f288082c.setPreviewCallback(null);
            this.f288082c.setPreviewDisplay(null);
            return true;
        } catch (Exception unused2) {
            return false;
        }
    }

    @TargetApi(14)
    public boolean n0() {
        int i3;
        try {
            i3 = this.f288082c.getParameters().getMaxNumDetectedFaces();
        } catch (Exception e16) {
            e16.printStackTrace();
            i3 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.i(f288075p, 2, "supportFaceDetect" + i3);
        }
        if (i3 <= 0) {
            return false;
        }
        return true;
    }

    public Camera.Parameters o() {
        try {
            return this.f288082c.getParameters();
        } catch (Exception e16) {
            QLog.e(f288075p, 2, e16, new Object[0]);
            return null;
        }
    }

    public boolean o0() {
        if (com.tencent.mobileqq.shortvideo.mediadevice.a.d().j()) {
            Camera.Parameters o16 = o();
            if (TextUtils.equals(o16.getFlashMode(), "torch")) {
                o16.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
            } else {
                o16.setFlashMode("torch");
            }
            return V(o16);
        }
        return false;
    }

    public int[] p(int i3, boolean z16) {
        int i16;
        int[] iArr = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        int i17 = i3 * 1000;
        List<int[]> f16 = com.tencent.mobileqq.shortvideo.mediadevice.a.d().f();
        if (f16 == null) {
            iArr[0] = i17;
            iArr[1] = i17;
            return iArr;
        }
        R(f16);
        if (!z16) {
            return q(f16, i3);
        }
        for (int[] iArr2 : f16) {
            if (iArr2 != null && iArr2.length >= 2 && i17 >= iArr2[0] && i17 <= (i16 = iArr2[1])) {
                iArr[0] = i17;
                iArr[1] = i16;
                return iArr;
            }
        }
        return q(f16, i3);
    }

    @TargetApi(17)
    public void p0(final File file, final Rect rect, final CameraCover.a aVar, final int i3, final boolean z16, final int i16) {
        if (this.f288082c == null) {
            if (QLog.isColorLevel()) {
                QLog.i(f288075p, 2, "[takePicture]mCamera " + ((Object) null));
                return;
            }
            return;
        }
        f.c("begin pic taken");
        try {
            this.f288082c.enableShutterSound(false);
        } catch (Exception e16) {
            QLog.i(f288075p, 1, "[takePicture]enableShutterSound error, ", e16);
        }
        try {
            final long currentTimeMillis = System.currentTimeMillis();
            this.f288090k = false;
            CameraMonitor.takePicture(this.f288082c, null, null, null, new Camera.PictureCallback() { // from class: com.tencent.mobileqq.shortvideo.mediadevice.CameraControl.1

                /* renamed from: a, reason: collision with root package name */
                Handler f288095a = new Handler(Looper.getMainLooper());

                @Override // android.hardware.Camera.PictureCallback
                public void onPictureTaken(final byte[] bArr, Camera camera2) {
                    final Camera.Size size;
                    if (QLog.isColorLevel()) {
                        QLog.i(CameraControl.f288075p, 2, "onJpegTaken");
                    }
                    f.c("inner pic taken");
                    try {
                        size = camera2.getParameters().getPictureSize();
                    } catch (Exception e17) {
                        e17.printStackTrace();
                        size = null;
                    }
                    if (size == null) {
                        QLog.e(CameraControl.f288075p, 1, "null picSize");
                        return;
                    }
                    QLog.i(CameraControl.f288075p, 1, "[onPictureTaken] picSize(" + size.width + "," + size.height + ") orientation=" + i3);
                    if (bArr == null) {
                        return;
                    }
                    com.tencent.mobileqq.shortvideo.camera2.c.b(1, size.height * size.width, System.currentTimeMillis() - currentTimeMillis);
                    this.f288095a.post(new Runnable() { // from class: com.tencent.mobileqq.shortvideo.mediadevice.CameraControl.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c cVar = new c();
                            cVar.f288114a = bArr;
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            cVar.f288115b = file;
                            cVar.f288116c = rect;
                            cVar.f288117d = aVar;
                            cVar.f288118e = i3;
                            cVar.f288119f = CameraControl.this.f288084e;
                            cVar.f288121h = 100;
                            cVar.f288120g = z16;
                            cVar.f288122i = i16;
                            cVar.f288123j = size;
                            new d(cVar).execute(new Void[0]);
                        }
                    });
                }
            });
        } catch (RuntimeException e17) {
            if (QLog.isColorLevel()) {
                QLog.i(f288075p, 2, "", e17);
            }
        }
    }

    public boolean q0(boolean z16) {
        String str;
        if (com.tencent.mobileqq.shortvideo.mediadevice.a.d().j()) {
            Camera.Parameters o16 = o();
            if (z16) {
                str = "torch";
            } else {
                str = DebugKt.DEBUG_PROPERTY_VALUE_OFF;
            }
            o16.setFlashMode(str);
            return V(o16);
        }
        return false;
    }

    public b r(int i3, int i16, int i17, int i18) {
        ArrayList<Float> arrayList;
        int i19;
        int i26;
        List<Camera.Size> g16 = com.tencent.mobileqq.shortvideo.mediadevice.a.d().g();
        if (g16 != null && !g16.isEmpty()) {
            if (QLog.isColorLevel()) {
                for (int i27 = 0; i27 < g16.size(); i27++) {
                    QLog.i(f288075p, 2, "[@] getFullVideoPreviewSize[list]: width=" + g16.get(i27).width + " height=" + g16.get(i27).height + " w/h=" + (g16.get(i27).width / g16.get(i27).height));
                }
            }
            if (com.tencent.mobileqq.activity.richmedia.c.f185845b == 1) {
                if (!f288080u) {
                    O(f288081v);
                    f288080u = true;
                }
                arrayList = f288081v;
            } else {
                if (!f288078s) {
                    O(f288079t);
                    f288078s = true;
                }
                arrayList = f288079t;
            }
            double d16 = i18 / i17;
            if (QLog.isColorLevel()) {
                QLog.i(f288075p, 2, "[@] getFullVideoPreviewSize[self-adaption] physicRatio=" + d16);
            }
            ArrayList arrayList2 = new ArrayList(3);
            ArrayList<Camera.Size> arrayList3 = new ArrayList<>(3);
            b bVar = new b();
            for (Camera.Size size : g16) {
                if (size != null) {
                    double d17 = size.width / size.height;
                    Iterator<Float> it = arrayList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        if (Math.abs(it.next().floatValue() - d17) <= 0.009999999776482582d) {
                            if (d17 >= d16) {
                                arrayList2.add(size);
                            } else {
                                arrayList3.add(size);
                            }
                        }
                    }
                }
            }
            int i28 = yq2.a.f450989f;
            int i29 = yq2.a.f450990g;
            if (QLog.isColorLevel()) {
                QLog.i(f288075p, 2, "[@] getFullVideoPreviewSize[self-adaption] previewWidth=" + i28 + "previewHeight=" + i29);
            }
            Iterator it5 = arrayList2.iterator();
            int i36 = -1;
            int i37 = -1;
            while (it5.hasNext()) {
                Camera.Size size2 = (Camera.Size) it5.next();
                if (size2 != null && size2.height == i29 && (i26 = size2.width) >= i28 && (i37 < 0 || i26 <= i37)) {
                    i37 = i26;
                }
            }
            if (i37 > 0) {
                bVar.f288112b = i29;
                bVar.f288111a = i37;
                if (((ICameraCompatible) QRoute.api(ICameraCompatible.class)).isFoundCoolPad() && N(arrayList3, i28, i29)) {
                    bVar.f288111a = i28;
                }
                return bVar;
            }
            Iterator<Camera.Size> it6 = arrayList3.iterator();
            long j3 = Long.MAX_VALUE;
            long j16 = Long.MAX_VALUE;
            while (it6.hasNext()) {
                Camera.Size next = it6.next();
                if (next != null && l(i3, i17, i18, next.width, next.height)) {
                    int i38 = next.width;
                    int i39 = next.height;
                    long j17 = i38 * i39;
                    if (j17 < j16) {
                        bVar.f288111a = i38;
                        bVar.f288112b = i39;
                        j16 = j17;
                    } else if (j17 == j16 && i38 < bVar.f288111a) {
                        bVar.f288111a = i38;
                        bVar.f288112b = i39;
                    }
                }
            }
            if (bVar.f288111a <= 0 && bVar.f288112b <= 0) {
                int i46 = yq2.a.f450997n[1];
                int i47 = yq2.a.f450998o[1];
                Iterator it7 = arrayList2.iterator();
                while (it7.hasNext()) {
                    Camera.Size size3 = (Camera.Size) it7.next();
                    if (size3 != null && size3.height == i47 && (i19 = size3.width) >= i46 && (i36 < 0 || i19 <= i36)) {
                        i36 = i19;
                    }
                }
                if (i36 > 0) {
                    bVar.f288112b = i47;
                    bVar.f288111a = i36;
                    return bVar;
                }
                if (bVar.f288111a <= 0 || bVar.f288112b <= 0) {
                    Iterator it8 = arrayList2.iterator();
                    long j18 = Long.MAX_VALUE;
                    while (it8.hasNext()) {
                        Camera.Size size4 = (Camera.Size) it8.next();
                        if (size4 != null) {
                            int i48 = size4.width;
                            int i49 = size4.height;
                            long j19 = i48 * i49;
                            if (j19 < j18) {
                                bVar.f288111a = i48;
                                bVar.f288112b = i49;
                                j18 = j19;
                            } else if (j19 == j18 && i48 < bVar.f288111a) {
                                bVar.f288111a = i48;
                                bVar.f288112b = i49;
                            }
                        }
                    }
                }
                if (bVar.f288111a <= 0 || bVar.f288112b <= 0) {
                    Iterator<Camera.Size> it9 = arrayList3.iterator();
                    while (it9.hasNext()) {
                        Camera.Size next2 = it9.next();
                        if (next2 != null && l(320, i17, i18, next2.width, next2.height)) {
                            int i56 = next2.width;
                            int i57 = next2.height;
                            long j26 = i56 * i57;
                            if (j26 < j3) {
                                bVar.f288111a = i56;
                                bVar.f288112b = i57;
                                j3 = j26;
                            } else if (j26 == j3 && i56 < bVar.f288111a) {
                                bVar.f288111a = i56;
                                bVar.f288112b = i57;
                            }
                        }
                    }
                }
                if (bVar.f288111a <= 0 || bVar.f288112b <= 0) {
                    long j27 = 0;
                    for (Camera.Size size5 : g16) {
                        if (size5 != null) {
                            int i58 = size5.width;
                            int i59 = size5.height;
                            long j28 = i58 * i59;
                            if (j28 > j27) {
                                bVar.f288111a = i58;
                                bVar.f288112b = i59;
                                j27 = j28;
                            } else if (j28 == j27 && i58 < bVar.f288111a) {
                                bVar.f288111a = i58;
                                bVar.f288112b = i59;
                            }
                        }
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.i(f288075p, 2, "[@] getFullVideoPreviewSize[self-adaption] cSize.width=" + bVar.f288111a + "  cSize.height=" + bVar.f288112b);
                }
                if (bVar.f288111a > 0 && bVar.f288112b > 0) {
                    return bVar;
                }
                return null;
            }
            return bVar;
        }
        return null;
    }

    public boolean r0(boolean z16) {
        if (com.tencent.mobileqq.shortvideo.mediadevice.a.d().j()) {
            Camera.Parameters o16 = o();
            String flashMode = o16.getFlashMode();
            if (z16 && !TextUtils.equals(flashMode, "on")) {
                o16.setFlashMode("on");
            } else if (!z16 && !TextUtils.equals(flashMode, DebugKt.DEBUG_PROPERTY_VALUE_OFF)) {
                o16.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
            }
            return V(o16);
        }
        return false;
    }

    public b v(int i3, int i16, int i17, List<Camera.Size> list) {
        int max = Math.max(i3 * i17, i16 * i17);
        if (QLog.isColorLevel()) {
            QLog.i(f288075p, 2, "setParamsPictureSize targetWidth " + max);
        }
        b bVar = new b(0, 0);
        int i18 = Integer.MAX_VALUE;
        for (Camera.Size size : list) {
            int abs = Math.abs(size.width - max);
            if (i18 > abs) {
                bVar.f288111a = size.width;
                bVar.f288112b = size.height;
                i18 = abs;
            }
        }
        return bVar;
    }

    public b w() {
        return this.f288089j;
    }

    public b x(int i3, int i16, int i17, int i18, int i19) {
        b v3;
        if (o() == null) {
            return null;
        }
        int min = Math.min(i3, i16);
        int max = Math.max(i3, i16);
        float f16 = max / min;
        b bVar = new b();
        List<Camera.Size> e16 = com.tencent.mobileqq.shortvideo.mediadevice.a.d().e();
        if (e16 == null || e16.isEmpty()) {
            return null;
        }
        b bVar2 = new b();
        ArrayList arrayList = new ArrayList();
        float f17 = 10000.0f;
        for (Camera.Size size : e16) {
            if (size != null) {
                if (QLog.isColorLevel()) {
                    QLog.i(f288075p, 2, "[@] setPictureSize[list]: width=" + size.width + " height=" + size.height + " w/h=" + (size.width / size.height));
                }
                float f18 = (size.width / size.height) - f16;
                if (Math.abs(f18) <= f288076q) {
                    arrayList.add(size);
                }
                if (size.width >= max && f17 > Math.abs(f18)) {
                    float abs = Math.abs(f18);
                    bVar2.f288111a = size.width;
                    bVar2.f288112b = size.height;
                    f17 = abs;
                }
            }
        }
        if (arrayList.isEmpty() && bVar2.f288111a >= max) {
            if (QLog.isColorLevel()) {
                QLog.i(f288075p, 2, "getPictureSize: width=" + bVar2.f288111a + " height=" + bVar2.f288112b + " w/h=" + (bVar2.f288111a / bVar2.f288112b));
            }
            return bVar2;
        }
        if (arrayList.isEmpty() && e16.size() > 0) {
            bVar.f288111a = e16.get(0).width;
            bVar.f288112b = e16.get(0).height;
            return bVar;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        if (i19 == -1) {
            for (Camera.Size size2 : arrayList) {
                int i26 = bVar.f288111a;
                int i27 = size2.width;
                if (i26 < i27) {
                    bVar.f288111a = i27;
                    bVar.f288112b = size2.height;
                }
            }
            v3 = bVar;
        } else {
            v3 = v(i17, i18, i19, arrayList);
        }
        if (v3.f288111a == 0) {
            return null;
        }
        return v3;
    }

    public b y() {
        return this.f288086g;
    }

    public b[] z(int i3, int i16, int i17, int i18) {
        if (QLog.isColorLevel()) {
            QLog.i(f288075p, 2, "[@] getPreviewAndPictureSizeGuarantee wanted size=" + yq2.a.f450989f + " " + yq2.a.f450990g + " cliped=" + i3 + " " + i16);
        }
        b[] bVarArr = new b[2];
        b H = H(i3, i16, i17, i18, true);
        if (H != null) {
            bVarArr[0] = H;
            if (QLog.isColorLevel()) {
                QLog.i(f288075p, 2, "[@] getPreviewAndPictureSizeGuarantee way2 preview=" + H.f288111a + " " + H.f288112b);
            }
            b x16 = x(H.f288111a, H.f288112b, i17, i18, 1);
            bVarArr[1] = x16;
            if (x16 != null) {
                if (QLog.isColorLevel()) {
                    QLog.i(f288075p, 2, "[@] getPreviewAndPictureSizeGuarantee way2 picture=" + x16.f288111a + " " + x16.f288112b);
                }
                f.m(true, H.f288111a, H.f288112b, x16.f288111a, x16.f288112b);
            } else {
                f.m(true, H.f288111a, H.f288112b, -1, -1);
            }
        }
        return bVarArr;
    }
}
