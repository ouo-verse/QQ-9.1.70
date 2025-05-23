package com.tencent.mapsdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class kv {
    public static SharedPreferences a(Context context, String str) {
        if (context != null) {
            return context.getSharedPreferences("TMS_".concat(String.valueOf(str)), 0);
        }
        return null;
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public SharedPreferences.Editor f149086a;

        public a(SharedPreferences.Editor editor) {
            this.f149086a = editor;
        }

        public final void a(String str, int i3) {
            this.f149086a.putInt(str, i3);
            this.f149086a.commit();
        }

        private void a(String str, boolean z16) {
            this.f149086a.putBoolean(str, z16);
            this.f149086a.commit();
        }

        private void a(String str, float f16) {
            this.f149086a.putFloat(str, f16);
            this.f149086a.commit();
        }

        private void a(String str, long j3) {
            this.f149086a.putLong(str, j3);
            this.f149086a.commit();
        }

        public final void a(String str, String str2) {
            this.f149086a.putString(str, str2);
            this.f149086a.commit();
        }

        private void a(String str, Set<String> set) {
            this.f149086a.putStringSet(str, set);
            this.f149086a.commit();
        }
    }

    private static SharedPreferences a(Context context) {
        if (context != null) {
            return context.getSharedPreferences("TMS_GLOBAL", 0);
        }
        return null;
    }

    public static a a(SharedPreferences sharedPreferences) {
        return new a(sharedPreferences.edit());
    }
}
