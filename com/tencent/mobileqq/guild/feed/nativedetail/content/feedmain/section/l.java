package com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.FeedDetailMainData;
import com.tencent.mobileqq.guild.feed.widget.GuildSmallWorldView;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J4\u0010\u0010\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u00042\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u0012\u001a\u00020\u0011H\u0014J\u0012\u0010\u0015\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/l;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/e;", "", "url", "", "urlType", "", "v", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedDetailMainData;", "data", "position", "", "", "payloads", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedDetailMainData$c$c;", "payload", "t", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "Lcom/tencent/mobileqq/guild/feed/widget/GuildSmallWorldView;", "d", "Lcom/tencent/mobileqq/guild/feed/widget/GuildSmallWorldView;", "smallWorldView", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class l extends e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildSmallWorldView smallWorldView;

    private final void v(String url, int urlType) {
        Map mapOf;
        GuildSmallWorldView guildSmallWorldView = this.smallWorldView;
        if (guildSmallWorldView != null) {
            VideoReport.setElementId(guildSmallWorldView, "em_sgrp_insert_card_url");
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("sgrp_url", url), TuplesKt.to("sgrp_url_type", Integer.valueOf(urlType)));
            VideoReport.setElementParams(guildSmallWorldView, mapOf);
            VideoReport.setElementExposePolicy(guildSmallWorldView, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementClickPolicy(guildSmallWorldView, ClickPolicy.REPORT_ALL);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.v1f};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        GuildSmallWorldView guildSmallWorldView;
        if (containerView != null) {
            guildSmallWorldView = (GuildSmallWorldView) containerView.findViewById(R.id.f165165v21);
        } else {
            guildSmallWorldView = null;
        }
        this.smallWorldView = guildSmallWorldView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.e
    protected void t(@Nullable FeedDetailMainData data, int position, @Nullable List<Object> payloads, @Nullable FeedDetailMainData.c.C7755c payload) {
        if (data == 0) {
            return;
        }
        this.mData = data;
        List<qj1.t> h16 = data.getFeedDetail().h();
        if (h16.isEmpty()) {
            GuildSmallWorldView guildSmallWorldView = this.smallWorldView;
            if (guildSmallWorldView != null) {
                guildSmallWorldView.setVisibility(8);
                return;
            }
            return;
        }
        GuildSmallWorldView guildSmallWorldView2 = this.smallWorldView;
        boolean z16 = false;
        if (guildSmallWorldView2 != null) {
            guildSmallWorldView2.setVisibility(0);
        }
        qj1.t tVar = h16.get(0);
        if (tVar.getUrlType() != 8 && tVar.getUrlType() != 9) {
            z16 = true;
        }
        GuildSmallWorldView guildSmallWorldView3 = this.smallWorldView;
        if (guildSmallWorldView3 != null) {
            GuildSmallWorldView.j(guildSmallWorldView3, new GuildSmallWorldView.b(tVar.getUrlType(), new GuildSmallWorldView.b.C7785b(tVar.getCoverUrl(), tVar.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_JUMP_URL java.lang.String(), z16), new GuildSmallWorldView.b.a(tVar.getPlatformIconUrl(), tVar.getPlatformName())), null, null, false, 14, null);
        }
        GuildSmallWorldView guildSmallWorldView4 = this.smallWorldView;
        if (guildSmallWorldView4 != null) {
            guildSmallWorldView4.setRadius(ShortFeedPicLineSection.INSTANCE.c());
        }
        v(tVar.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_JUMP_URL java.lang.String(), tVar.getUrlType());
    }
}
