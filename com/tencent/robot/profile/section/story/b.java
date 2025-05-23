package com.tencent.robot.profile.section.story;

import androidx.recyclerview.widget.DiffUtil;
import com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter;
import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegatesManager;
import com.tencent.robot.profile.data.RobotProfileStoryInfoData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00040\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/robot/profile/section/story/b;", "Lcom/tencent/biz/richframework/part/adapter/AsyncListDifferDelegationAdapter;", "Lcom/tencent/robot/profile/data/n$b;", "Lcom/tencent/biz/richframework/part/adapter/delegate/AdapterDelegatesManager;", "", "delegatesManager", "<init>", "(Lcom/tencent/biz/richframework/part/adapter/delegate/AdapterDelegatesManager;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b extends AsyncListDifferDelegationAdapter<RobotProfileStoryInfoData.RobotProfileStoryItemCardData> {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/robot/profile/section/story/b$a", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tencent/robot/profile/data/n$b;", "oldItem", "newItem", "", "b", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a extends DiffUtil.ItemCallback<RobotProfileStoryInfoData.RobotProfileStoryItemCardData> {
        a() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NotNull RobotProfileStoryInfoData.RobotProfileStoryItemCardData oldItem, @NotNull RobotProfileStoryInfoData.RobotProfileStoryItemCardData newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.a(newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NotNull RobotProfileStoryInfoData.RobotProfileStoryItemCardData oldItem, @NotNull RobotProfileStoryInfoData.RobotProfileStoryItemCardData newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.b(newItem);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull AdapterDelegatesManager<List<RobotProfileStoryInfoData.RobotProfileStoryItemCardData>> delegatesManager) {
        super(new a(), delegatesManager);
        Intrinsics.checkNotNullParameter(delegatesManager, "delegatesManager");
    }
}
