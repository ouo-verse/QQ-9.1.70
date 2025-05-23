package io.socket.client;

import a25.b;
import a25.c;
import a25.d;
import a25.e;
import androidx.core.app.NotificationCompat;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import io.socket.client.b;
import io.socket.emitter.Emitter;
import io.socket.engineio.client.Socket;
import io.socket.thread.EventThread;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.Call;
import okhttp3.WebSocket;

/* compiled from: P */
/* loaded from: classes28.dex */
public class Manager extends Emitter {

    /* renamed from: v, reason: collision with root package name */
    private static final Logger f408019v = Logger.getLogger(Manager.class.getName());

    /* renamed from: w, reason: collision with root package name */
    static WebSocket.Factory f408020w;

    /* renamed from: x, reason: collision with root package name */
    static Call.Factory f408021x;

    /* renamed from: a, reason: collision with root package name */
    ReadyState f408022a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f408023b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f408024c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f408025d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f408026e;

    /* renamed from: f, reason: collision with root package name */
    private int f408027f;

    /* renamed from: g, reason: collision with root package name */
    private long f408028g;

    /* renamed from: h, reason: collision with root package name */
    private long f408029h;

    /* renamed from: i, reason: collision with root package name */
    private double f408030i;

    /* renamed from: j, reason: collision with root package name */
    private y15.a f408031j;

    /* renamed from: k, reason: collision with root package name */
    private long f408032k;

    /* renamed from: l, reason: collision with root package name */
    private Set<Socket> f408033l;

    /* renamed from: m, reason: collision with root package name */
    private Date f408034m;

    /* renamed from: n, reason: collision with root package name */
    private URI f408035n;

    /* renamed from: o, reason: collision with root package name */
    private List<c> f408036o;

    /* renamed from: p, reason: collision with root package name */
    private Queue<b.InterfaceC10546b> f408037p;

    /* renamed from: q, reason: collision with root package name */
    private Options f408038q;

    /* renamed from: r, reason: collision with root package name */
    io.socket.engineio.client.Socket f408039r;

    /* renamed from: s, reason: collision with root package name */
    private e f408040s;

    /* renamed from: t, reason: collision with root package name */
    private d f408041t;

    /* renamed from: u, reason: collision with root package name */
    ConcurrentHashMap<String, Socket> f408042u;

