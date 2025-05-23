package com.tencent.mobileqq.profilecard.bussiness.photowall.bean;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes16.dex */
public abstract class ProfilePhotoWall {
    static IPatchRedirector $redirector_ = null;
    public static final int TYPE_GUILD_CHANNEL = 3;
    public static final int TYPE_NOW_PHOTO = 2;
    public static final int TYPE_QZONE_PHOTO_WALL = 1;
    public long time;
    public int type;
    public String uin;

    public ProfilePhotoWall() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract String getOriginUrl();

    public abstract String getThumbUrl(int i3);
}
