package com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippy.qq.app.HippyQQPreloadEngine;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqgamepub.api.IQQGameTempRelyApi;
import com.tencent.mobileqq.qqgamepub.data.GmpEnterInfoRsp;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a;
import com.tencent.mobileqq.qqgamepub.nt.api.IQQGamePubMsgApi;
import com.tencent.mobileqq.qqgamepub.utils.QQGameUIHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.qwallet.utils.IArkPubicEventWrap;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mh2.a;
import mqq.app.MobileQQ;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

/* loaded from: classes16.dex */
public abstract class QQGameHippyBasePresenter<V extends mh2.a, M extends com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a> extends com.tencent.mobileqq.qqgamepub.mvp.presenter.base.a<V, M> implements BusinessObserver {
    static IPatchRedirector $redirector_;
    protected List<String> C;
    public hh2.a D;
    public final QQGameHippyBasePresenter<V, M>.b E;
    private final QQGameHippyBasePresenter<V, M>.c F;

    /* renamed from: f, reason: collision with root package name */
    protected AppInterface f264633f;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.mobileqq.qqgamepub.web.b f264634h;

    /* renamed from: i, reason: collision with root package name */
    public int f264635i;

    /* renamed from: m, reason: collision with root package name */
    public List<QQGameMsgInfo> f264636m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class a implements HippyEngine.BackPressHandler {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f264640a;

        a(Activity activity) {
            this.f264640a = activity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQGameHippyBasePresenter.this, (Object) activity);
            }
        }

        @Override // com.tencent.mtt.hippy.HippyEngine.BackPressHandler
        public void handleBackPress() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQGamePub_QQGameHippyBasePresenter", 1, "do Back Event,to finish");
            }
            this.f264640a.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public class b extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQGameHippyBasePresenter.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            if ("action_qgame_delete_ad".equals(intent.getAction())) {
                try {
                    if (QQGameHippyBasePresenter.this.j()) {
                        QQGameHippyBasePresenter.this.E(intent);
                    }
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public class c implements Observer {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQGameHippyBasePresenter.this);
            }
        }

        @Override // java.util.Observer
        public void update(Observable observable, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) observable, obj);
                return;
            }
            try {
                if (obj instanceof IArkPubicEventWrap.a) {
                    QLog.d("QQGamePub_QQGameHippyBasePresenter", 1, "ark transfer data:" + ((IArkPubicEventWrap.a) obj).f279244c + ",appName:" + ((IArkPubicEventWrap.a) obj).f279242a + ",eventName:" + ((IArkPubicEventWrap.a) obj).f279243b);
                    if ("gc_ark_notify_hippy".equals(((IArkPubicEventWrap.a) obj).f279243b)) {
                        QQGameHippyBasePresenter.this.m(((IArkPubicEventWrap.a) obj).f279244c);
                    }
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23375);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 29)) {
            redirector.redirect((short) 29);
        } else {
            l91.a.a();
        }
    }

    public QQGameHippyBasePresenter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f264635i = 1;
        this.C = new ArrayList();
        this.E = new b();
        this.F = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void E(Intent intent) {
        QQGameMsgInfo qQGameMsgInfo;
        String stringExtra = intent.getStringExtra("arkViewId");
        boolean booleanExtra = intent.getBooleanExtra("isAioDeletMsg", false);
        Iterator<QQGameMsgInfo> it = this.f264636m.iterator();
        while (true) {
            if (it.hasNext()) {
                qQGameMsgInfo = it.next();
                if (stringExtra.equals(String.valueOf(qQGameMsgInfo.uniseq))) {
                    break;
                }
            } else {
                qQGameMsgInfo = null;
                break;
            }
        }
        if (qQGameMsgInfo != null) {
            if (!booleanExtra) {
                ((IQQGamePubMsgApi) QRoute.api(IQQGamePubMsgApi.class)).deleteMsg(qQGameMsgInfo.msgId);
                QQToast.makeText(y(), R.string.f211685lh, 1).show();
            }
            D(stringExtra);
        }
    }

    private void H() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("action_qgame_delete_ad");
            MobileQQ.sMobileQQ.registerReceiver(this.E, intentFilter);
        } catch (Throwable th5) {
            QLog.e("QQGamePub_QQGameHippyBasePresenter", 1, "GamePAHippyBaseFragment register BroadCastReceiver error: " + th5.getMessage());
        }
    }

    private void L() {
        ((IArkPubicEventWrap) QRoute.api(IArkPubicEventWrap.class)).unRegistVolumnReceiver(this.C);
        ((IArkPubicEventWrap) QRoute.api(IArkPubicEventWrap.class)).deleteObserver(this.F);
    }

    private void M() {
        ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) this.f264632e).c().deleteObserver(this.D);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(String str) {
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushString("data", str);
        J("gc_hippy_rec_ark", hippyMap);
    }

    public HippyQQPreloadEngine A() {
        mh2.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (HippyQQPreloadEngine) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        if (!j()) {
            QLog.i("QQGamePub_QQGameHippyBasePresenter", 1, "[getHippyQQEngine] view is detach");
            return null;
        }
        Reference reference = this.f264631d;
        if (reference == null || (aVar = (mh2.a) reference.get()) == null) {
            return null;
        }
        return aVar.Wg();
    }

    protected int B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return 5;
    }

    public com.tencent.mobileqq.qqgamepub.web.b C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (com.tencent.mobileqq.qqgamepub.web.b) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        if (this.f264634h == null) {
            this.f264634h = new com.tencent.mobileqq.qqgamepub.web.b();
        }
        return this.f264634h;
    }

    public void D(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) str);
        }
    }

    protected void F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        this.f264636m = (List) y().getIntent().getSerializableExtra(TabPreloadItem.TAB_NAME_MESSAGE);
        this.D = new hh2.a() { // from class: com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameHippyBasePresenter.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQGameHippyBasePresenter.this);
                }
            }

            @Override // hh2.a
            public void a(ArrayList<QQGameMsgInfo> arrayList) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) arrayList);
                    return;
                }
                super.a(arrayList);
                List<QQGameMsgInfo> list = QQGameHippyBasePresenter.this.f264636m;
                if (list != null && list.size() <= QQGameHippyBasePresenter.this.B()) {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable(arrayList) { // from class: com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameHippyBasePresenter.2.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ ArrayList f264638d;

                        {
                            this.f264638d = arrayList;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this, (Object) arrayList);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            Iterator it = this.f264638d.iterator();
                            while (it.hasNext()) {
                                QQGameMsgInfo qQGameMsgInfo = (QQGameMsgInfo) it.next();
                                if (!TextUtils.isEmpty(qQGameMsgInfo.arkAppName)) {
                                    ((IArkPubicEventWrap) QRoute.api(IArkPubicEventWrap.class)).addNotify(qQGameMsgInfo.arkAppName);
                                    QQGameHippyBasePresenter.this.C.add(qQGameMsgInfo.arkAppName);
                                }
                            }
                            QQGameHippyBasePresenter.this.P(this.f264638d);
                        }
                    });
                }
            }
        };
        ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) this.f264632e).c().addObserver(this.D);
        List<QQGameMsgInfo> list = this.f264636m;
        if (list != null) {
            for (QQGameMsgInfo qQGameMsgInfo : list) {
                if (!TextUtils.isEmpty(qQGameMsgInfo.arkAppName)) {
                    ((IArkPubicEventWrap) QRoute.api(IArkPubicEventWrap.class)).addNotify(qQGameMsgInfo.arkAppName);
                    this.C.add(qQGameMsgInfo.arkAppName);
                }
            }
        }
        ((IArkPubicEventWrap) QRoute.api(IArkPubicEventWrap.class)).addObserver(this.F);
        n();
    }

    public void G(int i3, int i16, int i17, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushInt("action", i3);
        sb5.append("action=");
        sb5.append(i3);
        sb5.append("|");
        if (i16 != -1) {
            hippyMap.pushInt("index", i16);
        }
        sb5.append("index=");
        sb5.append(i16);
        sb5.append("|");
        if (i17 != -1) {
            hippyMap.pushInt("height", i17);
        }
        sb5.append("height=");
        sb5.append(i17);
        sb5.append("|");
        if (!TextUtils.isEmpty(str)) {
            hippyMap.pushString("gameData", str);
            sb5.append("gameData=");
            sb5.append(str);
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQGamePub_QQGameHippyBasePresenter", 1, "notfiyHippyPageRefresh data:" + sb5.toString());
        }
        J("onGameFeedsEvent", hippyMap);
    }

    public void I() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        AppInterface appInterface = this.f264633f;
        if (appInterface != null) {
            ((IGameMsgManagerService) appInterface.getRuntimeService(IGameMsgManagerService.class, "")).setUnshowedUnreadCnt(0);
            ((IQQGamePubMsgApi) QRoute.api(IQQGamePubMsgApi.class)).setMsgRead();
        }
    }

    public void J(String str, HippyMap hippyMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) str, (Object) hippyMap);
            return;
        }
        try {
            HippyQQPreloadEngine A = A();
            if (A != null && hippyMap != null && !TextUtils.isEmpty(str)) {
                ((EventDispatcher) A.getHippyEngine().getEngineContext().getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeEvent(str, hippyMap);
            }
        } catch (Throwable th5) {
            QLog.d("QQGamePub_QQGameHippyBasePresenter", 1, "sendHippyNativeEvent fail:" + th5.getMessage());
        }
    }

    public void K() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        QBaseActivity y16 = y();
        if (y16 != null) {
            ActivityURIRequest activityURIRequest = new ActivityURIRequest(y16, IPublicAccountDetailActivity.ROUTE_NAME);
            activityURIRequest.extra().putString("uin", "2747277822");
            activityURIRequest.extra().putBoolean("fromQGamePub", true);
            QRoute.startUri(activityURIRequest, (o) null);
        }
    }

    public void N() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            MobileQQ.sMobileQQ.unregisterReceiver(this.E);
        }
    }

    public void O(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
            return;
        }
        this.f264635i = i3;
        if (QLog.isColorLevel()) {
            QLog.i("QQGamePub_QQGameHippyBasePresenter", 2, "updateHippyState\uff1a" + i3);
        }
    }

    public void P(ArrayList<QQGameMsgInfo> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        }
    }

    public JSONObject o(JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (JSONObject) iPatchRedirector.redirect((short) 25, (Object) this, (Object) jSONObject);
        }
        return null;
    }

    @Override // mqq.observer.BusinessObserver
    public void onReceive(int i3, boolean z16, Bundle bundle) {
        Object obj;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
            return;
        }
        if (i3 == 31) {
            if (bundle != null) {
                GmpEnterInfoRsp gmpEnterInfoRsp = (GmpEnterInfoRsp) bundle.getSerializable("rsp");
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("GmpEnterInfoRsp|");
                    String str2 = "";
                    if (gmpEnterInfoRsp == null) {
                        obj = "";
                    } else {
                        obj = Integer.valueOf(gmpEnterInfoRsp.retCode);
                    }
                    sb5.append(obj);
                    QLog.d("QQGamePub_QQGameHippyBasePresenter", 2, sb5.toString());
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("GmpEnterInfoRsp|");
                    if (gmpEnterInfoRsp == null) {
                        str = "";
                    } else {
                        str = gmpEnterInfoRsp.url;
                    }
                    sb6.append(str);
                    QLog.d("QQGamePub_QQGameHippyBasePresenter", 2, sb6.toString());
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("GmpEnterInfoRsp|");
                    if (gmpEnterInfoRsp != null) {
                        str2 = gmpEnterInfoRsp.content;
                    }
                    sb7.append(str2);
                    QLog.d("QQGamePub_QQGameHippyBasePresenter", 2, sb7.toString());
                }
                if (gmpEnterInfoRsp != null) {
                    try {
                        p(gmpEnterInfoRsp, true);
                        return;
                    } catch (Throwable th5) {
                        QLog.d("QQGamePub_QQGameHippyBasePresenter", 1, "-->onReceive showGiftIcon fail:" + th5.getMessage());
                        return;
                    }
                }
                return;
            }
            QLog.d("QQGamePub_QQGameHippyBasePresenter", 2, "GmpEnterInfoRsp| is null");
            p(null, false);
        }
    }

    public void p(GmpEnterInfoRsp gmpEnterInfoRsp, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, gmpEnterInfoRsp, Boolean.valueOf(z16));
        }
    }

    public boolean q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        if (((IQQGameTempRelyApi) QRoute.api(IQQGameTempRelyApi.class)).isVideoFullScreenMode()) {
            ((IQQGameTempRelyApi) QRoute.api(IQQGameTempRelyApi.class)).exitVideoFullScreen();
            return true;
        }
        QBaseActivity y16 = y();
        if (y16 == null) {
            QLog.e("QQGamePub_QQGameHippyBasePresenter", 1, "GamePAHippyBaseFragment getActivity is null");
            return true;
        }
        HippyQQPreloadEngine A = A();
        if (A != null) {
            return A.doOnBackPressed(new a(y16));
        }
        y16.finish();
        return true;
    }

    public View r(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, this, layoutInflater, viewGroup, bundle);
        }
        ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) this.f264632e).h("QQGamePub_QQGameHippyBasePresenter", "onCreateView");
        ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) this.f264632e).p(SystemClock.elapsedRealtime());
        this.f264633f = ((ICmGameHelper) QRoute.api(ICmGameHelper.class)).getAppInterface();
        ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) this.f264632e).i(y(), bundle);
        ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) this.f264632e).a("preGetIntentData");
        ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) this.f264632e).a("setStatusBarImmersive");
        ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) this.f264632e).g();
        ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) this.f264632e).a("initDownload");
        F();
        ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) this.f264632e).a("initMessage");
        H();
        C().g(((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) this.f264632e).d());
        return null;
    }

    public void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            N();
        }
    }

    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) this.f264632e).t();
        L();
        M();
        QQGameUIHelper.b();
        com.tencent.mobileqq.qqgamepub.utils.b.c().a();
    }

    public void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) this.f264632e).j(z());
        }
    }

    public void v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        AppInterface appInterface = this.f264633f;
        if (appInterface != null) {
            ((IGameMsgManagerService) appInterface.getRuntimeService(IGameMsgManagerService.class, "")).setUnshowedUnreadCnt(0);
        }
    }

    public void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            I();
        }
    }

    public void x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        QBaseActivity y16 = y();
        if (y16 != null) {
            y16.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public QBaseActivity y() {
        mh2.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (QBaseActivity) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        if (!j()) {
            QLog.i("QQGamePub_QQGameHippyBasePresenter", 1, "[getActivity] view is detach");
            return null;
        }
        Reference reference = this.f264631d;
        if (reference == null || (aVar = (mh2.a) reference.get()) == null) {
            return null;
        }
        return (QBaseActivity) aVar.getActivity();
    }

    public String z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return "";
    }
}
