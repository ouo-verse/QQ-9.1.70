package com.tencent.upload.uinterface;

import android.content.Context;
import com.tencent.upload.network.route.DebugServerRoute;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface IUploadService {
    public static final String DOMAIN_PARSER_THREAD_NAME = "domainParser";
    public static final String UPLOAD_HANDLE_THREAD_NAME = "uploadHandle";

    boolean cancel(AbstractUploadTask abstractUploadTask);

    boolean clearCacheWhenIdle(Context context);

    boolean commit(AbstractUploadTask abstractUploadTask);

    void init(Context context, IUploadConfig iUploadConfig, IUploadLog iUploadLog, IUploadReport iUploadReport, IUploadEnv iUploadEnv, IUploadSoLoader iUploadSoLoader);

    boolean isInitialized();

    void keepImageTmpFile(boolean z16);

    void pauseAllTask();

    void prepare(TaskTypeConfig taskTypeConfig);

    void setBackgroundMode(boolean z16);

    void setDebugServerRoute(DebugServerRoute debugServerRoute);

    boolean upload(AbstractUploadTask abstractUploadTask);
}
