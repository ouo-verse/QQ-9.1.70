package com.tencent.mobileqq.app;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.ServerConfigManager;
import mqq.observer.ServerConfigObserver;
import protocol.KQQConfig.GPS;
import protocol.KQQConfig.GetResourceReqInfoV2;
import protocol.KQQConfig.GetResourceRespV2;
import protocol.KQQConfig.ReqUserInfo;

/* loaded from: classes11.dex */
public class PluginConfigProxy extends ServerConfigObserver {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final ArrayList<ServerConfigObserver> f194897d;

    /* renamed from: e, reason: collision with root package name */
    private int f194898e;

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<GetResourceReqInfoV2> f194899f;

    /* loaded from: classes11.dex */
    class CallbackRunner implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private ServerConfigObserver f194900d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f194901e;

        /* renamed from: f, reason: collision with root package name */
        private int f194902f;

        /* renamed from: h, reason: collision with root package name */
        private GetResourceRespV2 f194903h;

        public CallbackRunner(ServerConfigObserver serverConfigObserver, boolean z16, int i3, GetResourceRespV2 getResourceRespV2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, PluginConfigProxy.this, serverConfigObserver, Boolean.valueOf(z16), Integer.valueOf(i3), getResourceRespV2);
                return;
            }
            this.f194900d = serverConfigObserver;
            this.f194901e = z16;
            this.f194902f = i3;
            this.f194903h = getResourceRespV2;
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.f194900d.onGetPluginConfig(this.f194901e, this.f194902f, this.f194903h);
            }
        }
    }

    public PluginConfigProxy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f194897d = new ArrayList<>();
        this.f194898e = 0;
        this.f194899f = new ArrayList<>();
    }

    public void a(int i3, List<GetResourceReqInfoV2> list, ServerConfigObserver serverConfigObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), list, serverConfigObserver);
            return;
        }
        this.f194899f.addAll(list);
        this.f194898e = i3 | this.f194898e;
        if (serverConfigObserver != null) {
            this.f194897d.add(serverConfigObserver);
        }
    }

    public void b(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) qQAppInterface);
            return;
        }
        ReqUserInfo reqUserInfo = new ReqUserInfo();
        reqUserInfo.cType = (byte) 1;
        reqUserInfo.stGps = new GPS();
        reqUserInfo.strAuthName = QQAppInterface.AUTHORIZATION_NAME;
        reqUserInfo.strAuthPassword = QQAppInterface.AUTHORIZATION_PASSWORD;
        reqUserInfo.vCells = new ArrayList<>();
        reqUserInfo.vMacs = new ArrayList<>();
        ((ServerConfigManager) qQAppInterface.getManager(3)).getPluginConfig(this.f194898e, reqUserInfo, this.f194899f, this, AppSetting.f());
    }

    @Override // mqq.observer.ServerConfigObserver
    public void onGetPluginConfig(boolean z16, int i3, GetResourceRespV2 getResourceRespV2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Integer.valueOf(i3), getResourceRespV2);
        } else {
            if ((this.f194898e & i3) == 0 || this.f194897d.isEmpty()) {
                return;
            }
            Iterator<ServerConfigObserver> it = this.f194897d.iterator();
            while (it.hasNext()) {
                ThreadManager.getSubThreadHandler().post(new CallbackRunner(it.next(), z16, i3, getResourceRespV2));
            }
        }
    }
}
