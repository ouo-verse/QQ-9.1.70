package com.tencent.mobileqq.activity.photo.album.photolist;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity;
import com.tencent.mobileqq.activity.photo.AlbumThumbManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.album.albumlist.AbstractAlbumListFragment;
import com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.querymedia.MediaQueryHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.AlbumThumbDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.bm;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* loaded from: classes10.dex */
public class PhotoListCustomizationBase<O extends OtherCommonData> extends f<O> {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name */
    private volatile boolean f184274m;

    /* JADX INFO: Access modifiers changed from: protected */
    public PhotoListCustomizationBase(PeakFragmentActivity peakFragmentActivity) {
        super(peakFragmentActivity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) peakFragmentActivity);
        }
    }

    private void U(List<LocalMediaInfo> list) {
        if ((this.f184312h.f184306q && this.f184310e.albumId.equals(QAlbumCustomAlbumConstants.RECENT_ALBUM_ID)) || (this.f184312h.f184307r && this.f184310e.albumId.equals(QAlbumCustomAlbumConstants.VIDEO_ALBUM_ID))) {
            if (list.isEmpty() || list.get(0).mMediaType != 2) {
                LocalMediaInfo localMediaInfo = new LocalMediaInfo();
                localMediaInfo.mMimeType = MimeHelper.MIME_TYPE_MOBILEQQ_CAMERA;
                localMediaInfo.mMediaType = 2;
                list.add(0, localMediaInfo);
            }
        }
    }

    private void V(List<LocalMediaInfo> list, PhotoCommonBaseData<O> photoCommonBaseData, HashMap<String, LocalMediaInfo> hashMap) {
        if (this.f184312h.f184306q && photoCommonBaseData.albumId.equals(QAlbumCustomAlbumConstants.RECENT_ALBUM_ID)) {
            for (LocalMediaInfo localMediaInfo : list) {
                if (localMediaInfo != null && !TextUtils.isEmpty(localMediaInfo.path)) {
                    e.f184289u.remove(localMediaInfo.path);
                    hashMap.remove(localMediaInfo.path);
                }
            }
            list.addAll(0, e.f184289u.values());
        }
    }

    private void W(List<LocalMediaInfo> list, PhotoCommonBaseData<O> photoCommonBaseData, HashMap<String, LocalMediaInfo> hashMap) {
        if (this.f184312h.f184307r && photoCommonBaseData.albumId.equals(QAlbumCustomAlbumConstants.VIDEO_ALBUM_ID)) {
            for (LocalMediaInfo localMediaInfo : list) {
                if (localMediaInfo != null && !TextUtils.isEmpty(localMediaInfo.path)) {
                    e.f184289u.remove(localMediaInfo.path);
                    hashMap.remove(localMediaInfo.path);
                }
            }
            int i3 = 0;
            for (LocalMediaInfo localMediaInfo2 : e.f184289u.values()) {
                if (localMediaInfo2 != null && "video/mp4".equals(localMediaInfo2.mMimeType)) {
                    list.add(i3, localMediaInfo2);
                    i3++;
                }
            }
        }
    }

    private void a0(LocalMediaInfo localMediaInfo, PhotoCommonBaseData photoCommonBaseData, String[] strArr, String str) {
        e0(localMediaInfo, strArr);
        photoCommonBaseData.selectedPhotoList.add(str);
        photoCommonBaseData.selectedIndex.add(localMediaInfo.position);
        photoCommonBaseData.selectedMediaInfoHashMap.put(str, localMediaInfo);
        Intent intent = this.f184309d.getIntent();
        if (!intent.hasExtra(QAlbumConstants.PARAM_INITTIME)) {
            intent.putExtra(QAlbumConstants.PARAM_INITTIME, System.currentTimeMillis());
        }
        localMediaInfo.selectStatus = 1;
        LinkedHashMap<String, Integer> linkedHashMap = QAlbumUtil.sSelectItemPosMap.get(this.f184310e.albumId);
        if (linkedHashMap == null) {
            linkedHashMap = new LinkedHashMap<>();
            QAlbumUtil.sSelectItemPosMap.put(this.f184310e.albumId, linkedHashMap);
        }
        linkedHashMap.put(str, Integer.valueOf(this.f184313i.I.findFirstVisibleItemPosition()));
        HashMap<String, Pair<String, String>> hashMap = QAlbumUtil.sSelectItemAlbum;
        if (!hashMap.containsKey(str)) {
            PhotoCommonBaseData<O> photoCommonBaseData2 = this.f184310e;
            hashMap.put(str, new Pair<>(photoCommonBaseData2.albumId, photoCommonBaseData2.albumName));
        }
    }

    private void b0(ArrayList<String> arrayList, LocalMediaInfo localMediaInfo, String str) {
        e0(localMediaInfo, MimeHelper.getMimeType(localMediaInfo.mMimeType));
        arrayList.add(str);
        this.f184310e.selectedIndex.add(localMediaInfo.position);
        this.f184310e.selectedMediaInfoHashMap.put(str, localMediaInfo);
        Intent intent = this.f184309d.getIntent();
        if (!intent.hasExtra(QAlbumConstants.PARAM_INITTIME)) {
            intent.putExtra(QAlbumConstants.PARAM_INITTIME, System.currentTimeMillis());
        }
        LinkedHashMap<String, Integer> linkedHashMap = QAlbumUtil.sSelectItemPosMap.get(this.f184310e.albumId);
        if (linkedHashMap == null) {
            linkedHashMap = new LinkedHashMap<>();
            QAlbumUtil.sSelectItemPosMap.put(this.f184310e.albumId, linkedHashMap);
        }
        linkedHashMap.put(str, Integer.valueOf(this.f184313i.I.findFirstVisibleItemPosition()));
        HashMap<String, Pair<String, String>> hashMap = QAlbumUtil.sSelectItemAlbum;
        if (!hashMap.containsKey(str)) {
            PhotoCommonBaseData<O> photoCommonBaseData = this.f184310e;
            hashMap.put(str, new Pair<>(photoCommonBaseData.albumId, photoCommonBaseData.albumName));
        }
    }

    private void c0(LocalMediaInfo localMediaInfo, PhotoCommonBaseData photoCommonBaseData, String[] strArr, String str) {
        if (this.f184312h.f184293d && strArr != null && "video".equals(strArr[0])) {
            e eVar = this.f184312h;
            int i3 = eVar.f184294e - 1;
            eVar.f184294e = i3;
            if (i3 == 1) {
                eVar.f184296g = localMediaInfo;
            }
        }
        if (!TextUtils.isEmpty(localMediaInfo.mMimeType) && "image/gif".equals(localMediaInfo.mMimeType)) {
            this.f184312h.f184295f--;
        }
        photoCommonBaseData.selectedPhotoList.remove(localMediaInfo.path);
        photoCommonBaseData.selectedIndex.remove(localMediaInfo.position);
        photoCommonBaseData.selectedMediaInfoHashMap.remove(str);
        localMediaInfo.selectStatus = 2;
        LinkedHashMap<String, Integer> linkedHashMap = QAlbumUtil.sSelectItemPosMap.get(this.f184310e.albumId);
        if (linkedHashMap != null) {
            linkedHashMap.remove(str);
        }
        HashMap<String, Pair<String, String>> hashMap = QAlbumUtil.sSelectItemAlbum;
        if (hashMap.containsKey(str)) {
            hashMap.remove(str);
        }
    }

    private void d0(ArrayList<String> arrayList, LocalMediaInfo localMediaInfo, String str) {
        String[] mimeType = MimeHelper.getMimeType(localMediaInfo.mMimeType);
        if (this.f184312h.f184293d && mimeType != null && "video".equals(mimeType[0])) {
            e eVar = this.f184312h;
            int i3 = eVar.f184294e - 1;
            eVar.f184294e = i3;
            if (i3 == 1) {
                eVar.f184296g = localMediaInfo;
            }
        }
        if (!TextUtils.isEmpty(localMediaInfo.mMimeType) && "image/gif".equals(localMediaInfo.mMimeType)) {
            this.f184312h.f184295f--;
        }
        arrayList.remove(str);
        this.f184310e.selectedIndex.remove(localMediaInfo.position);
        this.f184310e.selectedMediaInfoHashMap.remove(str);
        LinkedHashMap<String, Integer> linkedHashMap = QAlbumUtil.sSelectItemPosMap.get(this.f184310e.albumId);
        if (linkedHashMap != null) {
            linkedHashMap.remove(str);
        }
        HashMap<String, Pair<String, String>> hashMap = QAlbumUtil.sSelectItemAlbum;
        if (hashMap.containsKey(str)) {
            hashMap.remove(str);
        }
    }

    private void e0(LocalMediaInfo localMediaInfo, String[] strArr) {
        if (this.f184312h.f184293d && strArr != null && "video".equals(strArr[0])) {
            e eVar = this.f184312h;
            int i3 = eVar.f184294e + 1;
            eVar.f184294e = i3;
            if (i3 == 1) {
                eVar.f184296g = localMediaInfo;
            }
        }
        if (!TextUtils.isEmpty(localMediaInfo.mMimeType) && "image/gif".equals(localMediaInfo.mMimeType)) {
            this.f184312h.f184295f++;
        }
    }

    private boolean f0(boolean z16, int i3) {
        if (i3 == 1 && z16) {
            return true;
        }
        if (i3 == 2 && !z16) {
            return true;
        }
        return false;
    }

    private void j0(List<LocalMediaInfo> list, int i3, long j3, int i16) {
        while (i3 < list.size()) {
            LocalMediaInfo localMediaInfo = list.get(i3);
            if (localMediaInfo.path != null) {
                PhotoCommonBaseData<O> photoCommonBaseData = this.f184310e;
                if (photoCommonBaseData.firstVideoInfo == null && localMediaInfo.mMediaType == 1 && (QAlbumCustomAlbumConstants.RECENT_ALBUM_ID.equals(photoCommonBaseData.albumId) || QAlbumCustomAlbumConstants.VIDEO_ALBUM_ID.equals(this.f184310e.albumId))) {
                    this.f184310e.firstVideoInfo = localMediaInfo;
                }
                int mediaType = QAlbumUtil.getMediaType(localMediaInfo);
                localMediaInfo.position = Integer.valueOf(this.f184310e.mediaPathsList.size());
                this.f184310e.mediaPathsList.add(localMediaInfo.path);
                if (this.f184310e.selectedPhotoList.contains(localMediaInfo.path)) {
                    l0(localMediaInfo, mediaType);
                } else if (this.f184310e.selectedPhotoList.size() < this.f184310e.maxSelectNum && localMediaInfo.path.equals(this.f184312h.f184292c)) {
                    localMediaInfo.selectStatus = 1;
                    this.f184310e.selectedPhotoList.add(localMediaInfo.path);
                    this.f184310e.selectedIndex.add(localMediaInfo.position);
                    this.f184310e.selectedMediaInfoHashMap.put(localMediaInfo.path, localMediaInfo);
                } else {
                    m0(list, j3, i16, localMediaInfo);
                }
            }
            i3++;
        }
    }

    private void k0(@NonNull a aVar, View view, LocalMediaInfo localMediaInfo) {
        int i3 = localMediaInfo.selectStatus;
        if (i3 == 1) {
            aVar.J.setCheckedNumber(this.f184310e.selectedPhotoList.indexOf(localMediaInfo.path) + 1);
            if (view.getBackground() != null) {
                view.setBackgroundDrawable(null);
            }
        } else if (i3 == 3) {
            aVar.J.setChecked(false);
        } else {
            aVar.J.setChecked(false);
            if (view.getBackground() != null) {
                view.setBackgroundDrawable(null);
            }
        }
        int size = this.f184310e.selectedPhotoList.size();
        PhotoCommonBaseData<O> photoCommonBaseData = this.f184310e;
        if (size >= photoCommonBaseData.maxSelectNum && i3 != 1 && !photoCommonBaseData.isSingleMode) {
            aVar.F.setAlpha(0.3f);
        } else {
            aVar.F.setAlpha(1.0f);
        }
    }

    private void l0(LocalMediaInfo localMediaInfo, int i3) {
        localMediaInfo.selectStatus = 1;
        if (!this.f184310e.selectedIndex.contains(localMediaInfo.position)) {
            this.f184310e.selectedIndex.add(localMediaInfo.position);
        }
        e eVar = this.f184312h;
        if (eVar.f184293d && i3 == 1) {
            int i16 = eVar.f184294e + 1;
            eVar.f184294e = i16;
            if (i16 == 1) {
                eVar.f184296g = localMediaInfo;
            }
        }
        if (eVar.f184306q && !this.f184310e.selectedMediaInfoHashMap.containsKey(localMediaInfo.path)) {
            this.f184310e.selectedMediaInfoHashMap.put(localMediaInfo.path, localMediaInfo);
        }
        if (!TextUtils.isEmpty(localMediaInfo.mMimeType) && "image/gif".equals(localMediaInfo.mMimeType)) {
            this.f184312h.f184295f++;
        }
    }

    private void m0(List<LocalMediaInfo> list, long j3, int i3, LocalMediaInfo localMediaInfo) {
        if (this.f184312h.f184305p && j3 <= 60000 && i3 == list.size() && localMediaInfo.path.equals(QAlbumUtil.sLastAlbumPath)) {
            localMediaInfo.selectStatus = 3;
        } else {
            localMediaInfo.selectStatus = 2;
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.f
    public a A(@NonNull a aVar, int i3) {
        URL generateAlbumThumbURL;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (a) iPatchRedirector.redirect((short) 27, (Object) this, (Object) aVar, i3);
        }
        aVar.P.b(i3);
        aVar.P.a(aVar.J);
        ImageView imageView = aVar.F;
        imageView.setAdjustViewBounds(false);
        LocalMediaInfo m06 = this.f184313i.Q.m0(i3);
        aVar.F.setContentDescription(QAlbumUtil.createContentDescription(1, m06, i3));
        if (m06.isSystemMeidaStore) {
            generateAlbumThumbURL = QAlbumUtil.generateAlbumThumbURL(m06, "VIDEO");
        } else {
            generateAlbumThumbURL = QAlbumUtil.generateAlbumThumbURL(m06, "APP_VIDEO");
        }
        int i16 = AlbumThumbDownloader.THUMB_WIDHT;
        m06.thumbHeight = i16;
        m06.thumbWidth = i16;
        URLDrawable uRLDrawable = aVar.K;
        if (uRLDrawable == null || !uRLDrawable.getURL().equals(generateAlbumThumbURL)) {
            if (QLog.isColorLevel()) {
                QLog.d("QQAlbum", 2, "PhotoListAdapter,getView(),vedio url :" + generateAlbumThumbURL.toString());
            }
            d dVar = this.f184313i.Q;
            URLDrawable drawable = URLDrawableHelper.getDrawable(generateAlbumThumbURL, dVar.F, dVar.D);
            drawable.setTag(m06);
            imageView.setImageDrawable(drawable);
            aVar.K = drawable;
            if (uRLDrawable != null) {
                uRLDrawable.cancelDownload();
            }
        }
        TextView textView = aVar.L;
        if (!m06.isSystemMeidaStore && m06.mDuration <= 0) {
            textView.setVisibility(8);
            MediaScanner mediaScanner = MediaScanner.getInstance(BaseApplication.getContext());
            if (mediaScanner != null) {
                mediaScanner.queryMediaInfoDuration(this, m06, i3);
            }
        } else {
            textView.setVisibility(0);
            textView.setText(QAlbumUtil.formatTimeToString(m06.mDuration));
        }
        k0(aVar, aVar.itemView, m06);
        m06.visableTime = SystemClock.uptimeMillis();
        m06.listViewPosition = i3;
        return aVar;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.f
    public void B(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) intent);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.f
    public void C(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) intent);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.f
    public void D(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) message);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.f
    public void E(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            return;
        }
        this.f184312h.f184305p = intent.getBooleanExtra(QAlbumConstants.IS_RECODE_LAST_ALBUMPATH, true);
        this.f184312h.f184302m = this.f184310e.albumId;
        if (intent.getBooleanExtra(QAlbumConstants.ALBUM_ENTER_DIRECTLY, false)) {
            long currentTimeMillis = System.currentTimeMillis() - QAlbumUtil.sLastAlbumRecordTime;
            if (this.f184312h.f184305p && currentTimeMillis < 60000) {
                PhotoCommonBaseData<O> photoCommonBaseData = this.f184310e;
                photoCommonBaseData.albumName = QAlbumUtil.sLastAlbumName;
                photoCommonBaseData.albumId = QAlbumUtil.sLastAlbumId;
            }
        } else {
            this.f184310e.albumName = intent.getStringExtra(QAlbumConstants.ALBUM_NAME);
            this.f184310e.albumId = intent.getStringExtra(QAlbumConstants.ALBUM_ID);
        }
        PhotoCommonBaseData<O> photoCommonBaseData2 = this.f184310e;
        if (photoCommonBaseData2.albumId == null) {
            photoCommonBaseData2.albumId = QAlbumCustomAlbumConstants.RECENT_ALBUM_ID;
            photoCommonBaseData2.albumName = null;
        }
        this.f184312h.f184293d = intent.getBooleanExtra(QAlbumConstants.IS_SUPPORT_VIDEO_CHECKBOX, false);
        this.f184312h.f184308s = intent.getBooleanExtra(QAlbumConstants.SHOW_GIF_TYPE_ICON, false);
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        if (stringArrayListExtra != null && !stringArrayListExtra.isEmpty()) {
            this.f184310e.selectedPhotoList = stringArrayListExtra;
        }
        PhotoCommonBaseData<O> photoCommonBaseData3 = this.f184310e;
        if (photoCommonBaseData3.selectedPhotoList == null) {
            photoCommonBaseData3.selectedPhotoList = new ArrayList<>();
        }
        PhotoCommonBaseData<O> photoCommonBaseData4 = this.f184310e;
        if (photoCommonBaseData4.selectedMediaInfoHashMap == null) {
            photoCommonBaseData4.selectedMediaInfoHashMap = new HashMap<>();
        }
        HashMap hashMap = (HashMap) intent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
        if (hashMap != null && !hashMap.isEmpty() && this.f184310e.selectedPhotoList.size() == hashMap.size()) {
            this.f184310e.selectedMediaInfoHashMap.clear();
            this.f184310e.selectedMediaInfoHashMap.putAll(hashMap);
        }
        this.f184310e.selectedIndex = new ArrayList<>();
        this.f184310e.maxSelectNum = intent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
        this.f184310e.isSingleMode = intent.getBooleanExtra("PhotoConst.IS_SINGLE_MODE", true);
        PhotoCommonBaseData<O> photoCommonBaseData5 = this.f184310e;
        if (photoCommonBaseData5.maxSelectNum > 1) {
            photoCommonBaseData5.isSingleMode = false;
        }
        photoCommonBaseData5.showMediaType = intent.getIntExtra(QAlbumConstants.PHOTOLIST_KEY_SHOW_MEDIA, 1);
        PhotoCommonBaseData<O> photoCommonBaseData6 = this.f184310e;
        photoCommonBaseData6.filter = MediaFileFilter.getFilter(photoCommonBaseData6.showMediaType);
        this.f184310e.customSendBtnText = intent.getStringExtra(QAlbumConstants.CUSTOM_SENDBTN_TEXT);
        this.f184312h.f184306q = intent.getBooleanExtra(QAlbumConstants.IS_SHOW_CAMERA, false);
        e eVar = this.f184312h;
        if (eVar.f184306q) {
            eVar.f184307r = intent.getBooleanExtra(QAlbumConstants.SHOW_CAMERA_IN_VIDEO, false);
        }
        this.f184312h.f184297h = intent.getIntExtra("PHOTOLIST_START_POSITION", -1);
        intent.removeExtra("PHOTOLIST_START_POSITION");
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.f
    public void F() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.f184313i.p();
        View view = this.f184313i.D;
        if (view != null) {
            if (this.f184310e.isSingleMode) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            view.setVisibility(i3);
        }
        PhotoListSceneBase photoListSceneBase = this.f184313i;
        Button button = photoListSceneBase.K;
        if (button != null) {
            button.setOnClickListener(photoListSceneBase);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.f
    public void G(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        this.f184312h.f184301l = i3;
        if (i16 == -1 && i3 == 16) {
            X(true, this.f184309d.getIntent());
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.f
    public void I() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            this.f184312h.f184291b = true;
            P(null);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.f
    public void J(View view, int i3, CheckBox checkBox) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 2;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, view, Integer.valueOf(i3), checkBox);
            return;
        }
        PhotoCommonBaseData<O> photoCommonBaseData = this.f184310e;
        ArrayList<String> arrayList = photoCommonBaseData.selectedPhotoList;
        if (photoCommonBaseData.isSingleMode) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "current select count:" + arrayList.size());
        }
        LocalMediaInfo m06 = this.f184313i.Q.m0(i3);
        int i17 = m06.selectStatus;
        if (i17 != 1 && arrayList.size() >= this.f184310e.maxSelectNum) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f184312h.f184299j >= 1000) {
                QQToast.makeText(this.f184309d, Y(m06), 0).show();
                checkBox.setChecked(false);
                this.f184312h.f184299j = currentTimeMillis;
                return;
            }
            return;
        }
        if (i17 != 1) {
            i16 = 1;
        }
        m06.selectStatus = i16;
        if (i16 == 1) {
            z16 = true;
        }
        String str = m06.path;
        if (z16) {
            b0(arrayList, m06, str);
        } else {
            d0(arrayList, m06, str);
        }
        h0(z16, m06);
        this.f184313i.u(i3, z16);
        this.f184313i.t(!z16);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.f
    public void K(boolean z16, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.f
    public void L(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) view);
        } else {
            X(false, this.f184309d.getIntent());
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.f
    public void M(CompoundButton compoundButton, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, compoundButton, Boolean.valueOf(z16));
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.f
    public boolean N(List<LocalMediaInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, (Object) this, (Object) list)).booleanValue();
        }
        if (this.f184309d == null) {
            return false;
        }
        if (list == null) {
            if ((this.f184312h.f184306q && this.f184310e.albumId.equals(QAlbumCustomAlbumConstants.RECENT_ALBUM_ID)) || (this.f184312h.f184307r && this.f184310e.albumId.equals(QAlbumCustomAlbumConstants.VIDEO_ALBUM_ID))) {
                LocalMediaInfo localMediaInfo = new LocalMediaInfo();
                localMediaInfo.mMimeType = MimeHelper.MIME_TYPE_MOBILEQQ_CAMERA;
                ArrayList arrayList = new ArrayList();
                arrayList.add(0, localMediaInfo);
                list = arrayList;
            }
            this.f184313i.Q.t0(list);
            this.f184313i.Q.notifyDataSetChanged();
            T();
            QQToast.makeText(this.f184309d, "\u6682\u65e0\u5a92\u4f53\u6587\u4ef6", 1000).show();
            return false;
        }
        this.f184313i.Q.t0(list);
        if (list.isEmpty() && !this.f184274m) {
            QQToast.makeText(this.f184309d, "\u6682\u65e0\u5a92\u4f53\u6587\u4ef6", 1000).show();
        }
        this.f184313i.Q.notifyDataSetChanged();
        T();
        return true;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.f
    public void O(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) view);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.f
    public void P(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) view);
            return;
        }
        QAlbumUtil.clearSelectItemInfo();
        this.f184309d.finish();
        QAlbumUtil.anim(this.f184309d, false, false);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.f
    public List<LocalMediaInfo> Q(Object... objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (List) iPatchRedirector.redirect((short) 37, (Object) this, (Object) objArr);
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "PhotoListCustomizationBase,doInBackground");
        }
        MediaQueryHelper mediaQueryHelper = this.f184310e.getMediaQueryHelper();
        if (mediaQueryHelper == null || !this.f184310e.albumId.equals(this.f184312h.f184302m)) {
            mediaQueryHelper = this.f184310e.createMediaQueryHelper(this.f184309d);
        }
        if (this.f184274m) {
            QLog.i("QQAlbum", 1, "queryDoInBackground() run in destroyed, return empty list.");
            return Collections.emptyList();
        }
        try {
            mediaQueryHelper.queryNext();
            PhotoCommonBaseData<O> photoCommonBaseData = this.f184310e;
            if (photoCommonBaseData.firstRecentInfo == null && QAlbumCustomAlbumConstants.RECENT_ALBUM_ID.equals(photoCommonBaseData.albumId)) {
                this.f184310e.firstRecentInfo = mediaQueryHelper.getFirstInfo();
                mediaQueryHelper.upDateCount();
                PhotoCommonBaseData<O> photoCommonBaseData2 = this.f184310e;
                int i3 = photoCommonBaseData2.recentCountLimit;
                if (i3 > 0 && i3 < mediaQueryHelper.cursorsCount) {
                    photoCommonBaseData2.recentCount = i3;
                } else {
                    photoCommonBaseData2.recentCount = mediaQueryHelper.cursorsCount;
                }
                photoCommonBaseData2.videoCount = mediaQueryHelper.cursorsVideoCount;
            }
            List<LocalMediaInfo> list = mediaQueryHelper.mediaList;
            g0(list);
            S(list, 0);
            if (QLog.isColorLevel()) {
                QLog.d("QQAlbum", 2, "QueryPhotoTask,doInBackground,mediaList.size :" + list.size());
            }
            U(list);
            return list;
        } catch (Exception e16) {
            QLog.w("QQAlbum", 1, "queryHelper.queryNext() exception:" + e16);
            return Collections.emptyList();
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.f
    public void R(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) intent);
        } else {
            this.f184309d.startActivity(intent);
            this.f184309d.finish();
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.f
    public void S(List<LocalMediaInfo> list, int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) list, i3);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - QAlbumUtil.sLastAlbumRecordTime;
        if (QAlbumUtil.sLastAlbumPhotoCountMap.containsKey(this.f184310e.albumId)) {
            i16 = QAlbumUtil.sLastAlbumPhotoCountMap.get(this.f184310e.albumId).intValue();
        } else {
            i16 = 0;
        }
        int i17 = i16;
        int size = list.size();
        j0(list, i3, currentTimeMillis, i17);
        while (i3 < size) {
            LocalMediaInfo localMediaInfo = list.get(i3);
            String str = localMediaInfo.path;
            if (str != null) {
                this.f184310e.allMediaInfoHashMap.put(str, localMediaInfo);
            }
            i3++;
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.f
    public void T() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        PhotoCommonBaseData<O> photoCommonBaseData = this.f184310e;
        ArrayList<String> arrayList = photoCommonBaseData.selectedPhotoList;
        String str = photoCommonBaseData.customSendBtnText;
        if (str == null) {
            str = this.f184309d.getString(R.string.ctx);
        }
        if (arrayList.size() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str = str + "(" + arrayList.size() + ")";
        }
        Button button = this.f184313i.K;
        if (button != null) {
            button.setText(str);
            this.f184313i.K.setEnabled(z16);
        }
        TextView textView = this.f184313i.J;
        if (textView != null) {
            textView.setEnabled(z16);
        }
    }

    public void X(boolean z16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), intent);
            return;
        }
        intent.putExtra(QAlbumConstants.SHOW_ALBUM, false);
        ArrayList<String> arrayList = this.f184310e.selectedPhotoList;
        if (!z16) {
            intent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", arrayList);
        } else {
            intent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", this.f184312h.f184292c);
        }
        intent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.f184310e.selectedMediaInfoHashMap);
        intent.putExtra(QAlbumConstants.CURRENT_SELECTED_INDEX, 0);
        intent.putExtra(QAlbumConstants.ALBUM_NAME, this.f184310e.albumName);
        intent.putExtra(QAlbumConstants.ALBUM_ID, this.f184310e.albumId);
        intent.putExtra("FROM_WHERE", PhotoCommonBaseData.FROM_PHOTO_LIST);
        e.f184288t = this.f184313i.I.findFirstVisibleItemPosition();
        intent.setClass(this.f184309d, Z());
        intent.addFlags(603979776);
        R(intent);
        QAlbumUtil.anim(this.f184309d, true, true);
    }

    public String Y(LocalMediaInfo localMediaInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) localMediaInfo);
        }
        return this.f184309d.getResources().getString(R.string.cu_, Integer.valueOf(this.f184310e.maxSelectNum));
    }

    public Class Z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return (Class) iPatchRedirector.redirect((short) 46, (Object) this);
        }
        return AbstractPhotoPreviewActivity.class;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.f
    public boolean a(LocalMediaInfo localMediaInfo, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, localMediaInfo, Boolean.valueOf(z16))).booleanValue();
        }
        PhotoCommonBaseData<O> photoCommonBaseData = this.f184310e;
        String[] mimeType = MimeHelper.getMimeType(localMediaInfo.mMimeType);
        if (!this.f184312h.f184293d && mimeType != null && !"image".equals(mimeType[0])) {
            return false;
        }
        int i3 = localMediaInfo.selectStatus;
        if (f0(z16, i3)) {
            return false;
        }
        if (i3 == 2 && z16 && photoCommonBaseData.selectedPhotoList.size() >= photoCommonBaseData.maxSelectNum) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f184312h.f184299j >= 700) {
                QQToast.makeText(this.f184309d, Y(localMediaInfo), 1000).show();
                e eVar = this.f184312h;
                eVar.f184299j = currentTimeMillis;
                eVar.f184300k = true;
            }
            return false;
        }
        this.f184312h.f184300k = false;
        String str = localMediaInfo.path;
        if (z16) {
            a0(localMediaInfo, photoCommonBaseData, mimeType, str);
        } else {
            c0(localMediaInfo, photoCommonBaseData, mimeType, str);
        }
        this.f184313i.t(!z16);
        return true;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.b
    public View b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return (View) iPatchRedirector.redirect((short) 38, (Object) this);
        }
        return this.f184313i.b();
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.f
    public void c(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) view, i3);
        }
    }

    public View d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return (View) iPatchRedirector.redirect((short) 40, (Object) this);
        }
        return this.f184313i.d();
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.b
    public RelativeLayout.LayoutParams e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return (RelativeLayout.LayoutParams) iPatchRedirector.redirect((short) 39, (Object) this);
        }
        return this.f184313i.e();
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.b
    public RelativeLayout.LayoutParams f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return (RelativeLayout.LayoutParams) iPatchRedirector.redirect((short) 41, (Object) this);
        }
        return this.f184313i.f();
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.b
    public RelativeLayout.LayoutParams g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return (RelativeLayout.LayoutParams) iPatchRedirector.redirect((short) 44, (Object) this);
        }
        return this.f184313i.g();
    }

    public void g0(List<LocalMediaInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) list);
            return;
        }
        PhotoCommonBaseData<O> photoCommonBaseData = this.f184310e;
        if (photoCommonBaseData.selectedPhotoList == null) {
            photoCommonBaseData.selectedPhotoList = new ArrayList<>();
        }
        if (photoCommonBaseData.selectedMediaInfoHashMap == null) {
            photoCommonBaseData.selectedMediaInfoHashMap = new HashMap<>();
        }
        HashMap<String, LocalMediaInfo> hashMap = photoCommonBaseData.selectedMediaInfoHashMap;
        bm.a();
        e eVar = this.f184312h;
        eVar.f184294e = 0;
        eVar.f184295f = 0;
        PhotoCommonBaseData<O> photoCommonBaseData2 = this.f184310e;
        if (photoCommonBaseData2.allMediaInfoHashMap == null) {
            photoCommonBaseData2.allMediaInfoHashMap = new HashMap<>();
        } else {
            Iterator<String> it = photoCommonBaseData2.selectedPhotoList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (this.f184310e.allMediaInfoHashMap.containsKey(next) && !this.f184310e.selectedMediaInfoHashMap.containsKey(next)) {
                    PhotoCommonBaseData<O> photoCommonBaseData3 = this.f184310e;
                    photoCommonBaseData3.selectedMediaInfoHashMap.put(next, photoCommonBaseData3.allMediaInfoHashMap.get(next));
                }
            }
            photoCommonBaseData.allMediaInfoHashMap.clear();
        }
        PhotoCommonBaseData<O> photoCommonBaseData4 = this.f184310e;
        ArrayList<String> arrayList = photoCommonBaseData4.mediaPathsList;
        if (arrayList != null) {
            arrayList.clear();
        } else {
            photoCommonBaseData4.mediaPathsList = new ArrayList<>();
        }
        V(list, photoCommonBaseData, hashMap);
        W(list, photoCommonBaseData, hashMap);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.b
    public View h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return (View) iPatchRedirector.redirect((short) 42, (Object) this);
        }
        return this.f184313i.h();
    }

    public void h0(boolean z16, LocalMediaInfo localMediaInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, this, Boolean.valueOf(z16), localMediaInfo);
        }
    }

    protected void i0(a aVar, LocalMediaInfo localMediaInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) aVar, (Object) localMediaInfo);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.b
    public RelativeLayout.LayoutParams j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return (RelativeLayout.LayoutParams) iPatchRedirector.redirect((short) 43, (Object) this);
        }
        return this.f184313i.j();
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.f
    public Intent k(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (Intent) iPatchRedirector.redirect((short) 22, (Object) this, (Object) view, i3);
        }
        LocalMediaInfo m06 = this.f184313i.Q.m0(i3);
        Intent intent = this.f184309d.getIntent();
        intent.putExtra(QAlbumConstants.ALBUM_NAME, this.f184310e.albumName);
        intent.putExtra(QAlbumConstants.ALBUM_ID, this.f184310e.albumId);
        intent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.f184310e.selectedPhotoList);
        intent.putIntegerArrayListExtra(QAlbumConstants.SELECTED_INDEXS, this.f184310e.selectedIndex);
        if (QAlbumUtil.getMediaType(m06) == 0) {
            intent.putExtra(QAlbumConstants.CURRENT_SELECTED_INDEX, m06.position);
        }
        intent.putExtra("FROM_WHERE", PhotoCommonBaseData.FROM_PHOTO_LIST);
        intent.putExtra(QAlbumConstants.SHOW_ALBUM, true);
        e.f184288t = this.f184313i.I.findFirstVisibleItemPosition();
        if (!this.f184310e.selectedMediaInfoHashMap.containsKey(m06.path)) {
            this.f184310e.selectedMediaInfoHashMap.put(m06.path, m06);
        }
        intent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.f184310e.selectedMediaInfoHashMap);
        intent.setClass(this.f184309d, Z());
        intent.addFlags(603979776);
        return intent;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.f
    public void l(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) view, i3);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaScannerListener
    public void onPhotoListDatasetDurationChanged(int i3, LocalMediaInfo localMediaInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, i3, (Object) localMediaInfo);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.f
    public void p(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) view, i3);
            return;
        }
        LocalMediaInfo m06 = this.f184313i.Q.m0(i3);
        if (m06 == null) {
            return;
        }
        this.f184309d.getIntent();
        HashMap<String, Pair<String, String>> hashMap = QAlbumUtil.sSelectItemAlbum;
        if (!hashMap.containsKey(m06.path)) {
            PhotoCommonBaseData<O> photoCommonBaseData = this.f184310e;
            hashMap.put(m06.path, new Pair<>(photoCommonBaseData.albumId, photoCommonBaseData.albumName));
        }
        this.f184313i.s(m06.path);
        if (!this.f184310e.isSingleMode) {
            Intent intent = this.f184309d.getIntent();
            intent.putExtra(QAlbumConstants.ALBUM_NAME, this.f184310e.albumName);
            intent.putExtra(QAlbumConstants.ALBUM_ID, this.f184310e.albumId);
            LocalMediaInfo m07 = this.f184313i.Q.m0(i3);
            intent.putExtra(QAlbumConstants.CURRENT_SELECTED_INDEX, m07.position);
            intent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.f184310e.selectedPhotoList);
            intent.putIntegerArrayListExtra(QAlbumConstants.SELECTED_INDEXS, this.f184310e.selectedIndex);
            intent.putExtra("FROM_WHERE", PhotoCommonBaseData.FROM_PHOTO_LIST);
            intent.putExtra(QAlbumConstants.SHOW_ALBUM, true);
            e.f184288t = this.f184313i.I.findFirstVisibleItemPosition();
            HashMap<String, LocalMediaInfo> hashMap2 = this.f184310e.selectedMediaInfoHashMap;
            if (!hashMap2.containsKey(m07.path)) {
                hashMap2.put(m07.path, m07);
            }
            intent.putExtra("PeakConstants.selectedMediaInfoHashMap", hashMap2);
            intent.setClass(this.f184309d, Z());
            intent.addFlags(603979776);
            this.f184309d.startActivity(intent);
            this.f184309d.finish();
            QAlbumUtil.anim(this.f184309d, true, true);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.f
    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this);
            return;
        }
        this.f184274m = true;
        if (!this.f184312h.f184291b) {
            AlbumThumbManager.getInstance(this.f184309d).clear();
        }
        d dVar = this.f184313i.Q;
        if (dVar != null) {
            QAlbumUtil.sLastAlbumPhotoCountMap.put(this.f184310e.albumId, Integer.valueOf(dVar.getNUM_BACKGOURND_ICON()));
        }
        AsyncTask<Object, Object, List<LocalMediaInfo>> asyncTask = this.f184313i.G;
        if (asyncTask != null) {
            asyncTask.cancel(true);
        }
        q();
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.f
    public void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this);
        } else {
            this.f184313i.G = null;
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.f
    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this);
            return;
        }
        e eVar = this.f184312h;
        if (eVar.f184298i) {
            this.f184309d.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PhotoListCustomizationBase.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    PhotoListSceneBase photoListSceneBase = PhotoListCustomizationBase.this.f184313i;
                    if (photoListSceneBase.G == null) {
                        photoListSceneBase.m(false);
                    }
                }
            });
        } else {
            eVar.f184298i = true;
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.f
    public void u(Intent intent) {
        LocalMediaInfo localMediaInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) intent);
            return;
        }
        PhotoCommonBaseData<O> photoCommonBaseData = this.f184310e;
        ArrayList<String> arrayList = photoCommonBaseData.selectedPhotoList;
        HashMap<String, LocalMediaInfo> hashMap = photoCommonBaseData.selectedMediaInfoHashMap;
        intent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", arrayList);
        HashMap hashMap2 = new HashMap(hashMap);
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            HashMap<String, LocalMediaInfo> hashMap3 = this.f184310e.allMediaInfoHashMap;
            if (hashMap3 != null) {
                localMediaInfo = hashMap3.get(next);
            } else {
                localMediaInfo = null;
            }
            if (localMediaInfo != null) {
                hashMap2.put(next, localMediaInfo);
            } else {
                LocalMediaInfo localMediaInfo2 = hashMap.get(next);
                if (localMediaInfo2 != null) {
                    hashMap2.put(next, localMediaInfo2);
                }
            }
        }
        intent.putExtra("PeakConstants.selectedMediaInfoHashMap", hashMap2);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.f
    public AbstractAlbumListFragment w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return (AbstractAlbumListFragment) iPatchRedirector.redirect((short) 45, (Object) this);
        }
        return new AbstractAlbumListFragment();
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.f
    public a y(@NonNull a aVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (a) iPatchRedirector.redirect((short) 28, (Object) this, (Object) aVar, i3);
        }
        return aVar;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.f
    public a z(@NonNull a aVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (a) iPatchRedirector.redirect((short) 25, (Object) this, (Object) aVar, i3);
        }
        View view = aVar.itemView;
        aVar.P.b(i3);
        aVar.P.a(aVar.J);
        ImageView imageView = aVar.F;
        imageView.setAdjustViewBounds(false);
        LocalMediaInfo m06 = this.f184313i.Q.m0(i3);
        aVar.F.setContentDescription(QAlbumUtil.createContentDescription(0, m06, i3));
        if (m06 != null) {
            aVar.E.setVisibility(4);
            if (this.f184312h.f184308s && QAlbumUtil.isGif(m06)) {
                if (aVar.N == null) {
                    TextView p06 = this.f184313i.Q.p0();
                    aVar.N = p06;
                    p06.setText("GIF");
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(11);
                    layoutParams.addRule(12);
                    ((RelativeLayout) aVar.itemView).addView(aVar.N, layoutParams);
                }
                aVar.N.setVisibility(0);
            } else {
                TextView textView = aVar.N;
                if (textView != null) {
                    textView.setVisibility(8);
                }
            }
            int i16 = AlbumThumbDownloader.THUMB_WIDHT;
            m06.thumbHeight = i16;
            m06.thumbWidth = i16;
            URLDrawable uRLDrawable = aVar.K;
            if (uRLDrawable == null || !uRLDrawable.getURL().toString().equals(QAlbumUtil.PROTOCOL_ALBUM_THUMB + QzoneWebViewOfflinePlugin.STR_DEVIDER + m06.path)) {
                URL generateAlbumThumbURL = QAlbumUtil.generateAlbumThumbURL(m06);
                if (QLog.isColorLevel()) {
                    QLog.d("QQAlbum", 2, "PhotoListAdapter,getView(),image url :" + generateAlbumThumbURL.toString());
                }
                d dVar = this.f184313i.Q;
                URLDrawable drawable = URLDrawableHelper.getDrawable(generateAlbumThumbURL, dVar.F, dVar.D);
                drawable.setTag(m06);
                imageView.setImageDrawable(drawable);
                aVar.K = drawable;
            }
            k0(aVar, view, m06);
            if (AppSetting.f99565y) {
                aVar.J.setContentDescription(QAlbumUtil.createContentDescriptionWithCheckBox(0, m06, i3, aVar.J.isChecked()));
            }
            m06.visableTime = SystemClock.uptimeMillis();
            m06.listViewPosition = i3;
            i0(aVar, m06);
        }
        return aVar;
    }
}
