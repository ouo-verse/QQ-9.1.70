package com.tencent.mobileqq.troop.selectmember.inject;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.troop.selectmember.config.TroopSelectMemberConfig;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J \u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/troop/selectmember/inject/c;", "", "Lcom/tencent/mobileqq/troop/selectmember/config/TroopSelectMemberConfig;", "launchConfig", "Lcom/tencent/mobileqq/troop/selectmember/bean/a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "position", "", "b", "Lcom/tencent/mobileqq/troop/selectmember/bean/b;", VipFunCallConstants.KEY_GROUP, "a", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public interface c {
    boolean a(@NotNull TroopSelectMemberConfig launchConfig, @NotNull com.tencent.mobileqq.troop.selectmember.bean.b group, int position);

    boolean b(@NotNull TroopSelectMemberConfig launchConfig, @NotNull com.tencent.mobileqq.troop.selectmember.bean.a item, int position);
}
