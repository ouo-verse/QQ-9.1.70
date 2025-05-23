package com.xiaomi.push;

import android.os.Looper;
import android.text.TextUtils;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ij {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final StringBuilder f389415a;

        /* renamed from: b, reason: collision with root package name */
        private final String f389416b;

        /* renamed from: c, reason: collision with root package name */
        private final String f389417c;

        public a() {
            this(":", ",");
        }

        public a a(String str, Object obj) {
            if (!TextUtils.isEmpty(str)) {
                if (this.f389415a.length() > 0) {
                    this.f389415a.append(this.f389417c);
                }
                StringBuilder sb5 = this.f389415a;
                sb5.append(str);
                sb5.append(this.f389416b);
                sb5.append(obj);
            }
            return this;
        }

        public String toString() {
            return this.f389415a.toString();
        }

        public a(String str, String str2) {
            this.f389415a = new StringBuilder();
            this.f389416b = str;
            this.f389417c = str2;
        }
    }

    public static int a(String str, int i3) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (Exception unused) {
                return i3;
            }
        }
        return i3;
    }

    public static long b(String str, long j3) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Long.parseLong(str);
            } catch (Exception unused) {
                return j3;
            }
        }
        return j3;
    }

    public static boolean c() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            return true;
        }
        return false;
    }

    public static boolean d(Collection<?> collection) {
        if (collection != null && !collection.isEmpty()) {
            return false;
        }
        return true;
    }

    public static int e(String str, int i3) {
        if (!TextUtils.isEmpty(str)) {
            return ((str.hashCode() / 10) * 10) + i3;
        }
        return i3;
    }
}
