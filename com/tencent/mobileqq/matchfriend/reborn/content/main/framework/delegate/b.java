package com.tencent.mobileqq.matchfriend.reborn.content.main.framework.delegate;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.section.QQStrangerImageSection;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.section.QQStrangerLiteActionSection;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.section.QQStrangerUserInfoSection;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.section.g;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.section.k;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.section.p;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.trpcprotocol.qqstranger.common.feed.FeedPB$Feed;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J&\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\n\u001a\u00020\u0006H\u0016J4\u0010\u0013\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u001a\u0010\u0011\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00020\u00100\u000f0\u0004H\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/delegate/b;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/delegate/a;", "Lcom/tencent/trpcprotocol/qqstranger/common/feed/FeedPB$Feed;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "b", "getLayoutId", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "itemView", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "sections", "", "initSection", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class b extends a<FeedPB$Feed, FeedPB$Feed> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean isForViewType(FeedPB$Feed item, List<FeedPB$Feed> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return true;
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public int getLayoutId() {
        return R.layout.f167364cx2;
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public void initSection(ViewGroup parent, View itemView, List<Class<? extends Section<FeedPB$Feed>>> sections) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(sections, "sections");
        sections.add(QQStrangerUserInfoSection.class);
        sections.add(QQStrangerLiteActionSection.class);
        sections.add(k.class);
        sections.add(QQStrangerImageSection.class);
        sections.add(p.class);
        sections.add(com.tencent.mobileqq.matchfriend.reborn.content.main.framework.section.b.class);
        sections.add(g.class);
    }
}
