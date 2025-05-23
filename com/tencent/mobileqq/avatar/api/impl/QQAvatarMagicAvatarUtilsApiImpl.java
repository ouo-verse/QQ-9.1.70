package com.tencent.mobileqq.avatar.api.impl;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.avatar.api.IQQAvatarMagicAvatarUtilsApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes11.dex */
public class QQAvatarMagicAvatarUtilsApiImpl implements IQQAvatarMagicAvatarUtilsApi {
    static IPatchRedirector $redirector_ = null;
    private static final int SYNC_QZONE_OPEN = 1;
    private static final String TAG = "magicAvatar.QQAvatarMagicAvatarUtilsApiImpl";

    public QQAvatarMagicAvatarUtilsApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarMagicAvatarUtilsApi
    public boolean getSyncQzoneSwitch(@NonNull Context context) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context)).booleanValue();
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = null;
        }
        boolean z16 = false;
        if (str == null) {
            QLog.e(TAG, 1, "getSyncQzoneSwitch uin is null");
            return false;
        }
        if (ea.f0(context, str) == 1) {
            z16 = true;
        }
        QLog.e(TAG, 1, "getSyncQzoneSwitch uin:" + StringUtil.getSimpleUinForPrint(str) + " open: " + z16);
        return z16;
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarMagicAvatarUtilsApi
    @NonNull
    public String getSyncQzoneTips(@NonNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
        return context.getString(R.string.fk6);
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarMagicAvatarUtilsApi
    public void setSyncQzoneSwitch(@NonNull Context context, boolean z16) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, Boolean.valueOf(z16));
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = null;
        }
        if (str == null) {
            QLog.e(TAG, 1, "setSyncQzoneSwitch uin is null");
            return;
        }
        QLog.e(TAG, 1, "setSyncQzoneSwitch uin:" + StringUtil.getSimpleUinForPrint(str) + " open: " + z16);
        ea.d4(context, str, z16 ? 1 : 0);
    }
}
