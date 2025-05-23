package com.tencent.mobileqq.transfile;

import android.content.pm.PackageInfo;
import android.text.TextUtils;
import android.text.format.Time;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.guild.media.pic.config.api.IGuildPicPreDownLoadApi;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.richmediavfs.RmVFSUtils;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TransFileUtil {
    static IPatchRedirector $redirector_ = null;
    public static final String FILE_PHOTO_DIR = "photo/";
    private static final String HTTP_ENGINE_PATH = "httpengine";
    public static final Pattern HTTP_HOST_REGEX;
    public static final Pattern HTTP_URL_REGEX;
    static final String TAG = "TransFileUtil";
    private static final String TENCENT_DIR = "/Tencent/MobileQQ/";
    private static String sPrivateDir;
    public static String versionCode;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class FileInfo {
        static IPatchRedirector $redirector_;
        String fileDir;
        String name;
        String suffix;

        FileInfo(String str, String str2, String str3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, str2, str3);
                return;
            }
            this.fileDir = str;
            this.suffix = str2;
            this.name = str3;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38526);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        HTTP_URL_REGEX = Pattern.compile("https?://(\\d{1,3}\\.){3}\\d{1,3}(:\\d{1,5})?[/\\?].*");
        HTTP_HOST_REGEX = Pattern.compile("https?://[^/]*/{1}");
        versionCode = null;
    }

    public TransFileUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void addDomainToList(ArrayList<ServerAddr> arrayList, String str) {
        if (arrayList != null && str != null) {
            ServerAddr serverAddr = new ServerAddr();
            serverAddr.mIp = str;
            serverAddr.isDomain = true;
            arrayList.add(serverAddr);
        }
    }

    private static void buildAssistantFileInfo(String str, FileInfo fileInfo) {
        String str2 = fileInfo.fileDir + "ast/" + getPttTimeDir() + "/";
        fileInfo.fileDir = str2;
        fileInfo.fileDir = RmVFSUtils.getVFSPath(str2, true);
        fileInfo.suffix = ".ast";
        if (str == null) {
            fileInfo.name = getTransFileDateTime();
        }
    }

    private static void buildFileFileInfo(String str, byte[] bArr, FileInfo fileInfo) {
        fileInfo.fileDir = AppConstants.SDCARD_FILE_SAVE_PATH;
        if (str == null) {
            fileInfo.name = getTransFileDateTime();
            if (bArr != null) {
                fileInfo.name += HexUtil.bytes2HexStr(bArr).substring(0, 5);
            }
        } else {
            fileInfo.name = str;
        }
        fileInfo.suffix = "";
    }

    @NotNull
    protected static FileInfo buildFileInfo(String str, String str2, int i3, byte[] bArr) {
        FileInfo fileInfo = new FileInfo(AppConstants.SDCARD_PATH + str + "/", null, "");
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 23) {
                        if (i3 != 25) {
                            if (i3 != 53) {
                                if (i3 != 65) {
                                    if (i3 != 65537) {
                                        if (i3 == 327697) {
                                            buildAssistantFileInfo(str2, fileInfo);
                                        }
                                    }
                                } else {
                                    fileInfo.fileDir += FileMsg.FILE_PTT_DIR;
                                    fileInfo.suffix = ".slk";
                                    if (str2 == null) {
                                        fileInfo.name = "homework_" + getTransFileDateTime();
                                    }
                                }
                            } else {
                                fileInfo.fileDir += FileMsg.FILE_PTT_DIR;
                                fileInfo.suffix = ".slk";
                                if (str2 == null) {
                                    fileInfo.name = "vs_" + getTransFileDateTime();
                                }
                            }
                        } else {
                            fileInfo.fileDir += FileMsg.FILE_PTT_DIR;
                            fileInfo.suffix = ".slk";
                            if (str2 == null) {
                                fileInfo.name = "buluo_" + getTransFileDateTime();
                            }
                        }
                    } else {
                        fileInfo.fileDir += FileMsg.FILE_PTT_DIR;
                        fileInfo.suffix = ".slk";
                        if (str2 == null) {
                            fileInfo.name = "ef_" + getTransFileDateTime();
                        } else {
                            fileInfo.name = "ef_" + str2;
                        }
                    }
                } else {
                    buildPttFileInfo(str2, fileInfo);
                }
            }
            buildPicFileInfo(str2, bArr, fileInfo);
        } else {
            buildFileFileInfo(str2, bArr, fileInfo);
        }
        return fileInfo;
    }

    private static void buildPicFileInfo(String str, byte[] bArr, FileInfo fileInfo) {
        fileInfo.fileDir += "photo/";
        fileInfo.suffix = ".jpg";
        if (str == null) {
            fileInfo.name = getTransFileDateTime();
            if (bArr != null) {
                fileInfo.name += HexUtil.bytes2HexStr(bArr).substring(0, 5);
            }
        }
    }

    private static void buildPttFileInfo(String str, FileInfo fileInfo) {
        String str2 = fileInfo.fileDir + FileMsg.FILE_PTT_DIR + getPttTimeDir() + "/";
        fileInfo.fileDir = str2;
        fileInfo.fileDir = RmVFSUtils.getVFSPath(str2, true);
        fileInfo.suffix = ".amr";
        if (str == null) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "pttdown,33333");
            }
            fileInfo.name = "stream_" + getTransFileDateTime();
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "pttdown,name = " + fileInfo.name);
            }
        }
    }

    public static String buildTag(String str, String str2, String str3, String str4) {
        return LogTag.RICH_MEDIA + str4 + "." + str + "." + str2 + "." + str3;
    }

    private static String getExternalPath() {
        File externalCacheDir = BaseApplication.getContext().getExternalCacheDir();
        if (externalCacheDir != null) {
            return externalCacheDir.getParent();
        }
        return "";
    }

    public static ServerAddr getIpAndPortFromUrl(String str) {
        Pattern pattern = HTTP_URL_REGEX;
        ServerAddr serverAddr = null;
        if (pattern != null && str != null && pattern.matcher(str).matches() && str.split("/").length >= 3) {
            serverAddr = new ServerAddr();
            String[] split = str.split("/")[2].split(":");
            serverAddr.mIp = split[0];
            if (split.length == 2) {
                serverAddr.port = Integer.valueOf(split[1]).intValue();
            } else {
                serverAddr.port = 80;
            }
        }
        return serverAddr;
    }

    public static String getIpOrDomainFromURL(String str) {
        if (str != null) {
            Matcher matcher = Pattern.compile("http://([^/\\s]*)/").matcher(str);
            if (matcher.find()) {
                return matcher.group(0);
            }
            return str;
        }
        return str;
    }

    public static String getPttTimeDir() {
        Time time = new Time();
        time.setToNow();
        return getPttTimeDirByTime(time);
    }

    @NotNull
    protected static String getPttTimeDirByTime(Time time) {
        StringBuilder sb5;
        if (time.month + 1 > 9) {
            sb5 = new StringBuilder();
            sb5.append("");
        } else {
            sb5 = new StringBuilder();
            sb5.append("0");
        }
        sb5.append(time.month + 1);
        return "" + time.year + sb5.toString() + "/" + time.monthDay;
    }

    public static String getTempPath(NetReq netReq, String str, String str2) {
        String str3;
        if (netReq != null && (str3 = netReq.mTempPath) != null && str3.length() > 0) {
            return netReq.mTempPath;
        }
        return str2 + HTTP_ENGINE_PATH + File.separator + MD5.toMD5(getUrlResoursePath(str, false)) + ".tmp";
    }

    private static synchronized String getTransFileDateTime() {
        String format;
        synchronized (TransFileUtil.class) {
            try {
                LockMethodProxy.sleep(1L);
            } catch (InterruptedException e16) {
                e16.printStackTrace();
            }
            format = new SimpleDateFormat("yyyyMMddHHmmssSS").format(new Date(System.currentTimeMillis()));
        }
        return format;
    }

    public static String getTransferFilePath(String str, String str2, int i3, byte[] bArr) {
        return getTransferFilePath(str, str2, i3, bArr, true);
    }

    public static String getUinDesc(int i3) {
        String str = "" + i3;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 3000) {
                    if (i3 == 10014) {
                        return IGuildPicPreDownLoadApi.GUILD_PIC_LOG_TAG;
                    }
                    return str;
                }
                return "dis";
            }
            return "grp";
        }
        return "c2c";
    }

    public static String getUrlResoursePath(String str, boolean z16) {
        if (getIpAndPortFromUrl(str) == null && !z16) {
            return str;
        }
        Matcher matcher = HTTP_HOST_REGEX.matcher(str);
        if (matcher.find()) {
            return str.replace(matcher.group(), "");
        }
        return str;
    }

    public static synchronized String getVersionCode() {
        synchronized (TransFileUtil.class) {
            String str = versionCode;
            if (str != null) {
                return str;
            }
            versionCode = "unkownVersion";
            try {
                PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(BaseApplication.getContext().getPackageManager(), BaseApplication.getContext().getPackageName(), 0);
                versionCode = packageInfo.versionName + "." + packageInfo.versionCode;
            } catch (Exception e16) {
                versionCode = "unkownVersion";
                e16.printStackTrace();
            }
            return versionCode;
        }
    }

    public static String getsPrivateDir() {
        if (TextUtils.isEmpty(sPrivateDir)) {
            String externalPath = getExternalPath();
            if (TextUtils.isEmpty(externalPath)) {
                externalPath = BaseApplication.getContext().getCacheDir().getAbsolutePath();
            }
            sPrivateDir = externalPath + TENCENT_DIR;
        }
        return sPrivateDir;
    }

    public static void log(String str, boolean z16, String str2, String str3, String str4, String str5) {
        log("T", str, z16, str2, str3, str4, str5, null);
    }

    public static void printRichMediaDebug(Object obj, String str, String str2) {
        QLog.d("Q.richmedia.L." + obj, 2, "step:" + str + "    \tcontent:" + str2);
    }

    public static void printRichMediaError(Object obj, String str, String str2) {
        QLog.e("Q.richmedia.L." + obj, 2, "step:" + str + "    \tcontent:" + str2);
    }

    public static String replaceIp(String str, String str2) {
        if (str != null && str2 != null && str2.length() > 0) {
            return str.replaceFirst("https?://[^/\\s]*/", str2);
        }
        return str;
    }

    public static String getTransferFilePath(String str, String str2, int i3, byte[] bArr, boolean z16) {
        FileInfo buildFileInfo = buildFileInfo(str, str2, i3, bArr);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getTransferFilePath dir: " + buildFileInfo.fileDir);
        }
        File file = new File(buildFileInfo.fileDir);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(buildFileInfo.fileDir + buildFileInfo.name + buildFileInfo.suffix);
        if (i3 != 0 && z16 && !file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException unused) {
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getTransferFilePath : " + file2.getAbsoluteFile().toString());
        }
        return file2.getAbsoluteFile().toString();
    }

    public static void log(String str, String str2, boolean z16, String str3, String str4, String str5, String str6, Throwable th5) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("id:");
        sb5.append(str4);
        String str7 = z16 ? "up" : "dw";
        sb5.append(" \tstep:");
        sb5.append(str5);
        sb5.append(" \tcont:");
        sb5.append(str6);
        sb5.append(" \tver:");
        sb5.append(getVersionCode());
        if ("T".equals(str)) {
            sb5.append(" \ttid:");
            sb5.append(Thread.currentThread().getId());
        }
        String buildTag = buildTag(str2, str3, str7, str);
        if (th5 != null) {
            QLog.e(buildTag, 1, sb5.toString(), th5);
        } else if (QLog.isColorLevel()) {
            QLog.d(buildTag, 2, sb5.toString());
        }
    }
}
