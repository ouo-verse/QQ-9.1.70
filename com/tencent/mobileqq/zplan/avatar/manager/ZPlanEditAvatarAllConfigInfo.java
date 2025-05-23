package com.tencent.mobileqq.zplan.avatar.manager;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nu4.f;
import nu4.g;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\t\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\t8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000b\u0010\u000eR\u0017\u0010\u0016\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0014\u001a\u0004\b\u0011\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/manager/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Lnu4/g;", "a", "Ljava/util/List;", "c", "()Ljava/util/List;", "headConfigList", "Lnu4/a;", "b", "backgroundConfigList", "Lnu4/f;", "Lnu4/f;", "()Lnu4/f;", "globalConfig", "<init>", "(Ljava/util/List;Ljava/util/List;Lnu4/f;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.avatar.manager.b, reason: from toString */
/* loaded from: classes35.dex */
public final /* data */ class ZPlanEditAvatarAllConfigInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<g> headConfigList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<nu4.a> backgroundConfigList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final f globalConfig;

    public ZPlanEditAvatarAllConfigInfo(List<g> headConfigList, List<nu4.a> backgroundConfigList, f globalConfig) {
        Intrinsics.checkNotNullParameter(headConfigList, "headConfigList");
        Intrinsics.checkNotNullParameter(backgroundConfigList, "backgroundConfigList");
        Intrinsics.checkNotNullParameter(globalConfig, "globalConfig");
        this.headConfigList = headConfigList;
        this.backgroundConfigList = backgroundConfigList;
        this.globalConfig = globalConfig;
    }

    public final List<nu4.a> a() {
        return this.backgroundConfigList;
    }

    /* renamed from: b, reason: from getter */
    public final f getGlobalConfig() {
        return this.globalConfig;
    }

    public final List<g> c() {
        return this.headConfigList;
    }

    public int hashCode() {
        return (((this.headConfigList.hashCode() * 31) + this.backgroundConfigList.hashCode()) * 31) + this.globalConfig.hashCode();
    }

    public String toString() {
        return "ZPlanEditAvatarAllConfigInfo(headConfigList=" + this.headConfigList + ", backgroundConfigList=" + this.backgroundConfigList + ", globalConfig=" + this.globalConfig + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanEditAvatarAllConfigInfo)) {
            return false;
        }
        ZPlanEditAvatarAllConfigInfo zPlanEditAvatarAllConfigInfo = (ZPlanEditAvatarAllConfigInfo) other;
        return Intrinsics.areEqual(this.headConfigList, zPlanEditAvatarAllConfigInfo.headConfigList) && Intrinsics.areEqual(this.backgroundConfigList, zPlanEditAvatarAllConfigInfo.backgroundConfigList) && Intrinsics.areEqual(this.globalConfig, zPlanEditAvatarAllConfigInfo.globalConfig);
    }
}
