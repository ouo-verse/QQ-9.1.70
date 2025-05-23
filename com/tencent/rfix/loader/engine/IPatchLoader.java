package com.tencent.rfix.loader.engine;

import com.tencent.rfix.loader.entity.RFixLoadResult;
import java.io.File;

/* loaded from: classes25.dex */
public interface IPatchLoader {
    boolean cleanPatch(File file);

    String getPatchType();

    boolean loadPatch(RFixLoadResult rFixLoadResult);
}
