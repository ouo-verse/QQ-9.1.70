package com.tencent.mobileqq.guild.feed.topic.adapter.section;

import android.content.Context;
import android.view.View;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.guild.feed.topic.adapter.section.GuildFeedSingleHeadComponents;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J(\u0010\u000f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0014R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/adapter/section/l;", "Lcom/tencent/mobileqq/guild/feed/topic/adapter/section/b;", "Lvn1/b;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "data", "", "position", "", "", "payload", "r", "Lcom/tencent/mobileqq/guild/feed/topic/adapter/section/GuildFeedSingleHeadComponents;", "d", "Lcom/tencent/mobileqq/guild/feed/topic/adapter/section/GuildFeedSingleHeadComponents;", "components", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class l extends b<vn1.b> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildFeedSingleHeadComponents components = new GuildFeedSingleHeadComponents(new a());

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/feed/topic/adapter/section/l$a", "Lcom/tencent/mobileqq/guild/feed/topic/adapter/section/GuildFeedSingleHeadComponents$b;", "", "b", "Landroid/view/View;", "v", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements GuildFeedSingleHeadComponents.b {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.feed.topic.adapter.section.GuildFeedSingleHeadComponents.b
        public void a(@NotNull View v3) {
            Intrinsics.checkNotNullParameter(v3, "v");
            xn1.e eVar = xn1.e.f448187a;
            Context context = ((Section) l.this).mRootView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "mRootView.context");
            eVar.n(context, ((vn1.b) ((Section) l.this).mData).d());
        }

        @Override // com.tencent.mobileqq.guild.feed.topic.adapter.section.GuildFeedSingleHeadComponents.b
        public void b() {
            xn1.e eVar = xn1.e.f448187a;
            Context context = ((Section) l.this).mRootView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "mRootView.context");
            Object mData = ((Section) l.this).mData;
            Intrinsics.checkNotNullExpressionValue(mData, "mData");
            eVar.k(context, (vn1.b) mData);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return this.components.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.components.g(containerView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void onBindData(@NotNull vn1.b data, int position, @Nullable List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        GuildFeedSingleHeadComponents guildFeedSingleHeadComponents = this.components;
        String L = data.d().L();
        if (L == null) {
            L = "";
        }
        guildFeedSingleHeadComponents.f(new GuildFeedHeadBindParams(L, null, 0, null, 0, null, 62, null), position, payload);
    }
}
