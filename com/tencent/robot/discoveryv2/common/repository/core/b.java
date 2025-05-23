package com.tencent.robot.discoveryv2.common.repository.core;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.qqnt.kernel.nativeinterface.ListNode;
import com.tencent.robot.discoveryv2.common.data.FirstScreenFetchArgs;
import com.tencent.robot.discoveryv2.common.data.LoadState;
import com.tencent.robot.discoveryv2.common.data.RecommendRobotsData;
import com.tencent.robot.discoveryv2.common.data.SingleCategoryDetailData;
import com.tencent.robot.discoveryv2.common.data.SingleCategoryFetchArgs;
import com.tencent.robot.discoveryv2.common.data.SingleCategoryLoadData;
import com.tencent.robot.discoveryv2.common.data.SingleCategoryNextPageData;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\nH&J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH&J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\fH&J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\fH&J\u0014\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\fH&J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\fH&J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H&J\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0018H&J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u0018H&\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/robot/discoveryv2/common/repository/core/b;", "", "Lcom/tencent/robot/discoveryv2/common/repository/core/c;", "repositoryParams", "", h.F, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/robot/discoveryv2/common/data/a;", "fetchArgs", "a", "Lcom/tencent/robot/discoveryv2/common/data/f;", "j", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/robot/discoveryv2/common/data/LoadState;", "b", "Lcom/tencent/robot/discoveryv2/common/data/g;", "i", "Lcom/tencent/robot/discoveryv2/common/data/d;", "k", "", "Lcom/tencent/qqnt/kernel/nativeinterface/ListNode;", "d", "Lcom/tencent/robot/discoveryv2/common/data/i;", "g", "", "categoryId", "Lcom/tencent/robot/discoveryv2/common/data/e;", "f", "c", "", "l", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public interface b {
    void a(@NotNull FirstScreenFetchArgs fetchArgs);

    @NotNull
    Flow<LoadState> b();

    @NotNull
    SingleCategoryLoadData c(@NotNull String categoryId);

    @NotNull
    Flow<List<ListNode>> d();

    @Nullable
    SingleCategoryDetailData f(@NotNull String categoryId);

    @NotNull
    Flow<SingleCategoryNextPageData> g();

    void h(@NotNull RepositoryParams repositoryParams);

    @NotNull
    Flow<SingleCategoryLoadData> i();

    void j(@NotNull SingleCategoryFetchArgs fetchArgs);

    @NotNull
    Flow<RecommendRobotsData> k();

    boolean l(@NotNull String categoryId);

    void onDestroy();
}
