package com.tencent.mobileqq.activity.photo.album.preview.presenter;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.album.preview.BasePreviewPresent;
import com.tencent.mobileqq.activity.photo.album.preview.model.PreviewVideoData;
import com.tencent.mobileqq.activity.photo.album.preview.view.PreviewVideoView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import java.io.File;
import java.net.URL;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes10.dex */
public class d extends BasePreviewPresent {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private PreviewVideoView f184345d;

    /* renamed from: e, reason: collision with root package name */
    private HashMap<String, Drawable> f184346e;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f184346e = new HashMap<>();
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.preview.BasePreviewPresent
    public URL getFileUrl(File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (URL) iPatchRedirector.redirect((short) 3, (Object) this, (Object) file);
        }
        if (file == null) {
            return null;
        }
        return QAlbumUtil.generateAlbumVideoThumbURL(file.getPath(), "VIDEO");
    }

    public void j(String str, Drawable drawable) {
        HashMap<String, Drawable> hashMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) drawable);
        } else if (!TextUtils.isEmpty(str) && drawable != null && (hashMap = this.f184346e) != null) {
            hashMap.put(str, drawable);
        }
    }

    public Drawable k(String str) {
        HashMap<String, Drawable> hashMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Drawable) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }
        if (!TextUtils.isEmpty(str) && (hashMap = this.f184346e) != null) {
            return hashMap.get(str);
        }
        return null;
    }

    public LocalMediaInfo l(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (LocalMediaInfo) iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
        RichMediaBrowserInfo item = getItem(i3);
        if (item != null) {
            RichMediaBaseData richMediaBaseData = item.baseData;
            if (richMediaBaseData instanceof PreviewVideoData) {
                return ((PreviewVideoData) richMediaBaseData).f184339d;
            }
            return null;
        }
        return null;
    }

    public String m(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
        RichMediaBrowserInfo item = getItem(i3);
        if (item != null) {
            RichMediaBaseData richMediaBaseData = item.baseData;
            if (richMediaBaseData instanceof PreviewVideoData) {
                return ((PreviewVideoData) richMediaBaseData).filePath;
            }
            return null;
        }
        return null;
    }

    public void n(String str) {
        HashMap<String, Drawable> hashMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else if (!TextUtils.isEmpty(str) && (hashMap = this.f184346e) != null && hashMap.containsKey(str)) {
            this.f184346e.remove(str);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.preview.BasePreviewPresent, com.tencent.richmediabrowser.presenter.BrowserBasePresenter, com.tencent.richmediabrowser.presenter.BasePresenter, e04.a
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.onDestroy();
        PreviewVideoView previewVideoView = this.f184345d;
        if (previewVideoView != null) {
            previewVideoView.onDestroy();
        }
        HashMap<String, Drawable> hashMap = this.f184346e;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.preview.BasePreviewPresent, com.tencent.richmediabrowser.presenter.BasePresenter, e04.a
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.onPause();
        PreviewVideoView previewVideoView = this.f184345d;
        if (previewVideoView != null) {
            previewVideoView.onPause();
        }
    }

    @Override // com.tencent.richmediabrowser.presenter.BrowserBasePresenter, f04.b
    public void setBrowserView(f04.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar);
            return;
        }
        super.setBrowserView(cVar);
        if (cVar instanceof PreviewVideoView) {
            this.f184345d = (PreviewVideoView) cVar;
        }
    }
}
