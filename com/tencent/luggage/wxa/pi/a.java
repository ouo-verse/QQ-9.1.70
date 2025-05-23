package com.tencent.luggage.wxa.pi;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.wd.d;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    public static a f137604c = new a();

    /* renamed from: a, reason: collision with root package name */
    public HashMap f137605a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public volatile String f137606b = "";

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.pi.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C6602a extends d {
        public static final Parcelable.Creator<C6602a> CREATOR = new C6603a();

        /* renamed from: c, reason: collision with root package name */
        public String f137607c = null;

        /* renamed from: d, reason: collision with root package name */
        public boolean f137608d = false;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.pi.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6603a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public C6602a createFromParcel(Parcel parcel) {
                return new C6602a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public C6602a[] newArray(int i3) {
                return new C6602a[i3];
            }
        }

        public C6602a() {
        }

        @Override // com.tencent.luggage.wxa.wd.d
        public void h() {
            this.f137608d = com.tencent.luggage.wxa.pi.b.b().a(this.f137607c);
        }

        @Override // com.tencent.luggage.wxa.wd.d, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.f137607c);
            parcel.writeByte(this.f137608d ? (byte) 1 : (byte) 0);
        }

        @Override // com.tencent.luggage.wxa.wd.d
        public void a(Parcel parcel) {
            this.f137607c = parcel.readString();
            this.f137608d = parcel.readByte() != 0;
        }

        public C6602a(Parcel parcel) {
            a(parcel);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        void a();

        void b();

        void onResume();

        void onStop();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class c extends d {
        public static final Parcelable.Creator<c> CREATOR = new C6604a();

        /* renamed from: c, reason: collision with root package name */
        public String f137609c;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.pi.a$c$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6604a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public c createFromParcel(Parcel parcel) {
                return new c(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public c[] newArray(int i3) {
                return new c[i3];
            }
        }

        public c() {
        }

        @Override // com.tencent.luggage.wxa.wd.d
        public void a(Parcel parcel) {
            this.f137609c = parcel.readString();
        }

        @Override // com.tencent.luggage.wxa.wd.d
        public void h() {
            w.d("MicroMsg.AppBrandMusicClientService", "runInMainProcess");
            String c16 = com.tencent.luggage.wxa.pi.b.b().c();
            if (!w0.c(c16) && !c16.equals(this.f137609c)) {
                w.d("MicroMsg.AppBrandMusicClientService", "appid not match cannot operate, preAppId:%s, appId:%s", c16, this.f137609c);
                a();
            } else if (!com.tencent.luggage.wxa.pi.b.b().a(this.f137609c)) {
                w.d("MicroMsg.AppBrandMusicClientService", "appid not match cannot operate, can't not stop, preAppId:%s, appId:%s", c16, this.f137609c);
                a();
            } else {
                if (com.tencent.luggage.wxa.pi.b.b().e()) {
                    w.d("MicroMsg.AppBrandMusicClientService", "stop music ok");
                } else {
                    w.b("MicroMsg.AppBrandMusicClientService", "stop music fail");
                }
                a();
            }
        }

        @Override // com.tencent.luggage.wxa.wd.d, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.f137609c);
        }

        public c(Parcel parcel) {
            a(parcel);
        }
    }

    public void a(int i3) {
        w.d("MicroMsg.AppBrandMusicClientService", "notifyAction, currentPlayAppId:%s, action:%d", this.f137606b, Integer.valueOf(i3));
        for (Map.Entry entry : this.f137605a.entrySet()) {
            if (entry != null) {
                String str = (String) entry.getKey();
                b bVar = (b) entry.getValue();
                if (!TextUtils.isEmpty(this.f137606b) && this.f137606b.equalsIgnoreCase(str)) {
                    w.d("MicroMsg.AppBrandMusicClientService", "current play music appId is %s", this.f137606b);
                    if (bVar != null) {
                        if (i3 == 10) {
                            bVar.a();
                        } else if (i3 == 2) {
                            bVar.onStop();
                        } else if (i3 == 7) {
                            bVar.b();
                        } else if (i3 == 1) {
                            bVar.onResume();
                        }
                    }
                }
            }
        }
    }

    public void b(String str) {
        this.f137606b = str;
    }

    public boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.equalsIgnoreCase(this.f137606b)) {
            w.b("MicroMsg.AppBrandMusicClientService", "appId is diff, can't stop music");
            return false;
        }
        c cVar = new c();
        cVar.f137609c = str;
        cVar.b();
        return true;
    }

    public boolean b(String str, b bVar) {
        boolean remove;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (bVar == null) {
            this.f137605a.remove(str);
            return true;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            remove = this.f137605a.remove(str, bVar);
            return remove;
        }
        if (this.f137605a.get(str) != bVar) {
            return false;
        }
        this.f137605a.remove(str);
        return true;
    }

    public boolean a(String str, b bVar) {
        if (TextUtils.isEmpty(str) || bVar == null) {
            return false;
        }
        if (!this.f137605a.containsKey(str)) {
            this.f137605a.put(str, bVar);
            return true;
        }
        this.f137605a.remove(str);
        this.f137605a.put(str, bVar);
        return true;
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        C6602a c6602a = new C6602a();
        c6602a.f137607c = str;
        if (c6602a.c()) {
            return c6602a.f137608d;
        }
        return false;
    }
}
