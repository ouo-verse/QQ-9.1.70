package com.tencent.mobileqq.zplan.aigc.render;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/render/ParamsConfig;", "", "MatInstList", "", "Lcom/tencent/mobileqq/zplan/aigc/render/MaterialInst;", "(Ljava/util/List;)V", "getMatInstList", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final /* data */ class ParamsConfig {
    private final List<MaterialInst> MatInstList;

    public ParamsConfig(List<MaterialInst> MatInstList) {
        Intrinsics.checkNotNullParameter(MatInstList, "MatInstList");
        this.MatInstList = MatInstList;
    }

    public final List<MaterialInst> component1() {
        return this.MatInstList;
    }

    public final ParamsConfig copy(List<MaterialInst> MatInstList) {
        Intrinsics.checkNotNullParameter(MatInstList, "MatInstList");
        return new ParamsConfig(MatInstList);
    }

    public final List<MaterialInst> getMatInstList() {
        return this.MatInstList;
    }

    public int hashCode() {
        return this.MatInstList.hashCode();
    }

    public String toString() {
        return "ParamsConfig(MatInstList=" + this.MatInstList + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ParamsConfig copy$default(ParamsConfig paramsConfig, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = paramsConfig.MatInstList;
        }
        return paramsConfig.copy(list);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ParamsConfig) && Intrinsics.areEqual(this.MatInstList, ((ParamsConfig) other).MatInstList);
    }
}
