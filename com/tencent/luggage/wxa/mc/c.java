package com.tencent.luggage.wxa.mc;

import android.content.res.AssetFileDescriptor;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.InputStream;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c extends com.tencent.luggage.wxa.mc.a {

    /* renamed from: f, reason: collision with root package name */
    public final com.tencent.mm.plugin.appbrand.appcache.a[] f134271f;

    /* renamed from: g, reason: collision with root package name */
    public static final c f134270g = new c();
    public static final Parcelable.Creator<c> CREATOR = new a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c createFromParcel(Parcel parcel) {
            return new c(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c[] newArray(int i3) {
            return new c[i3];
        }
    }

    public /* synthetic */ c(Parcel parcel, a aVar) {
        this(parcel);
    }

    public final com.tencent.mm.plugin.appbrand.appcache.a C() {
        com.tencent.mm.plugin.appbrand.appcache.a aVar = new com.tencent.mm.plugin.appbrand.appcache.a();
        aVar.f151863c = true;
        aVar.f151861a = 0;
        aVar.pkgVersion = z.f134409a;
        aVar.md5 = "";
        return aVar;
    }

    @Override // com.tencent.luggage.wxa.mc.k
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public com.tencent.mm.plugin.appbrand.appcache.a e() {
        com.tencent.mm.plugin.appbrand.appcache.a aVar;
        com.tencent.mm.plugin.appbrand.appcache.a[] aVarArr = this.f134271f;
        com.tencent.mm.plugin.appbrand.appcache.a aVar2 = aVarArr[0];
        if (aVar2 != null) {
            return aVar2;
        }
        synchronized (aVarArr) {
            this.f134271f[0] = C();
            aVar = this.f134271f[0];
        }
        return aVar;
    }

    @Override // com.tencent.luggage.wxa.mc.k
    public InputStream a(String str) {
        return z.a(str);
    }

    @Override // com.tencent.luggage.wxa.mc.k
    public AssetFileDescriptor d(String str) {
        return z.b(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "AssetReader[%d][%s]", Integer.valueOf(w()), r());
    }

    public c() {
        this.f134271f = new com.tencent.mm.plugin.appbrand.appcache.a[]{null};
    }

    c(Parcel parcel) {
        this();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // com.tencent.luggage.wxa.mc.k
    public void init() {
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
    }
}
