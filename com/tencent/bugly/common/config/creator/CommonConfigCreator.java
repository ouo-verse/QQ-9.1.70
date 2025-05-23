package com.tencent.bugly.common.config.creator;

import com.tencent.bugly.common.config.configs.CommonConfig;
import com.tencent.rmonitor.base.config.data.k;
import com.tencent.rmonitor.base.config.data.m;
import com.tencent.rmonitor.base.config.e;

/* compiled from: P */
/* loaded from: classes5.dex */
public class CommonConfigCreator implements e {
    @Override // com.tencent.rmonitor.base.config.e
    public k createConfig(String str) {
        if ("common".equals(str)) {
            return new CommonConfig(str);
        }
        return null;
    }

    @Override // com.tencent.rmonitor.base.config.e
    public m createPluginConfig(String str) {
        if ("common".equals(str)) {
            return new CommonConfig(str);
        }
        return null;
    }
}
