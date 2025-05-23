package com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.viewpager.widget.ViewPager;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.api.IQQGameTempRelyApi;
import com.tencent.mobileqq.qqgamepub.data.GmpEnterInfoReq;
import com.tencent.mobileqq.qqgamepub.data.GmpEnterInfoRsp;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.ipc.QQGameIPCHandler;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qqgamepub.view.GameArkView;
import com.tencent.mobileqq.qqgamepub.web.e;
import com.tencent.mobileqq.qqgamepub.web.f;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import com.tencent.mobileqq.qwallet.utils.IArkPubicEventWrap;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mh2.c;
import mqq.app.MobileQQ;
import mqq.observer.BusinessObserver;

/* loaded from: classes16.dex */
public class QQGameWebPresenter extends com.tencent.mobileqq.qqgamepub.mvp.presenter.base.a<c, com.tencent.mobileqq.qqgamepub.mvp.model.bean.a> implements WadlProxyServiceCallBackInterface, BusinessObserver, QQGameIPCHandler.b {
    static IPatchRedirector $redirector_;
    private f C;
    private com.tencent.mobileqq.qqgamepub.web.a D;
    private e E;
    private com.tencent.mobileqq.qqgamepub.web.b F;

    @SuppressLint({"HandlerLeak"})
    private Handler G;

    /* renamed from: f, reason: collision with root package name */
    private boolean f264645f;

    /* renamed from: h, reason: collision with root package name */
    private String f264646h;

    /* renamed from: i, reason: collision with root package name */
    private b f264647i;

    /* renamed from: m, reason: collision with root package name */
    private List<String> f264648m;

