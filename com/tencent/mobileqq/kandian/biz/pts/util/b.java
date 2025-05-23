package com.tencent.mobileqq.kandian.biz.pts.util;

import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes33.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, Object> f239400a = new ConcurrentHashMap();

    public static void a() {
        HtmlOffline.D();
    }

    public static String b(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb5 = new StringBuilder();
        while (true) {
            try {
                try {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            sb5.append(readLine);
                        }
                    } catch (OutOfMemoryError unused) {
                        QLog.d("OfflineUtils", 2, "fail to read string from input stream due to OOM");
                        try {
                            inputStream.close();
                            return null;
                        } catch (IOException unused2) {
                            return null;
                        }
                    }
                } catch (IOException unused3) {
                    QLog.d("OfflineUtils", 2, "fail to read string from input stream");
                }
                try {
                    break;
                } catch (IOException unused4) {
                    return sb5.toString();
                }
            } catch (Throwable th5) {
                try {
                    inputStream.close();
                } catch (IOException unused5) {
                }
                throw th5;
            }
        }
        inputStream.close();
    }
}
