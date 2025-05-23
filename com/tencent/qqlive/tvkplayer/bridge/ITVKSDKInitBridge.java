package com.tencent.qqlive.tvkplayer.bridge;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.ITVKBeaconDataReporter;
import com.tencent.qqlive.tvkplayer.api.ITVKCustomizedCapability;
import com.tencent.qqlive.tvkplayer.api.ITVKHttpDnsResolver;
import com.tencent.qqlive.tvkplayer.api.ITVKLogListener;
import com.tencent.qqlive.tvkplayer.api.ITVKLogReportListener;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface ITVKSDKInitBridge {
    String getAdChid();

    int getCellularDataCost();

    String getChannelId();

    long getCurrentServerTimeSec();

    String getPlatform();

    String getPlayerCoreModuleName();

    int getPlayerCoreType();

    String getPlayerCoreVersion();

    String getSdkVersion();

    String getSdtfrom();

    boolean initSdk(@NonNull Context context, String str, String str2);

    boolean isSelfPlayerAvailable(Context context);

    void setAbUserId(String str);

    void setBeaconDataReporterBeforeInit(ITVKBeaconDataReporter iTVKBeaconDataReporter);

    void setCustomizedCapability(ITVKCustomizedCapability iTVKCustomizedCapability);

    void setDebugEnable(boolean z16);

    void setGuid(String str);

    void setHostConfigBeforeInitSDK(String str);

    void setHttpClientOption(int i3, boolean z16, int i16);

    void setHttpDnsResolver(ITVKHttpDnsResolver iTVKHttpDnsResolver);

    void setOnLogListener(ITVKLogListener iTVKLogListener);

    void setOnLogReportListener(ITVKLogReportListener iTVKLogReportListener);

    void setQQ(String str);

    void setSDKProperty(String str, String str2);

    void setSdkConfig(String str);

    void setUpc(String str);

    void setUpcState(int i3);

    void setUrlEnvironment(int i3);
}
