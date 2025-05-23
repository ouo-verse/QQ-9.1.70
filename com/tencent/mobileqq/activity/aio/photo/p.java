package com.tencent.mobileqq.activity.aio.photo;

import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.richmedia.RichmediaService;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;

/* compiled from: P */
/* loaded from: classes10.dex */
public class p {
    protected static boolean a(Intent intent) {
        return RichmediaService.s(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean b(boolean z16, int i3, Intent intent) {
        if (z16) {
            if (i3 == 2) {
                SharedPreferences u16 = PlusPanelUtils.u();
                if (u16 != null && u16.edit() != null) {
                    u16.edit().putBoolean(PeakConstants.KEY_PRESEND_OFF_FLAG, true).commit();
                    u16.edit().putLong(PeakConstants.KEY_PRESEND_OFF_TIME, System.currentTimeMillis()).commit();
                }
                return true;
            }
            if (a(intent)) {
                if (QLog.isColorLevel()) {
                    QLog.d("PhotoListPanel", 2, "sendMedias,start sendPhotoAcitivy,  addPresendMgrHandlerToIntent OK");
                }
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.d("PhotoListPanel", 2, "sendMedias,start sendPhotoAcitivy,  addPresendMgrHandlerToIntent failed");
            }
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PhotoListPanel", 2, "sendMedias,start sendPhotoAcitivy, not presend");
        }
        return false;
    }
}
