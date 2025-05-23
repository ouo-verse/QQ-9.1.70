package com.tencent.mobileqq.guild.live.livemanager;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.base.repository.AccountChangedNotifier;
import com.tencent.mobileqq.guild.live.helper.GuildTimeRecHelper;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.aa;
import com.tencent.mobileqq.guild.util.timerecord.GuildLiveTimeEvent;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDKManager;
import com.tencent.mobileqq.qqlive.callback.login.IQQLiveLoginCallback;
import com.tencent.mobileqq.qqlive.callback.room.audience.GetRoomInfoCallback;
import com.tencent.mobileqq.qqlive.data.config.CustomData;
import com.tencent.mobileqq.qqlive.data.config.QQLiveSDKConfig;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.mobileqq.qqlive.data.login.LoginRequest;
import com.tencent.mobileqq.qqlive.data.room.realtime.LiveRealTimeInfo;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.UUID;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.MainTicketCallback;
import mqq.manager.MainTicketInfo;
import mqq.manager.TicketManager;

/* compiled from: P */
/* loaded from: classes14.dex */
public class QQGuildLiveRoomCommMgr implements g, com.tencent.mobileqq.guild.base.repository.a {
    private long C;
    private long D;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f226722e;

    /* renamed from: h, reason: collision with root package name */
    private IQQLiveSDK f226724h;

    /* renamed from: i, reason: collision with root package name */
    private String f226725i;

    /* renamed from: m, reason: collision with root package name */
    private final GLiveChannelCore f226726m;

    /* renamed from: d, reason: collision with root package name */
    private final e12.a<Boolean> f226721d = new e12.a<>();

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f226723f = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a implements MainTicketCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AppRuntime f226727a;

        a(AppRuntime appRuntime) {
            this.f226727a = appRuntime;
        }

        @Override // mqq.manager.MainTicketCallback
        public void onFail(int i3, String str) {
            QLog.i("QGL.QQGuildLiveRoomCommMgr", 1, "get login ticket fail");
            QQGuildLiveRoomCommMgr.this.w(true);
        }

