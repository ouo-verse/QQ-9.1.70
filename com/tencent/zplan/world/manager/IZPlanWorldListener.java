package com.tencent.zplan.world.manager;

import androidx.annotation.Keep;
import com.tencent.zplan.world.model.ZPlanWorld;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/zplan/world/manager/IZPlanWorldListener;", "", "onGetZPlanWorld", "", "zPlanWorld", "Lcom/tencent/zplan/world/model/ZPlanWorld;", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public interface IZPlanWorldListener {
    void onGetZPlanWorld(@Nullable ZPlanWorld zPlanWorld);
}
