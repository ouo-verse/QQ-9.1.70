package on1;

import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.guild.feed.qqgame.view.BaseGuildGameFeedsView;
import com.tencent.mobileqq.guild.feed.qqgame.view.GuildGameFeedsSinglePicView;
import com.tencent.mobileqq.guild.feed.qqgame.view.GuildGameFeedsSingleVideoView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001f2\u00020\u0001:\u0001\u0003BC\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0018\u0012\u0006\u0010\u001a\u001a\u00020\r\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0006R\u0018\u0010\f\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000eR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0013\u00a8\u0006 "}, d2 = {"Lon1/a;", "", "", "a", "", NodeProps.VISIBLE, "", "d", "c", "b", "Lcom/tencent/mobileqq/guild/feed/qqgame/view/BaseGuildGameFeedsView;", "Lcom/tencent/mobileqq/guild/feed/qqgame/view/BaseGuildGameFeedsView;", "mCardAdView", "", "I", "lastPosition", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Ljava/lang/String;", "mTraceId", "traceId", "", "adByteArray", "", "reportMap", "position", "Lon1/d;", "iAction", "<init>", "(Ljava/lang/String;Landroid/view/ViewGroup;[BLjava/util/Map;ILon1/d;)V", "e", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BaseGuildGameFeedsView mCardAdView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int lastPosition;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup container;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mTraceId;

    public a(@NotNull String traceId, @NotNull ViewGroup container, @NotNull byte[] adByteArray, @NotNull Map<String, String> reportMap, int i3, @NotNull d iAction) {
        BaseGuildGameFeedsView guildGameFeedsSinglePicView;
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(adByteArray, "adByteArray");
        Intrinsics.checkNotNullParameter(reportMap, "reportMap");
        Intrinsics.checkNotNullParameter(iAction, "iAction");
        this.lastPosition = -1;
        this.mTraceId = traceId;
        this.container = container;
        b b16 = c.b(adByteArray);
        com.tencent.xaction.log.b.a("GuildFeedGameCardAd", 1, "create ad view: traceId:" + traceId + " position:" + i3 + " mCardAdView:" + this.mCardAdView + " gameFeedsData:" + b16);
        if (this.mCardAdView == null) {
            this.lastPosition = i3;
            if (b16.f423213a == 2) {
                guildGameFeedsSinglePicView = new GuildGameFeedsSingleVideoView(container.getContext(), iAction);
            } else {
                guildGameFeedsSinglePicView = new GuildGameFeedsSinglePicView(container.getContext(), iAction);
            }
            this.mCardAdView = guildGameFeedsSinglePicView;
            reportMap.put("sgrp_ad_content_type", String.valueOf(b16.f423213a));
            BaseGuildGameFeedsView baseGuildGameFeedsView = this.mCardAdView;
            Intrinsics.checkNotNull(baseGuildGameFeedsView);
            baseGuildGameFeedsView.d(reportMap, b16);
            container.addView(this.mCardAdView);
            return;
        }
        com.tencent.xaction.log.b.a("GuildFeedGameCardAd", 1, "create ad view: mCardAdView is added newPosition=" + i3 + " lastPosition=" + this.lastPosition);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getMTraceId() {
        return this.mTraceId;
    }

    public final void b() {
        BaseGuildGameFeedsView baseGuildGameFeedsView = this.mCardAdView;
        if (baseGuildGameFeedsView != null) {
            try {
                Intrinsics.checkNotNull(baseGuildGameFeedsView);
                baseGuildGameFeedsView.g();
                ViewGroup viewGroup = this.container;
                if (viewGroup != null) {
                    Intrinsics.checkNotNull(viewGroup);
                    viewGroup.removeView(this.mCardAdView);
                }
            } catch (Throwable th5) {
                com.tencent.xaction.log.b.c("GuildFeedGameCardAd", 1, "onDestroy exception", th5);
            }
        }
    }

    public final void c() {
        BaseGuildGameFeedsView baseGuildGameFeedsView = this.mCardAdView;
        if (baseGuildGameFeedsView != null) {
            baseGuildGameFeedsView.h();
        }
    }

    public final void d(boolean visible) {
        BaseGuildGameFeedsView baseGuildGameFeedsView = this.mCardAdView;
        if (baseGuildGameFeedsView != null) {
            baseGuildGameFeedsView.i(visible);
        }
    }
}
