package com.tencent.mobileqq.qqlive.widget.roombg;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.widget.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J0\u0010\u0010\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0014J(\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000bH\u0014R\"\u0010\u001b\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/roombg/CropImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "init", "", "l", "changed", "", "left", "top", "right", "bottom", "onLayout", "t", "r", "b", "setFrame", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "getAlignTop", "()Z", "setAlignTop", "(Z)V", LayoutAttrDefine.ALIGN_TOP, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class CropImageView extends AppCompatImageView {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean alignTop;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CropImageView(@NotNull Context context, @NotNull AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attrs);
        } else {
            setScaleType(ImageView.ScaleType.MATRIX);
            init(context, attrs);
        }
    }

    private final void init(Context context, AttributeSet attrs) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attrs, b.f273661u0, 0, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.theme.obtainStyl\u2026able.CropImageView, 0, 0)");
        try {
            boolean z16 = obtainStyledAttributes.getBoolean(b.f273669v0, true);
            obtainStyledAttributes.recycle();
            this.alignTop = z16;
        } catch (Throwable th5) {
            obtainStyledAttributes.recycle();
            throw th5;
        }
    }

    private final boolean l() {
        float f16;
        float f17;
        Matrix imageMatrix = getImageMatrix();
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return true;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth == 0 || intrinsicHeight == 0) {
            return true;
        }
        if (intrinsicWidth * height > intrinsicHeight * width) {
            f16 = height;
            f17 = intrinsicHeight;
        } else {
            f16 = width;
            f17 = intrinsicWidth;
        }
        float f18 = f16 / f17;
        imageMatrix.setScale(f18, f18);
        if (!this.alignTop) {
            imageMatrix.postTranslate(0.0f, getHeight() - (drawable.getIntrinsicHeight() * f18));
        }
        setImageMatrix(imageMatrix);
        return false;
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(changed), Integer.valueOf(left), Integer.valueOf(top), Integer.valueOf(right), Integer.valueOf(bottom));
        } else {
            super.onLayout(changed, left, top, right, bottom);
            l();
        }
    }

    public final void setAlignTop(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.alignTop = z16;
        }
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int l3, int t16, int r16, int b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(l3), Integer.valueOf(t16), Integer.valueOf(r16), Integer.valueOf(b16))).booleanValue();
        }
        l();
        return super.setFrame(l3, t16, r16, b16);
    }
}
