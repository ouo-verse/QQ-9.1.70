package com.tencent.could.huiyansdk.utils;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;

/* compiled from: P */
/* loaded from: classes5.dex */
public class m {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f100310a;

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f100311b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12935);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f100310a = new String[]{QQPermissionConstants.Permission.CAMERA};
            f100311b = new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE, QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE};
        }
    }

    public static boolean a(Context context, String[] strArr) {
        for (String str : strArr) {
            if (ContextCompat.checkSelfPermission(context, str) != 0) {
                return false;
            }
        }
        return true;
    }
}
