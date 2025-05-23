package com.tencent.mobileqq.activity.photo.album.preview.view;

import android.content.Context;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.constant.Constants;
import com.tencent.sharpP.SharpPUtils;

/* loaded from: classes10.dex */
public class WebPreviewPictureView extends b {
    static IPatchRedirector $redirector_;

    /* loaded from: classes10.dex */
    class a implements URLDrawable.URLDrawableListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) WebPreviewPictureView.this);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                WebPreviewPictureView.this.d(uRLDrawable);
            } else {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) uRLDrawable);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                WebPreviewPictureView.this.d(uRLDrawable);
            } else {
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
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                WebPreviewPictureView.this.d(uRLDrawable);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) uRLDrawable);
            }
        }
    }

    public WebPreviewPictureView(Context context, com.tencent.mobileqq.activity.photo.album.preview.presenter.b bVar) {
        super(context, bVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(URLDrawable uRLDrawable) {
        this.f184359f.post(new Runnable(uRLDrawable) { // from class: com.tencent.mobileqq.activity.photo.album.preview.view.WebPreviewPictureView.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ URLDrawable f184355d;

            {
                this.f184355d = uRLDrawable;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) WebPreviewPictureView.this, (Object) uRLDrawable);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                WebPreviewPictureView.this.f184359f.setImageDrawable(this.f184355d);
                WebPreviewPictureView webPreviewPictureView = WebPreviewPictureView.this;
                webPreviewPictureView.f184359f.initDrawable(this.f184355d, webPreviewPictureView.mScreenWidthPx, webPreviewPictureView.mScreenHeightPx, 0);
                if (QLog.isColorLevel()) {
                    QLog.d("QQAlbum", 2, "mScreenWidthPx\uff1a" + WebPreviewPictureView.this.mScreenWidthPx + "\uff0cmScreenHeightPx\uff1a" + WebPreviewPictureView.this.mScreenHeightPx + "\uff0cgetIntrinsicWidth\uff1a" + this.f184355d.getIntrinsicWidth() + "\uff0cgetIntrinsicHeight\uff1a" + this.f184355d.getIntrinsicHeight());
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.activity.photo.album.preview.view.b, com.tencent.richmediabrowser.view.BrowserBaseView
    public void bindView(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
            return;
        }
        String j3 = this.f184358e.j(i3);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = this.mScreenWidthPx;
        obtain.mRequestHeight = this.mScreenHeightPx;
        obtain.mLoadingDrawable = Constants.TRANSPARENT;
        String webpUrl = SharpPUtils.getWebpUrl(j3);
        URLDrawable drawable = URLDrawable.getDrawable(webpUrl, obtain);
        if (drawable == null) {
            QLog.w("QQAlbum", 2, "WebPreviewPictureView drawable == null");
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "WebPreviewPictureView url:" + webpUrl);
        }
        drawable.setURLDrawableListener(new a());
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "drawable.getStatus()\uff1a" + drawable.getStatus());
        }
        if (drawable.getStatus() == 1) {
            d(drawable);
        } else {
            drawable.startDownload();
        }
    }
}
