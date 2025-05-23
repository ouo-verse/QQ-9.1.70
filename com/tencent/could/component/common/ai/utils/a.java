package com.tencent.could.component.common.ai.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f100022a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14133);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f100022a = new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE, QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE};
        }
    }

    public static boolean a(Context context) {
        String[] strArr = f100022a;
        if (context == null) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        for (String str : strArr) {
            if (packageManager.checkPermission(str, packageName) != 0) {
                return false;
            }
        }
        return true;
    }
}
