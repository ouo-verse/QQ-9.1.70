package com.tencent.mobileqq.zplan.avatar.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.zplan.avatar.fragment.a;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/api/IZPlanAvatarEditResourceManagerFactory;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "", "actionList", "", "uin", "Lcom/tencent/mobileqq/zplan/avatar/fragment/a;", OperateCustomButton.OPERATE_CREATE, "zplan_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZPlanAvatarEditResourceManagerFactory extends QRouteApi {
    @NotNull
    a create(@NotNull List<Integer> actionList, @NotNull String uin);
}
