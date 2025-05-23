package com.tencent.aelight.camera.download.api.impl;

import com.tencent.aelight.camera.ae.download.AEResManager;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.util.List;
import java.util.Map;
import ms.a;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEResUtilImpl implements IAEResUtil {
    private static final String TAG = "AEResUtilImpl";

    @Override // com.tencent.aelight.camera.download.api.IAEResUtil
    public boolean checkAEResVersionOK(AEResInfo aEResInfo) {
        return AEResUtil.b(aEResInfo);
    }

    @Override // com.tencent.aelight.camera.download.api.IAEResUtil
    public void fetchAllEssentialBundles() {
        AEResUtil.q0();
    }

    @Override // com.tencent.aelight.camera.download.api.IAEResUtil
    public void fetchLightSDKEssentialBundles() {
        AEResUtil.t0();
    }

    @Override // com.tencent.aelight.camera.download.api.IAEResUtil
    public void fetchSingleBundle(String str) {
        AEResUtil.h(str);
    }

    @Override // com.tencent.aelight.camera.download.api.IAEResUtil
    public void fetchSingleBundleHighPriority(String str) {
        AEResUtil.i(str);
    }

    @Override // com.tencent.aelight.camera.download.api.IAEResUtil
    public String getAEKitBaseResUnzipFinalPath() {
        return AEResUtil.k();
    }

    @Override // com.tencent.aelight.camera.download.api.IAEResUtil
    public int getAEResStatus(AEResInfo aEResInfo) {
        return AEResUtil.m(aEResInfo);
    }

    @Override // com.tencent.aelight.camera.download.api.IAEResUtil
    public String getAEResUnzipFinalPath(String str) {
        return AEResUtil.J(str);
    }

    @Override // com.tencent.aelight.camera.download.api.IAEResUtil
    public String getLightAssetsDir() {
        return AEResUtil.s();
    }

    @Override // com.tencent.aelight.camera.download.api.IAEResUtil
    public String getLightBundleDir(AEResInfo aEResInfo) {
        return AEResUtil.u(aEResInfo);
    }

    @Override // com.tencent.aelight.camera.download.api.IAEResUtil
    public Map<String, String> getLightBundleMap() {
        return AEResUtil.o();
    }

    @Override // com.tencent.aelight.camera.download.api.IAEResUtil
    public String getLightEmptyMaterialConfigPath() {
        return AEResUtil.w();
    }

    @Override // com.tencent.aelight.camera.download.api.IAEResUtil
    public String getLightModelDir() {
        return AEResUtil.y();
    }

    @Override // com.tencent.aelight.camera.download.api.IAEResUtil
    public String getLightSDKBaseResUnzipFinalPath() {
        return AEResUtil.z();
    }

    @Override // com.tencent.aelight.camera.download.api.IAEResUtil
    public String getLightSDKCachePath() {
        return AEResUtil.A();
    }

    @Override // com.tencent.aelight.camera.download.api.IAEResUtil
    public List<AEResInfo> getLightSDKResInfo() {
        return AEResManager.J().N();
    }

    @Override // com.tencent.aelight.camera.download.api.IAEResUtil
    public List<String> getNeedDownloadList(VideoMaterial videoMaterial) {
        return AEResUtil.D(videoMaterial);
    }

    @Override // com.tencent.aelight.camera.download.api.IAEResUtil
    public String getUnzipAEResPath(AEResInfo aEResInfo) {
        return AEResUtil.I(aEResInfo);
    }

    @Override // com.tencent.aelight.camera.download.api.IAEResUtil
    public boolean isAEBaseSoReady() {
        return AEResUtil.Q();
    }

    @Override // com.tencent.aelight.camera.download.api.IAEResUtil
    public boolean isAEBaseSoReadyWithConfig() {
        return isAEBaseSoReady();
    }

    @Override // com.tencent.aelight.camera.download.api.IAEResUtil
    public boolean isAEResExist(AEResInfo aEResInfo) {
        try {
            return AEResUtil.U(aEResInfo);
        } catch (Throwable th5) {
            a.c(TAG, "error:" + th5.getMessage());
            return false;
        }
    }

    @Override // com.tencent.aelight.camera.download.api.IAEResUtil
    public boolean isFilterFaceSoVersionOK() {
        return AEResUtil.Y();
    }

    @Override // com.tencent.aelight.camera.download.api.IAEResUtil
    public boolean isLightCameraBaseResNotAllExist() {
        return AEResUtil.Z();
    }

    @Override // com.tencent.aelight.camera.download.api.IAEResUtil
    public boolean isLightCameraResExist() {
        return AEResUtil.b0();
    }

    @Override // com.tencent.aelight.camera.download.api.IAEResUtil
    public boolean isLightSDKResExist() {
        try {
            return AEResUtil.f0();
        } catch (Throwable th5) {
            a.c(TAG, "error:" + th5.getMessage());
            return false;
        }
    }

    @Override // com.tencent.aelight.camera.download.api.IAEResUtil
    public boolean loadAEBaseSo() {
        return AEResUtil.j0();
    }

    @Override // com.tencent.aelight.camera.download.api.IAEResUtil
    public boolean loadAEBaseSoWithConfig() {
        return AEResUtil.k0();
    }

    @Override // com.tencent.aelight.camera.download.api.IAEResUtil
    public boolean loadLightSdk() {
        return AEResUtil.n0();
    }

    @Override // com.tencent.aelight.camera.download.api.IAEResUtil
    public boolean loadOnlyFilament() {
        return AEResUtil.l0();
    }

    @Override // com.tencent.aelight.camera.download.api.IAEResUtil
    public boolean loadOnlyPag() {
        return AEResUtil.m0();
    }

    @Override // com.tencent.aelight.camera.download.api.IAEResUtil
    public void peakRequestAEBaseRes() {
        AEResUtil.q0();
    }

    @Override // com.tencent.aelight.camera.download.api.IAEResUtil
    public void preDownloadAllNonEssentialBundles() {
        AEResUtil.r0();
    }

    @Override // com.tencent.aelight.camera.download.api.IAEResUtil
    public void registerSyncReceiver() {
        AEResManager.J().o0();
    }

    @Override // com.tencent.aelight.camera.download.api.IAEResUtil
    public void removeAEDownloadCallBack(com.tencent.aelight.camera.download.api.a aVar) {
        AEResManager.J().p0(aVar);
    }

    @Override // com.tencent.aelight.camera.download.api.IAEResUtil
    public void setHasSynced(boolean z16) {
        AEResUtil.f63641b.set(z16);
    }

    @Override // com.tencent.aelight.camera.download.api.IAEResUtil
    public void unRegisterSyncReceiver() {
        AEResManager.J().G0();
    }

    @Override // com.tencent.aelight.camera.download.api.IAEResUtil
    public void fetchSingleBundle(String str, com.tencent.aelight.camera.download.api.a aVar) {
        AEResUtil.j(str, aVar);
    }

    @Override // com.tencent.aelight.camera.download.api.IAEResUtil
    public void fetchSpecificBundles(List<String> list) {
        AEResUtil.g(list, false);
    }

    @Override // com.tencent.aelight.camera.download.api.IAEResUtil
    public int getAEResStatus(String str, String str2) {
        return AEResUtil.n(str, str2);
    }

    @Override // com.tencent.aelight.camera.download.api.IAEResUtil
    public String getLightBundleDir(String str) {
        return AEResUtil.v(str);
    }

    @Override // com.tencent.aelight.camera.download.api.IAEResUtil
    public List<String> getNeedDownloadList(VideoMaterial videoMaterial, String str) {
        return AEResUtil.E(videoMaterial, str);
    }

    @Override // com.tencent.aelight.camera.download.api.IAEResUtil
    public boolean isLightCameraBaseResNotAllExist(String str) {
        return AEResUtil.a0(str);
    }

    @Override // com.tencent.aelight.camera.download.api.IAEResUtil
    public boolean isLightCameraResExist(String str) {
        return AEResUtil.c0(str);
    }

    @Override // com.tencent.aelight.camera.download.api.IAEResUtil
    public boolean isAEResExist(String str) {
        try {
            return AEResUtil.V(str);
        } catch (Throwable th5) {
            a.c(TAG, "error:" + th5.getMessage());
            return false;
        }
    }

    @Override // com.tencent.aelight.camera.download.api.IAEResUtil
    public boolean isAEResExist(String str, String str2) {
        try {
            return AEResUtil.W(str, str2);
        } catch (Throwable th5) {
            a.c(TAG, "error:" + th5.getMessage());
            return false;
        }
    }
}
