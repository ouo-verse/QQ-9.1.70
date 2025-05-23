package com.tencent.mobileqq.zplan.model;

import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/zplan/model/i;", "Ljava/util/Date;", "now", "", "a", "zplan_api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class j {
    public static final boolean a(@NotNull ZPlanMaintInfo zPlanMaintInfo, @NotNull Date now) {
        Intrinsics.checkNotNullParameter(zPlanMaintInfo, "<this>");
        Intrinsics.checkNotNullParameter(now, "now");
        if (zPlanMaintInfo.getMEnable() || !now.after(zPlanMaintInfo.getMBeginTime()) || !now.before(zPlanMaintInfo.getMEndTime())) {
            return false;
        }
        return true;
    }
}
