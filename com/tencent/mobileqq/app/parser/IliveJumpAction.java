package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.impl.RoomServiceConstants;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.config.QQLiveEntrance;
import com.tencent.mobileqq.qqlive.context.QQLiveContext;
import com.tencent.mobileqq.qqlivehall.iv.api.hall.IQQIvLiveHallApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.JumpKidModeMgr;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.common.api.IQQLiveReportApi;
import com.tencent.qqlive.common.report.constant.QQLiveQualityReportData;
import com.tencent.qqlive.common.report.constant.QQLiveReportConstants;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import com.tencent.timi.game.api.auth.IQQLiveAuthCheckApi;
import com.tencent.timi.game.api.entrance.IQQLiveEntranceCheckApi;
import com.tencent.timi.game.jump.api.IQQLiveAnchorJumpApi;
import com.tencent.util.NumberUtil;
import com.tencent.util.QQToastUtil;
import cooperation.ilive.util.ILiveEntranceUtilApi;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes11.dex */
public class IliveJumpAction extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;
    private Handler Q;

    public IliveJumpAction(QQAppInterface qQAppInterface, Context context) {
        super(qQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) context);
        } else {
            this.Q = new Handler(Looper.getMainLooper());
        }
    }

    private void H() {
        String str;
        if (TextUtils.isEmpty(this.f307441f.get("live_traceid"))) {
            str = ((IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class)).generateTraceId();
        } else {
            str = this.f307441f.get("live_traceid");
        }
        final String str2 = str;
        if ("watch".equals(this.f307440e)) {
            if (!((ILiveEntranceUtilApi) QRoute.api(ILiveEntranceUtilApi.class)).isClickEnable(1000)) {
                AegisLogger.i("unknown|IliveJumpAction", "dispatchActions", "fast click");
                return;
            }
            final String str3 = this.f307441f.get("roomid");
            final String str4 = this.f307441f.get("from");
            final String str5 = this.f307441f.get("source");
            final String str6 = this.f307441f.get("room_type");
            I(str2, this.f307438c, str5);
            a0(str2, "dispatch action", str3, str6, str4, str5, null);
            AegisLogger.i("unknown|IliveJumpAction", "dispatchActions", "roomId:" + str3 + ",from:" + str4 + ",source:" + str5);
            final long currentTimeMillis = System.currentTimeMillis();
            Bundle bundle = new Bundle();
            bundle.putInt("user_age", J());
            ((IQQLiveEntranceCheckApi) QRoute.api(IQQLiveEntranceCheckApi.class)).checkEntrance(this.f307437b, bundle, new hf4.a() { // from class: com.tencent.mobileqq.app.parser.ar
                @Override // hf4.a
                public final void onResult(boolean z16, String str7) {
                    IliveJumpAction.this.O(currentTimeMillis, str2, str3, str6, str4, str5, z16, str7);
                }
            });
            return;
        }
        if ("portal".equals(this.f307440e)) {
            L();
            return;
        }
        if ("study_mode".equals(this.f307440e)) {
            ((IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class)).qualityReport(new QQLiveQualityReportData.Builder().traceId(str2).eventId(QQLiveReportConstants.Event.E_JUMP_INTO_STUDY_MODE));
            JumpKidModeMgr.b().t((Activity) this.f307437b, 7);
        } else if ("vasbottomview".equals(this.f307440e)) {
            M();
        }
    }

    private void I(String str, String str2, String str3) {
        com.tencent.mobileqq.qqlive.config.c.f271178a.d(MobileQQ.sMobileQQ, QQLiveEntrance.SCHEME);
        com.tencent.mobileqq.qqlive.context.a aVar = new com.tencent.mobileqq.qqlive.context.a(QQLiveBusinessConfig.QQLIVE_APP_ID, str, str2, str3);
        QQLiveContext.Companion companion = QQLiveContext.INSTANCE;
        companion.f(companion.b(aVar));
        AegisLogger.i("unknown|IliveJumpAction", "ensureLiveContext", "traceId=" + str);
    }

    private String K() {
        return ((ILiveEntranceUtilApi) QRoute.api(ILiveEntranceUtilApi.class)).getCurrentRoomId();
    }

    private void L() {
        ((IQQLiveAuthCheckApi) QRoute.api(IQQLiveAuthCheckApi.class)).fetchAndCacheAuthState();
        com.tencent.mobileqq.qqlivehall.iv.api.hall.a aVar = new com.tencent.mobileqq.qqlivehall.iv.api.hall.a();
        aVar.e(NumberUtil.stringToInt(this.f307441f.get("from")));
        aVar.g(NumberUtil.stringToInt(this.f307441f.get("source")));
        aVar.f(NumberUtil.stringToInt(this.f307441f.get("retain")));
        aVar.j(J());
        if (TextUtils.equals(this.f307441f.get("update_js_bundle_type"), String.valueOf(0))) {
            aVar.h(0);
        } else {
            aVar.h(1);
        }
        String str = this.f307441f.get("buffer");
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        StringBuilder sb5 = new StringBuilder();
        String query = Uri.parse(this.f307438c).getQuery();
        sb5.append(String.format("buffer=%s", str));
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append(query);
        aVar.i(sb5.toString());
        AegisLogger.i("unknown|IliveJumpAction", "handlePortalAction", "from:" + aVar.a() + ",query=" + query + JefsClass.INDEX_URL + ((Object) sb5));
        ((IQQIvLiveHallApi) QRoute.api(IQQIvLiveHallApi.class)).openQQIvLiveHall(this.f307437b, aVar);
    }

    private void M() {
        int i3;
        String str = this.f307441f.get("type");
        if (!"1".equals(str)) {
            AegisLogger.i("unknown|IliveJumpAction", "handleVasBottomViewAction", "type is invalid, type:" + str);
            return;
        }
        String str2 = this.f307441f.get("url");
        if (TextUtils.isEmpty(str2)) {
            AegisLogger.i("unknown|IliveJumpAction", "handleVasBottomViewAction", "rawUrl is empty.");
            return;
        }
        String str3 = this.f307441f.get("bgColor");
        if (TextUtils.isEmpty(str3)) {
            str3 = "FFFFFFFF";
        }
        String str4 = this.f307441f.get("top_margin");
        if (!TextUtils.isEmpty(str4)) {
            i3 = Integer.valueOf(str4).intValue();
        } else {
            i3 = 168;
        }
        AegisLogger.i("unknown|IliveJumpAction", "handleVasBottomViewAction", "rawUrl:" + str2 + ", topMarginDp:" + i3 + ", bgColor:" + str3);
        ((ILiveEntranceUtilApi) QRoute.api(ILiveEntranceUtilApi.class)).openWebView(BaseApplication.getContext(), str2, i3, str3);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x029d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void N(final String str) {
        String str2;
        String str3;
        int i3;
        boolean z16;
        final n05.a aVar;
        final long currentTimeMillis = System.currentTimeMillis();
        if (((ILiveEntranceUtilApi) QRoute.api(ILiveEntranceUtilApi.class)).checkIsAnchorRoomNow()) {
            if (!K().equals(this.f307441f.get("roomid"))) {
                AegisLogger.e("unknown|IliveJumpAction", "handleWatchAction", "self live room exist, can not enter another roomd!");
                ((IQQLiveAnchorJumpApi) QRoute.api(IQQLiveAnchorJumpApi.class)).interruptJumpAction(this.f307437b);
                return;
            } else {
                AegisLogger.i("unknown|IliveJumpAction", "handleWatchAction", "back to self live room");
                ((IQQLiveAnchorJumpApi) QRoute.api(IQQLiveAnchorJumpApi.class)).openAnchorRoomPage(this.f307437b, 5, null);
                return;
            }
        }
        final String str4 = this.f307441f.get("roomid");
        String str5 = this.f307441f.get("rtmp");
        String str6 = this.f307441f.get("source");
        String str7 = this.f307441f.get("retain");
        String str8 = this.f307441f.get("closejump");
        String str9 = this.f307441f.get("trace_info");
        String str10 = this.f307441f.get("noclearTop");
        String str11 = this.f307441f.get("recom_info");
        final String str12 = this.f307441f.get("room_type");
        String str13 = this.f307441f.get("game_id");
        String str14 = this.f307441f.get("game_tag_id");
        String str15 = this.f307441f.get("video_source");
        String str16 = this.f307441f.get("cover_url");
        String str17 = this.f307441f.get("translucent_page");
        String str18 = this.f307441f.get("flv_url");
        String str19 = this.f307441f.get("is_use_flv");
        String str20 = this.f307441f.get("level");
        String str21 = this.f307441f.get("extdata");
        String str22 = this.f307441f.get("scene_id");
        String str23 = this.f307441f.get("qz_gdt");
        String str24 = this.f307441f.get("activity_id");
        String str25 = this.f307441f.get("auto_open_pendant_id");
        String str26 = this.f307441f.get("auto_open_luckybag");
        String str27 = this.f307441f.get(WadlProxyConsts.VIA_AUTO_DOWNLOAD);
        if (!TextUtils.isEmpty(str18) && !TextUtils.isEmpty(str19) && "1".equals(str19)) {
            str2 = str18;
        } else {
            str2 = str5;
        }
        try {
            String str28 = this.f307441f.get("from");
            if (str28 == null) {
                i3 = 99;
            } else {
                i3 = Integer.parseInt(str28);
            }
            str3 = "1";
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
            StringBuilder sb5 = new StringBuilder();
            str3 = "1";
            sb5.append("print exception: ");
            sb5.append(e16.getMessage());
            QLog.e("unknown|IliveJumpAction", 1, sb5.toString());
            i3 = 99;
        }
        AegisLogger.i("unknown|IliveJumpAction", "handleWatchAction", "begin jumping room -> roomId:" + str4 + ",roomType:" + str12 + ",from:" + i3 + ",source:" + str6 + ",noClearTop:" + str10 + ", gameId:" + str13 + ", gameTagId:" + str14 + ", videoSource:" + str15 + ", sceneId=" + str22);
        if (TextUtils.isEmpty(str6)) {
            str6 = ZPlanPublishSource.FROM_SCHEME;
        }
        try {
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        if (!TextUtils.isEmpty(str7)) {
            if (Integer.parseInt(str7) == 1) {
                z16 = true;
                aVar = new n05.a(this.f307437b, str6, str4, str2, z16, null, str8, i3);
                if (TextUtils.isEmpty(str10) && !str3.equals(str10)) {
                    aVar.f417955k = false;
                } else {
                    aVar.f417955k = true;
                }
                aVar.f417956l = str11;
                aVar.f417954j = str9;
                aVar.f417957m = str12;
                aVar.f417959o = str14;
                aVar.f417958n = str13;
                aVar.f417960p = str15;
                aVar.f417949e = str16;
                if (TextUtils.isEmpty(str17)) {
                    str17 = "false";
                }
                aVar.f417964t = str17;
                aVar.B = str20;
                aVar.C = str21;
                aVar.E = str;
                aVar.F = str22;
                aVar.G = str23;
                aVar.H = str24;
                aVar.I = str25;
                aVar.J = str26;
                aVar.K = str27;
                W(aVar, str6);
                X(aVar, str6, i3);
                Y(aVar);
                V(aVar);
                R(aVar);
                Z(aVar);
                S(aVar);
                T(aVar);
                U(aVar);
                Q(aVar);
                b0(new Runnable() { // from class: com.tencent.mobileqq.app.parser.as
                    @Override // java.lang.Runnable
                    public final void run() {
                        IliveJumpAction.this.P(currentTimeMillis, str, str4, str12, aVar);
                    }
                });
            }
        }
        z16 = false;
        aVar = new n05.a(this.f307437b, str6, str4, str2, z16, null, str8, i3);
        if (TextUtils.isEmpty(str10)) {
        }
        aVar.f417955k = true;
        aVar.f417956l = str11;
        aVar.f417954j = str9;
        aVar.f417957m = str12;
        aVar.f417959o = str14;
        aVar.f417958n = str13;
        aVar.f417960p = str15;
        aVar.f417949e = str16;
        if (TextUtils.isEmpty(str17)) {
        }
        aVar.f417964t = str17;
        aVar.B = str20;
        aVar.C = str21;
        aVar.E = str;
        aVar.F = str22;
        aVar.G = str23;
        aVar.H = str24;
        aVar.I = str25;
        aVar.J = str26;
        aVar.K = str27;
        W(aVar, str6);
        X(aVar, str6, i3);
        Y(aVar);
        V(aVar);
        R(aVar);
        Z(aVar);
        S(aVar);
        T(aVar);
        U(aVar);
        Q(aVar);
        b0(new Runnable() { // from class: com.tencent.mobileqq.app.parser.as
            @Override // java.lang.Runnable
            public final void run() {
                IliveJumpAction.this.P(currentTimeMillis, str, str4, str12, aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O(long j3, String str, String str2, String str3, String str4, String str5, boolean z16, String str6) {
        long currentTimeMillis = System.currentTimeMillis() - j3;
        AegisLogger.i("unknown|IliveJumpAction", "dispatchActions.checkEntrance", " passed:" + z16 + ",message:" + str6 + ",cost:" + currentTimeMillis);
        if (z16) {
            a0(str, "authed", str2, str3, str4, str5, String.valueOf(currentTimeMillis));
            N(str);
        } else {
            ((IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class)).qualityReport(new QQLiveQualityReportData.Builder().traceId(str).eventId(QQLiveReportConstants.Event.E_ENTER_ROOM_BREAK).desc("no auth"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P(long j3, String str, String str2, String str3, n05.a aVar) {
        a0(str, "audience room", str2, str3, String.valueOf(aVar.f417953i), String.valueOf(aVar.f417946b), String.valueOf(System.currentTimeMillis() - j3));
        ((ILiveEntranceUtilApi) QRoute.api(ILiveEntranceUtilApi.class)).liveWatchEntranceJump(aVar);
    }

    private void Q(n05.a aVar) {
        aVar.D = this.f307441f.get(AudienceReportConst.ANCHOR_ID);
    }

    private void R(n05.a aVar) {
        String str = this.f307441f.get("auto_open_url");
        if (str != null) {
            aVar.f417967w = str;
        }
        String str2 = this.f307441f.get("auto_open_page_style");
        if (str2 != null) {
            aVar.f417968x = str2;
        }
    }

    private void S(n05.a aVar) {
        String str = this.f307441f.get("default_tab_id");
        if (str != null) {
            aVar.f417969y = str;
        }
    }

    private void T(n05.a aVar) {
        String str = this.f307441f.get("gamelive_custom_params");
        if (str != null) {
            aVar.f417970z = str;
        }
    }

    private void U(n05.a aVar) {
        String str = this.f307441f.get("jumpcmd");
        if (str != null) {
            aVar.A = str;
        }
    }

    private void V(n05.a aVar) {
        String str = this.f307441f.get("jump_start_time");
        if (TextUtils.isEmpty(str)) {
            str = "" + System.currentTimeMillis();
        }
        aVar.f417965u = str;
    }

    private void W(n05.a aVar, String str) {
        String str2 = this.f307441f.get(RoomServiceConstants.PARAMS_QQ_LIVE_PRODUCT_TYPE);
        if (TextUtils.equals(str2, "1")) {
            aVar.f417961q = str2;
            AegisLogger.i("unknown|IliveJumpAction", "parseLiveProductType", "use schemeLiveProductType=" + aVar.f417961q);
            return;
        }
        aVar.f417961q = "1";
        AegisLogger.i("unknown|IliveJumpAction", "parseLiveProductType", "use defaultLiveProductType=" + aVar.f417961q);
    }

    private void X(n05.a aVar, String str, int i3) {
        aVar.f417962r = "false";
    }

    private void Y(n05.a aVar) {
        String str = this.f307441f.get("rcmd_context");
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        aVar.f417963s = str;
    }

    private void Z(n05.a aVar) {
        String str = this.f307441f.get("showmore");
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        aVar.f417966v = str;
    }

    private void a0(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        ((IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class)).qualityReport(new QQLiveQualityReportData.Builder().traceId(str).eventId(QQLiveReportConstants.Event.E_ENTER_ROOM_STEP).roomId(str3).roomType(str4).cost(str7).desc(str2).ext6(str5).ext7(str6).ext8(String.valueOf(System.currentTimeMillis())));
    }

    private void b0(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            this.Q.post(runnable);
        }
    }

    @VisibleForTesting
    int J() {
        Card t16 = ((FriendsManager) this.f307436a.getManager(QQManagerFactory.FRIENDS_MANAGER)).t(this.f307436a.getCurrentAccountUin());
        if (t16 == null) {
            QLog.i("unknown|IliveJumpAction", 1, "\u83b7\u53d6\u81ea\u5df1\u7684\u8d44\u6599\u5361\uff0c\u7f13\u5b58\u4e2d\u672a\u83b7\u53d6\u5230");
            return -1;
        }
        return t16.age;
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (StudyModeManager.t()) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                QQToastUtil.showQQToast(1, "\u672a\u6210\u5e74\u4eba\u6a21\u5f0f\u4e0b\u8be5\u5185\u5bb9\u4e0d\u53ef\u8bbf\u95ee");
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.app.parser.IliveJumpAction.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) IliveJumpAction.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            QQToastUtil.showQQToast(1, "\u672a\u6210\u5e74\u4eba\u6a21\u5f0f\u4e0b\u8be5\u5185\u5bb9\u4e0d\u53ef\u8bbf\u95ee");
                        }
                    }
                });
            }
            return false;
        }
        try {
            H();
            return true;
        } catch (Exception e16) {
            AegisLogger.e("unknown|IliveJumpAction", "doAction", "error: " + QLog.getStackTraceString(e16));
            i("unknown|IliveJumpAction");
            return false;
        }
    }

    public void c0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (TextUtils.isEmpty(this.f307438c)) {
            AegisLogger.e("unknown|IliveJumpAction", "setActionName", "illegal scheme:" + this.f307438c);
            this.f307440e = "";
            return;
        }
        if (this.f307438c.startsWith("mqqapi://vaslive/watch")) {
            this.f307440e = "watch";
        }
        if (this.f307438c.startsWith("mqqapi://vaslive/portal")) {
            this.f307440e = "portal";
        }
        if (this.f307438c.startsWith("mqqapi://vaslive/study_mode")) {
            this.f307440e = "study_mode";
        }
        if (this.f307438c.startsWith("mqqapi://vaslive/vasbottomview")) {
            this.f307440e = "vasbottomview";
        }
    }
}
