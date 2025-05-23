package com.tencent.luggage.wxa.a9;

import android.util.Log;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d implements e {
    public d() {
    }

    @Override // com.tencent.luggage.wxa.a9.e
    public void e(String str, String str2, Object... objArr) {
        if (objArr != null) {
            try {
                if (objArr.length > 0) {
                    str2 = String.format(str2, objArr);
                }
            } catch (Exception e16) {
                Log.e(str, "", e16);
                return;
            }
        }
        Log.e(str, str2);
    }

    @Override // com.tencent.luggage.wxa.a9.e
    public void i(String str, String str2, Object... objArr) {
        if (objArr != null) {
            try {
                if (objArr.length > 0) {
                    str2 = String.format(str2, objArr);
                }
            } catch (Exception e16) {
                Log.e(str, "", e16);
                return;
            }
        }
        Log.i(str, str2);
    }

    @Override // com.tencent.luggage.wxa.a9.e
    public void printStackTrace(String str, Throwable th5, String str2, Object... objArr) {
        if (th5 != null) {
            if (objArr != null) {
                try {
                    if (objArr.length > 0) {
                        str2 = String.format(str2, objArr);
                    }
                } catch (Exception e16) {
                    Log.e(str, "", e16);
                    return;
                }
            }
            Log.e(str, str2, th5);
        }
    }
}
