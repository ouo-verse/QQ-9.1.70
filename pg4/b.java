package pg4;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDKManager;
import com.tencent.mobileqq.qqlive.api.config.QQLiveSDKConfigHelper;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoom;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.callback.login.IQQLiveLoginCallback;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.mobileqq.qqlive.data.login.LoginRequest;
import com.tencent.mobileqq.qqlive.data.room.realtime.EndPageRealTimeInfo;
import com.tencent.mobileqq.qqlive.data.room.realtime.MetricsType;
import com.tencent.mobileqq.qqlive.data.room.realtime.RealTimeData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.bv;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.sso.request.QQLiveGetEndPageDataRequest;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.manager.MainTicketCallback;
import mqq.manager.MainTicketInfo;
import mqq.manager.TicketManager;
import st3.f;
import st3.g;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b {

    /* renamed from: f, reason: collision with root package name */
    private static volatile b f426181f;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f426183b;

    /* renamed from: d, reason: collision with root package name */
    private IQQLiveSDK f426185d;

    /* renamed from: a, reason: collision with root package name */
    private final MutableLiveData<Boolean> f426182a = new MutableLiveData<>();

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f426184c = false;

    /* renamed from: e, reason: collision with root package name */
    private final CopyOnWriteArrayList<IResultListener<Boolean>> f426186e = new CopyOnWriteArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements MainTicketCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AppRuntime f426187a;

        a(AppRuntime appRuntime) {
            this.f426187a = appRuntime;
        }

        @Override // mqq.manager.MainTicketCallback
        public void onFail(int i3, String str) {
            QLog.i("TgLiveTag_TgLiveRoomCommonManager", 1, "initLiveSDK async get login ticket fail");
        }

        @Override // mqq.manager.MainTicketCallback
        public void onSuccess(MainTicketInfo mainTicketInfo) {
            QLog.i("TgLiveTag_TgLiveRoomCommonManager", 1, "initLiveSDK async get login ticket success");
            b.this.r(this.f426187a, mainTicketInfo.getA2());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: pg4.b$b, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public class C11015b implements IQQLiveLoginCallback {
        C11015b() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.BaseCallback
        public void onFailed(int i3, String str) {
            b.this.f426185d.getLoginModule().unregisterLoginStateCallback(this);
            l.c("TgLiveTag_TgLiveRoomCommonManager", 1, "initLiveSDK login fail - " + i3 + ", " + str);
            synchronized (b.this) {
                b.this.f426184c = false;
                b.this.f426183b = false;
                b.this.f426182a.postValue(Boolean.FALSE);
                b.this.k();
                Iterator it = b.this.f426186e.iterator();
                while (it.hasNext()) {
                    ((IResultListener) it.next()).onError(i3, str);
                }
                b.this.f426186e.clear();
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.login.IQQLiveLoginCallback
        public void onSuccess(LoginInfo loginInfo) {
            b.this.f426185d.getLoginModule().unregisterLoginStateCallback(this);
            l.h("TgLiveTag_TgLiveRoomCommonManager", 1, "initLiveSDK login success");
            synchronized (b.this) {
                b.this.f426184c = false;
                b.this.f426183b = true;
                b.this.f426182a.postValue(Boolean.TRUE);
                Iterator it = b.this.f426186e.iterator();
                while (it.hasNext()) {
                    ((IResultListener) it.next()).onSuccess(Boolean.valueOf(b.this.f426183b));
                }
                b.this.f426186e.clear();
            }
        }
    }

    private static EndPageRealTimeInfo j(st3.b bVar) {
        st3.c cVar;
        EndPageRealTimeInfo endPageRealTimeInfo = new EndPageRealTimeInfo();
        ArrayList arrayList = new ArrayList();
        g gVar = bVar.f434719b;
        if (gVar != null && (cVar = bVar.f434718a) != null && cVar.f434722c != null && cVar.f434723d != null) {
            endPageRealTimeInfo.roomID = cVar.f434720a;
            endPageRealTimeInfo.programID = cVar.f434721b;
            endPageRealTimeInfo.logoURL = gVar.f434732a;
            endPageRealTimeInfo.nickName = gVar.f434733b;
            RealTimeData realTimeData = new RealTimeData();
            realTimeData.type = MetricsType.TOTAL_LIVE_TIME;
            realTimeData.value = bVar.f434718a.f434723d.f434727c;
            realTimeData.name = bVar.f434719b.f434733b;
            arrayList.add(realTimeData);
            for (f fVar : bVar.f434718a.f434722c.f434724a) {
                RealTimeData realTimeData2 = new RealTimeData();
                switch (fVar.f434729a) {
                    case 1:
                        realTimeData2.type = MetricsType.GIFT_AMOUNT;
                        realTimeData2.value = fVar.f434731c;
                        realTimeData2.name = fVar.f434730b;
                        arrayList.add(realTimeData2);
                        break;
                    case 2:
                        realTimeData2.type = MetricsType.NEW_FANS_NUM;
                        realTimeData2.value = fVar.f434731c;
                        realTimeData2.name = fVar.f434730b;
                        arrayList.add(realTimeData2);
                        break;
                    case 3:
                        realTimeData2.type = MetricsType.CUMULATIVE_UV;
                        realTimeData2.value = fVar.f434731c;
                        realTimeData2.name = fVar.f434730b;
                        arrayList.add(realTimeData2);
                        break;
                    case 4:
                        realTimeData2.type = MetricsType.COMMENT_NUM;
                        realTimeData2.value = fVar.f434731c;
                        realTimeData2.name = fVar.f434730b;
                        arrayList.add(realTimeData2);
                        break;
                    case 5:
                        realTimeData2.type = MetricsType.GIFT_GIVER_NUM;
                        realTimeData2.value = fVar.f434731c;
                        realTimeData2.name = fVar.f434730b;
                        arrayList.add(realTimeData2);
                        break;
                    case 6:
                        realTimeData2.type = MetricsType.NUM_OF_LIKE;
                        realTimeData2.value = fVar.f434731c;
                        realTimeData2.name = fVar.f434730b;
                        arrayList.add(realTimeData2);
                        break;
                }
            }
            endPageRealTimeInfo.items = arrayList;
        }
        return endPageRealTimeInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        l.h("TgLiveTag_TgLiveRoomCommonManager", 1, "destroyLiveSDK");
        com.tencent.timi.game.initer.impl.b.f377190a.b(QQLiveSDKConfigHelper.getSceneId());
        if (this.f426185d != null) {
            ((IQQLiveSDKManager) QRoute.api(IQQLiveSDKManager.class)).destroySDKImpl(com.tencent.mobileqq.qqlive.business.a.f271158a);
            this.f426182a.setValue(Boolean.FALSE);
            this.f426183b = false;
            this.f426185d = null;
            this.f426184c = false;
        }
        mg4.c.g().e();
    }

    public static b l() {
        if (f426181f == null) {
            synchronized (b.class) {
                if (f426181f == null) {
                    f426181f = new b();
                }
            }
        }
        return f426181f;
    }

    public static void n(@NonNull ILiveRoom iLiveRoom, final IResultListener<EndPageRealTimeInfo> iResultListener) {
        long j3;
        String str;
        l.i("TgLiveTag_TgLiveRoomCommonManager", "getRealTimeInfoForEndLiveUI.");
        if (iLiveRoom.getAnchorInfo() != null) {
            j3 = iLiveRoom.getAnchorInfo().getAnchorUid();
        } else {
            j3 = 0;
        }
        if (iLiveRoom.getRoomInfo() != null) {
            str = iLiveRoom.getRoomInfo().getProgramId();
        } else {
            str = "";
        }
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new QQLiveGetEndPageDataRequest(j3, str), new ILiveNetRequest.Callback() { // from class: pg4.a
            @Override // com.tencent.mobileqq.qqlive.api.ILiveNetRequest.Callback
            public final void onResponse(QQLiveResponse qQLiveResponse) {
                b.q(IResultListener.this, qQLiveResponse);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void q(IResultListener iResultListener, QQLiveResponse qQLiveResponse) {
        st3.b bVar = (st3.b) qQLiveResponse.getRsp();
        if (!qQLiveResponse.isFailed() && bVar != null) {
            iResultListener.onSuccess(j(bVar));
            return;
        }
        long retCode = qQLiveResponse.getRetCode();
        String errMsg = qQLiveResponse.getErrMsg();
        l.e("TgLiveTag_TgLiveRoomCommonManager", "getRealTimeInfo fail. code=" + retCode + " msg=" + errMsg);
        iResultListener.onError((int) retCode, errMsg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(@NonNull AppRuntime appRuntime, String str) {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.uin = appRuntime.getCurrentUin();
        loginRequest.qqA2 = str;
        loginRequest.authAppId = QQLiveSDKConfigHelper.getLoginAuthAppId();
        loginRequest.extData = QQLiveSDKConfigHelper.getLoginExtData();
        this.f426185d.getLoginModule().login(loginRequest, new C11015b());
    }

    public IQQLiveSDK m() {
        return this.f426185d;
    }

    public LiveData<Boolean> o(@NonNull AppRuntime appRuntime, IResultListener<Boolean> iResultListener) {
        l.h("TgLiveTag_TgLiveRoomCommonManager", 1, "initLiveSDK enter - mQQLiveSDKInitLoginSuc = " + this.f426183b + ", mIsIniting = " + this.f426184c);
        synchronized (this) {
            if (this.f426183b) {
                if (iResultListener != null) {
                    iResultListener.onSuccess(Boolean.valueOf(this.f426183b));
                }
                return this.f426182a;
            }
            if (this.f426184c) {
                this.f426186e.add(iResultListener);
                return this.f426182a;
            }
            this.f426184c = true;
            this.f426186e.add(iResultListener);
            IQQLiveSDK sDKImpl = ((IQQLiveSDKManager) QRoute.api(IQQLiveSDKManager.class)).getSDKImpl(qg4.f.f428917a);
            this.f426185d = sDKImpl;
            if (sDKImpl != null) {
                sDKImpl.init(appRuntime, QQLiveSDKConfigHelper.getDefIQQLiveSDK());
                com.tencent.timi.game.initer.impl.b.f377190a.f(QQLiveSDKConfigHelper.getSceneId());
                TicketManager ticketManager = (TicketManager) appRuntime.getManager(2);
                if (ticketManager.useAsyncTicketInterface()) {
                    ticketManager.getA2(bv.b(appRuntime.getCurrentUin(), 0L), 16, new a(appRuntime));
                } else {
                    String a26 = ticketManager.getA2(appRuntime.getCurrentUin());
                    QLog.i("TgLiveTag_TgLiveRoomCommonManager", 1, "initLiveSDK sync get login ticket");
                    r(appRuntime, a26);
                }
            }
            return this.f426182a;
        }
    }

    public boolean p() {
        return this.f426183b;
    }
}
