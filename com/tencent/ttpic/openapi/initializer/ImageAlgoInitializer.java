package com.tencent.ttpic.openapi.initializer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ImageAlgoInitializer extends Feature {
    private static final String TAG = "ImageAlgoInitializer";
    private static final SharedLibraryInfo[] sharedLibraries = {new SharedLibraryInfo("algo_rithm_jni")};

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
        return "ImageAlgo";
    }

    @Override // com.tencent.ttpic.openapi.initializer.Feature, com.tencent.ttpic.openapi.initializer.Initializable
    public List<SharedLibraryInfo> getSharedLibraries() {
        return Arrays.asList(sharedLibraries);
    }

    @Override // com.tencent.ttpic.openapi.initializer.Feature
    protected boolean initImpl() {
        return loadAllSoFiles();
    }
}
