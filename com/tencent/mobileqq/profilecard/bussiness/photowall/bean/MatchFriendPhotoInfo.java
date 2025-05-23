package com.tencent.mobileqq.profilecard.bussiness.photowall.bean;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes16.dex */
public class MatchFriendPhotoInfo extends ProfilePhotoWall {
    static IPatchRedirector $redirector_;
    private String photoUrl;

    public MatchFriendPhotoInfo(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.photoUrl = str;
        }
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.photowall.bean.ProfilePhotoWall
    public String getOriginUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.photoUrl;
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.photowall.bean.ProfilePhotoWall
    public String getThumbUrl(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        return this.photoUrl;
    }
}
