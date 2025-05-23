package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.BasePhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.album.h;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.photo.m;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.weiyun.utils.c;
import cooperation.peak.PeakConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes10.dex */
public class PhotoListCustomizationWeiyun extends PhotoListCustomizationDefault {
    static IPatchRedirector $redirector_;
    public static final String G;
    private boolean F;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68949);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            G = PhotoListCustomizationWeiyun.class.getName();
        }
    }

    PhotoListCustomizationWeiyun(AbstractPhotoListActivity abstractPhotoListActivity) {
        super(abstractPhotoListActivity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) abstractPhotoListActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault
    public void C0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        BasePhotoListActivity basePhotoListActivity = this.D;
        if (basePhotoListActivity != null && !basePhotoListActivity.isFinishing()) {
            if (this.f184310e.albumId.equals(QAlbumCustomAlbumConstants.RECENT_ALBUM_ID)) {
                StatisticCollector.getInstance(basePhotoListActivity).collectPerformance(null, "sendAlbumRecent", true, 0L, 0L, null, "");
            } else if (!this.f184310e.albumName.equalsIgnoreCase("Camera") && !this.f184310e.albumName.equalsIgnoreCase("camera") && !this.f184310e.albumName.contains("Camera") && !this.f184310e.albumName.contains("camera")) {
                StatisticCollector.getInstance(basePhotoListActivity).collectPerformance(null, "sendAlbumOther", true, 0L, 0L, null, "");
            } else {
                StatisticCollector.getInstance(basePhotoListActivity).collectPerformance(null, "sendAlbumRecent", false, 0L, 0L, null, "");
            }
            if (this.f184310e.selectedPhotoList != null) {
                m.n(basePhotoListActivity.getIntent(), this.f184310e.selectedPhotoList.size());
                m.i(basePhotoListActivity.getIntent(), this.f184310e.selectedPhotoList.size(), ((h) this.f184311f).f184248f);
            }
            Intent intent = new Intent();
            ArrayList<String> arrayList = this.f184310e.selectedPhotoList;
            if (arrayList == null) {
                arrayList = new ArrayList<>(0);
            }
            intent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", arrayList);
            basePhotoListActivity.setResult(-1, intent);
            basePhotoListActivity.finish();
            QAlbumUtil.anim(basePhotoListActivity, false, false);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void E(Intent intent) {
        List<String> j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            return;
        }
        super.E(intent);
        BasePhotoListActivity basePhotoListActivity = this.D;
        if (basePhotoListActivity != null && !basePhotoListActivity.isFinishing()) {
            this.f184310e.albumName = intent.getStringExtra(QAlbumConstants.ALBUM_NAME);
            String a16 = c.a(basePhotoListActivity.getApplicationContext(), ((h) this.f184311f).f184249h, "pref_select_album");
            if (!TextUtils.isEmpty(a16) && (j3 = c.j(a16)) != null && !j3.isEmpty()) {
                this.f184310e.albumId = j3.get(0);
            }
            this.C.f184305p = false;
            this.F = intent.getBooleanExtra(PeakConstants.ENTER_ALBUM_LIST, false);
            this.f184310e.filter.needVideo = false;
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.F();
        BasePhotoListActivity basePhotoListActivity = this.D;
        if (basePhotoListActivity != null && !basePhotoListActivity.isFinishing()) {
            View findViewById = basePhotoListActivity.findViewById(R.id.ivTitleBtnLeft);
            if (findViewById != null) {
                findViewById.setContentDescription(basePhotoListActivity.getString(R.string.ih6));
            }
            if (this.F) {
                u(basePhotoListActivity.getIntent());
                this.f184313i.c(true);
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void G(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        BasePhotoListActivity basePhotoListActivity = this.D;
        if (basePhotoListActivity != null && !basePhotoListActivity.isFinishing() && i3 == 10010 && i16 == -1) {
            Intent intent2 = new Intent();
            ArrayList<String> arrayList = this.f184310e.selectedPhotoList;
            if (arrayList == null) {
                arrayList = new ArrayList<>(0);
            }
            intent2.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", arrayList);
            basePhotoListActivity.setResult(-1, intent2);
            basePhotoListActivity.finish();
            QAlbumUtil.anim(basePhotoListActivity, false, false);
        }
        super.G(i3, i16, intent);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.f
    public void H(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
        } else if (this.F && !z16) {
            P(null);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void P(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
            return;
        }
        BasePhotoListActivity basePhotoListActivity = this.D;
        if (basePhotoListActivity != null && !basePhotoListActivity.isFinishing()) {
            basePhotoListActivity.setResult(-1, new Intent());
        }
        super.P(view);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void R(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
            return;
        }
        BasePhotoListActivity basePhotoListActivity = this.D;
        if (basePhotoListActivity != null && !basePhotoListActivity.isFinishing()) {
            basePhotoListActivity.startActivityForResult(intent, 10010);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void S(List<LocalMediaInfo> list, int i3) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) list, i3);
            return;
        }
        int size = list.size();
        ArrayList<String> stringArrayListExtra = this.D.getIntent().getStringArrayListExtra(PeakConstants.WEIYUN_FILTER_DATA);
        if (stringArrayListExtra != null) {
            for (int i16 = size - 1; i16 >= i3; i16--) {
                LocalMediaInfo localMediaInfo = list.get(i16);
                String substring = localMediaInfo.path.substring(localMediaInfo.path.lastIndexOf("/") + 1);
                File file = new File(localMediaInfo.path);
                if (file.exists()) {
                    str = substring + file.length();
                } else {
                    str = substring + localMediaInfo.fileSize;
                }
                if (stringArrayListExtra.contains(str)) {
                    list.remove(i16);
                }
            }
        }
        super.S(list, i3);
    }
}
