package com.tencent.biz.troop;

import NearbyGroup.RspGetAreaList;
import NearbyGroup.RspGetGroupInArea;
import NearbyGroup.RspGetNearbyGroup;
import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.core.util.Consumer;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.TroopRedpoint.TroopRedTouchHandler;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl;
import com.tencent.biz.pubaccount.api.IPublicAccountH5Manager;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.biz.webviewplugin.NTJuBaoUtil;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.bh;
import com.tencent.mobileqq.app.ck;
import com.tencent.mobileqq.app.ds;
import com.tencent.mobileqq.app.du;
import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.MessageForTroopReward;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.dt.api.IDTAPI;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.guild.api.IGuildOpenApi;
import com.tencent.mobileqq.guild.data.QQGuildOpenData;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.intervideo.huayang.IHuayangOpenHelper;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.share.api.IReadInjoyWebShareHelper;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.managers.TempMsgManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.api.IFactoryApi;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.o;
import com.tencent.mobileqq.shortvideo.x;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.troop.api.IBizTroopMemberInfoService;
import com.tencent.mobileqq.troop.api.ITroopAvatarLoaderApi;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.TroopTrpcRemoteResponse;
import com.tencent.mobileqq.troop.association.data.AllianceItem;
import com.tencent.mobileqq.troop.base.handler.TroopTrpcHandler;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.data.t;
import com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUtilsApi;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorService;
import com.tencent.mobileqq.troop.jointype.TroopJoinTypeFragment;
import com.tencent.mobileqq.troop.jointype.event.TroopManageAutoApprovalEvent;
import com.tencent.mobileqq.troop.jointype.event.TroopManageSetJoinTypeResultEvent;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAppService;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopCreateService;
import com.tencent.mobileqq.troop.troopidentity.api.ITroopIdentityApi;
import com.tencent.mobileqq.troop.troopmanager.api.ITroopManagerFragmentApi;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.troop.utils.az;
import com.tencent.mobileqq.troop.utils.r;
import com.tencent.mobileqq.troopmanage.activity.TroopSetJoinTypeActivity;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.webview.URLCheckParams;
import com.tencent.mobileqq.webview.f;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.bean.JoinTroopParam;
import com.tencent.qqnt.bus.api.IBusManager;
import com.tencent.qqnt.kernelpublic.nativeinterface.MemberRole;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import com.tencent.qqnt.troop.ITroopOperationRepoApi;
import com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi;
import com.tencent.state.data.SquareJSConst;
import com.tencent.troopguild.api.ITroopGuildPermissionService;
import com.tencent.trpcprotocol.sc_report.sso_data_recv.sso_data_recv.DownloadApkReport$OpenDownloadUrl;
import cooperation.peak.PeakConstants;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.gift.QZoneCheckSendGiftServlet;
import cooperation.troop_homework.model.HWTroopFileStatusInfo;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import mqq.app.AppRuntime;
import mqq.app.AppService;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.WtloginPrivacyListenerImpl;
import mqq.app.WtloginReportListenerImpl;
import mqq.app.WtloginSwitchListenerImpl;
import mqq.app.api.ProcessConstant;
import mqq.observer.BusinessObserver;
import oicq.wlogin_sdk.listener.PrivacyListener;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.request.WtloginListener;
import oicq.wlogin_sdk.tools.ErrMsg;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.group.nearbybanner.nearbybanner$Banners;
import tencent.im.group.nearbybanner.nearbybanner$ClientInfo;
import tencent.im.group.nearbybanner.nearbybanner$ReqBody;
import tencent.im.group.nearbybanner.nearbybanner$RspBody;
import tencent.im.oidb.cmd0x791.oidb_0x791$RedDotInfo;
import tencent.im.oidb.cmd0x7f5.cmd0x7f5$GroupInfo;

/* compiled from: P */
/* loaded from: classes5.dex */
public class TroopMemberApiService extends AppService {
    ConditionSearchManager C;
    int E;
    int F;
    String J;
    int K;
    IPublicAccountH5Manager U;

    /* renamed from: h, reason: collision with root package name */
    kx.b f96617h;

    /* renamed from: i, reason: collision with root package name */
    kx.d f96618i;

    /* renamed from: m, reason: collision with root package name */
    ck f96619m;

    /* renamed from: d, reason: collision with root package name */
    final Messenger f96614d = new Messenger(new IncomingHandler());

    /* renamed from: e, reason: collision with root package name */
    Messenger f96615e = null;

    /* renamed from: f, reason: collision with root package name */
    ConcurrentHashMap<String, Messenger> f96616f = new ConcurrentHashMap<>();
    int D = -1;
    boolean G = false;
    ArrayList<Integer> H = new ArrayList<>();
    boolean I = false;
    com.tencent.mobileqq.Doraemon.g L = null;
    du M = new f();
    com.tencent.mobileqq.troop.troopmanager.api.b N = new g();
    com.tencent.mobileqq.troop.api.observer.e P = new h();
    com.tencent.mobileqq.troop.api.observer.b Q = new i();
    com.tencent.mobileqq.troop.troopapps.api.b R = new j();
    com.tencent.mobileqq.troop.association.api.b S = new k();
    com.tencent.mobileqq.troop.observer.f T = new l();
    com.tencent.mobileqq.app.c V = new m();
    public bh W = new n();
    public com.tencent.mobileqq.avatar.observer.a X = new a();
    public uo4.e Y = new b();
    private ds Z = new ds();

    /* renamed from: a0, reason: collision with root package name */
    private ds.a f96612a0 = new c();

