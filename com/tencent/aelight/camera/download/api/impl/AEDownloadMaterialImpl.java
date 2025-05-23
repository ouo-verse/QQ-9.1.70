package com.tencent.aelight.camera.download.api.impl;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.data.AEQZoneMaterialMetaData;
import com.tencent.aelight.camera.ae.download.AEMaterialDownloader;
import com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMaterialManager;
import com.tencent.aelight.camera.download.api.IAEDownloadMaterial;
import com.tencent.aelight.camera.download.api.impl.AEDownloadMaterialImpl;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler;
import com.tencent.mobileqq.wink.utils.ar;
import com.tencent.open.base.MD5Utils;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEDownloadMaterialImpl implements IAEDownloadMaterial {
    private static final String TAG = "AEDownloadMaterialImpl";
    private final String[] needDownloadResArray = {IAEDownloadMaterial.FILAMENT_FACE_CAMERA_RES_KEY, IAEDownloadMaterial.FILAMENT_FACE_THUMBNAIL_RES_KEY};
    private static ConcurrentHashMap<String, AEMaterialMetaData> materialCache = new ConcurrentHashMap<>();
    private static String FILAMENT_FACE_CAMERA_DEFAULT_ID = "filament_face_camera_default_221228_addsmile";
    private static String FILAMENT_FACE_CAMERA_DEFAULT_URL = "https://downv6.qq.com/shadow_qqcamera/zplanV2/filament_face_camera_default_221228_addsmile.zip";
    private static String FILAMENT_FACE_THUMBNAIL_DEFAULT_ID = "filament_face_thumbnail_default";
    private static String FILAMENT_FACE_THUMBNAIL_DEFAULT_URL = "https://downv6.qq.com/shadow_qqcamera/zplanV2/filament_face_thumbnail_default.zip";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements com.tencent.aelight.camera.download.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.aelight.camera.download.a f69013d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f69014e;

        a(com.tencent.aelight.camera.download.a aVar, String str) {
            this.f69013d = aVar;
            this.f69014e = str;
        }

        @Override // com.tencent.aelight.camera.download.a
        public void onDownloadFinish(AEMaterialMetaData aEMaterialMetaData, boolean z16, int i3) {
            com.tencent.aelight.camera.download.a aVar = this.f69013d;
            if (aVar != null) {
                aVar.onDownloadFinish(aEMaterialMetaData, z16, i3);
            }
            ms.a.f(AEDownloadMaterialImpl.TAG, "filament res onDownloadFinish " + aEMaterialMetaData.f69050id + ", isUsable:" + z16 + ", resCode:" + i3 + "path:" + AEDownloadMaterialImpl.this.getFilamentFaceTemplatePath(this.f69014e));
        }

        @Override // com.tencent.aelight.camera.download.a
        public void onProgressUpdate(AEMaterialMetaData aEMaterialMetaData, int i3) {
            ms.a.a(AEDownloadMaterialImpl.TAG, "filament res onProgressUpdate " + aEMaterialMetaData.f69050id + ", progress:" + i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b extends TypeToken<AEMaterialMetaData> {
        b() {
        }
    }

    private AEMaterialMetaData getFilamentFaceMaterial(String str) {
        String str2 = "";
        if (IAEDownloadMaterial.FILAMENT_FACE_CAMERA_RES_KEY.equals(str)) {
            str2 = ar.f326685a.i("ae_key_editor_zplan_filament_face_camera_material_json", "");
        } else if (IAEDownloadMaterial.FILAMENT_FACE_THUMBNAIL_RES_KEY.equals(str)) {
            str2 = ar.f326685a.i("ae_key_editor_zplan_filament_face_thumbnail_material_json", "");
        }
        if (!TextUtils.isEmpty(str2)) {
            try {
                AEMaterialMetaData aEMaterialMetaData = (AEMaterialMetaData) new Gson().fromJson(str2, new b().getType());
                if (aEMaterialMetaData != null) {
                    return aEMaterialMetaData;
                }
            } catch (Exception e16) {
                ms.a.d(TAG, "parse " + str + " json error ", e16);
            }
        }
        AEMaterialMetaData aEMaterialMetaData2 = new AEMaterialMetaData();
        if (IAEDownloadMaterial.FILAMENT_FACE_CAMERA_RES_KEY.equals(str)) {
            aEMaterialMetaData2.f69050id = FILAMENT_FACE_CAMERA_DEFAULT_ID;
            aEMaterialMetaData2.resurl = FILAMENT_FACE_CAMERA_DEFAULT_URL;
        } else {
            if (!IAEDownloadMaterial.FILAMENT_FACE_THUMBNAIL_RES_KEY.equals(str)) {
                return null;
            }
            aEMaterialMetaData2.f69050id = FILAMENT_FACE_THUMBNAIL_DEFAULT_ID;
            aEMaterialMetaData2.resurl = FILAMENT_FACE_THUMBNAIL_DEFAULT_URL;
        }
        aEMaterialMetaData2.name = aEMaterialMetaData2.f69050id;
        aEMaterialMetaData2.md5 = MD5Utils.toMD5(aEMaterialMetaData2.resurl).toLowerCase();
        return aEMaterialMetaData2;
    }

    private AEMaterialMetaData getMetaDataByID(String str) {
        if (materialCache.containsKey(str)) {
            AEMaterialMetaData aEMaterialMetaData = materialCache.get(str);
            ms.a.f(TAG, "getMetaDataByID cache true materialKey:" + str + ", this" + aEMaterialMetaData);
            return aEMaterialMetaData;
        }
        AEMaterialMetaData filamentFaceMaterial = getFilamentFaceMaterial(str);
        ms.a.f(TAG, "getMetaDataByID cache false materialKey:" + str + ", this" + filamentFaceMaterial);
        if (filamentFaceMaterial == null) {
            return filamentFaceMaterial;
        }
        materialCache.put(str, filamentFaceMaterial);
        return filamentFaceMaterial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$refreshFilamentAiFaceMaterialList$0() {
        try {
            ((WinkDataServiceHandler) com.tencent.mobileqq.wink.b.a().getBusinessHandler(WinkDataServiceHandler.class.getName())).m3("ZplanAISculpt");
        } catch (Exception e16) {
            w53.b.d(TAG, "[fetchEditorResource] exception: ", e16);
        }
    }

    private void startDownloadFilamentRes(AppRuntime appRuntime, String str, com.tencent.aelight.camera.download.a aVar) {
        ms.a.f(TAG, "startDownloadFilamentRes " + str);
        AEFlashShowMaterialManager aEFlashShowMaterialManager = (AEFlashShowMaterialManager) com.tencent.aelight.camera.ae.control.a.b(3);
        AEMaterialMetaData metaDataByID = getMetaDataByID(str);
        if (metaDataByID != null && !metaDataByID.downloading) {
            ms.a.f(TAG, "startDownloadFilamentRes do start download");
            metaDataByID.downloading = true;
            aEFlashShowMaterialManager.r0(appRuntime, metaDataByID, new a(aVar, str));
            return;
        }
        ms.a.f(TAG, "startDownloadFilamentRes is downloading or empty");
    }

    @Override // com.tencent.aelight.camera.download.api.IAEDownloadMaterial
    public String getFilamentFaceTemplatePath(String str) {
        AEMaterialMetaData metaDataByID = getMetaDataByID(str);
        if (metaDataByID != null) {
            return metaDataByID.getLocalPath();
        }
        return null;
    }

    @Override // com.tencent.aelight.camera.download.api.IAEDownloadMaterial
    public boolean isFilamentFaceResReady() {
        ms.a.a(TAG, "isFilamentFaceResReady");
        AEFlashShowMaterialManager aEFlashShowMaterialManager = (AEFlashShowMaterialManager) com.tencent.aelight.camera.ae.control.a.b(3);
        boolean z16 = true;
        for (String str : this.needDownloadResArray) {
            z16 = z16 && aEFlashShowMaterialManager.O(getMetaDataByID(str));
            if (!z16) {
                return false;
            }
        }
        return true;
    }

    @Override // com.tencent.aelight.camera.download.api.IAEDownloadMaterial
    public boolean isQZoneCameraMaterialReady(String str) {
        return AEMaterialManager.j(AEQZoneMaterialMetaData.createAEQZoneMaterialMetaData(str));
    }

    @Override // com.tencent.aelight.camera.download.api.IAEDownloadMaterial
    public void preDownloadMaterial(String str) {
        AEMaterialDownloader.g(str);
    }

    @Override // com.tencent.aelight.camera.download.api.IAEDownloadMaterial
    public void preDownloadQZoneCameraMaterialByUrl(String str) {
        AEMaterialDownloader.h(str);
    }

    @Override // com.tencent.aelight.camera.download.api.IAEDownloadMaterial
    public void refreshFilamentAiFaceMaterialList() {
        ThreadManagerV2.excute(new Runnable() { // from class: is.a
            @Override // java.lang.Runnable
            public final void run() {
                AEDownloadMaterialImpl.lambda$refreshFilamentAiFaceMaterialList$0();
            }
        }, 64, null, false);
    }

    @Override // com.tencent.aelight.camera.download.api.IAEDownloadMaterial
    public void startDownloadFilamentFaceRes(AppRuntime appRuntime, com.tencent.aelight.camera.download.a aVar) {
        for (String str : this.needDownloadResArray) {
            startDownloadFilamentRes(appRuntime, str, aVar);
        }
    }

    @Override // com.tencent.aelight.camera.download.api.IAEDownloadMaterial
    public void startDownloadMaterial(AppRuntime appRuntime, AEMaterialMetaData aEMaterialMetaData, String str, com.tencent.aelight.camera.download.a aVar) {
        AEMaterialDownloader.l(appRuntime, aEMaterialMetaData, str, aVar);
    }
}
