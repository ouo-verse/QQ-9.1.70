package mu0;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import b32.d;
import com.tencent.avbiz.AVBizModuleFactory;
import com.tencent.icgame.game.utils.g;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.IQQLiveSDKManager;
import com.tencent.mobileqq.icgame.api.config.QQLiveSDKConfigHelper;
import com.tencent.mobileqq.icgame.api.room.ILiveRoom;
import com.tencent.mobileqq.icgame.data.login.LoginInfo;
import com.tencent.mobileqq.qqlive.data.login.LoginRequest;
import com.tencent.mobileqq.qqlive.data.room.realtime.EndPageRealTimeInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.bv;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.utils.IResultListener;
import hu0.f;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.manager.MainTicketCallback;
import mqq.manager.MainTicketInfo;
import mqq.manager.TicketManager;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a {

    /* renamed from: g, reason: collision with root package name */
    private static volatile a f417599g;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f417601b;

    /* renamed from: d, reason: collision with root package name */
    private IQQLiveSDK f417603d;

    /* renamed from: a, reason: collision with root package name */
    private final MutableLiveData<Boolean> f417600a = new MutableLiveData<>();

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f417602c = false;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f417604e = false;

    /* renamed from: f, reason: collision with root package name */
    private final CopyOnWriteArrayList<IResultListener<Boolean>> f417605f = new CopyOnWriteArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: mu0.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C10805a implements MainTicketCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AppRuntime f417606a;

        C10805a(AppRuntime appRuntime) {
            this.f417606a = appRuntime;
        }

        @Override // mqq.manager.MainTicketCallback
        public void onFail(int i3, String str) {
            QLog.i("ICGameTgLiveTag_ICGameTgLiveRoomCommonManager", 1, "initLiveSDK async get login ticket fail");
        }

        @Override // mqq.manager.MainTicketCallback
        public void onSuccess(MainTicketInfo mainTicketInfo) {
            QLog.i("ICGameTgLiveTag_ICGameTgLiveRoomCommonManager", 1, "initLiveSDK async get login ticket success");
            a.this.p(this.f417606a, mainTicketInfo.getA2());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class b implements w22.a {
        b() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.BaseCallback
        public void onFailed(int i3, String str) {
            a.this.f417603d.getLoginModule().unregisterLoginStateCallback(this);
            g.b("ICGameTgLiveTag_ICGameTgLiveRoomCommonManager", 1, "initLiveSDK login fail - " + i3 + ", " + str);
            synchronized (a.this) {
                a.this.f417602c = false;
                a.this.f417601b = false;
                a.this.f417600a.postValue(Boolean.FALSE);
                a.this.i();
                Iterator it = a.this.f417605f.iterator();
                while (it.hasNext()) {
                    ((IResultListener) it.next()).onError(i3, str);
                }
                a.this.f417605f.clear();
            }
        }

        @Override // w22.a
        public void onSuccess(LoginInfo loginInfo) {
            a.this.f417603d.getLoginModule().unregisterLoginStateCallback(this);
            g.g("ICGameTgLiveTag_ICGameTgLiveRoomCommonManager", 1, "initLiveSDK login success - " + loginInfo);
            synchronized (a.this) {
                a.this.f417602c = false;
                a.this.f417601b = true;
                a.this.f417600a.postValue(Boolean.TRUE);
                Iterator it = a.this.f417605f.iterator();
                while (it.hasNext()) {
                    ((IResultListener) it.next()).onSuccess(Boolean.valueOf(a.this.f417601b));
                }
                a.this.f417605f.clear();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class c implements d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener f417609a;

        c(IResultListener iResultListener) {
            this.f417609a = iResultListener;
        }

        @Override // b32.d
        public void onFailed(int i3, String str) {
            g.d("ICGameTgLiveTag_ICGameTgLiveRoomCommonManager", "getRealTimeInfo fail. code=" + i3 + " msg=" + str);
            IResultListener iResultListener = this.f417609a;
            if (iResultListener != null) {
                iResultListener.onError(i3, str);
            }
        }

        @Override // b32.d
        public void onSuccess(EndPageRealTimeInfo endPageRealTimeInfo) {
            g.h("ICGameTgLiveTag_ICGameTgLiveRoomCommonManager", "getRealTimeInfo suc.");
            IResultListener iResultListener = this.f417609a;
            if (iResultListener != null) {
                iResultListener.onSuccess(endPageRealTimeInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        g.g("ICGameTgLiveTag_ICGameTgLiveRoomCommonManager", 1, "destroyLiveSDK");
        com.tencent.icgame.game.initer.impl.b.f115068a.a(QQLiveSDKConfigHelper.getSceneId());
        if (this.f417603d != null) {
            ((IQQLiveSDKManager) QRoute.api(IQQLiveSDKManager.class)).destroySDKImpl(r22.a.f430572a);
            this.f417600a.setValue(Boolean.FALSE);
            this.f417601b = false;
            this.f417603d = null;
            this.f417602c = false;
        }
    }

    public static a k() {
        if (f417599g == null) {
            synchronized (a.class) {
                if (f417599g == null) {
                    f417599g = new a();
                }
            }
        }
        return f417599g;
    }

    public static void m(@NonNull ILiveRoom iLiveRoom, IResultListener<EndPageRealTimeInfo> iResultListener) {
        g.h("ICGameTgLiveTag_ICGameTgLiveRoomCommonManager", "getRealTimeInfoForEndLiveUI.");
        iLiveRoom.getLiveEndPageInfo(new c(iResultListener));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(@NonNull AppRuntime appRuntime, String str) {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.uin = appRuntime.getCurrentUin();
        loginRequest.qqA2 = str;
        loginRequest.authAppId = QQLiveSDKConfigHelper.getLoginAuthAppId();
        loginRequest.extData = QQLiveSDKConfigHelper.getLoginExtData();
        this.f417603d.getLoginModule().login(loginRequest, new b());
    }

    public void j(IResultListener<EndPageRealTimeInfo> iResultListener) {
        if (this.f417604e) {
            return;
        }
        this.f417604e = true;
        try {
            if (((fu0.c) qx0.a.b(fu0.c.class)).N(0L) != null) {
                f.s().h(0L, iResultListener);
            }
            i();
            this.f417604e = false;
            AVBizModuleFactory.getModuleByName("\u4e92\u52a8\u4e91\u73a9\u6cd5").abandonAVFocus();
            AVBizModuleFactory.removeModuleByName("\u4e92\u52a8\u4e91\u73a9\u6cd5");
        } catch (Throwable th5) {
            this.f417604e = false;
            throw th5;
        }
    }

    public IQQLiveSDK l() {
        return this.f417603d;
    }

    public LiveData<Boolean> n(@NonNull AppRuntime appRuntime, IResultListener<Boolean> iResultListener) {
        g.g("ICGameTgLiveTag_ICGameTgLiveRoomCommonManager", 1, "initLiveSDK enter - mQQLiveSDKInitLoginSuc = " + this.f417601b + ", mIsIniting = " + this.f417602c);
        synchronized (this) {
            if (this.f417601b) {
                if (iResultListener != null) {
                    iResultListener.onSuccess(Boolean.valueOf(this.f417601b));
                }
                return this.f417600a;
            }
            if (this.f417602c) {
                this.f417605f.add(iResultListener);
                return this.f417600a;
            }
            this.f417602c = true;
            this.f417605f.add(iResultListener);
            IQQLiveSDK sDKImpl = ((IQQLiveSDKManager) QRoute.api(IQQLiveSDKManager.class)).getSDKImpl(nu0.b.f421286a);
            this.f417603d = sDKImpl;
            if (sDKImpl != null) {
                sDKImpl.init(appRuntime, QQLiveSDKConfigHelper.getDefIQQLiveSDK());
                com.tencent.icgame.game.initer.impl.b.f115068a.d(QQLiveSDKConfigHelper.getSceneId());
                TicketManager ticketManager = (TicketManager) appRuntime.getManager(2);
                if (ticketManager.useAsyncTicketInterface()) {
                    ticketManager.getA2(bv.b(appRuntime.getCurrentUin(), 0L), 16, new C10805a(appRuntime));
                } else {
                    String a26 = ticketManager.getA2(appRuntime.getCurrentUin());
                    QLog.i("ICGameTgLiveTag_ICGameTgLiveRoomCommonManager", 1, "initLiveSDK sync get login ticket");
                    p(appRuntime, a26);
                }
            }
            return this.f417600a;
        }
    }

    public boolean o() {
        return this.f417601b;
    }
}
