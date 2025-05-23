package com.tencent.mobileqq.guild.performance.report;

import androidx.exifinterface.media.ExifInterface;
import com.hihonor.honorid.core.data.UserInfo;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.avcore.netchannel.INetChannelCallback;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.performance.report.z;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.tianjige.GuildCounterNames;
import com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bA\u0010BJ\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005J\u001e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0005J\u000e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010J&\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0002J\u001e\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0002J\u001e\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0002J\u0006\u0010\u0017\u001a\u00020\u0007J\u001e\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0002J\u000e\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0010J\u000e\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0005J\u0006\u0010\u001d\u001a\u00020\u0007J\u000e\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0005J\u001e\u0010!\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0002J&\u0010$\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0002J\u0016\u0010%\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0002J\u0016\u0010&\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0002J\u000e\u0010(\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u0005J\u0016\u0010)\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0002J\u0016\u0010*\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0002J\u000e\u0010,\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0005J\u001e\u0010-\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0002J:\u00104\u001a\u00020\u00072\u0006\u0010/\u001a\u00020.2\"\u00102\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000200j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`12\u0006\u00103\u001a\u00020\u0010JB\u00106\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u00022\u0006\u0010/\u001a\u00020.2\"\u00102\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000200j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`12\u0006\u00103\u001a\u00020\u0010J\u001a\u00109\u001a\u00020\u00072\b\u00107\u001a\u0004\u0018\u00010\u00022\b\u00108\u001a\u0004\u0018\u00010\u0002J\b\u0010:\u001a\u00020\u0002H\u0016J\b\u0010;\u001a\u00020\u0002H\u0016R\u0017\u0010@\u001a\u00020<8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010=\u001a\u0004\b>\u0010?\u00a8\u0006C"}, d2 = {"Lcom/tencent/mobileqq/guild/performance/report/aa;", "Lcom/tencent/mobileqq/guild/performance/report/a;", "", "guildId", "channelId", "", "channelType", "", "H", "t", "themeType", "o", "ret", "errMsg", UserInfo.USERSTATE, BdhLogUtil.LogTag.Tag_Conn, "", "isAgree", "B", "tinyId", "k", "l", "i", "E", "optMicEnable", "D", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "optRouteType", com.heytap.databaseengine.model.UserInfo.SEX_FEMALE, "j", "modeType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "optEnable", "u", "oldTheme", "newTheme", "y", "v", "r", "actionType", "w", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "teamState", HippyTKDListViewAdapter.X, DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/qqguildsdk/tianjige/GuildCounterNames;", "counterName", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "map", "isSuccess", ReportConstant.COSTREPORT_PREFIX, AdMetricTag.EVENT_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "showTips", "reasonForLog", "G", "b", "d", "Lcom/tencent/mobileqq/qqguildsdk/tianjige/IQQOpenTelemetryReportApi;", "Lcom/tencent/mobileqq/qqguildsdk/tianjige/IQQOpenTelemetryReportApi;", "getApi", "()Lcom/tencent/mobileqq/qqguildsdk/tianjige/IQQOpenTelemetryReportApi;", DTConstants.TAG.API, "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class aa extends a {

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public static final aa f230980i = new aa();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final IQQOpenTelemetryReportApi api;

    static {
        QRouteApi api2 = QRoute.api(IQQOpenTelemetryReportApi.class);
        Intrinsics.checkNotNullExpressionValue(api2, "api(IQQOpenTelemetryReportApi::class.java)");
        api = (IQQOpenTelemetryReportApi) api2;
    }

    aa() {
    }

    public final void A(boolean optMicEnable) {
        HashMap<String, String> hashMapOf;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("opt_mic_enable", String.valueOf(optMicEnable)));
        e("av_channel_user_av_mic", hashMapOf);
    }

    public final void B(boolean isAgree) {
        HashMap<String, String> hashMapOf;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("is_agree", String.valueOf(isAgree)));
        e("av_channel_user_handsup_callback", hashMapOf);
    }

    public final void C(int ret, @NotNull String errMsg, int userState) {
        HashMap<String, String> hashMapOf;
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("ret", String.valueOf(ret)), TuplesKt.to("err_msg", errMsg), TuplesKt.to("user_state", String.valueOf(userState)));
        e("av_channel_user_handsup", hashMapOf);
    }

    public final void D(boolean optMicEnable, int ret, @NotNull String errMsg) {
        HashMap<String, String> hashMapOf;
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("opt_mic_enable", String.valueOf(optMicEnable)), TuplesKt.to("ret", String.valueOf(ret)), TuplesKt.to("err_msg", errMsg));
        e("av_channel_user_mic", hashMapOf);
    }

    public final void E() {
        z.a.a(this, "av_channel_user_receive_invite_speak", null, 2, null);
    }

    public final void F(int optRouteType) {
        HashMap<String, String> hashMapOf;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("route_type", String.valueOf(optRouteType)));
        e("av_channel_user_route_type", hashMapOf);
    }

    public final void G(@Nullable String showTips, @Nullable String reasonForLog) {
        HashMap<String, String> hashMapOf;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("show_tips", String.valueOf(showTips)), TuplesKt.to("reason", String.valueOf(reasonForLog)));
        e("av_channel_leave", hashMapOf);
        endTask();
    }

    public final void H(@NotNull String guildId, @NotNull String channelId, int channelType) {
        HashMap<String, String> hashMapOf;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("guild_id", guildId), TuplesKt.to("channel_id", channelId), TuplesKt.to("channel_type", String.valueOf(channelType)));
        a(hashMapOf);
        c();
    }

    @Override // com.tencent.mobileqq.guild.performance.report.z
    @NotNull
    public String b() {
        return "QGMC.MediaChannelFullLinkReportTask";
    }

    @Override // com.tencent.mobileqq.guild.performance.report.z
    @NotNull
    public String d() {
        return "gpro_quality#event#av_channel";
    }

    public final void i(@NotNull String tinyId, int ret, @NotNull String errMsg) {
        HashMap<String, String> hashMapOf;
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(INetChannelCallback.KEY_TINY_ID, tinyId), TuplesKt.to("ret", String.valueOf(ret)), TuplesKt.to("err_msg", errMsg));
        e("av_channel_admin_cancel_speak", hashMapOf);
    }

    public final void j() {
        z.a.a(this, "av_channel_admin_handsup_list", null, 2, null);
    }

    public final void k(boolean isAgree, @NotNull String tinyId, int ret, @NotNull String errMsg) {
        HashMap<String, String> hashMapOf;
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("is_agree", String.valueOf(isAgree)), TuplesKt.to(INetChannelCallback.KEY_TINY_ID, tinyId), TuplesKt.to("ret", String.valueOf(ret)), TuplesKt.to("err_msg", errMsg));
        e("av_channel_admin_handsup", hashMapOf);
    }

    public final void l(@NotNull String tinyId, int ret, @NotNull String errMsg) {
        HashMap<String, String> hashMapOf;
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(INetChannelCallback.KEY_TINY_ID, tinyId), TuplesKt.to("ret", String.valueOf(ret)), TuplesKt.to("err_msg", errMsg));
        e("av_channel_admin_invite_speak", hashMapOf);
    }

    public final void m(int modeType) {
        HashMap<String, String> hashMapOf;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("audio_mode", String.valueOf(modeType)));
        e("av_channel_audio_mode_choose", hashMapOf);
    }

    public final void n(int teamState, int ret, @NotNull String errMsg) {
        HashMap<String, String> hashMapOf;
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("team_state", String.valueOf(teamState)), TuplesKt.to("ret", String.valueOf(ret)), TuplesKt.to("err_msg", errMsg));
        e("av_channel_play_together_close", hashMapOf);
    }

    public final void o(int themeType) {
        HashMap<String, String> hashMapOf;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("theme_type", String.valueOf(themeType)));
        e("av_channel_enter_callback", hashMapOf);
    }

    public final void p(int ret, @NotNull String errMsg) {
        HashMap<String, String> hashMapOf;
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("ret", String.valueOf(ret)), TuplesKt.to("err_msg", errMsg));
        e("av_channel_play_together_exit_smoba_team", hashMapOf);
    }

    public final void q(int ret, @NotNull String errMsg) {
        HashMap<String, String> hashMapOf;
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("ret", String.valueOf(ret)), TuplesKt.to("err_msg", errMsg));
        e("av_channel_play_together_join_smoba_team", hashMapOf);
    }

    public final void r(int ret, @NotNull String errMsg) {
        HashMap<String, String> hashMapOf;
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("ret", String.valueOf(ret)), TuplesKt.to("err_msg", errMsg));
        e("av_channel_play_together_launch_smoba_team", hashMapOf);
    }

    public final void s(@NotNull GuildCounterNames counterName, @NotNull HashMap<String, String> map, boolean isSuccess) {
        Intrinsics.checkNotNullParameter(counterName, "counterName");
        Intrinsics.checkNotNullParameter(map, "map");
        e(counterName.getCounterName(), map);
        api.reportMetricCount(counterName, isSuccess, map);
    }

    public final void t() {
        z.a.a(this, "av_channel_prepare_enter", null, 2, null);
    }

    public final void u(boolean optEnable, int ret, @NotNull String errMsg) {
        HashMap<String, String> hashMapOf;
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("opt_mic_enable", String.valueOf(optEnable)), TuplesKt.to("ret", String.valueOf(ret)), TuplesKt.to("err_msg", errMsg));
        e("av_channel_screen_share", hashMapOf);
    }

    public final void v(int ret, @NotNull String errMsg) {
        HashMap<String, String> hashMapOf;
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("ret", String.valueOf(ret)), TuplesKt.to("err_msg", errMsg));
        e("av_channel_play_together_smoba_team_auth", hashMapOf);
    }

    public final void w(int actionType) {
        HashMap<String, String> hashMapOf;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("action_type", String.valueOf(actionType)));
        e("av_channel_play_together_smoba_team_push", hashMapOf);
    }

    public final void x(int teamState) {
        HashMap<String, String> hashMapOf;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("team_state", String.valueOf(teamState)));
        e("av_channel_play_together_smoba_team_state_push", hashMapOf);
    }

    public final void y(int oldTheme, int newTheme, int ret, @NotNull String errMsg) {
        HashMap<String, String> hashMapOf;
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("old_theme", String.valueOf(oldTheme)), TuplesKt.to("new_theme", String.valueOf(newTheme)), TuplesKt.to("ret", String.valueOf(ret)), TuplesKt.to("err_msg", errMsg));
        e("av_channel_switch_theme", hashMapOf);
    }

    public final void z(@NotNull String eventName, @NotNull GuildCounterNames counterName, @NotNull HashMap<String, String> map, boolean isSuccess) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(counterName, "counterName");
        Intrinsics.checkNotNullParameter(map, "map");
        e(eventName, map);
        api.reportMetricCount(counterName, isSuccess, map);
    }
}
