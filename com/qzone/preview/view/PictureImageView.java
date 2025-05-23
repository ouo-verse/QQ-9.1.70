package com.qzone.preview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.qzone.common.account.LoginData;
import com.qzone.common.tool.ReportUtils;
import com.qzone.preview.LocalPictureViewer;
import com.qzone.preview.QzonePictureViewer;
import com.qzone.preview.business.BasePicureViewController;
import com.qzone.util.ar;
import com.qzone.util.z;
import com.qzone.widget.AsyncImageable;
import com.qzone.widget.QzoneFaceFriendSelectPopWindow;
import com.tencent.avcore.jni.codec.HWColorFormat;
import com.tencent.component.media.gif.AvifGifDrawable;
import com.tencent.component.media.gif.NewGifDrawable;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.drawable.BitmapImageDrawable;
import com.tencent.component.media.image.drawable.ImageDrawable;
import com.tencent.component.media.image.drawable.SliceBitmapDrawable;
import com.tencent.component.media.image.processor.ScaleProcessor;
import com.tencent.component.media.image.region.RegionDrawable;
import com.tencent.component.media.image.view.ExtendImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.widget.Gallery;
import cooperation.qzone.IPictureViewHack;
import cooperation.qzone.model.FaceData;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes39.dex */
public class PictureImageView extends ExtendImageView implements AsyncImageable, IPictureViewHack, BasePicureViewController.e {

    /* renamed from: h0, reason: collision with root package name */
    public static final Bitmap.Config f50063h0 = Bitmap.Config.ARGB_8888;

    /* renamed from: i0, reason: collision with root package name */
    protected static Bitmap f50064i0 = null;

    /* renamed from: j0, reason: collision with root package name */
    protected static int f50065j0 = 0;

    /* renamed from: k0, reason: collision with root package name */
    protected static int f50066k0 = 0;

    /* renamed from: l0, reason: collision with root package name */
    protected static float f50067l0 = 0.0f;

    /* renamed from: m0, reason: collision with root package name */
    protected static float f50068m0 = 14.0f;

    /* renamed from: n0, reason: collision with root package name */
    protected static float f50069n0 = 0.0f;

    /* renamed from: o0, reason: collision with root package name */
    protected static int f50070o0 = 0;
    protected String[] C;
    protected boolean[] D;
    protected boolean[] E;
    protected Rect[] F;
    protected float[] G;
    protected Paint H;
    protected int I;
    protected Rect J;
    protected boolean K;
    protected boolean L;
    protected List<FaceData> M;
    protected boolean N;
    protected int P;
    protected int Q;
    protected Rect R;
    protected d S;
    protected com.qzone.preview.b T;
    protected BasePicureViewController U;
    protected boolean V;
    protected boolean W;

    /* renamed from: a0, reason: collision with root package name */
    protected boolean f50071a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f50072b0;

    /* renamed from: c0, reason: collision with root package name */
    private Path f50073c0;

    /* renamed from: d, reason: collision with root package name */
    protected final AsyncImageable.AsyncImageableImpl f50074d;

    /* renamed from: d0, reason: collision with root package name */
    private int f50075d0;

    /* renamed from: e, reason: collision with root package name */
    protected float f50076e;

    /* renamed from: e0, reason: collision with root package name */
    QzoneFaceFriendSelectPopWindow f50077e0;

    /* renamed from: f, reason: collision with root package name */
    protected Paint f50078f;

    /* renamed from: f0, reason: collision with root package name */
    RectF f50079f0;

    /* renamed from: g0, reason: collision with root package name */
    public MotionEvent f50080g0;

    /* renamed from: h, reason: collision with root package name */
    protected Rect[] f50081h;

    /* renamed from: i, reason: collision with root package name */
    protected Rect[] f50082i;

    /* renamed from: m, reason: collision with root package name */
    protected RectF[] f50083m;

