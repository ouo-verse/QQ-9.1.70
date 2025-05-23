package com.tencent.oskplayer.util;

import android.util.Log;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DefaultLogger implements QLog {
    public static final String TAG = "OskPlayer";

    @Override // com.tencent.oskplayer.util.QLog
    public int d(String str, String str2) {
        return Log.d("OskPlayer/" + str, str2);
    }

    @Override // com.tencent.oskplayer.util.QLog
    public int e(String str, String str2) {
        return Log.e("OskPlayer/" + str, str2);
    }

    @Override // com.tencent.oskplayer.util.QLog
    public int i(String str, String str2) {
        return Log.i("OskPlayer/" + str, str2);
    }

    @Override // com.tencent.oskplayer.util.QLog
    public int v(String str, String str2) {
        return Log.v("OskPlayer/" + str, str2);
    }

    @Override // com.tencent.oskplayer.util.QLog
    public int w(String str, String str2) {
        return Log.w("OskPlayer/" + str, str2);
    }

    @Override // com.tencent.oskplayer.util.QLog
    public int d(String str, String str2, Throwable th5) {
        return Log.d("OskPlayer/" + str, str2, th5);
    }

    @Override // com.tencent.oskplayer.util.QLog
    public int e(String str, String str2, Throwable th5) {
        return Log.e("OskPlayer/" + str, str2, th5);
    }

    @Override // com.tencent.oskplayer.util.QLog
    public int i(String str, String str2, Throwable th5) {
        return Log.i("OskPlayer/" + str, str2, th5);
    }

    @Override // com.tencent.oskplayer.util.QLog
    public int v(String str, String str2, Throwable th5) {
        return Log.v("OskPlayer/" + str, str2, th5);
    }

    @Override // com.tencent.oskplayer.util.QLog
    public int w(String str, String str2, Throwable th5) {
        return Log.w("OskPlayer/" + str, str2, th5);
    }

    @Override // com.tencent.oskplayer.util.QLog
    public int w(String str, Throwable th5) {
        return Log.w("OskPlayer/" + str, th5);
    }
}
