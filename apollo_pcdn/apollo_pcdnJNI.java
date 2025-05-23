package apollo_pcdn;

import java.math.BigInteger;

/* compiled from: P */
/* loaded from: classes.dex */
public class apollo_pcdnJNI {
    public static final native long CallbackFuncPtrs_OnCompleteCallback_get(long j3, CallbackFuncPtrs callbackFuncPtrs);

    public static final native void CallbackFuncPtrs_OnCompleteCallback_set(long j3, CallbackFuncPtrs callbackFuncPtrs, long j16);

    public static final native long CallbackFuncPtrs_OnDataCallback_get(long j3, CallbackFuncPtrs callbackFuncPtrs);

    public static final native void CallbackFuncPtrs_OnDataCallback_set(long j3, CallbackFuncPtrs callbackFuncPtrs, long j16);

    public static final native long CallbackFuncPtrs_OnDestoryDownEngineCallback_get(long j3, CallbackFuncPtrs callbackFuncPtrs);

    public static final native void CallbackFuncPtrs_OnDestoryDownEngineCallback_set(long j3, CallbackFuncPtrs callbackFuncPtrs, long j16);

    public static final native long CallbackFuncPtrs_OnEngineUpdateAndGetNetStateCallback_get(long j3, CallbackFuncPtrs callbackFuncPtrs);

    public static final native void CallbackFuncPtrs_OnEngineUpdateAndGetNetStateCallback_set(long j3, CallbackFuncPtrs callbackFuncPtrs, long j16);

    public static final native long CallbackFuncPtrs_OnErrorCallback_get(long j3, CallbackFuncPtrs callbackFuncPtrs);

    public static final native void CallbackFuncPtrs_OnErrorCallback_set(long j3, CallbackFuncPtrs callbackFuncPtrs, long j16);

    public static final native long CallbackFuncPtrs_OnHeadersCallback_get(long j3, CallbackFuncPtrs callbackFuncPtrs);

    public static final native void CallbackFuncPtrs_OnHeadersCallback_set(long j3, CallbackFuncPtrs callbackFuncPtrs, long j16);

    public static final native long CreateDownEngine();

    public static final native int DOWNENGINE_DOWNLOAD_CONFIG_get();

    public static final native int DOWNENGINE_DOWNLOAD_HTTP_get();

    public static final native int DOWNENGINE_DOWNLOAD_INTERFACE_get();

    public static final native int DOWNENGINE_DOWNLOAD_P2P_get();

    public static final native int DOWNENGINE_DOWNLOAD_SCHEDULETASKS_get();

    public static final native int DOWNENGINE_DOWNLOAD_SYS_FS_get();

    public static final native void DestoryDownEngine(long j3);

    public static final native int DownEngineConfig_curNetworkState_get(long j3, DownEngineConfig downEngineConfig);

    public static final native void DownEngineConfig_curNetworkState_set(long j3, DownEngineConfig downEngineConfig, int i3);

    public static final native boolean DownEngineConfig_is4gEnablePcdn_get(long j3, DownEngineConfig downEngineConfig);

    public static final native void DownEngineConfig_is4gEnablePcdn_set(long j3, DownEngineConfig downEngineConfig, boolean z16);

    public static final native boolean DownEngineConfig_isEnableP2p_get(long j3, DownEngineConfig downEngineConfig);

    public static final native void DownEngineConfig_isEnableP2p_set(long j3, DownEngineConfig downEngineConfig, boolean z16);

    public static final native long DownEngineConfig_logCtx_get(long j3, DownEngineConfig downEngineConfig);

    public static final native void DownEngineConfig_logCtx_set(long j3, DownEngineConfig downEngineConfig, long j16);

    public static final native long DownEngineConfig_logFuncPtr_get(long j3, DownEngineConfig downEngineConfig);

    public static final native void DownEngineConfig_logFuncPtr_set(long j3, DownEngineConfig downEngineConfig, long j16);

    public static final native int DownEngineConfig_logLevel_get(long j3, DownEngineConfig downEngineConfig);

    public static final native void DownEngineConfig_logLevel_set(long j3, DownEngineConfig downEngineConfig, int i3);

    public static final native String DownEngineConfig_logSavePath_get(long j3, DownEngineConfig downEngineConfig);

    public static final native void DownEngineConfig_logSavePath_set(long j3, DownEngineConfig downEngineConfig, String str);

    public static final native long DownEngineConfig_maxHttpDownloadSpeed_get(long j3, DownEngineConfig downEngineConfig);

    public static final native void DownEngineConfig_maxHttpDownloadSpeed_set(long j3, DownEngineConfig downEngineConfig, long j16);

    public static final native long DownEngineConfig_maxP2PDownloadSpeed_get(long j3, DownEngineConfig downEngineConfig);

    public static final native void DownEngineConfig_maxP2PDownloadSpeed_set(long j3, DownEngineConfig downEngineConfig, long j16);

