package com.tencent.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes27.dex */
public class LayerImageView extends ImageView {
    static IPatchRedirector $redirector_;
    private boolean C;

    /* renamed from: d, reason: collision with root package name */
    private a[] f384613d;

    /* renamed from: e, reason: collision with root package name */
    private Bitmap f384614e;

    /* renamed from: f, reason: collision with root package name */
    private Bitmap.Config f384615f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f384616h;

    /* renamed from: i, reason: collision with root package name */
    private Paint f384617i;

    /* renamed from: m, reason: collision with root package name */
    private int f384618m;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private Bitmap f384619a;

        /* renamed from: b, reason: collision with root package name */
        private Rect f384620b;

        /* renamed from: c, reason: collision with root package name */
        private int f384621c;

        /* renamed from: d, reason: collision with root package name */
        private int f384622d;

        /* renamed from: e, reason: collision with root package name */
        private int f384623e;

        /* renamed from: f, reason: collision with root package name */
        private Bitmap.Config f384624f;

        a(Bitmap bitmap, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) bitmap, i3);
                return;
            }
            this.f384619a = bitmap;
            this.f384620b = new Rect(0, 0, 0, 0);
            if (bitmap != null) {
                this.f384622d = bitmap.getScaledWidth(i3);
                this.f384623e = bitmap.getScaledHeight(i3);
                this.f384621c = 0;
                this.f384624f = bitmap.getConfig();
                return;
            }
            this.f384621c = 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(Rect rect) {
            this.f384620b.set(rect);
        }
    }

    public LayerImageView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void a() {
        this.f384616h = false;
        this.f384617i = new Paint();
        this.f384618m = getResources().getDisplayMetrics().densityDpi;
        this.C = false;
    }

    private void b() {
        this.f384616h = true;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            super.onMeasure(i3, i16);
        }
    }

    public void setBitmaps(Bitmap[] bitmapArr, boolean z16) {
        a[] aVarArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, bitmapArr, Boolean.valueOf(z16));
            return;
        }
        if (z16 && (aVarArr = this.f384613d) != null) {
            for (a aVar : aVarArr) {
                if (aVar.f384619a != null) {
                    aVar.f384619a.recycle();
                }
            }
        }
        this.f384613d = new a[bitmapArr.length];
        for (int i3 = 0; i3 < bitmapArr.length; i3++) {
            this.f384613d[i3] = new a(bitmapArr[i3], this.f384618m);
            if (this.f384615f == null || (this.f384613d[i3].f384624f != null && this.f384613d[i3].f384624f.ordinal() > this.f384615f.ordinal())) {
                this.f384615f = this.f384613d[i3].f384624f;
            }
        }
        b();
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) bitmap);
            return;
        }
        super.setImageBitmap(bitmap);
        this.f384616h = false;
        this.f384614e = bitmap;
    }

    public void setLayerBitmap(int i3, Bitmap bitmap, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), bitmap, Boolean.valueOf(z16));
            return;
        }
        a[] aVarArr = this.f384613d;
        a aVar = aVarArr[i3];
        aVarArr[i3] = new a(bitmap, this.f384618m);
        if (z16 && aVar.f384619a != null) {
            aVar.f384619a.recycle();
        }
    }

    public void setLayerPadding(Rect[] rectArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) rectArr);
            return;
        }
        if (rectArr.length != this.f384613d.length) {
            throw new IllegalArgumentException("padding must have the same size as input bitmaps");
        }
        int i3 = 0;
        while (true) {
            a[] aVarArr = this.f384613d;
            if (i3 < aVarArr.length) {
                aVarArr[i3].e(rectArr[i3]);
                i3++;
            } else {
                b();
                return;
            }
        }
    }

    public void setLayerVisibility(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            this.f384613d[i3].f384621c = i16;
            b();
        } else {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    public void setNeedTransparent(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
        } else {
            this.C = z16;
        }
    }

    public LayerImageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public LayerImageView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            a();
        } else {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        }
    }

    public void setLayerPadding(int i3, Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3, (Object) rect);
        } else {
            this.f384613d[i3].e(rect);
            b();
        }
    }
}
