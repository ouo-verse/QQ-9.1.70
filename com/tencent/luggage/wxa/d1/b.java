package com.tencent.luggage.wxa.d1;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public Context f124056a;

    public b(Context context) {
        this.f124056a = context;
    }

    public boolean a(String str) {
        return PreferenceManager.getDefaultSharedPreferences(this.f124056a).getBoolean(str, false);
    }

    public void b(String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.f124056a).edit();
        edit.putBoolean(str, true);
        edit.apply();
    }
}
