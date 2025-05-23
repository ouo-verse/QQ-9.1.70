package com.tencent.mobileqq.profilecard.bussiness.photowall.constant;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes16.dex */
public class PhotoWallConstant {
    static IPatchRedirector $redirector_ = null;
    public static final String CMD_DEL_PHOTO_WALL = "SQQzoneSvc.delPhotoWall";
    public static final String CMD_GET_NOW_LIVE_GALLARY = "ilive.photo_wall";
    public static final String CMD_GET_PHOTO_WALL = "SQQzoneSvc.getPhotoWall";
    public static final int REQUEST_EDIT_PHOTO_WALL = 100;

    public PhotoWallConstant() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
