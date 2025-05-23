package com.tencent.mobileqq.guild.discoveryv2.content.recommend;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendAbsFeedData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendFeedTopicData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendFeedsGuildData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendGroupData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendGuildData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendHotLiveData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendLiveData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendRobotData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendSchemeData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendScreenShareData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendSelectedGuildData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendVoiceData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.i;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.p;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.minigame.minigamecenter.hippy.MiniGameCenterHippyFragment;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGuild;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendLive;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendRobot;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendVoice;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProEntry;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProExtra;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProFeedGuildInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a6\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002\u001a \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u001a\f\u0010\t\u001a\u00020\u0001*\u00020\bH\u0002\u001a \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u001a\f\u0010\f\u001a\u00020\u0001*\u00020\u000bH\u0002\u001a \u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u001a\f\u0010\u000f\u001a\u00020\u0001*\u00020\u000eH\u0002\u001a \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u001a\f\u0010\u0012\u001a\u00020\u0001*\u00020\u0011H\u0002\u001a \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u001a\f\u0010\u0015\u001a\u00020\u0001*\u00020\u0014H\u0002\u001a \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u001a\f\u0010\u0018\u001a\u00020\u0001*\u00020\u0017H\u0002\u001a\f\u0010\u001a\u001a\u00020\u0001*\u00020\u0019H\u0002\u001a \u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u00192\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u001a \u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u001a\f\u0010\u001e\u001a\u00020\u0001*\u00020\u001dH\u0002\u001a \u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u001d2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u001a\f\u0010!\u001a\u00020\u0001*\u00020 H\u0002\u001a \u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005*\u00020 2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u001a\f\u0010$\u001a\u00020\u0001*\u00020#H\u0002\u001a \u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005*\u00020#2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u001a\f\u0010'\u001a\u00020\u0001*\u00020&H\u0002\u001a \u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005*\u00020&2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u001a\f\u0010*\u001a\u00020\u0001*\u00020)H\u0002\u001a \u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005*\u00020)2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u001a\u000e\u0010-\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030,\u001a\"\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005*\u0006\u0012\u0002\b\u00030,2\u0006\u0010\u0004\u001a\u00020\u0003\u001a$\u00103\u001a\u00020\u00012\u001a\u00102\u001a\u0016\u0012\u0004\u0012\u000200\u0018\u00010/j\n\u0012\u0004\u0012\u000200\u0018\u0001`1H\u0002\u001a\u0018\u00105\u001a\u000204*\u0006\u0012\u0002\b\u00030,2\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u001a0\u00109\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u0001082\u0006\u00106\u001a\u00020\u00012\n\u00107\u001a\u0006\u0012\u0002\b\u00030,2\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u0017\u0010;\u001a\u0004\u0018\u00010:*\u0006\u0012\u0002\b\u00030,\u00a2\u0006\u0004\b;\u0010<\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendAbsFeedData;", "", "c", "", "position", "", "", "w", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendRobotData;", "k", "E", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendGroupData;", "g", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendSchemeData;", "l", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendGuildData;", h.F, "B", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendVoiceData;", "o", "I", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendScreenShareData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendFeedTopicData;", "e", "y", "G", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendLiveData;", "j", "D", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendSelectedGuildData;", DomainData.DOMAIN_NAME, "H", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendHotLiveData;", "i", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendFeedsGuildData;", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/p;", "d", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/l;", "b", "v", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProEntry;", "Lkotlin/collections/ArrayList;", "reportsInfo", "u", "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "p", "event", "data", "", "t", "", ReportConstant.COSTREPORT_PREFIX, "(Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/l;)Ljava/lang/Double;", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class RecommendReportHelperKt {
    private static final Map<String, Object> A(RecommendGroupData recommendGroupData, int i3) {
        Map<String, Object> mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("group_id", String.valueOf(recommendGroupData.getGroupCode())), TuplesKt.to("sgrp_rank", Integer.valueOf(i3)), TuplesKt.to("sgrp_trace_operate_json", u(recommendGroupData.getRecommendItem().getExtra().getReports())));
        return mutableMapOf;
    }

    private static final Map<String, Object> B(RecommendGuildData recommendGuildData, int i3) {
        Object obj;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("sgrp_rank", Integer.valueOf(i3));
        IGProContentRecommendGuild contentRecommendGuild = recommendGuildData.getRecommendItem().getContentRecommendGuild();
        if (contentRecommendGuild != null) {
            obj = Long.valueOf(contentRecommendGuild.getGuildId());
        } else {
            obj = "";
        }
        linkedHashMap.put("sgrp_channel_id", obj.toString());
        linkedHashMap.put(JumpGuildParam.EXTRA_KEY_TRACE_ID, recommendGuildData.getRecommendExtData().getTraceId());
        linkedHashMap.put("sgrp_trace_operate_json", u(recommendGuildData.getRecommendItem().getExtra().getReports()));
        i iVar = new i();
        iVar.b(recommendGuildData);
        linkedHashMap.put("sgrp_status", Integer.valueOf(iVar.getSgrpStatus()));
        linkedHashMap.put("sgrp_recall_tag", iVar.getSgrpRecallTag());
        linkedHashMap.put("sgrp_explicit_tag", iVar.getSgrpExplicitTag());
        linkedHashMap.put("sgrp_game_gift_tag", iVar.getSgrpGameGiftTag());
        return linkedHashMap;
    }

    private static final Map<String, Object> C(RecommendHotLiveData recommendHotLiveData, int i3) {
        Map<String, Object> mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("sgrp_rank", Integer.valueOf(i3)), TuplesKt.to(JumpGuildParam.EXTRA_KEY_TRACE_ID, recommendHotLiveData.getRecommendExtData().getTraceId()), TuplesKt.to("sgrp_trace_operate_json", u(recommendHotLiveData.getRecommendItem().getExtra().getReports())));
        return mutableMapOf;
    }

    private static final Map<String, Object> D(RecommendLiveData recommendLiveData, int i3) {
        Object obj;
        Object obj2;
        Map<String, Object> mutableMapOf;
        Pair[] pairArr = new Pair[6];
        pairArr[0] = TuplesKt.to("sgrp_rank", Integer.valueOf(i3));
        IGProContentRecommendLive contentRecommendLive = recommendLiveData.getRecommendItem().getContentRecommendLive();
        Object obj3 = "";
        if (contentRecommendLive == null) {
            obj = "";
        } else {
            obj = Long.valueOf(contentRecommendLive.getGuildId());
        }
        pairArr[1] = TuplesKt.to("sgrp_channel_id", obj.toString());
        IGProContentRecommendLive contentRecommendLive2 = recommendLiveData.getRecommendItem().getContentRecommendLive();
        if (contentRecommendLive2 == null) {
            obj2 = "";
        } else {
            obj2 = Long.valueOf(contentRecommendLive2.getChannelId());
        }
        pairArr[2] = TuplesKt.to("sgrp_sub_channel_id", obj2.toString());
        pairArr[3] = TuplesKt.to(JumpGuildParam.EXTRA_KEY_TRACE_ID, recommendLiveData.getRecommendExtData().getTraceId());
        IGProContentRecommendLive contentRecommendLive3 = recommendLiveData.getRecommendItem().getContentRecommendLive();
        if (contentRecommendLive3 != null) {
            obj3 = Long.valueOf(contentRecommendLive3.getRoomId());
        }
        pairArr[4] = TuplesKt.to("sgrp_live_room_id", obj3);
        pairArr[5] = TuplesKt.to("sgrp_trace_operate_json", u(recommendLiveData.getRecommendItem().getExtra().getReports()));
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        return mutableMapOf;
    }

    private static final Map<String, Object> E(RecommendRobotData recommendRobotData, int i3) {
        String str;
        Object obj;
        Map<String, Object> mutableMapOf;
        Pair[] pairArr = new Pair[7];
        IGProContentRecommendRobot robot = recommendRobotData.getRecommendItem().getRobot();
        String str2 = null;
        if (robot != null) {
            str = robot.getAppId();
        } else {
            str = null;
        }
        String str3 = "";
        if (str == null) {
            str = "";
        }
        pairArr[0] = TuplesKt.to("sgrp_robot_appid", str);
        IGProContentRecommendRobot robot2 = recommendRobotData.getRecommendItem().getRobot();
        if (robot2 == null) {
            obj = "";
        } else {
            obj = Long.valueOf(robot2.getRobotUin());
        }
        pairArr[1] = TuplesKt.to("sgrp_robot_uin", obj);
        IGProContentRecommendRobot robot3 = recommendRobotData.getRecommendItem().getRobot();
        if (robot3 != null) {
            str2 = robot3.getUid();
        }
        if (str2 != null) {
            str3 = str2;
        }
        pairArr[2] = TuplesKt.to("sgrp_robot_uid", str3);
        pairArr[3] = TuplesKt.to("sgrp_card_type", 0);
        pairArr[4] = TuplesKt.to(JumpGuildParam.EXTRA_KEY_TRACE_ID, recommendRobotData.getRecommendExtData().getTraceId());
        pairArr[5] = TuplesKt.to("sgrp_rank", Integer.valueOf(i3));
        pairArr[6] = TuplesKt.to("sgrp_trace_operate_json", u(recommendRobotData.getRecommendItem().getExtra().getReports()));
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        return mutableMapOf;
    }

    private static final Map<String, Object> F(RecommendSchemeData recommendSchemeData, int i3) {
        Map<String, Object> mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(JumpGuildParam.EXTRA_KEY_TRACE_ID, recommendSchemeData.getRecommendExtData().getTraceId()), TuplesKt.to("sgrp_rank", Integer.valueOf(i3)), TuplesKt.to("sgrp_trace_operate_json", u(recommendSchemeData.getRecommendItem().getExtra().getReports())));
        return mutableMapOf;
    }

    private static final Map<String, Object> G(RecommendScreenShareData recommendScreenShareData, int i3) {
        Object obj;
        Object obj2;
        String str;
        Map<String, Object> mutableMapOf;
        Pair[] pairArr = new Pair[7];
        pairArr[0] = TuplesKt.to("sgrp_rank", Integer.valueOf(i3));
        IGProContentRecommendVoice contentRecommendVoice = recommendScreenShareData.getRecommendItem().getContentRecommendVoice();
        Object obj3 = "";
        if (contentRecommendVoice == null) {
            obj = "";
        } else {
            obj = Long.valueOf(contentRecommendVoice.getGuildId());
        }
        pairArr[1] = TuplesKt.to("sgrp_channel_id", obj.toString());
        IGProContentRecommendVoice contentRecommendVoice2 = recommendScreenShareData.getRecommendItem().getContentRecommendVoice();
        if (contentRecommendVoice2 == null) {
            obj2 = "";
        } else {
            obj2 = Long.valueOf(contentRecommendVoice2.getChannelId());
        }
        pairArr[2] = TuplesKt.to("sgrp_sub_channel_id", obj2.toString());
        IGProContentRecommendVoice contentRecommendVoice3 = recommendScreenShareData.getRecommendItem().getContentRecommendVoice();
        if (contentRecommendVoice3 != null) {
            str = contentRecommendVoice3.getThemeSessionId();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        pairArr[3] = TuplesKt.to("sgrp_subchannel_session_id", str);
        IGProContentRecommendVoice contentRecommendVoice4 = recommendScreenShareData.getRecommendItem().getContentRecommendVoice();
        if (contentRecommendVoice4 != null) {
            obj3 = Integer.valueOf(contentRecommendVoice4.getThemeType());
        }
        pairArr[4] = TuplesKt.to("sgrp_content_card_type", obj3);
        pairArr[5] = TuplesKt.to(JumpGuildParam.EXTRA_KEY_TRACE_ID, recommendScreenShareData.getRecommendExtData().getTraceId());
        pairArr[6] = TuplesKt.to("sgrp_trace_operate_json", u(recommendScreenShareData.getRecommendItem().getExtra().getReports()));
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        return mutableMapOf;
    }

    private static final Map<String, Object> H(RecommendSelectedGuildData recommendSelectedGuildData, int i3) {
        Map<String, Object> mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("sgrp_rank", Integer.valueOf(i3)), TuplesKt.to(JumpGuildParam.EXTRA_KEY_TRACE_ID, recommendSelectedGuildData.getRecommendExtData().getTraceId()), TuplesKt.to("sgrp_trace_operate_json", u(recommendSelectedGuildData.getRecommendItem().getExtra().getReports())));
        return mutableMapOf;
    }

    private static final Map<String, Object> I(RecommendVoiceData recommendVoiceData, int i3) {
        Object obj;
        Object obj2;
        String str;
        Map<String, Object> mutableMapOf;
        Pair[] pairArr = new Pair[7];
        pairArr[0] = TuplesKt.to("sgrp_rank", Integer.valueOf(i3));
        IGProContentRecommendVoice contentRecommendVoice = recommendVoiceData.getRecommendItem().getContentRecommendVoice();
        Object obj3 = "";
        if (contentRecommendVoice == null) {
            obj = "";
        } else {
            obj = Long.valueOf(contentRecommendVoice.getGuildId());
        }
        pairArr[1] = TuplesKt.to("sgrp_channel_id", obj.toString());
        IGProContentRecommendVoice contentRecommendVoice2 = recommendVoiceData.getRecommendItem().getContentRecommendVoice();
        if (contentRecommendVoice2 == null) {
            obj2 = "";
        } else {
            obj2 = Long.valueOf(contentRecommendVoice2.getChannelId());
        }
        pairArr[2] = TuplesKt.to("sgrp_sub_channel_id", obj2.toString());
        IGProContentRecommendVoice contentRecommendVoice3 = recommendVoiceData.getRecommendItem().getContentRecommendVoice();
        if (contentRecommendVoice3 != null) {
            str = contentRecommendVoice3.getThemeSessionId();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        pairArr[3] = TuplesKt.to("sgrp_subchannel_session_id", str);
        IGProContentRecommendVoice contentRecommendVoice4 = recommendVoiceData.getRecommendItem().getContentRecommendVoice();
        if (contentRecommendVoice4 != null) {
            obj3 = Integer.valueOf(contentRecommendVoice4.getThemeType());
        }
        pairArr[4] = TuplesKt.to("sgrp_content_card_type", obj3);
        pairArr[5] = TuplesKt.to(JumpGuildParam.EXTRA_KEY_TRACE_ID, recommendVoiceData.getRecommendExtData().getTraceId());
        pairArr[6] = TuplesKt.to("sgrp_trace_operate_json", u(recommendVoiceData.getRecommendItem().getExtra().getReports()));
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        return mutableMapOf;
    }

    @NotNull
    public static final String b(@NotNull l<?> lVar) {
        Intrinsics.checkNotNullParameter(lVar, "<this>");
        if (lVar instanceof RecommendAbsFeedData) {
            return c((RecommendAbsFeedData) lVar);
        }
        if (lVar instanceof RecommendRobotData) {
            return k((RecommendRobotData) lVar);
        }
        if (lVar instanceof RecommendGroupData) {
            return g((RecommendGroupData) lVar);
        }
        if (lVar instanceof RecommendSchemeData) {
            return l((RecommendSchemeData) lVar);
        }
        if (lVar instanceof RecommendGuildData) {
            return h((RecommendGuildData) lVar);
        }
        if (lVar instanceof RecommendVoiceData) {
            return o((RecommendVoiceData) lVar);
        }
        if (lVar instanceof RecommendLiveData) {
            return j((RecommendLiveData) lVar);
        }
        if (lVar instanceof RecommendSelectedGuildData) {
            return n((RecommendSelectedGuildData) lVar);
        }
        if (lVar instanceof RecommendHotLiveData) {
            return i((RecommendHotLiveData) lVar);
        }
        if (lVar instanceof RecommendScreenShareData) {
            return m((RecommendScreenShareData) lVar);
        }
        if (lVar instanceof RecommendFeedTopicData) {
            return e((RecommendFeedTopicData) lVar);
        }
        if (lVar instanceof RecommendFeedsGuildData) {
            return f((RecommendFeedsGuildData) lVar);
        }
        if (lVar instanceof p) {
            return d((p) lVar);
        }
        return "";
    }

    private static final String c(RecommendAbsFeedData recommendAbsFeedData) {
        return "em_sgrp_forum_feed";
    }

    private static final String d(p pVar) {
        return "em_sgrp_ad_card";
    }

    private static final String e(RecommendFeedTopicData recommendFeedTopicData) {
        return "em_sgrp_discover_topic_module";
    }

    private static final String f(RecommendFeedsGuildData recommendFeedsGuildData) {
        return "em_sgrp_channel_and_forum_module";
    }

    private static final String g(RecommendGroupData recommendGroupData) {
        return "em_sgrp_group_recommend_card";
    }

    private static final String h(RecommendGuildData recommendGuildData) {
        return "em_sgrp_channel_single_card";
    }

    private static final String i(RecommendHotLiveData recommendHotLiveData) {
        return "em_sgrp_discover_wonderful_module";
    }

    private static final String j(RecommendLiveData recommendLiveData) {
        return "em_sgrp_nowplay_single_card";
    }

    private static final String k(RecommendRobotData recommendRobotData) {
        return "em_sgrp_robot_single_card";
    }

    private static final String l(RecommendSchemeData recommendSchemeData) {
        return "em_sgrp_font_size_card";
    }

    private static final String m(RecommendScreenShareData recommendScreenShareData) {
        return "em_sgrp_voice_single_card";
    }

    private static final String n(RecommendSelectedGuildData recommendSelectedGuildData) {
        return "em_sgrp_featured_channel_module";
    }

    private static final String o(RecommendVoiceData recommendVoiceData) {
        return "em_sgrp_voice_single_card";
    }

    @NotNull
    public static final IDynamicParams p(@NotNull final l<?> lVar, final int i3) {
        Intrinsics.checkNotNullParameter(lVar, "<this>");
        return new IDynamicParams() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.e
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map r16;
                r16 = RecommendReportHelperKt.r(l.this, i3, str);
                return r16;
            }
        };
    }

    public static /* synthetic */ IDynamicParams q(l lVar, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = 0;
        }
        return p(lVar, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map r(l data, int i3, String event) {
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullExpressionValue(event, "event");
        return t(event, data, i3);
    }

    @Nullable
    public static final Double s(@NotNull l<?> lVar) {
        Intrinsics.checkNotNullParameter(lVar, "<this>");
        if (lVar instanceof RecommendFeedsGuildData) {
            return Double.valueOf(0.3d);
        }
        return null;
    }

    @Nullable
    public static final Map<String, String> t(@NotNull String event, @NotNull l<?> data, int i3) {
        boolean z16;
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(data, "data");
        try {
        } catch (JSONException e16) {
            QLog.e("RecommendReportHelper", 1, e16.toString());
        }
        if (!Intrinsics.areEqual(event, "imp") && !Intrinsics.areEqual(event, "clck")) {
            return null;
        }
        byte[] tianShuAdItem = data.getRecommendExtData().getTianShuAdItem();
        if (tianShuAdItem.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            String str = new String(tianShuAdItem, Charsets.UTF_8);
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("iAdId");
            String traceInfo = jSONObject.optString(MiniGameCenterHippyFragment.EXTRA_KEY_AD_TRACE_INFO);
            QLog.d("TianShuAdReportHelper", 1, "data: " + data.getClass().getSimpleName() + " tianShuAdItem: " + str);
            bi1.a aVar = bi1.a.f28439a;
            String valueOf = String.valueOf(optInt);
            String traceId = data.getRecommendExtData().getTraceId();
            Intrinsics.checkNotNullExpressionValue(traceInfo, "traceInfo");
            return aVar.a(valueOf, traceId, traceInfo, i3);
        }
        return null;
    }

    private static final String u(ArrayList<IGProEntry> arrayList) {
        if (arrayList != null) {
            Iterator<IGProEntry> it = arrayList.iterator();
            while (it.hasNext()) {
                IGProEntry next = it.next();
                if (Intrinsics.areEqual(next.getKey(), "ukv")) {
                    byte[] value = next.getValue();
                    Intrinsics.checkNotNullExpressionValue(value, "info.value");
                    return new String(value, Charsets.UTF_8);
                }
            }
            return "";
        }
        return "";
    }

    @NotNull
    public static final Map<String, Object> v(@NotNull l<?> lVar, int i3) {
        Intrinsics.checkNotNullParameter(lVar, "<this>");
        if (lVar instanceof RecommendAbsFeedData) {
            return w((RecommendAbsFeedData) lVar, i3);
        }
        if (lVar instanceof RecommendRobotData) {
            return E((RecommendRobotData) lVar, i3);
        }
        if (lVar instanceof RecommendGroupData) {
            return A((RecommendGroupData) lVar, i3);
        }
        if (lVar instanceof RecommendSchemeData) {
            return F((RecommendSchemeData) lVar, i3);
        }
        if (lVar instanceof RecommendGuildData) {
            return B((RecommendGuildData) lVar, i3);
        }
        if (lVar instanceof RecommendVoiceData) {
            return I((RecommendVoiceData) lVar, i3);
        }
        if (lVar instanceof RecommendLiveData) {
            return D((RecommendLiveData) lVar, i3);
        }
        if (lVar instanceof RecommendSelectedGuildData) {
            return H((RecommendSelectedGuildData) lVar, i3);
        }
        if (lVar instanceof RecommendHotLiveData) {
            return C((RecommendHotLiveData) lVar, i3);
        }
        if (lVar instanceof RecommendScreenShareData) {
            return G((RecommendScreenShareData) lVar, i3);
        }
        if (lVar instanceof RecommendFeedTopicData) {
            return y((RecommendFeedTopicData) lVar, i3);
        }
        if (lVar instanceof RecommendFeedsGuildData) {
            return z((RecommendFeedsGuildData) lVar, i3);
        }
        if (lVar instanceof p) {
            return x((p) lVar, i3);
        }
        return new LinkedHashMap();
    }

    private static final Map<String, Object> w(RecommendAbsFeedData recommendAbsFeedData, int i3) {
        Object obj;
        Object obj2;
        ArrayList<IGProEntry> arrayList;
        Map<String, Object> mutableMapOf;
        Pair[] pairArr = new Pair[8];
        IGProFeedGuildInfo guildInfo = recommendAbsFeedData.getGuildInfo();
        String str = "";
        if (guildInfo == null) {
            obj = "";
        } else {
            obj = Long.valueOf(guildInfo.getGuildId());
        }
        pairArr[0] = TuplesKt.to("sgrp_channel_id", obj.toString());
        IGProFeedGuildInfo guildInfo2 = recommendAbsFeedData.getGuildInfo();
        if (guildInfo2 == null) {
            obj2 = "";
        } else {
            obj2 = Long.valueOf(guildInfo2.getChannelId());
        }
        pairArr[1] = TuplesKt.to("sgrp_sub_channel_id", obj2.toString());
        String idd = recommendAbsFeedData.getIdd();
        if (idd == null) {
            idd = "";
        }
        pairArr[2] = TuplesKt.to("sgrp_content_id", idd);
        String idd2 = recommendAbsFeedData.getIdd();
        if (idd2 != null) {
            str = idd2;
        }
        pairArr[3] = TuplesKt.to("sgrp_feed_id", str);
        pairArr[4] = TuplesKt.to(JumpGuildParam.EXTRA_KEY_TRACE_ID, recommendAbsFeedData.getRecommendExtData().getTraceId());
        pairArr[5] = TuplesKt.to("sgrp_rank", Integer.valueOf(i3));
        pairArr[6] = TuplesKt.to("sgrp_insert_sign", Integer.valueOf(recommendAbsFeedData.isInsertSign() ? 1 : 0));
        IGProExtra gProExtra = recommendAbsFeedData.getRecommendExtData().getGProExtra();
        if (gProExtra != null) {
            arrayList = gProExtra.getReports();
        } else {
            arrayList = null;
        }
        pairArr[7] = TuplesKt.to("sgrp_trace_operate_json", u(arrayList));
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        return mutableMapOf;
    }

    private static final Map<String, Object> x(p pVar, int i3) {
        int i16;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i17 = 1;
        QLog.d("TianShuAdReportHelper", 1, "adInfo " + pVar.getAdInfo());
        if (pVar.getAdInfo() != null) {
            if (pVar.getAdInfo().isContractAd()) {
                i16 = 2;
            } else {
                i16 = 1;
            }
            linkedHashMap.put("sgrp_ad_type", Integer.valueOf(i16));
            linkedHashMap.put("sgrp_ad_space_id", String.valueOf(pVar.getAdInfo().getPosId()));
            linkedHashMap.put("sgrp_ad_id", String.valueOf(pVar.getAdInfo().getAId()));
            if (pVar.getAdInfo().getInnerShowType() == 3 || pVar.getAdInfo().getInnerShowType() == 4) {
                i17 = 2;
            }
            linkedHashMap.put("sgrp_ad_content_type", Integer.valueOf(i17));
            linkedHashMap.put("sgrp_ad_trace_id", String.valueOf(pVar.getAdInfo().getTraceId()));
            linkedHashMap.put("sgrp_rank", Integer.valueOf(i3));
        }
        return linkedHashMap;
    }

    private static final Map<String, Object> y(RecommendFeedTopicData recommendFeedTopicData, int i3) {
        Map<String, Object> mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("sgrp_rank", Integer.valueOf(i3)), TuplesKt.to(JumpGuildParam.EXTRA_KEY_TRACE_ID, recommendFeedTopicData.getRecommendExtData().getTraceId()));
        return mutableMapOf;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0073, code lost:
    
        r13 = kotlin.collections.CollectionsKt___CollectionsKt.joinToString$default(r4, " \u00b7 ", null, null, 0, null, com.tencent.mobileqq.guild.discoveryv2.content.recommend.RecommendReportHelperKt$reportParams$1.INSTANCE, 30, null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final Map<String, Object> z(RecommendFeedsGuildData recommendFeedsGuildData, int i3) {
        Object firstOrNull;
        Object obj;
        Object firstOrNull2;
        Map<String, Object> mutableMapOf;
        String joinToString$default;
        IGProFeedGuildInfo guildInfo;
        Pair[] pairArr = new Pair[4];
        ArrayList<IGProContentRecommendFeed> feeds = recommendFeedsGuildData.getRecommendItem().getFeeds();
        Intrinsics.checkNotNullExpressionValue(feeds, "recommendItem.feeds");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) feeds);
        IGProContentRecommendFeed iGProContentRecommendFeed = (IGProContentRecommendFeed) firstOrNull;
        String str = "";
        if (iGProContentRecommendFeed == null || (guildInfo = iGProContentRecommendFeed.getGuildInfo()) == null) {
            obj = "";
        } else {
            obj = Long.valueOf(guildInfo.getGuildId());
        }
        pairArr[0] = TuplesKt.to("sgrp_channel_id", obj.toString());
        pairArr[1] = TuplesKt.to(JumpGuildParam.EXTRA_KEY_TRACE_ID, recommendFeedsGuildData.getRecommendExtData().getTraceId());
        pairArr[2] = TuplesKt.to("sgrp_rank", Integer.valueOf(i3));
        ArrayList<IGProContentRecommendFeed> feeds2 = recommendFeedsGuildData.getRecommendItem().getFeeds();
        Intrinsics.checkNotNullExpressionValue(feeds2, "recommendItem.feeds");
        firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) feeds2);
        IGProContentRecommendFeed iGProContentRecommendFeed2 = (IGProContentRecommendFeed) firstOrNull2;
        if (iGProContentRecommendFeed2 != null && (r4 = iGProContentRecommendFeed2.getTags()) != null && joinToString$default != null) {
            str = joinToString$default;
        }
        pairArr[3] = TuplesKt.to("sgrp_explicit_tag", str);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        return mutableMapOf;
    }
}
