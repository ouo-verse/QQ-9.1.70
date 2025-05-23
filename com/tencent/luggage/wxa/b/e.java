package com.tencent.luggage.wxa.b;

import android.os.Build;
import com.tencent.luggage.wxa.b.c;
import com.tencent.rfix.loader.utils.RFixConstants;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e implements c.b {
    @Override // com.tencent.luggage.wxa.b.c.b
    public String a(String str) {
        return (str.startsWith(RFixConstants.SO_PATH) && str.endsWith(".so")) ? str : System.mapLibraryName(str);
    }

    @Override // com.tencent.luggage.wxa.b.c.b
    public String b(String str) {
        return str.substring(3, str.length() - 3);
    }

    @Override // com.tencent.luggage.wxa.b.c.b
    public void c(String str) {
        System.load(str);
    }

    @Override // com.tencent.luggage.wxa.b.c.b
    public void loadLibrary(String str) {
        System.loadLibrary(str);
    }

    @Override // com.tencent.luggage.wxa.b.c.b
    public String[] a() {
        String[] strArr = Build.SUPPORTED_ABIS;
        if (strArr.length > 0) {
            return strArr;
        }
        String str = Build.CPU_ABI2;
        return !f.a(str) ? new String[]{Build.CPU_ABI, str} : new String[]{Build.CPU_ABI};
    }
}
