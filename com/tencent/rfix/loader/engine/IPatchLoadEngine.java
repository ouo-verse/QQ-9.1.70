package com.tencent.rfix.loader.engine;

import com.tencent.rfix.loader.entity.RFixLoadResult;

/* loaded from: classes25.dex */
public interface IPatchLoadEngine {
    IPatchLoader getLoader(String str);

    boolean registerLoader(IPatchLoader iPatchLoader);

    RFixLoadResult tryLoadPatch();
}
