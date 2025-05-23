package mqq.app;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ams.adcore.mma.util.SharedPreferencedUtil;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import oicq.wlogin_sdk.listener.PrivacyListener;

/* loaded from: classes28.dex */
public class WtloginPrivacyListenerImpl implements PrivacyListener {
    private static final String TAG = "WtloginPrivacyListenerImpl";
    private static volatile WtloginPrivacyListenerImpl singleton;
    private String deviceModel;

    public static WtloginPrivacyListenerImpl getSingleton() {
        if (singleton == null) {
            synchronized (WtloginPrivacyListenerImpl.class) {
                if (singleton == null) {
                    singleton = new WtloginPrivacyListenerImpl();
                }
            }
        }
        return singleton;
    }

    @Override // oicq.wlogin_sdk.listener.PrivacyListener
    public String getAndroidID(Context context) {
        try {
            return DeviceInfoMonitor.getString(context.getContentResolver(), SharedPreferencedUtil.SP_KEY_ANDROID_ID);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
            return null;
        }
    }

    @Override // oicq.wlogin_sdk.listener.PrivacyListener
    public String getBssid(Context context) {
        return null;
    }

    @Override // oicq.wlogin_sdk.listener.PrivacyListener
    public String getDeviceModel() {
        if (TextUtils.isEmpty(this.deviceModel)) {
            this.deviceModel = DeviceInfoMonitor.getModel();
        }
        return this.deviceModel;
    }

    @Override // oicq.wlogin_sdk.listener.PrivacyListener
    public String getImsi(Context context) {
        return null;
    }

    @Override // oicq.wlogin_sdk.listener.PrivacyListener
    public String getMac(Context context) {
        return null;
    }

    @Override // oicq.wlogin_sdk.listener.PrivacyListener
    public String getSsid(Context context) {
        return null;
    }
}
