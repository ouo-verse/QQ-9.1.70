package com.eclipsesource.mmv8.snapshot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class ContextBootstrapParams {
    public final SnapshotScriptInfo[] bootstrapScriptInfos;
    public final String name;
    public final boolean setupNodeEnv;
    public final SnapshotScriptInfo snapshotGlueScriptInfo;

    /* loaded from: classes2.dex */
    public static class Builder {
        private SnapshotScriptInfo mSnapshotGlueScriptInfo;
        private String mName = null;
        private final List<SnapshotScriptInfo> mBootstrapScriptInfos = new ArrayList();
        private boolean mSetupNodeEnv = false;

        public Builder appendBootstrapScriptInfo(SnapshotScriptInfo snapshotScriptInfo) {
            this.mBootstrapScriptInfos.add(snapshotScriptInfo);
            return this;
        }

        public ContextBootstrapParams build() {
            if (!Utils.isNullOrEmpty(this.mName)) {
                int size = this.mBootstrapScriptInfos.size();
                SnapshotScriptInfo[] snapshotScriptInfoArr = new SnapshotScriptInfo[size];
                for (int i3 = 0; i3 < size; i3++) {
                    snapshotScriptInfoArr[i3] = this.mBootstrapScriptInfos.get(i3);
                }
                return new ContextBootstrapParams(this.mName, this.mSnapshotGlueScriptInfo, snapshotScriptInfoArr, this.mSetupNodeEnv);
            }
            throw new IllegalStateException("name is empty");
        }

        public Builder name(String str) {
            if (!Utils.isNullOrEmpty(str)) {
                this.mName = str;
                return this;
            }
            throw new IllegalArgumentException("name is empty");
        }

        public Builder setupNodeEnv(boolean z16) {
            this.mSetupNodeEnv = z16;
            return this;
        }

        public Builder snapshotGlueScriptInfo(SnapshotScriptInfo snapshotScriptInfo) {
            this.mSnapshotGlueScriptInfo = snapshotScriptInfo;
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ContextBootstrapParams.class == obj.getClass()) {
            return this.name.equals(((ContextBootstrapParams) obj).name);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.name);
    }

    public String toString() {
        return "ContextBootstrapParams{name='" + this.name + "', snapshotGlueScriptInfo=" + this.snapshotGlueScriptInfo + ", bootstrapScriptInfos=" + Arrays.toString(this.bootstrapScriptInfos) + ", setupNodeEnv=" + this.setupNodeEnv + '}';
    }

    ContextBootstrapParams(String str, SnapshotScriptInfo snapshotScriptInfo, SnapshotScriptInfo[] snapshotScriptInfoArr, boolean z16) {
        this.name = str;
        this.snapshotGlueScriptInfo = snapshotScriptInfo;
        this.bootstrapScriptInfos = snapshotScriptInfoArr;
        this.setupNodeEnv = z16;
    }
}
