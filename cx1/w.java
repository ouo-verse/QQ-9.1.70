package cx1;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.google.gson.Gson;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildAVPriorityManager;
import com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.api.LaunchGuildChatPieParam;
import com.tencent.mobileqq.guild.message.directmessage.model.repositories.DirectMessageNodeRepository;
import com.tencent.mobileqq.guild.profile.profilecard.dialog.GuildRemoveGuildDialogFragment;
import com.tencent.mobileqq.guild.robot.api.IGuildRobotApi;
import com.tencent.mobileqq.guild.robot.api.IGuildRobotPageApi;
import com.tencent.mobileqq.guild.robot.api.model.GuildChannel;
import com.tencent.mobileqq.guild.robot.components.auth.RobotAuthorizeAddFragment;
import com.tencent.mobileqq.guild.robot.components.auth.RobotAuthorizeAddInfo;
import com.tencent.mobileqq.guild.robot.components.console.RobotInfo;
import com.tencent.mobileqq.guild.robot.components.guilds.RobotCommonGuildFragment;
import com.tencent.mobileqq.guild.robot.components.join.RobotJoinGuildFragment;
import com.tencent.mobileqq.guild.robot.components.setting.RobotMoreSettingDialogFragment;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cx;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.fm;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.common.EventData;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotData;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotDownMicReq;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotFeatureInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotInfoRsp;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotPanelListItem;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotUpMicReq;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotUpMicRsp;
import com.tencent.qqnt.kernel.nativeinterface.GProRobotCommonGuildReq;
import com.tencent.qqnt.kernel.nativeinterface.GProRobotCommonGuildRsp;
import com.tencent.qqnt.kernel.nativeinterface.IGProFetchGuildRobotInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGProFetchRobotCommonGuildCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGProRobotSimpleResultCallback;
import com.tencent.qqnt.kernel.nativeinterface.IUpMicGuildRobotCallback;
import cx1.w;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0x106a.oidb_0x106a$RobotInfo;
import vh2.cd;

/* compiled from: P */
/* loaded from: classes14.dex */
public class w implements cx1.a, cx1.c {

    /* renamed from: a, reason: collision with root package name */
    public boolean f392306a;

    /* renamed from: b, reason: collision with root package name */
    private int f392307b;

    /* renamed from: c, reason: collision with root package name */
    private int f392308c;

    /* renamed from: d, reason: collision with root package name */
    private String f392309d;

    /* renamed from: h, reason: collision with root package name */
    private boolean f392313h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f392314i;

    /* renamed from: j, reason: collision with root package name */
    private int f392315j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f392316k;

    /* renamed from: l, reason: collision with root package name */
    private int f392317l;

    /* renamed from: n, reason: collision with root package name */
    private GProGuildRobotInfoRsp f392319n;

    /* renamed from: o, reason: collision with root package name */
    private final e f392320o;

    /* renamed from: q, reason: collision with root package name */
    private int f392322q;

    /* renamed from: r, reason: collision with root package name */
    private GProGuildRobotData f392323r;

    /* renamed from: s, reason: collision with root package name */
    private GProRobotCommonGuildRsp f392324s;

    /* renamed from: t, reason: collision with root package name */
    private int f392325t;

    /* renamed from: u, reason: collision with root package name */
    private d f392326u;

    /* renamed from: w, reason: collision with root package name */
    private RobotAuthorizeAddInfo f392328w;

    /* renamed from: e, reason: collision with root package name */
    private boolean f392310e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f392311f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f392312g = false;

    /* renamed from: m, reason: collision with root package name */
    private boolean f392318m = false;

    /* renamed from: p, reason: collision with root package name */
    private boolean f392321p = false;

