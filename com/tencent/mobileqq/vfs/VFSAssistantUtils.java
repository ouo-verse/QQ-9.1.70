package com.tencent.mobileqq.vfs;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.mobileqq.inject.v;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VFSAssistantUtils {
    static IPatchRedirector $redirector_ = null;
    private static final String EVENT = "vfs_media_mount";
    private static final String KEY_EXTERNAL = "external_is_null";
    private static final String KEY_STATE = "state";
    private static final String TAG = "VFSAssistantUtils";
    private static volatile boolean externalReported;
    private static volatile String state;
    private static volatile boolean stateReported;

    public VFSAssistantUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void checkMediaState() {
        try {
            if (!"mounted".equals(state)) {
                state = Environment.getExternalStorageState();
            }
            String e16 = b.i().e();
            if (!"mounted".equals(state) && !stateReported) {
                stateReported = true;
                QLog.e(TAG, 1, "getExternalStorageState error: " + state + ", path: " + e16);
                report(e16);
                return;
            }
            if (e16 == null && !externalReported) {
                externalReported = true;
                QLog.e(TAG, 1, "getExternalStorageState error: " + state + ", path is null");
                report(null);
            }
        } catch (Exception e17) {
            QLog.e(TAG, 1, "getSDKPrivatePath is called!", e17);
        }
    }

    private static String combinePath(String str, String str2) {
        if (!str.startsWith("/") && str.indexOf(":") <= 0) {
            return str2 + File.separator + str;
        }
        if (str.startsWith(str2)) {
            return str;
        }
        if (str.startsWith(b.i().f())) {
            String[] split = str.split(b.i().f());
            if (split.length >= 2) {
                return str2 + split[1];
            }
            if (str.equals(b.i().f())) {
                return str2;
            }
        }
        QLog.e(TAG, 1, "invalid path: " + str + ", storage: " + b.i().f());
        return str;
    }

    public static String getCanonicalPath(String str) throws IOException {
        return new File(str).getCanonicalPath();
    }

    public static String getSDKPrivatePath(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        checkMediaState();
        String e16 = b.i().e();
        if (e16 == null) {
            QLog.e(TAG, 1, "external path is null");
            return str;
        }
        return combinePath(str, e16);
    }

    public static String getSandBoxPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        checkMediaState();
        String e16 = b.i().e();
        if (e16 != null) {
            return combinePath(str, e16);
        }
        QLog.e(TAG, 1, "external path is null");
        return combinePath(str, BaseApplication.getContext().getFilesDir().getPath());
    }

    private static void report(String str) {
        boolean z16;
        String str2;
        HashMap hashMap = new HashMap();
        hashMap.put("state", state);
        if (str == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        hashMap.put(KEY_EXTERNAL, String.valueOf(z16));
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str2 = peekAppRuntime.getAccount();
        } else {
            str2 = null;
        }
        v.c(str2, EVENT, hashMap);
    }
}
