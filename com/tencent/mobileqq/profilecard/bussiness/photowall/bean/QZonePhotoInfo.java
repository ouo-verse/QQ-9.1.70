package com.tencent.mobileqq.profilecard.bussiness.photowall.bean;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;

/* loaded from: classes16.dex */
public class QZonePhotoInfo extends ProfilePhotoWall {
    static IPatchRedirector $redirector_;
    public String photoId;
    public Map<Integer, String> photoUrls;

    public QZonePhotoInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.type = 1;
        }
    }

    private String getOther(int i3) {
        String str = null;
        for (int i16 = 1; TextUtils.isEmpty(str) && i16 < 5; i16++) {
            str = this.photoUrls.get(Integer.valueOf((i3 + i16) % 5));
        }
        return str;
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.photowall.bean.ProfilePhotoWall
    public String getOriginUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        Map<Integer, String> map = this.photoUrls;
        if (map != null) {
            String str = map.get(1);
            if (TextUtils.isEmpty(str)) {
                return getOther(1);
            }
            return str;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.photowall.bean.ProfilePhotoWall
    public String getThumbUrl(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 3;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        Map<Integer, String> map = this.photoUrls;
        if (map != null) {
            if (i3 > 100) {
                i16 = 2;
            }
            String str = map.get(Integer.valueOf(i16));
            if (TextUtils.isEmpty(str)) {
                return getOther(i16);
            }
            return str;
        }
        return null;
    }
}
