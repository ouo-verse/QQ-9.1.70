package org.extra.relinker;

import android.os.Build;
import com.tencent.rfix.loader.utils.RFixConstants;
import org.extra.relinker.c;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes29.dex */
public final class e implements c.b {
    @Override // org.extra.relinker.c.b
    public void a(String str) {
        System.loadLibrary(str);
    }

    @Override // org.extra.relinker.c.b
    public String b(String str) {
        return str.substring(3, str.length() - 3);
    }

    @Override // org.extra.relinker.c.b
    public void c(String str) {
        System.load(str);
    }

    @Override // org.extra.relinker.c.b
    public String d(String str) {
        if (str.startsWith(RFixConstants.SO_PATH) && str.endsWith(".so")) {
            return str;
        }
        return System.mapLibraryName(str);
    }

    @Override // org.extra.relinker.c.b
    public String[] a() {
        String[] strArr = Build.SUPPORTED_ABIS;
        if (strArr.length > 0) {
            return strArr;
        }
        String str = Build.CPU_ABI2;
        return !f.a(str) ? new String[]{Build.CPU_ABI, str} : new String[]{Build.CPU_ABI};
    }
}
