package com.tencent.ttpic.openapi.initializer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes27.dex */
public class PtuToolsInitializer extends Feature {
    private static final String TAG = "PtuToolsInitializer";
    private static final SharedLibraryInfo[] sharedLibraries = {new SharedLibraryInfo("pitu_tools"), new SharedLibraryInfo("pitu_device")};

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
        return "PtuTools";
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
