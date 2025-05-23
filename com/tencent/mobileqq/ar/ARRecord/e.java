package com.tencent.mobileqq.ar.ARRecord;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.y;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.io.File;
import java.text.SimpleDateFormat;

/* compiled from: P */
/* loaded from: classes11.dex */
public class e {
    public static String a() {
        String str = (ShortVideoUtils.getCameraPath() + new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Long.valueOf(System.currentTimeMillis()))) + com.tencent.av.ui.funchat.record.b.f75864a;
        File parentFile = new File(str).getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        return str;
    }

    public static String b() {
        return BaseApplicationImpl.getApplication().getFilesDir().getAbsolutePath() + "/AR/ARVideoRecord.tmp";
    }

    public static boolean c() {
        if (y.a().f198847g && !DeviceInfoMonitor.getModel().equalsIgnoreCase("CAM-TL00")) {
            return true;
        }
        return false;
    }
}
