package com.tencent.mobileqq.zplan.avatar.api.impl;

import com.tencent.mobileqq.zplan.avatar.api.IZPlanAvatarEditResourceManagerFactory;
import com.tencent.mobileqq.zplan.avatar.fragment.a;
import com.tencent.mobileqq.zplan.avatar.fragment.f;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/api/impl/ZPlanAvatarEditResourceManagerFactoryImpl;", "Lcom/tencent/mobileqq/zplan/avatar/api/IZPlanAvatarEditResourceManagerFactory;", "", "", "actionList", "", "uin", "Lcom/tencent/mobileqq/zplan/avatar/fragment/a;", OperateCustomButton.OPERATE_CREATE, "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanAvatarEditResourceManagerFactoryImpl implements IZPlanAvatarEditResourceManagerFactory {
    @Override // com.tencent.mobileqq.zplan.avatar.api.IZPlanAvatarEditResourceManagerFactory
    public a create(List<Integer> actionList, String uin) {
        Intrinsics.checkNotNullParameter(actionList, "actionList");
        Intrinsics.checkNotNullParameter(uin, "uin");
        return new f(actionList, uin);
    }
}
