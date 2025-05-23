package com.tencent.luggage.wxa.pc;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f137487a = new c();

    /* renamed from: b, reason: collision with root package name */
    public static final Lazy f137488b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f137489a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Uri invoke() {
            return Uri.parse("content://" + com.tencent.luggage.wxa.o7.a.f136193a + "/PersistentWxaSyncInvalidContactCmd");
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(a.f137489a);
        f137488b = lazy;
    }

    public final ContentResolver a() {
        return z.c().getContentResolver();
    }

    public final Uri b() {
        return (Uri) f137488b.getValue();
    }

    public long a(String str) {
        Cursor query;
        if (str == null || str.length() == 0) {
            return -1L;
        }
        try {
            ContentResolver a16 = a();
            if (a16 != null && (query = ContactsMonitor.query(a16, b(), null, "username=?", new String[]{str}, null)) != null) {
                try {
                    if (!query.isClosed() && query.moveToFirst()) {
                        b bVar = new b();
                        bVar.a(query);
                        long j3 = bVar.f138399d;
                        CloseableKt.closeFinally(query, null);
                        return j3;
                    }
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(query, null);
                } finally {
                }
            }
        } catch (Exception e16) {
            w.b("MicroMsg.WxaSyncCmdPersistentContentResolver", "getInvalidContactTimestampForUsername(" + str + ") get exception:" + e16);
        }
        return -1L;
    }
}