    public PictureImageView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k() {
        q();
        postInvalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0036, code lost:
    
        if (r1 < (r8 + r7.getHeight())) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ boolean l(View view, MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        if (motionEvent.getAction() == 0) {
            if (rawX >= iArr[0] && rawX < r8 + view.getWidth()) {
                if (rawY >= iArr[1]) {
                }
            }
            float floatValue = ((Float) ((View) getParent()).getTag(Gallery.ID_DEFAULT_SCALE)).floatValue();
            if (m(this.I) && this.f50076e != floatValue) {
                this.f50076e = floatValue;
                MotionEvent motionEvent2 = this.f50080g0;
                if (motionEvent2 != null) {
                    this.U.A0(motionEvent2, floatValue, true);
                }
            }
            this.f50077e0.dismiss();
            return true;
        }
        return false;
    }

    @Override // com.qzone.preview.business.BasePicureViewController.e
    public void a(boolean z16) {
        this.N = z16;
        postInvalidate();
    }

    @Override // com.qzone.widget.AsyncImageable
    public void cancelAsyncLoadImage() {
        this.f50074d.cancelAsyncLoadImage();
    }

    @Override // com.qzone.widget.AsyncImageable
    public void cancelAsyncLoadImageWithoutListener() {
        this.f50074d.cancelAsyncLoadImageWithoutListener();
    }

    protected void e(Canvas canvas) {
        for (Rect rect : this.f50081h) {
            if (rect.left != 0 || rect.top != 0 || rect.right != 0 || rect.bottom != 0) {
                this.f50078f.setColor(-1929379841);
                this.f50078f.setStyle(Paint.Style.STROKE);
                this.f50078f.setStrokeWidth(d(1));
                float f16 = rect.left;
                float f17 = rect.top;
                float f18 = rect.right;
                float f19 = rect.bottom;
                canvas.drawRoundRect(new RectF(f16, f17, f18, f19), 20.0f, 20.0f, this.f50078f);
                this.f50078f.setColor(352321535);
                this.f50078f.setStyle(Paint.Style.FILL);
                canvas.drawRoundRect(new RectF(f16, f17, f18, f19), 20.0f, 20.0f, this.f50078f);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0123  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void f(int i3, Canvas canvas) {
        int i16;
        int i17;
        int i18;
        int i19;
        String str = this.C[i3];
        if (str == null || str.length() <= 0) {
            return;
        }
        if (this.I == i3 && this.L) {
            this.C[i3] = o(this.M.get(i3).targetnick, false);
        } else {
            this.C[i3] = o(this.M.get(i3).targetnick, true);
        }
        this.G[i3] = this.H.measureText(this.C[i3]);
        float dip2px = (((this.G[i3] + ((this.D[i3] && this.I == i3 && this.L) ? f50066k0 : 0)) + ViewUtils.dip2px(20.0f)) + ViewUtils.dip2px(12.0f)) / this.f50076e;
        float dip2px2 = (f50067l0 + ViewUtils.dip2px(16.0f)) / this.f50076e;
        Rect rect = this.f50081h[i3];
        int i26 = rect.left;
        int i27 = rect.right;
        float f16 = ((i27 - i26) / 2) + i26;
        float f17 = this.P - (((i27 - i26) / 2) + i26);
        float f18 = dip2px / 2.0f;
        int i28 = (int) (((i27 - i26) / 2) - f18);
        float f19 = 0.0f;
        if (f16 < f18 && f17 > 0.0f) {
            i16 = ((int) ((((int) dip2px) / 2) - f16)) + 10;
        } else {
            if (f16 <= 0.0f || f17 >= f18) {
                i16 = 0;
                RectF rectF = new RectF();
                Rect rect2 = this.f50081h[i3];
                rectF.left = rect2.left + i28;
                float dip2px3 = rect2.top - ((int) ((ViewUtils.dip2px(13.0f) / this.f50076e) + dip2px2));
                rectF.top = dip2px3;
                float f26 = (int) dip2px;
                rectF.right = rectF.left + f26;
                float f27 = (int) dip2px2;
                rectF.bottom = dip2px3 + f27;
                RectF rectF2 = new RectF();
                Rect rect3 = this.f50081h[i3];
                rectF2.left = rect3.left + i28;
                float dip2px4 = (int) (rect3.bottom + (ViewUtils.dip2px(13.0f) / this.f50076e));
                rectF2.top = dip2px4;
                rectF2.right = rectF2.left + f26;
                float f28 = dip2px4 + f27;
                rectF2.bottom = f28;
                i17 = rectF.top >= 0.0f ? 999 : 0;
                i18 = f28 <= ((float) this.Q) ? 0 : 999;
                for (i19 = 0; i19 < i3; i19++) {
                    if (RectF.intersects(rectF, this.f50083m[i19])) {
                        i17++;
                    }
                    if (RectF.intersects(rectF2, this.f50083m[i19])) {
                        i18++;
                    }
                }
                Path path = new Path();
                if (i17 > i18) {
                    this.f50083m[i3] = rectF;
                    path.addRoundRect(rectF, 10.0f, 10.0f, Path.Direction.CCW);
                    RectF rectF3 = this.f50083m[i3];
                    float f29 = rectF3.left;
                    float d16 = (f29 + ((rectF3.right - f29) / 2.0f)) - d(6);
                    float f36 = i16;
                    path.moveTo(d16 - f36, this.f50083m[i3].bottom);
                    RectF rectF4 = this.f50083m[i3];
                    float f37 = rectF4.left;
                    path.lineTo((f37 + ((rectF4.right - f37) / 2.0f)) - f36, this.f50081h[i3].top - (ViewUtils.dip2px(6.0f) / this.f50076e));
                    RectF rectF5 = this.f50083m[i3];
                    float f38 = rectF5.left;
                    path.lineTo(((f38 + ((rectF5.right - f38) / 2.0f)) + d(6)) - f36, this.f50083m[i3].bottom);
                } else {
                    this.f50083m[i3] = rectF2;
                    path.addRoundRect(rectF2, 10.0f, 10.0f, Path.Direction.CW);
                    RectF rectF6 = this.f50083m[i3];
                    float f39 = rectF6.left;
                    float d17 = (f39 + ((rectF6.right - f39) / 2.0f)) - d(6);
                    float f46 = i16;
                    path.moveTo(d17 - f46, this.f50083m[i3].top);
                    RectF rectF7 = this.f50083m[i3];
                    float f47 = rectF7.left;
                    path.lineTo((f47 + ((rectF7.right - f47) / 2.0f)) - f46, this.f50081h[i3].bottom + (ViewUtils.dip2px(6.0f) / this.f50076e));
                    RectF rectF8 = this.f50083m[i3];
                    float f48 = rectF8.left;
                    path.lineTo(((f48 + ((rectF8.right - f48) / 2.0f)) + d(6)) - f46, this.f50083m[i3].top);
                }
                path.close();
                this.f50078f.setColor(-1526726656);
                this.f50078f.setStyle(Paint.Style.FILL);
                canvas.drawPath(path, this.f50078f);
                if (this.D[i3] && this.I == i3 && this.L) {
                    Rect rect4 = new Rect();
                    float centerX = this.f50083m[i3].centerX();
                    float f49 = this.G[i3] / 2.0f;
                    float f56 = this.f50076e;
                    int i29 = (int) (centerX + (f49 / f56));
                    rect4.left = i29;
                    RectF rectF9 = this.f50083m[i3];
                    float f57 = rectF9.top;
                    float f58 = f57 + ((rectF9.bottom - f57) / 2.0f);
                    int i36 = f50065j0;
                    int i37 = (int) (f58 - ((i36 / 2) / f56));
                    rect4.top = i37;
                    rect4.right = (int) (i29 + (f50066k0 / f56));
                    rect4.bottom = (int) (i37 + (i36 / f56));
                    this.F[i3] = rect4;
                    canvas.drawBitmap(f50064i0, (Rect) null, rect4, this.f50078f);
                    this.F[i3].left = (int) (r0.left - (ViewUtils.dip2px(5.0f) / this.f50076e));
                    this.F[i3].top = (int) (r0.top - (ViewUtils.dip2px(5.0f) / this.f50076e));
                    this.F[i3].right = (int) (r0.right + (ViewUtils.dip2px(5.0f) / this.f50076e));
                    this.F[i3].bottom = (int) (r0.bottom + (ViewUtils.dip2px(5.0f) / this.f50076e));
                    f19 = ViewUtils.dip2px(11.0f) / this.f50076e;
                }
                this.f50078f.setTextSize(f50068m0 / this.f50076e);
                this.f50078f.setColor(-1);
                this.f50078f.setTextAlign(Paint.Align.CENTER);
                this.f50078f.setAntiAlias(true);
                Rect rect5 = new Rect();
                Paint paint = this.f50078f;
                String str2 = this.C[i3];
                paint.getTextBounds(str2, 0, str2.length(), rect5);
                Paint.FontMetricsInt fontMetricsInt = this.f50078f.getFontMetricsInt();
                canvas.drawText(this.C[i3], this.f50083m[i3].centerX() - f19, (int) ((((r1.bottom + r1.top) - fontMetricsInt.bottom) - fontMetricsInt.top) / 2.0f), this.f50078f);
                Rect rect6 = this.f50082i[i3];
                RectF rectF10 = this.f50083m[i3];
                rect6.left = (int) rectF10.left;
                rect6.right = (int) rectF10.right;
                rect6.bottom = (int) rectF10.bottom;
                rect6.top = (int) rectF10.top;
            }
            i16 = ((int) (((int) f17) - f18)) - 10;
        }
        i28 += i16;
        RectF rectF11 = new RectF();
        Rect rect22 = this.f50081h[i3];
        rectF11.left = rect22.left + i28;
        float dip2px32 = rect22.top - ((int) ((ViewUtils.dip2px(13.0f) / this.f50076e) + dip2px2));
        rectF11.top = dip2px32;
        float f262 = (int) dip2px;
        rectF11.right = rectF11.left + f262;
        float f272 = (int) dip2px2;
        rectF11.bottom = dip2px32 + f272;
        RectF rectF22 = new RectF();
        Rect rect32 = this.f50081h[i3];
        rectF22.left = rect32.left + i28;
        float dip2px42 = (int) (rect32.bottom + (ViewUtils.dip2px(13.0f) / this.f50076e));
        rectF22.top = dip2px42;
        rectF22.right = rectF22.left + f262;
        float f282 = dip2px42 + f272;
        rectF22.bottom = f282;
        if (rectF11.top >= 0.0f) {
        }
        if (f282 <= ((float) this.Q)) {
        }
        while (i19 < i3) {
        }
        Path path2 = new Path();
        if (i17 > i18) {
        }
        path2.close();
        this.f50078f.setColor(-1526726656);
        this.f50078f.setStyle(Paint.Style.FILL);
        canvas.drawPath(path2, this.f50078f);
        if (this.D[i3]) {
            Rect rect42 = new Rect();
            float centerX2 = this.f50083m[i3].centerX();
            float f492 = this.G[i3] / 2.0f;
            float f562 = this.f50076e;
            int i292 = (int) (centerX2 + (f492 / f562));
            rect42.left = i292;
            RectF rectF92 = this.f50083m[i3];
            float f572 = rectF92.top;
            float f582 = f572 + ((rectF92.bottom - f572) / 2.0f);
            int i362 = f50065j0;
            int i372 = (int) (f582 - ((i362 / 2) / f562));
            rect42.top = i372;
            rect42.right = (int) (i292 + (f50066k0 / f562));
            rect42.bottom = (int) (i372 + (i362 / f562));
            this.F[i3] = rect42;
            canvas.drawBitmap(f50064i0, (Rect) null, rect42, this.f50078f);
            this.F[i3].left = (int) (r0.left - (ViewUtils.dip2px(5.0f) / this.f50076e));
            this.F[i3].top = (int) (r0.top - (ViewUtils.dip2px(5.0f) / this.f50076e));
            this.F[i3].right = (int) (r0.right + (ViewUtils.dip2px(5.0f) / this.f50076e));
            this.F[i3].bottom = (int) (r0.bottom + (ViewUtils.dip2px(5.0f) / this.f50076e));
            f19 = ViewUtils.dip2px(11.0f) / this.f50076e;
        }
        this.f50078f.setTextSize(f50068m0 / this.f50076e);
        this.f50078f.setColor(-1);
        this.f50078f.setTextAlign(Paint.Align.CENTER);
        this.f50078f.setAntiAlias(true);
        Rect rect52 = new Rect();
        Paint paint2 = this.f50078f;
        String str22 = this.C[i3];
        paint2.getTextBounds(str22, 0, str22.length(), rect52);
        Paint.FontMetricsInt fontMetricsInt2 = this.f50078f.getFontMetricsInt();
        canvas.drawText(this.C[i3], this.f50083m[i3].centerX() - f19, (int) ((((r1.bottom + r1.top) - fontMetricsInt2.bottom) - fontMetricsInt2.top) / 2.0f), this.f50078f);
        Rect rect62 = this.f50082i[i3];
        RectF rectF102 = this.f50083m[i3];
        rect62.left = (int) rectF102.left;
        rect62.right = (int) rectF102.right;
        rect62.bottom = (int) rectF102.bottom;
        rect62.top = (int) rectF102.top;
    }

    public String i() {
        return this.f50074d.v();
    }

    public RectF j(Rect rect, Matrix matrix) {
        RectF rectF = new RectF();
        rectF.left = rect.left;
        rectF.right = rect.right;
        rectF.top = rect.top;
        rectF.bottom = rect.bottom;
        matrix.mapRect(rectF);
        return rectF;
    }

    public void n() {
        Drawable drawable = getDrawable();
        if (drawable instanceof RegionDrawable) {
            ((RegionDrawable) drawable).onRecycle();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        Drawable drawable = getDrawable();
        if (!(drawable instanceof NewGifDrawable) || drawable.getCallback() == this) {
            this.V = true;
            super.onDetachedFromWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.component.media.image.view.ExtendImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i3;
        super.onDraw(canvas);
        BasePicureViewController basePicureViewController = this.U;
        if (basePicureViewController != null) {
            basePicureViewController.U0(this);
        }
        if (this.Q != getHeight() || this.P != getWidth()) {
            this.R.set(0, 0, getWidth(), getHeight());
            this.P = this.R.width();
            this.Q = this.R.height();
            p();
        }
        Rect[] rectArr = this.f50081h;
        if (rectArr != null && rectArr.length != 0) {
            BasePicureViewController basePicureViewController2 = this.U;
            if (basePicureViewController2 != null) {
                basePicureViewController2.V0(5.0f);
            }
        } else {
            BasePicureViewController basePicureViewController3 = this.U;
            if (basePicureViewController3 != null) {
                basePicureViewController3.V0(Gallery.MAX_SCALE_DEFAULT);
            }
        }
        this.f50078f.reset();
        if (this.W) {
            if (this.f50075d0 == 1 && (i3 = this.I) != -1 && this.M.get(i3) != null && this.M.get(this.I).targetuin == 0) {
                h(canvas, this.J);
            } else if (this.f50081h != null) {
                e(canvas);
                this.f50078f.reset();
                g(canvas);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Rect rect;
        Rect rect2;
        Rect[] rectArr = this.f50082i;
        if (rectArr != null && rectArr.length != 0) {
            int action = motionEvent.getAction() & 255;
            int x16 = (int) motionEvent.getX();
            int y16 = (int) motionEvent.getY();
            if (action == 0) {
                Rect[] rectArr2 = this.f50081h;
                if (rectArr2 != null) {
                    for (int length = rectArr2.length - 1; length > -1; length--) {
                        if (this.f50081h[length].contains(x16, y16)) {
                            if (!this.U.f49896z) {
                                return false;
                            }
                            this.J = this.f50081h[length];
                            this.I = length;
                            this.f50075d0 = 1;
                            return true;
                        }
                        if (this.f50083m[length].contains(x16, y16)) {
                            if (this.F[length].contains(x16, y16)) {
                                this.J = this.F[length];
                                this.f50075d0 = 3;
                            } else {
                                this.J = this.f50082i[length];
                                this.f50075d0 = 2;
                            }
                            this.I = length;
                            return true;
                        }
                        q();
                    }
                }
            } else if (action != 1) {
                if (action == 2 && this.I != -1 && (rect2 = this.J) != null && !rect2.contains(x16, y16)) {
                    q();
                }
            } else if (this.I != -1 && (rect = this.J) != null && rect.contains(x16, y16)) {
                QZLog.d("[PhotoAlbum]FaceFuntion", 2, "mTouchRectIndex:", Integer.valueOf(this.I), " mActionRect:", Integer.valueOf(this.f50075d0), " mTouchRect:", this.J);
                int i3 = this.I;
                if (i3 != -1 && i3 < this.M.size()) {
                    FaceData faceData = this.M.get(this.I);
                    int i16 = this.f50075d0;
                    if (i16 != 1) {
                        if (i16 == 2) {
                            if (this.T instanceof QzonePictureViewer) {
                                LpReportInfo_pf00064.allReport(301, 26);
                            }
                            postInvalidate();
                        } else if (i16 == 3) {
                            faceData.targetGroupid = faceData.groupid;
                            this.U.O0(faceData, this.I, 2);
                            faceData.targetuin = 0L;
                            faceData.targetnick = "";
                            faceData.targetGroupid = "";
                            p();
                            postInvalidate();
                        }
                    } else if (faceData.targetuin == 0 && this.U.f49896z && (this.D[this.I] || (this.T instanceof LocalPictureViewer) || faceData.owner_uin == LoginData.getInstance().getUin() || faceData.targetuin == 0)) {
                        motionEvent.setLocation(motionEvent.getRawX(), motionEvent.getRawY());
                        this.f50080g0 = motionEvent;
                        if (!m(this.I)) {
                            postInvalidate();
                        } else if (this.f50076e != 2.0f) {
                            this.f50076e = 2.0f;
                            this.U.A0(motionEvent, 2.0f, false);
                        } else {
                            this.U.A0(motionEvent, 2.0f, false);
                            postInvalidate();
                        }
                        LpReportInfo_pf00064.allReport(LpReportInfoConfig.ACTION_TYPE_LOCAL_PICTUREVIEWER_PAGE, 3);
                    }
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    protected void p() {
        int i3;
        if (this.Q != getHeight() || this.P != getWidth()) {
            this.Q = getHeight();
            this.P = getWidth();
        }
        if (this.P == 0 && this.Q == 0) {
            return;
        }
        List<FaceData> list = this.M;
        if (list != null && list.size() != 0) {
            int size = this.M.size();
            this.f50081h = new Rect[size];
            int i16 = 0;
            while (true) {
                Rect[] rectArr = this.f50081h;
                if (i16 >= rectArr.length) {
                    break;
                }
                rectArr[i16] = new Rect();
                i16++;
            }
            this.f50082i = new Rect[size];
            int i17 = 0;
            while (true) {
                Rect[] rectArr2 = this.f50082i;
                if (i17 >= rectArr2.length) {
                    break;
                }
                rectArr2[i17] = new Rect();
                i17++;
            }
            this.f50083m = new RectF[size];
            int i18 = 0;
            while (true) {
                RectF[] rectFArr = this.f50083m;
                if (i18 >= rectFArr.length) {
                    break;
                }
                rectFArr[i18] = new RectF();
                i18++;
            }
            this.F = new Rect[size];
            int i19 = 0;
            while (true) {
                Rect[] rectArr3 = this.F;
                if (i19 >= rectArr3.length) {
                    break;
                }
                rectArr3[i19] = new Rect();
                i19++;
            }
            this.C = new String[size];
            this.D = new boolean[size];
            this.E = new boolean[size];
            this.G = new float[size];
            this.H.setTextSize(f50068m0);
            for (int i26 = 0; i26 < size; i26++) {
                FaceData faceData = this.M.get(i26);
                if (faceData != null) {
                    if (faceData.quanstate == 1) {
                        if ((faceData.owner_uin == LoginData.getInstance().getUin() || faceData.writeruin == LoginData.getInstance().getUin() || faceData.targetuin == LoginData.getInstance().getUin()) && !TextUtils.isEmpty(faceData.faceid)) {
                            if (faceData.faceid.length() <= 5) {
                                this.D[i26] = false;
                            } else {
                                this.D[i26] = true;
                            }
                        } else {
                            this.D[i26] = false;
                        }
                        this.C[i26] = o(faceData.targetnick, true ^ this.D[i26]);
                    } else if (!TextUtils.isEmpty(faceData.targetnick) && faceData.targetuin != 0) {
                        this.D[i26] = true;
                        this.C[i26] = o(faceData.targetnick, true);
                    } else {
                        this.C[i26] = "";
                        this.D[i26] = false;
                    }
                    this.H.setTextSize(f50068m0);
                    this.G[i26] = this.H.measureText(this.C[i26]);
                    int i27 = this.P;
                    if (i27 > 0 && (i3 = this.Q) > 0) {
                        Rect rect = this.f50081h[i26];
                        int i28 = (int) (i27 * (((float) faceData.f390865x) / 10000.0f));
                        rect.left = i28;
                        int i29 = (int) (i3 * (((float) faceData.f390866y) / 10000.0f));
                        rect.top = i29;
                        rect.right = i28 + ((int) (i27 * (((float) faceData.f390864w) / 10000.0f)));
                        rect.bottom = i29 + ((int) (i3 * (((float) faceData.f390863h) / 10000.0f)));
                    }
                }
            }
            return;
        }
        this.f50081h = null;
        this.f50082i = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
    }

    @Override // cooperation.qzone.IPictureViewHack
    public boolean processGallerySingleTap(MotionEvent motionEvent, Matrix matrix) {
        if (this.f50081h == null) {
            return false;
        }
        int x16 = (int) motionEvent.getX();
        int y16 = (int) motionEvent.getY();
        int left = x16 - ((ViewGroup) getParent()).getLeft();
        int top = y16 - ((ViewGroup) getParent()).getTop();
        for (int length = this.f50081h.length - 1; length > -1; length--) {
            if (j(this.f50081h[length], matrix).contains(left, top)) {
                this.J = this.f50081h[length];
                this.I = length;
                this.L = true;
                this.K = false;
            }
        }
        for (int length2 = this.f50082i.length - 1; length2 > -1; length2--) {
            float f16 = left;
            float f17 = top;
            if (j(this.f50082i[length2], matrix).contains(f16, f17)) {
                if (j(this.F[length2], matrix).contains(f16, f17)) {
                    this.J = this.F[length2];
                    this.K = true;
                } else {
                    this.J = this.f50082i[length2];
                    this.K = false;
                }
                this.I = length2;
                this.L = true;
            }
        }
        return this.L;
    }

    @Override // com.qzone.widget.AsyncImageable
    public void setAsyncClipSize(int i3, int i16) {
        this.f50074d.setAsyncClipSize(i3, i16);
    }

    @Override // com.qzone.widget.AsyncImageable
    public void setAsyncImage(String str) {
        this.f50074d.setAsyncImage(str);
    }

    @Override // com.qzone.widget.AsyncImageable
    public void setAsyncImageListener(AsyncImageable.AsyncImageListener asyncImageListener) {
        this.f50074d.setAsyncImageListener(asyncImageListener);
    }

    @Override // com.qzone.widget.AsyncImageable
    public void setAsyncImageProcessor(ImageProcessor imageProcessor) {
        this.f50074d.setAsyncImageProcessor(imageProcessor);
    }

    @Override // com.qzone.widget.AsyncImageable
    public void setAsyncImages(ArrayList<String> arrayList, long j3) {
        this.f50074d.setAsyncImages(arrayList, j3);
    }

    @Override // com.qzone.widget.AsyncImageable
    public void setAsyncJustCover(boolean z16) {
        this.f50074d.setAsyncJustCover(z16);
    }

    @Override // com.qzone.widget.AsyncImageable
    public void setAsyncPreferQuality(boolean z16) {
        this.f50074d.setAsyncPreferQuality(z16);
    }

    @Override // com.qzone.widget.AsyncImageable
    public void setAsyncPriority(boolean z16) {
        this.f50074d.setAsyncPriority(z16);
    }

    @Override // com.qzone.widget.AsyncImageable
    public void setAsyncRootFilePath(String str) {
        this.f50074d.setAsyncRootFilePath(str);
    }

    public void setController(BasePicureViewController basePicureViewController) {
        this.U = basePicureViewController;
    }

    public void setDecodeConfig(Bitmap.Config config) {
        this.f50074d.G(config);
    }

    @Override // com.qzone.widget.AsyncImageable
    public void setDefaultImage(int i3) {
        this.f50074d.setDefaultImage(i3);
    }

    public void setEnableHighScale(boolean z16) {
        this.f50071a0 = z16;
    }

    public void setFaceData(List<FaceData> list) {
        this.M = list;
        this.Q = -1;
        this.P = -1;
        p();
        postInvalidate();
    }

    @Override // com.qzone.widget.AsyncImageable
    public void setFailImage(int i3) {
        this.f50074d.setFailImage(i3);
    }

    public void setImageType(int i3) {
        this.f50074d.I(i3);
    }

    @Override // com.qzone.widget.AsyncImageable
    public void setInternalAsyncImageListener(AsyncImageable.AsyncImageListener asyncImageListener) {
        this.f50074d.setInternalAsyncImageListener(asyncImageListener);
    }

    @Override // com.qzone.widget.AsyncImageable
    public void setNeedDownload(boolean z16) {
        this.f50074d.setNeedDownload(z16);
    }

    @Override // com.qzone.widget.AsyncImageable
    public void setNeedGifStream(boolean z16) {
        this.f50074d.setNeedGifStream(z16);
        d dVar = this.S;
        if (dVar == null || !z16) {
            return;
        }
        dVar.f50092a = true;
        setAsyncImageProcessor(dVar);
    }

    @Override // com.qzone.widget.AsyncImageable
    public void setNeedPieceLoad(boolean z16) {
        this.f50074d.setNeedPieceLoad(z16);
    }

    @Override // com.qzone.widget.AsyncImageable
    public void setNeedProgress(boolean z16) {
        this.f50074d.setNeedProgress(z16);
    }

    public void setOpenFace(boolean z16) {
        this.W = z16;
    }

    public void setOptImageScale(boolean z16) {
        this.S.d(z16);
        setAsyncImageProcessor(this.S);
    }

    public void setPictureViewer(com.qzone.preview.b bVar) {
        this.T = bVar;
    }

    public void setPlayingGif(boolean z16) {
        this.f50074d.J(z16);
    }

    public void setScale(float f16) {
        this.f50076e = f16;
        postInvalidate();
    }

    public PictureImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public float d(int i3) {
        int dip2px = ViewUtils.dip2px(i3);
        float f16 = this.f50076e;
        return f16 != 0.0f ? (float) ((dip2px * 1.0d) / f16) : dip2px;
    }

    protected void g(Canvas canvas) {
        for (int i3 = 0; i3 < this.f50081h.length; i3++) {
            if (this.I != i3) {
                f(i3, canvas);
            }
            int i16 = this.I;
            if (i16 != -1) {
                f(i16, canvas);
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        this.V = false;
        super.onAttachedToWindow();
    }

    protected void q() {
        this.f50075d0 = 0;
        this.J = null;
        this.I = -1;
    }

    public PictureImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f50076e = 1.0f;
        this.f50078f = new Paint();
        this.f50081h = null;
        this.f50082i = null;
        this.f50083m = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = new Paint();
        this.I = -1;
        this.J = null;
        boolean z16 = false;
        this.K = false;
        this.L = true;
        this.M = null;
        this.N = true;
        this.P = 0;
        this.Q = 0;
        this.R = new Rect();
        this.S = new d();
        this.T = null;
        this.U = null;
        this.V = false;
        this.W = false;
        this.f50072b0 = false;
        this.f50073c0 = new Path();
        this.f50075d0 = 0;
        this.f50079f0 = new RectF();
        this.f50080g0 = null;
        this.f50074d = new AsyncImageable.AsyncImageableImpl(this, this);
        if (f50064i0 == null) {
            Bitmap s16 = com.qzone.util.image.c.s(getResources(), R.drawable.fur);
            f50064i0 = s16;
            f50065j0 = s16.getHeight();
            f50066k0 = f50064i0.getWidth();
        }
        if (f50069n0 == 0.0f) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            float f16 = displayMetrics.density;
            f50069n0 = f16;
            f50070o0 = displayMetrics.widthPixels;
            float f17 = f16 * f50068m0;
            f50068m0 = f17;
            this.H.setTextSize(f17);
            Paint.FontMetrics fontMetrics = this.H.getFontMetrics();
            f50067l0 = (float) Math.ceil(fontMetrics.bottom - fontMetrics.top);
        }
        String str = Build.MANUFACTURER;
        if ((str.toUpperCase().equals("HUAWEI") || str.toUpperCase().equals("HW")) && f50070o0 >= 1080) {
            z16 = true;
        }
        this.f50072b0 = z16;
        setAsyncImageProcessor(this.S);
        setDecodeConfig(f50063h0);
    }

    protected String o(String str, boolean z16) {
        if (str == null) {
            return "";
        }
        float measureText = this.H.measureText(str);
        float f16 = (f50070o0 * 3) / 4;
        if (measureText > f16) {
            int length = str.length() - 1;
            while (length >= 0 && this.H.measureText(str.substring(0, length)) >= f16) {
                length--;
            }
            if (length < 0) {
                length = 0;
            }
            return str.substring(0, (length <= 10 || !z16) ? length : 10) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
        }
        if (str.length() <= 10 || !z16) {
            return str;
        }
        return str.substring(0, 10) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
    }

    protected void h(Canvas canvas, Rect rect) {
        if (rect == null) {
            return;
        }
        RectF rectF = this.f50079f0;
        rectF.left = rect.left;
        rectF.right = rect.right;
        rectF.top = rect.top;
        rectF.bottom = rect.bottom;
        if (this.f50072b0) {
            canvas.save();
            this.f50073c0.reset();
            this.f50073c0.addRect(0.0f, 0.0f, this.P, this.Q, Path.Direction.CW);
            canvas.clipPath(this.f50073c0);
            this.f50073c0.reset();
            this.f50073c0.addRoundRect(this.f50079f0, 20.0f, 20.0f, Path.Direction.CW);
            canvas.clipPath(this.f50073c0, Region.Op.DIFFERENCE);
            canvas.drawColor(HWColorFormat.COLOR_FormatVendorStartUnused);
            this.f50078f.setColor(1509949439);
            this.f50078f.setStyle(Paint.Style.STROKE);
            this.f50078f.setStrokeWidth(d(1));
            canvas.drawPath(this.f50073c0, this.f50078f);
        } else {
            canvas.saveLayerAlpha(0.0f, 0.0f, this.P, this.Q, 127);
            this.f50078f.setColor(1509949439);
            this.f50078f.setStyle(Paint.Style.STROKE);
            this.f50078f.setStrokeWidth(d(1));
            canvas.drawRoundRect(this.f50079f0, 20.0f, 20.0f, this.f50078f);
            RectF rectF2 = new RectF(0.0f, 0.0f, this.P, this.Q);
            this.f50078f.setColor(-1);
            this.f50078f.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawRoundRect(this.f50079f0, 20.0f, 20.0f, this.f50078f);
            this.f50078f.setColor(-16777216);
            this.f50078f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
            canvas.drawRect(rectF2, this.f50078f);
        }
        canvas.restore();
        if (this.f50077e0 == null) {
            this.f50077e0 = new QzoneFaceFriendSelectPopWindow(this.T.getHostActivity(), f50070o0);
        }
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        this.f50077e0.d(this.M.get(this.I), this.U.L);
        this.f50077e0.f(this.I);
        this.f50077e0.e(this.U.I());
        this.f50077e0.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.qzone.preview.view.b
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                PictureImageView.this.k();
            }
        });
        if (this.M.get(this.I).recommend_infos != null && this.M.get(this.I).recommend_infos.size() > 0) {
            HashMap hashMap = new HashMap(1);
            hashMap.put("recommendUin", "" + this.M.get(this.I).recommend_infos.size());
            QZLog.d("[PhotoAlbum]FaceFuntion", 2, "recommendUin", " size:", Integer.valueOf(this.M.get(this.I).recommend_infos.size()));
            ReportUtils.b("faceData", hashMap);
        }
        this.f50077e0.setTouchInterceptor(new View.OnTouchListener() { // from class: com.qzone.preview.view.c
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean l3;
                l3 = PictureImageView.this.l(view, motionEvent);
                return l3;
            }
        });
        QzoneFaceFriendSelectPopWindow qzoneFaceFriendSelectPopWindow = this.f50077e0;
        float f16 = iArr[0];
        int i3 = rect.left;
        qzoneFaceFriendSelectPopWindow.showAtLocation(this, 8388659, (int) ((f16 + ((i3 + ((rect.right - i3) / 2)) * this.f50076e)) - ViewUtils.dip2px(94.0f)), ((int) (iArr[1] + (rect.bottom * this.f50076e))) + 10);
        QzoneFaceFriendSelectPopWindow qzoneFaceFriendSelectPopWindow2 = this.f50077e0;
        float f17 = iArr[0];
        int i16 = rect.left;
        qzoneFaceFriendSelectPopWindow2.update((int) ((f17 + ((i16 + ((rect.right - i16) / 2)) * this.f50076e)) - ViewUtils.dip2px(94.0f)), ((int) (iArr[1] + (rect.bottom * this.f50076e))) + 10, -1, -1);
    }

    @Override // com.tencent.component.media.image.view.ExtendImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        int[] a16;
        boolean z16;
        Drawable drawable2 = drawable;
        int l3 = ar.l() - ((int) (ar.i() * 4.0f));
        int k3 = ar.k() - ((int) (ar.i() * 4.0f));
        if (drawable2 != null && (drawable2 instanceof SliceBitmapDrawable)) {
            ((SliceBitmapDrawable) drawable2).setTargetDensity(u5.a.f438266d);
        } else if (drawable2 != null && (drawable2 instanceof ImageDrawable) && this.S.f50092a) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (l3 > 0 && k3 > 0 && intrinsicWidth > 0 && intrinsicHeight > 0) {
                double d16 = intrinsicWidth;
                double d17 = intrinsicHeight;
                double d18 = d16 / d17;
                double d19 = l3;
                double d26 = k3;
                if (d18 > d19 / d26) {
                    k3 = (int) (d19 * (d17 / d16));
                } else {
                    l3 = (int) (d26 * d18);
                }
                drawable2 = new ScaleProcessor(l3, k3, true).process(drawable2);
                if (drawable2 != null) {
                    drawable2.setBounds(0, 0, l3, k3);
                }
            }
        } else if (drawable2 != null && (((z16 = drawable2 instanceof NewGifDrawable)) || (drawable2 instanceof AvifGifDrawable))) {
            int intrinsicWidth2 = drawable.getIntrinsicWidth();
            int intrinsicHeight2 = drawable.getIntrinsicHeight();
            if (l3 > 0 && k3 > 0 && intrinsicWidth2 > 0 && intrinsicHeight2 > 0) {
                double d27 = intrinsicWidth2;
                double d28 = intrinsicHeight2;
                double d29 = d27 / d28;
                double d36 = l3;
                double d37 = k3;
                if (d29 > d36 / d37) {
                    k3 = (int) (d36 * (d28 / d27));
                } else {
                    l3 = (int) (d37 * d29);
                }
                if (z16) {
                    NewGifDrawable newGifDrawable = (NewGifDrawable) drawable2;
                    newGifDrawable.setIntrinsicHeight(k3);
                    newGifDrawable.setIntrinsicWidth(l3);
                } else {
                    AvifGifDrawable avifGifDrawable = (AvifGifDrawable) drawable2;
                    avifGifDrawable.setIntrinsicHeight(k3);
                    avifGifDrawable.setIntrinsicWidth(l3);
                }
                drawable2.setBounds(0, 0, l3, k3);
            }
        } else if (drawable2 instanceof BitmapImageDrawable) {
            int intrinsicWidth3 = drawable.getIntrinsicWidth();
            int intrinsicHeight3 = drawable.getIntrinsicHeight();
            if (intrinsicWidth3 > 0 && intrinsicHeight3 > 0 && intrinsicWidth3 < l3 && intrinsicHeight3 < k3) {
                z zVar = new z();
                if (this.S.c()) {
                    a16 = zVar.c(intrinsicHeight3, intrinsicWidth3, k3, l3);
                } else {
                    a16 = zVar.a(intrinsicHeight3, intrinsicWidth3, k3, l3);
                }
                int i3 = a16[0];
                int i16 = a16[1];
                drawable2 = new ScaleProcessor(i3, i16, true).process(drawable2);
                if (drawable2 != null) {
                    drawable2.setBounds(0, 0, i3, i16);
                }
            }
        }
        if (drawable2 != null && (drawable2 instanceof NewGifDrawable)) {
            Drawable.Callback callback = drawable2.getCallback();
            if ((callback instanceof PictureImageView) && callback != this && this.V) {
                return;
            }
        }
        super.setImageDrawable(drawable2);
    }

    protected boolean m(int i3) {
        boolean z16;
        if (i3 >= 0) {
            Object[] objArr = new Object[6];
            objArr[0] = "needScale:";
            if (i3 >= 0) {
                if (((this.f50081h[i3].width() * 1.0d) / this.P) * f50070o0 < r8 / 4) {
                    z16 = true;
                    objArr[1] = Boolean.valueOf(z16);
                    objArr[2] = " face width:";
                    objArr[3] = Double.valueOf(((this.f50081h[i3].width() * 1.0d) / this.P) * f50070o0);
                    objArr[4] = " screenW/4:";
                    objArr[5] = Integer.valueOf(f50070o0 / 4);
                    QZLog.d("[PhotoAlbum]FaceFuntion", 2, objArr);
                }
            }
            z16 = false;
            objArr[1] = Boolean.valueOf(z16);
            objArr[2] = " face width:";
            objArr[3] = Double.valueOf(((this.f50081h[i3].width() * 1.0d) / this.P) * f50070o0);
            objArr[4] = " screenW/4:";
            objArr[5] = Integer.valueOf(f50070o0 / 4);
            QZLog.d("[PhotoAlbum]FaceFuntion", 2, objArr);
        }
        if (i3 >= 0) {
            if (((this.f50081h[i3].width() * 1.0d) / this.P) * f50070o0 < r13 / 4) {
                return true;
            }
        }
        return false;
    }
}
