package com.tencent.common.galleryactivity;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URL;

/* compiled from: P */
@Deprecated
/* loaded from: classes5.dex */
public class o extends d {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a extends URLDrawableDownListener.Adapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f99887d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ViewGroup f99888e;

        a(int i3, ViewGroup viewGroup) {
            this.f99887d = i3;
            this.f99888e = viewGroup;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, o.this, Integer.valueOf(i3), viewGroup);
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener.Adapter, com.tencent.image.URLDrawableDownListener
        public void onLoadFailed(View view, URLDrawable uRLDrawable, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, view, uRLDrawable, th5);
            } else {
                o.this.k2(this.f99887d, false);
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener.Adapter, com.tencent.image.URLDrawableDownListener
        public void onLoadProgressed(View view, URLDrawable uRLDrawable, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, view, uRLDrawable, Integer.valueOf(i3));
            } else {
                o.this.q(this.f99887d, i3 / 100);
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener.Adapter, com.tencent.image.URLDrawableDownListener
        public void onLoadSuccessed(View view, URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) uRLDrawable);
                return;
            }
            o.this.k2(this.f99887d, true);
            View g16 = o.this.g(uRLDrawable.getURL(), this.f99888e);
            if (g16 != null) {
                o.this.h(g16, uRLDrawable);
            }
        }
    }

    public o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public URLDrawable f(URL url, ViewGroup viewGroup) {
        Drawable.ConstantState constantState;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (URLDrawable) iPatchRedirector.redirect((short) 2, (Object) this, (Object) url, (Object) viewGroup);
        }
        if (url == null) {
            return null;
        }
        String url2 = url.toString();
        for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
            Drawable drawable = ((URLImageView) viewGroup.getChildAt(i3)).getDrawable();
            if (drawable != null && (drawable instanceof URLDrawable)) {
                URLDrawable uRLDrawable = (URLDrawable) drawable;
                if (uRLDrawable.getURL() != null && uRLDrawable.getURL().toString().equals(url2) && (constantState = uRLDrawable.getConstantState()) != null) {
                    return (URLDrawable) constantState.newDrawable(viewGroup.getContext().getResources());
                }
            }
        }
        return null;
    }

    public View g(URL url, ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) url, (Object) viewGroup);
        }
        for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
            URLImageView uRLImageView = (URLImageView) viewGroup.getChildAt(i3);
            Drawable drawable = uRLImageView.getDrawable();
            if (drawable != null && (drawable instanceof URLDrawable)) {
                URLDrawable uRLDrawable = (URLDrawable) drawable;
                if (uRLDrawable.getURL() != null && uRLDrawable.getURL().equals(url)) {
                    return uRLImageView;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v1, types: [android.widget.ImageView, com.tencent.image.URLImageView, android.view.View] */
    /* JADX WARN: Type inference failed for: r9v2 */
    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View view2;
        View view3;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            view2 = view;
            view3 = (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
        } else {
            if (view == 0) {
                view = new URLImageView(viewGroup.getContext());
                view.setAdjustViewBounds(true);
                n nVar = (n) getItem(i3);
                if (nVar != null) {
                    URLDrawable f16 = f(nVar.c(), viewGroup);
                    if (f16 == null) {
                        f16 = (URLDrawable) nVar.getImageDrawable();
                    }
                    view.setImageDrawable(f16);
                    if (f16 != null && f16.getStatus() != 1 && f16.getStatus() != 4 && f16.getStatus() != 2) {
                        int progress = f16.getProgress();
                        view.setURLDrawableDownListener(new a(i3, viewGroup));
                        I0(i3, progress / 100);
                    } else if (f16 != null) {
                        if (f16.getStatus() == 1) {
                            z16 = true;
                        }
                        k2(i3, z16);
                        h(view, f16);
                    }
                }
            }
            view2 = view;
            view3 = view;
        }
        EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
        return view3;
    }

    protected void h(View view, URLDrawable uRLDrawable) {
        throw null;
    }
}
