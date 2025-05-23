package com.tencent.rfix.loader.log;

import android.util.Log;

/* compiled from: P */
/* loaded from: classes25.dex */
public class DefaultRFixLog implements IRFixLog {
    @Override // com.tencent.rfix.loader.log.IRFixLog
    public void d(String str, String str2) {
        Log.d(str, str2);
    }

    @Override // com.tencent.rfix.loader.log.IRFixLog
    public void e(String str, String str2) {
        Log.e(str, str2);
    }

    @Override // com.tencent.rfix.loader.log.IRFixLog
    public void i(String str, String str2) {
        Log.i(str, str2);
    }

    @Override // com.tencent.rfix.loader.log.IRFixLog
    public void v(String str, String str2) {
        Log.v(str, str2);
    }

    @Override // com.tencent.rfix.loader.log.IRFixLog
    public void w(String str, String str2) {
        Log.w(str, str2);
    }

    @Override // com.tencent.rfix.loader.log.IRFixLog
    public void e(String str, String str2, Throwable th5) {
        Log.e(str, str2, th5);
    }

    @Override // com.tencent.rfix.loader.log.IRFixLog
    public void w(String str, String str2, Throwable th5) {
        Log.w(str, str2, th5);
    }
}
