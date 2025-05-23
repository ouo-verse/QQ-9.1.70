package com.tencent.mobileqq.qqlive.widget.chat.util.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.drawable.BitmapDrawable;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B+\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0014\u001a\u00020\n\u0012\u0006\u0010\u0015\u001a\u00020\n\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\f\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/chat/util/drawable/c;", "Landroid/graphics/drawable/BitmapDrawable;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "draw", "Landroid/graphics/Path;", "a", "Landroid/graphics/Path;", "path", "", "b", UserInfo.SEX_FEMALE, "radiusF", "c", "multiRadiusF", "Landroid/content/res/Resources;", "res", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "radius", "multiRadius", "<init>", "(Landroid/content/res/Resources;Landroid/graphics/Bitmap;FF)V", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class c extends BitmapDrawable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Path path;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private float radiusF;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private float multiRadiusF;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull Resources res, @Nullable Bitmap bitmap, float f16, float f17) {
        super(res, bitmap);
        Intrinsics.checkNotNullParameter(res, "res");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, res, bitmap, Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        this.path = new Path();
        this.radiusF = f16;
        this.multiRadiusF = f17;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        float height;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        this.path.reset();
        float f16 = 2;
        if (canvas.getHeight() > this.radiusF * f16) {
            height = this.multiRadiusF;
        } else {
            height = canvas.getHeight() / f16;
        }
        float width = canvas.getWidth();
        float height2 = canvas.getHeight();
        this.path.moveTo(height, 0.0f);
        float f17 = width - height;
        this.path.lineTo(f17, 0.0f);
        this.path.quadTo(width, 0.0f, width, height);
        float f18 = height2 - height;
        this.path.lineTo(width, f18);
        this.path.quadTo(width, height2, f17, height2);
        this.path.lineTo(height, height2);
        this.path.quadTo(0.0f, height2, 0.0f, f18);
        this.path.lineTo(0.0f, height);
        this.path.quadTo(0.0f, 0.0f, height, 0.0f);
        this.path.close();
        canvas.clipPath(this.path);
        super.draw(canvas);
    }
}
