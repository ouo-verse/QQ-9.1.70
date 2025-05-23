package com.tencent.mobileqq.guild.discover.recommend.miniapp;

import android.app.Activity;
import android.content.Context;
import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildDiscoverRecommendApi;
import com.tencent.mobileqq.guild.api.IGuildMiniProgramApi;
import com.tencent.mobileqq.guild.data.GuildFeedJumpData;
import com.tencent.mobileqq.guild.data.GuildJumpBaseData;
import com.tencent.mobileqq.guild.data.GuildJumpData;
import com.tencent.mobileqq.guild.data.GuildLiveJumpData;
import com.tencent.mobileqq.guild.data.GuildScheduleJumpData;
import com.tencent.mobileqq.guild.discover.f;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.mini.api.IMiniContainer;
import com.tencent.mobileqq.mini.servlet.GetGuildJoinUrlServlet;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.cg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@JsPlugin
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007J\n\u0010\u0011\u001a\u00020\u0010*\u00020\bJ\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/discover/recommend/miniapp/n;", "Lcom/tencent/qqmini/sdk/launcher/core/plugins/BaseJsPlugin;", "Lorg/json/JSONObject;", "data", "Lcom/tencent/mobileqq/guild/data/d;", "jumpBean", "", "l", "Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;", "req", "requestAddGuild", "openNativePageFromContainer", "requestAddGuildForFeed", "jumpToGuild", "jumpToC2C", "jumpToChannel", "", "r", "jumpToLiveRoom", "openYoloSharePanel", "openYoloSelfGuild", "jumpToFeed", "jumpToWebBrowser", "jumpToSchedule", "getPreloadData", "getJoinedGuildCount", "getBannerData", "<init>", "()V", "d", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class n extends BaseJsPlugin {
    private final void l(JSONObject data, GuildJumpBaseData jumpBean) {
        jumpBean.k(data.optString("guild_id"));
        jumpBean.j(data.optString("channel_id"));
        jumpBean.l(data.optString("join_sign"));
        String optString = data.optString("main_source");
        Intrinsics.checkNotNullExpressionValue(optString, "data.optString(PARAM_MAIN_SOURCE)");
        jumpBean.m(optString);
        String optString2 = data.optString("sub_source");
        Intrinsics.checkNotNullExpressionValue(optString2, "data.optString(PARAM_SUB_SOURCE)");
        jumpBean.o(optString2);
        String optString3 = data.optString("c2c_tiny_id");
        Intrinsics.checkNotNullExpressionValue(optString3, "data.optString(PARAM_C2C_TINY_ID)");
        jumpBean.i(optString3);
        String optString4 = data.optString("c2c_src_name");
        Intrinsics.checkNotNullExpressionValue(optString4, "data.optString(PARAM_C2C_SRC_NAME)");
        jumpBean.h(optString4);
        String optString5 = data.optString("pgin_source");
        Intrinsics.checkNotNullExpressionValue(optString5, "data.optString(PARAM_PGIN_SOURCE)");
        jumpBean.n(optString5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(String guildId, String c2cTinyId, String c2cNickName, String pginSource) {
        c cVar = new c();
        Intrinsics.checkNotNullExpressionValue(guildId, "guildId");
        Intrinsics.checkNotNullExpressionValue(c2cTinyId, "c2cTinyId");
        Intrinsics.checkNotNullExpressionValue(c2cNickName, "c2cNickName");
        Intrinsics.checkNotNullExpressionValue(pginSource, "pginSource");
        cVar.e(guildId, c2cTinyId, c2cNickName, pginSource);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(GuildFeedJumpData jumpBean) {
        Intrinsics.checkNotNullParameter(jumpBean, "$jumpBean");
        ((IGuildMiniProgramApi) QRoute.api(IGuildMiniProgramApi.class)).jumpToFeed(jumpBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(GuildJumpData jumpBean) {
        Intrinsics.checkNotNullParameter(jumpBean, "$jumpBean");
        ((IGuildMiniProgramApi) QRoute.api(IGuildMiniProgramApi.class)).jumpToGuild(jumpBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(GuildLiveJumpData jumpBean) {
        Intrinsics.checkNotNullParameter(jumpBean, "$jumpBean");
        ((IGuildMiniProgramApi) QRoute.api(IGuildMiniProgramApi.class)).jumpToLiveRoom(jumpBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(GuildScheduleJumpData jumpBean) {
        Intrinsics.checkNotNullParameter(jumpBean, "$jumpBean");
        ((IGuildMiniProgramApi) QRoute.api(IGuildMiniProgramApi.class)).jumpToSchedule(jumpBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(JumpGuildParam jumpGuildParam) {
        Intrinsics.checkNotNullParameter(jumpGuildParam, "$jumpGuildParam");
        GuildYoloJoinHelper.a(jumpGuildParam);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(GuildJumpBaseData jumpBean, final RequestEvent req) {
        Intrinsics.checkNotNullParameter(jumpBean, "$jumpBean");
        Intrinsics.checkNotNullParameter(req, "$req");
        ((IGuildMiniProgramApi) QRoute.api(IGuildMiniProgramApi.class)).joinGuild(jumpBean, new Runnable() { // from class: com.tencent.mobileqq.guild.discover.recommend.miniapp.l
            @Override // java.lang.Runnable
            public final void run() {
                n.u(RequestEvent.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(RequestEvent req) {
        Intrinsics.checkNotNullParameter(req, "$req");
        req.ok(new JSONObject("{\"success\":true}"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(JumpGuildParam jumpGuildParam, final RequestEvent req) {
        Intrinsics.checkNotNullParameter(jumpGuildParam, "$jumpGuildParam");
        Intrinsics.checkNotNullParameter(req, "$req");
        f.Companion companion = com.tencent.mobileqq.guild.discover.f.INSTANCE;
        Context i3 = ch.i();
        Intrinsics.checkNotNullExpressionValue(i3, "appContext()");
        f.Companion.c(companion, i3, jumpGuildParam, false, false, new Runnable() { // from class: com.tencent.mobileqq.guild.discover.recommend.miniapp.m
            @Override // java.lang.Runnable
            public final void run() {
                n.w(RequestEvent.this);
            }
        }, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(RequestEvent req) {
        Intrinsics.checkNotNullParameter(req, "$req");
        req.ok(new JSONObject("{\"success\":true}"));
    }

    @JsEvent({"getDiscoverBanner"})
    public final void getBannerData(@NotNull RequestEvent req) {
        Intrinsics.checkNotNullParameter(req, "req");
        QLog.d("Guild.jump.JS.GuildDiscoverPlugin", 1, "[getBannerData] " + req);
        req.ok(((IGuildDiscoverRecommendApi) QRoute.api(IGuildDiscoverRecommendApi.class)).getBannerData());
    }

    @JsEvent({"getJoinedGuildCount"})
    public final void getJoinedGuildCount(@NotNull RequestEvent req) {
        Intrinsics.checkNotNullParameter(req, "req");
        QLog.i("Guild.jump.JS.GuildDiscoverPlugin", 1, "[getJoinedGuildCount] " + r(req));
        req.ok(new JSONObject("{\"count\":" + ((IGuildMiniProgramApi) QRoute.api(IGuildMiniProgramApi.class)).getJoinedGuildCount() + "}"));
    }

    @JsEvent({"getPreloadData"})
    public final void getPreloadData(@NotNull RequestEvent req) {
        Intrinsics.checkNotNullParameter(req, "req");
        QLog.i("Guild.jump.JS.GuildDiscoverPlugin", 1, "[getPreloadData] " + r(req));
        req.fail();
    }

    @JsEvent({"jumpToC2C"})
    public final void jumpToC2C(@NotNull RequestEvent req) {
        Intrinsics.checkNotNullParameter(req, "req");
        JSONObject optJSONObject = new JSONObject(req.jsonParams).optJSONObject("data");
        if (optJSONObject == null) {
            req.fail("data is invalid");
            return;
        }
        Logger.f235387a.d().i("Guild.jump.JS.GuildDiscoverPlugin", 1, "jumpToC2C " + r(req));
        final String optString = optJSONObject.optString("guild_id");
        final String optString2 = optJSONObject.optString("c2c_tiny_id");
        final String optString3 = optJSONObject.optString("c2c_src_name");
        final String optString4 = optJSONObject.optString("pgin_source");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.discover.recommend.miniapp.f
            @Override // java.lang.Runnable
            public final void run() {
                n.m(optString, optString2, optString3, optString4);
            }
        });
    }

    @JsEvent({"jumpToChannel"})
    public final void jumpToChannel(@NotNull RequestEvent req) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        Intrinsics.checkNotNullParameter(req, "req");
        boolean z27 = true;
        Logger.f235387a.d().i("Guild.jump.JS.GuildDiscoverPlugin", 1, "jumpToChannel " + r(req));
        JSONObject optJSONObject = new JSONObject(req.jsonParams).optJSONObject("data");
        if (optJSONObject == null) {
            req.fail("data is invalid");
            return;
        }
        JumpGuildParam jumpGuildParam = new JumpGuildParam(optJSONObject.optString("guild_id", ""), optJSONObject.optString("channel_id", ""), optJSONObject.optString("join_sign", ""), optJSONObject.optString("main_source", ""), optJSONObject.optString("sub_source", ""));
        GuildAppReportSourceInfo guildAppReportSourceInfo = new GuildAppReportSourceInfo();
        guildAppReportSourceInfo.addReportItem("sgrp_stream_pgin_source_name", optJSONObject.optString("pgin_source", ""));
        guildAppReportSourceInfo.addReportItem(JumpGuildParam.EXTRA_KEY_TRACE_ID, optJSONObject.optString("trace_id", ""));
        jumpGuildParam.setReportSourceInfo(guildAppReportSourceInfo);
        String str = jumpGuildParam.guildId;
        Intrinsics.checkNotNullExpressionValue(str, "jumpGuildParam.guildId");
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            String channelId = jumpGuildParam.getChannelId();
            Intrinsics.checkNotNullExpressionValue(channelId, "jumpGuildParam.channelId");
            if (channelId.length() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                String joinSignature = jumpGuildParam.getJoinSignature();
                Intrinsics.checkNotNullExpressionValue(joinSignature, "jumpGuildParam.joinSignature");
                if (joinSignature.length() == 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (!z18) {
                    String mainSource = jumpGuildParam.getMainSource();
                    Intrinsics.checkNotNullExpressionValue(mainSource, "jumpGuildParam.mainSource");
                    if (mainSource.length() == 0) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    if (!z19) {
                        String subSource = jumpGuildParam.getSubSource();
                        Intrinsics.checkNotNullExpressionValue(subSource, "jumpGuildParam.subSource");
                        if (subSource.length() == 0) {
                            z26 = true;
                        } else {
                            z26 = false;
                        }
                        if (!z26) {
                            if (!optJSONObject.optBoolean("openInGuildTab") || d12.a.c()) {
                                z27 = false;
                            }
                            if (z27) {
                                BaseApplication baseApplication = BaseApplication.context;
                                String str2 = jumpGuildParam.guildId;
                                Intrinsics.checkNotNullExpressionValue(str2, "jumpGuildParam.guildId");
                                GuildJumpUtil.z(baseApplication, str2, jumpGuildParam.getChannelId(), jumpGuildParam.getReportSourceInfo(), null, 16, null);
                                return;
                            }
                            Activity attachActivity = this.mMiniAppContext.getAttachActivity();
                            Intrinsics.checkNotNullExpressionValue(attachActivity, "mMiniAppContext.attachedActivity");
                            GuildJumpUtil.n(attachActivity, jumpGuildParam);
                            return;
                        }
                    }
                }
            }
        }
        String str3 = "params is ilLegal, params = " + jumpGuildParam;
        Logger.b bVar = new Logger.b();
        if (str3 instanceof String) {
            bVar.a().add(str3);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("Guild.jump.JS.GuildDiscoverPlugin", 1, (String) it.next(), null);
        }
        req.fail(str3);
    }

    @JsEvent({"jumpToFeed"})
    public final void jumpToFeed(@NotNull RequestEvent req) {
        Intrinsics.checkNotNullParameter(req, "req");
        boolean z16 = true;
        QLog.i("Guild.jump.JS.GuildDiscoverPlugin", 1, "[jumpToFeed] " + r(req));
        JSONObject optJSONObject = new JSONObject(req.jsonParams).optJSONObject("data");
        if (optJSONObject == null) {
            req.fail("data is invalid");
            return;
        }
        final GuildFeedJumpData guildFeedJumpData = new GuildFeedJumpData();
        l(optJSONObject, guildFeedJumpData);
        guildFeedJumpData.y(optJSONObject.optString("poster_tiny_id"));
        guildFeedJumpData.x(optJSONObject.optString("feed_id"));
        guildFeedJumpData.w(optJSONObject.optLong(AlbumCacheData.CREATE_TIME));
        guildFeedJumpData.z(optJSONObject.optInt("share_source", -1));
        guildFeedJumpData.A(optJSONObject.optString(GetGuildJoinUrlServlet.BUNDLE_KEY_URL));
        String optString = optJSONObject.optString("trace_id", "");
        Intrinsics.checkNotNullExpressionValue(optString, "data.optString(PARAM_TRACE_ID, \"\")");
        guildFeedJumpData.B(optString);
        String optString2 = optJSONObject.optString("pgin_source", "");
        Intrinsics.checkNotNullExpressionValue(optString2, "data.optString(PARAM_PGIN_SOURCE, \"\")");
        guildFeedJumpData.n(optString2);
        if (guildFeedJumpData.v()) {
            String str = "params is ilLegal, params = " + guildFeedJumpData;
            req.fail(str);
            QLog.e("Guild.jump.JS.GuildDiscoverPlugin", 1, str);
            return;
        }
        if (!optJSONObject.optBoolean("openInGuildTab") || d12.a.c()) {
            z16 = false;
        }
        if (z16) {
            String guildId = guildFeedJumpData.getGuildId();
            Intrinsics.checkNotNull(guildId);
            String channelId = guildFeedJumpData.getChannelId();
            Intrinsics.checkNotNull(channelId);
            JumpGuildParam jumpGuildParam = new JumpGuildParam(guildId, channelId);
            jumpGuildParam.extras.putString("PGIN_SOURCE_REPORT_KEY", optJSONObject.optString("pgin_source", ""));
            jumpGuildParam.setDetailPageJumpInfo(new JumpGuildParam.ChannelDetailPageJumpInfo(guildFeedJumpData.getFeedId()));
            jumpGuildParam.businessType = 2;
            Context i3 = ch.i();
            Intrinsics.checkNotNullExpressionValue(i3, "appContext()");
            GuildJumpUtil.n(i3, jumpGuildParam);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.discover.recommend.miniapp.h
                @Override // java.lang.Runnable
                public final void run() {
                    n.n(GuildFeedJumpData.this);
                }
            });
        }
        req.ok();
    }

    @JsEvent({"jumpToGuild"})
    public final void jumpToGuild(@NotNull RequestEvent req) {
        Intrinsics.checkNotNullParameter(req, "req");
        QLog.i("Guild.jump.JS.GuildDiscoverPlugin", 1, "[jumpToGuild] " + r(req));
        JSONObject optJSONObject = new JSONObject(req.jsonParams).optJSONObject("data");
        if (optJSONObject == null) {
            req.fail("data is invalid");
            return;
        }
        final GuildJumpData guildJumpData = new GuildJumpData();
        l(optJSONObject, guildJumpData);
        guildJumpData.v(optJSONObject.optString("guild_icon"));
        guildJumpData.w(optJSONObject.optString("guild_name"));
        guildJumpData.u(optJSONObject.optString("guild_cover_url"));
        String optString = optJSONObject.optString("trace_id");
        Intrinsics.checkNotNullExpressionValue(optString, "data.optString(PARAM_TRACE_ID)");
        guildJumpData.x(optString);
        String optString2 = optJSONObject.optString("pgin_source");
        Intrinsics.checkNotNullExpressionValue(optString2, "data.optString(PARAM_PGIN_SOURCE)");
        guildJumpData.n(optString2);
        if (guildJumpData.t()) {
            String str = "params is ilLegal, params = " + guildJumpData;
            req.fail(str);
            QLog.e("Guild.jump.JS.GuildDiscoverPlugin", 1, str);
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.discover.recommend.miniapp.d
            @Override // java.lang.Runnable
            public final void run() {
                n.o(GuildJumpData.this);
            }
        });
        req.ok();
    }

    @JsEvent({"jumpToLiveRoom"})
    public final void jumpToLiveRoom(@NotNull RequestEvent req) {
        Intrinsics.checkNotNullParameter(req, "req");
        QLog.d("Guild.jump.JS.GuildDiscoverPlugin", 1, "[jumpToLiveRoom] " + r(req));
        JSONObject optJSONObject = new JSONObject(req.jsonParams).optJSONObject("data");
        if (optJSONObject == null) {
            req.fail("data is invalid");
            return;
        }
        final GuildLiveJumpData guildLiveJumpData = new GuildLiveJumpData();
        l(optJSONObject, guildLiveJumpData);
        guildLiveJumpData.y(optJSONObject.optString("guild_name"));
        guildLiveJumpData.B(optJSONObject.optString("live_room_name"));
        guildLiveJumpData.C(optJSONObject.optString("live_stream_url"));
        guildLiveJumpData.z(optJSONObject.optString("live_anchor_id"));
        guildLiveJumpData.A(optJSONObject.optLong("live_room_id", -1L));
        guildLiveJumpData.x(optJSONObject.optInt("enter_source", -1));
        String optString = optJSONObject.optString("trace_id", "");
        Intrinsics.checkNotNullExpressionValue(optString, "data.optString(PARAM_TRACE_ID, \"\")");
        guildLiveJumpData.D(optString);
        String optString2 = optJSONObject.optString("pgin_source", "");
        Intrinsics.checkNotNullExpressionValue(optString2, "data.optString(PARAM_PGIN_SOURCE, \"\")");
        guildLiveJumpData.n(optString2);
        if (guildLiveJumpData.w()) {
            String str = "params is ilLegal, params = " + guildLiveJumpData;
            req.fail(str);
            QLog.e("Guild.jump.JS.GuildDiscoverPlugin", 1, str);
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.discover.recommend.miniapp.k
            @Override // java.lang.Runnable
            public final void run() {
                n.p(GuildLiveJumpData.this);
            }
        });
        req.ok();
    }

    @JsEvent({"jumpoGuilToSchedule"})
    public final void jumpToSchedule(@NotNull RequestEvent req) {
        Intrinsics.checkNotNullParameter(req, "req");
        QLog.i("Guild.jump.JS.GuildDiscoverPlugin", 1, "[jumpToSchedule] " + req);
        JSONObject optJSONObject = new JSONObject(req.jsonParams).optJSONObject("data");
        if (optJSONObject == null) {
            req.fail("data is invalid");
            return;
        }
        final GuildScheduleJumpData guildScheduleJumpData = new GuildScheduleJumpData();
        l(optJSONObject, guildScheduleJumpData);
        guildScheduleJumpData.u(optJSONObject.optString("schedule_id"));
        guildScheduleJumpData.v(optJSONObject.optString(GetGuildJoinUrlServlet.BUNDLE_KEY_URL));
        guildScheduleJumpData.t(optJSONObject.optInt("enter_source", -1));
        if (guildScheduleJumpData.s()) {
            String str = "params is ilLegal, params = " + guildScheduleJumpData;
            req.fail(str);
            QLog.e("Guild.jump.JS.GuildDiscoverPlugin", 1, str);
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.discover.recommend.miniapp.g
            @Override // java.lang.Runnable
            public final void run() {
                n.q(GuildScheduleJumpData.this);
            }
        });
        req.ok();
    }

    @JsEvent({"jumpToWebBrowser"})
    public final void jumpToWebBrowser(@NotNull RequestEvent req) {
        Intrinsics.checkNotNullParameter(req, "req");
        QLog.i("Guild.jump.JS.GuildDiscoverPlugin", 1, "[jumpToWebBrowser] " + req);
        JSONObject optJSONObject = new JSONObject(req.jsonParams).optJSONObject("data");
        if (optJSONObject == null) {
            req.fail("data is invalid");
            QLog.i("Guild.jump.JS.GuildDiscoverPlugin", 1, "[jumpToWebBrowser] data is null");
            return;
        }
        String optString = optJSONObject.optString("url");
        if (!cg.f307525d.matcher(optString).matches()) {
            req.fail("url is invalid");
            QLog.i("Guild.jump.JS.GuildDiscoverPlugin", 1, "[jumpToWebBrowser] url is invalid, url = " + optString);
            return;
        }
        ((IGuildMiniProgramApi) QRoute.api(IGuildMiniProgramApi.class)).jumpToWebBrowser(optString);
        req.ok();
    }

    @JsEvent({"openNativePageFromContainer"})
    public final void openNativePageFromContainer(@NotNull RequestEvent req) {
        Intrinsics.checkNotNullParameter(req, "req");
        QLog.d("Guild.jump.JS.GuildDiscoverPlugin", 1, "[openNativePageFromContainer], jsonParams:" + req.jsonParams);
        try {
            ((IMiniContainer) QRoute.api(IMiniContainer.class)).launchPage(this.mContext, new JSONObject(req.jsonParams).optString(ZPlanPublishSource.FROM_SCHEME));
            req.ok();
        } catch (Exception e16) {
            QLog.e("Guild.jump.JS.GuildDiscoverPlugin", 1, e16, new Object[0]);
            req.fail();
        }
    }

    @JsEvent({"openYoloSelfGuild"})
    public final void openYoloSelfGuild(@NotNull RequestEvent req) {
        Intrinsics.checkNotNullParameter(req, "req");
        QLog.i("Guild.jump.JS.GuildDiscoverPlugin", 1, "[openYoloSelfGuild] " + req.jsonParams);
        JSONObject optJSONObject = new JSONObject(req.jsonParams).optJSONObject("data");
        if (optJSONObject == null) {
            req.fail("data is invalid");
            return;
        }
        final JumpGuildParam jumpGuildParam = new JumpGuildParam(optJSONObject.optString("guildId"), "", optJSONObject.optString("joinSignature"), optJSONObject.optString("mainSource"), optJSONObject.optString("subSource"));
        jumpGuildParam.extras.putInt("entranceId", optJSONObject.optInt("entranceId", 4));
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.discover.recommend.miniapp.j
            @Override // java.lang.Runnable
            public final void run() {
                n.s(JumpGuildParam.this);
            }
        });
        req.ok();
    }

    @Deprecated(message = "Yolo\u4e0b\u7ebf")
    @JsEvent({"openYoloSharePanel"})
    public final void openYoloSharePanel(@NotNull RequestEvent req) {
        Intrinsics.checkNotNullParameter(req, "req");
        QLog.i("Guild.jump.JS.GuildDiscoverPlugin", 1, "[openYoloSharePanel] " + req.jsonParams);
        req.ok();
    }

    @NotNull
    public final String r(@NotNull RequestEvent requestEvent) {
        Intrinsics.checkNotNullParameter(requestEvent, "<this>");
        return "event: " + requestEvent.event + " | jsonParams: " + requestEvent.jsonParams;
    }

    @JsEvent({"requestAddGuild"})
    public final void requestAddGuild(@NotNull final RequestEvent req) {
        Intrinsics.checkNotNullParameter(req, "req");
        JSONObject optJSONObject = new JSONObject(req.jsonParams).optJSONObject("data");
        if (optJSONObject == null) {
            req.fail("data is invalid");
            QLog.w("Guild.jump.JS.GuildDiscoverPlugin", 1, "[requestAddGuild] data is invalid");
            return;
        }
        QLog.d("Guild.jump.JS.GuildDiscoverPlugin", 1, "[requestAddGuild] " + optJSONObject);
        final GuildJumpBaseData guildJumpBaseData = new GuildJumpBaseData();
        l(optJSONObject, guildJumpBaseData);
        if (guildJumpBaseData.g()) {
            String str = "params is ilLegal, params = " + guildJumpBaseData;
            req.fail(str);
            QLog.e("Guild.jump.JS.GuildDiscoverPlugin", 1, str);
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.discover.recommend.miniapp.i
            @Override // java.lang.Runnable
            public final void run() {
                n.t(GuildJumpBaseData.this, req);
            }
        });
    }

    @JsEvent({"requestAddGuildForFeed"})
    public final void requestAddGuildForFeed(@NotNull final RequestEvent req) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(req, "req");
        JSONObject jSONObject = new JSONObject(req.jsonParams);
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        boolean z18 = true;
        if (optJSONObject == null) {
            req.fail("requestAddGuildForFeed data is invalid");
            QLog.w("Guild.jump.JS.GuildDiscoverPlugin", 1, "[requestAddGuildForFeed] data is invalid");
            return;
        }
        QLog.d("Guild.jump.JS.GuildDiscoverPlugin", 1, "[requestAddGuildForFeed] " + optJSONObject);
        String optString = optJSONObject.optString("guild_id");
        String optString2 = optJSONObject.optString("channel_id");
        String optString3 = optJSONObject.optString("join_sign");
        if (optString != null && optString.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            if (optString3 != null && optString3.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17) {
                String optString4 = optJSONObject.optString("main_source");
                String optString5 = optJSONObject.optString("sub_source");
                String optString6 = optJSONObject.optString("feed_id");
                optJSONObject.optLong(AlbumCacheData.CREATE_TIME);
                optJSONObject.optString("poster_tiny_id");
                optJSONObject.optInt("share_source");
                int optInt = optJSONObject.optInt("entranceId");
                String optString7 = optJSONObject.optString("pgin_source");
                final JumpGuildParam jumpGuildParam = new JumpGuildParam(optString, optString2, optString3, optString4, optString5);
                jumpGuildParam.extras.putString("PGIN_SOURCE_REPORT_KEY", optString7);
                if (optString6 != null && optString6.length() != 0) {
                    z18 = false;
                }
                if (!z18) {
                    jumpGuildParam.setDetailPageJumpInfo(new JumpGuildParam.ChannelDetailPageJumpInfo(optString6));
                    jumpGuildParam.businessType = 2;
                }
                jumpGuildParam.getJoinInfoParam().setPageEntranceId(optInt);
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.discover.recommend.miniapp.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        n.v(JumpGuildParam.this, req);
                    }
                });
                return;
            }
        }
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        bVar.a().add("requestAddGuildForFeed empty params key/joinSig");
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("Guild.jump.JS.GuildDiscoverPlugin", 1, (String) it.next(), null);
        }
        req.fail("params is ilLegal, params = " + jSONObject);
    }
}
