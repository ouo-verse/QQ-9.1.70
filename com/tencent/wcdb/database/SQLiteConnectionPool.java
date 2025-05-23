package com.tencent.wcdb.database;

import android.os.SystemClock;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.adinfo.QAdPlayStrategyDefine$PlayStrategyKey;
import com.tencent.wcdb.database.l;
import com.tencent.wcdb.support.Log;
import java.io.Closeable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

/* loaded from: classes27.dex */
public final class SQLiteConnectionPool implements Closeable {
    static IPatchRedirector $redirector_;
    static final /* synthetic */ boolean L;
    private final d C;
    private int D;
    private boolean E;
    private int F;
    private c G;
    private c H;
    private final ArrayList<SQLiteConnection> I;
    private SQLiteConnection J;
    private final WeakHashMap<SQLiteConnection, AcquiredConnectionStatus> K;

    /* renamed from: d, reason: collision with root package name */
    private final WeakReference<SQLiteDatabase> f384359d;

    /* renamed from: e, reason: collision with root package name */
    private volatile l f384360e;

    /* renamed from: f, reason: collision with root package name */
    private byte[] f384361f;

    /* renamed from: h, reason: collision with root package name */
    private SQLiteCipherSpec f384362h;

    /* renamed from: i, reason: collision with root package name */
    private final Object f384363i;

    /* renamed from: m, reason: collision with root package name */
    private final AtomicBoolean f384364m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes27.dex */
    public static final class AcquiredConnectionStatus {
        private static final /* synthetic */ AcquiredConnectionStatus[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final AcquiredConnectionStatus DISCARD;
        public static final AcquiredConnectionStatus NORMAL;
        public static final AcquiredConnectionStatus RECONFIGURE;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18700);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            AcquiredConnectionStatus acquiredConnectionStatus = new AcquiredConnectionStatus(QAdPlayStrategyDefine$PlayStrategyKey.NORMAL, 0);
            NORMAL = acquiredConnectionStatus;
            AcquiredConnectionStatus acquiredConnectionStatus2 = new AcquiredConnectionStatus("RECONFIGURE", 1);
            RECONFIGURE = acquiredConnectionStatus2;
            AcquiredConnectionStatus acquiredConnectionStatus3 = new AcquiredConnectionStatus("DISCARD", 2);
            DISCARD = acquiredConnectionStatus3;
            $VALUES = new AcquiredConnectionStatus[]{acquiredConnectionStatus, acquiredConnectionStatus2, acquiredConnectionStatus3};
        }

