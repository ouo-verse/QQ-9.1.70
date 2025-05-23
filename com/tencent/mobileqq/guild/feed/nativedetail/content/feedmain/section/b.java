package com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.FeedDetailMainData;
import com.tencent.mobileqq.guild.feed.widget.GuildLinkView;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J4\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\u000e\u001a\u00020\rH\u0014J\u0012\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/b;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/e;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedDetailMainData;", "data", "", "position", "", "", "payloads", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedDetailMainData$c$c;", "payload", "", "t", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "Lcom/tencent/mobileqq/guild/feed/widget/GuildLinkView;", "d", "Lcom/tencent/mobileqq/guild/feed/widget/GuildLinkView;", "linkView", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b extends e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildLinkView linkView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.v1_};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        GuildLinkView guildLinkView;
        if (containerView != null) {
            guildLinkView = (GuildLinkView) containerView.findViewById(R.id.v1z);
        } else {
            guildLinkView = null;
        }
        this.linkView = guildLinkView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.e
    protected void t(@Nullable FeedDetailMainData data, int position, @Nullable List<Object> payloads, @Nullable FeedDetailMainData.c.C7755c payload) {
        if (data == 0) {
            return;
        }
        this.mData = data;
        List<qj1.q> b16 = data.getFeedDetail().b();
        if (b16.isEmpty()) {
            GuildLinkView guildLinkView = this.linkView;
            if (guildLinkView != null) {
                guildLinkView.setVisibility(8);
                return;
            }
            return;
        }
        GuildLinkView guildLinkView2 = this.linkView;
        if (guildLinkView2 != null) {
            guildLinkView2.setVisibility(0);
        }
        qj1.q qVar = b16.get(0);
        GuildLinkView guildLinkView3 = this.linkView;
        if (guildLinkView3 != null) {
            GuildLinkView.d(guildLinkView3, qVar.getTitle(), qVar.getAbstract(), qVar.getThumbUrl(), qVar.getRedirectUrl(), null, null, null, null, null, com.tencent.luggage.wxa.ig.w.CTRL_INDEX, null);
        }
    }
}
