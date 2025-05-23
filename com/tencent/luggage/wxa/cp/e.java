package com.tencent.luggage.wxa.cp;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.util.Pair;
import com.tencent.luggage.wxa.cp.k;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.util.InputMethodUtil;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e extends t {
    public static final c CREATOR = new c();

    /* renamed from: a, reason: collision with root package name */
    public final b f123743a;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends com.tencent.luggage.wxa.cp.b implements k {
        public static final Parcelable.Creator<b> CREATOR = null;

        /* renamed from: a, reason: collision with root package name */
        public final ContentResolver f123744a;

        public b(Context context) {
            this.f123744a = context.getContentResolver();
        }

        @Override // com.tencent.luggage.wxa.cp.k.a
        public int a() {
            return 1;
        }

        @Override // com.tencent.luggage.wxa.cp.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public k.a a(Map map) {
            return this;
        }

        @Override // com.tencent.luggage.wxa.cp.k.a
        public i c(String str) {
            Cursor cursor;
            Cursor cursor2 = null;
            try {
                cursor = ContactsMonitor.query(this.f123744a, Uri.parse(str), null, null, null, null);
                if (cursor == null) {
                    c0.a(cursor);
                    return null;
                }
                try {
                    int columnIndex = cursor.getColumnIndex(InputMethodUtil.SOUGOU_URI_DISPLAYNAME);
                    int columnIndex2 = cursor.getColumnIndex("_size");
                    if (!cursor.moveToFirst()) {
                        c0.a(cursor);
                        return null;
                    }
                    i iVar = new i(this, str, cursor.getString(columnIndex), cursor.getLong(columnIndex2), 0L, 0L, false);
                    c0.a(cursor);
                    return iVar;
                } catch (RuntimeException unused) {
                    c0.a(cursor);
                    return null;
                } catch (Throwable th5) {
                    th = th5;
                    cursor2 = cursor;
                    c0.a(cursor2);
                    throw th;
                }
            } catch (RuntimeException unused2) {
                cursor = null;
            } catch (Throwable th6) {
                th = th6;
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
            return null;
        }

        @Override // com.tencent.luggage.wxa.cp.k.a
        public Iterable f(String str) {
            return null;
        }

        @Override // com.tencent.luggage.wxa.cp.k.a
        public boolean i(String str) {
            if (c(str) != null) {
                return true;
            }
            return false;
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
        public InputStream a(String str) {
            try {
                InputStream openInputStream = this.f123744a.openInputStream(Uri.parse(str));
                if (openInputStream != null) {
                    return openInputStream;
                }
                throw new FileNotFoundException("ContentResolver returns null");
            } catch (RuntimeException e16) {
                throw ((FileNotFoundException) new FileNotFoundException(str + " cannot be opened: " + e16.getMessage()).initCause(e16));
            }
        }

        @Override // com.tencent.luggage.wxa.cp.k.a
        public boolean b(String str, boolean z16) {
            return false;
        }

        @Override // com.tencent.luggage.wxa.cp.k.a
        public boolean b(String str) {
            try {
                return py3.b.e(this.f123744a, Uri.parse(str), null, null) >= 1;
            } catch (RuntimeException unused) {
                return false;
            }
        }

        @Override // com.tencent.luggage.wxa.cp.k.a
        public OutputStream a(String str, boolean z16) {
            try {
                OutputStream openOutputStream = this.f123744a.openOutputStream(Uri.parse(str), z16 ? "wa" : "w");
                if (openOutputStream != null) {
                    return openOutputStream;
                }
                throw new FileNotFoundException("ContentResolver returns null");
            } catch (RuntimeException e16) {
                throw ((FileNotFoundException) new FileNotFoundException(str + " cannot be opened: " + e16.getMessage()).initCause(e16));
            }
        }

        @Override // com.tencent.luggage.wxa.cp.b, com.tencent.luggage.wxa.cp.k.a
        public ParcelFileDescriptor a(String str, String str2) {
            try {
                ParcelFileDescriptor openFileDescriptor = this.f123744a.openFileDescriptor(Uri.parse(str), str2);
                if (openFileDescriptor != null) {
                    return openFileDescriptor;
                }
                throw new FileNotFoundException("ContentResolver returns null");
            } catch (RuntimeException e16) {
                throw ((FileNotFoundException) new FileNotFoundException(str + " cannot be opened: " + e16.getMessage()).initCause(e16));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class c implements Parcelable.Creator {

        /* renamed from: a, reason: collision with root package name */
        public static final u f123745a = new u(new e());

        public c() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e createFromParcel(Parcel parcel) {
            return (e) f123745a.f123837a;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e[] newArray(int i3) {
            return new e[i3];
        }
    }

    public static s a() {
        return (s) c.f123745a.f123837a;
    }

    public e() {
        this.f123743a = new b(l.d().b());
    }

    @Override // com.tencent.luggage.wxa.cp.s.a
    public Pair a(p pVar, b0 b0Var) {
        StringBuilder sb5 = new StringBuilder();
        String str = b0Var.f123725a;
        if (str != null) {
            sb5.append(str);
            sb5.append(':');
        }
        String str2 = b0Var.f123726b;
        if (str2 != null) {
            sb5.append("//");
            sb5.append(str2);
        }
        String str3 = b0Var.f123727c;
        if (str3 != null) {
            sb5.append(str3);
        }
        return Pair.create(this.f123743a, sb5.toString());
    }
}
