package com.rookery.translate.model;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static a f61217a;

    c() {
    }

    public static a a(Context context) {
        if (f61217a == null) {
            int memoryClass = (((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getMemoryClass() * 1048576) / 8;
            if (QLog.isColorLevel()) {
                QLog.d("Translator", 2, "[TranslateCache]disk cache:" + memoryClass);
            }
            synchronized (c.class) {
                if (f61217a == null) {
                    try {
                        f61217a = new a(context, 1, memoryClass);
                    } catch (IOException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("Translator", 2, "[TranslateCache] initcache error: " + e16);
                        }
                    }
                }
            }
        }
        return f61217a;
    }
}
