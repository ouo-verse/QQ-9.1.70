package com.qzone.reborn.util;

import android.os.Parcelable;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes37.dex */
public class i {

    /* renamed from: c, reason: collision with root package name */
    private static volatile i f59545c;

    /* renamed from: d, reason: collision with root package name */
    private static volatile i f59546d;

    /* renamed from: a, reason: collision with root package name */
    private final MMKVOptionEntity f59547a;

    /* renamed from: b, reason: collision with root package name */
    private final c f59548b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class b implements c {
        b() {
        }

        @Override // com.qzone.reborn.util.i.c
        public String getKey(String str) {
            return str + "_" + ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface c {
        String getKey(String str);
    }

    i(MMKVOptionEntity mMKVOptionEntity, c cVar) {
        this.f59547a = mMKVOptionEntity;
        this.f59548b = cVar;
    }

    public static i b() {
        if (f59546d == null) {
            synchronized (i.class) {
                if (f59546d == null) {
                    f59546d = new i(QMMKV.from(RFWApplication.getApplication(), QMMKVFile.FILE_QZONE_COMMON), new b());
                }
            }
        }
        return f59546d;
    }

    public static i c() {
        if (f59545c == null) {
            synchronized (i.class) {
                if (f59545c == null) {
                    f59545c = new i(QMMKV.from(RFWApplication.getApplication(), QMMKVFile.FILE_QZONE_COMMON), new a());
                }
            }
        }
        return f59545c;
    }

    public boolean a(String str) {
        return this.f59547a.containsKey(this.f59548b.getKey(str));
    }

    public boolean d(String str, boolean z16) {
        return this.f59547a.decodeBool(this.f59548b.getKey(str), z16);
    }

    public byte[] e(String str, byte[] bArr) {
        return this.f59547a.decodeBytes(this.f59548b.getKey(str), bArr);
    }

    public float f(String str, float f16) {
        return this.f59547a.decodeFloat(this.f59548b.getKey(str), f16);
    }

    public int g(String str, int i3) {
        return this.f59547a.decodeInt(this.f59548b.getKey(str), i3);
    }

    public long h(String str, long j3) {
        return this.f59547a.decodeLong(this.f59548b.getKey(str), j3);
    }

    public <T extends Parcelable> T i(String str, Class<T> cls, T t16) {
        return (T) this.f59547a.decodeParcelable(this.f59548b.getKey(str), cls, t16);
    }

    public String j(String str, String str2) {
        return this.f59547a.decodeString(this.f59548b.getKey(str), str2);
    }

    public Set<String> k(String str, Set<String> set) {
        return this.f59547a.decodeStringSet(this.f59548b.getKey(str), set);
    }

    public i l(String str, boolean z16) {
        this.f59547a.encodeBool(this.f59548b.getKey(str), z16);
        return this;
    }

    public i m(String str, byte[] bArr) {
        this.f59547a.encodeBytes(this.f59548b.getKey(str), bArr);
        return this;
    }

    public i n(String str, float f16) {
        this.f59547a.encodeFloat(this.f59548b.getKey(str), f16);
        return this;
    }

    public i o(String str, int i3) {
        this.f59547a.encodeInt(this.f59548b.getKey(str), i3);
        return this;
    }

    public i p(String str, long j3) {
        this.f59547a.encodeLong(this.f59548b.getKey(str), j3);
        return this;
    }

    public i q(String str, Parcelable parcelable) {
        this.f59547a.encodeParcelable(this.f59548b.getKey(str), parcelable);
        return this;
    }

    public i r(String str, String str2) {
        this.f59547a.encodeString(this.f59548b.getKey(str), str2);
        return this;
    }

    public i s(String str, Set<String> set) {
        this.f59547a.encodeStringSet(this.f59548b.getKey(str), set);
        return this;
    }

    public i t(String str) {
        this.f59547a.removeKey(this.f59548b.getKey(str));
        return this;
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements c {
        a() {
        }

        @Override // com.qzone.reborn.util.i.c
        public String getKey(String str) {
            return str;
        }
    }
}
