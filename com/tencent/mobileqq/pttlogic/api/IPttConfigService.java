package com.tencent.mobileqq.pttlogic.api;

import com.tencent.mobileqq.dpc.DPCObserver;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process = {"all"})
/* loaded from: classes16.dex */
public interface IPttConfigService extends IRuntimeService, DPCObserver {
    public static final String TAG_PRE_DOWNLOAD_CFG = "ptt_pre_download";
    public static final String TAG_PTT_OPTIMIZE_CFG = "ptt_optimize_cfg_v2";
    public static final String TAG_STREAM_SLICE_CFG = "ptt_stream_slice_cfg";

    void onGetPreDownloadCfg(String str);

    void onGetPttOptimizeCfg(String str);

    void onGetStreamSliceCfg(String str);
}
