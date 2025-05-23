package io.socket.client;

import a25.c;
import com.tencent.upload.report.UploadQualityReportBuilder;
import io.socket.client.Manager;
import io.socket.client.b;
import io.socket.emitter.Emitter;
import io.socket.thread.EventThread;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes28.dex */
public class Socket extends Emitter {

    /* renamed from: j, reason: collision with root package name */
    private static final Logger f408071j = Logger.getLogger(Socket.class.getName());

    /* renamed from: k, reason: collision with root package name */
    protected static Map<String, Integer> f408072k = new HashMap<String, Integer>() { // from class: io.socket.client.Socket.1
        {
            put(UploadQualityReportBuilder.STATE_CONNECT, 1);
            put("connect_error", 1);
            put("connect_timeout", 1);
            put("connecting", 1);
            put("disconnect", 1);
            put("error", 1);
            put("reconnect", 1);
            put("reconnect_attempt", 1);
            put("reconnect_failed", 1);
            put("reconnect_error", 1);
            put("reconnecting", 1);
            put("ping", 1);
            put("pong", 1);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    String f408073a;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f408074b;

    /* renamed from: c, reason: collision with root package name */
    private int f408075c;

    /* renamed from: d, reason: collision with root package name */
    private String f408076d;

    /* renamed from: e, reason: collision with root package name */
    private Manager f408077e;

    /* renamed from: f, reason: collision with root package name */
    private String f408078f;

    /* renamed from: g, reason: collision with root package name */
    private Map<Integer, a> f408079g;

    /* renamed from: h, reason: collision with root package name */
    private Queue<b.InterfaceC10546b> f408080h;

    /* renamed from: i, reason: collision with root package name */
    private final Queue<c<JSONArray>> f408081i;

    /* compiled from: P */
    /* renamed from: io.socket.client.Socket$3, reason: invalid class name */
    /* loaded from: classes28.dex */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ Socket this$0;

        @Override // java.lang.Runnable
        public void run() {
            if (!this.this$0.f408074b) {
                this.this$0.u();
                this.this$0.f408077e.p();
                if (Manager.ReadyState.OPEN == this.this$0.f408077e.f408022a) {
                    this.this$0.s();
                }
                this.this$0.p("connecting", new Object[0]);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: io.socket.client.Socket$4, reason: invalid class name */
    /* loaded from: classes28.dex */
    class AnonymousClass4 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Object[] f408085d;
        final /* synthetic */ Socket this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.p("message", this.f408085d);
        }
    }

    /* compiled from: P */
    /* renamed from: io.socket.client.Socket$8, reason: invalid class name */
    /* loaded from: classes28.dex */
    class AnonymousClass8 implements Runnable {
        final /* synthetic */ Socket this$0;

        @Override // java.lang.Runnable
        public void run() {
            if (this.this$0.f408074b) {
                if (Socket.f408071j.isLoggable(Level.FINE)) {
                    Socket.f408071j.fine(String.format("performing disconnect (%s)", this.this$0.f408076d));
                }
                this.this$0.t(new c(1));
            }
            this.this$0.o();
            if (this.this$0.f408074b) {
                this.this$0.r("io client disconnect");
            }
        }
    }

    static /* synthetic */ int l(Socket socket) {
        int i3 = socket.f408075c;
        socket.f408075c = i3 + 1;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        Queue<b.InterfaceC10546b> queue = this.f408080h;
        if (queue != null) {
            Iterator<b.InterfaceC10546b> it = queue.iterator();
            while (it.hasNext()) {
                it.next().destroy();
            }
            this.f408080h = null;
        }
        this.f408077e.n(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(String str) {
        Logger logger = f408071j;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(String.format("close (%s)", str));
        }
        this.f408074b = false;
        this.f408073a = null;
        p("disconnect", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        f408071j.fine("transport is open - connecting");
        if (!"/".equals(this.f408076d)) {
            String str = this.f408078f;
            if (str != null && !str.isEmpty()) {
                c cVar = new c(0);
                cVar.f25425f = this.f408078f;
                t(cVar);
                return;
            }
            t(new c(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(c cVar) {
        cVar.f25422c = this.f408076d;
        this.f408077e.r(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        if (this.f408080h != null) {
            return;
        }
        this.f408080h = new LinkedList<b.InterfaceC10546b>(this.f408077e) { // from class: io.socket.client.Socket.2
            final /* synthetic */ Manager val$io;

            /* compiled from: P */
            /* renamed from: io.socket.client.Socket$2$a */
            /* loaded from: classes28.dex */
            class a implements Emitter.Listener {
                a() {
                }
            }

            /* compiled from: P */
            /* renamed from: io.socket.client.Socket$2$b */
            /* loaded from: classes28.dex */
            class b implements Emitter.Listener {
                b() {
                }
            }

            /* compiled from: P */
            /* renamed from: io.socket.client.Socket$2$c */
            /* loaded from: classes28.dex */
            class c implements Emitter.Listener {
                c() {
                }
            }

            {
                this.val$io = r3;
                add(io.socket.client.b.a(r3, "open", new a()));
                add(io.socket.client.b.a(r3, "packet", new b()));
                add(io.socket.client.b.a(r3, "close", new c()));
            }
        };
    }

    public Emitter p(final String str, final Object... objArr) {
        EventThread.exec(new Runnable() { // from class: io.socket.client.Socket.5
            @Override // java.lang.Runnable
            public void run() {
                a aVar;
                if (Socket.f408072k.containsKey(str)) {
                    Socket.super.emit(str, objArr);
                    return;
                }
                Object[] objArr2 = objArr;
                int length = objArr2.length - 1;
                if (objArr2.length > 0 && (objArr2[length] instanceof a)) {
                    objArr2 = new Object[length];
                    for (int i3 = 0; i3 < length; i3++) {
                        objArr2[i3] = objArr[i3];
                    }
                    aVar = (a) objArr[length];
                } else {
                    aVar = null;
                }
                Socket.this.q(str, objArr2, aVar);
            }
        });
        return this;
    }

    public Emitter q(final String str, final Object[] objArr, final a aVar) {
        EventThread.exec(new Runnable() { // from class: io.socket.client.Socket.6
            @Override // java.lang.Runnable
            public void run() {
                JSONArray jSONArray = new JSONArray();
                jSONArray.mo162put(str);
                Object[] objArr2 = objArr;
                if (objArr2 != null) {
                    for (Object obj : objArr2) {
                        jSONArray.mo162put(obj);
                    }
                }
                c cVar = new c(2, jSONArray);
                if (aVar != null) {
                    Socket.f408071j.fine(String.format("emitting packet with ack id %d", Integer.valueOf(Socket.this.f408075c)));
                    Socket.this.f408079g.put(Integer.valueOf(Socket.this.f408075c), aVar);
                    cVar.f25421b = Socket.l(Socket.this);
                }
                if (Socket.this.f408074b) {
                    Socket.this.t(cVar);
                } else {
                    Socket.this.f408081i.add(cVar);
                }
            }
        });
        return this;
    }
}
