package com.tencent.mobileqq.qqexpand.match;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: P */
/* loaded from: classes35.dex */
public class b implements Handler.Callback {

    /* renamed from: f, reason: collision with root package name */
    QQAppInterface f263925f;

    /* renamed from: h, reason: collision with root package name */
    a f263926h;

    /* renamed from: d, reason: collision with root package name */
    public final String f263923d = "ExtendFriendLimitChatStateMachine";

    /* renamed from: e, reason: collision with root package name */
    protected boolean f263924e = false;

    /* renamed from: i, reason: collision with root package name */
    private BaseStateHandler f263927i = null;
    private final Lock D = new ReentrantLock();
    private final Handler E = new Handler(Looper.getMainLooper(), this);

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.mobileqq.qqexpand.match.a f263928m = new com.tencent.mobileqq.qqexpand.match.a(this, 100);
    private MatchingStateHandler C = new MatchingStateHandler(this, 101);

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public interface a {
        void a(int i3, vg2.d dVar, String str, String str2);
    }

    public b(QQAppInterface qQAppInterface) {
        this.f263925f = qQAppInterface;
        h(100, null);
    }

    public void a() {
        com.tencent.mobileqq.qqexpand.match.a aVar = this.f263928m;
        if (aVar != null) {
            aVar.b();
            this.f263928m = null;
        }
        MatchingStateHandler matchingStateHandler = this.C;
        if (matchingStateHandler != null) {
            matchingStateHandler.b();
            this.C = null;
        }
        this.f263927i = null;
        this.f263924e = false;
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendLimitChatStateMachine", 2, "machine Clear ");
        }
        this.E.removeCallbacksAndMessages(null);
    }

    public void b() {
        this.E.sendEmptyMessage(2);
    }

    public void c(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendLimitChatStateMachine", 2, "onMatchPushMsg success:" + z16);
        }
        Message.obtain(this.E, 7, Integer.valueOf(z16 ? 1 : 0)).sendToTarget();
    }

    public void d(boolean z16, vg2.d dVar) {
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendLimitChatStateMachine", 2, "onMatchPushMsg success:" + z16 + " info:" + dVar);
        }
        Message.obtain(this.E, 6, z16 ? 1 : 0, 0, dVar).sendToTarget();
    }

    public void e(boolean z16, int i3, vg2.d dVar, String str) {
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendLimitChatStateMachine", 2, "onCSMatchResponseMsg success:" + z16 + " retCode:" + i3);
        }
        Message.obtain(this.E, 4, z16 ? 1 : 0, i3, new Object[]{dVar, str}).sendToTarget();
    }

    public void g(a aVar) {
        this.f263926h = aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void h(int i3, vg2.d dVar) {
        BaseStateHandler baseStateHandler;
        this.D.lock();
        try {
            if (i3 == 100) {
                this.f263927i = this.f263928m;
            } else {
                if (i3 == 101) {
                    this.f263927i = this.C;
                }
                this.D.unlock();
                QLog.i("ExtendFriendLimitChatStateMachine", 2, "setStatus  " + i3);
                baseStateHandler = this.f263927i;
                if (baseStateHandler == null) {
                    baseStateHandler.j(dVar);
                    return;
                }
                return;
            }
            this.D.unlock();
            QLog.i("ExtendFriendLimitChatStateMachine", 2, "setStatus  " + i3);
            baseStateHandler = this.f263927i;
            if (baseStateHandler == null) {
            }
        } catch (Throwable th5) {
            this.D.unlock();
            throw th5;
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        BaseStateHandler baseStateHandler = this.f263927i;
        if (baseStateHandler == null) {
            return true;
        }
        int i3 = message.what;
        if (i3 == 1) {
            baseStateHandler.f(message.arg1);
        } else if (i3 != 2) {
            if (i3 == 4) {
                boolean z16 = message.arg1 == 1;
                Object obj = message.obj;
                if (obj != null && (obj instanceof Object[])) {
                    Object[] objArr = (Object[]) obj;
                    if (objArr != null && objArr.length == 2) {
                        baseStateHandler.e(z16, message.arg2, (vg2.d) objArr[0], (String) objArr[1]);
                    } else {
                        baseStateHandler.e(z16, message.arg2, null, null);
                    }
                } else {
                    baseStateHandler.e(z16, message.arg2, null, null);
                    QLog.e("ExtendFriendLimitChatStateMachine", 2, "CS_RESPONSE_MSG obj err");
                }
                if (QLog.isColorLevel()) {
                    QLog.d("ExtendFriendLimitChatStateMachine", 2, "CS_RESPONSE_MSG mIsGetMatchInfoWaitingHandle");
                }
                this.f263924e = false;
            } else if (i3 == 6) {
                boolean z17 = message.arg1 == 1;
                Object obj2 = message.obj;
                baseStateHandler.d(z17, obj2 != null ? (vg2.d) obj2 : null);
            } else if (i3 == 7) {
                baseStateHandler.c(message.arg1 == 1);
            }
        } else {
            baseStateHandler.a();
        }
        return true;
    }

    public void f(int i3) {
        if (i3 < 0) {
            QLog.e("ExtendFriendLimitChatStateMachine", 2, "requestmatch with wrong id");
            i3 = 1;
        }
        Message.obtain(this.E, 1, i3, i3).sendToTarget();
    }
}
