package com.tencent.ttpic.openapi.initializer;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.support.annotation.NonNull;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.api.standard.AEResourceDict;
import com.tencent.rfix.loader.utils.RFixConstants;

/* compiled from: P */
/* loaded from: classes27.dex */
public class SharedLibraryInfo extends AEResourceInfo {
    public SharedLibraryInfo(String str) {
        this.fileName = str;
        this.sha1 = getExpectedSoFileSHA1(str);
    }

    private static String getAbi() {
        Context context = AEModule.getContext();
        if (context == null) {
            return null;
        }
        try {
            Object obj = ApplicationInfo.class.getDeclaredField("primaryCpuAbi").get(context.getApplicationInfo());
            if (obj != null) {
                return (String) obj;
            }
        } catch (IllegalAccessException e16) {
            e16.printStackTrace();
        } catch (NoSuchFieldException e17) {
            e17.printStackTrace();
            return null;
        }
        return null;
    }

    private static String getExpectedSoFileSHA1(String str) {
        return AEResourceDict.getSHA1(getAbi(), getFullLibName(str));
    }

    public String getFullLibName() {
        return getFullLibName(this.fileName);
    }

    @Override // com.tencent.ttpic.openapi.initializer.AEResourceInfo
    @NonNull
    public String toString() {
        return String.format("%s(sha1 = %s)", getFullLibName(), this.sha1);
    }

    public static String getFullLibName(String str) {
        return RFixConstants.SO_PATH + str + ".so";
    }
}
