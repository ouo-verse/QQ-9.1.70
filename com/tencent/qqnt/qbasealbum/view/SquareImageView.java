package com.tencent.qqnt.qbasealbum.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.qbasealbum.b;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 I2\u00020\u0001:\u0001JB'\b\u0007\u0012\u0006\u0010C\u001a\u00020B\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010D\u0012\b\b\u0002\u0010F\u001a\u00020\u0002\u00a2\u0006\u0004\bG\u0010HJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014J0\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0014J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0014J\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0002J\u0016\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014J\u000e\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0002J\u0010\u0010\u001c\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aJ\u000e\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0002J\u000e\u0010 \u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0002R\u0016\u0010#\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\"R\u0016\u0010(\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010+\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010'R\u0016\u0010/\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010'R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0014\u00109\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00102R\u0014\u0010<\u001a\u00020:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010;R\u0014\u0010>\u001a\u00020:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010;R\u0014\u0010@\u001a\u00020:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010;R\u0016\u0010A\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010'\u00a8\u0006K"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/view/SquareImageView;", "Lcom/tencent/image/URLImageView;", "", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "", "changed", "left", "top", "right", "bottom", "onLayout", "Landroid/graphics/Canvas;", PM.CANVAS, "draw", "onDraw", "radius", "setRoundRect", "", "scale", "offset", "setImageScale", "color", "setFilterColor", "", "text", "setFilterText", "size", "setFilterTextSize", "circleBgColor", "setCircleBgColor", "d", UserInfo.SEX_FEMALE, "mScale", "e", "mScaleOffset", "f", "I", "mFilterColor", h.F, "Ljava/lang/String;", "mFilterText", "i", "mFilterTextSize", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mRoundRectRadius", "Landroid/graphics/RectF;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/graphics/RectF;", "mViewBounds", "Landroid/graphics/Path;", "D", "Landroid/graphics/Path;", "mClipPath", "E", "mRoundRectBounds", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "mCircleBgPaint", "G", "mRoundRectPaint", "H", "mTextPaint", "mCircleBgColor", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "J", "a", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class SquareImageView extends URLImageView {
    static IPatchRedirector $redirector_;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final RectF mViewBounds;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Path mClipPath;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final RectF mRoundRectBounds;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Paint mCircleBgPaint;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Paint mRoundRectPaint;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Paint mTextPaint;

    /* renamed from: I, reason: from kotlin metadata */
    private int mCircleBgColor;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float mScale;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float mScaleOffset;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mFilterColor;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mFilterText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mFilterTextSize;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mRoundRectRadius;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/view/SquareImageView$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qbasealbum.view.SquareImageView$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45472);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SquareImageView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
            return;
        }
        iPatchRedirector.redirect((short) 14, (Object) this, (Object) context);
    }

    @Override // android.view.View
    public void draw(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.mRoundRectRadius == 0) {
            super.draw(canvas);
            return;
        }
        if (this.mClipPath.isEmpty()) {
            Path path = this.mClipPath;
            RectF rectF = this.mViewBounds;
            int i3 = this.mRoundRectRadius;
            path.addRoundRect(rectF, i3, i3, Path.Direction.CW);
        }
        canvas.clipPath(this.mClipPath);
        super.draw(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int i3 = this.mCircleBgColor;
        if (i3 != -1) {
            this.mCircleBgPaint.setColor(i3);
            this.mCircleBgPaint.setAntiAlias(false);
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2, this.mCircleBgPaint);
        }
        super.onDraw(canvas);
        int i16 = this.mFilterColor;
        if (i16 != -1) {
            this.mRoundRectPaint.setColor(i16);
            RectF rectF = this.mRoundRectBounds;
            rectF.left = 0.0f;
            rectF.top = 0.0f;
            rectF.right = getMeasuredWidth();
            this.mRoundRectBounds.bottom = getMeasuredHeight();
            RectF rectF2 = this.mRoundRectBounds;
            int i17 = this.mRoundRectRadius;
            canvas.drawRoundRect(rectF2, i17, i17, this.mRoundRectPaint);
        }
        if (!TextUtils.isEmpty(this.mFilterText)) {
            this.mTextPaint.setTextSize(this.mFilterTextSize);
            this.mTextPaint.setColor(-1);
            this.mTextPaint.setTextAlign(Paint.Align.CENTER);
            Paint.FontMetricsInt fontMetricsInt = this.mTextPaint.getFontMetricsInt();
            String str = this.mFilterText;
            Intrinsics.checkNotNull(str);
            canvas.drawText(str, getMeasuredWidth() / 2, ((getMeasuredHeight() - fontMetricsInt.ascent) - fontMetricsInt.descent) / 2, this.mTextPaint);
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(changed), Integer.valueOf(left), Integer.valueOf(top), Integer.valueOf(right), Integer.valueOf(bottom));
        } else {
            super.onLayout(changed, left, top, right, bottom);
            this.mViewBounds.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(widthMeasureSpec), Integer.valueOf(heightMeasureSpec));
            return;
        }
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
        int measuredWidth = getMeasuredWidth();
        setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec((int) (((measuredWidth * 1.0f) / this.mScale) + ((int) this.mScaleOffset)), 1073741824));
    }

    public final void setCircleBgColor(int circleBgColor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, circleBgColor);
        } else {
            this.mCircleBgColor = circleBgColor;
            invalidate();
        }
    }

    public final void setFilterColor(int color) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, color);
        } else {
            this.mFilterColor = color;
            invalidate();
        }
    }

    public final void setFilterText(@Nullable String text) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) text);
        } else {
            this.mFilterText = text;
            requestLayout();
        }
    }

    public final void setFilterTextSize(int size) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, size);
        } else {
            this.mFilterTextSize = size;
            requestLayout();
        }
    }

    public final void setImageScale(float scale, float offset) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Float.valueOf(scale), Float.valueOf(offset));
            return;
        }
        if (scale > 0.0f) {
            this.mScale = scale;
        }
        this.mScaleOffset = offset;
        requestLayout();
    }

    public final void setRoundRect(int radius) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, radius);
            return;
        }
        if (radius < 0) {
            radius = 0;
        }
        this.mRoundRectRadius = radius;
        invalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SquareImageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
            return;
        }
        iPatchRedirector.redirect((short) 13, (Object) this, (Object) context, (Object) attributeSet);
    }

    public /* synthetic */ SquareImageView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SquareImageView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mScale = 1.0f;
        this.mFilterColor = -1;
        this.mFilterTextSize = 20;
        this.mViewBounds = new RectF();
        this.mClipPath = new Path();
        this.mRoundRectBounds = new RectF();
        this.mCircleBgPaint = new Paint();
        this.mRoundRectPaint = new Paint();
        this.mTextPaint = new Paint(1);
        this.mCircleBgColor = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.Q3);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026tyleable.SquareImageView)");
        this.mScale = obtainStyledAttributes.getFloat(b.V3, 1.0f);
        this.mScaleOffset = obtainStyledAttributes.getFloat(b.W3, 0.0f);
        this.mFilterColor = obtainStyledAttributes.getColor(b.R3, -1);
        this.mFilterText = obtainStyledAttributes.getString(b.S3);
        this.mFilterTextSize = obtainStyledAttributes.getDimensionPixelSize(b.T3, 40);
        this.mRoundRectRadius = obtainStyledAttributes.getDimensionPixelSize(b.U3, 0);
        obtainStyledAttributes.recycle();
    }
}
