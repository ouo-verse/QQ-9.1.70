package com.tencent.mobileqq.qqlive.widget.chat.util.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.jsengine.animation.custom.CustomAnimation;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B;\b\u0016\u0012\b\u0010#\u001a\u0004\u0018\u00010 \u0012\u0006\u0010\u0015\u001a\u00020\u0006\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u0016\u0012\u0006\u0010\u001f\u001a\u00020\u0016\u00a2\u0006\u0004\b(\u0010)J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016R\u0014\u0010\u000f\u001a\u00020\u00068\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00068\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00068\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0016\u0010\u0015\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000eR\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0018R\u0016\u0010\u001f\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0018R\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/chat/util/drawable/a;", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "draw", "", com.tencent.luggage.wxa.c8.c.f123400v, "setAlpha", "Landroid/graphics/ColorFilter;", CustomAnimation.KeyPath.COLOR_FILTER, "setColorFilter", "getOpacity", "a", "I", "LEFT_BOTTOM", "b", "RIGHT_TOP", "c", "RIGHT_BOTTOM", "d", "position", "", "e", UserInfo.SEX_FEMALE, "leftOffset", "f", "rightOffset", "g", "topOffset", h.F, "bottomOffset", "Landroid/graphics/Bitmap;", "i", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Landroid/graphics/Paint;", "j", "Landroid/graphics/Paint;", "paint", "<init>", "(Landroid/graphics/Bitmap;IFFFF)V", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a extends Drawable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int LEFT_BOTTOM;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int RIGHT_TOP;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int RIGHT_BOTTOM;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int position;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float leftOffset;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float rightOffset;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private float topOffset;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float bottomOffset;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Bitmap bitmap;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint paint;

    public a(@Nullable Bitmap bitmap, int i3, float f16, float f17, float f18, float f19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, bitmap, Integer.valueOf(i3), Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
            return;
        }
        this.LEFT_BOTTOM = 1;
        this.RIGHT_TOP = 2;
        this.RIGHT_BOTTOM = 3;
        this.position = 2;
        this.paint = new Paint(7);
        this.bitmap = bitmap;
        this.position = i3;
        this.leftOffset = f16;
        this.rightOffset = f17;
        this.topOffset = f18;
        this.bottomOffset = f19;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        float height;
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Bitmap bitmap = this.bitmap;
        if (bitmap != null) {
            float f17 = this.leftOffset;
            float f18 = this.topOffset;
            int i3 = this.LEFT_BOTTOM;
            int i16 = this.position;
            if (i3 == i16) {
                height = canvas.getHeight() - bitmap.getHeight();
                f16 = this.bottomOffset;
            } else {
                if (this.RIGHT_TOP == i16) {
                    f17 = (canvas.getWidth() - bitmap.getWidth()) + this.rightOffset;
                } else if (this.RIGHT_BOTTOM == i16) {
                    f17 = (canvas.getWidth() - bitmap.getWidth()) + this.rightOffset;
                    height = canvas.getHeight() - bitmap.getHeight();
                    f16 = this.bottomOffset;
                }
                canvas.drawBitmap(bitmap, f17, f18, this.paint);
            }
            f18 = height + f16;
            canvas.drawBitmap(bitmap, f17, f18, this.paint);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, alpha);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) colorFilter);
        }
    }
}
