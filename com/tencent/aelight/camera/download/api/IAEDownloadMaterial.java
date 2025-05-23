package com.tencent.aelight.camera.download.api;

import androidx.annotation.Nullable;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IAEDownloadMaterial extends QRouteApi {
    public static final String FILAMENT_FACE_CAMERA_RES_KEY = "filament_face_camera";
    public static final String FILAMENT_FACE_THUMBNAIL_RES_KEY = "filament_face_thumbnail";
    public static final String QZONE_CIKE_CAMERA_DEFAULT_MATERIAL_URL = "https://downv6.qq.com/shadow_qqcamera/qzone/video_tonghualian_basic_0204.zip";

    @Nullable
    String getFilamentFaceTemplatePath(String str);

    boolean isFilamentFaceResReady();

    boolean isQZoneCameraMaterialReady(String str);

    void preDownloadMaterial(String str);

    void preDownloadQZoneCameraMaterialByUrl(String str);

    void refreshFilamentAiFaceMaterialList();

    void startDownloadFilamentFaceRes(AppRuntime appRuntime, com.tencent.aelight.camera.download.a aVar);

    void startDownloadMaterial(AppRuntime appRuntime, AEMaterialMetaData aEMaterialMetaData, String str, com.tencent.aelight.camera.download.a aVar);
}
