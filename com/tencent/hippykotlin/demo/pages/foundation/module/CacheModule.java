package com.tencent.hippykotlin.demo.pages.foundation.module;

import com.tencent.kuikly.core.module.Module;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class CacheModule extends Module {
    public final Integer getInt(String str) {
        String item = getItem(str);
        if (item.length() > 0) {
            return Integer.valueOf(Integer.parseInt(item));
        }
        return null;
    }

    public final e getObject(String str) {
        String item = getItem(str);
        if (item.length() > 0) {
            return new e(item);
        }
        return null;
    }

    public final String getString(String str) {
        return getItem(str);
    }

    @Override // com.tencent.kuikly.core.module.Module
    public final String moduleName() {
        return "HRCacheModule";
    }

    public final void setItem(String str, String str2) {
        e eVar = new e();
        eVar.v("key", str);
        eVar.v("value", str2);
        toNative(false, "setItem", eVar.toString(), null, true);
    }

    public final String getItem(String str) {
        return toNative(false, "getItem", str, null, true).toString();
    }

    public final void setInt(String str, Integer num) {
        if (num == null) {
            setItem(str, "");
        } else {
            setItem(str, num.toString());
        }
    }

    public final void setObject(String str, e eVar) {
        if (eVar == null) {
            setItem(str, "");
        } else {
            setItem(str, eVar.toString());
        }
    }
}
