package com.tencent.mobileqq.proavatar;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.face.ZplanAvatarAnimateDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 >2\u00020\u0001:\u0001\u0005BA\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u0012\u0006\u0010\u001d\u001a\u00020\u0019\u0012\u0006\u0010\u001f\u001a\u00020\u0019\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010)\u001a\u00020$\u0012\b\b\u0002\u0010;\u001a\u00020:\u00a2\u0006\u0004\b<\u0010=J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006J\u0010\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001d\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u001f\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001e\u0010\u001cR\u0017\u0010#\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010!\u001a\u0004\b\u0014\u0010\"R\u0017\u0010)\u001a\u00020$8\u0006\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/proavatar/m;", "", "Landroid/graphics/Canvas;", PM.CANVAS, "", "a", "", "hideMaxDuration", "c", "animateDuration", "e", "Lcom/tencent/mobileqq/app/face/ZplanAvatarAnimateDrawable$AvatarAnimatorListener;", "listener", "d", "Landroid/content/res/Resources;", "Landroid/content/res/Resources;", "getRes", "()Landroid/content/res/Resources;", "res", "Landroid/graphics/drawable/Drawable;", "b", "Landroid/graphics/drawable/Drawable;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "drawable", "Landroid/graphics/Bitmap;", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "getBackgroundBitmap", "backgroundBitmap", "", "Ljava/lang/String;", "()Ljava/lang/String;", "backgroundUrl", "", "f", "I", "getClipPercent", "()I", "clipPercent", "Landroid/graphics/Path;", "g", "Landroid/graphics/Path;", "path", "Lcom/tencent/mobileqq/app/face/ZplanAvatarAnimateDrawable;", tl.h.F, "Lcom/tencent/mobileqq/app/face/ZplanAvatarAnimateDrawable;", "avatarDrawable", "Landroid/graphics/RectF;", "i", "Landroid/graphics/RectF;", "rectF", "Landroid/graphics/Paint;", "j", "Landroid/graphics/Paint;", "bitmapPaint", "", "isHideAvatar", "<init>", "(Landroid/content/res/Resources;Landroid/graphics/drawable/Drawable;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Ljava/lang/String;IZ)V", "k", "qqavatar-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class m {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Resources res;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Drawable drawable;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Bitmap bitmap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Bitmap backgroundBitmap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String backgroundUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int clipPercent;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Path path;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ZplanAvatarAnimateDrawable avatarDrawable;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RectF rectF;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint bitmapPaint;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/proavatar/m$a;", "", "", "DEFAULT_CLIP_PERCENT", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqavatar-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.proavatar.m$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33877);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public m(@NotNull Resources res, @NotNull Drawable drawable, @NotNull Bitmap bitmap, @NotNull Bitmap backgroundBitmap, @NotNull String backgroundUrl, int i3, boolean z16) {
        Intrinsics.checkNotNullParameter(res, "res");
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(backgroundBitmap, "backgroundBitmap");
        Intrinsics.checkNotNullParameter(backgroundUrl, "backgroundUrl");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, res, drawable, bitmap, backgroundBitmap, backgroundUrl, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        this.res = res;
        this.drawable = drawable;
        this.bitmap = bitmap;
        this.backgroundBitmap = backgroundBitmap;
        this.backgroundUrl = backgroundUrl;
        this.clipPercent = i3;
        this.path = new Path();
        ZplanAvatarAnimateDrawable zplanAvatarAnimateDrawable = new ZplanAvatarAnimateDrawable(res, bitmap, z16);
        this.avatarDrawable = zplanAvatarAnimateDrawable;
        this.rectF = new RectF();
        Paint paint = new Paint();
        this.bitmapPaint = paint;
        paint.setDither(true);
        zplanAvatarAnimateDrawable.setParentCallback(drawable);
    }

    public final void a(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Rect bounds = this.drawable.getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "drawable.bounds");
        canvas.save();
        this.path.reset();
        this.rectF.set(bounds);
        this.path.addArc(this.rectF, 0.0f, 360.0f);
        canvas.clipPath(this.path);
        canvas.drawBitmap(this.backgroundBitmap, (Rect) null, bounds, this.bitmapPaint);
        canvas.restore();
        canvas.save();
        com.tencent.mobileqq.avatar.utils.g.a(canvas, this.path, bounds.width(), bounds.height(), this.clipPercent / 100.0f);
        this.avatarDrawable.setBounds(bounds);
        this.avatarDrawable.draw(canvas);
        canvas.restore();
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.backgroundUrl;
    }

    public final void c(long hideMaxDuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, hideMaxDuration);
        } else {
            this.avatarDrawable.hideAvatar();
        }
    }

    public final void d(@Nullable ZplanAvatarAnimateDrawable.AvatarAnimatorListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) listener);
        } else {
            this.avatarDrawable.setAvatarAnimatorListener(listener);
        }
    }

    public final void e(long animateDuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, animateDuration);
        } else {
            this.avatarDrawable.showAvatar(animateDuration);
        }
    }

    public /* synthetic */ m(Resources resources, Drawable drawable, Bitmap bitmap, Bitmap bitmap2, String str, int i3, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(resources, drawable, bitmap, bitmap2, str, i3, (i16 & 64) != 0 ? false : z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, resources, drawable, bitmap, bitmap2, str, Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(i16), defaultConstructorMarker);
    }
}
