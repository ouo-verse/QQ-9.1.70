package com.tencent.ttpic.openapi.initializer;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes27.dex */
public class PagInitializer extends Feature {
    private static final String PAG_NAME = "pag";
    private static final String TAG = "PagInitializer";
    private static final SharedLibraryInfo[] sharedLibraries = new SharedLibraryInfo[0];

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
        return "Pag";
    }

    @Override // com.tencent.ttpic.openapi.initializer.Feature, com.tencent.ttpic.openapi.initializer.Initializable
    public List<SharedLibraryInfo> getSharedLibraries() {
        return Arrays.asList(sharedLibraries);
    }

    @Override // com.tencent.ttpic.openapi.initializer.Feature
    protected boolean initImpl() {
        return loadSo("pag", FeatureManager.getPagDir());
    }
}
