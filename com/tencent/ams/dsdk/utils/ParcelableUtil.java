package com.tencent.ams.dsdk.utils;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* loaded from: classes3.dex */
public class ParcelableUtil {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ParcelableUtil";

    public ParcelableUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static byte[] marshall(Parcelable parcelable) {
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        parcelable.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        DLog.d(TAG, "bytes = " + String.valueOf(marshall) + "parcel" + obtain.toString());
        OaidMonitor.parcelRecycle(obtain);
        return marshall;
    }

    public static Parcel unmarshall(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        return obtain;
    }
}
