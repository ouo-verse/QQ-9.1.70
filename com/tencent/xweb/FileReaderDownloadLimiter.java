package com.tencent.xweb;

import android.content.SharedPreferences;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.ar.y0;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: P */
/* loaded from: classes27.dex */
class FileReaderDownloadLimiter {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f384896a = new Object();

    public static String a() {
        try {
            return new SimpleDateFormat(DateUtil.DATE_FORMAT_8).format(new Date());
        } catch (Throwable th5) {
            x0.c("FileReaderDownloadLimiter", "getCurrentDate error: " + th5.getMessage());
            return "";
        }
    }

    public static void clear(String str) {
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    synchronized (f384896a) {
                        SharedPreferences l3 = y0.l();
                        if (l3 == null) {
                            x0.c("FileReaderDownloadLimiter", "clear sp is null");
                            return;
                        }
                        SharedPreferences.Editor edit = l3.edit();
                        if (edit == null) {
                            x0.c("FileReaderDownloadLimiter", "clear editor is null");
                            return;
                        }
                        edit.remove(str + "_download_count");
                        edit.remove(str + "_download_date");
                        edit.commit();
                        x0.d("FileReaderDownloadLimiter", "clear " + str + " download count and date");
                        return;
                    }
                }
            } catch (Throwable th5) {
                x0.c("FileReaderDownloadLimiter", "clear error: " + th5.getMessage());
                return;
            }
        }
        x0.c("FileReaderDownloadLimiter", "clear param is empty");
    }

    public static int getTodayDownloadCount(String str) {
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    synchronized (f384896a) {
                        SharedPreferences l3 = y0.l();
                        if (l3 == null) {
                            x0.c("FileReaderDownloadLimiter", "getTodayDownloadCount sp is null");
                            return 0;
                        }
                        String a16 = a();
                        if (a16 != null && !a16.isEmpty()) {
                            int i3 = l3.getInt(str + "_download_count", 0);
                            if (a16.equals(l3.getString(str + "_download_date", ""))) {
                                x0.d("FileReaderDownloadLimiter", "getTodayDownloadCount " + str + ", download count = " + i3 + ", download date = " + a16);
                                return i3;
                            }
                            x0.d("FileReaderDownloadLimiter", "getTodayDownloadCount " + str + ", not download today, download date = " + a16);
                            return 0;
                        }
                        x0.c("FileReaderDownloadLimiter", " getTodayDownloadCount current date is empty");
                        return 0;
                    }
                }
            } catch (Throwable th5) {
                x0.c("FileReaderDownloadLimiter", "getTodayDownloadCount error: " + th5.getMessage());
                return 0;
            }
        }
        x0.c("FileReaderDownloadLimiter", "getTodayDownloadCount param is empty");
        return 0;
    }

    public static void record(String str) {
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    synchronized (f384896a) {
                        SharedPreferences l3 = y0.l();
                        if (l3 == null) {
                            x0.c("FileReaderDownloadLimiter", "record sp is null");
                            return;
                        }
                        String a16 = a();
                        if (a16 != null && !a16.isEmpty()) {
                            int i3 = l3.getInt(str + "_download_count", 0);
                            String string = l3.getString(str + "_download_date", "");
                            SharedPreferences.Editor edit = l3.edit();
                            if (edit == null) {
                                x0.c("FileReaderDownloadLimiter", "record editor is null");
                                return;
                            }
                            if (a16.equals(string)) {
                                edit.putInt(str + "_download_count", i3 + 1);
                            } else {
                                edit.putInt(str + "_download_count", 1);
                                edit.putString(str + "_download_date", a16);
                            }
                            edit.commit();
                            x0.d("FileReaderDownloadLimiter", "record " + str + ", download count = " + (i3 + 1) + ", date = " + a16);
                            return;
                        }
                        x0.c("FileReaderDownloadLimiter", " record current date is empty");
                        return;
                    }
                }
            } catch (Throwable th5) {
                x0.c("FileReaderDownloadLimiter", "record error: " + th5.getMessage());
                return;
            }
        }
        x0.c("FileReaderDownloadLimiter", "record param is empty");
    }
}
