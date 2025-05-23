package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import android.util.Log;

/* compiled from: P */
/* loaded from: classes2.dex */
public class SafeStringBuilder {

    /* renamed from: a, reason: collision with root package name */
    private static final String f38020a = "SafeStringBuilder";

    /* renamed from: b, reason: collision with root package name */
    private static final String f38021b = "";

    public static String substring(StringBuilder sb5, int i3) {
        if (!TextUtils.isEmpty(sb5) && sb5.length() >= i3 && i3 >= 0) {
            try {
                return sb5.substring(i3);
            } catch (Exception e16) {
                Log.e(f38020a, "substring exception: " + e16.getMessage());
            }
        }
        return "";
    }

    public static String substring(StringBuilder sb5, int i3, int i16) {
        if (!TextUtils.isEmpty(sb5) && i3 >= 0 && i16 <= sb5.length() && i16 >= i3) {
            try {
                return sb5.substring(i3, i16);
            } catch (Exception e16) {
                Log.e(f38020a, "substring: " + e16.getMessage());
            }
        }
        return "";
    }
}
