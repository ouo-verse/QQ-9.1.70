package com.tencent.mobileqq.zplan.aigc.data;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uv4.bn;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/data/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Luv4/bn;", "a", "[Luv4/bn;", "()[Luv4/bn;", "templateInfoMap", "", "b", "J", "getUgcId", "()J", "ugcId", "<init>", "([Luv4/bn;J)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.aigc.data.e, reason: from toString */
/* loaded from: classes35.dex */
public final /* data */ class AIGCTemplateInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final bn[] templateInfoMap;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long ugcId;

    public AIGCTemplateInfo(bn[] templateInfoMap, long j3) {
        Intrinsics.checkNotNullParameter(templateInfoMap, "templateInfoMap");
        this.templateInfoMap = templateInfoMap;
        this.ugcId = j3;
    }

    /* renamed from: a, reason: from getter */
    public final bn[] getTemplateInfoMap() {
        return this.templateInfoMap;
    }

    public int hashCode() {
        return (Arrays.hashCode(this.templateInfoMap) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.ugcId);
    }

    public String toString() {
        return "AIGCTemplateInfo(templateInfoMap=" + Arrays.toString(this.templateInfoMap) + ", ugcId=" + this.ugcId + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AIGCTemplateInfo)) {
            return false;
        }
        AIGCTemplateInfo aIGCTemplateInfo = (AIGCTemplateInfo) other;
        return Intrinsics.areEqual(this.templateInfoMap, aIGCTemplateInfo.templateInfoMap) && this.ugcId == aIGCTemplateInfo.ugcId;
    }
}
