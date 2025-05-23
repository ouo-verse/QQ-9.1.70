package com.tencent.mobileqq.vas.config.business.qvip;

import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.msgnotify.api.IMsgNotifyPushDialog;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes20.dex */
public class PushOpenNotificationProcessor extends BaseQVipConfigProcessor<PushOpenNotificationConfig> {
    public static final int CMD = 95;
    private static final String TAG = "PushOpenNotificationProcessor";

    @Override // com.tencent.mobileqq.config.l
    public Class<PushOpenNotificationConfig> clazz() {
        return PushOpenNotificationConfig.class;
    }

    @Override // com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor, com.tencent.mobileqq.config.l
    public boolean isNeedCompressed() {
        return false;
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 95;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor
    @NonNull
    public PushOpenNotificationConfig migrateDefaultContent() {
        return new PushOpenNotificationConfig();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor
    @NonNull
    public PushOpenNotificationConfig migrateOldContent() {
        return new PushOpenNotificationConfig();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor
    @NonNull
    public PushOpenNotificationConfig parsed(ai[] aiVarArr) {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        int length = aiVarArr.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            String str = aiVarArr[i3].f202268b;
            if (QLog.isColorLevel()) {
                QLog.i("PushOpenNotify", 2, "config :" + str);
            }
            if (!TextUtils.isEmpty(str)) {
                ((IMsgNotifyPushDialog) QRoute.api(IMsgNotifyPushDialog.class)).parsePushOpenNotifyXML(waitAppRuntime, str, false);
                PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit().putString(waitAppRuntime.getCurrentUin() + "_" + AppConstants.Preferences.PUSH_OPEN_NOTIFY_XML, str).commit();
                break;
            }
            i3++;
        }
        return new PushOpenNotificationConfig();
    }
}
