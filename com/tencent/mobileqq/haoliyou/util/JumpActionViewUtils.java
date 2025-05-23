package com.tencent.mobileqq.haoliyou.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.aio.BaseForwardUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.PermissionUtil;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes7.dex */
public class JumpActionViewUtils {
    static IPatchRedirector $redirector_ = null;
    public static final String CONFIG_CHECK_URI_CAN_READ = "jump_action_view_check_uri_can_read_switch";
    private static final String TAG = "JumpActionViewUtils";

    public JumpActionViewUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static boolean checkUriCanRead(Context context, Uri uri) {
        boolean z16 = false;
        InputStream inputStream = null;
        try {
            try {
                inputStream = context.getContentResolver().openInputStream(uri);
                if (inputStream != null) {
                    if (inputStream.available() > 0) {
                        z16 = true;
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception unused) {
                    }
                }
                return z16;
            } catch (Throwable th5) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception unused2) {
                    }
                }
                throw th5;
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "checkUriCanRead catch exception: ", e16);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused3) {
                }
            }
            return false;
        }
    }

    private static boolean checkUriCanReadSwitch() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(CONFIG_CHECK_URI_CAN_READ, true);
    }

    private static Uri getActionViewUri(Intent intent) {
        if (intent == null || !CommonConstant.ACTION.HWID_SCHEME_URL.equalsIgnoreCase(intent.getAction())) {
            return null;
        }
        return intent.getData();
    }

    public static void requestStoragePermission(JumpActivity jumpActivity, Runnable runnable, Runnable runnable2) {
        if (jumpActivity != null && runnable != null) {
            if (!checkUriCanReadSwitch()) {
                runnable.run();
                return;
            }
            Uri actionViewUri = getActionViewUri(jumpActivity.getIntent());
            if (actionViewUri == null) {
                runnable.run();
                return;
            }
            boolean b16 = BaseForwardUtil.b(jumpActivity);
            QLog.i(TAG, 1, "requestStoragePermission hasSDPermission: " + b16);
            if (b16) {
                runnable.run();
                return;
            }
            boolean checkUriCanRead = checkUriCanRead(jumpActivity, actionViewUri);
            QLog.i(TAG, 1, "requestStoragePermission checkUriCanRead: " + checkUriCanRead);
            if (checkUriCanRead) {
                runnable.run();
            } else {
                PermissionUtil.requestSDCardPermission(jumpActivity, new PermissionUtil.SDCardPermissionCallback(runnable, runnable2) { // from class: com.tencent.mobileqq.haoliyou.util.JumpActionViewUtils.1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Runnable val$job;
                    final /* synthetic */ Runnable val$onReject;

                    {
                        this.val$job = runnable;
                        this.val$onReject = runnable2;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) runnable, (Object) runnable2);
                        }
                    }

                    @Override // com.tencent.util.PermissionUtil.SDCardPermissionCallback
                    public void allow() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else {
                            QLog.i(JumpActionViewUtils.TAG, 1, "requestStoragePermission allow");
                            this.val$job.run();
                        }
                    }

                    @Override // com.tencent.util.PermissionUtil.SDCardPermissionCallback
                    public void reject() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                            iPatchRedirector.redirect((short) 3, (Object) this);
                            return;
                        }
                        QLog.i(JumpActionViewUtils.TAG, 1, "requestStoragePermission reject");
                        Runnable runnable3 = this.val$onReject;
                        if (runnable3 != null) {
                            runnable3.run();
                        }
                    }
                });
            }
        }
    }
}
