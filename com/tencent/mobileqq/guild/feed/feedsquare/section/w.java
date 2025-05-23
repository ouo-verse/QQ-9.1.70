package com.tencent.mobileqq.guild.feed.feedsquare.section;

import android.content.Context;
import android.view.View;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedDescComponents;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDetailInitBean;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.FeedRichTextContentParser;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextContent;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0015\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J*\u0010\u000f\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/section/w;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedBaseSection;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/h;", "data", "", "position", "", "", "payload", "M", "", "v", "", NodeProps.VISIBLE, "onVisibleChanged", "com/tencent/mobileqq/guild/feed/feedsquare/section/w$a", "e", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/w$a;", "depends", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedDescComponents;", "f", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedDescComponents;", "components", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class w extends GuildFeedSquareFeedBaseSection {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a depends;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildFeedSquareFeedDescComponents components;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005H\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/feed/feedsquare/section/w$a", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedDescComponents$c;", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "c", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "stFeed", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "e", "", "g", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
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
            HashMap<String, Object> hashMap = new HashMap<>();
            w wVar = w.this;
            hashMap.putAll(wVar.C());
            hashMap.put(JumpGuildParam.EXTRA_KEY_TRACE_ID, ((com.tencent.mobileqq.guild.feed.feedsquare.data.h) ((Section) wVar).mData).getBlockData().c());
            return hashMap;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedDescComponents.c
        @Nullable
        public IParseRichTextConfig<Object> d(@NotNull Context context) {
            return GuildFeedSquareFeedDescComponents.c.a.c(this, context);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedDescComponents.c
        @Nullable
        public JumpGuildParam.JoinInfoParam e(@NotNull GProStFeed stFeed) {
            Intrinsics.checkNotNullParameter(stFeed, "stFeed");
            FeedRichTextContentParser feedRichTextContentParser = FeedRichTextContentParser.f221393a;
            GuildFeedDetailInitBean F = w.this.F(stFeed);
            String str = stFeed.channelInfo.sign.joinGuildSig;
            Intrinsics.checkNotNullExpressionValue(str, "stFeed.channelInfo.sign.joinGuildSig");
            return feedRichTextContentParser.d(F, str);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedDescComponents.c
        public float f() {
            return GuildFeedSquareFeedDescComponents.c.a.d(this);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedDescComponents.c
        @NotNull
        public Collection<String> g() {
            List<String> o16 = ((com.tencent.mobileqq.guild.feed.feedsquare.data.h) ((Section) w.this).mData).getBlockData().o();
            Intrinsics.checkNotNullExpressionValue(o16, "mData.blockData.highLightWord");
            return o16;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedDescComponents.c
        public float getTextSize() {
            return GuildFeedSquareFeedDescComponents.c.a.e(this);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedDescComponents.c
        @Nullable
        public String getTraceID() {
            return GuildFeedSquareFeedDescComponents.c.a.f(this);
        }
    }

    public w() {
        a aVar = new a();
        this.depends = aVar;
        this.components = new GuildFeedSquareFeedDescComponents(aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedBaseSection
    public void M(@Nullable com.tencent.mobileqq.guild.feed.feedsquare.data.h data, int position, @Nullable List<Object> payload) {
        if (data == 0) {
            return;
        }
        this.mData = data;
        this.components.n(data.getBlockData(), position, payload);
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

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.n
    @NotNull
    public String v() {
        return "GuildFeedSquareFeedDescSection";
    }
}
