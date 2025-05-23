package com.tencent.robot.discoveryv2.common.recommend.content;

import com.tencent.qqnt.kernel.nativeinterface.ListNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/robot/discoveryv2/common/recommend/content/c;", "", "<init>", "()V", "a", "Lcom/tencent/robot/discoveryv2/common/recommend/content/c$a;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class c {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/robot/discoveryv2/common/recommend/content/c$a;", "Lcom/tencent/robot/discoveryv2/common/recommend/content/c;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "Lcom/tencent/qqnt/kernel/nativeinterface/ListNode;", "a", "Ljava/util/List;", "()Ljava/util/List;", "categoryTabList", "<init>", "(Ljava/util/List;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.discoveryv2.common.recommend.content.c$a, reason: from toString */
    /* loaded from: classes25.dex */
    public static final /* data */ class UpdateCategoryTabUIState extends c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final List<ListNode> categoryTabList;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UpdateCategoryTabUIState(@NotNull List<ListNode> categoryTabList) {
            super(null);
            Intrinsics.checkNotNullParameter(categoryTabList, "categoryTabList");
            this.categoryTabList = categoryTabList;
        }

        @NotNull
        public final List<ListNode> a() {
            return this.categoryTabList;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof UpdateCategoryTabUIState) && Intrinsics.areEqual(this.categoryTabList, ((UpdateCategoryTabUIState) other).categoryTabList)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.categoryTabList.hashCode();
        }

        @NotNull
        public String toString() {
            return "UpdateCategoryTabUIState(categoryTabList=" + this.categoryTabList + ")";
        }
    }

    public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    c() {
    }
}
