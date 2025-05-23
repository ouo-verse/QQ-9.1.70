package com.tencent.mobileqq.guild.feed.morepanel;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.data.v;
import com.tencent.mobileqq.guild.feed.morepanel.k;
import com.tencent.mobileqq.guild.share.q;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.widget.ActionSheet;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\u0012\n\u0010\u0012\u001a\u00060\u000fj\u0002`\u0010\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001e\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016R\u0018\u0010\u0012\u001a\u00060\u000fj\u0002`\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0011R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0014R'\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/FeedSharePanelReportHelper;", "Lcom/tencent/mobileqq/guild/feed/morepanel/g;", "Lcom/tencent/widget/ActionSheet;", "actionSheet", "", "b", "Landroid/view/View;", "itemView", "Landroid/widget/ImageView;", "iconView", "Landroid/widget/TextView;", "nickView", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "sheetItem", "a", "Lqj1/d;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/IFeedBasicIdDisplayable;", "Lqj1/d;", "feed", "Lcom/tencent/mobileqq/guild/feed/morepanel/k$a;", "Lcom/tencent/mobileqq/guild/feed/morepanel/k$a;", "operationListProvider", "", "", "", "c", "Lkotlin/Lazy;", "d", "()Ljava/util/Map;", "pageParam", "Lcom/tencent/mobileqq/guild/data/GuildSharePageSource;", "pageSource", "<init>", "(Lqj1/d;Lcom/tencent/mobileqq/guild/feed/morepanel/k$a;Lcom/tencent/mobileqq/guild/data/GuildSharePageSource;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedSharePanelReportHelper implements g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final qj1.d feed;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final k.a operationListProvider;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy pageParam;

    public FeedSharePanelReportHelper(@NotNull qj1.d feed, @Nullable k.a aVar, @NotNull final GuildSharePageSource pageSource) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(feed, "feed");
        Intrinsics.checkNotNullParameter(pageSource, "pageSource");
        this.feed = feed;
        this.operationListProvider = aVar;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Map<String, Object>>() { // from class: com.tencent.mobileqq.guild.feed.morepanel.FeedSharePanelReportHelper$pageParam$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Map<String, Object> invoke() {
                qj1.d dVar;
                qj1.d dVar2;
                qj1.d dVar3;
                qj1.d dVar4;
                qj1.d dVar5;
                Map<String, Object> mutableMapOf;
                dVar = FeedSharePanelReportHelper.this.feed;
                dVar2 = FeedSharePanelReportHelper.this.feed;
                dVar3 = FeedSharePanelReportHelper.this.feed;
                dVar4 = FeedSharePanelReportHelper.this.feed;
                dVar5 = FeedSharePanelReportHelper.this.feed;
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("biz_source", "biz_src_jc_qqstation"), TuplesKt.to("sgrp_channel_id", Long.valueOf(dVar.getGuildId())), TuplesKt.to("sgrp_sub_channel_id", Long.valueOf(dVar2.getChannelId())), TuplesKt.to("sgrp_user_type", Integer.valueOf(v.c(String.valueOf(dVar3.getGuildId())))), TuplesKt.to("sgrp_content_id", dVar4.getFeedId()), TuplesKt.to("sgrp_feed_id", dVar5.getFeedId()), TuplesKt.to(AppConstants.Key.SHARE_PANEL_PAGE_SOURCE, Integer.valueOf(pageSource.ordinal())));
                mutableMapOf.putAll(com.tencent.mobileqq.guild.report.b.d());
                return mutableMapOf;
            }
        });
        this.pageParam = lazy;
    }

    private final Map<String, Object> d() {
        return (Map) this.pageParam.getValue();
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheetV2.m
    public void a(@NotNull View itemView, @NotNull ImageView iconView, @NotNull TextView nickView, @NotNull ShareActionSheetBuilder.ActionSheetItem sheetItem) {
        boolean z16;
        List<ShareActionSheetBuilder.ActionSheetItem> b16;
        List<ShareActionSheetBuilder.ActionSheetItem> a16;
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(iconView, "iconView");
        Intrinsics.checkNotNullParameter(nickView, "nickView");
        Intrinsics.checkNotNullParameter(sheetItem, "sheetItem");
        int i3 = sheetItem.action;
        if (i3 != 73 && i3 != 72) {
            k.a aVar = this.operationListProvider;
            boolean z17 = true;
            if (aVar != null && (a16 = aVar.a()) != null && a16.contains(sheetItem)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                VideoReport.setElementId(itemView, "em_sgrp_forum_operate_btn");
                VideoReport.setElementParam(itemView, "sgrp_btn_name", nickView.getText().toString());
                VideoReport.setElementParam(itemView, "sgrp_share_source", q.INSTANCE.b(sheetItem.action));
            } else {
                k.a aVar2 = this.operationListProvider;
                if (aVar2 == null || (b16 = aVar2.b()) == null || !b16.contains(sheetItem)) {
                    z17 = false;
                }
                if (z17) {
                    VideoReport.setElementId(itemView, "em_sgrp_share_item");
                    VideoReport.setElementParam(itemView, "sgrp_btn_name", nickView.getText().toString());
                    VideoReport.setElementParam(itemView, "sgrp_share_source", q.INSTANCE.b(sheetItem.action));
                }
            }
        } else {
            VideoReport.setElementExposePolicy(itemView, ExposurePolicy.REPORT_NONE);
            VideoReport.setElementId(itemView, "em_sgrp_share_panel_more_contacts");
            VideoReport.setElementParam(itemView, ShortVideoConstants.TO_UIN_TYPE, q.INSTANCE.a(sheetItem.uinType, sheetItem.action));
            VideoReport.setElementParam(itemView, "sgrp_channel_id", String.valueOf(this.feed.getGuildId()));
        }
        VideoReport.setElementReuseIdentifier(itemView, String.valueOf(sheetItem.hashCode()));
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheetV2.l
    public void b(@NotNull ActionSheet actionSheet) {
        Intrinsics.checkNotNullParameter(actionSheet, "actionSheet");
        VideoReport.setPageId(actionSheet, "pg_qdesign_shareview");
        VideoReport.setPageParams(actionSheet, new PageParams((Map<String, ?>) d()));
    }

    public /* synthetic */ FeedSharePanelReportHelper(qj1.d dVar, k.a aVar, GuildSharePageSource guildSharePageSource, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(dVar, aVar, (i3 & 4) != 0 ? GuildSharePageSource.FEED_DETAIL : guildSharePageSource);
    }
}
