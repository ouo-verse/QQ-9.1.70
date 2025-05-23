package com.tencent.ams.fusion.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* compiled from: P */
/* loaded from: classes3.dex */
public class h {
    public static boolean a(Context context) {
        ConnectivityManager connectivityManager;
        if (context != null && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null) {
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                    return false;
                }
                if (activeNetworkInfo.getState() != NetworkInfo.State.CONNECTED) {
                    return false;
                }
                return true;
            } catch (Throwable th5) {
                f.d("isNetworkConnected", th5);
            }
        }
        return false;
    }
}
