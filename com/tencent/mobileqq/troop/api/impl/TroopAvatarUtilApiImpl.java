package com.tencent.mobileqq.troop.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopAvatarUtilApiImpl implements ITroopAvatarUtilApi {
    static IPatchRedirector $redirector_;

    public TroopAvatarUtilApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi
    public String getArtWork(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        if (isAvatarUrl(str)) {
            return str + 0;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi
    public String getAvatarAddress(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, this, str, str2, Integer.valueOf(i3));
        }
        if (TextUtils.isEmpty(str2)) {
            QLog.d("TroopAvatarUtilApiImpl", 1, "getAvatarAddress troopUin is empty");
            return ITroopAvatarUtilApi.AVATAR_ADDRESS;
        }
        if (1 == i3) {
            return ITroopAvatarUtilApi.AVATAR_ADDRESS.replace(QzoneZipCacheHelper.DIR, str2).replace("file", str2 + "_" + str);
        }
        if (i3 != 0) {
            return ITroopAvatarUtilApi.AVATAR_ADDRESS;
        }
        return ITroopAvatarUtilApi.AVATAR_ADDRESS.replace(QzoneZipCacheHelper.DIR, str2).replace("file", str2);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi
    public String getThumbPhoto(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        if (isAvatarUrl(str)) {
            return str + 140;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi
    public boolean isAvatarUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str)).booleanValue();
        }
        if (str == null) {
            return false;
        }
        return str.startsWith(ITroopAvatarUtilApi.REGEXP_URL_STRING);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi
    public boolean isNumeric(String str) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str)).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if ((str.length() > 1 && str.startsWith(Marker.ANY_NON_NULL_MARKER)) || str.startsWith("-")) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        int length = str.length();
        do {
            length--;
            if (length < i3) {
                return true;
            }
        } while (Character.isDigit(str.charAt(length)));
        return false;
    }
}
