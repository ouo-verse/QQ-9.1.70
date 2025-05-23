package com.tencent.mobileqq.ark.config;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes11.dex */
class e {

    /* renamed from: a, reason: collision with root package name */
    private static volatile e f199253a;

    e() {
    }

    public static e a() {
        if (f199253a == null) {
            synchronized (e.class) {
                if (f199253a == null) {
                    f199253a = new e();
                }
            }
        }
        return f199253a;
    }

    public String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Matcher matcher = Pattern.compile("^\\[(\\d+)\\]$").matcher(str);
        if (!matcher.find()) {
            return null;
        }
        return matcher.group(1);
    }

    public String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Matcher matcher = Pattern.compile("^\\[('|\")(.+)('|\")\\]$").matcher(str);
        if (!matcher.find()) {
            return null;
        }
        return matcher.group(2);
    }
}
