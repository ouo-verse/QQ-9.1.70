package com.tencent.hydevteam.pluginframework.pluginmanager;

import com.tencent.commonsdk.zip.QZipInputStream;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import cooperation.photoplus.sticker.Sticker;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.ZipEntry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes7.dex */
class SimpleVersionChecker implements VersionChecker {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static String f114778a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11805);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f114778a = "https://dldir1.qq.com/huayang/Android/$TYPE$_StableBackupUrl_1_4.zip";
        }
    }

    SimpleVersionChecker() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static JSONObject a(String str, String str2, boolean z16) throws VersionCheckException {
        try {
            try {
                URLConnection openConnection = new URL("https://tiantian.qq.com/cgi-bin/hylove/version?platform=2&apptype=" + str2 + "&mode=" + (z16 ? 1 : 0) + "&frameversion=5&cursdkversion=0&uin=" + str).openConnection();
                if (openConnection instanceof HttpURLConnection) {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                    try {
                        try {
                            int responseCode = httpURLConnection.getResponseCode();
                            if (responseCode == 200) {
                                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                                StringBuilder sb5 = new StringBuilder("");
                                while (true) {
                                    try {
                                        String readLine = bufferedReader.readLine();
                                        if (readLine != null) {
                                            sb5.append(readLine);
                                            sb5.append("\n");
                                        } else {
                                            bufferedReader.close();
                                            return new JSONObject(sb5.toString());
                                        }
                                    } catch (Throwable th5) {
                                        bufferedReader.close();
                                        throw th5;
                                    }
                                }
                            } else {
                                throw new VersionCheckException("\u8bf7\u6c42\u670d\u52a1\u5668\u7aef\u5931\u8d25, HTTP\u8fd4\u56de\u7801:" + responseCode);
                            }
                        } catch (IOException e16) {
                            throw new VersionCheckException("IOException", e16);
                        } catch (JSONException e17) {
                            throw new VersionCheckException("\u89e3\u6790Json\u53d1\u751f\u9519\u8bef", e17);
                        }
                    } finally {
                        httpURLConnection.disconnect();
                    }
                } else {
                    throw new VersionCheckException("CGI\u4e0d\u662fhttp\u8fde\u63a5,\u9519\u8bef!");
                }
            } catch (IOException e18) {
                throw new VersionCheckException("\u6253\u5f00\u94fe\u63a5\u5931\u8d25", e18);
            }
        } catch (MalformedURLException e19) {
            throw new VersionCheckException("URL\u4e0d\u5408\u6cd5!", e19);
        }
    }

    @Override // com.tencent.hydevteam.pluginframework.pluginmanager.VersionChecker
    public TargetDownloadInfo check(String str, String str2, String str3, boolean z16) throws VersionCheckException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TargetDownloadInfo) iPatchRedirector.redirect((short) 2, this, str, str2, str3, Boolean.valueOf(z16));
        }
        str.hashCode();
        if (!str.equals(VersionChecker.SOURCE_BACKUP_STABLE)) {
            if (str.equals(VersionChecker.SOURCE_CGI)) {
                return a(a(str2, str3, z16));
            }
            throw new VersionCheckException("\u4e0d\u652f\u6301\u7684source:" + str);
        }
        String replace = f114778a.replace("$TYPE$", str3);
        f114778a = replace;
        return a(a(replace, str3));
    }

    @Override // com.tencent.hydevteam.pluginframework.pluginmanager.VersionChecker
    public TargetDownloadInfo checkForceUpdate(String str, String str2, String str3, boolean z16, InstalledPlugin installedPlugin) throws VersionCheckException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TargetDownloadInfo) iPatchRedirector.redirect((short) 3, this, str, str2, str3, Boolean.valueOf(z16), installedPlugin);
        }
        throw new RuntimeException("SimpleVersionChecker\u6682\u4e0d\u652f\u6301checkForceUpdate");
    }

    private static JSONObject a(String str, String str2) throws VersionCheckException {
        ZipEntry nextEntry;
        try {
            try {
                URLConnection openConnection = new URL(str).openConnection();
                if (openConnection instanceof HttpURLConnection) {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                    try {
                        try {
                            int responseCode = httpURLConnection.getResponseCode();
                            if (responseCode == 200) {
                                QZipInputStream qZipInputStream = new QZipInputStream(new BufferedInputStream(httpURLConnection.getInputStream()));
                                while (true) {
                                    try {
                                        nextEntry = qZipInputStream.getNextEntry();
                                        if (nextEntry == null) {
                                            nextEntry = null;
                                            break;
                                        }
                                        if (nextEntry.getName().equals(str2 + Sticker.JSON_SUFFIX)) {
                                            break;
                                        }
                                    } finally {
                                        qZipInputStream.close();
                                    }
                                }
                                if (nextEntry != null) {
                                    long size = nextEntry.getSize();
                                    if (size > TTL.MAX_VALUE) {
                                        throw new VersionCheckException(nextEntry + "\u7684\u538b\u7f29\u524d\u5927\u5c0f\u4e0d\u80fd\u8d85\u8fc72147483647");
                                    }
                                    if (size != -1) {
                                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((int) size);
                                        while (true) {
                                            try {
                                                int read = qZipInputStream.read();
                                                if (read != -1) {
                                                    byteArrayOutputStream.write(read);
                                                } else {
                                                    qZipInputStream.closeEntry();
                                                    return new JSONObject(byteArrayOutputStream.toString());
                                                }
                                            } finally {
                                                byteArrayOutputStream.close();
                                            }
                                        }
                                    } else {
                                        throw new VersionCheckException(nextEntry + "\u7684size\u6ca1\u6709\u8bbe\u7f6e");
                                    }
                                } else {
                                    throw new VersionCheckException("\u627e\u4e0d\u5230" + str2 + Sticker.JSON_SUFFIX);
                                }
                            } else {
                                throw new VersionCheckException("\u8bf7\u6c42\u670d\u52a1\u5668\u7aef\u5931\u8d25, HTTP\u8fd4\u56de\u7801:" + responseCode);
                            }
                        } catch (IOException e16) {
                            throw new VersionCheckException("IOException", e16);
                        } catch (JSONException e17) {
                            throw new VersionCheckException("\u89e3\u6790Json\u53d1\u751f\u9519\u8bef", e17);
                        }
                    } finally {
                        httpURLConnection.disconnect();
                    }
                } else {
                    throw new VersionCheckException("URL\u4e0d\u662fhttp\u534f\u8bae\u7684,\u4e0d\u652f\u6301!");
                }
            } catch (IOException e18) {
                throw new VersionCheckException("\u6253\u5f00\u94fe\u63a5\u5931\u8d25", e18);
            }
        } catch (MalformedURLException e19) {
            throw new VersionCheckException("\u4e0b\u8f7dURL\u4e0d\u5408\u6cd5", e19);
        }
    }

    private static TargetDownloadInfo a(JSONObject jSONObject) throws VersionCheckException {
        try {
            int i3 = jSONObject.getInt("errCode");
            String str = null;
            if (i3 == 0) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("data").getJSONObject("targetversion");
                String.valueOf(jSONObject2.getInt("versionno"));
                JSONArray jSONArray = jSONObject2.getJSONArray("content");
                long j3 = 0;
                String str2 = null;
                String str3 = null;
                boolean z16 = false;
                for (int i16 = 0; i16 < jSONArray.length(); i16++) {
                    JSONObject jSONObject3 = jSONArray.getJSONObject(i16);
                    if (jSONObject3.getString("type").equals("default")) {
                        String string = jSONObject3.getString("url");
                        str2 = jSONObject3.getString("hash");
                        try {
                            str3 = string;
                            z16 = true;
                            j3 = Long.parseLong(jSONObject3.getString("size"));
                        } catch (NumberFormatException e16) {
                            throw new VersionCheckException("size\u4e0d\u662f\u6570\u5b57", e16);
                        }
                    }
                    if (z16) {
                        break;
                    }
                }
                if (z16) {
                    return new SimpleTargetDownloadInfo(str3, str2, j3);
                }
                throw new VersionCheckException("json\u4e2d\u4e0d\u5305\u542b\u76ee\u6807content,\u76ee\u6807content\u7684type\u662fdefault");
            }
            try {
                str = jSONObject.getString("message");
            } catch (JSONException unused) {
            }
            throw new VersionCheckException("\u67e5\u8be2\u51fa\u9519\u3002errCode==" + i3 + " message==" + str);
        } catch (JSONException e17) {
            throw new VersionCheckException("Json\u4e0d\u7b26\u5408\u9884\u671f", e17);
        }
    }
}