    /* renamed from: v, reason: collision with root package name */
    private boolean f392327v = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a implements lv1.b {

        /* renamed from: a, reason: collision with root package name */
        private boolean f392329a = false;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildChannel f392330b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f392331c;

        a(GuildChannel guildChannel, List list) {
            this.f392330b = guildChannel;
            this.f392331c = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(boolean z16, int i3, String str, IGProSecurityResult iGProSecurityResult) {
            if (i3 == 0 && ch.p(iGProSecurityResult)) {
                w.this.f392327v = true;
                if (w.this.f392320o != null) {
                    w.this.r0(true, str, Boolean.valueOf(z16));
                    return;
                }
                return;
            }
            QLog.i("RobotInfoController", 1, "deleteRobot error: result=" + i3 + ", errMsg=" + str + ", security=" + iGProSecurityResult);
            if (w.this.f392320o != null) {
                w.this.r0(false, str, Boolean.valueOf(z16));
            }
        }

        @Override // lv1.b
        public void a(final boolean z16, int i3) {
            QLog.i("RobotInfoController", 2, "onRemoveGuild: isBlack=" + z16 + ", msgRevokeType=" + i3);
            this.f392329a = true;
            ((IGPSService) ch.S0(IGPSService.class, "")).kickGuildUsers(String.valueOf(this.f392330b.b()), this.f392331c, z16, new fm.a().c(i3).b(), new cd() { // from class: cx1.v
                @Override // vh2.cd
                public final void a(int i16, String str, IGProSecurityResult iGProSecurityResult) {
                    w.a.this.c(z16, i16, str, iGProSecurityResult);
                }
            });
        }

        @Override // lv1.b
        public void onDismiss() {
            if (!this.f392329a) {
                w.this.f392320o.u();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class b implements vy1.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AppRuntime f392333a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f392334b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f392335c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f392336d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f392337e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f392338f;

        b(AppRuntime appRuntime, String str, String str2, String str3, View view, int i3) {
            this.f392333a = appRuntime;
            this.f392334b = str;
            this.f392335c = str2;
            this.f392336d = str3;
            this.f392337e = view;
            this.f392338f = i3;
        }

        @Override // vy1.a
        public void a(IGProChannelInfo iGProChannelInfo) {
            QLog.d("RobotInfoController", 4, "channelInfo:", iGProChannelInfo.getChannelUin());
            w.this.y0(this.f392333a, this.f392334b, iGProChannelInfo.getChannelUin(), this.f392335c, this.f392336d, 1, this.f392337e, this.f392338f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class c implements yw1.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ sx1.c f392340a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f392341b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f392342c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f392343d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f392344e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f392345f;

        c(sx1.c cVar, String str, String str2, String str3, boolean z16, boolean z17) {
            this.f392340a = cVar;
            this.f392341b = str;
            this.f392342c = str2;
            this.f392343d = str3;
            this.f392344e = z16;
            this.f392345f = z17;
        }

        @Override // yw1.a
        public void onShow() {
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final sx1.c cVar = this.f392340a;
            final String str = this.f392341b;
            final String str2 = this.f392342c;
            final String str3 = this.f392343d;
            final boolean z16 = this.f392344e;
            final boolean z17 = this.f392345f;
            uIHandlerV2.postDelayed(new Runnable() { // from class: cx1.x
                @Override // java.lang.Runnable
                public final void run() {
                    sx1.c.this.a(str, str2, str3, z16, z17);
                }
            }, 1000L);
        }
    }

    public w(e eVar) {
        this.f392320o = eVar;
        eVar.t(this);
    }

    private void B0(String str) {
        Activity b16 = this.f392320o.b();
        if (b16 == null) {
            return;
        }
        String valueOf = String.valueOf(this.f392320o.k().k());
        String g16 = this.f392320o.g();
        ((IGuildRobotApi) QRoute.api(IGuildRobotApi.class)).updateRobotSort(b16, valueOf, g16);
        ((IGuildRobotApi) QRoute.api(IGuildRobotApi.class)).updateFuncSort(b16, valueOf + "," + str, g16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C0, reason: merged with bridge method [inline-methods] */
    public void g0(GProGuildRobotInfoRsp gProGuildRobotInfoRsp) {
        boolean z16;
        boolean z17;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        boolean z18 = true;
        if (gProGuildRobotInfoRsp != null && peekAppRuntime != null) {
            if (!this.f392318m) {
                this.f392319n = gProGuildRobotInfoRsp;
                return;
            }
            if (this.f392320o == null) {
                return;
            }
            this.f392319n = gProGuildRobotInfoRsp;
            GProGuildRobotData robotData = gProGuildRobotInfoRsp.getRobotData();
            this.f392323r = robotData;
            this.f392318m = false;
            this.f392310e = true;
            v0(robotData.getMuteStatus(), robotData.getPunishmentStatus(), gProGuildRobotInfoRsp.getRobotTestStatus());
            if (!this.f392313h) {
                this.f392320o.a();
                return;
            }
            this.f392307b = gProGuildRobotInfoRsp.getRole();
            if (robotData.getStatus() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.f392306a = z16;
            this.f392308c = robotData.getRobotRole();
            this.f392309d = robotData.getRobotName();
            if (robotData.getRobotOffline() == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            this.f392311f = z17;
            if (robotData.getIsGray() != 1) {
                z18 = false;
            }
            this.f392312g = z18;
            this.f392314i = robotData.getIsSharable();
            this.f392316k = robotData.getAllowAddOtherGuild();
            this.f392315j = robotData.getPublicType();
            this.f392317l = gProGuildRobotInfoRsp.getRobotTestStatus();
            this.f392326u.d(0, gProGuildRobotInfoRsp);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("RobotInfoController", 1, "infoReply = " + gProGuildRobotInfoRsp + " app = " + peekAppRuntime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public void k0(boolean z16, Bundle bundle, String str, View view) {
        int i3 = 0;
        String str2 = "";
        if (!z16) {
            int i16 = -1;
            if (bundle != null) {
                i16 = (int) bundle.getLong("retCode", -1);
                str2 = bundle.getString("errMsg", "");
            }
            QLog.e("RobotInfoController", 1, "start mini app fail, errCode : ", Integer.valueOf(i16), " errMsg : ", str2);
            i3 = i16;
        }
        x0(str, i3, str2, view);
    }

    private void R(GuildChannel guildChannel, RobotInfo robotInfo) {
        com.tencent.qqnt.kernel.api.ac g16 = sx1.f.g();
        if (g16 == null) {
            return;
        }
        g16.downMicGuildRobot(new GProGuildRobotDownMicReq(guildChannel.b(), guildChannel.a(), robotInfo.l(), robotInfo.k()), new IGProRobotSimpleResultCallback() { // from class: cx1.f
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGProRobotSimpleResultCallback
            public final void onResult(int i3, String str) {
                w.this.d0(i3, str);
            }
        });
    }

    private void V(AppRuntime appRuntime, GuildChannel guildChannel, RobotInfo robotInfo, String str, View view) {
        if (this.f392320o == null) {
            QLog.e("RobotInfoController", 1, "mRobotInfoContext is null");
            return;
        }
        QLog.d("RobotInfoController", 4, "handleCommandItemClick, guild: ", Long.valueOf(guildChannel.b()), " channel : ", Long.valueOf(guildChannel.a()));
        String l3 = Long.toString(guildChannel.b());
        String l16 = Long.toString(guildChannel.a());
        String l17 = Long.toString(robotInfo.k());
        int channelType = ((IGuildInfoUtilsApi) QRoute.api(IGuildInfoUtilsApi.class)).getChannelType(MobileQQ.sMobileQQ.peekAppRuntime(), this.f392320o.g(), this.f392320o.c());
        if (!l16.equals("0") && ((IGuildAVPriorityManager) QRoute.api(IGuildAVPriorityManager.class)).checkIsInAudioRoom(l16) == 0 && channelType != 2) {
            y0(appRuntime, l3, l16, l17, str, 0, view, channelType);
            return;
        }
        QLog.d("RobotInfoController", 4, "handleCommandItemClick, need choose channel");
        Activity b16 = this.f392320o.b();
        if (b16 == null) {
            return;
        }
        ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).openQQGuildSelectChannelDialogFragment((FragmentActivity) b16, l3, new b(appRuntime, l3, l17, str, view, channelType));
    }

    private void X(GProGuildRobotPanelListItem gProGuildRobotPanelListItem, final View view) {
        Activity b16;
        int type = gProGuildRobotPanelListItem.getType();
        final String settingUrl = gProGuildRobotPanelListItem.getSettingUrl();
        e eVar = this.f392320o;
        if (eVar == null || (b16 = eVar.b()) == null) {
            return;
        }
        if (type == 1) {
            IMiniAppService iMiniAppService = (IMiniAppService) QRoute.api(IMiniAppService.class);
            if (!iMiniAppService.isMiniAppUrl(settingUrl)) {
                QLog.d("RobotInfoController", 1, "open robot mini app, url error : ", settingUrl);
                return;
            }
            EntryModel entryModel = new EntryModel();
            entryModel.type = -1;
            final WeakReference weakReference = new WeakReference(new MiniAppLaunchListener() { // from class: cx1.i
                @Override // com.tencent.mobileqq.mini.api.MiniAppLaunchListener
                public final void onLaunchResult(boolean z16, Bundle bundle) {
                    w.this.k0(settingUrl, view, z16, bundle);
                }
            });
            iMiniAppService.startMiniApp(b16, settingUrl, 5003, entryModel, new MiniAppLaunchListener() { // from class: cx1.j
                @Override // com.tencent.mobileqq.mini.api.MiniAppLaunchListener
                public final void onLaunchResult(boolean z16, Bundle bundle) {
                    w.j0(weakReference, z16, bundle);
                }
            });
            return;
        }
        if (type == 0) {
            cx.a(b16, settingUrl);
        } else {
            QQToast.makeText(b16, R.string.f143550md, 1).show();
        }
    }

    private boolean Y(String str, String str2, String str3, int i3, boolean z16, boolean z17) {
        boolean z18;
        sx1.c cVar = new sx1.c();
        if (i3 == 0) {
            z18 = cVar.a(str, str2, str3, z16, z17);
        } else {
            z18 = false;
        }
        boolean z19 = z18;
        if (i3 == 1) {
            ap0.f.a();
            zo0.a.m(new c(cVar, str, str2, str3, z16, z17));
        }
        return z19;
    }

    private boolean Z(int i3, int i16) {
        if (i16 == 1 && i3 == 4) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(Activity activity, int i3, String str, IGProSecurityResult iGProSecurityResult, boolean z16, com.tencent.mobileqq.qqguildsdk.data.k kVar) {
        if (i3 == 66000) {
            QQToast.makeText(activity, R.string.f153511ca, 1).show();
            return;
        }
        if (i3 == 66015) {
            QQToast.makeText(activity, R.string.f158341pc, 1).show();
            return;
        }
        if (i3 != 0 && i3 != 66014) {
            QLog.e("RobotInfoController", 1, "createDirectMsgSession network error code:" + i3 + " message: " + str);
            return;
        }
        if (!ch.p(iGProSecurityResult)) {
            QLog.e("RobotInfoController", 1, "createDirectMsgSession network error securityCode:" + iGProSecurityResult.get$actionCode() + " strPrompt: " + iGProSecurityResult.getStrPrompt() + "strDetail: " + iGProSecurityResult.getStrDetail());
            return;
        }
        if (z16) {
            QLog.i("RobotInfoController", 1, "createDirectMsgSession peer is black");
            QQToast.makeText(activity, 1, "\u4f60\u5df2\u5c4f\u853d\u6b64\u673a\u5668\u4eba", 0).show();
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("RobotInfoController", 2, kVar.toString());
        }
        QLog.d("RobotInfoController", 4, "createDirectMsgSession guildId = ", kVar.b(), " channelId = ", kVar.a());
        DirectMessageNodeRepository.P(kVar, z16);
        LaunchGuildChatPieParam N = N(kVar);
        if (!d12.a.c() && com.tencent.mobileqq.guild.mainframe.q.l()) {
            ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).launchGuildChatPie(activity, N);
        } else {
            ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).launchGuildDirectMessageAio(activity, N);
        }
        this.f392320o.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(int i3) {
        boolean z16;
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        s0(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(final int i3, String str) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: cx1.n
            @Override // java.lang.Runnable
            public final void run() {
                w.this.c0(i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(int i3, GProRobotCommonGuildRsp gProRobotCommonGuildRsp, String str) {
        if (i3 == 0 && gProRobotCommonGuildRsp != null) {
            if (this.f392320o != null) {
                this.f392325t = gProRobotCommonGuildRsp.getTotal();
                this.f392324s = gProRobotCommonGuildRsp;
                this.f392326u.d(0, gProRobotCommonGuildRsp);
                this.f392318m = true;
                GProGuildRobotInfoRsp gProGuildRobotInfoRsp = this.f392319n;
                if (gProGuildRobotInfoRsp != null) {
                    g0(gProGuildRobotInfoRsp);
                    return;
                }
                return;
            }
            return;
        }
        QLog.i("RobotInfoController", 1, "errCode =  " + i3 + "  msg = " + str);
        this.f392326u.d(0, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(final int i3, final String str, final GProRobotCommonGuildRsp gProRobotCommonGuildRsp) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: cx1.q
            @Override // java.lang.Runnable
            public final void run() {
                w.this.e0(i3, gProRobotCommonGuildRsp, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(int i3, String str, final GProGuildRobotInfoRsp gProGuildRobotInfoRsp) {
        if (i3 == 0 && gProGuildRobotInfoRsp != null) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: cx1.r
                @Override // java.lang.Runnable
                public final void run() {
                    w.this.g0(gProGuildRobotInfoRsp);
                }
            });
            return;
        }
        QLog.e("RobotInfoController", 1, "fetchGuildRobotInfo|result = " + i3 + " errMsg = " + str);
        t0(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j0(WeakReference weakReference, boolean z16, Bundle bundle) {
        MiniAppLaunchListener miniAppLaunchListener = (MiniAppLaunchListener) weakReference.get();
        if (miniAppLaunchListener != null) {
            miniAppLaunchListener.onLaunchResult(z16, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0(RobotCommonGuildFragment robotCommonGuildFragment, boolean z16) {
        if (z16) {
            this.f392320o.a();
        } else {
            this.f392320o.i().b();
        }
        if (robotCommonGuildFragment != null && !robotCommonGuildFragment.isDetached()) {
            robotCommonGuildFragment.dismissAllowingStateLoss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(int i3) {
        Activity b16 = this.f392320o.b();
        if (b16 == null) {
            return;
        }
        if (i3 == 10010) {
            QQToast.makeText(b16, R.string.f154161e2, 1).show();
        }
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final e eVar = this.f392320o;
        Objects.requireNonNull(eVar);
        uIHandlerV2.postDelayed(new Runnable() { // from class: cx1.g
            @Override // java.lang.Runnable
            public final void run() {
                e.this.a();
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(int i3, String str) {
        boolean z16;
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        u0(z16, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(final int i3, final String str, GProGuildRobotUpMicRsp gProGuildRobotUpMicRsp) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: cx1.l
            @Override // java.lang.Runnable
            public final void run() {
                w.this.n0(i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void i0(AppRuntime appRuntime, GuildChannel guildChannel, RobotInfo robotInfo, int i3, String str) {
        boolean z16;
        int i16;
        int i17 = 1;
        QLog.i("RobotInfoController", 1, "authorize add, code: " + i3 + ", message: " + str);
        if (i3 == -2) {
            return;
        }
        if (i3 == 10032) {
            Activity b16 = this.f392320o.b();
            if (b16 == null) {
                return;
            }
            QQToast.makeText(b16, R.string.f153371bx, 1).show();
            return;
        }
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        e eVar = this.f392320o;
        if (eVar != null && !eVar.s() && !this.f392320o.p()) {
            p0(z16);
            if (this.f392320o.o()) {
                oidb_0x106a$RobotInfo oidb_0x106a_robotinfo = new oidb_0x106a$RobotInfo();
                oidb_0x106a_robotinfo.robot_tid.set(robotInfo.k());
                oidb_0x106a_robotinfo.robot_uin.set(robotInfo.l());
                A0(guildChannel, this.f392320o.k());
            }
        } else if (appRuntime != null) {
            if (z16) {
                i17 = 2;
            }
            if (z16) {
                i16 = R.string.f154601f9;
            } else {
                i16 = R.string.f154591f8;
            }
            QQToast.makeText(appRuntime.getApplicationContext(), i17, i16, 0).show();
        }
        w0(appRuntime, guildChannel, robotInfo, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0(boolean z16, String str, Boolean bool) {
        String qqStr;
        String string;
        if (z16) {
            U(this.f392320o.f(), this.f392320o.k());
            T(MobileQQ.sMobileQQ.peekAppRuntime(), this.f392320o.k());
            BaseApplication context = BaseApplication.getContext();
            if (bool.booleanValue()) {
                string = context.getString(R.string.f152301_1);
            } else {
                string = context.getString(R.string.f1500413x);
            }
            QQToast.makeText(context, 2, string, 0).show();
        } else {
            if (bool.booleanValue()) {
                qqStr = HardCodeUtil.qqStr(R.string.f152291_0);
            } else {
                qqStr = HardCodeUtil.qqStr(R.string.f1500313w);
            }
            if (TextUtils.isEmpty(str)) {
                str = qqStr;
            }
            ch.e1(1, str);
        }
        Q();
    }

    private void t0(final int i3) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: cx1.s
            @Override // java.lang.Runnable
            public final void run() {
                w.this.m0(i3);
            }
        });
    }

    private void u0(boolean z16, String str) {
        if (z16) {
            U(this.f392320o.f(), this.f392320o.k());
            T(MobileQQ.sMobileQQ.peekAppRuntime(), this.f392320o.k());
            Q();
            return;
        }
        QQToast.makeText(BaseApplication.getContext(), 4, str, 0).show();
    }

    private void v0(int i3, int i16, int i17) {
        int i18;
        if (this.f392320o == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("RobotInfoController", 2, "refreshRobotState, muStatus:" + i3 + ", punishmentStatus:" + i16 + ", testStatus:" + i17);
        }
        this.f392313h = true;
        if (i3 != 1) {
            i18 = 0;
        } else {
            d dVar = this.f392326u;
            i18 = R.string.f153981dk;
            dVar.d(1, Integer.valueOf(R.string.f153981dk));
            z0(true, R.string.f153981dk);
        }
        if (i16 != 3) {
            if (i16 == 4) {
                boolean Z = Z(i16, i17);
                i18 = R.string.f153961di;
                if (Z) {
                    z0(false, R.string.f153961di);
                } else {
                    this.f392326u.d(1, Integer.valueOf(R.string.f153961di));
                    z0(true, R.string.f153961di);
                }
            }
        } else {
            this.f392313h = false;
            int robotTestStatus = this.f392319n.getRobotTestStatus();
            i18 = R.string.f153971dj;
            if (robotTestStatus != 1 && robotTestStatus != 2) {
                this.f392320o.v(R.string.f153971dj);
            } else {
                this.f392313h = true;
            }
            this.f392326u.d(1, Integer.valueOf(R.string.f153971dj));
            z0(true, R.string.f153971dj);
        }
        if (i18 == 0) {
            this.f392326u.d(2, null);
            z0(false, i18);
        }
    }

    private void w0(AppRuntime appRuntime, GuildChannel guildChannel, RobotInfo robotInfo, boolean z16) {
        Object obj;
        d dVar = this.f392326u;
        if (z16 && dVar != null && appRuntime != null) {
            HashMap<String, Object> a16 = dVar.a();
            EventData.Builder withParam = EventData.builder().withId("ev_sgrp_robot_add_success").withParam("qq_robot_type", 2).withParam("to_uin", Long.valueOf(guildChannel.b())).withParam("add_type", 3).withParam("robot_id", Long.valueOf(robotInfo.l()));
            if (a16 != null) {
                obj = a16.get("robot_import_source");
            } else {
                obj = null;
            }
            VideoReport.reportEvent(withParam.withParam("robot_import_source", obj).withParam("uin", appRuntime.getCurrentUin()).build());
        }
    }

    public static void x0(String str, int i3, String str2, View view) {
        HashMap hashMap = new HashMap();
        hashMap.put("qq_robot_function_url", str);
        if (i3 != 0 && i3 != 2 && i3 != 1) {
            hashMap.put("qq_robot_error_code", String.valueOf(i3));
            hashMap.put("qq_robot_error_field", str2);
            i3 = 3;
        }
        hashMap.put("qq_robot_jump_result", Integer.valueOf(i3));
        VideoReport.reportEvent("ev_qqrobot_service_jump", view, hashMap);
    }

    private void z0(boolean z16, int i3) {
        this.f392321p = z16;
        this.f392322q = i3;
    }

    public void A0(GuildChannel guildChannel, RobotInfo robotInfo) {
        com.tencent.qqnt.kernel.api.ac g16 = sx1.f.g();
        if (g16 == null) {
            return;
        }
        g16.upMicGuildRobot(new GProGuildRobotUpMicReq(guildChannel.b(), guildChannel.a(), robotInfo.l(), false, new ArrayList(0), robotInfo.k()), new IUpMicGuildRobotCallback() { // from class: cx1.k
            @Override // com.tencent.qqnt.kernel.nativeinterface.IUpMicGuildRobotCallback
            public final void onUpMicGuildRobot(int i3, String str, GProGuildRobotUpMicRsp gProGuildRobotUpMicRsp) {
                w.this.o0(i3, str, gProGuildRobotUpMicRsp);
            }
        });
    }

    public void K(RobotInfo robotInfo, boolean z16, int i3) {
        if (z16) {
            QQToast.makeText(BaseApplication.getContext(), 0, i3, 0).show();
            return;
        }
        Activity b16 = this.f392320o.b();
        if (b16 == null) {
            return;
        }
        if (this.f392315j == 1) {
            QQToast.makeText(b16, 0, R.string.f154171e3, 0).show();
        } else {
            RobotJoinGuildFragment.Uh(b16, robotInfo, this.f392326u.a());
        }
    }

    public void L(final AppRuntime appRuntime, final GuildChannel guildChannel, final RobotInfo robotInfo, boolean z16, int i3) {
        if (z16) {
            QQToast.makeText(BaseApplication.getContext(), 0, i3, 0).show();
            return;
        }
        if (guildChannel != null && robotInfo != null) {
            Activity b16 = this.f392320o.b();
            if (b16 == null) {
                return;
            }
            RobotAuthorizeAddFragment.Jh((FragmentActivity) b16, appRuntime, guildChannel, robotInfo, this.f392328w, new vw1.d() { // from class: cx1.m
                @Override // vw1.d
                public final void a(int i16, String str) {
                    w.this.a0(appRuntime, guildChannel, robotInfo, i16, str);
                }
            }, "\u673a\u5668\u4eba\u8d44\u6599\u5361");
            return;
        }
        QLog.i("RobotInfoController", 1, "handleRobotFuncBtnClick data is null");
    }

    public boolean M() {
        return this.f392314i;
    }

    public LaunchGuildChatPieParam N(com.tencent.mobileqq.qqguildsdk.data.k kVar) {
        Bundle bundle = new Bundle();
        bundle.putByte(AppConstants.Key.GUILD_DIRECT_MESSAGE_FLAG, (byte) 1);
        bundle.putInt(AppConstants.Key.GUILD_DIRECT_MESSAGE_TYPE, 2);
        return new LaunchGuildChatPieParam().l(kVar.b()).b(kVar.a()).r(true).o(1).g(5).k(bundle).q("").a();
    }

    public void P(GuildChannel guildChannel, RobotInfo robotInfo, Boolean bool) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.valueOf(robotInfo.k()));
        GuildRemoveGuildDialogFragment.vh((FragmentActivity) this.f392320o.b(), String.valueOf(guildChannel.b()), arrayList, true, true, bool.booleanValue(), new a(guildChannel, arrayList));
        this.f392320o.m();
    }

    public void Q() {
        e eVar = this.f392320o;
        if (eVar != null && eVar.n()) {
            QLog.i("RobotInfoController", 1, "dismiss RobotInfoFragment");
            this.f392320o.a();
        }
    }

    public void S(int i3, int i16, long j3, long j16) {
        com.tencent.qqnt.kernel.api.ac g16 = sx1.f.g();
        if (g16 == null) {
            return;
        }
        g16.fetchRobotCommonGuild(new GProRobotCommonGuildReq(j3, i3, i16, j16, 1, 0L, new ArrayList(), new ArrayList()), new IGProFetchRobotCommonGuildCallback() { // from class: cx1.o
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGProFetchRobotCommonGuildCallback
            public final void onFetchRobotCommonGuild(int i17, String str, GProRobotCommonGuildRsp gProRobotCommonGuildRsp) {
                w.this.f0(i17, str, gProRobotCommonGuildRsp);
            }
        });
    }

    public void T(AppRuntime appRuntime, RobotInfo robotInfo) {
        S(0, 20, robotInfo.l(), robotInfo.k());
    }

    public void U(GuildChannel guildChannel, RobotInfo robotInfo) {
        com.tencent.qqnt.kernel.api.ac g16 = sx1.f.g();
        if (g16 == null) {
            return;
        }
        g16.fetchGuildRobotInfo(sx1.f.b(guildChannel, robotInfo, 0), new IGProFetchGuildRobotInfoCallback() { // from class: cx1.p
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGProFetchGuildRobotInfoCallback
            public final void onFetchGuildRobotInfo(int i3, String str, GProGuildRobotInfoRsp gProGuildRobotInfoRsp) {
                w.this.h0(i3, str, gProGuildRobotInfoRsp);
            }
        });
    }

    public void W(final AppRuntime appRuntime, final GuildChannel guildChannel, final RobotInfo robotInfo, boolean z16, int i3) {
        if (com.tencent.mobileqq.guild.util.o.c("RobotInfoController")) {
            QLog.d("RobotInfoController", 1, "handleRobotFuncBtnClick fast click");
            return;
        }
        Activity b16 = this.f392320o.b();
        if (b16 == null) {
            return;
        }
        if (sx1.f.i(this.f392307b, this.f392308c)) {
            if (this.f392306a) {
                o(true);
                return;
            }
            if (z16) {
                QQToast.makeText(BaseApplication.getContext(), 0, i3, 0).show();
                return;
            } else if (guildChannel != null && robotInfo != null) {
                RobotAuthorizeAddFragment.Jh((FragmentActivity) b16, appRuntime, guildChannel, robotInfo, this.f392328w, new vw1.d() { // from class: cx1.t
                    @Override // vw1.d
                    public final void a(int i16, String str) {
                        w.this.i0(appRuntime, guildChannel, robotInfo, i16, str);
                    }
                }, "\u673a\u5668\u4eba\u8d44\u6599\u5361");
                return;
            } else {
                QLog.i("RobotInfoController", 1, "handleRobotFuncBtnClick data is null");
                return;
            }
        }
        if (z16) {
            QQToast.makeText(BaseApplication.getContext(), 0, i3, 0).show();
        } else {
            RobotJoinGuildFragment.Uh(b16, robotInfo, this.f392326u.a());
        }
    }

    @Override // cx1.a
    public void a() {
        A0(this.f392320o.f(), this.f392320o.k());
    }

    @Override // cx1.a
    public void b(View view) {
        if (this.f392321p) {
            QQToast.makeText(BaseApplication.getContext(), 0, this.f392322q, 0).show();
            return;
        }
        if (!M()) {
            QQToast.makeText(BaseApplication.getContext(), 0, R.string.f154171e3, 0).show();
            return;
        }
        this.f392320o.a();
        Activity b16 = this.f392320o.b();
        if (b16 == null) {
            return;
        }
        new com.tencent.mobileqq.guild.robot.components.share.b(b16, this.f392320o.k()).i();
    }

    @Override // cx1.a
    public void c() {
        Activity b16 = this.f392320o.b();
        if (b16 == null) {
            return;
        }
        if (this.f392319n.getRobotTestStatus() != 1 && this.f392319n.getRobotTestStatus() != 2 && this.f392321p) {
            QQToast.makeText(BaseApplication.getContext(), 0, this.f392322q, 0).show();
            return;
        }
        GProGuildRobotData gProGuildRobotData = this.f392323r;
        if (gProGuildRobotData != null && gProGuildRobotData.getStatus() != 1) {
            QQToast.makeText(b16, b16.getString(R.string.f154141e0), 1).show();
        } else if (this.f392307b == 0) {
            QQToast.makeText(b16, 0, R.string.f153551ce, 0).show();
        } else {
            ((IGuildRobotPageApi) QRoute.api(IGuildRobotPageApi.class)).jumpRobotPushSettingPage(b16, this.f392320o.g(), String.valueOf(this.f392320o.k().k()), this.f392307b, 1);
        }
    }

    @Override // cx1.a
    public void d(GProGuildRobotPanelListItem gProGuildRobotPanelListItem, View view) {
        if (this.f392321p) {
            QQToast.makeText(BaseApplication.getContext(), 0, this.f392322q, 0).show();
            return;
        }
        Activity b16 = this.f392320o.b();
        if (b16 == null) {
            return;
        }
        GProGuildRobotData gProGuildRobotData = this.f392323r;
        if (gProGuildRobotData != null && gProGuildRobotData.getStatus() != 1) {
            QQToast.makeText(b16, b16.getString(R.string.f153381by), 1).show();
            return;
        }
        if (gProGuildRobotPanelListItem.getStatus() != 0) {
            String availableRangeDesc = gProGuildRobotPanelListItem.getAvailableRangeDesc();
            if (availableRangeDesc.equals("")) {
                availableRangeDesc = b16.getString(R.string.f153551ce);
            }
            QQToast.makeText(b16, 0, availableRangeDesc, 0).show();
            return;
        }
        B0(gProGuildRobotPanelListItem.getOffInfo().getTitle());
        X(gProGuildRobotPanelListItem, view);
    }

    @Override // cx1.a
    public void e(GProGuildRobotFeatureInfo gProGuildRobotFeatureInfo, View view) {
        Activity b16 = this.f392320o.b();
        if (b16 == null) {
            return;
        }
        if (this.f392321p) {
            QQToast.makeText(BaseApplication.getContext(), 0, this.f392322q, 0).show();
            return;
        }
        GProGuildRobotData gProGuildRobotData = this.f392323r;
        if (gProGuildRobotData != null && gProGuildRobotData.getStatus() != 1) {
            QQToast.makeText(b16, b16.getString(R.string.f153381by), 1).show();
            return;
        }
        if (gProGuildRobotFeatureInfo.getStatus() != 0) {
            String availableRangeDesc = gProGuildRobotFeatureInfo.getAvailableRangeDesc();
            if (availableRangeDesc.equals("")) {
                availableRangeDesc = b16.getString(R.string.f153551ce);
            }
            QQToast.makeText(b16, 0, availableRangeDesc, 0).show();
            return;
        }
        B0(gProGuildRobotFeatureInfo.getName());
        V(MobileQQ.sMobileQQ.peekAppRuntime(), this.f392320o.f(), this.f392320o.k(), gProGuildRobotFeatureInfo.getName(), view);
    }

    @Override // cx1.a
    public void f() {
        W(MobileQQ.sMobileQQ.peekAppRuntime(), this.f392320o.f(), this.f392320o.k(), this.f392321p, this.f392322q);
    }

    @Override // cx1.a
    public void g() {
        P(this.f392320o.f(), this.f392320o.k(), Boolean.FALSE);
    }

    @Override // cx1.a
    public boolean h() {
        return this.f392306a;
    }

    @Override // cx1.a
    public void i() {
        L(MobileQQ.sMobileQQ.peekAppRuntime(), this.f392320o.f(), this.f392320o.k(), this.f392321p, this.f392322q);
    }

    @Override // cx1.a
    public boolean j() {
        return this.f392327v;
    }

    @Override // cx1.a
    public void k() {
        R(this.f392320o.f(), this.f392320o.k());
    }

    @Override // cx1.a
    public void l() {
        e eVar;
        if (this.f392310e && (eVar = this.f392320o) != null) {
            RobotMoreSettingDialogFragment.Hh(eVar, this.f392321p, this.f392322q, this.f392319n, this);
            Q();
        }
    }

    @Override // cx1.a
    public void m() {
        P(this.f392320o.f(), this.f392320o.k(), Boolean.TRUE);
    }

    @Override // cx1.a
    public void n() {
        Activity b16 = this.f392320o.b();
        if (b16 == null) {
            QLog.e("RobotInfoController", 1, "mActivity = NULL ");
            return;
        }
        Gson gson = new Gson();
        Bundle bundle = new Bundle();
        bundle.putString("ROBOT_INFO_KEY", gson.toJson(this.f392320o.k()));
        bundle.putSerializable("ROBOT_COMMON_GUILD_DA_TONG_DATA", this.f392326u.a());
        final RobotCommonGuildFragment robotCommonGuildFragment = new RobotCommonGuildFragment();
        robotCommonGuildFragment.setArguments(bundle);
        if (b16 instanceof FragmentActivity) {
            robotCommonGuildFragment.show(((FragmentActivity) b16).getSupportFragmentManager(), RobotCommonGuildFragment.class.getName());
        }
        robotCommonGuildFragment.uh(new RobotCommonGuildFragment.a() { // from class: cx1.u
            @Override // com.tencent.mobileqq.guild.robot.components.guilds.RobotCommonGuildFragment.a
            public final void onDismiss(boolean z16) {
                w.this.l0(robotCommonGuildFragment, z16);
            }
        });
        this.f392320o.i().c();
    }

    @Override // cx1.a
    public void o(boolean z16) {
        IGPSService iGPSService;
        IGProGuildInfo guildInfo;
        if (MobileQQ.sMobileQQ.peekAppRuntime() != null && this.f392323r != null) {
            final Activity b16 = this.f392320o.b();
            if (b16 == null || (guildInfo = (iGPSService = (IGPSService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGPSService.class, "")).getGuildInfo(this.f392320o.g())) == null) {
                return;
            }
            com.tencent.mobileqq.qqguildsdk.data.i iVar = new com.tencent.mobileqq.qqguildsdk.data.i();
            if (z16) {
                iVar.f266704b = this.f392320o.g();
            } else {
                int size = this.f392324s.getGuilds().size();
                if (size <= 0) {
                    QLog.e("RobotInfoController", 2, "size = 0 robotUin = " + this.f392323r.getRobotUin() + " tid = " + this.f392323r.getRobotTid());
                    return;
                }
                iVar.f266704b = String.valueOf(this.f392324s.getGuilds().get(size - 1).getGuildId());
            }
            if (QLog.isColorLevel()) {
                QLog.d("RobotInfoController", 1, "guild id = " + iVar.f266704b);
            }
            iVar.f266703a = String.valueOf(this.f392323r.getRobotTid());
            iVar.f266707e = this.f392323r.getRobotName();
            iVar.f266706d = this.f392323r.getRobotName();
            iVar.f266705c = guildInfo.getGuildName();
            iGPSService.createDirectMsgSession(iVar, new vh2.h() { // from class: cx1.h
                @Override // vh2.h
                public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult, boolean z17, com.tencent.mobileqq.qqguildsdk.data.k kVar) {
                    w.this.b0(b16, i3, str, iGProSecurityResult, z17, kVar);
                }
            });
            return;
        }
        QLog.e("RobotInfoController", 2, "MobileQQ.sMobileQQ.peekAppRuntime() = " + MobileQQ.sMobileQQ.peekAppRuntime() + " mRobotData = " + this.f392323r);
    }

    @Override // cx1.c
    public void onCreateView() {
        this.f392326u = this.f392320o.i();
    }

    @Override // cx1.c
    public void p() {
        U(this.f392320o.f(), this.f392320o.k());
        T(MobileQQ.sMobileQQ.peekAppRuntime(), this.f392320o.k());
    }

    public void p0(boolean z16) {
        if (z16) {
            U(this.f392320o.f(), this.f392320o.k());
            T(MobileQQ.sMobileQQ.peekAppRuntime(), this.f392320o.k());
            QQToast.makeText(BaseApplication.getContext(), 2, R.string.f154601f9, 0).show();
            this.f392327v = true;
            return;
        }
        QQToast.makeText(BaseApplication.getContext(), 4, R.string.f154591f8, 0).show();
    }

    @Override // cx1.a
    public void q(ox1.i iVar) {
        e eVar;
        if (this.f392310e && (eVar = this.f392320o) != null) {
            RobotMoreSettingDialogFragment.Ih(eVar, this.f392321p, this.f392322q, this.f392319n, this, iVar);
            Q();
        }
    }

    @Override // cx1.a
    public void r() {
        K(this.f392320o.k(), this.f392321p, this.f392322q);
    }

    public void s0(boolean z16) {
        if (z16) {
            U(this.f392320o.f(), this.f392320o.k());
            T(MobileQQ.sMobileQQ.peekAppRuntime(), this.f392320o.k());
            Q();
            return;
        }
        QQToast.makeText(MobileQQ.sMobileQQ.peekAppRuntime().getApplicationContext(), 4, MobileQQ.sMobileQQ.peekAppRuntime().getApplicationContext().getString(R.string.f143360lv), 0).show();
    }

    public void y0(AppRuntime appRuntime, String str, String str2, String str3, String str4, int i3, View view, int i16) {
        Activity b16;
        boolean z16;
        e eVar = this.f392320o;
        if (eVar == null || (b16 = eVar.b()) == null) {
            return;
        }
        if (this.f392320o.q()) {
            o(true);
        } else if (!((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isChatFragmentShowing(((IGuildTempApi) QRoute.api(IGuildTempApi.class)).getSplashActivity()) && (!this.f392320o.r() || (str2 != null && !str2.equals(this.f392320o.c())))) {
            if (d12.a.c()) {
                com.tencent.mobileqq.guild.api.i a16 = new com.tencent.mobileqq.guild.api.i().f(str).b(str2).d(com.tencent.guild.aio.factory.a.class.getName()).a();
                if (AppSetting.t(b16)) {
                    ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).launchGuildChatFragment(b16, a16);
                } else {
                    ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).launchGuildChatActivity(b16, a16);
                }
            } else {
                ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).launchGuildChatPie(b16, new LaunchGuildChatPieParam().l(str).b(str2).r(true).f(true).a());
            }
        }
        this.f392320o.a();
        String str5 = this.f392309d;
        if (i16 == 5) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (Y(str3, str5, str4, i3, z16, this.f392320o.q())) {
            HashMap hashMap = new HashMap();
            hashMap.put("qq_robot_oder_jump_result", "jumped");
            VideoReport.reportEvent("ev_qqrobot_order_jump", view, hashMap);
        }
    }

    @Override // cx1.c
    public void onDestroy() {
    }

    @Override // cx1.c
    public void onPause() {
    }

    @Override // cx1.c
    public void onResume() {
    }

    @Override // cx1.c
    public void onStop() {
    }
}
