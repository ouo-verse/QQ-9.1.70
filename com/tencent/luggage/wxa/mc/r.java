package com.tencent.luggage.wxa.mc;

import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class r {

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f134358d = {ModulePkgInfo.MAIN_MODULE_NAME, ModulePkgInfo.MODULE_WITHOUT_PLUGIN_CODE, ModulePkgInfo.MODULE_WITHOUT_MULTI_PLUGIN_CODE, ModulePkgInfo.PLUGIN_CODE};

    /* renamed from: a, reason: collision with root package name */
    public final String f134359a;

    /* renamed from: b, reason: collision with root package name */
    public final String f134360b;

    /* renamed from: c, reason: collision with root package name */
    public volatile String f134361c;

    public r(String str, String str2) {
        this.f134359a = str;
        this.f134360b = a(str2);
    }

    public boolean a() {
        return toString().endsWith("$__PLUGINCODE__");
    }

    public String b() {
        return this.f134359a;
    }

    public String c() {
        return this.f134360b;
    }

    public String toString() {
        String str;
        if (w0.c(this.f134361c)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.f134359a);
            if (w0.c(this.f134360b)) {
                str = "";
            } else {
                str = '$' + this.f134360b;
            }
            sb5.append(str);
            this.f134361c = sb5.toString();
        }
        return this.f134361c;
    }

    public static String a(String str) {
        return (w0.c(str) || com.tencent.luggage.wxa.u9.a.a(f134358d, str)) ? str : com.tencent.luggage.wxa.rc.m.a(str);
    }

    public r(String str, String str2, int i3) {
        if (i3 == 0) {
            this.f134360b = "";
        } else if (i3 == 6) {
            this.f134360b = ModulePkgInfo.PLUGIN_CODE;
        } else if (i3 == 12) {
            this.f134360b = ModulePkgInfo.MODULE_WITHOUT_PLUGIN_CODE;
        } else if (i3 == 13) {
            this.f134360b = a(str2) + '$' + ModulePkgInfo.MODULE_WITHOUT_PLUGIN_CODE;
        } else if (i3 == 22) {
            this.f134360b = ModulePkgInfo.MODULE_WITHOUT_MULTI_PLUGIN_CODE;
        } else if (i3 != 23) {
            this.f134360b = a(str2);
        } else {
            this.f134360b = a(str2) + '$' + ModulePkgInfo.MODULE_WITHOUT_MULTI_PLUGIN_CODE;
        }
        this.f134359a = str;
    }
}
