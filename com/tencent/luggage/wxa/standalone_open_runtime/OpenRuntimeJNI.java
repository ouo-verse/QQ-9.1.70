package com.tencent.luggage.wxa.standalone_open_runtime;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

/* compiled from: P */
/* loaded from: classes8.dex */
public class OpenRuntimeJNI {

    /* renamed from: a, reason: collision with root package name */
    public static b f140719a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static String f140720b = "";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements b {
        @Override // com.tencent.luggage.wxa.standalone_open_runtime.OpenRuntimeJNI.b
        public void loadLibrary(String str) {
            System.loadLibrary(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        void loadLibrary(String str);
    }

    public static void a(b bVar) {
        if (bVar == null) {
            return;
        }
        f140719a = bVar;
    }

    private static native boolean nativeCheckLibValid(String str, String str2, int i3);

    private static native boolean nativeCheckValid(String str, int i3);

    private static native String nativeInit(AssetManager assetManager);

    private static native void nativeUnInit();

    public static void a(Context context) {
        f140719a.loadLibrary("wxaopenruntimejni");
        if (context == null) {
            Log.e("OpenRuntimeJNI", "Context is null");
            return;
        }
        AssetManager assets = context.getAssets();
        if (assets == null) {
            Log.e("OpenRuntimeJNI", "Failed to get AssetManager");
            return;
        }
        try {
            f140720b = nativeInit(assets);
        } catch (Exception e16) {
            Log.e("OpenRuntimeJNI", "Error in nativeInit", e16);
        }
    }

    public static String a() {
        return f140720b;
    }

    public static boolean a(String str, int i3) {
        return nativeCheckValid(str, i3);
    }

    public static boolean a(String str, String str2, int i3) {
        return nativeCheckLibValid(str, str2, i3);
    }
}
