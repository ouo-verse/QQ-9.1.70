package com.tencent.luggage.wxa.ii;

import android.database.Cursor;
import android.net.Uri;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public static final v f130593a = new v();

    /* renamed from: b, reason: collision with root package name */
    public static final Lazy f130594b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f130595a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Uri invoke() {
            return Uri.parse("content://" + com.tencent.luggage.wxa.o7.a.f136193a + "/PluginDevLaunchInfo");
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) a.f130595a);
        f130594b = lazy;
    }

    public final Uri a() {
        return (Uri) f130594b.getValue();
    }

    public boolean a(String str, String str2, long j3) {
        if (str == null || str2 == null) {
            return false;
        }
        u uVar = new u();
        uVar.f138415b = str;
        uVar.f138417d = str2;
        uVar.f138419f = j3;
        return com.tencent.luggage.wxa.tn.z.c().getContentResolver().insert(a(), uVar.a()) != null;
    }

    public long a(String str, String str2) {
        Cursor query;
        if (str != null && str2 != null && (query = ContactsMonitor.query(com.tencent.luggage.wxa.tn.z.c().getContentResolver(), a(), new String[]{"devKey"}, "appId=? AND versionDesc=?", new String[]{str, str2}, null)) != null) {
            try {
                if (!query.isClosed() && query.moveToFirst()) {
                    long j3 = query.getLong(0);
                    CloseableKt.closeFinally(query, null);
                    return j3;
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(query, null);
            } finally {
            }
        }
        return 0L;
    }
}
