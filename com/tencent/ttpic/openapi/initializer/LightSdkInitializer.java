package com.tencent.ttpic.openapi.initializer;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class LightSdkInitializer extends Feature {
    private static final String FILAMENT_NAME = "ace_zplan";
    private static final String PAG_NAME = "pag";
    private static final String TAG = "LightSdkInitializer";
    private static final SharedLibraryInfo[] SHARED_LIBRARIES = {new SharedLibraryInfo("light-sdk")};
    private static final SharedLibraryInfo CPP_SHARED = new SharedLibraryInfo("c++_shared");
    private static final SharedLibraryInfo OPENCV_WORLD = new SharedLibraryInfo("opencv_world");
    private static final SharedLibraryInfo V8_JNI = new SharedLibraryInfo(AECameraConstants.LIB_V8);

    private boolean loadSo(String str, String str2) {
        String str3 = TAG;
        Log.i(str3, "loadSo" + str + "path" + str2);
        String genSeperateFileDir = FileUtils.genSeperateFileDir(str2);
        SharedLibraryInfo sharedLibraryInfo = new SharedLibraryInfo(str);
        if (TextUtils.isEmpty(genSeperateFileDir)) {
            Log.e(str3, "soDir is null");
            return false;
        }
        if (new File(genSeperateFileDir, Feature.getFullLibname(sharedLibraryInfo.fileName)).exists()) {
            return systemLoadSafely(genSeperateFileDir, new SharedLibraryInfo(sharedLibraryInfo.fileName));
        }
        Log.e(str3, "soDir not exists");
        return false;
    }

    @Override // com.tencent.ttpic.openapi.initializer.Feature
    protected boolean destroyImpl() {
        return false;
    }

    @Override // com.tencent.ttpic.openapi.initializer.Feature, com.tencent.ttpic.openapi.initializer.Initializable
    public List<ModelInfo> getModelInfos() {
        return new ArrayList();
    }

    @Override // com.tencent.ttpic.openapi.initializer.Feature, com.tencent.ttpic.openapi.initializer.Initializable
    public String getName() {
        return "LightSdk";
    }

    @Override // com.tencent.ttpic.openapi.initializer.Feature, com.tencent.ttpic.openapi.initializer.Initializable
    public List<SharedLibraryInfo> getSharedLibraries() {
        return Arrays.asList(SHARED_LIBRARIES);
    }

    @Override // com.tencent.ttpic.openapi.initializer.Feature
    protected boolean initImpl() {
        if (!isExternalSoLoad()) {
            if (systemLoadLibrarySafely(V8_JNI.fileName) && loadSo(FILAMENT_NAME, FeatureManager.getFilamentDir()) && loadSo("pag", FeatureManager.getPagDir()) && loadAllSoFiles()) {
                return true;
            }
            return false;
        }
        FileUtils.genSeperateFileDir(FeatureManager.getSoDir());
        if (systemLoadLibrarySafely(V8_JNI.fileName) && loadSo(FILAMENT_NAME, FeatureManager.getFilamentDir()) && loadSo("pag", FeatureManager.getPagDir()) && loadAllSoFiles()) {
            return true;
        }
        return false;
    }
}
