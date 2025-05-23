package com.tencent.mobileqq.utils;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class cd {
    public static byte[] a(Parcelable parcelable) {
        Parcel obtain = Parcel.obtain();
        parcelable.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        return marshall;
    }

    public static Parcel b(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        return obtain;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003d, code lost:
    
        if (r4 != null) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x000d, code lost:
    
        if (r4 != null) goto L6;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0043  */
    /* JADX WARN: Type inference failed for: r2v5, types: [T] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T> T c(byte[] bArr, Parcelable.Creator<T> creator) {
        Parcel parcel;
        T t16 = (T) null;
        try {
            try {
                parcel = b(bArr);
            } catch (Exception e16) {
                e = e16;
                parcel = null;
            } catch (OutOfMemoryError e17) {
                e = e17;
                parcel = null;
            } catch (Throwable th5) {
                th = th5;
                if (t16 != 0) {
                }
                throw th;
            }
            try {
                t16 = creator.createFromParcel(parcel);
            } catch (Exception e18) {
                e = e18;
                if (QLog.isColorLevel()) {
                    QLog.i("ParcelableUtil", 2, e.getMessage(), e);
                }
            } catch (OutOfMemoryError e19) {
                e = e19;
                if (QLog.isColorLevel()) {
                    QLog.i("ParcelableUtil", 2, e.getMessage(), e);
                }
                if (parcel != null) {
                    OaidMonitor.parcelRecycle(parcel);
                }
                return (T) t16;
            }
        } catch (Throwable th6) {
            th = th6;
            t16 = (T) bArr;
            if (t16 != 0) {
                OaidMonitor.parcelRecycle(t16);
            }
            throw th;
        }
    }
}
