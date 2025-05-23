package com.qq.e.comm.managers.setting;

import com.qq.e.comm.pi.PrivacyPolicyListener;
import com.qq.e.comm.pi.SrcDownloadPermissionListener;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class QQSetting {

    /* renamed from: a, reason: collision with root package name */
    private static volatile int f38210a = 1;

    /* renamed from: b, reason: collision with root package name */
    private static volatile int f38211b = 1;

    /* renamed from: c, reason: collision with root package name */
    private static volatile boolean f38212c;

    /* renamed from: d, reason: collision with root package name */
    private static volatile boolean f38213d;

    /* renamed from: e, reason: collision with root package name */
    private static volatile boolean f38214e;

    /* renamed from: f, reason: collision with root package name */
    private static volatile boolean f38215f;

    /* renamed from: g, reason: collision with root package name */
    private static volatile String f38216g;

    /* renamed from: h, reason: collision with root package name */
    private static volatile int f38217h;

    /* renamed from: i, reason: collision with root package name */
    private static volatile WeakReference<PrivacyPolicyListener> f38218i;

    /* renamed from: j, reason: collision with root package name */
    private static volatile WeakReference<SrcDownloadPermissionListener> f38219j;

    public static int getAllowPreloadNonVideoNetType() {
        return f38210a;
    }

    public static int getAllowPreloadVideoNetType() {
        return f38211b;
    }

    public static boolean getIsAllowPreloadImageInBackground() {
        return f38214e;
    }

    public static boolean getIsAllowPreloadInBackground() {
        return f38213d;
    }

    public static boolean getIsAllowPreloadVideoInBackground() {
        return f38215f;
    }

    public static boolean getIsAppInForegroundStatus() {
        return f38212c;
    }

    public static PrivacyPolicyListener getPrivacyPolicyListener() {
        WeakReference<PrivacyPolicyListener> weakReference = f38218i;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static String getQQAppVersion() {
        return f38216g;
    }

    public static int getQQAppVersionId() {
        return f38217h;
    }

    public static WeakReference<SrcDownloadPermissionListener> getSrcDownloadPermissionListener() {
        return f38219j;
    }

    public static void setAllowPreloadNonVideoNetType(int i3) {
        f38210a = i3;
    }

    public static void setAllowPreloadVideoNetType(int i3) {
        f38211b = i3;
    }

    public static void setIsAllowPreloadImageInBackground(boolean z16) {
        f38214e = z16;
    }

    public static void setIsAllowPreloadInBackground(boolean z16) {
        f38213d = z16;
    }

    public static void setIsAllowPreloadVideoInBackground(boolean z16) {
        f38215f = z16;
    }

    public static void setIsAppInForegroundStatus(boolean z16) {
        f38212c = z16;
    }

    public static void setPrivacyPolicyListener(WeakReference<PrivacyPolicyListener> weakReference) {
        f38218i = weakReference;
    }

    public static void setQQAppVersion(String str) {
        f38216g = str;
    }

    public static void setQQAppVersionId(int i3) {
        f38217h = i3;
    }

    public static void setSrcDownloadPermissionListener(WeakReference<SrcDownloadPermissionListener> weakReference) {
        f38219j = weakReference;
    }
}
