package com.tencent.qmethod.pandoraex.core;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.bugly.common.utils.DeviceInfoUtil;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static List<String> f344034a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public static List<String> f344035b = new ArrayList();

    static {
        f344034a.add("TM#G_IM");
        f344034a.add("TM#G_IM#I");
        f344034a.add("TM#G_SID");
        f344034a.add("TM#G_DID");
        f344034a.add("TM#G_DID#I");
        f344034a.add("TM#G_MID");
        f344034a.add("TM#G_MID#I");
        f344035b.add("WM#G_CON_INFO");
        f344035b.add("WI#G_BSSID");
        f344035b.add("WI#G_SSID");
        f344035b.add("WI#G_IP_ADDR");
        f344035b.add("WI#TO_STR");
        f344035b.add("NI#GET_EXT_INFO");
        f344035b.add("IA#GET_H_A");
    }

    public static boolean a(String str) {
        if (!TextUtils.isEmpty(str) && f344034a.contains(str)) {
            if (("TM#G_MID".equals(str) || "TM#G_MID#I".equals(str)) && !d()) {
                return false;
            }
            return c();
        }
        return true;
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str) || !f344035b.contains(str) || com.tencent.qmethod.pandoraex.api.q.b() == null) {
            return false;
        }
        if (com.tencent.qmethod.pandoraex.api.r.c(com.tencent.qmethod.pandoraex.api.q.b(), str + "_network_state").booleanValue()) {
            return com.tencent.qmethod.pandoraex.api.r.d(com.tencent.qmethod.pandoraex.api.q.b(), str + "_network_state").booleanValue();
        }
        return false;
    }

    private static boolean c() {
        if (Build.VERSION.SDK_INT >= 29) {
            return false;
        }
        return r.a(com.tencent.qmethod.pandoraex.api.q.b(), DeviceInfoUtil.PERMISSION_READ_PHONE);
    }

    private static boolean d() {
        if (Build.VERSION.SDK_INT >= 26) {
            return true;
        }
        return false;
    }

    public static void e(String str, boolean z16) {
        if (!TextUtils.isEmpty(str) && f344035b.contains(str) && com.tencent.qmethod.pandoraex.api.q.b() != null) {
            com.tencent.qmethod.pandoraex.api.r.m(com.tencent.qmethod.pandoraex.api.q.b(), str + "_network_state", Boolean.valueOf(z16));
        }
    }
}
