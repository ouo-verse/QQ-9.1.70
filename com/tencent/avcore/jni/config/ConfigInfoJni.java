package com.tencent.avcore.jni.config;

import android.content.Context;
import com.tencent.avcore.config.Common;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.avcore.util.AVCoreUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ConfigInfoJni {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "ConfigInfoJni";
    protected final Context mContext;

    public ConfigInfoJni(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mContext = context;
        init();
        cacheMethodIds();
    }

    private static native void cacheMethodIds();

    public static String getSharpConfigPayloadFromFile(Context context) {
        String str = Common.SHARP_CONFIG_PAYLOAD_FILE_NAME;
        byte[] readFile = Common.readFile(context, str);
        if (readFile != null) {
            String str2 = new String(readFile);
            int indexOf = str2.indexOf(124);
            if (indexOf == -1) {
                return "";
            }
            String substring = str2.substring(0, indexOf);
            String substring2 = str2.substring(indexOf + 1);
            if (AVCoreLog.isColorLevel()) {
                AVCoreLog.i(TAG, "getSharpConfigPayloadFromFile FileName=" + str + "| payloadBuf:" + str2 + "| version=" + substring + "| payload=" + substring2);
            }
            return substring2;
        }
        if (AVCoreLog.isColorLevel()) {
            AVCoreLog.i(TAG, "getSharpConfigPayloadFromFile payloadBuf NULL");
        }
        return "";
    }

    public static int getSharpConfigVersionFromFile(Context context) {
        byte[] readFile = Common.readFile(context, Common.SHARP_CONFIG_PAYLOAD_FILE_NAME);
        if (readFile != null) {
            String str = new String(readFile);
            int indexOf = str.indexOf(124);
            if (indexOf > 0) {
                String substring = str.substring(0, indexOf);
                String substring2 = str.substring(indexOf + 1);
                if (AVCoreLog.isDevelopLevel()) {
                    AVCoreLog.e(TAG, "getSharpConfigVersionFromFile, payloadBufTmp[" + str + "], version[" + substring + "], payload[" + substring2 + "]");
                }
                try {
                    return Integer.parseInt(substring);
                } catch (Exception e16) {
                    AVCoreLog.e(TAG, "getSharpConfigVersionFromFile Exception, payloadBufTmp[" + str + "]", e16);
                }
            } else if (AVCoreLog.isDevelopLevel()) {
                AVCoreLog.d(TAG, "getSharpConfigVersionFromFile fail, payloadBufTmp[" + str + "]");
                AVCoreUtil.printHexStringEx(TAG, readFile);
            }
        }
        return 0;
    }

    private native void init();

    public byte[] getConfigInfoFromFile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (byte[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return Common.readFile(this.mContext, Common.FILE_NAME);
    }

    public String getSharpConfigPayloadFromFile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? getSharpConfigPayloadFromFile(this.mContext) : (String) iPatchRedirector.redirect((short) 2, (Object) this);
    }

    public int getSharpConfigVersionFromFile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? getSharpConfigVersionFromFile(this.mContext) : ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
    }
}
