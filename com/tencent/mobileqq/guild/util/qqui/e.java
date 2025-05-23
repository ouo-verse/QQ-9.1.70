package com.tencent.mobileqq.guild.util.qqui;

import android.content.Context;
import com.tencent.bugly.common.utils.DeviceInfoUtil;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;

/* compiled from: P */
/* loaded from: classes14.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f235610a = {QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE, DeviceInfoUtil.PERMISSION_READ_PHONE};

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f235611b = {QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE, QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE};

    /* renamed from: c, reason: collision with root package name */
    private static boolean f235612c;

    public static boolean a(Context context) {
        boolean z16 = f235612c;
        if (!z16 && context != null && context.checkSelfPermission(f235610a[0]) == 0) {
            f235612c = true;
            return true;
        }
        return z16;
    }
}
