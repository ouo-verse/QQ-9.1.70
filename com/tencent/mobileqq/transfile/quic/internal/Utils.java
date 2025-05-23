package com.tencent.mobileqq.transfile.quic.internal;

import android.os.Build;
import android.os.SystemProperties;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.libloader.TPFromApkLibraryLoader;
import com.tencent.util.AbiUtil;
import java.io.File;

/* compiled from: P */
/* loaded from: classes19.dex */
public class Utils {
    static IPatchRedirector $redirector_ = null;
    public static final String ANDROMEDA_NAME = "libandromeda.so";
    public static final String QUIC_LIB_NAME = "libquic_engine.so";
    public static final String TAG = "quic";

    public Utils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean checkIfCPUx86() {
        if (Build.VERSION.SDK_INT > 27) {
            return false;
        }
        String systemProperty = getSystemProperty(TPFromApkLibraryLoader.RO_PRODUCT_CPU_ABI, AbiUtil.ARM);
        if (TextUtils.isEmpty(systemProperty)) {
            return false;
        }
        return systemProperty.contains(ResourceAttributes.HostArchValues.X86);
    }

    public static String getAndromedaSoPath() {
        return getQuicSoSavePath() + ANDROMEDA_NAME;
    }

    public static String getQuicEngineSoPath() {
        return getQuicSoSavePath() + QUIC_LIB_NAME;
    }

    public static String getQuicSoSavePath() {
        try {
            File file = new File(BaseApplication.getContext().getFilesDir(), "/quic_net_res");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getAbsolutePath() + File.separator;
        } catch (NullPointerException e16) {
            QLog.e("quic", 1, "npe:", e16);
            return "/quic_net_res";
        }
    }

    private static String getSystemProperty(String str, String str2) {
        try {
            return (String) SystemProperties.class.getMethod("get", String.class, String.class).invoke(SystemProperties.class, str, "");
        } catch (Exception e16) {
            QLog.e("quic", 4, e16, new Object[0]);
            return str2;
        }
    }
}
