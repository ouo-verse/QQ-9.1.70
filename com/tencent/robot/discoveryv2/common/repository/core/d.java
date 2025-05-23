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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010$\u001a\u00020\"\u00a2\u0006\u0004\b%\u0010&J\u0015\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\u0096\u0001J\u0011\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u000bH\u0096\u0001J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0003H\u0096\u0001J\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0096\u0001J\u0011\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000fH\u0096\u0001J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0003H\u0096\u0001J\u0011\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u000fH\u0096\u0001J\u0011\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0019H\u0096\u0001J\t\u0010\u001c\u001a\u00020\tH\u0096\u0001J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0003H\u0096\u0001J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00130\u0003H\u0096\u0001J\u0006\u0010!\u001a\u00020 R\u0014\u0010$\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/robot/discoveryv2/common/repository/core/d;", "Lq34/a;", "Lcom/tencent/robot/discoveryv2/common/repository/core/b;", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/ListNode;", "d", "Lcom/tencent/robot/discoveryv2/common/data/a;", "fetchArgs", "", "a", "Lcom/tencent/robot/discoveryv2/common/data/f;", "j", "Lcom/tencent/robot/discoveryv2/common/data/LoadState;", "b", "", "categoryId", "Lcom/tencent/robot/discoveryv2/common/data/e;", "f", "Lcom/tencent/robot/discoveryv2/common/data/g;", "c", "Lcom/tencent/robot/discoveryv2/common/data/i;", "g", "", "l", "Lcom/tencent/robot/discoveryv2/common/repository/core/c;", "repositoryParams", h.F, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/robot/discoveryv2/common/data/d;", "k", "i", "", "e", "Lcom/tencent/robot/discoveryv2/common/repository/core/a;", "Lcom/tencent/robot/discoveryv2/common/repository/core/a;", "mRepositoryDelegate", "<init>", "(Lcom/tencent/robot/discoveryv2/common/repository/core/a;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class d implements q34.a, b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a mRepositoryDelegate;

    public d(@NotNull a mRepositoryDelegate) {
        Intrinsics.checkNotNullParameter(mRepositoryDelegate, "mRepositoryDelegate");
        this.mRepositoryDelegate = mRepositoryDelegate;
    }

    @Override // com.tencent.robot.discoveryv2.common.repository.core.b
    public void a(@NotNull FirstScreenFetchArgs fetchArgs) {
        Intrinsics.checkNotNullParameter(fetchArgs, "fetchArgs");
        this.mRepositoryDelegate.a(fetchArgs);
    }

    @Override // com.tencent.robot.discoveryv2.common.repository.core.b
    @NotNull
    public Flow<LoadState> b() {
        return this.mRepositoryDelegate.b();
    }

    @Override // com.tencent.robot.discoveryv2.common.repository.core.b
    @NotNull
    public SingleCategoryLoadData c(@NotNull String categoryId) {
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        return this.mRepositoryDelegate.c(categoryId);
    }

    @Override // com.tencent.robot.discoveryv2.common.repository.core.b
    @NotNull
    public Flow<List<ListNode>> d() {
        return this.mRepositoryDelegate.d();
    }

    @NotNull
    public final Object e() {
        return this.mRepositoryDelegate;
    }

    @Override // com.tencent.robot.discoveryv2.common.repository.core.b
    @Nullable
    public SingleCategoryDetailData f(@NotNull String categoryId) {
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        return this.mRepositoryDelegate.f(categoryId);
    }

    @Override // com.tencent.robot.discoveryv2.common.repository.core.b
    @NotNull
    public Flow<SingleCategoryNextPageData> g() {
        return this.mRepositoryDelegate.g();
    }

    @Override // com.tencent.robot.discoveryv2.common.repository.core.b
    public void h(@NotNull RepositoryParams repositoryParams) {
        Intrinsics.checkNotNullParameter(repositoryParams, "repositoryParams");
        this.mRepositoryDelegate.h(repositoryParams);
    }

    @Override // com.tencent.robot.discoveryv2.common.repository.core.b
    @NotNull
    public Flow<SingleCategoryLoadData> i() {
        return this.mRepositoryDelegate.i();
    }

    @Override // com.tencent.robot.discoveryv2.common.repository.core.b
    public void j(@NotNull SingleCategoryFetchArgs fetchArgs) {
        Intrinsics.checkNotNullParameter(fetchArgs, "fetchArgs");
        this.mRepositoryDelegate.j(fetchArgs);
    }

    @Override // com.tencent.robot.discoveryv2.common.repository.core.b
    @NotNull
    public Flow<RecommendRobotsData> k() {
        return this.mRepositoryDelegate.k();
    }

    @Override // com.tencent.robot.discoveryv2.common.repository.core.b
    public boolean l(@NotNull String categoryId) {
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        return this.mRepositoryDelegate.l(categoryId);
    }

    @Override // com.tencent.robot.discoveryv2.common.repository.core.b
    public void onDestroy() {
        this.mRepositoryDelegate.onDestroy();
    }
}
