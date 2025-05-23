package com.tencent.mobileqq.persistence;

import com.tencent.qphone.base.util.QLog;
import mqq.inject.MqqInjectorManager;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ORMConfig {
    public static final boolean DEBUG = false;
    public static final boolean ENABLE_CURSOR2ENTITY = true;
    public static final boolean ENABLE_CURSOR_INDEX_FORCE_USE = false;
    public static final boolean ENABLE_WRITE_OPT = !MqqInjectorManager.instance().isDebugVersion();
    public static final String TAG = "FastORM";
    public static final boolean USE_FAST_ORM = true;

    public static void debug(String str) {
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, str);
        }
    }
}