        AcquiredConnectionStatus(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static AcquiredConnectionStatus valueOf(String str) {
            return (AcquiredConnectionStatus) Enum.valueOf(AcquiredConnectionStatus.class, str);
        }

        public static AcquiredConnectionStatus[] values() {
            return (AcquiredConnectionStatus[]) $VALUES.clone();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes27.dex */
    public class a {
        static IPatchRedirector $redirector_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes27.dex */
    public static final class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public c f384372a;

        /* renamed from: b, reason: collision with root package name */
        public Thread f384373b;

        /* renamed from: c, reason: collision with root package name */
        public long f384374c;

        /* renamed from: d, reason: collision with root package name */
        public int f384375d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f384376e;

        /* renamed from: f, reason: collision with root package name */
        public String f384377f;

        /* renamed from: g, reason: collision with root package name */
        public int f384378g;

        /* renamed from: h, reason: collision with root package name */
        public SQLiteConnection f384379h;

        /* renamed from: i, reason: collision with root package name */
        public RuntimeException f384380i;

        /* renamed from: j, reason: collision with root package name */
        public int f384381j;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        /* synthetic */ c(a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18722);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            L = true;
        }
    }

    SQLiteConnectionPool(SQLiteDatabase sQLiteDatabase, d dVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, sQLiteDatabase, dVar, Integer.valueOf(i3));
            return;
        }
        this.f384363i = new Object();
        this.f384364m = new AtomicBoolean();
        this.I = new ArrayList<>();
        this.K = new WeakHashMap<>();
        this.f384359d = new WeakReference<>(sQLiteDatabase);
        this.C = new d(dVar);
        A(i3);
    }

    private void A(int i3) {
        if (i3 <= 0) {
            if ((this.C.f384395d & 536870912) != 0) {
                i3 = 4;
            } else {
                i3 = 1;
            }
        }
        this.D = i3;
        Log.d("WCDB.SQLiteConnectionPool", "Max connection pool size is %d.", Integer.valueOf(i3));
    }

    private void B() {
        if (this.E) {
        } else {
            throw new IllegalStateException("Cannot perform this operation because the connection pool has been closed.");
        }
    }

    private SQLiteConnection D(String str, int i3) {
        int size = this.I.size();
        if (size > 1 && str != null) {
            for (int i16 = 0; i16 < size; i16++) {
                SQLiteConnection sQLiteConnection = this.I.get(i16);
                if (sQLiteConnection.B(str)) {
                    this.I.remove(i16);
                    j(sQLiteConnection, i3);
                    return sQLiteConnection;
                }
            }
        }
        if (size > 0) {
            SQLiteConnection remove = this.I.remove(size - 1);
            j(remove, i3);
            return remove;
        }
        int size2 = this.K.size();
        if (this.J != null) {
            size2++;
        }
        if (size2 >= this.D) {
            return null;
        }
        SQLiteConnection u16 = u(this.C, false);
        j(u16, i3);
        return u16;
    }

    private SQLiteConnection E(int i3) {
        SQLiteConnection sQLiteConnection = this.J;
        if (sQLiteConnection != null) {
            this.J = null;
            j(sQLiteConnection, i3);
            return sQLiteConnection;
        }
        Iterator<SQLiteConnection> it = this.K.keySet().iterator();
        while (it.hasNext()) {
            if (it.next().C()) {
                return null;
            }
        }
        SQLiteConnection u16 = u(this.C, true);
        j(u16, i3);
        return u16;
    }

    private SQLiteConnection F(String str, int i3, com.tencent.wcdb.support.a aVar) {
        boolean z16;
        SQLiteConnection sQLiteConnection;
        SQLiteConnection sQLiteConnection2;
        RuntimeException runtimeException;
        long uptimeMillis;
        b k3;
        long j3;
        long j16;
        if ((i3 & 2) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        synchronized (this.f384363i) {
            B();
            if (!z16) {
                sQLiteConnection = D(str, i3);
            } else {
                sQLiteConnection = null;
            }
            if (sQLiteConnection == null) {
                sQLiteConnection = E(i3);
            }
            if (sQLiteConnection != null) {
                return sQLiteConnection;
            }
            int l3 = l(i3);
            c r16 = r(Thread.currentThread(), SystemClock.uptimeMillis(), l3, z16, str, i3);
            c cVar = this.H;
            c cVar2 = null;
            while (true) {
                if (cVar == null) {
                    break;
                }
                if (l3 > cVar.f384375d) {
                    r16.f384372a = cVar;
                    break;
                }
                cVar2 = cVar;
                cVar = cVar.f384372a;
            }
            if (cVar2 != null) {
                cVar2.f384372a = r16;
            } else {
                this.H = r16;
            }
            int i16 = r16.f384381j;
            long j17 = r16.f384374c + 3000;
            long j18 = 3000;
            while (true) {
                if (this.f384364m.compareAndSet(true, false)) {
                    synchronized (this.f384363i) {
                        G();
                    }
                }
                LockSupport.parkNanos(j18 * 1000000);
                Thread.interrupted();
                synchronized (this.f384363i) {
                    B();
                    sQLiteConnection2 = r16.f384379h;
                    runtimeException = r16.f384380i;
                    if (sQLiteConnection2 != null || runtimeException != null) {
                        break;
                    }
                    uptimeMillis = SystemClock.uptimeMillis();
                    if (uptimeMillis < j17) {
                        j16 = j17;
                        j3 = uptimeMillis - j17;
                        k3 = null;
                    } else {
                        k3 = k();
                        j3 = 3000;
                        j16 = uptimeMillis + 3000;
                    }
                }
                if (k3 != null) {
                    long j19 = uptimeMillis - r16.f384374c;
                    n(k3, j19, i3);
                    SQLiteDatabase sQLiteDatabase = this.f384359d.get();
                    l lVar = this.f384360e;
                    if (sQLiteDatabase != null && lVar != null) {
                        lVar.c(sQLiteDatabase, str, j19, z16, k3.f384370f, k3.f384371g);
                    }
                }
                j17 = j16;
                j18 = j3;
            }
            y(r16);
            if (sQLiteConnection2 != null) {
                return sQLiteConnection2;
            }
            throw runtimeException;
        }
    }

    private void G() {
        SQLiteConnection sQLiteConnection;
        c cVar = this.H;
        c cVar2 = null;
        boolean z16 = false;
        boolean z17 = false;
        while (cVar != null) {
            boolean z18 = true;
            if (this.E) {
                try {
                    if (!cVar.f384376e && !z16) {
                        sQLiteConnection = D(cVar.f384377f, cVar.f384378g);
                        if (sQLiteConnection == null) {
                            z16 = true;
                        }
                    } else {
                        sQLiteConnection = null;
                    }
                    if (sQLiteConnection == null && !z17 && (sQLiteConnection = E(cVar.f384378g)) == null) {
                        z17 = true;
                    }
                    if (sQLiteConnection != null) {
                        cVar.f384379h = sQLiteConnection;
                    } else if (!z16 || !z17) {
                        z18 = false;
                    } else {
                        return;
                    }
                } catch (RuntimeException e16) {
                    cVar.f384380i = e16;
                }
            }
            c cVar3 = cVar.f384372a;
            if (z18) {
                if (cVar2 != null) {
                    cVar2.f384372a = cVar3;
                } else {
                    this.H = cVar3;
                }
                cVar.f384372a = null;
                LockSupport.unpark(cVar.f384373b);
            } else {
                cVar2 = cVar;
            }
            cVar = cVar3;
        }
    }

    private void d() {
        e();
        SQLiteConnection sQLiteConnection = this.J;
        if (sQLiteConnection != null) {
            f(sQLiteConnection);
            this.J = null;
        }
    }

    private void e() {
        int size = this.I.size();
        for (int i3 = 0; i3 < size; i3++) {
            f(this.I.get(i3));
        }
        this.I.clear();
    }

    private void f(SQLiteConnection sQLiteConnection) {
        try {
            sQLiteConnection.n();
        } catch (RuntimeException e16) {
            Log.a("WCDB.SQLiteConnectionPool", "Failed to close connection, its fate is now in the hands of the merciful GC: " + sQLiteConnection + e16.getMessage());
        }
    }

    private void g() {
        int size = this.I.size();
        while (true) {
            int i3 = size - 1;
            if (size > this.D - 1) {
                f(this.I.remove(i3));
                size = i3;
            } else {
                return;
            }
        }
    }

    private void h() {
        o(AcquiredConnectionStatus.DISCARD);
    }

    private void i(boolean z16) {
        if (!z16) {
            synchronized (this.f384363i) {
                B();
                this.E = false;
                d();
                int size = this.K.size();
                if (size != 0) {
                    Log.c("WCDB.SQLiteConnectionPool", "The connection pool for " + this.C.f384393b + " has been closed but there are still " + size + " connections in use.  They will be closed as they are released back to the pool.");
                }
                G();
            }
        }
    }

    private void j(SQLiteConnection sQLiteConnection, int i3) {
        boolean z16;
        if ((i3 & 1) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        try {
            sQLiteConnection.S(z16);
            this.K.put(sQLiteConnection, AcquiredConnectionStatus.NORMAL);
        } catch (RuntimeException e16) {
            Log.a("WCDB.SQLiteConnectionPool", "Failed to prepare acquired connection for session, closing it: " + sQLiteConnection + ", connectionFlags=" + i3);
            f(sQLiteConnection);
            throw e16;
        }
    }

    private b k() {
        b bVar = new b(null);
        bVar.f384367c = 0;
        bVar.f384368d = 0;
        if (!this.K.isEmpty()) {
            for (SQLiteConnection sQLiteConnection : this.K.keySet()) {
                l.a<StackTraceElement[]> a06 = sQLiteConnection.a0();
                if (a06 != null) {
                    bVar.f384371g.add(a06);
                }
                l.a<String> Z = sQLiteConnection.Z();
                if (Z != null) {
                    bVar.f384370f.add(Z);
                    String o16 = sQLiteConnection.o();
                    if (o16 != null) {
                        bVar.f384366b.add(o16);
                    }
                    bVar.f384367c++;
                } else {
                    bVar.f384368d++;
                }
            }
        }
        int size = this.I.size();
        bVar.f384369e = size;
        if (this.J != null) {
            bVar.f384369e = size + 1;
        }
        return bVar;
    }

    private static int l(int i3) {
        if ((i3 & 4) != 0) {
            return 1;
        }
        return 0;
    }

    private void n(b bVar, long j3, int i3) {
        StringBuilder sb5 = new StringBuilder();
        if (j3 != 0) {
            Thread currentThread = Thread.currentThread();
            sb5.append("The connection pool for database '");
            sb5.append(bVar.f384365a);
            sb5.append("' has been unable to grant a connection to thread ");
            sb5.append(currentThread.getId());
            sb5.append(" (");
            sb5.append(currentThread.getName());
            sb5.append(") ");
            sb5.append("with flags 0x");
            sb5.append(Integer.toHexString(i3));
            sb5.append(" for ");
            sb5.append(((float) j3) * 0.001f);
            sb5.append(" seconds.\n");
        }
        sb5.append("Connections: ");
        sb5.append(bVar.f384367c);
        sb5.append(" active, ");
        sb5.append(bVar.f384368d);
        sb5.append(" idle, ");
        sb5.append(bVar.f384369e);
        sb5.append(" available.\n");
        if (!bVar.f384366b.isEmpty()) {
            sb5.append("\nRequests in progress:\n");
            Iterator<String> it = bVar.f384366b.iterator();
            while (it.hasNext()) {
                String next = it.next();
                sb5.append("  ");
                sb5.append(next);
                sb5.append("\n");
            }
        }
        Log.g("WCDB.SQLiteConnectionPool", sb5.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void o(AcquiredConnectionStatus acquiredConnectionStatus) {
        if (!this.K.isEmpty()) {
            ArrayList arrayList = new ArrayList(this.K.size());
            for (Map.Entry<SQLiteConnection, AcquiredConnectionStatus> entry : this.K.entrySet()) {
                AcquiredConnectionStatus value = entry.getValue();
                if (acquiredConnectionStatus != value && value != AcquiredConnectionStatus.DISCARD) {
                    arrayList.add(entry.getKey());
                }
            }
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.K.put(arrayList.get(i3), acquiredConnectionStatus);
            }
        }
    }

    private void open() {
        this.J = u(this.C, true);
        this.E = true;
    }

    private c r(Thread thread, long j3, int i3, boolean z16, String str, int i16) {
        c cVar = this.G;
        a aVar = null;
        if (cVar != null) {
            this.G = cVar.f384372a;
            cVar.f384372a = null;
        } else {
            cVar = new c(aVar);
        }
        cVar.f384373b = thread;
        cVar.f384374c = j3;
        cVar.f384375d = i3;
        cVar.f384376e = z16;
        cVar.f384377f = str;
        cVar.f384378g = i16;
        return cVar;
    }

    public static SQLiteConnectionPool t(SQLiteDatabase sQLiteDatabase, d dVar, byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec, int i3) {
        SQLiteCipherSpec sQLiteCipherSpec2;
        if (dVar != null) {
            SQLiteConnectionPool sQLiteConnectionPool = new SQLiteConnectionPool(sQLiteDatabase, dVar, i3);
            sQLiteConnectionPool.f384361f = bArr;
            if (sQLiteCipherSpec == null) {
                sQLiteCipherSpec2 = null;
            } else {
                sQLiteCipherSpec2 = new SQLiteCipherSpec(sQLiteCipherSpec);
            }
            sQLiteConnectionPool.f384362h = sQLiteCipherSpec2;
            sQLiteConnectionPool.open();
            return sQLiteConnectionPool;
        }
        throw new IllegalArgumentException("configuration must not be null.");
    }

    private SQLiteConnection u(d dVar, boolean z16) {
        int i3 = this.F;
        this.F = i3 + 1;
        return SQLiteConnection.E(this, dVar, i3, z16, this.f384361f, this.f384362h);
    }

    private void w() {
        SQLiteConnection sQLiteConnection = this.J;
        if (sQLiteConnection != null) {
            try {
                sQLiteConnection.H(this.C);
            } catch (RuntimeException e16) {
                Log.b("WCDB.SQLiteConnectionPool", "Failed to reconfigure available primary connection, closing it: " + this.J, e16);
                f(this.J);
                this.J = null;
            }
        }
        int size = this.I.size();
        int i3 = 0;
        while (i3 < size) {
            SQLiteConnection sQLiteConnection2 = this.I.get(i3);
            try {
                sQLiteConnection2.H(this.C);
            } catch (RuntimeException e17) {
                Log.b("WCDB.SQLiteConnectionPool", "Failed to reconfigure available non-primary connection, closing it: " + sQLiteConnection2, e17);
                f(sQLiteConnection2);
                this.I.remove(i3);
                size += -1;
                i3--;
            }
            i3++;
        }
        o(AcquiredConnectionStatus.RECONFIGURE);
    }

    private boolean x(SQLiteConnection sQLiteConnection, AcquiredConnectionStatus acquiredConnectionStatus) {
        if (acquiredConnectionStatus == AcquiredConnectionStatus.RECONFIGURE) {
            try {
                sQLiteConnection.H(this.C);
            } catch (RuntimeException e16) {
                Log.b("WCDB.SQLiteConnectionPool", "Failed to reconfigure released connection, closing it: " + sQLiteConnection, e16);
                acquiredConnectionStatus = AcquiredConnectionStatus.DISCARD;
            }
        }
        if (acquiredConnectionStatus != AcquiredConnectionStatus.DISCARD) {
            return true;
        }
        f(sQLiteConnection);
        return false;
    }

    private void y(c cVar) {
        cVar.f384372a = this.G;
        cVar.f384373b = null;
        cVar.f384377f = null;
        cVar.f384379h = null;
        cVar.f384380i = null;
        cVar.f384381j++;
        this.G = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C(String str, int i3, long j3) {
        SQLiteDatabase sQLiteDatabase = this.f384359d.get();
        l lVar = this.f384360e;
        if (lVar != null && sQLiteDatabase != null) {
            lVar.d(sQLiteDatabase, str, i3, j3);
        }
    }

    public SQLiteConnection a(String str, int i3, com.tencent.wcdb.support.a aVar) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (SQLiteConnection) iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), aVar);
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        SQLiteConnection F = F(str, i3, aVar);
        l lVar = this.f384360e;
        if (lVar != null) {
            long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
            SQLiteDatabase sQLiteDatabase = this.f384359d.get();
            if (sQLiteDatabase != null) {
                if ((i3 & 2) != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                lVar.b(sQLiteDatabase, str, uptimeMillis2, z16);
            }
        }
        return F;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            i(false);
        }
    }

    protected void finalize() throws Throwable {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        try {
            i(true);
        } finally {
            super.finalize();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l m() {
        return this.f384360e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(String str, String str2, long[] jArr, long[] jArr2, long[] jArr3) {
        this.f384359d.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(String str, int i3) {
        this.f384359d.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s() {
        Log.g("WCDB.SQLiteConnectionPool", "A SQLiteConnection object for database '" + this.C.f384393b + "' was leaked!  Please fix your application to end transactions in progress properly and to close the database when it is no longer needed.");
        this.f384364m.set(true);
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "SQLiteConnectionPool: " + this.C.f384392a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0093, code lost:
    
        d();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void v(d dVar) {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) dVar);
            return;
        }
        if (dVar != null) {
            synchronized (this.f384363i) {
                B();
                if (((dVar.f384395d ^ this.C.f384395d) & 536870912) != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    if (this.K.isEmpty()) {
                        e();
                    } else {
                        throw new IllegalStateException("Write Ahead Logging (WAL) mode cannot be enabled or disabled while there are transactions in progress.  Finish all transactions and release all active database connections first.");
                    }
                }
                if (dVar.f384398g != this.C.f384398g) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17 && !this.K.isEmpty()) {
                    throw new IllegalStateException("Foreign Key Constraints cannot be enabled or disabled while there are transactions in progress.  Finish all transactions and release all active database connections first.");
                }
                d dVar2 = this.C;
                if (((dVar2.f384395d ^ dVar.f384395d) & 268435473) == 0 && com.tencent.wcdb.g.f(dVar2.f384394c, dVar.f384394c) && dVar.f384403l.containsAll(this.C.f384403l)) {
                    this.C.b(dVar);
                    A(0);
                    g();
                    w();
                    G();
                }
                SQLiteConnection u16 = u(dVar, true);
                d();
                h();
                this.J = u16;
                this.C.b(dVar);
                A(0);
                G();
            }
            return;
        }
        throw new IllegalArgumentException("configuration must not be null.");
    }

    public void z(SQLiteConnection sQLiteConnection) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) sQLiteConnection);
            return;
        }
        synchronized (this.f384363i) {
            AcquiredConnectionStatus remove = this.K.remove(sQLiteConnection);
            if (remove != null) {
                if (!this.E) {
                    f(sQLiteConnection);
                } else if (sQLiteConnection.C()) {
                    if (x(sQLiteConnection, remove)) {
                        if (!L && this.J != null) {
                            throw new AssertionError();
                        }
                        this.J = sQLiteConnection;
                    }
                    G();
                } else if (this.I.size() >= this.D - 1) {
                    f(sQLiteConnection);
                } else {
                    if (x(sQLiteConnection, remove)) {
                        this.I.add(sQLiteConnection);
                    }
                    G();
                }
            } else {
                throw new IllegalStateException("Cannot perform this operation because the specified connection was not acquired from this pool or has already been released.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes27.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        String f384365a;

        /* renamed from: b, reason: collision with root package name */
        ArrayList<String> f384366b;

        /* renamed from: c, reason: collision with root package name */
        int f384367c;

        /* renamed from: d, reason: collision with root package name */
        int f384368d;

        /* renamed from: e, reason: collision with root package name */
        int f384369e;

        /* renamed from: f, reason: collision with root package name */
        ArrayList<l.a<String>> f384370f;

        /* renamed from: g, reason: collision with root package name */
        ArrayList<l.a<StackTraceElement[]>> f384371g;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f384366b = new ArrayList<>();
            this.f384370f = new ArrayList<>();
            this.f384371g = new ArrayList<>();
        }

        /* synthetic */ b(a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        }
    }
}
