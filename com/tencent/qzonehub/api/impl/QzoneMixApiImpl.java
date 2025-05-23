package com.tencent.qzonehub.api.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.pluginsdk.IPluginActivity;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQzoneMixApi;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.SharpPDec;
import cooperation.qzone.util.QZoneDistributedAppCtrl;
import cooperation.qzone.util.QzonePublicAccountHelper;
import java.util.Map;
import mqq.app.QQPermissionCallback;

/* compiled from: P */
/* loaded from: classes34.dex */
public class QzoneMixApiImpl implements IQzoneMixApi {
    private static final String TAG = "QzoneMixApiImpl";

    @Override // com.tencent.qzonehub.api.IQzoneMixApi
    public void broadcastFollowIfNeed(Context context, String str, int i3) {
        QzonePublicAccountHelper.broadcastFollowIfNeed(context, str, i3);
    }

    @Override // com.tencent.qzonehub.api.IQzoneMixApi
    public void execCtrlCommand(String str, int i3, Map<String, String> map) {
        QZoneDistributedAppCtrl.Control control = new QZoneDistributedAppCtrl.Control();
        control.cmd = i3;
        control.data.putAll(map);
        QZoneDistributedAppCtrl.getInstance(str).submitCtrl(control);
    }

    @Override // com.tencent.qzonehub.api.IQzoneMixApi
    public int getVersion() {
        return SharpPDec.getVersion();
    }

    @Override // com.tencent.qzonehub.api.IQzoneMixApi
    public int isSupportSharpP(Context context) {
        try {
            return SharpPDec.isSupportSharpP(context);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
            return 1;
        }
    }

    @Override // com.tencent.qzonehub.api.IQzoneMixApi
    public boolean requestStoragePermission(Activity activity, QQPermissionCallback qQPermissionCallback, int i3) {
        if (activity != null && (activity instanceof QzonePluginProxyActivity)) {
            if (activity.checkSelfPermission(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE) == 0 && activity.checkSelfPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0) {
                return true;
            }
            IPluginActivity realPluginActivity = ((QzonePluginProxyActivity) activity).getRealPluginActivity();
            if (realPluginActivity != null) {
                realPluginActivity.requestPermissions(qQPermissionCallback, i3, QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE);
            }
        }
        return false;
    }

    @Override // com.tencent.qzonehub.api.IQzoneMixApi
    public void broadcastBannerGameRedDot(Context context, Bundle bundle) {
    }
}
