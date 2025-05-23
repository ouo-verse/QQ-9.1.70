package com.tencent.mobileqq.guild.feed.feedlist.section;

import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.guild.api.FeedListSectionType;
import com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSingleImageComponents;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.common.EventAgingType;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
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
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J0\u0010\u0011\u001a\u00020\b2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0014R\u001a\u0010\u0017\u001a\u00020\u00128\u0014X\u0094\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001b\u001a\u00020\u00188FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0019\u001a\u0004\b\u0013\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedlist/section/FeedListSingleImageSection;", "Lrj1/b;", "Ext", "Ltk1/a;", "", "getViewStubLayoutId", "Landroid/view/View;", "initContainerView", "", "onInitView", "Ltk1/c;", "bindData", "", "position", "", "", "payload", "u", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSingleImageComponents$b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSingleImageComponents$b;", "D", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSingleImageComponents$b;", "depends", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSingleImageComponents;", "Lkotlin/Lazy;", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSingleImageComponents;", "components", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class FeedListSingleImageSection<Ext extends rj1.b> extends tk1.a<Ext> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final GuildFeedSingleImageComponents.b depends;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy components;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/feed/feedlist/section/FeedListSingleImageSection$a", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSingleImageComponents$b;", "Landroid/widget/ImageView;", "image", "", "c", "Landroid/view/View;", "imageView", "b", "", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements GuildFeedSingleImageComponents.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedListSingleImageSection<Ext> f218589a;

        a(FeedListSingleImageSection<Ext> feedListSingleImageSection) {
            this.f218589a = feedListSingleImageSection;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSingleImageComponents.b
        @Nullable
        public Object a() {
            return null;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSingleImageComponents.b
        public void b(@NotNull View imageView) {
            Intrinsics.checkNotNullParameter(imageView, "imageView");
            VideoReport.setEventType(imageView, EventAgingType.REALTIME);
            if1.a.b(imageView, "em_sgrp_forum_full_screen", ((Section) this.f218589a).mData.hashCode() + "#" + imageView.hashCode(), null, ExposurePolicy.REPORT_NONE, null, null, null, null, 244, null);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSingleImageComponents.b
        public void c(@NotNull ImageView image) {
            Intrinsics.checkNotNullParameter(image, "image");
            rj1.a.f431544a.i(image, this.f218589a.r(), FeedListSingleImageSection.A(this.f218589a), 0);
        }
    }

    public FeedListSingleImageSection() {
        super(FeedListSectionType.SingleImage);
        Lazy lazy;
        this.depends = new a(this);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<GuildFeedSingleImageComponents>(this) { // from class: com.tencent.mobileqq.guild.feed.feedlist.section.FeedListSingleImageSection$components$2
            final /* synthetic */ FeedListSingleImageSection<Ext> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildFeedSingleImageComponents invoke() {
                return new GuildFeedSingleImageComponents(this.this$0.getDepends());
            }
        });
        this.components = lazy;
    }

    public static final /* synthetic */ rj1.b A(FeedListSingleImageSection feedListSingleImageSection) {
        return (rj1.b) feedListSingleImageSection.s();
    }

    @NotNull
    public final GuildFeedSingleImageComponents C() {
        return (GuildFeedSingleImageComponents) this.components.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: D, reason: from getter */
    public GuildFeedSingleImageComponents.b getDepends() {
        return this.depends;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return C().f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tk1.a, com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View initContainerView) {
        super.onInitView(initContainerView);
        GuildFeedSingleImageComponents C = C();
        View rootView = getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        C.h(rootView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tk1.a, com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: u */
    public void onBindData(@Nullable tk1.c<Ext> bindData, int position, @Nullable List<Object> payload) {
        super.onBindData(bindData, position, payload);
        C().g(r(), position, payload);
    }
}
