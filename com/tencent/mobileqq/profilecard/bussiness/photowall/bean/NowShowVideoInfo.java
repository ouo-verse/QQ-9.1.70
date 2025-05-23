package com.tencent.mobileqq.profilecard.bussiness.photowall.bean;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class NowShowVideoInfo extends ProfilePhotoWall {
    static IPatchRedirector $redirector_;
    public String mCoverUrl;
    public String mJumpUrl;

    public NowShowVideoInfo(String str, String str2, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, Long.valueOf(j3));
            return;
        }
        this.type = 2;
        this.mCoverUrl = str;
        this.mJumpUrl = str2;
        this.time = j3;
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.photowall.bean.ProfilePhotoWall
    public String getOriginUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mCoverUrl;
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.photowall.bean.ProfilePhotoWall
    public String getThumbUrl(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        return this.mCoverUrl;
    }
}
