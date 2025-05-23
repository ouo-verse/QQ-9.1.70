package com.tencent.mobileqq.guild.feed.topic.adapter.section;

import android.content.Context;
import android.view.View;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedDescComponents;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextContent;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0013\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J(\u0010\u000f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0014J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/adapter/section/j;", "Lcom/tencent/mobileqq/guild/feed/topic/adapter/section/b;", "Lvn1/b;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "data", "", "position", "", "", "payload", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", NodeProps.VISIBLE, "onVisibleChanged", "com/tencent/mobileqq/guild/feed/topic/adapter/section/j$a", "d", "Lcom/tencent/mobileqq/guild/feed/topic/adapter/section/j$a;", "depends", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedDescComponents;", "e", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedDescComponents;", "components", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class j extends b<vn1.b> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a depends;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildFeedSquareFeedDescComponents components;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/feed/topic/adapter/section/j$a", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedDescComponents$c;", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "c", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "stFeed", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "e", "getTraceID", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements GuildFeedSquareFeedDescComponents.c {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedDescComponents.c
        @Nullable
        public IParseRichTextConfig<GProStRichTextContent> b(@NotNull Context context) {
            return GuildFeedSquareFeedDescComponents.c.a.a(this, context);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedDescComponents.c
        @NotNull
        public HashMap<String, Object> c() {
            return new HashMap<>();
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedDescComponents.c
        @Nullable
        public IParseRichTextConfig<Object> d(@NotNull Context context) {
            return GuildFeedSquareFeedDescComponents.c.a.c(this, context);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedDescComponents.c
        @NotNull
        public JumpGuildParam.JoinInfoParam e(@NotNull GProStFeed stFeed) {
            Intrinsics.checkNotNullParameter(stFeed, "stFeed");
            xn1.e eVar = xn1.e.f448187a;
            Object mData = ((Section) j.this).mData;
            Intrinsics.checkNotNullExpressionValue(mData, "mData");
            return eVar.g((vn1.b) mData);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedDescComponents.c
        public float f() {
            return GuildFeedSquareFeedDescComponents.c.a.d(this);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedDescComponents.c
        @NotNull
        public Collection<String> g() {
            return GuildFeedSquareFeedDescComponents.c.a.b(this);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedDescComponents.c
        public float getTextSize() {
            return GuildFeedSquareFeedDescComponents.c.a.e(this);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedDescComponents.c
        @NotNull
        public String getTraceID() {
            return ((vn1.b) ((Section) j.this).mData).getExt().getTraceId();
        }
    }

    public j() {
        a aVar = new a();
        this.depends = aVar;
        this.components = new GuildFeedSquareFeedDescComponents(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return this.components.m();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.components.o(containerView);
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onVisibleChanged(boolean visible) {
        this.components.p(visible);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void onBindData(@NotNull vn1.b data, int position, @Nullable List<Object> payload) {
        List emptyList;
        Intrinsics.checkNotNullParameter(data, "data");
        GuildFeedSquareFeedDescComponents guildFeedSquareFeedDescComponents = this.components;
        Object a16 = data.d().a();
        Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed");
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        guildFeedSquareFeedDescComponents.n(new ij1.g((GProStFeed) a16, "", emptyList), position, payload);
    }
}
