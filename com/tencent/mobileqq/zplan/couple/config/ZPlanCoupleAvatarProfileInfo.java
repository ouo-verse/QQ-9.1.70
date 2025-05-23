package com.tencent.mobileqq.zplan.couple.config;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "uin")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u0004H\u0016R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/zplan/couple/config/ZPlanCoupleAvatarProfileInfo;", "Lcom/tencent/mobileqq/persistence/Entity;", "()V", "uin", "", "switchStatus", "", WadlProxyConsts.SCENE_ID, "", "(Ljava/lang/String;ZI)V", "toString", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class ZPlanCoupleAvatarProfileInfo extends Entity {
    public int sceneId;
    public boolean switchStatus;
    public final String uin;

    public /* synthetic */ ZPlanCoupleAvatarProfileInfo(String str, boolean z16, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i16 & 2) != 0 ? false : z16, (i16 & 4) != 0 ? 0 : i3);
    }

    public String toString() {
        return "uin: " + this.uin + ", switchStatus: " + this.switchStatus + ", sceneId: " + this.sceneId;
    }

    public ZPlanCoupleAvatarProfileInfo(String uin, boolean z16, int i3) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        this.uin = uin;
        this.switchStatus = z16;
        this.sceneId = i3;
    }

    public ZPlanCoupleAvatarProfileInfo() {
        this("", false, 0, 6, null);
    }
}