    /* compiled from: P */
    /* renamed from: io.socket.client.Manager$11, reason: invalid class name */
    /* loaded from: classes28.dex */
    class AnonymousClass11 extends TimerTask {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Manager f408058d;
        final /* synthetic */ Manager this$0;

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            EventThread.exec(new Runnable() { // from class: io.socket.client.Manager.11.1

                /* compiled from: P */
                /* renamed from: io.socket.client.Manager$11$1$a */
                /* loaded from: classes28.dex */
                class a implements b {
                    a() {
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (AnonymousClass11.this.f408058d.f408024c) {
                        return;
                    }
                    Manager.f408019v.fine("attempting reconnect");
                    int a16 = AnonymousClass11.this.f408058d.f408031j.a();
                    AnonymousClass11.this.f408058d.o("reconnect_attempt", Integer.valueOf(a16));
                    AnonymousClass11.this.f408058d.o("reconnecting", Integer.valueOf(a16));
                    if (AnonymousClass11.this.f408058d.f408024c) {
                        return;
                    }
                    AnonymousClass11.this.f408058d.q(new a());
                }
            });
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private static class Engine extends io.socket.engineio.client.Socket {
        Engine(URI uri, Socket.Options options) {
            super(uri, options);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class Options extends Socket.Options {

        /* renamed from: b, reason: collision with root package name */
        public int f408062b;

        /* renamed from: c, reason: collision with root package name */
        public long f408063c;

        /* renamed from: d, reason: collision with root package name */
        public long f408064d;

        /* renamed from: e, reason: collision with root package name */
        public double f408065e;

        /* renamed from: f, reason: collision with root package name */
        public e f408066f;

        /* renamed from: g, reason: collision with root package name */
        public d f408067g;

        /* renamed from: a, reason: collision with root package name */
        public boolean f408061a = true;

        /* renamed from: h, reason: collision with root package name */
        public long f408068h = 20000;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public enum ReadyState {
        CLOSED,
        OPENING,
        OPEN
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class a implements e.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Manager f408069a;

        a(Manager manager) {
            this.f408069a = manager;
        }

        @Override // a25.e.a
        public void call(Object[] objArr) {
            for (Object obj : objArr) {
                if (obj instanceof String) {
                    this.f408069a.f408039r.write((String) obj);
                } else if (obj instanceof byte[]) {
                    this.f408069a.f408039r.write((byte[]) obj);
                }
            }
            this.f408069a.f408026e = false;
            this.f408069a.s();
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface b {
    }

    public Manager() {
        this(null, null);
    }

    private void l() {
        f408019v.fine("cleanup");
        while (true) {
            b.InterfaceC10546b poll = this.f408037p.poll();
            if (poll != null) {
                poll.destroy();
            } else {
                this.f408041t.a(null);
                this.f408036o.clear();
                this.f408026e = false;
                this.f408034m = null;
                this.f408041t.destroy();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(String str, Object... objArr) {
        emit(str, objArr);
        Iterator<Socket> it = this.f408042u.values().iterator();
        while (it.hasNext()) {
            it.next().p(str, objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (!this.f408036o.isEmpty() && !this.f408026e) {
            r(this.f408036o.remove(0));
        }
    }

    public Manager A(long j3) {
        this.f408029h = j3;
        y15.a aVar = this.f408031j;
        if (aVar != null) {
            aVar.d(j3);
        }
        return this;
    }

    public Manager B(long j3) {
        this.f408032k = j3;
        return this;
    }

    void m() {
        f408019v.fine("disconnect");
        this.f408024c = true;
        this.f408025d = false;
        if (this.f408022a != ReadyState.OPEN) {
            l();
        }
        this.f408031j.b();
        this.f408022a = ReadyState.CLOSED;
        io.socket.engineio.client.Socket socket = this.f408039r;
        if (socket != null) {
            socket.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(Socket socket) {
        this.f408033l.remove(socket);
        if (!this.f408033l.isEmpty()) {
            return;
        }
        m();
    }

    public Manager p() {
        return q(null);
    }

    public Manager q(final b bVar) {
        EventThread.exec(new Runnable() { // from class: io.socket.client.Manager.1

            /* compiled from: P */
            /* renamed from: io.socket.client.Manager$1$a */
            /* loaded from: classes28.dex */
            class a implements Emitter.Listener {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ Manager f408050a;

                a(Manager manager) {
                    this.f408050a = manager;
                }
            }

            /* compiled from: P */
            /* renamed from: io.socket.client.Manager$1$b */
            /* loaded from: classes28.dex */
            class b implements Emitter.Listener {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ Manager f408052a;

                b(Manager manager) {
                    this.f408052a = manager;
                }
            }

            /* compiled from: P */
            /* renamed from: io.socket.client.Manager$1$c */
            /* loaded from: classes28.dex */
            class c implements Emitter.Listener {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ Manager f408054a;

                c(Manager manager) {
                    this.f408054a = manager;
                }
            }

            /* compiled from: P */
            /* renamed from: io.socket.client.Manager$1$d */
            /* loaded from: classes28.dex */
            class d implements b.InterfaceC10546b {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ Timer f408056a;

                d(Timer timer) {
                    this.f408056a = timer;
                }

                @Override // io.socket.client.b.InterfaceC10546b
                public void destroy() {
                    this.f408056a.cancel();
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                ReadyState readyState;
                Logger logger = Manager.f408019v;
                Level level = Level.FINE;
                if (logger.isLoggable(level)) {
                    Manager.f408019v.fine(String.format("readyState %s", Manager.this.f408022a));
                }
                ReadyState readyState2 = Manager.this.f408022a;
                if (readyState2 != ReadyState.OPEN && readyState2 != (readyState = ReadyState.OPENING)) {
                    if (Manager.f408019v.isLoggable(level)) {
                        Manager.f408019v.fine(String.format("opening %s", Manager.this.f408035n));
                    }
                    Manager.this.f408039r = new Engine(Manager.this.f408035n, Manager.this.f408038q);
                    final Manager manager = Manager.this;
                    final io.socket.engineio.client.Socket socket = manager.f408039r;
                    manager.f408022a = readyState;
                    manager.f408024c = false;
                    socket.on(NotificationCompat.CATEGORY_TRANSPORT, new a(manager));
                    final b.InterfaceC10546b a16 = io.socket.client.b.a(socket, "open", new b(manager));
                    b.InterfaceC10546b a17 = io.socket.client.b.a(socket, "error", new c(manager));
                    if (Manager.this.f408032k >= 0) {
                        final long j3 = Manager.this.f408032k;
                        Manager.f408019v.fine(String.format("connection attempt will timeout after %d", Long.valueOf(j3)));
                        BaseTimer baseTimer = new BaseTimer();
                        baseTimer.schedule(new TimerTask() { // from class: io.socket.client.Manager.1.4
                            @Override // java.util.TimerTask, java.lang.Runnable
                            public void run() {
                                EventThread.exec(new Runnable() { // from class: io.socket.client.Manager.1.4.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Manager.f408019v.fine(String.format("connect attempt timed out after %d", Long.valueOf(j3)));
                                        a16.destroy();
                                        socket.close();
                                        socket.emit("error", new Object[]{new SocketIOException("timeout")});
                                        AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                        manager.o("connect_timeout", Long.valueOf(j3));
                                    }
                                });
                            }
                        }, j3);
                        Manager.this.f408037p.add(new d(baseTimer));
                    }
                    Manager.this.f408037p.add(a16);
                    Manager.this.f408037p.add(a17);
                    Manager.this.f408039r.open();
                }
            }
        });
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(c cVar) {
        Logger logger = f408019v;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(String.format("writing packet %s", cVar));
        }
        String str = cVar.f25425f;
        if (str != null && !str.isEmpty() && cVar.f25420a == 0) {
            cVar.f25422c += QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + cVar.f25425f;
        }
        if (!this.f408026e) {
            this.f408026e = true;
            this.f408040s.a(cVar, new a(this));
        } else {
            this.f408036o.add(cVar);
        }
    }

    public final double t() {
        return this.f408030i;
    }

    public Manager u(double d16) {
        this.f408030i = d16;
        y15.a aVar = this.f408031j;
        if (aVar != null) {
            aVar.c(d16);
        }
        return this;
    }

    public Manager v(boolean z16) {
        this.f408023b = z16;
        return this;
    }

    public Manager w(int i3) {
        this.f408027f = i3;
        return this;
    }

    public final long x() {
        return this.f408028g;
    }

    public Manager y(long j3) {
        this.f408028g = j3;
        y15.a aVar = this.f408031j;
        if (aVar != null) {
            aVar.e(j3);
        }
        return this;
    }

    public final long z() {
        return this.f408029h;
    }

    public Manager(URI uri, Options options) {
        this.f408033l = new HashSet();
        options = options == null ? new Options() : options;
        if (options.path == null) {
            options.path = "/socket.io";
        }
        if (options.webSocketFactory == null) {
            options.webSocketFactory = f408020w;
        }
        if (options.callFactory == null) {
            options.callFactory = f408021x;
        }
        this.f408038q = options;
        this.f408042u = new ConcurrentHashMap<>();
        this.f408037p = new LinkedList();
        v(options.f408061a);
        int i3 = options.f408062b;
        w(i3 == 0 ? Integer.MAX_VALUE : i3);
        long j3 = options.f408063c;
        y(j3 == 0 ? 1000L : j3);
        long j16 = options.f408064d;
        A(j16 == 0 ? 5000L : j16);
        double d16 = options.f408065e;
        u(d16 == 0.0d ? 0.5d : d16);
        this.f408031j = new y15.a().e(x()).d(z()).c(t());
        B(options.f408068h);
        this.f408022a = ReadyState.CLOSED;
        this.f408035n = uri;
        this.f408026e = false;
        this.f408036o = new ArrayList();
        e eVar = options.f408066f;
        this.f408040s = eVar == null ? new b.C0005b() : eVar;
        d dVar = options.f408067g;
        this.f408041t = dVar == null ? new b.a() : dVar;
    }
}
