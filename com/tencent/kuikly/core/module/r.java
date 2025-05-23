package com.tencent.kuikly.core.module;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002J\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0017\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0016\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/kuikly/core/module/r;", "Lcom/tencent/kuikly/core/module/Module;", "", "moduleName", "key", "value", "", "a", "", "setInt", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getString", "getInt", "(Ljava/lang/String;)Ljava/lang/Integer;", "getItem", "setItem", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class r extends Module {
    public final void a(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        setItem(key, value);
    }

    public final Integer getInt(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        String item = getItem(key);
        if (item.length() > 0) {
            return Integer.valueOf(Integer.parseInt(item));
        }
        return null;
    }

    public final String getItem(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return toNative(false, "getItem", key, null, true).toString();
    }

    public final String getString(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return getItem(key);
    }

    @Override // com.tencent.kuikly.core.module.Module
    public String moduleName() {
        return "KRSharedPreferencesModule";
    }

    public final void setInt(String key, Integer value) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (value == null) {
            setItem(key, "");
        } else {
            setItem(key, value.toString());
        }
    }

    public final void setItem(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
        eVar.v("key", key);
        eVar.v("value", value);
        toNative(false, "setItem", eVar.toString(), null, true);
    }
}
