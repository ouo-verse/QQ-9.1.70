package com.tencent.mobileqq.guild.component.animator;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Region;
import android.graphics.Shader;
import android.os.Build;
import android.os.SystemClock;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableColorStateList;
import com.tencent.theme.SkinnableView;
import kotlin.C11734b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 H2\u00020\u00012\u00020\u0002:\u0001IB\u001d\b\u0007\u0012\u0006\u0010C\u001a\u00020B\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010D\u00a2\u0006\u0004\bF\u0010GJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\fJ\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\fJ\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\fJ\u000e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u0006\u0010\u0015\u001a\u00020\fJ\u0006\u0010\u0016\u001a\u00020\fJ\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0017J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\fH\u0016J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\fH\u0016J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0003H\u0016J\b\u0010\u001d\u001a\u00020\u0005H\u0016R\u0016\u0010 \u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010%R\u0016\u0010+\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010*R\u0016\u0010-\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010*R\u0018\u00100\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00101\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010/R\u0016\u00104\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00103R\u0016\u00108\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u0010\u001fR\u0016\u0010:\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00103R\u0016\u0010=\u001a\u00020;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u00102R\u0014\u0010A\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@\u00a8\u0006J"}, d2 = {"Lcom/tencent/mobileqq/guild/component/animator/ScanningLightView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Lcom/tencent/theme/SkinnableView;", "", "night", "", "t", "Landroid/graphics/Canvas;", PM.CANVAS, "u", "p", "o", "", "color", "nightColor", "setSkeletonColor", "colorResId", "setSkeletonColorRes", "setLightColor", "setLightColorRes", "v", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "draw", "resId", "setImageResource", "setBackgroundResource", "isVisible", "onVisibilityAggregated", "onThemeChanged", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "imageResourceId", BdhLogUtil.LogTag.Tag_Conn, "backgroundResourceId", "", "D", UserInfo.SEX_FEMALE, "gradientWidth", "E", "speedPerMs", "Landroid/content/res/ColorStateList;", "Landroid/content/res/ColorStateList;", "skeletonColorStateList", "G", "lightColorStateList", "H", "Ljava/lang/Integer;", "skeletonNightColor", "lightNightColor", "J", "Z", "isSwitchThemeManually", "K", "curNightTheme", "L", "curSkeletonColor", "M", "isTranslucentSkeletonColor", "", "N", "startDrawTime", "Landroid/graphics/Paint;", "P", "Landroid/graphics/Paint;", "lightPaint", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public class ScanningLightView extends AppCompatImageView implements SkinnableView {
    private static final float R = (float) Math.tan(0.17453294f);
    private static final int S = Color.parseColor("#F3F4F8");
    private static final int T;
    private static final int U;
    private static final int V;

    /* renamed from: C, reason: from kotlin metadata */
    private int backgroundResourceId;

    /* renamed from: D, reason: from kotlin metadata */
    private final float gradientWidth;

    /* renamed from: E, reason: from kotlin metadata */
    private float speedPerMs;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private ColorStateList skeletonColorStateList;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private ColorStateList lightColorStateList;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private Integer skeletonNightColor;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private Integer lightNightColor;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean isSwitchThemeManually;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean curNightTheme;

    /* renamed from: L, reason: from kotlin metadata */
    private int curSkeletonColor;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean isTranslucentSkeletonColor;

    /* renamed from: N, reason: from kotlin metadata */
    private long startDrawTime;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final Paint lightPaint;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int imageResourceId;

    static {
        int parseColor = Color.parseColor("#FBFCFF");
        T = parseColor;
        U = kotlin.g.a(parseColor, 5);
        V = kotlin.g.a(Color.parseColor("#FFFFFF"), 3);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ScanningLightView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void o(Canvas canvas) {
        int i3;
        float width;
        boolean z16 = this.isTranslucentSkeletonColor;
        if (z16) {
            i3 = canvas.saveLayer(null, null);
            u(canvas);
        } else {
            i3 = 0;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        long j3 = this.startDrawTime;
        if (j3 == 0) {
            this.startDrawTime = uptimeMillis;
            width = 0.0f;
        } else {
            width = (((float) (uptimeMillis - j3)) * this.speedPerMs) % ((getWidth() + this.gradientWidth) + (getHeight() * R));
        }
        float f16 = width - this.gradientWidth;
        int save = canvas.save();
        canvas.translate(f16, 0.0f);
        try {
            canvas.rotate(10.0f);
            float f17 = this.gradientWidth;
            float f18 = R * f17;
            float f19 = -f18;
            canvas.drawRect(0.0f, f19, f17, canvas.getHeight() + f18, this.lightPaint);
            if (z16) {
                if (Build.VERSION.SDK_INT >= 26) {
                    canvas.clipOutRect(0.5f, f19, this.gradientWidth - 0.5f, canvas.getHeight() + f18);
                } else {
                    canvas.clipRect(0.5f, f19, this.gradientWidth - 0.5f, canvas.getHeight() + f18, Region.Op.DIFFERENCE);
                }
                canvas.drawColor(-1, PorterDuff.Mode.CLEAR);
            }
            if (z16) {
                canvas.restoreToCount(i3);
            }
        } finally {
            canvas.restoreToCount(save);
        }
    }

    private final void p(Canvas canvas) {
        u(canvas);
        canvas.drawColor(this.curSkeletonColor, PorterDuff.Mode.SRC_IN);
    }

    public static /* synthetic */ void setLightColor$default(ScanningLightView scanningLightView, int i3, int i16, int i17, Object obj) {
        if (obj == null) {
            if ((i17 & 2) != 0) {
                i16 = i3;
            }
            scanningLightView.setLightColor(i3, i16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setLightColor");
    }

    public static /* synthetic */ void setSkeletonColor$default(ScanningLightView scanningLightView, int i3, int i16, int i17, Object obj) {
        if (obj == null) {
            if ((i17 & 2) != 0) {
                i16 = i3;
            }
            scanningLightView.setSkeletonColor(i3, i16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setSkeletonColor");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(boolean night) {
        int defaultColor;
        boolean z16;
        PorterDuffXfermode porterDuffXfermode;
        Integer num;
        this.curNightTheme = night;
        if (night && ((num = this.skeletonNightColor) != null || !(this.skeletonColorStateList instanceof SkinnableColorStateList))) {
            if (num != null) {
                defaultColor = num.intValue();
            } else {
                defaultColor = V;
            }
        } else {
            defaultColor = this.skeletonColorStateList.getDefaultColor();
        }
        this.curSkeletonColor = defaultColor;
        if (Color.alpha(defaultColor) < 255) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.isTranslucentSkeletonColor = z16;
        int r16 = r();
        C11734b c11734b = C11734b.f433780a;
        QLog.i("Guild.component.ScanningLightView", 1, "setTheme(night:" + night + "), lightColor: " + Integer.toHexString(this.lightColorStateList.getDefaultColor()) + ", skeletonColor: " + Integer.toHexString(this.curSkeletonColor) + ", translucentSkeleton: " + this.isTranslucentSkeletonColor, null);
        this.lightPaint.setShader(new LinearGradient(0.0f, 0.0f, this.gradientWidth / ((float) 2), 0.0f, r16 & 16777215, r16, Shader.TileMode.MIRROR));
        Paint paint = this.lightPaint;
        if (this.isTranslucentSkeletonColor) {
            porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        } else {
            porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP);
        }
        paint.setXfermode(porterDuffXfermode);
        invalidate();
    }

    private final void u(Canvas canvas) {
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                super.draw(canvas);
                return;
            } catch (OutOfMemoryError e16) {
                C11734b c11734b = C11734b.f433780a;
                QLog.e("Guild.component.ScanningLightView", 1, "oom in draw", e16);
                return;
            }
        }
        super.draw(canvas);
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        p(canvas);
        o(canvas);
        postInvalidateOnAnimation();
    }

    @Override // com.tencent.theme.SkinnableView
    public void onThemeChanged() {
        kotlin.g gVar = kotlin.g.f433789a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (gVar.d(context)) {
            return;
        }
        boolean c16 = kotlin.f.f433786a.c();
        C11734b c11734b = C11734b.f433780a;
        QLog.i("Guild.component.ScanningLightView", 1, "onThemeChanged\uff1anight: " + c16 + ", isSwitchThemeManually: " + this.isSwitchThemeManually, null);
        if (!this.isSwitchThemeManually) {
            t(c16);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onVisibilityAggregated(boolean isVisible) {
        int i3;
        int i16;
        super.onVisibilityAggregated(isVisible);
        if (!isVisible) {
            setImageDrawable(null);
            setBackground(null);
            destroyDrawingCache();
            return;
        }
        if (getDrawable() == null && (i16 = this.imageResourceId) != 0) {
            setImageResource(i16);
        }
        if (getBackground() == null && (i3 = this.backgroundResourceId) != 0) {
            setBackgroundResource(i3);
        }
    }

    /* renamed from: q, reason: from getter */
    public final int getCurSkeletonColor() {
        return this.curSkeletonColor;
    }

    public final int r() {
        Integer num;
        if (this.curNightTheme && ((num = this.lightNightColor) != null || !(this.lightColorStateList instanceof SkinnableColorStateList))) {
            if (num != null) {
                return num.intValue();
            }
            return U;
        }
        return this.lightColorStateList.getDefaultColor();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.view.View
    public void setBackgroundResource(int resId) {
        this.backgroundResourceId = resId;
        super.setBackgroundResource(resId);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int resId) {
        this.imageResourceId = resId;
        super.setImageResource(resId);
    }

    public final void setLightColor(int color, int nightColor) {
        ColorStateList valueOf = ColorStateList.valueOf(color);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(color)");
        this.lightColorStateList = valueOf;
        this.lightNightColor = Integer.valueOf(nightColor);
        t(this.curNightTheme);
    }

    public final void setLightColorRes(int colorResId) {
        ColorStateList colorStateList = getContext().getColorStateList(colorResId);
        if (colorStateList != null) {
            this.lightColorStateList = colorStateList;
        }
        t(this.curNightTheme);
    }

    public final void setSkeletonColor(int color, int nightColor) {
        ColorStateList valueOf = ColorStateList.valueOf(color);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(color)");
        this.skeletonColorStateList = valueOf;
        this.skeletonNightColor = Integer.valueOf(nightColor);
        t(this.curNightTheme);
    }

    public final void setSkeletonColorRes(int colorResId) {
        ColorStateList colorStateList = getContext().getColorStateList(colorResId);
        if (colorStateList != null) {
            this.skeletonColorStateList = colorStateList;
        }
        t(this.curNightTheme);
    }

    public final void v(boolean night) {
        this.isSwitchThemeManually = true;
        t(night);
    }

    public /* synthetic */ ScanningLightView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ScanningLightView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.gradientWidth = getResources().getDimension(R.dimen.f159554dc2);
        this.speedPerMs = getResources().getDimension(R.dimen.f159555dc3) / ((float) 1000);
        ColorStateList colorStateList = context.getResources().getColorStateList(R.color.qui_common_fill_standard_extra);
        Intrinsics.checkNotNullExpressionValue(colorStateList, "context.resources.getCol\u2026mmon_fill_standard_extra)");
        this.skeletonColorStateList = colorStateList;
        ColorStateList colorStateList2 = context.getResources().getColorStateList(R.color.qui_common_fill_light_tertiary);
        Intrinsics.checkNotNullExpressionValue(colorStateList2, "context.resources.getCol\u2026mmon_fill_light_tertiary)");
        this.lightColorStateList = colorStateList2;
        this.lightPaint = new Paint();
        setLayerType(2, null);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tencent.mobileqq.guild.component.b.S3, 0, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026.ScanningLightView, 0, 0)");
        int resourceId = obtainStyledAttributes.getResourceId(com.tencent.mobileqq.guild.component.b.Z3, 0);
        this.imageResourceId = resourceId;
        if (resourceId == 0) {
            this.imageResourceId = obtainStyledAttributes.getResourceId(com.tencent.mobileqq.guild.component.b.U3, 0);
        }
        this.backgroundResourceId = obtainStyledAttributes.getResourceId(com.tencent.mobileqq.guild.component.b.T3, 0);
        ColorStateList colorStateList3 = obtainStyledAttributes.getColorStateList(com.tencent.mobileqq.guild.component.b.V3);
        if (colorStateList3 != null) {
            this.lightColorStateList = colorStateList3;
        }
        ColorStateList colorStateList4 = obtainStyledAttributes.getColorStateList(com.tencent.mobileqq.guild.component.b.X3);
        if (colorStateList4 != null) {
            this.skeletonColorStateList = colorStateList4;
        }
        int i3 = com.tencent.mobileqq.guild.component.b.W3;
        if (obtainStyledAttributes.hasValue(i3)) {
            this.lightNightColor = Integer.valueOf(obtainStyledAttributes.getColor(i3, U));
        }
        int i16 = com.tencent.mobileqq.guild.component.b.Y3;
        if (obtainStyledAttributes.hasValue(i16)) {
            this.skeletonNightColor = Integer.valueOf(obtainStyledAttributes.getColor(i16, V));
        }
        this.curSkeletonColor = this.skeletonColorStateList.getDefaultColor();
        obtainStyledAttributes.recycle();
        C11734b c11734b = C11734b.f433780a;
        QLog.i("Guild.component.ScanningLightView", 1, "init", null);
        if (kotlin.g.f433789a.d(context)) {
            kotlin.f.f433786a.f(this, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.component.animator.ScanningLightView.4
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    C11734b c11734b2 = C11734b.f433780a;
                    QLog.i("Guild.component.ScanningLightView", 1, "observeNightTheme\uff1a" + z16 + ", isSwitchThemeManually: " + ScanningLightView.this.isSwitchThemeManually, null);
                    if (ScanningLightView.this.isSwitchThemeManually) {
                        return;
                    }
                    ScanningLightView.this.t(z16);
                }
            });
        } else {
            t(kotlin.f.f433786a.c());
        }
    }
}
