package com.tencent.luggage.wxa.ii;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.luggage.wxa.hn.z0;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    public static final z f130599a = new z();

    /* renamed from: b, reason: collision with root package name */
    public static final Lazy f130600b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f130601a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Uri invoke() {
            return Uri.parse("content://" + com.tencent.luggage.wxa.o7.a.f136193a + "/WxaJsApiPluginInfo");
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(a.f130601a);
        f130600b = lazy;
    }

    public final Uri a() {
        return (Uri) f130600b.getValue();
    }

    public boolean a(String str, z0 z0Var) {
        if ((str == null || str.length() == 0) || z0Var == null) {
            return false;
        }
        ContentResolver contentResolver = com.tencent.luggage.wxa.tn.z.c().getContentResolver();
        Uri a16 = a();
        r rVar = new r();
        rVar.f138512b = str;
        rVar.f138514d = z0Var;
        Unit unit = Unit.INSTANCE;
        return contentResolver.insert(a16, rVar.a()) != null;
    }

    public z0 a(String str) {
        Cursor query;
        if (!(str == null || str.length() == 0) && (query = ContactsMonitor.query(com.tencent.luggage.wxa.tn.z.c().getContentResolver(), a(), new String[]{"permissionProtoBlob"}, "appId=?", new String[]{str}, null)) != null) {
            try {
                if (query.moveToFirst()) {
                    r rVar = new r();
                    rVar.a(query);
                    z0 z0Var = rVar.f138514d;
                    CloseableKt.closeFinally(query, null);
                    return z0Var;
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(query, null);
            } finally {
            }
        }
        return null;
    }
}
