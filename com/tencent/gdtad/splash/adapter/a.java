package com.tencent.gdtad.splash.adapter;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class a implements com.tencent.ams.fusion.service.kv.a {
    private String d(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return str + "_" + str2;
        }
        return null;
    }

    @Override // com.tencent.ams.fusion.service.kv.a
    public Set<String> a(String str, String str2, Set<String> set) {
        String d16 = d(str, str2);
        if (TextUtils.isEmpty(d16)) {
            QLog.e("GdtMMKVAdapterImpl", 1, "[getStringSet] error, filename:" + str + " key:" + str2 + " value:" + set.toString());
            return set;
        }
        return ym0.a.e("Splash_", d16, set);
    }

    @Override // com.tencent.ams.fusion.service.kv.a
    public void b(String str, String str2, Set<String> set) {
        String d16 = d(str, str2);
        if (TextUtils.isEmpty(d16)) {
            QLog.e("GdtMMKVAdapterImpl", 1, "[putInt] error, filename:" + str + " key:" + str2 + " value:" + set.toString());
            return;
        }
        ym0.a.i("Splash_", d16, set);
    }

    @Override // com.tencent.ams.fusion.service.kv.a
    public void c(String str, String str2) {
        String d16 = d(str, str2);
        if (TextUtils.isEmpty(d16)) {
            QLog.e("GdtMMKVAdapterImpl", 1, "[removeKey] error, filename:" + str + " key:" + str2);
            return;
        }
        ym0.a.j("Splash_", d16);
    }

    @Override // com.tencent.ams.fusion.service.kv.a
    public int getInt(String str, String str2, int i3) {
        String d16 = d(str, str2);
        if (TextUtils.isEmpty(d16)) {
            QLog.e("GdtMMKVAdapterImpl", 1, "[getInt] error, filename:" + str + " key:" + str2 + " defaultValue:" + i3);
            return i3;
        }
        return ym0.a.b("Splash_", d16, i3);
    }

    @Override // com.tencent.ams.fusion.service.kv.a
    public long getLong(String str, String str2, long j3) {
        String d16 = d(str, str2);
        if (TextUtils.isEmpty(d16)) {
            QLog.e("GdtMMKVAdapterImpl", 1, "[getLong] error, filename:" + str + " key:" + str2 + " defaultValue:" + j3);
            return j3;
        }
        return ym0.a.c("Splash_", d16, j3);
    }

    @Override // com.tencent.ams.fusion.service.kv.a
    public String getString(String str, String str2, String str3) {
        String d16 = d(str, str2);
        if (TextUtils.isEmpty(d16)) {
            QLog.e("GdtMMKVAdapterImpl", 1, "[getString] error, filename:" + str + " key:" + str2 + " defaultValue:" + str3);
            return str3;
        }
        return ym0.a.d("Splash_", d16, str3);
    }

    @Override // com.tencent.ams.fusion.service.kv.a
    public void putInt(String str, String str2, int i3) {
        String d16 = d(str, str2);
        if (TextUtils.isEmpty(d16)) {
            QLog.e("GdtMMKVAdapterImpl", 1, "[putInt] error, filename:" + str + " key:" + str2 + " value:" + i3);
            return;
        }
        ym0.a.f("Splash_", d16, i3);
    }

    @Override // com.tencent.ams.fusion.service.kv.a
    public void putLong(String str, String str2, long j3) {
        String d16 = d(str, str2);
        if (TextUtils.isEmpty(d16)) {
            QLog.e("GdtMMKVAdapterImpl", 1, "[putLong] error, filename:" + str + " key:" + str2 + " value:" + j3);
            return;
        }
        ym0.a.g("Splash_", d16, j3);
    }

    @Override // com.tencent.ams.fusion.service.kv.a
    public void putString(String str, String str2, String str3) {
        String d16 = d(str, str2);
        if (TextUtils.isEmpty(d16)) {
            QLog.e("GdtMMKVAdapterImpl", 1, "[putString] error, filename:" + str + " key:" + str2 + " value:" + str3);
            return;
        }
        ym0.a.h("Splash_", d16, str3);
    }
}
