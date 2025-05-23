package com.qzone.publish.utils;

import android.os.Parcel;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public class d {
    public static <T extends SmartParcelable> T a(T t16) {
        if (t16 == null) {
            QZLog.e("SmartParcelableUtils", 2, "copyObj is null !!");
            return null;
        }
        Parcel obtain = Parcel.obtain();
        ParcelableWrapper.writeDataToParcel(obtain, 0, t16);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        Parcel obtain2 = Parcel.obtain();
        obtain2.unmarshall(marshall, 0, marshall.length);
        obtain2.setDataPosition(0);
        T t17 = (T) ParcelableWrapper.createDataFromParcel(obtain2);
        OaidMonitor.parcelRecycle(obtain2);
        return t17;
    }
}
