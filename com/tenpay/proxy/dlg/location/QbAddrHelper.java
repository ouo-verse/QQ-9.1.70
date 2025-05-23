package com.tenpay.proxy.dlg.location;

import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* compiled from: P */
/* loaded from: classes27.dex */
public class QbAddrHelper {
    public static final String TAG = "QbAddrHelper";

    /* JADX WARN: Removed duplicated region for block: B:42:0x0070 A[Catch: Exception -> 0x006c, TRY_LEAVE, TryCatch #2 {Exception -> 0x006c, blocks: (B:49:0x0068, B:42:0x0070), top: B:48:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0068 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static QbAddrData doPraseFile(File file) {
        FileInputStream fileInputStream;
        Throwable th5;
        BufferedReader bufferedReader;
        String readLine;
        try {
            if (!file.exists()) {
                return null;
            }
            fileInputStream = new FileInputStream(file);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                QbAddrData qbAddrData = null;
                try {
                    do {
                        try {
                            try {
                                readLine = bufferedReader.readLine();
                                if (readLine != null) {
                                    if (qbAddrData == null) {
                                        qbAddrData = new QbAddrData();
                                    }
                                }
                                break;
                            } catch (Throwable th6) {
                                th5 = th6;
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (Exception e16) {
                                        QLog.e(TAG, 1, "", e16);
                                        throw th5;
                                    }
                                }
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                throw th5;
                            }
                        } catch (Exception e17) {
                            e = e17;
                            QLog.e(TAG, 1, "", e);
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception e18) {
                                    QLog.e(TAG, 1, "", e18);
                                    return null;
                                }
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            return null;
                        }
                    } while (qbAddrData.insertData(readLine));
                    break;
                    bufferedReader.close();
                    fileInputStream.close();
                } catch (Exception e19) {
                    QLog.e(TAG, 1, "", e19);
                }
                return qbAddrData;
            } catch (Exception e26) {
                e = e26;
                bufferedReader = null;
            } catch (Throwable th7) {
                th5 = th7;
                bufferedReader = null;
                if (bufferedReader != null) {
                }
                if (fileInputStream != null) {
                }
                throw th5;
            }
        } catch (Exception e27) {
            e = e27;
            bufferedReader = null;
            fileInputStream = null;
        } catch (Throwable th8) {
            fileInputStream = null;
            th5 = th8;
            bufferedReader = null;
        }
    }
}
