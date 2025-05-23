package com.tencent.mobileqq.listentogether;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.avbiz.AVBizModuleFactory;
import com.tencent.avbiz.Constants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.ark.dict.api.IArkDictManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.listentogether.data.ISong;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.listentogether.fragment.ListenTogetherOverlayFragment;
import com.tencent.mobileqq.listentogether.ipc.ListenTogetherIPCModuleMainServer;
import com.tencent.mobileqq.listentogether.lyrics.LyricsController;
import com.tencent.mobileqq.listentogether.lyrics.ProfileMusicBoxController;
import com.tencent.mobileqq.listentogether.player.QQMusicPlayService;
import com.tencent.mobileqq.listentogether.predownload.ListenTogetherResDownloader;
import com.tencent.mobileqq.listentogether.ui.BaseListenTogetherPanel;
import com.tencent.mobileqq.listentogether.ui.UiData;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.together.TogetherOperationHandler;
import com.tencent.mobileqq.troop.api.handler.ITroopPushHandler;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUtilsApi;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.intimateinfo.api.IIntimateInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.theme.SkinEngine;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ListenTogetherManager implements Manager {
    private volatile boolean C;
    private com.tencent.mobileqq.listentogether.predownload.a H;
    private com.tencent.mobileqq.listentogether.player.e I;
    private LyricsController J;
    private ProfileMusicBoxController K;
    private com.tencent.mobileqq.listentogether.d L;
    private long M;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f240859d;

    /* renamed from: f0, reason: collision with root package name */
    com.tencent.mobileqq.listentogether.j f240864f0;

    /* renamed from: g0, reason: collision with root package name */
    private WeakReference<com.tencent.mobileqq.listentogether.j> f240865g0;

    /* renamed from: j0, reason: collision with root package name */
    private WeakReference<com.tencent.mobileqq.listentogether.i> f240870j0;

    /* renamed from: m, reason: collision with root package name */
    private volatile boolean f240871m;

    /* renamed from: f, reason: collision with root package name */
    private volatile String f240863f = "";

    /* renamed from: h, reason: collision with root package name */
    private volatile String f240866h = "";

    /* renamed from: i, reason: collision with root package name */
    private volatile String f240868i = "";
    private volatile boolean D = true;
    private l Q = new l();
    private boolean R = false;
    private Runnable S = new Runnable() { // from class: com.tencent.mobileqq.listentogether.ListenTogetherManager.1
        @Override // java.lang.Runnable
        public void run() {
            ListenTogetherSession listenTogetherSession;
            if (TextUtils.isEmpty(ListenTogetherManager.this.f240863f) || (listenTogetherSession = (ListenTogetherSession) ListenTogetherManager.this.E.get(ListenTogetherManager.this.f240863f)) == null) {
                return;
            }
            ListenTogetherManager.this.s1(listenTogetherSession.f437188e, listenTogetherSession.f437189f, 1007);
        }
    };
    private RunnableShowForKey T = new RunnableShowForKey(false);
    private RunnableShowForKey U = new RunnableShowForKey(true);
    private Runnable V = new Runnable() { // from class: com.tencent.mobileqq.listentogether.ListenTogetherManager.2
        @Override // java.lang.Runnable
        public void run() {
            ListenTogetherSession listenTogetherSession;
            if (TextUtils.isEmpty(ListenTogetherManager.this.f240863f) || (listenTogetherSession = (ListenTogetherSession) ListenTogetherManager.this.E.get(ListenTogetherManager.this.f240863f)) == null) {
                return;
            }
            ListenTogetherManager.this.s1(listenTogetherSession.f437188e, listenTogetherSession.f437189f, 1004);
        }
    };
    private com.tencent.mobileqq.listentogether.player.f W = new e();
    private com.tencent.mobileqq.listentogether.player.d X = new f();
    private com.tencent.mobileqq.listentogether.player.c Y = new g();
    private com.tencent.mobileqq.troop.api.observer.f Z = new h();

    /* renamed from: a0, reason: collision with root package name */
    private com.tencent.mobileqq.troop.api.observer.b f240856a0 = new i();

    /* renamed from: b0, reason: collision with root package name */
    private ar f240857b0 = new j();

    /* renamed from: c0, reason: collision with root package name */
    private BroadcastReceiver f240858c0 = new k();

    /* renamed from: d0, reason: collision with root package name */
    private Handler.Callback f240860d0 = new a();

    /* renamed from: e0, reason: collision with root package name */
    int f240862e0 = -1;

    /* renamed from: h0, reason: collision with root package name */
    private boolean f240867h0 = false;

    /* renamed from: i0, reason: collision with root package name */
    private boolean f240869i0 = false;

    /* renamed from: e, reason: collision with root package name */
    private Handler f240861e = new Handler(ThreadManagerV2.getSubThreadLooper(), this.f240860d0);
    private Map<String, ListenTogetherSession> E = new ConcurrentHashMap();
    private LruCache<String, String> G = new LruCache<>(5);
    private LruCache<String, MusicInfo> F = new LruCache<>(100);
    private LruCache<String, Long> N = new LruCache<>(100);
    private LruCache<String, String> P = new LruCache<>(100);

    /* compiled from: P */
    /* loaded from: classes33.dex */
    private class RunnableShowForKey implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        String f240874d;

        /* renamed from: e, reason: collision with root package name */
        boolean f240875e;

        RunnableShowForKey(boolean z16) {
            this.f240875e = z16;
        }

        void a(String str) {
            this.f240874d = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            ListenTogetherManager.this.p0(this.f240874d, this.f240875e);
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1001) {
                MusicInfo N = ListenTogetherManager.this.N();
                if (N != null) {
                    N.D = (SystemClock.elapsedRealtime() - N.F) + N.D;
                    N.F = SystemClock.elapsedRealtime();
                    QLog.i("ListenTogether.Seek", 1, "MSG_TYPE_TIME_SYNC seek is: " + N.D + " currentTime: " + System.currentTimeMillis() + " result: " + ListenTogetherManager.this.I.b(N));
                } else {
                    QLog.i("ListenTogether.Manager", 1, "MSG_TYPE_TIME_SYNC startPlay musicInfo is null.");
                }
                ListenTogetherManager.this.f240861e.removeMessages(1001);
                ListenTogetherManager.this.f240861e.sendEmptyMessageDelayed(1001, com.tencent.mobileqq.listentogether.c.b().f240898c);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class d implements DialogInterface.OnDismissListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            ListenTogetherManager.this.j1();
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class f implements com.tencent.mobileqq.listentogether.player.d {
        f() {
        }

        @Override // com.tencent.mobileqq.listentogether.player.d
        public void a(String str, int i3, int i16) {
            ListenTogetherManager.this.F0(str, i3, i16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class h extends com.tencent.mobileqq.troop.api.observer.f {
        h() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.troop.api.observer.f
        public void b(String str, int i3, ITroopPushHandler.PushType pushType) {
            QLog.i("ListenTogether.Manager", 1, "onPassiveExit troopUin: " + str);
            if (ListenTogetherManager.this.f240863f.equals(d72.b.m(1, str))) {
                ((ListenTogetherSession) ListenTogetherManager.this.E.get(ListenTogetherManager.this.f240863f)).f437191i = 3;
                ((ListenTogetherSession) ListenTogetherManager.this.E.get(ListenTogetherManager.this.f240863f)).f437192m = 3;
                com.tencent.mobileqq.listentogether.a.c(ListenTogetherManager.this.f240859d, str, false);
                ListenTogetherManager listenTogetherManager = ListenTogetherManager.this;
                listenTogetherManager.e1(true, (ListenTogetherSession) listenTogetherManager.E.get(ListenTogetherManager.this.f240863f), 1007);
                ListenTogetherManager.this.Y0(1, str, false);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class i extends com.tencent.mobileqq.troop.api.observer.b {
        i() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.troop.api.observer.b
        public void l(int i3, int i16, String str) {
            QLog.i("ListenTogether.Manager", 1, "onTroopManagerSuccess result: " + i16 + " troopUin: " + str);
            if (i16 == 0) {
                if (i3 == 9 || i3 == 2) {
                    if (ListenTogetherManager.this.f240863f.equals(d72.b.m(1, str))) {
                        ((ListenTogetherSession) ListenTogetherManager.this.E.get(ListenTogetherManager.this.f240863f)).f437191i = 3;
                        ((ListenTogetherSession) ListenTogetherManager.this.E.get(ListenTogetherManager.this.f240863f)).f437192m = 3;
                        com.tencent.mobileqq.listentogether.a.c(ListenTogetherManager.this.f240859d, str, false);
                        ListenTogetherManager listenTogetherManager = ListenTogetherManager.this;
                        listenTogetherManager.e1(true, (ListenTogetherSession) listenTogetherManager.E.get(ListenTogetherManager.this.f240863f), 1007);
                        ListenTogetherManager.this.Y0(1, str, false);
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class j extends ar {
        j() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onUpdateDelFriend(boolean z16, Object obj) {
            QLog.i("ListenTogether.Manager", 1, "onUpdateDelFriend isSuccess: " + z16 + " object: " + obj);
            if (z16) {
                if (ListenTogetherManager.this.f240863f.equals(d72.b.m(2, String.valueOf(obj)))) {
                    ((ListenTogetherSession) ListenTogetherManager.this.E.get(ListenTogetherManager.this.f240863f)).f437191i = 3;
                    ((ListenTogetherSession) ListenTogetherManager.this.E.get(ListenTogetherManager.this.f240863f)).f437192m = 3;
                    com.tencent.mobileqq.listentogether.a.b(ListenTogetherManager.this.f240859d, String.valueOf(obj), false);
                    ListenTogetherManager listenTogetherManager = ListenTogetherManager.this;
                    listenTogetherManager.e1(true, (ListenTogetherSession) listenTogetherManager.E.get(ListenTogetherManager.this.f240863f), 1007);
                    ListenTogetherManager.this.Y0(2, String.valueOf(obj), false);
                }
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateFriendInfo(String str, boolean z16) {
            ListenTogetherSession Q = ListenTogetherManager.this.Q(2, str);
            if (z16 && Q != null && Q.f437189f.equals(str) && ListenTogetherManager.this.E1(Q)) {
                QLog.d("ListenTogether.Manager", 1, String.format("onUpdateFriendInfo uin=%s mutual level changed", Q.f437189f));
                ListenTogetherManager.this.H0(Q);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class l implements com.tencent.mobileqq.listentogether.player.b {

        /* renamed from: a, reason: collision with root package name */
        public Object f240890a = new Object();

        l() {
        }

        @Override // com.tencent.mobileqq.listentogether.player.b
        public void a(int i3) {
            Object obj = this.f240890a;
            if (obj == null || i3 == 0) {
                return;
            }
            synchronized (obj) {
                this.f240890a.notifyAll();
            }
        }
    }

    public ListenTogetherManager(QQAppInterface qQAppInterface) {
        this.f240859d = qQAppInterface;
        this.J = new LyricsController(qQAppInterface);
        this.K = new ProfileMusicBoxController(qQAppInterface);
        this.L = new com.tencent.mobileqq.listentogether.d(qQAppInterface);
        this.H = new ListenTogetherResDownloader(qQAppInterface);
        com.tencent.mobileqq.listentogether.player.g gVar = new com.tencent.mobileqq.listentogether.player.g(BaseApplication.context, qQAppInterface);
        this.I = gVar;
        gVar.f(this.W);
        this.I.c(this.X);
        this.I.a(this.Y);
        this.I.d(this.Q);
        qQAppInterface.addObserver(this.f240856a0);
        qQAppInterface.addObserver(this.Z);
        qQAppInterface.addObserver(this.f240857b0);
        if (LyricsController.B()) {
            return;
        }
        BaseApplication.getContext().registerReceiver(this.f240858c0, new IntentFilter(SkinEngine.ACTION_THEME_INVALIDATE), "com.tencent.msg.permission.pushnotify", null);
    }

    private void A0(int i3, String str) {
        QLog.i("ListenTogether.Manager", 1, "notifyUIModuleChangePlayModeListenTogetherFail type: " + i3 + " uin:" + str);
        ListenTogetherHandler listenTogetherHandler = (ListenTogetherHandler) this.f240859d.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER);
        if (listenTogetherHandler != null) {
            listenTogetherHandler.notifyUI(21, true, new Object[]{Integer.valueOf(i3), str});
        }
    }

    private void B0(int i3, String str) {
        QLog.i("ListenTogether.Manager", 1, "notifyUIModuleCutListenTogetherFail type: " + i3 + " uin:" + str);
        ListenTogetherHandler listenTogetherHandler = (ListenTogetherHandler) this.f240859d.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER);
        if (listenTogetherHandler != null) {
            listenTogetherHandler.notifyUI(20, true, new Object[]{Integer.valueOf(i3), str});
        }
    }

    private void C0(ListenTogetherSession listenTogetherSession) {
        ListenTogetherHandler listenTogetherHandler = (ListenTogetherHandler) this.f240859d.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER);
        if (listenTogetherHandler != null) {
            listenTogetherHandler.notifyUI(19, true, new Object[]{Integer.valueOf(listenTogetherSession.f437188e), listenTogetherSession.f437189f});
        }
    }

    private void D0(ListenTogetherSession listenTogetherSession, boolean z16) {
        QLog.i("ListenTogether.Manager", 1, "notifyUIModuleJoinListenTogetherFail session: " + listenTogetherSession + " listenTogetherClosed:" + z16);
        ListenTogetherHandler listenTogetherHandler = (ListenTogetherHandler) this.f240859d.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER);
        if (listenTogetherHandler != null) {
            listenTogetherHandler.notifyUI(5, true, new Object[]{Integer.valueOf(listenTogetherSession.f437188e), listenTogetherSession.f437189f, Boolean.valueOf(z16)});
        }
    }

    private boolean D1(ListenTogetherSession listenTogetherSession) {
        if (listenTogetherSession.f437192m == 2) {
            this.f240863f = listenTogetherSession.f();
            this.f240866h = this.f240863f;
        } else if (this.f240863f.equals(listenTogetherSession.f())) {
            this.f240863f = "";
            return true;
        }
        return false;
    }

    private void E0(int i3, String str) {
        QLog.i("ListenTogether.Manager", 1, "notifyUIModulePauseListenTogetherFail type: " + i3 + " uin:" + str);
        ListenTogetherHandler listenTogetherHandler = (ListenTogetherHandler) this.f240859d.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER);
        if (listenTogetherHandler != null) {
            listenTogetherHandler.notifyUI(6, true, new Object[]{Integer.valueOf(i3), str});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean E1(ListenTogetherSession listenTogetherSession) {
        boolean z16;
        if (listenTogetherSession.f437188e != 2) {
            return false;
        }
        com.tencent.mobileqq.mutualmark.info.c h16 = com.tencent.mobileqq.mutualmark.c.h(this.f240859d, listenTogetherSession.f437189f, 28L, true);
        int i3 = h16 == null ? 0 : (int) h16.f252086b;
        if (listenTogetherSession.W != i3) {
            listenTogetherSession.W = i3;
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ListenTogether.Manager", 2, String.format("updateMutualLevel sessionType=%d uin=%s level=%d changed=%b", Integer.valueOf(listenTogetherSession.f437188e), listenTogetherSession.f437189f, Integer.valueOf(i3), Boolean.valueOf(z16)));
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0(String str, int i3, int i16) {
        ListenTogetherHandler listenTogetherHandler = (ListenTogetherHandler) this.f240859d.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER);
        if (listenTogetherHandler != null) {
            listenTogetherHandler.notifyUI(9, true, new Object[]{str, Integer.valueOf(i3), Integer.valueOf(i16)});
        }
    }

    private void G0(int i3, String str) {
        QLog.i("ListenTogether.Manager", 1, "notifyUIModuleResumeListenTogetherFail type: " + i3 + " uin:" + str);
        ListenTogetherHandler listenTogetherHandler = (ListenTogetherHandler) this.f240859d.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER);
        if (listenTogetherHandler != null) {
            listenTogetherHandler.notifyUI(7, true, new Object[]{Integer.valueOf(i3), str});
        }
    }

    private boolean G1(ListenTogetherSession listenTogetherSession, int i3) {
        synchronized (this.E) {
            String f16 = listenTogetherSession.f();
            ListenTogetherSession listenTogetherSession2 = this.E.get(f16);
            if (listenTogetherSession2 == null) {
                this.E.put(f16, listenTogetherSession);
            } else {
                if (listenTogetherSession.E < listenTogetherSession2.E) {
                    return false;
                }
                listenTogetherSession2.j(listenTogetherSession);
                listenTogetherSession = listenTogetherSession2;
            }
            if (listenTogetherSession.f437191i == 3 || listenTogetherSession.f437192m == 3) {
                listenTogetherSession.M = false;
            }
            if (j0(i3)) {
                listenTogetherSession.M = false;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0(ListenTogetherSession listenTogetherSession) {
        ListenTogetherHandler listenTogetherHandler;
        QLog.i("ListenTogether.Manager", 1, "notifyUIModuleToInitOrUpdate session: " + listenTogetherSession);
        if (listenTogetherSession == null || (listenTogetherHandler = (ListenTogetherHandler) this.f240859d.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)) == null) {
            return;
        }
        listenTogetherHandler.notifyUI(4, true, new Object[]{listenTogetherSession});
    }

    private void H1(int i3, String str, int i16) {
        if (QLog.isColorLevel()) {
            QLog.i("ListenTogether.Manager", 1, "updateSessionPlayMode type:" + i3 + " uin:" + str + " playMode:" + i16);
        }
        if (i16 > 3 || i16 < 1) {
            return;
        }
        ListenTogetherSession listenTogetherSession = this.E.get(d72.b.m(i3, str));
        if (listenTogetherSession == null || listenTogetherSession.V == i16) {
            return;
        }
        listenTogetherSession.V = i16;
        if (QLog.isColorLevel()) {
            QLog.i("ListenTogether.Manager", 1, "updateSessionPlayMode in ");
        }
        H0(listenTogetherSession);
    }

    private boolean I() {
        if (!this.I.isConnected()) {
            long uptimeMillis = SystemClock.uptimeMillis();
            synchronized (this.Q.f240890a) {
                if (!this.I.isConnected()) {
                    try {
                        this.I.init();
                        this.Q.f240890a.wait(1500L);
                    } catch (InterruptedException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.i("ListenTogether.Manager", 2, "doConnIfNeed InterruptedException==>", e16);
                        }
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.i("ListenTogether.Manager", 2, String.format("doConnIfNeed %b cos=%d", Boolean.valueOf(this.I.isConnected()), Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis)));
            }
        }
        return this.I.isConnected();
    }

    private void I1(int i3, String str, int i16) {
        if (QLog.isColorLevel()) {
            QLog.i("ListenTogether.Manager", 1, "updateSessionStatus type:" + i3 + " uin:" + str + " status:" + i16);
        }
        String m3 = d72.b.m(i3, str);
        if (!this.E.containsKey(m3) || this.E.get(m3) == null) {
            return;
        }
        this.E.get(m3).f437191i = i16;
        if (QLog.isColorLevel()) {
            QLog.i("ListenTogether.Manager", 1, "updateSessionStatus in ");
        }
    }

    public static ListenTogetherManager J(QQAppInterface qQAppInterface) {
        return (ListenTogetherManager) qQAppInterface.getManager(QQManagerFactory.LISTEN_TOGETHER_MANAGER);
    }

    public static void M0(QQAppInterface qQAppInterface, int i3, String str, int i16) {
        ListenTogetherManager J = J(qQAppInterface);
        if (J != null && i3 == 1) {
            J.L0(1, str, i16);
        } else {
            if (J == null || i3 != 0) {
                return;
            }
            J.L0(2, str, i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int P() {
        return this.f240871m ? 800 : 100;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(String str) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new com.tencent.mobileqq.listentogether.h(str, false, true));
        ListenTogetherHandler listenTogetherHandler = (ListenTogetherHandler) this.f240859d.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER);
        ListenTogetherSession listenTogetherSession = this.E.get(this.f240866h);
        if (listenTogetherSession == null || listenTogetherHandler == null) {
            return;
        }
        listenTogetherHandler.H2(listenTogetherSession.f437188e, listenTogetherSession.f437189f, arrayList, true);
    }

    private boolean b0(int i3, String str, int i16) {
        H1(i3, str, i16);
        if (i3 == 2) {
            return true;
        }
        if (i3 == 1) {
            ListenTogetherSession listenTogetherSession = this.E.get(d72.b.m(i3, str));
            if (listenTogetherSession != null) {
                if (TextUtils.equals(listenTogetherSession.C, this.f240859d.getCurrentUin())) {
                    return true;
                }
                TroopInfo B = ((TroopManager) this.f240859d.getManager(QQManagerFactory.TROOP_MANAGER)).B(this.f240859d.getCurrentUin());
                if (B != null && B.isOwnerOrAdmin()) {
                    return true;
                }
            }
        }
        return false;
    }

    private void f1(boolean z16, List<MusicInfo> list) {
        QLog.i("ListenTogether.Manager", 1, "onGetLyricFromServer success: " + z16 + " musicList: " + list);
        if (!z16) {
            u0(true);
            return;
        }
        if (list != null && !list.isEmpty()) {
            MusicInfo musicInfo = list.get(0);
            if (musicInfo == null) {
                return;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            if (!TextUtils.isEmpty(musicInfo.f240915m)) {
                this.G.put(list.get(0).f240910d, musicInfo.f240915m);
                hashMap.put("has_lyric", "1");
            } else {
                hashMap.put("has_lyric", "0");
            }
            u0(false);
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "listen_together_lyric", true, 0L, 0L, hashMap, "");
            return;
        }
        u0(true);
    }

    private void h1(boolean z16, List<MusicInfo> list) {
        QLog.i("ListenTogether.Manager", 1, "onGetMusicUrlFromServer success: " + z16 + " musicList: " + list);
        if (!z16 || list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            MusicInfo musicInfo = list.get(i3);
            if (musicInfo != null && musicInfo.j()) {
                this.F.put(musicInfo.f240910d, musicInfo);
                arrayList.add(musicInfo);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.H.a(arrayList);
    }

    private boolean j0(int i3) {
        if (i3 != 1001 && i3 != 1009 && i3 != 1021 && i3 != 1023) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l1() {
        this.f240861e.postDelayed(this.S, 8000L);
    }

    private boolean n0(int i3) {
        return j0(i3) || i3 == 1000 || i3 == 1013 || i3 == 1018;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n1() {
        ListenTogetherSession listenTogetherSession;
        if (TextUtils.isEmpty(this.f240863f) || (listenTogetherSession = this.E.get(this.f240863f)) == null) {
            return;
        }
        s1(listenTogetherSession.f437188e, listenTogetherSession.f437189f, 1008);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0(String str, boolean z16) {
        ListenTogetherHandler listenTogetherHandler;
        if (TextUtils.isEmpty(str) || (listenTogetherHandler = (ListenTogetherHandler) this.f240859d.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)) == null) {
            return;
        }
        listenTogetherHandler.notifyUI(15, true, new Object[]{Boolean.valueOf(z16), this.E.get(str)});
    }

    private void q0(int i3, String str) {
        ListenTogetherHandler listenTogetherHandler = (ListenTogetherHandler) this.f240859d.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER);
        if (listenTogetherHandler != null) {
            listenTogetherHandler.notifyUI(22, true, new Object[]{Integer.valueOf(i3), str});
        }
    }

    private void r0(int i3, String str, String str2) {
        ListenTogetherHandler listenTogetherHandler = (ListenTogetherHandler) this.f240859d.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER);
        if (listenTogetherHandler != null) {
            listenTogetherHandler.notifyUI(18, true, new Object[]{Integer.valueOf(i3), str, str2});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0(ISong iSong) {
        ListenTogetherHandler listenTogetherHandler = (ListenTogetherHandler) this.f240859d.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER);
        if (listenTogetherHandler != null) {
            listenTogetherHandler.notifyUI(13, true, new Object[]{iSong});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s1(int i3, String str, int i16) {
        QLog.i("ListenTogether.Manager", 1, "refreshListenTogetherStatus, type: " + i3 + " uin: " + str + " by:" + L(i16));
        String m3 = d72.b.m(i3, str);
        if (!m3.equals(this.f240863f) && !m3.equals(this.f240868i)) {
            QLog.i("ListenTogether.Manager", 1, "refreshListenTogetherStatus, currentSessionKey: " + this.f240863f + " currentAio: " + this.f240868i + " not equal return.");
            return;
        }
        TogetherOperationHandler togetherOperationHandler = (TogetherOperationHandler) this.f240859d.getBusinessHandler(BusinessHandlerFactory.TOGETHER_OPERATOR_HANDLER);
        if (togetherOperationHandler != null) {
            togetherOperationHandler.F2(1, i3, str, i16);
        }
    }

    private void t0(int i3, String str, boolean z16, boolean z17) {
        QLog.i("ListenTogether.Manager", 1, "notifyLyricModuleSwitchChange, type: " + i3 + " uin: " + str + " open:" + z16 + " userAction: " + z17);
        ListenTogetherHandler listenTogetherHandler = (ListenTogetherHandler) this.f240859d.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER);
        if (listenTogetherHandler != null) {
            listenTogetherHandler.notifyUI(11, true, new Object[]{Integer.valueOf(i3), str, Boolean.valueOf(z16), Boolean.valueOf(z17)});
        }
    }

    private void u0(boolean z16) {
        ListenTogetherSession listenTogetherSession;
        MusicInfo c16;
        if (TextUtils.isEmpty(this.f240863f) || (listenTogetherSession = this.E.get(this.f240863f)) == null || (c16 = listenTogetherSession.c()) == null) {
            return;
        }
        String str = this.G.get(c16.f240910d);
        ListenTogetherHandler listenTogetherHandler = (ListenTogetherHandler) this.f240859d.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER);
        if (listenTogetherHandler != null) {
            listenTogetherHandler.notifyUI(10, true, new Object[]{c16.f240910d, str, Boolean.valueOf(z16)});
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("notifyMusicModuleLyric lyric: ");
        sb5.append(str != null ? str.length() : 0);
        sb5.append(" serverError: ");
        sb5.append(z16);
        sb5.append(" songid: ");
        sb5.append(c16.f240910d);
        QLog.i("ListenTogether.Manager", 1, sb5.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        ListenTogetherHandler listenTogetherHandler = (ListenTogetherHandler) this.f240859d.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER);
        if (listenTogetherHandler != null) {
            listenTogetherHandler.notifyUI(10, true, new Object[]{str, str2, Boolean.FALSE});
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("notifyMusicModuleLyric use cache lyric: ");
        sb5.append(str2 != null ? str2.length() : 0);
        sb5.append(" serverError");
        QLog.i("ListenTogether.Manager", 1, sb5.toString());
    }

    private void w0(ListenTogetherSession listenTogetherSession, int i3) {
        QLog.i("ListenTogether.Manager", 1, "notifyMusicModuleToRefresh session: " + listenTogetherSession + " manager destroy: " + this.C + " playFocused: " + this.D);
        if (listenTogetherSession == null) {
            return;
        }
        this.f240861e.removeMessages(1001);
        if (listenTogetherSession.f437192m == 2) {
            int i16 = listenTogetherSession.f437191i;
            if (i16 != 1) {
                if (i16 == 2) {
                    QLog.i("ListenTogether.Manager", 1, "notifyMusicModuleToRefresh pausePlay result: " + this.I.pausePlay());
                    return;
                }
                if (i16 == 3) {
                    QLog.i("ListenTogether.Manager", 1, "notifyMusicModuleToRefresh stopPlay result: " + this.I.stopPlay());
                    return;
                }
                if (i16 == 4) {
                    QLog.i("ListenTogether.Manager", 1, "notifyMusicModuleToRefresh stopPlay result: " + this.I.stopPlay());
                    return;
                }
                return;
            }
            MusicInfo c16 = listenTogetherSession.c();
            if (c16 == null) {
                QLog.i("ListenTogether.Manager", 1, "notifyMusicModuleToRefresh startPlay musicInfo is null. return.");
                return;
            }
            if (!this.C && this.D && H() && !this.f240859d.isVideoChatting() && !this.f240859d.isPttRecordingOrPlaying() && I()) {
                long j3 = c16.D;
                QLog.i("ListenTogether.Seek", 1, "sendRefreshPlayMsg seek: " + j3 + " currentTime: " + System.currentTimeMillis());
                if (j3 < 0) {
                    this.f240861e.sendEmptyMessageDelayed(1001, -j3);
                } else {
                    this.f240861e.sendEmptyMessage(1001);
                }
                if (i3 == 1009 || i3 == 1021 || i3 == 1001 || i3 == 1023 || i3 == 1015 || i3 == 1014 || i3 == 1010) {
                    u1(listenTogetherSession.f437188e, listenTogetherSession.f437189f, c16.f240910d, c16.f240911e);
                    return;
                }
                return;
            }
            return;
        }
        QLog.i("ListenTogether.Manager", 1, "notifyMusicModuleToRefresh stopPlay result: " + this.I.stopPlay());
    }

    private void w1(int i3) {
        ListenTogetherSession listenTogetherSession = this.E.get(this.f240863f);
        if (listenTogetherSession != null) {
            s1(listenTogetherSession.f437188e, listenTogetherSession.f437189f, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(String str, int i3) {
        ListenTogetherHandler listenTogetherHandler = (ListenTogetherHandler) this.f240859d.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER);
        if (listenTogetherHandler != null) {
            listenTogetherHandler.notifyUI(12, true, new Object[]{str, Integer.valueOf(i3)});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0() {
        ListenTogetherHandler listenTogetherHandler = (ListenTogetherHandler) this.f240859d.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER);
        if (listenTogetherHandler != null) {
            listenTogetherHandler.notifyUI(16, true, null);
        }
    }

    public void A1(Context context, UiData uiData, BaseListenTogetherPanel.ReportInfo reportInfo) {
        ListenTogetherSession listenTogetherSession = this.E.get(d72.b.m(uiData.f241157d, uiData.f241158e));
        if (listenTogetherSession == null) {
            V0();
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("type", 7);
        intent.putExtra("uin", uiData.f241158e);
        intent.putExtra("uinType", listenTogetherSession.f437188e);
        intent.putExtra("uiData", uiData);
        intent.putExtra(CacheTable.TABLE_NAME, reportInfo);
        intent.putExtra("public_fragment_window_feature", 1);
        intent.setFlags(536870912);
        intent.addFlags(268435456);
        if (context == null) {
            context = BaseApplication.getContext();
        }
        x1(true);
        PublicFragmentActivity.b.a(context, intent, PublicTransFragmentActivity.class, ListenTogetherOverlayFragment.class);
    }

    public void C(int i3, String str, com.tencent.mobileqq.listentogether.i iVar) {
        TroopInfo B;
        this.f240870j0 = new WeakReference<>(iVar);
        String m3 = d72.b.m(i3, str);
        QLog.i("ListenTogether.Manager", 1, "checkAndExitListenTogether type: " + i3 + " ,uin: " + str + " key:" + m3 + "  currentSessionKey:" + this.f240863f);
        ListenTogetherSession listenTogetherSession = this.E.get(m3);
        if (listenTogetherSession == null) {
            V0();
            return;
        }
        boolean equals = TextUtils.equals(listenTogetherSession.C, this.f240859d.getCurrentUin());
        int i16 = listenTogetherSession.f437188e;
        if (i16 == 2 || (i16 == 1 && (equals || ((B = ((TroopManager) this.f240859d.getManager(QQManagerFactory.TROOP_MANAGER)).B(str)) != null && B.isOwnerOrAdmin())))) {
            Intent intent = new Intent();
            intent.putExtra("type", 3);
            intent.putExtra("uinType", listenTogetherSession.f437188e);
            intent.putExtra("public_fragment_window_feature", 1);
            intent.setFlags(536870912);
            intent.addFlags(268435456);
            x1(true);
            PublicFragmentActivity.b.a(BaseApplication.getContext(), intent, PublicTransFragmentActivity.class, ListenTogetherOverlayFragment.class);
            return;
        }
        W0(false);
    }

    public void C1(JSONObject jSONObject) {
        ListenTogetherHandler listenTogetherHandler = (ListenTogetherHandler) this.f240859d.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER);
        if (listenTogetherHandler != null) {
            listenTogetherHandler.startAioShareTogetherListen(jSONObject);
        }
    }

    public void D(UiData uiData, BaseListenTogetherPanel.ReportInfo reportInfo, com.tencent.mobileqq.listentogether.i iVar) {
        TroopInfo B;
        int i3 = uiData.f241157d;
        String str = uiData.f241158e;
        this.f240870j0 = new WeakReference<>(iVar);
        String m3 = d72.b.m(i3, str);
        QLog.i("ListenTogether.Manager", 1, "checkAndExitListenTogether type: " + i3 + " ,uin: " + str + " key:" + m3 + "  currentSessionKey:" + this.f240863f);
        ListenTogetherSession listenTogetherSession = this.E.get(m3);
        if (listenTogetherSession == null) {
            V0();
            return;
        }
        boolean equals = TextUtils.equals(listenTogetherSession.C, this.f240859d.getCurrentUin());
        int i16 = listenTogetherSession.f437188e;
        boolean z16 = i16 == 2 || (i16 == 1 && (equals || ((B = ((TroopManager) this.f240859d.getManager(QQManagerFactory.TROOP_MANAGER)).B(str)) != null && B.isOwnerOrAdmin())));
        Intent intent = new Intent();
        if (z16) {
            intent.putExtra("type", 5);
        } else {
            intent.putExtra("type", 6);
        }
        intent.putExtra("uin", str);
        intent.putExtra("uinType", listenTogetherSession.f437188e);
        intent.putExtra("uiData", uiData);
        intent.putExtra(CacheTable.TABLE_NAME, reportInfo);
        intent.putExtra("public_fragment_window_feature", 1);
        intent.setFlags(536870912);
        intent.addFlags(268435456);
        x1(true);
        PublicFragmentActivity.b.a(BaseApplication.getContext(), intent, PublicTransFragmentActivity.class, ListenTogetherOverlayFragment.class);
    }

    public void E(QBaseActivity qBaseActivity, int i3, String str, com.tencent.mobileqq.listentogether.j jVar) {
        this.f240865g0 = new WeakReference<>(jVar);
        QLog.i("ListenTogether.Manager", 1, "checkAndJoinListenTogether type: " + i3 + " ,uin: " + str);
        if (H() && !this.f240859d.isVideoChatting() && !this.f240859d.isPttRecordingOrPlaying()) {
            ListenTogetherSession listenTogetherSession = this.E.get(d72.b.m(i3, str));
            if (listenTogetherSession != null && !TextUtils.isEmpty(listenTogetherSession.Q) && !"0".equals(listenTogetherSession.Q)) {
                String qqStr = HardCodeUtil.qqStr(R.string.nqa);
                String qqStr2 = HardCodeUtil.qqStr(R.string.nq9);
                if (listenTogetherSession.P == 1) {
                    if (listenTogetherSession.S) {
                        qqStr2 = HardCodeUtil.qqStr(R.string.nq_);
                    }
                } else {
                    qqStr2 = HardCodeUtil.qqStr(R.string.f172141nq2);
                }
                QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(qBaseActivity, 230);
                c cVar = new c(i3, str);
                createCustomDialog.setTitle(qqStr);
                createCustomDialog.setMessage(qqStr2);
                createCustomDialog.setOnDismissListener(new d());
                createCustomDialog.setNegativeButton(HardCodeUtil.qqStr(R.string.j6l), cVar);
                createCustomDialog.setPositiveButton(HardCodeUtil.qqStr(R.string.ket), cVar);
                createCustomDialog.setCanceledOnTouchOutside(false);
                createCustomDialog.show();
                if (i3 == 1 && !this.f240867h0) {
                    this.f240867h0 = true;
                    d72.b.v(this.f240859d, "is_not_first_join_listen_together_" + i3, true, false);
                    return;
                }
                if (i3 != 2 || this.f240869i0) {
                    return;
                }
                this.f240869i0 = true;
                d72.b.v(this.f240859d, "is_not_first_join_listen_together_" + i3, true, false);
                return;
            }
            k1();
            G(qBaseActivity, i3, str);
            return;
        }
        z1(qBaseActivity, HardCodeUtil.qqStr(R.string.f172140nq1));
        H0(this.E.get(d72.b.m(i3, str)));
        j1();
    }

    public void F(JSONObject jSONObject) {
        ListenTogetherHandler listenTogetherHandler = (ListenTogetherHandler) this.f240859d.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER);
        if (listenTogetherHandler != null) {
            listenTogetherHandler.checkAndShowAioShareMusic(jSONObject);
        }
    }

    public void F1(int i3, String str, long j3) {
        this.N.put(i3 + "_" + str, Long.valueOf(j3));
    }

    public boolean G(Context context, int i3, String str) {
        boolean z16;
        if (i3 == 1) {
            if (!this.f240867h0) {
                this.f240867h0 = d72.b.l(this.f240859d, "is_not_first_join_listen_together_" + i3, false, false);
            }
            z16 = this.f240867h0;
        } else {
            if (!this.f240869i0) {
                this.f240869i0 = d72.b.l(this.f240859d, "is_not_first_join_listen_together_" + i3, false, false);
            }
            z16 = this.f240869i0;
        }
        if (z16) {
            return false;
        }
        this.J.N = true;
        Intent intent = new Intent();
        intent.putExtra("type", 4);
        intent.putExtra("uinType", i3);
        intent.putExtra("public_fragment_window_feature", 1);
        intent.setFlags(268435456);
        x1(true);
        PublicFragmentActivity.b.a(BaseApplication.getContext(), intent, PublicTransFragmentActivity.class, ListenTogetherOverlayFragment.class);
        if (i3 == 1) {
            this.f240867h0 = true;
        } else {
            this.f240869i0 = true;
        }
        d72.b.v(this.f240859d, "is_not_first_join_listen_together_" + i3, true, false);
        return true;
    }

    public boolean H() {
        String checkAVFocus = AVBizModuleFactory.getModuleByName(Constants.Business.LISTEN_TOGETHER).checkAVFocus();
        if ("true".equals(checkAVFocus)) {
            return true;
        }
        Context baseContext = this.f240859d.getApp().getBaseContext();
        QQToast.makeText(baseContext, String.format(baseContext.getString(R.string.z_k), checkAVFocus), 1).show();
        QLog.e("ListenTogether.Manager", 1, "preCheckIsUserGamePlaying, res[" + checkAVFocus + "]");
        return false;
    }

    public void I0(int i3, boolean z16, int i16) {
        JSONObject jSONObject;
        if (QLog.isColorLevel()) {
            QLog.d("ListenTogether.Manager", 1, "notifyWebCheckJoinResult uinTypeForOpener:" + i16 + " isOpener:" + z16 + " canJoin:" + i3);
        }
        try {
            jSONObject = new JSONObject();
            jSONObject.put("type", "checkJoin");
            jSONObject.put("canJoin", i3);
            jSONObject.put("isOpener", z16 ? 1 : 0);
            jSONObject.put("uinType", i16);
        } catch (JSONException e16) {
            QLog.e("ListenTogether.Manager", 1, "notifyWebCheckJoinResult error : " + e16.getMessage());
            jSONObject = null;
        }
        if (jSONObject != null) {
            ListenTogetherIPCModuleMainServer.b(jSONObject);
        }
    }

    public void J0(int i3) {
        JSONObject jSONObject;
        if (QLog.isColorLevel()) {
            QLog.d("ListenTogether.Manager", 1, "notifyWebCheckJoinResult retCode:" + i3);
        }
        try {
            jSONObject = new JSONObject();
            jSONObject.put("type", "joinListen");
            jSONObject.put("retCode", i3);
        } catch (JSONException e16) {
            QLog.e("ListenTogether.Manager", 1, "notifyWebJoinListenResult error : " + e16.getMessage());
            jSONObject = null;
        }
        if (jSONObject != null) {
            ListenTogetherIPCModuleMainServer.b(jSONObject);
        }
    }

    public String K(String str) {
        return this.P.get(str);
    }

    public void K0(int i3, String str, String str2, int i16) {
        JSONObject jSONObject;
        if (QLog.isColorLevel()) {
            QLog.d("ListenTogether.Manager", 1, "musicSongStateChange uinType:" + i3 + " uin:" + str + " changeType:" + str2 + " opValue:" + i16);
        }
        try {
            jSONObject = new JSONObject();
            jSONObject.put("type", str2);
            jSONObject.put("uin", str);
            jSONObject.put("uinType", i3);
            jSONObject.put("value", i16);
        } catch (JSONException e16) {
            QLog.e("ListenTogether.Manager", 1, "musicSongStateChange error : " + e16.getMessage());
            jSONObject = null;
        }
        if (jSONObject != null) {
            ListenTogetherIPCModuleMainServer.b(jSONObject);
        }
    }

    public void L0(int i3, String str, int i16) {
        LyricsController lyricsController;
        QLog.i("ListenTogether.Manager", 1, "onBackFromAIO. mLastEnterAIOId:" + this.f240862e0 + " aioId:" + i16);
        if (this.f240862e0 == i16 && (lyricsController = this.J) != null && lyricsController.z()) {
            this.f240871m = false;
            this.J.G(i3, str, true);
        }
    }

    public MusicInfo N() {
        List<MusicInfo> list;
        ListenTogetherSession listenTogetherSession = this.E.get(this.f240866h);
        if (listenTogetherSession == null || (list = listenTogetherSession.L) == null || list.isEmpty()) {
            return null;
        }
        return listenTogetherSession.L.get(0);
    }

    public void N0(int i3, String str, int i16) {
        ListenTogetherHandler listenTogetherHandler;
        QLog.i("ListenTogether.Manager", 1, "onChangePlayMode type: " + i3 + " ,uin: " + str + " ,dstPlayMode: " + i16);
        ListenTogetherSession listenTogetherSession = this.E.get(d72.b.m(i3, str));
        if (listenTogetherSession == null || (listenTogetherHandler = (ListenTogetherHandler) this.f240859d.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)) == null) {
            return;
        }
        listenTogetherHandler.E2(listenTogetherSession.f437188e, listenTogetherSession.f437189f, i16);
    }

    public ListenTogetherSession O() {
        return this.E.get(this.f240866h);
    }

    public void O0(boolean z16, int i3, String str, int i16) {
        QLog.i("ListenTogether.Manager", 1, "onChangePlayModeRespFromServer, success: " + z16 + " ,type: " + i3 + " ,uin: " + str + ", playMode: " + i16);
        if (!z16) {
            A0(i3, str);
        } else {
            H1(i3, str, i16);
        }
    }

    public ListenTogetherSession Q(int i3, String str) {
        return this.E.get(d72.b.m(i3, str));
    }

    public String R(String str) {
        return this.G.get(str);
    }

    public void R0(boolean z16, int i3, String str) {
        QLog.i("ListenTogether.Manager", 1, "onCutOperRespFromServer, success: " + z16 + " ,type: " + i3 + " ,uin: " + str);
        if (!z16) {
            B0(i3, str);
        } else {
            s1(i3, str, 1019);
        }
    }

    public void S0(int i3, String str, int i16) {
        ListenTogetherHandler listenTogetherHandler;
        QLog.i("ListenTogether.Manager", 1, "onCutSong type: " + i3 + " ,uin: " + str + ",cutType: " + i16);
        this.f240861e.removeMessages(1001);
        ListenTogetherSession listenTogetherSession = this.E.get(d72.b.m(i3, str));
        if (listenTogetherSession == null || (listenTogetherHandler = (ListenTogetherHandler) this.f240859d.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)) == null) {
            return;
        }
        listenTogetherHandler.F2(listenTogetherSession.f437188e, listenTogetherSession.f437189f, i16);
    }

    public LyricsController T() {
        return this.J;
    }

    public void T0(int i3, String str, int i16) {
        QLog.i("ListenTogether.Manager", 1, "onDestroyAIO. type: " + i3 + " uin:" + str + " mLastEnterAIOId:" + this.f240862e0 + " aioId:" + i16);
        if (this.f240862e0 != i16) {
            return;
        }
        if (d72.b.m(i3, str).equals(this.f240868i)) {
            this.f240868i = "";
        }
        LyricsController lyricsController = this.J;
        if (lyricsController != null) {
            lyricsController.E(i3, str);
        }
    }

    public int U() {
        return this.I.e();
    }

    public void U0(int i3, String str, int i16) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.listentogether.ListenTogetherManager.11
            @Override // java.lang.Runnable
            public void run() {
                ((IArkDictManager) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IArkDictManager.class, "")).updateLocalDict();
            }
        }, 64, null, false);
        this.f240871m = true;
        this.f240868i = d72.b.m(i3, str);
        boolean g06 = g0(i3, str);
        QLog.i("ListenTogether.Manager", 1, "onEnterAio type: " + i3 + " ,uin: " + str + " open: " + g06 + " mLastEnterAIOId:" + this.f240862e0 + " aioId:" + i16);
        this.f240862e0 = i16;
        LyricsController lyricsController = this.J;
        if (lyricsController != null) {
            lyricsController.F(i3, str);
        }
        if (g06) {
            if (i3 == 2) {
                if (!((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "ListenTogether.Manager")) {
                    return;
                }
            }
            H0(this.E.get(d72.b.m(i3, str)));
            s1(i3, str, 1000);
        }
    }

    public int V() {
        return this.I.getPlayState();
    }

    public void V0() {
        WeakReference<com.tencent.mobileqq.listentogether.i> weakReference = this.f240870j0;
        com.tencent.mobileqq.listentogether.i iVar = weakReference == null ? null : weakReference.get();
        if (iVar != null) {
            iVar.onCancel();
        }
        this.f240870j0 = null;
    }

    public ProfileMusicBoxController W() {
        return this.K;
    }

    public void W0(boolean z16) {
        WeakReference<com.tencent.mobileqq.listentogether.i> weakReference = this.f240870j0;
        com.tencent.mobileqq.listentogether.i iVar = weakReference == null ? null : weakReference.get();
        if (iVar != null) {
            iVar.a(z16);
        }
        this.f240870j0 = null;
    }

    public long X(int i3, String str) {
        Long l3 = this.N.get(i3 + "_" + str);
        if (l3 == null) {
            return 0L;
        }
        return l3.longValue();
    }

    public void X0(int i3, String str, int i16) {
        QLog.i("ListenTogether.Manager", 1, "onExitAio. mLastEnterAIOId:" + this.f240862e0 + " aioId:" + i16);
        LyricsController lyricsController = this.J;
        boolean z16 = lyricsController != null && lyricsController.v().f241061m;
        if (this.f240862e0 != i16 || z16) {
            return;
        }
        this.f240871m = false;
        LyricsController lyricsController2 = this.J;
        if (lyricsController2 != null) {
            lyricsController2.G(i3, str, false);
        }
    }

    public void Y0(int i3, String str, boolean z16) {
        ListenTogetherHandler listenTogetherHandler;
        QLog.i("ListenTogether.Manager", 1, "onExitListenTogether type: " + i3 + " ,uin: " + str + "bForceStop" + z16);
        if ((i3 != 1 && i3 != 2) || TextUtils.isEmpty(str) || (listenTogetherHandler = (ListenTogetherHandler) this.f240859d.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)) == null) {
            return;
        }
        if (z16) {
            listenTogetherHandler.d3(i3, str);
        } else {
            listenTogetherHandler.X2(i3, str);
        }
    }

    public void Z0(boolean z16, ListenTogetherSession listenTogetherSession, int i3, boolean z17) {
        QLog.i("ListenTogether.Manager", 1, "onGetExitListenTogetherResponse isSuceess: " + z16 + " byUser: " + z17);
        if (listenTogetherSession == null) {
            return;
        }
        ListenTogetherSession listenTogetherSession2 = this.E.get(listenTogetherSession.f());
        if (!z16) {
            H0(listenTogetherSession2);
            C0(listenTogetherSession2);
            return;
        }
        if (listenTogetherSession.f437188e == 2) {
            if (i3 == 3) {
                com.tencent.mobileqq.listentogether.a.b(this.f240859d, listenTogetherSession.f437189f, false);
            }
        } else if (i3 == 3) {
            com.tencent.mobileqq.listentogether.a.c(this.f240859d, listenTogetherSession.f437189f, false);
        }
        s1(listenTogetherSession.f437188e, listenTogetherSession.f437189f, 1016);
    }

    public void a0(boolean z16, Object obj) {
        if (QLog.isColorLevel()) {
            QLog.d("AioShareMusicListenTogether.Manager", 2, "handleCheckAndShowAioShareMusic() isSuccess = " + z16);
        }
        if (z16) {
            try {
                com.tencent.aiosharemusic.a.b((JSONObject) obj, "checkAioShareMusic");
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    public void c0(boolean z16, int i3, String str, String str2, int i16, String str3) {
        if (QLog.isColorLevel()) {
            QLog.i("ListenTogether.Manager", 1, String.format("suc=%b type=%d uin=%s, err=%s from=%d id=%s", Boolean.valueOf(z16), Integer.valueOf(i3), MobileQQ.getShortUinStr(str), str2, Integer.valueOf(i16), str3));
        }
        if (z16) {
            if (i3 == 2) {
                com.tencent.mobileqq.listentogether.a.b(this.f240859d, str, true);
            } else if (i3 == 1) {
                com.tencent.mobileqq.listentogether.a.c(this.f240859d, str, true);
            }
            s1(i3, str, 1023);
        }
        ListenTogetherHandler listenTogetherHandler = (ListenTogetherHandler) this.f240859d.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER);
        if (listenTogetherHandler != null) {
            listenTogetherHandler.notifyUI(23, z16, new Object[]{Integer.valueOf(i3), str, str2, Integer.valueOf(i16), str3});
        }
    }

    public void c1(int i3, String str, long j3, long j16, String str2) {
        QLog.i("ListenTogether.Manager", 1, "onGetListenTogetherJoinedCountChangePush type: " + i3 + " uin: " + str + " sep: " + j3 + " timeStamp: " + j16);
        r0(i3, str, str2);
        ListenTogetherSession listenTogetherSession = this.E.get(d72.b.m(i3, str));
        if (listenTogetherSession == null) {
            return;
        }
        listenTogetherSession.N = str2;
    }

    public void d0(boolean z16, Object[] objArr) {
        if (QLog.isColorLevel()) {
            QLog.d("AioShareMusicListenTogether.Manager", 2, "handleReportDownloadFailedAioShareMusic()  isSuccess = " + z16);
        }
    }

    public void e1(boolean z16, ListenTogetherSession listenTogetherSession, int i3) {
        QLog.i("ListenTogether.Manager", 1, "onGetListenTogetherSessionFromServer, success: " + z16 + " ,session: " + listenTogetherSession + " ,by: " + L(i3));
        if (listenTogetherSession == null) {
            return;
        }
        if (z16) {
            if (G1(listenTogetherSession, i3)) {
                ListenTogetherSession listenTogetherSession2 = this.E.get(listenTogetherSession.f());
                boolean D1 = D1(listenTogetherSession2);
                E1(listenTogetherSession2);
                H0(listenTogetherSession2);
                r0(listenTogetherSession2.f437188e, listenTogetherSession2.f437189f, listenTogetherSession2.N);
                if (this.f240863f.equals(listenTogetherSession.f()) || D1) {
                    if (n0(i3)) {
                        this.D = true;
                    }
                    w0(listenTogetherSession2, i3);
                    P0(listenTogetherSession2);
                }
                if (this.f240863f.equals(listenTogetherSession.f())) {
                    if (j0(i3)) {
                        this.J.s();
                    }
                    if (i3 == 1014 || i3 == 1015 || i3 == 1012 || i3 == 1003) {
                        K0(listenTogetherSession.f437188e, listenTogetherSession.f437189f, "switchSong", 0);
                    }
                    if (i3 == 1020) {
                        K0(listenTogetherSession.f437188e, listenTogetherSession.f437189f, "playModeChange", listenTogetherSession.V);
                    }
                    if (i3 == 1021) {
                        q0(listenTogetherSession.f437188e, listenTogetherSession.f437189f);
                    }
                }
                if (D1) {
                    final int i16 = listenTogetherSession.f437188e;
                    final String str = listenTogetherSession.f437189f;
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.listentogether.ListenTogetherManager.15
                        @Override // java.lang.Runnable
                        public void run() {
                            ListenTogetherManager.this.J.x(i16, str);
                        }
                    });
                    if (i3 == 1012) {
                        K0(listenTogetherSession.f437188e, listenTogetherSession.f437189f, "closeListen", 0);
                        return;
                    } else {
                        K0(listenTogetherSession.f437188e, listenTogetherSession.f437189f, "comeoutSong", 0);
                        return;
                    }
                }
                return;
            }
            return;
        }
        H0(this.E.get(listenTogetherSession.f()));
    }

    public boolean h0(int i3, String str) {
        return this.J.A(i3, str);
    }

    public boolean i1(QBaseActivity qBaseActivity, int i3, String str, int i16) {
        QLog.d("ListenTogether.Manager", 1, "joinListenTogether type: " + i3 + " ,uin: " + str + " ,by:" + M(i16));
        if (!H()) {
            return false;
        }
        if (!this.f240859d.isVideoChatting() && !this.f240859d.isPttRecordingOrPlaying()) {
            if (tr2.b.q(this.f240859d).f(qBaseActivity, 1, str, i3)) {
                return false;
            }
            ListenTogetherHandler listenTogetherHandler = (ListenTogetherHandler) this.f240859d.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER);
            if (listenTogetherHandler != null) {
                listenTogetherHandler.S2(i3, str, i16);
            }
            return true;
        }
        z1(qBaseActivity, HardCodeUtil.qqStr(R.string.f172142nq3));
        H0(this.E.get(d72.b.m(i3, str)));
        return false;
    }

    public void j1() {
        WeakReference<com.tencent.mobileqq.listentogether.j> weakReference = this.f240865g0;
        com.tencent.mobileqq.listentogether.j jVar = weakReference == null ? null : weakReference.get();
        if (jVar != null) {
            jVar.onCancel();
        }
        this.f240865g0 = null;
    }

    public boolean k0() {
        int V = V();
        return V == 2 || V == 1;
    }

    public void k1() {
        WeakReference<com.tencent.mobileqq.listentogether.j> weakReference = this.f240865g0;
        com.tencent.mobileqq.listentogether.j jVar = weakReference == null ? null : weakReference.get();
        if (jVar != null) {
            jVar.a();
        }
        this.f240865g0 = null;
    }

    public boolean l0(int i3, String str) {
        return this.f240863f.equals(d72.b.m(i3, str));
    }

    public void o1(int i3, String str) {
        ListenTogetherHandler listenTogetherHandler;
        QLog.i("ListenTogether.Manager", 1, "onPauseMusicPlay type: " + i3 + " ,uin: " + str);
        this.f240861e.removeMessages(1001);
        boolean pausePlay = this.I.pausePlay();
        ListenTogetherSession listenTogetherSession = this.E.get(d72.b.m(i3, str));
        if (!pausePlay) {
            E0(i3, str);
        } else {
            if (listenTogetherSession == null || (listenTogetherHandler = (ListenTogetherHandler) this.f240859d.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)) == null) {
                return;
            }
            listenTogetherHandler.V2(listenTogetherSession.f437188e, listenTogetherSession.f437189f);
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        QLog.i("ListenTogether.Manager", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        this.C = true;
        this.f240861e.removeCallbacksAndMessages(null);
        this.I.stopPlay();
        this.H.destroy();
        this.J.t();
        this.K.t();
        this.L.v();
        this.f240859d.removeObserver(this.f240856a0);
        this.f240859d.removeObserver(this.Z);
        this.f240859d.removeObserver(this.f240857b0);
        if (LyricsController.B()) {
            return;
        }
        BaseApplication.getContext().unregisterReceiver(this.f240858c0);
    }

    public void p1(boolean z16, int i3, String str) {
        QLog.i("ListenTogether.Manager", 1, "onPauseRespFromServer, success: " + z16 + " ,type: " + i3 + " ,uin: " + str);
        if (!z16) {
            E0(i3, str);
        }
        K0(i3, str, "pauseSong", 0);
        s1(i3, str, 1005);
    }

    public void q1(int i3, String str) {
        ListenTogetherHandler listenTogetherHandler;
        QLog.i("ListenTogether.Manager", 1, "onResumeMusicPlay type: " + i3 + " ,uin: " + str);
        this.f240861e.removeMessages(1001);
        boolean resumePlay = this.I.resumePlay();
        ListenTogetherSession listenTogetherSession = this.E.get(d72.b.m(i3, str));
        if (!resumePlay) {
            G0(i3, str);
        } else {
            if (listenTogetherSession == null || (listenTogetherHandler = (ListenTogetherHandler) this.f240859d.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)) == null) {
                return;
            }
            listenTogetherHandler.W2(listenTogetherSession.f437188e, listenTogetherSession.f437189f);
        }
    }

    public void r1(boolean z16, int i3, String str) {
        QLog.i("ListenTogether.Manager", 1, "onResumeRespFromServer, success: " + z16 + " ,type: " + i3 + " ,uin: " + str);
        if (!z16) {
            G0(i3, str);
        }
        K0(i3, str, "resumeSong", 0);
        s1(i3, str, 1006);
    }

    public void x0(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("AioShareMusicListenTogether.Manager", 2, "notifyPlayChangeToAioShareMusic() newSong = " + str);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("current_song_id", str);
            com.tencent.aiosharemusic.a.b(jSONObject, "updateSongIdToAioShareMusic");
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    public void x1(boolean z16) {
        LyricsController lyricsController = this.J;
        if (lyricsController == null || lyricsController.v() == null) {
            return;
        }
        this.J.v().f241061m = z16;
    }

    public void y1(String str, String str2, int i3) {
        this.P.put(str, i3 + "_" + str2);
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class g implements com.tencent.mobileqq.listentogether.player.c {
        g() {
        }

        @Override // com.tencent.mobileqq.listentogether.player.c
        public void a(ISong iSong) {
            if (iSong != null) {
                ListenTogetherManager.this.s0(iSong);
                ListenTogetherManager.this.x0(iSong.getId());
                String str = (String) ListenTogetherManager.this.G.get(iSong.getId());
                if (!TextUtils.isEmpty(str)) {
                    ListenTogetherManager.this.v0(iSong.getId(), str);
                } else {
                    ListenTogetherManager.this.S(iSong.getId());
                }
            }
        }
    }

    public boolean f0() {
        QLog.d("ListenTogether.Manager", 1, String.format("isJoinSession [%s, %s]", this.f240868i, this.f240863f));
        return !TextUtils.isEmpty(this.f240863f);
    }

    public boolean g0(int i3, String str) {
        boolean z16 = false;
        if (i3 == 1) {
            TroopInfo n3 = ((TroopManager) this.f240859d.getManager(QQManagerFactory.TROOP_MANAGER)).n(str);
            if (n3 != null) {
                z16 = n3.isListenTogetherOpen();
            } else if (QLog.isColorLevel()) {
                QLog.d("ListenTogether.switch", 2, "isListenTogetherOpen troopinfo is null");
            }
        } else if (i3 == 2) {
            com.tencent.qqnt.ntrelation.intimateinfo.bean.a intimateSimpleInfoWithUid = ((IIntimateInfoService) QRoute.api(IIntimateInfoService.class)).getIntimateSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "ListenTogether.Manager");
            if (intimateSimpleInfoWithUid != null) {
                z16 = intimateSimpleInfoWithUid.p().booleanValue();
            } else if (QLog.isColorLevel()) {
                QLog.d("ListenTogether.switch", 2, "isListenTogetherOpen extensionInfo is null");
            }
        }
        if (QLog.isColorLevel() && this.R != z16) {
            QLog.d("ListenTogether.switch", 2, "isListenTogetherOpen, type:" + i3 + " uin:" + str + " res:" + z16);
        }
        this.R = z16;
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class c implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f240881d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f240882e;

        c(int i3, String str) {
            this.f240881d = i3;
            this.f240882e = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (i3 == 1) {
                ListenTogetherManager.this.k1();
                dialogInterface.dismiss();
            } else if (i3 == 0) {
                ListenTogetherManager.this.j1();
                dialogInterface.dismiss();
                ListenTogetherManager listenTogetherManager = ListenTogetherManager.this;
                listenTogetherManager.H0((ListenTogetherSession) listenTogetherManager.E.get(d72.b.m(this.f240881d, this.f240882e)));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class k extends BroadcastReceiver {
        k() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getIntExtra("pid", Process.myPid()) == Process.myPid()) {
                QLog.i("ListenTogether.Manager", 1, "onThemeChange.");
                ListenTogetherManager.this.z0();
            }
        }
    }

    private void P0(ListenTogetherSession listenTogetherSession) {
        List<MusicInfo> list;
        ListenTogetherHandler listenTogetherHandler;
        if (listenTogetherSession == null || (list = listenTogetherSession.L) == null || list.isEmpty() || listenTogetherSession.f437191i != 1 || listenTogetherSession.f437192m != 2) {
            return;
        }
        int size = listenTogetherSession.L.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i3 = 0; i3 < size; i3++) {
            MusicInfo musicInfo = listenTogetherSession.L.get(i3);
            if (musicInfo != null) {
                if (musicInfo.j()) {
                    this.F.put(musicInfo.f240910d, musicInfo);
                }
                boolean z16 = (i0(this.F.get(musicInfo.f240910d)) && musicInfo.j()) ? false : true;
                if (z16) {
                    arrayList.add(new com.tencent.mobileqq.listentogether.h(musicInfo.f240910d, z16, false));
                }
            }
        }
        if (arrayList.isEmpty() || (listenTogetherHandler = (ListenTogetherHandler) this.f240859d.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)) == null) {
            return;
        }
        listenTogetherHandler.H2(listenTogetherSession.f437188e, listenTogetherSession.f437189f, arrayList, false);
    }

    private void z1(QBaseActivity qBaseActivity, String str) {
        QQToast.makeText(qBaseActivity, 1, str, 0).show(qBaseActivity.getTitleBarHeight());
    }

    public void g1(boolean z16, List<MusicInfo> list, boolean z17) {
        if (z17) {
            f1(z16, list);
        } else {
            h1(z16, list);
        }
    }

    public void v1() {
        this.M = 0L;
    }

    private String L(int i3) {
        switch (i3) {
            case 1000:
                return "enter_aio";
            case 1001:
                return IHWTroopUtilsApi.HOMEWORK_TROOP_JOIN_SOURCE;
            case 1002:
                return "js_api";
            case 1003:
                return "push";
            case 1004:
                return "audio_release";
            case 1005:
                return "pause";
            case 1006:
                return "resume";
            case 1007:
                return "finish";
            case 1008:
                return "net_connected";
            case 1009:
                return "js_api_open";
            case 1010:
                return "js_api_cute";
            case 1011:
                return "js_api_close";
            case 1012:
                return "push_close";
            case 1013:
                return "js_api_end_try_song";
            case 1014:
                return "push_cute";
            case 1015:
                return "push_auto_cute";
            case 1016:
                return "exit";
            case 1017:
                return "relation_finish";
            case 1018:
                return "musicbox_resume";
            case 1019:
                return "cut_song";
            case 1020:
                return "change_playmode";
            case 1021:
                return "join_enter";
            case 1022:
            default:
                return "";
            case 1023:
                return "client_open_n_join";
        }
    }

    private String M(int i3) {
        switch (i3) {
            case 1000:
                return "JOIN_SESSION_BY_MUSIC_PANEL";
            case 1001:
                return "JOIN_SESSION_BY_WEB";
            case 1002:
                return "JOIN_SESSION_BY_JOIN_AND_ENTER";
            default:
                return "";
        }
    }

    public void m1(JSONObject jSONObject) {
        int i3;
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("type");
        String optString2 = jSONObject.optString("uin");
        int optInt = jSONObject.optInt("uinType");
        int i16 = 1;
        QLog.i("ListenTogether.Manager", 1, "onMusicStateChangeJsApiCalled type: " + optInt + " uin: " + optString2 + " apiType: " + optString);
        if ("switchSong".equals(optString)) {
            s1(optInt, optString2, 1010);
            return;
        }
        if ("openListen".equals(optString)) {
            if (optInt == 2) {
                com.tencent.mobileqq.listentogether.a.b(this.f240859d, optString2, true);
            } else if (optInt == 1) {
                com.tencent.mobileqq.listentogether.a.c(this.f240859d, optString2, true);
            }
            s1(optInt, optString2, 1009);
            return;
        }
        boolean z16 = false;
        if ("closeListen".equals(optString)) {
            if (optInt == 2) {
                com.tencent.mobileqq.listentogether.a.b(this.f240859d, optString2, false);
            } else if (optInt == 1) {
                com.tencent.mobileqq.listentogether.a.c(this.f240859d, optString2, false);
            }
            s1(optInt, optString2, 1011);
            return;
        }
        if ("addSong".equals(optString)) {
            s1(optInt, optString2, 1002);
            return;
        }
        if ("deleteSong".equals(optString)) {
            s1(optInt, optString2, 1002);
            return;
        }
        if ("sortSong".equals(optString)) {
            s1(optInt, optString2, 1002);
            return;
        }
        if ("closeListenSelf".equals(optString)) {
            Y0(optInt, optString2, false);
            return;
        }
        if ("showLyrics".equals(optString)) {
            t0(optInt, optString2, true, true);
            return;
        }
        if ("hideLyrics".equals(optString)) {
            t0(optInt, optString2, false, true);
            return;
        }
        if ("checkJoin".equals(optString)) {
            if (f0()) {
                ListenTogetherSession listenTogetherSession = this.E.get(this.f240863f);
                if (listenTogetherSession != null) {
                    boolean equals = TextUtils.equals(listenTogetherSession.C, this.f240859d.getCurrentUin());
                    i3 = listenTogetherSession.f437188e;
                    i16 = 0;
                    z16 = equals;
                } else {
                    i3 = 1;
                    i16 = 0;
                }
            } else {
                i3 = 1;
            }
            I0(i16, z16, i3);
            return;
        }
        if ("endTrySong".equals(optString)) {
            if (SystemClock.elapsedRealtime() - this.M <= 180000) {
                w1(1013);
                return;
            } else {
                QLog.i("ListenTogether.Manager", 1, "endTrySong, > 3 min");
                return;
            }
        }
        if ("joinListen".equals(optString)) {
            ListenTogetherHandler listenTogetherHandler = (ListenTogetherHandler) this.f240859d.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER);
            if (listenTogetherHandler != null) {
                listenTogetherHandler.S2(optInt, optString2, 1001);
                return;
            }
            return;
        }
        if ("musicboxResume".equals(optString)) {
            w1(1018);
        }
    }

    public void t1(MusicInfo musicInfo) {
        if (musicInfo == null) {
            return;
        }
        try {
            String K = K(musicInfo.f240910d);
            if (TextUtils.isEmpty(K)) {
                return;
            }
            String[] split = K.split("_");
            int parseInt = Integer.parseInt(split[0]);
            String str = split[1];
            ListenTogetherHandler listenTogetherHandler = (ListenTogetherHandler) this.f240859d.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER);
            if (listenTogetherHandler != null) {
                listenTogetherHandler.Y2(parseInt, str, musicInfo.f240910d, musicInfo.f240911e, musicInfo.f240914i.get(0), musicInfo.f240913h);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private boolean i0(MusicInfo musicInfo) {
        return musicInfo != null && SystemClock.elapsedRealtime() - musicInfo.E < 180000;
    }

    public void e0(boolean z16, Object obj) {
        String str;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isSuccess", z16);
            if (z16) {
                Object[] objArr = (Object[]) obj;
                int intValue = ((Integer) objArr[0]).intValue();
                String str2 = (String) objArr[1];
                String str3 = (String) objArr[2];
                s1(intValue, str2, 1022);
                y1(str3, str2, intValue);
                if (intValue == 2) {
                    str = "c2c_AIO";
                } else {
                    str = "Grp_AIO";
                }
                String str4 = str;
                if (intValue == 2) {
                    str2 = "";
                }
                ReportController.o(null, "dc00899", str4, "", "music_tab", "clk_share_suc", 0, 0, str2, "", "", "");
            } else {
                Object[] objArr2 = (Object[]) obj;
                int intValue2 = ((Integer) objArr2[0]).intValue();
                String str5 = (String) objArr2[1];
                jSONObject.put("uint32_result", intValue2);
                jSONObject.put("bytes_errmsg", str5);
            }
            if (QLog.isColorLevel()) {
                QLog.d("AioShareMusicListenTogether.Manager", 2, "handleStartAioShareMusic() jsonObject = " + jSONObject.toString());
            }
            com.tencent.aiosharemusic.a.b(jSONObject, "startListenAioShareMusic");
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    public void m0(QBaseActivity qBaseActivity, int i3, String str) {
        String str2;
        ListenTogetherSession listenTogetherSession = this.E.get(d72.b.m(i3, str));
        Object[] objArr = new Object[7];
        objArr[0] = "joinTogetherAndEnter";
        objArr[1] = " type=";
        objArr[2] = Integer.valueOf(i3);
        objArr[3] = " uin=";
        objArr[4] = str;
        objArr[5] = " session=";
        if (listenTogetherSession != null) {
            str2 = listenTogetherSession.toString();
        } else {
            str2 = "null";
        }
        objArr[6] = str2;
        QLog.d("ListenTogether.Manager", 1, objArr);
        if (listenTogetherSession != null && listenTogetherSession.f437191i != 3) {
            if (listenTogetherSession.f437192m != 2) {
                this.f240864f0 = new b(new WeakReference(qBaseActivity), i3, str);
                J(this.f240859d).E(qBaseActivity, i3, str, this.f240864f0);
            } else {
                q0(i3, str);
            }
        } else {
            z1(qBaseActivity, HardCodeUtil.qqStr(R.string.isa));
        }
        if (i3 == 2) {
            ReportController.o(null, "dc00899", "c2c_AIO", "", "music_tab", "clk_musicark", 0, 0, str, "", "", "");
            return;
        }
        ReportController.o(null, "dc00899", "Grp_AIO", "", "music_tab", "clk_musicark", 0, 0, str, "", "" + d72.b.j(this.f240859d.getCurrentAccountUin(), str), "");
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class e implements com.tencent.mobileqq.listentogether.player.f {
        e() {
        }

        @Override // com.tencent.mobileqq.listentogether.player.f
        public void b(boolean z16) {
            QLog.i("ListenTogether.Manager", 1, "onNetChanged: " + z16);
            if (z16) {
                ListenTogetherManager.this.n1();
            }
        }

        @Override // com.tencent.mobileqq.listentogether.player.f
        public void c(boolean z16, boolean z17) {
            QLog.i("ListenTogether.Manager", 1, "onFocusChanged: " + z16 + " isTransient:" + z17);
            ListenTogetherManager.this.D = z16;
            if (z16) {
                ListenTogetherManager.this.f240861e.removeCallbacks(ListenTogetherManager.this.T);
                ListenTogetherManager.this.f240861e.postDelayed(ListenTogetherManager.this.V, ListenTogetherManager.this.P());
                ListenTogetherManager.this.U.a(ListenTogetherManager.this.f240866h);
                ListenTogetherManager.this.f240861e.postDelayed(ListenTogetherManager.this.U, ListenTogetherManager.this.P());
                ListenTogetherManager.this.M = 0L;
                return;
            }
            ListenTogetherManager.this.f240861e.removeCallbacks(ListenTogetherManager.this.V);
            ListenTogetherManager.this.f240861e.removeCallbacks(ListenTogetherManager.this.U);
            ListenTogetherManager.this.T.a(ListenTogetherManager.this.f240866h);
            ListenTogetherManager.this.f240861e.postDelayed(ListenTogetherManager.this.T, ListenTogetherManager.this.P());
            if (z17) {
                ListenTogetherManager.this.M = 0L;
            } else {
                ListenTogetherManager.this.M = SystemClock.elapsedRealtime();
            }
        }

        @Override // com.tencent.mobileqq.listentogether.player.f
        public void a(String str, int i3) {
            String id5;
            com.tencent.mobileqq.onlinestatus.manager.e eVar;
            Object[] objArr = new Object[5];
            objArr[0] = "onPlayStateChanged: " + com.tencent.mobileqq.listentogether.player.a.a(i3);
            objArr[1] = " songId:";
            objArr[2] = str;
            objArr[3] = " curSongID:";
            if (QQMusicPlayService.C() == null) {
                id5 = "sCurSong is null";
            } else {
                id5 = QQMusicPlayService.C().getId();
            }
            objArr[4] = id5;
            QLog.d("ListenTogether.Manager", 1, objArr);
            HashMap<String, String> hashMap = new HashMap<>();
            if (i3 == 8) {
                ListenTogetherManager.this.l1();
            } else if (i3 == 5 || i3 == 7) {
                hashMap.put("status", String.valueOf(i3));
            }
            if (i3 == 2) {
                if (ListenTogetherManager.this.K.i0()) {
                    ListenTogetherManager.this.K.l0();
                    ListenTogetherManager.this.K.q0();
                }
                ListenTogetherManager.this.f240861e.removeCallbacks(ListenTogetherManager.this.T);
                ListenTogetherManager.this.U.a(ListenTogetherManager.this.f240866h);
                ListenTogetherManager.this.f240861e.postDelayed(ListenTogetherManager.this.U, ListenTogetherManager.this.P());
                hashMap.put("status", String.valueOf(i3));
            } else if (i3 == 4 || i3 == 5 || i3 == 7) {
                ListenTogetherManager.this.f240861e.removeCallbacks(ListenTogetherManager.this.U);
                ListenTogetherManager.this.T.a(ListenTogetherManager.this.f240866h);
                ListenTogetherManager.this.f240861e.postDelayed(ListenTogetherManager.this.T, ListenTogetherManager.this.P());
            }
            if (i3 == 2) {
                ListenTogetherManager.this.f240861e.removeMessages(1001);
                ListenTogetherManager.this.f240861e.sendEmptyMessageDelayed(1001, com.tencent.mobileqq.listentogether.c.b().f240898c);
            } else {
                ListenTogetherManager.this.f240861e.removeMessages(1001);
            }
            ListenTogetherManager.this.y0(str, i3);
            if (!hashMap.isEmpty()) {
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "listen_together_player_status", true, 0L, 0L, hashMap, "");
            }
            if (QQMusicPlayService.C() == null || (eVar = (com.tencent.mobileqq.onlinestatus.manager.e) ((IOnlineStatusManagerService) ListenTogetherManager.this.f240859d.getRuntimeService(IOnlineStatusManagerService.class)).getManager(com.tencent.mobileqq.onlinestatus.manager.e.class)) == null) {
                return;
            }
            eVar.p(i3);
        }
    }

    private void u1(int i3, String str, String str2, String str3) {
        if (i3 == 2) {
            ReportController.o(null, "dc00899", "c2c_AIO", "", "music_tab", "song_play", 0, 0, "", "", str3, str2);
            return;
        }
        TroopInfo k3 = ((TroopManager) this.f240859d.getManager(QQManagerFactory.TROOP_MANAGER)).k(str);
        if (k3 != null) {
            r0 = k3.isOwner() ? 0 : 2;
            if (k3.isAdmin()) {
                r0 = 1;
            }
        }
        ReportController.o(null, "dc00899", "Grp_AIO", "", "music_tab", "song_play", 0, 0, str, String.valueOf(r0), str3, str2);
    }

    public void a1(boolean z16, ListenTogetherSession listenTogetherSession, int i3) {
        QLog.i("ListenTogether.Manager", 1, "onGetJoinListenTogetherResponse isSuccess: " + z16 + " by: " + M(i3));
        if (listenTogetherSession == null) {
            return;
        }
        ListenTogetherSession listenTogetherSession2 = this.E.get(listenTogetherSession.f());
        int i16 = 1001;
        if (!z16) {
            H0(listenTogetherSession2);
            if (i3 != 1001) {
                D0(listenTogetherSession2, false);
                return;
            } else {
                J0(1);
                return;
            }
        }
        switch (i3) {
            case 1000:
                break;
            case 1001:
                i16 = 1009;
                break;
            case 1002:
                i16 = 1021;
                break;
            default:
                i16 = -1;
                break;
        }
        s1(listenTogetherSession.f437188e, listenTogetherSession.f437189f, i16);
        J0(0);
        if (i3 == 1002) {
            if (listenTogetherSession.f437188e == 2) {
                ReportController.o(null, "dc00899", "c2c_AIO", "", "music_tab", "clk_musicark_suc", 0, 0, listenTogetherSession.f437189f, "", "", "");
                return;
            }
            ReportController.o(null, "dc00899", "Grp_AIO", "", "music_tab", "clk_musicark_suc", 0, 0, listenTogetherSession.f437189f, "", "" + d72.b.j(this.f240859d.getCurrentAccountUin(), listenTogetherSession.f437189f), "");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x00c1, code lost:
    
        if (r21 == 31) goto L54;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d1(int i3, String str, long j3, String str2, int i16, long j16, Object obj) {
        if (QLog.isColorLevel()) {
            QLog.i("ListenTogether.Manager", 2, String.format("onGetListenTogetherPush type=%d seq=%d actionUin=%s pushType=%s data=%s ts=%d", Integer.valueOf(i3), Long.valueOf(j3), str2, Y(i16), obj, Long.valueOf(j16)));
        }
        if (this.f240859d.getCurrentAccountUin().equals(str2) && i16 != 3 && i16 != 4 && i16 != 14) {
            if (i16 == 1) {
                if (i3 == 2) {
                    com.tencent.mobileqq.listentogether.a.b(this.f240859d, str, true);
                } else if (i3 == 1) {
                    com.tencent.mobileqq.listentogether.a.c(this.f240859d, str, true);
                }
            } else if (i16 == 2) {
                if (i3 == 2) {
                    com.tencent.mobileqq.listentogether.a.b(this.f240859d, str, false);
                } else if (i3 == 1) {
                    com.tencent.mobileqq.listentogether.a.c(this.f240859d, str, false);
                }
                I1(i3, str, 3);
            } else if (i16 == 32) {
                Z0(true, new ListenTogetherSession(i3, str), 2, false);
            }
            QLog.i("ListenTogether.Manager", 1, "onGetListenTogetherPush action uin == current uin return.");
            return;
        }
        F1(i3, str, j16);
        if (i16 == 14) {
            this.f240861e.removeCallbacks(this.S);
        } else if (i16 == 1 || i16 == 3) {
            if (i3 == 2) {
                com.tencent.mobileqq.listentogether.a.b(this.f240859d, str, true);
            } else if (i3 == 1) {
                com.tencent.mobileqq.listentogether.a.c(this.f240859d, str, true);
            }
            K0(i3, str, "openListen", 0);
        } else {
            if (i16 != 2 && i16 != 4) {
                if (i16 == 16) {
                    r10 = (b0(i3, str, obj instanceof Integer ? ((Integer) obj).intValue() : 0) ? 1 : 0) | 1;
                }
                if (r10 == 0) {
                    s1(i3, str, i16 == 2 ? 1012 : i16 == 12 ? 1014 : i16 == 14 ? 1015 : i16 == 16 ? 1020 : 1003);
                    return;
                }
                return;
            }
            if (i3 == 2) {
                com.tencent.mobileqq.listentogether.a.b(this.f240859d, str, false);
            } else if (i3 == 1) {
                com.tencent.mobileqq.listentogether.a.c(this.f240859d, str, false);
            }
            I1(i3, str, 3);
            K0(i3, str, "closeListen", 0);
        }
        r10 = 1;
        if (r10 == 0) {
        }
    }

    private String Y(int i3) {
        if (i3 == 1) {
            return "start";
        }
        if (i3 == 2) {
            return "stop";
        }
        if (i3 == 3) {
            return "auto_start";
        }
        if (i3 == 4) {
            return "auto_stop";
        }
        if (i3 == 11) {
            return "play";
        }
        if (i3 == 12) {
            return "cut";
        }
        if (i3 == 31) {
            return IHWTroopUtilsApi.HOMEWORK_TROOP_JOIN_SOURCE;
        }
        if (i3 != 32) {
            switch (i3) {
                case 14:
                    return "auto_cut";
                case 15:
                    return "pause";
                case 16:
                    return "change_playmode";
                default:
                    switch (i3) {
                        case 21:
                            return "add";
                        case 22:
                            return "delete";
                        case 23:
                            return "sort";
                        case 24:
                            return QCircleLpReportDc05507.KEY_CLEAR;
                        default:
                            return "";
                    }
            }
        }
        return "quit";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class b implements com.tencent.mobileqq.listentogether.j {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WeakReference f240877a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f240878b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f240879c;

        b(WeakReference weakReference, int i3, String str) {
            this.f240877a = weakReference;
            this.f240878b = i3;
            this.f240879c = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.listentogether.j
        public void a() {
            QBaseActivity qBaseActivity = (QBaseActivity) this.f240877a.get();
            if (ListenTogetherManager.this.C || qBaseActivity == null || qBaseActivity.isFinishing()) {
                return;
            }
            ListenTogetherManager.J(ListenTogetherManager.this.f240859d).i1(qBaseActivity, this.f240878b, this.f240879c, 1002);
        }

        @Override // com.tencent.mobileqq.listentogether.j
        public void onCancel() {
        }
    }
}
