package com.tencent.mobileqq.guild.discoveryv2.dialog;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.base.extension.o;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendAbsFeedData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendFeedTopicData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendFeedsGuildData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendGroupData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendRobotData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.m;
import com.tencent.mobileqq.guild.discoveryv2.widget.a;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedConfigAPi;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendRobot;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProFeedGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller.QAdCardExtraData;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qj1.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0002J@\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t2\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005J\u0016\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0010J(\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0013\u001a\u00020\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/dialog/RecommendFeedbackDialog;", "", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/l;", "data", "", "Lcom/tencent/mobileqq/guild/discoveryv2/widget/a$a;", "a", "Landroid/content/Context;", "ctx", "", "", QAdCardExtraData.AdExtraInnerKey.AD_EXTRA_KEY_PAGE_PARAMS, "extItem", "", "d", "feedId", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendAbsFeedData;", "b", "", "position", "c", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class RecommendFeedbackDialog {

    /* renamed from: a */
    @NotNull
    public static final RecommendFeedbackDialog f217414a = new RecommendFeedbackDialog();

    RecommendFeedbackDialog() {
    }

    private final List<a.C7731a> a(l<?> data) {
        List mutableList;
        int collectionSizeOrDefault;
        List<a.C7731a> mutableList2;
        o oVar = o.f214742a;
        QRouteApi api = QRoute.api(IGuildFeedConfigAPi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(T::class.java)");
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) ((IGuildFeedConfigAPi) api).getFeedOptionConfig());
        List<String> list = mutableList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (String str : list) {
            arrayList.add(new a.C7731a(str, new RecommendFeedbackDialog$configActionSheetItem$1$1(str, data)));
        }
        mutableList2 = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        return mutableList2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void e(RecommendFeedbackDialog recommendFeedbackDialog, Context context, Map map, l lVar, a.C7731a c7731a, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            lVar = null;
        }
        if ((i3 & 8) != 0) {
            c7731a = null;
        }
        recommendFeedbackDialog.d(context, map, lVar, c7731a);
    }

    @NotNull
    public final a.C7731a b(@NotNull String feedId, @NotNull RecommendAbsFeedData data) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(data, "data");
        String jubaoStr = HardCodeUtil.qqStr(R.string.f161581y4);
        Intrinsics.checkNotNullExpressionValue(jubaoStr, "jubaoStr");
        return new a.C7731a(jubaoStr, new RecommendFeedbackDialog$jubaoItem$1(jubaoStr, data));
    }

    @NotNull
    public final Map<String, Object> c(@NotNull l<?> data, int position) {
        Map<String, Object> emptyMap;
        h hVar;
        Long l3;
        h hVar2;
        Map<String, Object> mapOf;
        Object firstOrNull;
        String joinToString$default;
        Map<String, Object> mapOf2;
        IGProFeedGuildInfo guildInfo;
        Map<String, Object> mapOf3;
        Map<String, Object> mapOf4;
        String str;
        Object obj;
        Map<String, Object> mapOf5;
        Map<String, Object> mapOf6;
        Intrinsics.checkNotNullParameter(data, "data");
        if (data instanceof RecommendAbsFeedData) {
            RecommendAbsFeedData recommendAbsFeedData = (RecommendAbsFeedData) data;
            mapOf6 = MapsKt__MapsKt.mapOf(TuplesKt.to("sgrp_content_id", recommendAbsFeedData.getIdd()), TuplesKt.to("sgrp_content_title", recommendAbsFeedData.getTitle()), TuplesKt.to("sgrp_content_card_type", 1), TuplesKt.to("sgrp_sub_channel_id", String.valueOf(recommendAbsFeedData.getGuildInfo().getChannelId())), TuplesKt.to("sgrp_channel_id", String.valueOf(recommendAbsFeedData.getGuildInfo().getGuildId())), TuplesKt.to("sgrp_user_place", Integer.valueOf(position)), TuplesKt.to(JumpGuildParam.EXTRA_KEY_TRACE_ID, data.getRecommendExtData().getTraceId()));
            return mapOf6;
        }
        Object obj2 = "";
        Object obj3 = null;
        if (data instanceof RecommendRobotData) {
            Pair[] pairArr = new Pair[6];
            pairArr[0] = TuplesKt.to("sgrp_content_card_type", 33);
            pairArr[1] = TuplesKt.to("sgrp_user_place", Integer.valueOf(position));
            pairArr[2] = TuplesKt.to(JumpGuildParam.EXTRA_KEY_TRACE_ID, data.getRecommendExtData().getTraceId());
            RecommendRobotData recommendRobotData = (RecommendRobotData) data;
            IGProContentRecommendRobot robot = recommendRobotData.getRecommendItem().getRobot();
            if (robot != null) {
                str = robot.getAppId();
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            pairArr[3] = TuplesKt.to("sgrp_robot_appid", str);
            IGProContentRecommendRobot robot2 = recommendRobotData.getRecommendItem().getRobot();
            if (robot2 == null) {
                obj = "";
            } else {
                obj = Long.valueOf(robot2.getRobotUin());
            }
            pairArr[4] = TuplesKt.to("sgrp_robot_uin", obj);
            IGProContentRecommendRobot robot3 = recommendRobotData.getRecommendItem().getRobot();
            if (robot3 != null) {
                obj3 = robot3.getUid();
            }
            if (obj3 != null) {
                obj2 = obj3;
            }
            pairArr[5] = TuplesKt.to("sgrp_robot_uid", obj2);
            mapOf5 = MapsKt__MapsKt.mapOf(pairArr);
            return mapOf5;
        }
        if (data instanceof RecommendGroupData) {
            mapOf4 = MapsKt__MapsKt.mapOf(TuplesKt.to("sgrp_content_id", Long.valueOf(((RecommendGroupData) data).getGroupCode())), TuplesKt.to("sgrp_content_card_type", 15), TuplesKt.to("sgrp_user_place", Integer.valueOf(position)), TuplesKt.to(JumpGuildParam.EXTRA_KEY_TRACE_ID, data.getRecommendExtData().getTraceId()));
            return mapOf4;
        }
        if (data instanceof RecommendFeedTopicData) {
            mapOf3 = MapsKt__MapsKt.mapOf(TuplesKt.to("sgrp_content_id", ""), TuplesKt.to("sgrp_content_card_type", 18), TuplesKt.to("sgrp_user_place", Integer.valueOf(position)), TuplesKt.to(JumpGuildParam.EXTRA_KEY_TRACE_ID, data.getRecommendExtData().getTraceId()));
            return mapOf3;
        }
        if (data instanceof RecommendFeedsGuildData) {
            Pair[] pairArr2 = new Pair[5];
            pairArr2[0] = TuplesKt.to("sgrp_content_card_type", 19);
            pairArr2[1] = TuplesKt.to("sgrp_user_place", Integer.valueOf(position));
            pairArr2[2] = TuplesKt.to(JumpGuildParam.EXTRA_KEY_TRACE_ID, data.getRecommendExtData().getTraceId());
            RecommendFeedsGuildData recommendFeedsGuildData = (RecommendFeedsGuildData) data;
            ArrayList<IGProContentRecommendFeed> feeds = recommendFeedsGuildData.getRecommendItem().getFeeds();
            Intrinsics.checkNotNullExpressionValue(feeds, "data.recommendItem.feeds");
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) feeds);
            IGProContentRecommendFeed iGProContentRecommendFeed = (IGProContentRecommendFeed) firstOrNull;
            if (iGProContentRecommendFeed != null && (guildInfo = iGProContentRecommendFeed.getGuildInfo()) != null) {
                obj3 = Long.valueOf(guildInfo.getGuildId());
            }
            pairArr2[3] = TuplesKt.to("sgrp_channel_id", obj3);
            ArrayList<IGProContentRecommendFeed> feeds2 = recommendFeedsGuildData.getRecommendItem().getFeeds();
            Intrinsics.checkNotNullExpressionValue(feeds2, "data.recommendItem.feeds");
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(feeds2, ",", null, null, 0, null, new Function1<IGProContentRecommendFeed, CharSequence>() { // from class: com.tencent.mobileqq.guild.discoveryv2.dialog.RecommendFeedbackDialog$pageParams$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final CharSequence invoke(IGProContentRecommendFeed iGProContentRecommendFeed2) {
                    String idd = iGProContentRecommendFeed2.getIdd();
                    Intrinsics.checkNotNullExpressionValue(idd, "it.idd");
                    return idd;
                }
            }, 30, null);
            pairArr2[4] = TuplesKt.to("sgrp_content_id", joinToString$default);
            mapOf2 = MapsKt__MapsKt.mapOf(pairArr2);
            return mapOf2;
        }
        if (!(data instanceof m)) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            return emptyMap;
        }
        Pair[] pairArr3 = new Pair[5];
        pairArr3[0] = TuplesKt.to("sgrp_content_card_type", 20);
        pairArr3[1] = TuplesKt.to("sgrp_user_place", Integer.valueOf(position));
        pairArr3[2] = TuplesKt.to(JumpGuildParam.EXTRA_KEY_TRACE_ID, data.getRecommendExtData().getTraceId());
        Object recommendItem = data.getRecommendItem();
        if (recommendItem instanceof h) {
            hVar = (h) recommendItem;
        } else {
            hVar = null;
        }
        if (hVar != null) {
            l3 = Long.valueOf(hVar.getGuildId());
        } else {
            l3 = null;
        }
        pairArr3[3] = TuplesKt.to("sgrp_channel_id", l3);
        Object recommendItem2 = data.getRecommendItem();
        if (recommendItem2 instanceof h) {
            hVar2 = (h) recommendItem2;
        } else {
            hVar2 = null;
        }
        if (hVar2 != null) {
            obj3 = hVar2.getFeedId();
        }
        pairArr3[4] = TuplesKt.to("sgrp_content_id", obj3);
        mapOf = MapsKt__MapsKt.mapOf(pairArr3);
        return mapOf;
    }

    public final void d(@NotNull Context ctx, @NotNull Map<String, ? extends Object> r46, @Nullable l<?> data, @Nullable a.C7731a extItem) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(r46, "pageParams");
        List<a.C7731a> a16 = a(data);
        if (extItem != null) {
            a16.add(extItem);
        }
        com.tencent.mobileqq.guild.discoveryv2.widget.a aVar = new com.tencent.mobileqq.guild.discoveryv2.widget.a();
        aVar.d(a16);
        aVar.c(new a.C7731a("\u53d6\u6d88", RecommendFeedbackDialog$show$actionSheet$1$1.INSTANCE));
        ActionSheet a17 = aVar.a(ctx);
        a17.show();
        VideoReport.setPageId(a17, "pg_sgrp_content_feedback");
        VideoReport.setPageParams(a17, new PageParams(r46));
        VideoReport.traverseExposure();
    }
}
