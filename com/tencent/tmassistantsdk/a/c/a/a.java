package com.tencent.tmassistantsdk.a.c.a;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a extends com.tencent.tmassistant.common.a.a {

    /* renamed from: a, reason: collision with root package name */
    protected static a f380550a;

    public static synchronized a e() {
        a aVar;
        synchronized (a.class) {
            if (f380550a == null) {
                f380550a = new a();
            }
            aVar = f380550a;
        }
        return aVar;
    }

    @Override // com.tencent.tmassistant.common.a.a
    protected String a() {
        return "CREATE TABLE if not exists BusinessInfoLogTable( _id INTEGER PRIMARY KEY AUTOINCREMENT, logData BLOB );";
    }

    @Override // com.tencent.tmassistant.common.a.a
    protected String c() {
        return "INSERT INTO BusinessInfoLogTable logData = ?";
    }

    @Override // com.tencent.tmassistant.common.a.a
    protected String d() {
        return "BusinessInfoLogTable";
    }

    @Override // com.tencent.tmassistant.common.a.a
    protected String[] a(int i3) {
        if (i3 > 1) {
            return new String[]{a()};
        }
        return null;
    }
}
