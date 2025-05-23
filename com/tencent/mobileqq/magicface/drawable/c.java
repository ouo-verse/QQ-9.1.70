package com.tencent.mobileqq.magicface.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.magicface.drawable.PngGifEngine;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c extends Drawable implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private int f243309d;

    /* renamed from: e, reason: collision with root package name */
    private a f243310e;

    /* renamed from: f, reason: collision with root package name */
    private PngGifEngine f243311f;

    /* renamed from: h, reason: collision with root package name */
    private Bitmap f243312h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static final class a extends Drawable.ConstantState {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        String[] f243313a;

        /* renamed from: b, reason: collision with root package name */
        String[] f243314b;

        /* renamed from: c, reason: collision with root package name */
        int f243315c;

        /* renamed from: d, reason: collision with root package name */
        int f243316d;

        /* renamed from: e, reason: collision with root package name */
        int f243317e;

        /* renamed from: f, reason: collision with root package name */
        boolean f243318f;

        /* renamed from: g, reason: collision with root package name */
        Paint f243319g;

        /* renamed from: h, reason: collision with root package name */
        Shader.TileMode f243320h;

        /* renamed from: i, reason: collision with root package name */
        Shader.TileMode f243321i;

        /* renamed from: j, reason: collision with root package name */
        int f243322j;

        public a(e eVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) eVar);
                return;
            }
            this.f243317e = 119;
            this.f243319g = new Paint(6);
            this.f243320h = null;
            this.f243321i = null;
            this.f243322j = 160;
            if (eVar == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("PngFrameDrawable", 2, "\u3010ramdom magic\u3011 png frame param is null.");
                }
                throw new IllegalArgumentException("\u3010ramdom magic\u3011 png frame param is null.");
            }
            this.f243313a = eVar.f243327e;
            this.f243314b = eVar.f243328f;
            this.f243315c = eVar.f243325c;
            this.f243316d = eVar.f243324b;
            this.f243318f = eVar.f243329g;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new c(this, (Resources) null) : (Drawable) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Drawable) iPatchRedirector.redirect((short) 3, (Object) this, (Object) resources);
            }
            if (QLog.isColorLevel()) {
                QLog.d("PngFrameDrawable", 2, "func newDrawable");
            }
            return new c(this, resources);
        }
    }

    public c(e eVar, Resources resources) {
        this(new a(eVar), resources);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) eVar, (Object) resources);
    }

    private void c() {
        if (QLog.isColorLevel()) {
            QLog.d("PngFrameDrawable", 2, "func initGifEngine");
        }
        PngGifEngine.a aVar = new PngGifEngine.a();
        aVar.f243308e = this;
        a aVar2 = this.f243310e;
        aVar.f243304a = aVar2.f243316d;
        aVar.f243305b = aVar2.f243315c;
        if (!aVar2.f243318f) {
            aVar.f243306c = null;
        } else {
            aVar.f243306c = aVar2.f243313a;
        }
        PngGifEngine pngGifEngine = new PngGifEngine();
        this.f243311f = pngGifEngine;
        pngGifEngine.e(aVar);
    }

    @Override // com.tencent.mobileqq.magicface.drawable.b
    public void a(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) bitmap);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PngFrameDrawable", 2, "func onBitmapReady,bitmap:" + bitmap);
        }
        if (bitmap == null) {
            return;
        }
        Bitmap bitmap2 = this.f243312h;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.f243312h.recycle();
        }
        this.f243312h = bitmap;
        invalidateSelf();
    }

    public Bitmap b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Bitmap) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.f243312h;
    }

    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        Bitmap bitmap = this.f243312h;
        if (bitmap != null && !bitmap.isRecycled()) {
            return true;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) canvas);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PngFrameDrawable", 2, "func draw,bitmap:" + this.f243312h);
        }
        Bitmap bitmap = this.f243312h;
        if (bitmap != null && !bitmap.isRecycled()) {
            canvas.drawBitmap(this.f243312h, (Rect) null, getBounds(), this.f243310e.f243319g);
        }
    }

    public void e(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
            return;
        }
        PngGifEngine pngGifEngine = this.f243311f;
        if (pngGifEngine == null) {
            return;
        }
        String[] strArr = this.f243310e.f243314b;
        if (strArr != null && i3 >= 0 && i3 < strArr.length) {
            pngGifEngine.d(strArr[i3]);
        }
        this.f243311f.f();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Drawable.ConstantState) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.f243310e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else if (i3 != this.f243310e.f243319g.getAlpha()) {
            this.f243310e.f243319g.setAlpha(i3);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) colorFilter);
        } else {
            this.f243310e.f243319g.setColorFilter(colorFilter);
            invalidateSelf();
        }
    }

    c(a aVar, Resources resources) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) aVar, (Object) resources);
            return;
        }
        this.f243310e = aVar;
        if (resources != null) {
            this.f243309d = resources.getDisplayMetrics().densityDpi;
        } else {
            this.f243309d = aVar.f243322j;
        }
        c();
    }
}
