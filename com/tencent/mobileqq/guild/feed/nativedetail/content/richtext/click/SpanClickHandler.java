package com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.click;

import android.content.Context;
import android.view.View;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.api.impl.GuildDTReportApiImpl;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi;
import com.tencent.mobileqq.guild.feed.launcher.parser.f;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.utils.aq;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.page.PageInfo;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yl1.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b-\u0010.J>\u0010\n\u001a\u00020\t2\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001`\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002JL\u0010\u0010\u001a\u00020\t2\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001`\u00042\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u0007H\u0002JM\u0010\u0015\u001a\u00020\t2\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001`\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0007H\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016Jq\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001`\u00042\u0006\u0010\u0014\u001a\u00020\u00072\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001c\u001a\u00020\u000e\u00a2\u0006\u0004\b\u001d\u0010\u001eJO\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0014\u001a\u00020\u00072\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u000e\u00a2\u0006\u0004\b\u001f\u0010 JV\u0010!\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001`\u0004Jg\u0010%\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u00032\"\u0010#\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001`\u00042\u0006\u0010$\u001a\u00020\f\u00a2\u0006\u0004\b%\u0010&J(\u0010*\u001a\u00020\t2\u0006\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010)\u001a\u00020\u000eJ\u0016\u0010,\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0003\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/click/SpanClickHandler;", "", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "dtReportParams", "channelId", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", "j", "userId", "", "textBusinessType", "", "isRobot", "i", "", "topicId", "fromBusinessType", "view", "k", "(Ljava/util/HashMap;Ljava/lang/Long;ILandroid/view/View;)V", "guildId", "isSquare", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "joinInfoParam", QCircleWeakNetReporter.KEY_TRACE_ID, "forceOpenGuildHome", "c", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;Ljava/util/HashMap;Landroid/view/View;Ljava/lang/String;Z)V", "g", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;Landroid/view/View;Ljava/lang/String;Z)V", "b", "displayText", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "businessType", "e", "(Ljava/lang/Long;Ljava/lang/String;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;I)V", "groupCode", "signature", "isFromFeedGallery", "f", "guildNumber", "d", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class SpanClickHandler {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final SpanClickHandler f221406a = new SpanClickHandler();

    SpanClickHandler() {
    }

    public static /* synthetic */ void h(SpanClickHandler spanClickHandler, String str, String str2, Boolean bool, JumpGuildParam.JoinInfoParam joinInfoParam, View view, String str3, boolean z16, int i3, Object obj) {
        String str4;
        boolean z17;
        if ((i3 & 32) != 0) {
            str4 = "";
        } else {
            str4 = str3;
        }
        if ((i3 & 64) != 0) {
            z17 = false;
        } else {
            z17 = z16;
        }
        spanClickHandler.g(str, str2, bool, joinInfoParam, view, str4, z17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(HashMap<String, Object> dtReportParams, String userId, int textBusinessType, boolean isRobot, View widget) {
        if (textBusinessType == 0) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.putAll(dtReportParams);
        hashMap.put("sgrp_touin", userId);
        hashMap.put("sgrp_click_region", Integer.valueOf(textBusinessType));
        if (isRobot) {
            hashMap.put("sgrp_touin_user_type", 1);
        } else {
            hashMap.put("sgrp_touin_user_type", 0);
        }
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).reportDtEventManual(widget, "em_sgrp_at_user", "clck", hashMap);
    }

    private final void j(HashMap<String, Object> dtReportParams, String channelId, View widget) {
        HashMap hashMap = new HashMap();
        hashMap.putAll(dtReportParams);
        if (channelId == null) {
            channelId = "";
        }
        hashMap.put("sgrp_insert_sub_channel_id", channelId);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).reportDtEventManual(widget, "em_sgrp_sub_channel_link", "clck", hashMap);
    }

    private final void k(HashMap<String, Object> dtReportParams, Long topicId, int fromBusinessType, View view) {
        long j3;
        String str;
        String str2;
        GuildDTReportApiImpl guildDTReportApiImpl = ch.f235509b;
        PageInfo nearestPageInfoWithPgId = guildDTReportApiImpl.getNearestPageInfoWithPgId(view);
        HashMap hashMap = new HashMap();
        hashMap.putAll(dtReportParams);
        if (topicId != null) {
            j3 = topicId.longValue();
        } else {
            j3 = 0;
        }
        hashMap.put("sgrp_topic_id", Long.valueOf(j3));
        HashMap hashMap2 = new HashMap();
        hashMap2.putAll(dtReportParams);
        hashMap2.putAll(guildDTReportApiImpl.getPageInfoParams(nearestPageInfoWithPgId));
        if (fromBusinessType == 22) {
            str = "em_sgrp_forum_editor_layer_topic";
        } else {
            str = "em_sgrp_forum_editor_topic";
        }
        HashMap hashMap3 = new HashMap();
        if (nearestPageInfoWithPgId != null) {
            str2 = nearestPageInfoWithPgId.getPageId();
        } else {
            str2 = null;
        }
        hashMap3.put("dt_pgid", str2);
        hashMap3.put("cur_pg", hashMap2);
        hashMap3.putAll(hashMap);
        VideoReport.setElementId(view, str);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
        VideoReport.reportEvent("clck", view, hashMap3);
    }

    public final void b(@NotNull final View widget, @Nullable String channelId, @Nullable String guildId, @NotNull final String userId, final int textBusinessType, @NotNull final HashMap<String, Object> dtReportParams) {
        Intrinsics.checkNotNullParameter(widget, "widget");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(dtReportParams, "dtReportParams");
        if (guildId == null) {
            guildId = "";
        }
        if (channelId == null) {
            channelId = "";
        }
        GuildProfileData guildProfileData = GuildProfileData.ofTextTypeData(guildId, channelId, userId, 2);
        IGuildFeedUtilsApi iGuildFeedUtilsApi = (IGuildFeedUtilsApi) QRoute.api(IGuildFeedUtilsApi.class);
        Context context = widget.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "widget.context");
        Intrinsics.checkNotNullExpressionValue(guildProfileData, "guildProfileData");
        iGuildFeedUtilsApi.openProfileOnClick(context, guildProfileData, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.click.SpanClickHandler$handleClickAtSpan$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                SpanClickHandler.f221406a.i(dtReportParams, userId, textBusinessType, z16, widget);
            }
        });
    }

    public final void c(@NotNull String guildId, @NotNull String channelId, @Nullable Boolean isSquare, @Nullable JumpGuildParam.JoinInfoParam joinInfoParam, @NotNull HashMap<String, Object> dtReportParams, @NotNull View view, @Nullable String traceID, boolean forceOpenGuildHome) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(dtReportParams, "dtReportParams");
        Intrinsics.checkNotNullParameter(view, "view");
        g(guildId, channelId, isSquare, joinInfoParam, view, traceID, forceOpenGuildHome);
        j(dtReportParams, channelId, view);
    }

    public final void d(@NotNull View view, @NotNull String guildNumber) {
        boolean z16;
        HashMap hashMapOf;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(guildNumber, "guildNumber");
        if (guildNumber.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            n.z(0, R.string.f146830v9);
            return;
        }
        JumpGuildParam jumpGuildParam = new JumpGuildParam("", "");
        jumpGuildParam.setMainAndSubSource("share", "channel_code_channel");
        com.tencent.mobileqq.guild.report.b.g("channel_code_highlight_channel", "SpanClickHandler");
        jumpGuildParam.guildNumber = guildNumber;
        jumpGuildParam.businessType = 9;
        ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).jumpGuildOnFullStandalone(view.getContext(), jumpGuildParam);
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("sgrp_highlight_channel_code", guildNumber));
        VideoReport.setElementId(view, "em_sgrp_channel_code_blue_highlight");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
        VideoReport.reportEvent("clck", view, hashMapOf);
    }

    public final void e(@Nullable Long topicId, @Nullable String guildId, @NotNull View widget, @NotNull String displayText, @Nullable String traceID, @NotNull HashMap<String, Object> reportParams, int businessType) {
        Intrinsics.checkNotNullParameter(widget, "widget");
        Intrinsics.checkNotNullParameter(displayText, "displayText");
        Intrinsics.checkNotNullParameter(reportParams, "reportParams");
        if (topicId != null) {
            long longValue = topicId.longValue();
            f fVar = f.f220101a;
            Context context = widget.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "widget.context");
            fVar.Q(context, longValue, displayText, traceID, guildId);
        }
        k(reportParams, topicId, businessType, widget);
    }

    public final void f(@NotNull String groupCode, @NotNull String signature, @NotNull View view, boolean isFromFeedGallery) {
        int i3;
        Intrinsics.checkNotNullParameter(groupCode, "groupCode");
        Intrinsics.checkNotNullParameter(signature, "signature");
        Intrinsics.checkNotNullParameter(view, "view");
        if (isFromFeedGallery) {
            i3 = 1024;
        } else {
            i3 = 1023;
        }
        ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).openTroopInfoActivity(view.getContext(), aq.d(groupCode, signature, i3), 2);
    }

    public final void g(@NotNull String guildId, @NotNull String channelId, @Nullable Boolean isSquare, @Nullable JumpGuildParam.JoinInfoParam joinInfoParam, @NotNull View view, @Nullable String traceID, boolean forceOpenGuildHome) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(view, "view");
        GuildMainFrameUtils.i(guildId, channelId, 0, null, false, new SpanClickHandler$openChannel$1(isSquare, view.getContext(), guildId, channelId, joinInfoParam, traceID, forceOpenGuildHome), 28, null);
    }
}
