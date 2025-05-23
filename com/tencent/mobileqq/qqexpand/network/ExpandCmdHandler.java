package com.tencent.mobileqq.qqexpand.network;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qqexpand.manager.ExpandManager;
import com.tencent.mobileqq.qqexpand.network.a;
import com.tencent.mobileqq.qqexpand.network.b;
import com.tencent.mobileqq.utils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.plugins.RaffleJsPlugin;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ExpandCmdHandler {

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicInteger f263946c = new AtomicInteger();

    /* renamed from: a, reason: collision with root package name */
    private Map<Integer, a> f263947a;

    /* renamed from: b, reason: collision with root package name */
    private final BaseQQAppInterface f263948b;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqexpand.network.ExpandCmdHandler$2, reason: invalid class name */
    /* loaded from: classes35.dex */
    class AnonymousClass2 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqexpand.network.a f263951d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ d f263952e;
        final /* synthetic */ ExpandCmdHandler this$0;

        @Override // java.lang.Runnable
        public void run() {
            int incrementAndGet = ExpandCmdHandler.f263946c.incrementAndGet();
            this.this$0.f263947a.put(Integer.valueOf(incrementAndGet), new a(this.f263951d, this.f263952e));
            ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.this$0.f263948b.getAccount(), this.f263951d.b());
            toServiceMsg.setTimeout(this.f263951d.e());
            toServiceMsg.extraData.putLong("REQUEST_TIME", System.currentTimeMillis());
            toServiceMsg.extraData.putInt("FLUTTER_REQUEST_SEQ", incrementAndGet);
            if (!this.f263951d.h()) {
                long length = this.f263951d.f().length;
                int i3 = (int) length;
                byte[] bArr = new byte[i3 + 4];
                PkgTools.DWord2Byte(bArr, 0, length + 4);
                PkgTools.copyData(bArr, 4, this.f263951d.f(), i3);
                toServiceMsg.putWupBuffer(bArr);
            } else {
                toServiceMsg.putWupBuffer(this.f263951d.f());
            }
            NewIntent newIntent = new NewIntent(this.this$0.f263948b.getApplication(), c.class);
            newIntent.putExtra(ToServiceMsg.class.getSimpleName(), toServiceMsg);
            this.this$0.f263948b.startServlet(newIntent);
            if (QLog.isColorLevel()) {
                QLog.d("expand.cmd.ExpandCmdHandler", 2, String.format("send request cmd: %s, request seq: %s", this.f263951d.b(), Integer.valueOf(incrementAndGet)));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public com.tencent.mobileqq.qqexpand.network.a f263953a;

        /* renamed from: b, reason: collision with root package name */
        public d f263954b;

        public a(com.tencent.mobileqq.qqexpand.network.a aVar, d dVar) {
            this.f263953a = aVar;
            this.f263954b = dVar;
        }
    }

    public ExpandCmdHandler(BaseQQAppInterface baseQQAppInterface) {
        this.f263947a = new ConcurrentHashMap();
        this.f263948b = baseQQAppInterface;
        this.f263947a = new ConcurrentHashMap();
    }

    private b c(a aVar, FromServiceMsg fromServiceMsg) {
        b cVar;
        if (aVar.f263953a.h()) {
            cVar = new b.C8322b(fromServiceMsg.getResultCode(), fromServiceMsg.getBusinessFailMsg());
            if (fromServiceMsg.isSuccess()) {
                cVar.a(fromServiceMsg.getWupBuffer());
            }
        } else {
            if (aVar.f263953a.g()) {
                cVar = new b.a(fromServiceMsg.getResultCode(), fromServiceMsg.getBusinessFailMsg());
            } else {
                cVar = new b.c(fromServiceMsg.getResultCode(), fromServiceMsg.getBusinessFailMsg());
            }
            if (fromServiceMsg.isSuccess()) {
                int length = fromServiceMsg.getWupBuffer().length - 4;
                byte[] bArr = new byte[length];
                PkgTools.copyData(bArr, 0, fromServiceMsg.getWupBuffer(), 4, length);
                cVar.a(bArr);
            }
        }
        return cVar;
    }

    public static ExpandCmdHandler d(BaseQQAppInterface baseQQAppInterface) {
        ExpandManager expandManager = (ExpandManager) baseQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
        if (expandManager == null) {
            return null;
        }
        return expandManager.s0();
    }

    private void g(ToServiceMsg toServiceMsg, b bVar) {
        int i3 = toServiceMsg.extraData.getInt("FLUTTER_REQUEST_SEQ");
        long currentTimeMillis = System.currentTimeMillis() - toServiceMsg.extraData.getLong("REQUEST_TIME");
        if (bVar.c() != 0) {
            QLog.w("expand.cmd.ExpandCmdHandler", 2, String.format("[onReceive]cmd: %s, app seq: %s, cost: %s, errorInfo: %s, request seq: %s", toServiceMsg.getServiceCmd(), Integer.valueOf(toServiceMsg.getAppSeq()), Long.valueOf(currentTimeMillis), bVar.d(), Integer.valueOf(i3)));
        } else if (QLog.isColorLevel()) {
            QLog.d("expand.cmd.ExpandCmdHandler", 2, String.format("[onReceive]cmd: %s, app seq: %s, cost: %s, errorInfo: %s, request seq: %s", toServiceMsg.getServiceCmd(), Integer.valueOf(toServiceMsg.getAppSeq()), Long.valueOf(currentTimeMillis), bVar.d(), Integer.valueOf(i3)));
        }
    }

    public void e() {
        this.f263947a.clear();
    }

    public void h(String str, byte[] bArr, d dVar) {
        i(new a.C8321a().l(false).k(true).j(str).i(bArr).h(), dVar);
    }

    public void j(String str, byte[] bArr, d dVar) {
        i(new a.C8321a().l(false).j(str).i(bArr).h(), dVar);
    }

    public void f(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        if (toServiceMsg != null && fromServiceMsg != null) {
            int i3 = toServiceMsg.extraData.getInt("FLUTTER_REQUEST_SEQ");
            a aVar = this.f263947a.get(Integer.valueOf(i3));
            if (aVar == null) {
                QLog.w("expand.cmd.ExpandCmdHandler", 1, "can't find request cmd:" + toServiceMsg.getServiceCmd() + " request seq:" + i3);
                return;
            }
            b c16 = c(aVar, fromServiceMsg);
            g(toServiceMsg, c16);
            d dVar = aVar.f263954b;
            if (dVar != null) {
                dVar.a(aVar.f263953a, c16);
                return;
            }
            return;
        }
        QLog.e("expand.cmd.ExpandCmdHandler", 1, "request == null || response == null");
    }

    public void i(final com.tencent.mobileqq.qqexpand.network.a aVar, final d dVar) {
        if (aVar == null) {
            QLog.w("expand.cmd.ExpandCmdHandler", 1, "send request but request == null");
        } else if (!AppNetConnInfo.isNetSupport()) {
            dVar.a(aVar, new b(900000000, RaffleJsPlugin.ERROR_REPORT_NO_NETWORK));
        } else {
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.network.ExpandCmdHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    int incrementAndGet = ExpandCmdHandler.f263946c.incrementAndGet();
                    ExpandCmdHandler.this.f263947a.put(Integer.valueOf(incrementAndGet), new a(aVar, dVar));
                    ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", ExpandCmdHandler.this.f263948b.getAccount(), aVar.b());
                    toServiceMsg.setTimeout(aVar.e());
                    toServiceMsg.extraData.putLong("REQUEST_TIME", System.currentTimeMillis());
                    toServiceMsg.extraData.putInt("FLUTTER_REQUEST_SEQ", incrementAndGet);
                    if (!aVar.h()) {
                        long length = aVar.f().length;
                        int i3 = (int) length;
                        byte[] bArr = new byte[i3 + 4];
                        PkgTools.DWord2Byte(bArr, 0, length + 4);
                        PkgTools.copyData(bArr, 4, aVar.f(), i3);
                        toServiceMsg.putWupBuffer(bArr);
                    } else {
                        toServiceMsg.putWupBuffer(aVar.f());
                    }
                    NewIntent newIntent = new NewIntent(ExpandCmdHandler.this.f263948b.getApplication(), c.class);
                    newIntent.putExtra(ToServiceMsg.class.getSimpleName(), toServiceMsg);
                    ExpandCmdHandler.this.f263948b.startServlet(newIntent);
                    if (QLog.isColorLevel()) {
                        QLog.d("expand.cmd.ExpandCmdHandler", 2, String.format("send request cmd: %s, request seq: %s", aVar.b(), Integer.valueOf(incrementAndGet)));
                    }
                }
            });
        }
    }
}
