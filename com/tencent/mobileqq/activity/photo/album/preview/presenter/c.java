package com.tencent.mobileqq.activity.photo.album.preview.presenter;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.FlowThumbDecoder;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.album.preview.e;
import com.tencent.mobileqq.activity.photo.album.preview.model.PreviewPictureData;
import com.tencent.mobileqq.activity.photo.album.preview.model.PreviewVideoData;
import com.tencent.mobileqq.activity.photo.album.preview.model.WebPreviewPictureData;
import com.tencent.mobileqq.mini.out.activity.PhotoPreviewActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.shortvideo.util.d;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class c<O extends OtherCommonData> extends MainBrowserPresenter implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public com.tencent.mobileqq.activity.photo.album.preview.view.c f184340d;

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.mobileqq.activity.photo.album.preview.model.a f184341e;

    /* renamed from: f, reason: collision with root package name */
    public PhotoCommonBaseData<O> f184342f;

    /* renamed from: h, reason: collision with root package name */
    public com.tencent.mobileqq.activity.photo.album.preview.d f184343h;

    /* renamed from: i, reason: collision with root package name */
    public a f184344i;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void i() {
        Iterator<String> it = this.f184343h.f184324b.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!this.f184343h.f184331i || !QAlbumUtil.isNetUrl(next)) {
                if (next != null) {
                    if (!new File(next).exists()) {
                        it.remove();
                    }
                } else {
                    it.remove();
                }
            }
        }
    }

    private void m(Intent intent) {
        this.f184343h.f184324b = new ArrayList<>();
        this.f184343h.f184324b.addAll(this.f184342f.mediaPathsList);
        if (this.f184343h.f184324b.isEmpty()) {
            this.f184343h.f184324b = intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        }
        com.tencent.mobileqq.activity.photo.album.preview.d dVar = this.f184343h;
        if (dVar.f184324b == null) {
            dVar.f184324b = new ArrayList<>();
        }
        this.f184342f.selectedPhotoList = intent.getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
        ArrayList<Integer> integerArrayListExtra = intent.getIntegerArrayListExtra(QAlbumConstants.SELECTED_INDEXS);
        if (integerArrayListExtra != null && !integerArrayListExtra.isEmpty()) {
            this.f184342f.selectedIndex = integerArrayListExtra;
        }
        if (this.f184342f.selectedIndex == null || this.f184343h.f184324b == null) {
            if (QLog.isColorLevel()) {
                QLog.d("QQAlbum", 2, "initData(): Error! selectedItem or sSelectedIndex is null");
            }
            this.f184340d.f184362d.finish();
        }
    }

    private void n(Intent intent) {
        this.f184343h.f184324b = intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        com.tencent.mobileqq.activity.photo.album.preview.d dVar = this.f184343h;
        if (dVar.f184324b == null) {
            dVar.f184324b = new ArrayList<>();
            this.f184343h.f184324b.addAll(this.f184342f.selectedPhotoList);
        }
        String stringExtra = intent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
        if (stringExtra != null && !stringExtra.equals("")) {
            this.f184343h.f184324b.clear();
            this.f184343h.f184324b.add(stringExtra);
        }
        i();
        PhotoCommonBaseData<O> photoCommonBaseData = this.f184342f;
        ArrayList<String> arrayList = photoCommonBaseData.selectedPhotoList;
        if (arrayList == null) {
            photoCommonBaseData.selectedPhotoList = new ArrayList<>();
        } else {
            arrayList.clear();
        }
        this.f184342f.selectedPhotoList.addAll(this.f184343h.f184324b);
        this.f184342f.selectedIndex.clear();
        if (!this.f184342f.isSingleMode) {
            for (int i3 = 0; i3 < this.f184343h.f184324b.size(); i3++) {
                this.f184342f.selectedIndex.add(Integer.valueOf(i3));
            }
        }
    }

    private void r(String str, LocalMediaInfo localMediaInfo) {
        LocalMediaInfo localMediaInfo2;
        if (localMediaInfo != null) {
            if (localMediaInfo.mediaWidth == 0 || localMediaInfo.mediaHeight == 0) {
                d.a aVar = new d.a();
                com.tencent.mobileqq.shortvideo.util.d.a(str, aVar);
                int[] iArr = aVar.f288248a;
                localMediaInfo.mediaWidth = iArr[0];
                localMediaInfo.mediaHeight = iArr[1];
                localMediaInfo.rotation = iArr[2];
                HashMap<String, LocalMediaInfo> hashMap = this.f184342f.allMediaInfoHashMap;
                if (hashMap != null) {
                    localMediaInfo2 = hashMap.get(str);
                } else {
                    localMediaInfo2 = null;
                }
                if (localMediaInfo2 != null) {
                    if (localMediaInfo2.mediaWidth == 0 || localMediaInfo2.mediaHeight == 0) {
                        localMediaInfo2.mediaWidth = localMediaInfo.mediaWidth;
                        localMediaInfo2.mediaHeight = localMediaInfo.mediaHeight;
                        localMediaInfo2.rotation = localMediaInfo.rotation;
                    }
                }
            }
        }
    }

    @Override // com.tencent.richmediabrowser.presenter.MainBrowserPresenter, f04.b
    public void buildParams(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent);
            return;
        }
        super.buildParams(intent);
        this.f184344i.j(intent);
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "PhotoPreviewCustomization PhotoCommonData = " + this.f184342f);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.preview.presenter.a
    public void c(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
            return;
        }
        if (i3 == 100 || i3 == 102) {
            if (this.f184343h.f184323a) {
                this.f184340d.f184363e.r();
            } else {
                this.f184340d.f184363e.h();
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.preview.presenter.a
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        f04.b currentPresenter = getCurrentPresenter();
        if (currentPresenter instanceof BrowserBasePresenter) {
            ((BrowserBasePresenter) currentPresenter).onDestroy();
        }
        try {
            Iterator<String> it = this.f184342f.selectedPhotoList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next != null) {
                    File file = new File(next);
                    URLDrawable.removeMemoryCacheByUrl(file.toURL().toString());
                    URLDrawable.removeMemoryCacheByUrl(file.toURL().toString() + "#NOSAMPLE");
                }
            }
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.e(PhotoPreviewActivity.TAG, 2, "remove file error");
            }
        }
        this.f184342f.releaseCommonData();
    }

    @Override // com.tencent.mobileqq.activity.photo.album.preview.presenter.a
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        f04.b currentPresenter = getCurrentPresenter();
        if (currentPresenter instanceof BrowserBasePresenter) {
            ((BrowserBasePresenter) currentPresenter).onPause();
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.preview.presenter.a
    public void doOnResume() {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        f04.b currentPresenter = getCurrentPresenter();
        if (currentPresenter instanceof BrowserBasePresenter) {
            ((BrowserBasePresenter) currentPresenter).onResume();
        }
        if (this.f184343h.f184323a && (view = this.f184340d.f184365h) != null) {
            view.setVisibility(0);
        }
    }

    public List<RichMediaBrowserInfo> g() {
        RichMediaBrowserInfo h16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (List) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.f184343h.f184324b.iterator();
        while (it.hasNext()) {
            String next = it.next();
            int l3 = l(next);
            if (l3 != 0) {
                if (l3 != 1) {
                    if (QAlbumUtil.isNetUrl(next)) {
                        h16 = new RichMediaBrowserInfo();
                        WebPreviewPictureData webPreviewPictureData = new WebPreviewPictureData();
                        webPreviewPictureData.filePath = next;
                        h16.baseData = webPreviewPictureData;
                    } else {
                        h16 = h(next);
                    }
                } else {
                    h16 = new RichMediaBrowserInfo();
                    PreviewVideoData previewVideoData = new PreviewVideoData();
                    previewVideoData.filePath = next;
                    previewVideoData.f184339d = k(next);
                    h16.baseData = previewVideoData;
                }
            } else {
                h16 = h(next);
            }
            if (h16 != null) {
                arrayList.add(h16);
            }
        }
        return arrayList;
    }

    RichMediaBrowserInfo h(String str) {
        RichMediaBrowserInfo richMediaBrowserInfo = new RichMediaBrowserInfo();
        PreviewPictureData previewPictureData = new PreviewPictureData();
        previewPictureData.filePath = str;
        richMediaBrowserInfo.baseData = previewPictureData;
        return richMediaBrowserInfo;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.preview.presenter.a
    public void j(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) intent);
            return;
        }
        FlowThumbDecoder.sFlowItemHeight = this.f184340d.f184362d.getResources().getDimension(R.dimen.f158877re);
        this.f184343h.f184326d = intent.getStringExtra("FROM_WHERE");
        intent.removeExtra("FROM_WHERE");
        this.f184342f.isSingleMode = intent.getBooleanExtra("PhotoConst.IS_SINGLE_MODE", false);
        PhotoCommonBaseData<O> photoCommonBaseData = this.f184342f;
        if (photoCommonBaseData.selectedMediaInfoHashMap == null) {
            photoCommonBaseData.selectedMediaInfoHashMap = new HashMap<>();
        }
        HashMap hashMap = (HashMap) intent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
        if (hashMap != null && !hashMap.isEmpty()) {
            this.f184342f.selectedMediaInfoHashMap.putAll(hashMap);
        }
        HashMap<String, LocalMediaInfo> hashMap2 = (HashMap) intent.getSerializableExtra(QAlbumConstants.ALL_MEDIA_PATHS);
        if (hashMap2 != null) {
            this.f184342f.allMediaInfoHashMap = hashMap2;
        }
        this.f184342f.maxSelectNum = intent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
        this.f184343h.f184327e = intent.getBooleanExtra(QAlbumConstants.SHOW_ALBUM, false);
        if (this.f184343h.f184327e) {
            m(intent);
        } else {
            n(intent);
        }
        com.tencent.mobileqq.activity.photo.album.preview.d dVar = this.f184343h;
        dVar.f184329g = dVar.f184324b.size();
        this.f184343h.f184332j = this.f184340d.f184362d.getIntent().getIntExtra(QAlbumConstants.CURRENT_SELECTED_INDEX, -1);
        com.tencent.mobileqq.activity.photo.album.preview.d dVar2 = this.f184343h;
        if (dVar2.f184332j >= dVar2.f184329g) {
            dVar2.f184332j = -1;
        }
        intent.removeExtra(QAlbumConstants.CURRENT_SELECTED_INDEX);
        this.f184342f.customSendBtnText = intent.getStringExtra(QAlbumConstants.CUSTOM_SENDBTN_TEXT);
        PhotoCommonBaseData<O> photoCommonBaseData2 = this.f184342f;
        if (photoCommonBaseData2.filter == null) {
            photoCommonBaseData2.filter = MediaFileFilter.MEDIA_FILTER_DEFAULT;
        }
        notifyImageListChanged(g(), this.f184343h.f184332j);
    }

    public LocalMediaInfo k(String str) {
        LocalMediaInfo localMediaInfo;
        HashMap<String, LocalMediaInfo> hashMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (LocalMediaInfo) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        }
        HashMap<String, LocalMediaInfo> hashMap2 = this.f184342f.selectedMediaInfoHashMap;
        if (hashMap2 != null) {
            localMediaInfo = hashMap2.get(str);
        } else {
            localMediaInfo = null;
        }
        if (localMediaInfo == null && (hashMap = this.f184342f.allMediaInfoHashMap) != null) {
            localMediaInfo = hashMap.get(str);
        }
        r(str, localMediaInfo);
        return localMediaInfo;
    }

    public int l(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str)).intValue();
        }
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (k(str) == null) {
            return QAlbumUtil.getMediaType(str);
        }
        return QAlbumUtil.getMediaType(k(str));
    }

    public void o(com.tencent.mobileqq.activity.photo.album.preview.model.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else {
            super.setBrowserModel(aVar);
            this.f184341e = aVar;
        }
    }

    public void p(com.tencent.mobileqq.activity.photo.album.preview.view.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar);
        } else {
            super.setBrowserScene(cVar);
            this.f184340d = cVar;
        }
    }

    public void q(e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) eVar);
            return;
        }
        this.f184344i = eVar;
        this.f184342f = eVar.f184334e;
        this.f184343h = eVar.f184336h;
    }
}
