package com.tencent.mobileqq.activity.photo.album.preview.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.image.RegionDrawableData;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.view.BrowserBaseView;
import com.tencent.richmediabrowser.view.recyclerview.BrowserScaleView;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b extends BrowserBaseView implements e04.c {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private Map<String, URLDrawable> f184357d;

    /* renamed from: e, reason: collision with root package name */
    protected com.tencent.mobileqq.activity.photo.album.preview.presenter.b f184358e;

    /* renamed from: f, reason: collision with root package name */
    protected BrowserScaleView f184359f;

    /* renamed from: h, reason: collision with root package name */
    URLDrawable f184360h;

    /* renamed from: i, reason: collision with root package name */
    int f184361i;

    public b(Context context, com.tencent.mobileqq.activity.photo.album.preview.presenter.b bVar) {
        super(context, bVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) bVar);
            return;
        }
        this.f184357d = new HashMap();
        this.f184361i = -1;
        this.f184358e = bVar;
    }

    private String a() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("(preview) Actives: ");
        Iterator<String> it = this.f184357d.keySet().iterator();
        while (it.hasNext()) {
            sb5.append(it.next() + " ");
        }
        return sb5.toString();
    }

    private void b(int i3, BrowserScaleView browserScaleView, URL url) {
        if (i3 == this.f184361i && this.f184360h != null) {
            if (QLog.isColorLevel() && this.f184360h != null) {
                QLog.d("QQAlbum", 2, "use exist raw drawable");
                return;
            }
            return;
        }
        if (QLog.isColorLevel() && this.f184360h != null) {
            QLog.d("QQAlbum", 2, "rawDrawable is exist");
        }
        String str = url.toString() + "#NOSAMPLE";
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mUseExifOrientation = false;
        obtain.mUseMemoryCache = false;
        URLDrawable drawable = URLDrawable.getDrawable(str, obtain);
        drawable.setTag(2);
        this.f184360h = null;
        this.f184361i = i3;
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "create rawDrawable, position:" + i3);
        }
        if (drawable.getStatus() == 1) {
            browserScaleView.ignoreLayout = true;
            browserScaleView.setImageDrawable(drawable);
            browserScaleView.ignoreLayout = false;
        }
    }

    @Override // com.tencent.richmediabrowser.view.BrowserBaseView
    public void bindView(int i3) {
        URLDrawable uRLDrawable;
        int status;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        String j3 = this.f184358e.j(i3);
        if (TextUtils.isEmpty(j3)) {
            if (QLog.isColorLevel()) {
                QLog.d("QQAlbum", 2, "bindView path is null, position :" + i3);
                return;
            }
            return;
        }
        File file = new File(j3);
        URLDrawable uRLDrawable2 = this.f184357d.get(j3);
        URL fileUrl = this.f184358e.getFileUrl(new File(j3));
        if (uRLDrawable2 != null && uRLDrawable2.getStatus() == 1 && uRLDrawable2.getURL().equals(fileUrl)) {
            this.f184359f.setImageDrawable(uRLDrawable2);
            this.f184359f.initDrawable(uRLDrawable2, this.mScreenWidthPx, this.mScreenHeightPx, 0);
        } else {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mRequestWidth = this.mScreenWidthPx;
            obtain.mRequestHeight = this.mScreenHeightPx;
            obtain.mLoadingDrawable = new ColorDrawable(0);
            obtain.mPlayGifImage = true;
            URL fileUrl2 = this.f184358e.getFileUrl(file);
            if (fileUrl2 != null) {
                uRLDrawable = URLDrawable.getDrawable(fileUrl2, obtain);
                if (uRLDrawable != null && (status = uRLDrawable.getStatus()) != 1 && status != 2 && status != 3) {
                    uRLDrawable.setTag(1);
                    uRLDrawable.downloadImediatly();
                }
            } else {
                uRLDrawable = null;
            }
            if (uRLDrawable != null) {
                this.f184359f.setImageDrawable(uRLDrawable);
                this.f184359f.initDrawable(uRLDrawable, this.mScreenWidthPx, this.mScreenHeightPx, 0);
                this.f184357d.put(j3, uRLDrawable);
            }
        }
        this.f184359f.setMainBrowserPresenter(this.f184358e.mainBrowserPresenter);
    }

    @Override // com.tencent.richmediabrowser.view.BrowserBaseView
    public View getView(View view, ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) viewGroup);
        }
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(R.layout.f167641dx0, viewGroup, false);
        this.mBrowserItemView = relativeLayout;
        BrowserScaleView browserScaleView = (BrowserScaleView) relativeLayout.findViewById(R.id.f25380ao);
        this.f184359f = browserScaleView;
        browserScaleView.setOnItemEventListener(this);
        return this.mBrowserItemView;
    }

    @Override // com.tencent.richmediabrowser.view.BrowserBaseView, e04.c
    public void onClickEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        com.tencent.mobileqq.activity.photo.album.preview.presenter.b bVar = this.f184358e;
        if (bVar != null) {
            bVar.k();
        }
    }

    @Override // com.tencent.richmediabrowser.view.BrowserBaseView
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        QLog.d("QQAlbum", 1, "PreviewPictureView onDestroy");
        this.f184357d.clear();
        super.onDestroy();
    }

    @Override // com.tencent.richmediabrowser.view.BrowserBaseView
    public void onDestroyView(int i3, View view) {
        String j3;
        URLDrawable uRLDrawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3, (Object) view);
            return;
        }
        super.onDestroyView(i3, view);
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "onDestroyView:" + a());
        }
        com.tencent.mobileqq.activity.photo.album.preview.presenter.b bVar = this.f184358e;
        if (bVar != null && (uRLDrawable = this.f184357d.get((j3 = bVar.j(i3)))) != null) {
            if (uRLDrawable.getStatus() == 0) {
                uRLDrawable.cancelDownload(true);
            }
            this.f184357d.remove(j3);
        }
        if (i3 == this.f184361i) {
            URLDrawable uRLDrawable2 = this.f184360h;
            if (uRLDrawable2 != null && uRLDrawable2.getStatus() == 0) {
                this.f184360h.cancelDownload(true);
            }
            this.f184360h = null;
            this.f184361i = -1;
            if (QLog.isColorLevel()) {
                QLog.d("QQAlbum", 2, "(preview)destory rawDrawable, position: " + i3);
            }
        }
    }

    @Override // com.tencent.richmediabrowser.view.BrowserBaseView
    public void onItemSelected(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            super.onItemSelected(i3);
            bindView(i3);
        }
    }

    @Override // e04.c
    public void onLongClickEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    @Override // com.tencent.richmediabrowser.view.BrowserBaseView, e04.f
    public void onScaleBegin(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
            return;
        }
        Drawable drawable = this.f184359f.getDrawable();
        URLDrawable uRLDrawable = this.f184359f.mDecoding;
        if (drawable instanceof URLDrawable) {
            URLDrawable uRLDrawable2 = (URLDrawable) drawable;
            if (uRLDrawable2.isFakeSize() && uRLDrawable == null) {
                URL url = uRLDrawable2.getURL();
                if ("file".equals(url.getProtocol()) && url.getRef() == null) {
                    b(i3, this.f184359f, url);
                }
            }
        }
    }

    @Override // com.tencent.richmediabrowser.view.BrowserBaseView
    public void onShowAreaChanged(int i3, View view, RegionDrawableData regionDrawableData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), view, regionDrawableData);
        } else {
            if (!ImageView.class.isInstance(view)) {
                return;
            }
            Drawable drawable = ((ImageView) view).getDrawable();
            if (!URLDrawable.class.isInstance(drawable)) {
                return;
            }
            ((URLDrawable) drawable).updateRegionBitmap(regionDrawableData);
        }
    }
}
