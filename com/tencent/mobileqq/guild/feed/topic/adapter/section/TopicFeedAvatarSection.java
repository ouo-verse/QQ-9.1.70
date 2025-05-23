package com.tencent.mobileqq.guild.feed.topic.adapter.section;

import android.content.Context;
import android.view.View;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedAvatarComponents;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J*\u0010\u000f\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0014R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/adapter/section/TopicFeedAvatarSection;", "Lcom/tencent/mobileqq/guild/feed/topic/adapter/section/b;", "Lvn1/b;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "data", "", "position", "", "", "payload", "r", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedAvatarComponents;", "d", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedAvatarComponents;", "components", "<init>", "()V", "e", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class TopicFeedAvatarSection extends b<vn1.b> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildFeedAvatarComponents components = new GuildFeedAvatarComponents(new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.feed.topic.adapter.section.TopicFeedAvatarSection$components$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull View it) {
            View view;
            Object obj;
            Intrinsics.checkNotNullParameter(it, "it");
            xn1.e eVar = xn1.e.f448187a;
            view = ((Section) TopicFeedAvatarSection.this).mRootView;
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "mRootView.context");
            obj = ((Section) TopicFeedAvatarSection.this).mData;
            eVar.n(context, ((vn1.b) obj).d());
        }
    });

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return this.components.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        if (containerView != null) {
            this.components.e(containerView);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable vn1.b data, int position, @Nullable List<Object> payload) {
        qj1.h d16;
        String u16;
        if (data != null && (d16 = data.d()) != null && (u16 = d16.u()) != null) {
            this.components.d(u16, data.d().t(), position);
        }
    }
}
