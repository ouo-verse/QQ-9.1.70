package cooperation.vip.ad;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import androidx.core.util.Consumer;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.activity.home.chats.biz.tianshu.TianShuConversationThirdView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IPageSceneADManagerApi;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchServer;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.vip.ad.event.TianshuAdRequestEvent;
import cooperation.vip.ad.processors.QQPushNotifyProcessor;
import cooperation.vip.ad.processors.TianshuSplashProcessor;
import cooperation.vip.pb.TianShuAccess;
import cooperation.vip.tianshu.TianShuManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes28.dex */
public class TianshuNewAdManager implements SimpleEventReceiver {
    private Handler E;

    /* renamed from: d, reason: collision with root package name */
    private cooperation.vip.ad.processors.h f391056d;

    /* renamed from: e, reason: collision with root package name */
    private QQPushNotifyProcessor f391057e;

    /* renamed from: f, reason: collision with root package name */
    private long f391058f;

    /* renamed from: h, reason: collision with root package name */
    private long f391059h;

    /* renamed from: i, reason: collision with root package name */
    private b f391060i;

    /* renamed from: m, reason: collision with root package name */
    private final List<cooperation.vip.ad.processors.a> f391061m = Collections.synchronizedList(new ArrayList());
    private final Map<Integer, TianShuGetAdvCallback> C = Collections.synchronizedMap(new HashMap());
    private boolean D = false;
    private String F = "";
    private Boolean G = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class a extends com.tencent.mobileqq.tianshu.data.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f391067e;

        a(int i3) {
            this.f391067e = i3;
        }

