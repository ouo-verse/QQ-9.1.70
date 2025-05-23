package com.tencent.ttpic.openapi.initializer;

import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface Initializable {
    List<ModelInfo> getModelInfos();

    String getName();

    List<SharedLibraryInfo> getSharedLibraries();

    boolean init();

    boolean isFunctionReady();

    boolean isResourceReady();
}
