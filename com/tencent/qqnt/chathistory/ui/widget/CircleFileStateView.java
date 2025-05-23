package com.tencent.qqnt.chathistory.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.graphics.drawable.DrawableKt;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ?2\u00020\u0001:\u00013B!\u0012\u0006\u00108\u001a\u000207\u0012\b\u0010:\u001a\u0004\u0018\u000109\u0012\u0006\u0010;\u001a\u00020\u0006\u00a2\u0006\u0004\b<\u0010=B\u001d\b\u0017\u0012\u0006\u00108\u001a\u000207\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u000109\u00a2\u0006\u0004\b<\u0010>J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0014J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00068\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0011R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\n\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u000eR\u0016\u0010\u001d\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0011R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0011R\u0016\u0010$\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0011R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010*\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010'R\u0016\u0010-\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R$\u00102\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u00068F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b3\u00104\"\u0004\b5\u00106\u00a8\u0006@"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/widget/CircleFileStateView;", "Landroid/view/View;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "onDraw", "", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "progress", HippyQQPagView.FunctionName.SET_PROGRESS, "", "d", UserInfo.SEX_FEMALE, "mDensity", "e", "I", "mShadowColor", "f", "mRadius", h.F, "mRingWidth", "Landroid/graphics/Paint;", "i", "Landroid/graphics/Paint;", "mPaint", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, BdhLogUtil.LogTag.Tag_Conn, "mState", "", "D", "Z", "mShowRing", "E", "mProgressBgColor", "mProgressRateColor", "Landroid/graphics/Bitmap;", "G", "Landroid/graphics/Bitmap;", "mActionBitmap", "H", "mPauseBitmap", "Landroid/graphics/RectF;", "Landroid/graphics/RectF;", "drawingOval", "Landroid/graphics/Matrix;", "J", "Landroid/graphics/Matrix;", "mMatrix", "state", "a", "()I", "setState", "(I)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "K", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class CircleFileStateView extends View {
    static IPatchRedirector $redirector_;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private int mState;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean mShowRing;

    /* renamed from: E, reason: from kotlin metadata */
    private int mProgressBgColor;

    /* renamed from: F, reason: from kotlin metadata */
    private int mProgressRateColor;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private Bitmap mActionBitmap;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private Bitmap mPauseBitmap;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private RectF drawingOval;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Matrix mMatrix;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final float mDensity;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int mShadowColor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mRadius;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mRingWidth;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint mPaint;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float progress;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/widget/CircleFileStateView$a;", "", "", "CIRCLE_STATE_DOWNLOAD", "I", "CIRCLE_STATE_FAILED", "CIRCLE_STATE_INIT", "CIRCLE_STATE_PROGRESS", "CIRCLE_STATE_UPLOAD", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chathistory.ui.widget.CircleFileStateView$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51634);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
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
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            return;
        }
        iPatchRedirector.redirect((short) 9, (Object) this, (Object) context);
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.mState;
    }

    @Override // android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        Bitmap bitmap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        int i3 = this.mState;
        if (i3 != 1) {
            if (i3 != 2 && i3 != 3) {
                bitmap = null;
            } else {
                bitmap = this.mActionBitmap;
            }
        } else {
            bitmap = this.mPauseBitmap;
        }
        Bitmap bitmap2 = bitmap;
        float f16 = this.mRingWidth;
        if (i3 == 1) {
            f16 *= 2;
        }
        float f17 = f16;
        if (this.mShowRing) {
            this.mPaint.setColor(this.mProgressBgColor);
            this.mPaint.setShadowLayer(9.0f, 0.0f, 0.0f, this.mShadowColor);
            this.mPaint.setStrokeWidth(f17);
            RectF rectF = this.drawingOval;
            float f18 = f17 / 2;
            int i16 = this.mRadius;
            rectF.set(f18, f18, i16 - f18, i16 - f18);
            canvas.drawArc(this.drawingOval, -90.0f, 360.0f, false, this.mPaint);
            this.mPaint.setColor(this.mProgressRateColor);
            this.mPaint.setShadowLayer(9.0f, 0.0f, 0.0f, this.mShadowColor);
            this.mPaint.setStrokeWidth(f17);
            RectF rectF2 = this.drawingOval;
            int i17 = this.mRadius;
            rectF2.set(f18, f18, i17 - f18, i17 - f18);
            canvas.drawArc(this.drawingOval, -90.0f, (float) (this.progress * 3.6d), false, this.mPaint);
        }
        if (bitmap2 != null) {
            float width = (this.mRadius - (2.0f * f17)) / bitmap2.getWidth();
            this.mMatrix.setScale(width, width);
            this.mMatrix.postTranslate(f17, f17);
            if (this.mState == 2) {
                Matrix matrix = this.mMatrix;
                int i18 = this.mRadius;
                matrix.postRotate(180.0f, i18 / 2, i18 / 2);
            }
            canvas.drawBitmap(bitmap2, this.mMatrix, this.mPaint);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int coerceAtMost;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(widthMeasureSpec), Integer.valueOf(heightMeasureSpec));
            return;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(View.MeasureSpec.getSize(widthMeasureSpec), View.MeasureSpec.getSize(heightMeasureSpec));
        this.mRadius = coerceAtMost;
        setMeasuredDimension(coerceAtMost, coerceAtMost);
    }

    public final void setProgress(int progress) {
        int coerceIn;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            coerceIn = RangesKt___RangesKt.coerceIn(progress, (ClosedRange<Integer>) new IntRange(0, 100));
            this.progress = coerceIn;
            invalidate();
            return;
        }
        iPatchRedirector.redirect((short) 6, (Object) this, progress);
    }

    public final void setState(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.mState = i3;
            invalidate();
        }
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
        this.mRingWidth = 3;
        this.mProgressBgColor = -1;
        this.mProgressRateColor = -16776961;
        this.mMatrix = new Matrix();
        this.mDensity = getResources().getDisplayMetrics().density;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, cw3.a.P);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026tyleable.CircleFileState)");
            this.mProgressRateColor = obtainStyledAttributes.getColor(cw3.a.V, -16776961);
            this.mProgressBgColor = obtainStyledAttributes.getColor(cw3.a.U, -1);
            this.mRingWidth = obtainStyledAttributes.getDimensionPixelOffset(cw3.a.W, 3);
            this.progress = obtainStyledAttributes.getInteger(cw3.a.Q, 50);
            this.mState = obtainStyledAttributes.getInteger(cw3.a.R, 0);
            Drawable drawable = obtainStyledAttributes.getDrawable(cw3.a.S);
            this.mActionBitmap = drawable != null ? DrawableKt.toBitmap$default(drawable, 0, 0, null, 7, null) : null;
            Drawable drawable2 = obtainStyledAttributes.getDrawable(cw3.a.T);
            this.mPauseBitmap = drawable2 != null ? DrawableKt.toBitmap$default(drawable2, 0, 0, null, 7, null) : null;
            obtainStyledAttributes.recycle();
        } else {
            this.mActionBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.f161603nc1);
            this.mPauseBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.f161604nc2);
        }
        this.mShowRing = true;
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        setClickable(true);
        this.drawingOval = new RectF();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CircleFileStateView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public /* synthetic */ CircleFileStateView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
