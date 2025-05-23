package com.tencent.live2.jsplugin;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;

/* loaded from: classes7.dex */
public class LiveURLParser {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "LiveURLParser";

    public LiveURLParser() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String getStreamId(String str) {
        int length;
        int i3;
        try {
        } catch (Exception unused) {
            LiteavLog.e(TAG, "getStreamId fail, url:".concat(String.valueOf(str)));
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf("/");
        if (str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            length = str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        } else {
            length = str.length();
        }
        if (lastIndexOf != -1 && length != -1 && length > (i3 = lastIndexOf + 1)) {
            return str.substring(i3, length);
        }
        return "";
    }

    public static String getURLParams(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String[] split = str.split("\\?");
            if (split.length < 2) {
                return "";
            }
            for (String str3 : split[1].split(ContainerUtils.FIELD_DELIMITER)) {
                if (str3.indexOf(ContainerUtils.KEY_VALUE_DELIMITER) > 0) {
                    String substring = str3.substring(0, str3.indexOf(ContainerUtils.KEY_VALUE_DELIMITER));
                    String substring2 = str3.substring(str3.indexOf(ContainerUtils.KEY_VALUE_DELIMITER) + 1);
                    if (substring.equalsIgnoreCase(str2)) {
                        return substring2;
                    }
                }
            }
        }
        return "";
    }
}
