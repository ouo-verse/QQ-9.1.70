package oicq.wlogin_sdk.listener;

import android.content.Context;

/* loaded from: classes28.dex */
public interface PrivacyListener {
    String getAndroidID(Context context);

    String getBssid(Context context);

    String getDeviceModel();

    String getImsi(Context context);

    String getMac(Context context);

    String getSsid(Context context);
}
