package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.os.Parcelable;
import android.util.Pair;
import android.view.View;
import com.tencent.aelight.camera.qqstory.api.IQQStoryFlowManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.PhotoCropActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.BasePhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.album.g;
import com.tencent.mobileqq.activity.photo.album.h;
import com.tencent.mobileqq.activity.photo.album.j;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.e;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes10.dex */
public class PhotoListCustomizationReadInJoy extends PhotoListCustomizationDefault {
    static IPatchRedirector $redirector_;
    public static final String G;
    private boolean F;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68941);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            G = PhotoListCustomizationReadInJoy.class.getName();
        }
    }

    PhotoListCustomizationReadInJoy(AbstractPhotoListActivity abstractPhotoListActivity) {
        super(abstractPhotoListActivity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) abstractPhotoListActivity);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void E(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
        } else {
            super.E(intent);
            this.F = intent.getBooleanExtra("readinjoy_video", false);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void G(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (!this.F) {
            super.G(i3, i16, intent);
            return;
        }
        ArrayList<String> arrayList = this.f184310e.selectedPhotoList;
        if (QLog.isDevelopLevel() && arrayList != null && arrayList.size() != 0) {
            QLog.d("QQAlbum", 4, "[NewPhotoListActivity] [onActivityResult] selectedPhotoList = " + arrayList.size());
        }
        if (i16 == -1) {
            if (this.F) {
                this.D.setResult(-1, intent);
                this.D.finish();
                return;
            }
        } else if (i3 == 17) {
            if (this.F && intent != null) {
                this.D.setResult(0, intent);
                this.D.finish();
            }
            QAlbumUtil.sLastAlbumRecordTime = 0L;
            return;
        }
        PhotoUtils.onSendResult(this.D, i3, i16, intent, this.C.F, ((h) this.f184311f).f184249h);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void P(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
            return;
        }
        if (this.F) {
            QAlbumUtil.clearSelectItemInfo();
            e.e();
            BasePhotoListActivity basePhotoListActivity = this.D;
            basePhotoListActivity.setResult(0, basePhotoListActivity.getIntent());
            this.D.finish();
            QAlbumUtil.anim(this.D, false, false);
            return;
        }
        super.P(view);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void R(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
        } else {
            super.R(intent);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void S(List<LocalMediaInfo> list, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) list, i3);
            return;
        }
        if (this.F && list != null) {
            for (int size = list.size() - 1; size >= i3; size--) {
                if (!list.get(size).path.endsWith(".mp4")) {
                    list.remove(size);
                }
            }
        }
        super.S(list, i3);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void p(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view, i3);
            return;
        }
        if (!Utils.B()) {
            BasePhotoListActivity basePhotoListActivity = this.D;
            QQToast.makeText(basePhotoListActivity, basePhotoListActivity.getResources().getString(R.string.h9v), 0).show();
            return;
        }
        LocalMediaInfo m06 = this.f184313i.Q.m0(i3);
        if (m06 == null) {
            return;
        }
        Intent intent = this.D.getIntent();
        if (m06.fileSize > this.f184310e.filter.videoSizeLimit && !this.F) {
            QQCustomDialog createNoTitleDialog = DialogUtil.createNoTitleDialog(this.D, "\u4f60\u9009\u62e9\u7684\u89c6\u9891\u6587\u4ef6\u8fc7\u5927\uff0c\u65e0\u6cd5\u53d1\u9001\u3002");
            createNoTitleDialog.setPositiveButton(R.string.f171151ok, new DialogUtil.DialogOnClickAdapter());
            createNoTitleDialog.show();
            return;
        }
        HashMap<String, Pair<String, String>> hashMap = QAlbumUtil.sSelectItemAlbum;
        if (!hashMap.containsKey(m06.path)) {
            PhotoCommonBaseData<O> photoCommonBaseData = this.f184310e;
            hashMap.put(m06.path, new Pair<>(photoCommonBaseData.albumId, photoCommonBaseData.albumName));
        }
        this.f184313i.s(m06.path);
        if (!this.C.f184243x) {
            intent.putExtra("file_send_path", m06.path);
            intent.putExtra(PeakConstants.IS_VIDEO_SELECTED, true);
            intent.putExtra(PeakConstants.VIDEO_SIZE, m06.fileSize);
            intent.putExtra(ShortVideoConstants.FILE_SEND_DURATION, m06.mDuration);
            intent.putExtra(ShortVideoConstants.FILE_WIDTH, m06.mediaWidth);
            intent.putExtra(ShortVideoConstants.FILE_HEIGHT, m06.mediaHeight);
            intent.putExtra(ShortVideoConstants.MEDIA_INFO, (Parcelable) m06);
            ArrayList arrayList = new ArrayList();
            arrayList.add(m06.path);
            if (this.F) {
                this.C.P.b();
                MediaScanner.getInstance(BaseApplication.getContext()).queryMediaInfoAsync(new MediaScanner.OnMediaInfoScannerListener(intent, arrayList) { // from class: com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationReadInJoy.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ Intent f184411d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ ArrayList f184412e;

                    {
                        this.f184411d = intent;
                        this.f184412e = arrayList;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, PhotoListCustomizationReadInJoy.this, intent, arrayList);
                        }
                    }

                    @Override // com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaInfoScannerListener
                    public void onMediaInfoChanged(LocalMediaInfo localMediaInfo, boolean z16) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, this, localMediaInfo, Boolean.valueOf(z16));
                            return;
                        }
                        ((PhotoListCustomizationDefault) PhotoListCustomizationReadInJoy.this).C.P.a();
                        if (((IQQStoryFlowManager) QRoute.api(IQQStoryFlowManager.class)).isValidMedia(((PhotoListCustomizationDefault) PhotoListCustomizationReadInJoy.this).D, localMediaInfo)) {
                            this.f184411d.putExtra(ShortVideoConstants.MEDIA_INFO, (Parcelable) localMediaInfo);
                            PhotoUtils.sendPhoto(((PhotoListCustomizationDefault) PhotoListCustomizationReadInJoy.this).D, this.f184411d, this.f184412e, 2, true);
                        }
                    }
                }, m06);
                return;
            } else {
                PhotoUtils.sendPhoto(this.D, intent, arrayList, 2, false);
                return;
            }
        }
        if (!this.f184310e.isSingleMode) {
            Intent intent2 = this.D.getIntent();
            intent2.putExtra(QAlbumConstants.ALBUM_NAME, this.f184310e.albumName);
            intent2.putExtra(QAlbumConstants.ALBUM_ID, this.f184310e.albumId);
            LocalMediaInfo m07 = this.f184313i.Q.m0(i3);
            intent2.putExtra(QAlbumConstants.CURRENT_SELECTED_INDEX, m07.position);
            intent2.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.f184310e.selectedPhotoList);
            intent2.putIntegerArrayListExtra(QAlbumConstants.SELECTED_INDEXS, this.f184310e.selectedIndex);
            intent2.putExtra("FROM_WHERE", PhotoCommonBaseData.FROM_PHOTO_LIST);
            intent2.putExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, ((h) this.f184311f).f184248f);
            intent2.putExtra(QAlbumConstants.SHOW_ALBUM, true);
            intent2.putExtra(PeakConstants.SHOW_MAGIC_USE_PASTER, this.C.A);
            intent2.putExtra("PasterConstants.paster_id", this.C.C);
            intent2.putExtra("PasterConstants.paster_cate_id", this.C.D);
            com.tencent.mobileqq.activity.photo.album.photolist.e.f184288t = this.f184313i.I.findFirstVisibleItemPosition();
            HashMap<String, LocalMediaInfo> hashMap2 = this.f184310e.selectedMediaInfoHashMap;
            if (!hashMap2.containsKey(m07.path)) {
                hashMap2.put(m07.path, m07);
            }
            intent2.putExtra("PeakConstants.selectedMediaInfoHashMap", hashMap2);
            intent2.putExtra("PasterConstants.pasters_data", this.C.B);
            intent2.setClass(this.D, NewPhotoPreviewActivity.class);
            intent2.addFlags(603979776);
            ArrayList<String> arrayList2 = this.f184310e.selectedPhotoList;
            if (arrayList2 != null && arrayList2.size() > 0) {
                ReportController.n(null, "CliOper", "", ((h) this.f184311f).f184249h, "0X8005674", "0X8005674", 0, this.f184310e.selectedPhotoList.size(), 0, "", "", "", "");
            }
            this.D.startActivity(intent2);
            this.D.finish();
            QAlbumUtil.anim(this.D, true, true);
            return;
        }
        Intent intent3 = new Intent(this.D, (Class<?>) ShortVideoPreviewActivity.class);
        intent3.putExtras(intent);
        intent3.putExtra("file_send_path", m06.path);
        intent3.putExtra(ShortVideoConstants.FILE_SEND_SIZE, m06.fileSize);
        intent3.putExtra(ShortVideoConstants.FILE_SEND_DURATION, m06.mDuration);
        intent3.putExtra(ShortVideoConstants.FILE_WIDTH, m06.mediaWidth);
        intent3.putExtra(ShortVideoConstants.FILE_HEIGHT, m06.mediaHeight);
        intent3.putExtra("uin", this.C.J);
        intent3.putExtra("uintype", this.C.H);
        intent3.putExtra(ShortVideoConstants.FILE_SOURCE, "album");
        intent3.putExtra(ShortVideoConstants.IS_FROM_SYSTEM_MEDIA, m06.isSystemMeidaStore);
        if (this.C.f184293d) {
            intent3.putExtra(QAlbumConstants.IS_SUPPORT_VIDEO_CHECKBOX, true);
            intent3.putExtra("PhotoConst.PHOTO_PATHS", this.f184310e.selectedPhotoList);
        }
        this.D.startActivityForResult(intent3, 17);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault
    public void z0(LocalMediaInfo localMediaInfo, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) localMediaInfo, i3);
            return;
        }
        e.e();
        String str = localMediaInfo.path;
        Intent intent = this.D.getIntent();
        intent.putExtra(QAlbumConstants.ALBUM_NAME, this.f184310e.albumName);
        intent.putExtra(QAlbumConstants.ALBUM_ID, this.f184310e.albumId);
        intent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
        intent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.f184310e.selectedPhotoList);
        intent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", str);
        intent.putExtra(ShortVideoConstants.MEDIA_INFO, (Parcelable) localMediaInfo);
        if (intent.getBooleanExtra(PeakConstants.MULTI_PREVIEW_IN_SINGLE_MODE, false)) {
            intent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.f184310e.mediaPathsList);
            intent.putExtra(QAlbumConstants.CURRENT_SELECTED_INDEX, i3);
        }
        g gVar = this.C;
        if (gVar.E) {
            HashMap<String, Pair<String, String>> hashMap = QAlbumUtil.sSelectItemAlbum;
            if (!hashMap.containsKey(str)) {
                PhotoCommonBaseData<O> photoCommonBaseData = this.f184310e;
                hashMap.put(str, new Pair<>(photoCommonBaseData.albumId, photoCommonBaseData.albumName));
            }
            this.f184313i.s(str);
            PhotoUtils.sendPhoto(this.D, intent, this.f184310e.selectedPhotoList, 0, this.C.f184241v);
            return;
        }
        if (!gVar.O) {
            intent.putExtra(PeakConstants.ALLOW_LOCK, false);
            intent.setClass(this.D, NewPhotoPreviewActivity.class);
            intent.putExtra("PasterConstants.pasters_data", this.C.B);
        } else {
            intent.setClass(this.D, PhotoCropActivity.class);
            j.i(intent, this.f184310e.albumId, str, this.C.f184305p);
            intent.putExtra("PHOTOLIST_START_POSITION", this.f184313i.I.findFirstVisibleItemPosition());
        }
        intent.putExtra("FROM_WHERE", PhotoCommonBaseData.FROM_PHOTO_LIST);
        intent.putExtra("PhotoConst.SOURCE_FROM", "FROM_SELECT_PHOTO");
        intent.addFlags(603979776);
        this.D.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
        this.D.startActivityForResult(intent, 10014);
        QAlbumUtil.anim(this.D, true, true);
    }
}
