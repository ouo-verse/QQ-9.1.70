package com.tencent.mobileqq.pic.operator;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.message.msgstorage.api.IMsgStorageApi;
import com.tencent.mobileqq.pic.ac;
import com.tencent.mobileqq.pic.m;
import com.tencent.mobileqq.pic.p;
import com.tencent.mobileqq.pic.q;
import com.tencent.mobileqq.pic.v;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes16.dex */
public abstract class a {
    static IPatchRedirector $redirector_;
    protected Handler C;
    protected String D;

    /* renamed from: d, reason: collision with root package name */
    public String f258749d;

    /* renamed from: e, reason: collision with root package name */
    public String f258750e;

    /* renamed from: f, reason: collision with root package name */
    public p f258751f;

    /* renamed from: h, reason: collision with root package name */
    protected MessageRecord f258752h;

    /* renamed from: i, reason: collision with root package name */
    protected ac f258753i;

    /* renamed from: m, reason: collision with root package name */
    protected AppInterface f258754m;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.pic.operator.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    class HandlerC8225a extends Handler {
        static IPatchRedirector $redirector_;

        HandlerC8225a(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            if (message.what != 1) {
                a aVar = a.this;
                com.tencent.mobileqq.pic.f.c(aVar.f258750e, aVar.f258749d, "dispatchMessage", "what:" + message.what + ",result:" + message.arg1 + ",obj:" + message.obj);
            }
            ac acVar = a.this.f258753i;
            if (acVar == null) {
                return;
            }
            switch (message.what) {
                case 0:
                    acVar.g(message.arg1, (q) message.obj);
                    return;
                case 1:
                    q qVar = (q) message.obj;
                    Object obj = qVar.f258793d;
                    if (obj instanceof Integer) {
                        acVar.b(((Integer) obj).intValue(), qVar.f258796g);
                        return;
                    }
                    return;
                case 2:
                    acVar.f(message.arg1, (q) message.obj);
                    return;
                case 3:
                    acVar.c(message.arg1, (q) message.obj);
                    return;
                case 4:
                    acVar.d(message.arg1, (q) message.obj);
                    return;
                case 5:
                    Object obj2 = message.obj;
                    ArrayList<q> arrayList = null;
                    if (obj2 != null) {
                        try {
                            arrayList = (ArrayList) obj2;
                        } catch (ClassCastException unused) {
                        }
                    }
                    a.this.f258753i.i(message.arg1, arrayList);
                    return;
                case 6:
                    acVar.e(((Integer) ((q) message.obj).f258793d).intValue());
                    return;
                default:
                    return;
            }
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.D = "PicOperator." + getClass().getSimpleName();
        this.f258754m = com.tencent.mobileqq.pic.i.h();
    }

    private void f(int i3) {
        v vVar;
        if ((i3 == 3 || i3 == 4) && (vVar = this.f258751f.C) != null && !vVar.U) {
            ((IMsgStorageApi) QRoute.api(IMsgStorageApi.class)).onMsgUploadTaskEnd(this.f258752h);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(int i3, m.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) aVar);
            return;
        }
        q qVar = new q();
        qVar.f258792c = this.f258751f;
        qVar.f258791b = aVar;
        qVar.f258790a = -1;
        e(i3, -1, qVar);
        if (aVar != null) {
            com.tencent.mobileqq.pic.f.e(this.f258750e, this.f258749d, aVar.f258736a, aVar.f258737b);
        } else {
            com.tencent.mobileqq.pic.f.e(this.f258750e, this.f258749d, "handleError", "unkown err,err == null");
        }
        f(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(int i3, q qVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) qVar);
            return;
        }
        if (qVar == null) {
            qVar = new q();
        }
        qVar.f258790a = 0;
        qVar.f258792c = this.f258751f;
        e(i3, 0, qVar);
        com.tencent.mobileqq.pic.f.c(this.f258750e, this.f258749d, "handleSuccess", "what:" + i3);
        f(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(int i3, int i16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), obj);
            return;
        }
        if (this.C == null) {
            return;
        }
        Message message = new Message();
        message.what = i3;
        message.arg1 = i16;
        message.obj = obj;
        this.C.sendMessage(message);
    }

    public abstract void i();

    public void j(ac acVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) acVar);
            return;
        }
        this.f258753i = acVar;
        if (acVar == null) {
            return;
        }
        this.C = new HandlerC8225a(Looper.getMainLooper());
    }
}
