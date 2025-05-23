package com.tencent.luggage.wxa.mc;

import android.content.res.AssetFileDescriptor;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class f extends com.tencent.luggage.wxa.mc.a {

    /* renamed from: g, reason: collision with root package name */
    public static boolean f134286g = false;

    /* renamed from: f, reason: collision with root package name */
    public final com.tencent.mm.plugin.appbrand.appcache.a f134288f;

    /* renamed from: h, reason: collision with root package name */
    public static final f f134287h = new f();
    public static final Parcelable.Creator<f> CREATOR = new a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public f createFromParcel(Parcel parcel) {
            return new f(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public f[] newArray(int i3) {
            return new f[i3];
        }
    }

    public /* synthetic */ f(Parcel parcel, a aVar) {
        this(parcel);
    }

    public static boolean G() {
        if (!com.tencent.luggage.wxa.tn.e.f141559a && !f134286g) {
            return false;
        }
        return new File(com.tencent.luggage.wxa.tn.z.c().getExternalFilesDir("").getAbsolutePath() + File.separator + "WAVersion.json").exists();
    }

    @Override // com.tencent.luggage.wxa.mc.k
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public com.tencent.mm.plugin.appbrand.appcache.a e() {
        return this.f134288f;
    }

    @Override // com.tencent.luggage.wxa.mc.k
    public InputStream a(String str) {
        String a16 = com.tencent.luggage.wxa.rc.m.a(str);
        if (com.tencent.luggage.wxa.tn.e.f141559a || f134286g) {
            File file = new File(com.tencent.luggage.wxa.tn.z.c().getExternalFilesDir("").getAbsolutePath() + File.separator + a16);
            com.tencent.luggage.wxa.tn.w.d("Luggage.DebugReader", "use local: %s %b", file.getAbsolutePath(), Boolean.valueOf(file.exists()));
            if (file.exists()) {
                try {
                    return new FileInputStream(file);
                } catch (FileNotFoundException e16) {
                    com.tencent.luggage.wxa.tn.w.d("Luggage.DebugReader", "FileNotFoundException %s", e16);
                    return null;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.tencent.luggage.wxa.mc.k
    public AssetFileDescriptor d(String str) {
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "DebugReader[%d][%s]", Integer.valueOf(w()), r());
    }

    public f() {
        com.tencent.mm.plugin.appbrand.appcache.a aVar = new com.tencent.mm.plugin.appbrand.appcache.a();
        this.f134288f = aVar;
        aVar.f151863c = true;
        aVar.f151861a = 0;
        aVar.pkgVersion = z.f134409a;
        aVar.md5 = "";
    }

    f(Parcel parcel) {
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
