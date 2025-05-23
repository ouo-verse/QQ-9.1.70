package com.gcore.abase.config;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ConfigBundle {
    public static ConfigBundle sInstance = new ConfigBundle();

    private native boolean getBoolean(String str, String str2, boolean z16);

    public static ConfigBundle getInstance() {
        return sInstance;
    }

    private native int getInt(String str, String str2, int i3);

    private native long getLong(String str, String str2, long j3);

    private native String getString(String str, String str2, String str3);

    private native boolean setBoolean(String str, String str2, boolean z16);

    private native boolean setInt(String str, String str2, int i3);

    private native boolean setLong(String str, String str2, long j3);

    private native boolean setString(String str, String str2, String str3);

    public String get(String str, String str2, String str3) {
        return getString(str, str2, str3);
    }

    public boolean set(String str, String str2, String str3) {
        return setString(str, str2, str3);
    }

    public int get(String str, String str2, int i3) {
        return getInt(str, str2, i3);
    }

    public boolean set(String str, String str2, int i3) {
        return setInt(str, str2, i3);
    }

    public long get(String str, String str2, long j3) {
        return getLong(str, str2, j3);
    }

    public boolean set(String str, String str2, long j3) {
        return setLong(str, str2, j3);
    }

    public boolean get(String str, String str2, boolean z16) {
        return getBoolean(str, str2, z16);
    }

    public boolean set(String str, String str2, boolean z16) {
        return setBoolean(str, str2, z16);
    }
}