        @Override // com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback
        public void onGetAdvs(boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
            TianshuNewAdManager.this.l(z16, getAdsRsp, this.f293074d, this.f391067e);
        }
    }

    public TianshuNewAdManager() {
        this.f391058f = 120L;
        this.E = null;
        m();
        SimpleEventBus.getInstance().registerReceiver(this);
        try {
            this.f391058f = Integer.parseInt(VasToggle.getStringData(VasToggle.VAS_GUIDE_TIME_INTERVAL, String.valueOf(this.f391058f)));
        } catch (NumberFormatException e16) {
            QLog.e("TianshuNewAdManager", 1, "number format error, e = " + e16);
        }
        QLog.d("TianshuNewAdManager", 1, "mConfigIntervalTime = " + this.f391058f);
        if (GuardManager.sInstance != null) {
            b bVar = new b(this);
            this.f391060i = bVar;
            GuardManager.sInstance.registerCallBack(bVar);
        }
        this.E = new Handler(Looper.getMainLooper());
        ((IPageSceneADManagerApi) QRoute.api(IPageSceneADManagerApi.class)).init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(boolean z16, final TianShuAccess.GetAdsRsp getAdsRsp, final String str, final int i3) {
        List<TianShuAccess.RspEntry> list;
        boolean z17 = false;
        if (z16 && getAdsRsp != null) {
            if (getAdsRsp.mapAds.has()) {
                list = getAdsRsp.mapAds.get();
            } else {
                list = null;
            }
            if (list == null) {
                QLog.d("TianshuNewAdManager", 1, "handlerTianshuAdRsp , rspEntries = null, traceId:", str);
                return;
            }
            final HashMap hashMap = new HashMap();
            for (TianShuAccess.RspEntry rspEntry : list) {
                if (rspEntry != null && rspEntry.key.has()) {
                    hashMap.put(Integer.valueOf(rspEntry.key.get()), rspEntry);
                }
            }
            k(new Consumer() { // from class: cooperation.vip.ad.t
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    TianshuNewAdManager.this.o(i3, hashMap, getAdsRsp, str, (cooperation.vip.ad.processors.a) obj);
                }
            });
            return;
        }
        Object[] objArr = new Object[4];
        objArr[0] = "dispatchAdResponse fail, result: ";
        objArr[1] = Boolean.valueOf(z16);
        objArr[2] = "getAdRsp == null:";
        if (getAdsRsp == null) {
            z17 = true;
        }
        objArr[3] = Boolean.valueOf(z17);
        QLog.d("TianshuNewAdManager", 1, objArr);
    }

    private void m() {
        cooperation.vip.ad.processors.h hVar = new cooperation.vip.ad.processors.h();
        this.f391056d = hVar;
        this.f391061m.add(hVar);
        this.f391061m.add(new cooperation.vip.ad.processors.j());
        this.f391061m.add(new cooperation.vip.ad.processors.l());
        this.f391061m.add(new cooperation.vip.ad.processors.g());
        this.f391061m.add(new cooperation.vip.ad.processors.b());
        QQPushNotifyProcessor qQPushNotifyProcessor = new QQPushNotifyProcessor();
        this.f391057e = qQPushNotifyProcessor;
        this.f391061m.add(qQPushNotifyProcessor);
        this.f391061m.add(new cooperation.vip.ad.processors.f());
        if (i.k()) {
            this.f391061m.add(new TianshuSplashProcessor());
        }
    }

    private boolean n() {
        if (this.G == null) {
            this.G = Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("tianshu_red_request_foreground", true));
        }
        return this.G.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(final int i3, Map map, final TianShuAccess.GetAdsRsp getAdsRsp, final String str, final cooperation.vip.ad.processors.a aVar) {
        if (!aVar.h(i3)) {
            return;
        }
        final HashMap hashMap = new HashMap();
        for (int i16 : aVar.f()) {
            hashMap.put(Integer.valueOf(i16), (TianShuAccess.RspEntry) map.get(Integer.valueOf(i16)));
        }
        if (RFWThreadManager.isMainThread()) {
            aVar.i(getAdsRsp, hashMap, str, i3);
        } else {
            this.E.post(new Runnable() { // from class: cooperation.vip.ad.TianshuNewAdManager.2
                @Override // java.lang.Runnable
                public void run() {
                    aVar.i(getAdsRsp, hashMap, str, i3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void q(int i3, List list, cooperation.vip.ad.processors.a aVar) {
        if (aVar.c(i3)) {
            list.addAll(aVar.d(i3));
            aVar.g(System.currentTimeMillis());
        }
    }

    private boolean r(int i3) {
        if (!i.i().booleanValue()) {
            return false;
        }
        if (i3 == 1) {
            this.F = RFWApplication.getAccountId();
        } else if (!this.F.equals(RFWApplication.getAccountId())) {
            QLog.d("TianshuNewAdManager", 1, "currentUin is not equals");
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        QQPushNotifyProcessor qQPushNotifyProcessor = this.f391057e;
        if (qQPushNotifyProcessor != null) {
            qQPushNotifyProcessor.y();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        QQPushNotifyProcessor qQPushNotifyProcessor = this.f391057e;
        if (qQPushNotifyProcessor != null) {
            qQPushNotifyProcessor.z();
        }
        QQAppInterface b16 = i.b();
        if (b16 != null && b16.isLogin() && MobileQQ.sProcessId == 1) {
            ((IRedTouchManager) b16.getRuntimeService(IRedTouchManager.class, "")).checkMsgExpire();
            ((IRedTouchServer) b16.getRuntimeService(IRedTouchServer.class, "")).sendRedpointReq(n(), true, 2);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(TianshuAdRequestEvent.class);
        return arrayList;
    }

    public void j() {
        cooperation.vip.ad.processors.h hVar = this.f391056d;
        if (hVar != null) {
            hVar.k();
        }
    }

    public void k(Consumer<cooperation.vip.ad.processors.a> consumer) {
        ListIterator<cooperation.vip.ad.processors.a> listIterator = this.f391061m.listIterator();
        while (listIterator.hasNext()) {
            cooperation.vip.ad.processors.a next = listIterator.next();
            if (next != null) {
                consumer.accept(next);
            }
        }
    }

    public void onDestroy() {
        k(new Consumer() { // from class: cooperation.vip.ad.s
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                ((cooperation.vip.ad.processors.a) obj).onDestroy();
            }
        });
        Iterator<Map.Entry<Integer, TianShuGetAdvCallback>> it = this.C.entrySet().iterator();
        while (it.hasNext()) {
            TianShuManager.getInstance().removeAdvCallback(it.next().getValue());
        }
        this.C.clear();
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null) {
            guardManager.unregisterCallback(this.f391060i);
        }
        this.E.removeCallbacksAndMessages(null);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        TianShuManager.getInstance().onDestroy();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof TianshuAdRequestEvent) {
            v(((TianshuAdRequestEvent) simpleBaseEvent).getTime());
        }
    }

    public void s(QQAppInterface qQAppInterface) {
        TianShuManager.getInstance().onAccountChanged();
        GrowHalfLayerHelper.m();
        k(new Consumer() { // from class: cooperation.vip.ad.r
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                ((cooperation.vip.ad.processors.a) obj).onAccountChange();
            }
        });
    }

    public void v(final int i3) {
        k(new Consumer() { // from class: cooperation.vip.ad.p
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                ((cooperation.vip.ad.processors.a) obj).b(i3);
            }
        });
        if (r(i3)) {
            QLog.d("TianshuNewAdManager", 1, "requestAdRequest needIntercept, time:" + i3);
            return;
        }
        this.f391056d.t(this.D);
        final ArrayList arrayList = new ArrayList();
        k(new Consumer() { // from class: cooperation.vip.ad.q
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                TianshuNewAdManager.q(i3, arrayList, (cooperation.vip.ad.processors.a) obj);
            }
        });
        TianShuGetAdvCallback tianShuGetAdvCallback = this.C.get(Integer.valueOf(i3));
        if (tianShuGetAdvCallback == null) {
            tianShuGetAdvCallback = new a(i3);
            this.C.put(Integer.valueOf(i3), tianShuGetAdvCallback);
        }
        QLog.d("TianshuNewAdManager", 1, "requestAdRequest time:" + i3);
        TianShuManager.getInstance().requestAdv(arrayList, tianShuGetAdvCallback, i3, this.D);
    }

    public void w(Activity activity) {
        this.f391056d.s(activity);
    }

    public void x(boolean z16) {
        this.D = z16;
    }

    public void y(TianShuConversationThirdView tianShuConversationThirdView) {
        cooperation.vip.ad.processors.h hVar = this.f391056d;
        if (hVar != null) {
            hVar.u(tianShuConversationThirdView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class b implements IGuardInterface {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<TianshuNewAdManager> f391069d;

        public b(TianshuNewAdManager tianshuNewAdManager) {
            this.f391069d = new WeakReference<>(tianshuNewAdManager);
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationBackground() {
            WeakReference<TianshuNewAdManager> weakReference = this.f391069d;
            if (weakReference == null) {
                QLog.e("TianshuNewAdManagerGuardLifeCycleObserver", 1, "onApplicationForeground   mWeakReference == null");
                return;
            }
            TianshuNewAdManager tianshuNewAdManager = weakReference.get();
            if (tianshuNewAdManager != null) {
                tianshuNewAdManager.f391059h = System.currentTimeMillis();
                i.q("", "TianshuNewAdManagerGuardLifeCycleObserver");
                QLog.d("TianshuNewAdManagerGuardLifeCycleObserver", 1, "onApplicationBackground   | mLastBackgroundTime = " + tianshuNewAdManager.f391059h + " | mConfigIntervalTime = " + tianshuNewAdManager.f391058f);
                tianshuNewAdManager.t();
                return;
            }
            QLog.e("TianshuNewAdManagerGuardLifeCycleObserver", 1, "onApplicationForeground   manager == null");
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationForeground() {
            WeakReference<TianshuNewAdManager> weakReference = this.f391069d;
            if (weakReference == null) {
                QLog.e("TianshuNewAdManagerGuardLifeCycleObserver", 1, "onApplicationForeground   mWeakReference == null");
                return;
            }
            final TianshuNewAdManager tianshuNewAdManager = weakReference.get();
            if (tianshuNewAdManager == null) {
                QLog.e("TianshuNewAdManagerGuardLifeCycleObserver", 1, "onApplicationForeground   manager == null");
                return;
            }
            if (tianshuNewAdManager.f391059h == 0) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            QLog.d("TianshuNewAdManagerGuardLifeCycleObserver", 1, "onApplicationForeground   | curTime = " + currentTimeMillis + " | mLastBackgroundTime: " + tianshuNewAdManager.f391059h + " | intervalTime = " + ((currentTimeMillis - tianshuNewAdManager.f391059h) / 1000) + " | mConfigIntervalTime = " + tianshuNewAdManager.f391058f);
            tianshuNewAdManager.u();
            if (currentTimeMillis - tianshuNewAdManager.f391059h >= tianshuNewAdManager.f391058f * 1000) {
                ThreadManagerV2.executeDelay(new Runnable() { // from class: cooperation.vip.ad.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        TianshuNewAdManager.this.v(4);
                    }
                }, 16, null, false, 300L);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundTimeTick(long j3) {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundUnguardTimeTick(long j3) {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onLiteTimeTick(long j3) {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onScreensStateChanged(boolean z16) {
        }
    }
}
