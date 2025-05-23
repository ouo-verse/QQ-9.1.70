package com.tencent.shadow.dynamic.host;

import android.os.RemoteException;
import com.tencent.shadow.core.common.InstalledApk;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface UuidManager {
    public static final String DESCRIPTOR = "com.tencent.shadow.dynamic.host.UuidManager";
    public static final int TRANSACTION_CODE_FAILED_EXCEPTION = 1;
    public static final int TRANSACTION_CODE_NOT_FOUND_EXCEPTION = 2;
    public static final int TRANSACTION_CODE_NO_EXCEPTION = 0;
    public static final int TRANSACTION_getPlugin = 1;
    public static final int TRANSACTION_getPluginLoader = 2;
    public static final int TRANSACTION_getRuntime = 3;

    InstalledApk getPlugin(String str, String str2) throws RemoteException, NotFoundException, FailedException;

    InstalledApk getPluginLoader(String str) throws RemoteException, NotFoundException, FailedException;

    InstalledApk getRuntime(String str) throws RemoteException, NotFoundException, FailedException;
}
