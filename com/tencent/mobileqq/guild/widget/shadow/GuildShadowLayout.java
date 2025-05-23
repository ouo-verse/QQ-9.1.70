package com.tencent.mobileqq.guild.widget.shadow;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.internal.view.SupportMenu;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import mw1.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import u12.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 V2\u00020\u00012\u00020\u0002:\u0002%\u0010B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010S\u001a\u00020\u0011\u00a2\u0006\u0004\bT\u0010UJ\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0002J(\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0011H\u0014J\u0012\u0010\u0016\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0014J$\u0010\u001b\u001a\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u0017J\u0010\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0011H\u0014J\u000e\u0010 \u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u001eJ\u0018\u0010%\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#H\u0016R\u0016\u0010(\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010-\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010'R\u0016\u0010.\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010+R\u0016\u00100\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010/R\u0016\u00103\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00105\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00102R\u0016\u00107\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010/R\u0016\u00109\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u0010'R\u0016\u0010:\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010/R\u0016\u0010<\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u00102R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010A\u001a\u00020=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010?R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010G\u001a\u00020=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010?R+\u0010O\u001a\u00020H2\u0006\u0010I\u001a\u00020H8B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\b*\u0010L\"\u0004\bM\u0010NR\u0018\u0010R\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010Q\u00a8\u0006W"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/shadow/GuildShadowLayout;", "Landroid/widget/FrameLayout;", "Lmw1/c;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "f", "g", h.F, "i", "Landroid/graphics/Canvas;", PM.CANVAS, "d", "c", "b", "", "w", "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "dispatchDraw", "", "dx", "dy", NodeProps.SHADOW_RADIUS, "setShadowLayoutAttrs", "visibility", "onWindowVisibilityChanged", "Lcom/tencent/mobileqq/guild/widget/shadow/GuildShadowLayout$b;", "windowVisibilityChanged", "setOnWindowVisibilityChanged", "Landroid/view/View;", "view", "Lmw1/b;", "helper", "a", "Landroid/content/res/ColorStateList;", "Landroid/content/res/ColorStateList;", "mShadowColor", "", "e", "Z", "default_clickable", "mBgColor", "mIsClickable", UserInfo.SEX_FEMALE, "mShadowRadius", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "mDx", BdhLogUtil.LogTag.Tag_Conn, "mDy", "D", "mCornerRadius", "E", "mBorderColor", "mBorderWidth", "G", "mShadowSides", "Landroid/graphics/Paint;", "H", "Landroid/graphics/Paint;", "mPaint", "mHelpPaint", "Landroid/graphics/Path;", "J", "Landroid/graphics/Path;", "mRoundPath", "K", "mRoundPaint", "Landroid/graphics/RectF;", "<set-?>", "L", "Lkotlin/properties/ReadWriteProperty;", "()Landroid/graphics/RectF;", "j", "(Landroid/graphics/RectF;)V", "mContentRF", "M", "Landroid/graphics/RectF;", "mBorderRF", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "N", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildShadowLayout extends FrameLayout implements c {

    /* renamed from: C, reason: from kotlin metadata */
    private int mDy;

    /* renamed from: D, reason: from kotlin metadata */
    private float mCornerRadius;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private ColorStateList mBorderColor;

    /* renamed from: F, reason: from kotlin metadata */
    private float mBorderWidth;

    /* renamed from: G, reason: from kotlin metadata */
    private int mShadowSides;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private Paint mPaint;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private Paint mHelpPaint;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private Path mRoundPath;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private Paint mRoundPaint;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty mContentRF;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private RectF mBorderRF;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ColorStateList mShadowColor;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean default_clickable;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ColorStateList mBgColor;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mIsClickable;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float mShadowRadius;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mDx;
    static final /* synthetic */ KProperty<Object>[] P = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(GuildShadowLayout.class, "mContentRF", "getMContentRF()Landroid/graphics/RectF;", 0))};

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/shadow/GuildShadowLayout$b;", "", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public interface b {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildShadowLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void b(Canvas canvas) {
        RectF rectF = this.mBorderRF;
        if (rectF != null) {
            canvas.save();
            this.mPaint.setStrokeWidth(this.mBorderWidth);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor.getDefaultColor());
            float f16 = this.mCornerRadius;
            canvas.drawRoundRect(rectF, f16, f16, this.mPaint);
            a.g(this.mPaint, null, Integer.valueOf(this.mBgColor.getDefaultColor()), 1, null);
            canvas.restore();
        }
    }

    private final void c(Canvas canvas) {
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), null, 31);
        super.dispatchDraw(canvas);
        try {
            this.mRoundPath.reset();
            Path path = this.mRoundPath;
            RectF e16 = e();
            float f16 = this.mCornerRadius;
            path.addRoundRect(e16, f16, f16, Path.Direction.CW);
            canvas.drawPath(this.mRoundPath, this.mRoundPaint);
        } finally {
            canvas.restoreToCount(saveLayer);
        }
    }

    private final void d(Canvas canvas) {
        canvas.save();
        RectF e16 = e();
        float f16 = this.mCornerRadius;
        canvas.drawRoundRect(e16, f16, f16, this.mPaint);
        canvas.restore();
    }

    private final RectF e() {
        return (RectF) this.mContentRF.getValue(this, P[0]);
    }

    private final void f(Context context, AttributeSet attrs) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, up1.a.f439504g5);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026leable.GuildShadowLayout)");
        ColorStateList it = obtainStyledAttributes.getColorStateList(up1.a.f439606o5);
        if (it != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            this.mShadowColor = it;
        }
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(up1.a.f439518h5);
        if (colorStateList == null) {
            colorStateList = this.mShadowColor;
        } else {
            Intrinsics.checkNotNullExpressionValue(colorStateList, "getColorStateList(R.styl\u2026_bgColor) ?: mShadowColor");
        }
        this.mBgColor = colorStateList;
        this.mIsClickable = obtainStyledAttributes.getBoolean(up1.a.f439557k5, this.default_clickable);
        this.mShadowRadius = obtainStyledAttributes.getDimension(up1.a.f439619p5, a.d(context, 0.0f));
        this.mDx = obtainStyledAttributes.getDimensionPixelOffset(up1.a.f439581m5, 0);
        this.mDy = obtainStyledAttributes.getDimensionPixelOffset(up1.a.f439593n5, 0);
        this.mCornerRadius = obtainStyledAttributes.getDimension(up1.a.f439569l5, a.d(context, 0.0f));
        ColorStateList it5 = obtainStyledAttributes.getColorStateList(up1.a.f439531i5);
        if (it5 != null) {
            Intrinsics.checkNotNullExpressionValue(it5, "it");
            this.mBorderColor = it5;
        }
        this.mBorderWidth = obtainStyledAttributes.getDimension(up1.a.f439544j5, a.d(context, 0.0f));
        this.mShadowSides = obtainStyledAttributes.getInt(up1.a.f439632q5, 15);
        obtainStyledAttributes.recycle();
    }

    private final void g() {
        Path path = new Path();
        this.mRoundPath = path;
        path.setFillType(Path.FillType.INVERSE_WINDING);
        Paint paint = new Paint(1);
        this.mRoundPaint = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mRoundPaint.setColor(0);
        this.mRoundPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    }

    private final void h() {
        this.mPaint.setColor(this.mBgColor.getDefaultColor());
        this.mPaint.setShadowLayer(this.mShadowRadius, this.mDx, this.mDy, this.mShadowColor.getDefaultColor());
    }

    private final void i() {
        int i3;
        int i16;
        int abs = (int) (this.mShadowRadius + Math.abs(this.mDx));
        int abs2 = (int) (this.mShadowRadius + Math.abs(this.mDy));
        if (a.a(this.mShadowSides, 8)) {
            i3 = abs;
        } else {
            i3 = 0;
        }
        if (a.a(this.mShadowSides, 1)) {
            i16 = abs2;
        } else {
            i16 = 0;
        }
        if (!a.a(this.mShadowSides, 2)) {
            abs = 0;
        }
        if (!a.a(this.mShadowSides, 4)) {
            abs2 = 0;
        }
        setPadding(i3, i16, abs, abs2);
    }

    private final void j(RectF rectF) {
        this.mContentRF.setValue(this, P[0], rectF);
    }

    public static /* synthetic */ void setShadowLayoutAttrs$default(GuildShadowLayout guildShadowLayout, float f16, float f17, float f18, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f16 = 0.0f;
        }
        if ((i3 & 2) != 0) {
            f17 = 0.0f;
        }
        if ((i3 & 4) != 0) {
            f18 = 0.0f;
        }
        guildShadowLayout.setShadowLayoutAttrs(f16, f17, f18);
    }

    @Override // mw1.c
    public void a(@NotNull View view, @NotNull mw1.b helper) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(helper, "helper");
        this.mShadowColor = helper.b(this.mShadowColor);
        this.mBorderColor = helper.b(this.mBorderColor);
        this.mBgColor = helper.b(this.mBgColor);
        h();
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@Nullable Canvas canvas) {
        if (canvas == null) {
            return;
        }
        setClickable(this.mIsClickable);
        a.e(canvas, false);
        d(canvas);
        if (this.mCornerRadius > 0.0f) {
            c(canvas);
        } else {
            super.dispatchDraw(canvas);
        }
        b(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        super.onSizeChanged(w3, h16, oldw, oldh);
        j(new RectF(getPaddingLeft(), getPaddingTop(), w3 - getPaddingRight(), h16 - getPaddingBottom()));
        float f16 = this.mBorderWidth / 3;
        if (f16 > 0.0f) {
            this.mBorderRF = new RectF(e().left + f16, e().top + f16, e().right - f16, e().bottom - f16);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
    }

    public final void setOnWindowVisibilityChanged(@NotNull b windowVisibilityChanged) {
        Intrinsics.checkNotNullParameter(windowVisibilityChanged, "windowVisibilityChanged");
    }

    public final void setShadowLayoutAttrs(float dx5, float dy5, float shadowRadius) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.mShadowRadius = a.d(context, shadowRadius);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildShadowLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildShadowLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildShadowLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        ColorStateList valueOf = ColorStateList.valueOf(-16777216);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(default_shadowColor)");
        this.mShadowColor = valueOf;
        this.default_clickable = true;
        ColorStateList valueOf2 = ColorStateList.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(valueOf2, "valueOf(0)");
        this.mBgColor = valueOf2;
        this.mIsClickable = this.default_clickable;
        ColorStateList valueOf3 = ColorStateList.valueOf(SupportMenu.CATEGORY_MASK);
        Intrinsics.checkNotNullExpressionValue(valueOf3, "valueOf(default_borderColor)");
        this.mBorderColor = valueOf3;
        this.mShadowSides = 15;
        this.mPaint = a.c(this, null, -1, 1, null);
        this.mHelpPaint = a.c(this, null, Integer.valueOf(SupportMenu.CATEGORY_MASK), 1, null);
        this.mRoundPath = new Path();
        this.mRoundPaint = new Paint(1);
        this.mContentRF = Delegates.INSTANCE.notNull();
        f(context, attributeSet);
        g();
        h();
        i();
        if (Build.VERSION.SDK_INT >= 28 || getLayerType() == 1) {
            return;
        }
        setLayerType(1, null);
    }
}
