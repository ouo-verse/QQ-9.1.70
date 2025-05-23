package com.tencent.luggage.wxa.wn;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Vector;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public String f144296a;

    /* renamed from: b, reason: collision with root package name */
    public volatile d f144297b;

    /* renamed from: c, reason: collision with root package name */
    public volatile HandlerThread f144298c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public c f144299a;

        /* renamed from: b, reason: collision with root package name */
        public long f144300b;

        /* renamed from: c, reason: collision with root package name */
        public int f144301c;

        /* renamed from: d, reason: collision with root package name */
        public String f144302d;

        /* renamed from: e, reason: collision with root package name */
        public com.tencent.luggage.wxa.wn.a f144303e;

        /* renamed from: f, reason: collision with root package name */
        public com.tencent.luggage.wxa.wn.a f144304f;

        /* renamed from: g, reason: collision with root package name */
        public com.tencent.luggage.wxa.wn.a f144305g;

        public b(c cVar, Message message, String str, com.tencent.luggage.wxa.wn.a aVar, com.tencent.luggage.wxa.wn.a aVar2, com.tencent.luggage.wxa.wn.a aVar3) {
            a(cVar, message, str, aVar, aVar2, aVar3);
        }

        public void a(c cVar, Message message, String str, com.tencent.luggage.wxa.wn.a aVar, com.tencent.luggage.wxa.wn.a aVar2, com.tencent.luggage.wxa.wn.a aVar3) {
            int i3;
            this.f144299a = cVar;
            this.f144300b = System.currentTimeMillis();
            if (message != null) {
                i3 = message.what;
            } else {
                i3 = 0;
            }
            this.f144301c = i3;
            this.f144302d = str;
            this.f144303e = aVar;
            this.f144304f = aVar2;
            this.f144305g = aVar3;
        }

        public String toString() {
            String name;
            String name2;
            String str;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("time=");
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(this.f144300b);
            sb5.append(String.format("%tm-%td %tH:%tM:%tS.%tL", calendar, calendar, calendar, calendar, calendar, calendar));
            sb5.append(" processed=");
            com.tencent.luggage.wxa.wn.a aVar = this.f144303e;
            String str2 = "<null>";
            if (aVar == null) {
                name = "<null>";
            } else {
                name = aVar.getName();
            }
            sb5.append(name);
            sb5.append(" org=");
            com.tencent.luggage.wxa.wn.a aVar2 = this.f144304f;
            if (aVar2 == null) {
                name2 = "<null>";
            } else {
                name2 = aVar2.getName();
            }
            sb5.append(name2);
            sb5.append(" dest=");
            com.tencent.luggage.wxa.wn.a aVar3 = this.f144305g;
            if (aVar3 != null) {
                str2 = aVar3.getName();
            }
            sb5.append(str2);
            sb5.append(" what=");
            c cVar = this.f144299a;
            if (cVar != null) {
                str = cVar.a(this.f144301c);
            } else {
                str = "";
            }
            if (TextUtils.isEmpty(str)) {
                sb5.append(this.f144301c);
                sb5.append("(0x");
                sb5.append(Integer.toHexString(this.f144301c));
                sb5.append(")");
            } else {
                sb5.append(str);
            }
            if (!TextUtils.isEmpty(this.f144302d)) {
                sb5.append(" ");
                sb5.append(this.f144302d);
            }
            return sb5.toString();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.wn.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C6889c {

        /* renamed from: a, reason: collision with root package name */
        public Vector f144306a;

        /* renamed from: b, reason: collision with root package name */
        public int f144307b;

        /* renamed from: c, reason: collision with root package name */
        public int f144308c;

        /* renamed from: d, reason: collision with root package name */
        public int f144309d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f144310e;

        public synchronized void a() {
            this.f144306a.clear();
        }

        public synchronized boolean b() {
            return this.f144310e;
        }

        public C6889c() {
            this.f144306a = new Vector();
            this.f144307b = 20;
            this.f144308c = 0;
            this.f144309d = 0;
            this.f144310e = false;
        }

        public synchronized void a(c cVar, Message message, String str, com.tencent.luggage.wxa.wn.a aVar, com.tencent.luggage.wxa.wn.a aVar2, com.tencent.luggage.wxa.wn.a aVar3) {
            this.f144309d++;
            if (this.f144306a.size() < this.f144307b) {
                this.f144306a.add(new b(cVar, message, str, aVar, aVar2, aVar3));
            } else {
                b bVar = (b) this.f144306a.get(this.f144308c);
                int i3 = this.f144308c + 1;
                this.f144308c = i3;
                if (i3 >= this.f144307b) {
                    this.f144308c = 0;
                }
                bVar.a(cVar, message, str, aVar, aVar2, aVar3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class d extends Handler {

        /* renamed from: q, reason: collision with root package name */
        public static final Object f144311q = new Object();

        /* renamed from: a, reason: collision with root package name */
        public boolean f144312a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f144313b;

        /* renamed from: c, reason: collision with root package name */
        public Message f144314c;

        /* renamed from: d, reason: collision with root package name */
        public C6889c f144315d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f144316e;

        /* renamed from: f, reason: collision with root package name */
        public C6890c[] f144317f;

        /* renamed from: g, reason: collision with root package name */
        public int f144318g;

        /* renamed from: h, reason: collision with root package name */
        public C6890c[] f144319h;

        /* renamed from: i, reason: collision with root package name */
        public int f144320i;

        /* renamed from: j, reason: collision with root package name */
        public a f144321j;

        /* renamed from: k, reason: collision with root package name */
        public b f144322k;

        /* renamed from: l, reason: collision with root package name */
        public c f144323l;

        /* renamed from: m, reason: collision with root package name */
        public HashMap f144324m;

        /* renamed from: n, reason: collision with root package name */
        public com.tencent.luggage.wxa.wn.b f144325n;

        /* renamed from: o, reason: collision with root package name */
        public com.tencent.luggage.wxa.wn.b f144326o;

        /* renamed from: p, reason: collision with root package name */
        public ArrayList f144327p;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a extends com.tencent.luggage.wxa.wn.b {
            public a() {
            }

            @Override // com.tencent.luggage.wxa.wn.b
            public boolean a(Message message) {
                d.this.f144323l.b(message);
                return true;
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class b extends com.tencent.luggage.wxa.wn.b {
            public b() {
            }

            @Override // com.tencent.luggage.wxa.wn.b
            public boolean a(Message message) {
                return false;
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.wn.c$d$c, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6890c {

            /* renamed from: a, reason: collision with root package name */
            public com.tencent.luggage.wxa.wn.b f144330a;

            /* renamed from: b, reason: collision with root package name */
            public C6890c f144331b;

            /* renamed from: c, reason: collision with root package name */
            public boolean f144332c;

            public C6890c() {
            }

            public String toString() {
                String name;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("state=");
                sb5.append(this.f144330a.getName());
                sb5.append(",active=");
                sb5.append(this.f144332c);
                sb5.append(",parent=");
                C6890c c6890c = this.f144331b;
                if (c6890c == null) {
                    name = "null";
                } else {
                    name = c6890c.f144330a.getName();
                }
                sb5.append(name);
                return sb5.toString();
            }
        }

        public final void h() {
            if (this.f144313b) {
                this.f144323l.h("quitNow:");
            }
            sendMessageAtFrontOfQueue(obtainMessage(-1, f144311q));
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            com.tencent.luggage.wxa.wn.b bVar;
            c cVar;
            if (!this.f144312a) {
                if (this.f144313b) {
                    this.f144323l.h("handleMessage: E msg.what=" + message.what);
                }
                this.f144314c = message;
                boolean z16 = this.f144316e;
                if (z16) {
                    bVar = b(message);
                } else if (!z16 && message.what == -2 && message.obj == f144311q) {
                    this.f144316e = true;
                    a(0);
                    bVar = null;
                } else {
                    throw new RuntimeException("StateMachine.handleMessage: The start method not called, received msg: " + message);
                }
                a(bVar, message);
                if (this.f144313b && (cVar = this.f144323l) != null) {
                    cVar.h("handleMessage: X");
                }
            }
        }

        public final void i() {
            if (this.f144313b) {
                this.f144323l.h("setupInitialStateStack: E mInitialState=" + this.f144325n.getName());
            }
            C6890c c6890c = (C6890c) this.f144324m.get(this.f144325n);
            this.f144320i = 0;
            while (c6890c != null) {
                C6890c[] c6890cArr = this.f144319h;
                int i3 = this.f144320i;
                c6890cArr[i3] = c6890c;
                c6890c = c6890c.f144331b;
                this.f144320i = i3 + 1;
            }
            this.f144318g = -1;
            f();
        }

        public d(Looper looper, c cVar) {
            super(looper);
            this.f144312a = false;
            this.f144313b = false;
            this.f144315d = new C6889c();
            this.f144318g = -1;
            this.f144321j = new a();
            this.f144322k = new b();
            this.f144324m = new HashMap();
            this.f144327p = new ArrayList();
            this.f144323l = cVar;
            a(this.f144321j, (com.tencent.luggage.wxa.wn.b) null);
            a(this.f144322k, (com.tencent.luggage.wxa.wn.b) null);
        }

        public final void b() {
            if (this.f144313b) {
                this.f144323l.h("completeConstruction: E");
            }
            int i3 = 0;
            for (C6890c c6890c : this.f144324m.values()) {
                int i16 = 0;
                while (c6890c != null) {
                    c6890c = c6890c.f144331b;
                    i16++;
                }
                if (i3 < i16) {
                    i3 = i16;
                }
            }
            if (this.f144313b) {
                this.f144323l.h("completeConstruction: maxDepth=" + i3);
            }
            this.f144317f = new C6890c[i3];
            this.f144319h = new C6890c[i3];
            i();
            sendMessageAtFrontOfQueue(obtainMessage(-2, f144311q));
            if (this.f144313b) {
                this.f144323l.h("completeConstruction: X");
            }
        }

        public final Message c() {
            return this.f144314c;
        }

        public final com.tencent.luggage.wxa.wn.a d() {
            return this.f144317f[this.f144318g].f144330a;
        }

        public final void e() {
            for (int size = this.f144327p.size() - 1; size >= 0; size--) {
                Message message = (Message) this.f144327p.get(size);
                if (this.f144313b) {
                    this.f144323l.h("moveDeferredMessageAtFrontOfQueue; what=" + message.what);
                }
                sendMessageAtFrontOfQueue(message);
            }
            this.f144327p.clear();
        }

        public final int f() {
            int i3 = this.f144318g + 1;
            int i16 = i3;
            for (int i17 = this.f144320i - 1; i17 >= 0; i17--) {
                if (this.f144313b) {
                    this.f144323l.h("moveTempStackToStateStack: i=" + i17 + ",j=" + i16);
                }
                this.f144317f[i16] = this.f144319h[i17];
                i16++;
            }
            this.f144318g = i16 - 1;
            if (this.f144313b) {
                this.f144323l.h("moveTempStackToStateStack: X mStateStackTop=" + this.f144318g + ",startingIndex=" + i3 + ",Top=" + this.f144317f[this.f144318g].f144330a.getName());
            }
            return i3;
        }

        public final void g() {
            if (this.f144313b) {
                this.f144323l.h("quit:");
            }
            sendMessage(obtainMessage(-1, f144311q));
        }

        public final void a(com.tencent.luggage.wxa.wn.b bVar, Message message) {
            com.tencent.luggage.wxa.wn.b bVar2 = this.f144317f[this.f144318g].f144330a;
            boolean z16 = this.f144323l.c(this.f144314c) && message.obj != f144311q;
            if (this.f144315d.b()) {
                if (this.f144326o != null) {
                    C6889c c6889c = this.f144315d;
                    c cVar = this.f144323l;
                    Message message2 = this.f144314c;
                    c6889c.a(cVar, message2, cVar.a(message2), bVar, bVar2, this.f144326o);
                }
            } else if (z16) {
                C6889c c6889c2 = this.f144315d;
                c cVar2 = this.f144323l;
                Message message3 = this.f144314c;
                c6889c2.a(cVar2, message3, cVar2.a(message3), bVar, bVar2, this.f144326o);
            }
            com.tencent.luggage.wxa.wn.b bVar3 = this.f144326o;
            if (bVar3 != null) {
                while (true) {
                    if (this.f144313b) {
                        this.f144323l.h("handleMessage: new destination call exit/enter");
                    }
                    a(b(bVar3));
                    a(f());
                    e();
                    com.tencent.luggage.wxa.wn.b bVar4 = this.f144326o;
                    if (bVar3 == bVar4) {
                        break;
                    } else {
                        bVar3 = bVar4;
                    }
                }
                this.f144326o = null;
            }
            if (bVar3 != null) {
                if (bVar3 == this.f144322k) {
                    this.f144323l.j();
                    a();
                } else if (bVar3 == this.f144321j) {
                    this.f144323l.i();
                }
            }
        }

        public final com.tencent.luggage.wxa.wn.b b(Message message) {
            C6890c c6890c = this.f144317f[this.f144318g];
            if (this.f144313b) {
                this.f144323l.h("processMsg: " + c6890c.f144330a.getName());
            }
            if (a(message)) {
                a((com.tencent.luggage.wxa.wn.a) this.f144322k);
            } else {
                while (true) {
                    if (c6890c.f144330a.a(message)) {
                        break;
                    }
                    c6890c = c6890c.f144331b;
                    if (c6890c == null) {
                        this.f144323l.e(message);
                        break;
                    }
                    if (this.f144313b) {
                        this.f144323l.h("processMsg: " + c6890c.f144330a.getName());
                    }
                }
            }
            if (c6890c != null) {
                return c6890c.f144330a;
            }
            return null;
        }

        public final C6890c b(com.tencent.luggage.wxa.wn.b bVar) {
            this.f144320i = 0;
            C6890c c6890c = (C6890c) this.f144324m.get(bVar);
            do {
                C6890c[] c6890cArr = this.f144319h;
                int i3 = this.f144320i;
                this.f144320i = i3 + 1;
                c6890cArr[i3] = c6890c;
                c6890c = c6890c.f144331b;
                if (c6890c == null) {
                    break;
                }
            } while (!c6890c.f144332c);
            if (this.f144313b) {
                this.f144323l.h("setupTempStateStackWithStatesToEnter: X mTempStateStackCount=" + this.f144320i + ",curStateInfo: " + c6890c);
            }
            return c6890c;
        }

        public final void a() {
            if (this.f144323l.f144298c != null) {
                getLooper().quit();
                this.f144323l.f144298c = null;
            }
            removeCallbacksAndMessages(null);
            this.f144323l.f144297b = null;
            this.f144323l = null;
            this.f144314c = null;
            this.f144315d.a();
            this.f144317f = null;
            this.f144319h = null;
            this.f144324m.clear();
            this.f144325n = null;
            this.f144326o = null;
            this.f144327p.clear();
            this.f144312a = true;
        }

        public final void a(C6890c c6890c) {
            C6890c c6890c2;
            while (true) {
                int i3 = this.f144318g;
                if (i3 < 0 || (c6890c2 = this.f144317f[i3]) == c6890c) {
                    return;
                }
                com.tencent.luggage.wxa.wn.b bVar = c6890c2.f144330a;
                if (this.f144313b) {
                    this.f144323l.h("invokeExitMethods: " + bVar.getName());
                }
                bVar.b();
                C6890c[] c6890cArr = this.f144317f;
                int i16 = this.f144318g;
                c6890cArr[i16].f144332c = false;
                this.f144318g = i16 - 1;
            }
        }

        public final void a(int i3) {
            while (i3 <= this.f144318g) {
                if (this.f144313b) {
                    this.f144323l.h("invokeEnterMethods: " + this.f144317f[i3].f144330a.getName());
                }
                this.f144317f[i3].f144330a.a();
                this.f144317f[i3].f144332c = true;
                i3++;
            }
        }

        public final C6890c a(com.tencent.luggage.wxa.wn.b bVar, com.tencent.luggage.wxa.wn.b bVar2) {
            C6890c c6890c;
            if (this.f144313b) {
                c cVar = this.f144323l;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("addStateInternal: E state=");
                sb5.append(bVar.getName());
                sb5.append(",parent=");
                sb5.append(bVar2 == null ? "" : bVar2.getName());
                cVar.h(sb5.toString());
            }
            if (bVar2 != null) {
                c6890c = (C6890c) this.f144324m.get(bVar2);
                if (c6890c == null) {
                    c6890c = a(bVar2, (com.tencent.luggage.wxa.wn.b) null);
                }
            } else {
                c6890c = null;
            }
            C6890c c6890c2 = (C6890c) this.f144324m.get(bVar);
            if (c6890c2 == null) {
                c6890c2 = new C6890c();
                this.f144324m.put(bVar, c6890c2);
            }
            C6890c c6890c3 = c6890c2.f144331b;
            if (c6890c3 != null && c6890c3 != c6890c) {
                throw new RuntimeException("state already added");
            }
            c6890c2.f144330a = bVar;
            c6890c2.f144331b = c6890c;
            c6890c2.f144332c = false;
            if (this.f144313b) {
                this.f144323l.h("addStateInternal: X stateInfo: " + c6890c2);
            }
            return c6890c2;
        }

        public final void a(com.tencent.luggage.wxa.wn.b bVar) {
            if (this.f144313b) {
                this.f144323l.h("setInitialState: initialState=" + bVar.getName());
            }
            this.f144325n = bVar;
        }

        public final void a(com.tencent.luggage.wxa.wn.a aVar) {
            this.f144326o = (com.tencent.luggage.wxa.wn.b) aVar;
            if (this.f144313b) {
                this.f144323l.h("transitionTo: destState=" + this.f144326o.getName());
            }
        }

        public final boolean a(Message message) {
            return message.what == -1 && message.obj == f144311q;
        }

        public final void a(boolean z16) {
            this.f144313b = z16;
        }
    }

    public c(String str, Looper looper) {
        a(str, looper);
    }

    public String a(int i3) {
        return null;
    }

    public void b(Message message) {
    }

    public boolean c(Message message) {
        return true;
    }

    public final com.tencent.luggage.wxa.wn.a d() {
        d dVar = this.f144297b;
        if (dVar == null) {
            return null;
        }
        return dVar.d();
    }

    public void e(Message message) {
        if (this.f144297b.f144313b) {
            m(" - unhandledMessage: msg.what=" + message.what);
        }
    }

    public final Handler f() {
        return this.f144297b;
    }

    public final String h() {
        return this.f144296a;
    }

    public final void k() {
        d dVar = this.f144297b;
        if (dVar != null) {
            dVar.g();
        }
    }

    public final void l() {
        d dVar = this.f144297b;
        if (dVar != null) {
            dVar.h();
        }
    }

    public void m() {
        d dVar = this.f144297b;
        if (dVar == null) {
            return;
        }
        dVar.b();
    }

    public String a(Message message) {
        return "";
    }

    public final void b(com.tencent.luggage.wxa.wn.b bVar) {
        this.f144297b.a(bVar);
    }

    public final Message c() {
        d dVar = this.f144297b;
        if (dVar == null) {
            return null;
        }
        return dVar.c();
    }

    public void h(String str) {
        Log.d(this.f144296a, str);
    }

    public final Message b(int i3) {
        return Message.obtain(this.f144297b, i3);
    }

    public final void d(Message message) {
        d dVar = this.f144297b;
        if (dVar == null) {
            return;
        }
        dVar.sendMessage(message);
    }

    public void m(String str) {
        Log.e(this.f144296a, str);
    }

    public final void c(int i3) {
        d dVar = this.f144297b;
        if (dVar == null) {
            return;
        }
        dVar.sendMessage(b(i3));
    }

    public final void a(String str, Looper looper) {
        this.f144296a = str;
        this.f144297b = new d(looper, this);
    }

    public final void a(com.tencent.luggage.wxa.wn.b bVar) {
        this.f144297b.a(bVar, (com.tencent.luggage.wxa.wn.b) null);
    }

    public final void a(com.tencent.luggage.wxa.wn.a aVar) {
        this.f144297b.a(aVar);
    }

    public final Message a(int i3, Object obj) {
        return Message.obtain(this.f144297b, i3, obj);
    }

    public final void a(Message message, long j3) {
        d dVar = this.f144297b;
        if (dVar == null) {
            return;
        }
        dVar.sendMessageDelayed(message, j3);
    }

    public void a(boolean z16) {
        d dVar = this.f144297b;
        if (dVar == null) {
            return;
        }
        dVar.a(z16);
    }

    public void i() {
    }

    public void j() {
    }
}
