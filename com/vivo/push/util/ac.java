package com.vivo.push.util;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes22.dex */
public final class ac implements e {

    /* renamed from: a, reason: collision with root package name */
    private ContentResolver f387869a;

    @Override // com.vivo.push.util.e
    public final boolean a(Context context) {
        if (!n.b()) {
            return false;
        }
        this.f387869a = context.getContentResolver();
        return true;
    }

    @Override // com.vivo.push.util.e
    public final void b(String str, String str2) {
        try {
            Settings.System.putString(this.f387869a, str, str2);
        } catch (Exception e16) {
            e16.printStackTrace();
            u.b("SettingsCache", "putString error by ".concat(String.valueOf(str)));
        }
    }

    @Override // com.vivo.push.util.e
    public final String a(String str, String str2) {
        try {
            return DeviceInfoMonitor.getStringSystem(this.f387869a, str);
        } catch (Exception e16) {
            e16.printStackTrace();
            u.b("SettingsCache", "getString error by ".concat(String.valueOf(str)));
            return str2;
        }
    }
}
