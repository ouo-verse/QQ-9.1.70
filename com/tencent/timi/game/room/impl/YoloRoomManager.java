package com.tencent.timi.game.room.impl;

import android.app.Dialog;
import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.timi.game.app.event.AppBecomeBackgroundEvent;
import com.tencent.timi.game.app.event.AppBecomeForegroundEvent;
import com.tencent.timi.game.room.impl.YoloVoiceChangeAlertUtil;
import com.tencent.timi.game.room.impl.c;
import com.tencent.timi.game.room.impl.doublecheck.RoomGameDoubleCheckDialog;
import com.tencent.timi.game.room.impl.tgpa.YoloRoomTGPALogic;
import com.tencent.timi.game.room.impl.util.YoloRoomFloatViewUtil;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.team.impl.event.TeamLaneEvent;
import com.tencent.timi.game.trtc.roomservice.multipevoiceroom.TimiGameQQTrtcUtil;
import com.tencent.timi.game.ui.widget.e;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.utils.IResultListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.MobileQQ;
import mqq.util.LogUtil;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.MessageOuterClass$YoloRoomActionMsg;
import trpc.yes.common.MessageOuterClass$YoloRoomNewDataPushMsg;
import trpc.yes.common.SafeOuterClass$SafeCheckResult;
import trpc.yes.common.SmobaDataOuterClass$YoloTeamInfo;
import trpc.yes.common.SmobaDataOuterClass$YoloTeamMemberInfo;
import trpc.yes.common.YoloRoomOuterClass$DoYoloRoomCmdRsp;
import trpc.yes.common.YoloRoomOuterClass$GetYoloRoomDataRsp;
import trpc.yes.common.YoloRoomOuterClass$YoloBattleOBStatusChangeAction;
import trpc.yes.common.YoloRoomOuterClass$YoloCommonGameDataInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloCommonGameOneSchema;
import trpc.yes.common.YoloRoomOuterClass$YoloCommonGameRouteInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloCommonGameSchema;
import trpc.yes.common.YoloRoomOuterClass$YoloGameDataInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloGameRoomOwnerChangeAction;
import trpc.yes.common.YoloRoomOuterClass$YoloGameRoomRemindStartGameCmd;
import trpc.yes.common.YoloRoomOuterClass$YoloGameRouteInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomAction;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomAgreeSpeakingCmd;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomApplySpeakingAction;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomApplySpeakingCmd;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomCmdReq;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomCmdRsp;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomConf;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomDataInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomDoubleCheckCmd;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomDoubleCheckPlayer;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomForbiddenSpeechAction;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomForbiddenSpeechCmd;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomForbiddenSpeechConf;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInvitedSpeakingAction;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInvitedSpeakingCmd;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomJoinGameAction;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomJoinGameCmd;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomJoinGameCmdRsp;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomKickOutRoomAction;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomKickOutRoomCmd;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomKickOutSpeakingAction;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomKickOutSpeakingCmd;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomLeaveRsp;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomModifyInfoAction;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomModifyInfoActionContent;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomModifyInfoCmd;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomReadyStatusChangeAction;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomReadyStatusChangeCmd;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomRejectSpeakingCmd;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomSpeakingPosChangeAction;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomSpeakingPosChangeCmd;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomSpeakingPosInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomSpeakingPosListInitAction;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomSpeakingPosStatusChangeAction;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomSpeakingPosStatusChangeCmd;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomSpeakingUserStatusUpdateAction;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomSpeakingUserUpdateCmd;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomStartGameAction;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomStartGameCmd;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomStartGameCmdRsp;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomUpdateGameRouteInfoAction;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomUserData;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomVoiceSwitchChangeAction;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomVoiceSwitchChangeCmd;
import trpc.yes.common.YoloRoomOuterClass$YoloSmobaGameDataInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloSmobaRoomChooceHeroAction;
import trpc.yes.common.YoloRoomOuterClass$YoloSmobaRoomChooceHeroCmd;
import trpc.yes.common.YoloRoomOuterClass$YoloSmobaRoomOwnerChangeAction;
import trpc.yes.common.YoloRoomOuterClass$YoloSmobaRoomRemindStartGameCmd;
import trpc.yes.common.YoloRoomOuterClass$YoloUserGameData;
import trpc.yes.wuji.WujiYoloRoomOuterClass$WujiYoloSmobaRoomConf;

/* compiled from: P */
/* loaded from: classes26.dex */
public class YoloRoomManager implements gm4.c, gm4.b, gm4.d, SimpleEventReceiver {
    private int C;
    private int D;
    private YoloRoomOuterClass$YoloRoomConf H;
    private long I;
    private YoloRoomOuterClass$YoloGameRouteInfo K;
    private YoloRoomOuterClass$YoloCommonGameOneSchema L;
    private boolean M;

    /* renamed from: d, reason: collision with root package name */
    private YoloRoomOuterClass$YoloRoomInfo f379034d;

    /* renamed from: e, reason: collision with root package name */
    private YoloRoomOuterClass$YoloRoomUserData f379036e;

    /* renamed from: h, reason: collision with root package name */
    private long f379041h;

    /* renamed from: i, reason: collision with root package name */
    private CommonOuterClass$QQUserId f379043i;

    /* renamed from: m, reason: collision with root package name */
    private CommonOuterClass$QQUserId f379048m;

    /* renamed from: n0, reason: collision with root package name */
    private hm4.a f379050n0;

    /* renamed from: o0, reason: collision with root package name */
    private RoomGameDoubleCheckDialog f379051o0;

    /* renamed from: p0, reason: collision with root package name */
    private Dialog f379052p0;

    /* renamed from: q0, reason: collision with root package name */
    private com.tencent.timi.game.room.impl.c f379053q0;

    /* renamed from: f, reason: collision with root package name */
    private MutableLiveData<YoloRoomOuterClass$YoloRoomInfo> f379038f = new j();
    private List<Long> E = new CopyOnWriteArrayList();
    private List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> F = new ArrayList();
    private int G = -1;
    private int J = 0;
    private int N = -1;
    private long P = 0;
    private long Q = 0;
    private int R = 15000;
    private long S = 0;
    private volatile boolean T = false;
    private volatile boolean U = true;
    private volatile boolean V = false;
    private volatile boolean W = false;
    private volatile long X = 0;
    private HashMap<Long, Boolean> Y = new HashMap<>();
    private volatile boolean Z = false;

    /* renamed from: a0, reason: collision with root package name */
    private volatile boolean f379031a0 = false;

    /* renamed from: b0, reason: collision with root package name */
    private HashMap<String, WeakReference<fm4.f>> f379032b0 = new HashMap<>();

    /* renamed from: c0, reason: collision with root package name */
    private ConcurrentHashMap<String, String> f379033c0 = new ConcurrentHashMap<>();

    /* renamed from: d0, reason: collision with root package name */
    private CopyOnWriteArrayList<fm4.v> f379035d0 = new CopyOnWriteArrayList<>();

    /* renamed from: e0, reason: collision with root package name */
    private CopyOnWriteArrayList<fm4.r> f379037e0 = new CopyOnWriteArrayList<>();

    /* renamed from: f0, reason: collision with root package name */
    private CopyOnWriteArrayList<fm4.q> f379039f0 = new CopyOnWriteArrayList<>();

    /* renamed from: g0, reason: collision with root package name */
    private CopyOnWriteArrayList<fm4.p> f379040g0 = new CopyOnWriteArrayList<>();

    /* renamed from: h0, reason: collision with root package name */
    private CopyOnWriteArrayList<fm4.t> f379042h0 = new CopyOnWriteArrayList<>();

    /* renamed from: i0, reason: collision with root package name */
    private CopyOnWriteArrayList<fm4.w> f379044i0 = new CopyOnWriteArrayList<>();

    /* renamed from: j0, reason: collision with root package name */
    private CopyOnWriteArrayList<fm4.u> f379045j0 = new CopyOnWriteArrayList<>();

    /* renamed from: k0, reason: collision with root package name */
    private CopyOnWriteArrayList<fm4.s> f379046k0 = new CopyOnWriteArrayList<>();

    /* renamed from: l0, reason: collision with root package name */
    private HashMap<Integer, fm4.n> f379047l0 = new HashMap<>();

    /* renamed from: m0, reason: collision with root package name */
    private List<com.tencent.timi.game.room.impl.a> f379049m0 = new ArrayList();

    /* renamed from: r0, reason: collision with root package name */
    private boolean f379054r0 = false;

    /* renamed from: s0, reason: collision with root package name */
    private boolean f379055s0 = false;

    /* renamed from: t0, reason: collision with root package name */
    private gm4.e f379056t0 = new u();

    /* renamed from: u0, reason: collision with root package name */
    private fm4.p f379057u0 = new ac();

    /* renamed from: v0, reason: collision with root package name */
    private fm4.q f379058v0 = new aj();

    /* renamed from: w0, reason: collision with root package name */
    private fm4.v f379059w0 = new ap();

    /* renamed from: x0, reason: collision with root package name */
    private fm4.t f379060x0 = new aq();

    /* renamed from: y0, reason: collision with root package name */
    private ln4.a f379061y0 = new ar();

