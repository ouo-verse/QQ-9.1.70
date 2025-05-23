package com.tencent.mobileqq.ark;

import android.text.TextUtils;
import com.tencent.ark.open.appmanage.Utility;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.api.IArkHelper;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes11.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static int f199490a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static int f199491b = 1;

    /* renamed from: c, reason: collision with root package name */
    public static int f199492c = 2;

    /* renamed from: d, reason: collision with root package name */
    public static int f199493d = 3;

    /* renamed from: e, reason: collision with root package name */
    public static int f199494e = 4;

    /* renamed from: f, reason: collision with root package name */
    public static int f199495f = 2;

    /* renamed from: g, reason: collision with root package name */
    public static int f199496g = 3;

    public static void a(QQAppInterface qQAppInterface, String str, String str2, int i3) {
        if (Utility.isValidAppName(str) && !TextUtils.isEmpty(str2)) {
            d.d("ArkApp.DataReport", String.format("appInsideClickReport, app=%s, op-name=%s, entry=%d", str, str2, Integer.valueOf(i3)));
            ((IArkHelper) QRoute.api(IArkHelper.class)).reportEvent(qQAppInterface, str, "__app__", str2, 0L, i3, 0L, 0L, 0L, "", "");
        } else {
            d.d("ArkApp.DataReport", String.format("appInsideClickReport, invalid args, app=%s, opName=%s, entry=%d", str, str2, Integer.valueOf(i3)));
        }
    }

    public static void b(QQAppInterface qQAppInterface, String str, String str2, int i3, int i16, long j3, long j16, long j17, String str3, String str4) {
        if (!TextUtils.isEmpty(str) && Utility.isValidAppName(str) && !TextUtils.isEmpty(str2)) {
            if (!"HTTPTaskResult".equals(str2)) {
                d.d("ArkApp.DataReport", String.format("platformEventReport, app=%s, op-name=%s, entry=%d, result=%d, r1=%d, r2=%d, r3=%s, r4=%s", str, str2, Integer.valueOf(i16), Integer.valueOf(i3), Long.valueOf(j16), Long.valueOf(j17), str3, str4));
            }
            ((IArkHelper) QRoute.api(IArkHelper.class)).reportEvent(qQAppInterface, str, "__platform__", str2, i3, i16, j3, j16, j17, str3, str4);
            return;
        }
        d.d("ArkApp.DataReport", String.format("platformEventReport, invalid args, app-name=%s, op-name=%s", str, str2));
    }

    public static void c(QQAppInterface qQAppInterface, String str, String str2, String str3, int i3, int i16, int i17) {
        String str4;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (str3 == null) {
                str4 = "";
            } else {
                str4 = str3;
            }
            b(qQAppInterface, str2, str, 0, i17, 0L, i3, i16, str4, "");
        }
    }
}
