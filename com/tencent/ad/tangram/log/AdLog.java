package com.tencent.ad.tangram.log;

import android.support.annotation.Nullable;
import android.util.Log;
import com.tencent.ad.tangram.annotation.AdKeep;
import java.lang.ref.WeakReference;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdLog {
    private static volatile AdLog sInstance;
    private WeakReference<AdLogAdapter> adapter;

    AdLog() {
    }

    public static void d(String str, String str2) {
        d(str, str2, null);
    }

    public static void e(String str, String str2) {
        e(str, str2, null);
    }

    @Nullable
    private static AdLogAdapter getAdapter() {
        if (getInstance().adapter != null) {
            return getInstance().adapter.get();
        }
        return null;
    }

    public static AdLog getInstance() {
        if (sInstance == null) {
            synchronized (AdLog.class) {
                if (sInstance == null) {
                    sInstance = new AdLog();
                }
            }
        }
        return sInstance;
    }

    public static void i(String str, String str2) {
        i(str, str2, null);
    }

    public static void setAdapter(WeakReference<AdLogAdapter> weakReference) {
        getInstance().adapter = weakReference;
    }

    public static void w(String str, String str2) {
        w(str, str2, null);
    }

    public static void d(String str, String str2, Throwable th5) {
        AdLogAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.d(str, str2, th5);
        } else {
            Log.d(str, str2, th5);
        }
    }

    public static void e(String str, String str2, Throwable th5) {
        AdLogAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.e(str, str2, th5);
        } else {
            Log.e(str, str2, th5);
        }
    }

    public static void i(String str, String str2, Throwable th5) {
        AdLogAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.i(str, str2, th5);
        } else {
            Log.i(str, str2, th5);
        }
    }

    public static void w(String str, String str2, Throwable th5) {
        AdLogAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.w(str, str2, th5);
        } else {
            Log.w(str, str2, th5);
        }
    }
}
