package com.tencent.storage.view.rtv;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.annotation.ColorInt;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 J2\u00020\u00012\u00020\u0002:\u0001KB'\b\u0007\u0012\u0006\u0010D\u001a\u00020C\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010E\u0012\b\b\u0002\u0010G\u001a\u00020\u0003\u00a2\u0006\u0004\bH\u0010IJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0016\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bJ\u0010\u0010\u000f\u001a\u00020\b2\b\b\u0001\u0010\u000e\u001a\u00020\u0003J\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0003J\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0013\u001a\u00020\bJ\u000e\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0003J\u000e\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0019J \u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001cJ\u0010\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\u0018\u0010\"\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u0003H\u0014J(\u0010'\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0003H\u0014J\b\u0010(\u001a\u00020\bH\u0016R\u001c\u0010,\u001a\n **\u0004\u0018\u00010)0)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010+R\u0016\u0010.\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010-R\u0016\u00100\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010-R\u001a\u00105\u001a\u0002018\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\t\u00102\u001a\u0004\b3\u00104R\u001a\u00109\u001a\u0002068\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u0013\u00107\u001a\u0004\b/\u00108R\u0014\u0010=\u001a\u00020:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010@\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010B\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010-\u00a8\u0006L"}, d2 = {"Lcom/tencent/storage/view/rtv/RollingTextView;", "Landroid/view/View;", "Lcom/tencent/theme/SkinnableView;", "", "e", "d", "Landroid/graphics/Canvas;", PM.CANVAS, "", h.F, "unit", "", "size", "setTextSize", "color", "setTextColor", "setTextColorStateList", "Landroid/content/res/ColorStateList;", "colorStateList", "i", "", "fontString", "setTextFont", "textStyle", "setTextStyle", "", "text", IECSearchBar.METHOD_SET_TEXT, "", "animate", "expand", "onDraw", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "width", "height", "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "onThemeChanged", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "Landroid/animation/ValueAnimator;", "animator", "I", "lastMeasuredDesiredWidth", "f", "lastMeasuredDesiredHeight", "Landroid/text/TextPaint;", "Landroid/text/TextPaint;", "g", "()Landroid/text/TextPaint;", "textPaint", "Lcom/tencent/storage/view/rtv/f;", "Lcom/tencent/storage/view/rtv/f;", "()Lcom/tencent/storage/view/rtv/f;", "textManager", "Landroid/graphics/Rect;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/graphics/Rect;", "viewBounds", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/CharSequence;", "targetText", "D", "mTextColorStateList", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "E", "b", "storage-view-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class RollingTextView extends View implements SkinnableView {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private CharSequence targetText;

    /* renamed from: D, reason: from kotlin metadata */
    private int mTextColorStateList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ValueAnimator animator;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int lastMeasuredDesiredWidth;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int lastMeasuredDesiredHeight;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextPaint textPaint;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f textManager;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Rect viewBounds;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/storage/view/rtv/RollingTextView$a", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "storage-view-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RollingTextView.this);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            } else {
                RollingTextView.this.f().i();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/storage/view/rtv/RollingTextView$b;", "", "", "ANIMATION_DURATION", "J", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "storage-view-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.storage.view.rtv.RollingTextView$b, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35571);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 22)) {
            redirector.redirect((short) 22);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RollingTextView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 21)) {
            return;
        }
        iPatchRedirector.redirect((short) 21, (Object) this, (Object) context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(RollingTextView this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.textManager.l(valueAnimator.getAnimatedFraction());
        this$0.requestLayout();
        this$0.invalidate();
    }

    private final int d() {
        return ((int) this.textManager.g()) + getPaddingTop() + getPaddingBottom();
    }

    private final int e() {
        return ((int) this.textManager.e()) + getPaddingLeft() + getPaddingRight();
    }

    private final void h(Canvas canvas) {
        float e16 = this.textManager.e();
        float g16 = this.textManager.g();
        int width = this.viewBounds.width();
        int height = this.viewBounds.height();
        Rect rect = this.viewBounds;
        float f16 = rect.left + (width - e16);
        float f17 = rect.top + ((height - g16) / 2.0f);
        com.tencent.storage.view.c cVar = com.tencent.storage.view.c.f373802a;
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        canvas.translate(f16, f17 + cVar.c(6.0f, resources));
        canvas.clipRect(0.0f, 0.0f, e16, g16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(ValueAnimator valueAnimator) {
        valueAnimator.start();
    }

    public static /* synthetic */ void setText$default(RollingTextView rollingTextView, CharSequence charSequence, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z17 = true;
        }
        rollingTextView.setText(charSequence, z16, z17);
    }

    @NotNull
    public final f f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (f) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.textManager;
    }

    @NotNull
    public final TextPaint g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TextPaint) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.textPaint;
    }

    public final void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else if (this.mTextColorStateList != 0) {
            ColorStateList colorStateList = getResources().getColorStateList(this.mTextColorStateList);
            Intrinsics.checkNotNullExpressionValue(colorStateList, "resources.getColorStateList(mTextColorStateList)");
            setTextColor(colorStateList);
        }
    }

    @Override // android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        canvas.save();
        h(canvas);
        canvas.translate(0.0f, this.textManager.f());
        this.textManager.b(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Integer.valueOf(widthMeasureSpec), Integer.valueOf(heightMeasureSpec));
            return;
        }
        this.lastMeasuredDesiredWidth = e();
        this.lastMeasuredDesiredHeight = d();
        setMeasuredDimension(View.resolveSize(this.lastMeasuredDesiredWidth, widthMeasureSpec), View.resolveSize(this.lastMeasuredDesiredHeight, heightMeasureSpec));
    }

    @Override // android.view.View
    protected void onSizeChanged(int width, int height, int oldw, int oldh) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(oldw), Integer.valueOf(oldh));
        } else {
            super.onSizeChanged(width, height, oldw, oldh);
            this.viewBounds.set(getPaddingLeft(), getPaddingTop(), width - getPaddingRight(), height - getPaddingBottom());
        }
    }

    @Override // com.tencent.theme.SkinnableView
    public void onThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else {
            i();
        }
    }

    public final void setText(@NotNull CharSequence text) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) text);
        } else {
            Intrinsics.checkNotNullParameter(text, "text");
            setText$default(this, text, !TextUtils.isEmpty(this.targetText), false, 4, null);
        }
    }

    public final void setTextColor(@ColorInt int color) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, color);
        } else {
            this.textPaint.setColor(color);
            invalidate();
        }
    }

    public final void setTextColorStateList(int color) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, color);
            return;
        }
        this.mTextColorStateList = color;
        ColorStateList colorStateList = getResources().getColorStateList(color);
        Intrinsics.checkNotNullExpressionValue(colorStateList, "resources.getColorStateList(color)");
        setTextColor(colorStateList);
    }

    public final void setTextFont(@NotNull String fontString) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) fontString);
            return;
        }
        Intrinsics.checkNotNullParameter(fontString, "fontString");
        try {
            this.textPaint.setTypeface(Typeface.create(fontString, 0));
            f fVar = this.textManager;
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            fVar.m(resources);
            requestLayout();
            invalidate();
        } catch (Exception e16) {
            QLog.d("RollingTextView", 1, e16, new Object[0]);
        }
    }

    public final void setTextSize(int unit, float size) {
        Resources resources;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(unit), Float.valueOf(size));
            return;
        }
        Context context = getContext();
        if (context != null) {
            resources = context.getResources();
        } else {
            resources = null;
        }
        if (resources == null) {
            resources = Resources.getSystem();
            Intrinsics.checkNotNullExpressionValue(resources, "getSystem()");
        }
        this.textPaint.setTextSize(TypedValue.applyDimension(unit, size, resources.getDisplayMetrics()));
        f fVar = this.textManager;
        Resources resources2 = getResources();
        Intrinsics.checkNotNullExpressionValue(resources2, "resources");
        fVar.m(resources2);
        requestLayout();
        invalidate();
    }

    public final void setTextStyle(int textStyle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, textStyle);
            return;
        }
        Typeface typeface = this.textPaint.getTypeface();
        if (textStyle != 1) {
            if (textStyle != 2) {
                if (textStyle == 3) {
                    typeface = Typeface.create(typeface, 3);
                }
            } else {
                typeface = Typeface.create(typeface, 2);
            }
        } else {
            typeface = Typeface.create(typeface, 1);
        }
        this.textPaint.setTypeface(typeface);
        f fVar = this.textManager;
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        fVar.m(resources);
        requestLayout();
        invalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RollingTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) {
            return;
        }
        iPatchRedirector.redirect((short) 20, (Object) this, (Object) context, (Object) attributeSet);
    }

    public final void setText(@NotNull CharSequence text, boolean animate, boolean expand2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, text, Boolean.valueOf(animate), Boolean.valueOf(expand2));
            return;
        }
        Intrinsics.checkNotNullParameter(text, "text");
        this.targetText = text;
        if (animate) {
            this.textManager.k(text);
            this.textManager.h(expand2);
            final ValueAnimator valueAnimator = this.animator;
            if (valueAnimator.isRunning()) {
                valueAnimator.cancel();
            }
            valueAnimator.setDuration(500L);
            valueAnimator.setInterpolator(new LinearInterpolator());
            post(new Runnable() { // from class: com.tencent.storage.view.rtv.d
                @Override // java.lang.Runnable
                public final void run() {
                    RollingTextView.j(valueAnimator);
                }
            });
            return;
        }
        com.tencent.storage.view.rtv.a c16 = this.textManager.c();
        this.textManager.j(com.tencent.storage.view.rtv.a.INSTANCE.a());
        this.textManager.k(text);
        this.textManager.j(c16);
        this.textManager.i();
        requestLayout();
        invalidate();
    }

    public /* synthetic */ RollingTextView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    public final void setTextColor(@NotNull ColorStateList colorStateList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) colorStateList);
            return;
        }
        Intrinsics.checkNotNullParameter(colorStateList, "colorStateList");
        this.textPaint.setColor(colorStateList.getColorForState(getDrawableState(), -16777216));
        invalidate();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RollingTextView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f);
        this.animator = ofFloat;
        TextPaint textPaint = new TextPaint(1);
        this.textPaint = textPaint;
        f fVar = new f(textPaint, null, i16, 0 == true ? 1 : 0);
        this.textManager = fVar;
        this.viewBounds = new Rect();
        this.targetText = "";
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.storage.view.rtv.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                RollingTextView.c(RollingTextView.this, valueAnimator);
            }
        });
        ofFloat.addListener(new a());
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        fVar.m(resources);
    }
}
