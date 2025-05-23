package com.tencent.widget;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.jsengine.animation.custom.CustomAnimation;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\nH\u0017J\u0006\u0010\u0014\u001a\u00020\u000fJ\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\nH\u0016J\u0012\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u000e\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\nR\u0011\u0010\u0003\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/widget/BatteryDrawable;", "Landroid/graphics/drawable/Drawable;", "()V", "batteryProducer", "Lcom/tencent/widget/OnlineBatteryProducer;", "getBatteryProducer", "()Lcom/tencent/widget/OnlineBatteryProducer;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Landroid/graphics/Bitmap;", "percent", "", "producer", "type", "customMute", "draw", "", PM.CANVAS, "Landroid/graphics/Canvas;", "drawBatteryToBitmap", "getOpacity", "getSelfPercent", "setAlpha", com.tencent.luggage.wxa.c8.c.f123400v, "setColorFilter", CustomAnimation.KeyPath.COLOR_FILTER, "Landroid/graphics/ColorFilter;", "setPercentage", "setType", "qqonlinestatus-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class BatteryDrawable extends Drawable {
    static IPatchRedirector $redirector_;

    @Nullable
    private Bitmap bitmap;
    private int percent;

    @NotNull
    private final OnlineBatteryProducer producer;
    private int type;

    public BatteryDrawable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.producer = new OnlineBatteryProducer();
            this.percent = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0027, code lost:
    
        if (r1 == false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void drawBatteryToBitmap() {
        boolean z16;
        Bitmap bitmap = this.bitmap;
        if (bitmap != null) {
            boolean z17 = true;
            if (bitmap != null && bitmap.getWidth() == this.producer.width) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                Bitmap bitmap2 = this.bitmap;
                if (bitmap2 == null || bitmap2.getHeight() != this.producer.height) {
                    z17 = false;
                }
            }
        }
        OnlineBatteryProducer onlineBatteryProducer = this.producer;
        this.bitmap = Bitmap.createBitmap(onlineBatteryProducer.width, onlineBatteryProducer.height, Bitmap.Config.ARGB_8888);
        if (this.bitmap != null) {
            Bitmap bitmap3 = this.bitmap;
            Intrinsics.checkNotNull(bitmap3);
            this.producer.draw(new Canvas(bitmap3), this.percent);
        }
    }

    @Nullable
    public final Drawable customMute() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Drawable) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        if (this.bitmap == null) {
            return null;
        }
        return new BitmapDrawable(this.bitmap);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Bitmap bitmap = this.bitmap;
        if (bitmap != null) {
            boolean z16 = false;
            if (bitmap != null && bitmap.isRecycled()) {
                z16 = true;
            }
            if (!z16) {
                Bitmap bitmap2 = this.bitmap;
                Intrinsics.checkNotNull(bitmap2);
                canvas.drawBitmap(bitmap2, (Rect) null, getBounds(), this.producer.getPaint());
            }
        }
    }

    @NotNull
    public final OnlineBatteryProducer getBatteryProducer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (OnlineBatteryProducer) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.producer;
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated(message = "Deprecated in Java", replaceWith = @ReplaceWith(expression = "PixelFormat.TRANSLUCENT", imports = {"android.graphics.PixelFormat"}))
    public int getOpacity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return -3;
    }

    public final void getSelfPercent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            BatteryDrawableKt.runOnSubThread(new Function0<Unit>() { // from class: com.tencent.widget.BatteryDrawable$getSelfPercent$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BatteryDrawable.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Bitmap bitmap;
                    int i3;
                    Bitmap bitmap2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    int localBatteryCapacity = ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).getLocalBatteryCapacity();
                    bitmap = BatteryDrawable.this.bitmap;
                    if (bitmap != null) {
                        i3 = BatteryDrawable.this.percent;
                        if (localBatteryCapacity == i3) {
                            bitmap2 = BatteryDrawable.this.bitmap;
                            boolean z16 = false;
                            if (bitmap2 != null && !bitmap2.isRecycled()) {
                                z16 = true;
                            }
                            if (z16) {
                                return;
                            }
                        }
                    }
                    BatteryDrawable.this.percent = localBatteryCapacity;
                    BatteryDrawableKt.runOnUI(new Function0<Unit>() { // from class: com.tencent.widget.BatteryDrawable$getSelfPercent$1.1
                        static IPatchRedirector $redirector_;

                        {
                            super(0);
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) BatteryDrawable.this);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            } else {
                                BatteryDrawable.this.drawBatteryToBitmap();
                                BatteryDrawable.this.invalidateSelf();
                            }
                        }
                    });
                }
            });
        } else {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, alpha);
        } else {
            this.producer.getPaint().setAlpha(alpha);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) colorFilter);
        } else {
            this.producer.getPaint().setColorFilter(colorFilter);
        }
    }

    public final void setPercentage(int percent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, percent);
        } else {
            this.percent = percent;
            drawBatteryToBitmap();
        }
    }

    public final void setType(int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, type);
        } else {
            this.type = type;
            this.producer.init(type);
        }
    }
}
