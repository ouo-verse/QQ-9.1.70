package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes10.dex */
public class PhotoListCustomizationNearby extends PhotoListCustomizationDefault {
    static IPatchRedirector $redirector_;
    public static final String F;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68930);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            F = PhotoListCustomizationNearby.class.getName();
        }
    }

    PhotoListCustomizationNearby(AbstractPhotoListActivity abstractPhotoListActivity) {
        super(abstractPhotoListActivity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) abstractPhotoListActivity);
        }
    }

    private boolean G0(LocalMediaInfo localMediaInfo) {
        if (localMediaInfo.mediaWidth >= 320 && localMediaInfo.mediaHeight >= 320) {
            return true;
        }
        try {
            DialogUtil.createCustomDialog(this.D, 230, (String) null, HardCodeUtil.qqStr(R.string.f172288p51), HardCodeUtil.qqStr(R.string.p4l), (String) null, (DialogInterface.OnClickListener) null, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationNearby.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhotoListCustomizationNearby.this);
                    }
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                    }
                }
            }).show();
            return false;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("PhotoListCustomizationNearby", 2, "showLocationFailDialog fail!", e16);
                return false;
            }
            return false;
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void J(View view, int i3, CheckBox checkBox) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, view, Integer.valueOf(i3), checkBox);
        } else if (G0(this.f184313i.Q.m0(i3))) {
            super.J(view, i3, checkBox);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void R(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
        } else if (intent != null) {
            super.R(intent);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase
    public String Y(LocalMediaInfo localMediaInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) localMediaInfo);
        }
        return HardCodeUtil.qqStr(R.string.i1s);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public Intent k(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Intent) iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, i3);
        }
        LocalMediaInfo m06 = this.f184313i.Q.m0(i3);
        if (this.f184313i.Q.getItemViewType(i3) == 0 && !G0(m06)) {
            return null;
        }
        return super.k(view, i3);
    }
}
