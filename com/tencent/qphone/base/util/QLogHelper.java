package com.tencent.qphone.base.util;

import android.annotation.SuppressLint;
import android.os.Process;
import android.util.Log;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.qphone.base.util.report.firebase.QLogFirebaseReportManager;
import com.tenpay.proxy.dlg.location.QbAddrData;
import common.config.service.QzoneConfig;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class QLogHelper {
    private static final String DELETE_RECORD_FILE_NAME = "delete_expire_file_record.log";
    private static final String TAG = "QLogHelper";

    @SuppressLint({"SimpleDateFormat"})
    private static final SimpleDateFormat logTimeFormatter = new SimpleDateFormat("yy-MM-dd HH:mm:ss.SSS");
    private static String[] sensitiveMsgArray = {NotificationActivity.PASSWORD, "PassWord", "passWord", "PASSWORD", "passwd", "Passwd", "PASSWD", "\u5bc6\u7801", "\u7968\u636e", "\u8d26\u53f7", QzoneConfig.DefaultValue.DEFAULT_PASSIVE_FEED_TAB_NAME};

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0010, code lost:
    
        r3 = r8.split(com.tencent.qphone.base.util.QLogHelper.sensitiveMsgArray[r1], 2)[1];
        r5 = r3.length();
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
    
        r7 = "****";
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0023, code lost:
    
        if (r5 <= 4) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0025, code lost:
    
        r7 = r3.substring(0, 2) + "****" + r3.substring(r5 - 2, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0054, code lost:
    
        return com.tencent.qphone.base.util.QLogHelper.sensitiveMsgArray[r1] + r7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String filterSensitiveMsg(String str) {
        int i3 = 0;
        while (true) {
            try {
                String[] strArr = sensitiveMsgArray;
                if (i3 < strArr.length) {
                    if (str.contains(strArr[i3])) {
                        break;
                    }
                    i3++;
                } else {
                    return str;
                }
            } catch (Exception e16) {
                QLog.e(TAG, 1, "filterSensitiveMsg error", e16);
                return str;
            }
        }
    }

    public static List<File> getOutOfCurHourLogs() {
        ArrayList arrayList = new ArrayList();
        File file = new File(QLog.getLogPath());
        if (!file.exists()) {
            return arrayList;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length != 0) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy.MM.dd.HH");
            long currentTimeMillis = System.currentTimeMillis();
            String str = simpleDateFormat.format(Long.valueOf(currentTimeMillis)) + ".log";
            String str2 = simpleDateFormat.format(Long.valueOf(currentTimeMillis)) + ".qlog";
            String str3 = simpleDateFormat.format(Long.valueOf(currentTimeMillis)) + ".qqxlog";
            for (File file2 : listFiles) {
                if (!DELETE_RECORD_FILE_NAME.equals(file2.getName())) {
                    String absolutePath = file2.getAbsolutePath();
                    if (!absolutePath.endsWith(str) && !absolutePath.endsWith(str2) && !absolutePath.endsWith(str3) && !absolutePath.endsWith(".mmap3")) {
                        arrayList.add(file2);
                    }
                }
            }
        }
        return arrayList;
    }

    public static void reportToGoogleFirebase(long j3, byte b16, String str, String str2, Throwable th5) {
        if (QLogFirebaseReportManager.getInstance().isFirebaseReportNotNull()) {
            if (j3 == 0) {
                j3 = System.currentTimeMillis();
            }
            String format = logTimeFormatter.format(Long.valueOf(j3));
            StringBuilder sb5 = new StringBuilder();
            sb5.append(format);
            sb5.append("[P");
            sb5.append(Process.myPid());
            sb5.append(']');
            sb5.append("[T");
            sb5.append(Process.myTid());
            sb5.append(']');
            sb5.append(QLog.byteLevel2StringLevel(Byte.valueOf(b16)));
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(str);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(str2);
            sb5.append('\n');
            if (th5 != null) {
                QLogFirebaseReportManager.getInstance().sendToGoogleFirebase(sb5.toString() + " " + Log.getStackTraceString(th5));
                return;
            }
            QLogFirebaseReportManager.getInstance().sendToGoogleFirebase(sb5.toString());
        }
    }
}
