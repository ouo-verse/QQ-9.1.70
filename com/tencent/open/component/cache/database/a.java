package com.tencent.open.component.cache.database;

import android.content.ContentValues;
import android.database.Cursor;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class a {

    /* compiled from: P */
    /* renamed from: com.tencent.open.component.cache.database.a$a, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public interface InterfaceC9275a<T extends a> {
        T createFromCursor(Cursor cursor);

        String sortOrder();

        b[] structure();

        int version();
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        protected String f341129a;

        /* renamed from: b, reason: collision with root package name */
        protected String f341130b;

        public b(String str, String str2) {
            this.f341129a = str;
            this.f341130b = str2;
        }

        public String a() {
            return this.f341129a;
        }

        public String b() {
            return this.f341130b;
        }
    }

    public abstract void a(ContentValues contentValues);
}
