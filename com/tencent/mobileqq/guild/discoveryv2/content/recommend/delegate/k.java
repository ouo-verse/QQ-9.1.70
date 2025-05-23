package com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendFileData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.RecommendBottomSection;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.ah;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.ao;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.as;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J6\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u001c\u0010\n\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0000\u0012\u00020\u00020\t0\b0\u0007H\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R\u001a\u0010\u0014\u001a\u00020\u000f8\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/delegate/k;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/delegate/g;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendFileData;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "itemView", "", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "sections", "", "f", "", "getLayoutId", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "b", "()Ljava/lang/String;", "x2jLayoutName", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class k extends g<RecommendFileData> {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String x2jLayoutName;

    public k() {
        super(RecommendFileData.class);
        this.x2jLayoutName = "guild_discovery_v2_recommend_feed_item_layout";
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.a
    @NotNull
    /* renamed from: b, reason: from getter */
    public String getX2jLayoutName() {
        return this.x2jLayoutName;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate.g
    public void f(@NotNull ViewGroup parent, @NotNull View itemView, @NotNull List<Class<? extends Section<? super RecommendFileData>>> sections) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(sections, "sections");
        sections.add(ao.class);
        sections.add(com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.n.class);
        sections.add(as.class);
        sections.add(RecommendBottomSection.class);
        sections.add(ah.class);
        sections.add(com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.s.class);
        sections.add(com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.o.class);
        sections.add(com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.g.class);
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public int getLayoutId() {
        return R.layout.elm;
    }
}
