package com.tencent.aelight.camera.ae.util;

import com.tencent.component.media.image.ProgressTracer;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;

/* compiled from: P */
/* loaded from: classes32.dex */
public class k {
    public static void a(String str, String str2) {
        if (str == null || str.trim().length() == 0) {
            return;
        }
        File file = new File(str);
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (int i3 = 0; i3 < listFiles.length; i3++) {
                if (listFiles[i3].isDirectory()) {
                    if (!listFiles[i3].getAbsolutePath().equals(str2)) {
                        ms.a.a("AEResFileUtil", "" + listFiles[i3].getAbsolutePath() + ProgressTracer.SEPARATOR + str2);
                        FileUtils.deleteDirectory(listFiles[i3].getAbsolutePath());
                    }
                } else {
                    listFiles[i3].delete();
                }
            }
        }
        file.delete();
    }
}
