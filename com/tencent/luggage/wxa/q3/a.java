package com.tencent.luggage.wxa.q3;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.luggage.wxa.tn.f0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.zp.h;
import cooperation.qzone.QZoneHelper;
import java.io.IOException;
import org.apache.commons.lang.StringUtils;
import org.joor.Reflect;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a implements com.tencent.luggage.wxa.qa.a {

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.q3.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6616a {

        /* renamed from: a, reason: collision with root package name */
        public static final f0 f137817a = f0.e("MicroMsg_XIPC_MMProtoBufTransfer");
    }

    public static boolean a() {
        return com.tencent.luggage.wxa.tn.e.f141559a && Math.random() < 0.5d;
    }

    public static boolean b() {
        if (!com.tencent.luggage.wxa.tn.e.f141559a || Math.random() >= 0.5d) {
            return false;
        }
        return true;
    }

    public static f0 c() {
        return C6616a.f137817a;
    }

    @Override // com.tencent.luggage.wxa.qa.a
    public String getName() {
        return "com.tencent.luggage.login.account.tdi.ipc.MMProtoBufTransfer";
    }

    @Override // com.tencent.luggage.wxa.qa.a
    public boolean a(Object obj) {
        return obj instanceof com.tencent.luggage.wxa.fn.b;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.luggage.wxa.qa.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Object obj, Parcel parcel) {
        final byte[] bArr;
        final ParcelFileDescriptor parcelFileDescriptor;
        ParcelFileDescriptor parcelFileDescriptor2;
        long l3;
        if (obj == null) {
            parcel.writeString(null);
            return;
        }
        com.tencent.luggage.wxa.fn.b bVar = (com.tencent.luggage.wxa.fn.b) obj;
        parcel.writeString(bVar.getClass().getName());
        boolean z16 = true;
        try {
            bArr = bVar.b();
        } catch (Exception e16) {
            w.b("MicroMsg.XIPC.MMProtoBufTransfer", "writeToParcel, e = %s", e16);
            bArr = new byte[0];
        }
        if (bArr.length > 102400 || (b() && bArr.length > 0)) {
            try {
                ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
                parcelFileDescriptor2 = createPipe[0];
                parcelFileDescriptor = createPipe[1];
            } catch (IOException | IndexOutOfBoundsException unused) {
                parcelFileDescriptor = null;
                parcelFileDescriptor2 = null;
            }
            if (parcelFileDescriptor2 != null && parcelFileDescriptor != null) {
                h.f146825d.d(new Runnable() { // from class: w31.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.tencent.luggage.wxa.q3.a.a(parcelFileDescriptor, bArr);
                    }
                });
                parcel.writeString("__KEY_PARCEL_DESCRIPTOR_PLACEHOLDER__");
                parcel.writeInt(bArr.length);
                parcel.writeParcelable(parcelFileDescriptor2, 0);
                return;
            }
        }
        f0 c16 = c();
        if ((bArr.length > 102400 || (a() && bArr.length > 0)) && c16 != null) {
            try {
                l3 = c16.l();
            } catch (Throwable th5) {
                w.a("MicroMsg.XIPC.MMProtoBufTransfer", th5, "encode bytes to mmkv", new Object[0]);
            }
            if (l3 >= QZoneHelper.Constants.NO_WIFI_UPLOAD_VIDEO_MAX_SIZE_DEFAULT) {
                w.b("MicroMsg.XIPC.MMProtoBufTransfer", "mmkv totalSize[%d] too large, skip use mmkv", Long.valueOf(l3));
            } else {
                String join = StringUtils.join(new String[]{z.i(), obj.getClass().getName(), obj.hashCode() + "", SystemClock.elapsedRealtimeNanos() + ""}, "$");
                c16.a(join, bArr);
                if (c16.a(join)) {
                    parcel.writeString(join);
                    if (z16) {
                        parcel.writeString(null);
                        parcel.writeInt(bArr.length);
                        parcel.writeByteArray(bArr);
                        return;
                    }
                    return;
                }
            }
        }
        z16 = false;
        if (z16) {
        }
    }

    public static /* synthetic */ void a(ParcelFileDescriptor parcelFileDescriptor, byte[] bArr) {
        try {
            ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(parcelFileDescriptor);
            try {
                autoCloseOutputStream.write(bArr);
                autoCloseOutputStream.close();
            } finally {
            }
        } catch (IOException e16) {
            w.b("MicroMsg.XIPC.MMProtoBufTransfer", "writeToParcel by ParcelFileDescriptor get exception %s", e16);
        }
    }

    @Override // com.tencent.luggage.wxa.qa.a
    public Object a(Parcel parcel) {
        byte[] bArr;
        byte[] bArr2;
        boolean z16;
        ParcelFileDescriptor parcelFileDescriptor;
        String readString = parcel.readString();
        if (TextUtils.isEmpty(readString)) {
            return null;
        }
        String readString2 = parcel.readString();
        if ("__KEY_PARCEL_DESCRIPTOR_PLACEHOLDER__".equals(readString2)) {
            int readInt = parcel.readInt();
            if (readInt <= 0 || (parcelFileDescriptor = (ParcelFileDescriptor) parcel.readParcelable(ParcelFileDescriptor.class.getClassLoader())) == null) {
                return null;
            }
            try {
                ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor);
                try {
                    bArr = new byte[readInt];
                    int i3 = 0;
                    while (i3 < readInt) {
                        int read = autoCloseInputStream.read(bArr, i3, readInt - i3);
                        if (read == -1) {
                            w.b("MicroMsg.XIPC.MMProtoBufTransfer", "readFromParcel: unexpected end of stream (expected %d, actual %d)", Integer.valueOf(readInt), Integer.valueOf(i3));
                            autoCloseInputStream.close();
                            return null;
                        }
                        i3 += read;
                    }
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.a(readInt, i3);
                    }
                    autoCloseInputStream.close();
                } finally {
                }
            } catch (IOException e16) {
                w.b("MicroMsg.XIPC.MMProtoBufTransfer", "readFromParcel by ParcelFileDescriptor get exception %s", e16);
                return null;
            }
        } else if (!TextUtils.isEmpty(readString2)) {
            f0 c16 = c();
            try {
                bArr2 = c16.b(readString2);
                if (bArr2 == null) {
                    try {
                        w.b("MicroMsg.XIPC.MMProtoBufTransfer", "readFromParcel, NULL bytes, gProtoBufXProcessStore[%s]", c16);
                        if (!z16) {
                            return null;
                        }
                        return null;
                    } catch (Throwable th5) {
                        th = th5;
                        try {
                            w.a("MicroMsg.XIPC.MMProtoBufTransfer", th, "readFromParcel", new Object[0]);
                            try {
                                c16.g(readString2);
                                if (com.tencent.luggage.wxa.tn.e.f141559a || (bArr2 != null && bArr2.length >= 1048576)) {
                                    c16.m();
                                }
                            } catch (Throwable unused) {
                            }
                            return null;
                        } finally {
                            try {
                                c16.g(readString2);
                                if (com.tencent.luggage.wxa.tn.e.f141559a || (bArr2 != null && bArr2.length >= 1048576)) {
                                    c16.m();
                                }
                            } catch (Throwable unused2) {
                            }
                        }
                    }
                }
                try {
                    c16.g(readString2);
                    if (com.tencent.luggage.wxa.tn.e.f141559a || bArr2.length >= 1048576) {
                        c16.m();
                    }
                } catch (Throwable unused3) {
                }
                bArr = bArr2;
            } catch (Throwable th6) {
                th = th6;
                bArr2 = null;
            }
        } else {
            byte[] bArr3 = new byte[parcel.readInt()];
            parcel.readByteArray(bArr3);
            bArr = bArr3;
        }
        try {
            com.tencent.luggage.wxa.fn.b bVar = (com.tencent.luggage.wxa.fn.b) Reflect.on(readString).create().get();
            bVar.a(bArr);
            return bVar;
        } catch (Throwable th7) {
            w.b("MicroMsg.XIPC.MMProtoBufTransfer", "readFromParcel, e = %s", th7);
            return null;
        }
    }
}
