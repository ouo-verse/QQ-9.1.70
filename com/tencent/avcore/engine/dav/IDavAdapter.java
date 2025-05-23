package com.tencent.avcore.engine.dav;

import com.tencent.avcore.engine.IAVAdapter;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface IDavAdapter extends IAVAdapter {
    boolean enableQClearFromConfig();

    String getCustomInfo(long j3, String str);

    void initBeaconReporter();

    void initClientLogReport();

    void initConfig();

    void initTABSDK();

    boolean loadLibrary();

    boolean useVideoConfigPolicyOfServer();
}
