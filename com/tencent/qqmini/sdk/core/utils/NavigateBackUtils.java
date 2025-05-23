package com.tencent.qqmini.sdk.core.utils;

import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/* compiled from: P */
/* loaded from: classes23.dex */
public class NavigateBackUtils {
    public static final String NAVIGATE_BACK_APPID_FILE_PATH;
    public static final String PATH_WXAPKG_ROOT;
    public static final String TAG = "NavigateBackUtils";

    static {
        String str = AppLoaderFactory.g().getContext().getFilesDir().getPath() + "/mini/";
        PATH_WXAPKG_ROOT = str;
        NAVIGATE_BACK_APPID_FILE_PATH = str + "navigateback_appid";
    }

    public static void clearTag() {
        deleteFile(new File(NAVIGATE_BACK_APPID_FILE_PATH));
    }

    private static void deleteFile(File file) {
        if (file.exists()) {
            file.delete();
        }
    }

    public static String getTagAppid() {
        return getTagAppidInner(new File(NAVIGATE_BACK_APPID_FILE_PATH));
    }

    private static String getTagAppidInner(File file) {
        if (file.exists()) {
            BufferedReader bufferedReader = null;
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                    try {
                        String readLine = bufferedReader2.readLine();
                        bufferedReader2.close();
                        try {
                            bufferedReader2.close();
                        } catch (Exception unused) {
                        }
                        return readLine;
                    } catch (Exception e16) {
                        e = e16;
                        bufferedReader = bufferedReader2;
                        QMLog.e(TAG, "getTagAppid exception!", e);
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                                return "";
                            } catch (Exception unused2) {
                                return "";
                            }
                        }
                        return "";
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception unused3) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception e17) {
                    e = e17;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } else {
            return "";
        }
    }

    public static void writeTagAppid(String str) {
        writeTagAppidInner(new File(NAVIGATE_BACK_APPID_FILE_PATH), str);
    }

    private static void writeTagAppidInner(File file, String str) {
        BufferedWriter bufferedWriter = null;
        try {
            try {
                try {
                    BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file));
                    try {
                        bufferedWriter2.write(str);
                        bufferedWriter2.close();
                        bufferedWriter2.close();
                    } catch (Exception e16) {
                        e = e16;
                        bufferedWriter = bufferedWriter2;
                        QMLog.e(TAG, "getTagAppid exception!", e);
                        if (bufferedWriter != null) {
                            bufferedWriter.close();
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedWriter = bufferedWriter2;
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (Exception unused) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Exception e17) {
                e = e17;
            }
        } catch (Exception unused2) {
        }
    }
}
