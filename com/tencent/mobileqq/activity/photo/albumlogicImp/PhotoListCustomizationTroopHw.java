package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;

/* loaded from: classes10.dex */
public class PhotoListCustomizationTroopHw extends PhotoListCustomizationDefault {
    static IPatchRedirector $redirector_;
    public static final String H;
    private final long F;
    private final int G;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68948);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            H = PhotoListCustomizationTroopHw.class.getName();
        }
    }

    protected PhotoListCustomizationTroopHw(AbstractPhotoListActivity abstractPhotoListActivity) {
        super(abstractPhotoListActivity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) abstractPhotoListActivity);
        } else {
            this.F = 600000L;
            this.G = 1024;
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void E(Intent intent) {
        MediaFileFilter mediaFileFilter;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            return;
        }
        super.E(intent);
        PhotoCommonBaseData<O> photoCommonBaseData = this.f184310e;
        if (photoCommonBaseData != 0 && (mediaFileFilter = photoCommonBaseData.filter) != null) {
            mediaFileFilter.needHeif = true;
        }
        int intExtra = intent.getIntExtra(QAlbumConstants.PHOTOLIST_KEY_SHOW_MEDIA, 0);
        if (intExtra == 1 || intExtra == 4 || intExtra == 6) {
            this.C.f184293d = false;
        }
    }

    boolean G0(int i3) {
        try {
            LocalMediaInfo m06 = this.f184313i.Q.m0(i3);
            if (m06 != null) {
                if (m06.selectStatus != 1) {
                    return false;
                }
                return true;
            }
        } catch (Exception e16) {
            QLog.e("QQAlbum", 1, "[isCurPhotoChecked] exception = " + e16);
        }
        return false;
    }

    boolean H0(LocalMediaInfo localMediaInfo) {
        boolean z16;
        if (QAlbumUtil.getMediaType(localMediaInfo) == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && localMediaInfo.mDuration > 600000) {
            QQToast.makeText(this.D, HardCodeUtil.qqStr(R.string.p4g) + 10L + HardCodeUtil.qqStr(R.string.p4s), 0).show();
            return false;
        }
        Iterator<String> it = this.f184310e.selectedPhotoList.iterator();
        long j3 = 0;
        while (it.hasNext()) {
            j3 += FileUtils.getFileSizes(it.next());
        }
        if (j3 + FileUtils.getFileSizes(localMediaInfo.path) <= 1073741824) {
            return true;
        }
        QQToast.makeText(this.D, HardCodeUtil.qqStr(R.string.p4m) + "1.0G" + HardCodeUtil.qqStr(R.string.p5e), 0).show();
        return false;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void J(View view, int i3, CheckBox checkBox) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, view, Integer.valueOf(i3), checkBox);
            return;
        }
        LocalMediaInfo m06 = this.f184313i.Q.m0(i3);
        if (m06 == null || G0(i3) || H0(m06)) {
            super.J(view, i3, checkBox);
        }
        QLog.i("QQAlbum", 2, "[onCheckBoxClick] position = " + i3 + ", photoInfo = " + m06);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase
    public String Y(LocalMediaInfo localMediaInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) localMediaInfo);
        }
        int i3 = this.f184310e.maxSelectNum;
        if (this.C.f184293d) {
            return this.D.getString(R.string.f180543bc, Integer.valueOf(i3));
        }
        return this.D.getString(R.string.f180553bd, Integer.valueOf(i3));
    }
}
