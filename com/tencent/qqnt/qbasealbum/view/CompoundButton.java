package com.tencent.qqnt.qbasealbum.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqnt.qbasealbum.b;
import com.tencent.qqnt.qbasealbum.ktx.d;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010'\u001a\u00020\u000e\u00a2\u0006\u0004\b(\u0010)J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0014J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0016\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eJ\u0010\u0010\u0013\u001a\u00020\u00062\b\b\u0001\u0010\u0012\u001a\u00020\u000eJ\u0010\u0010\u0014\u001a\u00020\u00062\b\b\u0001\u0010\u0012\u001a\u00020\u000eJ\u001a\u0010\u0016\u001a\u00020\u00062\b\b\u0001\u0010\u0012\u001a\u00020\u000e2\b\b\u0001\u0010\u0015\u001a\u00020\u000eR(\u0010\u001d\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010#\u00a8\u0006*"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/view/CompoundButton;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "a", "b", NodeProps.ON_ATTACHED_TO_WINDOW, "Landroid/view/MotionEvent;", "event", "", "onTouchEvent", "", "foregroundWidth", "foregroundHeight", "setForegroundSize", "fgRes", "setForegroundResource", "setForegroundDrawable", "bgRes", "setForegroundAndBackgroundResource", "Landroid/widget/ImageView;", "<set-?>", "d", "Landroid/widget/ImageView;", "getForegroundView", "()Landroid/widget/ImageView;", "foregroundView", "Landroid/graphics/drawable/Drawable;", "e", "Landroid/graphics/drawable/Drawable;", "mForegroundDrawable", "f", "I", "mForegroundWidth", h.F, "mForegroundHeight", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class CompoundButton extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView foregroundView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable mForegroundDrawable;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mForegroundWidth;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mForegroundHeight;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CompoundButton(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            return;
        }
        iPatchRedirector.redirect((short) 11, (Object) this, (Object) context);
    }

    private final void a(Context context, AttributeSet attrs) {
        b(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.fsw, (ViewGroup) this, true);
        ImageView imageView = (ImageView) findViewById(R.id.y3f);
        this.foregroundView = imageView;
        if (this.mForegroundDrawable != null) {
            Intrinsics.checkNotNull(imageView);
            imageView.setImageDrawable(this.mForegroundDrawable);
        }
    }

    private final void b(Context context, AttributeSet attrs) {
        TypedArray obtainStyledAttributes;
        if (attrs == null || (obtainStyledAttributes = context.obtainStyledAttributes(attrs, b.f360895a)) == null) {
            return;
        }
        this.mForegroundDrawable = obtainStyledAttributes.getDrawable(b.f360909c);
        this.mForegroundWidth = obtainStyledAttributes.getDimensionPixelSize(b.f360915d, 0);
        this.mForegroundHeight = obtainStyledAttributes.getDimensionPixelSize(b.f360902b, 0);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onAttachedToWindow();
        ImageView imageView = this.foregroundView;
        if (imageView != null && this.mForegroundWidth != 0 && this.mForegroundHeight != 0) {
            Intrinsics.checkNotNull(imageView);
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            layoutParams.width = this.mForegroundWidth;
            layoutParams.height = this.mForegroundHeight;
            ImageView imageView2 = this.foregroundView;
            Intrinsics.checkNotNull(imageView2);
            imageView2.setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) event)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(event, "event");
        if (isClickable() && isEnabled()) {
            int action = event.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    setAlpha(1.0f);
                }
                return super.onTouchEvent(event);
            }
            setAlpha(0.5f);
            super.onTouchEvent(event);
            return true;
        }
        return super.onTouchEvent(event);
    }

    public final void setForegroundAndBackgroundResource(@DrawableRes int fgRes, @DrawableRes int bgRes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(fgRes), Integer.valueOf(bgRes));
        } else {
            setForegroundResource(fgRes);
            setBackgroundResource(bgRes);
        }
    }

    public final void setForegroundDrawable(@DrawableRes int fgRes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, fgRes);
            return;
        }
        ImageView imageView = this.foregroundView;
        if (imageView != null) {
            Intrinsics.checkNotNull(imageView);
            d.e(imageView, fgRes);
        }
    }

    public final void setForegroundResource(@DrawableRes int fgRes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, fgRes);
            return;
        }
        ImageView imageView = this.foregroundView;
        if (imageView != null) {
            Intrinsics.checkNotNull(imageView);
            imageView.setImageResource(fgRes);
        }
    }

    public final void setForegroundSize(int foregroundWidth, int foregroundHeight) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(foregroundWidth), Integer.valueOf(foregroundHeight));
        } else {
            this.mForegroundWidth = foregroundWidth;
            this.mForegroundHeight = foregroundHeight;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CompoundButton(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            return;
        }
        iPatchRedirector.redirect((short) 10, (Object) this, (Object) context, (Object) attributeSet);
    }

    public /* synthetic */ CompoundButton(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CompoundButton(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            a(context, attributeSet);
        } else {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
        }
    }
}
