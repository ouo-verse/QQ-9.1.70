package com.tencent.qqnt.aio.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 f2\u00020\u0001:\u0001\u0005B!\u0012\u0006\u0010_\u001a\u00020^\u0012\b\u0010a\u001a\u0004\u0018\u00010`\u0012\u0006\u0010b\u001a\u00020\u0012\u00a2\u0006\u0004\bc\u0010dB\u001d\b\u0017\u0012\u0006\u0010_\u001a\u00020^\u0012\n\b\u0002\u0010a\u001a\u0004\u0018\u00010`\u00a2\u0006\u0004\bc\u0010eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\f\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0010\u0010\r\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0012H\u0014J\u0016\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0012J\u0016\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u0012J\u000e\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0012J\u0010\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020 H\u0016R\u0014\u0010%\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010$R\u0016\u0010(\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010*\u001a\u00020\u00128\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b)\u0010'R\u0016\u0010,\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010'R\u0016\u0010.\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010'R\u0016\u00100\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010'R\u0016\u00102\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010'R\u0016\u00104\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010'R\u0016\u00106\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010'R\u0016\u00107\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010'R\u0016\u00109\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u0010'R\u0016\u0010;\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010'R\u0014\u0010>\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010=R$\u0010\u001e\u001a\u00020\u000f2\u0006\u0010?\u001a\u00020\u000f8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b@\u0010$\u001a\u0004\bA\u0010BR\u0016\u0010D\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010'R\u0016\u0010G\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010I\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010'R\u0016\u0010K\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010'R\u0018\u0010N\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010P\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010MR\u0014\u0010T\u001a\u00020Q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0014\u0010X\u001a\u00020U8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bV\u0010WR$\u0010Y\u001a\u00020\u00122\u0006\u0010Y\u001a\u00020\u00128F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]\u00a8\u0006g"}, d2 = {"Lcom/tencent/qqnt/aio/widget/CircleFileStateView;", "Landroid/view/View;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "a", "c", "b", "Landroid/graphics/drawable/Drawable;", "drawable", "Landroid/graphics/Bitmap;", "d", "setPauseDrawable", "setActionDrawable", "onDraw", "", "ringWidth", "setProgressRingWidth", "", "color", "setCenterBgColor", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "bgAlpha", "bgColor", "setBackgroundColor", "progressColor", "progressAlpha", "setProgressColor", "progress", HippyQQPagView.FunctionName.SET_PROGRESS, "Landroid/view/MotionEvent;", "event", "", "onTouchEvent", UserInfo.SEX_FEMALE, "mDensity", "e", "I", "mProgressBgColor", "f", "mShadowColor", tl.h.F, "mProgressBgAlpha", "i", "mProgressRateColor", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mProgressRatePressedColor", BdhLogUtil.LogTag.Tag_Conn, "mProgressPauseColor", "D", "mProgressRateAlpha", "E", "mCenterBgColor", "mCenterBgPressedColor", "G", "mRadius", "H", "mRingWidth", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "mPaint", "<set-?>", "J", HippyQQPagView.FunctionName.GET_PROGRESS, "()F", "K", "mState", "L", "Z", "mShowRing", "M", "mShowRingColor", "N", "mShowCenterColor", "P", "Landroid/graphics/Bitmap;", "mActionBitmap", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "mPauseBitmap", "Landroid/graphics/RectF;", BdhLogUtil.LogTag.Tag_Req, "Landroid/graphics/RectF;", "mDrawRect", "Landroid/graphics/Matrix;", ExifInterface.LATITUDE_SOUTH, "Landroid/graphics/Matrix;", "mDrawMatrix", "state", "getState", "()I", "setState", "(I)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "T", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class CircleFileStateView extends View {
    static IPatchRedirector $redirector_;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private int mProgressPauseColor;

    /* renamed from: D, reason: from kotlin metadata */
    private int mProgressRateAlpha;

    /* renamed from: E, reason: from kotlin metadata */
    private int mCenterBgColor;

    /* renamed from: F, reason: from kotlin metadata */
    private int mCenterBgPressedColor;

    /* renamed from: G, reason: from kotlin metadata */
    private int mRadius;

    /* renamed from: H, reason: from kotlin metadata */
    private int mRingWidth;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Paint mPaint;

    /* renamed from: J, reason: from kotlin metadata */
    private float progress;

    /* renamed from: K, reason: from kotlin metadata */
    private int mState;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean mShowRing;

    /* renamed from: M, reason: from kotlin metadata */
    private int mShowRingColor;

    /* renamed from: N, reason: from kotlin metadata */
    private int mShowCenterColor;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private Bitmap mActionBitmap;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private Bitmap mPauseBitmap;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final RectF mDrawRect;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final Matrix mDrawMatrix;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final float mDensity;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mProgressBgColor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int mShadowColor;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mProgressBgAlpha;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mProgressRateColor;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mProgressRatePressedColor;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/aio/widget/CircleFileStateView$a;", "", "", "CIRCLE_STATE_DOWNLOAD", "I", "CIRCLE_STATE_FAILED", "CIRCLE_STATE_INIT", "CIRCLE_STATE_PROGRESS", "CIRCLE_STATE_UPLOAD", "<init>", "()V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.widget.CircleFileStateView$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48028);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 19)) {
            redirector.redirect((short) 19);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CircleFileStateView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 18)) {
            return;
        }
        iPatchRedirector.redirect((short) 18, (Object) this, (Object) context);
    }

    private final void a(Canvas canvas) {
        this.mPaint.setAlpha(255);
        this.mPaint.setColor(this.mShowCenterColor);
        this.mPaint.setStyle(Paint.Style.FILL);
        int i3 = this.mRadius;
        canvas.drawCircle(i3 / 2, i3 / 2, (i3 / 2) - this.mRingWidth, this.mPaint);
    }

    private final void b(Canvas canvas) {
        Bitmap bitmap;
        int i3 = this.mState;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3 && i3 != 4) {
                    if (i3 != 5) {
                        bitmap = null;
                    } else {
                        bitmap = this.mActionBitmap;
                    }
                } else {
                    bitmap = this.mActionBitmap;
                }
            } else {
                bitmap = this.mPauseBitmap;
            }
        } else {
            bitmap = this.mActionBitmap;
        }
        if (bitmap != null) {
            float width = (this.mRadius - (this.mRingWidth * 2.0f)) / bitmap.getWidth();
            this.mDrawMatrix.reset();
            this.mDrawMatrix.setScale(width, width);
            Matrix matrix = this.mDrawMatrix;
            int i16 = this.mRingWidth;
            matrix.postTranslate(i16, i16);
            if (this.mState == 3) {
                Matrix matrix2 = this.mDrawMatrix;
                int i17 = this.mRadius;
                matrix2.postRotate(180.0f, i17 / 2, i17 / 2);
            }
            canvas.drawBitmap(bitmap, this.mDrawMatrix, this.mPaint);
        }
    }

    private final void c(Canvas canvas) {
        if (!this.mShowRing) {
            return;
        }
        this.mPaint.setColor(this.mProgressBgColor);
        this.mPaint.setShadowLayer(9.0f, 0.0f, 0.0f, this.mShadowColor);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.mRingWidth);
        RectF rectF = this.mDrawRect;
        int i3 = this.mRingWidth;
        int i16 = this.mRadius;
        rectF.set(i3 / 2, i3 / 2, i16 - (i3 / 2), i16 - (i3 / 2));
        canvas.drawArc(this.mDrawRect, -90.0f, 360.0f, false, this.mPaint);
        this.mPaint.setColor(this.mShowRingColor);
        this.mPaint.setShadowLayer(9.0f, 0.0f, 0.0f, this.mShadowColor);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.mRingWidth);
        RectF rectF2 = this.mDrawRect;
        int i17 = this.mRingWidth;
        int i18 = this.mRadius;
        rectF2.set(i17 / 2, i17 / 2, i18 - (i17 / 2), i18 - (i17 / 2));
        canvas.drawArc(this.mDrawRect, -90.0f, (float) (this.progress * 3.6d), false, this.mPaint);
    }

    private final Bitmap d(Drawable drawable) {
        Bitmap.Config config;
        if (drawable == null) {
            return null;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (drawable.getOpacity() != -1) {
            config = Bitmap.Config.ARGB_8888;
        } else {
            config = Bitmap.Config.RGB_565;
        }
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, config);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return createBitmap;
    }

    @Override // android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        a(canvas);
        c(canvas);
        b(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(widthMeasureSpec), Integer.valueOf(heightMeasureSpec));
            return;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int min = Math.min(View.MeasureSpec.getSize(widthMeasureSpec), View.MeasureSpec.getSize(widthMeasureSpec));
        this.mRadius = min;
        setMeasuredDimension(min, min);
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, (Object) event)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction();
        if (action != 0 && action != 2) {
            this.mShowRingColor = this.mProgressRateColor;
            if (this.mState != 2) {
                this.mShowRingColor = this.mProgressPauseColor;
            }
            this.mShowCenterColor = this.mCenterBgColor;
            invalidate();
        } else {
            this.mShowRingColor = this.mProgressRatePressedColor;
            this.mShowCenterColor = this.mCenterBgPressedColor;
            invalidate();
        }
        return super.onTouchEvent(event);
    }

    public final void setActionDrawable(@Nullable Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) drawable);
        } else {
            this.mActionBitmap = d(drawable);
        }
    }

    public final void setBackgroundColor(int bgAlpha, int bgColor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(bgAlpha), Integer.valueOf(bgColor));
        } else {
            this.mProgressBgColor = bgColor;
            this.mProgressBgAlpha = bgAlpha;
        }
    }

    public final void setCenterBgColor(int color) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, color);
            return;
        }
        this.mCenterBgColor = color;
        this.mShowCenterColor = color;
        invalidate();
    }

    public final void setPauseDrawable(@Nullable Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) drawable);
        } else {
            this.mPauseBitmap = d(drawable);
        }
    }

    public final void setProgress(int progress) {
        int coerceAtMost;
        int coerceAtLeast;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(progress, 100);
            this.progress = coerceAtMost;
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(progress, 0);
            this.progress = coerceAtLeast;
            invalidate();
            return;
        }
        iPatchRedirector.redirect((short) 13, (Object) this, progress);
    }

    public final void setProgressColor(int progressColor, int progressAlpha) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(progressColor), Integer.valueOf(progressAlpha));
            return;
        }
        this.mProgressRateColor = progressColor;
        this.mProgressRateAlpha = progressAlpha;
        invalidate();
    }

    public final void setProgressRingWidth(float ringWidth) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Float.valueOf(ringWidth));
            return;
        }
        int i3 = (int) ((ringWidth * this.mDensity) + 0.5d);
        this.mRingWidth = i3;
        this.mPaint.setStrokeWidth(i3);
        invalidate();
    }

    public final void setState(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
            return;
        }
        this.mState = i3;
        this.mShowRingColor = this.mProgressRateColor;
        if (i3 != 2) {
            this.mShowRingColor = this.mProgressPauseColor;
        }
        invalidate();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircleFileStateView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mDensity = getResources().getDisplayMetrics().density;
        this.mProgressBgColor = -1;
        this.mProgressRateColor = -16776961;
        this.mProgressRatePressedColor = -16776961;
        this.mProgressPauseColor = -7829368;
        this.mCenterBgColor = -7829368;
        this.mCenterBgPressedColor = -3355444;
        this.mRingWidth = 3;
        this.mDrawRect = new RectF();
        this.mDrawMatrix = new Matrix();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, qv3.a.P);
            this.mProgressRateColor = obtainStyledAttributes.getColor(qv3.a.Y, -16776961);
            this.mProgressBgColor = obtainStyledAttributes.getColor(qv3.a.V, -1);
            this.mCenterBgColor = obtainStyledAttributes.getColor(qv3.a.Q, -7829368);
            this.mProgressRatePressedColor = obtainStyledAttributes.getColor(qv3.a.Z, -16776961);
            this.mProgressPauseColor = obtainStyledAttributes.getColor(qv3.a.W, -7829368);
            this.mCenterBgPressedColor = obtainStyledAttributes.getColor(qv3.a.R, -3355444);
            this.mProgressRateAlpha = obtainStyledAttributes.getInteger(qv3.a.X, 255);
            this.mProgressBgAlpha = obtainStyledAttributes.getInteger(qv3.a.U, 51);
            this.mRingWidth = obtainStyledAttributes.getDimensionPixelOffset(qv3.a.f429720a0, 3);
            this.progress = obtainStyledAttributes.getInteger(qv3.a.S, 50);
            this.mState = obtainStyledAttributes.getInteger(qv3.a.T, 1);
            obtainStyledAttributes.recycle();
        }
        this.mShowRing = true;
        this.mShowRingColor = this.mProgressRateColor;
        this.mShowCenterColor = this.mCenterBgColor;
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        setClickable(true);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CircleFileStateView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) attributeSet);
    }

    public /* synthetic */ CircleFileStateView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return;
        }
        iPatchRedirector.redirect((short) 4, this, context, attributeSet, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
