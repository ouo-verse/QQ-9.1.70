package com.huawei.hms.ui;

import android.os.Bundle;
import com.huawei.hms.base.ui.LogUtil;

/* compiled from: P */
/* loaded from: classes2.dex */
public class SafeBundle {

    /* renamed from: a, reason: collision with root package name */
    private final Bundle f37642a;

    public SafeBundle() {
        this(new Bundle());
    }

    public boolean containsKey(String str) {
        try {
            return this.f37642a.containsKey(str);
        } catch (Exception unused) {
            LogUtil.e("SafeBundle", "containsKey exception. key:");
            return false;
        }
    }

    public Object get(String str) {
        try {
            return this.f37642a.get(str);
        } catch (Exception e16) {
            LogUtil.e("SafeBundle", "get exception: " + e16.getMessage(), true);
            return null;
        }
    }

    public Bundle getBundle() {
        return this.f37642a;
    }

    public int getInt(String str) {
        return getInt(str, 0);
    }

    public String getString(String str) {
        try {
            return this.f37642a.getString(str);
        } catch (Exception e16) {
            LogUtil.e("SafeBundle", "getString exception: " + e16.getMessage(), true);
            return "";
        }
    }

    public boolean isEmpty() {
        try {
            return this.f37642a.isEmpty();
        } catch (Exception unused) {
            LogUtil.e("SafeBundle", "isEmpty exception");
            return true;
        }
    }

    public int size() {
        try {
            return this.f37642a.size();
        } catch (Exception unused) {
            LogUtil.e("SafeBundle", "size exception");
            return 0;
        }
    }

    public String toString() {
        return this.f37642a.toString();
    }

    public SafeBundle(Bundle bundle) {
        this.f37642a = bundle == null ? new Bundle() : bundle;
    }

    public int getInt(String str, int i3) {
        try {
            return this.f37642a.getInt(str, i3);
        } catch (Exception e16) {
            LogUtil.e("SafeBundle", "getInt exception: " + e16.getMessage(), true);
            return i3;
        }
    }

    public String getString(String str, String str2) {
        try {
            return this.f37642a.getString(str, str2);
        } catch (Exception e16) {
            LogUtil.e("SafeBundle", "getString exception: " + e16.getMessage(), true);
            return str2;
        }
    }
}
