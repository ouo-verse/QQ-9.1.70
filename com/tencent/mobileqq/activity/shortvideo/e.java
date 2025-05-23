package com.tencent.mobileqq.activity.shortvideo;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes10.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static AtomicBoolean f186320a = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name */
    public static String[] f186321b = {"MI 3", "Coolpad 8675", "OPPO R7", "Redmi Note 2", "MX4", "vivo X5L", "m3 note", "PRO 6"};

    /* renamed from: c, reason: collision with root package name */
    private static ArrayList<String> f186322c = null;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f186323d = false;

    public static void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (Integer.valueOf(str).intValue() == 0) {
                    f186320a.set(false);
                } else {
                    f186320a.set(true);
                }
            } catch (Exception unused) {
                f186320a.set(false);
            }
        } else {
            f186320a.set(false);
        }
        if (QLog.isColorLevel()) {
            QLog.d("ShortVideo.ProgressiveUtils", 2, "parseConfig(): config = " + str + ", sProgressiveEnable = " + f186320a.get());
        }
    }
}
