package com.eclipsesource.mmv8.snapshot;

import com.eclipsesource.mmv8.snapshot.CreateSnapshotResult;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class CreateSnapshotParams {
    public final List<ContextBootstrapParams> contextBootstrapParamsList;
    public final SnapshotScriptInfo globalSnapshotGlueScriptInfo;
    public boolean injectConsole;
    public final boolean keepCompiledData;
    public final String snapshotDirPath;
    public final List<SnapshotScriptInfo> warmupScriptInfoList;

    public CreateSnapshotParams(boolean z16, SnapshotScriptInfo snapshotScriptInfo, List<ContextBootstrapParams> list, List<SnapshotScriptInfo> list2, boolean z17, String str) {
        if (list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                ContextBootstrapParams contextBootstrapParams = list.get(i3);
                if (contextBootstrapParams != null) {
                    if (contextBootstrapParams.setupNodeEnv && CreateSnapshotResult.Success.NODE_MAIN_CONTEXT_INDEX != i3) {
                        throw new IllegalArgumentException("only the first contextBootstrapParams support setupNodeEnv");
                    }
                } else {
                    throw new IllegalArgumentException("contextBootstrapParams is null");
                }
            }
        }
        if (list2 != null) {
            Iterator<SnapshotScriptInfo> it = list2.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new IllegalArgumentException("warmupScriptInfo is null");
                }
            }
        }
        if (!Utils.isNullOrEmpty(str)) {
            this.injectConsole = z16;
            this.globalSnapshotGlueScriptInfo = snapshotScriptInfo;
            this.contextBootstrapParamsList = list == null ? Collections.emptyList() : list;
            this.warmupScriptInfoList = list2 == null ? Collections.emptyList() : list2;
            this.keepCompiledData = z17;
            this.snapshotDirPath = str;
            return;
        }
        throw new IllegalArgumentException("snapshotDirPath is illegal");
    }

    public String toString() {
        return "CreateSnapshotParams{injectConsole=" + this.injectConsole + ", globalSnapshotGlueScriptInfo=" + this.globalSnapshotGlueScriptInfo + ", contextBootstrapParamsList=" + Arrays.toString(this.contextBootstrapParamsList.toArray()) + ", warmupScriptInfoList=" + Arrays.toString(this.warmupScriptInfoList.toArray()) + ", keepCompiledData=" + this.keepCompiledData + ", snapshotDirPath='" + this.snapshotDirPath + "'}";
    }
}
