package com.tencent.ams.mosaic.jsengine.component.imagegallery;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.mosaic.jsengine.a;
import com.tencent.ams.mosaic.jsengine.component.BasicComponent;
import com.tencent.ams.mosaic.jsengine.component.imagegallery.ImageGalleryView;
import com.tencent.ams.mosaic.utils.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ImageGalleryComponentImpl extends BasicComponent implements ImageGalleryComponent, ImageGalleryView.b, ViewPager.OnPageChangeListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final ImageGalleryView f71208d;

    /* renamed from: e, reason: collision with root package name */
    private JSFunction f71209e;

    /* renamed from: f, reason: collision with root package name */
    private JSFunction f71210f;

    public ImageGalleryComponentImpl(Context context, String str, float f16, float f17) {
        super(context, str, f16, f17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        ImageGalleryView imageGalleryView = new ImageGalleryView(context);
        this.f71208d = imageGalleryView;
        imageGalleryView.setOnItemClickListener(this);
        imageGalleryView.setOnPageChangeListener(this);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase, com.tencent.ams.mosaic.jsengine.component.Component
    public void commit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        } else {
            this.f71208d.g();
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    @NonNull
    public View getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f71208d;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.imagegallery.ImageGalleryView.b
    public void onItemClick(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3);
        } else if (this.f71209e != null) {
            getJSEngine().u(this.f71209e, new Object[]{Integer.valueOf(i3)}, null);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
            return;
        }
        f.a("ImageGalleryComponentImpl", "onPageScrollStateChanged state:" + i3);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i3, float f16, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), Float.valueOf(f16), Integer.valueOf(i16));
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
            return;
        }
        f.a("ImageGalleryComponentImpl", "onPageSelected position:" + i3);
        if (this.f71210f != null) {
            getJSEngine().u(this.f71210f, new Object[]{Integer.valueOf(i3)}, null);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.imagegallery.ImageGalleryComponent
    public void scrollToPage(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Boolean.valueOf(z16));
        } else {
            this.f71208d.k(i3, z16);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.imagegallery.ImageGalleryComponent
    public void setAnimationType(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            this.f71208d.setAnimationType(str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.imagegallery.ImageGalleryComponent
    public void setAutoScroll(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
        } else {
            this.f71208d.setAutoScroll(z16);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.imagegallery.ImageGalleryComponent
    public void setAutoScrollInterval(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        } else {
            this.f71208d.setAutoScrollInterval(i3);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.imagegallery.ImageGalleryComponent
    public void setInfiniteLoop(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
        } else {
            this.f71208d.setInfiniteLoop(z16);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase, com.tencent.ams.mosaic.jsengine.component.Component
    public void setJSEngine(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        } else {
            super.setJSEngine(aVar);
            this.f71208d.setImageLoader(getImageLoader());
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.imagegallery.ImageGalleryComponent
    public void setPageClickListener(JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) jSFunction);
        } else {
            this.f71209e = jSFunction;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.imagegallery.ImageGalleryComponent
    public void setPageMargin(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Float.valueOf(f16));
        } else {
            this.f71208d.setPageMargin(Utils.dp2px(f16));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.imagegallery.ImageGalleryComponent
    public void setPageSelectedListener(JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) jSFunction);
        } else {
            this.f71210f = jSFunction;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.imagegallery.ImageGalleryComponent
    public void setScaleType(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
        } else {
            this.f71208d.setScaleType(str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.imagegallery.ImageGalleryComponent
    public void setSideExposeWidth(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Float.valueOf(f16));
        } else {
            this.f71208d.setSideExposeWidth(Utils.dp2px(f16));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.imagegallery.ImageGalleryComponent
    public void setSrcList(String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) strArr);
        } else {
            this.f71208d.setSrcList(strArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase
    public String tag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "ImageGalleryComponentImpl";
    }
}