    public static final native long DownEngineConfig_maxP2PUploadSpeed_get(long j3, DownEngineConfig downEngineConfig);

    public static final native void DownEngineConfig_maxP2PUploadSpeed_set(long j3, DownEngineConfig downEngineConfig, long j16);

    public static final native BigInteger DownEngineConfig_maxUsableDiskSize_get(long j3, DownEngineConfig downEngineConfig);

    public static final native void DownEngineConfig_maxUsableDiskSize_set(long j3, DownEngineConfig downEngineConfig, BigInteger bigInteger);

    public static final native long DownEngineConfig_openProgressCallBack_get(long j3, DownEngineConfig downEngineConfig);

    public static final native void DownEngineConfig_openProgressCallBack_set(long j3, DownEngineConfig downEngineConfig, long j16);

    public static final native long DownEngineConfig_uiAppId_get(long j3, DownEngineConfig downEngineConfig);

    public static final native void DownEngineConfig_uiAppId_set(long j3, DownEngineConfig downEngineConfig, long j16);

    public static final native String DwResumeFilePostfix_get();

    public static final native String DwTempFilePostfix_get();

    public static final native float IDownEngine_GetCurrentP2PSharingRatio(long j3, IDownEngine iDownEngine);

    public static final native float IDownEngine_GetCurrentPCDNSharingRatio(long j3, IDownEngine iDownEngine);

    public static final native double IDownEngine_GetCurrentSpeed(long j3, IDownEngine iDownEngine);

    public static final native String IDownEngine_GetErrContent(long j3, IDownEngine iDownEngine, long j16);

    public static final native long IDownEngine_GetInterfaceLastError(long j3, IDownEngine iDownEngine);

    public static final native BigInteger IDownEngine_GetTransferBytes__PCDN_0(long j3, IDownEngine iDownEngine, long j16);

    public static final native BigInteger IDownEngine_GetTransferBytes__PCDN_1(long j3, IDownEngine iDownEngine);

    public static final native boolean IDownEngine_InitDownEngine(long j3, IDownEngine iDownEngine, long j16, DownEngineConfig downEngineConfig);

    public static final native boolean IDownEngine_Pause(long j3, IDownEngine iDownEngine);

    public static final native boolean IDownEngine_Resume(long j3, IDownEngine iDownEngine);

    public static final native void IDownEngine_SetBackGroundSwitch(long j3, IDownEngine iDownEngine, boolean z16);

    public static final native void IDownEngine_SetEnableP2P(long j3, IDownEngine iDownEngine, boolean z16);

    public static final native boolean IDownEngine_SetOption__PCDN_0(long j3, IDownEngine iDownEngine, int i3, BigInteger bigInteger);

    public static final native boolean IDownEngine_SetOption__PCDN_1(long j3, IDownEngine iDownEngine, int i3, String str);

    public static final native void IDownEngine_SetUniDevId(long j3, IDownEngine iDownEngine, String str);

    public static final native boolean IDownEngine_SetupCallBack(long j3, IDownEngine iDownEngine, long j16, CallbackFuncPtrs callbackFuncPtrs);

    public static final native long IDownEngine_StartTask__PCDN_0(long j3, IDownEngine iDownEngine, String str, BigInteger bigInteger, BigInteger bigInteger2);

    public static final native long IDownEngine_StartTask__PCDN_1(long j3, IDownEngine iDownEngine, String str, long j16, Range range, BigInteger bigInteger);

    public static final native boolean IDownEngine_StopAllTasks(long j3, IDownEngine iDownEngine);

    public static final native boolean IDownEngine_StopTask(long j3, IDownEngine iDownEngine, long j16);

    public static final native boolean IDownEngine_UnitDownEngine(long j3, IDownEngine iDownEngine);

    public static final native void NotifyBackGroundSwitch(boolean z16);

    public static final native BigInteger Range_range_end_get(long j3, Range range);

    public static final native void Range_range_end_set(long j3, Range range, BigInteger bigInteger);

    public static final native BigInteger Range_range_start_get(long j3, Range range);

    public static final native void Range_range_start_set(long j3, Range range, BigInteger bigInteger);

    public static final native void delete_CallbackFuncPtrs(long j3);

    public static final native void delete_DownEngineConfig(long j3);

    public static final native void delete_IDownEngine(long j3);

    public static final native void delete_IDownEngineCallBack(long j3);

    public static final native void delete_Range(long j3);

    public static final native int kApolloNotReachable_get();

    public static final native int kDownEngineEnableHttp302Cahe_get();

    public static final native int kDownEngineEnableHttpLinkPool_get();

    public static final native int kDownEngineMaxHttpLinkNum_get();

    public static final native int kDownEngineMaxPcdnLinkNum_get();

    public static final native long new_CallbackFuncPtrs();

    public static final native long new_DownEngineConfig();

    public static final native long new_IDownEngineCallBack();

    public static final native long new_Range__PCDN_0();

    public static final native long new_Range__PCDN_1(BigInteger bigInteger, BigInteger bigInteger2);
}
