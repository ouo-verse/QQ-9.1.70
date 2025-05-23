package com.tencent.xweb.updater;

import com.tencent.xweb.CalledByApi;

/* compiled from: P */
@CalledByApi
/* loaded from: classes27.dex */
public interface IXWebUpdateListener {
    public static final int CHECK_UPDATE_CONFIG_FAILED = 1;
    public static final int CHECK_UPDATE_RUNTIME_FAILED = 2;
    public static final int DOWNLOAD_RUNTIME_FAILED = 3;
    public static final int INSTALL_RUNTIME_FAILED = 4;

    boolean onNeedDownload();

    void onUpdateCancelled();

    void onUpdateCompleted();

    void onUpdateFailed(int i3);

    void onUpdateProgress(int i3);

    void onUpdateStart();
}
