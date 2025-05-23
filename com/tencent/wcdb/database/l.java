package com.tencent.wcdb.database;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface l {

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class a<T> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final T f384430a;

        /* renamed from: b, reason: collision with root package name */
        public final long f384431b;

        /* renamed from: c, reason: collision with root package name */
        public final int f384432c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(T t16, long j3, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, t16, Long.valueOf(j3), Integer.valueOf(i3));
                return;
            }
            this.f384430a = t16;
            this.f384431b = j3;
            this.f384432c = i3;
        }
    }

    void a(SQLiteDatabase sQLiteDatabase);

    void b(SQLiteDatabase sQLiteDatabase, String str, long j3, boolean z16);

    void c(SQLiteDatabase sQLiteDatabase, String str, long j3, boolean z16, List<a<String>> list, List<a<StackTraceElement[]>> list2);

    void d(SQLiteDatabase sQLiteDatabase, String str, int i3, long j3);
}
