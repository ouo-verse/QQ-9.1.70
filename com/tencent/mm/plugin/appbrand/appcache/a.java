package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.mc.p;
import com.tencent.luggage.wxa.mc.q0;
import com.tencent.luggage.wxa.rc.m;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mm.plugin.appbrand.appstorage.MD5JNI;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class a extends ModulePkgInfo implements Iterable {
    public static final Parcelable.Creator<a> CREATOR = new b();

    /* renamed from: g, reason: collision with root package name */
    public static c f151860g;

    /* renamed from: a, reason: collision with root package name */
    public int f151861a;

    /* renamed from: b, reason: collision with root package name */
    public long f151862b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f151863c;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedList f151864d;

    /* renamed from: e, reason: collision with root package name */
    public volatile transient Map f151865e;

    /* renamed from: f, reason: collision with root package name */
    public q0 f151866f;

    /* compiled from: P */
    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C7053a implements Iterator {

        /* renamed from: a, reason: collision with root package name */
        public boolean f151867a = false;

        /* renamed from: b, reason: collision with root package name */
        public Iterator f151868b = null;

        public C7053a() {
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ModulePkgInfo next() {
            if (!this.f151867a) {
                this.f151867a = true;
                return a.this;
            }
            return (ModulePkgInfo) this.f151868b.next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (!this.f151867a) {
                return true;
            }
            if (this.f151868b == null) {
                this.f151868b = a.this.f151864d.iterator();
            }
            return this.f151868b.hasNext();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i3) {
            return new a[i3];
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface c {
    }

    public a() {
        this.f151864d = new LinkedList();
        this.f151866f = null;
        this.name = ModulePkgInfo.MAIN_MODULE_NAME;
        this.independent = true;
    }

    public static void a(c cVar) {
        f151860g = cVar;
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return a(new v(str));
    }

    public void c(String str) {
        synchronized (this.f151864d) {
            if (!this.f151864d.isEmpty() && this.f151865e == null) {
                this.f151865e = new ArrayMap();
                Iterator it = this.f151864d.iterator();
                while (it.hasNext()) {
                    ModulePkgInfo modulePkgInfo = (ModulePkgInfo) it.next();
                    modulePkgInfo.pkgVersion = this.pkgVersion;
                    String a16 = a(modulePkgInfo.name);
                    if (!a16.equals(modulePkgInfo.name)) {
                        w.d("Luggage.WXA.WxaPkgWrappingInfo", "setupModuleEnv, appId:%s, module mapped %s -> %s", str, modulePkgInfo.name, a16);
                        this.f151865e.put(a16, modulePkgInfo.name);
                        modulePkgInfo.name = a16;
                    }
                }
                w.d("Luggage.WXA.WxaPkgWrappingInfo", "setupModuleEnv, appId:%s, NameMap.size:%d", str, Integer.valueOf(this.f151865e.size()));
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo
    public boolean isAssignable(ModulePkgInfo modulePkgInfo) {
        if (modulePkgInfo instanceof a) {
            if (super.isAssignable(modulePkgInfo) && this.pkgVersion == modulePkgInfo.pkgVersion) {
                return true;
            }
            return false;
        }
        return super.isAssignable(modulePkgInfo);
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return new C7053a();
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo
    public void readFromParcel(Parcel parcel) {
        boolean z16;
        super.readFromParcel(parcel);
        this.f151861a = parcel.readInt();
        this.pkgVersion = parcel.readInt();
        this.f151862b = parcel.readLong();
        if (parcel.readByte() != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f151863c = z16;
        parcel.readTypedList(this.f151864d, ModulePkgInfo.CREATOR);
        this.f151866f = (q0) parcel.readParcelable(q0.class.getClassLoader());
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo
    public String toString() {
        return "WxaPkgWrappingInfo{pkgDebugType=" + this.f151861a + ", pkgVersion=" + this.pkgVersion + ", pkgCreateTime=" + this.f151862b + ", localPkg=" + this.f151863c + ", md5='" + this.md5 + "', pkgPath='" + this.pkgPath + "'}";
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeInt(this.f151861a);
        parcel.writeInt(this.pkgVersion);
        parcel.writeLong(this.f151862b);
        parcel.writeByte(this.f151863c ? (byte) 1 : (byte) 0);
        parcel.writeTypedList(this.f151864d);
        parcel.writeParcelable(this.f151866f, 0);
    }

    public static String a(String str) {
        return ModulePkgInfo.MAIN_MODULE_NAME.equals(str) ? str : m.a(str, false);
    }

    public String a(String str, String str2) {
        String str3;
        if (ModulePkgInfo.MAIN_MODULE_NAME.equals(str2)) {
            return str2;
        }
        synchronized (this.f151864d) {
            if (this.f151865e == null) {
                c(str);
            }
            str3 = (String) this.f151865e.get(str2);
            if (TextUtils.isEmpty(str3)) {
                str3 = str2;
            }
        }
        w.d("Luggage.WXA.WxaPkgWrappingInfo", "getModuleNameForURLFetch appId:%s, retrace module %s -> %s", str, str2, str3);
        return str3;
    }

    public a(Parcel parcel) {
        this();
        readFromParcel(parcel);
    }

    public static String a(v vVar) {
        String str;
        String[] strArr;
        try {
            p.a();
            strArr = new String[1];
        } catch (Exception | UnsatisfiedLinkError e16) {
            w.a("Luggage.WXA.WxaPkgWrappingInfo", e16, "getFileMD5 by jni", new Object[0]);
            str = null;
        }
        if (-101 == MD5JNI.getMD5String(x.b(vVar.g(), false), strArr)) {
            throw new IOException("MD5_ERR_FILE_OPEN");
        }
        str = strArr[0];
        if (TextUtils.isEmpty(str)) {
            try {
                InputStream a16 = x.a(vVar);
                try {
                    str = com.tencent.luggage.wxa.y8.c.a(a16, 16384);
                    if (a16 != null) {
                        a16.close();
                    }
                } finally {
                }
            } catch (IOException e17) {
                w.a("Luggage.WXA.WxaPkgWrappingInfo", e17, "getFileMD5 by java io", new Object[0]);
            }
        }
        return str;
    }
}
