package gh4;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import fm4.g;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import trpc.yes.common.CommonOuterClass$QQUserId;
import ug4.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010P\u001a\u00020L\u00a2\u0006\u0004\b\\\u0010]J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u0002J\u0006\u0010\r\u001a\u00020\u0002J\u0006\u0010\u000e\u001a\u00020\u0002J\u0006\u0010\u000f\u001a\u00020\u0002J\u0006\u0010\u0010\u001a\u00020\u0002J\u0006\u0010\u0011\u001a\u00020\u0002J\u0006\u0010\u0012\u001a\u00020\u0002J\u0006\u0010\u0013\u001a\u00020\u0002J\u0006\u0010\u0014\u001a\u00020\u0002J\u0006\u0010\u0015\u001a\u00020\u0002J\u0006\u0010\u0016\u001a\u00020\u0002J\u0006\u0010\u0017\u001a\u00020\u0002J\u0006\u0010\u0018\u001a\u00020\u0002J\u0006\u0010\u0019\u001a\u00020\u0002J\u0006\u0010\u001a\u001a\u00020\u0002J\u0006\u0010\u001b\u001a\u00020\u0002J\u0006\u0010\u001c\u001a\u00020\u0002J\u0006\u0010\u001d\u001a\u00020\u0002J\"\u0010 \u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001ej\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u001fJ\"\u0010!\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001ej\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u001fJ\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\"J\b\u0010%\u001a\u0004\u0018\u00010$J\"\u0010&\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001ej\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u001fJ\u001e\u0010-\u001a\u00020,2\u0006\u0010(\u001a\u00020'2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020)J\u0016\u00101\u001a\u00020,2\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020\u0002J\u000e\u00102\u001a\u00020,2\u0006\u0010/\u001a\u00020\u0001J\u0016\u00105\u001a\u00020,2\u0006\u00103\u001a\u00020'2\u0006\u00104\u001a\u00020\u0002J\u000e\u00106\u001a\u00020\u00022\u0006\u00103\u001a\u00020'J\u0016\u00108\u001a\u00020,2\u0006\u00103\u001a\u00020'2\u0006\u00107\u001a\u00020\u0002J\u000e\u00109\u001a\u00020\u00022\u0006\u00103\u001a\u00020'J\u000e\u0010:\u001a\u00020,2\u0006\u00103\u001a\u00020'J\u0006\u0010;\u001a\u00020,J\u000e\u0010=\u001a\u00020,2\u0006\u0010<\u001a\u00020\u0002J\u000e\u0010?\u001a\u00020,2\u0006\u0010>\u001a\u00020)J\u0006\u0010@\u001a\u00020,J\u0006\u0010A\u001a\u00020,J\u0006\u0010B\u001a\u00020,J\u0006\u0010C\u001a\u00020,J\"\u0010H\u001a\u00020,2\u0006\u0010E\u001a\u00020D2\b\b\u0002\u0010F\u001a\u00020)2\b\b\u0002\u0010G\u001a\u00020\u0002J\u0006\u0010I\u001a\u00020,J\u0006\u0010J\u001a\u00020,J\u0006\u0010K\u001a\u00020,R\u0017\u0010P\u001a\u00020L8\u0006\u00a2\u0006\f\n\u0004\b1\u0010M\u001a\u0004\bN\u0010OR2\u0010R\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001ej\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010QR\"\u0010U\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00020S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010TR\"\u0010V\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00020S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010TR\"\u0010W\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00020S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010TR\u0016\u0010X\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\rR\u0016\u0010Y\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\rR\u0016\u0010Z\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\rR\u0016\u0010[\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010\r\u00a8\u0006^"}, d2 = {"Lgh4/d;", "", "", BdhLogUtil.LogTag.Tag_Conn, "B", "G", "e", "d", "H", "I", "f", "g", "K", "J", "w", "v", "j", "k", "p", ReportConstant.COSTREPORT_PREFIX, "t", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "u", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, HippyTKDListViewAdapter.X, "y", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "E", "D", "", h.F, "Lfm4/c;", "i", UserInfo.SEX_FEMALE, "", "roomId", "", "roomType", "yesGameId", "", "c", "Landroid/view/View;", "view", "elementId", "a", "b", "teamId", "memberTags", "Z", "o", "scene", "a0", "L", "U", "W", "reason", "X", "exitSource", "Y", "V", "P", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "T", "", "result", "errorCode", "errorMsg", BdhLogUtil.LogTag.Tag_Req, "O", "M", "N", "Lcom/tencent/timi/game/api/param/ExpandHallLaunchParam;", "Lcom/tencent/timi/game/api/param/ExpandHallLaunchParam;", "l", "()Lcom/tencent/timi/game/api/param/ExpandHallLaunchParam;", ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY, "Ljava/util/HashMap;", "mReportParamMap", "", "Ljava/util/Map;", "mTeamMemberTagMap", "mTeamUserBranch", "mTeamSceneMap", "mJoinRoomStartTimeStamp", "mJoinRoomSuccTimeStamp", "mHallCreateTimeStamp", "mGuildSlideInTimeStamp", "<init>", "(Lcom/tencent/timi/game/api/param/ExpandHallLaunchParam;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ExpandHallLaunchParam launchParam;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private HashMap<String, String> mReportParamMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<Long, String> mTeamMemberTagMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<Long, String> mTeamUserBranch;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<Long, String> mTeamSceneMap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long mJoinRoomStartTimeStamp;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private long mJoinRoomSuccTimeStamp;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long mHallCreateTimeStamp;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long mGuildSlideInTimeStamp;

    public d(@NotNull ExpandHallLaunchParam launchParam) {
        Intrinsics.checkNotNullParameter(launchParam, "launchParam");
        this.launchParam = launchParam;
        this.mReportParamMap = new HashMap<>();
        this.mTeamMemberTagMap = new LinkedHashMap();
        this.mTeamUserBranch = new LinkedHashMap();
        this.mTeamSceneMap = new LinkedHashMap();
    }

    public static /* synthetic */ void S(d dVar, boolean z16, int i3, String str, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        if ((i16 & 4) != 0) {
            str = "";
        }
        dVar.R(z16, i3, str);
    }

    @NotNull
    public final String A() {
        return "em_yes_micjoin_win_confirm";
    }

    @NotNull
    public final String B() {
        return "em_yes_notice";
    }

    @NotNull
    public final String C() {
        if (this.launchParam.f376301d == 2) {
            return "pg_sgrp_smoba_cpdd";
        }
        return "pg_kl_smoba_cpdd";
    }

    @NotNull
    public final HashMap<String, String> D() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("yes_game_id", String.valueOf(this.launchParam.f376303f));
        hashMap.put("yes_user_from", String.valueOf(b.a(this.launchParam)));
        return hashMap;
    }

    @NotNull
    public final HashMap<String, String> E() {
        HashMap<String, String> hashMap = new HashMap<>(this.mReportParamMap);
        if (this.launchParam.f376301d == 2) {
            hashMap.putAll(h());
        }
        return hashMap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x000d, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r0);
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final HashMap<String, String> F() {
        Long longOrNull;
        String str = this.mReportParamMap.get("yes_room_id");
        if (str != null && longOrNull != null) {
            CommonOuterClass$QQUserId R = ((g) mm4.b.b(g.class)).K0(longOrNull.longValue()).R();
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.putAll(this.mReportParamMap);
            hashMap.put("yes_room_owner", String.valueOf(R.yes_uid.get()));
            hashMap.put("yes_user_from", String.valueOf(b.a(this.launchParam)));
            hashMap.putAll(h());
            return hashMap;
        }
        return this.mReportParamMap;
    }

    @NotNull
    public final String G() {
        return "em_yes_config";
    }

    @NotNull
    public final String H() {
        return "em_yes_data_authorize";
    }

    @NotNull
    public final String I() {
        return "em_yes_data_authorize_panel_close";
    }

    @NotNull
    public final String J() {
        return "em_yes_rolebind_panel_confirm";
    }

    @NotNull
    public final String K() {
        return "em_yes_rolebind_panel_close";
    }

    @NotNull
    public final String L(long teamId) {
        String str = this.mTeamSceneMap.get(Long.valueOf(teamId));
        if (str == null) {
            return "1";
        }
        return str;
    }

    public final void M() {
        this.mGuildSlideInTimeStamp = System.currentTimeMillis();
    }

    public final void N() {
        if (this.mGuildSlideInTimeStamp == 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.mGuildSlideInTimeStamp;
        HashMap<String, String> F = F();
        F.put("yes_room_lvtm", String.valueOf(currentTimeMillis));
        ((ug4.b) mm4.b.b(ug4.b.class)).reportEvent("ev_yes_room_slideout", F);
    }

    public final void O() {
        HashMap hashMap = new HashMap();
        String str = this.launchParam.C;
        Intrinsics.checkNotNullExpressionValue(str, "launchParam.channelId");
        hashMap.put("k_channel_id", str);
        String str2 = this.launchParam.f376305i;
        Intrinsics.checkNotNullExpressionValue(str2, "launchParam.channelName");
        hashMap.put("k_channel_name", str2);
        hashMap.put("k_source_id", String.valueOf(this.launchParam.f376301d));
        hashMap.put("k_yes_game_id", String.valueOf(this.launchParam.f376303f));
        hashMap.put("k_cost_time", String.valueOf(System.currentTimeMillis() - this.mJoinRoomSuccTimeStamp));
        ((ug4.b) mm4.b.b(ug4.b.class)).e("e_hall_chat_init_finish", hashMap);
    }

    public final void P() {
        this.mHallCreateTimeStamp = System.currentTimeMillis();
    }

    public final void Q() {
        HashMap hashMap = new HashMap();
        String str = this.launchParam.C;
        Intrinsics.checkNotNullExpressionValue(str, "launchParam.channelId");
        hashMap.put("k_channel_id", str);
        String str2 = this.launchParam.f376305i;
        Intrinsics.checkNotNullExpressionValue(str2, "launchParam.channelName");
        hashMap.put("k_channel_name", str2);
        hashMap.put("k_source_id", String.valueOf(this.launchParam.f376301d));
        hashMap.put("k_yes_game_id", String.valueOf(this.launchParam.f376303f));
        hashMap.put("k_cost_time", String.valueOf(System.currentTimeMillis() - this.mHallCreateTimeStamp));
        ((ug4.b) mm4.b.b(ug4.b.class)).e("e_hall_ui_load_result", hashMap);
    }

    public final void R(boolean result, int errorCode, @NotNull String errorMsg) {
        String valueOf;
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        HashMap hashMap = new HashMap();
        String str = this.launchParam.C;
        Intrinsics.checkNotNullExpressionValue(str, "launchParam.channelId");
        hashMap.put("k_channel_id", str);
        String str2 = this.launchParam.f376305i;
        Intrinsics.checkNotNullExpressionValue(str2, "launchParam.channelName");
        hashMap.put("k_channel_name", str2);
        hashMap.put("k_source_id", String.valueOf(this.launchParam.f376301d));
        hashMap.put("k_yes_game_id", String.valueOf(this.launchParam.f376303f));
        if (this.mJoinRoomStartTimeStamp == 0) {
            valueOf = "-1";
        } else {
            valueOf = String.valueOf(System.currentTimeMillis() - this.mJoinRoomStartTimeStamp);
        }
        hashMap.put("k_cost_time", valueOf);
        hashMap.put(com.tencent.mobileqq.phonecontact.observer.b.KEY_RESULT, String.valueOf(result));
        hashMap.put("k_err_code", String.valueOf(errorCode));
        hashMap.put("k_err_msg", errorMsg);
        ((ug4.b) mm4.b.b(ug4.b.class)).e("e_hall_join_room_result", hashMap);
    }

    public final void T() {
        this.mJoinRoomStartTimeStamp = System.currentTimeMillis();
    }

    public final void U(long teamId) {
        this.mTeamSceneMap.remove(Long.valueOf(teamId));
    }

    public final void V() {
        long j3;
        long j16 = this.launchParam.H;
        HashMap hashMap = new HashMap(E());
        hashMap.put("yes_leave_reason", "0");
        CommonOuterClass$QQUserId E = ((ll4.a) mm4.b.b(ll4.a.class)).E();
        gm4.c K0 = ((g) mm4.b.b(g.class)).K0(j16);
        if (K0 != null) {
            j3 = K0.A(E);
        } else {
            j3 = 0;
        }
        hashMap.put("yes_stay_duration", String.valueOf(j3));
        ((ug4.b) mm4.b.b(ug4.b.class)).reportEvent("ev_yes_leave_mic", hashMap);
    }

    public final void W() {
        this.mJoinRoomSuccTimeStamp = System.currentTimeMillis();
        ((ug4.b) mm4.b.b(ug4.b.class)).reportEvent("ev_yes_room_in", F());
    }

    public final void X(@NotNull String reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        HashMap<String, String> F = F();
        F.put("yes_fail_reason", reason);
        ((ug4.b) mm4.b.b(ug4.b.class)).reportEvent("ev_yes_room_in_fail", F);
    }

    public final void Y(int exitSource) {
        String str;
        if (this.mJoinRoomSuccTimeStamp != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.mJoinRoomSuccTimeStamp;
            HashMap hashMap = new HashMap();
            hashMap.putAll(F());
            hashMap.put("yes_room_lvtm", String.valueOf(currentTimeMillis));
            if (exitSource == 3) {
                str = "1";
            } else {
                str = "0";
            }
            hashMap.put("yes_leave_reason", str);
            ((ug4.b) mm4.b.b(ug4.b.class)).reportEvent("ev_yes_room_out", hashMap);
        }
    }

    public final void Z(long teamId, @NotNull String memberTags) {
        Intrinsics.checkNotNullParameter(memberTags, "memberTags");
        this.mTeamMemberTagMap.put(Long.valueOf(teamId), memberTags);
    }

    public final void a(@NotNull View view, @NotNull String elementId) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        mm4.a b16 = mm4.b.b(ug4.b.class);
        Intrinsics.checkNotNullExpressionValue(b16, "getService(IReportService::class.java)");
        b.a.a((ug4.b) b16, view, false, null, elementId, E(), 6, null);
    }

    public final void a0(long teamId, @NotNull String scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        this.mTeamSceneMap.put(Long.valueOf(teamId), scene);
    }

    public final void b(@NotNull Object view) {
        Intrinsics.checkNotNullParameter(view, "view");
        HashMap hashMap = new HashMap();
        hashMap.put("yes_game_id", String.valueOf(this.launchParam.f376303f));
        hashMap.put("yes_user_from", String.valueOf(com.tencent.timi.game.utils.b.h(this.launchParam.f376301d)));
        ((ug4.b) mm4.b.b(ug4.b.class)).b(view, C(), hashMap);
    }

    public final void c(long roomId, int roomType, int yesGameId) {
        this.launchParam.H = roomId;
        this.mReportParamMap.put("yes_room_id", String.valueOf(roomId));
        this.mReportParamMap.put("yes_room_type", String.valueOf(roomType));
        this.mReportParamMap.put("yes_game_id", String.valueOf(yesGameId));
        this.mReportParamMap.put("yes_user_from", String.valueOf(b.a(this.launchParam)));
    }

    @NotNull
    public final String d() {
        return "em_yes_config_panel_data_authorize";
    }

    @NotNull
    public final String e() {
        return "em_yes_config_panel_rolebind";
    }

    @NotNull
    public final String f() {
        return "em_yes_rolebind_win_cancel";
    }

    @NotNull
    public final String g() {
        return "em_yes_rolebind_win_gamelaunch";
    }

    @NotNull
    public final Map<String, String> h() {
        HashMap hashMap = new HashMap();
        ExpandHallLaunchParam expandHallLaunchParam = this.launchParam;
        if (expandHallLaunchParam.f376301d == 2) {
            hashMap.put("qq_group_num", String.valueOf(expandHallLaunchParam.f376304h));
            hashMap.put("sgrp_channel_num", this.launchParam.C.toString());
            hashMap.put(QCircleDaTongConstant.ElementParamKey.SGRP_CHANNEL_NAME, this.launchParam.f376305i.toString());
            hashMap.put("sgrp_duration_flag", "1");
            hashMap.put("sgrp_login_flag", "1");
        }
        return hashMap;
    }

    @Nullable
    public final fm4.c i() {
        Long longOrNull;
        long j3;
        ExpandHallLaunchParam expandHallLaunchParam = this.launchParam;
        if (expandHallLaunchParam.f376301d == 2) {
            String str = expandHallLaunchParam.C;
            Intrinsics.checkNotNullExpressionValue(str, "launchParam.channelId");
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(str);
            if (longOrNull != null) {
                j3 = longOrNull.longValue();
            } else {
                j3 = 0;
            }
            ExpandHallLaunchParam expandHallLaunchParam2 = this.launchParam;
            return new fm4.c(expandHallLaunchParam2.f376304h, j3, expandHallLaunchParam2.f376305i);
        }
        return null;
    }

    @NotNull
    public final String j() {
        return "em_yes_mic";
    }

    @NotNull
    public final String k() {
        return "em_yes_voice";
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final ExpandHallLaunchParam getLaunchParam() {
        return this.launchParam;
    }

    @NotNull
    public final String m() {
        return "em_yes_leaveroom_win_cancel";
    }

    @NotNull
    public final String n() {
        return "em_yes_leaveroom_win_confirm";
    }

    @NotNull
    public final String o(long teamId) {
        String str = this.mTeamMemberTagMap.get(Long.valueOf(teamId));
        if (str == null) {
            return "";
        }
        return str;
    }

    @NotNull
    public final String p() {
        return "em_yes_mic_apply";
    }

    @NotNull
    public final String q() {
        return "em_yes_micapprove_panel_clear";
    }

    @NotNull
    public final String r() {
        return "em_yes_micapprove_panel_close";
    }

    @NotNull
    public final String s() {
        return "em_yes_micapprove_panel_confirm";
    }

    @NotNull
    public final String t() {
        return "em_yes_micapprove_panel_ignore";
    }

    @NotNull
    public final String u() {
        return "em_yes_micapprove_panel_user_head";
    }

    @NotNull
    public final String v() {
        return "em_yes_mic_seat";
    }

    @NotNull
    public final String w() {
        return "em_yes_mic_user_head";
    }

    @NotNull
    public final String x() {
        return "em_yes_acceptmic_win_close";
    }

    @NotNull
    public final String y() {
        return "em_yes_acceptmic_win_confirm";
    }

    @NotNull
    public final String z() {
        return "em_yes_micjoin_win_close";
    }
}
