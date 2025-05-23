package com.getkeepsafe.relinker;

import android.os.Build;
import com.getkeepsafe.relinker.b;
import com.tencent.rfix.loader.utils.RFixConstants;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public final class c implements b.InterfaceC0224b {
    @Override // com.getkeepsafe.relinker.b.InterfaceC0224b
    public void loadLibrary(String str) {
        System.loadLibrary(str);
    }

    @Override // com.getkeepsafe.relinker.b.InterfaceC0224b
    public void loadPath(String str) {
        System.load(str);
    }

    @Override // com.getkeepsafe.relinker.b.InterfaceC0224b
    public String mapLibraryName(String str) {
        if (str.startsWith(RFixConstants.SO_PATH) && str.endsWith(".so")) {
            return str;
        }
        return System.mapLibraryName(str);
    }

    @Override // com.getkeepsafe.relinker.b.InterfaceC0224b
    public String[] supportedAbis() {
        String[] strArr = Build.SUPPORTED_ABIS;
        if (strArr.length > 0) {
            return strArr;
        }
        String str = Build.CPU_ABI2;
        if (!d.a(str)) {
            return new String[]{Build.CPU_ABI, str};
        }
        return new String[]{Build.CPU_ABI};
    }

    @Override // com.getkeepsafe.relinker.b.InterfaceC0224b
    public String unmapLibraryName(String str) {
        return str.substring(3, str.length() - 3);
    }
}
