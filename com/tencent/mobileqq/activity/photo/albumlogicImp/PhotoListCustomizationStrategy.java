package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.util.Pair;
import android.view.View;
import android.widget.CheckBox;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.BasePhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.album.h;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.photolist.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QZoneHelper;
import java.util.HashMap;

/* loaded from: classes10.dex */
public class PhotoListCustomizationStrategy extends PhotoListCustomizationAIO {
    static IPatchRedirector $redirector_;
    public static final String V;
    private long U;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68943);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            V = PhotoListCustomizationStrategy.class.getName();
        }
    }

    public PhotoListCustomizationStrategy(AbstractPhotoListActivity abstractPhotoListActivity) {
        super(abstractPhotoListActivity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) abstractPhotoListActivity);
        }
    }

    private void T0(LocalMediaInfo localMediaInfo) {
        HashMap<String, Pair<String, String>> hashMap = QAlbumUtil.sSelectItemAlbum;
        if (!hashMap.containsKey(localMediaInfo.path)) {
            PhotoCommonBaseData<O> photoCommonBaseData = this.f184310e;
            hashMap.put(localMediaInfo.path, new Pair<>(photoCommonBaseData.albumId, photoCommonBaseData.albumName));
        }
        this.f184313i.s(localMediaInfo.path);
        Intent intent = this.D.getIntent();
        intent.putExtra(QAlbumConstants.ALBUM_NAME, this.f184310e.albumName);
        intent.putExtra(QAlbumConstants.ALBUM_ID, this.f184310e.albumId);
        intent.putExtra(QAlbumConstants.CURRENT_SELECTED_INDEX, localMediaInfo.position);
        intent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.f184310e.selectedPhotoList);
        intent.putIntegerArrayListExtra(QAlbumConstants.SELECTED_INDEXS, this.f184310e.selectedIndex);
        intent.putExtra("FROM_WHERE", PhotoCommonBaseData.FROM_PHOTO_LIST);
        intent.putExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, ((h) this.f184311f).f184248f);
        intent.putExtra(QAlbumConstants.SHOW_ALBUM, true);
        intent.putExtra(PeakConstants.SHOW_MAGIC_USE_PASTER, this.C.A);
        intent.putExtra("PasterConstants.paster_id", this.C.C);
        intent.putExtra("PasterConstants.paster_cate_id", this.C.D);
        e.f184288t = this.f184313i.I.findFirstVisibleItemPosition();
        HashMap<String, LocalMediaInfo> hashMap2 = this.f184310e.selectedMediaInfoHashMap;
        if (!hashMap2.containsKey(localMediaInfo.path)) {
            hashMap2.put(localMediaInfo.path, localMediaInfo);
        }
        intent.putExtra("PeakConstants.selectedMediaInfoHashMap", hashMap2);
        intent.putExtra("PasterConstants.pasters_data", this.C.B);
        intent.setClass(this.D, NewPhotoPreviewActivity.class);
        intent.addFlags(603979776);
        this.D.startActivityForResult(intent, 17);
        QAlbumUtil.anim(this.D, true, true);
    }

    private void U0() {
        QQToast.makeText(BaseApplication.getContext(), String.format("\u4ec5\u652f\u6301\u4e0a\u4f20%dM\u4ee5\u5185\u7684\u56fe\u7247", 20), 0).show();
    }

    @Override // com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationAIO, com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void E(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            return;
        }
        super.E(intent);
        this.f184310e.filter.videoMaxDuration = intent.getLongExtra(QAlbumConstants.PHOTOLIST_KEY_FILTER_VIDEO_DURATION_LIMIT, Long.MAX_VALUE);
    }

    @Override // com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationAIO, com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.F();
        View view = this.f184313i.D;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationAIO, com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void G(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (i16 == -1 && intent != null) {
            if (i3 != 17 && i3 != 10000) {
                if (i3 == 10018) {
                    Q0(intent);
                }
            } else {
                this.D.setResult(-1, M0(intent));
                this.D.finish();
            }
        }
        QLog.i("QQAlbum", 1, "[onActivityResult] requestCode:" + i3 + ",resultCode:" + i16 + ",data:" + intent);
    }

    @Override // com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationAIO, com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void J(View view, int i3, CheckBox checkBox) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, view, Integer.valueOf(i3), checkBox);
            return;
        }
        LocalMediaInfo m06 = this.f184313i.Q.m0(i3);
        if (m06.mMediaType == 0 && m06.fileSize > QZoneHelper.Constants.NO_WIFI_UPLOAD_VIDEO_MAX_SIZE_DEFAULT) {
            U0();
        } else {
            super.J(view, i3, checkBox);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationAIO
    public boolean K0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void O(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
            return;
        }
        this.D.setResult(-1, N0());
        this.D.finish();
        QAlbumUtil.anim(this.D, false, false);
    }

    @Override // com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationAIO, com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void R(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) intent);
        } else if (this.U > QZoneHelper.Constants.NO_WIFI_UPLOAD_VIDEO_MAX_SIZE_DEFAULT) {
            U0();
        } else {
            this.D.startActivityForResult(intent, 17);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationAIO, com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public Intent k(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Intent) iPatchRedirector.redirect((short) 8, (Object) this, (Object) view, i3);
        }
        this.U = this.f184313i.Q.m0(i3).fileSize;
        return super.k(view, i3);
    }

    @Override // com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationAIO, com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void p(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view, i3);
            return;
        }
        LocalMediaInfo m06 = this.f184313i.Q.m0(i3);
        if (m06 == null) {
            return;
        }
        long j3 = this.f184310e.filter.videoMaxDuration;
        if (m06.mDuration > j3) {
            QQCustomDialog createNoTitleDialog = DialogUtil.createNoTitleDialog(this.D, String.format("\u8bf7\u9009\u62e9\u4e0d\u8d85\u8fc7%s\u5206\u949f\u7684\u89c6\u9891", Long.valueOf(j3 / 60000)));
            createNoTitleDialog.setPositiveButton(R.string.f171151ok, new DialogUtil.DialogOnClickAdapter());
            createNoTitleDialog.show();
        } else if (!Utils.B()) {
            BasePhotoListActivity basePhotoListActivity = this.D;
            QQToast.makeText(basePhotoListActivity, basePhotoListActivity.getResources().getString(R.string.h9v), 0).show();
        } else {
            try {
                T0(m06);
            } catch (Exception e16) {
                QLog.e("QQAlbum", 1, e16, new Object[0]);
            }
        }
    }
}
