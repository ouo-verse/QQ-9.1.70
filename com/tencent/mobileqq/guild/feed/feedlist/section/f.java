package com.tencent.mobileqq.guild.feed.feedlist.section;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.guild.api.FeedListSectionType;
import com.tencent.mobileqq.guild.feed.topic.adapter.section.GuildFeedHeadBindParams;
import com.tencent.mobileqq.guild.feed.topic.adapter.section.GuildFeedSingleHeadComponents;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rj1.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J0\u0010\u0011\u001a\u00020\b2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0014R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedlist/section/f;", "Lrj1/b;", "Ext", "Ltk1/a;", "", "getViewStubLayoutId", "Landroid/view/View;", "initContainerView", "", "onInitView", "Ltk1/c;", "bindData", "", "position", "", "", "payload", "u", "Lcom/tencent/mobileqq/guild/feed/topic/adapter/section/GuildFeedSingleHeadComponents;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/feed/topic/adapter/section/GuildFeedSingleHeadComponents;", "components", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class f<Ext extends rj1.b> extends tk1.a<Ext> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final GuildFeedSingleHeadComponents components;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/feed/feedlist/section/f$a", "Lcom/tencent/mobileqq/guild/feed/topic/adapter/section/GuildFeedSingleHeadComponents$b;", "", "b", "Landroid/view/View;", "v", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements GuildFeedSingleHeadComponents.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ f<Ext> f218595a;

        a(f<Ext> fVar) {
            this.f218595a = fVar;
        }

        @Override // com.tencent.mobileqq.guild.feed.topic.adapter.section.GuildFeedSingleHeadComponents.b
        public void a(@NotNull View v3) {
            Intrinsics.checkNotNullParameter(v3, "v");
            rj1.a aVar = rj1.a.f431544a;
            Context context = this.f218595a.getRootView().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
            aVar.j(context, this.f218595a.r(), f.A(this.f218595a));
        }

        @Override // com.tencent.mobileqq.guild.feed.topic.adapter.section.GuildFeedSingleHeadComponents.b
        public void b() {
            rj1.a aVar = rj1.a.f431544a;
            Context context = this.f218595a.getRootView().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
            aVar.h(context, this.f218595a.r(), f.A(this.f218595a));
        }
    }

    public f() {
        super(FeedListSectionType.Header);
        this.components = new GuildFeedSingleHeadComponents(new a(this));
    }

    public static final /* synthetic */ rj1.b A(f fVar) {
        return (rj1.b) fVar.s();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return this.components.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tk1.a, com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View initContainerView) {
        super.onInitView(initContainerView);
        GuildFeedSingleHeadComponents guildFeedSingleHeadComponents = this.components;
        View rootView = getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        guildFeedSingleHeadComponents.g(rootView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tk1.a, com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: u */
    public void onBindData(@Nullable tk1.c<Ext> bindData, int position, @Nullable List<Object> payload) {
        super.onBindData(bindData, position, payload);
        GuildFeedSingleHeadComponents guildFeedSingleHeadComponents = this.components;
        String L = r().L();
        if (L == null) {
            L = "";
        }
        guildFeedSingleHeadComponents.f(new GuildFeedHeadBindParams(L, null, 0, null, 0, null, 62, null), position, payload);
    }
}
