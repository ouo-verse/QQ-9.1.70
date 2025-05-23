package com.tencent.qzonehub.reborn;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.component.network.ISharedPreferencesProvider;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes25.dex */
public final class QZoneDownloadSharedPreferencesProvider implements ISharedPreferencesProvider {
    private static final /* synthetic */ QZoneDownloadSharedPreferencesProvider[] $VALUES;
    static IPatchRedirector $redirector_ = null;
    public static final QZoneDownloadSharedPreferencesProvider INSTANCE;
    private static final String TAG = "QZoneDownloadSharedPreferencesProvider";
    private static final int USE_MMKV = 1;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24013);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        QZoneDownloadSharedPreferencesProvider qZoneDownloadSharedPreferencesProvider = new QZoneDownloadSharedPreferencesProvider("INSTANCE", 0);
        INSTANCE = qZoneDownloadSharedPreferencesProvider;
        $VALUES = new QZoneDownloadSharedPreferencesProvider[]{qZoneDownloadSharedPreferencesProvider};
    }

    QZoneDownloadSharedPreferencesProvider(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    private boolean isUseMMkv() {
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", "download_sdk_use_mmkv", 1) == 1) {
            return true;
        }
        return false;
    }

    public static QZoneDownloadSharedPreferencesProvider valueOf(String str) {
        return (QZoneDownloadSharedPreferencesProvider) Enum.valueOf(QZoneDownloadSharedPreferencesProvider.class, str);
    }

    public static QZoneDownloadSharedPreferencesProvider[] values() {
        return (QZoneDownloadSharedPreferencesProvider[]) $VALUES.clone();
    }

    @Override // com.tencent.component.network.ISharedPreferencesProvider
    public SharedPreferences getSharedPreferences(Context context, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SharedPreferences) iPatchRedirector.redirect((short) 2, this, context, str, Integer.valueOf(i3));
        }
        if (isUseMMkv()) {
            return LocalMultiProcConfig.getPreferences(str, i3);
        }
        QLog.d(TAG, 1, "getSharedPreferences isUseMMkv return false");
        return null;
    }
}
