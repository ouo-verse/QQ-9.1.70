package com.tencent.mobileqq.aio.msglist.holder.component.tofu.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.util.VersionUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 *2\u00020\u0001:\u0001+B\u0013\b\u0016\u0012\b\u0010!\u001a\u0004\u0018\u00010 \u00a2\u0006\u0004\b\"\u0010#B\u001d\b\u0016\u0012\b\u0010!\u001a\u0004\u0018\u00010 \u0012\b\u0010%\u001a\u0004\u0018\u00010$\u00a2\u0006\u0004\b\"\u0010&B%\b\u0016\u0012\b\u0010!\u001a\u0004\u0018\u00010 \u0012\b\u0010%\u001a\u0004\u0018\u00010$\u0012\u0006\u0010(\u001a\u00020'\u00a2\u0006\u0004\b\"\u0010)J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0004J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0014J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0004J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0004J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\b\u0010\u0010\u001a\u00020\u0004H\u0014R\"\u0010\u0016\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/CornerImageView;", "Lcom/tencent/image/URLImageView;", "", "radius", "", "setRadius", "", "e", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "d", "c", "", "enable", "setPressMask", "drawableStateChanged", "Z", "getMEnablePressMask", "()Z", "setMEnablePressMask", "(Z)V", "mEnablePressMask", "[F", "Landroid/graphics/Path;", "f", "Landroid/graphics/Path;", "mPath", "Landroid/graphics/RectF;", tl.h.F, "Landroid/graphics/RectF;", "mTmpRectF", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "i", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class CornerImageView extends URLImageView {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private static ColorFilter f192157m;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean mEnablePressMask;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private float[] radius;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Path mPath;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RectF mTmpRectF;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/CornerImageView$a;", "", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.CornerImageView$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63743);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            INSTANCE = new Companion(null);
            f192157m = new PorterDuffColorFilter(637534208, PorterDuff.Mode.SRC_ATOP);
        }
    }

    public CornerImageView(@Nullable Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        } else {
            this.radius = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
            this.mTmpRectF = new RectF();
        }
    }

    protected final void c(@Nullable Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) canvas);
        }
    }

    protected final void d(@Nullable Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) canvas);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        super.drawableStateChanged();
        if (!this.mEnablePressMask) {
            return;
        }
        int[] drawableState = getDrawableState();
        int length = drawableState.length;
        boolean z16 = false;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            if (drawableState[i3] == 16842919) {
                z16 = true;
                break;
            }
            i3++;
        }
        if (isPressed() | z16) {
            Drawable drawable = getDrawable();
            if (drawable != null) {
                drawable.setColorFilter(f192157m);
                drawable.invalidateSelf();
                return;
            }
            return;
        }
        Drawable drawable2 = getDrawable();
        if (drawable2 != null) {
            drawable2.setColorFilter(null);
            drawable2.invalidateSelf();
        }
    }

    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else if (!VersionUtils.isKITKAT()) {
            setLayerType(1, null);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.mPath == null) {
            this.mPath = new Path();
        }
        int save = canvas.save();
        try {
            try {
                Path path = this.mPath;
                Intrinsics.checkNotNull(path);
                RectF rectF = this.mTmpRectF;
                rectF.set(0.0f, 0.0f, getWidth(), getHeight());
                path.reset();
                path.addRoundRect(rectF, this.radius, Path.Direction.CW);
                canvas.clipPath(path);
                d(canvas);
                super.onDraw(canvas);
                c(canvas);
            } catch (UnsupportedOperationException unused) {
                super.onDraw(canvas);
            }
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public final void setMEnablePressMask(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        } else {
            this.mEnablePressMask = z16;
        }
    }

    public final void setPressMask(boolean enable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, enable);
        } else {
            this.mEnablePressMask = enable;
        }
    }

    public final void setRadius(@NotNull float[] radius) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) radius);
            return;
        }
        Intrinsics.checkNotNullParameter(radius, "radius");
        this.radius = radius;
        e();
    }

    public final void setRadius(float radius) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Float.valueOf(radius));
        } else {
            this.radius = new float[]{radius, radius, radius, radius, radius, radius, radius, radius};
            e();
        }
    }

    public CornerImageView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.radius = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
            this.mTmpRectF = new RectF();
        }
    }

    public CornerImageView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.radius = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
            this.mTmpRectF = new RectF();
        }
    }
}
