package com.tencent.mobileqq.qqexpand.match;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqexpand.match.b;
import com.tencent.mobileqq.qqexpand.network.e;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes35.dex */
public class MatchingStateHandler extends BaseStateHandler implements Handler.Callback {
    private int C;
    private String D;
    private int E;

    /* renamed from: h, reason: collision with root package name */
    public final String f263919h;

    /* renamed from: i, reason: collision with root package name */
    public final int f263920i;

    /* renamed from: m, reason: collision with root package name */
    Handler f263921m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MatchingStateHandler(b bVar, int i3) {
        super(bVar, i3);
        this.f263919h = "ExtendFriendLimitChatMatchingStateHandler";
        this.f263920i = 60;
        this.f263921m = new Handler(Looper.getMainLooper(), this);
        this.C = 101;
        this.D = "";
        this.E = 1;
    }

    private void m() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.match.MatchingStateHandler.1
            @Override // java.lang.Runnable
            public void run() {
                String str;
                b bVar = MatchingStateHandler.this.f263914d;
                if (bVar != null) {
                    bVar.h(100, null);
                    MatchingStateHandler matchingStateHandler = MatchingStateHandler.this;
                    b.a aVar = matchingStateHandler.f263914d.f263926h;
                    if (aVar != null) {
                        vg2.d dVar = matchingStateHandler.f263915e;
                        if (dVar == null || (str = dVar.f441611g) == null) {
                            str = "";
                        }
                        aVar.a(0, dVar, str, "");
                    }
                    MatchingStateHandler.this.l();
                }
            }
        });
    }

    private void n(int i3, String str) {
        b.a aVar;
        b bVar = this.f263914d;
        if (bVar != null) {
            bVar.h(100, null);
            l();
        }
        QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, "onFailedMatchPb  failedType\uff1a" + i3);
        b bVar2 = this.f263914d;
        if (bVar2 == null || (aVar = bVar2.f263926h) == null) {
            return;
        }
        aVar.a(i3, null, "", str);
    }

    @Override // com.tencent.mobileqq.qqexpand.match.BaseStateHandler
    public void a() {
        int i3 = this.C;
        if (i3 != 101 && i3 != 104) {
            QLog.i("ExtendFriendLimitChatMatchingStateHandler", 2, "cancelMatch in matching state unknown!!" + this.C);
            return;
        }
        QLog.i("ExtendFriendLimitChatMatchingStateHandler", 2, "cancelMatch in matching state REQUEST_MATCHING or WAIT_PUSH ");
        l();
        b bVar = this.f263914d;
        if (bVar != null) {
            e eVar = (e) bVar.f263925f.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
            if (eVar != null) {
                eVar.m1(this.f263914d.f263925f.getCurrentAccountUin());
            }
            this.f263914d.h(100, null);
            return;
        }
        QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, "cancelMatch in matching state machine is null");
    }

    @Override // com.tencent.mobileqq.qqexpand.match.BaseStateHandler
    public void b() {
        this.f263915e.a();
        l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.qqexpand.match.BaseStateHandler
    public void c(boolean z16) {
        QLog.i("ExtendFriendLimitChatMatchingStateHandler", 2, "onCancelMatchMsg \u53d6\u6d88\u5339\u914d: " + z16);
    }

    @Override // com.tencent.mobileqq.qqexpand.match.BaseStateHandler
    public void d(boolean z16, vg2.d dVar) {
        com.tencent.mobileqq.qqexpand.bean.chat.a aVar;
        if (z16 && dVar != null && dVar.f441613i != this.E) {
            h(dVar.f441607c, dVar.f441605a, dVar.f441606b);
            g(dVar.f441607c, dVar.f441612h);
            QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, "ON PUSH WITH PUSH TAG" + dVar.f441613i + " wait id:" + this.E);
            return;
        }
        this.f263921m.removeMessages(1);
        if (dVar == null) {
            QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, "onPushMsg null indo");
            return;
        }
        QLog.i("ExtendFriendLimitChatMatchingStateHandler", 2, "onPushMsg ");
        if (z16) {
            h(dVar.f441607c, dVar.f441605a, dVar.f441606b);
            i(dVar);
            g(dVar.f441607c, dVar.f441612h);
            if (this.C == 104) {
                if (dVar.c()) {
                    i(dVar);
                    QLog.i("ExtendFriendLimitChatMatchingStateHandler", 2, "STATE_PROTO_WAIT_PUSH - \u300b STATE_PROTO_AIO_OPEN matchinf:" + dVar.toString());
                    this.C = 105;
                    com.tencent.mobileqq.qqexpand.manager.e eVar = (com.tencent.mobileqq.qqexpand.manager.e) ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
                    if (eVar != null && (aVar = dVar.f441615k) != null && aVar.f263462s == 1) {
                        eVar.I();
                    }
                    m();
                    return;
                }
                return;
            }
            QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, "WAIT PUSH IN STATE: UN HANDLED" + this.C + dVar.toString());
            return;
        }
        n(2, this.D);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.qqexpand.match.BaseStateHandler
    public void e(boolean z16, int i3, vg2.d dVar, String str) {
        long j3;
        QLog.i("ExtendFriendLimitChatMatchingStateHandler", 2, "onCSRequestMsg");
        if (!z16) {
            QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, "onCSRequestMsg success = " + z16);
            n(1, "");
            return;
        }
        if (i3 == 0) {
            if (dVar != null && dVar.c()) {
                QLog.i("ExtendFriendLimitChatMatchingStateHandler", 2, "onCSRequestMsg - \u300b STATE_PROTO_AIO_OPEN matchinf:" + dVar.toString());
                i(dVar);
                h(dVar.f441607c, dVar.f441605a, dVar.f441606b);
                g(dVar.f441607c, dVar.f441612h);
                this.C = 105;
                m();
                return;
            }
            QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, "onCSRequestMsg MatchInfo is wrong ");
            n(1, str);
            return;
        }
        if (i3 == 1) {
            this.C = 104;
            if (dVar != null) {
                j3 = dVar.f441610f * 1000;
            } else {
                QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, "onCSRequestMsg STATE_PROTO_WAIT_PUSH but matchinfo  is wrong,push time use 30");
                j3 = 30000;
            }
            if (60000 < j3) {
                j3 = 60000;
            }
            o(1, j3);
            QLog.i("ExtendFriendLimitChatMatchingStateHandler", 2, "onCSRequestMsg - \u300b STATE_PROTO_WAIT_PUSH  pushimte \uff1a" + j3 + "tips errm:" + (str != null ? str : ""));
            this.D = str;
            return;
        }
        if (i3 == 3) {
            QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, "onCSRequestMsg fail   ret is MatchOpRetCode_Security_Beat errmsg:" + (str != null ? str : ""));
            n(7, str);
            return;
        }
        if (i3 == 4) {
            QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, "onCSRequestMsg fail   ret is MatchOpRetCode_Security_Limit errmsg:" + (str != null ? str : ""));
            n(8, str);
            return;
        }
        if (i3 == 2) {
            QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, "onCSRequestMsg fail   ret is MatchOpRetCode_Security_Beat errmsg:" + (str != null ? str : ""));
            n(6, str);
            return;
        }
        if (i3 == 12) {
            QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, "onCSRequestMsg fail   ret is MatchOpRetCode_No_Times errmsg:" + (str != null ? str : ""));
            n(9, str);
            return;
        }
        QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, "onCSRequestMsg RECODE = " + i3 + " errMsg:" + (str != null ? str : ""));
        n(1, str);
    }

    @Override // com.tencent.mobileqq.qqexpand.match.BaseStateHandler
    public void f(int i3) {
        QLog.i("ExtendFriendLimitChatMatchingStateHandler", 2, "requestMatch in matching state id:" + i3);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, "\u8d85\u65f6 on timer TIMER_FOR_PUSH\uff1a" + this.f263915e.toString());
            a();
            n(2, this.D);
        }
        return true;
    }

    @Override // com.tencent.mobileqq.qqexpand.match.BaseStateHandler
    public void j(vg2.d dVar) {
        this.f263915e.a();
        if (dVar != null) {
            i(dVar);
            this.E = dVar.f441613i;
        }
        this.C = 101;
    }

    public void o(int i3, long j3) {
        this.f263921m.sendMessageDelayed(this.f263921m.obtainMessage(i3), j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        QLog.i("ExtendFriendLimitChatMatchingStateHandler", 2, "clearMsg");
        this.f263921m.removeCallbacksAndMessages(null);
    }
}
