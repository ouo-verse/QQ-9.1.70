package com.tencent.mobileqq.troop.navigatebar.network;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.navigatebar.network.handler.c;
import com.tencent.mobileqq.troop.navigatebar.network.handler.d;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopAioMessageNavigateBusinessHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f298004d;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f298005e;

    /* renamed from: f, reason: collision with root package name */
    private final List<a> f298006f;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface a {
        void a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj);

        @NonNull
        String b();
    }

    protected TroopAioMessageNavigateBusinessHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        } else {
            this.f298006f = new ArrayList();
            D2();
        }
    }

    private void D2() {
        this.f298006f.add(new c(this));
        this.f298006f.add(new com.tencent.mobileqq.troop.navigatebar.network.handler.b(this));
        this.f298006f.add(new d(this));
    }

    public AppInterface getApp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (AppInterface) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.appRuntime;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Set) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (this.allowCmdSet == null) {
            this.allowCmdSet = new HashSet(this.f298006f.size());
            for (a aVar : this.f298006f) {
                if (!TextUtils.isEmpty(aVar.b())) {
                    this.allowCmdSet.add(aVar.b());
                }
            }
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Class) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return com.tencent.mobileqq.troop.navigatebar.network.a.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg != null && toServiceMsg != null) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopAioMessageNavigateBusinessHandler", 2, "onReceive, data = " + obj + ", cmd = " + fromServiceMsg.getServiceCmd());
            }
            String serviceCmd = fromServiceMsg.getServiceCmd();
            if (!TextUtils.isEmpty(serviceCmd) && !msgCmdFilter(serviceCmd)) {
                com.tencent.mobileqq.troop.navigatebar.expriment.a.g(false);
                if ("OidbSvcTrpcTcp.0x1093_0".equals(serviceCmd)) {
                    this.f298005e = false;
                    com.tencent.mobileqq.troop.navigatebar.expriment.a.g(true);
                } else if ("OidbSvcTrpcTcp.0x1092_0".equals(serviceCmd)) {
                    this.f298004d = false;
                }
                for (a aVar : this.f298006f) {
                    if (aVar.b().equals(serviceCmd)) {
                        aVar.a(toServiceMsg, fromServiceMsg, obj);
                    }
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("TroopAioMessageNavigateBusinessHandler", 2, "cmdfilter error=" + serviceCmd);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopAioMessageNavigateBusinessHandler", 2, "onReceive,resp == null or req == null");
        }
    }
}
