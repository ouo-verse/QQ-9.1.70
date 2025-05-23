package com.tencent.bugly.crashreport.common.config;

import com.tencent.bugly.proguard.v;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import com.tencent.bugly.proguard.z;
import com.tencent.rmonitor.base.config.data.k;
import com.tencent.rmonitor.base.config.data.m;
import com.tencent.rmonitor.base.config.e;

/* compiled from: P */
/* loaded from: classes5.dex */
public class CrashConfigCreator implements e {
    @Override // com.tencent.rmonitor.base.config.e
    public k createConfig(String str) {
        if ("crash".equals(str)) {
            return new v();
        }
        if ("emulator".equals(str)) {
            return new x();
        }
        if ("application_exit".equals(str)) {
            return new y();
        }
        if ("crash_report".equals(str)) {
            return new w();
        }
        return null;
    }

    @Override // com.tencent.rmonitor.base.config.e
    public m createPluginConfig(String str) {
        if ("http".equals(str)) {
            return new z(str);
        }
        return null;
    }
}
