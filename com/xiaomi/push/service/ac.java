package com.xiaomi.push.service;

import com.xiaomi.push.gs;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ac {
    public static gs a(gs gsVar) {
        Map<String, String> map;
        if (gsVar != null && (map = gsVar.f24769b) != null) {
            map.remove("score_info");
        }
        return gsVar;
    }
}
