package com.tencent.mobileqq.zplan.authorize.impl.checker.scene;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.zplan.authorize.impl.manager.CheckPhoneManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\r\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/zplan/authorize/impl/checker/scene/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", WadlProxyConsts.SCENE_ID, "Lcom/tencent/mobileqq/zplan/authorize/impl/manager/CheckPhoneManager$EntryType;", "b", "Lcom/tencent/mobileqq/zplan/authorize/impl/manager/CheckPhoneManager$EntryType;", "()Lcom/tencent/mobileqq/zplan/authorize/impl/manager/CheckPhoneManager$EntryType;", "sceneType", "<init>", "(ILcom/tencent/mobileqq/zplan/authorize/impl/manager/CheckPhoneManager$EntryType;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.authorize.impl.checker.scene.a, reason: from toString */
/* loaded from: classes35.dex */
public final /* data */ class SceneCheckRequest {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int sceneId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final CheckPhoneManager.EntryType sceneType;

    public SceneCheckRequest(int i3, CheckPhoneManager.EntryType sceneType) {
        Intrinsics.checkNotNullParameter(sceneType, "sceneType");
        this.sceneId = i3;
        this.sceneType = sceneType;
    }

    /* renamed from: a, reason: from getter */
    public final int getSceneId() {
        return this.sceneId;
    }

    /* renamed from: b, reason: from getter */
    public final CheckPhoneManager.EntryType getSceneType() {
        return this.sceneType;
    }

    public int hashCode() {
        return (this.sceneId * 31) + this.sceneType.hashCode();
    }

    public String toString() {
        return "SceneCheckRequest(sceneId=" + this.sceneId + ", sceneType=" + this.sceneType + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SceneCheckRequest)) {
            return false;
        }
        SceneCheckRequest sceneCheckRequest = (SceneCheckRequest) other;
        return this.sceneId == sceneCheckRequest.sceneId && this.sceneType == sceneCheckRequest.sceneType;
    }
}
