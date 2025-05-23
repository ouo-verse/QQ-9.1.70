package com.tencent.qqconnect.wtlogin.impl;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.qqconnect.wtlogin.IOpenSdkQQLiteBridgeApi;
import com.tencent.qqconnect.wtlogin.d;
import cooperation.peak.PeakConstants;
import hp3.f;

/* compiled from: P */
/* loaded from: classes22.dex */
public class OpenSdkQQLiteBridgeApiImpl implements IOpenSdkQQLiteBridgeApi {
    static IPatchRedirector $redirector_;

    public OpenSdkQQLiteBridgeApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqconnect.wtlogin.IOpenSdkQQLiteBridgeApi
    public Object fetchQQLiteStatus(f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, (Object) fVar);
        }
        return d.c(fVar);
    }

    @Override // com.tencent.qqconnect.wtlogin.IOpenSdkQQLiteBridgeApi
    public void startPhotoListEdit(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(PeakConstants.PHOTO_LIST_SHOW_PREVIEW, true);
        intent.putExtra("Business_Origin", 103);
        intent.putExtra("BUSINESS_ORIGIN_NEW", 103);
        intent.putExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", true);
        intent.putExtra("fromWhereClick", PhotoCommonBaseData.FROM_PHOTO_LIST);
        int x16 = ProfileCardUtil.x(activity);
        PhotoUtils.startPhotoListEdit(intent, activity, activity.getClass().getName(), x16, x16, 1080, 1080, FaceUtil.getUploadAvatarTempPath());
    }
}
