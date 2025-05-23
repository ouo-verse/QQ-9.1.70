package com.tencent.luggage.wxa.yq;

import com.tencent.luggage.wxa.ar.w;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.ar.y;
import com.tencent.xweb.xwalk.plugin.XWalkPlugin;
import com.tencent.xweb.xwalk.plugin.XWalkPluginManager;
import java.io.File;

/* compiled from: P */
/* loaded from: classes9.dex */
public class c extends d {

    /* renamed from: n, reason: collision with root package name */
    public String f146064n;

    public c(String str, int i3) {
        super(i3);
        this.f146064n = str;
    }

    @Override // com.tencent.luggage.wxa.yq.d, com.tencent.luggage.wxa.yq.a
    public boolean a(String str, String str2) {
        x0.d("LibPluginUpdateConfig", "copyPackageToLocal, pluginName:" + this.f146064n + ", fileName:" + str);
        String a16 = a(str);
        if (a16 == null) {
            x0.a("LibPluginUpdateConfig", "can not find so file");
            return false;
        }
        String b16 = b();
        if (b16 != null && !b16.isEmpty()) {
            String str3 = a16 + File.separator + str;
            x0.d("LibPluginUpdateConfig", "copyPackageToLocal, src file path:" + str3);
            File file = new File(str3);
            File file2 = new File(b16);
            if (file2.exists()) {
                if (y.a(file2.getAbsolutePath(), str2)) {
                    x0.a("LibPluginUpdateConfig", "copyPackageToLocal, already have file and md5 matched");
                    return true;
                }
                x0.a("LibPluginUpdateConfig", "copyPackageToLocal, already have file but md5 not matched");
                file2.delete();
            }
            if (!file.exists()) {
                x0.a("LibPluginUpdateConfig", "copyPackageToLocal, src file not find, path:" + str3);
                return false;
            }
            if (w.a(file, file2)) {
                return true;
            }
            x0.a("LibPluginUpdateConfig", "copyPackageToLocal, copy file failed");
            return false;
        }
        x0.a("LibPluginUpdateConfig", "download path is empty");
        return false;
    }

    @Override // com.tencent.luggage.wxa.yq.a, com.tencent.luggage.wxa.yq.f
    public String b() {
        XWalkPlugin plugin = XWalkPluginManager.getPlugin(this.f146064n);
        if (plugin == null) {
            x0.c("LibPluginUpdateConfig", "getDownloadPath error, plugin is null");
            return "";
        }
        return plugin.getDownloadFullPath(this.f146073h, false);
    }
}
