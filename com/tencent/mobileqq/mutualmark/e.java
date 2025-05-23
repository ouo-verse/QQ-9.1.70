package com.tencent.mobileqq.mutualmark;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: P */
/* loaded from: classes15.dex */
public class e extends Drawable implements Handler.Callback, URLDrawable.URLDrawableListener {
    static IPatchRedirector $redirector_;
    int C;
    int D;
    String E;
    int F;

    /* renamed from: d, reason: collision with root package name */
    Drawable f252029d;

    /* renamed from: e, reason: collision with root package name */
    URLDrawable f252030e;

    /* renamed from: f, reason: collision with root package name */
    Drawable f252031f;

    /* renamed from: h, reason: collision with root package name */
    int f252032h;

    /* renamed from: i, reason: collision with root package name */
    Handler f252033i;

    /* renamed from: m, reason: collision with root package name */
    int f252034m;

    public e(Context context, int i3) {
        this(context, i3, 16.0f);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, i3);
    }

    private Drawable c() {
        Drawable drawable = this.f252031f;
        if (drawable != null) {
            return drawable;
        }
        URLDrawable uRLDrawable = this.f252030e;
        if (uRLDrawable != null) {
            return uRLDrawable;
        }
        Drawable drawable2 = this.f252029d;
        if (drawable2 != null) {
            return drawable2;
        }
        return null;
    }

    public void a(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
            return;
        }
        URLDrawable uRLDrawable = this.f252030e;
        if (uRLDrawable != null) {
            uRLDrawable.setCallback(view);
        }
        setCallback(view);
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(@NonNull Resources.Theme theme) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, (Object) this, (Object) theme);
            return;
        }
        if (c() != null) {
            c().applyTheme(theme);
        }
        super.applyTheme(theme);
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        this.f252034m = 255;
        this.C = 0;
        this.D = 0;
        Handler handler = this.f252033i;
        if (handler != null) {
            handler.removeMessages(0);
            this.f252033i.removeMessages(1);
        }
        setAlpha(this.f252034m);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            return ((Boolean) iPatchRedirector.redirect((short) 54, (Object) this)).booleanValue();
        }
        if (c() != null) {
            return c().canApplyTheme();
        }
        return super.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this);
            return;
        }
        if (c() != null) {
            c().clearColorFilter();
        }
        super.clearColorFilter();
    }

    public URLDrawable d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            return (URLDrawable) iPatchRedirector.redirect((short) 66, (Object) this);
        }
        return this.f252030e;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) canvas);
            return;
        }
        if (c() != null) {
            Rect bounds = c().getBounds();
            if (bounds.width() > 0 && bounds.height() > 0) {
                canvas.saveLayerAlpha(bounds.left, bounds.top, bounds.right, bounds.bottom, this.f252034m);
                c().draw(canvas);
                canvas.restore();
            }
        }
    }

    public void e(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            return;
        }
        if (this.f252033i == null) {
            this.f252033i = new Handler(Looper.getMainLooper(), this);
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.E) && !str.equals(this.E)) {
            b();
        }
        this.E = str;
        Handler handler = this.f252033i;
        if (handler != null && !handler.hasMessages(0)) {
            this.f252033i.sendEmptyMessage(0);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Integer) iPatchRedirector.redirect((short) 35, (Object) this)).intValue();
        }
        return this.f252034m;
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.Callback getCallback() {
        Drawable.Callback callback;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (Drawable.Callback) iPatchRedirector.redirect((short) 29, (Object) this);
        }
        if (c() != null && (callback = c().getCallback()) != null) {
            return callback;
        }
        return super.getCallback();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this)).intValue();
        }
        if (c() != null) {
            return c().getChangingConfigurations();
        }
        return super.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public ColorFilter getColorFilter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return (ColorFilter) iPatchRedirector.redirect((short) 40, (Object) this);
        }
        if (c() != null) {
            return c().getColorFilter();
        }
        return super.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            return (Drawable.ConstantState) iPatchRedirector.redirect((short) 65, (Object) this);
        }
        if (c() != null) {
            return c().getConstantState();
        }
        return super.getConstantState();
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable getCurrent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return (Drawable) iPatchRedirector.redirect((short) 49, (Object) this);
        }
        if (c() != null) {
            return c().getCurrent();
        }
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Rect getDirtyBounds() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (Rect) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        if (c() != null) {
            return c().getDirtyBounds();
        }
        return super.getDirtyBounds();
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(@NonNull Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, (Object) rect);
        } else if (c() != null) {
            c().getHotspotBounds(rect);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            return ((Integer) iPatchRedirector.redirect((short) 57, (Object) this)).intValue();
        }
        if (c() != null) {
            c().getIntrinsicHeight();
            return this.f252032h;
        }
        return super.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            return ((Integer) iPatchRedirector.redirect((short) 56, (Object) this)).intValue();
        }
        if (c() != null) {
            int intrinsicWidth = c().getIntrinsicWidth();
            int intrinsicHeight = c().getIntrinsicHeight();
            if (intrinsicHeight > 0 && intrinsicWidth > 0) {
                return (intrinsicWidth * this.f252032h) / intrinsicHeight;
            }
            return intrinsicWidth;
        }
        return super.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getLayoutDirection() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Integer) iPatchRedirector.redirect((short) 33, (Object) this)).intValue();
        }
        if (c() != null) {
            return c().getLayoutDirection();
        }
        return super.getLayoutDirection();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            return ((Integer) iPatchRedirector.redirect((short) 59, (Object) this)).intValue();
        }
        if (c() != null) {
            int minimumHeight = c().getMinimumHeight();
            if (QLog.isColorLevel()) {
                QLog.i("MutualMarkIconProxyDrawable", 2, "getMinimumHeight height : " + minimumHeight);
            }
            return minimumHeight;
        }
        return super.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            return ((Integer) iPatchRedirector.redirect((short) 58, (Object) this)).intValue();
        }
        if (c() != null) {
            int minimumWidth = c().getMinimumWidth();
            if (QLog.isColorLevel()) {
                QLog.i("MutualMarkIconProxyDrawable", 2, "getMinimumWidth width : " + minimumWidth);
            }
            return minimumWidth;
        }
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(@NonNull Outline outline) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            iPatchRedirector.redirect((short) 61, (Object) this, (Object) outline);
        } else if (c() != null) {
            c().getOutline(outline);
        } else {
            super.getOutline(outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            return ((Boolean) iPatchRedirector.redirect((short) 60, (Object) this, (Object) rect)).booleanValue();
        }
        if (c() != null) {
            return c().getPadding(rect);
        }
        return super.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public int[] getState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return (int[]) iPatchRedirector.redirect((short) 47, (Object) this);
        }
        if (c() != null) {
            return c().getState();
        }
        return super.getState();
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Region getTransparentRegion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return (Region) iPatchRedirector.redirect((short) 55, (Object) this);
        }
        if (c() != null) {
            return c().getTransparentRegion();
        }
        return super.getTransparentRegion();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) message)).booleanValue();
        }
        if (this.f252033i == null) {
            return false;
        }
        int i3 = message.what;
        if (i3 != 0) {
            if (i3 == 1) {
                setAlpha(102);
                invalidateSelf();
            }
        } else {
            int i16 = this.f252034m;
            if (i16 <= 0) {
                this.C = 0;
            } else if (i16 >= 255) {
                this.C = 1;
            }
            if (this.C == 0) {
                int i17 = i16 + 5;
                this.f252034m = i17;
                if (i17 >= 255) {
                    this.f252034m = 255;
                }
            } else {
                int i18 = i16 - 5;
                this.f252034m = i18;
                if (i18 <= 0) {
                    this.f252034m = 0;
                }
            }
            setAlpha(this.f252034m);
            invalidateSelf();
            int i19 = this.f252034m;
            if (i19 == 0) {
                this.D++;
            }
            if (this.D >= 3 && i19 >= this.F) {
                this.f252033i.removeMessages(0);
                this.f252033i.sendEmptyMessage(1);
            } else {
                if (this.f252033i.hasMessages(0)) {
                    this.f252033i.removeMessages(0);
                }
                this.f252033i.sendEmptyMessageDelayed(0, 20);
            }
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(@NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet) throws IOException, XmlPullParserException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            iPatchRedirector.redirect((short) 63, this, resources, xmlPullParser, attributeSet);
            return;
        }
        if (c() != null) {
            c().inflate(resources, xmlPullParser, attributeSet);
        }
        super.inflate(resources, xmlPullParser, attributeSet);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
            return;
        }
        if (c() != null) {
            c().invalidateSelf();
        }
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return ((Boolean) iPatchRedirector.redirect((short) 52, (Object) this)).booleanValue();
        }
        if (c() != null) {
            return c().isAutoMirrored();
        }
        return super.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isFilterBitmap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this)).booleanValue();
        }
        if (c() != null) {
            return c().isFilterBitmap();
        }
        return super.isFilterBitmap();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return ((Boolean) iPatchRedirector.redirect((short) 45, (Object) this)).booleanValue();
        }
        if (c() != null) {
            return c().isStateful();
        }
        return super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this);
            return;
        }
        if (c() != null) {
            c().jumpToCurrentState();
        }
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            return (Drawable) iPatchRedirector.redirect((short) 62, (Object) this);
        }
        Drawable c16 = c();
        if (c16 != null) {
            if (c16 instanceof SkinnableBitmapDrawable) {
                this.f252031f = ((SkinnableBitmapDrawable) c()).mutate2();
            } else if (c16 instanceof URLDrawable) {
                this.f252031f = c16.mutate();
            }
            return this;
        }
        return super.mutate();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Boolean) iPatchRedirector.redirect((short) 34, (Object) this, i3)).booleanValue();
        }
        if (c() != null) {
            return c().onLayoutDirectionChanged(i3);
        }
        return super.onLayoutDirectionChanged(i3);
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadCanceled(URLDrawable uRLDrawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) uRLDrawable);
        }
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) uRLDrawable, (Object) th5);
        }
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) uRLDrawable, i3);
        }
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadSuccessed(URLDrawable uRLDrawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) uRLDrawable);
            return;
        }
        int intrinsicWidth = uRLDrawable.getIntrinsicWidth();
        int intrinsicHeight = uRLDrawable.getIntrinsicHeight();
        if (intrinsicHeight > 0 && intrinsicWidth > 0) {
            int i3 = this.f252032h;
            intrinsicWidth = (intrinsicWidth * i3) / intrinsicHeight;
            intrinsicHeight = i3;
        }
        if (intrinsicWidth > 0 && intrinsicHeight > 0) {
            setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            invalidateSelf();
            if (getCallback() != null && (getCallback() instanceof View)) {
                ((View) getCallback()).invalidate();
                ((View) getCallback()).requestLayout();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(@NonNull Runnable runnable, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, runnable, Long.valueOf(j3));
            return;
        }
        if (c() != null) {
            c().scheduleSelf(runnable, j3);
        }
        super.scheduleSelf(runnable, j3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
        } else {
            this.f252034m = i3;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this, z16);
            return;
        }
        if (c() != null) {
            c().setAutoMirrored(z16);
        }
        super.setAutoMirrored(z16);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        if (c() != null) {
            c().setBounds(i3, i16, i17, i18);
        }
        super.setBounds(i3, i16, i17, i18);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, i3);
            return;
        }
        if (c() != null) {
            c().setChangingConfigurations(i3);
        }
        super.setChangingConfigurations(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) colorFilter);
        } else if (c() != null) {
            c().setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, z16);
            return;
        }
        if (c() != null) {
            c().setDither(z16);
        }
        super.setDither(z16);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, z16);
            return;
        }
        if (c() != null) {
            c().setFilterBitmap(z16);
        }
        super.setFilterBitmap(z16);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, this, Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        if (c() != null) {
            c().setHotspot(f16, f17);
        }
        super.setHotspot(f16, f17);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        if (c() != null) {
            c().setHotspotBounds(i3, i16, i17, i18);
        }
        super.setHotspotBounds(i3, i16, i17, i18);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(@NonNull int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return ((Boolean) iPatchRedirector.redirect((short) 46, (Object) this, (Object) iArr)).booleanValue();
        }
        if (c() != null) {
            return c().setState(iArr);
        }
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, i3);
            return;
        }
        if (c() != null) {
            c().setTint(i3);
        }
        super.setTint(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(@Nullable ColorStateList colorStateList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) colorStateList);
            return;
        }
        if (c() != null) {
            c().setTintList(colorStateList);
        }
        super.setTintList(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(@NonNull PorterDuff.Mode mode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, (Object) mode);
            return;
        }
        if (c() != null) {
            c().setTintMode(mode);
        }
        super.setTintMode(mode);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            return ((Boolean) iPatchRedirector.redirect((short) 50, this, Boolean.valueOf(z16), Boolean.valueOf(z17))).booleanValue();
        }
        if (c() != null) {
            return c().setVisible(z16, z17);
        }
        return super.setVisible(z16, z17);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(@NonNull Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) runnable);
            return;
        }
        if (c() != null) {
            c().unscheduleSelf(runnable);
        }
        super.unscheduleSelf(runnable);
    }

    public e(Context context, int i3, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, Integer.valueOf(i3), Float.valueOf(f16));
            return;
        }
        this.f252032h = 42;
        this.f252034m = 255;
        this.C = 0;
        this.D = 0;
        this.E = "";
        this.F = 102;
        this.f252032h = ViewUtils.dip2px(f16);
        this.f252029d = context.getResources().getDrawable(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i3, @NonNull PorterDuff.Mode mode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, i3, (Object) mode);
            return;
        }
        if (c() != null) {
            c().setColorFilter(i3, mode);
        }
        super.setColorFilter(i3, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(@NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws IOException, XmlPullParserException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            iPatchRedirector.redirect((short) 64, this, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        if (c() != null) {
            c().inflate(resources, xmlPullParser, attributeSet, theme);
        }
        super.inflate(resources, xmlPullParser, attributeSet, theme);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(@NonNull Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) rect);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("MutualMarkIconProxyDrawable", 2, "setBounds bounds : " + rect);
        }
        if (c() != null) {
            c().setBounds(rect);
        }
        super.setBounds(rect);
    }

    public e(Context context, String str) {
        this(context, str, 16.0f);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) str);
    }

    public e(Context context, String str, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, str, Float.valueOf(f16));
            return;
        }
        this.f252032h = 42;
        this.f252034m = 255;
        this.C = 0;
        this.D = 0;
        this.E = "";
        this.F = 102;
        this.f252032h = ViewUtils.dip2px(f16);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        ColorDrawable colorDrawable = new ColorDrawable(0);
        colorDrawable.setBounds(0, 0, 0, this.f252032h);
        obtain.mUseApngImage = true;
        obtain.mLoadingDrawable = colorDrawable;
        obtain.mFailedDrawable = colorDrawable;
        this.f252030e = URLDrawable.getDrawable(str, obtain);
        this.f252030e.setTargetDensity(context.getResources().getDisplayMetrics().densityDpi / 2);
        this.f252030e.setURLDrawableListener(this);
        if (1 != this.f252030e.getStatus()) {
            this.f252030e.setAutoDownload(true);
            this.f252030e.startDownload(true);
        }
    }

    public e(Context context, String str, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, context, str, view);
            return;
        }
        this.f252032h = 42;
        this.f252034m = 255;
        this.C = 0;
        this.D = 0;
        this.E = "";
        this.F = 102;
        this.f252032h = ViewUtils.dip2px(16.0f);
        ColorDrawable colorDrawable = new ColorDrawable(0);
        colorDrawable.setBounds(0, 0, 0, this.f252032h);
        this.f252030e = VasApngUtil.getApngURLDrawable(str, VasApngUtil.VIP_APNG_TAGS, colorDrawable, null, this);
        int i3 = context.getResources().getDisplayMetrics().densityDpi / 2;
        URLDrawable uRLDrawable = this.f252030e;
        if (uRLDrawable != null) {
            uRLDrawable.setTargetDensity(i3);
            this.f252030e.setCallback(view);
        }
        setCallback(view);
        if (QLog.isColorLevel()) {
            QLog.i("MutualMarkIconProxyDrawable", 2, "MutualMarkIconProxyDrawable density : " + i3);
        }
    }
}
