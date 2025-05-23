package com.tencent.mobileqq.mutualmark.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.mutualmark.e;
import com.tencent.mobileqq.mutualmark.info.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MutualMarkIconItemView extends ImageView {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    c f252300d;

    /* renamed from: e, reason: collision with root package name */
    e f252301e;

    /* renamed from: f, reason: collision with root package name */
    URLDrawable f252302f;

    /* renamed from: h, reason: collision with root package name */
    int f252303h;

    /* renamed from: i, reason: collision with root package name */
    int f252304i;

    /* renamed from: m, reason: collision with root package name */
    URLDrawable.URLDrawableListener f252305m;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements URLDrawable.URLDrawableListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MutualMarkIconItemView.this);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) uRLDrawable);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) uRLDrawable, (Object) th5);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) uRLDrawable, i3);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) uRLDrawable);
                return;
            }
            MutualMarkIconItemView mutualMarkIconItemView = MutualMarkIconItemView.this;
            URLDrawable uRLDrawable2 = mutualMarkIconItemView.f252302f;
            if (uRLDrawable2 != null) {
                mutualMarkIconItemView.d(uRLDrawable2.getIntrinsicWidth(), MutualMarkIconItemView.this.f252302f.getIntrinsicHeight());
            }
        }
    }

    public MutualMarkIconItemView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f252303h = ViewUtils.dip2px(16.0f);
        this.f252304i = 0;
        this.f252305m = new a();
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        e eVar = this.f252301e;
        if (eVar != null) {
            eVar.b();
        }
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        if (this.f252302f != null) {
            int i3 = this.f252304i;
            if (i3 == 0) {
                return this.f252303h;
            }
            return i3;
        }
        e eVar = this.f252301e;
        if (eVar != null) {
            return eVar.getIntrinsicWidth();
        }
        return getMeasuredWidth();
    }

    public long c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Long) iPatchRedirector.redirect((short) 10, (Object) this)).longValue();
        }
        c cVar = this.f252300d;
        if (cVar != null) {
            return cVar.f252085a;
        }
        return 0L;
    }

    void d(int i3, int i16) {
        if (i16 > 0 && i3 > 0) {
            int i17 = this.f252303h;
            i3 = (i3 * i17) / i16;
            i16 = i17;
        }
        if (i3 > 0 && i16 > 0) {
            this.f252304i = i3;
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            layoutParams.width = i3;
            layoutParams.height = i16;
        }
    }

    public URLDrawable e(String str, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (URLDrawable) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) context);
        }
        int dip2px = ViewUtils.dip2px(16.0f);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        ColorDrawable colorDrawable = new ColorDrawable(0);
        colorDrawable.setBounds(0, 0, 0, dip2px);
        obtain.mUseApngImage = true;
        obtain.mLoadingDrawable = colorDrawable;
        obtain.mFailedDrawable = colorDrawable;
        URLDrawable drawable = URLDrawable.getDrawable(str, obtain);
        this.f252302f = drawable;
        drawable.setBounds(0, 0, dip2px, dip2px);
        this.f252302f.setTargetDensity(context.getResources().getDisplayMetrics().densityDpi / 2);
        this.f252302f.setURLDrawableListener(this.f252305m);
        if (1 != this.f252302f.getStatus()) {
            this.f252302f.setAutoDownload(true);
            this.f252302f.startDownload(true);
        } else {
            d(this.f252302f.getIntrinsicWidth(), this.f252302f.getIntrinsicHeight());
        }
        return this.f252302f;
    }

    public void f(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            return;
        }
        e eVar = this.f252301e;
        if (eVar != null) {
            eVar.e(str);
        }
    }

    public void setIconAlpha(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Float.valueOf(f16));
        } else {
            a();
            setAlpha(f16);
        }
    }

    public void setIconResource(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) cVar);
            return;
        }
        if (this.f252300d == cVar) {
            return;
        }
        this.f252300d = cVar;
        if (!TextUtils.isEmpty(cVar.f252106v) && cVar.f252107w == 1) {
            e(cVar.f252106v, getContext());
            this.f252301e = null;
            setImageDrawable(this.f252302f);
        } else {
            if (!TextUtils.isEmpty(cVar.f252103s) && cVar.f252107w == 0) {
                e eVar = new e(getContext(), cVar.f252103s);
                this.f252301e = eVar;
                this.f252302f = null;
                setImageDrawable(eVar);
                return;
            }
            if (cVar.f252101q != 0 && cVar.f252107w == 0) {
                e eVar2 = new e(getContext(), cVar.f252101q);
                this.f252301e = eVar2;
                this.f252302f = null;
                setImageDrawable(eVar2);
            }
        }
    }

    public MutualMarkIconItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f252303h = ViewUtils.dip2px(16.0f);
        this.f252304i = 0;
        this.f252305m = new a();
    }

    public MutualMarkIconItemView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f252303h = ViewUtils.dip2px(16.0f);
        this.f252304i = 0;
        this.f252305m = new a();
    }
}
