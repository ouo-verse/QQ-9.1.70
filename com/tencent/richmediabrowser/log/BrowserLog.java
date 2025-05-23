package com.tencent.richmediabrowser.log;

import android.util.Log;

/* compiled from: P */
/* loaded from: classes25.dex */
public class BrowserLog implements IBrowserLog {
    @Override // com.tencent.richmediabrowser.log.IBrowserLog
    public void d(String str, int i3, String str2) {
        if (isColorLevel()) {
            Log.d(str, str2);
        }
    }

    @Override // com.tencent.richmediabrowser.log.IBrowserLog
    public void e(String str, int i3, String str2) {
        if (isColorLevel()) {
            Log.e(str, str2);
        }
    }

    @Override // com.tencent.richmediabrowser.log.IBrowserLog
    public void i(String str, int i3, String str2) {
        if (isColorLevel()) {
            Log.i(str, str2);
        }
    }

    @Override // com.tencent.richmediabrowser.log.IBrowserLog
    public boolean isColorLevel() {
        return true;
    }

    @Override // com.tencent.richmediabrowser.log.IBrowserLog
    public void w(String str, int i3, String str2) {
        if (isColorLevel()) {
            Log.w(str, str2);
        }
    }
}
