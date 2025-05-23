package com.tencent.ams.mosaic.jsengine.component.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.ams.mosaic.jsengine.component.image.CustomImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class FastCustomImageView extends CustomImageView {
    static IPatchRedirector $redirector_;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f71145c0;

    /* renamed from: d0, reason: collision with root package name */
    private float f71146d0;

    public FastCustomImageView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.f71145c0 = true;
        }
    }

    private com.tencent.ams.mosaic.jsengine.component.image.drawable.e p(Bitmap bitmap) {
        com.tencent.ams.mosaic.jsengine.component.image.drawable.e a16 = com.tencent.ams.mosaic.jsengine.component.image.drawable.f.a(getResources(), bitmap);
        float f16 = this.f71146d0;
        if (f16 > 0.0f) {
            a16.e(f16);
            com.tencent.ams.mosaic.utils.f.e("FastCustomImageView", "createRoundedBitmapDrawable cornerRadius:" + this.f71146d0);
        }
        int i3 = this.U;
        if (i3 != 0) {
            a16.setColorFilter(i3, PorterDuff.Mode.SRC_ATOP);
            com.tencent.ams.mosaic.utils.f.e("FastCustomImageView", "createRoundedBitmapDrawable maskColor:" + this.U);
        }
        return a16;
    }

    private boolean r() {
        if (this.f71146d0 == 0.0f) {
            float f16 = this.Q;
            if (f16 > 0.0f || this.R > 0.0f || this.S > 0.0f || this.T > 0.0f) {
                float f17 = this.R;
                if (f16 == f17) {
                    float f18 = this.T;
                    if (f17 != f18 || f18 != this.S) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return this.f71145c0;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.CustomImageView, android.view.View
    public void invalidate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            q();
            super.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.component.image.CustomImageView
    public void l(Canvas canvas, @NonNull CustomImageView.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) canvas, (Object) aVar);
        } else if (r()) {
            aVar.a(canvas);
            i(canvas);
        } else {
            super.l(canvas, aVar);
        }
    }

    public void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        Drawable drawable = getDrawable();
        if (drawable instanceof com.tencent.ams.mosaic.jsengine.component.image.drawable.e) {
            com.tencent.ams.mosaic.jsengine.component.image.drawable.e eVar = (com.tencent.ams.mosaic.jsengine.component.image.drawable.e) drawable;
            float f16 = this.f71146d0;
            if (f16 > 0.0f) {
                eVar.e(f16);
                com.tencent.ams.mosaic.utils.f.e("FastCustomImageView", "invalidateDrawable cornerRadius:" + this.f71146d0);
            }
            int i3 = this.U;
            if (i3 != 0) {
                eVar.setColorFilter(i3, PorterDuff.Mode.SRC_ATOP);
                com.tencent.ams.mosaic.utils.f.e("FastCustomImageView", "invalidateDrawable maskColor:" + this.U);
            }
        }
    }

    public void setEnableFastDraw(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("FastCustomImageView", "setEnableFastDraw: " + z16);
        this.f71145c0 = z16;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.CustomImageView, android.widget.ImageView, com.tencent.ams.mosaic.jsengine.component.image.c
    public void setImageBitmap(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) bitmap);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("FastCustomImageView", "setImageBitmap");
        if (r()) {
            com.tencent.ams.mosaic.jsengine.component.image.drawable.e a16 = com.tencent.ams.mosaic.jsengine.component.image.drawable.f.a(getResources(), bitmap);
            float f16 = this.f71146d0;
            if (f16 > 0.0f) {
                a16.e(f16);
                com.tencent.ams.mosaic.utils.f.e("FastCustomImageView", "setImageBitmap cornerRadius:" + this.f71146d0);
            }
            int i3 = this.U;
            if (i3 != 0) {
                a16.setColorFilter(i3, PorterDuff.Mode.SRC_ATOP);
                com.tencent.ams.mosaic.utils.f.e("FastCustomImageView", "setImageBitmap maskColor:" + this.U);
            }
            super.setImageDrawable(p(bitmap));
            return;
        }
        super.setImageBitmap(bitmap);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.CustomImageView, android.widget.ImageView, com.tencent.ams.mosaic.jsengine.component.image.c
    public void setImageDrawable(@Nullable Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) drawable);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("FastCustomImageView", "setImageDrawable mEnableFastDraw:" + this.f71145c0);
        if (r() && (drawable instanceof BitmapDrawable)) {
            com.tencent.ams.mosaic.utils.f.e("FastCustomImageView", "setImageDrawable use rounded bitmap drawable");
            super.setImageDrawable(p(((BitmapDrawable) drawable).getBitmap()));
        } else {
            com.tencent.ams.mosaic.utils.f.h("FastCustomImageView", "not BitmapDrawable or not enable fast draw");
            super.setImageDrawable(drawable);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.CustomImageView, com.tencent.ams.mosaic.jsengine.component.image.c
    public void setRadius(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16));
        } else {
            this.f71146d0 = f16;
            super.setRadius(f16);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.image.CustomImageView, com.tencent.ams.mosaic.jsengine.component.image.c
    public void setRadius(float f16, float f17, float f18, float f19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
            return;
        }
        if (f16 == f17 && f17 == f18 && f18 == f19) {
            this.f71146d0 = f16;
        }
        super.setRadius(f16, f17, f18, f19);
    }
}
