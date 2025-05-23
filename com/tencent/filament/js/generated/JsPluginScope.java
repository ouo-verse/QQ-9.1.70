package com.tencent.filament.js.generated;

import com.tencent.filament.zplan.plugin.FilamentZipPlugin;
import com.tencent.filament.zplan.plugin.a;
import com.tencent.filament.zplan.plugin.b;
import com.tencent.filament.zplan.plugin.c;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class JsPluginScope {
    public static final Map EVENT_HANDLERS;

    static {
        HashMap hashMap = new HashMap();
        EVENT_HANDLERS = hashMap;
        hashMap.put("unzip", FilamentZipPlugin.class);
        hashMap.put("downloadUrl", a.class);
        hashMap.put("sendMSFRequest", b.class);
        hashMap.put("getSystemInfoSync", c.class);
    }
}
