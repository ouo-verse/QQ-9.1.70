package com.tencent.aelight.camera.aioeditor.takevideo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.tencent.aelight.camera.report.api.IAEBaseReportParam;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.util.WeakReferenceHandler;
import java.util.HashMap;

/* loaded from: classes32.dex */
public class EditPicRawImage extends u implements Runnable, Handler.Callback, View.OnLayoutChangeListener {
    public static int Q;
    private float C;
    private float D;
    private float E;
    private float F;
    private float G;
    private float H;
    private float I;
    private float J;
    private final RectF K;
    private final Matrix L;
    private final Matrix M;
    private final float[] N;
    private final RectF P;

    /* renamed from: d, reason: collision with root package name */
    ImageView f67706d;

    /* renamed from: e, reason: collision with root package name */
    Bitmap f67707e;

    /* renamed from: f, reason: collision with root package name */
    WeakReferenceHandler f67708f;

    /* renamed from: h, reason: collision with root package name */
    boolean f67709h;

    /* renamed from: i, reason: collision with root package name */
    boolean f67710i;

    /* renamed from: m, reason: collision with root package name */
    private int f67711m;

    /* loaded from: classes32.dex */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (QLog.isDevelopLevel()) {
                ms.a.f("EditPicActivity.EditVideoRawImage", "[EditPicRawImage onGlobalLayout]");
            }
            Bitmap bitmap = EditPicRawImage.this.f67707e;
            if (bitmap != null && !bitmap.isRecycled()) {
                int width = EditPicRawImage.this.f67706d.getWidth();
                int height = EditPicRawImage.this.f67706d.getHeight();
                if (QLog.isDevelopLevel()) {
                    ms.a.f("EditPicActivity.EditVideoRawImage", "last width = " + EditPicRawImage.this.C + ", last height = " + EditPicRawImage.this.D);
                    ms.a.f("EditPicActivity.EditVideoRawImage", "current width = " + width + ", current height = " + height);
                }
                if (((int) EditPicRawImage.this.C) == width && ((int) EditPicRawImage.this.D) == height) {
                    return;
                }
                EditPicRawImage.Q = height;
                EditPicRawImage.this.s0();
                EditPicRawImage.this.Z(width, height, true);
                return;
            }
            ms.a.f("EditPicActivity.EditVideoRawImage", "display bitmap is invalid");
        }
    }

    public EditPicRawImage(EditVideoPartManager editVideoPartManager, int i3) {
        super(editVideoPartManager);
        this.f67708f = new WeakReferenceHandler(Looper.getMainLooper(), this);
        this.f67709h = false;
        this.f67710i = false;
        this.I = 1.0f;
        this.J = 3.0f;
        this.K = new RectF();
        this.L = new Matrix();
        this.M = new Matrix();
        this.N = new float[9];
        this.P = new RectF();
        this.f67711m = i3;
    }

    public static int m0(BitmapFactory.Options options, int i3, int i16) {
        int i17 = options.outHeight;
        int i18 = options.outWidth;
        if (i17 > i18 * 6) {
            i16 *= 3;
        }
        if (i18 > i17 * 6) {
            i3 *= 3;
        }
        if (i17 <= i16 * 1.2f && i18 <= i3 * 1.2f) {
            return 1;
        }
        int i19 = 2;
        int i26 = i17 / 2;
        int i27 = i18 / 2;
        while (true) {
            if (i26 / i19 <= i16 && i27 / i19 <= i3) {
                return i19;
            }
            i19 *= 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        float f16;
        float f17;
        if (this.f67706d.getWidth() <= 0 || this.f67706d.getHeight() <= 0) {
            return;
        }
        Drawable drawable = this.f67706d.getDrawable();
        if (drawable == null) {
            ms.a.a("EditPicActivity.EditVideoRawImage", "image view with no drawable");
            return;
        }
        this.E = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        this.F = intrinsicHeight;
        if (this.E > 0.0f && intrinsicHeight > 0.0f) {
            this.C = this.f67706d.getWidth();
            float height = this.f67706d.getHeight();
            this.D = height;
            float f18 = this.C;
            float f19 = this.E;
            float f26 = f18 / f19;
            float f27 = this.F;
            if (f26 >= height / f27) {
                float f28 = height / f27;
                this.I = f28;
                f17 = (f18 - (f19 * f28)) / 2.0f;
                f16 = 0.0f;
            } else {
                float f29 = f18 / f19;
                this.I = f29;
                f16 = (height - (f27 * f29)) / 2.0f;
                f17 = 0.0f;
            }
            ms.a.f("EditPicActivity.EditVideoRawImage", "bitmap width = " + this.E + "bitmap height = " + this.F);
            ms.a.f("EditPicActivity.EditVideoRawImage", "scale = " + this.I + ", tx = " + f17 + ", ty = " + f16);
            this.J = Math.max(this.I, this.J);
            this.L.reset();
            Matrix matrix = this.L;
            float f36 = this.I;
            matrix.setScale(f36, f36);
            this.L.postTranslate(f17, f16);
            z0(this.L, false);
            this.K.set(0.0f, 0.0f, this.E, this.F);
            this.f67706d.getImageMatrix().mapRect(this.K);
            EditVideoDoodle editVideoDoodle = this.mParent.I;
            if (editVideoDoodle != null) {
                if (this.E / this.C != this.F / this.D) {
                    editVideoDoodle.t0(new RectF(this.K));
                    return;
                } else {
                    editVideoDoodle.t0(null);
                    return;
                }
            }
            return;
        }
        ms.a.a("EditPicActivity.EditVideoRawImage", "image view drawable size is not ready");
    }

    void Z(int i3, int i16, boolean z16) {
        d dVar = (d) getEditExport(d.class);
        if (dVar != null) {
            try {
                dVar.Z(i3, i16, z16);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void editVideoPrePublish(int i3, fs.b bVar) {
        fs.g gVar = bVar.f400395l;
        gVar.f400419e = this.f67710i;
        gVar.f400417c = this.f67707e;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Bitmap d16;
        aa aaVar = this.mUi;
        if (aaVar != null && aaVar.getActivity() != null && !this.mUi.getActivity().isFinishing()) {
            int i3 = message.what;
            if (i3 == 998) {
                QQToast.makeText(this.mUi.getActivity().getApplicationContext(), this.mUi.getActivity().getResources().getString(R.string.i3j), 0).show();
                this.mUi.finish(0, null, R.anim.dialog_exit, 0);
            } else if (i3 == 999) {
                Object obj = message.obj;
                if (obj instanceof Bitmap) {
                    d16 = (Bitmap) obj;
                } else {
                    d16 = g.d(((Long) obj).longValue());
                    if (d16 == null || d16.getWidth() < 64 || d16.getHeight() < 64) {
                        QLog.e("EditPicActivity.EditVideoRawImage", 1, "bitmap illegal");
                        this.mUi.finish(0, null, R.anim.dialog_exit, 0);
                        return false;
                    }
                }
                y0(d16, false);
                this.mParent.F0();
                w0();
                if (this.f67709h) {
                    this.mParent.s(Message.obtain(null, 2, 4, 0));
                } else if (this.mParent.C.e() != 106 && this.mParent.C.e() != 109 && this.mParent.C.e() != 103) {
                    this.mParent.s(Message.obtain(null, 2, 1024, 0));
                }
            }
            ms.a.c("PhotoTakenPerformance", "end");
            return false;
        }
        Object[] objArr = new Object[2];
        objArr[0] = "handleMessage isFinishing" + message.what + " mUi is null, ";
        objArr[1] = Boolean.valueOf(this.mUi == null);
        QLog.e("EditPicActivity.EditVideoRawImage", 1, objArr);
        return false;
    }

    public float n0() {
        return this.I;
    }

    public float o0() {
        this.f67706d.getImageMatrix().getValues(this.N);
        return this.N[0];
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onCreate() {
        super.onCreate();
        ((IAEBaseReportParam) QRoute.api(IAEBaseReportParam.class)).setVideoDuration(-1L);
        if (g.f(this.mParent.C.E)) {
            this.f67708f.obtainMessage(999, Long.valueOf(this.mParent.C.E)).sendToTarget();
        } else {
            ThreadManagerV2.post(this, 8, null, false);
        }
        ImageView imageView = (ImageView) findViewSure(R.id.rzd);
        this.f67706d = imageView;
        imageView.getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onDestroy() {
        super.onDestroy();
        this.f67708f.removeMessages(999);
        Q = 0;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        if (QLog.isColorLevel()) {
            QLog.i("EditPicActivity.EditVideoRawImage", 2, "onLayoutChange, height pixel change,bottom:" + i18 + " oldBottom:" + i28 + " top:" + i16 + " oldTop:" + i26);
        }
        if (i28 != i18 && Q == 0 && i18 > 0) {
            Q = i18 - i16;
        }
        final boolean z16 = (i27 - i19 == i17 - i3 && i28 - i26 == i18 - i16) ? false : true;
        this.f67706d.post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditPicRawImage.2
            @Override // java.lang.Runnable
            public void run() {
                int width = EditPicRawImage.this.f67706d.getWidth();
                int height = EditPicRawImage.this.f67706d.getHeight();
                if (!z16 || width <= 0 || height <= 0) {
                    return;
                }
                EditPicRawImage.this.s0();
                EditPicRawImage.this.x0(width, height);
            }
        });
    }

    public Bitmap p0() {
        return this.f67707e;
    }

    public float q0() {
        return this.J;
    }

    @Override // java.lang.Runnable
    public void run() {
        aa aaVar;
        Bitmap bitmap;
        Bitmap decodeFileWithBufferedStream;
        if (this.mIsDestroy || (aaVar = this.mUi) == null) {
            return;
        }
        String sourcePath = this.mParent.C.f204059i.getSourcePath();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BaseImageUtil.decodeFileWithBufferedStream(sourcePath, options);
        r0(options.outWidth, options.outHeight);
        if (options.outWidth >= 64 && options.outHeight >= 64) {
            DisplayMetrics displayMetrics = aaVar.getActivity().getResources().getDisplayMetrics();
            int m06 = m0(options, displayMetrics.widthPixels, displayMetrics.heightPixels);
            options.inJustDecodeBounds = false;
            options.inSampleSize = m06;
            try {
                decodeFileWithBufferedStream = BaseImageUtil.decodeFileWithBufferedStream(sourcePath, options);
            } catch (OutOfMemoryError unused) {
                QLog.e("EditPicActivity.EditVideoRawImage", 1, "decode oom" + options.inSampleSize);
                options.inSampleSize = m06 * 2;
                try {
                    decodeFileWithBufferedStream = BaseImageUtil.decodeFileWithBufferedStream(sourcePath, options);
                } catch (OutOfMemoryError unused2) {
                    QLog.e("EditPicActivity.EditVideoRawImage", 1, "decode oom" + options.inSampleSize);
                    options.inSampleSize = m06 * 4;
                    try {
                        decodeFileWithBufferedStream = BaseImageUtil.decodeFileWithBufferedStream(sourcePath, options);
                    } catch (OutOfMemoryError unused3) {
                        QLog.e("EditPicActivity.EditVideoRawImage", 1, "decode oom again" + options.inSampleSize);
                        bitmap = null;
                    }
                }
            }
            bitmap = decodeFileWithBufferedStream;
            if (bitmap == null) {
                QLog.e("EditPicActivity.EditVideoRawImage", 1, "decode" + ((Object) null));
                aaVar.finish(0, null, R.anim.dialog_exit, 0);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("EditPicActivity.EditVideoRawImage", 2, "sampleSize" + m06 + " w " + bitmap.getWidth() + " h " + bitmap.getHeight());
            }
            this.mParent.C.f204060m = bitmap.getWidth();
            this.mParent.C.C = bitmap.getHeight();
            int exifOrientation = BaseImageUtil.getExifOrientation(sourcePath);
            if (exifOrientation != 0 && exifOrientation % 90 == 0) {
                this.mParent.f67778b0 = exifOrientation;
                if (QLog.isColorLevel()) {
                    QLog.d("EditPicActivity.EditVideoRawImage", 2, "has exif rotate" + exifOrientation);
                }
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                Matrix matrix = new Matrix();
                matrix.postRotate(exifOrientation, width / 2.0f, height / 2.0f);
                bitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            }
            if (this.mUi != null) {
                this.f67708f.obtainMessage(999, bitmap).sendToTarget();
                return;
            }
            return;
        }
        QLog.e("EditPicActivity.EditVideoRawImage", 1, "too small");
        this.f67708f.sendEmptyMessage(998);
    }

    public void t0(float f16, float f17, float f18) {
        float o06 = o0();
        float min = Math.min(this.J / o06, Math.max(this.I / o06, f16));
        if (Math.abs(min - 1.0f) < 1.0E-6d) {
            return;
        }
        this.M.set(this.f67706d.getImageMatrix());
        this.M.postTranslate(f17 - this.G, f18 - this.H);
        this.M.postScale(min, min, f17, f18);
        z0(this.M, true);
        this.G = f17;
        this.H = f18;
    }

    public void u0(float f16, float f17) {
        this.G = f16;
        this.H = f17;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w0() {
        aa aaVar = this.mUi;
        if (aaVar != null && aaVar.getActivity() != null) {
            try {
                VideoReport.addToDetectionWhitelist(aaVar.getActivity());
                View rootView = aaVar.getRootView();
                EditVideoParams editVideoParams = this.mParent.C;
                VideoReport.setPageId(rootView, "pg_image_edit");
                HashMap hashMap = new HashMap();
                hashMap.put("type_aio_pg", Integer.valueOf(kr.a.c(editVideoParams)));
                hashMap.put("image_edit_import_from", Integer.valueOf(kr.a.d(editVideoParams)));
                hashMap.put("image_edit_import_size", kr.a.e(editVideoParams));
                VideoReport.setPageParams(rootView, kr.a.b(hashMap));
                QLog.d("EditPicActivity.EditVideoRawImage", 2, "registerDaTongPageReport map\uff1a" + hashMap);
                return;
            } catch (Exception unused) {
                return;
            }
        }
        QLog.e("EditPicActivity.EditVideoRawImage", 2, "registerDaTongPageReport failed, mUi is null!");
    }

    public void y0(Bitmap bitmap, boolean z16) {
        Bitmap bitmap2;
        Bitmap bitmap3;
        Bitmap bitmap4 = this.f67707e;
        if (bitmap4 != null && !bitmap4.isRecycled()) {
            this.f67707e.recycle();
        }
        if (bitmap != null && !bitmap.isRecycled()) {
            int width = this.f67706d.getWidth();
            int height = this.f67706d.getHeight();
            this.f67707e = bitmap;
            if (!this.f67710i && !EditVideoPartManager.v(this.f67711m, 8192) && (bitmap2 = this.f67707e) != null && this.mParent.f67780d == 0 && com.tencent.biz.qqstory.utils.k.g(bitmap2.getWidth(), this.f67707e.getHeight(), width, height)) {
                try {
                    bitmap3 = BaseImageUtil.gaussionBlur(getContext(), this.f67707e, 0.25f, 20.0f);
                } catch (Throwable th5) {
                    QLog.e("EditPicActivity.EditVideoRawImage", 1, "[setBitmap] gaussionBlur failed. ", th5);
                    bitmap3 = null;
                }
                if (bitmap3 != null) {
                    this.f67710i = true;
                    Canvas canvas = new Canvas();
                    canvas.setBitmap(bitmap3.isMutable() ? bitmap3 : bitmap3.copy(bitmap3.getConfig(), true));
                    canvas.drawColor(Color.parseColor("#3F000000"), PorterDuff.Mode.SRC_OVER);
                    Pair<Integer, Integer> b16 = com.tencent.biz.qqstory.utils.k.b(this.f67707e.getWidth(), this.f67707e.getHeight(), width, height);
                    this.f67707e = com.tencent.biz.qqstory.utils.b.l(com.tencent.biz.qqstory.utils.b.n(bitmap3, ((Integer) b16.first).intValue(), ((Integer) b16.second).intValue(), true), this.f67707e);
                }
            }
            this.f67706d.setImageBitmap(this.f67707e);
            this.f67706d.setScaleType(ImageView.ScaleType.MATRIX);
            s0();
            if (Build.MANUFACTURER.equalsIgnoreCase("Letv")) {
                this.f67706d.destroyDrawingCache();
                this.f67706d.refreshDrawableState();
                this.f67706d.invalidate();
            }
            if (!z16 && this.f67707e != null) {
                int width2 = this.f67706d.getWidth();
                int height2 = this.f67706d.getHeight();
                if (width2 <= 0 || height2 <= 0) {
                    return;
                }
                ms.a.f("EditPicActivity.EditVideoRawImage", "resizeDoodleView image width: " + width2 + " height: " + height2);
                x0(width2, height2);
                return;
            }
            d dVar = (d) getEditExport(d.class);
            if (dVar != null) {
                com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.c r06 = dVar.V().r0();
                com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.h hVar = r06 != null ? (com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.h) r06.I(104) : null;
                if (hVar != null) {
                    hVar.b();
                    hVar.i();
                    dVar.V().V0();
                    return;
                }
                return;
            }
            return;
        }
        ms.a.i("EditPicActivity.EditVideoRawImage", "setBitmap is invalid:" + bitmap);
    }

    public void v0() {
        this.H = 0.0f;
        this.G = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x0(int i3, int i16) {
        Z(i3, i16, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void z0(Matrix matrix, boolean z16) {
        float f16;
        float f17;
        float f18;
        if (z16) {
            float f19 = 0.0f;
            this.P.set(0.0f, 0.0f, this.E, this.F);
            matrix.mapRect(this.P);
            RectF rectF = this.P;
            float f26 = rectF.left;
            RectF rectF2 = this.K;
            float f27 = rectF2.left;
            if (f26 <= f27) {
                f26 = rectF.right;
                f27 = rectF2.right;
                if (f26 >= f27) {
                    f16 = 0.0f;
                    f17 = rectF.top;
                    f18 = rectF2.top;
                    if (f17 <= f18) {
                        f19 = f18 - f17;
                    } else {
                        float f28 = rectF.bottom;
                        float f29 = rectF2.bottom;
                        if (f28 < f29) {
                            f19 = f29 - f28;
                        }
                    }
                    matrix.postTranslate(f16, f19);
                }
            }
            f16 = f27 - f26;
            f17 = rectF.top;
            f18 = rectF2.top;
            if (f17 <= f18) {
            }
            matrix.postTranslate(f16, f19);
        }
        this.f67706d.setImageMatrix(matrix);
        this.f67706d.invalidate();
        this.L.invert(this.M);
        this.M.postConcat(this.f67706d.getImageMatrix());
        EditVideoDoodle editVideoDoodle = this.mParent.I;
        if (editVideoDoodle != null) {
            editVideoDoodle.u0(this.M);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void editVideoStateChanged(int i3, Object obj) {
        if (i3 == 7) {
            this.f67706d.setVisibility(8);
        } else {
            this.f67706d.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r0(int i3, int i16) {
    }
}