    /* renamed from: b0, reason: collision with root package name */
    private final SimpleEventReceiver f96613b0 = new e();

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a extends com.tencent.mobileqq.avatar.observer.a {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object[], java.io.Serializable] */
        @Override // com.tencent.mobileqq.avatar.observer.a
        protected void onUpdateTroopHead(boolean z16, String str) {
            Bundle bundle = new Bundle();
            bundle.putInt("type", 3);
            bundle.putBoolean("isSuccess", z16);
            bundle.putSerializable("data", new Object[]{str});
            bundle.putSerializable("observer_type", 2);
            TroopMemberApiService.this.X(3, bundle);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class b extends uo4.e {
        b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object[], java.io.Serializable] */
        @Override // uo4.e
        public void a(@NonNull String str, int i3) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("observer_type", 6);
            bundle.putSerializable("data", new Object[]{str, Integer.valueOf(i3)});
            TroopMemberApiService.this.X(3, bundle);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class c implements ds.a {
        c() {
        }

        @Override // com.tencent.mobileqq.app.ds.a
        public void a(boolean z16, @Nullable Object obj) {
            if (obj instanceof Bundle) {
                TroopMemberApiService.this.X(162, (Bundle) obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class d extends WtloginListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ WtloginHelper f96652b;

        d(WtloginHelper wtloginHelper) {
            this.f96652b = wtloginHelper;
        }

        @Override // oicq.wlogin_sdk.request.WtloginListener
        public void OnException(ErrMsg errMsg, int i3, WUserSigInfo wUserSigInfo) {
            super.OnException(errMsg, i3, wUserSigInfo);
            TroopMemberApiService.this.X(59, null);
        }

        @Override // oicq.wlogin_sdk.request.WtloginListener
        public void onGetA1WithA1(String str, long j3, int i3, long j16, byte[] bArr, long j17, long j18, long j19, byte[] bArr2, byte[] bArr3, WUserSigInfo wUserSigInfo, WFastLoginInfo wFastLoginInfo, int i16, ErrMsg errMsg) {
            if (i16 == 0) {
                TroopMemberApiService.this.X(59, this.f96652b.PrepareQloginResult(str, j18, j19, i16, wFastLoginInfo).getExtras());
            } else {
                TroopMemberApiService.this.X(59, null);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class e implements SimpleEventReceiver {
        e() {
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
            ArrayList<Class<? extends SimpleBaseEvent>> arrayList = new ArrayList<>();
            arrayList.add(TroopManageSetJoinTypeResultEvent.class);
            return arrayList;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v1, types: [com.tencent.mobileqq.troop.jointype.event.TroopManageSetJoinTypeResultEvent] */
        /* JADX WARN: Type inference failed for: r11v8, types: [com.tencent.biz.troop.TroopMemberApiService] */
        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
            Bundle bundle;
            int i3;
            if (simpleBaseEvent instanceof TroopManageSetJoinTypeResultEvent) {
                TroopManageSetJoinTypeResultEvent troopManageSetJoinTypeResultEvent = (TroopManageSetJoinTypeResultEvent) simpleBaseEvent;
                int multiGroupOption = troopManageSetJoinTypeResultEvent.getMultiGroupOption();
                boolean isSetSuccess = troopManageSetJoinTypeResultEvent.isSetSuccess();
                String troopUinList = troopManageSetJoinTypeResultEvent.getTroopUinList();
                JSONObject jSONObject = new JSONObject();
                try {
                    try {
                        jSONObject.put("groupUin", new JSONArray(troopUinList));
                        if (isSetSuccess) {
                            i3 = 0;
                        } else {
                            i3 = 1;
                        }
                        jSONObject.put("retCode", i3);
                        jSONObject.put("groupOption", multiGroupOption);
                        bundle = new Bundle();
                    } catch (JSONException unused) {
                        QLog.e("TroopMemberApiService", 1, "groupAddMethodList callJs error.");
                        bundle = new Bundle();
                    }
                    bundle.putInt("seq", troopManageSetJoinTypeResultEvent.getSeq());
                    bundle.putString("processName", troopManageSetJoinTypeResultEvent.getProcessName());
                    bundle.putString("groupAddMethodList", jSONObject.toString());
                    troopManageSetJoinTypeResultEvent = TroopMemberApiService.this;
                    troopManageSetJoinTypeResultEvent.X(174, bundle);
                } catch (Throwable th5) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putInt("seq", troopManageSetJoinTypeResultEvent.getSeq());
                    bundle2.putString("processName", troopManageSetJoinTypeResultEvent.getProcessName());
                    bundle2.putString("groupAddMethodList", jSONObject.toString());
                    TroopMemberApiService.this.X(174, bundle2);
                    throw th5;
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class f extends du {
        f() {
        }

        @Override // com.tencent.mobileqq.app.du
        protected void a(boolean z16, int i3, Bundle bundle) {
            if (z16) {
                TroopMemberApiService.this.X(144, bundle);
            } else if (QLog.isColorLevel()) {
                QLog.d("TroopMemberApiService", 2, "onWebPushResp isSuc:", Boolean.valueOf(z16), " type:", Integer.valueOf(i3));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class g extends com.tencent.mobileqq.troop.troopmanager.api.b {
        g() {
        }

        /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object[], java.io.Serializable] */
        @Override // com.tencent.mobileqq.troop.troopmanager.api.b
        protected void onNotifyTroopUpgradeSuccess(String str, int i3) {
            TroopMemberApiService.this.Y(com.tencent.mobileqq.troop.troopmanager.api.b.TYPE_NOTIFY_TROOP_UPGRADE_SUCCESS, true, new Object[]{str, Integer.valueOf(i3)}, getClass().getSuperclass().getName(), "");
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class h extends com.tencent.mobileqq.troop.api.observer.e {
        h() {
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        public void onGetUinByOpenId(boolean z16, int i3, String str, String str2, String str3, int i16, int i17, Object obj) {
            boolean z17;
            String str4;
            Bundle bundle = new Bundle();
            bundle.putInt("type", com.tencent.mobileqq.troop.api.observer.e.TYPE_GET_UIN_BY_OPEN_ID);
            bundle.putBoolean("isSuccess", z16);
            bundle.putInt("appid", i3);
            bundle.putString("openId", str);
            bundle.putString("token", str2);
            bundle.putInt("seq", i16);
            bundle.putInt("retCode", i17);
            bundle.putString("uin", str3);
            if (obj instanceof AllInOne) {
                AllInOne allInOne = (AllInOne) obj;
                if (allInOne != null && (!TextUtils.isEmpty(allInOne.nickname) || !TextUtils.isEmpty(allInOne.remark))) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                bundle.putBoolean(IProfileProtocolConst.PARAM_IS_FRIEND, z17);
                String str5 = "";
                if (allInOne == null) {
                    str4 = "";
                } else {
                    str4 = allInOne.nickname;
                }
                bundle.putString("nickName", str4);
                if (allInOne != null) {
                    str5 = allInOne.remark;
                }
                bundle.putString("remark", str5);
            }
            TroopMemberApiService.this.X(58, bundle);
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        public void onTroopOpenApiVerifyed(boolean z16, int i3, String str, String str2, String str3, int i16, int i17, ArrayList<String> arrayList, int i18, int i19) {
            Bundle bundle = new Bundle();
            bundle.putInt("type", com.tencent.mobileqq.troop.api.observer.e.TYPE_NOTIFY_TROOP_OPEN_API_TOKEN_VERIFY);
            bundle.putBoolean("isSuccess", z16);
            bundle.putInt("appid", i3);
            bundle.putString("openGroupId", str);
            bundle.putString("token", str2);
            bundle.putInt("freq", i16);
            bundle.putInt("expireTime", i17);
            bundle.putStringArrayList("apilist", arrayList);
            bundle.putInt("seq", i18);
            bundle.putInt("retCode", i19);
            TroopMemberApiService.this.X(28, bundle);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class i extends com.tencent.mobileqq.troop.api.observer.b {
        i() {
        }

        /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object[], java.io.Serializable] */
        @Override // com.tencent.mobileqq.troop.api.observer.b
        protected void k(int i3, int i16) {
            TroopMemberApiService.this.Y(com.tencent.mobileqq.troop.api.observer.b.f294307e, false, new Object[]{Integer.valueOf(i3), Integer.valueOf(i16)}, getClass().getSuperclass().getName(), "");
        }

        /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object[], java.io.Serializable] */
        @Override // com.tencent.mobileqq.troop.api.observer.b
        protected void l(int i3, int i16, String str) {
            TroopMemberApiService.this.Y(com.tencent.mobileqq.troop.api.observer.b.f294307e, true, new Object[]{Integer.valueOf(i3), Integer.valueOf(i16), str}, getClass().getSuperclass().getName(), "");
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class j extends com.tencent.mobileqq.troop.troopapps.api.b {
        j() {
        }

        @Override // com.tencent.mobileqq.troop.troopapps.api.b
        protected void e(Boolean bool) {
            if (bool.booleanValue()) {
                TroopMemberApiService troopMemberApiService = TroopMemberApiService.this;
                if (troopMemberApiService.G) {
                    ITroopAppService iTroopAppService = (ITroopAppService) ((AppService) troopMemberApiService).app.getRuntimeService(ITroopAppService.class, "all");
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    if (iTroopAppService != null) {
                        List<TroopAIOAppInfo> troopAppList = iTroopAppService.getTroopAppList(false, 0);
                        if (troopAppList != null && !troopAppList.isEmpty()) {
                            for (TroopAIOAppInfo troopAIOAppInfo : troopAppList) {
                                arrayList.add(Integer.valueOf(troopAIOAppInfo.appid));
                                if (troopAIOAppInfo.appid == TroopMemberApiService.this.E) {
                                    QQToast.makeText(BaseApplication.getContext(), 2, R.string.f173223i52, 0).show(TroopMemberApiService.this.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                                    return;
                                }
                            }
                        }
                        arrayList.add(Integer.valueOf(TroopMemberApiService.this.E));
                        ArrayList<Integer> arrayList2 = new ArrayList<>();
                        arrayList2.add(Integer.valueOf(TroopMemberApiService.this.E));
                        iTroopAppService.addTroopApp(arrayList, arrayList2);
                    }
                }
            }
        }

        @Override // com.tencent.mobileqq.troop.troopapps.api.b
        protected void f(Boolean bool) {
            Bundle bundle = new Bundle();
            bundle.putInt("seq", TroopMemberApiService.this.F);
            bundle.putInt("type", com.tencent.mobileqq.troop.troopapps.api.b.f299364f);
            bundle.putBoolean("isSuccess", bool.booleanValue());
            TroopMemberApiService.this.X(42, bundle);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class k extends com.tencent.mobileqq.troop.association.api.b {
        k() {
        }

        /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object[], java.io.Serializable] */
        @Override // com.tencent.mobileqq.troop.association.api.b
        protected void a(boolean z16, String str, int i3, long j3, AllianceItem allianceItem) {
            TroopMemberApiService.this.Y(com.tencent.mobileqq.troop.association.api.b.f294469e, z16, new Object[]{str, Integer.valueOf(i3), Long.valueOf(j3), allianceItem}, getClass().getSuperclass().getName(), "");
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class l extends com.tencent.mobileqq.troop.observer.f {
        l() {
        }

        /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object[], java.io.Serializable] */
        @Override // com.tencent.mobileqq.troop.observer.f
        protected void c(boolean z16, String str, boolean z17) {
            TroopMemberApiService.this.Y(com.tencent.mobileqq.troop.observer.f.f298018m, z16, new Object[]{str, Boolean.valueOf(z17)}, getClass().getSuperclass().getName(), "");
        }

        /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object[], java.io.Serializable] */
        @Override // com.tencent.mobileqq.troop.observer.f
        protected void f(boolean z16, String str, boolean z17) {
            TroopMemberApiService.this.Y(com.tencent.mobileqq.troop.observer.f.f298017i, z16, new Object[]{str, Boolean.valueOf(z17)}, getClass().getSuperclass().getName(), "");
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class m extends com.tencent.mobileqq.app.c {
        m() {
        }

        @Override // com.tencent.mobileqq.app.c
        protected void g(Object obj) {
            t tVar = (t) obj;
            Bundle bundle = new Bundle();
            bundle.putLong("ProgressTotal", tVar.f294976j);
            bundle.putLong("ProgressValue", tVar.f294977k);
            bundle.putString("FileName", tVar.f294987u);
            bundle.putString("FilePath", tVar.f294985s);
            bundle.putString("LocalFile", tVar.f294978l);
            bundle.putString("ThumbnailFile_Middle", tVar.f294981o);
            bundle.putString("ThumbnailFile_Large", tVar.f294980n);
            bundle.putInt("Status", tVar.f294972f);
            int i3 = tVar.f294972f;
            if (i3 != 8 && (i3 != 11 || !FileUtils.fileExists(tVar.f294985s))) {
                if (!TextUtils.isEmpty(tVar.f294980n)) {
                    bundle.putInt("size", 640);
                    TroopMemberApiService.this.X(56, bundle);
                    return;
                } else {
                    if (!TextUtils.isEmpty(tVar.f294981o)) {
                        bundle.putInt("size", 383);
                        TroopMemberApiService.this.X(56, bundle);
                        return;
                    }
                    return;
                }
            }
            TroopMemberApiService.this.X(55, bundle);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class n extends bh {
        n() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object[], java.io.Serializable] */
        @Override // com.tencent.mobileqq.app.bh
        protected void onGetAreaList(boolean z16, RspGetAreaList rspGetAreaList, boolean z17) {
            Bundle bundle = new Bundle();
            bundle.putInt("type", 12);
            bundle.putBoolean("isSuccess", z16);
            bundle.putSerializable("data", new Object[]{Boolean.valueOf(z17), rspGetAreaList});
            bundle.putSerializable("observer_type", 1);
            TroopMemberApiService.this.X(3, bundle);
            bundle.putSerializable("", rspGetAreaList);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object[], java.io.Serializable] */
        @Override // com.tencent.mobileqq.app.bh
        protected void onGetGroupInArea(boolean z16, RspGetGroupInArea rspGetGroupInArea) {
            Bundle bundle = new Bundle();
            bundle.putInt("type", 13);
            bundle.putBoolean("isSuccess", z16);
            bundle.putSerializable("data", new Object[]{rspGetGroupInArea});
            bundle.putSerializable("observer_type", 1);
            TroopMemberApiService.this.X(3, bundle);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object[], java.io.Serializable] */
        @Override // com.tencent.mobileqq.app.bh
        protected void onGetGroups(int i3, boolean z16, boolean z17, RspGetNearbyGroup rspGetNearbyGroup) {
            Bundle bundle = new Bundle();
            bundle.putInt("type", 8);
            bundle.putInt("iFilterId", i3);
            bundle.putBoolean("isSuccess", z16);
            bundle.putSerializable("data", new Object[]{Integer.valueOf(i3), Boolean.valueOf(z17), rspGetNearbyGroup});
            bundle.putSerializable("observer_type", 1);
            TroopMemberApiService.this.X(3, bundle);
        }

        @Override // com.tencent.mobileqq.app.bh
        protected void onGetNewNearbyTroops(boolean z16, int i3, cmd0x7f5$GroupInfo cmd0x7f5_groupinfo) {
            Bundle bundle = new Bundle();
            bundle.putInt("type", 28);
            bundle.putBoolean("isSuccess", z16);
            if (cmd0x7f5_groupinfo != null) {
                bundle.putByteArray("groupInfo", cmd0x7f5_groupinfo.toByteArray());
            }
            bundle.putInt("count", i3);
            bundle.putSerializable("observer_type", 1);
            TroopMemberApiService.this.X(3, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(QQAppInterface qQAppInterface, long j3, HWTroopFileStatusInfo hWTroopFileStatusInfo, Bundle bundle) {
        String str;
        if (hWTroopFileStatusInfo == null) {
            return;
        }
        FileInfo fileInfo = new FileInfo();
        if (!q.p(hWTroopFileStatusInfo.LocalFile)) {
            TroopFileTransferManager.O(qQAppInterface, j3).r();
        }
        if (!TextUtils.isEmpty(hWTroopFileStatusInfo.FileName)) {
            str = hWTroopFileStatusInfo.FileName;
        } else {
            str = "";
        }
        TroopFileManager.F(qQAppInterface, j3).c(hWTroopFileStatusInfo.Id);
        fileInfo.y(str);
        fileInfo.z(hWTroopFileStatusInfo.LocalFile);
        fileInfo.A(hWTroopFileStatusInfo.ProgressTotal);
        t tVar = new t();
        tVar.f294987u = str;
        tVar.f294978l = hWTroopFileStatusInfo.LocalFile;
        tVar.f294976j = hWTroopFileStatusInfo.ProgressTotal;
        tVar.f294967a = hWTroopFileStatusInfo.Id;
        tVar.f294971e = j3;
        tVar.f294988v = hWTroopFileStatusInfo.BusId;
        tVar.f294985s = hWTroopFileStatusInfo.FilePath;
        tVar.f294986t = hWTroopFileStatusInfo.sha1;
        tVar.f294979m = hWTroopFileStatusInfo.ThumbnailFile_Small;
        tVar.f294980n = hWTroopFileStatusInfo.ThumbnailFile_Large;
        tVar.f294972f = hWTroopFileStatusInfo.Status;
        bundle.putLong("sessionId", FileManagerUtil.newEntityByTroopFileInfo(tVar).nSessionId);
        bundle.putInt("cloudType", 4);
        bundle.putInt("type", 10006);
        bundle.putString("filePath", fileInfo.k());
        bundle.putString(WadlProxyConsts.PARAM_FILENAME, fileInfo.j());
        bundle.putLong("fileSize", fileInfo.l());
        bundle.putLong(IProfileProtocolConst.PARAM_TROOP_CODE, j3);
        X(20, bundle);
    }

    public static boolean N(AppRuntime appRuntime, BusinessObserver businessObserver) {
        nearbybanner$ReqBody nearbybanner_reqbody = new nearbybanner$ReqBody();
        try {
            DisplayMetrics displayMetrics = appRuntime.getApplication().getResources().getDisplayMetrics();
            int i3 = displayMetrics.widthPixels;
            int i16 = displayMetrics.heightPixels;
            nearbybanner$ClientInfo nearbybanner_clientinfo = new nearbybanner$ClientInfo();
            nearbybanner_clientinfo.uint32_lcd_height.set(i16);
            nearbybanner_clientinfo.uint32_lcd_width.set(i3);
            nearbybanner_clientinfo.bytes_client_version.set(ByteStringMicro.copyFromUtf8(AppSetting.f99551k + "." + AppSetting.f99542b));
            nearbybanner_clientinfo.uint32_os.set(0);
            nearbybanner_reqbody.msg_client_info.set(nearbybanner_clientinfo);
            NewIntent newIntent = new NewIntent(appRuntime.getApplication(), com.tencent.biz.m.class);
            newIntent.putExtra("cmd", "nearby_group_banner.get_banner_info");
            newIntent.putExtra("data", nearbybanner_reqbody.toByteArray());
            newIntent.setObserver(businessObserver);
            appRuntime.startServlet(newIntent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private void Q() {
        this.Z.a(0, this.f96612a0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit R(String str, String str2, String str3) {
        com.tencent.mobileqq.dt.api.b bVar = new com.tencent.mobileqq.dt.api.b();
        bVar.i("10104");
        bVar.o(4);
        bVar.n(str);
        bVar.j("0");
        bVar.s(0);
        bVar.r(str2);
        bVar.q(str2);
        bVar.m("anonymousseq=" + com.tencent.biz.anonymous.a.f78360i);
        bVar.k(Integer.toString(1));
        bVar.l(str);
        bVar.x(NewReportPlugin.h("REPORT_IP=0&EVIL_IP=0", true));
        bVar.v(str3);
        ((IDTAPI) QRoute.api(IDTAPI.class)).jumpReport(QBaseActivity.sTopActivity, bVar);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(Boolean bool, TroopInfo troopInfo) {
        if (this.app == null) {
            return;
        }
        Y(com.tencent.mobileqq.troop.api.observer.e.TYPE_GET_TROOP_INFO, bool.booleanValue(), troopInfo.troopuin, getClass().getSuperclass().getName(), "");
        if (QLog.isDevelopLevel()) {
            QLog.i("TroopMngTest", 2, String.format("onGetTroopInfoResult [%s, %s]", bool, troopInfo.troopuin));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(Boolean bool) {
        if (this.app == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("isSuccess", bool.booleanValue());
        bundle.putInt("seq", this.K);
        bundle.putString("callback", this.J);
        X(110, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        ((ITroopGuildPermissionService) this.app.getRuntimeService(ITroopGuildPermissionService.class, "")).addObserver(this.Y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(Bundle bundle) {
        String str;
        if (bundle == null) {
            QLog.e("TroopMemberApiService", 1, "data = " + bundle);
            return;
        }
        try {
            DownloadApkReport$OpenDownloadUrl downloadApkReport$OpenDownloadUrl = new DownloadApkReport$OpenDownloadUrl();
            String string = bundle.getString("guid");
            String string2 = bundle.getString("date");
            String string3 = bundle.getString("version");
            String string4 = bundle.getString("url");
            String[] split = string4.split("/");
            if (split.length != 0) {
                str = split[split.length - 1];
            } else {
                str = string4;
            }
            String string5 = bundle.getString("mimeType");
            String string6 = bundle.getString("ip");
            if (QLog.isColorLevel()) {
                QLog.d("TroopMemberApiService", 2, " sendMSF data = " + bundle + " downloadType = " + com.tencent.mobileqq.webview.b.f313815d);
            }
            downloadApkReport$OpenDownloadUrl.client_ip.set(ByteStringMicro.copyFromUtf8(string6));
            downloadApkReport$OpenDownloadUrl.timestamp.set(string2);
            downloadApkReport$OpenDownloadUrl.guid.set(ByteStringMicro.copyFromUtf8(string));
            downloadApkReport$OpenDownloadUrl.client_ver.set(string3);
            downloadApkReport$OpenDownloadUrl.download_type.set(com.tencent.mobileqq.webview.b.f313815d);
            downloadApkReport$OpenDownloadUrl.filename.set(ByteStringMicro.copyFromUtf8(str));
            downloadApkReport$OpenDownloadUrl.file_type.set(string5);
            downloadApkReport$OpenDownloadUrl.url.set(string4);
            ProtoUtils.d(this.app, new com.tencent.mobileqq.webview.b(), downloadApkReport$OpenDownloadUrl.toByteArray(), "trpc.sc_report.sso_data_recv.sso_data_recv.ApkUrlOpen");
            com.tencent.mobileqq.webview.b.f313815d = 1;
        } catch (Exception e16) {
            QLog.e("TroopMemberApiService", 1, "onProtocol error", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(int i3, boolean z16, Serializable serializable, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            str2 = com.tencent.biz.troop.b.y();
        }
        Bundle bundle = new Bundle();
        bundle.putInt("type", i3);
        bundle.putBoolean("isSuccess", z16);
        bundle.putSerializable("data", serializable);
        bundle.putString("observerClassName", str);
        if (!TextUtils.isEmpty(str2)) {
            bundle.putString("processName", str2);
        }
        X(3, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Z(long j3, boolean z16) {
        ILebaHelperService iLebaHelperService;
        com.tencent.mobileqq.leba.entity.n lebaViewItemById;
        AppRuntime appRuntime = this.app;
        if (!(appRuntime instanceof QQAppInterface) || (lebaViewItemById = (iLebaHelperService = (ILebaHelperService) appRuntime.getRuntimeService(ILebaHelperService.class, ProcessConstant.MULTI)).getLebaViewItemById(j3)) == null || lebaViewItemById.f240505b == null || z16 == lebaViewItemById.d()) {
            return false;
        }
        if (z16) {
            lebaViewItemById.e();
        } else {
            lebaViewItemById.a();
        }
        AppRuntime appRuntime2 = this.app;
        if (!(appRuntime2 instanceof QQAppInterface)) {
            return false;
        }
        iLebaHelperService.updateAppSetting(appRuntime2, lebaViewItemById.f240505b.uiResId, z16, NetConnInfoCenter.getServerTimeMillis(), Long.MIN_VALUE);
        iLebaHelperService.netSetPluginState(String.valueOf(lebaViewItemById.f240505b.uiResId), z16, NetConnInfoCenter.getServerTimeMillis());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0() {
        ((ITroopGuildPermissionService) this.app.getRuntimeService(ITroopGuildPermissionService.class, "")).removeObserver(this.Y);
    }

    public void K(Bundle bundle) {
        int i3;
        oidb_0x791$RedDotInfo e16;
        AppRuntime appRuntime = this.app;
        if (appRuntime instanceof QQAppInterface) {
            QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
            TroopRedTouchManager troopRedTouchManager = (TroopRedTouchManager) qQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH_EX);
            if (troopRedTouchManager != null && (e16 = troopRedTouchManager.e(7)) != null) {
                TroopRedTouchHandler.F2(qQAppInterface, e16);
                TroopRedTouchHandler troopRedTouchHandler = (TroopRedTouchHandler) ((QQAppInterface) this.app).getBusinessHandler(BusinessHandlerFactory.GET_RED_POINT_EX_HANDLER);
                if (troopRedTouchHandler != null) {
                    troopRedTouchHandler.notifyUI(105, true, null);
                }
            }
            i3 = 0;
        } else {
            i3 = 1;
            ReportController.o(null, "P_CliOper", "BizTechReport", "", "tribe", "clearreddot", 0, 1, "", "", "", "");
        }
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            bundle2.putInt("seq", bundle.getInt("seq", -1));
            if (!TextUtils.isEmpty(bundle.getString("callback"))) {
                bundle2.putString("callback", bundle.getString("callback"));
            }
        }
        bundle2.putString("data", "{code:\"" + i3 + "\"}");
        bundle2.putString("method", "cleanDynamicRedPoint");
        X(15, bundle2);
    }

    public void L(String str, String str2) {
        WtloginHelper.setReportListener(WtloginReportListenerImpl.getSingleton());
        WtloginHelper.setSwitchListener(WtloginSwitchListenerImpl.getSingleton());
        WtloginHelper wtloginHelper = new WtloginHelper(this.app.getApplication().getApplicationContext(), (PrivacyListener) WtloginPrivacyListenerImpl.getSingleton());
        byte[] bArr = {-51, 50, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_UGC, -105, -54, -19, PublicAccountH5AbilityPluginImpl.OPENCAMERA, -124, -125, -52, -72, -101, -27, 33, 65, Byte.MIN_VALUE};
        wtloginHelper.SetListener(new d(wtloginHelper));
        int GetA1WithA1 = wtloginHelper.GetA1WithA1(this.app.getAccount(), 16L, 16L, str.getBytes(), 1L, Long.valueOf(str2).longValue(), 1L, "5.2".getBytes(), bArr, new WUserSigInfo(), new WFastLoginInfo());
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("source", "TroopMemberApiService");
            QQBeaconReport.report(this.app.getAccount(), "wtlogin_invalid_init", hashMap);
        } catch (Exception e16) {
            QLog.e("TroopMemberApiService", 1, e16, new Object[0]);
        }
        if (GetA1WithA1 != -1001) {
            X(59, null);
        }
    }

    public kx.b O() {
        if (this.f96617h == null) {
            this.f96617h = new kx.b(this);
        }
        return this.f96617h;
    }

    public kx.d P() {
        if (this.f96618i == null) {
            this.f96618i = new kx.d(this);
        }
        return this.f96618i;
    }

    public void V(final String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.i("TroopMemberApiService", 2, "anonymous report. group_code = " + str + "; account = " + str2);
        }
        if (!(this.app instanceof QQAppInterface)) {
            return;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
            if (qBaseActivity != null) {
                Bundle bundle = new Bundle();
                bundle.putLong("anonymousseq", com.tencent.biz.anonymous.a.f78360i);
                final String str3 = "8000000";
                NTJuBaoUtil.a("8000000", str, 25029, NewReportPlugin.P(25029, qBaseActivity, "8000000", str, bundle), new Function1() { // from class: com.tencent.biz.troop.d
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit R;
                        R = TroopMemberApiService.R(str3, str, (String) obj);
                        return R;
                    }
                });
                return;
            }
            return;
        }
        QLog.e("TroopMemberApiService", 1, "safetyReport param blank.");
    }

    public void X(int i3, Bundle bundle) {
        ConcurrentHashMap<String, Messenger> concurrentHashMap;
        String str = null;
        Message obtain = Message.obtain((Handler) null, i3);
        Messenger messenger = this.f96615e;
        if (bundle != null) {
            str = bundle.getString("processName");
        }
        if (str != null && (concurrentHashMap = this.f96616f) != null && concurrentHashMap.get(str) != null) {
            messenger = this.f96616f.get(str);
        }
        obtain.setData(bundle);
        if (messenger != null) {
            try {
                messenger.send(obtain);
            } catch (RemoteException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("TroopMemberApiService", 2, "messeage not sent:" + e16.getMessage());
                }
            }
        }
    }

    @Override // mqq.app.AppService, android.app.Service
    public IBinder onBind(Intent intent) {
        if (QLog.isColorLevel()) {
            QLog.i("TroopMemberApiService", 2, "MessengerService onBind");
        }
        return this.f96614d.getBinder();
    }

    @Override // mqq.app.AppService, android.app.Service
    public void onCreate() {
        if (QLog.isColorLevel()) {
            QLog.i("TroopMemberApiService", 2, "MessengerService onCreate");
        }
        super.onCreate();
        AppRuntime appRuntime = this.app;
        if (appRuntime instanceof QQAppInterface) {
            ((QQAppInterface) appRuntime).addObserver(this.V, true);
            ((QQAppInterface) this.app).addObserver(this.W);
            ((QQAppInterface) this.app).addObserver(this.X);
            ((QQAppInterface) this.app).addObserver(this.R);
            ((QQAppInterface) this.app).addObserver(this.Q);
            ((QQAppInterface) this.app).addObserver(this.P);
            ((QQAppInterface) this.app).addObserver(this.N);
            ((QQAppInterface) this.app).addObserver(this.S);
            ((QQAppInterface) this.app).addObserver(this.T);
            Q();
            this.app.registObserver(this.Z);
            this.app.registObserver(this.M);
        }
        SimpleEventBus.getInstance().registerReceiver(this.f96613b0);
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (QLog.isColorLevel()) {
            QLog.i("TroopMemberApiService", 2, "MessengerService onDestroy");
        }
        super.onDestroy();
        AppRuntime appRuntime = this.app;
        if (appRuntime instanceof QQAppInterface) {
            ((QQAppInterface) appRuntime).removeObserver(this.V);
            ((QQAppInterface) this.app).removeObserver(this.W);
            ((QQAppInterface) this.app).removeObserver(this.X);
            ((QQAppInterface) this.app).removeObserver(this.R);
            ((QQAppInterface) this.app).removeObserver(this.Q);
            ((QQAppInterface) this.app).removeObserver(this.P);
            ((QQAppInterface) this.app).removeObserver(this.N);
            ((QQAppInterface) this.app).removeObserver(this.S);
            ((QQAppInterface) this.app).removeObserver(this.T);
            this.app.unRegistObserver(this.M);
            this.app.unRegistObserver(this.Z);
            this.Z.b();
        }
        this.app = null;
        this.f96615e = null;
        ConcurrentHashMap<String, Messenger> concurrentHashMap = this.f96616f;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
            this.f96616f = null;
        }
        ConditionSearchManager conditionSearchManager = this.C;
        if (conditionSearchManager != null) {
            conditionSearchManager.o(this);
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this.f96613b0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class IncomingHandler extends Handler {

        /* compiled from: P */
        /* loaded from: classes5.dex */
        class a implements BusinessObserver {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Bundle f96632d;

            a(Bundle bundle) {
                this.f96632d = bundle;
            }

            @Override // mqq.observer.BusinessObserver
            public void onReceive(int i3, boolean z16, Bundle bundle) {
                this.f96632d.remove("data");
                if (!z16) {
                    TroopMemberApiService.this.X(16, this.f96632d);
                    return;
                }
                byte[] byteArray = bundle.getByteArray("data");
                nearbybanner$RspBody nearbybanner_rspbody = new nearbybanner$RspBody();
                try {
                    nearbybanner_rspbody.mergeFrom(byteArray);
                    if (nearbybanner_rspbody.uint32_result.get() != 0 && !nearbybanner_rspbody.msg_banners.has()) {
                        TroopMemberApiService.this.X(16, this.f96632d);
                        return;
                    }
                    nearbybanner$Banners nearbybanner_banners = nearbybanner_rspbody.msg_banners.get();
                    if (!nearbybanner_banners.rpt_banner_info.has()) {
                        TroopMemberApiService.this.X(16, this.f96632d);
                    } else {
                        this.f96632d.putByteArray("data", nearbybanner_banners.toByteArray());
                        TroopMemberApiService.this.X(16, this.f96632d);
                    }
                } catch (InvalidProtocolBufferMicroException unused) {
                    TroopMemberApiService.this.X(16, this.f96632d);
                } catch (Exception unused2) {
                    TroopMemberApiService.this.X(16, this.f96632d);
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes5.dex */
        class b extends com.tencent.mobileqq.vip.f {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Bundle f96634a;

            b(Bundle bundle) {
                this.f96634a = bundle;
            }

            @Override // com.tencent.mobileqq.vip.f
            public void onDone(com.tencent.mobileqq.vip.g gVar) {
                this.f96634a.putBoolean("down", true);
                TroopMemberApiService.this.X(84, this.f96634a);
            }
        }

        /* compiled from: P */
        /* loaded from: classes5.dex */
        class d implements f.InterfaceC8971f {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f96640a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f96641b;

            d(int i3, String str) {
                this.f96640a = i3;
                this.f96641b = str;
            }

            @Override // com.tencent.mobileqq.webview.f.InterfaceC8971f
            public void onResult(Bundle bundle) {
                bundle.putInt("seq", this.f96640a);
                bundle.putString("processName", this.f96641b);
                TroopMemberApiService.this.X(143, bundle);
            }
        }

        /* compiled from: P */
        /* loaded from: classes5.dex */
        class e implements IReadInjoyWebShareHelper.a {
            e() {
            }

            @Override // com.tencent.mobileqq.kandian.biz.share.api.IReadInjoyWebShareHelper.a
            public void a(int i3, @NotNull Bundle bundle) {
                TroopMemberApiService.this.X(i3, bundle);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes5.dex */
        public class f implements Function2<Boolean, TroopInfo, Unit> {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f96644d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f96645e;

            f(int i3, String str) {
                this.f96644d = i3;
                this.f96645e = str;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Unit invoke(Boolean bool, TroopInfo troopInfo) {
                cooperation.troop.a aVar = new cooperation.troop.a((QQAppInterface) ((AppService) TroopMemberApiService.this).app);
                PluginCommunicationHandler pluginCommunicationHandler = PluginCommunicationHandler.getInstance();
                if (pluginCommunicationHandler != null) {
                    pluginCommunicationHandler.register(aVar);
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("isSuccess", bool.booleanValue());
                bundle.putInt("seq", this.f96644d);
                bundle.putString("processName", this.f96645e);
                TroopMemberApiService.this.X(57, bundle);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes5.dex */
        public class g implements com.tencent.mobileqq.troop.api.f {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Bundle f96647a;

            g(Bundle bundle) {
                this.f96647a = bundle;
            }

            @Override // com.tencent.mobileqq.troop.api.f
            public void a(@NonNull TroopTrpcRemoteResponse troopTrpcRemoteResponse) {
                this.f96647a.putBoolean("success", false);
                this.f96647a.putInt("code", troopTrpcRemoteResponse.code);
                this.f96647a.putString("msg", troopTrpcRemoteResponse.f293941msg);
                this.f96647a.putByteArray("body", troopTrpcRemoteResponse.data);
                TroopMemberApiService.this.X(168, this.f96647a);
            }

            @Override // com.tencent.mobileqq.troop.api.f
            public void b(@NonNull TroopTrpcRemoteResponse troopTrpcRemoteResponse) {
                this.f96647a.putBoolean("success", true);
                this.f96647a.putInt("code", troopTrpcRemoteResponse.code);
                this.f96647a.putString("msg", troopTrpcRemoteResponse.f293941msg);
                this.f96647a.putByteArray("body", troopTrpcRemoteResponse.data);
                TroopMemberApiService.this.X(168, this.f96647a);
            }
        }

        IncomingHandler() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object[], java.io.Serializable] */
        public /* synthetic */ Unit A(long j3, Boolean bool, TroopInfo troopInfo) {
            TroopMemberApiService.this.Y(com.tencent.mobileqq.troop.api.observer.b.f294310i, bool.booleanValue(), new Object[]{Long.valueOf(j3), troopInfo}, TroopMemberApiService.this.Q.getClass().getSuperclass().getName(), "");
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void B(int i3) {
            SharedPreferences sharedPreferences = TroopMemberApiService.this.getBaseContext().getSharedPreferences("sp_public_account_with_cuin_" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), 0);
            if (sharedPreferences != null) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putInt("browser_font_size_index", i3);
                edit.commit();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object[], java.io.Serializable] */
        public /* synthetic */ void C(String str, boolean z16, int i3, String str2, com.tencent.qqnt.bean.c cVar) {
            TroopMemberApiService.this.Y(com.tencent.mobileqq.troop.api.observer.b.f294307e, z16, new Object[]{1, Integer.valueOf(i3), str}, TroopMemberApiService.this.Q.getClass().getSuperclass().getName(), "");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit D(AppRuntime appRuntime, Boolean bool, TroopInfo troopInfo) {
            if (troopInfo != null) {
                ((ITroopCreateService) appRuntime.getRuntimeService(ITroopCreateService.class, "")).jumpToAioAfterCreated(troopInfo.troopuin, troopInfo.getTroopDisplayName(), false, true);
            }
            TroopMemberApiService.this.T(bool);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void E(int i3, String str, Bundle bundle) {
            bundle.putInt("seq", i3);
            bundle.putString("processName", str);
            TroopMemberApiService.this.X(118, bundle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit F(Bundle bundle) {
            TroopMemberApiService.this.X(176, bundle);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void G(Bundle bundle, boolean z16, int i3, JSONObject jSONObject, tencent.trpcprotocol.b bVar) {
            bundle.putBoolean("success", z16);
            if (bVar != null) {
                bundle.putInt("code", bVar.f436077a);
                bundle.putString("msg", bVar.f436078b);
                bundle.putByteArray("body", bVar.f436079c);
                bundle.putString(QCircleWeakNetReporter.KEY_TRACE_ID, bVar.f436081e);
            }
            TroopMemberApiService.this.X(164, bundle);
        }

        private void H(Bundle bundle) {
            QQToast.makeText(((AppService) TroopMemberApiService.this).app.getApplicationContext(), "\u62b1\u6b49\uff0c\u56fe\u6587\u53d1\u8868\u529f\u80fd\u5df2\u4e0b\u67b6", 1).show();
        }

        private void I() {
            ((IBusManager) QRoute.api(IBusManager.class)).sendEvent(new com.tencent.mobileqq.troop.addsource.c());
        }

        private void J(int i3, Bundle bundle, int i16, String str) {
            bundle.putInt(QzoneIPCModule.RESULT_CODE, i16);
            bundle.putString("resultMsg", str);
            TroopMemberApiService.this.X(i3, bundle);
        }

        private void k(Bundle bundle) {
            bundle.putString("iid", ((IReadInJoyUtils) QRoute.api(IReadInJoyUtils.class)).getEncryptUin());
            J(159, bundle, 0, "success");
        }

        private void l(final Bundle bundle) throws JSONException {
            final int i3;
            JSONObject jSONObject = new JSONObject(bundle.getString("troopAvatarData"));
            final JSONArray optJSONArray = jSONObject.optJSONArray(SquareJSConst.Params.PARAMS_UIN_LIST);
            if ("1".equals(jSONObject.getString("avatarType"))) {
                i3 = 4;
            } else {
                i3 = 1;
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.troop.TroopMemberApiService.IncomingHandler.9

                /* compiled from: P */
                /* renamed from: com.tencent.biz.troop.TroopMemberApiService$IncomingHandler$9$a */
                /* loaded from: classes5.dex */
                class a implements com.tencent.mobileqq.troop.api.b {
                    a() {
                    }

                    @Override // com.tencent.mobileqq.troop.api.b
                    public void a(@NonNull String str, @NonNull Bitmap bitmap) {
                        bundle.putString("troopUin", str);
                        bundle.putParcelable("troopAvatar", bitmap);
                        AnonymousClass9 anonymousClass9 = AnonymousClass9.this;
                        TroopMemberApiService.this.X(171, bundle);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (optJSONArray != null) {
                        for (int i16 = 0; i16 < optJSONArray.length(); i16++) {
                            ((ITroopAvatarLoaderApi) QRoute.api(ITroopAvatarLoaderApi.class)).loadAvatar(((AppService) TroopMemberApiService.this).app.getApp(), i3, optJSONArray.optString(i16), new a());
                        }
                    }
                }
            }, 16, null, false);
        }

        private String m(String str) {
            TroopInfo k3;
            TroopManager troopManager = (TroopManager) ((AppService) TroopMemberApiService.this).app.getManager(QQManagerFactory.TROOP_MANAGER);
            if (troopManager != null && (k3 = troopManager.k(str)) != null) {
                return k3.troopname;
            }
            return "";
        }

        private void n(Bundle bundle) {
            try {
                JSONObject jSONObject = new JSONObject(bundle.getString("openTroopQRPageData"));
                String optString = jSONObject.optString("troop_uin");
                Intent intent = new Intent();
                intent.putExtra("troopUin", optString);
                intent.putExtra("troopName", m(optString));
                intent.putExtra("source", String.valueOf(jSONObject.optJSONObject("source")));
                intent.setFlags(268435456);
                QPublicFragmentActivity.b.b(BaseApplication.getContext(), intent, QPublicFragmentActivity.class, ((ITroopManagerFragmentApi) QRoute.api(ITroopManagerFragmentApi.class)).getTroopJumpQRPageFragmentClass());
            } catch (Exception e16) {
                QLog.d("TroopMemberApiService", 1, "gotoTroopQRCodeActivity NullPointerException ", e16);
            }
        }

        private void o(Bundle bundle) {
            String str;
            String str2;
            QQAppInterface qQAppInterface = (QQAppInterface) ((AppService) TroopMemberApiService.this).app;
            String str3 = "";
            RespondQueryQQBindingStat selfBindInfo = ((IPhoneContactService) ((AppService) TroopMemberApiService.this).app.getRuntimeService(IPhoneContactService.class, "")).getSelfBindInfo();
            if (selfBindInfo == null) {
                str = "";
            } else {
                str = selfBindInfo.mobileNo;
            }
            String currentNickname = qQAppInterface.getCurrentNickname();
            String decodeString = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations").decodeString("cur_city", null);
            if (decodeString != null) {
                String[] split = decodeString.split("-");
                if (split.length > 0) {
                    String str4 = split[0];
                    if (split.length >= 2) {
                        str3 = split[1];
                    }
                    str2 = str3;
                    str3 = str4;
                    bundle.putString("phone", str);
                    bundle.putString("name", currentNickname);
                    bundle.putString("city", str3);
                    bundle.putString(GdtGetUserInfoHandler.KEY_AREA, str2);
                }
            }
            str2 = "";
            bundle.putString("phone", str);
            bundle.putString("name", currentNickname);
            bundle.putString("city", str3);
            bundle.putString(GdtGetUserInfoHandler.KEY_AREA, str2);
        }

        private void p(Bundle bundle) {
            JSONObject jSONObject;
            String string = bundle.getString("ALD_CONFIG_RESULT");
            try {
                jSONObject = new JSONObject(string);
            } catch (JSONException unused) {
                if (QLog.isColorLevel()) {
                    QLog.e("TroopMemberApiService", 2, "handleGetALDConfig result parse error.");
                }
                jSONObject = null;
            }
            if (string != null && jSONObject != null) {
                bundle.putString("ALD_CONFIG_RESULT", "");
                TroopMemberApiService.this.X(151, bundle);
            }
        }

        private void q(Bundle bundle) {
            Intent intent = new Intent();
            intent.putExtra("seq", bundle.getInt("seq"));
            intent.putExtra("processName", bundle.getString("processName"));
            intent.addFlags(268435456);
            intent.putExtra("troop_uin", bundle.getString("troop_uin"));
            intent.putExtra("troopUinList", bundle.getString("troopUinList"));
            intent.putExtra(WinkDaTongReportConstant.ElementParamKey.XSJ_USER_FROM, bundle.getString(WinkDaTongReportConstant.ElementParamKey.XSJ_USER_FROM));
            if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("106087", true)) {
                QPublicFragmentActivity.start(BaseApplication.getContext(), intent, TroopJoinTypeFragment.class);
            } else {
                QPublicFragmentActivity.start(BaseApplication.getContext(), intent, TroopSetJoinTypeActivity.class);
            }
        }

        private void r(Bundle bundle) {
            boolean z16;
            String string = bundle.getString("groupAutoApproval");
            try {
                if (TextUtils.isEmpty(string)) {
                    QLog.e("TroopMemberApiService", 1, "#handleGroupSpeakFrequencyLimit groupAutoApproval is empty");
                    return;
                }
                JSONObject jSONObject = new JSONObject(string);
                if (jSONObject.optInt("state", 0) == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("groupUinList");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        String optString = optJSONArray.optString(i3);
                        if (!TextUtils.isEmpty(optString)) {
                            ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).updateTroopAutoApproval(optString, z16);
                            SimpleEventBus.getInstance().dispatchEvent(new TroopManageAutoApprovalEvent(optString, z16));
                        }
                    }
                    return;
                }
                QLog.e("TroopMemberApiService", 1, "#handleGroupSpeakFrequencyLimit groupInfoArray is empty");
            } catch (JSONException unused) {
                QLog.e("TroopMemberApiService", 1, "#handleGroupAutoApproval json fail");
            }
        }

        private void s(final Bundle bundle) {
            ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).getCreatedTroopListAsync(true, new Consumer() { // from class: com.tencent.biz.troop.m
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    TroopMemberApiService.IncomingHandler.this.y(bundle, (List) obj);
                }
            });
        }

        private void t(Bundle bundle) {
            String string = bundle.getString("troopUin");
            if (TextUtils.isEmpty(string)) {
                QLog.e("TroopMemberApiService", 1, "handleGetTroopInfo, troopUin is empty.");
            } else {
                ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).fetchTroopBasicInfo(string, "TroopMemberApiService.handleMsgTroopOpenSetJoinType", null, new f(bundle.getInt("seq"), bundle.getString("processName")));
            }
        }

        private void u(final Bundle bundle) {
            HashMap hashMap;
            String string = bundle.getString("service");
            String string2 = bundle.getString("method");
            String string3 = bundle.getString("refer");
            Serializable serializable = bundle.getSerializable("extData");
            if (serializable instanceof HashMap) {
                hashMap = (HashMap) serializable;
            } else {
                hashMap = null;
            }
            byte[] byteArray = bundle.getByteArray("param");
            ((IReadInJoyHelper) QRoute.api(IReadInJoyHelper.class)).ssoForward(string, string2, byteArray, hashMap, string3, new l52.a() { // from class: com.tencent.biz.troop.l
                @Override // l52.a
                public final void a(boolean z16, int i3, JSONObject jSONObject, tencent.trpcprotocol.b bVar) {
                    TroopMemberApiService.IncomingHandler.this.G(bundle, z16, i3, jSONObject, bVar);
                }
            });
        }

        private void v(Bundle bundle) {
            HashMap hashMap;
            String string = bundle.getString("service");
            String string2 = bundle.getString("method");
            String string3 = bundle.getString("refer");
            Serializable serializable = bundle.getSerializable("extData");
            if (serializable instanceof HashMap) {
                hashMap = (HashMap) serializable;
            } else {
                hashMap = null;
            }
            byte[] byteArray = bundle.getByteArray("param");
            ((TroopTrpcHandler) ((QQAppInterface) ((AppService) TroopMemberApiService.this).app).getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopTrpcHandlerName())).J2(string, string2, byteArray, 0, hashMap, string3, new g(bundle));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void x(List list, Bundle bundle) {
            QLog.i("TroopMemberApiService", 1, "#getGroupListAsOwner: troopInfoList.size= " + list.size());
            JSONObject jSONObject = new JSONObject();
            try {
                try {
                    JSONArray jSONArray = new JSONArray();
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        TroopInfo troopInfo = (TroopInfo) it.next();
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("groupUin", troopInfo.getTroopUin());
                        jSONObject2.put("groupName", troopInfo.getNewTroopNameOrTroopName());
                        jSONObject2.put("groupMemberNum", troopInfo.getMemberNum());
                        jSONArray.mo162put(jSONObject2);
                    }
                    jSONObject.put("groupInfoList", jSONArray);
                } catch (JSONException unused) {
                    QLog.e("TroopMemberApiService", 1, "#getGroupListAsOwner json fail");
                }
            } finally {
                bundle.putString("groupListAsOwner", jSONObject.toString());
                TroopMemberApiService.this.X(172, bundle);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void y(final Bundle bundle, final List list) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.biz.troop.n
                @Override // java.lang.Runnable
                public final void run() {
                    TroopMemberApiService.IncomingHandler.this.x(list, bundle);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit z(Boolean bool, TroopInfo troopInfo) {
            TroopMemberApiService.this.S(bool, troopInfo);
            return null;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to find 'out' block for switch in B:13:0x0073. Please report as an issue. */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v65, types: [java.lang.Object[], java.io.Serializable] */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            boolean z16;
            final Bundle data;
            String string;
            ConcurrentHashMap<String, Messenger> concurrentHashMap;
            String string2;
            ConcurrentHashMap<String, Messenger> concurrentHashMap2;
            com.tencent.mobileqq.leba.entity.n nVar;
            LebaPluginInfo lebaPluginInfo;
            TroopInfo troopInfo;
            TroopInfo k3;
            com.tencent.mobileqq.troop.utils.i iVar;
            ArrayList<String> stringArrayList;
            QQGuildOpenData guildOpenDataFromApp;
            ConcurrentHashMap<String, Messenger> concurrentHashMap3;
            final AppRuntime appRuntime = ((AppService) TroopMemberApiService.this).app;
            if (appRuntime instanceof QQAppInterface) {
                QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
            }
            if (message == null || appRuntime == null || !((z16 = appRuntime instanceof QQAppInterface)) || (data = message.getData()) == null) {
                return;
            }
            data.setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
            r12 = false;
            boolean z17 = false;
            r12 = false;
            r12 = false;
            boolean z18 = false;
            r12 = false;
            r12 = false;
            boolean z19 = false;
            switch (message.what) {
                case 1:
                    TroopMemberApiService.this.f96615e = message.replyTo;
                    Object obj = message.obj;
                    if (obj != null && (string = ((Bundle) obj).getString("processName")) != null && (concurrentHashMap = TroopMemberApiService.this.f96616f) != null) {
                        concurrentHashMap.put(string, message.replyTo);
                    }
                    super.handleMessage(message);
                    return;
                case 2:
                    TroopMemberApiService.this.f96615e = null;
                    Object obj2 = message.obj;
                    if (obj2 != null && (string2 = ((Bundle) obj2).getString("processName")) != null && (concurrentHashMap2 = TroopMemberApiService.this.f96616f) != null) {
                        concurrentHashMap2.remove(string2);
                    }
                    super.handleMessage(message);
                    return;
                case 3:
                case 4:
                case 5:
                case 9:
                case 10:
                case 14:
                case 23:
                case 24:
                case 25:
                case 26:
                case 33:
                case 34:
                case 35:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 46:
                case 47:
                case 48:
                case 55:
                case 60:
                case 61:
                case 62:
                case 63:
                case 66:
                case 68:
                case 71:
                case 73:
                case 76:
                case 77:
                case 79:
                case 81:
                case 87:
                case 88:
                case 89:
                case 93:
                case 94:
                case 95:
                case 96:
                case 97:
                case 98:
                case 99:
                case 100:
                case 101:
                case 102:
                case 104:
                case 105:
                case 106:
                case 107:
                case 108:
                case 110:
                case 111:
                case 114:
                case 115:
                case 117:
                case 120:
                case 121:
                case 122:
                case 124:
                case 126:
                case 127:
                case 128:
                case 129:
                case 130:
                case 131:
                case 132:
                case 133:
                case 134:
                case 135:
                case 136:
                case 137:
                case 141:
                case 150:
                case 154:
                case 155:
                case 156:
                case 160:
                case 162:
                case 165:
                case 175:
                default:
                    super.handleMessage(message);
                    return;
                case 6:
                    TroopMemberApiService.this.f96619m = new ck(appRuntime.getAccount());
                    super.handleMessage(message);
                    return;
                case 7:
                    String string3 = data.getString("gcode");
                    if (!TextUtils.isEmpty(string3)) {
                        TroopMemberApiService.this.V(string3, appRuntime.getAccount());
                    }
                    super.handleMessage(message);
                    return;
                case 8:
                    TroopMemberApiService.this.O().b(appRuntime, data);
                    super.handleMessage(message);
                    return;
                case 11:
                    Bundle bundle = new Bundle();
                    bundle.putInt("seq", data.getInt("seq", -1));
                    String[] stringArray = data.getStringArray("paths");
                    if (z16 && stringArray != null && stringArray.length > 0) {
                        IRedTouchManager iRedTouchManager = (IRedTouchManager) appRuntime.getRuntimeService(IRedTouchManager.class, "");
                        int[] iArr = new int[stringArray.length];
                        int length = stringArray.length;
                        int[] iArr2 = new int[length];
                        for (int i3 = 0; i3 < length; i3++) {
                            BusinessInfoCheckUpdate.AppInfo appInfoByPath = iRedTouchManager.getAppInfoByPath(stringArray[i3]);
                            if (appInfoByPath != null) {
                                iArr[i3] = appInfoByPath.iNewFlag.get();
                                iArr2[i3] = appInfoByPath.type.get();
                            } else {
                                iArr[i3] = 0;
                                iArr2[i3] = -1;
                            }
                        }
                        bundle.putIntArray("iNewFlags", iArr);
                        bundle.putIntArray("types", iArr2);
                    }
                    TroopMemberApiService.this.X(11, bundle);
                    super.handleMessage(message);
                    return;
                case 12:
                    new Bundle().putInt("seq", data.getInt("seq", -1));
                    String string4 = data.getString("path");
                    if (z16) {
                        ((IRedTouchManager) appRuntime.getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick(string4);
                    }
                    super.handleMessage(message);
                    return;
                case 13:
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("method", "changeAnonymousNick");
                    bundle2.putInt("seq", data.getInt("seq", -1));
                    String string5 = data.getString("troopUin");
                    long j3 = data.getLong("bubbleId");
                    int i16 = data.getInt("headId");
                    String string6 = data.getString("nickName");
                    int i17 = data.getInt("expireTime");
                    String string7 = data.getString("rankColor");
                    if (!TextUtils.isEmpty(string5) && !TextUtils.isEmpty(string6)) {
                        com.tencent.biz.anonymous.a.h().o(string5, j3, i16, string6, i17, "", string7);
                        bundle2.putBoolean("result", true);
                    } else {
                        bundle2.putBoolean("result", false);
                    }
                    TroopMemberApiService.this.X(13, bundle2);
                    super.handleMessage(message);
                    return;
                case 15:
                    TroopMemberApiService.this.K(data);
                    super.handleMessage(message);
                    return;
                case 16:
                    if (!TroopMemberApiService.N(appRuntime, new a(data))) {
                        TroopMemberApiService.this.X(16, data);
                    }
                    super.handleMessage(message);
                    return;
                case 17:
                    ILebaHelperService iLebaHelperService = (ILebaHelperService) appRuntime.getRuntimeService(ILebaHelperService.class, ProcessConstant.MULTI);
                    if (iLebaHelperService != null) {
                        iLebaHelperService.setFlagBackFromMgr();
                    } else {
                        QLog.d("TroopMemberApiService", 1, "MSG_LEBA_SEARCH_UPDATE_PLUGIN lebaHelperService == null");
                    }
                    data.putBoolean("result", TroopMemberApiService.this.Z(data.getLong("uiResId"), data.getBoolean("isChecked")));
                    TroopMemberApiService.this.X(17, data);
                    super.handleMessage(message);
                    return;
                case 18:
                    long j16 = data.getLong("uiResId");
                    ILebaHelperService iLebaHelperService2 = (ILebaHelperService) appRuntime.getRuntimeService(ILebaHelperService.class, ProcessConstant.MULTI);
                    if (iLebaHelperService2 != null) {
                        nVar = iLebaHelperService2.getLebaViewItemById(j16);
                    } else {
                        QLog.d("TroopMemberApiService", 1, "MSG_LEBA_SEARCH_GET_PLUGIN_BY_TYPE lebaHelperService == null");
                        nVar = null;
                    }
                    if (nVar != null && (lebaPluginInfo = nVar.f240505b) != null) {
                        data.putString("packageName", lebaPluginInfo.strPkgName);
                        data.putString("imageUrl", nVar.f240505b.strResURL);
                        data.putString("name", nVar.f240505b.strResName);
                        data.putBoolean(com.tencent.mobileqq.msf.core.f0.c.e.h.f248218g, nVar.d());
                        data.putInt("type", 0);
                        data.putBoolean("has", true);
                    } else {
                        data.putBoolean("has", false);
                    }
                    TroopMemberApiService.this.X(18, data);
                    super.handleMessage(message);
                    return;
                case 19:
                    String string8 = data.getString("troopUin");
                    String string9 = data.getString("troopName");
                    data.getInt("troopTypeId");
                    ITroopInfoService iTroopInfoService = (ITroopInfoService) appRuntime.getRuntimeService(ITroopInfoService.class, "");
                    if (iTroopInfoService != null) {
                        troopInfo = iTroopInfoService.findTroopInfo(string8);
                        if (troopInfo == null) {
                            troopInfo = new TroopInfo(string8);
                            troopInfo.markHadJoinTroop();
                            troopInfo.troopname = string9;
                            troopInfo.Administrator = ((QQAppInterface) appRuntime).getCurrentAccountUin();
                            troopInfo.memberRole = MemberRole.OWNER;
                            ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).saveTroopInCache(troopInfo);
                        }
                    } else {
                        troopInfo = null;
                    }
                    ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).fetchTroopBasicInfo(string8, "TroopMemberApiService.MSG_CREATE_TROOP_SUCCESS", null, null);
                    TroopManager troopManager = (TroopManager) appRuntime.getManager(QQManagerFactory.TROOP_MANAGER);
                    if (troopManager != null && troopInfo != null) {
                        troopManager.d(troopInfo);
                    }
                    if (z16) {
                        TroopMemberApiService.this.X(19, data);
                    }
                    super.handleMessage(message);
                    return;
                case 20:
                    if (z16) {
                        long j17 = data.getLong(IProfileProtocolConst.PARAM_TROOP_CODE);
                        QQAppInterface qQAppInterface2 = (QQAppInterface) appRuntime;
                        t k16 = TroopFileUtils.k(qQAppInterface2, j17, null, data.getString("filePath"), data.getString(WadlProxyConsts.PARAM_FILENAME), data.getLong("fileSize"), data.getInt("busid"));
                        Bundle bundle3 = new Bundle();
                        bundle3.putInt("seq", data.getInt("seq", -1));
                        if (!TextUtils.isEmpty(data.getString("callback"))) {
                            bundle3.putString("callback", data.getString("callback"));
                        }
                        bundle3.putString("method", "getFileInfo");
                        bundle3.putString("processName", data.getString("processName"));
                        TroopMemberApiService.this.M(qQAppInterface2, j17, HWTroopFileStatusInfo.parse(k16), bundle3);
                    }
                    super.handleMessage(message);
                    return;
                case 21:
                    if (z16) {
                        TroopMemberApiService troopMemberApiService = TroopMemberApiService.this;
                        if (troopMemberApiService.U == null) {
                            troopMemberApiService.U = (IPublicAccountH5Manager) QRoute.api(IPublicAccountH5Manager.class);
                            TroopMemberApiService troopMemberApiService2 = TroopMemberApiService.this;
                            troopMemberApiService2.U.init(troopMemberApiService2, (QQAppInterface) appRuntime);
                        }
                        if (data.getBoolean(IPublicAccountH5AbilityPlugin.ISPICORVOICE)) {
                            TroopMemberApiService.this.U.startUploadPic(data);
                        } else {
                            TroopMemberApiService.this.U.uploadPtt(data);
                        }
                    }
                    super.handleMessage(message);
                    return;
                case 22:
                    if (z16) {
                        TroopMemberApiService troopMemberApiService3 = TroopMemberApiService.this;
                        if (troopMemberApiService3.U == null) {
                            troopMemberApiService3.U = (IPublicAccountH5Manager) QRoute.api(IPublicAccountH5Manager.class);
                            TroopMemberApiService troopMemberApiService4 = TroopMemberApiService.this;
                            troopMemberApiService4.U.init(troopMemberApiService4, (QQAppInterface) appRuntime);
                        }
                        if (data.getBoolean(IPublicAccountH5AbilityPlugin.ISPICORVOICE)) {
                            TroopMemberApiService.this.U.startDownloadPic(data);
                        } else {
                            TroopMemberApiService.this.U.downloadPtt(data);
                        }
                    }
                    super.handleMessage(message);
                    return;
                case 27:
                    IPublicAccountH5Manager iPublicAccountH5Manager = TroopMemberApiService.this.U;
                    if (iPublicAccountH5Manager != null) {
                        iPublicAccountH5Manager.cancleAllTask();
                    }
                    super.handleMessage(message);
                    return;
                case 28:
                    ((com.tencent.mobileqq.troop.api.handler.j) ((QQAppInterface) appRuntime).getBusinessHandler(BusinessHandlerFactory.TROOP_TOKEN_HANDLER)).e0(data.getInt("appid"), data.getString("openGroupId"), data.getString("token"), data.getString("url"), data.getInt("seq"));
                    super.handleMessage(message);
                    return;
                case 29:
                    String string10 = data.getString("troopUin");
                    String string11 = data.getString("memberUin");
                    int i18 = data.getInt("titleId");
                    if (((TroopManager) appRuntime.getManager(QQManagerFactory.TROOP_MANAGER)) != null && i18 > 0) {
                        ((ITroopMemberExtInfoRepoApi) QRoute.api(ITroopMemberExtInfoRepoApi.class)).updateTroopMemberSpecialTitle(string10, string11, i18);
                        ((QQAppInterface) appRuntime).getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_INFO_HANDLER).notifyUI(com.tencent.mobileqq.troop.api.observer.e.TYPE_NOTIFY_TROOP_RANK_TITLE_UPDATE, true, new Object[]{string10, string11, Integer.valueOf(i18)});
                    }
                    super.handleMessage(message);
                    return;
                case 30:
                    ((ITroopAppService) appRuntime.getRuntimeService(ITroopAppService.class, "all")).setAppListChangedFromWebOperate(data.getBoolean("isTroopAppListChanged"));
                    super.handleMessage(message);
                    return;
                case 31:
                    String string12 = data.getString("troopUin");
                    String string13 = data.getString("opn");
                    if (!TextUtils.isEmpty(string13) && !TextUtils.isEmpty(string12)) {
                        if (string13.equals("g_homework")) {
                            String str = TroopFileUtils.a((QQAppInterface) appRuntime, Long.parseLong(string12)) ? "role=teacher&" : "";
                            Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) QQBrowserActivity.class);
                            intent.putExtra("url", "https://qun.qq.com/homework/features/index.html?_wv=1027&_bid=2146#" + str + "gid=" + string12 + "&src=0");
                            intent.setFlags(268435456);
                            TroopMemberApiService.this.startActivity(intent);
                        } else if (string13.equals("g_troop_reward")) {
                            az.g((QQAppInterface) appRuntime, TroopMemberApiService.this, string12, true);
                        }
                    }
                    super.handleMessage(message);
                    return;
                case 32:
                    ((com.tencent.mobileqq.intervideo.od.d) ((QQAppInterface) appRuntime).getManager(QQManagerFactory.ODPROXY_MGR)).b(TroopMemberApiService.this, data.getLong("roomid", 0L), data.getString("roomname"), data.getString("vasname"), data.getString("userdata"), data.getInt("fromid", 0));
                    super.handleMessage(message);
                    return;
                case 36:
                    String string14 = data.getString("troopUin");
                    ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).fetchTroopBasicInfo(string14, "TroopMemberApiService.MSG_GET_GROUP_INFO_REQ", null, new Function2() { // from class: com.tencent.biz.troop.e
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj3, Object obj4) {
                            Unit z26;
                            z26 = TroopMemberApiService.IncomingHandler.this.z((Boolean) obj3, (TroopInfo) obj4);
                            return z26;
                        }
                    });
                    if (QLog.isDevelopLevel()) {
                        QLog.i("TroopMngTest", 4, String.format("MSG_GET_GROUP_INFO_REQ [%s]", string14));
                    }
                    super.handleMessage(message);
                    return;
                case 42:
                    TroopMemberApiService.this.E = data.getInt("appId");
                    TroopMemberApiService.this.F = data.getInt("seq");
                    if (TroopMemberApiService.this.E != 0) {
                        ITroopAppService iTroopAppService = (ITroopAppService) appRuntime.getRuntimeService(ITroopAppService.class, "all");
                        ArrayList<Integer> arrayList = new ArrayList<>();
                        if (iTroopAppService.isCheckedUpdateAfterLogined(0) && !iTroopAppService.getAppListChangedFromWebOperate(0)) {
                            List<TroopAIOAppInfo> troopAppList = iTroopAppService.getTroopAppList(false, 0);
                            if (troopAppList != null && !troopAppList.isEmpty()) {
                                for (TroopAIOAppInfo troopAIOAppInfo : troopAppList) {
                                    arrayList.add(Integer.valueOf(troopAIOAppInfo.appid));
                                    if (troopAIOAppInfo.appid == TroopMemberApiService.this.E) {
                                        QQToast.makeText(BaseApplication.getContext(), 2, R.string.f173223i52, 0).show(TroopMemberApiService.this.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                                        return;
                                    }
                                }
                            }
                            arrayList.add(Integer.valueOf(TroopMemberApiService.this.E));
                            ArrayList<Integer> arrayList2 = new ArrayList<>();
                            arrayList2.add(Integer.valueOf(TroopMemberApiService.this.E));
                            iTroopAppService.addTroopApp(arrayList, arrayList2);
                        } else {
                            TroopMemberApiService.this.G = true;
                            iTroopAppService.getTroopAppList(true, 0);
                        }
                    }
                    super.handleMessage(message);
                    return;
                case 43:
                    try {
                        long j18 = data.getLong("troopPubAccountUin");
                        long[] longArray = data.getLongArray("troopUinList");
                        if (longArray != null && longArray.length > 0) {
                            ITroopInfoService iTroopInfoService2 = (ITroopInfoService) appRuntime.getRuntimeService(ITroopInfoService.class, "");
                            for (long j19 : longArray) {
                                TroopInfo findTroopInfo = iTroopInfoService2.findTroopInfo(j19 + "");
                                if (findTroopInfo != null) {
                                    ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).updateAssociatePubAccount(findTroopInfo.troopuin, j18);
                                }
                            }
                        }
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e(PublicAccountDetailActivityImpl.TAG_TROOP, 2, "updateTroopBindedPubAccount:" + e16.toString());
                        }
                    }
                    super.handleMessage(message);
                    return;
                case 44:
                    String string15 = data.getString("troopUin");
                    TroopManager troopManager2 = (TroopManager) appRuntime.getManager(QQManagerFactory.TROOP_MANAGER);
                    if (troopManager2 != null && (k3 = troopManager2.k(string15)) != null && k3.hasOrgs()) {
                        z19 = true;
                    }
                    data.putBoolean("hasOrgs", z19);
                    TroopMemberApiService.this.X(44, data);
                    super.handleMessage(message);
                    return;
                case 45:
                    com.tencent.mobileqq.troop.utils.d.b(TroopMemberApiService.this, data.getString("localFilePath"), data.getString("fileDisPlayName"));
                    super.handleMessage(message);
                    return;
                case 49:
                    final long j26 = data.getLong("troopUin");
                    ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).fetchTroopInfoForJoinTroop(String.valueOf(j26), "TroopMemberApiService", null, data.getBoolean("needPrivilege", false), new Function2() { // from class: com.tencent.biz.troop.f
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj3, Object obj4) {
                            Unit A;
                            A = TroopMemberApiService.IncomingHandler.this.A(j26, (Boolean) obj3, (TroopInfo) obj4);
                            return A;
                        }
                    });
                    super.handleMessage(message);
                    return;
                case 50:
                    data.putInt("fontSize", QQAppInterface.curBrowserFontSizeIndex);
                    TroopMemberApiService.this.X(50, data);
                    super.handleMessage(message);
                    return;
                case 51:
                    final int i19 = data.getInt("fontSize", 1);
                    QQAppInterface.curBrowserFontSizeIndex = i19;
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.troop.g
                        @Override // java.lang.Runnable
                        public final void run() {
                            TroopMemberApiService.IncomingHandler.this.B(i19);
                        }
                    }, 32, null, true);
                    super.handleMessage(message);
                    return;
                case 52:
                    String string16 = data.getString("troopUin");
                    int i26 = data.getInt("rewardMoney");
                    String string17 = data.getString("rewardContent");
                    String string18 = data.getString("mediaPath");
                    int i27 = data.getInt("rewardType");
                    az.f302096e = data.getInt("imageMaxWidthPixels", 1080);
                    az.f302097f = data.getInt("imageMaxHeightPixels", 1920);
                    ((az) appRuntime.getManager(QQManagerFactory.TROOP_REWARD_MGR)).f(string16, i26, string17, string18, i27);
                    super.handleMessage(message);
                    return;
                case 53:
                    MessageForTroopReward d16 = ((az) appRuntime.getManager(QQManagerFactory.TROOP_REWARD_MGR)).d(data.getString("troopUin"), data.getString("rewardId"));
                    data.putString("videoPath", d16 != null ? d16.mediaPath : "");
                    TroopMemberApiService.this.X(53, data);
                    super.handleMessage(message);
                    return;
                case 54:
                    TroopFileTransferManager.O((QQAppInterface) appRuntime, Long.parseLong(data.getString("troopUin"))).x0(data.getString("largeImageFile"), data.getString(WadlProxyConsts.PARAM_FILENAME), data.getLong("progressTotal"), data.getInt("busId"), null);
                    super.handleMessage(message);
                    return;
                case 56:
                    TroopFileTransferManager.O((QQAppInterface) appRuntime, Long.parseLong(data.getString("troopUin"))).C(data.getString("filePath"), data.getString(WadlProxyConsts.PARAM_FILENAME), data.getInt("busId"), data.getInt("size"), null);
                    super.handleMessage(message);
                    return;
                case 57:
                    t(data);
                    super.handleMessage(message);
                    return;
                case 58:
                    ((com.tencent.mobileqq.troop.api.handler.j) ((QQAppInterface) appRuntime).getBusinessHandler(BusinessHandlerFactory.TROOP_TOKEN_HANDLER)).F1(data.getInt("appid"), data.getString("openId"), data.getString("token"), data.getInt("seq"));
                    super.handleMessage(message);
                    return;
                case 59:
                    TroopMemberApiService.this.L(data.getString("pkgname"), data.getString("appid"));
                    super.handleMessage(message);
                    return;
                case 64:
                    data.putByteArray("decryptResult", PreloadManager.s().A(data.getString("hashName")));
                    TroopMemberApiService.this.X(64, data);
                    super.handleMessage(message);
                    return;
                case 65:
                    ((IHuayangOpenHelper) QRoute.api(IHuayangOpenHelper.class)).open((QQAppInterface) appRuntime, data.getString("appType"), data.getString("openType"), data.getString(LayoutAttrDefine.CLICK_URI), "web", data.getString("action"), data.getString("pluginPackageName"), data.getString("pluginParams"));
                    super.handleMessage(message);
                    return;
                case 67:
                    final String string19 = data.getString("troopUin");
                    ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).joinGroup(new JoinTroopParam(string19, data.getInt("statOption"), data.getString("authKey"), data.getString("authSig")), null, "TroopMemberApiService", new com.tencent.qqnt.troop.d() { // from class: com.tencent.biz.troop.h
                        @Override // com.tencent.qqnt.troop.d
                        public final void a(boolean z26, int i28, String str2, com.tencent.qqnt.bean.c cVar) {
                            TroopMemberApiService.IncomingHandler.this.C(string19, z26, i28, str2, cVar);
                        }
                    });
                    super.handleMessage(message);
                    return;
                case 69:
                    ((IFactoryApi) QRoute.api(IFactoryApi.class)).getHuaYangDownLoadHelper((QQAppInterface) appRuntime, data.getString("pluginPackageName"), data.getString("appType")).canceLauncher();
                    super.handleMessage(message);
                    return;
                case 70:
                    final String string20 = data.getString("groupCode");
                    final String string21 = data.getString("groupMemberUin");
                    final int i28 = data.getInt("seq");
                    ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.troop.TroopMemberApiService.IncomingHandler.2
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageRecord robotLastSpeakMessage;
                            if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("robot_last_speak_message_9130", false) && (robotLastSpeakMessage = ((IBizTroopMemberInfoService) appRuntime.getRuntimeService(IBizTroopMemberInfoService.class, "")).getRobotLastSpeakMessage(string20, string21)) != null) {
                                data.putLong("lastMsgTime", robotLastSpeakMessage.time);
                                data.putString("lastMsgContent", robotLastSpeakMessage.f203106msg);
                                data.putInt("seq", i28);
                                TroopMemberApiService.this.X(70, data);
                                return;
                            }
                            data.putLong("lastMsgTime", 0L);
                            data.putString("lastMsgContent", "");
                            data.putInt("seq", i28);
                            TroopMemberApiService.this.X(70, data);
                        }
                    }, 8, null, true);
                    super.handleMessage(message);
                    return;
                case 72:
                    String string22 = data.getString("schoolName");
                    int i29 = data.getInt(AppConstants.Key.COLUMN_IS_VALID);
                    l92.a aVar = (l92.a) ((QQAppInterface) appRuntime).getBusinessHandler(BusinessHandlerFactory.NEARBY_CARD_HANDLER);
                    if (aVar != null) {
                        aVar.F0(string22, i29);
                    }
                    super.handleMessage(message);
                    return;
                case 74:
                    Bundle bundle4 = new Bundle();
                    bundle4.putInt("seq", data.getInt("seq", -1));
                    if (z16 && (iVar = (com.tencent.mobileqq.troop.utils.i) appRuntime.getManager(QQManagerFactory.NEARBY_VIDEO_CHAT)) != null) {
                        String a16 = iVar.a();
                        String c16 = iVar.c();
                        bundle4.putString("nearbyVideoConfig", a16);
                        bundle4.putString("title", c16);
                    }
                    TroopMemberApiService.this.X(74, bundle4);
                    super.handleMessage(message);
                    return;
                case 75:
                    if (z16) {
                        boolean j27 = com.tencent.mobileqq.shortvideo.util.f.j((QQAppInterface) appRuntime, BaseApplication.getContext());
                        if (QLog.isColorLevel()) {
                            QLog.e("TroopMemberApiService", 2, "isPtvFilterDownloadOK:" + j27);
                        }
                    }
                    super.handleMessage(message);
                    return;
                case 78:
                    data.putInt("currentFragment", SplashActivity.currentFragment);
                    v61.a b16 = v61.b.a().b();
                    if (b16 != null && b16.d()) {
                        data.putBoolean("KEY_OPEN_MINI_CHAT", true);
                    }
                    TroopMemberApiService.this.X(78, data);
                    super.handleMessage(message);
                    return;
                case 80:
                    n62.a aVar2 = (n62.a) appRuntime.getManager(QQManagerFactory.READINJOY_VIDEO_UPLOAD_MANAGER);
                    aVar2.b(TroopMemberApiService.this);
                    aVar2.a(data.getString("videoPath"), data);
                    super.handleMessage(message);
                    return;
                case 82:
                    Bundle bundle5 = new Bundle();
                    bundle5.putInt("seq", data.getInt("seq", -1));
                    if (z16) {
                        QQAppInterface qQAppInterface3 = (QQAppInterface) appRuntime;
                        if (qQAppInterface3.isVideoChatting() && !qQAppInterface3.getAVNotifyCenter().c0()) {
                            z18 = true;
                        }
                    }
                    bundle5.putBoolean("isOtherTypeChatting", z18);
                    TroopMemberApiService.this.X(82, bundle5);
                    super.handleMessage(message);
                    return;
                case 83:
                    int i36 = data.getInt("subCmd");
                    ITroopEnterEffectService iTroopEnterEffectService = (ITroopEnterEffectService) appRuntime.getRuntimeService(ITroopEnterEffectService.class, "all");
                    if (i36 == 1) {
                        int i37 = data.getInt("effectId");
                        ArrayList<Integer> integerArrayList = data.getIntegerArrayList("groupCodeList");
                        String string23 = data.getString("effectName");
                        int i38 = data.getInt("svipLevel");
                        int i39 = data.getInt("svipType");
                        if (integerArrayList.size() == 0) {
                            iTroopEnterEffectService.updateGlobalEffectInfo(i37, string23, i38, i39);
                        } else {
                            Iterator<Integer> it = integerArrayList.iterator();
                            while (it.hasNext()) {
                                iTroopEnterEffectService.updateEffectInfo(it.next().intValue(), i37, string23, i38, i39);
                            }
                        }
                    } else if (i36 == 2 && (stringArrayList = data.getStringArrayList("statusList")) != null) {
                        iTroopEnterEffectService.updateEffectStatus(stringArrayList);
                    }
                    TroopMemberApiService.this.X(85, data);
                    super.handleMessage(message);
                    return;
                case 84:
                    Bundle bundle6 = new Bundle();
                    bundle6.putInt("seq", data.getInt("seq", -1));
                    com.tencent.mobileqq.vip.h u16 = ((DownloaderFactory) appRuntime.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).u(1);
                    File file = new File(com.tencent.mobileqq.nearby.e.f252585l + File.separator + "nearby_heart.mp4");
                    if (!file.exists()) {
                        file.mkdirs();
                    } else {
                        file.delete();
                    }
                    u16.startDownload(new com.tencent.mobileqq.vip.g("https://pub.idqqimg.com/pc/misc/nearby/nearby_heart.gif", file), new b(bundle6), new Bundle());
                    super.handleMessage(message);
                    return;
                case 85:
                    String string24 = data.getString("troopUin");
                    String string25 = data.getString("path");
                    int i46 = data.getInt("msgTailType", 0);
                    Intent intent2 = new Intent();
                    intent2.putExtra(PeakConstants.SEND_IN_BACKGROUND, true);
                    intent2.putExtra("file_send_path", string25);
                    intent2.putExtra(ShortVideoConstants.FILE_SEND_SIZE, new File(string25).length());
                    intent2.putExtra(ShortVideoConstants.FILE_SEND_DURATION, ShortVideoUtils.getDurationOfVideo(string25));
                    intent2.putExtra("uin", string24);
                    intent2.putExtra("uintype", 1);
                    intent2.putExtra(ShortVideoConstants.FILE_SOURCE, ShortVideoConstants.FILE_SOURCE_ALBUM_FLOW);
                    intent2.putExtra(ShortVideoConstants.MSG_TAIL_TYPE, i46);
                    new com.tencent.mobileqq.activity.shortvideo.i(intent2).execute(new Void[0]);
                    TroopMemberApiService.this.X(85, data);
                    super.handleMessage(message);
                    return;
                case 86:
                    long j28 = data.getLong("roomId");
                    Bundle bundle7 = new Bundle();
                    bundle7.putInt("jumpType", 1);
                    bundle7.putString("roomid", String.valueOf(j28));
                    ((com.tencent.mobileqq.intervideo.now.dynamic.b) appRuntime.getManager(QQManagerFactory.NOW_DYNAMIC_MANAGER)).c(bundle7);
                    super.handleMessage(message);
                    return;
                case 90:
                    ((com.tencent.mobileqq.intervideo.now.dynamic.b) appRuntime.getManager(QQManagerFactory.NOW_DYNAMIC_MANAGER)).b(data);
                    super.handleMessage(message);
                    return;
                case 91:
                    TroopMemberApiService troopMemberApiService5 = TroopMemberApiService.this;
                    if (troopMemberApiService5.I) {
                        return;
                    }
                    troopMemberApiService5.I = true;
                    boolean isNetworkAvailable = NetworkUtil.isNetworkAvailable(null);
                    VideoEnvironment.LogDownLoad("TroopMemberApiService", "startDownloadConfig netUsable=" + isNetworkAvailable, null);
                    if (isNetworkAvailable) {
                        VideoEnvironment.LogDownLoad("TroopMemberApiService", HardCodeUtil.qqStr(R.string.un7), null);
                        ShortVideoResourceManager.M((QQAppInterface) appRuntime, new c(appRuntime, data));
                    } else {
                        data.putInt("result", -1);
                        TroopMemberApiService.this.X(91, data);
                    }
                    super.handleMessage(message);
                    return;
                case 92:
                    ((com.tencent.mobileqq.intervideo.groupvideo.h) appRuntime.getManager(QQManagerFactory.GROUP_VIDEO_PLUGIN_MANAGER)).e(TroopMemberApiService.this, data.getString("roomId"), ((QQAppInterface) appRuntime).getCurrentAccountUin(), data.getInt("isGroupCode"), data.getString("action"), data.getString("fromId"), data.getString("backType"), data.getString("openType"), data.getString("extra"));
                    super.handleMessage(message);
                    return;
                case 103:
                    ((ITroopAppService) appRuntime.getRuntimeService(ITroopAppService.class, "all")).setProfileAppListChangedFromWebOperate(data.getBoolean("isTroopProfileAppListChanged"), data.getString("profileAppListChangedTroopUin"));
                    super.handleMessage(message);
                    return;
                case 109:
                    TroopMemberApiService.this.J = data.getString("callback");
                    TroopMemberApiService.this.K = data.getInt("seq");
                    String string26 = data.getString("troopUin");
                    String string27 = data.getString("chatType");
                    if (!TextUtils.isEmpty(string26) && VipFunCallConstants.KEY_GROUP.equals(string27)) {
                        ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).fetchTroopBasicInfoWithExt(string26, "TroopMemberApiService.MSG_TROOP_CREATE", null, new Function2() { // from class: com.tencent.biz.troop.i
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj3, Object obj4) {
                                Unit D;
                                D = TroopMemberApiService.IncomingHandler.this.D(appRuntime, (Boolean) obj3, (TroopInfo) obj4);
                                return D;
                            }
                        });
                    } else if (!TextUtils.isEmpty(string26) && "groupPro".equals(string27)) {
                        String string28 = data.getString("packageId");
                        new Bundle();
                        if (!TextUtils.isEmpty(string28) && (guildOpenDataFromApp = ((IGuildOpenApi) appRuntime.getRuntimeService(IGuildOpenApi.class, "")).getGuildOpenDataFromApp(string28)) != null) {
                            Bundle bundle8 = new Bundle();
                            bundle8.putString(AppConstants.Key.GUILD_FROM, "guildOpenCreate");
                            bundle8.putString(AppConstants.Key.GUILD_FROM_APP_NAME, guildOpenDataFromApp.appName);
                        }
                        String string29 = data.getString("appChannel");
                        Context context = BaseActivity.sTopActivity;
                        if (context == null) {
                            context = TroopMemberApiService.this.getApplicationContext();
                        }
                        JumpGuildParam jumpGuildParam = new JumpGuildParam(string26, "");
                        jumpGuildParam.extras.putString("PGIN_SOURCE_REPORT_KEY", string29);
                        ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).gotoConversationGuild(context, jumpGuildParam);
                    } else {
                        QLog.i("TroopMemberApiService", 1, "notifyTroopCreate error none");
                        Bundle bundle9 = new Bundle();
                        bundle9.putBoolean("isSuccess", false);
                        bundle9.putInt("seq", TroopMemberApiService.this.K);
                        bundle9.putString("callback", TroopMemberApiService.this.J);
                        TroopMemberApiService.this.X(110, bundle9);
                    }
                    super.handleMessage(message);
                    return;
                case 112:
                    QQAppInterface qQAppInterface4 = (QQAppInterface) appRuntime;
                    Intent aliasIntent = SplashActivity.getAliasIntent(qQAppInterface4.getApp().getApplicationContext());
                    aliasIntent.putExtras(data);
                    Intent m3 = BaseAIOUtils.m(aliasIntent, null);
                    ForwardUtils.p(qQAppInterface4, qQAppInterface4.getApp().getApplicationContext(), ForwardUtils.n0(m3), m3);
                    super.handleMessage(message);
                    return;
                case 113:
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopMemberApiService", 2, "MSG_HOMEWORK_TROOP_CLEAR_RED_POINT");
                    }
                    String string30 = data.getString("troopUin");
                    String string31 = data.getString("type");
                    if (!TextUtils.isEmpty(string30) && String.valueOf(1104445552).equals(string31)) {
                        QQAppInterface qQAppInterface5 = (QQAppInterface) appRuntime;
                        if (((IHWTroopUtilsApi) QRoute.api(IHWTroopUtilsApi.class)).getAIOHomeworkBtnRedPoint(qQAppInterface5, string30) != 0) {
                            ((IHWTroopUtilsApi) QRoute.api(IHWTroopUtilsApi.class)).clearHomeworkTroopRedPoint(qQAppInterface5, string30);
                        }
                    }
                    super.handleMessage(message);
                    return;
                case 116:
                    int i47 = data.getInt("seq");
                    TroopMemberApiService troopMemberApiService6 = TroopMemberApiService.this;
                    if (troopMemberApiService6.L == null) {
                        troopMemberApiService6.L = new com.tencent.mobileqq.Doraemon.g();
                    }
                    Messenger messenger = TroopMemberApiService.this.f96615e;
                    String string32 = data.getString("processName");
                    if (string32 != null && (concurrentHashMap3 = TroopMemberApiService.this.f96616f) != null && concurrentHashMap3.get(string32) != null) {
                        messenger = TroopMemberApiService.this.f96616f.get(string32);
                    }
                    TroopMemberApiService.this.L.a(116, data, i47, messenger);
                    super.handleMessage(message);
                    return;
                case 118:
                    final int i48 = data.getInt("seq");
                    final String string33 = data.getString("processName");
                    URLCheckParams uRLCheckParams = (URLCheckParams) data.getParcelable("param");
                    com.tencent.mobileqq.webview.f fVar = (com.tencent.mobileqq.webview.f) appRuntime.getManager(QQManagerFactory.URL_SECURITY_CHECK_MANAGER);
                    if (fVar != null) {
                        fVar.d(uRLCheckParams, new f.InterfaceC8971f() { // from class: com.tencent.biz.troop.j
                            @Override // com.tencent.mobileqq.webview.f.InterfaceC8971f
                            public final void onResult(Bundle bundle10) {
                                TroopMemberApiService.IncomingHandler.this.E(i48, string33, bundle10);
                            }
                        });
                    } else {
                        Bundle bundle10 = new Bundle();
                        bundle10.putInt("seq", i48);
                        bundle10.putString("processName", string33);
                        TroopMemberApiService.this.X(118, bundle10);
                    }
                    super.handleMessage(message);
                    return;
                case 119:
                    String string34 = data.getString("content");
                    int i49 = data.getInt("seq");
                    DataLineHandler dataLineHandler = (DataLineHandler) ((QQAppInterface) appRuntime).getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
                    if (dataLineHandler != null && dataLineHandler.X2(string34, 0).longValue() > 0) {
                        z17 = true;
                    }
                    Bundle bundle11 = new Bundle();
                    bundle11.putBoolean("isSuccess", z17);
                    bundle11.putInt("seq", i49);
                    TroopMemberApiService.this.X(119, bundle11);
                    super.handleMessage(message);
                    return;
                case 123:
                    int i56 = data.getInt("seq");
                    QQAppInterface qQAppInterface6 = (QQAppInterface) appRuntime;
                    Card r16 = ((FriendsManager) appRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER)).r(qQAppInterface6.getCurrentUin());
                    if (r16 != null) {
                        if (QLog.isColorLevel()) {
                            QLog.d("TroopMemberApiService", 2, "get user gender:" + ((int) r16.shGender));
                        }
                        data.putShort("gender", r16.shGender);
                    }
                    data.putString("facePath", qQAppInterface6.getCustomFaceFilePath(1, qQAppInterface6.getCurrentAccountUin(), 0));
                    data.putInt("seq", i56);
                    TroopMemberApiService.this.X(123, data);
                    super.handleMessage(message);
                    return;
                case 125:
                    data.putString("nickName", ((QQAppInterface) appRuntime).getCurrentNickname());
                    TroopMemberApiService.this.X(125, data);
                    super.handleMessage(message);
                    return;
                case 138:
                    o(data);
                    TroopMemberApiService.this.X(138, data);
                    super.handleMessage(message);
                    return;
                case 139:
                    try {
                        com.tencent.mobileqq.webview.f fVar2 = (com.tencent.mobileqq.webview.f) appRuntime.getManager(QQManagerFactory.URL_SECURITY_CHECK_MANAGER);
                        if (fVar2 != null) {
                            fVar2.i(data);
                        } else if (QLog.isColorLevel()) {
                            QLog.d("TroopMemberApiService", 2, "report passwd forbid fail");
                        }
                    } catch (Throwable th5) {
                        QLog.e("TroopMemberApiService", 2, th5, new Object[0]);
                    }
                    super.handleMessage(message);
                    return;
                case 140:
                    com.tencent.biz.subscribe.utils.j.g(BaseApplication.getContext(), data.getString("uin"), null);
                    super.handleMessage(message);
                    return;
                case 142:
                    boolean z26 = data.getBoolean(com.tencent.mobileqq.msf.core.f0.c.e.h.f248218g);
                    String string35 = data.getString("troopUin");
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopHonor.jsapi", 2, String.format("switch troop honor aio, troopUin: %s, isOpen: %s", string35, Boolean.valueOf(z26)));
                    }
                    ((ITroopHonorService) appRuntime.getRuntimeService(ITroopHonorService.class, "")).updateTroopHonorAIOSwitch(string35, z26);
                    super.handleMessage(message);
                    return;
                case 143:
                    com.tencent.mobileqq.webview.f fVar3 = (com.tencent.mobileqq.webview.f) appRuntime.getManager(QQManagerFactory.URL_SECURITY_CHECK_MANAGER);
                    String string36 = data.getString("appid");
                    String string37 = data.getString("openid");
                    String string38 = data.getString("troopuin");
                    int i57 = data.getInt("seq");
                    String string39 = data.getString("processName");
                    if (fVar3 != null) {
                        fVar3.h(string36, string37, string38, new d(i57, string39));
                    } else {
                        Bundle bundle12 = new Bundle();
                        bundle12.putInt("seq", i57);
                        bundle12.putString("processName", string39);
                        bundle12.putInt("result", -1);
                        TroopMemberApiService.this.X(143, bundle12);
                    }
                    super.handleMessage(message);
                    return;
                case 144:
                    TroopMemberApiService.this.P().a(appRuntime, data);
                    super.handleMessage(message);
                    return;
                case 145:
                    String string40 = data.getString("code");
                    String[] strArr = {"0", "0", "0", "0"};
                    try {
                        if (!TextUtils.isEmpty(string40)) {
                            JSONObject jSONObject = new JSONObject(string40);
                            strArr[0] = jSONObject.optString("country", "0");
                            strArr[1] = jSONObject.optString("province", "0");
                            strArr[2] = jSONObject.optString("city", "0");
                            strArr[3] = jSONObject.optString(GdtGetUserInfoHandler.KEY_AREA, "0");
                        }
                    } catch (JSONException e17) {
                        e17.printStackTrace();
                    }
                    TroopMemberApiService troopMemberApiService7 = TroopMemberApiService.this;
                    if (troopMemberApiService7.C == null) {
                        troopMemberApiService7.C = (ConditionSearchManager) appRuntime.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER);
                        TroopMemberApiService.this.C.h(this);
                    }
                    Intent intent3 = new Intent(BaseApplication.getContext(), (Class<?>) LocationSelectActivity.class);
                    intent3.putExtra("param_is_popup", false);
                    intent3.putExtra(QZoneCheckSendGiftServlet.PARAM_REQ_TYPE, 2);
                    intent3.putExtra(IProfileCardConst.PARAM_LOCATION_CODE, strArr);
                    intent3.putExtra("param_location_param", TroopMemberApiService.this.C.Q(strArr));
                    BaseApplication.getContext().startActivity(intent3);
                    super.handleMessage(message);
                    return;
                case 146:
                    ((com.tencent.mobileqq.intervideo.groupvideo.h) appRuntime.getManager(QQManagerFactory.GROUP_VIDEO_PLUGIN_MANAGER)).c(null);
                    super.handleMessage(message);
                    return;
                case 147:
                    String string41 = data.getString("groupCode");
                    String string42 = data.getString("appID");
                    String string43 = data.getString("url");
                    String string44 = data.getString("source");
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopMemberApiService", 2, String.format("MSG_LAUNCH_GROUP_APP, groupCode: %s, appID: %s, url: %s, source: %s", string41, string42, string43, string44));
                    }
                    Context context2 = BaseActivity.sTopActivity;
                    if (context2 == null) {
                        context2 = TroopMemberApiService.this.getApplicationContext();
                    }
                    if (!(context2 instanceof BaseActivity)) {
                        context2 = null;
                    }
                    r.e((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), BaseApplication.getContext(), (BaseActivity) context2, string41, Long.parseLong(string42), string43, 1, 0, false);
                    super.handleMessage(message);
                    return;
                case 148:
                    data.putBoolean("enable", ((TempMsgManager) appRuntime.getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER)).F(data.getShort("tmpPushType")));
                    data.putInt("seq", data.getInt("seq"));
                    TroopMemberApiService.this.X(148, data);
                    super.handleMessage(message);
                    return;
                case 149:
                    short s16 = data.getShort("tmpPushType");
                    boolean z27 = data.getBoolean("enable");
                    ((TempMsgManager) appRuntime.getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER)).n(s16, z27, true);
                    data.putBoolean("enable", z27);
                    data.putBoolean("success", true);
                    data.putInt("seq", data.getInt("seq"));
                    TroopMemberApiService.this.X(149, data);
                    super.handleMessage(message);
                    return;
                case 151:
                    p(data);
                    super.handleMessage(message);
                    return;
                case 152:
                    is2.a aVar3 = (is2.a) ((QQAppInterface) appRuntime).getBusinessHandler(BusinessHandlerFactory.TROOP_ESSENCE_MSG_HANDLER);
                    if (aVar3 != null) {
                        aVar3.h1(data.getString("troopUin"), data.getBoolean("isChecked"));
                    }
                    super.handleMessage(message);
                    return;
                case 153:
                    com.tencent.mobileqq.troop.association.api.a aVar4 = (com.tencent.mobileqq.troop.association.api.a) ((QQAppInterface) appRuntime).getBusinessHandler(BusinessHandlerFactory.TROOP_ASSOCIATION_HANDLER);
                    if (aVar4 != null) {
                        aVar4.z0(data.getString("troopUin", ""), data.getInt("opType", 0), data.getString("startTroopUin", ""));
                    }
                    super.handleMessage(message);
                    return;
                case 157:
                    w(data);
                    super.handleMessage(message);
                    return;
                case 158:
                    H(data);
                    super.handleMessage(message);
                    return;
                case 159:
                    k(data);
                    super.handleMessage(message);
                    return;
                case 161:
                    if (BaseActivity.sTopActivity != null) {
                        ((IReadInjoyWebShareHelper) QRoute.api(IReadInjoyWebShareHelper.class)).showShareActionSheet(BaseActivity.sTopActivity, (QQAppInterface) appRuntime, data, new e());
                    } else {
                        QLog.e("TroopMemberApiService", 2, "web share error: topActivity or AppInterface is null");
                    }
                    super.handleMessage(message);
                    return;
                case 163:
                    TroopMemberApiService.this.W(data);
                    super.handleMessage(message);
                    return;
                case 164:
                    u(data);
                    super.handleMessage(message);
                    return;
                case 166:
                    String string45 = data.getString("guildId");
                    if (string45 != null) {
                        int troopFeedTalkPermission = ((ITroopGuildPermissionService) appRuntime.getRuntimeService(ITroopGuildPermissionService.class, "")).getTroopFeedTalkPermission(string45, true);
                        Bundle bundle13 = new Bundle();
                        bundle13.putSerializable("observer_type", 6);
                        bundle13.putSerializable("data", new Object[]{string45, Integer.valueOf(troopFeedTalkPermission)});
                        TroopMemberApiService.this.X(3, bundle13);
                    }
                    super.handleMessage(message);
                    return;
                case 167:
                    if (data.getBoolean("register")) {
                        TroopMemberApiService.this.U();
                    } else {
                        TroopMemberApiService.this.a0();
                    }
                    super.handleMessage(message);
                    return;
                case 168:
                    v(data);
                    super.handleMessage(message);
                    return;
                case 169:
                    n(data);
                    super.handleMessage(message);
                    return;
                case 170:
                    I();
                    super.handleMessage(message);
                    return;
                case 171:
                    try {
                        l(data);
                    } catch (Throwable unused) {
                        if (QLog.isColorLevel()) {
                            QLog.i("TroopMemberApiService", 2, "get troop avatar json fail");
                        }
                    }
                    super.handleMessage(message);
                    return;
                case 172:
                    s(data);
                    super.handleMessage(message);
                    return;
                case 173:
                    r(data);
                    super.handleMessage(message);
                    return;
                case 174:
                    q(data);
                    super.handleMessage(message);
                    return;
                case 176:
                    ((ITroopIdentityApi) QRoute.api(ITroopIdentityApi.class)).getTroopMemberRankTitleForWeb(data, new Function1() { // from class: com.tencent.biz.troop.k
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj3) {
                            Unit F;
                            F = TroopMemberApiService.IncomingHandler.this.F((Bundle) obj3);
                            return F;
                        }
                    });
                    super.handleMessage(message);
                    return;
                case 177:
                    ((ITroopIdentityApi) QRoute.api(ITroopIdentityApi.class)).onGetGlobalSwitch(data.getBoolean(com.tencent.mobileqq.msf.core.f0.c.e.h.f248218g));
                    super.handleMessage(message);
                    return;
            }
        }

        private void w(Bundle bundle) {
        }

        /* compiled from: P */
        /* loaded from: classes5.dex */
        class c implements x.a {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ AppRuntime f96636d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Bundle f96637e;

            c(AppRuntime appRuntime, Bundle bundle) {
                this.f96636d = appRuntime;
                this.f96637e = bundle;
            }

            @Override // com.tencent.mobileqq.shortvideo.x.a
            public void onConfigResult(int i3, int i16) {
                VideoEnvironment.LogDownLoad("TroopMemberApiService", "result=" + i3 + ",serverError=" + i16, null);
                if (i3 != 1 && i3 != 0) {
                    VideoEnvironment.LogDownLoad("TroopMemberApiService", HardCodeUtil.qqStr(R.string.ung) + i16 + "]", null);
                    ShortVideoResourceManager.N(HardCodeUtil.qqStr(R.string.uma));
                    o.b(1, i16);
                    TroopMemberApiService.this.I = false;
                    return;
                }
                if (i16 != 0) {
                    VideoEnvironment.LogDownLoad("TroopMemberApiService", HardCodeUtil.qqStr(R.string.f172840um4) + i16 + "]", null);
                    ShortVideoResourceManager.N(HardCodeUtil.qqStr(R.string.ula));
                    o.b(1, i16);
                    TroopMemberApiService.this.I = false;
                    return;
                }
                ArrayList arrayList = new ArrayList(1);
                int f16 = ShortVideoResourceManager.f((QQAppInterface) this.f96636d, arrayList);
                if (f16 == 0) {
                    VideoEnvironment.LogDownLoad("TroopMemberApiService", HardCodeUtil.qqStr(R.string.f172833ul2), null);
                    ShortVideoResourceManager.q((QQAppInterface) this.f96636d, arrayList, new a());
                    return;
                }
                VideoEnvironment.LogDownLoad("TroopMemberApiService", HardCodeUtil.qqStr(R.string.f172834ul3) + f16 + "]", null);
                ShortVideoResourceManager.N(HardCodeUtil.qqStr(R.string.f172839um3));
                o.b(1, f16);
            }

            /* compiled from: P */
            /* loaded from: classes5.dex */
            class a implements ShortVideoResourceManager.e {
                a() {
                }

                @Override // com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.e
                public void onDownloadFinish(String str, int i3, String str2) {
                    if (str.startsWith("new_qq_android_native_short_video_")) {
                        if (i3 != 0) {
                            VideoEnvironment.LogDownLoad("TroopMemberApiService", HardCodeUtil.qqStr(R.string.ukt) + i3 + "]", null);
                            ShortVideoResourceManager.N(HardCodeUtil.qqStr(R.string.um_));
                            o.b(2, i3);
                            c.this.f96637e.putInt("result", 0);
                        } else {
                            c.this.f96637e.putInt("result", -2);
                        }
                    }
                    VideoEnvironment.LogDownLoad("TroopMemberApiService", "name=" + str + ",result=" + i3 + ",filePath=" + str2, null);
                    c cVar = c.this;
                    TroopMemberApiService.this.X(91, cVar.f96637e);
                    TroopMemberApiService.this.I = false;
                }

                @Override // com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.e
                public void onNetWorkNone() {
                    TroopMemberApiService.this.I = false;
                }

                @Override // com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.e
                public void onUpdateProgress(String str, long j3, long j16) {
                }
            }
        }
    }
}
