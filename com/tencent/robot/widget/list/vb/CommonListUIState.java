package com.tencent.robot.widget.list.vb;

import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.base.route.h;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/robot/widget/list/vb/CommonListUIState;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "()V", "InitRecyclerViewAdapterUIState", "SubmitListUIState", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public class CommonListUIState implements MviUIState {

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/robot/widget/list/vb/CommonListUIState$InitRecyclerViewAdapterUIState;", "Lcom/tencent/robot/widget/list/vb/CommonListUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mvi/api/runtime/b;", "d", "Lcom/tencent/mvi/api/runtime/b;", "b", "()Lcom/tencent/mvi/api/runtime/b;", "mviContext", "Ljava/util/concurrent/Executor;", "e", "Ljava/util/concurrent/Executor;", "a", "()Ljava/util/concurrent/Executor;", "executor", "<init>", "(Lcom/tencent/mvi/api/runtime/b;Ljava/util/concurrent/Executor;)V", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class InitRecyclerViewAdapterUIState extends CommonListUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final com.tencent.mvi.api.runtime.b mviContext;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final Executor executor;

        public InitRecyclerViewAdapterUIState(@NotNull com.tencent.mvi.api.runtime.b mviContext, @NotNull Executor executor) {
            Intrinsics.checkNotNullParameter(mviContext, "mviContext");
            Intrinsics.checkNotNullParameter(executor, "executor");
            this.mviContext = mviContext;
            this.executor = executor;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final Executor getExecutor() {
            return this.executor;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final com.tencent.mvi.api.runtime.b getMviContext() {
            return this.mviContext;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InitRecyclerViewAdapterUIState)) {
                return false;
            }
            InitRecyclerViewAdapterUIState initRecyclerViewAdapterUIState = (InitRecyclerViewAdapterUIState) other;
            if (Intrinsics.areEqual(this.mviContext, initRecyclerViewAdapterUIState.mviContext) && Intrinsics.areEqual(this.executor, initRecyclerViewAdapterUIState.executor)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.mviContext.hashCode() * 31) + this.executor.hashCode();
        }

        @NotNull
        public String toString() {
            return "InitRecyclerViewAdapterUIState(mviContext=" + this.mviContext + ", executor=" + this.executor + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/robot/widget/list/vb/CommonListUIState$SubmitListUIState;", "Lcom/tencent/robot/widget/list/vb/CommonListUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "Lb74/a;", "d", "Ljava/util/List;", "a", "()Ljava/util/List;", "itemDataList", "Ljava/lang/Runnable;", "e", "Ljava/lang/Runnable;", "b", "()Ljava/lang/Runnable;", "submitCallback", "<init>", "(Ljava/util/List;Ljava/lang/Runnable;)V", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class SubmitListUIState extends CommonListUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final List<b74.a> itemDataList;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Runnable submitCallback;

        /* JADX WARN: Multi-variable type inference failed */
        public SubmitListUIState(@NotNull List<? extends b74.a> itemDataList, @Nullable Runnable runnable) {
            Intrinsics.checkNotNullParameter(itemDataList, "itemDataList");
            this.itemDataList = itemDataList;
            this.submitCallback = runnable;
        }

        @NotNull
        public final List<b74.a> a() {
            return this.itemDataList;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final Runnable getSubmitCallback() {
            return this.submitCallback;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SubmitListUIState)) {
                return false;
            }
            SubmitListUIState submitListUIState = (SubmitListUIState) other;
            if (Intrinsics.areEqual(this.itemDataList, submitListUIState.itemDataList) && Intrinsics.areEqual(this.submitCallback, submitListUIState.submitCallback)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = this.itemDataList.hashCode() * 31;
            Runnable runnable = this.submitCallback;
            if (runnable == null) {
                hashCode = 0;
            } else {
                hashCode = runnable.hashCode();
            }
            return hashCode2 + hashCode;
        }

        @NotNull
        public String toString() {
            return "SubmitListUIState(itemDataList=" + this.itemDataList + ", submitCallback=" + this.submitCallback + ")";
        }
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }
}
