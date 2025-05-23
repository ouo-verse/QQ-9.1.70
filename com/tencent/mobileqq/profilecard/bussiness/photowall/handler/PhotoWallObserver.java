package com.tencent.mobileqq.profilecard.bussiness.photowall.handler;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes16.dex */
public class PhotoWallObserver implements BusinessObserver {
    static IPatchRedirector $redirector_ = null;
    public static final int TYPE_REQ_DEL_QZONE_PHOTOWALL = 2;
    public static final int TYPE_REQ_GET_QZONE_PHOTOWALL = 1;

    public PhotoWallObserver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void onUpdate_onDelQZonePhotoWall(int i3, boolean z16, Object obj) {
        if (i3 == 2 && obj != null) {
            onDelQZonePhotoWall(z16, (String) ((Object[]) obj)[0]);
        }
    }

    private void onUpdate_onGetQZonePhotoWall(int i3, boolean z16, Object obj) {
        if (i3 == 1 && obj != null) {
            Object[] objArr = (Object[]) obj;
            onGetQZonePhotoWall(z16, (String) objArr[0], (mobile_sub_get_photo_wall_rsp) objArr[1], (String) objArr[2]);
        }
    }

    protected void onDelQZonePhotoWall(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), str);
        }
    }

    protected void onGetQZonePhotoWall(boolean z16, String str, mobile_sub_get_photo_wall_rsp mobile_sub_get_photo_wall_rspVar, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str, mobile_sub_get_photo_wall_rspVar, str2);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
        } else {
            onUpdate_onGetQZonePhotoWall(i3, z16, obj);
            onUpdate_onDelQZonePhotoWall(i3, z16, obj);
        }
    }
}
