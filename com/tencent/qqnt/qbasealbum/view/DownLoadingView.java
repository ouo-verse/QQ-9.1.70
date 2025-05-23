package com.tencent.qqnt.qbasealbum.view;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.avcore.jni.codec.HWColorFormat;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\bR\u0010SB\u001b\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010U\u001a\u0004\u0018\u00010T\u00a2\u0006\u0004\bR\u0010VB#\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010U\u001a\u0004\u0018\u00010T\u0012\u0006\u0010W\u001a\u00020\u0006\u00a2\u0006\u0004\bR\u0010XJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0006J\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0006J\u001e\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0011J\u0018\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0014J(\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H\u0014J\u0010\u0010 \u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u001eH\u0014J\u000e\u0010\"\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u0006J\u000e\u0010%\u001a\u00020\t2\u0006\u0010$\u001a\u00020#R\u0016\u0010(\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010+R\u0016\u0010/\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010+R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00108\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00105R\u0016\u0010:\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00105R\u0016\u0010<\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u00105R\u0018\u0010?\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010>R\u0016\u0010A\u001a\u00020=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010>R\u0016\u0010D\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010E\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010CR\u0016\u0010F\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010'R\u0016\u0010H\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010'R\u0016\u0010J\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010'R\u0016\u0010M\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010O\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010LR\u0016\u0010Q\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010L\u00a8\u0006Y"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/view/DownLoadingView;", "Landroid/view/View;", "", "dp", "Landroid/content/Context;", "context", "", "a", "corner", "", "setBgCorner", "color", "setBgColor", "setProgressColor", "setRingColor", "progressRadius", "innerPadding", "", "fanMode", "setProgressSizeAndMode", "drawMaskMode", "b", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "w", h.F, "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "max", "setMax", "", "progress", HippyQQPagView.FunctionName.SET_PROGRESS, "d", UserInfo.SEX_FEMALE, "scale", "Landroid/graphics/Paint;", "e", "Landroid/graphics/Paint;", "mGreyPaint", "f", "mTransPaint", "mRingPaint", "Landroid/graphics/Path;", "i", "Landroid/graphics/Path;", "mArcPath", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "mWidth", BdhLogUtil.LogTag.Tag_Conn, "mHeight", "D", "centerX", "E", "centerY", "Landroid/graphics/RectF;", "Landroid/graphics/RectF;", "viewRectF", "G", "innerRectF", "H", "J", "mMax", "mProgress", "mCorner", "K", "mRadius", "L", "mInnerPadding", "M", "Z", "isDrawMaskMode", "N", "isProgressFan", "P", "isRoundStrokeCap", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class DownLoadingView extends View {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    private int mHeight;

    /* renamed from: D, reason: from kotlin metadata */
    private int centerX;

    /* renamed from: E, reason: from kotlin metadata */
    private int centerY;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private RectF viewRectF;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private RectF innerRectF;

    /* renamed from: H, reason: from kotlin metadata */
    private long mMax;

    /* renamed from: I, reason: from kotlin metadata */
    private long mProgress;

    /* renamed from: J, reason: from kotlin metadata */
    private float mCorner;

    /* renamed from: K, reason: from kotlin metadata */
    private float mRadius;

    /* renamed from: L, reason: from kotlin metadata */
    private float mInnerPadding;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean isDrawMaskMode;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean isProgressFan;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean isRoundStrokeCap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float scale;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Paint mGreyPaint;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Paint mTransPaint;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Paint mRingPaint;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Path mArcPath;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mWidth;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownLoadingView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mGreyPaint = new Paint(1);
        this.mTransPaint = new Paint(1);
        this.mRingPaint = new Paint(1);
        this.mArcPath = new Path();
        float f16 = this.centerX - R.attr.radius;
        int i3 = this.centerY;
        this.innerRectF = new RectF(f16, i3 - R.attr.radius, r1 + R.attr.radius, i3 + R.attr.radius);
        this.mMax = 100L;
        Intrinsics.checkNotNullExpressionValue(getContext(), "context");
        this.mCorner = a(2.0f, r8);
        Intrinsics.checkNotNullExpressionValue(getContext(), "context");
        this.mRadius = a(17.5f, r8);
        Intrinsics.checkNotNullExpressionValue(getContext(), "context");
        this.mInnerPadding = a(2.5f, r8);
        this.isProgressFan = true;
        this.isRoundStrokeCap = true;
        this.mGreyPaint.setStyle(Paint.Style.FILL);
        this.mGreyPaint.setColor(HWColorFormat.COLOR_FormatVendorStartUnused);
        this.mTransPaint.setStyle(Paint.Style.FILL);
        this.mTransPaint.setColor(0);
        this.mTransPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.mRingPaint.setStyle(Paint.Style.STROKE);
        this.mRingPaint.setColor(0);
        this.mRingPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        setLayerType(1, null);
    }

    private final int a(float dp5, Context context) {
        boolean z16;
        if (this.scale == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.scale = context.getResources().getDisplayMetrics().density;
        }
        return (int) (dp5 * this.scale);
    }

    public final void b(boolean drawMaskMode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, drawMaskMode);
        } else {
            this.isDrawMaskMode = drawMaskMode;
        }
    }

    @Override // android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (this.isDrawMaskMode) {
            RectF rectF = this.viewRectF;
            Intrinsics.checkNotNull(rectF);
            float f16 = this.mCorner;
            canvas.drawRoundRect(rectF, f16, f16, this.mGreyPaint);
            return;
        }
        RectF rectF2 = this.viewRectF;
        Intrinsics.checkNotNull(rectF2);
        float f17 = this.mCorner;
        canvas.drawRoundRect(rectF2, f17, f17, this.mGreyPaint);
        if (!this.isProgressFan) {
            canvas.drawArc(this.innerRectF, 360.0f, 360.0f, false, this.mRingPaint);
        }
        long j3 = this.mMax;
        long j16 = this.mProgress;
        boolean z16 = false;
        if (0 <= j16 && j16 <= j3) {
            z16 = true;
        }
        if (z16) {
            float f18 = (((float) j16) * 360.0f) / ((float) j3);
            if (this.isProgressFan) {
                canvas.drawCircle(this.centerX, this.centerY, this.mRadius, this.mTransPaint);
                canvas.drawCircle(this.centerX, this.centerY, this.mRadius - this.mInnerPadding, this.mGreyPaint);
                this.mArcPath.reset();
                this.mArcPath.moveTo(this.centerX, this.centerY);
                this.mArcPath.arcTo(this.innerRectF, 270.0f, f18);
                canvas.drawPath(this.mArcPath, this.mTransPaint);
                return;
            }
            canvas.drawArc(this.innerRectF, 270.0f, f18, false, this.mTransPaint);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(widthMeasureSpec), Integer.valueOf(heightMeasureSpec));
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(w3), Integer.valueOf(h16), Integer.valueOf(oldw), Integer.valueOf(oldh));
            return;
        }
        super.onSizeChanged(w3, h16, oldw, oldh);
        this.mWidth = w3;
        this.mHeight = h16;
        this.centerX = w3 / 2;
        this.centerY = h16 / 2;
        this.viewRectF = new RectF(0.0f, 0.0f, this.mWidth, this.mHeight);
        float f16 = this.mRadius - this.mInnerPadding;
        int i3 = this.centerX;
        int i16 = this.centerY;
        this.innerRectF = new RectF(i3 - f16, i16 - f16, i3 + f16, i16 + f16);
    }

    public final void setBgColor(int color) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, color);
        } else {
            this.mGreyPaint.setColor(color);
        }
    }

    public final void setBgCorner(float corner) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Float.valueOf(corner));
        } else {
            this.mCorner = corner;
        }
    }

    public final void setMax(int max) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, max);
        } else {
            this.mMax = max;
        }
    }

    public final void setProgress(long progress) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, progress);
            return;
        }
        this.mProgress = progress;
        if (progress == this.mMax) {
            setVisibility(4);
        }
        invalidate();
    }

    public final void setProgressColor(int color) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, color);
        } else {
            this.mTransPaint.setColor(color);
        }
    }

    public final void setProgressSizeAndMode(float progressRadius, float innerPadding, boolean fanMode) {
        Paint.Cap cap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Float.valueOf(progressRadius), Float.valueOf(innerPadding), Boolean.valueOf(fanMode));
            return;
        }
        this.mRadius = progressRadius;
        this.mInnerPadding = innerPadding;
        float f16 = progressRadius - innerPadding;
        int i3 = this.centerX;
        int i16 = this.centerY;
        this.innerRectF = new RectF(i3 - f16, i16 - f16, i3 + f16, i16 + f16);
        this.isProgressFan = fanMode;
        if (fanMode) {
            this.mTransPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            this.mTransPaint.setStyle(Paint.Style.FILL);
            return;
        }
        this.mTransPaint.setStrokeWidth(innerPadding);
        this.mTransPaint.setXfermode(null);
        this.mTransPaint.setStyle(Paint.Style.STROKE);
        Paint paint = this.mTransPaint;
        if (this.isRoundStrokeCap) {
            cap = Paint.Cap.ROUND;
        } else {
            cap = Paint.Cap.BUTT;
        }
        paint.setStrokeCap(cap);
        this.mRingPaint.setStrokeWidth(innerPadding);
        this.mRingPaint.setXfermode(null);
        this.mRingPaint.setStyle(Paint.Style.STROKE);
    }

    public final void setRingColor(int color) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, color);
        } else {
            this.mRingPaint.setColor(color);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownLoadingView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.mGreyPaint = new Paint(1);
        this.mTransPaint = new Paint(1);
        this.mRingPaint = new Paint(1);
        this.mArcPath = new Path();
        float f16 = this.centerX - R.attr.radius;
        int i3 = this.centerY;
        this.innerRectF = new RectF(f16, i3 - R.attr.radius, r1 + R.attr.radius, i3 + R.attr.radius);
        this.mMax = 100L;
        Intrinsics.checkNotNullExpressionValue(getContext(), "context");
        this.mCorner = a(2.0f, r7);
        Intrinsics.checkNotNullExpressionValue(getContext(), "context");
        this.mRadius = a(17.5f, r7);
        Intrinsics.checkNotNullExpressionValue(getContext(), "context");
        this.mInnerPadding = a(2.5f, r7);
        this.isProgressFan = true;
        this.isRoundStrokeCap = true;
        this.mGreyPaint.setStyle(Paint.Style.FILL);
        this.mGreyPaint.setColor(HWColorFormat.COLOR_FormatVendorStartUnused);
        this.mTransPaint.setStyle(Paint.Style.FILL);
        this.mTransPaint.setColor(0);
        this.mTransPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.mRingPaint.setStyle(Paint.Style.STROKE);
        this.mRingPaint.setColor(0);
        this.mRingPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        setLayerType(1, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownLoadingView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mGreyPaint = new Paint(1);
        this.mTransPaint = new Paint(1);
        this.mRingPaint = new Paint(1);
        this.mArcPath = new Path();
        float f16 = this.centerX - R.attr.radius;
        int i16 = this.centerY;
        this.innerRectF = new RectF(f16, i16 - R.attr.radius, r8 + R.attr.radius, i16 + R.attr.radius);
        this.mMax = 100L;
        Intrinsics.checkNotNullExpressionValue(getContext(), "context");
        this.mCorner = a(2.0f, r7);
        Intrinsics.checkNotNullExpressionValue(getContext(), "context");
        this.mRadius = a(17.5f, r7);
        Intrinsics.checkNotNullExpressionValue(getContext(), "context");
        this.mInnerPadding = a(2.5f, r7);
        this.isProgressFan = true;
        this.isRoundStrokeCap = true;
        this.mGreyPaint.setStyle(Paint.Style.FILL);
        this.mGreyPaint.setColor(HWColorFormat.COLOR_FormatVendorStartUnused);
        this.mTransPaint.setStyle(Paint.Style.FILL);
        this.mTransPaint.setColor(0);
        this.mTransPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.mRingPaint.setStyle(Paint.Style.STROKE);
        this.mRingPaint.setColor(0);
        this.mRingPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        setLayerType(1, null);
    }
}