    /* loaded from: classes16.dex */
    class a extends Handler {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQGameWebPresenter.this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            int i3 = message.what;
            if (i3 != 1 && i3 != 2 && i3 != 3 && i3 != 4) {
                if (i3 != 100) {
                    if (i3 == 102) {
                        QQGameWebPresenter.this.q(message.arg1);
                        return;
                    }
                    return;
                } else {
                    if (QQGameWebPresenter.this.j()) {
                        QQGameWebPresenter.this.J().n3();
                        return;
                    }
                    return;
                }
            }
            QQGameWebPresenter.this.S(i3, message.arg1, message.arg2, (String) message.obj);
        }
    }

    /* loaded from: classes16.dex */
    private class b extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQGameWebPresenter.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            QLog.d("QQGamePub_GamePAWebPresenter", 1, "MessageQGameReceiver onReceive action = " + intent.getAction());
            String action = intent.getAction();
            if (action == null) {
                return;
            }
            action.hashCode();
            char c16 = '\uffff';
            switch (action.hashCode()) {
                case -2101758543:
                    if (action.equals("action_qgame_tool_messgae")) {
                        c16 = 0;
                        break;
                    }
                    break;
                case -803303675:
                    if (action.equals("action_qgame_h5_video_pause")) {
                        c16 = 1;
                        break;
                    }
                    break;
                case 1082475589:
                    if (action.equals("action_qgame_h5_video_play")) {
                        c16 = 2;
                        break;
                    }
                    break;
                case 1105368530:
                    if (action.equals("action_qgame_delete_ad")) {
                        c16 = 3;
                        break;
                    }
                    break;
                case 1590398986:
                    if (action.equals("action_qgame_jaspi_webloaded")) {
                        c16 = 4;
                        break;
                    }
                    break;
            }
            switch (c16) {
                case 0:
                    QQGameWebPresenter.this.w(intent);
                    return;
                case 1:
                    com.tencent.mobileqq.qqgamepub.utils.b.b(1);
                    return;
                case 2:
                    com.tencent.mobileqq.qqgamepub.utils.b.b(2);
                    return;
                case 3:
                    QQGameWebPresenter.this.v(intent);
                    return;
                case 4:
                    QQGameWebPresenter.this.x();
                    return;
                default:
                    return;
            }
        }
    }

    public QQGameWebPresenter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f264645f = false;
        this.f264648m = new ArrayList();
        this.G = new a();
    }

    private Map<String, Object> T(int i3, int i16, int i17, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("action", Integer.valueOf(i3));
        if (i3 == 4) {
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("perfData", str);
            }
        } else {
            if (i16 != -1) {
                hashMap.put("index", Integer.valueOf(i16));
            }
            if (i17 != -1) {
                hashMap.put("height", Integer.valueOf(i17));
            }
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("gameData", str);
            }
        }
        return hashMap;
    }

    private void t(Activity activity) {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable(activity) { // from class: com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameWebPresenter.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Activity f264650d;

            {
                this.f264650d = activity;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQGameWebPresenter.this, (Object) activity);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else if (QQGameWebPresenter.this.j()) {
                    QQGameWebPresenter.this.J().o(false, 0);
                    ((IQQGameHelper) QRoute.api(IQQGameHelper.class)).enterAIO(this.f264650d, true);
                    QQGameWebPresenter.this.I().d();
                }
            }
        }, 400L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(Intent intent) {
        String stringExtra = intent.getStringExtra("arkViewId");
        boolean booleanExtra = intent.getBooleanExtra("isAioDeletMsg", false);
        if (!TextUtils.isEmpty(stringExtra)) {
            o(stringExtra, booleanExtra);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(Intent intent) {
        ArrayList arrayList;
        Bundle extras = intent.getExtras();
        if (extras != null && (arrayList = (ArrayList) extras.getSerializable("key_get_msg")) != null && arrayList.size() > 0) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable(arrayList) { // from class: com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameWebPresenter.4
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ ArrayList f264651d;

                {
                    this.f264651d = arrayList;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQGameWebPresenter.this, (Object) arrayList);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        QQGameWebPresenter.this.g0(this.f264651d);
                        QIPCClientHelper.getInstance().callServer("QQGameIPCModule", "clearUnreadMsg", null);
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameWebPresenter.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQGameWebPresenter.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    QQGameWebPresenter.this.W();
                }
            }
        }, 500L);
    }

    public QQGameMsgInfo A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return (QQGameMsgInfo) iPatchRedirector.redirect((short) 45, (Object) this);
        }
        if (j()) {
            return i().c(J().Wc());
        }
        return null;
    }

    public void B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        QQGameIPCHandler.e().d();
        QQGameIPCHandler.e().c("task_qgame_task_all_complete", this);
        QQGameIPCHandler.e().c("task_get_qgame_msg", this);
        QQGameIPCHandler.e().f("task_get_qgame_msg", true);
    }

    public com.tencent.mobileqq.qqgamepub.web.a C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (com.tencent.mobileqq.qqgamepub.web.a) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        if (this.D == null) {
            this.D = new com.tencent.mobileqq.qqgamepub.web.a();
        }
        return this.D;
    }

    public Handler D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Handler) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.G;
    }

    public com.tencent.mobileqq.qqgamepub.model.a E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (com.tencent.mobileqq.qqgamepub.model.a) iPatchRedirector.redirect((short) 35, (Object) this);
        }
        return i().e();
    }

    public e F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (e) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        if (this.E == null) {
            this.E = new e(0);
        }
        return this.E;
    }

    public int G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        f fVar = this.C;
        if (fVar != null) {
            return fVar.getF373114d();
        }
        return -1;
    }

    public f H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (f) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.C;
    }

    public com.tencent.mobileqq.qqgamepub.web.b I() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (com.tencent.mobileqq.qqgamepub.web.b) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        if (this.F == null) {
            this.F = new com.tencent.mobileqq.qqgamepub.web.b();
        }
        return this.F;
    }

    public c J() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (c) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return (c) this.f264631d.get();
    }

    public void K(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, (Object) str);
            return;
        }
        if (!j()) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e("QQGamePub_GamePAWebPresenter", 1, "handleAdReverseFeedBack, arkViewId is null");
            return;
        }
        QLog.d("QQGamePub_GamePAWebPresenter", 1, "h5,call handleAdReverseFeedBack arkViewId:" + str);
        J().o(false, 0);
        int k3 = i().k(str);
        if (k3 >= 0 && k3 < i().h()) {
            com.tencent.mobileqq.qqgamepub.view.a aVar = E().f().get(k3);
            int Wc = J().Wc();
            if (Wc == E().h() - 1) {
                Wc--;
            }
            if (Wc != -1) {
                E().f().remove(aVar);
                E().g().remove(k3);
                J().refreshHead(Wc);
                b0(2, Wc, -1, GamePubAccountHelper.m(E().g()).toString());
                b0(1, Wc, -1, "");
            }
        }
    }

    public void L() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this);
            return;
        }
        com.tencent.mobileqq.qqgamepub.view.a a16 = i().a(i().j());
        if (a16 != null) {
            i().t(a16);
            if (a16 instanceof GameArkView) {
                ((GameArkView) a16).c();
            }
        }
    }

    public void M(ViewPager viewPager, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewPager, (Object) context);
        } else {
            this.C = new f(this, context, viewPager);
        }
    }

    public void N() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        try {
            this.f264645f = false;
            WadlProxyServiceUtil.getProxyService().registerWadlServiceCallBack(this);
        } catch (Throwable th5) {
            QLog.e("QQGamePub_GamePAWebPresenter", 1, th5, new Object[0]);
        }
    }

    public void O() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            com.tencent.mobileqq.qqgamepub.utils.b.c().d(2);
        }
    }

    public void P() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else if (j()) {
            J().me();
            WadlProxyServiceUtil.getProxyService().doQueryAllTask();
        }
    }

    public void Q(QBaseActivity qBaseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) qBaseActivity);
        } else if (!SimpleUIUtil.getSimpleUISwitch()) {
            SystemBarActivityModule.setSystemBarComp(qBaseActivity, null);
            SystemBarActivityModule.setImmersiveStatus(qBaseActivity, 0);
        }
    }

    public void R() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        Handler handler = this.G;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        e0();
        p();
        QQGameIPCHandler.e().h();
        com.tencent.mobileqq.qqgamepub.utils.b.c().a();
        WadlProxyServiceUtil.getProxyService().unRegisterWadlServiceCallBack(this);
    }

    public void S(int i3, int i16, int i17, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str);
        } else if (j()) {
            J().Y5(T(i3, i16, i17, str));
        }
    }

    public void U(QBaseActivity qBaseActivity) {
        boolean z16;
        long j3;
        long j16;
        long j17;
        long j18;
        long j19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) qBaseActivity);
            return;
        }
        Intent intent = qBaseActivity.getIntent();
        boolean z17 = false;
        long j26 = 0;
        if (intent != null) {
            if (intent.hasExtra("startTime")) {
                j18 = intent.getLongExtra("startTime", 0L);
                if (j18 > 0) {
                    j19 = SystemClock.elapsedRealtime() - j18;
                } else {
                    j19 = 0;
                }
            } else {
                j18 = 0;
                j19 = 0;
            }
            if (intent.hasExtra("clickTime")) {
                j26 = intent.getLongExtra("clickTime", 0L);
            }
            if (intent.hasExtra("unreadNum")) {
                this.E = new e(intent.getIntExtra("unreadNum", 0));
            }
            if (intent.hasExtra("isColdBoot")) {
                z17 = intent.getBooleanExtra("isColdBoot", false);
            }
            if (intent.hasExtra("arkResPath")) {
                this.f264646h = intent.getStringExtra("arkResPath");
            }
            z16 = z17;
            j16 = j26;
            j3 = j18;
            j17 = j19;
        } else {
            z16 = false;
            j3 = 0;
            j16 = 0;
            j17 = 0;
        }
        C().n(j3, j16, z16, j17);
    }

    public void V() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
        } else if (j()) {
            b0(3, -1, J().Rd(), "");
        }
    }

    public void W() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this);
            return;
        }
        if (!j()) {
            return;
        }
        b0(3, -1, J().Rd(), "");
        if (H() != null && i().p()) {
            b0(1, J().Wc(), -1, "");
        }
        if (i().l() > 3) {
            b0(2, -1, -1, i().g());
        }
    }

    public void X(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            ((IArkPubicEventWrap) QRoute.api(IArkPubicEventWrap.class)).addNotify(str);
            this.f264648m.add(str);
        }
    }

    public void Y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this);
            return;
        }
        this.f264647i = new b();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_qgame_tool_messgae");
        intentFilter.addAction("action_qgame_jaspi_webloaded");
        intentFilter.addAction("action_qgame_h5_video_pause");
        intentFilter.addAction("action_qgame_h5_video_play");
        intentFilter.addAction("action_qgame_delete_ad");
        MobileQQ.sMobileQQ.registerReceiver(this.f264647i, intentFilter);
    }

    public void Z(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, i3);
            return;
        }
        QQGameMsgInfo c16 = i().c(i3);
        if (c16 != null) {
            GamePubAccountHelper.K(c16, 0, GamePubAccountHelper.s());
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.ipc.QQGameIPCHandler.b
    public void a(String str, EIPCResult eIPCResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) str, (Object) eIPCResult);
            return;
        }
        if (!j()) {
            return;
        }
        try {
            if ("task_get_qgame_msg".equals(str)) {
                J().o5(eIPCResult);
            } else if ("task_qgame_task_all_complete".equals(str)) {
                J().z2();
            }
        } catch (Throwable th5) {
            QLog.d("QQGamePub_GamePAWebPresenter", 1, "handleIpcResult fail:" + th5.getMessage());
            th5.printStackTrace();
        }
    }

    public void a0(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, j3);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("msgId", j3);
        QIPCClientHelper.getInstance().callServer("QQGameIPCModule", "deleteMessage", bundle);
    }

    public void b0(int i3, int i16, int i17, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), obj);
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = i3;
        obtain.arg1 = i16;
        obtain.arg2 = i17;
        obtain.obj = obj;
        D().sendMessage(obtain);
    }

    public void c0(int i3, int i16, int i17, Object obj, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), obj, Long.valueOf(j3));
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = i3;
        obtain.arg1 = i16;
        obtain.arg2 = i17;
        obtain.obj = obj;
        D().sendMessageDelayed(obtain, j3);
    }

    public void d0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this);
        } else {
            c0(4, -1, -1, C().b(), 2000L);
        }
    }

    public void e0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else if (this.f264648m != null) {
            ((IArkPubicEventWrap) QRoute.api(IArkPubicEventWrap.class)).unRegistVolumnReceiver(this.f264648m);
        }
    }

    public void f0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this);
            return;
        }
        b bVar = this.f264647i;
        if (bVar != null) {
            MobileQQ.sMobileQQ.unregisterReceiver(bVar);
        }
    }

    public void g0(ArrayList<QQGameMsgInfo> arrayList) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this, (Object) arrayList);
            return;
        }
        if (j() && arrayList != null && arrayList.size() > 0) {
            if (G() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            F().g(arrayList.size());
            F().f(arrayList.size());
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                E().g().add(0, arrayList.get(i3));
                E().a(0, ((IQQGameTempRelyApi) QRoute.api(IQQGameTempRelyApi.class)).createHeader(arrayList.get(i3), y()));
                if (!TextUtils.isEmpty(arrayList.get(i3).arkAppName)) {
                    X(arrayList.get(i3).arkAppName);
                }
                if (i3 == arrayList.size() - 1) {
                    if (!z16) {
                        D().sendEmptyMessageDelayed(100, 3000L);
                    }
                    J().f7(arrayList.get(i3).paMsgid);
                }
                int Wc = J().Wc();
                if (!z16) {
                    Wc++;
                }
                J().refreshHead(-1);
                J().W9(Wc);
                I().f(arrayList.get(i3).gameAppId, arrayList.get(i3).paMsgid);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqgamepub.mvp.presenter.base.a
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.qqgamepub.mvp.model.bean.a c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (com.tencent.mobileqq.qqgamepub.mvp.model.bean.a) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return new com.tencent.mobileqq.qqgamepub.mvp.model.bean.a(this);
    }

    public synchronized void o(String str, boolean z16) {
        QQGameMsgInfo qQGameMsgInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, this, str, Boolean.valueOf(z16));
            return;
        }
        QLog.d("QQGamePub_GamePAWebPresenter", 1, "deleteMsg arkViewId:" + str);
        Iterator<QQGameMsgInfo> it = E().g().iterator();
        while (true) {
            if (it.hasNext()) {
                qQGameMsgInfo = it.next();
                if (str.equals(String.valueOf(qQGameMsgInfo.uniseq))) {
                    break;
                }
            } else {
                qQGameMsgInfo = null;
                break;
            }
        }
        if (qQGameMsgInfo != null) {
            if (!z16) {
                a0(qQGameMsgInfo.msgId);
                QQToast.makeText(BaseApplication.getContext(), R.string.f211685lh, 1).show();
            }
            K(str);
        }
    }

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface
    public void onQueryCallback(ArrayList<WadlResult> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) arrayList);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQGamePub_GamePAWebPresenter", 1, "---->onQueryCallback isGetGameEnter=" + this.f264645f);
        }
        if (this.f264645f) {
            return;
        }
        long w3 = GamePubAccountHelper.w(arrayList);
        if (QLog.isColorLevel()) {
            QLog.d("QQGamePub_GamePAWebPresenter", 1, "---> get lastGameAppID=" + w3);
        }
        this.f264645f = true;
        ((IQWalletApi) QRoute.api(IQWalletApi.class)).servletSendRequest(new GmpEnterInfoReq(w3, 1, 0), this);
    }

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface
    public void onQueryCallbackVia(ArrayList<WadlResult> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) arrayList);
        }
    }

    @Override // mqq.observer.BusinessObserver
    public void onReceive(int i3, boolean z16, Bundle bundle) {
        GmpEnterInfoRsp gmpEnterInfoRsp;
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
            return;
        }
        if (i3 == 31) {
            if (z16 && bundle != null) {
                gmpEnterInfoRsp = (GmpEnterInfoRsp) bundle.getSerializable("rsp");
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("GmpEnterInfoRsp|");
                    if (gmpEnterInfoRsp != null) {
                        obj = Integer.valueOf(gmpEnterInfoRsp.retCode);
                    } else {
                        obj = "";
                    }
                    sb5.append(obj);
                    QLog.d("QQGamePub_GamePAWebPresenter", 2, sb5.toString());
                }
            } else {
                gmpEnterInfoRsp = null;
            }
            ThreadManagerV2.getUIHandlerV2().post(new Runnable(gmpEnterInfoRsp) { // from class: com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameWebPresenter.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ GmpEnterInfoRsp f264649d;

                {
                    this.f264649d = gmpEnterInfoRsp;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQGameWebPresenter.this, (Object) gmpEnterInfoRsp);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (!QQGameWebPresenter.this.j()) {
                        return;
                    }
                    GmpEnterInfoRsp gmpEnterInfoRsp2 = this.f264649d;
                    if (gmpEnterInfoRsp2 != null && gmpEnterInfoRsp2.retCode == 0 && gmpEnterInfoRsp2.state == 1) {
                        QQGameWebPresenter.this.J().q(this.f264649d, true);
                    } else {
                        QQGameWebPresenter.this.J().q(GamePubAccountHelper.p(), false);
                    }
                }
            });
        }
    }

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface
    public void onWadlTaskStatusChanged(WadlResult wadlResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) wadlResult);
        }
    }

    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this);
        } else {
            i().e().b();
        }
    }

    public void q(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, i3);
            return;
        }
        for (int i16 = 0; i16 < i().h(); i16++) {
            if (i16 == i3) {
                com.tencent.mobileqq.qqgamepub.view.a a16 = i().a(i3);
                i().t(a16);
                if (a16 instanceof GameArkView) {
                    GameArkView gameArkView = (GameArkView) a16;
                    com.tencent.mobileqq.qqgamepub.utils.b.c().g(gameArkView);
                    gameArkView.c();
                } else {
                    com.tencent.mobileqq.qqgamepub.utils.b.c().g(null);
                }
            } else {
                com.tencent.mobileqq.qqgamepub.view.a a17 = i().a(i16);
                if (a17 != null) {
                    a17.onPause();
                }
            }
        }
        i().d().onResume();
    }

    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this);
            return;
        }
        if (i().l() > 0) {
            i().u(0);
            e F = F();
            if (F.b() > 0) {
                F.h();
            } else {
                i().u(i().b());
            }
        }
    }

    public void s(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, i3);
            return;
        }
        D().removeMessages(102);
        c0(102, i3, -1, "", 200L);
        if (j()) {
            J().R0(i3);
        }
        QQGameMsgInfo c16 = i().c(i3);
        AppInterface appInterface = ((ICmGameHelper) QRoute.api(ICmGameHelper.class)).getAppInterface();
        if (appInterface != null && c16 != null) {
            i().s(appInterface, c16.paMsgid);
        }
        Z(i3);
        D().removeMessages(1);
        b0(1, i3, -1, "");
        i().q();
    }

    public void u(int i3, Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, i3, (Object) activity);
        } else if (i().o(i3)) {
            s(i3);
        } else if (i().n(i3)) {
            t(activity);
        }
    }

    public QBaseActivity y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return (QBaseActivity) iPatchRedirector.redirect((short) 48, (Object) this);
        }
        if (!j()) {
            QLog.i("QQGamePub_GamePAWebPresenter", 1, "[getActivity] view is detach");
            return null;
        }
        return ((c) this.f264631d.get()).getBaseActivity();
    }

    public String z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.f264646h;
    }
}
