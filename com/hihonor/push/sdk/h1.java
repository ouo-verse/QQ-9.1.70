package com.hihonor.push.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

/* compiled from: P */
/* loaded from: classes2.dex */
public class h1 {

    /* renamed from: a, reason: collision with root package name */
    public final SharedPreferences f36393a;

    public h1(Context context, String str) {
        Context createDeviceProtectedStorageContext;
        boolean moveSharedPreferencesFrom;
        if (context != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                createDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
                SharedPreferences sharedPreferences = createDeviceProtectedStorageContext.getSharedPreferences("move_to_de_records", 0);
                boolean z16 = !sharedPreferences.getBoolean(str, false);
                moveSharedPreferencesFrom = createDeviceProtectedStorageContext.moveSharedPreferencesFrom(context, str);
                if (moveSharedPreferencesFrom & z16) {
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putBoolean(str, true);
                    edit.apply();
                }
                this.f36393a = createDeviceProtectedStorageContext.getSharedPreferences(str, 0);
                return;
            }
            this.f36393a = context.getSharedPreferences(str, 0);
            return;
        }
        throw new NullPointerException("context is null!");
    }

    public boolean a(String str, String str2) {
        SharedPreferences.Editor edit;
        SharedPreferences sharedPreferences = this.f36393a;
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
            return false;
        }
        return edit.putString(str, str2).commit();
    }

    public boolean a(String str) {
        SharedPreferences.Editor edit;
        SharedPreferences sharedPreferences = this.f36393a;
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
            return false;
        }
        return edit.remove(str).commit();
    }
}
