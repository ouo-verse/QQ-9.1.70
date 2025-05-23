package com.huawei.secure.android.common.util;

import android.content.Context;
import android.os.Binder;
import android.os.Process;
import android.support.v4.content.PermissionChecker;
import android.util.Log;
import com.huawei.secure.android.common.exception.NoPermissionCheckerException;

/* loaded from: classes2.dex */
public class PermissionUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final String f38014a = "PermissionUtil";

    public static boolean checkCallingPermission(Context context, String str, String str2) throws NoPermissionCheckerException {
        if (Binder.getCallingPid() == Process.myPid()) {
            return false;
        }
        return checkPermission(context, str, Binder.getCallingPid(), Binder.getCallingUid(), str2);
    }

    public static boolean checkPermission(Context context, String str, int i3, int i16, String str2) throws NoPermissionCheckerException {
        try {
            if (PermissionChecker.checkPermission(context, str, i3, i16, str2) == 0) {
                return true;
            }
            return false;
        } catch (Throwable th5) {
            Log.e(f38014a, "checkPermission: " + th5.getMessage() + " , you should implementation support library or androidx library");
            throw new NoPermissionCheckerException("you should implementation support library or androidx library");
        }
    }

    public static boolean checkSelfPermission(Context context, String str) throws NoPermissionCheckerException {
        return checkPermission(context, str, Process.myPid(), Process.myUid(), context.getPackageName());
    }
}
