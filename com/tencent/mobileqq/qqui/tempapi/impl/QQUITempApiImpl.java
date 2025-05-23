package com.tencent.mobileqq.qqui.tempapi.impl;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.fileassistant.util.h;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qqui.tempapi.IQQUITempApi;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQUITempApiImpl implements IQQUITempApi {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "QQUITempApiImpl";

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQUITempApiImpl.this);
            }
        }
    }

    public QQUITempApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqui.tempapi.IQQUITempApi
    public void initUrlDrawable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqui.tempapi.IQQUITempApi
    public boolean isNewVersionDataline() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return h.o();
    }

    @Override // com.tencent.mobileqq.qqui.tempapi.IQQUITempApi
    public void requestRecordAudioPermission(Activity activity, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, activity, str, str2);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "requestRecordAudioPermission but not set permissionBusinessId!");
            str = QQPermissionConstants.Business.ID.QQ_RICH_MEDIA_RECORD_AUDIO;
        }
        if (TextUtils.isEmpty(str2)) {
            QLog.e(TAG, 1, "requestRecordAudioPermission but not set permissionBusinessScene!");
            str2 = QQPermissionConstants.Business.SCENE.RICH_MEDIA_COMMON_RECORD_AUDIO;
        }
        QQPermissionFactory.getQQPermission(activity, new BusinessConfig(str, str2)).requestPermissions(new String[]{QQPermissionConstants.Permission.RECORD_AUDIO}, 2, new a());
    }
}
