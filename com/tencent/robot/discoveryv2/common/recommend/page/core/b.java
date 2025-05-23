package com.tencent.robot.discoveryv2.common.recommend.page.core;

import com.tencent.robot.discoveryv2.common.data.LoadState;
import com.tencent.robot.discoveryv2.common.data.SingleCategoryLoadType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/robot/discoveryv2/common/recommend/page/core/b;", "", "<init>", "()V", "a", "b", "c", "Lcom/tencent/robot/discoveryv2/common/recommend/page/core/b$a;", "Lcom/tencent/robot/discoveryv2/common/recommend/page/core/b$b;", "Lcom/tencent/robot/discoveryv2/common/recommend/page/core/b$c;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/robot/discoveryv2/common/recommend/page/core/b$a;", "Lcom/tencent/robot/discoveryv2/common/recommend/page/core/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Z", "()Z", "haveNextPage", "<init>", "(Z)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.discoveryv2.common.recommend.page.core.b$a, reason: from toString */
    /* loaded from: classes25.dex */
    public static final /* data */ class UpdateHaveNextPageUIState extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean haveNextPage;

        public UpdateHaveNextPageUIState(boolean z16) {
            super(null);
            this.haveNextPage = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getHaveNextPage() {
            return this.haveNextPage;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof UpdateHaveNextPageUIState) && this.haveNextPage == ((UpdateHaveNextPageUIState) other).haveNextPage) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            boolean z16 = this.haveNextPage;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        @NotNull
        public String toString() {
            return "UpdateHaveNextPageUIState(haveNextPage=" + this.haveNextPage + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/robot/discoveryv2/common/recommend/page/core/b$b;", "Lcom/tencent/robot/discoveryv2/common/recommend/page/core/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "Ls34/b;", "a", "Ljava/util/List;", "()Ljava/util/List;", "recommendRobotList", "<init>", "(Ljava/util/List;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.discoveryv2.common.recommend.page.core.b$b, reason: collision with other inner class name and from toString */
    /* loaded from: classes25.dex */
    public static final /* data */ class UpdatePageDataUIState extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final List<s34.b> recommendRobotList;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public UpdatePageDataUIState(@NotNull List<? extends s34.b> recommendRobotList) {
            super(null);
            Intrinsics.checkNotNullParameter(recommendRobotList, "recommendRobotList");
            this.recommendRobotList = recommendRobotList;
        }

        @NotNull
        public final List<s34.b> a() {
            return this.recommendRobotList;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof UpdatePageDataUIState) && Intrinsics.areEqual(this.recommendRobotList, ((UpdatePageDataUIState) other).recommendRobotList)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.recommendRobotList.hashCode();
        }

        @NotNull
        public String toString() {
            return "UpdatePageDataUIState(recommendRobotList=" + this.recommendRobotList + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/robot/discoveryv2/common/recommend/page/core/b$c;", "Lcom/tencent/robot/discoveryv2/common/recommend/page/core/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/robot/discoveryv2/common/data/LoadState;", "a", "Lcom/tencent/robot/discoveryv2/common/data/LoadState;", "()Lcom/tencent/robot/discoveryv2/common/data/LoadState;", "loadState", "Lcom/tencent/robot/discoveryv2/common/data/SingleCategoryLoadType;", "b", "Lcom/tencent/robot/discoveryv2/common/data/SingleCategoryLoadType;", "()Lcom/tencent/robot/discoveryv2/common/data/SingleCategoryLoadType;", "loadType", "<init>", "(Lcom/tencent/robot/discoveryv2/common/data/LoadState;Lcom/tencent/robot/discoveryv2/common/data/SingleCategoryLoadType;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.discoveryv2.common.recommend.page.core.b$c, reason: from toString */
    /* loaded from: classes25.dex */
    public static final /* data */ class UpdatePageLoadStateUIState extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final LoadState loadState;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final SingleCategoryLoadType loadType;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UpdatePageLoadStateUIState(@NotNull LoadState loadState, @NotNull SingleCategoryLoadType loadType) {
            super(null);
            Intrinsics.checkNotNullParameter(loadState, "loadState");
            Intrinsics.checkNotNullParameter(loadType, "loadType");
            this.loadState = loadState;
            this.loadType = loadType;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final LoadState getLoadState() {
            return this.loadState;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final SingleCategoryLoadType getLoadType() {
            return this.loadType;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdatePageLoadStateUIState)) {
                return false;
            }
            UpdatePageLoadStateUIState updatePageLoadStateUIState = (UpdatePageLoadStateUIState) other;
            if (this.loadState == updatePageLoadStateUIState.loadState && this.loadType == updatePageLoadStateUIState.loadType) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.loadState.hashCode() * 31) + this.loadType.hashCode();
        }

        @NotNull
        public String toString() {
            return "UpdatePageLoadStateUIState(loadState=" + this.loadState + ", loadType=" + this.loadType + ")";
        }
    }

    public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    b() {
    }
}
