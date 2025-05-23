package com.tencent.mobileqq.soload.biz.entity;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.soload.util.e;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SoLocalInfo {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "SoLoadWidget.SoLocalInfo";
    public String mRFileFolder;
    public String mRFileUrl;
    public long mSoCRC;
    public String mSoName;
    public String mSoPath;
    public String mSoVer;
    public String mUrl;

    public SoLocalInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.mSoCRC = -1L;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static SoLocalInfo createSoLocalInfo(String str) {
        SoLocalInfo soLocalInfo = new SoLocalInfo();
        try {
            Uri parse = Uri.parse(str);
            soLocalInfo.mSoVer = parse.getQueryParameter("ver");
            soLocalInfo.mSoName = parse.getQueryParameter("name");
            soLocalInfo.mSoPath = parse.getQueryParameter("path");
            soLocalInfo.mSoCRC = parseCRC(parse.getQueryParameter("crc"));
            soLocalInfo.mUrl = parse.getQueryParameter("url");
            soLocalInfo.mRFileUrl = parse.getQueryParameter("rUrl");
            soLocalInfo.mRFileFolder = parse.getQueryParameter("rPath");
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
        return soLocalInfo;
    }

    private static long parseCRC(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return Long.parseLong(str);
            }
            return -1L;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
            return -1L;
        }
    }

    public String encode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + "ver=" + this.mSoVer + "&name=" + this.mSoName + "&path=" + e.a(this.mSoPath) + "&crc=" + this.mSoCRC + "&url=" + e.a(this.mUrl) + "&rUrl=" + e.a(this.mRFileUrl) + "&rPath=" + e.a(this.mRFileFolder);
    }

    public SoLocalInfo(String str, String str2, String str3, long j3, String str4, String str5, String str6) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, str3, Long.valueOf(j3), str4, str5, str6);
            return;
        }
        this.mSoVer = str;
        this.mSoName = str2;
        this.mSoPath = str3;
        this.mSoCRC = j3;
        this.mUrl = str4;
        this.mRFileUrl = str5;
        this.mRFileFolder = str6;
    }
}
