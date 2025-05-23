package com.tencent.wcdb.database;

import android.annotation.SuppressLint;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.wcdb.support.Log;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class SQLiteDebug {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static volatile int f384388a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile ArrayList<IOTraceStats> f384389b;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class DbStats {
        static IPatchRedirector $redirector_;
        public String cache;
        public String dbName;
        public long dbSize;
        public int lookaside;
        public long pageSize;

        public DbStats(String str, long j3, long j16, int i3, int i16, int i17, int i18) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
                return;
            }
            this.dbName = str;
            this.pageSize = j16 / 1024;
            this.dbSize = (j3 * j16) / 1024;
            this.lookaside = i3;
            this.cache = i16 + "/" + i17 + "/" + i18;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class IOTraceStats {
        static IPatchRedirector $redirector_;
        public String dbName;
        public String journalMode;
        public long lastJournalReadOffset;
        public byte[] lastJournalReadPage;
        public long lastJournalWriteOffset;
        public byte[] lastJournalWritePage;
        public long lastReadOffset;
        public byte[] lastReadPage;
        public long lastWriteOffset;
        public byte[] lastWritePage;
        public long pageCount;
        public long pageSize;
        public String path;

        public IOTraceStats() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @SuppressLint({"DefaultLocale"})
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return String.format("[%s | %s] pageSize: %d, pageCount: %d, journal: %s, lastRead: %d, lastWrite: %d, lastJournalRead: %d, lastJournalWrite: %d", this.dbName, this.path, Long.valueOf(this.pageSize), Long.valueOf(this.pageCount), this.journalMode, Long.valueOf(this.lastReadOffset), Long.valueOf(this.lastWriteOffset), Long.valueOf(this.lastJournalReadOffset), Long.valueOf(this.lastJournalWriteOffset));
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class PagerStats {
        static IPatchRedirector $redirector_;
        public ArrayList<DbStats> dbStats;
        public int largestMemAlloc;
        public int memoryUsed;
        public int pageCacheOverflow;

        public PagerStats() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20715);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            SQLiteGlobal.a();
        }
    }

    SQLiteDebug() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(SQLiteConnection sQLiteConnection) {
        try {
            f384388a = nativeGetLastErrorLine();
            ArrayList<IOTraceStats> arrayList = new ArrayList<>();
            long z16 = sQLiteConnection.z(null);
            if (z16 != 0) {
                nativeGetIOTraceStats(z16, arrayList);
                sQLiteConnection.r(null);
            }
            f384389b = arrayList;
        } catch (RuntimeException e16) {
            Log.a("WCDB.SQLiteDebug", "Cannot collect I/O trace statistics: " + e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(SQLiteDatabase sQLiteDatabase) {
        try {
            f384388a = nativeGetLastErrorLine();
            ArrayList<IOTraceStats> arrayList = new ArrayList<>();
            long j3 = sQLiteDatabase.j("collectIoStat", false, false);
            if (j3 != 0) {
                nativeGetIOTraceStats(j3, arrayList);
            }
            sQLiteDatabase.a0(j3, null);
            f384389b = arrayList;
        } catch (RuntimeException e16) {
            Log.a("WCDB.SQLiteDebug", "Cannot collect I/O trace statistics: " + e16.getMessage());
        }
    }

    public static final boolean c(long j3) {
        if (j3 > 300) {
            return true;
        }
        return false;
    }

    private static native void nativeGetIOTraceStats(long j3, ArrayList<IOTraceStats> arrayList);

    private static native int nativeGetLastErrorLine();

    private static native void nativeGetPagerStats(PagerStats pagerStats);

    private static native void nativeSetIOTraceFlags(int i3);
}
