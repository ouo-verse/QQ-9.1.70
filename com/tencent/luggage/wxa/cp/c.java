package com.tencent.luggage.wxa.cp;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Pair;
import com.tencent.luggage.wxa.cp.k;
import com.tencent.luggage.wxa.dp.f;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c extends t {
    public static final C6119c CREATOR = new C6119c();

    /* renamed from: a, reason: collision with root package name */
    public final b f123730a;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends com.tencent.luggage.wxa.cp.b implements k {
        public static final Parcelable.Creator<b> CREATOR = null;

        /* renamed from: a, reason: collision with root package name */
        public final AssetManager f123731a;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements f.a {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f123732a;

            public a(String str) {
                this.f123732a = str;
            }

            @Override // com.tencent.luggage.wxa.dp.f.a
            public i a(String str) {
                String str2 = this.f123732a + str;
                InputStream inputStream = null;
                try {
                    inputStream = b.this.f123731a.open(str2);
                    return new i(b.this, str2, str, inputStream.available(), 0L, 0L, false);
                } catch (IOException unused) {
                    return new i(b.this, str2, str, 0L, 0L, 0L, true);
                } finally {
                    c0.a(inputStream);
                }
            }
        }

        public b(Context context) {
            this.f123731a = context.getAssets();
        }

        @Override // com.tencent.luggage.wxa.cp.k.a
        public int a() {
            return 12;
        }

        @Override // com.tencent.luggage.wxa.cp.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public k.a a(Map map) {
            return this;
        }

        @Override // com.tencent.luggage.wxa.cp.k.a
        public i c(String str) {
            String substring;
            try {
                InputStream a16 = a(str);
                int available = a16.available();
                a16.close();
                int lastIndexOf = str.lastIndexOf(47);
                if (lastIndexOf < 0) {
                    substring = str;
                } else {
                    substring = str.substring(lastIndexOf + 1);
                }
                return new i(this, str, substring, available, 0L, 0L, false);
            } catch (IOException unused) {
                return null;
            }
        }

        @Override // com.tencent.luggage.wxa.cp.k.a
        public String d(String str, boolean z16) {
            return null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.tencent.luggage.wxa.cp.k.a
        public Iterable e(String str) {
            String str2;
            String a16 = c0.a(str, true, false);
            try {
                String[] list = this.f123731a.list(a16);
                if (list == null) {
                    return null;
                }
                if (a16.isEmpty()) {
                    str2 = a16;
                } else {
                    str2 = a16 + '/';
                }
                return new com.tencent.luggage.wxa.dp.f(Arrays.asList(list), new a(str2), false);
            } catch (IOException e16) {
                com.tencent.luggage.wxa.yp.b.a("VFS.AssetsFileSystem", e16, "Cannot list: " + a16);
                return null;
            }
        }

        @Override // com.tencent.luggage.wxa.cp.k.a
        public Iterable f(String str) {
            String a16 = c0.a(str, true, false);
            try {
                String[] list = this.f123731a.list(a16);
                if (list == null) {
                    return null;
                }
                return Arrays.asList(list);
            } catch (IOException e16) {
                com.tencent.luggage.wxa.yp.b.a("VFS.AssetsFileSystem", e16, "Cannot list: " + a16);
                return null;
            }
        }

        @Override // com.tencent.luggage.wxa.cp.k.a
        public boolean i(String str) {
            try {
                a(str).close();
                return true;
            } catch (IOException unused) {
                return false;
            }
        }

        @Override // com.tencent.luggage.wxa.cp.b
        public String toString() {
            return "assets";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.tencent.luggage.wxa.cp.k.a
        public k b() {
            return this;
        }

        @Override // com.tencent.luggage.wxa.cp.k.a
        public boolean d(String str) {
            return false;
        }

        @Override // com.tencent.luggage.wxa.cp.k.a
        public boolean b(String str) {
            return false;
        }

        @Override // com.tencent.luggage.wxa.cp.k.a
        public InputStream a(String str) {
            try {
                return this.f123731a.open(str);
            } catch (IOException e16) {
                if (e16 instanceof FileNotFoundException) {
                    throw ((FileNotFoundException) e16);
                }
                throw new FileNotFoundException(e16.getMessage());
            }
        }

        @Override // com.tencent.luggage.wxa.cp.b
        public boolean b(String str, k.a aVar, String str2) {
            return false;
        }

        @Override // com.tencent.luggage.wxa.cp.k.a
        public boolean b(String str, boolean z16) {
            return false;
        }

        @Override // com.tencent.luggage.wxa.cp.b
        public long b(String str, k.a aVar, String str2, boolean z16) {
            throw new IOException("Not implemented");
        }

        @Override // com.tencent.luggage.wxa.cp.k.a
        public OutputStream a(String str, boolean z16) {
            throw new FileNotFoundException("Cannot open files for writing on read-only filesystems");
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.cp.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C6119c implements Parcelable.Creator {

        /* renamed from: a, reason: collision with root package name */
        public static final c f123734a = new c();

        public C6119c() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c createFromParcel(Parcel parcel) {
            return f123734a;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c[] newArray(int i3) {
            return new c[i3];
        }
    }

    public static c a() {
        return C6119c.f123734a;
    }

    public c() {
        this.f123730a = new b(l.d().b());
    }

    @Override // com.tencent.luggage.wxa.cp.s.a
    public Pair a(p pVar, b0 b0Var) {
        String str = b0Var.f123727c;
        return Pair.create(this.f123730a, str == null ? "" : c0.a(str, true, true));
    }
}
