package com.tencent.mobileqq.troop.trooptodo;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import com.tencent.image.DownloadParams;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.eh;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class o implements DownloadParams.DecodeHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static String f301818a;

    /* renamed from: b, reason: collision with root package name */
    public static final DownloadParams.DecodeHandler f301819b;

    /* renamed from: c, reason: collision with root package name */
    public static final DownloadParams.DecodeHandler f301820c;

    /* renamed from: d, reason: collision with root package name */
    public static final DownloadParams.DecodeHandler f301821d;

    /* renamed from: e, reason: collision with root package name */
    public static final DownloadParams.DecodeHandler f301822e;

    /* renamed from: f, reason: collision with root package name */
    public static final DownloadParams.DecodeHandler f301823f;

    /* renamed from: g, reason: collision with root package name */
    public static final DownloadParams.DecodeHandler f301824g;

    /* renamed from: h, reason: collision with root package name */
    public static final DownloadParams.DecodeHandler f301825h;

    /* renamed from: i, reason: collision with root package name */
    public static final DownloadParams.DecodeHandler f301826i;

    /* renamed from: j, reason: collision with root package name */
    public static final DownloadParams.DecodeHandler f301827j;

    /* renamed from: k, reason: collision with root package name */
    public static final DownloadParams.DecodeHandler f301828k;

    /* renamed from: l, reason: collision with root package name */
    public static final DownloadParams.DecodeHandler f301829l;

    /* renamed from: m, reason: collision with root package name */
    public static final DownloadParams.DecodeHandler f301830m;

    /* renamed from: n, reason: collision with root package name */
    public static final DownloadParams.DecodeHandler f301831n;

    /* renamed from: o, reason: collision with root package name */
    public static final DownloadParams.DecodeHandler f301832o;

    /* renamed from: p, reason: collision with root package name */
    public static final DownloadParams.DecodeHandler f301833p;

    /* renamed from: q, reason: collision with root package name */
    public static final DownloadParams.DecodeHandler f301834q;

    /* renamed from: r, reason: collision with root package name */
    public static final DownloadParams.DecodeHandler f301835r;

    /* renamed from: s, reason: collision with root package name */
    public static final DownloadParams.DecodeHandler f301836s;

    /* renamed from: t, reason: collision with root package name */
    public static final DownloadParams.DecodeHandler f301837t;

    /* renamed from: u, reason: collision with root package name */
    public static final DownloadParams.DecodeHandler f301838u;

    /* renamed from: v, reason: collision with root package name */
    public static final DownloadParams.DecodeHandler f301839v;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements DownloadParams.DecodeHandler {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.image.DownloadParams.DecodeHandler
        public Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloadParams, (Object) bitmap);
            }
            if (bitmap == null) {
                return null;
            }
            Object obj = downloadParams.tag;
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                if (iArr.length == 4) {
                    if (iArr[0] == 0) {
                        iArr[0] = bitmap.getWidth();
                    }
                    if (iArr[1] == 0) {
                        iArr[1] = bitmap.getHeight();
                    }
                    bitmap = BaseImageUtil.getRoundedCornerBitmap4(bitmap, iArr[0], iArr[1], iArr[2], iArr[3]);
                    if (bitmap == null && QLog.isDevelopLevel()) {
                        QLog.w(o.f301818a, 2, "ROUND_CORNER_DECODER bitmap == null");
                    }
                }
            }
            return bitmap;
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class b implements DownloadParams.DecodeHandler {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.image.DownloadParams.DecodeHandler
        public Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloadParams, (Object) bitmap);
            }
            if (bitmap != null && downloadParams != null) {
                Object obj = downloadParams.tag;
                if (obj instanceof int[]) {
                    int[] iArr = (int[]) obj;
                    if (iArr.length == 4) {
                        int i3 = iArr[0];
                        int i16 = iArr[1];
                        int i17 = iArr[2];
                        int i18 = iArr[3];
                        if (i17 > 0 && i18 > 0) {
                            if (i17 == bitmap.getWidth() && i18 == bitmap.getHeight()) {
                                return bitmap;
                            }
                            try {
                                Bitmap createBitmap = Bitmap.createBitmap(i17, i18, Bitmap.Config.ARGB_8888);
                                Canvas canvas = new Canvas(createBitmap);
                                Matrix matrix = new Matrix();
                                o.c(matrix, bitmap.getWidth(), bitmap.getHeight(), i17, i18, i3, i16);
                                canvas.drawBitmap(bitmap, matrix, new Paint(6));
                                return createBitmap;
                            } catch (OutOfMemoryError unused) {
                            }
                        }
                    }
                }
            }
            return bitmap;
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class c implements DownloadParams.DecodeHandler {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.image.DownloadParams.DecodeHandler
        public Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloadParams, (Object) bitmap);
            }
            if (bitmap == null) {
                return null;
            }
            Object obj = downloadParams.tag;
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                if (iArr.length == 2) {
                    float q16 = ah.q();
                    if (q16 < 0.01f) {
                        q16 = 1.0f;
                    }
                    int i3 = (int) (iArr[0] / q16);
                    iArr[0] = i3;
                    int i16 = (int) (iArr[1] / q16);
                    iArr[1] = i16;
                    return BaseImageUtil.getCircleFaceBitmap(bitmap, i3, i16);
                }
                return bitmap;
            }
            return bitmap;
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class d implements DownloadParams.DecodeHandler {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.image.DownloadParams.DecodeHandler
        public Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloadParams, (Object) bitmap);
            }
            if (bitmap == null) {
                return null;
            }
            Object obj = downloadParams.tag;
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                if (iArr.length == 2) {
                    float q16 = ah.q();
                    if (q16 < 0.01f) {
                        q16 = 1.0f;
                    }
                    int i3 = (int) (iArr[0] / q16);
                    iArr[0] = i3;
                    int i16 = (int) (iArr[1] / q16);
                    iArr[1] = i16;
                    Bitmap circleFaceBitmap = BaseImageUtil.getCircleFaceBitmap(bitmap, i3, i16);
                    Canvas canvas = new Canvas(circleFaceBitmap);
                    Paint paint = new Paint();
                    paint.setAntiAlias(true);
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setColor(Color.argb(20, 0, 0, 0));
                    paint.setStrokeWidth(0.5f);
                    float width = circleFaceBitmap.getWidth() * 0.5f;
                    canvas.drawCircle(width, width, width - 0.5f, paint);
                    return circleFaceBitmap;
                }
                return bitmap;
            }
            return bitmap;
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class e implements DownloadParams.DecodeHandler {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.image.DownloadParams.DecodeHandler
        public Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloadParams, (Object) bitmap);
            }
            if (bitmap == null) {
                return null;
            }
            Object obj = downloadParams.tag;
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                if (iArr.length == 2) {
                    return BaseImageUtil.getCicrlColorBitmap(bitmap, iArr[0], iArr[1]);
                }
            }
            return bitmap;
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class f implements DownloadParams.DecodeHandler {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0028  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x004a  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0047  */
        @Override // com.tencent.image.DownloadParams.DecodeHandler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
            int i3;
            Bitmap bitmap2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloadParams, (Object) bitmap);
            }
            if (bitmap == null) {
                return null;
            }
            Object obj = downloadParams.tag;
            boolean z16 = false;
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                if (iArr.length > 0) {
                    i3 = iArr[0];
                    if (i3 == 0) {
                        Matrix matrix = new Matrix();
                        matrix.postRotate(i3);
                        int width = bitmap.getWidth();
                        int height = bitmap.getHeight();
                        if (i3 % 90 != 0) {
                            z16 = true;
                        }
                        bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, z16);
                    } else {
                        bitmap2 = bitmap;
                    }
                    if (bitmap2 != bitmap) {
                        bitmap.recycle();
                    }
                    return bitmap2;
                }
            }
            i3 = 0;
            if (i3 == 0) {
            }
            if (bitmap2 != bitmap) {
            }
            return bitmap2;
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class g implements DownloadParams.DecodeHandler {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.image.DownloadParams.DecodeHandler
        public Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloadParams, (Object) bitmap);
            }
            if (bitmap == null) {
                return null;
            }
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            RectF rectF = new RectF(0.0f, 0.0f, width, height);
            Canvas canvas = new Canvas(createBitmap);
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.FILL);
            paint.setAntiAlias(true);
            paint.setShader(bitmapShader);
            canvas.drawRoundRect(rectF, 12.0f, 12.0f, paint);
            paint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, height / 2, Color.parseColor("#80000000"), Color.parseColor("#00000000"), Shader.TileMode.CLAMP));
            canvas.drawRoundRect(rectF, 12.0f, 12.0f, paint);
            bitmap.recycle();
            return createBitmap;
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class h implements DownloadParams.DecodeHandler {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.image.DownloadParams.DecodeHandler
        public Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
            boolean z16;
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloadParams, (Object) bitmap);
            }
            if (bitmap == null) {
                return null;
            }
            Object obj = downloadParams.tag;
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                if (iArr.length == 6) {
                    int i16 = iArr[0];
                    int i17 = iArr[1];
                    int i18 = iArr[2];
                    int i19 = iArr[3];
                    int i26 = iArr[4];
                    int i27 = iArr[5];
                    int height = bitmap.getHeight();
                    int width = bitmap.getWidth();
                    if (i16 >= 0 && i17 >= 0 && i18 > 0 && i19 > 0 && i16 < width && i17 < height) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i(o.f301818a, 2, String.format("CUSTOM_CLIP_DECODER [%d,%d,%d,%d,%d,%d] valid=%b", Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), Boolean.valueOf(z16)));
                    }
                    if (!z16 && i26 > 0 && i27 > 0) {
                        float f16 = i26 / i27;
                        float width2 = bitmap.getWidth() / bitmap.getHeight();
                        Rect rect = new Rect();
                        if (f16 > width2) {
                            int width3 = bitmap.getWidth();
                            rect.set(0, (int) ((bitmap.getHeight() - r5) * 0.5f), width3, (int) (((bitmap.getHeight() - r5) * 0.5f) + ((int) (width3 / f16))));
                        } else {
                            int height2 = bitmap.getHeight();
                            rect.set((int) ((bitmap.getWidth() - r5) * 0.5f), 0, (int) (((bitmap.getWidth() - r5) * 0.5f) + ((int) (height2 * f16))), height2);
                        }
                        Bitmap clipRectBitmapScale = BaseImageUtil.getClipRectBitmapScale(bitmap, rect, ((ITroopPhotoUtilsApi) QRoute.api(ITroopPhotoUtilsApi.class)).getInSampleSize(i26, i27, rect.height(), rect.width()));
                        if (QLog.isColorLevel()) {
                            QLog.i(o.f301818a, 2, String.format("CUSTOM_CLIP_DECODER centerCrop %s", rect.toShortString()));
                            return clipRectBitmapScale;
                        }
                        return clipRectBitmapScale;
                    }
                    if (z16) {
                        if (i16 + i18 > width) {
                            i18 = width - i16;
                        }
                        if (i17 + i19 > height) {
                            i19 = height - i17;
                        }
                        Rect rect2 = new Rect(i16, i17, i18 + i16, i19 + i17);
                        if (i26 > 0 && i27 > 0) {
                            i3 = ((ITroopPhotoUtilsApi) QRoute.api(ITroopPhotoUtilsApi.class)).getInSampleSize(i26, i27, rect2.height(), rect2.width());
                        } else {
                            i3 = 1;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.i(o.f301818a, 2, String.format("CUSTOM_CLIP_DECODER [w,h]=[%d,%d] dstClip=%s sample=%d", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), rect2, Integer.valueOf(i3)));
                        }
                        return BaseImageUtil.getClipRectBitmapScale(bitmap, rect2, i3);
                    }
                }
            }
            return bitmap;
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class i implements DownloadParams.DecodeHandler {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.image.DownloadParams.DecodeHandler
        public Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
            Bitmap createBitmap;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloadParams, (Object) bitmap);
            }
            try {
                int height = bitmap.getHeight();
                int width = bitmap.getWidth();
                int i3 = downloadParams.reqWidth;
                int i16 = downloadParams.reqHeight;
                float f16 = (i3 * 1.0f) / width;
                Matrix matrix = new Matrix();
                matrix.setScale(f16, f16);
                float f17 = i16;
                if (height * f16 > f17) {
                    createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, (int) (f17 / f16), matrix, true);
                } else {
                    createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
                }
                if (QLog.isColorLevel()) {
                    QLog.d(o.f301818a, 2, String.format("ALIGN_TOP_DECODER srcHeight = %s, srcWidth = %s, reqWidth = %s, reqHeight = %s, scale = %s", Integer.valueOf(height), Integer.valueOf(width), Integer.valueOf(i3), Integer.valueOf(i16), Float.valueOf(f16)));
                }
                return createBitmap;
            } catch (Exception e16) {
                e16.printStackTrace();
                return bitmap;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class j implements DownloadParams.DecodeHandler {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.image.DownloadParams.DecodeHandler
        public Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloadParams, (Object) bitmap);
            }
            if (bitmap == null) {
                return null;
            }
            Object obj = downloadParams.tag;
            if (!(obj instanceof int[])) {
                return null;
            }
            int[] iArr = (int[]) obj;
            if (iArr.length != 1) {
                return null;
            }
            int i3 = iArr[0];
            return BaseImageUtil.getRoundedCornerBitmap(bitmap, i3, i3, i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class k implements DownloadParams.DecodeHandler {
        static IPatchRedirector $redirector_;

        k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.image.DownloadParams.DecodeHandler
        public Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloadParams, (Object) bitmap);
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("URLDrawableDecodeHandler", 4, "ROUND_FACE_DECODER");
            }
            if (bitmap == null) {
                return null;
            }
            Object obj = downloadParams.tag;
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                if (iArr.length == 2) {
                    float q16 = ah.q();
                    if (q16 < 0.01f) {
                        q16 = 1.0f;
                    }
                    int i3 = (int) (iArr[0] / q16);
                    iArr[0] = i3;
                    int i16 = (int) (iArr[1] / q16);
                    iArr[1] = i16;
                    return BaseImageUtil.getRoundFaceBitmap(bitmap, i3, i16);
                }
            }
            return BaseImageUtil.getRoundFaceBitmap(bitmap, 50, 50);
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class l implements DownloadParams.DecodeHandler {
        static IPatchRedirector $redirector_;

        l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.image.DownloadParams.DecodeHandler
        public Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloadParams, (Object) bitmap);
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("URLDrawableDecodeHandler", 4, "ROUND_FACE_DECODER");
            }
            if (bitmap == null) {
                return null;
            }
            Object obj = downloadParams.tag;
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                if (iArr.length == 2) {
                    return BaseImageUtil.getRoundedCornerBitmap(bitmap, 0.0f, iArr[0], iArr[1]);
                }
            }
            return BaseImageUtil.getRoundFaceBitmap(bitmap, 50, 50);
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class m implements DownloadParams.DecodeHandler {
        static IPatchRedirector $redirector_;

        m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.image.DownloadParams.DecodeHandler
        public Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloadParams, (Object) bitmap);
            }
            if (QLog.isColorLevel()) {
                QLog.d("zivonchen", 2, "mRoundCornerDecoder---------------");
            }
            if (bitmap == null) {
                return null;
            }
            Object obj = downloadParams.tag;
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                if (iArr.length == 3) {
                    return BaseImageUtil.getRoundedCornerBitmap2(bitmap, iArr[2], iArr[0], iArr[1]);
                }
                return bitmap;
            }
            return bitmap;
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class n implements DownloadParams.DecodeHandler {
        static IPatchRedirector $redirector_;

        n() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.image.DownloadParams.DecodeHandler
        public Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloadParams, (Object) bitmap);
            }
            if (QLog.isColorLevel()) {
                QLog.d("URLDrawableDecodeHandler", 2, "AVATAR_WALL_RECT__DECODER");
            }
            if (bitmap == null) {
                return null;
            }
            Object obj = downloadParams.tag;
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                if (iArr.length == 3) {
                    return BaseImageUtil.getClipCenterRoundedCornerBitmap(bitmap, iArr[0], iArr[1], iArr[2]);
                }
                return bitmap;
            }
            return bitmap;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.troop.trooptodo.o$o, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    class C8834o implements DownloadParams.DecodeHandler {
        static IPatchRedirector $redirector_;

        C8834o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.image.DownloadParams.DecodeHandler
        public Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloadParams, (Object) bitmap);
            }
            if (QLog.isColorLevel()) {
                QLog.d("URLDrawableDecodeHandler", 2, "PART_ROUND_CORNER_DECODER");
            }
            if (bitmap == null) {
                return null;
            }
            Object obj = downloadParams.tag;
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                if (iArr.length == 3) {
                    return BaseImageUtil.getPartRoundBitmap(bitmap, iArr[0], iArr[1], iArr[2]);
                }
                return bitmap;
            }
            return bitmap;
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class p implements DownloadParams.DecodeHandler {
        static IPatchRedirector $redirector_;

        p() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.image.DownloadParams.DecodeHandler
        public Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloadParams, (Object) bitmap);
            }
            if (bitmap == null) {
                return null;
            }
            Object obj = downloadParams.tag;
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                if (iArr.length == 3) {
                    if (iArr[0] == 0) {
                        iArr[0] = bitmap.getWidth();
                    }
                    if (iArr[1] == 0) {
                        iArr[1] = bitmap.getHeight();
                    }
                    return BaseImageUtil.getHalfRoundedBitmap(bitmap, iArr[2], iArr[0], iArr[1]);
                }
                return bitmap;
            }
            return bitmap;
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class q implements DownloadParams.DecodeHandler {
        static IPatchRedirector $redirector_;

        q() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.image.DownloadParams.DecodeHandler
        public Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloadParams, (Object) bitmap);
            }
            if (bitmap == null) {
                return null;
            }
            Object obj = downloadParams.tag;
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                if (iArr.length == 3) {
                    int i3 = iArr[0];
                    if (i3 == 0 && (i3 = downloadParams.reqWidth) == 0) {
                        i3 = bitmap.getWidth();
                    }
                    int i16 = iArr[1];
                    if (i16 == 0) {
                        int i17 = downloadParams.reqHeight;
                        if (i17 == 0) {
                            i17 = bitmap.getHeight();
                        }
                        i16 = i17;
                    }
                    return BaseImageUtil.getHalfRoundedBitmap(bitmap, iArr[2], i3, i16);
                }
                return bitmap;
            }
            return bitmap;
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class r implements DownloadParams.DecodeHandler {
        static IPatchRedirector $redirector_;

        r() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.image.DownloadParams.DecodeHandler
        public Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloadParams, (Object) bitmap);
            }
            if (bitmap == null) {
                return null;
            }
            Object obj = downloadParams.tag;
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                if (iArr.length == 3) {
                    return BaseImageUtil.getPartRoundBitmap(bitmap, iArr[2], iArr[0], iArr[1]);
                }
                return bitmap;
            }
            return bitmap;
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class s implements DownloadParams.DecodeHandler {
        static IPatchRedirector $redirector_;

        s() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.image.DownloadParams.DecodeHandler
        public Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloadParams, (Object) bitmap);
            }
            if (bitmap == null) {
                return null;
            }
            Object obj = downloadParams.tag;
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                if (iArr.length == 3) {
                    if (iArr[0] == 0) {
                        iArr[0] = bitmap.getWidth();
                    }
                    if (iArr[1] == 0) {
                        iArr[1] = bitmap.getHeight();
                    }
                    bitmap = BaseImageUtil.getRoundedCornerBitmap3(bitmap, iArr[2], iArr[0], iArr[1]);
                    if (bitmap == null && QLog.isDevelopLevel()) {
                        QLog.w(o.f301818a, 2, "ROUND_CORNER_DECODER bitmap == null");
                    }
                }
            }
            return bitmap;
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class t implements DownloadParams.DecodeHandler {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private int f301840a;

        public t(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3);
            } else {
                this.f301840a = i3;
            }
        }

        @Override // com.tencent.image.DownloadParams.DecodeHandler
        public Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloadParams, (Object) bitmap);
            }
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int i3 = downloadParams.reqHeight;
            int i16 = (width * i3) / height;
            if (i3 < height) {
                height = i3;
                width = i16;
            }
            try {
                Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_4444);
                new Canvas(createBitmap).drawBitmap(bitmap, (Rect) null, new Rect(0, 0, width, height), new Paint(7));
                eh.a(createBitmap, this.f301840a);
                return createBitmap;
            } catch (Exception | OutOfMemoryError unused) {
                return bitmap;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65139);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f301818a = "URLDrawableDecodeHandler";
        f301819b = new k();
        f301820c = new l();
        f301821d = new m();
        f301822e = new n();
        f301823f = new C8834o();
        f301824g = new p();
        f301825h = new q();
        f301826i = new r();
        f301827j = new s();
        f301828k = new a();
        f301829l = new b();
        f301830m = new c();
        f301831n = new d();
        f301832o = new e();
        f301833p = new f();
        f301834q = new t(10);
        f301835r = new t(20);
        f301836s = new g();
        f301837t = new h();
        f301838u = new i();
        f301839v = new j();
    }

    public static final int[] b(int i3, int i16, int i17) {
        return new int[]{i3, i16, i17};
    }

    public static void c(Matrix matrix, int i3, int i16, int i17, int i18, float f16, float f17) {
        float f18;
        float f19;
        float f26;
        if (matrix == null) {
            matrix = new Matrix();
        }
        if (i3 * i18 > i17 * i16) {
            f18 = i18;
            f19 = i16;
        } else {
            f18 = i17;
            f19 = i3;
        }
        float f27 = f18 / f19;
        float f28 = i17 * 0.5f;
        float f29 = i18 * 0.5f;
        int i19 = (int) (i3 * f27);
        int i26 = (int) (i16 * f27);
        float f36 = f16 * i19;
        float f37 = f17 * i26;
        float f38 = 0.0f;
        if (i19 > i17 && f36 > f28) {
            f26 = Math.min(i19 - i17, f36 - f28);
        } else {
            f26 = 0.0f;
        }
        if (i26 > i18 && f37 > f29) {
            f38 = Math.min(i26 - i18, f37 - f29);
        }
        matrix.setScale(f27, f27);
        matrix.postTranslate(((int) (f26 + 0.5f)) * (-1), ((int) (f38 + 0.5f)) * (-1));
    }
}
