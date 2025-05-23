package com.tencent.biz.qqstory.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b implements e {

    /* renamed from: a, reason: collision with root package name */
    protected AtomicBoolean f94035a = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name */
    protected SharedPreferences f94036b;

    private void b() {
        if (this.f94035a.get()) {
        } else {
            throw new IllegalStateException("have not attachContext");
        }
    }

    private void e(@Nullable String str, @Nullable Object obj, @Nullable String str2) {
        String name;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("key=");
        sb5.append(str);
        sb5.append(" expected ");
        sb5.append(str2);
        sb5.append(" but value was ");
        if (obj == null) {
            name = "null";
        } else {
            name = obj.getClass().getName();
        }
        sb5.append(name);
        hd0.c.t("ConfigManager", sb5.toString());
    }

    public void a(Context context) {
        if (context != null) {
            if (this.f94035a.compareAndSet(false, true)) {
                hd0.c.a("ConfigManager", "attachContext, " + context);
                this.f94036b = context.getSharedPreferences("qqstory_config", 4);
                return;
            }
            hd0.c.t("ConfigManager", "attachContext duplicate");
            return;
        }
        throw new IllegalArgumentException("Context should not be null");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <V> V c(@NonNull String str, @NonNull V v3) {
        V v16;
        b();
        if (v3.getClass() == Integer.class) {
            v16 = (V) Integer.valueOf(this.f94036b.getInt(str, ((Integer) v3).intValue()));
        } else if (v3.getClass() == Long.class) {
            v16 = (V) Long.valueOf(this.f94036b.getLong(str, ((Long) v3).longValue()));
        } else if (v3.getClass() == String.class) {
            v16 = (V) this.f94036b.getString(str, (String) v3);
        } else if (v3.getClass() == Boolean.class) {
            v16 = (V) Boolean.valueOf(this.f94036b.getBoolean(str, ((Boolean) v3).booleanValue()));
        } else {
            throw new IllegalArgumentException("defValue class is not support : " + v3.getClass());
        }
        hd0.c.m("ConfigManager", "get value : K : %s, V : %s", str, v16);
        if (v16 != null && v16.getClass() == v3.getClass()) {
            return v16;
        }
        e(str, v16, v3.getClass().getName());
        return v3;
    }

    public <V> void d(String str, V v3) {
        boolean commit;
        b();
        if (v3.getClass() == Integer.class) {
            commit = this.f94036b.edit().putInt(str, ((Integer) v3).intValue()).commit();
        } else if (v3.getClass() == Long.class) {
            commit = this.f94036b.edit().putLong(str, ((Long) v3).longValue()).commit();
        } else if (v3.getClass() == String.class) {
            commit = this.f94036b.edit().putString(str, (String) v3).commit();
        } else if (v3.getClass() == Boolean.class) {
            commit = this.f94036b.edit().putBoolean(str, ((Boolean) v3).booleanValue()).commit();
        } else {
            throw new IllegalArgumentException("value class is not support : " + v3.getClass());
        }
        if (!commit) {
            hd0.c.i("ConfigManager", "set value error : K:%s, V:%s .", str, v3);
        } else {
            hd0.c.m("ConfigManager", "set value success :  K:%s, V:%s .", str, v3);
        }
    }

    @Override // com.tencent.biz.qqstory.model.e
    public void onDestroy() {
        hd0.c.a("ConfigManager", MosaicConstants$JsFunction.FUNC_ON_DESTROY);
    }

    @Override // com.tencent.biz.qqstory.model.e
    public void onInit() {
        hd0.c.a("ConfigManager", "onInit");
    }
}
