package com.tencent.mobileqq.guild.feed.feedsquare.section;

import android.content.Context;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.adapter.section.SectionIOCKt;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextContent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J*\u0010\r\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0014J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/section/ae;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedBaseSection;", "Landroid/view/View;", "containerView", "", "onInitView", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/h;", "data", "", "position", "", "", "payload", "M", "", "getViewStubLayoutId", "", NodeProps.VISIBLE, "onVisibleChanged", "attached", "onAttachedChanged", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "com/tencent/mobileqq/guild/feed/feedsquare/section/ae$a", "e", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/ae$a;", "depends", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildLongFeedContentComponents;", "f", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildLongFeedContentComponents;", "components", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class ae extends GuildFeedSquareFeedBaseSection {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a depends;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildLongFeedContentComponents components;

    /* compiled from: P */
    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\tH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/mobileqq/guild/feed/feedsquare/section/ae$a", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildLongFeedContentComponents$c;", "Landroid/view/View;", "getRootView", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "getInitBean", "", "a", "", "", "k", "view", "elementId", "", "c", "Lxj1/f;", "j", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements GuildLongFeedContentComponents.c {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.c
        public int a() {
            return ae.this.s();
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.c
        @Nullable
        public IParseRichTextConfig<GProStRichTextContent> b(@NotNull Context context) {
            return GuildLongFeedContentComponents.c.a.b(this, context);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.c
        public void c(@Nullable View view, @NotNull String elementId) {
            Intrinsics.checkNotNullParameter(elementId, "elementId");
            ae.this.A(view, elementId);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.c
        public float d() {
            return GuildLongFeedContentComponents.c.a.a(this);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.c
        @Nullable
        public IParseRichTextConfig<GProStRichTextContent> e(@NotNull Context context) {
            return GuildLongFeedContentComponents.c.a.f(this, context);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.c
        public float f() {
            return GuildLongFeedContentComponents.c.a.g(this);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.c
        public float g() {
            return GuildLongFeedContentComponents.c.a.e(this);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.c
        @NotNull
        public GuildFeedBaseInitBean getInitBean() {
            ae aeVar = ae.this;
            GProStFeed b16 = ((com.tencent.mobileqq.guild.feed.feedsquare.data.h) ((Section) aeVar).mData).getBlockData().b();
            Intrinsics.checkNotNullExpressionValue(b16, "mData.blockData.sourceData");
            return aeVar.F(b16);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.c
        @NotNull
        public View getRootView() {
            View mRootView = ((Section) ae.this).mRootView;
            Intrinsics.checkNotNullExpressionValue(mRootView, "mRootView");
            return mRootView;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.c
        public int h() {
            return GuildLongFeedContentComponents.c.a.d(this);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.c
        public float i() {
            return GuildLongFeedContentComponents.c.a.c(this);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.c
        @Nullable
        public xj1.f j() {
            return (xj1.f) SectionIOCKt.getIocInterface(ae.this, xj1.f.class);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.c
        @NotNull
        public List<String> k() {
            List<String> o16 = ((com.tencent.mobileqq.guild.feed.feedsquare.data.h) ((Section) ae.this).mData).getBlockData().o();
            Intrinsics.checkNotNullExpressionValue(o16, "mData.blockData.highLightWord");
            return o16;
        }
    }

    public ae() {
        a aVar = new a();
        this.depends = aVar;
        this.components = new GuildLongFeedContentComponents(aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedBaseSection
    public void M(@Nullable com.tencent.mobileqq.guild.feed.feedsquare.data.h data, int position, @Nullable List<Object> payload) {
        if (data == 0) {
            return;
        }
        this.mData = data;
        this.components.C(data.getBlockData(), position, payload);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return this.components.z();
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onAttachedChanged(boolean attached) {
        this.components.B(attached);
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        this.components.D();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.components.F(containerView);
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onVisibleChanged(boolean visible) {
        this.components.G(visible);
    }
}
