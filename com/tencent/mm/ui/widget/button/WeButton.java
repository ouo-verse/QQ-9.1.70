package com.tencent.mm.ui.widget.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.dynamicwidget.http.Method;
import com.tencent.luggage.wxa.fp.a;
import com.tencent.luggage.wxa.lo.m;
import com.tencent.luggage.wxa.lo.o;
import com.tencent.luggage.wxa.lo.r;
import com.tencent.luggage.wxa.standalone_open_runtime_sdk.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 B2\u00020\u0001:\u0002BCB!\u0012\u0006\u0010:\u001a\u000209\u0012\b\u0010<\u001a\u0004\u0018\u00010;\u0012\u0006\u0010=\u001a\u00020\t\u00a2\u0006\u0004\b>\u0010?B\u0011\b\u0016\u0012\u0006\u0010:\u001a\u000209\u00a2\u0006\u0004\b>\u0010@B\u001b\b\u0016\u0012\u0006\u0010:\u001a\u000209\u0012\b\u0010<\u001a\u0004\u0018\u00010;\u00a2\u0006\u0004\b>\u0010AJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0004\u001a\u00020\u0002H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tJ\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016J\u000e\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\tJ\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\tH\u0016J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\tH\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0014J\b\u0010\u0015\u001a\u00020\u0002H\u0002J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0002R\u0016\u0010\u000f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0016R\"\u0010$\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u0016\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010(\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u0016\u001a\u0004\b&\u0010!\"\u0004\b'\u0010#R\u0016\u0010*\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010\u0016R\u0016\u0010,\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010\u0016R\u0016\u0010.\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010\u0016R\u0016\u00100\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010\u0016R\u0016\u00102\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010\u0016R\u0016\u00104\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010\u0016R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107\u00a8\u0006D"}, d2 = {"Lcom/tencent/mm/ui/widget/button/WeButton;", "Lcom/tencent/luggage/wxa/fp/a;", "", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Ljava/lang/Runnable;", "action", "", Method.POST, "", "resId", "setIcon", "Landroid/graphics/Canvas;", PM.CANVAS, "draw", "radius", "setRadius", "color", "setBackgroundColor", "setTextColor", "drawableStateChanged", "a", "I", "Landroid/graphics/drawable/Drawable;", "b", "Landroid/graphics/drawable/Drawable;", "svgIcon", "c", "bitmapDrawable", "d", "svgIconWidth", "e", "getHorizontalPadding", "()I", "setHorizontalPadding", "(I)V", "horizontalPadding", "f", "getContentWidth", "setContentWidth", "contentWidth", "g", "backgroundColor", h.F, "pressBackgroundColor", "i", "disableBackgroundColor", "j", "textColor", "k", "pressTextColor", "l", "disableTextColor", "Landroid/graphics/Path;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/graphics/Path;", "path", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "style", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Companion", "RoundCornerOutlineProvider", "weui-native-android-lib_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public class WeButton extends a {

    @NotNull
    public static final String TAG = "WeButton";

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public int radius;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public Drawable svgIcon;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public Drawable bitmapDrawable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public int svgIconWidth;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public int horizontalPadding;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public int contentWidth;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public int backgroundColor;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public int pressBackgroundColor;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public int disableBackgroundColor;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public int textColor;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public int pressTextColor;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public int disableTextColor;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public Path path;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\f\u0010\rJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mm/ui/widget/button/WeButton$RoundCornerOutlineProvider;", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "", "a", "I", "radius", "<init>", "(I)V", "weui-native-android-lib_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public static final class RoundCornerOutlineProvider extends ViewOutlineProvider {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public int radius;

        public RoundCornerOutlineProvider(int i3) {
            this.radius = i3;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(@Nullable View view, @Nullable Outline outline) {
            int i3;
            int i16;
            float f16;
            float f17;
            if (Build.VERSION.SDK_INT > 31) {
                if (view != null) {
                    f16 = view.getMeasuredWidth();
                } else {
                    f16 = 0.0f;
                }
                if (view != null) {
                    f17 = view.getMeasuredHeight();
                } else {
                    f17 = 0.0f;
                }
                RectF rectF = new RectF(0.0f, 0.0f, f16, f17);
                if (outline != null) {
                    float f18 = this.radius;
                    outline.setPath(r.a(rectF, f18, f18, f18, f18, 0.6f));
                    return;
                }
                return;
            }
            if (view != null) {
                i3 = view.getMeasuredWidth();
            } else {
                i3 = 0;
            }
            if (view != null) {
                i16 = view.getMeasuredHeight();
            } else {
                i16 = 0;
            }
            Rect rect = new Rect(0, 0, i3, i16);
            if (outline != null) {
                outline.setRoundRect(rect, this.radius);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WeButton(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Integer num;
        Intrinsics.checkNotNullParameter(context, "context");
        this.path = new Path();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.WeButton);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026et, R.styleable.WeButton)");
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.Component);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes2, "context.obtainStyledAttr\u2026t, R.styleable.Component)");
            this.radius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.WeButton_button_radius, 0);
            this.svgIcon = obtainStyledAttributes2.getDrawable(R.styleable.Component_iconName);
            this.svgIconWidth = (int) (obtainStyledAttributes.getDimensionPixelSize(R.styleable.WeButton_button_iconSize, 0) * o.b(context));
            this.disableBackgroundColor = obtainStyledAttributes.getColor(R.styleable.WeButton_button_disableBgColor, 0);
            this.disableTextColor = obtainStyledAttributes.getColor(R.styleable.WeButton_button_disableFgColor, 0);
            obtainStyledAttributes.recycle();
            obtainStyledAttributes2.recycle();
        }
        setClipToOutline(true);
        setOutlineProvider(new RoundCornerOutlineProvider(this.radius));
        Drawable background = getBackground();
        if (background != null) {
            num = Integer.valueOf(background instanceof ColorDrawable ? ((ColorDrawable) background).getColor() : 0);
        } else {
            num = null;
        }
        Intrinsics.checkNotNull(num);
        int intValue = num.intValue();
        this.backgroundColor = intValue;
        this.backgroundColor = a(intValue);
        this.pressBackgroundColor = m.c(context.getResources().getColor(com.tencent.mobileqq.R.color.aqc), this.backgroundColor);
        r.a(getPaint());
        this.textColor = getCurrentTextColor();
        this.pressTextColor = m.c(context.getResources().getColor(com.tencent.mobileqq.R.color.aqc), getCurrentTextColor());
        a();
    }

    public final void a() {
        Drawable drawable = this.svgIcon;
        if (drawable != null) {
            int i3 = this.svgIconWidth;
            drawable.setBounds(0, 0, i3, i3);
            int i16 = this.svgIconWidth;
            Bitmap createBitmap = Bitmap.createBitmap(i16, i16, Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(svgIconWidt\u2026 Bitmap.Config.ARGB_8888)");
            Canvas canvas = new Canvas(createBitmap);
            Drawable drawable2 = this.svgIcon;
            if (drawable2 != null) {
                int i17 = this.svgIconWidth;
                drawable2.setBounds(0, 0, i17, i17);
                drawable2.draw(canvas);
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getContext().getResources(), createBitmap);
            this.bitmapDrawable = bitmapDrawable;
            int i18 = this.svgIconWidth;
            bitmapDrawable.setBounds(0, 0, i18, i18);
            Drawable drawable3 = this.bitmapDrawable;
            if (drawable3 != null) {
                drawable3.setColorFilter(this.textColor, PorterDuff.Mode.SRC_ATOP);
            }
            setCompoundDrawables(this.bitmapDrawable, null, null, null);
            getPaint().getTextBounds(getText().toString(), 0, getText().length(), new Rect());
            this.contentWidth = this.svgIconWidth + o.c(getContext(), com.tencent.mobileqq.R.dimen.f158059be0) + ((int) (r0.width() * o.b(getContext())));
        }
    }

    @Override // android.view.View
    public void draw(@NotNull Canvas canvas) {
        int width;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.draw(canvas);
        if (getWidth() > 0 && this.svgIcon != null && (width = (int) ((getWidth() / 2.0d) - (this.contentWidth / 2.0d))) != this.horizontalPadding && width > getPaddingLeft()) {
            this.horizontalPadding = width;
            setPadding(width, 0, width, 0);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int i3 = this.backgroundColor;
        if (i3 != 0) {
            int i16 = this.textColor;
            if (isPressed()) {
                i3 = this.pressBackgroundColor;
                i16 = this.pressTextColor;
            } else if (!isEnabled()) {
                i3 = this.disableBackgroundColor;
                i16 = this.disableTextColor;
            }
            super.setBackgroundColor(i3);
            super.setTextColor(i16);
            Drawable drawable = this.bitmapDrawable;
            if (drawable != null) {
                m.a(drawable, i16);
            }
        }
    }

    public final int getContentWidth() {
        return this.contentWidth;
    }

    public final int getHorizontalPadding() {
        return this.horizontalPadding;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean post(@Nullable Runnable action) {
        return super.post(action);
    }

    @Override // android.view.View
    public void setBackgroundColor(int color) {
        if (this.backgroundColor != color) {
            this.backgroundColor = color;
            this.pressBackgroundColor = m.c(getContext().getColor(com.tencent.mobileqq.R.color.aqc), this.backgroundColor);
        }
        super.setBackgroundColor(color);
    }

    public final void setContentWidth(int i3) {
        this.contentWidth = i3;
    }

    public final void setHorizontalPadding(int i3) {
        this.horizontalPadding = i3;
    }

    public final void setIcon(int resId) {
        this.svgIcon = getContext().getDrawable(resId);
        a();
    }

    public final void setRadius(int radius) {
        this.radius = radius;
        setClipToOutline(true);
        setOutlineProvider(new RoundCornerOutlineProvider(radius));
    }

    @Override // android.widget.TextView
    public void setTextColor(int color) {
        if (this.textColor != color) {
            this.textColor = color;
            this.pressTextColor = m.c(getContext().getResources().getColor(com.tencent.mobileqq.R.color.aqc), this.textColor);
        }
        super.setTextColor(color);
    }

    public final int a(int color) {
        if (!r.b()) {
            return color;
        }
        if (color == getContext().getColor(com.tencent.mobileqq.R.color.ap9)) {
            return getContext().getColor(com.tencent.mobileqq.R.color.ap_);
        }
        return color == getContext().getColor(com.tencent.mobileqq.R.color.awx) ? getContext().getColor(com.tencent.mobileqq.R.color.awy) : color;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WeButton(@NotNull Context context) {
        this(context, null, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WeButton(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
