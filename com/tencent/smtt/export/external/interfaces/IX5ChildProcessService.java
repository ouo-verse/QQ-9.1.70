package com.tencent.smtt.export.external.interfaces;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/* loaded from: classes22.dex */
public interface IX5ChildProcessService {
    public static final String CRASH_RECORD_FD0_KEY = "com.tencent.smtt.multiprocess.CRASH_RECORD_FD0";
    public static final String CRASH_RECORD_FD1_KEY = "com.tencent.smtt.multiprocess.CRASH_RECORD_FD1";
    public static final String DISABLE_SEALED_CLASSLOADER_KEY = "com.tencent.smtt.multiprocess.DISABLE_SEALED_CLASSLOADER";
    public static final String ENTRY_CLASS_NAME_KEY = "com.tencent.smtt.multiprocess.ENTRY_CLASS_NAME";
    public static final String ENTRY_DEX_FD_KEY = "com.tencent.smtt.multiprocess.ENTRY_DEX_FD";
    public static final String ENTRY_DEX_FILE_KEY = "com.tencent.smtt.multiprocess.ENTRY_DEX_FILE";
    public static final String ERROR_CALLBACK_KEY = "com.tencent.smtt.multiprocess.ERROR_CALLBACK";
    public static final String INSTALLATION_DIRECTORY_KEY = "com.tencent.smtt.multiprocess.INSTALLATION_DIRECTORY";
    public static final String UNSEALED_PACKAGES_KEY = "com.tencent.smtt.multiprocess.UNSEALED_PACKAGES";

    IBinder onBind(Service service, Intent intent);

    void onCreate(Service service, Intent intent);

    void onDestroy(Service service);
}
