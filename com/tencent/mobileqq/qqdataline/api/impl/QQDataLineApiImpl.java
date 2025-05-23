package com.tencent.mobileqq.qqdataline.api.impl;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqdataline.api.IQQDataLineApi;
import com.tencent.qqnt.kernel.nativeinterface.PeerUid;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QQDataLineApiImpl implements IQQDataLineApi {
    static IPatchRedirector $redirector_;

    public QQDataLineApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqdataline.api.IQQDataLineApi
    public String changeUid2Uin(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        if (PeerUid.DATALINE_PC_UID.equals(str)) {
            return AppConstants.DATALINE_PC_UIN;
        }
        if (PeerUid.DATALINE_PHONE_UID.equals(str)) {
            return AppConstants.DATALINE_PHONE_UIN;
        }
        if (PeerUid.DATALINE_PAD_UID.equals(str)) {
            return AppConstants.DATALINE_IPAD_UIN;
        }
        return "";
    }

    @Override // com.tencent.mobileqq.qqdataline.api.IQQDataLineApi
    public String getDeviceNameFromUid(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) str);
        }
        if (PeerUid.DATALINE_PC_UID.equals(str)) {
            return context.getString(R.string.c5f);
        }
        if (PeerUid.DATALINE_PAD_UID.equals(str)) {
            return context.getString(R.string.f16272217);
        }
        if (PeerUid.DATALINE_PHONE_UID.equals(str)) {
            return context.getString(R.string.f16273218);
        }
        return "";
    }
}
