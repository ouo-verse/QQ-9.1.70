package com.tencent.ttpic.openapi.initializer.so;

import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.initializer.so.MinElf;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class SoDependencyUtil {
    private static final String TAG = "SoDependencyUtil";

    public static List<String> getDependencies(String str, String str2) {
        String[] dependencies1 = getDependencies1(str, str2);
        if (dependencies1 == null) {
            return null;
        }
        return Arrays.asList(dependencies1);
    }

    public static String[] getDependencies1(String str, String str2) {
        try {
            return MinElf.extract_DT_NEEDED(new File(str, str2));
        } catch (MinElf.ElfError e16) {
            e = e16;
            e.printStackTrace();
            LogUtils.e(TAG, e);
            return null;
        } catch (IOException e17) {
            e = e17;
            e.printStackTrace();
            LogUtils.e(TAG, e);
            return null;
        } catch (Throwable th5) {
            LogUtils.e(TAG, th5);
            return null;
        }
    }
}
