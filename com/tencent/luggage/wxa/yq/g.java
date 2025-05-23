package com.tencent.luggage.wxa.yq;

import android.content.Context;
import com.tencent.luggage.wxa.ar.n0;
import com.tencent.luggage.wxa.ar.q0;
import com.tencent.luggage.wxa.ar.v;
import com.tencent.luggage.wxa.ar.x0;
import java.io.File;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class g {
    public static int a(Context context, int i3) {
        File[] listFiles = new File(context.getApplicationInfo().dataDir).listFiles();
        int i16 = -1;
        if (listFiles == null) {
            x0.d("XWalkRuntimeRevertHelper", "revertToApkVer failed, files is null");
            return -1;
        }
        int installedNewstVersionForCurAbi = XWalkEnvironment.getInstalledNewstVersionForCurAbi();
        int i17 = -1;
        boolean z16 = false;
        for (File file : listFiles) {
            int a16 = q0.a(file);
            if (a16 >= 0) {
                if (a16 == i3) {
                    z16 = true;
                }
                if (a16 <= i3 && a16 >= 2000 && a16 != installedNewstVersionForCurAbi && a16 > i17) {
                    i17 = a16;
                }
            }
        }
        boolean z17 = i17 > 0;
        if (z16 && a(i3)) {
            x0.d("XWalkRuntimeRevertHelper", "revertToApkVer checkApkExist targetApk exist");
            i16 = i3;
        } else if (a(i17)) {
            i16 = i17;
        } else {
            x0.d("XWalkRuntimeRevertHelper", "revertToApkVer nAvailableOldVer targetApk not exist");
        }
        if (i16 == i3) {
            n0.a(89L, 1);
        } else if (i16 > 0) {
            n0.a(90L, 1);
        } else if (z17) {
            n0.a(92L, 1);
        } else {
            n0.a(91L, 1);
        }
        x0.d("XWalkRuntimeRevertHelper", "revert from:" + XWalkEnvironment.getInstalledNewstVersionForCurAbi() + " to:" + i16);
        XWalkEnvironment.setCoreVersionInfo(i16, "revert from:" + XWalkEnvironment.getInstalledNewstVersionForCurAbi() + " to:" + i16, com.tencent.luggage.wxa.ar.b.b());
        return i16;
    }

    public static boolean a(int i3) {
        File d16 = q0.d(i3);
        if (d16 == null) {
            x0.c("XWalkRuntimeRevertHelper", "checkApkExist, no config file");
            return false;
        }
        return v.a(i3, d16);
    }
}
