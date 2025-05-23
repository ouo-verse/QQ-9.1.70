package com.tencent.mobileqq.guild.feed.presenter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedDescComponents;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDefaultInitBean;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.FeedRichTextContentParser;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
@Metadata(d1 = {"\u0000=\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0010\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u001dB\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\u000b\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\tH\u0017J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0004H\u0016R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/presenter/m;", "Lcom/tencent/mobileqq/guild/feed/presenter/GuildBaseFeedChildPresenter;", "Lij1/g;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "o", "data", "", "position", "t", "view", NodeProps.ON_CLICK, "requestView", "onPreloadResult", "com/tencent/mobileqq/guild/feed/presenter/m$b", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/feed/presenter/m$b;", "depends", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedDescComponents;", "G", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedDescComponents;", "components", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedDefaultInitBean;", "defaultInitBean", "<init>", "(Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedDefaultInitBean;)V", "H", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class m extends GuildBaseFeedChildPresenter<ij1.g> implements View.OnClickListener {

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final b depends;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final GuildFeedSquareFeedDescComponents components;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005H\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/feed/presenter/m$b", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedDescComponents$c;", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "c", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "stFeed", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "e", "", "g", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements GuildFeedSquareFeedDescComponents.c {
        b() {
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
            hashMap.putAll(m.this.e());
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
            GuildFeedDefaultInitBean guildFeedDefaultInitBean = m.this.D;
            String str = stFeed.channelInfo.sign.joinGuildSig;
            Intrinsics.checkNotNullExpressionValue(str, "stFeed.channelInfo.sign.joinGuildSig");
            return feedRichTextContentParser.d(guildFeedDefaultInitBean, str);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedDescComponents.c
        public float f() {
            return GuildFeedSquareFeedDescComponents.c.a.d(this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedDescComponents.c
        @NotNull
        public Collection<String> g() {
            List<String> o16 = ((ij1.g) m.this.f222800d).o();
            Intrinsics.checkNotNullExpressionValue(o16, "mData.highLightWord");
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(@NotNull GuildFeedDefaultInitBean defaultInitBean) {
        super(defaultInitBean);
        Intrinsics.checkNotNullParameter(defaultInitBean, "defaultInitBean");
        b bVar = new b();
        this.depends = bVar;
        this.components = new GuildFeedSquareFeedDescComponents(bVar);
    }

    @Override // com.tencent.mobileqq.guild.feed.presenter.GuildBaseFeedChildPresenter
    public void o(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.o(rootView);
        RFWLayoutPreLoader d16 = gj1.a.a().d();
        View findViewById = rootView.findViewById(R.id.x0u);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.view.ViewStub");
        d16.requestPreloadViewForViewStub((ViewStub) findViewById, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null) {
            i(((ij1.g) this.f222800d).b(), 0, 1);
            p(new com.tencent.mobileqq.guild.feed.event.a(1));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.guild.feed.presenter.GuildBaseFeedChildPresenter, com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader.RequestPreloadViewListener
    public void onPreloadResult(@NotNull View requestView) {
        Intrinsics.checkNotNullParameter(requestView, "requestView");
        super.onPreloadResult(requestView);
        this.components.o(requestView);
    }

    @Override // com.tencent.mobileqq.guild.feed.presenter.GuildBaseFeedChildPresenter
    @SuppressLint({"UseCompatLoadingForColorStateLists"})
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void k(@Nullable ij1.g data, int position) {
        GProStFeed gProStFeed;
        super.k(data, position);
        if (data != null) {
            gProStFeed = data.b();
        } else {
            gProStFeed = null;
        }
        if (gProStFeed == null) {
            return;
        }
        this.components.n(data, position, null);
        if (h()) {
            c(this.f222805m, "em_sgrp_forum_feed");
        }
    }
}
