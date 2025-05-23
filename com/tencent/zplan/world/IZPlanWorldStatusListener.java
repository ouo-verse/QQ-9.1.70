package com.tencent.zplan.world;

import androidx.annotation.Keep;
import com.tencent.zplan.world.model.FirstFrameResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/zplan/world/IZPlanWorldStatusListener;", "", "onEnterSceneResult", "", "success", "", "onFirstFrame", "result", "Lcom/tencent/zplan/world/model/FirstFrameResult;", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public interface IZPlanWorldStatusListener {
    void onEnterSceneResult(boolean success);

    void onFirstFrame(@NotNull FirstFrameResult result);

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class a {
        public static void b(@NotNull IZPlanWorldStatusListener iZPlanWorldStatusListener, @NotNull FirstFrameResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
        }

        public static void a(@NotNull IZPlanWorldStatusListener iZPlanWorldStatusListener, boolean z16) {
        }
    }
}
