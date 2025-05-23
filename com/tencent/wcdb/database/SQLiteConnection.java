package com.tencent.wcdb.database;

import android.annotation.SuppressLint;
import android.os.Process;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.wcdb.CursorWindow;
import com.tencent.wcdb.database.l;
import com.tencent.wcdb.support.Log;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class SQLiteConnection {
    static IPatchRedirector $redirector_;

    /* renamed from: s, reason: collision with root package name */
    private static final String[] f384310s;

    /* renamed from: t, reason: collision with root package name */
    private static final byte[] f384311t;

    /* renamed from: u, reason: collision with root package name */
    private static final Pattern f384312u;

    /* renamed from: v, reason: collision with root package name */
    private static final String[] f384313v;

    /* renamed from: w, reason: collision with root package name */
    private static final String[] f384314w;

    /* renamed from: a, reason: collision with root package name */
    private final SQLiteConnectionPool f384315a;

    /* renamed from: b, reason: collision with root package name */
    private final com.tencent.wcdb.database.d f384316b;

    /* renamed from: c, reason: collision with root package name */
    private final int f384317c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f384318d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f384319e;

    /* renamed from: f, reason: collision with root package name */
    private final e f384320f;

    /* renamed from: g, reason: collision with root package name */
    private d f384321g;

    /* renamed from: h, reason: collision with root package name */
    private final c f384322h;

    /* renamed from: i, reason: collision with root package name */
    private Thread f384323i;

    /* renamed from: j, reason: collision with root package name */
    private int f384324j;

    /* renamed from: k, reason: collision with root package name */
    private StackTraceElement[] f384325k;

    /* renamed from: l, reason: collision with root package name */
    private long f384326l;

    /* renamed from: m, reason: collision with root package name */
    private long f384327m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f384328n;

    /* renamed from: o, reason: collision with root package name */
    private byte[] f384329o;

    /* renamed from: p, reason: collision with root package name */
    private SQLiteCipherSpec f384330p;

    /* renamed from: q, reason: collision with root package name */
    private b f384331q;

    /* renamed from: r, reason: collision with root package name */
    private int f384332r;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @SuppressLint({"SimpleDateFormat"})
    /* loaded from: classes27.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: k, reason: collision with root package name */
        private static final SimpleDateFormat f384333k;

        /* renamed from: a, reason: collision with root package name */
        long f384334a;

        /* renamed from: b, reason: collision with root package name */
        long f384335b;

        /* renamed from: c, reason: collision with root package name */
        String f384336c;

        /* renamed from: d, reason: collision with root package name */
        String f384337d;

        /* renamed from: e, reason: collision with root package name */
        ArrayList<Object> f384338e;

        /* renamed from: f, reason: collision with root package name */
        boolean f384339f;

        /* renamed from: g, reason: collision with root package name */
        Exception f384340g;

        /* renamed from: h, reason: collision with root package name */
        int f384341h;

        /* renamed from: i, reason: collision with root package name */
        int f384342i;

        /* renamed from: j, reason: collision with root package name */
        int f384343j;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18610);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 4)) {
                redirector.redirect((short) 4);
            } else {
                f384333k = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        private String b() {
            if (!this.f384339f) {
                return "running";
            }
            if (this.f384340g != null) {
                return "failed";
            }
            return "succeeded";
        }

        public void a(StringBuilder sb5, boolean z16) {
            ArrayList<Object> arrayList;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, sb5, Boolean.valueOf(z16));
                return;
            }
            sb5.append(this.f384336c);
            if (this.f384339f) {
                sb5.append(" took ");
                sb5.append(this.f384335b - this.f384334a);
                sb5.append("ms");
            } else {
                sb5.append(" started ");
                sb5.append(System.currentTimeMillis() - this.f384334a);
                sb5.append("ms ago");
            }
            sb5.append(" - ");
            sb5.append(b());
            if (this.f384337d != null) {
                sb5.append(", sql=\"");
                sb5.append(SQLiteConnection.b0(this.f384337d));
                sb5.append("\"");
            }
            if (this.f384343j > 0) {
                sb5.append(", tid=");
                sb5.append(this.f384343j);
            }
            if (z16 && (arrayList = this.f384338e) != null && arrayList.size() != 0) {
                sb5.append(", bindArgs=[");
                int size = this.f384338e.size();
                for (int i3 = 0; i3 < size; i3++) {
                    Object obj = this.f384338e.get(i3);
                    if (i3 != 0) {
                        sb5.append(", ");
                    }
                    if (obj == null) {
                        sb5.append("null");
                    } else if (obj instanceof byte[]) {
                        sb5.append("<byte[]>");
                    } else if (obj instanceof String) {
                        sb5.append("\"");
                        sb5.append((String) obj);
                        sb5.append("\"");
                    } else {
                        sb5.append(obj);
                    }
                }
                sb5.append("]");
            }
            Exception exc = this.f384340g;
            if (exc != null && exc.getMessage() != null) {
                sb5.append(", exception=\"");
                sb5.append(this.f384340g.getMessage());
                sb5.append("\"");
            }
        }

        /* synthetic */ b(a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<SQLiteConnection> f384348a;

        /* renamed from: b, reason: collision with root package name */
        private d f384349b;

        /* renamed from: c, reason: collision with root package name */
        private String f384350c;

        /* renamed from: d, reason: collision with root package name */
        private long f384351d;

        /* renamed from: e, reason: collision with root package name */
        private int f384352e;

        /* renamed from: f, reason: collision with root package name */
        private int f384353f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f384354g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f384355h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f384356i;

        /* renamed from: j, reason: collision with root package name */
        private b f384357j;

        d(SQLiteConnection sQLiteConnection) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) sQLiteConnection);
            } else {
                this.f384348a = new WeakReference<>(sQLiteConnection);
            }
        }

        public void p(Object[] objArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) objArr);
                return;
            }
            SQLiteConnection sQLiteConnection = this.f384348a.get();
            if (sQLiteConnection != null) {
                sQLiteConnection.m(this, objArr);
            }
        }

        public void q(com.tencent.wcdb.support.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) aVar);
                return;
            }
            SQLiteConnection sQLiteConnection = this.f384348a.get();
            if (sQLiteConnection != null) {
                sQLiteConnection.p(aVar);
            }
        }

        public void r(String str) {
            SQLiteConnection sQLiteConnection;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
            } else {
                if (this.f384357j == null || (sQLiteConnection = this.f384348a.get()) == null) {
                    return;
                }
                if (sQLiteConnection.f384322h.d(this.f384357j.f384341h)) {
                    sQLiteConnection.f384322h.h(this.f384357j.f384341h, str);
                }
                this.f384357j = null;
            }
        }

        public long s() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
            }
            return this.f384351d;
        }

        public void t(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
                return;
            }
            SQLiteConnection sQLiteConnection = this.f384348a.get();
            if (sQLiteConnection != null) {
                sQLiteConnection.K(this, z16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public final class e extends com.tencent.wcdb.support.b<String, d> {
        static IPatchRedirector $redirector_;

        public e(int i3) {
            super(i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SQLiteConnection.this, i3);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.wcdb.support.b
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public void b(boolean z16, String str, d dVar, d dVar2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                dVar.f384355h = false;
                if (!dVar.f384356i) {
                    SQLiteConnection.this.y(dVar);
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, dVar, dVar2);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18660);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
            return;
        }
        f384310s = new String[0];
        f384311t = new byte[0];
        f384312u = Pattern.compile("[\\s]*\\n+[\\s]*");
        f384313v = new String[]{"HMAC_SHA1", "HMAC_SHA256", "HMAC_SHA512"};
        f384314w = new String[]{"PBKDF2_HMAC_SHA1", "PBKDF2_HMAC_SHA256", "PBKDF2_HMAC_SHA512"};
    }

    SQLiteConnection(SQLiteConnectionPool sQLiteConnectionPool, com.tencent.wcdb.database.d dVar, int i3, boolean z16, byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, sQLiteConnectionPool, dVar, Integer.valueOf(i3), Boolean.valueOf(z16), bArr, sQLiteCipherSpec);
            return;
        }
        this.f384322h = new c(this, 0 == true ? 1 : 0);
        this.f384329o = bArr;
        this.f384330p = sQLiteCipherSpec != null ? new SQLiteCipherSpec(sQLiteCipherSpec) : null;
        this.f384315a = sQLiteConnectionPool;
        com.tencent.wcdb.database.d dVar2 = new com.tencent.wcdb.database.d(dVar);
        this.f384316b = dVar2;
        this.f384317c = i3;
        this.f384318d = z16;
        this.f384319e = (dVar.f384395d & 1) != 0;
        this.f384320f = new e(dVar2.f384396e);
    }

    private static boolean A(int i3) {
        if (i3 == 2 || i3 == 1) {
            return true;
        }
        return false;
    }

    private d D(String str, long j3, int i3, int i16, boolean z16) {
        d dVar = this.f384321g;
        if (dVar != null) {
            this.f384321g = dVar.f384349b;
            dVar.f384349b = null;
            dVar.f384355h = false;
        } else {
            dVar = new d(this);
        }
        dVar.f384350c = str;
        dVar.f384351d = j3;
        dVar.f384352e = i3;
        dVar.f384353f = i16;
        dVar.f384354g = z16;
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SQLiteConnection E(SQLiteConnectionPool sQLiteConnectionPool, com.tencent.wcdb.database.d dVar, int i3, boolean z16, byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec) {
        SQLiteConnection sQLiteConnection = new SQLiteConnection(sQLiteConnectionPool, dVar, i3, z16, bArr, sQLiteCipherSpec);
        try {
            sQLiteConnection.F();
            return sQLiteConnection;
        } catch (SQLiteException e16) {
            SQLiteDebug.a(sQLiteConnection);
            sQLiteConnection.q(false);
            throw e16;
        }
    }

    private void F() {
        com.tencent.wcdb.database.d dVar = this.f384316b;
        long nativeOpen = nativeOpen(dVar.f384392a, dVar.f384395d, dVar.f384394c);
        this.f384327m = nativeOpen;
        byte[] bArr = this.f384329o;
        if (bArr != null && bArr.length == 0) {
            this.f384329o = null;
        }
        byte[] bArr2 = this.f384329o;
        if (bArr2 != null) {
            nativeSetKey(nativeOpen, bArr2);
            N();
        }
        T();
        U();
        O();
        X();
        V();
        Q();
        M();
        R();
        long j3 = WCDBInitializationProbe.apiEnv;
        long nativeSQLiteHandle = nativeSQLiteHandle(this.f384327m, true);
        try {
            Iterator<ww4.a> it = this.f384316b.f384403l.iterator();
            while (it.hasNext()) {
                it.next().a(nativeSQLiteHandle, j3);
            }
            nativeSQLiteHandle(this.f384327m, false);
            W();
        } catch (Throwable th5) {
            nativeSQLiteHandle(this.f384327m, false);
            throw th5;
        }
    }

    private void I(d dVar) {
        dVar.f384350c = null;
        dVar.f384349b = this.f384321g;
        this.f384321g = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(d dVar, boolean z16) {
        nativeResetStatement(this.f384327m, dVar.s(), z16);
    }

    private void M() {
        if (!this.f384316b.a() && !this.f384319e) {
            if (this.f384316b.f384399h) {
                nativeSetWalHook(this.f384327m);
            } else if (w("PRAGMA wal_autocheckpoint", null, null) != 100) {
                w("PRAGMA wal_autocheckpoint=100", null, null);
            }
        }
    }

    private void N() {
        SQLiteCipherSpec sQLiteCipherSpec = this.f384330p;
        if (sQLiteCipherSpec != null) {
            if (sQLiteCipherSpec.kdfIteration != 0) {
                s("PRAGMA kdf_iter=" + this.f384330p.kdfIteration, null, null);
            }
            s("PRAGMA cipher_use_hmac=" + this.f384330p.hmacEnabled, null, null);
            if (this.f384330p.hmacAlgorithm != -1) {
                s("PRAGMA cipher_hmac_algorithm=" + f384313v[this.f384330p.hmacAlgorithm], null, null);
            }
            if (this.f384330p.kdfAlgorithm != -1) {
                s("PRAGMA cipher_kdf_algorithm=" + f384314w[this.f384330p.kdfAlgorithm], null, null);
            }
        }
    }

    private void O() {
        long j3;
        if (!this.f384319e) {
            if (this.f384316b.f384398g) {
                j3 = 1;
            } else {
                j3 = 0;
            }
            if (w("PRAGMA foreign_keys", null, null) != j3) {
                s("PRAGMA foreign_keys=" + j3, null, null);
            }
        }
    }

    private void P(String str) {
        String x16 = x("PRAGMA journal_mode", null, null);
        if (!x16.equalsIgnoreCase(str)) {
            try {
                if (x("PRAGMA journal_mode=" + str, null, null).equalsIgnoreCase(str)) {
                    return;
                }
            } catch (SQLiteDatabaseLockedException unused) {
            }
            Log.g("WCDB.SQLiteConnection", "Could not change the database journal mode of '" + this.f384316b.f384393b + "' from '" + x16 + "' to '" + str + "' because the database is locked.  This usually means that there are other open connections to the database which prevents the database from enabling or disabling write-ahead logging mode.  Proceeding without changing the journal mode.");
        }
    }

    private void Q() {
        if (!this.f384316b.a() && !this.f384319e && w("PRAGMA journal_size_limit", null, null) != 524288) {
            w("PRAGMA journal_size_limit=524288", null, null);
        }
    }

    private void R() {
        com.tencent.wcdb.database.d dVar = this.f384316b;
        int i3 = dVar.f384395d | 16;
        dVar.f384395d = i3;
        if ((i3 & 16) != 0) {
            return;
        }
        String locale = dVar.f384397f.toString();
        nativeRegisterLocalizedCollators(this.f384327m, locale);
        if (this.f384319e) {
            return;
        }
        try {
            s("CREATE TABLE IF NOT EXISTS android_metadata (locale TEXT)", null, null);
            String x16 = x("SELECT locale FROM android_metadata UNION SELECT NULL ORDER BY locale DESC LIMIT 1", null, null);
            if (x16 != null && x16.equals(locale)) {
                return;
            }
            s("BEGIN", null, null);
            try {
                s("DELETE FROM android_metadata", null, null);
                s("INSERT INTO android_metadata (locale) VALUES(?)", new Object[]{locale}, null);
                s("REINDEX LOCALIZED", null, null);
                s("COMMIT", null, null);
            } catch (Throwable th5) {
                s("ROLLBACK", null, null);
                throw th5;
            }
        } catch (RuntimeException e16) {
            throw new SQLiteException("Failed to change locale for db '" + this.f384316b.f384393b + "' to '" + locale + "'.", e16);
        }
    }

    private void T() {
        long j3;
        String str;
        int i3;
        if (!this.f384316b.a()) {
            if (this.f384329o != null) {
                SQLiteCipherSpec sQLiteCipherSpec = this.f384330p;
                if (sQLiteCipherSpec == null || (i3 = sQLiteCipherSpec.pageSize) <= 0) {
                    i3 = SQLiteGlobal.f384390a;
                }
                j3 = i3;
                str = "PRAGMA cipher_page_size";
            } else {
                j3 = SQLiteGlobal.f384390a;
                str = "PRAGMA page_size";
            }
            if (w(str, null, null) != j3) {
                s(str + ContainerUtils.KEY_VALUE_DELIMITER + j3, null, null);
            }
        }
    }

    private void U() {
        if (this.f384319e) {
            s("PRAGMA query_only = 1", null, null);
        }
    }

    private void V() {
        s("PRAGMA synchronous=" + this.f384316b.f384400i, null, null);
    }

    private void W() {
        long j3 = this.f384327m;
        com.tencent.wcdb.database.d dVar = this.f384316b;
        nativeSetUpdateNotification(j3, dVar.f384401j, dVar.f384402k);
    }

    private void X() {
        String str;
        if (!this.f384316b.a() && !this.f384319e) {
            if ((this.f384316b.f384395d & 536870912) != 0) {
                str = "WAL";
            } else {
                str = "PERSIST";
            }
            P(str);
        }
    }

    private void Y(d dVar) {
        if (this.f384328n && !dVar.f384354g) {
            throw new SQLiteException("Cannot execute this statement because it might modify the database but the connection is read-only.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b0(String str) {
        return f384312u.matcher(str).replaceAll(" ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(d dVar, Object[] objArr) {
        int i3;
        long j3;
        if (objArr != null) {
            i3 = objArr.length;
        } else {
            i3 = 0;
        }
        if (i3 == dVar.f384352e) {
            if (i3 == 0) {
                return;
            }
            long s16 = dVar.s();
            for (int i16 = 0; i16 < i3; i16++) {
                Object obj = objArr[i16];
                int e16 = com.tencent.wcdb.g.e(obj);
                if (e16 != 0) {
                    if (e16 != 1) {
                        if (e16 != 2) {
                            if (e16 != 4) {
                                if (obj instanceof Boolean) {
                                    long j16 = this.f384327m;
                                    int i17 = i16 + 1;
                                    if (((Boolean) obj).booleanValue()) {
                                        j3 = 1;
                                    } else {
                                        j3 = 0;
                                    }
                                    nativeBindLong(j16, s16, i17, j3);
                                } else {
                                    nativeBindString(this.f384327m, s16, i16 + 1, obj.toString());
                                }
                            } else {
                                nativeBindBlob(this.f384327m, s16, i16 + 1, (byte[]) obj);
                            }
                        } else {
                            nativeBindDouble(this.f384327m, s16, i16 + 1, ((Number) obj).doubleValue());
                        }
                    } else {
                        nativeBindLong(this.f384327m, s16, i16 + 1, ((Number) obj).longValue());
                    }
                } else {
                    nativeBindNull(this.f384327m, s16, i16 + 1);
                }
            }
            return;
        }
        throw new SQLiteBindOrColumnIndexOutOfRangeException("Expected " + dVar.f384352e + " bind arguments but " + i3 + " were provided.");
    }

    private static native void nativeBindBlob(long j3, long j16, int i3, byte[] bArr);

    private static native void nativeBindDouble(long j3, long j16, int i3, double d16);

    private static native void nativeBindLong(long j3, long j16, int i3, long j17);

    private static native void nativeBindNull(long j3, long j16, int i3);

    private static native void nativeBindString(long j3, long j16, int i3, String str);

    private static native void nativeCancel(long j3);

    private static native void nativeClose(long j3);

    private static native void nativeExecute(long j3, long j16);

    private static native int nativeExecuteForChangedRowCount(long j3, long j16);

    private static native long nativeExecuteForCursorWindow(long j3, long j16, long j17, int i3, int i16, boolean z16);

    private static native long nativeExecuteForLastInsertedRowId(long j3, long j16);

    private static native long nativeExecuteForLong(long j3, long j16);

    private static native String nativeExecuteForString(long j3, long j16);

    private static native void nativeFinalizeStatement(long j3, long j16);

    private static native int nativeGetColumnCount(long j3, long j16);

    private static native String nativeGetColumnName(long j3, long j16, int i3);

    private static native int nativeGetDbLookaside(long j3);

    private static native int nativeGetParameterCount(long j3, long j16);

    private static native boolean nativeIsReadOnly(long j3, long j16);

    private native long nativeOpen(String str, int i3, String str2);

    private static native long nativePrepareStatement(long j3, String str);

    private static native void nativeRegisterCustomFunction(long j3, SQLiteCustomFunction sQLiteCustomFunction);

    private static native void nativeRegisterLocalizedCollators(long j3, String str);

    private static native void nativeResetCancel(long j3, boolean z16);

    private static native void nativeResetStatement(long j3, long j16, boolean z16);

    private static native long nativeSQLiteHandle(long j3, boolean z16);

    private static native void nativeSetKey(long j3, byte[] bArr);

    private static native void nativeSetUpdateNotification(long j3, boolean z16, boolean z17);

    private static native void nativeSetWalHook(long j3);

    private static native long nativeWalCheckpoint(long j3, String str);

    private void notifyChange(String str, String str2, long[] jArr, long[] jArr2, long[] jArr3) {
        this.f384315a.p(str, str2, jArr, jArr2, jArr3);
    }

    private void notifyCheckpoint(String str, int i3) {
        this.f384315a.q(str, i3);
    }

    private void q(boolean z16) {
        if (this.f384327m != 0) {
            int i3 = this.f384322h.a("close", null, null).f384341h;
            try {
                this.f384320f.c();
                nativeClose(this.f384327m);
                this.f384327m = 0L;
            } finally {
                this.f384322h.c(i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(d dVar) {
        nativeFinalizeStatement(this.f384327m, dVar.s());
        I(dVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean B(String str) {
        if (this.f384320f.d(str) != null) {
            return true;
        }
        return false;
    }

    public boolean C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.f384318d;
    }

    public void G(String str, k kVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) kVar);
            return;
        }
        if (str != null) {
            b a16 = this.f384322h.a("prepare", str, null);
            int i3 = a16.f384341h;
            try {
                try {
                    d j3 = j(str);
                    a16.f384342i = j3.f384353f;
                    if (kVar != null) {
                        try {
                            kVar.f384427a = j3.f384352e;
                            kVar.f384429c = j3.f384354g;
                            int nativeGetColumnCount = nativeGetColumnCount(this.f384327m, j3.s());
                            if (nativeGetColumnCount == 0) {
                                kVar.f384428b = f384310s;
                            } else {
                                kVar.f384428b = new String[nativeGetColumnCount];
                                for (int i16 = 0; i16 < nativeGetColumnCount; i16++) {
                                    kVar.f384428b[i16] = nativeGetColumnName(this.f384327m, j3.s(), i16);
                                }
                            }
                        } finally {
                            J(j3);
                        }
                    }
                    return;
                } catch (RuntimeException e16) {
                    this.f384322h.f(i3, e16);
                    throw e16;
                }
            } finally {
                this.f384322h.c(i3);
            }
        }
        throw new IllegalArgumentException("sql must not be null.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(com.tencent.wcdb.database.d dVar) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26 = false;
        this.f384328n = false;
        long j3 = WCDBInitializationProbe.apiEnv;
        long nativeSQLiteHandle = nativeSQLiteHandle(this.f384327m, true);
        try {
            Iterator<ww4.a> it = dVar.f384403l.iterator();
            while (it.hasNext()) {
                ww4.a next = it.next();
                if (!this.f384316b.f384403l.contains(next)) {
                    next.a(nativeSQLiteHandle, j3);
                }
            }
            nativeSQLiteHandle(this.f384327m, false);
            int i3 = dVar.f384395d;
            com.tencent.wcdb.database.d dVar2 = this.f384316b;
            if (((i3 ^ dVar2.f384395d) & 536870912) != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (dVar.f384398g != dVar2.f384398g) {
                z17 = true;
            } else {
                z17 = false;
            }
            boolean z27 = !dVar.f384397f.equals(dVar2.f384397f);
            boolean z28 = dVar.f384399h;
            com.tencent.wcdb.database.d dVar3 = this.f384316b;
            if (z28 != dVar3.f384399h) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (dVar.f384400i != dVar3.f384400i) {
                z19 = true;
            } else {
                z19 = false;
            }
            if (dVar.f384401j != dVar3.f384401j || dVar.f384402k != dVar3.f384402k) {
                z26 = true;
            }
            dVar3.b(dVar);
            this.f384320f.g(dVar.f384396e);
            if (z17) {
                O();
            }
            if (z16) {
                X();
            }
            if (z19) {
                V();
            }
            if (z18) {
                M();
            }
            if (z27) {
                R();
            }
            if (z26) {
                W();
            }
        } catch (Throwable th5) {
            nativeSQLiteHandle(this.f384327m, false);
            throw th5;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(d dVar) {
        dVar.f384356i = false;
        if (dVar.f384355h) {
            try {
                K(dVar, true);
                return;
            } catch (SQLiteException unused) {
                this.f384320f.f(dVar.f384350c);
                return;
            }
        }
        y(dVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L(boolean z16, boolean z17) {
        if (z16) {
            this.f384323i = Thread.currentThread();
            this.f384324j = Process.myTid();
            if (z17) {
                this.f384325k = this.f384323i.getStackTrace();
                this.f384326l = System.currentTimeMillis();
                return;
            } else {
                this.f384325k = null;
                this.f384326l = 0L;
                return;
            }
        }
        this.f384323i = null;
        this.f384324j = 0;
        this.f384325k = null;
        this.f384326l = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S(boolean z16) {
        this.f384328n = z16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l.a<String> Z() {
        return this.f384322h.k();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l.a<StackTraceElement[]> a0() {
        StackTraceElement[] stackTraceElementArr = this.f384325k;
        if (stackTraceElementArr == null) {
            return null;
        }
        return new l.a<>(stackTraceElementArr, this.f384326l, this.f384324j);
    }

    protected void finalize() throws Throwable {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        try {
            SQLiteConnectionPool sQLiteConnectionPool = this.f384315a;
            if (sQLiteConnectionPool != null && this.f384327m != 0) {
                sQLiteConnectionPool.s();
            }
            q(true);
        } finally {
            super.finalize();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d j(String str) {
        boolean z16;
        d d16 = this.f384320f.d(str);
        if (d16 != null) {
            if (!d16.f384356i) {
                d16.f384356i = true;
                return d16;
            }
            z16 = true;
        } else {
            z16 = false;
        }
        long nativePrepareStatement = nativePrepareStatement(this.f384327m, str);
        try {
            int nativeGetParameterCount = nativeGetParameterCount(this.f384327m, nativePrepareStatement);
            int d17 = com.tencent.wcdb.g.d(str);
            d16 = D(str, nativePrepareStatement, nativeGetParameterCount, d17, nativeIsReadOnly(this.f384327m, nativePrepareStatement));
            if (!z16 && A(d17)) {
                this.f384320f.e(str, d16);
                d16.f384355h = true;
            }
            d16.f384356i = true;
            return d16;
        } catch (RuntimeException e16) {
            if (d16 == null || !d16.f384355h) {
                nativeFinalizeStatement(this.f384327m, nativePrepareStatement);
            }
            throw e16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n() {
        q(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String o() {
        return this.f384322h.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(Exception exc) {
        int i3 = this.f384332r - 1;
        this.f384332r = i3;
        if (i3 == 0 && this.f384331q != null) {
            nativeSQLiteHandle(this.f384327m, false);
            if (exc == null) {
                this.f384322h.d(this.f384331q.f384341h);
            } else {
                this.f384322h.f(this.f384331q.f384341h, exc);
            }
            this.f384331q = null;
        }
    }

    public void s(String str, Object[] objArr, com.tencent.wcdb.support.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, objArr, aVar);
            return;
        }
        if (str != null) {
            b a16 = this.f384322h.a("execute", str, objArr);
            int i3 = a16.f384341h;
            try {
                try {
                    d j3 = j(str);
                    a16.f384342i = j3.f384353f;
                    try {
                        Y(j3);
                        m(j3, objArr);
                        k(j3);
                        l(aVar);
                        try {
                            nativeExecute(this.f384327m, j3.s());
                            return;
                        } finally {
                            p(aVar);
                        }
                    } finally {
                        J(j3);
                    }
                } catch (RuntimeException e16) {
                    this.f384322h.f(i3, e16);
                    throw e16;
                }
            } finally {
                this.f384322h.c(i3);
            }
        }
        throw new IllegalArgumentException("sql must not be null.");
    }

    public int t(String str, Object[] objArr, com.tencent.wcdb.support.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, this, str, objArr, aVar)).intValue();
        }
        if (str != null) {
            b a16 = this.f384322h.a("executeForChangedRowCount", str, objArr);
            int i3 = a16.f384341h;
            try {
                try {
                    d j3 = j(str);
                    a16.f384342i = j3.f384353f;
                    try {
                        Y(j3);
                        m(j3, objArr);
                        k(j3);
                        l(aVar);
                        try {
                            int nativeExecuteForChangedRowCount = nativeExecuteForChangedRowCount(this.f384327m, j3.s());
                            if (this.f384322h.d(i3)) {
                                this.f384322h.h(i3, "changedRows=" + nativeExecuteForChangedRowCount);
                            }
                            return nativeExecuteForChangedRowCount;
                        } finally {
                            p(aVar);
                        }
                    } finally {
                        J(j3);
                    }
                } catch (RuntimeException e16) {
                    this.f384322h.f(i3, e16);
                    throw e16;
                }
            } catch (Throwable th5) {
                if (this.f384322h.d(i3)) {
                    this.f384322h.h(i3, "changedRows=0");
                }
                throw th5;
            }
        }
        throw new IllegalArgumentException("sql must not be null.");
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return "SQLiteConnection: " + this.f384316b.f384392a + " (" + this.f384317c + ")";
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x01bc A[Catch: all -> 0x01e9, TryCatch #2 {all -> 0x01e9, blocks: (B:12:0x0061, B:37:0x00bd, B:39:0x00c5, B:50:0x01b4, B:52:0x01bc, B:53:0x01e8), top: B:11:0x0061 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int u(String str, Object[] objArr, CursorWindow cursorWindow, int i3, int i16, boolean z16, com.tencent.wcdb.support.a aVar) {
        String str2;
        String str3;
        String str4;
        int i17;
        int i18;
        String str5;
        String str6;
        int i19;
        int i26;
        int i27;
        d dVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, this, str, objArr, cursorWindow, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), aVar)).intValue();
        }
        if (str != null) {
            if (cursorWindow != null) {
                cursorWindow.a();
                try {
                    b a16 = this.f384322h.a("executeForCursorWindow", str, objArr);
                    int i28 = a16.f384341h;
                    int i29 = -1;
                    try {
                        d j3 = j(str);
                        a16.f384342i = j3.f384353f;
                        try {
                            Y(j3);
                            m(j3, objArr);
                            k(j3);
                            l(aVar);
                            try {
                                try {
                                    dVar = j3;
                                    i18 = i28;
                                } catch (Throwable th5) {
                                    th = th5;
                                    str2 = "', startPos=";
                                    str5 = ", actualPos=";
                                    str3 = ", filledRows=";
                                    i17 = i3;
                                    str6 = ", countedRows=";
                                    i18 = i28;
                                    str4 = "window='";
                                    dVar = j3;
                                }
                                try {
                                    long nativeExecuteForCursorWindow = nativeExecuteForCursorWindow(this.f384327m, j3.s(), cursorWindow.f384296e, i3, i16, z16);
                                    i27 = (int) (nativeExecuteForCursorWindow >> 32);
                                    i19 = (int) nativeExecuteForCursorWindow;
                                    try {
                                        i26 = cursorWindow.s();
                                    } catch (Throwable th6) {
                                        th = th6;
                                        i17 = i3;
                                        str4 = "window='";
                                        str6 = ", countedRows=";
                                        str2 = "', startPos=";
                                        str5 = ", actualPos=";
                                        str3 = ", filledRows=";
                                        i26 = -1;
                                    }
                                    try {
                                        cursorWindow.x(i27);
                                        try {
                                            p(aVar);
                                            try {
                                                J(dVar);
                                                if (this.f384322h.d(i18)) {
                                                    this.f384322h.h(i18, "window='" + cursorWindow + "', startPos=" + i3 + ", actualPos=" + i27 + ", filledRows=" + i26 + ", countedRows=" + i19);
                                                }
                                                return i19;
                                            } catch (RuntimeException e16) {
                                                e = e16;
                                                i17 = i3;
                                                str4 = "window='";
                                                str6 = ", countedRows=";
                                                str2 = "', startPos=";
                                                str5 = ", actualPos=";
                                                str3 = ", filledRows=";
                                                i29 = i27;
                                                this.f384322h.f(i18, e);
                                                throw e;
                                            } catch (Throwable th7) {
                                                th = th7;
                                                i17 = i3;
                                                str4 = "window='";
                                                str6 = ", countedRows=";
                                                str2 = "', startPos=";
                                                str5 = ", actualPos=";
                                                str3 = ", filledRows=";
                                                if (this.f384322h.d(i18)) {
                                                }
                                                throw th;
                                            }
                                        } catch (Throwable th8) {
                                            th = th8;
                                            i17 = i3;
                                            str4 = "window='";
                                            str6 = ", countedRows=";
                                            str2 = "', startPos=";
                                            str5 = ", actualPos=";
                                            str3 = ", filledRows=";
                                            i29 = i27;
                                            try {
                                                try {
                                                    J(dVar);
                                                    throw th;
                                                } catch (Throwable th9) {
                                                    th = th9;
                                                    i27 = i29;
                                                    if (this.f384322h.d(i18)) {
                                                        this.f384322h.h(i18, str4 + cursorWindow + str2 + i17 + str5 + i27 + str3 + i26 + str6 + i19);
                                                    }
                                                    throw th;
                                                }
                                            } catch (RuntimeException e17) {
                                                e = e17;
                                                this.f384322h.f(i18, e);
                                                throw e;
                                            }
                                        }
                                    } catch (Throwable th10) {
                                        th = th10;
                                        i17 = i3;
                                        str4 = "window='";
                                        str6 = ", countedRows=";
                                        str2 = "', startPos=";
                                        str5 = ", actualPos=";
                                        str3 = ", filledRows=";
                                        i29 = i27;
                                        try {
                                            p(aVar);
                                            throw th;
                                        } catch (Throwable th11) {
                                            th = th11;
                                            J(dVar);
                                            throw th;
                                        }
                                    }
                                } catch (Throwable th12) {
                                    th = th12;
                                    i17 = i3;
                                    str4 = "window='";
                                    str6 = ", countedRows=";
                                    str2 = "', startPos=";
                                    str5 = ", actualPos=";
                                    str3 = ", filledRows=";
                                    i19 = -1;
                                    i26 = -1;
                                    p(aVar);
                                    throw th;
                                }
                            } catch (Throwable th13) {
                                th = th13;
                                dVar = j3;
                                str2 = "', startPos=";
                                str3 = ", filledRows=";
                                str4 = "window='";
                                i17 = i3;
                                i18 = i28;
                                str5 = ", actualPos=";
                                str6 = ", countedRows=";
                            }
                        } catch (Throwable th14) {
                            th = th14;
                            dVar = j3;
                            str2 = "', startPos=";
                            str3 = ", filledRows=";
                            str4 = "window='";
                            i17 = i3;
                            i18 = i28;
                            str5 = ", actualPos=";
                            str6 = ", countedRows=";
                            i19 = -1;
                            i26 = -1;
                        }
                    } catch (RuntimeException e18) {
                        e = e18;
                        str2 = "', startPos=";
                        str3 = ", filledRows=";
                        str4 = "window='";
                        i17 = i3;
                        i18 = i28;
                        str5 = ", actualPos=";
                        str6 = ", countedRows=";
                        i19 = -1;
                        i26 = -1;
                    } catch (Throwable th15) {
                        th = th15;
                        str2 = "', startPos=";
                        str3 = ", filledRows=";
                        str4 = "window='";
                        i17 = i3;
                        i18 = i28;
                        str5 = ", actualPos=";
                        str6 = ", countedRows=";
                        i19 = -1;
                        i26 = -1;
                        i27 = -1;
                    }
                } finally {
                    cursorWindow.g();
                }
            } else {
                throw new IllegalArgumentException("window must not be null.");
            }
        } else {
            throw new IllegalArgumentException("sql must not be null.");
        }
    }

    public long v(String str, Object[] objArr, com.tencent.wcdb.support.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Long) iPatchRedirector.redirect((short) 10, this, str, objArr, aVar)).longValue();
        }
        if (str != null) {
            b a16 = this.f384322h.a("executeForLastInsertedRowId", str, objArr);
            int i3 = a16.f384341h;
            try {
                try {
                    d j3 = j(str);
                    a16.f384342i = j3.f384353f;
                    try {
                        Y(j3);
                        m(j3, objArr);
                        k(j3);
                        l(aVar);
                        try {
                            return nativeExecuteForLastInsertedRowId(this.f384327m, j3.s());
                        } finally {
                            p(aVar);
                        }
                    } finally {
                        J(j3);
                    }
                } catch (RuntimeException e16) {
                    this.f384322h.f(i3, e16);
                    throw e16;
                }
            } finally {
                this.f384322h.c(i3);
            }
        }
        throw new IllegalArgumentException("sql must not be null.");
    }

    public long w(String str, Object[] objArr, com.tencent.wcdb.support.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, this, str, objArr, aVar)).longValue();
        }
        if (str != null) {
            b a16 = this.f384322h.a("executeForLong", str, objArr);
            int i3 = a16.f384341h;
            try {
                try {
                    d j3 = j(str);
                    a16.f384342i = j3.f384353f;
                    try {
                        Y(j3);
                        m(j3, objArr);
                        k(j3);
                        l(aVar);
                        try {
                            return nativeExecuteForLong(this.f384327m, j3.s());
                        } finally {
                            p(aVar);
                        }
                    } finally {
                        J(j3);
                    }
                } catch (RuntimeException e16) {
                    this.f384322h.f(i3, e16);
                    throw e16;
                }
            } finally {
                this.f384322h.c(i3);
            }
        }
        throw new IllegalArgumentException("sql must not be null.");
    }

    public String x(String str, Object[] objArr, com.tencent.wcdb.support.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, this, str, objArr, aVar);
        }
        if (str != null) {
            b a16 = this.f384322h.a("executeForString", str, objArr);
            int i3 = a16.f384341h;
            try {
                try {
                    d j3 = j(str);
                    a16.f384342i = j3.f384353f;
                    try {
                        Y(j3);
                        m(j3, objArr);
                        k(j3);
                        l(aVar);
                        try {
                            return nativeExecuteForString(this.f384327m, j3.s());
                        } finally {
                            p(aVar);
                        }
                    } finally {
                        J(j3);
                    }
                } catch (RuntimeException e16) {
                    this.f384322h.f(i3, e16);
                    throw e16;
                }
            } finally {
                this.f384322h.c(i3);
            }
        }
        throw new IllegalArgumentException("sql must not be null.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long z(String str) {
        if (this.f384327m == 0) {
            return 0L;
        }
        if (str != null && this.f384331q == null) {
            b a16 = this.f384322h.a(str, null, null);
            this.f384331q = a16;
            a16.f384342i = 99;
        }
        this.f384332r++;
        return nativeSQLiteHandle(this.f384327m, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public final class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final b[] f384344a;

        /* renamed from: b, reason: collision with root package name */
        private int f384345b;

        /* renamed from: c, reason: collision with root package name */
        private int f384346c;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.f384344a = new b[20];
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SQLiteConnection.this);
            }
        }

        private boolean e(b bVar) {
            if (bVar != null) {
                bVar.f384335b = System.currentTimeMillis();
                bVar.f384339f = true;
                Exception exc = bVar.f384340g;
                if (exc != null && exc.getMessage() != null) {
                    return true;
                }
                return SQLiteDebug.c(bVar.f384335b - bVar.f384334a);
            }
            return false;
        }

        private b g(int i3) {
            b bVar = this.f384344a[i3 & 255];
            if (bVar.f384341h != i3) {
                return null;
            }
            return bVar;
        }

        private void i(b bVar, String str) {
            StringBuilder sb5 = new StringBuilder();
            bVar.a(sb5, false);
            if (str != null) {
                sb5.append(", ");
                sb5.append(str);
            }
            Log.c("WCDB.SQLiteConnection", sb5.toString());
        }

        private int j(int i3) {
            int i16 = this.f384346c;
            this.f384346c = i16 + 1;
            return i3 | (i16 << 8);
        }

        b a(String str, String str2, Object[] objArr) {
            b bVar;
            synchronized (this.f384344a) {
                int i3 = (this.f384345b + 1) % 20;
                bVar = this.f384344a[i3];
                a aVar = null;
                if (bVar == null) {
                    bVar = new b(aVar);
                    this.f384344a[i3] = bVar;
                } else {
                    bVar.f384339f = false;
                    bVar.f384340g = null;
                    ArrayList<Object> arrayList = bVar.f384338e;
                    if (arrayList != null) {
                        arrayList.clear();
                    }
                }
                bVar.f384334a = System.currentTimeMillis();
                bVar.f384336c = str;
                bVar.f384337d = str2;
                if (objArr != null) {
                    ArrayList<Object> arrayList2 = bVar.f384338e;
                    if (arrayList2 == null) {
                        bVar.f384338e = new ArrayList<>();
                    } else {
                        arrayList2.clear();
                    }
                    for (Object obj : objArr) {
                        if (obj != null && (obj instanceof byte[])) {
                            bVar.f384338e.add(SQLiteConnection.f384311t);
                        } else {
                            bVar.f384338e.add(obj);
                        }
                    }
                }
                bVar.f384341h = j(i3);
                bVar.f384343j = SQLiteConnection.this.f384324j;
                this.f384345b = i3;
            }
            return bVar;
        }

        String b() {
            synchronized (this.f384344a) {
                b bVar = this.f384344a[this.f384345b];
                if (bVar != null && !bVar.f384339f) {
                    StringBuilder sb5 = new StringBuilder();
                    bVar.a(sb5, false);
                    return sb5.toString();
                }
                return null;
            }
        }

        void c(int i3) {
            String str;
            String str2;
            int i16;
            long j3;
            synchronized (this.f384344a) {
                b g16 = g(i3);
                if (e(g16)) {
                    i(g16, null);
                }
                str = g16.f384337d;
                str2 = g16.f384336c;
                i16 = g16.f384342i;
                j3 = g16.f384335b - g16.f384334a;
            }
            if (!"prepare".equals(str2)) {
                SQLiteConnection.this.f384315a.C(str, i16, j3);
            }
        }

        boolean d(int i3) {
            synchronized (this.f384344a) {
                b g16 = g(i3);
                if (g16 == null) {
                    return false;
                }
                boolean e16 = e(g16);
                String str = g16.f384337d;
                String str2 = g16.f384336c;
                int i16 = g16.f384342i;
                long j3 = g16.f384335b - g16.f384334a;
                if (!"prepare".equals(str2)) {
                    SQLiteConnection.this.f384315a.C(str, i16, j3);
                }
                return e16;
            }
        }

        void f(int i3, Exception exc) {
            synchronized (this.f384344a) {
                b g16 = g(i3);
                if (g16 != null) {
                    g16.f384340g = exc;
                }
            }
        }

        void h(int i3, String str) {
            synchronized (this.f384344a) {
                b g16 = g(i3);
                if (g16 != null) {
                    i(g16, str);
                }
            }
        }

        l.a<String> k() {
            synchronized (this.f384344a) {
                b bVar = this.f384344a[this.f384345b];
                if (bVar != null && !bVar.f384339f) {
                    return new l.a<>(bVar.f384337d, bVar.f384334a, bVar.f384343j);
                }
                return null;
            }
        }

        /* synthetic */ c(SQLiteConnection sQLiteConnection, a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) sQLiteConnection, (Object) aVar);
        }
    }

    private void k(d dVar) {
    }

    private void l(com.tencent.wcdb.support.a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(com.tencent.wcdb.support.a aVar) {
    }
}
