package com.tencent.wcdb;

import android.util.Pair;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.database.l;
import com.tencent.wcdb.support.Log;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class h implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f384436b;

    /* renamed from: a, reason: collision with root package name */
    private final boolean f384437a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15952);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f384436b = new String[]{"", "-journal", "-wal", ".sm", ".bak", "-vfslog", "-vfslo1"};
        }
    }

    public h(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        } else {
            this.f384437a = z16;
        }
    }

    private void b(String str) {
        if (!str.equalsIgnoreCase(":memory:") && str.trim().length() != 0) {
            Log.a("WCDB.DefaultDatabaseErrorHandler", "Remove database file: " + str);
            int i3 = 0;
            if (!this.f384437a) {
                File file = new File(str);
                File file2 = new File(file.getParentFile(), "corrupted");
                if (!file2.mkdirs()) {
                    Log.a("WCDB.DefaultDatabaseErrorHandler", "Could not create directory for corrupted database. Corruption backup may be unavailable.");
                }
                String str2 = file2.getPath() + "/" + file.getName();
                String[] strArr = f384436b;
                int length = strArr.length;
                while (i3 < length) {
                    String str3 = strArr[i3];
                    d(str + str3, str2 + str3);
                    i3++;
                }
                return;
            }
            String[] strArr2 = f384436b;
            int length2 = strArr2.length;
            while (i3 < length2) {
                c(str + strArr2[i3]);
                i3++;
            }
        }
    }

    private static boolean c(String str) {
        return new File(str).delete();
    }

    private static boolean d(String str, String str2) {
        File file = new File(str);
        boolean renameTo = file.renameTo(new File(str2));
        if (!renameTo) {
            file.delete();
        }
        return renameTo;
    }

    @Override // com.tencent.wcdb.f
    public void a(SQLiteDatabase sQLiteDatabase) {
        List<Pair<String, String>> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) sQLiteDatabase);
            return;
        }
        Log.a("WCDB.DefaultDatabaseErrorHandler", "Corruption reported by sqlite on database: " + sQLiteDatabase.getPath());
        if (!sQLiteDatabase.isOpen()) {
            b(sQLiteDatabase.getPath());
            return;
        }
        try {
            list = sQLiteDatabase.getAttachedDbs();
        } catch (SQLiteException unused) {
            list = null;
        }
        l t16 = sQLiteDatabase.t();
        if (t16 != null) {
            t16.a(sQLiteDatabase);
        }
        try {
            sQLiteDatabase.close();
            if (list != null) {
                Iterator<Pair<String, String>> it = list.iterator();
                while (it.hasNext()) {
                    b((String) it.next().second);
                }
                return;
            }
        } catch (SQLiteException unused2) {
            if (list != null) {
                Iterator<Pair<String, String>> it5 = list.iterator();
                while (it5.hasNext()) {
                    b((String) it5.next().second);
                }
                return;
            }
        } catch (Throwable th5) {
            if (list != null) {
                Iterator<Pair<String, String>> it6 = list.iterator();
                while (it6.hasNext()) {
                    b((String) it6.next().second);
                }
            } else {
                b(sQLiteDatabase.getPath());
            }
            throw th5;
        }
        b(sQLiteDatabase.getPath());
    }
}
