package org.light.internal.relinker;

import com.tencent.rfix.loader.utils.RFixConstants;
import org.light.device.LightDeviceProperty;
import org.light.internal.relinker.ReLinker;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes29.dex */
public final class SystemLibraryLoader implements ReLinker.LibraryLoader {
    @Override // org.light.internal.relinker.ReLinker.LibraryLoader
    public void loadLibrary(String str) {
        System.loadLibrary(str);
    }

    @Override // org.light.internal.relinker.ReLinker.LibraryLoader
    public void loadPath(String str) {
        System.load(str);
    }

    @Override // org.light.internal.relinker.ReLinker.LibraryLoader
    public String mapLibraryName(String str) {
        if (str.startsWith(RFixConstants.SO_PATH) && str.endsWith(".so")) {
            return str;
        }
        return System.mapLibraryName(str);
    }

    @Override // org.light.internal.relinker.ReLinker.LibraryLoader
    public String[] supportedAbis() {
        String stringProp = LightDeviceProperty.getStringProp(4);
        String stringProp2 = LightDeviceProperty.getStringProp(5);
        String[] stringArrayProp = LightDeviceProperty.getStringArrayProp(6);
        if (stringArrayProp != null && stringArrayProp.length > 0) {
            return stringArrayProp;
        }
        if (!TextUtils.isEmpty(stringProp2)) {
            return new String[]{stringProp, stringProp2};
        }
        return new String[]{stringProp};
    }

    @Override // org.light.internal.relinker.ReLinker.LibraryLoader
    public String unmapLibraryName(String str) {
        return str.substring(3, str.length() - 3);
    }
}
