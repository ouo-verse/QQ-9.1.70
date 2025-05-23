package com.tencent.qqnt.qbasealbum.preview.view;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B)\b\u0007\u0012\b\u0010$\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%\u0012\b\b\u0002\u0010'\u001a\u00020\u0011\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0012\u0010\u0010\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0012\u0010\u0016\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J(\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0007\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0011H\u0014R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006*"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/preview/view/MultiTouchImageView;", "Lcom/tencent/image/URLImageView;", "Landroid/widget/ImageView$ScaleType;", "getScaleType", "Landroid/graphics/Matrix;", "getImageMatrix", "Landroid/view/View$OnLongClickListener;", "l", "", "setOnLongClickListener", "Landroid/view/View$OnClickListener;", "setOnClickListener", "scaleType", "setScaleType", "Landroid/graphics/drawable/Drawable;", "drawable", "setImageDrawable", "", "resId", "setImageResource", "Landroid/net/Uri;", LayoutAttrDefine.CLICK_URI, "setImageURI", "t", "r", "b", "", "setFrame", "Lcom/tencent/qqnt/qbasealbum/preview/view/PhotoViewAttacher;", "d", "Lcom/tencent/qqnt/qbasealbum/preview/view/PhotoViewAttacher;", "attacher", "e", "Landroid/widget/ImageView$ScaleType;", "pendingScaleType", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class MultiTouchImageView extends URLImageView {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PhotoViewAttacher attacher;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView.ScaleType pendingScaleType;

    @JvmOverloads
    public MultiTouchImageView(@Nullable Context context) {
        this(context, null, 0, 6, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
            return;
        }
        iPatchRedirector.redirect((short) 14, (Object) this, (Object) context);
    }

    @Override // android.widget.ImageView
    @NotNull
    public Matrix getImageMatrix() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Matrix) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        PhotoViewAttacher photoViewAttacher = this.attacher;
        Intrinsics.checkNotNull(photoViewAttacher);
        return photoViewAttacher.E();
    }

    @Override // android.widget.ImageView
    @NotNull
    public ImageView.ScaleType getScaleType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ImageView.ScaleType) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        PhotoViewAttacher photoViewAttacher = this.attacher;
        Intrinsics.checkNotNull(photoViewAttacher);
        return photoViewAttacher.I();
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int l3, int t16, int r16, int b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, this, Integer.valueOf(l3), Integer.valueOf(t16), Integer.valueOf(r16), Integer.valueOf(b16))).booleanValue();
        }
        boolean frame = super.setFrame(l3, t16, r16, b16);
        if (frame) {
            PhotoViewAttacher photoViewAttacher = this.attacher;
            Intrinsics.checkNotNull(photoViewAttacher);
            photoViewAttacher.X();
        }
        return frame;
    }

    @Override // com.tencent.image.URLImageView, android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) drawable);
            return;
        }
        super.setImageDrawable(drawable);
        PhotoViewAttacher photoViewAttacher = this.attacher;
        if (photoViewAttacher != null) {
            photoViewAttacher.X();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int resId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, resId);
            return;
        }
        super.setImageResource(resId);
        PhotoViewAttacher photoViewAttacher = this.attacher;
        if (photoViewAttacher != null) {
            photoViewAttacher.X();
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(@Nullable Uri uri) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) uri);
            return;
        }
        super.setImageURI(uri);
        PhotoViewAttacher photoViewAttacher = this.attacher;
        if (photoViewAttacher != null) {
            photoViewAttacher.X();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) l3);
            return;
        }
        PhotoViewAttacher photoViewAttacher = this.attacher;
        Intrinsics.checkNotNull(photoViewAttacher);
        photoViewAttacher.T(l3);
    }

    @Override // android.view.View
    public void setOnLongClickListener(@Nullable View.OnLongClickListener l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) l3);
            return;
        }
        PhotoViewAttacher photoViewAttacher = this.attacher;
        Intrinsics.checkNotNull(photoViewAttacher);
        photoViewAttacher.U(l3);
    }

    @Override // android.widget.ImageView
    public void setScaleType(@NotNull ImageView.ScaleType scaleType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) scaleType);
            return;
        }
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        PhotoViewAttacher photoViewAttacher = this.attacher;
        if (photoViewAttacher == null) {
            this.pendingScaleType = scaleType;
        } else {
            Intrinsics.checkNotNull(photoViewAttacher);
            photoViewAttacher.W(scaleType);
        }
    }

    @JvmOverloads
    public MultiTouchImageView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
            return;
        }
        iPatchRedirector.redirect((short) 13, (Object) this, (Object) context, (Object) attributeSet);
    }

    public /* synthetic */ MultiTouchImageView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    @JvmOverloads
    public MultiTouchImageView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.attacher = new PhotoViewAttacher(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        ImageView.ScaleType scaleType = this.pendingScaleType;
        if (scaleType != null) {
            Intrinsics.checkNotNull(scaleType);
            setScaleType(scaleType);
            this.pendingScaleType = null;
        }
    }
}
