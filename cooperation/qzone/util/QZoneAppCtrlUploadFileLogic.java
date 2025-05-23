package cooperation.qzone.util;

import android.content.Context;
import android.net.http.Headers;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.testassister.ShareAppLogHelper;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mtt.hippy.adapter.http.HttpHeader;
import com.tencent.mtt.hippy.bridge.HippyBridge;
import com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor;
import com.tencent.qphone.base.util.QLog;
import common.qzone.component.util.SecurityUtil;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* compiled from: P */
/* loaded from: classes38.dex */
public class QZoneAppCtrlUploadFileLogic {
    public static final String ANR_LOG_DIRECTORY = "anr";
    public static final String ANR_LOG_PATH;
    public static final String ANR_PATH = "ANR";
    public static final String AVSDK_LOG_DIRECTORY = "avsdk";
    private static final String CHARSET = "utf-8";
    public static final int CODE_LOG_SIZE_WARNING = 1;
    public static final int CODE_LOG_ZIP_FAILED = -3;
    public static final int CODE_SUCC = 0;
    static final String CONTENT_TYPE = "multipart/form-data";
    public static final String DATABASE_PATH = "databases";
    public static final String DB_PATH = "DB";
    public static final long ERROR_TIME = -1;
    static final String LINE_END = "\r\n";
    public static final String LOGCAT_PATH = "LOGCAT";
    static final String PREFIX = "--";
    static final String REQUESTURL = "http://zhizi.qq.com/uploadfile.php";
    public static final String TAG = "QZoneAppCtrlUploadFileLogic";
    private static final int TIME_OUT = 100000000;
    public static final String TRACE_PATH = "TRACE";
    static final int UPLOAD_PID = 3;
    public static final int WARNING_SIZE_LEVLE = 26214400;
    public static final String ZIP_DIR;

