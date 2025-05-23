package com.tencent.av.foldable;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d extends b {

    /* renamed from: f, reason: collision with root package name */
    private final String f73743f;

    /* renamed from: h, reason: collision with root package name */
    private final ContentObserver f73744h = new a(null);

    /* renamed from: i, reason: collision with root package name */
    private ContentResolver f73745i;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a extends ContentObserver {
        a(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z16) {
            super.onChange(z16);
            d dVar = d.this;
            dVar.e(Integer.valueOf(dVar.g()));
        }
    }

    public d(@NonNull Context context, String str) {
        this.f73745i = null;
        this.f73743f = str;
        if (context != null) {
            this.f73745i = context.getContentResolver();
        }
        e(Integer.valueOf(g()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int g() {
        ContentResolver contentResolver = this.f73745i;
        if (contentResolver == null) {
            return -1;
        }
        return Settings.Global.getInt(contentResolver, this.f73743f, -1);
    }

    @Override // com.tencent.av.foldable.h
    public void a() {
        super.a();
        ContentResolver contentResolver = this.f73745i;
        if (contentResolver == null) {
            return;
        }
        contentResolver.unregisterContentObserver(this.f73744h);
        this.f73745i = null;
    }

    @Override // com.tencent.av.foldable.h
    public void d() {
        if (this.f73745i == null) {
            return;
        }
        this.f73745i.registerContentObserver(Settings.Global.getUriFor(this.f73743f), false, this.f73744h);
    }
}
