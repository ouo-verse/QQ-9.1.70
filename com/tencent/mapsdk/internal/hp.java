package com.tencent.mapsdk.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class hp {
    private static <T extends Parcelable> T a(T t16) {
        Parcel obtain = Parcel.obtain();
        obtain.writeParcelable(t16, 0);
        obtain.setDataPosition(0);
        T t17 = (T) obtain.readParcelable(t16.getClass().getClassLoader());
        OaidMonitor.parcelRecycle(obtain);
        return t17;
    }
}
