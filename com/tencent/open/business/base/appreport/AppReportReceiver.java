package com.tencent.open.business.base.appreport;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.assistant.sdk.remote.SDKConst;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.open.business.base.e;
import com.tencent.open.downloadnew.YybHandleUtil;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AppReportReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, final Intent intent) {
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.open.business.base.appreport.AppReportReceiver.1
            @Override // java.lang.Runnable
            public void run() {
                String str;
                try {
                    String action = intent.getAction();
                    if (action == null) {
                        return;
                    }
                    boolean booleanExtra = intent.getBooleanExtra("android.intent.extra.REPLACING", false);
                    String dataString = intent.getDataString();
                    if (dataString != null && dataString.startsWith("package:")) {
                        String substring = dataString.substring(8);
                        if (BaseApplicationImpl.getApplication() == null || BaseApplicationImpl.getApplication().getFirstSimpleAccount() == null) {
                            str = "";
                        } else {
                            str = BaseApplicationImpl.getApplication().getFirstSimpleAccount().getUin();
                        }
                        if (action.equals("android.intent.action.PACKAGE_ADDED") && !booleanExtra) {
                            if (substring.equals("com.tencent.mobileqq")) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("AppReportReceiver", 2, "mobileqq ACTION_PACKAGE_ADDED");
                                    return;
                                }
                                return;
                            } else if (substring.equals(SDKConst.SELF_PACKAGENAME)) {
                                try {
                                    e.i(context.getApplicationContext(), str);
                                } catch (Exception unused) {
                                }
                            }
                        } else if (action.equals("android.intent.action.PACKAGE_REMOVED") && !booleanExtra) {
                            if (substring.equals("com.tencent.mobileqq")) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("AppReportReceiver", 2, "mobileqq ACTION_PACKAGE_REMOVED");
                                    return;
                                }
                                return;
                            }
                        } else if (action.equals("android.intent.action.PACKAGE_REPLACED") && booleanExtra) {
                            if (substring.equals("com.tencent.mobileqq")) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("AppReportReceiver", 2, "mobileqq ACTION_PACKAGE_REPLACED deleteYYBApkPackage");
                                }
                                YybHandleUtil.b();
                                return;
                            }
                        } else {
                            return;
                        }
                        if (com.tencent.mobileqq.automator.a.f199911b && QLog.isColorLevel()) {
                            QLog.d("isFirstLaunch", 2, "firstlaunch!");
                        }
                    }
                } catch (Throwable th5) {
                    if (QLog.isColorLevel()) {
                        QLog.d("crash", 2, "", th5);
                    }
                }
            }
        });
    }
}
