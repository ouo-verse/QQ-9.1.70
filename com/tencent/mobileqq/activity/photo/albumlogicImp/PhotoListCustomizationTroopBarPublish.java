package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.tencent.aelight.camera.qqstory.api.IQQStoryFlowManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.BasePhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.album.h;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.photolist.e;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.vivo.push.PushClientConstants;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes10.dex */
public class PhotoListCustomizationTroopBarPublish extends PhotoListCustomizationDefault {
    static IPatchRedirector $redirector_;
    public static final String I;
    private String F;
    private boolean G;
    private boolean H;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68946);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            I = PhotoListCustomizationTroopBarPublish.class.getName();
        }
    }

    PhotoListCustomizationTroopBarPublish(AbstractPhotoListActivity abstractPhotoListActivity) {
        super(abstractPhotoListActivity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) abstractPhotoListActivity);
        } else {
            this.F = "";
            this.H = false;
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void E(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            return;
        }
        super.E(intent);
        this.F = intent.getStringExtra("from_tribe_class_name");
        this.G = "tribe".equals(intent.getStringExtra(PeakConstants.VIDEO_REFER));
        this.H = intent.getBooleanExtra(PeakConstants.IS_FROM_TROOP_BAR, false);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void G(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (!this.G) {
            super.G(i3, i16, intent);
            return;
        }
        ArrayList<String> arrayList = this.f184310e.selectedPhotoList;
        if (QLog.isDevelopLevel() && arrayList != null && arrayList.size() != 0) {
            QLog.d("QQAlbum", 4, "[NewPhotoListActivity] [onActivityResult] selectedPhotoList = " + arrayList.size());
        }
        if (i16 == -1 && this.G) {
            this.D.setResult(-1, intent);
            this.D.finish();
        } else {
            PhotoUtils.onSendResult(this.D, i3, i16, intent, this.C.F, ((h) this.f184311f).f184249h);
        }
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
    public void p(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view, i3);
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
        long j3 = m06.fileSize;
        MediaFileFilter mediaFileFilter = this.f184310e.filter;
        if (j3 > mediaFileFilter.videoSizeLimit) {
            QQCustomDialog createNoTitleDialog = DialogUtil.createNoTitleDialog(this.D, "\u4f60\u9009\u62e9\u7684\u89c6\u9891\u6587\u4ef6\u8fc7\u5927\uff0c\u65e0\u6cd5\u53d1\u9001\u3002");
            createNoTitleDialog.setPositiveButton(R.string.f171151ok, new DialogUtil.DialogOnClickAdapter());
            createNoTitleDialog.show();
            if (this.H) {
                String stringExtra = this.D.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
                Intent intent2 = new Intent("key_video_size_overflow");
                intent2.putExtra(PushClientConstants.TAG_CLASS_NAME, stringExtra);
                this.D.sendBroadcast(intent2);
                return;
            }
            return;
        }
        if (this.H && m06.mDuration - mediaFileFilter.videoMaxDuration > 999) {
            QQCustomDialog createNoTitleDialog2 = DialogUtil.createNoTitleDialog(this.D, HardCodeUtil.qqStr(R.string.p5l));
            createNoTitleDialog2.setPositiveButton(R.string.f171151ok, new DialogUtil.DialogOnClickAdapter());
            createNoTitleDialog2.show();
            String stringExtra2 = this.D.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
            if (this.H) {
                Intent intent3 = new Intent("key_video_time_overflow");
                intent3.putExtra(PushClientConstants.TAG_CLASS_NAME, stringExtra2);
                this.D.sendBroadcast(intent3);
                return;
            }
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
            if (this.G) {
                this.C.P.b();
                MediaScanner.getInstance(BaseApplication.getContext()).queryMediaInfoAsync(new MediaScanner.OnMediaInfoScannerListener(intent, arrayList) { // from class: com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationTroopBarPublish.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ Intent f184414d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ ArrayList f184415e;

                    {
                        this.f184414d = intent;
                        this.f184415e = arrayList;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, PhotoListCustomizationTroopBarPublish.this, intent, arrayList);
                        }
                    }

                    @Override // com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaInfoScannerListener
                    public void onMediaInfoChanged(LocalMediaInfo localMediaInfo, boolean z16) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, this, localMediaInfo, Boolean.valueOf(z16));
                            return;
                        }
                        ((PhotoListCustomizationDefault) PhotoListCustomizationTroopBarPublish.this).C.P.a();
                        if (((IQQStoryFlowManager) QRoute.api(IQQStoryFlowManager.class)).isValidMedia(((PhotoListCustomizationDefault) PhotoListCustomizationTroopBarPublish.this).D, localMediaInfo)) {
                            this.f184414d.putExtra(ShortVideoConstants.MEDIA_INFO, (Parcelable) localMediaInfo);
                            PhotoUtils.sendPhoto(((PhotoListCustomizationDefault) PhotoListCustomizationTroopBarPublish.this).D, this.f184414d, this.f184415e, 2, true);
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
            Intent intent4 = this.D.getIntent();
            intent4.putExtra(QAlbumConstants.ALBUM_NAME, this.f184310e.albumName);
            intent4.putExtra(QAlbumConstants.ALBUM_ID, this.f184310e.albumId);
            LocalMediaInfo m07 = this.f184313i.Q.m0(i3);
            intent4.putExtra(QAlbumConstants.CURRENT_SELECTED_INDEX, m07.position);
            intent4.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.f184310e.selectedPhotoList);
            intent4.putIntegerArrayListExtra(QAlbumConstants.SELECTED_INDEXS, this.f184310e.selectedIndex);
            intent4.putExtra("FROM_WHERE", PhotoCommonBaseData.FROM_PHOTO_LIST);
            intent4.putExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, ((h) this.f184311f).f184248f);
            intent4.putExtra(QAlbumConstants.SHOW_ALBUM, true);
            intent4.putExtra(PeakConstants.SHOW_MAGIC_USE_PASTER, this.C.A);
            intent4.putExtra("PasterConstants.paster_id", this.C.C);
            intent4.putExtra("PasterConstants.paster_cate_id", this.C.D);
            e.f184288t = this.f184313i.I.findFirstVisibleItemPosition();
            HashMap<String, LocalMediaInfo> hashMap2 = this.f184310e.selectedMediaInfoHashMap;
            if (!hashMap2.containsKey(m07.path)) {
                hashMap2.put(m07.path, m07);
            }
            intent4.putExtra("PeakConstants.selectedMediaInfoHashMap", hashMap2);
            intent4.putExtra("PasterConstants.pasters_data", this.C.B);
            intent4.setClass(this.D, NewPhotoPreviewActivity.class);
            intent4.addFlags(603979776);
            ArrayList<String> arrayList2 = this.f184310e.selectedPhotoList;
            if (arrayList2 != null && arrayList2.size() > 0) {
                ReportController.n(null, "CliOper", "", ((h) this.f184311f).f184249h, "0X8005674", "0X8005674", 0, this.f184310e.selectedPhotoList.size(), 0, "", "", "", "");
            }
            this.D.startActivity(intent4);
            this.D.finish();
            QAlbumUtil.anim(this.D, true, true);
            return;
        }
        Intent intent5 = new Intent(this.D, (Class<?>) ShortVideoPreviewActivity.class);
        intent5.putExtras(intent);
        intent5.putExtra("file_send_path", m06.path);
        intent5.putExtra(ShortVideoConstants.FILE_SEND_SIZE, m06.fileSize);
        intent5.putExtra(ShortVideoConstants.FILE_SEND_DURATION, m06.mDuration);
        intent5.putExtra(ShortVideoConstants.FILE_WIDTH, m06.mediaWidth);
        intent5.putExtra(ShortVideoConstants.FILE_HEIGHT, m06.mediaHeight);
        intent5.putExtra("uin", this.C.J);
        intent5.putExtra("uintype", this.C.H);
        intent5.putExtra(ShortVideoConstants.FILE_SOURCE, "album");
        intent5.putExtra(ShortVideoConstants.IS_FROM_SYSTEM_MEDIA, m06.isSystemMeidaStore);
        intent5.putExtra(PeakConstants.IS_FROM_TROOP_BAR, this.H);
        if (this.C.f184293d) {
            intent5.putExtra(QAlbumConstants.IS_SUPPORT_VIDEO_CHECKBOX, true);
            intent5.putExtra("PhotoConst.PHOTO_PATHS", this.f184310e.selectedPhotoList);
        }
        this.D.startActivityForResult(intent5, 17);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault
    public void w0(View view, Bundle bundle, int i3, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, view, bundle, Integer.valueOf(i3), intent);
            return;
        }
        super.w0(view, bundle, i3, intent);
        if (this.f184310e.selectedPhotoList.size() > 0) {
            TextUtils.isEmpty(this.F);
        }
    }
}
