package com.tencent.mobileqq.guild.feed.feedlist.section;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.guild.api.FeedListSectionType;
import com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedAvatarComponents;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rj1.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 \u0018*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J0\u0010\u0011\u001a\u00020\b2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0014R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedlist/section/FeedListAvatarSection;", "Lrj1/b;", "Ext", "Ltk1/a;", "", "getViewStubLayoutId", "Landroid/view/View;", "initContainerView", "", "onInitView", "Ltk1/c;", "bindData", "", "position", "", "", "payload", "u", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedAvatarComponents;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedAvatarComponents;", "components", "<init>", "()V", "D", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class FeedListAvatarSection<Ext extends rj1.b> extends tk1.a<Ext> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final GuildFeedAvatarComponents components;

    public FeedListAvatarSection() {
        super(FeedListSectionType.Avatar);
        this.components = new GuildFeedAvatarComponents(new Function1<View, Unit>(this) { // from class: com.tencent.mobileqq.guild.feed.feedlist.section.FeedListAvatarSection$components$1
            final /* synthetic */ FeedListAvatarSection<Ext> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                qj1.h r16;
                Intrinsics.checkNotNullParameter(it, "it");
                rj1.a aVar = rj1.a.f431544a;
                Context context = this.this$0.getRootView().getContext();
                Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
                r16 = this.this$0.r();
                aVar.j(context, r16, FeedListAvatarSection.A(this.this$0));
            }
        });
    }

    public static final /* synthetic */ rj1.b A(FeedListAvatarSection feedListAvatarSection) {
        return (rj1.b) feedListAvatarSection.s();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return this.components.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tk1.a, com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View initContainerView) {
        super.onInitView(initContainerView);
        if (initContainerView != null) {
            this.components.e(initContainerView);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tk1.a, com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: u */
    public void onBindData(@Nullable tk1.c<Ext> bindData, int position, @Nullable List<Object> payload) {
        super.onBindData(bindData, position, payload);
        String u16 = r().u();
        if (u16 != null) {
            this.components.d(u16, r().t(), position);
        }
    }
}
