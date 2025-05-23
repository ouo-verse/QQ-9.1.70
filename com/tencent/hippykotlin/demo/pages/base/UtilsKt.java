package com.tencent.hippykotlin.demo.pages.base;

import com.tencent.kuikly.core.nvi.serialization.json.e;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class UtilsKt {
    public static final String getValueFromParams(e eVar, String str) {
        if (eVar == null) {
            return "";
        }
        if (eVar.a(str)) {
            return eVar.p(str);
        }
        e m3 = eVar.m("ext_userdata");
        if (m3 == null) {
            m3 = new e();
        }
        if (m3.a(str)) {
            return m3.p(str);
        }
        e m16 = eVar.m("userData");
        if (m16 == null) {
            m16 = new e();
        }
        if (!m16.a(str)) {
            return "";
        }
        return m16.p(str);
    }
}