        @Override // mqq.manager.MainTicketCallback
        public void onSuccess(MainTicketInfo mainTicketInfo) {
            QLog.i("QGL.QQGuildLiveRoomCommMgr", 1, "get login ticket suc");
            QQGuildLiveRoomCommMgr.this.B(this.f226727a, mainTicketInfo.getA2());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class b implements IQQLiveLoginCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f226729a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f226730b;

        b(String str, long j3) {
            this.f226729a = str;
            this.f226730b = j3;
        }

        @Override // com.tencent.mobileqq.qqlive.callback.BaseCallback
        public void onFailed(int i3, String str) {
            QLog.e("QGL.QQGuildLiveRoomCommMgr", 1, "login fail code " + i3 + " msg " + str);
            if (!QQGuildLiveRoomCommMgr.this.v(this.f226729a)) {
                QLog.e("QGL.QQGuildLiveRoomCommMgr", 1, "login fail, mQQLiveSDK == null, ignore. ");
                return;
            }
            com.tencent.mobileqq.guild.performance.report.l.g("live_sdk_login_fail", new HashMap(), i3, vq1.c.a(this.f226730b, str));
            QQGuildLiveRoomCommMgr.this.z();
        }

        @Override // com.tencent.mobileqq.qqlive.callback.login.IQQLiveLoginCallback
        public void onSuccess(LoginInfo loginInfo) {
            if (!QQGuildLiveRoomCommMgr.this.v(this.f226729a)) {
                QLog.e("QGL.QQGuildLiveRoomCommMgr", 1, "login suc, checkUseUuidIsValid == false, ignore.");
                return;
            }
            com.tencent.mobileqq.guild.performance.report.l.c("live_sdk_login_success");
            LiveUserInfo liveUserInfo = loginInfo.userInfo;
            if (liveUserInfo != null) {
                QQGuildLiveRoomCommMgr.this.C = liveUserInfo.uid;
            }
            GuildTimeRecHelper.d(GuildLiveTimeEvent.LIVE_SDK_INIT_LOGIN);
            QLog.i("QGL.QQGuildLiveRoomCommMgr", 1, "login info " + loginInfo);
            QQGuildLiveRoomCommMgr.this.f226723f = false;
            QQGuildLiveRoomCommMgr.this.f226722e = true;
            QQGuildLiveRoomCommMgr.this.f226721d.postValue(Boolean.TRUE);
            QQGuildLiveRoomCommMgr.this.D = System.currentTimeMillis();
            QQGuildLiveRoomCommMgr.this.D();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QLog.i("QGL.QQGuildLiveRoomCommMgr", 1, "handleInitSdkFailed retry.");
            QQGuildLiveRoomCommMgr.this.g(QQGuildLiveRoomCommMgr.u());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class e implements DialogInterface.OnClickListener {
        e() {
        }

        private boolean a(Activity activity) {
            if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
                return true;
            }
            return false;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QLog.i("QGL.QQGuildLiveRoomCommMgr", 1, "handleInitSdkFailed exit.");
            Activity b16 = com.tencent.mobileqq.guild.window.o.a().b("qqGuildLiveRoom");
            if (a(b16)) {
                GuildSplitViewUtils.f235370a.t(b16, false);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class f implements GetRoomInfoCallback {
        f() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.audience.GetRoomInfoCallback
        public void onFailed(int i3, String str) {
            QLog.e("QGL.QQGuildLiveRoomCommMgr", 1, "getRoomRealTimeInfo fail. code=" + i3 + " msg=" + str);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.audience.GetRoomInfoCallback
        public void onSuccess(LiveRealTimeInfo liveRealTimeInfo) {
            if (QLog.isColorLevel()) {
                QLog.i("QGL.QQGuildLiveRoomCommMgr", 2, "getRoomRealTimeInfo suc.");
            }
            if (QQGuildLiveRoomCommMgr.this.f226722e) {
                QQGuildLiveRoomCommMgr.this.C(liveRealTimeInfo);
            }
        }
    }

    public QQGuildLiveRoomCommMgr(GLiveChannelCore gLiveChannelCore) {
        this.f226726m = gLiveChannelCore;
        AccountChangedNotifier.f214789d.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(@NonNull AppRuntime appRuntime, String str) {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.uin = appRuntime.getCurrentUin();
        loginRequest.qqA2 = str;
        String uuid = UUID.randomUUID().toString();
        this.f226725i = uuid;
        GuildTimeRecHelper.g(GuildLiveTimeEvent.LIVE_SDK_INIT_LOGIN);
        com.tencent.mobileqq.guild.performance.report.l.c("live_sdk_login_start");
        QLog.i("QGL.QQGuildLiveRoomCommMgr", 1, "QQLiveSDK call login");
        long currentTimeMillis = System.currentTimeMillis();
        IQQLiveSDK iQQLiveSDK = this.f226724h;
        if (iQQLiveSDK == null) {
            QLog.i("QGL.QQGuildLiveRoomCommMgr", 1, "QQLiveSDK is null return");
            w(true);
        } else {
            iQQLiveSDK.getLoginModule().login(loginRequest, new b(uuid, currentTimeMillis));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(LiveRealTimeInfo liveRealTimeInfo) {
        sq1.b j3 = sq1.b.j(liveRealTimeInfo);
        if (j3 != null) {
            QLog.i("QGL.QQGuildLiveRoomCommMgr", 1, "mapRoomRealTimeInfo2EndLiveData," + j3.toString());
            this.f226726m.g().O0(j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        IQQLiveSDK iQQLiveSDK = this.f226724h;
        if (iQQLiveSDK != null) {
            iQQLiveSDK.getLoginModule().registerLoginStateCallback(new c());
        }
    }

    static /* bridge */ /* synthetic */ AppRuntime u() {
        return x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean v(String str) {
        return TextUtils.equals(this.f226725i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(boolean z16) {
        if (z16) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.live.livemanager.QQGuildLiveRoomCommMgr.3
                @Override // java.lang.Runnable
                public void run() {
                    QQGuildLiveRoomCommMgr.this.f226723f = false;
                    QQGuildLiveRoomCommMgr.this.f226722e = false;
                    QQGuildLiveRoomCommMgr.this.f226721d.postValue(Boolean.FALSE);
                    QQGuildLiveRoomCommMgr.this.z();
                }
            });
            return;
        }
        this.f226723f = false;
        this.f226722e = false;
        this.f226721d.postValue(Boolean.FALSE);
        z();
    }

    private static AppRuntime x() {
        return MobileQQ.sMobileQQ.peekAppRuntime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void A(@NonNull AppRuntime appRuntime) {
        TicketManager ticketManager = (TicketManager) appRuntime.getManager(2);
        if (ticketManager.useAsyncTicketInterface()) {
            ticketManager.getA2(com.tencent.guild.aio.input.at.utils.g.a(appRuntime.getCurrentUin(), 0L), 16, new a(appRuntime));
            return;
        }
        String a26 = ticketManager.getA2(appRuntime.getCurrentUin());
        QLog.i("QGL.QQGuildLiveRoomCommMgr", 1, "get login ticket suc use old");
        B(appRuntime, a26);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        GLiveChannelCore.f226698a.o().d();
        i();
        aa.c(new d(), new e());
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.g
    public long c() {
        return this.C;
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.g
    public IQQLiveSDK f() {
        return this.f226724h;
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.g
    public LiveData<Boolean> g(@NonNull final AppRuntime appRuntime) {
        QLog.i("QGL.QQGuildLiveRoomCommMgr", 1, "initLiveSDK enter :" + this.D);
        if (this.f226722e) {
            QLog.i("QGL.QQGuildLiveRoomCommMgr", 1, "initLiveSDK mQQLiveSDKInitLoginSuc == true");
            return this.f226721d;
        }
        if (this.f226723f) {
            QLog.d("QGL.QQGuildLiveRoomCommMgr", 1, "initLiveSDK mIsIniting == true");
            return this.f226721d;
        }
        this.f226723f = true;
        IQQLiveSDK sDKImpl = ((IQQLiveSDKManager) QRoute.api(IQQLiveSDKManager.class)).getSDKImpl(com.tencent.mobileqq.qqlive.business.a.f271158a);
        this.f226724h = sDKImpl;
        if (sDKImpl == null) {
            QLog.w("QGL.QQGuildLiveRoomCommMgr", 1, "get QQLiveSDK failed");
            w(false);
            return this.f226721d;
        }
        CustomData customData = new CustomData();
        customData.liveVerifyUrl = "https://accounts.qq.com/kaiyang/sms?_wv=3&appid=101955308";
        this.f226724h.init(appRuntime, QQLiveSDKConfig.createBuilder().customData(customData).build());
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.live.livemanager.r
            @Override // java.lang.Runnable
            public final void run() {
                QQGuildLiveRoomCommMgr.this.A(appRuntime);
            }
        }, 16, null, false);
        return this.f226721d;
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.g
    public boolean h() {
        return this.f226722e;
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.g
    public void i() {
        QLog.i("QGL.QQGuildLiveRoomCommMgr", 1, "destroyLiveSDK. call stack: " + QLog.getStackTraceString(new Throwable()));
        if (this.f226724h != null) {
            com.tencent.mobileqq.guild.performance.report.l.c("live_sdk_destroy");
            ((IQQLiveSDKManager) QRoute.api(IQQLiveSDKManager.class)).destroySDKImpl(com.tencent.mobileqq.qqlive.business.a.f271158a);
            this.f226721d.setValue(Boolean.FALSE);
            this.f226722e = false;
            this.f226724h = null;
            this.f226723f = false;
            this.f226725i = null;
            this.C = 0L;
            QLog.i("QGL.QQGuildLiveRoomCommMgr", 1, "destroyLiveSDK suc.");
        }
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.g
    public void j(String str, String str2) {
        IQQLiveSDK iQQLiveSDK;
        QLog.i("QGL.QQGuildLiveRoomCommMgr", 1, "getRoomRealTimeInfo roomId:" + str + " programId=" + str2);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (this.f226722e && (iQQLiveSDK = this.f226724h) != null) {
                try {
                    iQQLiveSDK.getRoomGetInfoModule().getRoomRealTimeInfo(Long.parseLong(str), str2, new f());
                    this.f226726m.g().Z();
                    return;
                } catch (NumberFormatException unused) {
                    QLog.e("QGL.QQGuildLiveRoomCommMgr", 1, "getRoomRealTimeInfo NumberFormatException:" + str);
                    return;
                }
            }
            QLog.e("QGL.QQGuildLiveRoomCommMgr", 1, "getRoomRealTimeInfo mQQLiveSDKInitLoginSuc:" + this.f226722e + " mQQLiveSDK=" + this.f226724h);
        }
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.g
    public LiveData<Boolean> k() {
        return this.f226721d;
    }

    @Override // com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(String str) {
        i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class c implements IQQLiveLoginCallback {
        c() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.BaseCallback
        public void onFailed(int i3, String str) {
            QLog.e("QGL.QQGuildLiveRoomCommMgr", 1, "LoginState callback fail code:" + i3 + " , msg:" + str);
            QQGuildLiveRoomCommMgr.this.f226722e = false;
            QQGuildLiveRoomCommMgr.this.f226721d.setValue(Boolean.FALSE);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.login.IQQLiveLoginCallback
        public void onSuccess(LoginInfo loginInfo) {
        }
    }
}