    static {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(ANR_LOG_DIRECTORY);
        String str = File.separator;
        sb5.append(str);
        sb5.append("traces.txt");
        ANR_LOG_PATH = sb5.toString();
        ZIP_DIR = "tencent" + str + "zip";
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void saveLogcatToFileV2(Context context, String str) {
        File file;
        try {
            InputStream inputStream = RuntimeMonitor.exec(Runtime.getRuntime(), "logcat -v time -b main").getInputStream();
            if (Environment.getExternalStorageState().equals("mounted")) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(Environment.getExternalStorageDirectory().getAbsolutePath());
                String str2 = File.separator;
                sb5.append(str2);
                String str3 = ZIP_DIR;
                sb5.append(str3);
                sb5.append(str2);
                sb5.append(LOGCAT_PATH);
                File file2 = new File(VFSAssistantUtils.getSDKPrivatePath(sb5.toString()));
                if (!file2.exists()) {
                    if (QLog.isDevelopLevel()) {
                        QLog.d(TAG, 4, "saveLogcatToFile mkdirs: " + file2.getAbsolutePath());
                    }
                    file2.mkdirs();
                }
                file = new File(VFSAssistantUtils.getSDKPrivatePath(Environment.getExternalStorageDirectory().getAbsolutePath() + str2 + str3 + str2 + LOGCAT_PATH + str2 + str + "logcatwyx.txt"));
                if (!file.exists()) {
                    if (QLog.isDevelopLevel()) {
                        QLog.d(TAG, 4, "saveLogcatToFile createNewFile: " + file.getAbsolutePath());
                    }
                    file.createNewFile();
                }
            } else {
                file = null;
            }
            byte[] bArr = new byte[1024];
            if (QLog.isDevelopLevel()) {
                QLog.d(TAG, 4, "saveLogcatToFile start read logcat");
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    int i3 = 1048576;
                    while (true) {
                        if (i3 <= 0) {
                            break;
                        }
                        long currentTimeMillis2 = System.currentTimeMillis();
                        long j3 = currentTimeMillis2 - currentTimeMillis;
                        if (j3 > 10000) {
                            if (QLog.isDevelopLevel()) {
                                QLog.d(TAG, 4, "saveLogcatToFile current time:" + currentTimeMillis2 + "\t start time:" + currentTimeMillis + "\t offset:" + j3);
                            }
                        } else {
                            int read = inputStream.read(bArr, 0, Math.min(i3, 1024));
                            if (read != -1) {
                                fileOutputStream.write(bArr, 0, read);
                                i3 -= read;
                            } else {
                                throw new EOFException("reach end of log data");
                            }
                        }
                    }
                } finally {
                    fileOutputStream.close();
                    uploadLogcat(context, str);
                }
            } finally {
                inputStream.close();
            }
        } catch (IOException e16) {
            e16.printStackTrace();
            if (QLog.isDevelopLevel()) {
                QLog.d(TAG, 4, "saveLogcatToFile exception: " + e16.toString());
            }
        }
    }

    public static void showDirFileList(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            str = VFSAssistantUtils.getSDKPrivatePath(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "tencent");
        }
        try {
            File file = new File(str);
            if (file.isDirectory()) {
                QLog.e(TAG, 1, "showDirFileList dirPath:" + file.getAbsolutePath());
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (int i3 = 0; i3 < listFiles.length; i3++) {
                        if (listFiles[i3].isDirectory()) {
                            QLog.e(TAG, 1, "dir:" + listFiles[i3].getAbsolutePath());
                        }
                        if (listFiles[i3].isFile()) {
                            QLog.e(TAG, 1, HippyBridge.URI_SCHEME_FILE + listFiles[i3].getAbsolutePath() + ",size:" + listFiles[i3].length());
                        }
                    }
                    return;
                }
                return;
            }
            if (file.isFile()) {
                QLog.e(TAG, 1, "showDirFileList filePath:" + file.getAbsolutePath());
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private static int stepZipLogFile(String str, File file) {
        ZipOutputStream zipOutputStream;
        Throwable th5;
        BufferedInputStream bufferedInputStream;
        Throwable th6;
        try {
            File file2 = new File(str);
            try {
                zipOutputStream = new ZipOutputStream(new FileOutputStream(file2));
            } catch (Throwable th7) {
                zipOutputStream = null;
                th5 = th7;
            }
            try {
                byte[] bArr = new byte[1024];
                ZipEntry zipEntry = new ZipEntry(file.getName());
                zipEntry.setSize(file.length());
                zipEntry.setTime(file.lastModified());
                zipOutputStream.putNextEntry(zipEntry);
                try {
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                    while (true) {
                        try {
                            int read = bufferedInputStream.read(bArr, 0, 1024);
                            if (read == -1) {
                                break;
                            }
                            zipOutputStream.write(bArr, 0, read);
                        } catch (Throwable th8) {
                            th6 = th8;
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                            throw th6;
                        }
                    }
                    bufferedInputStream.close();
                    zipOutputStream.close();
                    if (file2.length() >= 26214400) {
                        if (QLog.isDevelopLevel()) {
                            QLog.d(TAG, 4, "stepZipLogFile result: 26214400");
                        }
                        zipOutputStream.close();
                        return 1;
                    }
                    if (QLog.isDevelopLevel()) {
                        QLog.d(TAG, 4, "stepZipLogFile result: 0");
                    }
                    zipOutputStream.close();
                    return 0;
                } catch (Throwable th9) {
                    bufferedInputStream = null;
                    th6 = th9;
                }
            } catch (Throwable th10) {
                th5 = th10;
                if (zipOutputStream != null) {
                    zipOutputStream.close();
                }
                throw th5;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            if (!QLog.isDevelopLevel()) {
                return -3;
            }
            QLog.d(TAG, 4, "stepZipLogFile result: -3");
            return -3;
        }
    }

    private static int stepZipLogFiles(String str, ArrayList<File> arrayList) {
        ZipOutputStream zipOutputStream;
        Throwable th5;
        BufferedInputStream bufferedInputStream;
        Throwable th6;
        try {
            File file = new File(str);
            try {
                zipOutputStream = new ZipOutputStream(new FileOutputStream(file));
            } catch (Throwable th7) {
                zipOutputStream = null;
                th5 = th7;
            }
            try {
                byte[] bArr = new byte[1024];
                Iterator<File> it = arrayList.iterator();
                while (it.hasNext()) {
                    File next = it.next();
                    ZipEntry zipEntry = new ZipEntry(next.getName());
                    zipEntry.setSize(next.length());
                    zipEntry.setTime(next.lastModified());
                    zipOutputStream.putNextEntry(zipEntry);
                    try {
                        bufferedInputStream = new BufferedInputStream(new FileInputStream(next));
                        while (true) {
                            try {
                                int read = bufferedInputStream.read(bArr, 0, 1024);
                                if (read != -1) {
                                    zipOutputStream.write(bArr, 0, read);
                                }
                            } catch (Throwable th8) {
                                th6 = th8;
                                if (bufferedInputStream != null) {
                                    bufferedInputStream.close();
                                    throw th6;
                                }
                                throw th6;
                            }
                        }
                        bufferedInputStream.close();
                    } catch (Throwable th9) {
                        bufferedInputStream = null;
                        th6 = th9;
                    }
                }
                zipOutputStream.close();
                if (file.length() >= 26214400) {
                    zipOutputStream.close();
                    return 1;
                }
                zipOutputStream.close();
                return 0;
            } catch (Throwable th10) {
                th5 = th10;
                if (zipOutputStream != null) {
                    zipOutputStream.close();
                    throw th5;
                }
                throw th5;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            if (!QLog.isDevelopLevel()) {
                return -3;
            }
            QLog.d(TAG, 4, "stepZipLogFiles result: -3");
            return -3;
        }
    }

    public static void uploadANR(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(Environment.getDataDirectory().getAbsolutePath());
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append(ANR_LOG_DIRECTORY);
        File file = new File(VFSAssistantUtils.getSDKPrivatePath(sb5.toString()));
        if (!file.isDirectory() || file.listFiles() == null) {
            return;
        }
        String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(Environment.getExternalStorageDirectory().getAbsolutePath() + str2 + ZIP_DIR + str2 + ANR_PATH);
        StringBuilder sb6 = new StringBuilder();
        sb6.append(sDKPrivatePath);
        sb6.append(str2);
        sb6.append("upload.log.zip");
        String sb7 = sb6.toString();
        File file2 = new File(sDKPrivatePath);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        uploadFile(file, sb7, str);
    }

    public static void uploadAvsdk(Context context, String str, final long j3, final long j16) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(Environment.getExternalStorageDirectory().getAbsolutePath());
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append("tencent");
        sb5.append(str2);
        sb5.append(MimeHelper.MIME_TYPE_MOBILEQQ);
        sb5.append(str2);
        sb5.append("log");
        sb5.append(str2);
        sb5.append(AVSDK_LOG_DIRECTORY);
        File file = new File(VFSAssistantUtils.getSDKPrivatePath(sb5.toString()));
        FilenameFilter filenameFilter = new FilenameFilter() { // from class: cooperation.qzone.util.QZoneAppCtrlUploadFileLogic.3
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str3) {
                if ((!str3.startsWith("QAVSDK") && !str3.startsWith("qavsdk")) || str3.split("_").length == 2) {
                    return false;
                }
                File file3 = new File(file2 + File.separator + str3);
                if (!file3.exists()) {
                    return false;
                }
                long lastModified = file3.lastModified();
                if (QLog.isDevelopLevel()) {
                    QLog.d(QZoneAppCtrlUploadFileLogic.TAG, 4, "file dir: " + file2.getName());
                    QLog.d(QZoneAppCtrlUploadFileLogic.TAG, 4, "file name: " + str3 + " mStartTime: " + j3 + " mEndTime: " + j16 + " lastModifiedTime: " + lastModified);
                }
                if (lastModified < j3 || lastModified > j16) {
                    return false;
                }
                if (!QLog.isDevelopLevel()) {
                    return true;
                }
                QLog.d(QZoneAppCtrlUploadFileLogic.TAG, 4, "find file name: " + str3);
                return true;
            }
        };
        if (!file.isDirectory() || file.listFiles() == null) {
            return;
        }
        String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(Environment.getExternalStorageDirectory().getAbsolutePath() + str2 + ZIP_DIR + str2 + AVSDK_LOG_DIRECTORY);
        StringBuilder sb6 = new StringBuilder();
        sb6.append(sDKPrivatePath);
        sb6.append(str2);
        sb6.append("upload.log.zip");
        String sb7 = sb6.toString();
        File file2 = new File(sDKPrivatePath);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        uploadFile(file, filenameFilter, sb7, str);
    }

    public static void uploadByCustom(Context context, String str, String str2, long j3, boolean z16) {
        String sDKPrivatePath;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || context == null) {
            return;
        }
        if (z16) {
            sDKPrivatePath = context.getFilesDir() != null ? context.getFilesDir().getParent() : null;
        } else {
            sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "tencent");
        }
        if (TextUtils.isEmpty(sDKPrivatePath)) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(Environment.getExternalStorageDirectory().getAbsolutePath());
        String str3 = File.separator;
        sb5.append(str3);
        sb5.append(ZIP_DIR);
        sb5.append(str3);
        sb5.append("custom");
        String sDKPrivatePath2 = VFSAssistantUtils.getSDKPrivatePath(sb5.toString());
        File file = new File(sDKPrivatePath2);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str4 = sDKPrivatePath2 + str3 + "upload.log.zip";
        File file2 = new File(sDKPrivatePath, str);
        if (!file2.isFile() || file2.length() >= j3) {
            return;
        }
        uploadFile(file2, str4, str2);
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "uploadByCustom filename: " + str4);
        }
    }

    public static void uploadDB(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = SecurityUtil.c(str);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(context.getFilesDir().getParent());
        String str3 = File.separator;
        sb5.append(str3);
        sb5.append(DATABASE_PATH);
        sb5.append(str3);
        sb5.append(str2);
        String sb6 = sb5.toString();
        String str4 = Environment.getExternalStorageDirectory().getAbsolutePath() + str3 + ZIP_DIR + str3 + DB_PATH;
        File file = new File(VFSAssistantUtils.getSDKPrivatePath(str4));
        if (!file.exists()) {
            file.mkdirs();
        }
        uploadFile(new File(sb6), VFSAssistantUtils.getSDKPrivatePath(str4 + str3 + "upload.log.zip"), str);
    }

    public static boolean uploadFile(File file, FilenameFilter filenameFilter, String str, String str2) {
        int i3;
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.exists()) {
            if (file.getName().contains(AVSDK_LOG_DIRECTORY) && file.isDirectory()) {
                ArrayList arrayList = new ArrayList();
                File[] listFiles = file.listFiles(filenameFilter);
                if (listFiles != null && listFiles.length != 0) {
                    for (File file2 : listFiles) {
                        arrayList.add(file2);
                    }
                    i3 = stepZipLogFiles(str, arrayList);
                } else {
                    QLog.w(TAG, 2, "files is empty");
                    return false;
                }
            } else {
                i3 = -3;
            }
            if (i3 != 0) {
                if (QLog.isColorLevel()) {
                    QLog.w(TAG, 2, "uploadFile zip file error code" + i3);
                }
                com.tencent.mobileqq.utils.FileUtils.deleteFile(str);
                return false;
            }
        }
        return uploadFileToServer(file, str, str2);
    }

    public static boolean uploadFileToServer(File file, String str, String str2) {
        HttpURLConnection httpURLConnection;
        DataOutputStream dataOutputStream;
        DataOutputStream dataOutputStream2;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        File file2 = new File(str);
        if (!file2.exists()) {
            return false;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "zip filepath: " + str);
            QLog.d(TAG, 4, "src file: " + file.getAbsolutePath());
        }
        String uuid = UUID.randomUUID().toString();
        try {
            httpURLConnection = (HttpURLConnection) new URL(REQUESTURL).openConnection();
            httpURLConnection.setReadTimeout(100000000);
            httpURLConnection.setConnectTimeout(100000000);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty(HttpHeader.RSP.CHARSET, "utf-8");
            httpURLConnection.setRequestProperty(Headers.CONN_DIRECTIVE, "keep-alive");
            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + uuid);
            dataOutputStream = null;
            fileInputStream = null;
            try {
                dataOutputStream2 = new DataOutputStream(httpURLConnection.getOutputStream());
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (MalformedURLException e16) {
            e16.printStackTrace();
        } catch (IOException e17) {
            e17.printStackTrace();
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(PREFIX);
            stringBuffer.append(uuid);
            stringBuffer.append("\r\n");
            stringBuffer.append("Content-Disposition: form-data; name=\"file\"; filename=\"" + file2.getName() + "\"\r\n");
            stringBuffer.append("Content-Type: application/octet-stream; charset=utf-8\r\n");
            stringBuffer.append("\r\n");
            dataOutputStream2.write(stringBuffer.toString().getBytes());
            try {
                fileInputStream2 = new FileInputStream(file2);
            } catch (Throwable th6) {
                th = th6;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    dataOutputStream2.write(bArr, 0, read);
                }
                fileInputStream2.close();
                dataOutputStream2.write("\r\n".getBytes());
                dataOutputStream2.write((PREFIX + uuid + "\r\n").getBytes());
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Content-Disposition: form-data; name=\"qq\"\r\n");
                sb5.append("\r\n");
                sb5.append(str2 + "\r\n");
                sb5.append(PREFIX + uuid + "\r\n");
                sb5.append("Content-Disposition: form-data; name=\"p_id\"\r\n");
                sb5.append("\r\n");
                sb5.append("3\r\n");
                sb5.append(PREFIX + uuid + "\r\n");
                dataOutputStream2.write(sb5.toString().getBytes());
                dataOutputStream2.flush();
                dataOutputStream2.close();
                int responseCode = httpURLConnection.getResponseCode();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    if (QLog.isDevelopLevel()) {
                        QLog.d(TAG, 4, readLine);
                    }
                }
                if (responseCode == 200) {
                    if (QLog.isDevelopLevel()) {
                        QLog.d(TAG, 4, "http uploadFile sucess");
                    }
                    return true;
                }
                return false;
            } catch (Throwable th7) {
                th = th7;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th8) {
            th = th8;
            dataOutputStream = dataOutputStream2;
            if (dataOutputStream != null) {
                dataOutputStream.close();
            }
            throw th;
        }
    }

    public static void uploadLogcat(Context context, String str) {
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "uploadLogcat start zip");
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(Environment.getExternalStorageDirectory().getAbsolutePath());
        String str2 = File.separator;
        sb5.append(str2);
        String str3 = ZIP_DIR;
        sb5.append(str3);
        sb5.append(str2);
        sb5.append(LOGCAT_PATH);
        sb5.append(str2);
        sb5.append(str);
        sb5.append("logcatwyx.txt");
        File file = new File(VFSAssistantUtils.getSDKPrivatePath(sb5.toString()));
        if (file.exists()) {
            String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(Environment.getExternalStorageDirectory().getAbsolutePath() + str2 + str3 + str2 + LOGCAT_PATH);
            StringBuilder sb6 = new StringBuilder();
            sb6.append(sDKPrivatePath);
            sb6.append(str2);
            sb6.append("upload.log.zip");
            String sb7 = sb6.toString();
            File file2 = new File(sDKPrivatePath);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            uploadFile(file, sb7, str);
        }
    }

    public static void uploadTrace(Context context, String str, final long j3, final long j16) {
        if (!TextUtils.isEmpty(str) && j3 > 0 && j16 > j3) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(Environment.getExternalStorageDirectory().getAbsolutePath());
            String str2 = File.separator;
            sb5.append(str2);
            sb5.append("tencent");
            sb5.append(str2);
            sb5.append("MobileQQ");
            sb5.append(str2);
            sb5.append("trace");
            File[] listFiles = new File(VFSAssistantUtils.getSDKPrivatePath(sb5.toString())).listFiles(new FilenameFilter() { // from class: cooperation.qzone.util.QZoneAppCtrlUploadFileLogic.1
                @Override // java.io.FilenameFilter
                public boolean accept(File file, String str3) {
                    if (!str3.endsWith(".trace")) {
                        return false;
                    }
                    File file2 = new File(file + File.separator + str3);
                    if (!file2.exists()) {
                        return false;
                    }
                    long lastModified = file2.lastModified();
                    if (QLog.isDevelopLevel()) {
                        QLog.d(QZoneAppCtrlUploadFileLogic.TAG, 4, "file dir: " + file.getName());
                        QLog.d(QZoneAppCtrlUploadFileLogic.TAG, 4, "file name: " + str3 + " mStartTime: " + j3 + " mEndTime: " + j16 + " lastModifiedTime: " + lastModified);
                    }
                    if (lastModified < j3 || lastModified > j16) {
                        return false;
                    }
                    if (!QLog.isDevelopLevel()) {
                        return true;
                    }
                    QLog.d(QZoneAppCtrlUploadFileLogic.TAG, 4, "find file name: " + str3);
                    return true;
                }
            });
            Comparator<ShareAppLogHelper.LogFile> comparator = new Comparator<ShareAppLogHelper.LogFile>() { // from class: cooperation.qzone.util.QZoneAppCtrlUploadFileLogic.2
                @Override // java.util.Comparator
                public int compare(ShareAppLogHelper.LogFile logFile, ShareAppLogHelper.LogFile logFile2) {
                    return ((int) (logFile.lastModified() - logFile2.lastModified())) / 1000;
                }
            };
            ArrayList arrayList = new ArrayList();
            if (listFiles != null && listFiles.length > 0) {
                if (QLog.isDevelopLevel()) {
                    QLog.d(TAG, 4, "logFiles length" + listFiles.length);
                }
                for (File file : listFiles) {
                    arrayList.add(new ShareAppLogHelper.LogFile(file.getPath()));
                    Collections.sort(arrayList, comparator);
                }
            }
            if (QLog.isDevelopLevel()) {
                QLog.d(TAG, 4, "find file: " + arrayList.size());
            }
            if (arrayList.size() == 0) {
                return;
            }
            StringBuilder sb6 = new StringBuilder();
            sb6.append(Environment.getExternalStorageDirectory().getAbsolutePath());
            String str3 = File.separator;
            sb6.append(str3);
            sb6.append(ZIP_DIR);
            sb6.append(str3);
            sb6.append("TRACE");
            String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(sb6.toString());
            String str4 = sDKPrivatePath + str3 + "upload.log.zip";
            File file2 = new File(sDKPrivatePath);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            uploadFile((File) arrayList.get(arrayList.size() - 1), str4, str);
        }
    }

    public static long getAvsdkTimeFromServer(String str) {
        if (str == null || TextUtils.isEmpty(str) || str.length() != 10) {
            return -1L;
        }
        try {
            try {
                Date parse = new SimpleDateFormat("yyyyMMddHH").parse(str.trim());
                if (parse != null) {
                    return parse.getTime();
                }
                return -1L;
            } catch (Exception e16) {
                QLog.e(TAG, 1, "error time = " + str);
                e16.printStackTrace();
                return -1L;
            }
        } catch (Throwable unused) {
            return -1L;
        }
    }

    public static boolean uploadFile(File file, String str, String str2) {
        int stepZipLogFile;
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.exists()) {
            if (file.getName().contains(ANR_LOG_DIRECTORY) && file.isDirectory()) {
                ArrayList arrayList = new ArrayList();
                for (File file2 : file.listFiles()) {
                    arrayList.add(file2);
                }
                stepZipLogFile = stepZipLogFiles(str, arrayList);
            } else {
                if (!file.isFile()) {
                    return false;
                }
                stepZipLogFile = stepZipLogFile(str, file);
            }
            if (stepZipLogFile != 0) {
                if (QLog.isColorLevel()) {
                    QLog.w(TAG, 2, "uploadFile zip file error code" + stepZipLogFile);
                }
                com.tencent.mobileqq.utils.FileUtils.deleteFile(str);
                return false;
            }
        }
        return uploadFileToServer(file, str, str2);
    }
}
