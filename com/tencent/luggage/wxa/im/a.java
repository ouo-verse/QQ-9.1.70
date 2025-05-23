package com.tencent.luggage.wxa.im;

import android.text.TextUtils;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;

/* compiled from: P */
/* loaded from: classes8.dex */
public enum a {
    INST;

    public static a b() {
        return INST;
    }

    public boolean a(String str, boolean z16, boolean z17, boolean z18) {
        return z16;
    }

    public final String c() {
        return hashCode() + "";
    }

    public int a(String str, int i3) {
        return a(str, i3, true);
    }

    public int a(String str, int i3, boolean z16) {
        return a(str, i3, z16, true);
    }

    public int a(String str, int i3, boolean z16, boolean z17) {
        String a16 = a(str, "", z16, z17);
        return w0.c(a16) ? i3 : w0.a(a16, i3);
    }

    public boolean a(String str, boolean z16) {
        return a(str, z16, true, true);
    }

    public String a(String str, String str2, boolean z16, boolean z17) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        String str3 = "1";
        if (!"clicfg_canvas_use_magic_brush".equals(str) && !"clicfg_appbrand_native_socket_wcwss".equals(str) && !"clicfg_appbrand_native_readfile".equals(str)) {
            if ("clicfg_appbrand_native_download".equals(str)) {
                str3 = "0";
            } else if (!"clicfg_enable_appbrand_uploadfile_binding_android".equals(str) && !"clicfg_enable_appbrand_downloadfile_binding_android".equals(str) && !"clicfg_enable_appbrand_request_newcronet_binding_android".equals(str)) {
                str3 = str2;
            }
        }
        if (z17) {
            w.d("ExptManager", "%s get mulit expt result[%s] key[%s] def[%s] ", c(), str3, str, str2);
        }
        return str3;
    }
}
