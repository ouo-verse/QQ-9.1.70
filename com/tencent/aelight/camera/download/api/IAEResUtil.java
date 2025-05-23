package com.tencent.aelight.camera.download.api;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.util.List;
import java.util.Map;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IAEResUtil extends QRouteApi {
    public static final int AERES_EXIST = 1;
    public static final int AERES_MACHINE_NOT_SUPPORT = 0;
    public static final int AERES_NOT_EXIST = 2;

    @Deprecated
    boolean checkAEResVersionOK(AEResInfo aEResInfo);

    void fetchAllEssentialBundles();

    void fetchLightSDKEssentialBundles();

    void fetchSingleBundle(String str);

    void fetchSingleBundle(String str, a aVar);

    void fetchSingleBundleHighPriority(String str);

    void fetchSpecificBundles(List<String> list);

    String getAEKitBaseResUnzipFinalPath();

    @Deprecated
    int getAEResStatus(AEResInfo aEResInfo);

    int getAEResStatus(String str, String str2);

    String getAEResUnzipFinalPath(String str);

    String getLightAssetsDir();

    @Deprecated
    String getLightBundleDir(@NonNull AEResInfo aEResInfo);

    String getLightBundleDir(@NonNull String str);

    Map<String, String> getLightBundleMap();

    String getLightEmptyMaterialConfigPath();

    @Deprecated
    String getLightModelDir();

    String getLightSDKBaseResUnzipFinalPath();

    String getLightSDKCachePath();

    List<AEResInfo> getLightSDKResInfo();

    List<String> getNeedDownloadList(VideoMaterial videoMaterial);

    List<String> getNeedDownloadList(VideoMaterial videoMaterial, String str);

    String getUnzipAEResPath(@NonNull AEResInfo aEResInfo);

    boolean isAEBaseSoReady();

    boolean isAEBaseSoReadyWithConfig();

    @Deprecated
    boolean isAEResExist(AEResInfo aEResInfo);

    boolean isAEResExist(String str);

    boolean isAEResExist(String str, String str2);

    boolean isFilterFaceSoVersionOK();

    boolean isLightCameraBaseResNotAllExist();

    boolean isLightCameraBaseResNotAllExist(String str);

    boolean isLightCameraResExist();

    boolean isLightCameraResExist(String str);

    boolean isLightSDKResExist();

    boolean loadAEBaseSo();

    boolean loadAEBaseSoWithConfig();

    boolean loadLightSdk();

    boolean loadOnlyFilament();

    boolean loadOnlyPag();

    void peakRequestAEBaseRes();

    void preDownloadAllNonEssentialBundles();

    void registerSyncReceiver();

    void removeAEDownloadCallBack(a aVar);

    void setHasSynced(boolean z16);

    void unRegisterSyncReceiver();
}
