package com.tencent.av.foldable;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c extends com.tencent.av.foldable.a {

    /* renamed from: f, reason: collision with root package name */
    private final String f73739f;

    /* renamed from: h, reason: collision with root package name */
    private final ContentObserver f73740h = new a(null);

    /* renamed from: i, reason: collision with root package name */
    private ContentResolver f73741i;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a extends ContentObserver {
        a(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z16) {
            super.onChange(z16);
            c.this.g();
        }
    }

    public c(@NonNull Context context, String str) {
        this.f73741i = null;
        this.f73739f = str;
        if (context != null) {
            this.f73741i = context.getContentResolver();
        }
    }

    @Override // com.tencent.av.foldable.h
    public void a() {
        super.a();
        ContentResolver contentResolver = this.f73741i;
        if (contentResolver != null) {
            contentResolver.unregisterContentObserver(this.f73740h);
            this.f73741i = null;
        }
    }

    @Override // com.tencent.av.foldable.h
    public void d() {
        if (this.f73741i != null) {
            this.f73741i.registerContentObserver(Settings.Global.getUriFor(this.f73739f), false, this.f73740h);
        }
        g();
    }

    @Override // com.tencent.av.foldable.a
    public int f() {
        ContentResolver contentResolver = this.f73741i;
        if (contentResolver == null) {
            return -1;
        }
        return Settings.Global.getInt(contentResolver, this.f73739f, -1);
    }
}
