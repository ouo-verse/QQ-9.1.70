package com.tencent.mobileqq.qshadow.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.shadow.core.common.Logger;
import com.tencent.shadow.core.common.LoggerFactory;
import com.tencent.shadow.dynamic.host.ShadowTag;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QShadowRepository {
    static IPatchRedirector $redirector_ = null;
    private static final String QSHADOW_SP = "QShadow_SP";
    private static final Logger mLogger;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36720);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            mLogger = LoggerFactory.getLogger(ShadowTag.class);
        }
    }

    QShadowRepository() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void deleteInstalledPlugin(Context context, String str) {
        getSP(context).edit().putString(str, "").apply();
    }

    public static Map<String, String> getAllInstallPlugin(Context context) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, ?> entry : getSP(context).getAll().entrySet()) {
            hashMap.put(entry.getKey(), (String) entry.getValue());
        }
        return hashMap;
    }

    public static String getInstalledPlugin(Context context, String str, String str2) {
        return getSP(context).getString(str, str2);
    }

    private static SharedPreferences getSP(Context context) {
        return context.getSharedPreferences(QSHADOW_SP, 0);
    }

    public static String getStringFromStream(InputStream inputStream) {
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream));
                try {
                    StringBuilder sb5 = new StringBuilder("");
                    while (true) {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb5.append(readLine);
                    }
                    String sb6 = sb5.toString();
                    try {
                        bufferedReader2.close();
                    } catch (IOException e16) {
                        e16.printStackTrace();
                    }
                    return sb6;
                } catch (Exception e17) {
                    e = e17;
                    bufferedReader = bufferedReader2;
                    mLogger.error("plugin_tag getStringFromStream error: ", (Throwable) e);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e18) {
                            e18.printStackTrace();
                        }
                    }
                    return "";
                } catch (Throwable th5) {
                    th = th5;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e19) {
                            e19.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e26) {
                e = e26;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static String getUuidFromFile(File file) {
        if (!file.exists()) {
            return "";
        }
        try {
            return getUuidFromStream(new FileInputStream(file));
        } catch (FileNotFoundException e16) {
            mLogger.error("plugin_tag get uuid error: ", (Throwable) e16);
            return "";
        }
    }

    public static String getUuidFromStream(InputStream inputStream) {
        try {
            return new JSONObject(getStringFromStream(inputStream)).getString("UUID");
        } catch (JSONException e16) {
            mLogger.error("plugin_tag getUuidFromStream error: ", (Throwable) e16);
            return "";
        }
    }

    public static void saveInstalledPlugin(Context context, String str, String str2) {
        getSP(context).edit().putString(str, str2).apply();
    }
}
