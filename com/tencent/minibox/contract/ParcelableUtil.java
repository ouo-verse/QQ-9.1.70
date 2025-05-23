package com.tencent.minibox.contract;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* loaded from: classes9.dex */
public class ParcelableUtil {
    public static byte[] marshall(Parcelable parcelable) {
        Parcel obtain = Parcel.obtain();
        parcelable.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        return marshall;
    }

    public static <T extends Parcelable> T unmarshall(byte[] bArr, Parcelable.Creator<T> creator) {
        if (bArr == null) {
            return null;
        }
        try {
            return creator.createFromParcel(unmarshall(bArr));
        } catch (Exception unused) {
            return null;
        }
    }

    private static Parcel unmarshall(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        return obtain;
    }
}
