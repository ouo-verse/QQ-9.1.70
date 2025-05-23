package com.tencent.mobileqq.guild.feed.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedNativeDetailApi;
import com.tencent.mobileqq.guild.feed.data.GProStFeedMemoryKeepSerializer;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.FeedRichTextContentParser;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.GestureTextView;
import com.tencent.mobileqq.guild.feed.nativedetail.fragment.FeedNativeDetailFragment;
import com.tencent.mobileqq.guild.feed.nativedetail.fragment.TroopFeedNativeDetailFragment;
import com.tencent.mobileqq.guild.feed.report.c;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextContent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 -2\u00020\u0001:\u0001.B\u0007\u00a2\u0006\u0004\b+\u0010,J0\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bH\u0002J\u0018\u0010\f\u001a\u00020\u00062\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bH\u0002J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0016J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001aH\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0018\u0010\u001e\u001a\u00020\u00022\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bH\u0016J\"\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016J0\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b2\u0006\u0010 \u001a\u00020\u0006H\u0016J*\u0010&\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00162\b\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010%\u001a\u00020$H\u0016J@\u0010&\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$2\u0006\u0010*\u001a\u00020\u0006H\u0016\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/impl/GuildFeedNativeDetailApiImpl;", "Lcom/tencent/mobileqq/guild/feed/api/IGuildFeedNativeDetailApi;", "", "feedId", "", "feedType", "", "needWebView", "", "functionList", "needOpenNativeDetailPage", "functionType", "supportsAllFunctions", "", "startTime", "", "reportOnOpen", "Landroid/content/Context;", "context", "Landroid/widget/TextView;", "createGestureTextView", "isLongFeedNativeSwitchOpen", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "stFeed", "hasThirdVideo", "checkCanPreload", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProContentRecommendFeed;", "feed", "recommendFeed", "list", "functionListToStr", "checkNeedWebView", "loggable", "feedData", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "initBean", "Landroid/content/Intent;", "intent", "openFeedNativeDetailPage", "guildId", "channelId", "businessType", "needActivityAnim", "<init>", "()V", "Companion", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedNativeDetailApiImpl implements IGuildFeedNativeDetailApi {

    @NotNull
    private static final List<Integer> SUPPORTED_FUNCTION_LIST;

    @NotNull
    public static final String TAG = "GuildFeedNativeDetailApiImpl";

    @NotNull
    private static final String LONG_FEED_NATIVE_SWITCH = "103125";
    private static final boolean longFeedNativeSwitchOpen = !((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(LONG_FEED_NATIVE_SWITCH, false);

    static {
        List<Integer> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{2, 3});
        SUPPORTED_FUNCTION_LIST = listOf;
    }

    private final void reportOnOpen(final long startTime, final String feedId) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.api.impl.w
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedNativeDetailApiImpl.reportOnOpen$lambda$5(feedId, startTime);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reportOnOpen$lambda$5(String feedId, long j3) {
        Intrinsics.checkNotNullParameter(feedId, "$feedId");
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_feed_id", feedId);
        hashMap.put("sgrp_open_time", Long.valueOf(j3));
        VideoReport.reportEvent("ev_sgrp_forum_detail_open", hashMap);
    }

    private final boolean supportsAllFunctions(List<Integer> functionType) {
        boolean z16;
        List<Integer> list = functionType;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        Iterator<Integer> it = functionType.iterator();
        while (it.hasNext()) {
            if (!SUPPORTED_FUNCTION_LIST.contains(Integer.valueOf(it.next().intValue()))) {
                return false;
            }
        }
        return true;
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedNativeDetailApi
    public boolean checkCanPreload(@NotNull GProStFeed stFeed) {
        Intrinsics.checkNotNullParameter(stFeed, "stFeed");
        return com.tencent.mobileqq.guild.discoveryv2.util.a.f217788a.a(stFeed.feedType) || hasThirdVideo(stFeed);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedNativeDetailApi
    public boolean checkNeedWebView(@NotNull String feedId, boolean needWebView, @Nullable String functionList) {
        List<String> split$default;
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        if (longFeedNativeSwitchOpen) {
            return false;
        }
        if (functionList == null || functionList.length() == 0) {
            return needWebView;
        }
        ArrayList arrayList = new ArrayList();
        split$default = StringsKt__StringsKt.split$default((CharSequence) functionList, new String[]{"_"}, false, 0, 6, (Object) null);
        for (String str : split$default) {
            if (TextUtils.isDigitsOnly(str)) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str)));
            }
        }
        return IGuildFeedNativeDetailApi.a.a(this, feedId, needWebView, arrayList, false, 8, null);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedNativeDetailApi
    @NotNull
    public TextView createGestureTextView(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new GestureTextView(context);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedNativeDetailApi
    @NotNull
    public String functionListToStr(@Nullable List<Integer> list) {
        boolean z16;
        List<Integer> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            sb5.append(list.get(i3).intValue());
            if (i3 != list.size() - 1) {
                sb5.append("_");
            }
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "stringBuilder.toString()");
        return sb6;
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedNativeDetailApi
    public boolean hasThirdVideo(@NotNull GProStFeed stFeed) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(stFeed, "stFeed");
        if (stFeed.summary.layoutType == 5) {
            return true;
        }
        ArrayList<GProStRichTextContent> arrayList = stFeed.contents.contents;
        Intrinsics.checkNotNullExpressionValue(arrayList, "stFeed.contents.contents");
        if (!(arrayList instanceof Collection) || !arrayList.isEmpty()) {
            for (GProStRichTextContent gProStRichTextContent : arrayList) {
                if (gProStRichTextContent.type == 3 && gProStRichTextContent.urlContent.type == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    z17 = true;
                    break;
                }
            }
        }
        z17 = false;
        if (z17) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedNativeDetailApi
    public boolean isLongFeedNativeSwitchOpen() {
        return longFeedNativeSwitchOpen;
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedNativeDetailApi
    public boolean needOpenNativeDetailPage(@NotNull IGProContentRecommendFeed recommendFeed) {
        Intrinsics.checkNotNullParameter(recommendFeed, "recommendFeed");
        if (longFeedNativeSwitchOpen) {
            return true;
        }
        String feedId = recommendFeed.getIdd();
        int feedType = recommendFeed.getFeedType();
        boolean needWebview = recommendFeed.getNeedWebview();
        ArrayList<Integer> functionList = recommendFeed.getFunctionList();
        Intrinsics.checkNotNullExpressionValue(feedId, "feedId");
        return needOpenNativeDetailPage(feedId, feedType, needWebview, functionList);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedNativeDetailApi
    public void openFeedNativeDetailPage(@NotNull Context context, @NotNull GProStFeed feedData, @Nullable GuildFeedBaseInitBean initBean, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        Intrinsics.checkNotNullParameter(intent, "intent");
        intent.putExtra("last_Modified_Time", feedData.meta.lastModifiedTime);
        intent.putExtra("st_feed_detail_data", new GProStFeedMemoryKeepSerializer(feedData));
        FeedRichTextContentParser feedRichTextContentParser = FeedRichTextContentParser.f221393a;
        String str = feedData.channelInfo.sign.joinGuildSig;
        Intrinsics.checkNotNullExpressionValue(str, "feedData.channelInfo.sign.joinGuildSig");
        JumpGuildParam.JoinInfoParam d16 = feedRichTextContentParser.d(initBean, str);
        if (d16 != null) {
            intent.putExtra("join_info_param", (Parcelable) d16);
        }
        if (initBean != null && initBean.getBusinessType() == 7) {
            String troopUin = initBean.getTroopUin();
            if (troopUin == null) {
                troopUin = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(troopUin, "initBean.troopUin ?: \"\"");
            }
            intent.putExtra("FEED_TROOP_UIN", troopUin);
            intent.putExtra("FEED_TROOP_ROLE", String.valueOf(initBean.getTroopRole()));
            intent.putExtra("guild_feed_support_at_entrance", false);
        }
        QRouteApi api = QRoute.api(IGuildFeedNativeDetailApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IGuildFeedNativeDetailApi::class.java)");
        IGuildFeedNativeDetailApi iGuildFeedNativeDetailApi = (IGuildFeedNativeDetailApi) api;
        String valueOf = String.valueOf(feedData.channelInfo.sign.guildId);
        String valueOf2 = String.valueOf(feedData.channelInfo.sign.channelId);
        String str2 = feedData.idd;
        Intrinsics.checkNotNullExpressionValue(str2, "feedData.idd");
        IGuildFeedNativeDetailApi.a.b(iGuildFeedNativeDetailApi, context, valueOf, valueOf2, str2, initBean != null ? initBean.getBusinessType() : 0, intent, false, 64, null);
        vh1.k.INSTANCE.b(String.valueOf(feedData.channelInfo.sign.guildId), TAG);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedNativeDetailApi
    public boolean checkCanPreload(@NotNull IGProContentRecommendFeed feed) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        return com.tencent.mobileqq.guild.discoveryv2.util.a.f217788a.a(feed.getFeedType()) || feed.getFeedContentType() == 4;
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedNativeDetailApi
    public boolean needOpenNativeDetailPage(@NotNull GProStFeed stFeed) {
        Intrinsics.checkNotNullParameter(stFeed, "stFeed");
        if (longFeedNativeSwitchOpen) {
            return true;
        }
        String feedId = stFeed.idd;
        int i3 = stFeed.feedType;
        boolean z16 = stFeed.needWebview;
        ArrayList<Integer> arrayList = stFeed.functionList;
        Intrinsics.checkNotNullExpressionValue(feedId, "feedId");
        return needOpenNativeDetailPage(feedId, i3, z16, arrayList);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedNativeDetailApi
    public boolean checkNeedWebView(@NotNull String feedId, boolean needWebView, @Nullable List<Integer> functionList, boolean loggable) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        boolean z16 = false;
        if (longFeedNativeSwitchOpen) {
            return false;
        }
        boolean supportsAllFunctions = supportsAllFunctions(functionList);
        if (needWebView && !supportsAllFunctions) {
            z16 = true;
        }
        if (loggable) {
            QLog.i(TAG, 1, "[checkNeedWebView] nativeSupportsAllFunctions = " + supportsAllFunctions + ", functionList: " + (functionList != null ? functionList.toString() : null) + ", needWebView\uff1a " + needWebView + ", needOpenWeb = " + z16 + ", feedId: " + feedId);
        }
        return z16;
    }

    private final boolean needOpenNativeDetailPage(String feedId, int feedType, boolean needWebView, List<Integer> functionList) {
        if (longFeedNativeSwitchOpen) {
            return true;
        }
        boolean a16 = IGuildFeedNativeDetailApi.a.a(this, feedId, needWebView, functionList, false, 8, null);
        QLog.i(TAG, 1, "[needOpenNativeDetailPage] feedType = " + feedType + " needOpenWeb = " + a16 + " functionList: " + (functionList != null ? functionList.toString() : null) + ", feedId = " + feedId);
        return !a16;
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedNativeDetailApi
    public void openFeedNativeDetailPage(@NotNull Context context, @NotNull String guildId, @NotNull String channelId, @NotNull String feedId, int businessType, @NotNull Intent intent, boolean needActivityAnim) {
        Class cls;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(intent, "intent");
        QLog.i(TAG, 1, "openFeedNativeDetailPage guildId = " + guildId + " channelId = " + channelId + " feedId = " + feedId + " businessType = " + businessType + " needActivityAnim=" + needActivityAnim);
        if (!(guildId.length() == 0)) {
            if (!(channelId.length() == 0)) {
                if (!(feedId.length() == 0)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    com.tencent.mobileqq.guild.feed.report.c.f223280a.r(intent, new c.FeedReportData(feedId, guildId, channelId), businessType == 7);
                    intent.putExtra("guild_id", guildId);
                    intent.putExtra("channel_id", channelId);
                    intent.putExtra("feed_id", feedId);
                    intent.putExtra("business_type", businessType);
                    intent.putExtra("public_fragment_window_feature", 1);
                    intent.putExtra("start_time", currentTimeMillis);
                    boolean z16 = context instanceof Activity;
                    if (!z16) {
                        intent.addFlags(268435456);
                    }
                    if (businessType == 7) {
                        intent.putExtra("guild_feed_support_at_entrance", false);
                    }
                    if (businessType == 7) {
                        if (!intent.hasExtra("FEED_TROOP_UIN") && z16) {
                            Intent intent2 = ((Activity) context).getIntent();
                            long longExtra = intent2 != null ? intent2.getLongExtra("key_peerUin", 0L) : 0L;
                            if (longExtra != 0) {
                                intent.putExtra("FEED_TROOP_UIN", String.valueOf(longExtra));
                            }
                        }
                        cls = TroopFeedNativeDetailFragment.class;
                    } else {
                        cls = FeedNativeDetailFragment.class;
                    }
                    Class cls2 = cls;
                    if (!needActivityAnim && !GuildSplitViewUtils.f235370a.D(context)) {
                        QPublicFragmentActivity.b.b(context, intent, QPublicTransFragmentActivity.class, cls2);
                    } else {
                        GuildSplitViewUtils.p(GuildSplitViewUtils.f235370a, context, intent, cls2, null, 8, null);
                    }
                    vh1.k.INSTANCE.b(guildId, TAG);
                    reportOnOpen(currentTimeMillis, feedId);
                }
            }
        }
    }
}
