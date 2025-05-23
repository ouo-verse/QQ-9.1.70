package com.tencent.mobileqq.gamecenter.yungame;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamematrix.gmcg.api.GmCgApiService;
import com.tencent.gamematrix.gmcg.api.GmCgError;
import com.tencent.gamematrix.gmcg.api.GmCgPlayAllocator;
import com.tencent.gamematrix.gmcg.api.GmCgPlayAllocatorListener;
import com.tencent.gamematrix.gmcg.api.GmCgSdkLoginListener;
import com.tencent.gamematrix.gmcg.api.model.GmCgAllocateDeviceInfo;
import com.tencent.gamematrix.gmcg.api.model.GmCgAllocatorCfg;
import com.tencent.gamematrix.gmcg.api.model.GmCgGameConfigInfo;
import com.tencent.gamematrix.gmcg.api.model.GmCgPlayQueueInfo;
import com.tencent.gamematrix.gmcg.api.model.GmCgSdkLoginCfg;
import com.tencent.gamematrix.gmcg.sdk.GmCgSdk;
import com.tencent.gamematrix.gmcg.sdk.impl.CGApiServiceImpl;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivityLandscapeForMultiProcess;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.YunGameRuntime;
import com.tencent.mobileqq.gamecenter.api.IYunGameChannelApi;
import com.tencent.mobileqq.gamecenter.api.IYunGameConstant;
import com.tencent.mobileqq.gamecenter.data.GameInfo;
import com.tencent.mobileqq.gamecenter.yungame.view.FloatWindowView;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ILaunchTroopSysMsgUIUtilApi;
import com.tencent.mobileqq.vas.comm.api.IGameCenterUnitedConfigApi;
import com.tencent.mobileqq.vas.comm.api.ResCallback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import eipc.EIPCResult;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class YunGameManager {

    /* renamed from: v, reason: collision with root package name */
    private static volatile YunGameManager f213526v;

    /* renamed from: a, reason: collision with root package name */
    private Context f213527a;

    /* renamed from: b, reason: collision with root package name */
    private GmCgSdkLoginCfg f213528b;

    /* renamed from: c, reason: collision with root package name */
    private GameInfo f213529c;

    /* renamed from: d, reason: collision with root package name */
    private GmCgAllocateDeviceInfo f213530d;

    /* renamed from: e, reason: collision with root package name */
    private GmCgPlayAllocator f213531e;

    /* renamed from: f, reason: collision with root package name */
    private WeakReference<d> f213532f;

    /* renamed from: g, reason: collision with root package name */
    private String f213533g;

    /* renamed from: h, reason: collision with root package name */
    private String f213534h;

    /* renamed from: i, reason: collision with root package name */
    private long f213535i;

    /* renamed from: j, reason: collision with root package name */
    private int f213536j;

    /* renamed from: k, reason: collision with root package name */
    private int f213537k;

    /* renamed from: l, reason: collision with root package name */
    private CGApiServiceImpl f213538l;

    /* renamed from: m, reason: collision with root package name */
    private HashMap<String, GmCgGameConfigInfo> f213539m;

    /* renamed from: n, reason: collision with root package name */
    private FloatWindowView f213540n;

    /* renamed from: o, reason: collision with root package name */
    private Handler f213541o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f213542p = false;

    /* renamed from: q, reason: collision with root package name */
    private boolean f213543q = false;

    /* renamed from: r, reason: collision with root package name */
    private boolean f213544r = false;

    /* renamed from: s, reason: collision with root package name */
    private boolean f213545s = false;

    /* renamed from: t, reason: collision with root package name */
    private long f213546t = 0;

    /* renamed from: u, reason: collision with root package name */
    @SuppressLint({"HandlerLeak"})
    Handler f213547u = new a(ThreadManagerV2.getSubThreadLooper());

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3 && YunGameManager.this.f213531e != null) {
                        YunGameManager.this.f213531e.cancelQueue();
                        YunGameManager.this.f213531e.stopAllocate(true);
                        YunGameManager.this.f213531e = null;
                        YunGameManager.this.f213545s = false;
                        return;
                    }
                    return;
                }
                Object obj = message.obj;
                if (obj == null) {
                    QLog.i("YunGameManager", 1, "[handleMessage] MSG_START_ALLOCATE obj is null;");
                    return;
                } else {
                    if (obj instanceof GameInfo) {
                        YunGameManager.this.z((GameInfo) obj);
                        return;
                    }
                    return;
                }
            }
            QLog.i("YunGameManager", 1, "[handleMessage] MSG_LOGIN_TIME_OUT");
            YunGameManager.this.f213543q = false;
            YunGameManager.this.f213544r = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements GmCgSdkLoginListener {
        b() {
        }

        @Override // com.tencent.gamematrix.gmcg.api.GmCgSdkLoginListener
        public /* synthetic */ void onGmCgSdkLoginMessage(String str) {
            com.tencent.gamematrix.gmcg.api.i.a(this, str);
        }

        @Override // com.tencent.gamematrix.gmcg.api.GmCgSdkLoginListener
        public void onGmCgSdkLoginResult(GmCgError gmCgError) {
            QLog.i("YunGameManager", 1, "[login][onGmCgSdkLoginResult] ret:" + gmCgError.toString());
            YunGameManager.this.f213547u.removeMessages(1);
            if (gmCgError.getErrorCode() == GmCgError.ErrorNone.getErrorCode()) {
                YunGameManager.this.f213543q = true;
                YunGameManager.this.Z(IYunGameConstant.CMD_SERVICE_START, 0, "", null);
            } else {
                YunGameManager.this.f213543q = false;
                YunGameManager.this.Z(IYunGameConstant.CMD_SERVICE_START, -2, "", null);
            }
            YunGameManager.this.f213544r = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c implements GmCgApiService.GetGameConfigResultListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f213554a;

        c(String str) {
            this.f213554a = str;
        }

        @Override // com.tencent.gamematrix.gmcg.api.GmCgApiService.GetGameConfigResultListener
        public void onGotFail(GmCgError gmCgError) {
            QLog.d("YunGameManager", 1, "[onGotFail] gmCgError:" + gmCgError);
        }

        @Override // com.tencent.gamematrix.gmcg.api.GmCgApiService.GetGameConfigResultListener
        public void onGotGameConfig(GmCgGameConfigInfo gmCgGameConfigInfo) {
            QLog.d("YunGameManager", 1, "[onGotGameConfig] gmCgGameConfigInfo:" + gmCgGameConfigInfo);
            YunGameManager.this.f213539m.put(this.f213554a, gmCgGameConfigInfo);
            try {
                String str = this.f213554a + "," + gmCgGameConfigInfo.pScreenOrientation;
                QMMKV.fromV2(YunGameManager.this.f213527a, "common_mmkv_configurations").putString(IYunGameConstant.KEY_SCREEN_CFG + this.f213554a, str);
            } catch (Throwable th5) {
                QLog.e("YunGameManager", 1, th5, new Object[0]);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface d {
        void P4(String str);

        void U2(int i3);

        void ca(String str);

        void m4(e eVar);

        void n8(boolean z16, String str);

        void notifyUserFeedback();
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public int f213556a = 0;

        /* renamed from: b, reason: collision with root package name */
        public int f213557b = 0;

        /* renamed from: c, reason: collision with root package name */
        public int f213558c = 0;

        /* renamed from: d, reason: collision with root package name */
        public String f213559d;

        /* renamed from: e, reason: collision with root package name */
        public String f213560e;

        /* renamed from: f, reason: collision with root package name */
        public String f213561f;

        /* renamed from: g, reason: collision with root package name */
        public String f213562g;

        /* renamed from: h, reason: collision with root package name */
        public String f213563h;
    }

    YunGameManager() {
        QLog.d("YunGameManager", 1, "[YunGameManager] new instance");
        this.f213538l = new CGApiServiceImpl();
        this.f213539m = new HashMap<>();
        this.f213541o = new Handler(Looper.getMainLooper());
    }

    private void A() {
        d dVar;
        WeakReference<d> weakReference;
        d dVar2;
        QLog.d("YunGameManager", 1, "[destory] destory====");
        if (this.f213529c != null && (weakReference = this.f213532f) != null && (dVar2 = weakReference.get()) != null) {
            dVar2.P4(this.f213529c.getGameId());
        }
        this.f213532f = null;
        this.f213529c = null;
        this.f213547u.sendEmptyMessage(3);
        this.f213530d = null;
        this.f213528b = null;
        this.f213547u.removeMessages(1);
        WeakReference<d> weakReference2 = this.f213532f;
        if (weakReference2 != null && this.f213529c != null && (dVar = weakReference2.get()) != null) {
            dVar.P4(this.f213529c.getGameId());
        }
        c0(false);
        SystemMethodProxy.killProcess(Process.myPid());
        System.exit(0);
    }

    public static YunGameManager F() {
        if (f213526v == null) {
            synchronized (YunGameManager.class) {
                if (f213526v == null) {
                    f213526v = new YunGameManager();
                }
            }
        }
        return f213526v;
    }

    public static boolean H(Context context) {
        return Settings.canDrawOverlays(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void J(String str, String str2, int i3, Bundle bundle) {
        QLog.d("YunGameManager", 1, "[sendMsgToClient] plugin cmd:" + str);
        Bundle bundle2 = new Bundle();
        bundle2.putString(IYunGameConstant.KEY_PARAM_MSG, str2);
        bundle2.putInt(IYunGameConstant.KEY_PARAM_RET, i3);
        bundle2.putBundle("key_data", bundle);
        QIPCClientHelper.getInstance().callServer(IYunGameConstant.IPC_NAME, str, bundle2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(GameInfo gameInfo, int i3, int i16, String str, String str2, String str3, String str4) {
        GameInfo gameInfo2 = this.f213529c;
        if (gameInfo2 != null && TextUtils.equals(gameInfo2.getGameId(), gameInfo.getGameId())) {
            if (gameInfo.getAppId().equals(str4)) {
                QLog.d("YunGameManager", 2, "[startGame] accessToken:" + str + ",openId:" + str3 + ",payToken:" + str2);
                gameInfo.setAccessToken(str);
                gameInfo.setPayToken(str2);
                gameInfo.setOpenId(str3);
                gameInfo.setAutoLoginForType5Switch(i3);
                gameInfo.setCloudGameLoginParamV1Switch(i16);
            }
            y(gameInfo);
            return;
        }
        QLog.d("YunGameManager", 2, "[shouldGetLaunchKeysBeforeStart] gameId:" + gameInfo.getGameId() + ", return.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(long j3, final GameInfo gameInfo, JSONObject jSONObject) {
        QLog.i("YunGameManager", 1, "[shouldGetLaunchKeysBeforeStart] loadResConfigJsonObjAsync cost:" + (System.currentTimeMillis() - j3));
        JSONArray optJSONArray = jSONObject.optJSONArray("autoLoginArr");
        if (optJSONArray == null) {
            optJSONArray = ((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).getConfigJsonObj(IGameCenterUnitedConfigApi.GAME_CENTER_YUNGAME_AUTO_LOGIN).optJSONArray("autoLoginArr");
            QLog.i("YunGameManager", 1, "[shouldGetLaunchKeysBeforeStart] use old config");
        }
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                Object opt = optJSONArray.opt(i3);
                if (opt instanceof JSONObject) {
                    JSONObject jSONObject2 = (JSONObject) opt;
                    if (gameInfo.getAppId().equals(jSONObject2.opt("appId"))) {
                        final int optInt = jSONObject2.optInt("autoLoginForType5Switch");
                        final int optInt2 = jSONObject2.optInt("cloudGameLoginParamV1Switch");
                        QLog.d("YunGameManager", 2, "[shouldGetLaunchKeysBeforeStart] autoLoginForType5Switch:" + optInt + ",autoLoginForType5Switch:" + optInt);
                        if (optInt == 1 || optInt2 == 1) {
                            ((IYunGameChannelApi) QRoute.api(IYunGameChannelApi.class)).startGetLaunchKeys(gameInfo.getAppId(), new IYunGameChannelApi.OnGetLaunchKeyListener() { // from class: com.tencent.mobileqq.gamecenter.yungame.l
                                @Override // com.tencent.mobileqq.gamecenter.api.IYunGameChannelApi.OnGetLaunchKeyListener
                                public final void onResult(String str, String str2, String str3, String str4) {
                                    YunGameManager.this.K(gameInfo, optInt, optInt2, str, str2, str3, str4);
                                }
                            });
                            return;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        y(gameInfo);
    }

    private void R(Bundle bundle) {
        boolean z16 = bundle.getBoolean(IYunGameConstant.KEY_TOGGLE_ALLOW, true);
        String string = bundle.getString(IYunGameConstant.KEY_TOGGLE_URL);
        WeakReference<d> weakReference = this.f213532f;
        if (weakReference != null) {
            d dVar = weakReference.get();
            if (dVar != null) {
                dVar.n8(z16, string);
            }
            if (!z16) {
                h0(this.f213529c);
            }
        }
    }

    private void S(Bundle bundle) {
        String string = bundle.getString(IYunGameConstant.KEY_PUSH_DATA);
        QLog.d("YunGameManager", 2, "[onPushReceive] data:" + string);
        try {
            JSONObject jSONObject = new JSONObject(string);
            int optInt = jSONObject.optInt(ILaunchTroopSysMsgUIUtilApi.KEY_PUSH_TYPE);
            e eVar = new e();
            eVar.f213556a = optInt;
            if (optInt == 1) {
                JSONObject optJSONObject = jSONObject.optJSONObject("terminal");
                if (optJSONObject == null) {
                    return;
                }
                eVar.f213558c = optJSONObject.optInt("task_type", -1);
                eVar.f213563h = optJSONObject.optString("jump_url");
                eVar.f213559d = optJSONObject.optString("title");
                eVar.f213557b = optJSONObject.optInt("pop_type", -1);
                eVar.f213560e = optJSONObject.optString("sub_title");
                eVar.f213561f = optJSONObject.optString("left_button_name");
                eVar.f213562g = optJSONObject.optString("right_button_name");
            } else if (optInt == 2 || optInt == 3) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("web");
                if (jSONObject2 == null) {
                    return;
                } else {
                    eVar.f213563h = jSONObject2.optString("jump_url");
                }
            }
            N(eVar);
        } catch (Exception e16) {
            QLog.e("YunGameManager", 1, e16, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(String str, String str2, boolean z16) {
        long j3;
        String str3;
        String str4;
        String str5;
        String str6;
        GameInfo B = B();
        int i3 = this.f213537k;
        if (B != null) {
            str3 = B.getAppId();
            j3 = (System.currentTimeMillis() - this.f213535i) / 1000;
            QLog.d("YunGameManager", 1, "[report] queueTime:" + j3);
            if (i3 == 0) {
                i3 = 4;
            } else if (i3 == 2) {
                i3 = 1;
            } else {
                i3 = 2;
            }
        } else {
            j3 = 0;
            str3 = "";
        }
        if (z16) {
            i3 = 5;
        }
        GameInfo gameInfo = this.f213529c;
        if (gameInfo == null) {
            str4 = "";
            str5 = str4;
            str6 = str5;
        } else {
            str4 = gameInfo.getReportChannelId();
            str5 = this.f213529c.getGameId();
            str6 = this.f213529c.getReportActId();
        }
        new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperId(str).setOperModule("9080").setOpertype(str2).setGameAppId(str3).setExt(1, "908014").setExt(11, "1").setExt(12, WadlProxyConsts.PAGE_ID_DOWNLOAD).setExt(46, j3 + "").setExt(6, "" + i3).setExt(49, "" + this.f213536j).setExt(41, str4).setExt(42, str5).setExt(43, str6).report();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        int i3;
        FloatWindowView floatWindowView = new FloatWindowView(this.f213527a);
        this.f213540n = floatWindowView;
        floatWindowView.setIsAddToWindowManager(true);
        if (Build.VERSION.SDK_INT >= 26) {
            i3 = 2038;
        } else {
            i3 = 2002;
        }
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, i3, 8, -3);
        layoutParams.gravity = 51;
        layoutParams.y = com.tencent.mobileqq.gamecenter.yungame.a.d(200.0f, this.f213527a.getResources());
        ((WindowManager) this.f213527a.getSystemService("window")).addView(this.f213540n, layoutParams);
        X("914201", "8", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean z(final GameInfo gameInfo) {
        if (gameInfo == null) {
            return false;
        }
        c0(true);
        QLog.i("YunGameManager", 1, "[allocateDevice] start allocate devices:" + gameInfo);
        GmCgPlayAllocator createPlayAllocator = GmCgSdk.createPlayAllocator(new GmCgAllocatorCfg.Builder(gameInfo.getGameId(), 7200L).setGamePlayType(gameInfo.getPlayType()).skipNetDetect(true).setQueueConfig(true, 0).setBizExtraInfo("test").build());
        this.f213531e = createPlayAllocator;
        createPlayAllocator.setPlayAllocatorListener(new GmCgPlayAllocatorListener() { // from class: com.tencent.mobileqq.gamecenter.yungame.YunGameManager.4
            @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayAllocatorListener
            public void onGmCgAllocatorError(GmCgError gmCgError) {
                YunGameManager.this.Y(3);
                if (YunGameManager.this.f213540n != null && YunGameManager.this.f213540n.isAttachedToWindow()) {
                    YunGameManager.this.f213540n.f(-7, 0, 0);
                }
                YunGameManager.this.f213537k = -7;
                Bundle bundle = new Bundle();
                IYunGameConstant.GameStatusInfo gameStatusInfo = new IYunGameConstant.GameStatusInfo();
                gameStatusInfo.setGameInfo(gameInfo);
                gameStatusInfo.setMsg("wait allocator devices");
                gameStatusInfo.setStatus(2);
                gameStatusInfo.setStartQueueTime(YunGameManager.this.f213535i);
                bundle.putParcelable(IYunGameConstant.KEY_PARAM_QUEUE_INFO, gameStatusInfo);
                YunGameManager.this.Z(IYunGameConstant.CMD_GAME_STATUS_CHANGE, -7, "allocate device failed.", bundle);
            }

            @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayAllocatorListener
            public void onGmCgAllocatorUpdate(int i3, boolean z16, GmCgAllocateDeviceInfo gmCgAllocateDeviceInfo) {
                QLog.i("YunGameManager", 1, "[onGmCgAllocatorUpdate] update: " + i3 + ", " + z16);
                if (i3 == 1) {
                    YunGameManager.this.f213545s = true;
                    IYunGameConstant.GameStatusInfo gameStatusInfo = new IYunGameConstant.GameStatusInfo();
                    gameStatusInfo.setGameInfo(gameInfo);
                    gameStatusInfo.setIndex(gmCgAllocateDeviceInfo.mCgPlayQueueInfo.pWaitPos);
                    gameStatusInfo.setTotal(gmCgAllocateDeviceInfo.mCgPlayQueueInfo.pWaitNum);
                    gameStatusInfo.setMsg("wait allocator devices");
                    gameStatusInfo.setStatus(2);
                    gameStatusInfo.setStartQueueTime(YunGameManager.this.f213535i);
                    Bundle bundle = new Bundle();
                    bundle.putParcelable(IYunGameConstant.KEY_PARAM_QUEUE_INFO, gameStatusInfo);
                    YunGameManager.this.Z(IYunGameConstant.CMD_GAME_STATUS_CHANGE, 2, "", bundle);
                    if (YunGameManager.this.f213540n != null && YunGameManager.this.f213540n.isAttachedToWindow()) {
                        FloatWindowView floatWindowView = YunGameManager.this.f213540n;
                        GmCgPlayQueueInfo gmCgPlayQueueInfo = gmCgAllocateDeviceInfo.mCgPlayQueueInfo;
                        floatWindowView.f(2, gmCgPlayQueueInfo.pWaitPos, gmCgPlayQueueInfo.pWaitNum);
                    }
                    YunGameManager.this.f213537k = 2;
                    YunGameManager.this.f213536j = gmCgAllocateDeviceInfo.mCgPlayQueueInfo.pWaitPos;
                    return;
                }
                if (i3 == 2) {
                    QLog.i("YunGameManager", 1, "[onGmCgAllocatorUpdate] code start");
                    return;
                }
                if (i3 == 3) {
                    YunGameManager.this.f213545s = false;
                    YunGameManager.this.Y(1);
                    if (YunGameManager.this.f213540n != null && YunGameManager.this.f213540n.isAttachedToWindow()) {
                        YunGameManager.this.f213540n.f(0, 0, 0);
                    }
                    YunGameManager.this.f213537k = 0;
                    QLog.i("YunGameManager", 1, "[onGmCgAllocatorUpdate] createPlaySessionFromDevice ");
                    YunGameManager.this.f213530d = gmCgAllocateDeviceInfo;
                    if (YunGameManager.this.f213530d != null && YunGameManager.this.f213530d.mCgDeviceInfo != null) {
                        QLog.i("YunGameManager", 1, "[onGmCgAllocatorUpdate] deviceId: " + YunGameManager.this.f213530d.mCgDeviceInfo.getDeviceID());
                    } else {
                        QLog.i("YunGameManager", 1, "[onGmCgAllocatorUpdate]  ");
                    }
                    YunGameManager.this.f0(gameInfo);
                    YunGameManager.this.f213541o.post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.yungame.YunGameManager.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            YunGameManager.this.V();
                        }
                    });
                }
            }
        });
        QLog.i("YunGameManager", 1, "[startGame] startAllocate....");
        this.f213535i = System.currentTimeMillis();
        this.f213531e.startAllocate();
        return true;
    }

    public GameInfo B() {
        return this.f213529c;
    }

    public GmCgAllocateDeviceInfo C() {
        return this.f213530d;
    }

    public GmCgGameConfigInfo D(String str) {
        return this.f213539m.get(str);
    }

    public void E(String str) {
        QLog.d("YunGameManager", 1, "[getGameConfigFromServer] getGameConfigFromServer:" + str);
        this.f213538l.getGameConfigInfo(str, new c(str));
    }

    public String G() {
        return this.f213533g;
    }

    public void I(Context context) {
        this.f213527a = context;
        this.f213542p = QMMKV.fromV2(context, "common_mmkv_configurations").getBoolean(IYunGameConstant.KEY_YUNGAME_ENV_CFG, false);
        QLog.d("YunGameManager", 1, "[init] init end, TestEnv:" + this.f213542p);
    }

    public synchronized void M(String str, String str2) {
        QLog.i("YunGameManager", 2, "[login] start Login...." + this.f213542p);
        if (this.f213543q) {
            QLog.i("YunGameManager", 2, "[login] already login return.");
            Z(IYunGameConstant.CMD_SERVICE_START, 0, "", null);
            return;
        }
        if (this.f213544r) {
            QLog.i("YunGameManager", 2, "[login] logining.... return.");
            return;
        }
        this.f213544r = true;
        if (QLog.isColorLevel()) {
            QLog.d("YunGameManager", 2, "[login] uid:" + str + ", key:" + str2);
        }
        this.f213534h = str2;
        this.f213533g = str;
        if (this.f213542p) {
            GmCgSdkLoginCfg gmCgSdkLoginCfg = new GmCgSdkLoginCfg("4BB0116F05BF3B7A", str, str2);
            this.f213528b = gmCgSdkLoginCfg;
            gmCgSdkLoginCfg.setServerType(1);
        } else {
            GmCgSdkLoginCfg gmCgSdkLoginCfg2 = new GmCgSdkLoginCfg("A766AD57B552AF01", str, str2);
            this.f213528b = gmCgSdkLoginCfg2;
            gmCgSdkLoginCfg2.setServerType(0);
        }
        this.f213547u.removeMessages(1);
        this.f213547u.sendEmptyMessageDelayed(1, 5000L);
        GmCgSdk.login(this.f213528b, new b());
    }

    public void N(e eVar) {
        d dVar;
        WeakReference<d> weakReference = this.f213532f;
        if (weakReference != null && (dVar = weakReference.get()) != null) {
            dVar.m4(eVar);
        }
    }

    public void O() {
        d dVar;
        WeakReference<d> weakReference = this.f213532f;
        if (weakReference != null && (dVar = weakReference.get()) != null) {
            dVar.notifyUserFeedback();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public EIPCResult P(String str, Bundle bundle, int i3) {
        Bundle bundle2;
        int i16;
        GameInfo gameInfo;
        EIPCResult eIPCResult = new EIPCResult();
        GameInfo gameInfo2 = null;
        if (bundle != null) {
            bundle2 = bundle.getBundle("key_data");
        } else {
            bundle2 = null;
        }
        if (bundle2 != null) {
            bundle2.setClassLoader(GameInfo.class.getClassLoader());
            gameInfo2 = (GameInfo) bundle2.getParcelable(IYunGameConstant.KEY_GAME_INFO);
            if (gameInfo2 != null) {
                bundle2.putInt("key_callback_id", gameInfo2.getCallbackId());
            }
        }
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1492043821:
                if (str.equals(IYunGameConstant.CMD_GET_GAME_TOGGLE)) {
                    c16 = 0;
                    break;
                }
                break;
            case -1257674422:
                if (str.equals(IYunGameConstant.CMD_STOP_GAME)) {
                    c16 = 1;
                    break;
                }
                break;
            case -888710700:
                if (str.equals(IYunGameConstant.CMD_START_GAME)) {
                    c16 = 2;
                    break;
                }
                break;
            case -220568699:
                if (str.equals(IYunGameConstant.CMD_USER_DESTORY)) {
                    c16 = 3;
                    break;
                }
                break;
            case 129488362:
                if (str.equals(IYunGameConstant.CMD_EXIT_BACKGROUND)) {
                    c16 = 4;
                    break;
                }
                break;
            case 144903943:
                if (str.equals(IYunGameConstant.CMD_RESTART_GAME)) {
                    c16 = 5;
                    break;
                }
                break;
            case 1118059752:
                if (str.equals(IYunGameConstant.CMD_NOTIFY_USER_FEEDBACK)) {
                    c16 = 6;
                    break;
                }
                break;
            case 1647287039:
                if (str.equals(IYunGameConstant.CMD_PUSH)) {
                    c16 = 7;
                    break;
                }
                break;
            case 2092284970:
                if (str.equals(IYunGameConstant.CMD_CHANGE_CLARITY)) {
                    c16 = '\b';
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                R(bundle2);
                i16 = 0;
                break;
            case 1:
                i16 = h0(gameInfo2);
                break;
            case 2:
                i16 = g0(gameInfo2);
                break;
            case 3:
                A();
                i16 = 0;
                break;
            case 4:
                e0();
                i16 = 0;
                break;
            case 5:
                i16 = U(gameInfo2);
                break;
            case 6:
                O();
                i16 = 0;
                break;
            case 7:
                S(bundle2);
                i16 = 0;
                break;
            case '\b':
                if (bundle2 != null) {
                    a0(bundle2.getInt(IYunGameConstant.KEY_CLARITY));
                }
                i16 = 0;
                break;
            default:
                i16 = 0;
                break;
        }
        Bundle bundle3 = new Bundle();
        bundle3.putInt(IYunGameConstant.KEY_PARAM_RET, i16);
        bundle3.putBundle("key_data", bundle2);
        if (i16 == -6 && (gameInfo = this.f213529c) != null) {
            bundle3.putString(IYunGameConstant.KEY_PARAM_MSG, gameInfo.getGameId());
        }
        eIPCResult.data = bundle3;
        eIPCResult.code = 0;
        return eIPCResult;
    }

    public void Q() {
        QLog.i("YunGameManager", 1, "[onGameDestory] game destory.");
        this.f213529c = null;
        this.f213532f = null;
        this.f213545s = false;
        Z(IYunGameConstant.CMD_GAME_DESTORY, 0, "", null);
        c0(false);
    }

    public void T(String str, GmCgGameConfigInfo gmCgGameConfigInfo) {
        this.f213539m.put(str, gmCgGameConfigInfo);
    }

    public int U(GameInfo gameInfo) {
        d dVar;
        if (gameInfo == null) {
            QLog.e("YunGameManager", 1, "[reStartGame] gameInfo is null !!!!");
            return -5;
        }
        WeakReference<d> weakReference = this.f213532f;
        if (weakReference != null && (dVar = weakReference.get()) != null) {
            dVar.ca(this.f213529c.getGameId());
            return 0;
        }
        return 0;
    }

    public void V() {
        QLog.i("YunGameManager", 1, "[removeFloatWindow] removeFloatWindow");
        FloatWindowView floatWindowView = this.f213540n;
        if (floatWindowView != null && floatWindowView.isAttachedToWindow()) {
            QLog.i("YunGameManager", 1, "[removeFloatWindow] removeFloatWindow real.");
            ((WindowManager) this.f213527a.getSystemService("window")).removeView(this.f213540n);
            this.f213540n = null;
        }
    }

    public void W() {
        QLog.i("YunGameManager", 1, "[removeFloatWindowByUser] removeFloatWindowByUser");
        Z(IYunGameConstant.CMD_SHOW_TIPS, 0, "", null);
        X("914202", "20", true);
        V();
    }

    public void Y(int i3) {
        GameInfo gameInfo = this.f213529c;
        if (gameInfo == null) {
            return;
        }
        String reportChannelId = gameInfo.getReportChannelId();
        String gameId = this.f213529c.getGameId();
        new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperId("914482").setOperModule("9080").setOpertype("20").setGameAppId(this.f213529c.getAppId()).setRetId(i3).setExt(1, "908014").setExt(11, "1").setExt(12, WadlProxyConsts.PAGE_ID_DOWNLOAD).setExt(41, reportChannelId).setExt(42, gameId).setExt(43, this.f213529c.getReportActId()).report();
    }

    public void Z(final String str, final int i3, final String str2, final Bundle bundle) {
        this.f213547u.post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.yungame.j
            @Override // java.lang.Runnable
            public final void run() {
                YunGameManager.J(str, str2, i3, bundle);
            }
        });
    }

    public void a0(int i3) {
        d dVar;
        WeakReference<d> weakReference = this.f213532f;
        if (weakReference != null && (dVar = weakReference.get()) != null) {
            dVar.U2(i3);
        }
    }

    public void b0(d dVar) {
        this.f213532f = new WeakReference<>(dVar);
    }

    public void c0(boolean z16) {
        YunGameRuntime yunGameRuntime = (YunGameRuntime) MobileQQ.sMobileQQ.peekAppRuntime();
        if (yunGameRuntime != null) {
            yunGameRuntime.setGameRunning(z16);
        } else {
            QLog.i("YunGameManager", 1, "[setProcessState] YunGameRuntime is null!");
        }
    }

    public void d0(final GameInfo gameInfo) {
        if (gameInfo != null && !TextUtils.isEmpty(gameInfo.getAppId())) {
            final long currentTimeMillis = System.currentTimeMillis();
            ((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).loadResConfigJsonObjAsync(IGameCenterUnitedConfigApi.GAME_CENTER_YUNGAME_AUTO_LOGIN_RES, new ResCallback() { // from class: com.tencent.mobileqq.gamecenter.yungame.k
                @Override // com.tencent.mobileqq.vas.comm.api.ResCallback
                public final void onLoad(JSONObject jSONObject) {
                    YunGameManager.this.L(currentTimeMillis, gameInfo, jSONObject);
                }
            });
        } else {
            y(gameInfo);
        }
    }

    public void e0() {
        QLog.i("YunGameManager", 1, "[showFloatWindow] showFloatWindow");
        if (!H(this.f213527a)) {
            QLog.i("YunGameManager", 1, "[showFloatWindow] hasOverlayPermission is false");
        } else {
            this.f213541o.post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.yungame.YunGameManager.5

                /* compiled from: P */
                /* renamed from: com.tencent.mobileqq.gamecenter.yungame.YunGameManager$5$a */
                /* loaded from: classes12.dex */
                class a implements View.OnClickListener {
                    a() {
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        EventCollector.getInstance().onViewClickedBefore(view);
                        QLog.i("YunGameManager", 1, "[onClick] mFloatView onClick....");
                        if (YunGameManager.this.f213546t > 0 && Math.abs(System.currentTimeMillis() - YunGameManager.this.f213546t) < 1000) {
                            QLog.i("YunGameManager", 1, "[onClick] click too fast, return.");
                        } else {
                            YunGameManager.this.f213546t = System.currentTimeMillis();
                            if (YunGameManager.this.f213529c != null) {
                                Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(YunGameManager.this.f213529c.getJumpUrl()));
                                intent.addFlags(268435456);
                                if (YunGameManager.this.f213527a != null) {
                                    YunGameManager.this.f213527a.startActivity(intent);
                                }
                            } else {
                                YunGameManager.this.V();
                            }
                            YunGameManager.this.X("914202", "20", false);
                        }
                        EventCollector.getInstance().onViewClicked(view);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    QLog.i("YunGameManager", 1, "[showFloatWindow] showFloatWindow real");
                    if (YunGameManager.this.f213540n != null) {
                        YunGameManager.this.V();
                    }
                    if (YunGameManager.this.f213540n == null) {
                        try {
                            YunGameManager.this.x();
                        } catch (Throwable th5) {
                            QLog.e("YunGameManager", 1, th5, new Object[0]);
                        }
                    }
                    if (YunGameManager.this.f213540n == null) {
                        QLog.e("YunGameManager", 1, "[showFloatWindow] add floatview err.");
                    } else {
                        YunGameManager.this.f213540n.setOnClickListener(new a());
                    }
                }
            });
        }
    }

    public void f0(GameInfo gameInfo) {
        if (gameInfo == null) {
            QLog.e("YunGameManager", 1, "[startGameActivity] gameInfo is null !!!!");
            return;
        }
        QLog.i("YunGameManager", 1, "[startGameActivity] realStartGame....");
        Intent intent = new Intent();
        intent.putExtra("public_fragment_window_feature", 1);
        QPublicFragmentActivity.b.d(intent, QPublicTransFragmentActivityLandscapeForMultiProcess.class, YunGameFragment.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(IYunGameConstant.KEY_GAME_INFO, gameInfo);
        bundle.putInt("key_callback_id", gameInfo.getCallbackId());
        Z(IYunGameConstant.CMD_START_GAME, 0, "start game suc.", bundle);
    }

    public int g0(GameInfo gameInfo) {
        if (gameInfo == null) {
            QLog.e("YunGameManager", 1, "[startGame] gameInfo is null !!!!");
            return -5;
        }
        QLog.i("YunGameManager", 1, "[startGame]  info:" + gameInfo);
        if (!this.f213543q) {
            QLog.i("YunGameManager", 1, "[startGame] not login, return.");
            M(this.f213533g, this.f213534h);
            return -2;
        }
        GameInfo gameInfo2 = this.f213529c;
        if (gameInfo2 != null) {
            if (this.f213545s) {
                QLog.i("YunGameManager", 1, "[startGame]  game queueing, return." + this.f213529c.getGameId());
                return -6;
            }
            h0(gameInfo2);
        }
        this.f213529c = gameInfo;
        if (D(gameInfo.getGameId()) == null) {
            E(gameInfo.getGameId());
        }
        d0(gameInfo);
        return 3;
    }

    public int h0(GameInfo gameInfo) {
        d dVar;
        if (gameInfo == null) {
            QLog.e("YunGameManager", 1, "[stopGame] gameInfo is null !!!!");
            return -5;
        }
        QLog.i("YunGameManager", 1, "[stopGame] stop game....");
        this.f213547u.sendEmptyMessage(3);
        if (this.f213545s) {
            Y(2);
        }
        WeakReference<d> weakReference = this.f213532f;
        if (weakReference != null && (dVar = weakReference.get()) != null) {
            dVar.P4("");
        }
        this.f213541o.post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.yungame.YunGameManager.6
            @Override // java.lang.Runnable
            public void run() {
                YunGameManager.this.V();
            }
        });
        c0(false);
        return 0;
    }

    public void y(GameInfo gameInfo) {
        Message obtainMessage = this.f213547u.obtainMessage(2);
        obtainMessage.obj = gameInfo;
        this.f213547u.sendMessage(obtainMessage);
    }
}
