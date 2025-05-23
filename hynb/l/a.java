package hynb.l;

import com.huya.huyasdk.api.HuyaGetSubscribeStatusRequest;
import com.huya.huyasdk.api.HuyaGetSubscribeStatusResponse;
import com.huya.huyasdk.api.HuyaPresenterSubscriptionInfo;
import com.huya.huyasdk.api.HuyaPresenterSubscriptionRequest;
import com.huya.huyasdk.api.HuyaPresenterSubscriptionResponse;
import com.huya.huyasdk.api.HuyaPresenterUnsubscriptionRequest;
import com.huya.huyasdk.api.SubscribeActionCallback;
import com.huya.huyasdk.api.SubscribeCallback;
import com.huya.huyasdk.api.SubscribeStatusCallback;
import com.huya.huyasdk.data.HYNSRequest;
import com.huya.huyasdk.data.RegisterResultInfo;
import com.huya.huyasdk.jce.OpenGetSubscribeStatusReq;
import com.huya.huyasdk.jce.OpenGetSubscribeStatusRsp;
import com.huya.huyasdk.jce.OpenSubscribeReq;
import com.huya.huyasdk.jce.OpenSubscribeRsp;
import com.huya.huyasdk.jce.OpenSubscribedNotice;
import com.huya.huyasdk.service.api.ILoginService;
import hynb.b.g;
import hynb.b.h;
import hynb.b.i;
import hynb.b.l;
import hynb.j.d;
import hynb.p.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a {

    /* renamed from: d, reason: collision with root package name */
    public static a f406746d = new a();

    /* renamed from: a, reason: collision with root package name */
    public SubscribeCallback f406747a = null;

    /* renamed from: b, reason: collision with root package name */
    public final Set<Long> f406748b = new HashSet();

    /* renamed from: c, reason: collision with root package name */
    public final hynb.g.a f406749c = new hynb.g.a() { // from class: w15.a
        @Override // hynb.g.a
        public final void a(int i3, Object obj) {
            hynb.l.a.this.a(i3, obj);
        }
    };

    /* compiled from: P */
    /* renamed from: hynb.l.a$a, reason: collision with other inner class name */
    /* loaded from: classes28.dex */
    public class C10486a implements g {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f406750a;

        public C10486a(long j3) {
            this.f406750a = j3;
        }

        @Override // hynb.b.g
        public void a(RegisterResultInfo registerResultInfo) {
            hynb.p.g.f406799a.info("HuyaSubscribeImpl", "register group success");
            if (!a.this.f406748b.contains(Long.valueOf(this.f406750a))) {
                return;
            }
            hynb.g.b.f406712m.a(3141, OpenSubscribedNotice.class);
            hynb.g.b.f406712m.a(a.this.f406749c);
            hynb.g.b.f406712m.b("HuyaSubscribeImpl");
        }

        @Override // hynb.b.g
        public void b(RegisterResultInfo registerResultInfo) {
            hynb.p.g.f406799a.info("HuyaSubscribeImpl", "register group failed");
            a.this.f406748b.remove(Long.valueOf(this.f406750a));
        }
    }

    public synchronized void b(long j3) {
        if (!this.f406748b.add(Long.valueOf(j3))) {
            hynb.p.g.f406799a.c("HuyaSubscribeImpl", "pid: %s, push already enabled", Long.valueOf(j3));
            return;
        }
        String str = "open_" + hynb.n.a.a().f406767a.f406781n + ":" + j3;
        hynb.p.g.f406799a.a("HuyaSubscribeImpl", "enablePush, register group for " + str);
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        hynb.g.b.f406712m.a("HuyaSubscribeImpl", arrayList, new C10486a(j3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i3, Object obj) {
        if (i3 == 3141) {
            OpenSubscribedNotice openSubscribedNotice = (OpenSubscribedNotice) obj;
            hynb.p.g.f406799a.a("HuyaSubscribeImpl", "onEvent, OpenSubscribedNotice: " + openSubscribedNotice);
            if (this.f406747a != null) {
                HuyaPresenterSubscriptionInfo huyaPresenterSubscriptionInfo = new HuyaPresenterSubscriptionInfo();
                huyaPresenterSubscriptionInfo.presenterUid = openSubscribedNotice.lSubscribeToUid;
                huyaPresenterSubscriptionInfo.subscriberUid = openSubscribedNotice.lSubscribeFromUid;
                huyaPresenterSubscriptionInfo.subscriberNick = openSubscribedNotice.sSubscribeFromNick;
                huyaPresenterSubscriptionInfo.subscriberAvatar = openSubscribedNotice.sSubscribeFromAvatar;
                this.f406747a.onSubscriptionInfoNotify(huyaPresenterSubscriptionInfo);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class b implements h<OpenGetSubscribeStatusRsp> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SubscribeStatusCallback f406752a;

        public b(a aVar, SubscribeStatusCallback subscribeStatusCallback) {
            this.f406752a = subscribeStatusCallback;
        }

        @Override // hynb.b.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(OpenGetSubscribeStatusRsp openGetSubscribeStatusRsp) {
            hynb.p.g.f406799a.a("HuyaSubscribeImpl", "callGetSubscribeStatus, response: " + openGetSubscribeStatusRsp);
            HuyaGetSubscribeStatusResponse huyaGetSubscribeStatusResponse = new HuyaGetSubscribeStatusResponse();
            huyaGetSubscribeStatusResponse.status = openGetSubscribeStatusRsp.iStatus;
            SubscribeStatusCallback subscribeStatusCallback = this.f406752a;
            if (subscribeStatusCallback != null) {
                subscribeStatusCallback.onSubscribeStatusResponse(huyaGetSubscribeStatusResponse, null);
            }
        }

        @Override // hynb.b.h
        public Class<OpenGetSubscribeStatusRsp> getResponseClass() {
            return OpenGetSubscribeStatusRsp.class;
        }

        @Override // hynb.b.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(int i3, String str, OpenGetSubscribeStatusRsp openGetSubscribeStatusRsp) {
            hynb.p.g.f406799a.c("HuyaSubscribeImpl", "callGetSubscribeStatus, onError, retValue: %s, errMsg: %s, rsp: %s", Integer.valueOf(i3), str, openGetSubscribeStatusRsp);
            SubscribeStatusCallback subscribeStatusCallback = this.f406752a;
            if (subscribeStatusCallback != null) {
                subscribeStatusCallback.onSubscribeStatusResponse(null, new IllegalStateException(str));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class c implements h<OpenSubscribeRsp> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SubscribeActionCallback f406753a;

        public c(a aVar, SubscribeActionCallback subscribeActionCallback) {
            this.f406753a = subscribeActionCallback;
        }

        @Override // hynb.b.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(OpenSubscribeRsp openSubscribeRsp) {
            hynb.p.g.f406799a.info("HuyaSubscribeImpl", "doCallSubscribeAction, onResponse, rsp: " + openSubscribeRsp);
            if (this.f406753a != null) {
                HuyaPresenterSubscriptionResponse huyaPresenterSubscriptionResponse = new HuyaPresenterSubscriptionResponse();
                huyaPresenterSubscriptionResponse.success = true;
                huyaPresenterSubscriptionResponse.message = openSubscribeRsp.sMessage;
                this.f406753a.onSubscriptionResponse(huyaPresenterSubscriptionResponse, null);
            }
        }

        @Override // hynb.b.h
        public Class<OpenSubscribeRsp> getResponseClass() {
            return OpenSubscribeRsp.class;
        }

        @Override // hynb.b.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(int i3, String str, OpenSubscribeRsp openSubscribeRsp) {
            hynb.p.g.f406799a.b("HuyaSubscribeImpl", "doCallSubscribeAction, onError, retValue: %s, errMsg: %s, rsp: %s", Integer.valueOf(i3), str, openSubscribeRsp);
            if (this.f406753a != null) {
                if (openSubscribeRsp != null) {
                    str = openSubscribeRsp.sMessage;
                }
                HuyaPresenterSubscriptionResponse huyaPresenterSubscriptionResponse = new HuyaPresenterSubscriptionResponse();
                huyaPresenterSubscriptionResponse.success = false;
                huyaPresenterSubscriptionResponse.message = str;
                this.f406753a.onSubscriptionResponse(huyaPresenterSubscriptionResponse, new IllegalStateException(str));
            }
        }
    }

    public void a(SubscribeCallback subscribeCallback) {
        this.f406747a = subscribeCallback;
    }

    public synchronized void a(long j3) {
        if (!this.f406748b.remove(Long.valueOf(j3))) {
            hynb.p.g.f406799a.info("HuyaSubscribeImpl", "push already disabled");
            return;
        }
        String str = "open_" + hynb.n.a.a().f406767a.f406781n + ":" + j3;
        hynb.p.g.f406799a.a("HuyaSubscribeImpl", "disablePush, unregister group for " + str);
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        hynb.g.b.f406712m.a("HuyaSubscribeImpl", arrayList, (i) null);
        hynb.g.b.f406712m.a(3141);
        hynb.g.b.f406712m.b(this.f406749c);
        hynb.g.b.f406712m.a("HuyaSubscribeImpl");
    }

    public void a(HuyaPresenterSubscriptionRequest huyaPresenterSubscriptionRequest, SubscribeActionCallback subscribeActionCallback) {
        e eVar = hynb.p.g.f406799a;
        eVar.a("HuyaSubscribeImpl", "callSubscribeAction, request: " + huyaPresenterSubscriptionRequest);
        if (huyaPresenterSubscriptionRequest == null) {
            eVar.error("HuyaSubscribeImpl", "callGetSubscribeStatus, request is null");
            if (subscribeActionCallback != null) {
                subscribeActionCallback.onSubscriptionResponse(null, new NullPointerException("request is null"));
                return;
            }
            return;
        }
        if (!((ILoginService) d.a(ILoginService.class)).isLogin()) {
            eVar.error("HuyaSubscribeImpl", "callGetSubscribeStatus, not login");
            if (subscribeActionCallback != null) {
                subscribeActionCallback.onSubscriptionResponse(null, new IllegalStateException("not login"));
                return;
            }
            return;
        }
        OpenSubscribeReq openSubscribeReq = new OpenSubscribeReq();
        openSubscribeReq.tId = hynb.o.e.a(((ILoginService) d.a(ILoginService.class)).getLoginUid());
        openSubscribeReq.lToUid = huyaPresenterSubscriptionRequest.subscribedUid;
        openSubscribeReq.sFromNick = huyaPresenterSubscriptionRequest.subscriberNick;
        openSubscribeReq.sFromAvatar = huyaPresenterSubscriptionRequest.subscriberAvatarUrl;
        openSubscribeReq.iAction = 1;
        a(openSubscribeReq, subscribeActionCallback);
    }

    public void a(HuyaPresenterUnsubscriptionRequest huyaPresenterUnsubscriptionRequest, SubscribeActionCallback subscribeActionCallback) {
        e eVar = hynb.p.g.f406799a;
        eVar.a("HuyaSubscribeImpl", "callUnsubscribeAction, request: " + huyaPresenterUnsubscriptionRequest);
        if (huyaPresenterUnsubscriptionRequest == null) {
            eVar.error("HuyaSubscribeImpl", "callGetSubscribeStatus, request is null");
            if (subscribeActionCallback != null) {
                subscribeActionCallback.onSubscriptionResponse(null, new NullPointerException("request is null"));
                return;
            }
            return;
        }
        if (!((ILoginService) d.a(ILoginService.class)).isLogin()) {
            eVar.error("HuyaSubscribeImpl", "callGetSubscribeStatus, not login");
            if (subscribeActionCallback != null) {
                subscribeActionCallback.onSubscriptionResponse(null, new IllegalStateException("not login"));
                return;
            }
            return;
        }
        OpenSubscribeReq openSubscribeReq = new OpenSubscribeReq();
        openSubscribeReq.tId = hynb.o.e.a(((ILoginService) d.a(ILoginService.class)).getLoginUid());
        openSubscribeReq.lToUid = huyaPresenterUnsubscriptionRequest.subscribedUid;
        openSubscribeReq.iAction = 2;
        a(openSubscribeReq, subscribeActionCallback);
    }

    public void a(HuyaGetSubscribeStatusRequest huyaGetSubscribeStatusRequest, SubscribeStatusCallback subscribeStatusCallback) {
        e eVar = hynb.p.g.f406799a;
        eVar.a("HuyaSubscribeImpl", "callGetSubscribeStatus, request: " + huyaGetSubscribeStatusRequest);
        if (huyaGetSubscribeStatusRequest == null) {
            eVar.error("HuyaSubscribeImpl", "callGetSubscribeStatus, request is null");
            if (subscribeStatusCallback != null) {
                subscribeStatusCallback.onSubscribeStatusResponse(null, new NullPointerException("request is null"));
                return;
            }
            return;
        }
        if (!((ILoginService) d.a(ILoginService.class)).isLogin()) {
            eVar.error("HuyaSubscribeImpl", "callGetSubscribeStatus, not login");
            if (subscribeStatusCallback != null) {
                subscribeStatusCallback.onSubscribeStatusResponse(null, new IllegalStateException("not login"));
                return;
            }
            return;
        }
        OpenGetSubscribeStatusReq openGetSubscribeStatusReq = new OpenGetSubscribeStatusReq();
        openGetSubscribeStatusReq.tId = hynb.o.e.a(((ILoginService) d.a(ILoginService.class)).getLoginUid());
        openGetSubscribeStatusReq.lToUid = huyaGetSubscribeStatusRequest.subscribedUid;
        l.i().b(new HYNSRequest.Builder().sServantName("wupui").sFuncName("openGetSubscribeStatus").jsonBodyObj(openGetSubscribeStatusReq).build(), new b(this, subscribeStatusCallback));
    }

    public final void a(OpenSubscribeReq openSubscribeReq, SubscribeActionCallback subscribeActionCallback) {
        hynb.p.g.f406799a.info("HuyaSubscribeImpl", "doCallSubscribeAction, req: " + openSubscribeReq);
        l.i().b(new HYNSRequest.Builder().sServantName("wupui").sFuncName("openSubscribe").jsonBodyObj(openSubscribeReq).build(), new c(this, subscribeActionCallback));
    }
}
