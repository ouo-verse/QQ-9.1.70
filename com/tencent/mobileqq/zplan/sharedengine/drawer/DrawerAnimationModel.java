package com.tencent.mobileqq.zplan.sharedengine.drawer;

import com.tencent.filament.zplan.animation.ZPlanAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\t\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0010\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0012\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0013\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0011\u0010\f\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/zplan/sharedengine/drawer/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/filament/zplan/animation/ZPlanAction;", "a", "Lcom/tencent/filament/zplan/animation/ZPlanAction;", "()Lcom/tencent/filament/zplan/animation/ZPlanAction;", "breathAction", "b", "d", "stretchAction", "c", "refreshAction", "standBreathAction", "<init>", "(Lcom/tencent/filament/zplan/animation/ZPlanAction;Lcom/tencent/filament/zplan/animation/ZPlanAction;Lcom/tencent/filament/zplan/animation/ZPlanAction;Lcom/tencent/filament/zplan/animation/ZPlanAction;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.sharedengine.drawer.a, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class DrawerAnimationModel {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final ZPlanAction breathAction;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final ZPlanAction stretchAction;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final ZPlanAction refreshAction;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final ZPlanAction standBreathAction;

    public DrawerAnimationModel(ZPlanAction breathAction, ZPlanAction stretchAction, ZPlanAction refreshAction, ZPlanAction standBreathAction) {
        Intrinsics.checkNotNullParameter(breathAction, "breathAction");
        Intrinsics.checkNotNullParameter(stretchAction, "stretchAction");
        Intrinsics.checkNotNullParameter(refreshAction, "refreshAction");
        Intrinsics.checkNotNullParameter(standBreathAction, "standBreathAction");
        this.breathAction = breathAction;
        this.stretchAction = stretchAction;
        this.refreshAction = refreshAction;
        this.standBreathAction = standBreathAction;
    }

    /* renamed from: a, reason: from getter */
    public final ZPlanAction getBreathAction() {
        return this.breathAction;
    }

    /* renamed from: b, reason: from getter */
    public final ZPlanAction getRefreshAction() {
        return this.refreshAction;
    }

    /* renamed from: c, reason: from getter */
    public final ZPlanAction getStandBreathAction() {
        return this.standBreathAction;
    }

    /* renamed from: d, reason: from getter */
    public final ZPlanAction getStretchAction() {
        return this.stretchAction;
    }

    public int hashCode() {
        return (((((this.breathAction.hashCode() * 31) + this.stretchAction.hashCode()) * 31) + this.refreshAction.hashCode()) * 31) + this.standBreathAction.hashCode();
    }

    public String toString() {
        return "DrawerAnimationModel(breathAction=" + this.breathAction + ", stretchAction=" + this.stretchAction + ", refreshAction=" + this.refreshAction + ", standBreathAction=" + this.standBreathAction + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DrawerAnimationModel)) {
            return false;
        }
        DrawerAnimationModel drawerAnimationModel = (DrawerAnimationModel) other;
        return Intrinsics.areEqual(this.breathAction, drawerAnimationModel.breathAction) && Intrinsics.areEqual(this.stretchAction, drawerAnimationModel.stretchAction) && Intrinsics.areEqual(this.refreshAction, drawerAnimationModel.refreshAction) && Intrinsics.areEqual(this.standBreathAction, drawerAnimationModel.standBreathAction);
    }
}
