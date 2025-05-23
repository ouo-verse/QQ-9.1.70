package com.tencent.mobileqq.guild.feed.feedsquare.section;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.GProStFeedDetailRspWrapper;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildTaskProgressState;
import com.tencent.mobileqq.guild.feed.widget.GuildLinkView;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J*\u0010\r\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0014R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/section/aq;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedBaseSection;", "Landroid/view/View;", "containerView", "", "onInitView", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/h;", "data", "", "position", "", "", "payload", "M", "", "getViewStubLayoutId", "Lcom/tencent/mobileqq/guild/feed/widget/GuildLinkView;", "e", "Lcom/tencent/mobileqq/guild/feed/widget/GuildLinkView;", "linkView", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class aq extends GuildFeedSquareFeedBaseSection {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private GuildLinkView linkView;

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedBaseSection
    public void M(@Nullable com.tencent.mobileqq.guild.feed.feedsquare.data.h data, int position, @Nullable List<Object> payload) {
        Object firstOrNull;
        GuildLinkView guildLinkView;
        String str;
        if (data == null) {
            return;
        }
        GProStFeed b16 = data.getBlockData().b();
        Intrinsics.checkNotNullExpressionValue(b16, "data.blockData.sourceData");
        String str2 = null;
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) new GProStFeedDetailRspWrapper(b16, null, 2, null).b());
        qj1.q qVar = (qj1.q) firstOrNull;
        if (qVar == null) {
            return;
        }
        GuildLinkView guildLinkView2 = this.linkView;
        if (guildLinkView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("linkView");
            guildLinkView = null;
        } else {
            guildLinkView = guildLinkView2;
        }
        String title = qVar.getTitle();
        String str3 = qVar.getAbstract();
        String thumbUrl = qVar.getThumbUrl();
        String redirectUrl = qVar.getRedirectUrl();
        Map<String, Object> C = C();
        GuildTaskProgressState p16 = data.getBlockData().p();
        if (p16 != null && (str = p16.mTaskId) != null) {
            str2 = str + "_image";
        }
        GuildLinkView.d(guildLinkView, title, str3, thumbUrl, redirectUrl, C, null, str2, null, null, MsgConstant.KRMFILETHUMBSIZE384, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.wbd};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        if (containerView == null) {
            return;
        }
        View findViewById = containerView.findViewById(R.id.f96795in);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026id.third_party_link_view)");
        this.linkView = (GuildLinkView) findViewById;
    }
}
