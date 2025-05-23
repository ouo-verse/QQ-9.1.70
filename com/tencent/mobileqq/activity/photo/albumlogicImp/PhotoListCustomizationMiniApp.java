package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.CompoundButton;
import com.tencent.component.media.image.ImageManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.BasePhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.album.h;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.photo.m;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.e;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes10.dex */
public class PhotoListCustomizationMiniApp extends PhotoListCustomizationDefault {
    static IPatchRedirector $redirector_;
    public static final String H;
    private boolean F;
    private int G;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68928);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            H = PhotoListCustomizationMiniApp.class.getName();
        }
    }

    PhotoListCustomizationMiniApp(AbstractPhotoListActivity abstractPhotoListActivity) {
        super(abstractPhotoListActivity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) abstractPhotoListActivity);
        } else {
            this.F = false;
            this.G = 0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault
    protected void B0(Intent intent, boolean z16, ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, intent, Boolean.valueOf(z16), arrayList);
            return;
        }
        HashMap hashMap = new HashMap();
        int i3 = 0;
        for (int i16 = 0; i16 < arrayList.size(); i16++) {
            String str = arrayList.get(i16);
            if (!ImageManager.isNetworkUrl(str)) {
                int b16 = ((h) this.f184311f).b(this.f184310e, str);
                LocalMediaInfo a16 = ((h) this.f184311f).a(this.f184310e, str);
                if (b16 == 1 && a16 != null) {
                    hashMap.put(Integer.valueOf(i3), a16);
                }
                i3++;
            }
        }
        if (!hashMap.isEmpty()) {
            intent.putExtra(PeakConstants.VIDEO_INFO, hashMap);
        }
        intent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", arrayList);
        intent.putExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, ((h) this.f184311f).f184248f);
        intent.setComponent(null);
        intent.setAction(intent.getStringExtra(PeakConstants.DEST_BROADCAST_ACTION_NAME));
        intent.setFlags(intent.getFlags() & (-536870913) & (-67108865));
        try {
            this.D.sendBroadcast(intent);
            this.D.finish();
        } catch (Exception e16) {
            QLog.d("PhotoListCustomizationMiniApp", 1, "sendPhoto fail!", e16);
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
        this.F = intent.getBooleanExtra("from_miniapp_enable_bottombar", false);
        this.G = intent.getIntExtra("from_miniapp_cur_sizetype", 0);
        this.f184310e.filter.videoMaxDuration = intent.getLongExtra(QAlbumConstants.PHOTOLIST_KEY_FILTER_VIDEO_DURATION_LIMIT, Long.MAX_VALUE);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.F();
        if (this.F) {
            this.f184313i.D.setVisibility(0);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void G(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (i16 != -1 && i3 == 10001 && intent != null) {
            String stringExtra = intent.getStringExtra(PeakConstants.FROM_QQSTORY_SLIDESHOW_FILE_DATA);
            if (!TextUtils.isEmpty(stringExtra)) {
                FileUtils.deleteDirectory(new File(stringExtra).getParent());
            }
            this.D.setResult(0, intent);
            this.D.finish();
        }
        super.G(i3, i16, intent);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void M(CompoundButton compoundButton, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, compoundButton, Boolean.valueOf(z16));
        } else if (z16) {
            ((h) this.f184311f).f184248f = 2;
        } else {
            ((h) this.f184311f).f184248f = 0;
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void P(View view) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
            return;
        }
        Intent intent = this.D.getIntent();
        QAlbumUtil.clearSelectItemInfo();
        e.e();
        PresendPicMgr f16 = PresendPicMgr.f();
        if (f16 != null) {
            f16.a(1006);
        }
        ArrayList<String> arrayList = this.f184310e.selectedPhotoList;
        if (arrayList != null) {
            i3 = arrayList.size();
        } else {
            i3 = 0;
        }
        m.e(intent, i3);
        if (!this.C.G) {
            this.D.finish();
            QAlbumUtil.anim(this.D, false, false);
            return;
        }
        QLog.e("PhotoListCustomizationMiniApp", 2, "onTitleBtnRightClick");
        Intent intent2 = new Intent();
        String stringExtra = intent.getStringExtra(PeakConstants.DEST_BROADCAST_ACTION_NAME);
        if (QLog.isColorLevel()) {
            QLog.d("PhotoListCustomizationMiniApp", 2, String.format("sendPhoto action=%s", stringExtra));
        }
        if (!TextUtils.isEmpty(stringExtra)) {
            if (QLog.isColorLevel()) {
                QLog.d("PhotoListCustomizationMiniApp", 2, String.format("sendPhoto extras=%s", intent.getExtras()));
            }
            intent2.setComponent(null);
            intent2.setAction(stringExtra);
            intent2.setFlags(intent.getFlags() & (-536870913) & (-67108865));
            this.D.sendBroadcast(intent2);
            this.D.finish();
            QAlbumUtil.anim(this.D, false, false);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase
    public String Y(LocalMediaInfo localMediaInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) localMediaInfo);
        }
        PhotoCommonBaseData<O> photoCommonBaseData = this.f184310e;
        int i3 = photoCommonBaseData.maxSelectNum;
        int i16 = photoCommonBaseData.showMediaType;
        if (i16 == 6) {
            return this.D.getResources().getString(R.string.w2l, Integer.valueOf(i3));
        }
        if (i16 == 2) {
            return this.D.getResources().getString(R.string.w2o, Integer.valueOf(i3));
        }
        return super.Y(localMediaInfo);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public Intent k(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Intent) iPatchRedirector.redirect((short) 6, (Object) this, (Object) view, i3);
        }
        Intent k3 = super.k(view, i3);
        k3.putExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, ((h) this.f184311f).f184248f);
        k3.putExtra("from_miniapp_cur_sizetype", this.G);
        return k3;
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
        long j3 = m06.fileSize;
        MediaFileFilter mediaFileFilter = this.f184310e.filter;
        if (j3 > mediaFileFilter.videoSizeLimit) {
            QQCustomDialog createNoTitleDialog = DialogUtil.createNoTitleDialog(this.D, "\u8bf7\u9009\u62e9\u4e0d\u8d85\u8fc7" + (((((float) this.f184310e.filter.videoSizeLimit) / 1024.0f) / 1024.0f) / 1024.0f) + "G\u7684\u89c6\u9891");
            createNoTitleDialog.setPositiveButton(R.string.f171151ok, new DialogUtil.DialogOnClickAdapter());
            createNoTitleDialog.show();
            return;
        }
        if (m06.mDuration > mediaFileFilter.videoMaxDuration) {
            QQCustomDialog createNoTitleDialog2 = DialogUtil.createNoTitleDialog(this.D, "\u8bf7\u9009\u62e9\u4e0d\u8d85\u8fc7" + ((this.f184310e.filter.videoMaxDuration / 60) / 1000) + "\u5206\u949f\u7684\u89c6\u9891");
            createNoTitleDialog2.setPositiveButton(R.string.f171151ok, new DialogUtil.DialogOnClickAdapter());
            createNoTitleDialog2.show();
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
            PhotoUtils.sendPhoto(this.D, intent, arrayList, 2, false);
            return;
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
}
