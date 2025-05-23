package com.tencent.av.business.servlet;

import android.os.Looper;
import com.qq.jce.wup.UniPacket;
import com.tencent.av.business.handler.EffectMaterialHandler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import mqq.app.NewIntent;
import mqq.app.Servlet;

/* compiled from: P */
/* loaded from: classes3.dex */
public class EffectMaterialService extends BaseService {

    /* renamed from: b, reason: collision with root package name */
    private int f73469b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f73470c;

    /* renamed from: d, reason: collision with root package name */
    private HashSet<nu.a> f73471d;

    public EffectMaterialService(AppInterface appInterface) {
        super(appInterface);
        this.f73469b = 0;
        this.f73470c = false;
        this.f73471d = new HashSet<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized nu.a h(String str) {
        nu.a aVar;
        if (!this.f73470c) {
            i();
        }
        Iterator<nu.a> it = this.f73471d.iterator();
        while (true) {
            if (it.hasNext()) {
                aVar = it.next();
                if (aVar.c(str)) {
                    break;
                }
            } else {
                aVar = null;
                break;
            }
        }
        return aVar;
    }

    private void i() {
        if (this.f73470c) {
            return;
        }
        this.f73471d.add(new nu.b());
        this.f73470c = true;
    }

    @Override // com.tencent.av.business.servlet.BaseService
    public Class<? extends Servlet> a() {
        return c.class;
    }

    @Override // com.tencent.av.business.servlet.BaseService
    public void b(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        Object obj = null;
        if (fromServiceMsg.isSuccess()) {
            nu.a h16 = h(fromServiceMsg.getServiceCmd());
            if (h16 != null) {
                obj = h16.a(toServiceMsg, fromServiceMsg);
            } else {
                QLog.i("EffectMaterialService", 1, "onReceive " + fromServiceMsg.getServiceCmd() + ", coder is null");
            }
        } else {
            QLog.i("EffectMaterialService", 1, "onReceive " + fromServiceMsg.getServiceCmd() + ", response is fail");
        }
        c(toServiceMsg, fromServiceMsg, obj);
    }

    @Override // com.tencent.av.business.servlet.BaseService
    protected void c(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        ((EffectMaterialHandler) this.f73467a.getBusinessHandler(EffectMaterialHandler.class.getName())).onReceive(toServiceMsg, fromServiceMsg, obj);
    }

    @Override // com.tencent.av.business.servlet.BaseService
    public void d(final ToServiceMsg toServiceMsg) {
        Runnable runnable = new Runnable() { // from class: com.tencent.av.business.servlet.EffectMaterialService.1
            /* JADX WARN: Removed duplicated region for block: B:10:0x005c  */
            /* JADX WARN: Removed duplicated region for block: B:13:0x008c  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                boolean z16;
                String serviceCmd = toServiceMsg.getServiceCmd();
                if (QLog.isColorLevel()) {
                    QLog.i("EffectMaterialService", 2, "sendRequest " + serviceCmd);
                }
                nu.a h16 = EffectMaterialService.this.h(serviceCmd);
                if (h16 != null) {
                    z16 = true;
                    UniPacket uniPacket = new UniPacket(true);
                    uniPacket.setEncodeName("utf-8");
                    EffectMaterialService effectMaterialService = EffectMaterialService.this;
                    int i3 = effectMaterialService.f73469b;
                    effectMaterialService.f73469b = i3 + 1;
                    uniPacket.setRequestId(i3);
                    if (h16.b(toServiceMsg, uniPacket)) {
                        toServiceMsg.putWupBuffer(uniPacket.encode());
                        if (!z16) {
                            toServiceMsg.extraData.putLong("KEY_REQUEST_TIME", System.currentTimeMillis());
                            NewIntent newIntent = new NewIntent(EffectMaterialService.this.f73467a.getApplication(), c.class);
                            newIntent.putExtra(ToServiceMsg.class.getSimpleName(), toServiceMsg);
                            EffectMaterialService.this.f73467a.startServlet(newIntent);
                            return;
                        }
                        EffectMaterialService.this.c(toServiceMsg, new FromServiceMsg(toServiceMsg.getUin(), serviceCmd), null);
                        return;
                    }
                }
                z16 = false;
                if (!z16) {
                }
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            ThreadManagerV2.excute(runnable, 16, null, false);
        } else {
            runnable.run();
        }
    }
}