    /* renamed from: z0, reason: collision with root package name */
    private Runnable f379062z0 = new Runnable() { // from class: com.tencent.timi.game.room.impl.YoloRoomManager.8
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (YoloRoomManager.this.f379041h > 0) {
                    YoloRoomManager.this.y2();
                }
            } catch (Exception unused) {
                com.tencent.timi.game.utils.l.f("YoloRoomManager", "requestRunnable mRoomId ERROR", new Exception());
                if (eh4.a.c()) {
                    com.tencent.timi.game.utils.w.c(new Runnable() { // from class: com.tencent.timi.game.room.impl.YoloRoomManager.8.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.timi.game.ui.widget.f.c("\u4ec5\u6d4b\u8bd5\u51fa\u73b0\uff1a\n\u62c9\u53d6roomdata\u5f02\u5e38\uff0c\u8bf7\u4e0a\u4f20\u65e5\u5fd7");
                        }
                    });
                }
            }
        }
    };
    private fm4.r A0 = new as();
    private fm4.w B0 = new a();
    private fm4.u C0 = new b();
    private boolean D0 = false;
    private gm4.a E0 = new c();
    private gh4.d F0 = null;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements fm4.w {
        a() {
        }

        @Override // fm4.w
        public void g() {
            Iterator it = YoloRoomManager.this.f379044i0.iterator();
            while (it.hasNext()) {
                ((fm4.w) it.next()).g();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class aa implements fm4.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener f379068a;

        aa(IResultListener iResultListener) {
            this.f379068a = iResultListener;
        }

        @Override // fm4.b
        public void a(YoloRoomOuterClass$YoloRoomCmdRsp yoloRoomOuterClass$YoloRoomCmdRsp, long j3, boolean z16, YoloRoomOuterClass$DoYoloRoomCmdRsp yoloRoomOuterClass$DoYoloRoomCmdRsp) {
            if (!z16) {
                YoloRoomManager.this.Q1();
            }
            IResultListener iResultListener = this.f379068a;
            if (iResultListener != null) {
                iResultListener.onSuccess(yoloRoomOuterClass$YoloRoomCmdRsp);
            }
        }

        @Override // fm4.b
        public void b(int i3, String str, long j3, boolean z16) {
            com.tencent.timi.game.ui.widget.f.d(true, str);
            IResultListener iResultListener = this.f379068a;
            if (iResultListener != null) {
                iResultListener.onError(i3, str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class ab implements fm4.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener f379070a;

        ab(IResultListener iResultListener) {
            this.f379070a = iResultListener;
        }

        @Override // fm4.b
        public void a(YoloRoomOuterClass$YoloRoomCmdRsp yoloRoomOuterClass$YoloRoomCmdRsp, long j3, boolean z16, YoloRoomOuterClass$DoYoloRoomCmdRsp yoloRoomOuterClass$DoYoloRoomCmdRsp) {
            if (!z16) {
                YoloRoomManager.this.Q1();
            }
            IResultListener iResultListener = this.f379070a;
            if (iResultListener != null) {
                iResultListener.onSuccess(yoloRoomOuterClass$YoloRoomCmdRsp);
            }
        }

        @Override // fm4.b
        public void b(int i3, String str, long j3, boolean z16) {
            com.tencent.timi.game.ui.widget.f.d(true, str);
            IResultListener iResultListener = this.f379070a;
            if (iResultListener != null) {
                iResultListener.onError(i3, str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class ac implements fm4.p {
        ac() {
        }

        @Override // fm4.p
        public void a(ConcurrentHashMap<String, Integer> concurrentHashMap) {
            Iterator it = YoloRoomManager.this.f379040g0.iterator();
            while (it.hasNext()) {
                ((fm4.p) it.next()).a(concurrentHashMap);
            }
        }

        @Override // fm4.p
        public void h(sn4.a aVar) {
            Iterator it = YoloRoomManager.this.f379040g0.iterator();
            while (it.hasNext()) {
                ((fm4.p) it.next()).h(aVar);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class ad implements fm4.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener f379073a;

        ad(IResultListener iResultListener) {
            this.f379073a = iResultListener;
        }

        @Override // fm4.b
        public void a(YoloRoomOuterClass$YoloRoomCmdRsp yoloRoomOuterClass$YoloRoomCmdRsp, long j3, boolean z16, YoloRoomOuterClass$DoYoloRoomCmdRsp yoloRoomOuterClass$DoYoloRoomCmdRsp) {
            if (!z16) {
                YoloRoomManager.this.Q1();
            }
            IResultListener iResultListener = this.f379073a;
            if (iResultListener != null) {
                iResultListener.onSuccess(yoloRoomOuterClass$YoloRoomCmdRsp);
            }
        }

        @Override // fm4.b
        public void b(int i3, String str, long j3, boolean z16) {
            IResultListener iResultListener = this.f379073a;
            if (iResultListener != null) {
                iResultListener.onError(i3, str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class ae implements fm4.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f379075a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IResultListener f379076b;

        ae(int i3, IResultListener iResultListener) {
            this.f379075a = i3;
            this.f379076b = iResultListener;
        }

        @Override // fm4.b
        public void a(YoloRoomOuterClass$YoloRoomCmdRsp yoloRoomOuterClass$YoloRoomCmdRsp, long j3, boolean z16, YoloRoomOuterClass$DoYoloRoomCmdRsp yoloRoomOuterClass$DoYoloRoomCmdRsp) {
            if (!z16) {
                YoloRoomManager.this.Q1();
            }
            SimpleEventBus.getInstance().dispatchEvent(new TeamLaneEvent(this.f379075a));
            IResultListener iResultListener = this.f379076b;
            if (iResultListener != null) {
                iResultListener.onSuccess(yoloRoomOuterClass$YoloRoomCmdRsp);
            }
        }

        @Override // fm4.b
        public void b(int i3, String str, long j3, boolean z16) {
            IResultListener iResultListener = this.f379076b;
            if (iResultListener != null) {
                iResultListener.onError(i3, str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class af implements fm4.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener f379078a;

        af(IResultListener iResultListener) {
            this.f379078a = iResultListener;
        }

        @Override // fm4.b
        public void a(YoloRoomOuterClass$YoloRoomCmdRsp yoloRoomOuterClass$YoloRoomCmdRsp, long j3, boolean z16, YoloRoomOuterClass$DoYoloRoomCmdRsp yoloRoomOuterClass$DoYoloRoomCmdRsp) {
            if (!z16) {
                YoloRoomManager.this.Q1();
            }
            IResultListener iResultListener = this.f379078a;
            if (iResultListener != null) {
                iResultListener.onSuccess(yoloRoomOuterClass$YoloRoomCmdRsp);
            }
        }

        @Override // fm4.b
        public void b(int i3, String str, long j3, boolean z16) {
            String str2;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            if (eh4.a.e()) {
                str2 = "(" + i3 + ")";
            } else {
                str2 = "";
            }
            sb5.append(str2);
            com.tencent.timi.game.ui.widget.f.c(sb5.toString());
            IResultListener iResultListener = this.f379078a;
            if (iResultListener != null) {
                iResultListener.onError(i3, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class ag implements fm4.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener f379080a;

        ag(IResultListener iResultListener) {
            this.f379080a = iResultListener;
        }

        @Override // fm4.b
        public void a(YoloRoomOuterClass$YoloRoomCmdRsp yoloRoomOuterClass$YoloRoomCmdRsp, long j3, boolean z16, YoloRoomOuterClass$DoYoloRoomCmdRsp yoloRoomOuterClass$DoYoloRoomCmdRsp) {
            if (!z16) {
                YoloRoomManager.this.Q1();
            }
            IResultListener iResultListener = this.f379080a;
            if (iResultListener != null) {
                iResultListener.onSuccess(yoloRoomOuterClass$YoloRoomCmdRsp);
            }
        }

        @Override // fm4.b
        public void b(int i3, String str, long j3, boolean z16) {
            IResultListener iResultListener = this.f379080a;
            if (iResultListener != null) {
                iResultListener.onError(i3, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class ah implements DialogInterface.OnDismissListener {
        ah() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (YoloRoomManager.this.f379051o0 == dialogInterface) {
                YoloRoomManager.this.f379051o0 = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class ai implements pl4.d<YoloRoomOuterClass$GetYoloRoomDataRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f379083a;

        ai(long j3) {
            this.f379083a = j3;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean z16, int i3, int i16, int i17, String str, String str2, @Nullable YoloRoomOuterClass$GetYoloRoomDataRsp yoloRoomOuterClass$GetYoloRoomDataRsp, @Nullable FromServiceMsg fromServiceMsg) {
            boolean z17;
            YoloRoomManager.this.T = false;
            com.tencent.timi.game.utils.l.e("YoloRoomManager", "GetYoloRoomData onError -- " + i16 + "" + str + " - " + str2);
            if (i3 == 1002) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17 && YoloRoomManager.this.V) {
                YoloRoomManager.this.V = false;
            }
            if (YoloRoomManager.this.V) {
                com.tencent.timi.game.utils.l.b("YoloRoomManager", "requestingRoomData immediately");
            }
            YoloRoomUtil.Z(i16);
            if (i16 == 920017) {
                YoloRoomManager.this.f379058v0.n(i16, str2);
                YoloRoomManager.this.c1(i16, str2);
            }
            if (i16 == 920009 || i16 == 920003) {
                YoloRoomManager.this.d1();
            } else {
                YoloRoomManager yoloRoomManager = YoloRoomManager.this;
                yoloRoomManager.P1(yoloRoomManager.V);
            }
            YoloRoomManager.this.V = false;
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(YoloRoomOuterClass$GetYoloRoomDataRsp yoloRoomOuterClass$GetYoloRoomDataRsp, FromServiceMsg fromServiceMsg) {
            boolean z16;
            if (YoloRoomManager.this.H1() && this.f379083a == YoloRoomManager.this.f379041h) {
                if (yoloRoomOuterClass$GetYoloRoomDataRsp == null) {
                    com.tencent.timi.game.utils.l.e("YoloRoomManager", "GetYoloRoomData yoloRoomDataRsp is null!");
                } else {
                    if (yoloRoomOuterClass$GetYoloRoomDataRsp.has_more.get() == 1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    int i3 = yoloRoomOuterClass$GetYoloRoomDataRsp.online_num.get();
                    List<YoloRoomOuterClass$YoloRoomAction> list = yoloRoomOuterClass$GetYoloRoomDataRsp.action_list.get();
                    if (list.size() > 0) {
                        YoloRoomManager.this.P = list.get(list.size() - 1).action_id.get();
                    }
                    com.tencent.timi.game.utils.l.i("YoloRoomManager", "GetYoloRoomData suc - hasMoreAction= " + z16 + ", onlineNum= " + i3 + ", maxClientActionId= " + YoloRoomManager.this.P + ", yoloRoomActionList.size= " + list.size());
                    if (YoloRoomManager.this.D != i3) {
                        YoloRoomManager.this.D = i3;
                        YoloRoomManager.this.f379058v0.b(i3);
                    }
                    YoloRoomManager.this.E.clear();
                    YoloRoomManager.this.E.addAll(yoloRoomOuterClass$GetYoloRoomDataRsp.uid_list.get());
                    ArrayList arrayList = new ArrayList();
                    for (int i16 = 0; i16 < list.size(); i16++) {
                        YoloRoomManager.this.z1(list.get(i16), arrayList);
                    }
                }
                YoloRoomManager.this.U = false;
                YoloRoomManager.this.T = false;
                if (!YoloRoomManager.this.V && (yoloRoomOuterClass$GetYoloRoomDataRsp == null || yoloRoomOuterClass$GetYoloRoomDataRsp.has_more.get() == 0)) {
                    YoloRoomManager.this.P1(false);
                    return;
                }
                com.tencent.timi.game.utils.l.b("YoloRoomManager", "requestingRoomData immediately");
                YoloRoomManager.this.V = false;
                YoloRoomManager.this.P1(true);
                return;
            }
            com.tencent.timi.game.utils.l.e("YoloRoomManager", "GetYoloRoomData onRsp but skip!!! requestRoomId=" + this.f379083a + ", roomId=" + YoloRoomManager.this.f379041h);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class aj implements fm4.q {
        aj() {
        }

        @Override // fm4.q
        public void b(int i3) {
            Iterator it = YoloRoomManager.this.f379039f0.iterator();
            while (it.hasNext()) {
                ((fm4.q) it.next()).b(i3);
            }
        }

        @Override // fm4.q
        public void c(boolean z16) {
            Iterator it = YoloRoomManager.this.f379039f0.iterator();
            while (it.hasNext()) {
                ((fm4.q) it.next()).c(z16);
            }
        }

        @Override // fm4.q
        public void d(long j3, CommonOuterClass$QQUserId commonOuterClass$QQUserId, long j16) {
            Iterator it = YoloRoomManager.this.f379039f0.iterator();
            while (it.hasNext()) {
                ((fm4.q) it.next()).d(j3, commonOuterClass$QQUserId, j16);
            }
        }

        @Override // fm4.q
        public void e(int i3, YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo, List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> list) {
            Iterator it = YoloRoomManager.this.f379039f0.iterator();
            while (it.hasNext()) {
                ((fm4.q) it.next()).e(i3, yoloRoomOuterClass$YoloRoomSpeakingPosInfo, list);
            }
        }

        @Override // fm4.q
        public void i(int i3, YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo, List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> list) {
            Iterator it = YoloRoomManager.this.f379039f0.iterator();
            while (it.hasNext()) {
                ((fm4.q) it.next()).i(i3, yoloRoomOuterClass$YoloRoomSpeakingPosInfo, list);
            }
        }

        @Override // fm4.q
        public void k(int i3, YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo, List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> list) {
            Iterator it = YoloRoomManager.this.f379039f0.iterator();
            while (it.hasNext()) {
                ((fm4.q) it.next()).k(i3, yoloRoomOuterClass$YoloRoomSpeakingPosInfo, list);
            }
        }

        @Override // fm4.q
        public void m(CommonOuterClass$QQUserId commonOuterClass$QQUserId, YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo, List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> list, int i3) {
            Iterator it = YoloRoomManager.this.f379039f0.iterator();
            while (it.hasNext()) {
                ((fm4.q) it.next()).m(commonOuterClass$QQUserId, yoloRoomOuterClass$YoloRoomSpeakingPosInfo, list, i3);
            }
        }

        @Override // fm4.q
        public void n(int i3, String str) {
            Iterator it = YoloRoomManager.this.f379039f0.iterator();
            while (it.hasNext()) {
                ((fm4.q) it.next()).n(i3, str);
            }
        }

        @Override // fm4.q
        public void o(List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> list) {
            Iterator it = YoloRoomManager.this.f379039f0.iterator();
            while (it.hasNext()) {
                ((fm4.q) it.next()).o(list);
            }
        }

        @Override // fm4.q
        public void p(List<YoloRoomOuterClass$YoloRoomModifyInfoActionContent> list) {
            Iterator it = YoloRoomManager.this.f379039f0.iterator();
            while (it.hasNext()) {
                ((fm4.q) it.next()).p(list);
            }
        }

        @Override // fm4.q
        public void q(CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
            Iterator it = YoloRoomManager.this.f379039f0.iterator();
            while (it.hasNext()) {
                ((fm4.q) it.next()).q(commonOuterClass$QQUserId);
            }
        }

        @Override // fm4.q
        public void r(String str, int i3, YoloRoomOuterClass$YoloBattleOBStatusChangeAction yoloRoomOuterClass$YoloBattleOBStatusChangeAction) {
            Iterator it = YoloRoomManager.this.f379039f0.iterator();
            while (it.hasNext()) {
                ((fm4.q) it.next()).r(str, i3, yoloRoomOuterClass$YoloBattleOBStatusChangeAction);
            }
        }

        @Override // fm4.q
        public void s(boolean z16, int i3, YoloRoomOuterClass$YoloGameRouteInfo yoloRoomOuterClass$YoloGameRouteInfo) {
            Iterator it = YoloRoomManager.this.f379039f0.iterator();
            while (it.hasNext()) {
                ((fm4.q) it.next()).s(z16, i3, yoloRoomOuterClass$YoloGameRouteInfo);
            }
        }

        @Override // fm4.q
        public void t(CommonOuterClass$QQUserId commonOuterClass$QQUserId, CommonOuterClass$QQUserId commonOuterClass$QQUserId2, long j3, long j16) {
            Iterator it = YoloRoomManager.this.f379039f0.iterator();
            while (it.hasNext()) {
                fm4.q qVar = (fm4.q) it.next();
                com.tencent.timi.game.utils.l.b("YoloRoomManager", ">>onInvitedSpeaking listener = " + qVar);
                qVar.t(commonOuterClass$QQUserId, commonOuterClass$QQUserId2, j3, j16);
            }
        }

        @Override // fm4.q
        public void u(CommonOuterClass$QQUserId commonOuterClass$QQUserId, long j3) {
            Iterator it = YoloRoomManager.this.f379039f0.iterator();
            while (it.hasNext()) {
                ((fm4.q) it.next()).u(commonOuterClass$QQUserId, j3);
            }
        }

        @Override // fm4.q
        public void v(CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
            Iterator it = YoloRoomManager.this.f379039f0.iterator();
            while (it.hasNext()) {
                ((fm4.q) it.next()).v(commonOuterClass$QQUserId);
            }
        }

        @Override // fm4.q
        public void w(YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo, List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> list) {
            Iterator it = YoloRoomManager.this.f379039f0.iterator();
            while (it.hasNext()) {
                ((fm4.q) it.next()).w(yoloRoomOuterClass$YoloRoomSpeakingPosInfo, list);
            }
        }

        @Override // fm4.q
        public void x(CommonOuterClass$QQUserId commonOuterClass$QQUserId, YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo, List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> list) {
            Iterator it = YoloRoomManager.this.f379039f0.iterator();
            while (it.hasNext()) {
                ((fm4.q) it.next()).x(commonOuterClass$QQUserId, yoloRoomOuterClass$YoloRoomSpeakingPosInfo, list);
            }
        }

        @Override // fm4.q
        public void y(CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
            Iterator it = YoloRoomManager.this.f379039f0.iterator();
            while (it.hasNext()) {
                ((fm4.q) it.next()).y(commonOuterClass$QQUserId);
            }
        }

        @Override // fm4.q
        public void z(int i3, YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo, List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> list) {
            Iterator it = YoloRoomManager.this.f379039f0.iterator();
            while (it.hasNext()) {
                ((fm4.q) it.next()).z(i3, yoloRoomOuterClass$YoloRoomSpeakingPosInfo, list);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class al implements pl4.d<YoloRoomOuterClass$DoYoloRoomCmdRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f379088a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f379089b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ fm4.b f379090c;

        al(long j3, int i3, fm4.b bVar) {
            this.f379088a = j3;
            this.f379089b = i3;
            this.f379090c = bVar;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean z16, int i3, int i16, int i17, String str, String str2, @Nullable YoloRoomOuterClass$DoYoloRoomCmdRsp yoloRoomOuterClass$DoYoloRoomCmdRsp, @Nullable FromServiceMsg fromServiceMsg) {
            YoloRoomManager.this.Y0(i16, str2, this.f379088a, this.f379089b, this.f379090c);
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(YoloRoomOuterClass$DoYoloRoomCmdRsp yoloRoomOuterClass$DoYoloRoomCmdRsp, FromServiceMsg fromServiceMsg) {
            YoloRoomManager.this.Z0(this.f379088a, yoloRoomOuterClass$DoYoloRoomCmdRsp, this.f379089b, this.f379090c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class am implements RoomGameDoubleCheckDialog.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ YoloRoomOuterClass$YoloCommonGameOneSchema f379092a;

        am(YoloRoomOuterClass$YoloCommonGameOneSchema yoloRoomOuterClass$YoloCommonGameOneSchema) {
            this.f379092a = yoloRoomOuterClass$YoloCommonGameOneSchema;
        }

        @Override // com.tencent.timi.game.room.impl.doublecheck.RoomGameDoubleCheckDialog.d
        public void a() {
            com.tencent.timi.game.utils.l.i("YoloRoomManager", "notifyLaunchGame# DoubleCheckDialog - onLaunchGame ");
            YoloRoomUtil.k0(YoloRoomManager.this.m1());
            YoloRoomManager.b1("DoubleCheckDialog - onLaunchGam");
            nm4.a.a(this.f379092a.schema.get());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class an implements DialogInterface.OnClickListener {

        /* compiled from: P */
        /* loaded from: classes26.dex */
        class a implements IResultListener<YoloRoomOuterClass$YoloRoomLeaveRsp> {
            a() {
            }

            @Override // com.tencent.timi.game.utils.IResultListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(YoloRoomOuterClass$YoloRoomLeaveRsp yoloRoomOuterClass$YoloRoomLeaveRsp) {
                YoloRoomUtil.d0();
            }

            @Override // com.tencent.timi.game.utils.IResultListener
            public void onError(int i3, String str) {
                YoloRoomUtil.d0();
            }
        }

        an() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            YoloRoomManager.this.N1(false, 0, new a(), true);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class ap implements fm4.v {
        ap() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class aq implements fm4.t {
        aq() {
        }

        @Override // fm4.t
        public void f(long j3, int i3) {
            Iterator it = YoloRoomManager.this.f379042h0.iterator();
            while (it.hasNext()) {
                ((fm4.t) it.next()).f(j3, i3);
            }
        }

        @Override // fm4.t
        public void l(long j3, int i3) {
            Iterator it = YoloRoomManager.this.f379042h0.iterator();
            while (it.hasNext()) {
                ((fm4.t) it.next()).l(j3, i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class as implements fm4.r {
        as() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class b implements fm4.u {
        b() {
        }

        @Override // fm4.u
        public void j(boolean z16) {
            Iterator it = YoloRoomManager.this.f379045j0.iterator();
            while (it.hasNext()) {
                ((fm4.u) it.next()).j(z16);
            }
            YoloRoomManager.this.f379045j0.clear();
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class d implements c.a {
        d() {
        }

        @Override // com.tencent.timi.game.room.impl.c.a
        public void a(@NotNull MessageOuterClass$YoloRoomActionMsg messageOuterClass$YoloRoomActionMsg, long j3) {
            if (YoloRoomManager.this.f379034d != null && YoloRoomManager.this.f379034d.tim_group_id.get() == j3) {
                YoloRoomManager.this.A1(messageOuterClass$YoloRoomActionMsg.yolo_room_action);
            }
        }

        @Override // com.tencent.timi.game.room.impl.c.a
        public void b(@NotNull MessageOuterClass$YoloRoomNewDataPushMsg messageOuterClass$YoloRoomNewDataPushMsg, long j3) {
            if (YoloRoomManager.this.f379034d != null && YoloRoomManager.this.f379034d.tim_group_id.get() == j3) {
                YoloRoomManager.this.i2(messageOuterClass$YoloRoomNewDataPushMsg.new_data_time_ms.get(), "FromImGroupNotifyMsg");
            }
        }

        @Override // com.tencent.timi.game.room.impl.c.a
        public void c(String str, @NotNull MessageOuterClass$YoloRoomActionMsg messageOuterClass$YoloRoomActionMsg, long j3) {
            if (YoloRoomManager.this.f379034d != null && YoloRoomManager.this.f379034d.tim_group_id.get() == j3) {
                YoloRoomManager.this.B1(str, messageOuterClass$YoloRoomActionMsg.yolo_room_action);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class f implements IResultListener<List<ln4.c>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CommonOuterClass$QQUserId f379110a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f379111b;

        f(CommonOuterClass$QQUserId commonOuterClass$QQUserId, String str) {
            this.f379110a = commonOuterClass$QQUserId;
            this.f379111b = str;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(List<ln4.c> list) {
            Iterator<ln4.c> it = list.iterator();
            boolean z16 = false;
            while (it.hasNext()) {
                if (it.next().c().equals(this.f379110a)) {
                    z16 = true;
                }
            }
            if (!z16) {
                com.tencent.timi.game.ui.widget.f.c(this.f379111b);
                YoloRoomManager.this.d2();
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int i3, String str) {
            com.tencent.timi.game.ui.widget.f.c(this.f379111b);
            YoloRoomManager.this.d2();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class g implements TimiGameQQTrtcUtil.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener f379113a;

        g(IResultListener iResultListener) {
            this.f379113a = iResultListener;
        }

        @Override // com.tencent.timi.game.trtc.roomservice.multipevoiceroom.TimiGameQQTrtcUtil.b
        public void onError(int i3, String str) {
            YoloRoomManager.this.f379054r0 = false;
            boolean H1 = YoloRoomManager.this.H1();
            int roomType = YoloRoomManager.this.getRoomType();
            com.tencent.timi.game.utils.l.e("YoloRoomManager", "checkMediaTrtcEnv requestQQAudioEnv onError - " + i3 + " - " + str + ", isInRoom = " + H1 + " - " + YoloRoomManager.this.p1());
            if (H1) {
                YoloRoomManager.this.a1(i3, str, roomType);
                IResultListener iResultListener = this.f379113a;
                if (iResultListener != null) {
                    iResultListener.onError(i3, str);
                }
                YoloRoomManager.this.C0.j(false);
            }
        }

        @Override // com.tencent.timi.game.trtc.roomservice.multipevoiceroom.TimiGameQQTrtcUtil.b
        public void onSuccess() {
            YoloRoomManager.this.f379054r0 = false;
            boolean H1 = YoloRoomManager.this.H1();
            com.tencent.timi.game.utils.l.i("YoloRoomManager", "checkMediaTrtcEnv requestQQAudioEnv onSuccess, isInRoom = " + H1);
            if (H1) {
                YoloRoomManager.this.D1();
                IResultListener iResultListener = this.f379113a;
                if (iResultListener != null) {
                    iResultListener.onSuccess(YoloRoomManager.this.f379050n0);
                }
                YoloRoomManager.this.C0.j(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class h implements IResultListener<Boolean> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f379115a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f379116b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ IResultListener f379117c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f379118d;

        h(boolean z16, int i3, IResultListener iResultListener, boolean z17) {
            this.f379115a = z16;
            this.f379116b = i3;
            this.f379117c = iResultListener;
            this.f379118d = z17;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Boolean bool) {
            com.tencent.timi.game.utils.l.i("YoloRoomManager", "leaveRoom - exitRoomCheck onSuccess - " + bool);
            if (bool.booleanValue()) {
                YoloRoomManager.this.O1(this.f379115a, this.f379116b, this.f379117c, this.f379118d);
                return;
            }
            IResultListener iResultListener = this.f379117c;
            if (iResultListener != null) {
                iResultListener.onError(-10000, "exitRoomCheck false");
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int i3, String str) {
            com.tencent.timi.game.utils.l.e("YoloRoomManager", "leaveRoom - exitRoomCheck onError - " + i3 + " - " + str);
            IResultListener iResultListener = this.f379117c;
            if (iResultListener != null) {
                iResultListener.onError(i3, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class i implements IResultListener<YoloRoomOuterClass$YoloRoomLeaveRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f379120a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IResultListener f379121b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f379122c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f379123d;

        i(boolean z16, IResultListener iResultListener, boolean z17, boolean z18) {
            this.f379120a = z16;
            this.f379121b = iResultListener;
            this.f379122c = z17;
            this.f379123d = z18;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(YoloRoomOuterClass$YoloRoomLeaveRsp yoloRoomOuterClass$YoloRoomLeaveRsp) {
            if (!this.f379120a) {
                YoloRoomManager.this.d2();
                IResultListener iResultListener = this.f379121b;
                if (iResultListener != null) {
                    iResultListener.onSuccess(yoloRoomOuterClass$YoloRoomLeaveRsp);
                }
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int i3, String str) {
            if (!this.f379120a) {
                YoloRoomManager.this.f379055s0 = false;
                if (this.f379122c) {
                    com.tencent.timi.game.ui.widget.f.c("\u9000\u51fa\u623f\u95f4\u5931\u8d25, " + str + "(" + i3 + ")");
                }
                YoloRoomManager.this.B2(this.f379123d);
                IResultListener iResultListener = this.f379121b;
                if (iResultListener != null) {
                    iResultListener.onError(i3, str);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class j extends MutableLiveData<YoloRoomOuterClass$YoloRoomInfo> {
        j() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class l implements IResultListener<hm4.a> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f379128a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f379129b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f379130c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IResultListener f379131d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes26.dex */
        public class a implements fm4.b {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ hm4.a f379133a;

            a(hm4.a aVar) {
                this.f379133a = aVar;
            }

            @Override // fm4.b
            public void a(YoloRoomOuterClass$YoloRoomCmdRsp yoloRoomOuterClass$YoloRoomCmdRsp, long j3, boolean z16, YoloRoomOuterClass$DoYoloRoomCmdRsp yoloRoomOuterClass$DoYoloRoomCmdRsp) {
                if (!z16) {
                    YoloRoomManager.this.Q1();
                }
                hm4.a aVar = this.f379133a;
                if (aVar != null) {
                    aVar.y(true);
                    this.f379133a.C(l.this.f379128a);
                }
                IResultListener iResultListener = l.this.f379131d;
                if (iResultListener != null) {
                    iResultListener.onSuccess(yoloRoomOuterClass$YoloRoomCmdRsp);
                }
            }

            @Override // fm4.b
            public void b(int i3, String str, long j3, boolean z16) {
                com.tencent.timi.game.ui.widget.f.d(true, str);
                IResultListener iResultListener = l.this.f379131d;
                if (iResultListener != null) {
                    iResultListener.onError(i3, str);
                }
            }
        }

        l(boolean z16, int i3, boolean z17, IResultListener iResultListener) {
            this.f379128a = z16;
            this.f379129b = i3;
            this.f379130c = z17;
            this.f379131d = iResultListener;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(hm4.a aVar) {
            YoloRoomOuterClass$YoloRoomSpeakingPosChangeCmd yoloRoomOuterClass$YoloRoomSpeakingPosChangeCmd = new YoloRoomOuterClass$YoloRoomSpeakingPosChangeCmd();
            int i3 = 1;
            yoloRoomOuterClass$YoloRoomSpeakingPosChangeCmd.f437262op.set(1);
            PBInt32Field pBInt32Field = yoloRoomOuterClass$YoloRoomSpeakingPosChangeCmd.voice_switch;
            if (!this.f379128a) {
                i3 = 2;
            }
            pBInt32Field.set(i3);
            yoloRoomOuterClass$YoloRoomSpeakingPosChangeCmd.pos.set(this.f379129b);
            yoloRoomOuterClass$YoloRoomSpeakingPosChangeCmd.no_user_type_check.set(this.f379130c ? 1 : 0);
            YoloRoomOuterClass$YoloRoomCmdReq yoloRoomOuterClass$YoloRoomCmdReq = new YoloRoomOuterClass$YoloRoomCmdReq();
            yoloRoomOuterClass$YoloRoomCmdReq.yolo_room_speaking_pos_change_cmd.set(yoloRoomOuterClass$YoloRoomSpeakingPosChangeCmd);
            YoloRoomManager.this.e1(11, yoloRoomOuterClass$YoloRoomCmdReq, new a(aVar));
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int i3, String str) {
            com.tencent.timi.game.utils.l.i("YoloRoomManager", "inSpeaking#onError - errorCode:" + i3 + " - errorMessage:" + str);
            IResultListener iResultListener = this.f379131d;
            if (iResultListener != null) {
                iResultListener.onError(i3, str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class m implements fm4.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener f379135a;

        m(IResultListener iResultListener) {
            this.f379135a = iResultListener;
        }

        @Override // fm4.b
        public void a(YoloRoomOuterClass$YoloRoomCmdRsp yoloRoomOuterClass$YoloRoomCmdRsp, long j3, boolean z16, YoloRoomOuterClass$DoYoloRoomCmdRsp yoloRoomOuterClass$DoYoloRoomCmdRsp) {
            if (!z16) {
                YoloRoomManager.this.Q1();
            }
            if (YoloRoomManager.this.f379050n0 != null) {
                YoloRoomManager.this.f379050n0.y(false);
            }
            IResultListener iResultListener = this.f379135a;
            if (iResultListener != null) {
                iResultListener.onSuccess(yoloRoomOuterClass$YoloRoomCmdRsp);
            }
        }

        @Override // fm4.b
        public void b(int i3, String str, long j3, boolean z16) {
            com.tencent.timi.game.ui.widget.f.d(true, "\u4e0b\u9ea6\u5931\u8d25, " + str + "(" + i3 + ")");
            IResultListener iResultListener = this.f379135a;
            if (iResultListener != null) {
                iResultListener.onError(i3, str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class n implements fm4.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener f379137a;

        n(IResultListener iResultListener) {
            this.f379137a = iResultListener;
        }

        @Override // fm4.b
        public void a(YoloRoomOuterClass$YoloRoomCmdRsp yoloRoomOuterClass$YoloRoomCmdRsp, long j3, boolean z16, YoloRoomOuterClass$DoYoloRoomCmdRsp yoloRoomOuterClass$DoYoloRoomCmdRsp) {
            if (!z16) {
                YoloRoomManager.this.Q1();
            }
            IResultListener iResultListener = this.f379137a;
            if (iResultListener != null) {
                iResultListener.onSuccess(yoloRoomOuterClass$YoloRoomCmdRsp);
            }
        }

        @Override // fm4.b
        public void b(int i3, String str, long j3, boolean z16) {
            IResultListener iResultListener = this.f379137a;
            if (iResultListener != null) {
                iResultListener.onError(i3, str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class o implements fm4.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener f379139a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f379140b;

        o(IResultListener iResultListener, boolean z16) {
            this.f379139a = iResultListener;
            this.f379140b = z16;
        }

        @Override // fm4.b
        public void a(YoloRoomOuterClass$YoloRoomCmdRsp yoloRoomOuterClass$YoloRoomCmdRsp, long j3, boolean z16, YoloRoomOuterClass$DoYoloRoomCmdRsp yoloRoomOuterClass$DoYoloRoomCmdRsp) {
            if (!z16) {
                YoloRoomManager.this.Q1();
            }
            IResultListener iResultListener = this.f379139a;
            if (iResultListener != null) {
                iResultListener.onSuccess(yoloRoomOuterClass$YoloRoomCmdRsp);
            }
        }

        @Override // fm4.b
        public void b(int i3, String str, long j3, boolean z16) {
            String str2;
            String str3;
            StringBuilder sb5 = new StringBuilder();
            if (this.f379140b) {
                str2 = "\u6253\u5f00\u9ea6\u4f4d";
            } else {
                str2 = "\u5173\u95ed\u9ea6\u4f4d";
            }
            sb5.append(str2);
            sb5.append("\u5931\u8d25, ");
            sb5.append(str);
            if (eh4.a.e()) {
                str3 = "(" + i3 + ")";
            } else {
                str3 = "";
            }
            sb5.append(str3);
            com.tencent.timi.game.ui.widget.f.c(sb5.toString());
            IResultListener iResultListener = this.f379139a;
            if (iResultListener != null) {
                iResultListener.onError(i3, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class p implements YoloVoiceChangeAlertUtil.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CommonOuterClass$QQUserId f379142a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f379143b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ IResultListener f379144c;

        p(CommonOuterClass$QQUserId commonOuterClass$QQUserId, int i3, IResultListener iResultListener) {
            this.f379142a = commonOuterClass$QQUserId;
            this.f379143b = i3;
            this.f379144c = iResultListener;
        }

        @Override // com.tencent.timi.game.room.impl.YoloVoiceChangeAlertUtil.b
        public void onConfirm() {
            YoloRoomManager.this.g1(this.f379142a, this.f379143b, this.f379144c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class q implements fm4.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener f379146a;

        q(IResultListener iResultListener) {
            this.f379146a = iResultListener;
        }

        @Override // fm4.b
        public void a(YoloRoomOuterClass$YoloRoomCmdRsp yoloRoomOuterClass$YoloRoomCmdRsp, long j3, boolean z16, YoloRoomOuterClass$DoYoloRoomCmdRsp yoloRoomOuterClass$DoYoloRoomCmdRsp) {
            if (!z16) {
                YoloRoomManager.this.Q1();
            }
            IResultListener iResultListener = this.f379146a;
            if (iResultListener != null) {
                iResultListener.onSuccess(yoloRoomOuterClass$YoloRoomCmdRsp);
            }
        }

        @Override // fm4.b
        public void b(int i3, String str, long j3, boolean z16) {
            String str2;
            if (i3 == 920008) {
                com.tencent.timi.game.ui.widget.f.c("\u65e0\u6cd5\u7981\u9ea6\u64cd\u4f5c\uff0c\u623f\u4e3b\u6743\u9650\u8f6c\u79fb\u3002");
            } else {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("\u64cd\u4f5c\u5931\u8d25, ");
                sb5.append(str);
                if (eh4.a.e()) {
                    str2 = "(" + i3 + ")";
                } else {
                    str2 = "";
                }
                sb5.append(str2);
                com.tencent.timi.game.ui.widget.f.c(sb5.toString());
            }
            IResultListener iResultListener = this.f379146a;
            if (iResultListener != null) {
                iResultListener.onError(i3, str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class r implements fm4.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener f379148a;

        r(IResultListener iResultListener) {
            this.f379148a = iResultListener;
        }

        @Override // fm4.b
        public void a(YoloRoomOuterClass$YoloRoomCmdRsp yoloRoomOuterClass$YoloRoomCmdRsp, long j3, boolean z16, YoloRoomOuterClass$DoYoloRoomCmdRsp yoloRoomOuterClass$DoYoloRoomCmdRsp) {
            if (!z16) {
                YoloRoomManager.this.Q1();
            }
            IResultListener iResultListener = this.f379148a;
            if (iResultListener != null) {
                iResultListener.onSuccess(yoloRoomOuterClass$YoloRoomCmdRsp);
            }
        }

        @Override // fm4.b
        public void b(int i3, String str, long j3, boolean z16) {
            String str2;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("\u64cd\u4f5c\u5931\u8d25, ");
            sb5.append(str);
            if (eh4.a.e()) {
                str2 = "(" + i3 + ")";
            } else {
                str2 = "";
            }
            sb5.append(str2);
            com.tencent.timi.game.ui.widget.f.c(sb5.toString());
            IResultListener iResultListener = this.f379148a;
            if (iResultListener != null) {
                iResultListener.onError(i3, str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class s implements fm4.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener f379150a;

        s(IResultListener iResultListener) {
            this.f379150a = iResultListener;
        }

        @Override // fm4.b
        public void a(YoloRoomOuterClass$YoloRoomCmdRsp yoloRoomOuterClass$YoloRoomCmdRsp, long j3, boolean z16, YoloRoomOuterClass$DoYoloRoomCmdRsp yoloRoomOuterClass$DoYoloRoomCmdRsp) {
            if (!z16) {
                YoloRoomManager.this.Q1();
            }
            IResultListener iResultListener = this.f379150a;
            if (iResultListener != null) {
                iResultListener.onSuccess(yoloRoomOuterClass$YoloRoomCmdRsp);
            }
        }

        @Override // fm4.b
        public void b(int i3, String str, long j3, boolean z16) {
            String str2;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("\u64cd\u4f5c\u5931\u8d25, ");
            sb5.append(str);
            if (eh4.a.e()) {
                str2 = "(" + i3 + ")";
            } else {
                str2 = "";
            }
            sb5.append(str2);
            com.tencent.timi.game.ui.widget.f.c(sb5.toString());
            IResultListener iResultListener = this.f379150a;
            if (iResultListener != null) {
                iResultListener.onError(i3, str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class t implements fm4.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener f379152a;

        t(IResultListener iResultListener) {
            this.f379152a = iResultListener;
        }

        @Override // fm4.b
        public void a(YoloRoomOuterClass$YoloRoomCmdRsp yoloRoomOuterClass$YoloRoomCmdRsp, long j3, boolean z16, YoloRoomOuterClass$DoYoloRoomCmdRsp yoloRoomOuterClass$DoYoloRoomCmdRsp) {
            if (!z16) {
                YoloRoomManager.this.Q1();
            }
            IResultListener iResultListener = this.f379152a;
            if (iResultListener != null) {
                iResultListener.onSuccess(yoloRoomOuterClass$YoloRoomCmdRsp);
            }
        }

        @Override // fm4.b
        public void b(int i3, String str, long j3, boolean z16) {
            String str2;
            if (TextUtils.isEmpty(str)) {
                if (i3 == 9200104) {
                    str = "\u5f53\u524d\u672c\u961f\u4eba\u5458\u6bb5\u4f4d\u4e0d\u7b26\u5408\u8981\u6c42";
                } else if (i3 != 9200117 && i3 != 9200118) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("\u4fee\u6539\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
                    if (eh4.a.e()) {
                        str2 = "(" + i3 + ")";
                    } else {
                        str2 = "";
                    }
                    sb5.append(str2);
                    str = sb5.toString();
                } else {
                    str = "\u4eba\u6570\u8d85\u51fa\u8be5\u6a21\u5f0f\u9650\u5236";
                }
            }
            com.tencent.timi.game.ui.widget.f.c(str);
            IResultListener iResultListener = this.f379152a;
            if (iResultListener != null) {
                iResultListener.onError(i3, str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class u implements gm4.e {
        u() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class v implements fm4.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener f379155a;

        v(IResultListener iResultListener) {
            this.f379155a = iResultListener;
        }

        @Override // fm4.b
        public void a(YoloRoomOuterClass$YoloRoomCmdRsp yoloRoomOuterClass$YoloRoomCmdRsp, long j3, boolean z16, YoloRoomOuterClass$DoYoloRoomCmdRsp yoloRoomOuterClass$DoYoloRoomCmdRsp) {
            YoloRoomOuterClass$YoloRoomStartGameCmdRsp yoloRoomOuterClass$YoloRoomStartGameCmdRsp;
            if (!z16) {
                YoloRoomManager.this.Q1();
            }
            IResultListener iResultListener = this.f379155a;
            if (iResultListener != null) {
                if (yoloRoomOuterClass$YoloRoomCmdRsp != null) {
                    yoloRoomOuterClass$YoloRoomStartGameCmdRsp = yoloRoomOuterClass$YoloRoomCmdRsp.yolo_room_start_game_cmd_rsp;
                } else {
                    yoloRoomOuterClass$YoloRoomStartGameCmdRsp = null;
                }
                iResultListener.onSuccess(yoloRoomOuterClass$YoloRoomStartGameCmdRsp);
            }
        }

        @Override // fm4.b
        public void b(int i3, String str, long j3, boolean z16) {
            String str2;
            if (i3 != 9200107) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("\u64cd\u4f5c\u5931\u8d25, ");
                sb5.append(str);
                if (eh4.a.e()) {
                    str2 = "(" + i3 + ")";
                } else {
                    str2 = "";
                }
                sb5.append(str2);
                com.tencent.timi.game.ui.widget.f.c(sb5.toString());
            }
            IResultListener iResultListener = this.f379155a;
            if (iResultListener != null) {
                iResultListener.onError(i3, str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class w implements fm4.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener f379157a;

        w(IResultListener iResultListener) {
            this.f379157a = iResultListener;
        }

        @Override // fm4.b
        public void a(YoloRoomOuterClass$YoloRoomCmdRsp yoloRoomOuterClass$YoloRoomCmdRsp, long j3, boolean z16, YoloRoomOuterClass$DoYoloRoomCmdRsp yoloRoomOuterClass$DoYoloRoomCmdRsp) {
            YoloRoomOuterClass$YoloRoomJoinGameCmdRsp yoloRoomOuterClass$YoloRoomJoinGameCmdRsp;
            if (!z16) {
                YoloRoomManager.this.Q1();
            }
            if (yoloRoomOuterClass$YoloRoomCmdRsp != null) {
                yoloRoomOuterClass$YoloRoomJoinGameCmdRsp = yoloRoomOuterClass$YoloRoomCmdRsp.yolo_room_join_game_cmd_rsp;
            } else {
                yoloRoomOuterClass$YoloRoomJoinGameCmdRsp = null;
            }
            com.tencent.timi.game.utils.l.i("YoloRoomManager", "joinGame onSuccess - " + yoloRoomOuterClass$YoloRoomJoinGameCmdRsp);
            if (yoloRoomOuterClass$YoloRoomJoinGameCmdRsp != null && yoloRoomOuterClass$YoloRoomJoinGameCmdRsp.room_info.has()) {
                YoloRoomManager.this.r2(null, yoloRoomOuterClass$YoloRoomJoinGameCmdRsp.room_info, 0);
                com.tencent.timi.game.utils.l.h("YoloRoomManager", 1, "CMD_TYPE_JOIN_GAME - need launch game");
                YoloRoomManager yoloRoomManager = YoloRoomManager.this;
                yoloRoomManager.W1(yoloRoomManager.L, true);
            }
            IResultListener iResultListener = this.f379157a;
            if (iResultListener != null) {
                iResultListener.onSuccess(yoloRoomOuterClass$YoloRoomJoinGameCmdRsp);
            }
        }

        @Override // fm4.b
        public void b(int i3, String str, long j3, boolean z16) {
            IResultListener iResultListener = this.f379157a;
            if (iResultListener != null) {
                iResultListener.onError(i3, str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class x implements fm4.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener f379159a;

        x(IResultListener iResultListener) {
            this.f379159a = iResultListener;
        }

        @Override // fm4.b
        public void a(YoloRoomOuterClass$YoloRoomCmdRsp yoloRoomOuterClass$YoloRoomCmdRsp, long j3, boolean z16, YoloRoomOuterClass$DoYoloRoomCmdRsp yoloRoomOuterClass$DoYoloRoomCmdRsp) {
            if (!z16) {
                YoloRoomManager.this.Q1();
            }
            IResultListener iResultListener = this.f379159a;
            if (iResultListener != null) {
                iResultListener.onSuccess(yoloRoomOuterClass$YoloRoomCmdRsp);
            }
        }

        @Override // fm4.b
        public void b(int i3, String str, long j3, boolean z16) {
            String str2;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("\u64cd\u4f5c\u5931\u8d25, ");
            sb5.append(str);
            if (eh4.a.e()) {
                str2 = "(" + i3 + ")";
            } else {
                str2 = "";
            }
            sb5.append(str2);
            com.tencent.timi.game.ui.widget.f.c(sb5.toString());
            IResultListener iResultListener = this.f379159a;
            if (iResultListener != null) {
                iResultListener.onError(i3, str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class y implements fm4.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener f379161a;

        y(IResultListener iResultListener) {
            this.f379161a = iResultListener;
        }

        @Override // fm4.b
        public void a(YoloRoomOuterClass$YoloRoomCmdRsp yoloRoomOuterClass$YoloRoomCmdRsp, long j3, boolean z16, YoloRoomOuterClass$DoYoloRoomCmdRsp yoloRoomOuterClass$DoYoloRoomCmdRsp) {
            if (!z16) {
                YoloRoomManager.this.Q1();
            }
            com.tencent.timi.game.ui.widget.f.c("\u5df2\u53d1\u51fa\u4e0a\u9ea6\u9080\u8bf7");
            IResultListener iResultListener = this.f379161a;
            if (iResultListener != null) {
                iResultListener.onSuccess(yoloRoomOuterClass$YoloRoomCmdRsp);
            }
        }

        @Override // fm4.b
        public void b(int i3, String str, long j3, boolean z16) {
            String str2;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            if (eh4.a.e()) {
                str2 = "(" + i3 + ")";
            } else {
                str2 = "";
            }
            sb5.append(str2);
            com.tencent.timi.game.ui.widget.f.c(sb5.toString());
            IResultListener iResultListener = this.f379161a;
            if (iResultListener != null) {
                iResultListener.onError(i3, str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class z implements fm4.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ fm4.a f379163a;

        z(fm4.a aVar) {
            this.f379163a = aVar;
        }

        @Override // fm4.b
        public void a(YoloRoomOuterClass$YoloRoomCmdRsp yoloRoomOuterClass$YoloRoomCmdRsp, long j3, boolean z16, YoloRoomOuterClass$DoYoloRoomCmdRsp yoloRoomOuterClass$DoYoloRoomCmdRsp) {
            if (!z16) {
                YoloRoomManager.this.Q1();
            }
            fm4.a aVar = this.f379163a;
            if (aVar != null) {
                aVar.a(yoloRoomOuterClass$YoloRoomCmdRsp, yoloRoomOuterClass$DoYoloRoomCmdRsp);
            }
        }

        @Override // fm4.b
        public void b(int i3, String str, long j3, boolean z16) {
            com.tencent.timi.game.ui.widget.f.d(true, str);
            fm4.a aVar = this.f379163a;
            if (aVar != null) {
                aVar.onError(i3, str);
            }
        }
    }

    public YoloRoomManager(long j3) {
        this.f379041h = j3;
        this.f379049m0.add(new lm4.a(this, this.f379059w0));
        this.f379049m0.add(new im4.a(this, this.A0));
        com.tencent.timi.game.room.impl.c cVar = new com.tencent.timi.game.room.impl.c();
        this.f379053q0 = cVar;
        cVar.c(new d());
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A1(YoloRoomOuterClass$YoloRoomAction yoloRoomOuterClass$YoloRoomAction) {
        int i3 = yoloRoomOuterClass$YoloRoomAction.action_type.get();
        new ArrayList();
        com.tencent.timi.game.utils.l.h("YoloRoomManager", 1, "handleRoomActionFromImGroupNotifyMsg yoloActionType=" + i3);
        switch (i3) {
            case 24:
                YoloRoomOuterClass$YoloRoomInvitedSpeakingAction yoloRoomOuterClass$YoloRoomInvitedSpeakingAction = yoloRoomOuterClass$YoloRoomAction.yolo_room_invited_speaking_action;
                f2(yoloRoomOuterClass$YoloRoomInvitedSpeakingAction.invite_user_id, yoloRoomOuterClass$YoloRoomInvitedSpeakingAction.invited_user_id, yoloRoomOuterClass$YoloRoomInvitedSpeakingAction.expire_time.get(), m1());
                return;
            case 25:
                YoloRoomOuterClass$YoloRoomApplySpeakingAction yoloRoomOuterClass$YoloRoomApplySpeakingAction = yoloRoomOuterClass$YoloRoomAction.yolo_room_apply_speaking_action;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("handleRoomActionFromImGroupNotifyMsg YOLO_ACTION_TYPE_APPLY_FOR_SPEAKING uid:");
                sb5.append(MobileQQ.getShortUinStr(yoloRoomOuterClass$YoloRoomApplySpeakingAction.user_id.yes_uid.get() + ""));
                sb5.append(", time:");
                sb5.append(yoloRoomOuterClass$YoloRoomApplySpeakingAction.apply_time_ms.get());
                com.tencent.timi.game.utils.l.h("YoloRoomManager", 1, sb5.toString());
                b2(yoloRoomOuterClass$YoloRoomApplySpeakingAction.user_id, yoloRoomOuterClass$YoloRoomApplySpeakingAction.apply_time_ms.get());
                return;
            case 26:
                a2(m1(), yoloRoomOuterClass$YoloRoomAction.yolo_room_agree_speaking_action.user_id, yoloRoomOuterClass$YoloRoomAction.action_time.get());
                return;
            default:
                com.tencent.timi.game.utils.l.i("YoloRoomManager", "handleRoomActionFromImGroupNotifyMsg not handled! - " + i3);
                return;
        }
    }

    private void A2() {
        YoloRoomOuterClass$YoloRoomConf yoloRoomOuterClass$YoloRoomConf = this.H;
        if (yoloRoomOuterClass$YoloRoomConf != null && yoloRoomOuterClass$YoloRoomConf.yolo_room_game_conf.has()) {
            String str = this.H.yolo_room_game_conf.game_room_notice.get();
            com.tencent.timi.game.utils.l.i("YoloRoomManager", "onNewRoom - " + m1() + " - gameRoomNotice = " + str);
            if (!TextUtils.isEmpty(str)) {
                com.tencent.timi.game.room.impl.util.g.f379335a.h(this.f379034d.tim_group_id.get(), this.f379034d.room_id.get(), str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B1(String str, YoloRoomOuterClass$YoloRoomAction yoloRoomOuterClass$YoloRoomAction) {
        int i3 = yoloRoomOuterClass$YoloRoomAction.action_type.get();
        com.tencent.timi.game.utils.l.i("YoloRoomManager", "handleRoomActionFromImMsg " + i3 + ", msgId = " + str + ", clientTid = " + yoloRoomOuterClass$YoloRoomAction.client_seq_id.get());
        if (i3 != 25) {
            if (i3 != 26) {
                if (i3 != 29) {
                    if (i3 != 150) {
                        if (i3 != 154) {
                            if (i3 != 203) {
                                if (i3 != 101) {
                                    if (i3 != 102) {
                                        com.tencent.timi.game.utils.l.i("YoloRoomManager", "handleRoomActionFromImMsg not handled! - " + i3);
                                        return;
                                    }
                                    p2(yoloRoomOuterClass$YoloRoomAction.yolo_room_leave_action.user_id);
                                    return;
                                }
                                m2(yoloRoomOuterClass$YoloRoomAction.yolo_room_enter_action.user_id);
                                return;
                            }
                        } else {
                            u1(yoloRoomOuterClass$YoloRoomAction);
                            return;
                        }
                    }
                    y1(i3, yoloRoomOuterClass$YoloRoomAction);
                    return;
                }
                t1(yoloRoomOuterClass$YoloRoomAction);
                return;
            }
            a2(m1(), yoloRoomOuterClass$YoloRoomAction.yolo_room_agree_speaking_action.user_id, yoloRoomOuterClass$YoloRoomAction.action_time.get());
            return;
        }
        YoloRoomOuterClass$YoloRoomApplySpeakingAction yoloRoomOuterClass$YoloRoomApplySpeakingAction = yoloRoomOuterClass$YoloRoomAction.yolo_room_apply_speaking_action;
        b2(yoloRoomOuterClass$YoloRoomApplySpeakingAction.user_id, yoloRoomOuterClass$YoloRoomApplySpeakingAction.apply_time_ms.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B2(boolean z16) {
        com.tencent.timi.game.utils.l.i("YoloRoomManager", "setLoopingRequestRoomData curValue = " + this.W + ", newValue = " + z16);
        this.W = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C1(long j3, @NotNull List<? extends ln4.c> list) {
        String str;
        if (this.f379055s0) {
            com.tencent.timi.game.utils.l.e("YoloRoomManager", "handleSelfKickedFromIm but mManualClickLeaveRoom");
            return;
        }
        CommonOuterClass$QQUserId E = ((ll4.a) mm4.b.b(ll4.a.class)).E();
        for (ln4.c cVar : list) {
            if (ll4.b.a(E, cVar.c())) {
                com.tencent.timi.game.utils.l.e("YoloRoomManager", "handleSelfKickedFromIm self kicked out!");
                CommonOuterClass$QQUserId c16 = cVar.c();
                if (YoloRoomUtil.c0(getRoomType())) {
                    if (((sm4.a) mm4.b.b(sm4.a.class)).n1()) {
                        str = "\u88ab\u79fb\u51fa\u8f66\u961f\uff0c\u91d1\u5e01\u5c06\u9000\u8fd8\u5e10\u6237";
                    } else {
                        str = "\u4f60\u5df2\u88ab\u79fb\u51fa\u8f66\u961f";
                    }
                } else {
                    str = "\u4f60\u5df2\u88ab\u79fb\u51fa\u623f\u95f4";
                }
                ((kn4.b) mm4.b.b(kn4.b.class)).V1().b(j3, new f(c16, str));
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D1() {
        synchronized (this) {
            if (this.f379050n0 == null) {
                boolean K1 = K1();
                if (E2(this.f379034d)) {
                    hm4.a aVar = new hm4.a(this.f379034d);
                    this.f379050n0 = aVar;
                    aVar.n(K1, this.f379057u0);
                    if (K1) {
                        this.f379050n0.y(true);
                    }
                }
            }
        }
    }

    private boolean E2(YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo) {
        if (yoloRoomOuterClass$YoloRoomInfo.game_data_info.common_game_data_info.qq_live_room_config.has()) {
            ll4.b.a(yoloRoomOuterClass$YoloRoomInfo.game_data_info.common_game_data_info.qq_live_room_config.qq_live_user_id, q1());
            return true;
        }
        return true;
    }

    private boolean F1(long j3) {
        if (j3 != 0 && this.Y.get(Long.valueOf(j3)) == null) {
            return true;
        }
        return false;
    }

    private void G2() {
        YoloRoomOuterClass$YoloRoomConf yoloRoomOuterClass$YoloRoomConf = this.H;
        if (yoloRoomOuterClass$YoloRoomConf != null && yoloRoomOuterClass$YoloRoomConf.yolo_room_community_conf.has()) {
            com.tencent.timi.game.utils.l.b("YoloRoomManager", "is_show_third_part_gift" + this.H.yolo_room_community_conf.wuji_yolo_room_community_conf.is_show_third_part_gift.get());
        }
    }

    private void H2(int i3) {
        com.tencent.timi.game.utils.l.i("YoloRoomManager", "updateRequestRoomDataGap - " + i3 + ReportConstant.COSTREPORT_PREFIX);
        if (i3 > 0) {
            this.R = i3 * 1000;
        }
    }

    private void I2(YoloRoomOuterClass$YoloRoomUserData yoloRoomOuterClass$YoloRoomUserData) {
        com.tencent.timi.game.utils.l.i("YoloRoomManager", "updateRoomUserData");
        this.f379036e = yoloRoomOuterClass$YoloRoomUserData;
    }

    private boolean J1(List<CommonOuterClass$QQUserId> list) {
        if (!list.isEmpty()) {
            CommonOuterClass$QQUserId q16 = q1();
            Iterator<CommonOuterClass$QQUserId> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().yes_uid.get() == q16.yes_uid.get()) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private void J2(YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo, int i3) {
        ArrayList arrayList = new ArrayList();
        for (YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo2 : this.F) {
            if (yoloRoomOuterClass$YoloRoomSpeakingPosInfo2.pos.get() == yoloRoomOuterClass$YoloRoomSpeakingPosInfo.pos.get()) {
                arrayList.add(yoloRoomOuterClass$YoloRoomSpeakingPosInfo);
            } else {
                arrayList.add(yoloRoomOuterClass$YoloRoomSpeakingPosInfo2);
            }
        }
        k2(arrayList, i3, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O1(boolean z16, int i3, IResultListener<YoloRoomOuterClass$YoloRoomLeaveRsp> iResultListener, boolean z17) {
        boolean z18;
        boolean z19 = this.W;
        B2(false);
        int roomType = getRoomType();
        this.f379055s0 = true;
        if (roomType == 5) {
            z18 = true;
        } else {
            z18 = false;
        }
        com.tencent.timi.game.utils.l.i("YoloRoomManager", "leaveRoomInner, isForceExit= " + z16 + ", mRoomId= " + this.f379041h + ", leaveFrom= " + i3 + ", roomType= " + roomType);
        YoloRoomUtil.m0(this.f379041h, z16, roomType, new i(z18, iResultListener, z17, z19));
        if (z18) {
            com.tencent.timi.game.utils.l.i("YoloRoomManager", "leaveRoomInner, CallbackSuccessImmediately roomType= " + roomType);
            d2();
            if (iResultListener != null) {
                iResultListener.onSuccess(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q1() {
        P1(true);
    }

    private void S1() {
        com.tencent.timi.game.utils.l.i("YoloRoomManager", "notifyEnterNewRoom - " + m1());
        if (getRoomType() == 1) {
            com.tencent.timi.game.initer.impl.b.f377190a.f(10003);
            ConcurrentHashMap<String, String> s16 = ((ni4.a) mm4.b.b(ni4.a.class)).s1(this.f379041h);
            if (s16 != null && s16.size() > 0) {
                N(s16);
            } else {
                ((ni4.a) mm4.b.b(ni4.a.class)).s2(this.f379041h);
            }
        }
        this.f379060x0.f(m1(), getRoomType());
        com.tencent.timi.game.room.impl.d.g().o(m1(), getRoomType());
    }

    private boolean T0() {
        YoloRoomOuterClass$YoloRoomConf Y = Y();
        if (Y == null) {
            return true;
        }
        return Y.yolo_room_community_conf.wuji_yolo_room_community_conf.speaking_list_switch.get();
    }

    private void T1() {
        long m16 = m1();
        com.tencent.timi.game.utils.l.i("YoloRoomManager", "notifyExitRoom - " + m16);
        if (m16 != 0) {
            if (getRoomType() == 1) {
                com.tencent.timi.game.initer.impl.b.f377190a.b(10003);
            }
            this.f379060x0.l(m16, getRoomType());
            com.tencent.timi.game.room.impl.d.g().p(m16, getRoomType());
            com.tencent.timi.game.room.impl.d.g().d(m16);
            YoloRoomFloatViewUtil.c(m16, getRoomType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U0(IResultListener<hm4.a> iResultListener) {
        if (!G1()) {
            if (iResultListener != null) {
                iResultListener.onError(-999, "\u5f53\u524d\u623f\u95f4\u8bed\u97f3\u529f\u80fd\u6682\u672a\u5f00\u653e");
            }
            this.C0.j(false);
            return;
        }
        hm4.a aVar = this.f379050n0;
        if (aVar == null) {
            com.tencent.timi.game.utils.l.i("YoloRoomManager", "checkMediaTrtcEnv call requestQQAudioEnv");
            this.f379054r0 = true;
            TimiGameQQTrtcUtil.h(new g(iResultListener));
        } else {
            this.f379054r0 = false;
            if (iResultListener != null) {
                iResultListener.onSuccess(aVar);
            }
        }
    }

    private void U1() {
        SmobaDataOuterClass$YoloTeamInfo smobaDataOuterClass$YoloTeamInfo;
        boolean z16 = true;
        if (getRoomType() == 1) {
            boolean z17 = false;
            if (this.L != null) {
                long g36 = ((ll4.a) mm4.b.b(ll4.a.class)).g3();
                YoloRoomOuterClass$YoloGameRouteInfo yoloRoomOuterClass$YoloGameRouteInfo = this.K;
                SmobaDataOuterClass$YoloTeamMemberInfo smobaDataOuterClass$YoloTeamMemberInfo = null;
                if (yoloRoomOuterClass$YoloGameRouteInfo != null && yoloRoomOuterClass$YoloGameRouteInfo.smoba_game_route_info.has()) {
                    smobaDataOuterClass$YoloTeamInfo = this.K.smoba_game_route_info.team_info;
                } else {
                    smobaDataOuterClass$YoloTeamInfo = null;
                }
                if (smobaDataOuterClass$YoloTeamInfo != null && smobaDataOuterClass$YoloTeamInfo.memberlist.get().size() > 0) {
                    Iterator<SmobaDataOuterClass$YoloTeamMemberInfo> it = smobaDataOuterClass$YoloTeamInfo.memberlist.get().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        SmobaDataOuterClass$YoloTeamMemberInfo next = it.next();
                        if (next.yes_uid.get() == g36) {
                            smobaDataOuterClass$YoloTeamMemberInfo = next;
                            break;
                        }
                    }
                }
                if (smobaDataOuterClass$YoloTeamMemberInfo == null) {
                    z16 = false;
                }
                z17 = z16;
            }
            if (!z17) {
                QBaseActivity b16 = vf4.a.b();
                com.tencent.timi.game.utils.l.e("YoloRoomManager", "notifyGameStarted isPlayerInSmobaTeam is false! " + b16 + " - " + this.f379052p0);
                Dialog dialog = this.f379052p0;
                if (dialog == null || !dialog.isShowing()) {
                    if (b16 != null && !b16.isFinishing() && !((sm4.a) mm4.b.b(sm4.a.class)).y3()) {
                        com.tencent.timi.game.ui.widget.e c16 = new e.a(b16).q("\u961f\u4f0d\u5df2\u5f00\u59cb\u6e38\u620f\u4e86").j("\u6362\u4e2a\u623f\u95f4\uff0c\u5bfb\u627e\u65b0\u7684\u961f\u53cb\u5f00\u9ed1\u5427\uff01").n("\u53d6\u6d88").m(new ao()).p("\u6362\u4e2a\u623f\u95f4").o(new an()).c();
                        this.f379052p0 = c16;
                        c16.show();
                    } else if (((sm4.a) mm4.b.b(sm4.a.class)).y3()) {
                        com.tencent.timi.game.ui.widget.f.c("\u8f66\u901f\u592a\u5feb\u4e3b\u64ad\u5df2\u53d1\u8f66\u5566\uff0c\u8bf7\u7b49\u5f85\u4e0b\u4e00\u5c40\u5427\u3002");
                    } else {
                        com.tencent.timi.game.ui.widget.f.c("\u961f\u4f0d\u5df2\u5f00\u59cb\u6e38\u620f\u4e86\n\u6362\u4e2a\u623f\u95f4\u5bfb\u627e\u65b0\u7684\u961f\u53cb\u5f00\u9ed1\u5427\u3002");
                    }
                }
            }
        }
    }

    private boolean V0() {
        YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo = this.f379034d;
        if (yoloRoomOuterClass$YoloRoomInfo != null && yoloRoomOuterClass$YoloRoomInfo.game_route_info.has() && this.f379034d.game_route_info.smoba_game_route_info.has() && this.f379034d.game_route_info.smoba_game_route_info.team_info.has() && this.f379034d.game_data_info.has() && this.f379034d.game_data_info.smoba_game_data_info.has()) {
            int i3 = this.f379034d.game_data_info.smoba_game_data_info.game_mode.get();
            SmobaDataOuterClass$YoloTeamInfo smobaDataOuterClass$YoloTeamInfo = this.f379034d.game_route_info.smoba_game_route_info.team_info;
            if (i3 == 1) {
                if (smobaDataOuterClass$YoloTeamInfo.maxteammembernum.get() != 3) {
                    return true;
                }
            } else if (i3 == 2 && smobaDataOuterClass$YoloTeamInfo.maxteammembernum.get() != 5) {
                return true;
            }
        }
        return false;
    }

    private void V1(boolean z16) {
        if (!z16) {
            S1();
        }
        YoloRoomOuterClass$YoloRoomConf yoloRoomOuterClass$YoloRoomConf = this.H;
        if (yoloRoomOuterClass$YoloRoomConf != null && yoloRoomOuterClass$YoloRoomConf.yolo_room_common_conf.has()) {
            R1(m1(), this.H.yolo_room_common_conf.forbidden_speech_conf_list.get());
        }
    }

    private void W0() {
        U0(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W1(YoloRoomOuterClass$YoloCommonGameOneSchema yoloRoomOuterClass$YoloCommonGameOneSchema, boolean z16) {
        if (yoloRoomOuterClass$YoloCommonGameOneSchema != null) {
            boolean a16 = ll4.b.a(R(), q1());
            if (!z16 && !a16) {
                RoomGameDoubleCheckDialog roomGameDoubleCheckDialog = this.f379051o0;
                if (roomGameDoubleCheckDialog == null || !roomGameDoubleCheckDialog.isShowing()) {
                    F2();
                }
                am amVar = new am(yoloRoomOuterClass$YoloCommonGameOneSchema);
                RoomGameDoubleCheckDialog roomGameDoubleCheckDialog2 = this.f379051o0;
                if (roomGameDoubleCheckDialog2 != null) {
                    roomGameDoubleCheckDialog2.Y(amVar);
                    return;
                } else {
                    com.tencent.timi.game.utils.l.i("YoloRoomManager", "notifyLaunchGame# mDoubleCheckDialog is null");
                    amVar.a();
                    return;
                }
            }
            com.tencent.timi.game.utils.l.i("YoloRoomManager", "notifyLaunchGame# direct launch game, isSelfOwner = " + a16 + ", isJoinGame = " + z16);
            RoomGameDoubleCheckDialog roomGameDoubleCheckDialog3 = this.f379051o0;
            if (roomGameDoubleCheckDialog3 != null && roomGameDoubleCheckDialog3.isShowing()) {
                this.f379051o0.dismiss();
                this.f379051o0 = null;
            }
            YoloRoomUtil.k0(m1());
            b1("direct launch game");
            nm4.a.a(yoloRoomOuterClass$YoloCommonGameOneSchema.schema.get());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y0(int i3, String str, long j3, int i16, fm4.b bVar) {
        boolean F1 = F1(j3);
        com.tencent.timi.game.utils.l.e("YoloRoomManager", "doYoloRoomCmd - " + i16 + "\uff0c onError,  hasClientTidHandled = " + F1 + ", errorCode = " + i3 + ", errorMessage = " + str);
        YoloRoomUtil.Z(i3);
        if (i3 == 920017) {
            this.f379058v0.n(i3, str);
            c1(i3, str);
        }
        if (i3 == 920009 || i3 == 920003) {
            d1();
        }
        if (bVar != null) {
            bVar.b(i3, str, j3, F1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z0(long j3, YoloRoomOuterClass$DoYoloRoomCmdRsp yoloRoomOuterClass$DoYoloRoomCmdRsp, int i3, fm4.b bVar) {
        boolean F1 = F1(j3);
        com.tencent.timi.game.utils.l.i("YoloRoomManager", "doYoloRoomCmd - " + i3 + "\uff0c Success,  hasClientTidHandled = " + F1);
        String str = "";
        if (yoloRoomOuterClass$DoYoloRoomCmdRsp != null) {
            YoloRoomOuterClass$YoloRoomCmdRsp yoloRoomOuterClass$YoloRoomCmdRsp = yoloRoomOuterClass$DoYoloRoomCmdRsp.yolo_room_cmd_rsp;
            if (bVar != null) {
                bVar.a(yoloRoomOuterClass$YoloRoomCmdRsp, j3, F1, yoloRoomOuterClass$DoYoloRoomCmdRsp);
            }
            SafeOuterClass$SafeCheckResult safeOuterClass$SafeCheckResult = yoloRoomOuterClass$DoYoloRoomCmdRsp.safe_check_result;
            if (safeOuterClass$SafeCheckResult != null && safeOuterClass$SafeCheckResult.has()) {
                SafeOuterClass$SafeCheckResult safeOuterClass$SafeCheckResult2 = yoloRoomOuterClass$DoYoloRoomCmdRsp.safe_check_result;
                com.tencent.timi.game.utils.l.e("YoloRoomManager", "doYoloRoomCmd - " + i3 + ", safeCheckResult = " + safeOuterClass$SafeCheckResult2.code.get() + " - " + safeOuterClass$SafeCheckResult2.check_msg.get());
                if (safeOuterClass$SafeCheckResult2.code.get() != 0 && !TextUtils.isEmpty(safeOuterClass$SafeCheckResult2.check_msg.get())) {
                    str = safeOuterClass$SafeCheckResult2.check_msg.get();
                }
            }
        } else if (bVar != null) {
            bVar.a(null, j3, F1, null);
        }
        if (!TextUtils.isEmpty(str)) {
            com.tencent.timi.game.ui.widget.f.d(true, str);
        } else if (i3 == 14) {
            com.tencent.timi.game.ui.widget.f.c("\u4fee\u6539\u8bbe\u7f6e\u6210\u529f");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a1(final int i3, final String str, final int i16) {
        com.tencent.timi.game.utils.w.c(new Runnable() { // from class: com.tencent.timi.game.room.impl.YoloRoomManager.17
            @Override // java.lang.Runnable
            public void run() {
                String str2;
                if (YoloRoomManager.this.D0) {
                    com.tencent.timi.game.utils.l.e("YoloRoomManager", "checkMediaTrtcEnv requestQQAudioEnv but background!");
                    return;
                }
                int i17 = i3;
                if (i17 == -2) {
                    if (YoloRoomUtil.c0(i16)) {
                        str2 = "\u8f66\u961f\u8bed\u97f3\u529f\u80fd";
                    } else {
                        str2 = "\u8bed\u97f3\u529f\u80fd";
                    }
                    com.tencent.timi.game.ui.widget.f.c("\u6b63\u5728" + str + "\uff0c\u8bf7\u7ed3\u675f\u540e\u624d\u80fd\u4f7f\u7528" + str2);
                    return;
                }
                if (i17 == -1) {
                    com.tencent.timi.game.ui.widget.f.c("\u4e1a\u52a1\u6240\u9700\u7ec4\u4ef6\u52a0\u8f7d\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5\uff1a" + str);
                    return;
                }
                if (i17 == -3) {
                    com.tencent.timi.game.ui.widget.f.c("\u7528\u6237\u6743\u9650\u6821\u9a8c\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5\uff1a" + str);
                }
            }
        });
    }

    private void a2(long j3, CommonOuterClass$QQUserId commonOuterClass$QQUserId, long j16) {
        this.f379058v0.d(j3, commonOuterClass$QQUserId, j16);
    }

    public static void b1(String str) {
        com.tencent.timi.game.utils.l.i("YoloRoomManager", "doWhenLaunchGame - " + str);
        YoloRoomTGPALogic.m(str);
    }

    private void b2(CommonOuterClass$QQUserId commonOuterClass$QQUserId, long j3) {
        this.f379058v0.u(commonOuterClass$QQUserId, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c1(int i3, String str) {
        com.tencent.timi.game.utils.l.e("YoloRoomManager", "doWhenNetErrorNeedAutoExitRoom " + i3 + " - " + str);
        B2(false);
        O1(true, 0, null, true);
    }

    private void c2(String str, int i3, YoloRoomOuterClass$YoloBattleOBStatusChangeAction yoloRoomOuterClass$YoloBattleOBStatusChangeAction) {
        if (i3 != this.N) {
            this.N = i3;
        }
        this.f379058v0.r(str, i3, yoloRoomOuterClass$YoloBattleOBStatusChangeAction);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d1() {
        com.tencent.timi.game.utils.l.e("YoloRoomManager", "doWhenNetErrorNotInRoom, mRoomId = " + this.f379041h);
        if (this.f379041h != 0) {
            O1(true, 0, null, false);
        }
        d2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d2() {
        com.tencent.timi.game.utils.l.e("YoloRoomManager", "onExitRoom");
        ((kn4.b) mm4.b.b(kn4.b.class)).V1().c(this.f379061y0);
        T1();
        z2();
    }

    private void e2(int i3, YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo, int i16) {
        J2(yoloRoomOuterClass$YoloRoomSpeakingPosInfo, i16);
        this.f379058v0.e(i3, yoloRoomOuterClass$YoloRoomSpeakingPosInfo, this.F);
    }

    private void f2(CommonOuterClass$QQUserId commonOuterClass$QQUserId, CommonOuterClass$QQUserId commonOuterClass$QQUserId2, long j3, long j16) {
        this.f379058v0.t(commonOuterClass$QQUserId, commonOuterClass$QQUserId2, j3, j16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g1(CommonOuterClass$QQUserId commonOuterClass$QQUserId, int i3, IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> iResultListener) {
        if (commonOuterClass$QQUserId == null || ll4.b.a(commonOuterClass$QQUserId, q1())) {
            boolean z16 = true;
            if (i3 != 1) {
                z16 = false;
            }
            C2(z16);
        }
        YoloRoomOuterClass$YoloRoomVoiceSwitchChangeCmd yoloRoomOuterClass$YoloRoomVoiceSwitchChangeCmd = new YoloRoomOuterClass$YoloRoomVoiceSwitchChangeCmd();
        yoloRoomOuterClass$YoloRoomVoiceSwitchChangeCmd.f437266op.set(i3);
        if (commonOuterClass$QQUserId != null) {
            yoloRoomOuterClass$YoloRoomVoiceSwitchChangeCmd.user_id.set(commonOuterClass$QQUserId);
        }
        YoloRoomOuterClass$YoloRoomCmdReq yoloRoomOuterClass$YoloRoomCmdReq = new YoloRoomOuterClass$YoloRoomCmdReq();
        yoloRoomOuterClass$YoloRoomCmdReq.yolo_room_voice_switch_change_cmd.set(yoloRoomOuterClass$YoloRoomVoiceSwitchChangeCmd);
        e1(13, yoloRoomOuterClass$YoloRoomCmdReq, new q(iResultListener));
    }

    private long h1() {
        long j3 = this.X + 1;
        this.Y.put(Long.valueOf(j3), Boolean.TRUE);
        this.X = j3;
        return j3;
    }

    private void h2(List<YoloRoomOuterClass$YoloRoomModifyInfoActionContent> list, YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo) {
        if (getRoomInfo().room_id.get() == yoloRoomOuterClass$YoloRoomInfo.room_id.get()) {
            D2(yoloRoomOuterClass$YoloRoomInfo);
        }
        this.f379058v0.p(list);
    }

    private void j2(int i3, YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo, int i16) {
        J2(yoloRoomOuterClass$YoloRoomSpeakingPosInfo, i16);
        this.f379058v0.k(i3, yoloRoomOuterClass$YoloRoomSpeakingPosInfo, this.F);
    }

    private void k2(List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> list, int i3, boolean z16) {
        if (z16 || M1(i3, "onSpeakingPosListChanged")) {
            this.F.clear();
            if (list != null && list.size() > 0) {
                this.F.addAll(list);
            }
            this.G = i3;
            com.tencent.timi.game.utils.l.i("YoloRoomManager", "onSpeakingPosListChanged, posListVersion = " + i3 + ", isForceUpdateList = " + z16);
            this.f379058v0.o(this.F);
        }
    }

    private void l2(YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo, int i3) {
        J2(yoloRoomOuterClass$YoloRoomSpeakingPosInfo, i3);
        this.f379058v0.w(yoloRoomOuterClass$YoloRoomSpeakingPosInfo, this.F);
    }

    private void m2(CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
        this.f379058v0.y(commonOuterClass$QQUserId);
    }

    private void n2(CommonOuterClass$QQUserId commonOuterClass$QQUserId, int i3, YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo, int i16) {
        com.tencent.timi.game.utils.l.e("YoloRoomManager", "onUserKickedOutRoom - " + commonOuterClass$QQUserId + " - " + i3);
        if (yoloRoomOuterClass$YoloRoomSpeakingPosInfo != null) {
            J2(yoloRoomOuterClass$YoloRoomSpeakingPosInfo, i16);
        }
        this.f379058v0.x(commonOuterClass$QQUserId, yoloRoomOuterClass$YoloRoomSpeakingPosInfo, this.F);
        if (ll4.b.a(commonOuterClass$QQUserId, q1()) && H1()) {
            String str = "\u4f60\u88ab\u8e22\u51fa\u623f\u95f4";
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            str = "\u957f\u65f6\u95f4\u6ca1\u6709\u6d3b\u52a8\uff0c\u4f60\u88ab\u79fb\u51fa\u4e86\u623f\u95f4";
                        }
                    } else {
                        str = "\u957f\u65f6\u95f4\u6ca1\u6709\u51c6\u5907\uff0c\u4f60\u88ab\u79fb\u51fa\u4e86\u623f\u95f4";
                    }
                } else {
                    str = "\u7531\u4e8e\u6ca1\u6709\u786e\u8ba4\uff0c\u4f60\u88ab\u79fb\u51fa\u4e86\u623f\u95f4";
                }
            }
            com.tencent.timi.game.ui.widget.f.c(str);
            com.tencent.timi.game.utils.l.e("YoloRoomManager", "onUserKickedOutRoom self kicked out!");
            d2();
        }
    }

    private void o2(CommonOuterClass$QQUserId commonOuterClass$QQUserId, YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo, int i3, int i16) {
        hm4.a aVar;
        if (ll4.b.a(commonOuterClass$QQUserId, q1()) && (aVar = this.f379050n0) != null) {
            aVar.y(false);
        }
        J2(yoloRoomOuterClass$YoloRoomSpeakingPosInfo, i3);
        this.f379058v0.m(commonOuterClass$QQUserId, yoloRoomOuterClass$YoloRoomSpeakingPosInfo, this.F, i16);
    }

    private void p2(CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
        this.f379058v0.v(commonOuterClass$QQUserId);
    }

    private void q2(int i3, YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo, int i16) {
        com.tencent.timi.game.utils.l.i("YoloRoomManager", "onVoiceSwitchChanged - " + i3 + ", yesuid= " + LogUtil.getSafePrintUin(String.valueOf(yoloRoomOuterClass$YoloRoomSpeakingPosInfo.user_id.yes_uid.get())) + ", listVersion= " + i16);
        YoloRoomOuterClass$YoloRoomSpeakingPosInfo r16 = r1();
        J2(yoloRoomOuterClass$YoloRoomSpeakingPosInfo, i16);
        if (ll4.b.a(yoloRoomOuterClass$YoloRoomSpeakingPosInfo.user_id, q1())) {
            if (i3 == 3) {
                com.tencent.timi.game.ui.widget.f.c("\u5df2\u88ab\u7ba1\u7406\u5458\u7981\u9ea6");
                com.tencent.timi.game.utils.l.i("YoloRoomManager", "onVoiceSwitchChanged mic forbidden by owner!");
                C2(false);
            } else if (r16 != null && r16.voice_switch.get() == 3) {
                com.tencent.timi.game.ui.widget.f.c("\u7ba1\u7406\u5458\u5df2\u89e3\u9664\u4e86\u4f60\u7684\u9ea6\u4f4d\u9759\u97f3\uff0c\u53ef\u4ee5\u6062\u590d\u8bed\u97f3\u804a\u5929\u5566");
                com.tencent.timi.game.utils.l.i("YoloRoomManager", "onVoiceSwitchChanged mic resumed by owner!");
            }
        }
        this.f379058v0.i(i3, yoloRoomOuterClass$YoloRoomSpeakingPosInfo, this.F);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r2(YoloRoomOuterClass$YoloRoomAction yoloRoomOuterClass$YoloRoomAction, YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo, int i3) {
        boolean z16;
        int i16 = this.J;
        D2(yoloRoomOuterClass$YoloRoomInfo);
        if (this.J != i16) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.timi.game.utils.l.i("YoloRoomManager", "onYoloRoomInfoUpdate " + i3 + ", roomGameStatus = " + this.J + ", isGameStatusChanged = " + z16);
        this.f379058v0.s(z16, this.J, this.f379034d.game_route_info);
        if (z16 && this.J == 3) {
            U1();
        }
    }

    private void s2(int i3, YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo, int i16) {
        J2(yoloRoomOuterClass$YoloRoomSpeakingPosInfo, i16);
        this.f379058v0.z(i3, yoloRoomOuterClass$YoloRoomSpeakingPosInfo, this.F);
    }

    private void t1(YoloRoomOuterClass$YoloRoomAction yoloRoomOuterClass$YoloRoomAction) {
        YoloRoomOuterClass$YoloRoomForbiddenSpeechAction yoloRoomOuterClass$YoloRoomForbiddenSpeechAction = yoloRoomOuterClass$YoloRoomAction.yolo_room_forbidden_speech_action;
        if (yoloRoomOuterClass$YoloRoomForbiddenSpeechAction != null && ll4.b.a(yoloRoomOuterClass$YoloRoomForbiddenSpeechAction.user_id, q1())) {
            Iterator<fm4.s> it = this.f379046k0.iterator();
            while (it.hasNext()) {
                it.next().c(yoloRoomOuterClass$YoloRoomForbiddenSpeechAction.second.get());
            }
        }
    }

    private void u1(YoloRoomOuterClass$YoloRoomAction yoloRoomOuterClass$YoloRoomAction) {
        List<CommonOuterClass$QQUserId> list = yoloRoomOuterClass$YoloRoomAction.yolo_game_room_settle_gift_notice_action.unsettle_user_id_list.get();
        if (J1(list)) {
            com.tencent.timi.game.utils.l.i("YoloRoomManager", "YOlO_ACTION_TYPE_GAME_ROOM_SETTLE_GIFT_NOTICE received , userList.size == " + list.size());
            com.tencent.timi.game.ui.widget.f.c("\u672c\u5c40\u6bd4\u8d5b\u5bf9\u5c40\u5f02\u5e38\uff0c\u9884\u4ed8\u91d1\u5e01\u5c06\u9000\u56de\u8d26\u6237\u3002");
            return;
        }
        com.tencent.timi.game.utils.l.e("YoloRoomManager", "YOlO_ACTION_TYPE_GAME_ROOM_SETTLE_GIFT_NOTICE received , but userList is empty");
    }

    public static YoloRoomOuterClass$YoloCommonGameOneSchema u2(YoloRoomOuterClass$YoloCommonGameRouteInfo yoloRoomOuterClass$YoloCommonGameRouteInfo, CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
        YoloRoomOuterClass$YoloCommonGameSchema yoloRoomOuterClass$YoloCommonGameSchema;
        if (yoloRoomOuterClass$YoloCommonGameRouteInfo != null && yoloRoomOuterClass$YoloCommonGameRouteInfo.has() && (yoloRoomOuterClass$YoloCommonGameSchema = yoloRoomOuterClass$YoloCommonGameRouteInfo.common_game_schema) != null && yoloRoomOuterClass$YoloCommonGameSchema.schemas.size() > 0) {
            for (int i3 = 0; i3 < yoloRoomOuterClass$YoloCommonGameSchema.schemas.size(); i3++) {
                YoloRoomOuterClass$YoloCommonGameOneSchema yoloRoomOuterClass$YoloCommonGameOneSchema = yoloRoomOuterClass$YoloCommonGameSchema.schemas.get(i3);
                if (ll4.b.a(yoloRoomOuterClass$YoloCommonGameOneSchema.user_id, commonOuterClass$QQUserId)) {
                    return yoloRoomOuterClass$YoloCommonGameOneSchema;
                }
            }
            return null;
        }
        return null;
    }

    private void v1() {
        YoloRoomOuterClass$YoloRoomConf yoloRoomOuterClass$YoloRoomConf = this.H;
        if (yoloRoomOuterClass$YoloRoomConf != null && yoloRoomOuterClass$YoloRoomConf.yolo_room_common_conf.has()) {
            H2(this.H.yolo_room_common_conf.get_data_pull_time.get());
            YoloRoomCommonConfManager yoloRoomCommonConfManager = YoloRoomCommonConfManager.f379027a;
            yoloRoomCommonConfManager.f(this.H.yolo_room_common_conf.safe_conf.send_interval_times.get());
            yoloRoomCommonConfManager.e(this.H.yolo_room_common_conf.safe_conf.game_room_send_interval_times.get());
            List<String> list = this.H.yolo_room_common_conf.enter_room_greet_words_list.get();
            if (list != null && !list.isEmpty()) {
                yoloRoomCommonConfManager.d(list);
                return;
            }
            return;
        }
        com.tencent.timi.game.utils.l.e("YoloRoomManager", "onJoinNewRoom, no commonConf - ");
    }

    private void w1(int i3, YoloRoomOuterClass$YoloRoomAction yoloRoomOuterClass$YoloRoomAction) {
        if (i3 == 151 && o1() == 101) {
            com.tencent.timi.game.utils.l.e("YoloRoomManager", "handleOwnerChangeAction old version new action!");
            return;
        }
        YoloRoomOuterClass$YoloGameRoomOwnerChangeAction yoloRoomOuterClass$YoloGameRoomOwnerChangeAction = yoloRoomOuterClass$YoloRoomAction.yolo_game_room_owner_change_action;
        if (i3 != 151 && yoloRoomOuterClass$YoloRoomAction.yolo_smoba_room_owner_change_action.has()) {
            YoloRoomOuterClass$YoloSmobaRoomOwnerChangeAction yoloRoomOuterClass$YoloSmobaRoomOwnerChangeAction = yoloRoomOuterClass$YoloRoomAction.yolo_smoba_room_owner_change_action;
            yoloRoomOuterClass$YoloGameRoomOwnerChangeAction = new YoloRoomOuterClass$YoloGameRoomOwnerChangeAction();
            yoloRoomOuterClass$YoloGameRoomOwnerChangeAction.from_user_id.set(yoloRoomOuterClass$YoloSmobaRoomOwnerChangeAction.from_user_id.get());
            yoloRoomOuterClass$YoloGameRoomOwnerChangeAction.to_user_id.set(yoloRoomOuterClass$YoloSmobaRoomOwnerChangeAction.to_user_id.get());
            yoloRoomOuterClass$YoloGameRoomOwnerChangeAction.room_speaking_pos_list.addAll(yoloRoomOuterClass$YoloSmobaRoomOwnerChangeAction.room_speaking_pos_list.get());
            yoloRoomOuterClass$YoloGameRoomOwnerChangeAction.speaking_pos_list_version.set(yoloRoomOuterClass$YoloSmobaRoomOwnerChangeAction.speaking_pos_list_version.get());
            yoloRoomOuterClass$YoloGameRoomOwnerChangeAction.reason.set(yoloRoomOuterClass$YoloSmobaRoomOwnerChangeAction.reason.get());
        }
        com.tencent.timi.game.utils.l.e("YoloRoomManager", "handleOwnerChangeAction, reason = " + yoloRoomOuterClass$YoloGameRoomOwnerChangeAction.reason.get() + ", toUserId = " + yoloRoomOuterClass$YoloGameRoomOwnerChangeAction.to_user_id.yes_uid.get());
        if (!ll4.b.a(R(), yoloRoomOuterClass$YoloGameRoomOwnerChangeAction.to_user_id)) {
            if (ll4.b.a(R(), q1())) {
                com.tencent.timi.game.utils.l.e("YoloRoomManager", "handleOwnerChangeAction self is not owner any more!");
            }
            YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo = new YoloRoomOuterClass$YoloRoomInfo();
            yoloRoomOuterClass$YoloRoomInfo.set(getRoomInfo());
            yoloRoomOuterClass$YoloRoomInfo.owner_user_id.set(yoloRoomOuterClass$YoloGameRoomOwnerChangeAction.to_user_id);
            D2(yoloRoomOuterClass$YoloRoomInfo);
        }
        YoloRoomOuterClass$YoloRoomSpeakingPosInfo r16 = r1();
        k2(yoloRoomOuterClass$YoloGameRoomOwnerChangeAction.room_speaking_pos_list.get(), yoloRoomOuterClass$YoloGameRoomOwnerChangeAction.speaking_pos_list_version.get(), true);
        YoloRoomOuterClass$YoloRoomSpeakingPosInfo r17 = r1();
        if (r16 != null && r17 != null) {
            if (r16.voice_switch.get() != r17.voice_switch.get()) {
                com.tencent.timi.game.utils.l.e("YoloRoomManager", "YOLO_ACTION_TYPE_OWNER_CHANGE - self VoiceSwitch changed! old=" + r16.voice_switch.get() + ", new=" + r17.voice_switch.get());
                q2(r17.voice_switch.get(), r17, yoloRoomOuterClass$YoloGameRoomOwnerChangeAction.speaking_pos_list_version.get());
            }
        } else if (r16 != null && r17 == null && yoloRoomOuterClass$YoloGameRoomOwnerChangeAction.reason.get() == 2) {
            com.tencent.timi.game.utils.l.e("YoloRoomManager", "handleOwnerChangeAction self kicked! - " + yoloRoomOuterClass$YoloGameRoomOwnerChangeAction.reason.get());
            n2(q1(), 3, null, this.G);
        }
        ((bo4.d) mm4.b.b(bo4.d.class)).I3(yoloRoomOuterClass$YoloGameRoomOwnerChangeAction.to_user_id, new ak(yoloRoomOuterClass$YoloGameRoomOwnerChangeAction.to_user_id));
        this.f379058v0.q(yoloRoomOuterClass$YoloGameRoomOwnerChangeAction.to_user_id);
    }

    private void w2() {
        try {
            com.tencent.timi.game.utils.w.e(this.f379062z0);
        } catch (Exception e16) {
            com.tencent.timi.game.utils.l.f("YoloRoomManager", "loop removeCallback error", e16);
        }
    }

    private void x1() {
        Object obj;
        YoloRoomOuterClass$YoloRoomDoubleCheckPlayer v3 = v(q1());
        StringBuilder sb5 = new StringBuilder();
        sb5.append("handlePlayerDoubleCheck - selfDoubleCheckPlayer = ");
        sb5.append(v3);
        sb5.append(" - ");
        RoomGameDoubleCheckDialog roomGameDoubleCheckDialog = this.f379051o0;
        if (roomGameDoubleCheckDialog != null) {
            obj = Boolean.valueOf(roomGameDoubleCheckDialog.isShowing());
        } else {
            obj = "null";
        }
        sb5.append(obj);
        com.tencent.timi.game.utils.l.i("YoloRoomManager", sb5.toString());
        if (v3 != null) {
            RoomGameDoubleCheckDialog roomGameDoubleCheckDialog2 = this.f379051o0;
            if (roomGameDoubleCheckDialog2 != null && roomGameDoubleCheckDialog2.isShowing()) {
                this.f379051o0.c0(i1(), 0L);
            } else {
                F2();
            }
        }
    }

    private void x2() {
        YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo;
        if (YoloRoomUtil.c0(this.C) && (yoloRoomOuterClass$YoloRoomInfo = this.f379034d) != null && yoloRoomOuterClass$YoloRoomInfo.room_data_info.sub_create_from.get() != 3) {
            ConcurrentHashMap<String, String> L = YoloRoomUtil.L(getRoomInfo());
            if (getRoomInfo() != null) {
                gh4.e I0 = ((gh4.f) mm4.b.b(gh4.f.class)).I0();
                if (I0 != null && I0.m0() != null) {
                    L.put("yes_member_tag_id", I0.m0().o(getRoomInfo().room_id.get()));
                    L.put("yes_ref_scene", I0.m0().L(getRoomInfo().room_id.get()));
                }
                YoloRoomOuterClass$YoloRoomSpeakingPosInfo r16 = r1();
                if (r16 != null && r16.user_from.get() == 4) {
                    L.put("yes_ref_scene", "4");
                }
                L.put("yes_team_leader_uid", getRoomInfo().owner_user_id.yes_uid.get() + "");
            }
            if (um4.h.a()) {
                L.put("yes_gift_price", String.valueOf(um4.h.f439235c));
                um4.h.b();
            }
            ((ug4.b) mm4.b.b(ug4.b.class)).reportEvent("ev_yes_team_join_success", L);
        }
    }

    private void y1(int i3, YoloRoomOuterClass$YoloRoomAction yoloRoomOuterClass$YoloRoomAction) {
        CommonOuterClass$QQUserId commonOuterClass$QQUserId;
        if (i3 == 150 && o1() == 101) {
            com.tencent.timi.game.utils.l.e("YoloRoomManager", "handleRemindAction old version new action!");
            return;
        }
        if (i3 == 150) {
            commonOuterClass$QQUserId = yoloRoomOuterClass$YoloRoomAction.yolo_game_room_remind_owner_start_game_action.owner_user_id;
        } else {
            commonOuterClass$QQUserId = yoloRoomOuterClass$YoloRoomAction.yolo_smoba_room_remind_owner_start_game_action.owner_user_id;
        }
        if (ll4.b.a(commonOuterClass$QQUserId, q1())) {
            com.tencent.timi.game.utils.l.i("YoloRoomManager", "YOLO_ACTION_TYPE_REMIND_OWNER_START_GAME");
            com.tencent.timi.game.ui.widget.f.c("\u961f\u5458\u558a\u4f60\u53d1\u8f66\u5566\uff0c\u5feb\u56de\u53bb\u770b\u770b\u5427~");
            this.f379058v0.c(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y2() {
        long j3 = this.f379041h;
        int i3 = 1;
        if (this.T) {
            com.tencent.timi.game.utils.l.b("YoloRoomManager", "requestingRoomData = true,waiting for request finish");
            this.V = true;
            return;
        }
        this.T = true;
        boolean z16 = this.Z;
        this.Z = false;
        if (YoloRoomUtil.c0(getRoomType())) {
            i3 = z16 ? 1 : 0;
        }
        com.tencent.timi.game.utils.l.i("YoloRoomManager", "requestRoomData - " + this.f379041h + ", clientMaxId = " + this.P);
        ((pl4.c) mm4.b.b(pl4.c.class)).F1(jm4.f.d(this.f379041h, this.P, i3), YoloRoomOuterClass$GetYoloRoomDataRsp.class, new ai(j3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z1(YoloRoomOuterClass$YoloRoomAction yoloRoomOuterClass$YoloRoomAction, List<CommonOuterClass$QQUserId> list) {
        YoloRoomOuterClass$YoloCommonGameOneSchema yoloRoomOuterClass$YoloCommonGameOneSchema;
        int i3 = yoloRoomOuterClass$YoloRoomAction.action_type.get();
        com.tencent.timi.game.utils.l.i("YoloRoomManager", "handleRoomAction " + i3 + ", actionId = " + yoloRoomOuterClass$YoloRoomAction.action_id.get() + ", actionTime = " + yoloRoomOuterClass$YoloRoomAction.action_time.get() + ", clientTid = " + yoloRoomOuterClass$YoloRoomAction.client_seq_id.get());
        if (i3 != 27) {
            boolean z16 = true;
            if (i3 != 105) {
                if (i3 != 151) {
                    if (i3 != 201) {
                        if (i3 != 251) {
                            int i16 = 0;
                            if (i3 != 260) {
                                if (i3 != 107) {
                                    if (i3 != 108) {
                                        switch (i3) {
                                            case 11:
                                                YoloRoomOuterClass$YoloRoomSpeakingPosChangeAction yoloRoomOuterClass$YoloRoomSpeakingPosChangeAction = yoloRoomOuterClass$YoloRoomAction.yolo_room_speaking_pos_change_action;
                                                if (M1(yoloRoomOuterClass$YoloRoomSpeakingPosChangeAction.speaking_pos_list_version.get(), "YOLO_ACTION_TYPE_SPEAKING_POS_CHANGE")) {
                                                    e2(yoloRoomOuterClass$YoloRoomSpeakingPosChangeAction.f437261op.get(), yoloRoomOuterClass$YoloRoomSpeakingPosChangeAction.room_speaking_pos, yoloRoomOuterClass$YoloRoomSpeakingPosChangeAction.speaking_pos_list_version.get());
                                                    return;
                                                }
                                                return;
                                            case 12:
                                                YoloRoomOuterClass$YoloRoomReadyStatusChangeAction yoloRoomOuterClass$YoloRoomReadyStatusChangeAction = yoloRoomOuterClass$YoloRoomAction.yolo_room_ready_status_change_action;
                                                if (M1(yoloRoomOuterClass$YoloRoomReadyStatusChangeAction.speaking_pos_list_version.get(), "YOLO_ACTION_TYPE_READY_STATUS_CHANGE")) {
                                                    j2(yoloRoomOuterClass$YoloRoomReadyStatusChangeAction.f437259op.get(), yoloRoomOuterClass$YoloRoomReadyStatusChangeAction.room_speaking_pos, yoloRoomOuterClass$YoloRoomReadyStatusChangeAction.speaking_pos_list_version.get());
                                                    return;
                                                }
                                                return;
                                            case 13:
                                                YoloRoomOuterClass$YoloRoomVoiceSwitchChangeAction yoloRoomOuterClass$YoloRoomVoiceSwitchChangeAction = yoloRoomOuterClass$YoloRoomAction.yolo_room_voice_switch_change_action;
                                                if (M1(yoloRoomOuterClass$YoloRoomVoiceSwitchChangeAction.speaking_pos_list_version.get(), "YOLO_ACTION_TYPE_VOICE_SWITCH_CHANGE")) {
                                                    q2(yoloRoomOuterClass$YoloRoomVoiceSwitchChangeAction.f437265op.get(), yoloRoomOuterClass$YoloRoomVoiceSwitchChangeAction.room_speaking_pos, yoloRoomOuterClass$YoloRoomVoiceSwitchChangeAction.speaking_pos_list_version.get());
                                                    return;
                                                }
                                                return;
                                            case 14:
                                                YoloRoomOuterClass$YoloRoomModifyInfoAction yoloRoomOuterClass$YoloRoomModifyInfoAction = yoloRoomOuterClass$YoloRoomAction.yolo_room_modify_info_action;
                                                h2(yoloRoomOuterClass$YoloRoomModifyInfoAction.action_content_list.get(), yoloRoomOuterClass$YoloRoomModifyInfoAction.room_info);
                                                if (yoloRoomOuterClass$YoloRoomModifyInfoAction.room_speaking_pos_list.has() && yoloRoomOuterClass$YoloRoomModifyInfoAction.room_speaking_pos_list.size() > 0) {
                                                    com.tencent.timi.game.utils.l.i("YoloRoomManager", "onModifyRoomInfo update speakingPosList");
                                                    k2(yoloRoomOuterClass$YoloRoomModifyInfoAction.room_speaking_pos_list.get(), yoloRoomOuterClass$YoloRoomModifyInfoAction.speaking_pos_list_version.get(), false);
                                                    return;
                                                }
                                                return;
                                            case 15:
                                                YoloRoomOuterClass$YoloRoomSpeakingPosStatusChangeAction yoloRoomOuterClass$YoloRoomSpeakingPosStatusChangeAction = yoloRoomOuterClass$YoloRoomAction.yolo_room_speaking_pos_status_change_action;
                                                if (M1(yoloRoomOuterClass$YoloRoomSpeakingPosStatusChangeAction.speaking_pos_list_version.get(), "YOLO_ACTION_TYPE_SPEAKING_POS_STATUS_CHANGE")) {
                                                    s2(yoloRoomOuterClass$YoloRoomSpeakingPosStatusChangeAction.f437263op.get(), yoloRoomOuterClass$YoloRoomSpeakingPosStatusChangeAction.room_speaking_pos, yoloRoomOuterClass$YoloRoomSpeakingPosStatusChangeAction.speaking_pos_list_version.get());
                                                    return;
                                                }
                                                return;
                                            default:
                                                switch (i3) {
                                                    case 18:
                                                        YoloRoomOuterClass$YoloRoomKickOutSpeakingAction yoloRoomOuterClass$YoloRoomKickOutSpeakingAction = yoloRoomOuterClass$YoloRoomAction.yolo_room_kick_out_speaking_action;
                                                        if (M1(yoloRoomOuterClass$YoloRoomKickOutSpeakingAction.speaking_pos_list_version.get(), "YOLO_ACTION_TYPE_KICK_OUT_SPEAKING")) {
                                                            com.tencent.timi.game.room.impl.util.h.f379336a.a(yoloRoomOuterClass$YoloRoomKickOutSpeakingAction.user_id, m1(), yoloRoomOuterClass$YoloRoomKickOutSpeakingAction.reason.get());
                                                            o2(yoloRoomOuterClass$YoloRoomKickOutSpeakingAction.user_id, yoloRoomOuterClass$YoloRoomKickOutSpeakingAction.room_speaking_pos, yoloRoomOuterClass$YoloRoomKickOutSpeakingAction.speaking_pos_list_version.get(), yoloRoomOuterClass$YoloRoomKickOutSpeakingAction.reason.get());
                                                            return;
                                                        }
                                                        return;
                                                    case 19:
                                                        YoloRoomOuterClass$YoloRoomKickOutRoomAction yoloRoomOuterClass$YoloRoomKickOutRoomAction = yoloRoomOuterClass$YoloRoomAction.yolo_room_kick_out_room_action;
                                                        if (!yoloRoomOuterClass$YoloRoomKickOutRoomAction.room_speaking_pos.has() || M1(yoloRoomOuterClass$YoloRoomKickOutRoomAction.speaking_pos_list_version.get(), "YOLO_ACTION_TYPE_KICK_OUT_ROOM")) {
                                                            n2(yoloRoomOuterClass$YoloRoomKickOutRoomAction.user_id, (int) yoloRoomOuterClass$YoloRoomKickOutRoomAction.reason.get(), yoloRoomOuterClass$YoloRoomKickOutRoomAction.room_speaking_pos, yoloRoomOuterClass$YoloRoomKickOutRoomAction.speaking_pos_list_version.get());
                                                        }
                                                        YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo = this.f379034d;
                                                        if (yoloRoomOuterClass$YoloRoomInfo != null) {
                                                            com.tencent.timi.game.room.impl.util.g.f379335a.i(yoloRoomOuterClass$YoloRoomAction, yoloRoomOuterClass$YoloRoomInfo.tim_group_id.get(), this.f379034d.room_id.get());
                                                            return;
                                                        }
                                                        return;
                                                    case 20:
                                                        r2(yoloRoomOuterClass$YoloRoomAction, yoloRoomOuterClass$YoloRoomAction.yolo_room_start_game_action.room_info, i3);
                                                        YoloRoomOuterClass$YoloRoomStartGameAction yoloRoomOuterClass$YoloRoomStartGameAction = yoloRoomOuterClass$YoloRoomAction.yolo_room_start_game_action;
                                                        if (yoloRoomOuterClass$YoloRoomStartGameAction.speaking_pos_list_version.has() && yoloRoomOuterClass$YoloRoomStartGameAction.room_speaking_pos_list.has()) {
                                                            k2(yoloRoomOuterClass$YoloRoomStartGameAction.room_speaking_pos_list.get(), yoloRoomOuterClass$YoloRoomStartGameAction.speaking_pos_list_version.get(), true);
                                                        }
                                                        com.tencent.timi.game.utils.l.h("YoloRoomManager", 1, "ACTION_TYPE_START_GAME - need launch game");
                                                        W1(this.L, false);
                                                        return;
                                                    case 21:
                                                        r2(yoloRoomOuterClass$YoloRoomAction, yoloRoomOuterClass$YoloRoomAction.yolo_room_join_game_action.room_info, i3);
                                                        YoloRoomOuterClass$YoloRoomJoinGameAction yoloRoomOuterClass$YoloRoomJoinGameAction = yoloRoomOuterClass$YoloRoomAction.yolo_room_join_game_action;
                                                        if (yoloRoomOuterClass$YoloRoomJoinGameAction.speaking_pos_list_version.has() && yoloRoomOuterClass$YoloRoomJoinGameAction.room_speaking_pos_list.has()) {
                                                            k2(yoloRoomOuterClass$YoloRoomJoinGameAction.room_speaking_pos_list.get(), yoloRoomOuterClass$YoloRoomJoinGameAction.speaking_pos_list_version.get(), true);
                                                            return;
                                                        }
                                                        return;
                                                    case 22:
                                                        r2(yoloRoomOuterClass$YoloRoomAction, yoloRoomOuterClass$YoloRoomAction.yolo_room_double_check_action.room_info, i3);
                                                        x1();
                                                        return;
                                                    default:
                                                        Iterator<com.tencent.timi.game.room.impl.a> it = this.f379049m0.iterator();
                                                        while (true) {
                                                            if (it.hasNext()) {
                                                                if (it.next().a(i3, yoloRoomOuterClass$YoloRoomAction)) {
                                                                }
                                                            } else {
                                                                z16 = false;
                                                            }
                                                        }
                                                        if (!z16) {
                                                            com.tencent.timi.game.utils.l.i("YoloRoomManager", "handleRoomAction not handled! - " + i3 + " - " + yoloRoomOuterClass$YoloRoomAction);
                                                            return;
                                                        }
                                                        return;
                                                }
                                        }
                                    }
                                    r2(yoloRoomOuterClass$YoloRoomAction, yoloRoomOuterClass$YoloRoomAction.yolo_room_update_game_route_info_action.room_info, i3);
                                    YoloRoomOuterClass$YoloRoomUpdateGameRouteInfoAction yoloRoomOuterClass$YoloRoomUpdateGameRouteInfoAction = yoloRoomOuterClass$YoloRoomAction.yolo_room_update_game_route_info_action;
                                    if (yoloRoomOuterClass$YoloRoomUpdateGameRouteInfoAction.speaking_pos_list_version.has() && yoloRoomOuterClass$YoloRoomUpdateGameRouteInfoAction.room_speaking_pos_list.has()) {
                                        k2(yoloRoomOuterClass$YoloRoomUpdateGameRouteInfoAction.room_speaking_pos_list.get(), yoloRoomOuterClass$YoloRoomUpdateGameRouteInfoAction.speaking_pos_list_version.get(), true);
                                    }
                                    if (this.J == 0 && !TextUtils.isEmpty(yoloRoomOuterClass$YoloRoomAction.yolo_room_update_game_route_info_action.status_change_text.get())) {
                                        com.tencent.timi.game.room.impl.util.g.f379335a.i(yoloRoomOuterClass$YoloRoomAction, this.f379034d.tim_group_id.get(), this.f379034d.room_id.get());
                                    }
                                    if (this.J != 3 && (yoloRoomOuterClass$YoloCommonGameOneSchema = this.L) != null && yoloRoomOuterClass$YoloCommonGameOneSchema.launch_game.get()) {
                                        com.tencent.timi.game.utils.l.h("YoloRoomManager", 1, "UPDATE_GAME_ROUTE_INFO - need launch game");
                                        W1(yoloRoomOuterClass$YoloCommonGameOneSchema, false);
                                        return;
                                    }
                                    return;
                                }
                                r2(yoloRoomOuterClass$YoloRoomAction, yoloRoomOuterClass$YoloRoomAction.yolo_room_close_game_action.room_info, i3);
                                return;
                            }
                            YoloRoomOuterClass$YoloBattleOBStatusChangeAction yoloRoomOuterClass$YoloBattleOBStatusChangeAction = yoloRoomOuterClass$YoloRoomAction.yolo_battle_ob_status_change_action;
                            int i17 = yoloRoomOuterClass$YoloBattleOBStatusChangeAction.status.get();
                            if (i17 <= 0) {
                                com.tencent.timi.game.utils.l.i("YoloRoomManager", "YOLO_ACTION_TYPE_BATTLE_OB_STATUS_CHANGE get exception obStatus " + yoloRoomOuterClass$YoloBattleOBStatusChangeAction.status);
                            } else {
                                i16 = i17;
                            }
                            c2("", i16, yoloRoomOuterClass$YoloBattleOBStatusChangeAction);
                            return;
                        }
                    } else {
                        YoloRoomOuterClass$YoloSmobaRoomChooceHeroAction yoloRoomOuterClass$YoloSmobaRoomChooceHeroAction = yoloRoomOuterClass$YoloRoomAction.yolo_smoba_room_chooce_hero_action;
                        if (M1(yoloRoomOuterClass$YoloSmobaRoomChooceHeroAction.speaking_pos_list_version.get(), "YOLO_ACTION_TYPE_SMOBA_CHOOCE_HERO")) {
                            l2(yoloRoomOuterClass$YoloSmobaRoomChooceHeroAction.room_speaking_pos, yoloRoomOuterClass$YoloSmobaRoomChooceHeroAction.speaking_pos_list_version.get());
                            return;
                        }
                        return;
                    }
                }
                w1(i3, yoloRoomOuterClass$YoloRoomAction);
                return;
            }
            YoloRoomOuterClass$YoloRoomSpeakingPosInfo r16 = r1();
            YoloRoomOuterClass$YoloRoomSpeakingPosListInitAction yoloRoomOuterClass$YoloRoomSpeakingPosListInitAction = yoloRoomOuterClass$YoloRoomAction.yolo_room_speaking_pos_list_init_action;
            k2(yoloRoomOuterClass$YoloRoomSpeakingPosListInitAction.room_speaking_pos_list.get(), yoloRoomOuterClass$YoloRoomSpeakingPosListInitAction.speaking_pos_list_version.get(), true);
            YoloRoomOuterClass$YoloRoomSpeakingPosInfo r17 = r1();
            if (r16 != null && r17 != null && r16.voice_switch.get() != r17.voice_switch.get()) {
                com.tencent.timi.game.utils.l.e("YoloRoomManager", "YOLO_ACTION_TYPE_SPEAKING_POS_LIST_INIT - self VoiceSwitch changed! old=" + r16.voice_switch.get() + ", new=" + r17.voice_switch.get());
                q2(r17.voice_switch.get(), r17, yoloRoomOuterClass$YoloRoomSpeakingPosListInitAction.speaking_pos_list_version.get());
            }
            for (YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo : yoloRoomOuterClass$YoloRoomSpeakingPosListInitAction.room_speaking_pos_list.get()) {
                if (yoloRoomOuterClass$YoloRoomSpeakingPosInfo.user_id.yes_uid.get() != 0 && !list.contains(yoloRoomOuterClass$YoloRoomSpeakingPosInfo.user_id)) {
                    list.add(yoloRoomOuterClass$YoloRoomSpeakingPosInfo.user_id);
                }
            }
            return;
        }
        YoloRoomOuterClass$YoloRoomSpeakingUserStatusUpdateAction yoloRoomOuterClass$YoloRoomSpeakingUserStatusUpdateAction = yoloRoomOuterClass$YoloRoomAction.yolo_room_speaking_user_status_update_action;
        if (M1(yoloRoomOuterClass$YoloRoomSpeakingUserStatusUpdateAction.speaking_pos_list_version.get(), "YOLO_ACTION_TYPE_SPEAKING_USER_STATUS_UPDATE")) {
            l2(yoloRoomOuterClass$YoloRoomSpeakingUserStatusUpdateAction.room_speaking_pos, yoloRoomOuterClass$YoloRoomSpeakingUserStatusUpdateAction.speaking_pos_list_version.get());
        }
    }

    private void z2() {
        com.tencent.timi.game.utils.l.i("YoloRoomManager", "resetAll, mRoomId= " + m1());
        this.f379034d = null;
        this.f379036e = null;
        this.f379038f.setValue(null);
        this.f379041h = 0L;
        B2(false);
        this.U = true;
        this.T = false;
        this.R = 15000;
        this.S = 0L;
        this.I = 0L;
        this.P = 0L;
        this.Q = 0L;
        this.G = -1;
        this.L = null;
        this.M = false;
        this.f379033c0.clear();
        hm4.a aVar = this.f379050n0;
        if (aVar != null) {
            aVar.p();
            this.f379050n0.m();
            this.f379050n0 = null;
        }
    }

    @Override // gm4.c
    public long A(CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
        if (L(commonOuterClass$QQUserId) == null) {
            return 0L;
        }
        long currentTimeMillis = (System.currentTimeMillis() / 1000) - r9.in_speaking_time.get();
        if (currentTimeMillis < 0) {
            return 0L;
        }
        return currentTimeMillis;
    }

    @Override // gm4.b
    public void B(CommonOuterClass$QQUserId commonOuterClass$QQUserId, int i3, IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> iResultListener) {
        YoloRoomOuterClass$YoloRoomForbiddenSpeechCmd yoloRoomOuterClass$YoloRoomForbiddenSpeechCmd = new YoloRoomOuterClass$YoloRoomForbiddenSpeechCmd();
        if (commonOuterClass$QQUserId != null) {
            yoloRoomOuterClass$YoloRoomForbiddenSpeechCmd.user_id.set(commonOuterClass$QQUserId);
        }
        yoloRoomOuterClass$YoloRoomForbiddenSpeechCmd.second.set(i3);
        yoloRoomOuterClass$YoloRoomForbiddenSpeechCmd.is_gm_forbidden.set(true);
        YoloRoomOuterClass$YoloRoomCmdReq yoloRoomOuterClass$YoloRoomCmdReq = new YoloRoomOuterClass$YoloRoomCmdReq();
        yoloRoomOuterClass$YoloRoomCmdReq.yolo_room_forbidden_speech_cmd.set(yoloRoomOuterClass$YoloRoomForbiddenSpeechCmd);
        e1(29, yoloRoomOuterClass$YoloRoomCmdReq, new ab(iResultListener));
    }

    @Override // gm4.c
    public YoloRoomOuterClass$YoloCommonGameOneSchema C() {
        return this.L;
    }

    public void C2(boolean z16) {
        com.tencent.timi.game.utils.l.i("YoloRoomManager", "setMicEnable - " + z16 + " - " + this.f379050n0);
        if (z16) {
            U0(new k(z16));
            return;
        }
        hm4.a aVar = this.f379050n0;
        if (aVar != null) {
            aVar.C(z16);
        }
    }

    @Override // gm4.c
    public boolean D() {
        YoloRoomOuterClass$YoloRoomSpeakingPosInfo r16 = r1();
        if (r16 != null && r16.user_from.get() == 2) {
            return true;
        }
        return false;
    }

    public void D2(YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo) {
        int i3;
        this.f379034d = yoloRoomOuterClass$YoloRoomInfo;
        this.f379038f.setValue(yoloRoomOuterClass$YoloRoomInfo);
        this.f379041h = this.f379034d.room_id.get();
        this.C = this.f379034d.room_type.get();
        YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo2 = this.f379034d;
        this.f379043i = yoloRoomOuterClass$YoloRoomInfo2.create_user_id;
        this.f379048m = yoloRoomOuterClass$YoloRoomInfo2.owner_user_id;
        YoloRoomOuterClass$YoloGameRouteInfo yoloRoomOuterClass$YoloGameRouteInfo = yoloRoomOuterClass$YoloRoomInfo2.game_route_info;
        this.K = yoloRoomOuterClass$YoloGameRouteInfo;
        if (yoloRoomOuterClass$YoloGameRouteInfo.has()) {
            i3 = this.f379034d.game_route_info.game_status.get();
        } else {
            i3 = 0;
        }
        this.J = i3;
        this.L = t2(q1());
        this.M = V0();
    }

    @Override // gm4.c
    public CommonOuterClass$QQUserId E() {
        YoloRoomOuterClass$YoloRoomSpeakingPosInfo L = L(q1());
        if (L != null) {
            return L.user_id;
        }
        return null;
    }

    public void E1(int i3, YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo, List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> list, int i16, long j3, YoloRoomOuterClass$YoloRoomConf yoloRoomOuterClass$YoloRoomConf, YoloRoomOuterClass$YoloRoomUserData yoloRoomOuterClass$YoloRoomUserData) {
        boolean z16;
        YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo2;
        com.tencent.timi.game.utils.l.i("YoloRoomManager", "onJoinNewRoom - JoinRoomType." + i3 + ", roomId = " + yoloRoomOuterClass$YoloRoomInfo.room_id.get() + ", roomType = " + yoloRoomOuterClass$YoloRoomInfo.room_type.get() + ", latestActionId = " + j3 + ", maxClientActionId = " + this.P + ", speakingPosListVersion = " + i16);
        if (i3 == 2 && (yoloRoomOuterClass$YoloRoomInfo2 = this.f379034d) != null && yoloRoomOuterClass$YoloRoomInfo2.room_id.get() == yoloRoomOuterClass$YoloRoomInfo.room_id.get()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            z2();
            this.I = System.currentTimeMillis();
        }
        com.tencent.timi.game.room.impl.util.g.f379335a.b(yoloRoomOuterClass$YoloRoomInfo);
        D2(yoloRoomOuterClass$YoloRoomInfo);
        I2(yoloRoomOuterClass$YoloRoomUserData);
        this.H = yoloRoomOuterClass$YoloRoomConf;
        v1();
        G2();
        if (j3 > this.P) {
            this.P = j3;
        }
        k2(list, i16, true);
        W0();
        if (!z16 && this.J == 1) {
            x1();
        }
        B2(true);
        P1(z16);
        V1(z16);
        ((kn4.b) mm4.b.b(kn4.b.class)).V1().a(this.f379061y0);
        A2();
        if (i3 != 2) {
            x2();
        }
    }

    @Override // gm4.b
    public void F(CommonOuterClass$QQUserId commonOuterClass$QQUserId, IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> iResultListener) {
        com.tencent.timi.game.utils.l.i("YoloRoomManager", "agreeSpeaking - " + commonOuterClass$QQUserId);
        YoloRoomOuterClass$YoloRoomAgreeSpeakingCmd yoloRoomOuterClass$YoloRoomAgreeSpeakingCmd = new YoloRoomOuterClass$YoloRoomAgreeSpeakingCmd();
        if (commonOuterClass$QQUserId != null) {
            yoloRoomOuterClass$YoloRoomAgreeSpeakingCmd.user_id.set(commonOuterClass$QQUserId);
        }
        YoloRoomOuterClass$YoloRoomCmdReq yoloRoomOuterClass$YoloRoomCmdReq = new YoloRoomOuterClass$YoloRoomCmdReq();
        yoloRoomOuterClass$YoloRoomCmdReq.yolo_room_agree_speaking_cmd.set(yoloRoomOuterClass$YoloRoomAgreeSpeakingCmd);
        e1(26, yoloRoomOuterClass$YoloRoomCmdReq, new aa(iResultListener));
    }

    public void F2() {
        Object obj;
        int i3 = getRoomInfo().game_route_info.expire_time.get();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("showDoubleCheckDialog - ");
        RoomGameDoubleCheckDialog roomGameDoubleCheckDialog = this.f379051o0;
        if (roomGameDoubleCheckDialog != null) {
            obj = Boolean.valueOf(roomGameDoubleCheckDialog.isShowing());
        } else {
            obj = "null";
        }
        sb5.append(obj);
        sb5.append(", expireTimeSeconds = ");
        sb5.append(i3);
        sb5.append(" ");
        long j3 = i3;
        sb5.append(yn4.d.a(100 * j3, "HH:mm:ss:SSS"));
        com.tencent.timi.game.utils.l.i("YoloRoomManager", sb5.toString());
        RoomGameDoubleCheckDialog roomGameDoubleCheckDialog2 = this.f379051o0;
        if (roomGameDoubleCheckDialog2 != null && roomGameDoubleCheckDialog2.isShowing()) {
            this.f379051o0.dismiss();
        }
        this.f379051o0 = null;
        QBaseActivity b16 = vf4.a.b();
        if (b16 != null && !b16.isFinishing()) {
            com.tencent.timi.game.utils.l.i("YoloRoomManager", "showDoubleCheckDialog  topActivity = " + b16);
            RoomGameDoubleCheckDialog a16 = new RoomGameDoubleCheckDialog.c(b16).a(m1(), i1(), (j3 * 1000) + 800);
            this.f379051o0 = a16;
            a16.setOnDismissListener(new ah());
            this.f379051o0.show();
            return;
        }
        com.tencent.timi.game.utils.l.e("YoloRoomManager", "showDoubleCheckDialog but topActivity is invalid " + b16);
    }

    @Override // gm4.c
    public fm4.c G() {
        YoloRoomOuterClass$YoloRoomSpeakingPosInfo r16;
        if (D() && (r16 = r1()) != null) {
            return new fm4.c(r16.guild_id.get(), r16.channel_id.get(), r16.channel_name.get());
        }
        return null;
    }

    public boolean G1() {
        if (getRoomInfo() != null && getRoomInfo().room_data_info.sub_create_from.get() == 3) {
            return false;
        }
        if (getRoomType() == 5) {
            return T0();
        }
        if (getRoomType() == 1) {
            WujiYoloRoomOuterClass$WujiYoloSmobaRoomConf wujiYoloRoomOuterClass$WujiYoloSmobaRoomConf = Y().yolo_room_smoba_conf.yolo_smoba_room_conf;
            if (wujiYoloRoomOuterClass$WujiYoloSmobaRoomConf == null || !wujiYoloRoomOuterClass$WujiYoloSmobaRoomConf.is_use_voice.get()) {
                return false;
            }
            return true;
        }
        if (!YoloRoomUtil.c0(getRoomType())) {
            return true;
        }
        if (Y().yolo_room_game_conf == null || !Y().yolo_room_game_conf.is_use_voice.get()) {
            return false;
        }
        return true;
    }

    @Override // gm4.d
    public void H(fm4.u uVar) {
        if (uVar != null) {
            com.tencent.timi.game.utils.l.i("YoloRoomManager", "waitMediaEnvCallback, mIsCheckingTrtc = " + this.f379054r0 + " - " + j1());
            if (j1() != null) {
                uVar.j(true);
            } else if (!this.f379054r0) {
                uVar.j(false);
            } else if (!this.f379045j0.contains(uVar)) {
                this.f379045j0.add(uVar);
            }
        }
    }

    public boolean H1() {
        if (this.f379041h > 0) {
            return true;
        }
        return false;
    }

    @Override // gm4.c
    public int I() {
        return this.D;
    }

    public boolean I1() {
        return this.f379031a0;
    }

    @Override // gm4.b
    public void J(int i3, IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> iResultListener) {
        com.tencent.timi.game.utils.l.i("YoloRoomManager", "chooseHeroLane has inject");
        YoloRoomOuterClass$YoloSmobaRoomChooceHeroCmd yoloRoomOuterClass$YoloSmobaRoomChooceHeroCmd = new YoloRoomOuterClass$YoloSmobaRoomChooceHeroCmd();
        YoloRoomOuterClass$YoloRoomCmdReq yoloRoomOuterClass$YoloRoomCmdReq = new YoloRoomOuterClass$YoloRoomCmdReq();
        yoloRoomOuterClass$YoloRoomCmdReq.yolo_smoba_room_chooce_hero.set(yoloRoomOuterClass$YoloSmobaRoomChooceHeroCmd);
        yoloRoomOuterClass$YoloRoomCmdReq.yolo_smoba_room_chooce_hero.hero_lane_type.set(i3);
        e1(201, yoloRoomOuterClass$YoloRoomCmdReq, new ae(i3, iResultListener));
    }

    @Override // gm4.b
    public void K(IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> iResultListener) {
        int i3;
        com.tencent.timi.game.utils.l.i("YoloRoomManager", "remindStartGame");
        YoloRoomOuterClass$YoloRoomCmdReq yoloRoomOuterClass$YoloRoomCmdReq = new YoloRoomOuterClass$YoloRoomCmdReq();
        yoloRoomOuterClass$YoloRoomCmdReq.yolo_game_room_remind_start_game_cmd.set(new YoloRoomOuterClass$YoloGameRoomRemindStartGameCmd());
        if (L1()) {
            yoloRoomOuterClass$YoloRoomCmdReq.yolo_smoba_room_remind_start_game_cmd.set(new YoloRoomOuterClass$YoloSmobaRoomRemindStartGameCmd());
            i3 = 203;
        } else {
            i3 = 150;
        }
        e1(i3, yoloRoomOuterClass$YoloRoomCmdReq, new ad(iResultListener));
    }

    public boolean K1() {
        return q(q1());
    }

    @Override // gm4.c
    public YoloRoomOuterClass$YoloRoomSpeakingPosInfo L(CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
        if (commonOuterClass$QQUserId != null) {
            for (YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo : this.F) {
                if (ll4.b.a(yoloRoomOuterClass$YoloRoomSpeakingPosInfo.user_id, commonOuterClass$QQUserId)) {
                    return yoloRoomOuterClass$YoloRoomSpeakingPosInfo;
                }
            }
            return null;
        }
        return null;
    }

    public boolean L1() {
        if (getRoomType() == 1) {
            return true;
        }
        return false;
    }

    @Override // gm4.c
    public int M() {
        return this.J;
    }

    public boolean M1(int i3, String str) {
        if (i3 <= this.G) {
            com.tencent.timi.game.utils.l.e("YoloRoomManager", "SpeakingPosListVersion is old from action - " + str + ", curVersion is " + this.G + ", actionVersion is " + i3);
            return false;
        }
        return true;
    }

    @Override // gm4.c
    public void N(ConcurrentHashMap<String, String> concurrentHashMap) {
        this.f379033c0 = concurrentHashMap;
    }

    public void N1(boolean z16, int i3, IResultListener<YoloRoomOuterClass$YoloRoomLeaveRsp> iResultListener, boolean z17) {
        if (this.f379041h == 0) {
            if (iResultListener != null) {
                iResultListener.onError(-10001, "mRoomId is 0");
                return;
            }
            return;
        }
        fm4.n n16 = n1();
        com.tencent.timi.game.utils.l.e("YoloRoomManager", "leaveRoom - " + this.f379041h + " - " + z16 + " - " + n16);
        if (n16 != null && !z16) {
            n16.a(new h(z16, i3, iResultListener, z17));
        } else {
            O1(z16, i3, iResultListener, z17);
        }
    }

    @Override // gm4.b
    public void O(CommonOuterClass$QQUserId commonOuterClass$QQUserId, int i3, IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> iResultListener) {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("changeVoiceSwitch - ");
        sb5.append(i3);
        sb5.append(" - ");
        if (commonOuterClass$QQUserId != null) {
            str = LogUtil.getSafePrintUin(String.valueOf(commonOuterClass$QQUserId.uid.get())) + " - " + LogUtil.getSafePrintUin(String.valueOf(commonOuterClass$QQUserId.yes_uid.get()));
        } else {
            str = "self_null";
        }
        sb5.append(str);
        com.tencent.timi.game.utils.l.i("YoloRoomManager", sb5.toString());
        if (i3 == 2) {
            g1(commonOuterClass$QQUserId, i3, iResultListener);
        } else if (YoloVoiceChangeAlertUtil.c(this.f379050n0.q())) {
            YoloVoiceChangeAlertUtil.d(getRoomType(), new p(commonOuterClass$QQUserId, i3, iResultListener));
        } else {
            g1(commonOuterClass$QQUserId, i3, iResultListener);
        }
    }

    @Override // gm4.c
    public gh4.d P() {
        return this.F0;
    }

    public void P1(boolean z16) {
        long j3;
        w2();
        if (this.W) {
            int i3 = this.R;
            Runnable runnable = this.f379062z0;
            if (z16) {
                j3 = 0;
            } else {
                j3 = i3;
            }
            com.tencent.timi.game.utils.w.d(runnable, j3);
        }
    }

    @Override // gm4.d
    public void Q(fm4.q qVar) {
        com.tencent.timi.game.utils.l.b("YoloRoomManager", "unRegisterCommonListener roomListener =  " + qVar);
        if (qVar != null && this.f379039f0.contains(qVar)) {
            this.f379039f0.remove(qVar);
            com.tencent.timi.game.utils.l.b("YoloRoomManager", "registerCommonListener real remove");
        }
    }

    @Override // gm4.c
    public CommonOuterClass$QQUserId R() {
        return this.f379048m;
    }

    public void R1(long j3, List<YoloRoomOuterClass$YoloRoomForbiddenSpeechConf> list) {
        Iterator<fm4.s> it = this.f379046k0.iterator();
        while (it.hasNext()) {
            fm4.s next = it.next();
            next.a(list);
            next.b(j3);
        }
    }

    @Override // gm4.c
    public boolean S() {
        return this.M;
    }

    @Override // gm4.b
    public void T(boolean z16, IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> iResultListener) {
        int i3;
        com.tencent.timi.game.utils.l.i("YoloRoomManager", "doReady - " + z16);
        YoloRoomOuterClass$YoloRoomReadyStatusChangeCmd yoloRoomOuterClass$YoloRoomReadyStatusChangeCmd = new YoloRoomOuterClass$YoloRoomReadyStatusChangeCmd();
        PBInt32Field pBInt32Field = yoloRoomOuterClass$YoloRoomReadyStatusChangeCmd.f437260op;
        if (z16) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        pBInt32Field.set(i3);
        YoloRoomOuterClass$YoloRoomCmdReq yoloRoomOuterClass$YoloRoomCmdReq = new YoloRoomOuterClass$YoloRoomCmdReq();
        yoloRoomOuterClass$YoloRoomCmdReq.yolo_room_ready_status_change_cmd.set(yoloRoomOuterClass$YoloRoomReadyStatusChangeCmd);
        e1(12, yoloRoomOuterClass$YoloRoomCmdReq, new n(iResultListener));
    }

    @Override // gm4.c
    public YoloRoomOuterClass$YoloGameRouteInfo U() {
        return this.K;
    }

    @Override // gm4.d
    public void V(fm4.p pVar) {
        if (pVar != null && this.f379040g0.contains(pVar)) {
            this.f379040g0.remove(pVar);
        }
    }

    @Override // gm4.b
    public void W(CommonOuterClass$QQUserId commonOuterClass$QQUserId, IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> iResultListener) {
        com.tencent.timi.game.utils.l.i("YoloRoomManager", "kickOutRoom");
        YoloRoomOuterClass$YoloRoomKickOutRoomCmd yoloRoomOuterClass$YoloRoomKickOutRoomCmd = new YoloRoomOuterClass$YoloRoomKickOutRoomCmd();
        if (commonOuterClass$QQUserId != null) {
            yoloRoomOuterClass$YoloRoomKickOutRoomCmd.user_id.set(commonOuterClass$QQUserId);
        }
        yoloRoomOuterClass$YoloRoomKickOutRoomCmd.is_close_pos.set(0);
        YoloRoomOuterClass$YoloRoomCmdReq yoloRoomOuterClass$YoloRoomCmdReq = new YoloRoomOuterClass$YoloRoomCmdReq();
        yoloRoomOuterClass$YoloRoomCmdReq.yolo_room_kick_out_room_cmd.set(yoloRoomOuterClass$YoloRoomKickOutRoomCmd);
        e1(19, yoloRoomOuterClass$YoloRoomCmdReq, new s(iResultListener));
    }

    @Override // gm4.b
    public void X(boolean z16, YoloRoomOuterClass$YoloUserGameData yoloRoomOuterClass$YoloUserGameData, IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> iResultListener) {
        boolean K1 = K1();
        com.tencent.timi.game.utils.l.i("YoloRoomManager", "updateSpeakingUserStatus - isLeave = " + (z16 ? 1 : 0) + ", isSelfInSpeaking = " + K1);
        if (!K1) {
            if (iResultListener != null) {
                iResultListener.onError(-10000, "\u4f60\u4e0d\u5728\u9ea6\u4e0a");
                return;
            }
            return;
        }
        YoloRoomOuterClass$YoloRoomSpeakingUserUpdateCmd yoloRoomOuterClass$YoloRoomSpeakingUserUpdateCmd = new YoloRoomOuterClass$YoloRoomSpeakingUserUpdateCmd();
        if (z16 || !z16) {
            yoloRoomOuterClass$YoloRoomSpeakingUserUpdateCmd.leave_status.set(z16 ? 1 : 0);
        }
        if (yoloRoomOuterClass$YoloUserGameData != null) {
            yoloRoomOuterClass$YoloRoomSpeakingUserUpdateCmd.user_game_data.set(yoloRoomOuterClass$YoloUserGameData);
        }
        YoloRoomOuterClass$YoloRoomCmdReq yoloRoomOuterClass$YoloRoomCmdReq = new YoloRoomOuterClass$YoloRoomCmdReq();
        yoloRoomOuterClass$YoloRoomCmdReq.yolo_room_speaking_user_update_cmd.set(yoloRoomOuterClass$YoloRoomSpeakingUserUpdateCmd);
        e1(27, yoloRoomOuterClass$YoloRoomCmdReq, new ag(iResultListener));
    }

    public void X0() {
        z2();
        w2();
        this.f379049m0.clear();
        v2();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    public void X1(boolean z16, fm4.f fVar) {
        boolean z17;
        com.tencent.timi.game.utils.l.i("YoloRoomManager", "notifyRoomPageShowStatus - " + z16 + " - " + fVar.getPageName());
        if (z16) {
            this.f379032b0.put(fVar.getPageName(), new WeakReference<>(fVar));
        } else {
            this.f379032b0.remove(fVar.getPageName());
        }
        YoloRoomFloatViewUtil.f(m1(), fVar.O());
        if (this.f379032b0.size() > 0) {
            Iterator<Map.Entry<String, WeakReference<fm4.f>>> it = this.f379032b0.entrySet().iterator();
            while (it.hasNext()) {
                if (it.next().getValue().get() != null) {
                    z17 = true;
                    break;
                }
                com.tencent.timi.game.utils.l.e("YoloRoomManager", "notifyRoomPageShowStatus check, value.get is null");
            }
        }
        z17 = false;
        this.f379031a0 = z17;
        boolean z18 = !z17;
        com.tencent.timi.game.utils.l.i("YoloRoomManager", "notifyRoomPageShowStatus show/hide floating - " + z18);
        if (z18) {
            YoloRoomFloatViewUtil.g(m1(), getRoomType(), getRoomInfo());
        } else {
            YoloRoomFloatViewUtil.e(m1(), getRoomType());
        }
    }

    @Override // gm4.c
    public YoloRoomOuterClass$YoloRoomConf Y() {
        return this.H;
    }

    @Override // gm4.b
    public void Z(CommonOuterClass$QQUserId commonOuterClass$QQUserId, IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> iResultListener) {
        com.tencent.timi.game.utils.l.i("YoloRoomManager", "inviteSpeaking - " + commonOuterClass$QQUserId);
        YoloRoomOuterClass$YoloRoomInvitedSpeakingCmd yoloRoomOuterClass$YoloRoomInvitedSpeakingCmd = new YoloRoomOuterClass$YoloRoomInvitedSpeakingCmd();
        if (commonOuterClass$QQUserId != null) {
            yoloRoomOuterClass$YoloRoomInvitedSpeakingCmd.user_id.set(commonOuterClass$QQUserId);
        }
        YoloRoomOuterClass$YoloRoomCmdReq yoloRoomOuterClass$YoloRoomCmdReq = new YoloRoomOuterClass$YoloRoomCmdReq();
        yoloRoomOuterClass$YoloRoomCmdReq.yolo_room_invited_speaking_cmd.set(yoloRoomOuterClass$YoloRoomInvitedSpeakingCmd);
        e1(24, yoloRoomOuterClass$YoloRoomCmdReq, new y(iResultListener));
    }

    public void Z1() {
        com.tencent.timi.game.utils.l.i("YoloRoomManager", "notifySmobaLeaveTeamFromTGPA");
        this.B0.g();
    }

    @Override // gm4.b
    public void a(YoloRoomOuterClass$YoloRoomModifyInfoCmd yoloRoomOuterClass$YoloRoomModifyInfoCmd, IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> iResultListener) {
        com.tencent.timi.game.utils.l.i("YoloRoomManager", "modifyRoomInfo, gameStatus = " + M());
        YoloRoomOuterClass$YoloRoomCmdReq yoloRoomOuterClass$YoloRoomCmdReq = new YoloRoomOuterClass$YoloRoomCmdReq();
        yoloRoomOuterClass$YoloRoomCmdReq.yolo_room_modify_info_cmd.set(yoloRoomOuterClass$YoloRoomModifyInfoCmd);
        e1(14, yoloRoomOuterClass$YoloRoomCmdReq, new t(iResultListener));
    }

    @Override // gm4.d
    public void b(fm4.s sVar) {
        if (sVar != null && !this.f379046k0.contains(sVar)) {
            this.f379046k0.add(sVar);
        }
    }

    @Override // gm4.b
    public void c(CommonOuterClass$QQUserId commonOuterClass$QQUserId, IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> iResultListener) {
        com.tencent.timi.game.utils.l.i("YoloRoomManager", "rejectSpeaking - " + commonOuterClass$QQUserId);
        YoloRoomOuterClass$YoloRoomRejectSpeakingCmd yoloRoomOuterClass$YoloRoomRejectSpeakingCmd = new YoloRoomOuterClass$YoloRoomRejectSpeakingCmd();
        if (commonOuterClass$QQUserId != null) {
            yoloRoomOuterClass$YoloRoomRejectSpeakingCmd.user_id.set(commonOuterClass$QQUserId);
        }
        YoloRoomOuterClass$YoloRoomCmdReq yoloRoomOuterClass$YoloRoomCmdReq = new YoloRoomOuterClass$YoloRoomCmdReq();
        yoloRoomOuterClass$YoloRoomCmdReq.yolo_room_reject_speaking_cmd.set(yoloRoomOuterClass$YoloRoomRejectSpeakingCmd);
        e1(34, yoloRoomOuterClass$YoloRoomCmdReq, new af(iResultListener));
    }

    @Override // gm4.d
    public void d(fm4.s sVar) {
        if (sVar == null) {
            return;
        }
        this.f379046k0.remove(sVar);
    }

    @Override // gm4.c
    public ConcurrentHashMap<String, String> e() {
        return YoloRoomUtil.L(getRoomInfo());
    }

    public long e1(int i3, YoloRoomOuterClass$YoloRoomCmdReq yoloRoomOuterClass$YoloRoomCmdReq, fm4.b bVar) {
        long h16 = h1();
        com.tencent.timi.game.utils.l.i("YoloRoomManager", "doYoloRoomCmd - " + i3 + ", mRoomId = " + this.f379041h);
        if (this.f379041h == 0) {
            com.tencent.timi.game.utils.l.e("YoloRoomManager", "doYoloRoomCmd - " + i3 + ", mRoomId invalid!!!");
            if (bVar != null) {
                bVar.b(10000, "\u6570\u636e\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", h16, true);
            }
            return h16;
        }
        ((pl4.c) mm4.b.b(pl4.c.class)).F1(jm4.c.d(this.f379041h, i3, h16, yoloRoomOuterClass$YoloRoomCmdReq), YoloRoomOuterClass$DoYoloRoomCmdRsp.class, new al(h16, i3, bVar));
        return h16;
    }

    @Override // gm4.c
    public long f() {
        PBUInt64Field pBUInt64Field;
        YoloRoomOuterClass$YoloRoomSpeakingPosInfo r16 = r1();
        if (r16 != null && (pBUInt64Field = r16.from_room_id) != null) {
            return pBUInt64Field.get();
        }
        return 0L;
    }

    public void f1(IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> iResultListener) {
        com.tencent.timi.game.utils.l.i("YoloRoomManager", "doubleCheck");
        YoloRoomOuterClass$YoloRoomDoubleCheckCmd yoloRoomOuterClass$YoloRoomDoubleCheckCmd = new YoloRoomOuterClass$YoloRoomDoubleCheckCmd();
        YoloRoomOuterClass$YoloRoomCmdReq yoloRoomOuterClass$YoloRoomCmdReq = new YoloRoomOuterClass$YoloRoomCmdReq();
        yoloRoomOuterClass$YoloRoomCmdReq.yolo_room_double_check_cmd.set(yoloRoomOuterClass$YoloRoomDoubleCheckCmd);
        e1(22, yoloRoomOuterClass$YoloRoomCmdReq, new x(iResultListener));
    }

    @Override // gm4.b
    public void g(boolean z16, int i3, IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> iResultListener) {
        com.tencent.timi.game.utils.l.i("YoloRoomManager", "openCloseSpeakingPos");
        YoloRoomOuterClass$YoloRoomSpeakingPosStatusChangeCmd yoloRoomOuterClass$YoloRoomSpeakingPosStatusChangeCmd = new YoloRoomOuterClass$YoloRoomSpeakingPosStatusChangeCmd();
        yoloRoomOuterClass$YoloRoomSpeakingPosStatusChangeCmd.f437264op.set(!z16 ? 1 : 0);
        yoloRoomOuterClass$YoloRoomSpeakingPosStatusChangeCmd.pos.set(i3);
        YoloRoomOuterClass$YoloRoomCmdReq yoloRoomOuterClass$YoloRoomCmdReq = new YoloRoomOuterClass$YoloRoomCmdReq();
        yoloRoomOuterClass$YoloRoomCmdReq.yolo_room_speaking_pos_status_change_cmd.set(yoloRoomOuterClass$YoloRoomSpeakingPosStatusChangeCmd);
        e1(15, yoloRoomOuterClass$YoloRoomCmdReq, new o(iResultListener, z16));
    }

    public void g2() {
        com.tencent.timi.game.utils.l.e("YoloRoomManager", "onLogout - " + m1() + " - " + p1());
        d2();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(AppBecomeForegroundEvent.class);
        arrayList.add(AppBecomeBackgroundEvent.class);
        return arrayList;
    }

    @Override // gm4.c
    public YoloRoomOuterClass$YoloRoomInfo getRoomInfo() {
        return this.f379034d;
    }

    @Override // gm4.c
    public int getRoomType() {
        return this.C;
    }

    @Override // gm4.b
    public void h(IResultListener<YoloRoomOuterClass$YoloRoomStartGameCmdRsp> iResultListener) {
        com.tencent.timi.game.utils.l.i("YoloRoomManager", "startGame");
        YoloRoomOuterClass$YoloRoomStartGameCmd yoloRoomOuterClass$YoloRoomStartGameCmd = new YoloRoomOuterClass$YoloRoomStartGameCmd();
        YoloRoomOuterClass$YoloRoomCmdReq yoloRoomOuterClass$YoloRoomCmdReq = new YoloRoomOuterClass$YoloRoomCmdReq();
        yoloRoomOuterClass$YoloRoomCmdReq.yolo_room_start_game_cmd.set(yoloRoomOuterClass$YoloRoomStartGameCmd);
        e1(20, yoloRoomOuterClass$YoloRoomCmdReq, new v(iResultListener));
    }

    @Override // gm4.b
    public void i(IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> iResultListener) {
        com.tencent.timi.game.utils.l.i("YoloRoomManager", "outSpeaking");
        YoloRoomOuterClass$YoloRoomSpeakingPosChangeCmd yoloRoomOuterClass$YoloRoomSpeakingPosChangeCmd = new YoloRoomOuterClass$YoloRoomSpeakingPosChangeCmd();
        yoloRoomOuterClass$YoloRoomSpeakingPosChangeCmd.f437262op.set(2);
        YoloRoomOuterClass$YoloRoomCmdReq yoloRoomOuterClass$YoloRoomCmdReq = new YoloRoomOuterClass$YoloRoomCmdReq();
        yoloRoomOuterClass$YoloRoomCmdReq.yolo_room_speaking_pos_change_cmd.set(yoloRoomOuterClass$YoloRoomSpeakingPosChangeCmd);
        e1(11, yoloRoomOuterClass$YoloRoomCmdReq, new m(iResultListener));
    }

    public List<YoloRoomOuterClass$YoloRoomDoubleCheckPlayer> i1() {
        YoloRoomOuterClass$YoloGameRouteInfo yoloRoomOuterClass$YoloGameRouteInfo = getRoomInfo().game_route_info;
        if (yoloRoomOuterClass$YoloGameRouteInfo != null && yoloRoomOuterClass$YoloGameRouteInfo.game_status.get() == 1) {
            return yoloRoomOuterClass$YoloGameRouteInfo.double_check_players.get();
        }
        return null;
    }

    public void i2(long j3, String str) {
        boolean z16;
        if (j3 > 0 && j3 > this.S) {
            z16 = true;
        } else {
            z16 = false;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onNewActionDataFromOnlinePush - ");
        sb5.append(str);
        sb5.append(", ");
        sb5.append(j3);
        sb5.append(", lastNewDataPushTimeStamp = ");
        sb5.append(this.S);
        sb5.append(", AlreadyHandled = ");
        sb5.append(!z16);
        com.tencent.timi.game.utils.l.i("YoloRoomManager", sb5.toString());
        if (z16) {
            this.S = j3;
            P1(true);
        }
    }

    @Override // gm4.d
    public void j(fm4.t tVar) {
        if (tVar != null && !this.f379042h0.contains(tVar)) {
            this.f379042h0.add(tVar);
        }
    }

    public hm4.a j1() {
        return this.f379050n0;
    }

    @Override // gm4.b
    public void k(IResultListener<YoloRoomOuterClass$YoloRoomJoinGameCmdRsp> iResultListener) {
        com.tencent.timi.game.utils.l.i("YoloRoomManager", "joinGame");
        YoloRoomOuterClass$YoloRoomJoinGameCmd yoloRoomOuterClass$YoloRoomJoinGameCmd = new YoloRoomOuterClass$YoloRoomJoinGameCmd();
        YoloRoomOuterClass$YoloRoomCmdReq yoloRoomOuterClass$YoloRoomCmdReq = new YoloRoomOuterClass$YoloRoomCmdReq();
        yoloRoomOuterClass$YoloRoomCmdReq.yolo_room_join_game_cmd.set(yoloRoomOuterClass$YoloRoomJoinGameCmd);
        e1(21, yoloRoomOuterClass$YoloRoomCmdReq, new w(iResultListener));
    }

    public boolean k1() {
        hm4.a aVar = this.f379050n0;
        if (aVar != null && aVar.t()) {
            return true;
        }
        return false;
    }

    @Override // gm4.d
    public void l(fm4.p pVar) {
        if (pVar != null && !this.f379040g0.contains(pVar)) {
            this.f379040g0.add(pVar);
        }
    }

    public gm4.a l1() {
        return this.E0;
    }

    @Override // gm4.c
    public YoloRoomOuterClass$YoloRoomUserData m() {
        return this.f379036e;
    }

    public long m1() {
        return this.f379041h;
    }

    @Override // gm4.c
    public List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> n() {
        return this.F;
    }

    public fm4.n n1() {
        return this.f379047l0.get(Integer.valueOf(getRoomType()));
    }

    @Override // gm4.c
    public void o(gh4.d dVar) {
        this.F0 = dVar;
    }

    @Override // gm4.c
    public int o1() {
        YoloRoomOuterClass$YoloRoomDataInfo yoloRoomOuterClass$YoloRoomDataInfo;
        YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo = this.f379034d;
        if (yoloRoomOuterClass$YoloRoomInfo != null) {
            yoloRoomOuterClass$YoloRoomDataInfo = yoloRoomOuterClass$YoloRoomInfo.room_data_info;
        } else {
            yoloRoomOuterClass$YoloRoomDataInfo = null;
        }
        if (yoloRoomOuterClass$YoloRoomDataInfo != null) {
            return yoloRoomOuterClass$YoloRoomDataInfo.game_id.get();
        }
        return 0;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof AppBecomeForegroundEvent) {
            com.tencent.timi.game.utils.l.i("YoloRoomManager", "AppBecomeForegroundEvent called");
            this.D0 = false;
            X(false, null, null);
        } else if (simpleBaseEvent instanceof AppBecomeBackgroundEvent) {
            com.tencent.timi.game.utils.l.i("YoloRoomManager", "AppBecomeBackgroundEvent called");
            this.D0 = true;
            X(true, null, null);
        }
    }

    @Override // gm4.b
    public void p(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.contains("LogIgnore")) {
                if (eh4.a.e()) {
                    com.tencent.timi.game.utils.l.i("YoloRoomManager", "clientUpdateHeartBeat - " + str);
                }
            } else {
                com.tencent.timi.game.utils.l.i("YoloRoomManager", "clientUpdateHeartBeat - " + str);
            }
        }
        this.Z = true;
    }

    public String p1() {
        return com.tencent.timi.game.room.impl.util.f.a(getRoomType());
    }

    @Override // gm4.c
    public boolean q(CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
        if (L(commonOuterClass$QQUserId) != null) {
            return true;
        }
        return false;
    }

    @NotNull
    public CommonOuterClass$QQUserId q1() {
        CommonOuterClass$QQUserId E = ((ll4.a) mm4.b.b(ll4.a.class)).E();
        if (E == null) {
            return new CommonOuterClass$QQUserId();
        }
        return E;
    }

    @Override // gm4.b
    public void r(CommonOuterClass$QQUserId commonOuterClass$QQUserId, boolean z16, IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> iResultListener) {
        com.tencent.timi.game.utils.l.i("YoloRoomManager", "kickOutSpeaking");
        YoloRoomOuterClass$YoloRoomKickOutSpeakingCmd yoloRoomOuterClass$YoloRoomKickOutSpeakingCmd = new YoloRoomOuterClass$YoloRoomKickOutSpeakingCmd();
        if (commonOuterClass$QQUserId != null) {
            yoloRoomOuterClass$YoloRoomKickOutSpeakingCmd.user_id.set(commonOuterClass$QQUserId);
        }
        yoloRoomOuterClass$YoloRoomKickOutSpeakingCmd.is_close_pos.set(z16 ? 1 : 0);
        YoloRoomOuterClass$YoloRoomCmdReq yoloRoomOuterClass$YoloRoomCmdReq = new YoloRoomOuterClass$YoloRoomCmdReq();
        yoloRoomOuterClass$YoloRoomCmdReq.yolo_room_kick_out_speaking_cmd.set(yoloRoomOuterClass$YoloRoomKickOutSpeakingCmd);
        e1(18, yoloRoomOuterClass$YoloRoomCmdReq, new r(iResultListener));
    }

    public YoloRoomOuterClass$YoloRoomSpeakingPosInfo r1() {
        return L(q1());
    }

    @Override // gm4.c
    public YoloRoomOuterClass$YoloCommonGameOneSchema s() {
        return t2(R());
    }

    public YoloRoomOuterClass$YoloSmobaGameDataInfo s1() {
        YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo;
        if (1 == this.C && (yoloRoomOuterClass$YoloRoomInfo = this.f379034d) != null && yoloRoomOuterClass$YoloRoomInfo.game_data_info.has() && this.f379034d.game_data_info.smoba_game_data_info.has()) {
            return this.f379034d.game_data_info.smoba_game_data_info;
        }
        return null;
    }

    @Override // gm4.d
    public void t(fm4.t tVar) {
        if (tVar != null && this.f379042h0.contains(tVar)) {
            this.f379042h0.remove(tVar);
        }
    }

    public YoloRoomOuterClass$YoloCommonGameOneSchema t2(CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
        YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo = this.f379034d;
        if (yoloRoomOuterClass$YoloRoomInfo != null && yoloRoomOuterClass$YoloRoomInfo.game_route_info.has()) {
            return u2(this.f379034d.game_route_info.common_game_route_info, commonOuterClass$QQUserId);
        }
        return null;
    }

    @Override // gm4.b
    public void u(fm4.a aVar) {
        com.tencent.timi.game.utils.l.i("YoloRoomManager", "applySpeaking");
        YoloRoomOuterClass$YoloRoomApplySpeakingCmd yoloRoomOuterClass$YoloRoomApplySpeakingCmd = new YoloRoomOuterClass$YoloRoomApplySpeakingCmd();
        YoloRoomOuterClass$YoloRoomCmdReq yoloRoomOuterClass$YoloRoomCmdReq = new YoloRoomOuterClass$YoloRoomCmdReq();
        yoloRoomOuterClass$YoloRoomCmdReq.yolo_room_apply_speaking_cmd.set(yoloRoomOuterClass$YoloRoomApplySpeakingCmd);
        e1(25, yoloRoomOuterClass$YoloRoomCmdReq, new z(aVar));
    }

    @Override // gm4.c
    public YoloRoomOuterClass$YoloRoomDoubleCheckPlayer v(CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
        List<YoloRoomOuterClass$YoloRoomDoubleCheckPlayer> i16 = i1();
        if (i16 != null && i16.size() > 0) {
            for (YoloRoomOuterClass$YoloRoomDoubleCheckPlayer yoloRoomOuterClass$YoloRoomDoubleCheckPlayer : i16) {
                if (ll4.b.a(yoloRoomOuterClass$YoloRoomDoubleCheckPlayer.user_id, commonOuterClass$QQUserId)) {
                    return yoloRoomOuterClass$YoloRoomDoubleCheckPlayer;
                }
            }
            return null;
        }
        return null;
    }

    public void v2() {
        com.tencent.timi.game.room.impl.c cVar = this.f379053q0;
        if (cVar != null) {
            cVar.b();
            this.f379053q0 = null;
        }
    }

    @Override // gm4.c
    public YoloRoomOuterClass$YoloCommonGameDataInfo w() {
        YoloRoomOuterClass$YoloGameDataInfo yoloRoomOuterClass$YoloGameDataInfo;
        YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo = this.f379034d;
        if (yoloRoomOuterClass$YoloRoomInfo != null && (yoloRoomOuterClass$YoloGameDataInfo = yoloRoomOuterClass$YoloRoomInfo.game_data_info) != null && yoloRoomOuterClass$YoloGameDataInfo.has()) {
            YoloRoomOuterClass$YoloSmobaGameDataInfo yoloRoomOuterClass$YoloSmobaGameDataInfo = this.f379034d.game_data_info.smoba_game_data_info;
            if (yoloRoomOuterClass$YoloSmobaGameDataInfo != null && yoloRoomOuterClass$YoloSmobaGameDataInfo.has()) {
                YoloRoomOuterClass$YoloSmobaGameDataInfo yoloRoomOuterClass$YoloSmobaGameDataInfo2 = this.f379034d.game_data_info.smoba_game_data_info;
                YoloRoomOuterClass$YoloCommonGameDataInfo yoloRoomOuterClass$YoloCommonGameDataInfo = new YoloRoomOuterClass$YoloCommonGameDataInfo();
                yoloRoomOuterClass$YoloCommonGameDataInfo.create_type.set(yoloRoomOuterClass$YoloSmobaGameDataInfo2.create_type.get());
                yoloRoomOuterClass$YoloCommonGameDataInfo.is_auto_dismiss.set(yoloRoomOuterClass$YoloSmobaGameDataInfo2.is_auto_dismiss.get());
                yoloRoomOuterClass$YoloCommonGameDataInfo.is_off_double_check.set(yoloRoomOuterClass$YoloSmobaGameDataInfo2.is_off_double_check.get());
                yoloRoomOuterClass$YoloCommonGameDataInfo.base_room_id.set(yoloRoomOuterClass$YoloSmobaGameDataInfo2.base_room_id.get());
                yoloRoomOuterClass$YoloCommonGameDataInfo.game_mode.set(yoloRoomOuterClass$YoloSmobaGameDataInfo2.game_mode.get());
                yoloRoomOuterClass$YoloCommonGameDataInfo.grade_list.set(yoloRoomOuterClass$YoloSmobaGameDataInfo2.grade_list.get());
                yoloRoomOuterClass$YoloCommonGameDataInfo.mode_name.set(yoloRoomOuterClass$YoloSmobaGameDataInfo2.mode_name.get());
                yoloRoomOuterClass$YoloCommonGameDataInfo.game_desc.set(((pm4.a) mm4.b.b(pm4.a.class)).W2(yoloRoomOuterClass$YoloSmobaGameDataInfo2.grade_list.get()) + APLogFileUtil.SEPARATOR_LOG + yoloRoomOuterClass$YoloSmobaGameDataInfo2.mode_name.get());
                return yoloRoomOuterClass$YoloCommonGameDataInfo;
            }
            YoloRoomOuterClass$YoloCommonGameDataInfo yoloRoomOuterClass$YoloCommonGameDataInfo2 = this.f379034d.game_data_info.common_game_data_info;
            if (yoloRoomOuterClass$YoloCommonGameDataInfo2 != null && yoloRoomOuterClass$YoloCommonGameDataInfo2.has()) {
                return this.f379034d.game_data_info.common_game_data_info;
            }
            return null;
        }
        return null;
    }

    @Override // gm4.c
    public ConcurrentHashMap<String, String> x() {
        return this.f379033c0;
    }

    @Override // gm4.d
    public void y(fm4.q qVar) {
        com.tencent.timi.game.utils.l.b("YoloRoomManager", "registerCommonListener roomListener =  " + qVar);
        if (qVar != null && !this.f379039f0.contains(qVar)) {
            this.f379039f0.add(qVar);
            com.tencent.timi.game.utils.l.b("YoloRoomManager", "registerCommonListener real add");
        }
    }

    @Override // gm4.b
    public void z(boolean z16, int i3, boolean z17, IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> iResultListener) {
        com.tencent.timi.game.utils.l.i("YoloRoomManager", "inSpeaking - " + z16 + " - " + i3 + " - " + z17);
        U0(new l(z16, i3, z17, iResultListener));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class e implements IResultListener<hm4.a> {
        e() {
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int i3, String str) {
            if (YoloRoomManager.this.H1()) {
                YoloRoomManager yoloRoomManager = YoloRoomManager.this;
                YoloRoomOuterClass$YoloRoomSpeakingPosInfo L = yoloRoomManager.L(yoloRoomManager.q1());
                if (L != null && L.voice_switch.get() == 1) {
                    com.tencent.timi.game.utils.l.e("YoloRoomManager", "init checkMediaTrtcEnv onError, close self mic!");
                    YoloRoomManager.this.O(null, 2, new a());
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes26.dex */
        class a implements IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> {
            a() {
            }

            @Override // com.tencent.timi.game.utils.IResultListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(YoloRoomOuterClass$YoloRoomCmdRsp yoloRoomOuterClass$YoloRoomCmdRsp) {
            }

            @Override // com.tencent.timi.game.utils.IResultListener
            public void onError(int i3, String str) {
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(hm4.a aVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class c implements gm4.a {
        c() {
        }

        @Override // gm4.a
        public boolean a() {
            hm4.a j16 = YoloRoomManager.this.j1();
            if (j16 != null) {
                return j16.v();
            }
            return false;
        }

        @Override // gm4.a
        public boolean b() {
            return YoloRoomManager.this.k1();
        }

        @Override // gm4.a
        public void c(boolean z16) {
            YoloRoomManager.this.U0(new a(z16));
        }

        @Override // gm4.a
        public LiveData<Boolean> d() {
            hm4.a j16 = YoloRoomManager.this.j1();
            if (j16 != null) {
                return j16.s();
            }
            return null;
        }

        @Override // gm4.a
        public LiveData<Boolean> e() {
            hm4.a j16 = YoloRoomManager.this.j1();
            if (j16 != null) {
                return j16.r();
            }
            return null;
        }

        /* compiled from: P */
        /* loaded from: classes26.dex */
        class a implements IResultListener<hm4.a> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ boolean f379103a;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: P */
            /* renamed from: com.tencent.timi.game.room.impl.YoloRoomManager$c$a$a, reason: collision with other inner class name */
            /* loaded from: classes26.dex */
            public class C9962a implements YoloVoiceChangeAlertUtil.b {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ hm4.a f379105a;

                C9962a(hm4.a aVar) {
                    this.f379105a = aVar;
                }

                @Override // com.tencent.timi.game.room.impl.YoloVoiceChangeAlertUtil.b
                public void onConfirm() {
                    this.f379105a.D(a.this.f379103a);
                }
            }

            a(boolean z16) {
                this.f379103a = z16;
            }

            @Override // com.tencent.timi.game.utils.IResultListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(hm4.a aVar) {
                if (aVar != null) {
                    if (this.f379103a && YoloVoiceChangeAlertUtil.c(YoloRoomManager.this.f379050n0.q())) {
                        YoloVoiceChangeAlertUtil.d(YoloRoomManager.this.getRoomType(), new C9962a(aVar));
                    } else {
                        aVar.D(this.f379103a);
                    }
                }
            }

            @Override // com.tencent.timi.game.utils.IResultListener
            public void onError(int i3, String str) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class ak implements IResultListener<IUserInfo> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CommonOuterClass$QQUserId f379086a;

        ak(CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
            this.f379086a = commonOuterClass$QQUserId;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(IUserInfo iUserInfo) {
            String str;
            String str2;
            if (iUserInfo != null) {
                str = iUserInfo.i(this.f379086a);
            } else {
                str = "";
            }
            if (!TextUtils.isEmpty(str)) {
                str2 = "\u961f\u957f\u5df2\u79bb\u5f00\u961f\u4f0d\uff0c\u5df2\u8f6c\u79fb\u7ed9 " + str;
            } else {
                str2 = "\u961f\u957f\u5df2\u79bb\u5f00\u961f\u4f0d\uff0c\u961f\u957f\u5df2\u8f6c\u79fb";
            }
            com.tencent.timi.game.ui.widget.f.c(str2);
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int i3, String str) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class ao implements DialogInterface.OnClickListener {
        ao() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class ar implements ln4.a {
        ar() {
        }

        @Override // ln4.a
        public void c(@NotNull long j3, @NotNull ln4.c cVar) {
            if (YoloRoomManager.this.f379034d != null && YoloRoomManager.this.f379034d.tim_group_id.get() == j3) {
                com.tencent.timi.game.utils.l.e("YoloRoomManager", "TIM group dismissed !!! - IMGroupId = " + j3 + " - " + YoloRoomManager.this.f379034d);
                if (YoloRoomUtil.c0(YoloRoomManager.this.C)) {
                    if (((sm4.a) mm4.b.b(sm4.a.class)).y3() && !((sm4.a) mm4.b.b(sm4.a.class)).a2(YoloRoomManager.this.f379041h)) {
                        QQToast.makeText(BaseApplication.getContext(), 0, "\u4e3b\u64ad\u5173\u95ed\u7ec4\u961f\uff0c\u8f66\u961f\u5df2\u89e3\u6563\u3002", 0).show();
                    } else if (((sm4.a) mm4.b.b(sm4.a.class)).n1()) {
                        com.tencent.timi.game.ui.widget.f.c("\u793c\u7269\u8f66\u961f\u5df2\u89e3\u6563\uff0c\u91d1\u5e01\u5c06\u9000\u8fd8\u8d26\u6237\u3002");
                    }
                } else {
                    com.tencent.timi.game.ui.widget.f.c("\u623f\u95f4\u5df2\u89e3\u6563");
                }
                YoloRoomManager.this.c1(-10000, "TIM group dismissed");
            }
        }

        @Override // ln4.a
        public void d(@NotNull long j3, @NotNull ln4.c cVar, @NotNull List<? extends ln4.c> list) {
            if (YoloRoomManager.this.H1() && j3 == YoloRoomManager.this.getRoomInfo().tim_group_id.get() && list.size() > 0) {
                YoloRoomManager.this.C1(j3, list);
            }
        }

        @Override // ln4.a
        public void b(@NotNull long j3, @NotNull ln4.c cVar) {
        }

        @Override // ln4.a
        public void a(@NotNull long j3, @NotNull ln4.c cVar, @NotNull List<? extends ln4.c> list) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class k implements IResultListener<hm4.a> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f379126a;

        k(boolean z16) {
            this.f379126a = z16;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(hm4.a aVar) {
            if (aVar != null) {
                aVar.C(this.f379126a);
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int i3, String str) {
        }
    }
}
