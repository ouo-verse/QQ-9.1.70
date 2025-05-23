package com.tencent.robot.profile.adapterdelegates;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.robot.profile.data.RobotProfileStoryInfoData;
import com.tencent.robot.profile.section.story.RobotStoryListSection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J&\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\n\u001a\u00020\u0006H\u0016J4\u0010\u0013\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u001a\u0010\u0011\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00020\u00100\u000f0\u0004H\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/robot/profile/adapterdelegates/k;", "Lcom/tencent/robot/profile/adapterdelegates/g;", "Lcom/tencent/robot/profile/data/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "b", "getLayoutId", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "itemView", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "sections", "", "initSection", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class k extends g {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean isForViewType(@NotNull com.tencent.robot.profile.data.g item, @NotNull List<com.tencent.robot.profile.data.g> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof RobotProfileStoryInfoData;
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public int getLayoutId() {
        return R.layout.hoo;
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public void initSection(@NotNull ViewGroup parent, @NotNull View itemView, @NotNull List<Class<? extends Section<com.tencent.robot.profile.data.g>>> sections) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(sections, "sections");
        sections.add(com.tencent.robot.profile.section.story.c.class);
        sections.add(RobotStoryListSection.class);
    }
}
