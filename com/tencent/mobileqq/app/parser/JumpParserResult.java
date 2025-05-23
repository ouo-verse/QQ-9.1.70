package com.tencent.mobileqq.app.parser;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.util.HashMap;

/* loaded from: classes11.dex */
public class JumpParserResult {
    static IPatchRedirector $redirector_;
    private static String TAG;
    private String mAction;
    private HashMap<String, String> mParamMap;
    private String mParamString;
    private String mScheme;
    private String mServer;
    private String mUrl;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42417);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            TAG = "JumpParserResult";
        }
    }

    public JumpParserResult(String str, String str2, String str3, String str4, String str5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, str3, str4, str5);
            return;
        }
        str = str == null ? "" : str;
        str2 = str2 == null ? "" : str2;
        str3 = str3 == null ? "" : str3;
        str4 = str4 == null ? "" : str4;
        this.mScheme = str;
        this.mServer = str2;
        this.mAction = str3;
        this.mParamString = str4;
        this.mUrl = str5;
        this.mParamMap = new HashMap<>();
    }

    public static String generateKeyWithInfo(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "generateKeyWithInfo error: scheme is empty");
            return "";
        }
        if (str2 == null) {
            str2 = "";
        }
        if (str3 == null) {
            str3 = "";
        }
        if (str4 == null) {
            str4 = "";
        }
        if (str.contains(QzoneWebViewOfflinePlugin.STR_DEVIDER)) {
            QLog.d(TAG, 1, "scheme with ://");
        } else {
            str = str + QzoneWebViewOfflinePlugin.STR_DEVIDER;
        }
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            str3 = "/" + str3;
        } else if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            QLog.d(TAG, 1, "generateKeyWithInfo: action is empty");
        } else if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            QLog.d(TAG, 1, "generateKeyWithInfo: server and action is empty");
        } else {
            QLog.e(TAG, 1, "generateKeyWithInfo error: server is empty but action is not empty");
            return "";
        }
        if (!TextUtils.isEmpty(str4) && !str4.startsWith(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            str4 = QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + str4;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        sb5.append(str2);
        sb5.append(str3);
        sb5.append(str4);
        QLog.d(TAG, 1, "generateKeyWithInfo: " + ((Object) sb5));
        return sb5.toString();
    }

    public String generateKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.mScheme);
        sb5.append(QzoneWebViewOfflinePlugin.STR_DEVIDER);
        sb5.append(this.mServer);
        sb5.append("/");
        sb5.append(this.mAction);
        sb5.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        sb5.append(this.mParamString);
        QLog.d(TAG, 1, "generateKey: " + ((Object) sb5));
        return sb5.toString();
    }

    public String getAction() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mAction;
    }

    public HashMap<String, String> getParamMap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (HashMap) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mParamMap;
    }

    public String getParamString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mParamString;
    }

    public String getScheme() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mScheme;
    }

    public String getServer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mServer;
    }

    public String getUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.mUrl;
    }

    public void putAttribute(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str, (Object) str2);
            return;
        }
        HashMap<String, String> hashMap = this.mParamMap;
        if (hashMap == null) {
            return;
        }
        hashMap.put(str, str2);
    }

    public void setAction(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
            return;
        }
        if (str == null) {
            str = "";
        }
        this.mAction = str;
    }

    public void setParamMap(HashMap<String, String> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) hashMap);
        } else {
            this.mParamMap = hashMap;
        }
    }

    public void setParamString(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
            return;
        }
        if (str == null) {
            str = "";
        }
        this.mParamString = str;
    }

    public void setScheme(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            return;
        }
        if (str == null) {
            str = "";
        }
        this.mScheme = str;
    }

    public void setServer(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
            return;
        }
        if (str == null) {
            str = "";
        }
        this.mServer = str;
    }
}
