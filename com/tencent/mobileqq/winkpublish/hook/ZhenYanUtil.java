package com.tencent.mobileqq.winkpublish.hook;

import android.os.Process;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import uq3.c;
import uq3.k;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ZhenYanUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final String f327219a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f327220b;

    /* renamed from: c, reason: collision with root package name */
    private static volatile boolean f327221c;

    /* renamed from: d, reason: collision with root package name */
    private static final HashMap<String, String> f327222d;

    static {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("/data/user/0/com.tencent.mobileqq/cache");
        String str = File.separator;
        sb5.append(str);
        sb5.append(QQPermissionConstants.Permission.AUIDO_GROUP);
        sb5.append(str);
        f327219a = sb5.toString();
        f327222d = new HashMap<>();
    }

    public static native void addFilterName(String str);

    public static void c() {
        if (f327221c && f327220b) {
            recordLeftCache();
            RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.winkpublish.hook.ZhenYanUtil.1
                /* JADX WARN: Removed duplicated region for block: B:45:0x00fb A[Catch: IOException -> 0x00f7, TRY_LEAVE, TryCatch #2 {IOException -> 0x00f7, blocks: (B:52:0x00f3, B:45:0x00fb), top: B:51:0x00f3 }] */
                /* JADX WARN: Removed duplicated region for block: B:51:0x00f3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    BufferedReader bufferedReader;
                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
                    String str = ZhenYanUtil.f327219a + simpleDateFormat.format(date) + "_" + Process.myPid() + "_record.txt";
                    File file = new File(str);
                    if (file.exists()) {
                        ArrayList arrayList = new ArrayList();
                        InputStreamReader inputStreamReader = null;
                        try {
                            try {
                                InputStreamReader inputStreamReader2 = new InputStreamReader(new FileInputStream(file), "GBK");
                                try {
                                    bufferedReader = new BufferedReader(inputStreamReader2);
                                    int i3 = 0;
                                    while (true) {
                                        try {
                                            String readLine = bufferedReader.readLine();
                                            if (readLine != null) {
                                                if (readLine.contains("com/tencent/")) {
                                                    i3++;
                                                    String substring = readLine.substring(0, readLine.indexOf(";"));
                                                    String str2 = (String) ZhenYanUtil.f327222d.get(substring);
                                                    if (str2 != null) {
                                                        arrayList.add(str2);
                                                        ZhenYanUtil.f327222d.remove(substring);
                                                    }
                                                } else {
                                                    QLog.e("zhenYan", 1, "unknown record:" + readLine);
                                                }
                                            } else {
                                                QLog.d("zhenYan", 1, " record count:" + i3);
                                                a.b(arrayList);
                                                inputStreamReader2.close();
                                                bufferedReader.close();
                                                return;
                                            }
                                        } catch (Exception e16) {
                                            e = e16;
                                            inputStreamReader = inputStreamReader2;
                                            try {
                                                QLog.e("zhenYan", 1, e, new Object[0]);
                                                if (inputStreamReader != null) {
                                                    inputStreamReader.close();
                                                }
                                                if (bufferedReader != null) {
                                                    bufferedReader.close();
                                                    return;
                                                }
                                                return;
                                            } catch (Throwable th5) {
                                                th = th5;
                                                if (inputStreamReader != null) {
                                                    try {
                                                        inputStreamReader.close();
                                                    } catch (IOException e17) {
                                                        e17.printStackTrace();
                                                        throw th;
                                                    }
                                                }
                                                if (bufferedReader != null) {
                                                    bufferedReader.close();
                                                }
                                                throw th;
                                            }
                                        } catch (Throwable th6) {
                                            th = th6;
                                            inputStreamReader = inputStreamReader2;
                                            if (inputStreamReader != null) {
                                            }
                                            if (bufferedReader != null) {
                                            }
                                            throw th;
                                        }
                                    }
                                } catch (Exception e18) {
                                    e = e18;
                                    bufferedReader = null;
                                } catch (Throwable th7) {
                                    th = th7;
                                    bufferedReader = null;
                                }
                            } catch (Exception e19) {
                                e = e19;
                                bufferedReader = null;
                            } catch (Throwable th8) {
                                th = th8;
                                bufferedReader = null;
                            }
                        } catch (IOException e26) {
                            e26.printStackTrace();
                        }
                    } else {
                        QLog.d("zhenYan", 1, "not found:" + str);
                    }
                }
            });
        }
    }

    public static native boolean canHookFindClassInitializer();

    public static native boolean canHookLookUp();

    public static void d() {
        boolean c16 = k.b().c("art_hook", false);
        boolean R4 = c.R4();
        if (c16 || R4) {
            return;
        }
        QLog.i("zhenYan", 1, "switch close, debug switch:" + c16 + ",wns switch:" + R4);
    }

    public static native boolean hookFindClassInitializer();

    public static native boolean hookLookUp();

    public static native void recordLeftCache();

    public static native void removeFilterName(String str);
}
