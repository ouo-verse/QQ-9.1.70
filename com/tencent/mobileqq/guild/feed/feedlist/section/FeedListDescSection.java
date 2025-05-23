package com.tencent.mobileqq.guild.feed.feedlist.section;

import android.content.Context;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.guild.api.FeedListSectionType;
import com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedDescComponents;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextContent;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rj1.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007\u00a2\u0006\u0004\b!\u0010\"J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J0\u0010\u000f\u001a\u00020\u00062\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0014J\b\u0010\u0011\u001a\u00020\u0010H\u0014J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R\u001a\u0010\u001a\u001a\u00020\u00158\u0014X\u0094\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010 \u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedlist/section/FeedListDescSection;", "Lrj1/b;", "Ext", "Ltk1/a;", "Landroid/view/View;", "initContainerView", "", "onInitView", "Ltk1/c;", "bindData", "", "position", "", "", "payload", "u", "", "getViewStubLayoutId", "", NodeProps.VISIBLE, "onVisibleChanged", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedDescComponents$c;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedDescComponents$c;", "B", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedDescComponents$c;", "depends", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedDescComponents;", "D", "Lkotlin/Lazy;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedDescComponents;", "components", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class FeedListDescSection<Ext extends rj1.b> extends tk1.a<Ext> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final GuildFeedSquareFeedDescComponents.c depends;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy components;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/feed/feedlist/section/FeedListDescSection$a", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedDescComponents$c;", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "c", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "stFeed", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "e", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements GuildFeedSquareFeedDescComponents.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedListDescSection<Ext> f218585a;

        a(FeedListDescSection<Ext> feedListDescSection) {
            this.f218585a = feedListDescSection;
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
            return rj1.a.f431544a.d(((tk1.c) ((Section) this.f218585a).mData).getData(), (rj1.b) ((tk1.c) ((Section) this.f218585a).mData).a());
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
        @Nullable
        public String getTraceID() {
            return GuildFeedSquareFeedDescComponents.c.a.f(this);
        }
    }

    public FeedListDescSection() {
        super(FeedListSectionType.Desc);
        Lazy lazy;
        this.depends = new a(this);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<GuildFeedSquareFeedDescComponents>(this) { // from class: com.tencent.mobileqq.guild.feed.feedlist.section.FeedListDescSection$components$2
            final /* synthetic */ FeedListDescSection<Ext> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildFeedSquareFeedDescComponents invoke() {
                return new GuildFeedSquareFeedDescComponents(this.this$0.getDepends());
            }
        });
        this.components = lazy;
    }

    private final GuildFeedSquareFeedDescComponents A() {
        return (GuildFeedSquareFeedDescComponents) this.components.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: B, reason: from getter */
    public GuildFeedSquareFeedDescComponents.c getDepends() {
        return this.depends;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return A().m();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tk1.a, com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View initContainerView) {
        super.onInitView(initContainerView);
        GuildFeedSquareFeedDescComponents A = A();
        View rootView = getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        A.o(rootView);
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onVisibleChanged(boolean visible) {
        super.onVisibleChanged(visible);
        A().p(visible);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tk1.a, com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: u */
    public void onBindData(@Nullable tk1.c<Ext> bindData, int position, @Nullable List<Object> payload) {
        Object obj;
        qj1.h data;
        super.onBindData(bindData, position, payload);
        if (bindData != null && (data = bindData.getData()) != null) {
            obj = data.a();
        } else {
            obj = null;
        }
        if (!(obj instanceof GProStFeed)) {
            return;
        }
        GuildFeedSquareFeedDescComponents A = A();
        Object a16 = bindData.getData().a();
        Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed");
        A.n(new ij1.g((GProStFeed) a16, ""), position, payload);
    }
}
