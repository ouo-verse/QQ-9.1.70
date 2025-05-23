package com.tencent.mobileqq.uniformdownload.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.uniformdownload.util.UniformDownloadUtil;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes17.dex */
public class UniformDownloadNfnReceiver extends BroadcastReceiver {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static String f305832a;

    /* renamed from: b, reason: collision with root package name */
    private static int f305833b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19258);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f305832a = "UniformDownloadNfnReceiver";
            f305833b = 0;
        }
    }

    public UniformDownloadNfnReceiver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
            return;
        }
        String action = intent.getAction();
        Bundle bundleExtra = intent.getBundleExtra("_PARAM_EXTRA");
        if (action != null) {
            if (action.equals("com.tencent.mobileqq.UniformDownloadNfn.PAUSE")) {
                if (bundleExtra != null) {
                    int i3 = bundleExtra.getInt("_notify_param_Id");
                    String string = bundleExtra.getString("_notify_param_Url");
                    QLog.i(f305832a, 1, "[UniformDL] onReceive. PAUSE_DOWNLOAD: id:" + i3 + " url:" + string);
                    UniformDownloadMgr.m().w(string, bundleExtra);
                    return;
                }
                QLog.e(f305832a, 1, "[UniformDL] onReceive. PAUSE_DOWNLOAD: param = null");
                return;
            }
            if (action.equals("com.tencent.mobileqq.UniformDownloadNfn.DO_DOWNLOAD")) {
                if (bundleExtra != null) {
                    int i16 = bundleExtra.getInt("_notify_param_Id");
                    String string2 = bundleExtra.getString("_notify_param_Url");
                    QLog.i(f305832a, 1, "[UniformDL] onReceive. DO_DOWNLOAD:id:" + i16 + " url:" + string2);
                    UniformDownloadMgr.m().z(string2, bundleExtra);
                    return;
                }
                QLog.e(f305832a, 1, "[UniformDL] onReceive. DO_DOWNLOAD: param = null");
                return;
            }
            if (action.equals("com.tencent.mobileqq.UniformDownloadNfn.TRY_DOWNLOAD")) {
                if (bundleExtra != null) {
                    int i17 = bundleExtra.getInt("_notify_param_Id");
                    String string3 = bundleExtra.getString("_notify_param_Url");
                    QLog.i(f305832a, 1, "[UniformDL] onReceive. TRY_DOWNLOAD:id:" + i17 + " url:" + string3);
                    UniformDownloadMgr.m().F(string3, bundleExtra);
                    return;
                }
                QLog.e(f305832a, 1, "[UniformDL] onReceive. TRY_DOWNLOAD: param = null");
                return;
            }
            if (action.equals("com.tencent.mobileqq.UniformDownloadNfn.INSTALL")) {
                String stringExtra = intent.getStringExtra("_PARAM_FILEPATH");
                String stringExtra2 = intent.getStringExtra("_PARAM_PKGNAME");
                String stringExtra3 = intent.getStringExtra("big_brother_source_key");
                if (TextUtils.isEmpty(stringExtra3)) {
                    stringExtra3 = "biz_src_unknown";
                }
                QLog.i(f305832a, 1, "[UniformDL] onReceive. DO_INSTALL: PH:" + stringExtra + "PKGN:" + stringExtra2);
                UniformDownloadUtil.l(stringExtra, stringExtra3);
                if (stringExtra2 != null) {
                    UniformDownloadMgr.m().o().f(stringExtra2, intent.getIntExtra("_PARAM_DL_SUC_NEW_NID", 0));
                    return;
                }
                return;
            }
            if (action.equals("com.tencent.mobileqq.UniformDownloadNfn.BEDEL")) {
                if (bundleExtra != null) {
                    int i18 = bundleExtra.getInt("_notify_param_Id");
                    String string4 = bundleExtra.getString("_notify_param_Url");
                    QLog.i(f305832a, 1, "[UniformDL] onReceive. NOTIFICATION_BE_DEL: id:" + i18 + " url:" + string4);
                    UniformDownloadMgr.m().i(string4, bundleExtra);
                } else {
                    QLog.w(f305832a, 1, "[UniformDL] onReceive. NOTIFICATION_BE_DEL: param = null. may not be clean info except download succ");
                }
                String stringExtra4 = intent.getStringExtra("_PARAM_PKGNAME");
                if (stringExtra4 != null) {
                    int intExtra = intent.getIntExtra("_PARAM_DL_SUC_NEW_NID", 0);
                    QLog.i(f305832a, 1, "[UniformDL] onReceive. download suc. NOTIFICATION_BE_DEL: id:" + intExtra);
                    UniformDownloadMgr.m().o().f(stringExtra4, intExtra);
                    return;
                }
                return;
            }
            QLog.e(f305832a, 1, "[UniformDL] onReceive. unkown action:" + action);
        }
    }
}
