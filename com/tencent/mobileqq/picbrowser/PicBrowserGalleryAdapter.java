package com.tencent.mobileqq.picbrowser;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.galleryactivity.d;
import com.tencent.mobileqq.nearby.h;
import com.tencent.mobileqq.picbrowser.PicBrowserImage;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Gallery;

/* loaded from: classes16.dex */
public class PicBrowserGalleryAdapter extends d implements PicBrowserImage.b {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private Context f258897f;

    /* renamed from: h, reason: collision with root package name */
    private Handler f258898h;

    /* renamed from: i, reason: collision with root package name */
    private PicBrowserImage.b f258899i;

    public PicBrowserGalleryAdapter(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.f258898h = new Handler();
            this.f258897f = context;
        }
    }

    @Override // com.tencent.mobileqq.picbrowser.PicBrowserImage.b
    public void D0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        int netWorkType = HttpUtil.getNetWorkType();
        if (netWorkType != 1 && netWorkType != 4) {
            return;
        }
        PicBrowserImage picBrowserImage = (PicBrowserImage) getItem(i3 + 1);
        if (picBrowserImage != null) {
            picBrowserImage.g();
        }
        PicBrowserImage picBrowserImage2 = (PicBrowserImage) getItem(i3 - 1);
        if (picBrowserImage2 != null) {
            picBrowserImage2.g();
        }
    }

    @Override // com.tencent.common.galleryactivity.d
    public void I0(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.f258898h.post(new Runnable(i3, i16) { // from class: com.tencent.mobileqq.picbrowser.PicBrowserGalleryAdapter.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f258900d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f258901e;

                {
                    this.f258900d = i3;
                    this.f258901e = i16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, PicBrowserGalleryAdapter.this, Integer.valueOf(i3), Integer.valueOf(i16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        PicBrowserGalleryAdapter.super.I0(this.f258900d, this.f258901e);
                        if (PicBrowserGalleryAdapter.this.f258899i != null) {
                            PicBrowserGalleryAdapter.this.f258899i.I0(this.f258900d, this.f258901e);
                            return;
                        }
                        return;
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
        }
    }

    @Override // com.tencent.common.galleryactivity.d
    public void c(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, i3);
            return;
        }
        PicBrowserImage picBrowserImage = (PicBrowserImage) getItem(i3);
        if (picBrowserImage != null) {
            picBrowserImage.j(view, i3, this);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            c16 = (View) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), view, viewGroup);
        } else if (view != null) {
            c16 = view;
        } else {
            PicBrowserImage picBrowserImage = (PicBrowserImage) getItem(i3);
            if (picBrowserImage == null) {
                c16 = null;
            } else {
                PicInfo picInfo = picBrowserImage.f258907e;
                Context context = this.f258897f;
                if ((context instanceof PicBrowserActivity) && ((PicBrowserActivity) context).f258891b0) {
                    h.b(((PicBrowserActivity) context).app).i(picInfo.f258917e);
                }
                c16 = picBrowserImage.c(i3, this.f258898h, this);
                c16.setTag(Gallery.ID_CHILD_ROTATEABLE, Boolean.TRUE);
            }
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return c16;
    }

    public void j(PicBrowserImage.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
        } else {
            this.f258899i = bVar;
        }
    }

    @Override // com.tencent.common.galleryactivity.d, com.tencent.mobileqq.picbrowser.PicBrowserImage.b
    public void k2(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Boolean.valueOf(z16));
        } else {
            this.f258898h.post(new Runnable(i3, z16) { // from class: com.tencent.mobileqq.picbrowser.PicBrowserGalleryAdapter.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f258904d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ boolean f258905e;

                {
                    this.f258904d = i3;
                    this.f258905e = z16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, PicBrowserGalleryAdapter.this, Integer.valueOf(i3), Boolean.valueOf(z16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        PicBrowserGalleryAdapter.super.k2(this.f258904d, this.f258905e);
                        if (PicBrowserGalleryAdapter.this.f258899i != null) {
                            PicBrowserGalleryAdapter.this.f258899i.k2(this.f258904d, this.f258905e);
                            return;
                        }
                        return;
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
        }
    }

    @Override // com.tencent.common.galleryactivity.d
    public void q(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.f258898h.post(new Runnable(i3, i16) { // from class: com.tencent.mobileqq.picbrowser.PicBrowserGalleryAdapter.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f258902d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f258903e;

                {
                    this.f258902d = i3;
                    this.f258903e = i16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, PicBrowserGalleryAdapter.this, Integer.valueOf(i3), Integer.valueOf(i16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        PicBrowserGalleryAdapter.super.q(this.f258902d, this.f258903e);
                        if (PicBrowserGalleryAdapter.this.f258899i != null) {
                            PicBrowserGalleryAdapter.this.f258899i.q(this.f258902d, this.f258903e);
                            return;
                        }
                        return;
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
        }
    }
}
