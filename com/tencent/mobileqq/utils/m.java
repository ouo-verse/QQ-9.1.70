package com.tencent.mobileqq.utils;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.app.privacy.PrivacyPolicyHelper;
import com.tencent.mobileqq.msf.core.net.NetContants;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes20.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private static long f307810a = 0;

    /* renamed from: b, reason: collision with root package name */
    private static String f307811b = "";

    /* renamed from: c, reason: collision with root package name */
    private static AtomicBoolean f307812c;

    public static boolean a() {
        if (f307812c == null) {
            f307812c = new AtomicBoolean(BaseApplication.getContext().getSharedPreferences(NetContants.SharePref.KEY_ENABLE_IPV6, 4).getBoolean(NetContants.SharePref.EXTRA_ENABLE_IPV6, true));
        }
        return f307812c.get();
    }

    public static String b() {
        if (!PrivacyPolicyHelper.isUserAllow()) {
            return "";
        }
        if (!TextUtils.isEmpty(f307811b)) {
            return f307811b;
        }
        String model = DeviceInfoMonitor.getModel();
        if (TextUtils.isEmpty(model)) {
            return "";
        }
        String str = Build.MANUFACTURER + "-" + model;
        f307811b = str;
        QLog.d("AppSetting", 1, "[getDeviceInfo] ", str);
        return f307811b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x004d, code lost:
    
        if (r4 != null) goto L11;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long c() {
        Throwable th5;
        BufferedReader bufferedReader;
        FileReader fileReader;
        if (f307810a == 0) {
            BufferedReader bufferedReader2 = null;
            bufferedReader2 = null;
            bufferedReader2 = null;
            bufferedReader2 = null;
            try {
                try {
                    try {
                        fileReader = new FileReader("/proc/meminfo");
                        try {
                            bufferedReader = new BufferedReader(fileReader, 1024);
                            try {
                                String readLine = bufferedReader.readLine();
                                bufferedReader2 = readLine;
                                if (readLine != null) {
                                    Long valueOf = Long.valueOf(readLine.split("\\s+")[1]);
                                    f307810a = valueOf.longValue() * 1024;
                                    bufferedReader2 = valueOf;
                                }
                                bufferedReader.close();
                            } catch (Exception unused) {
                                bufferedReader2 = bufferedReader;
                                f307810a = 0L;
                                if (bufferedReader2 != null) {
                                    bufferedReader2.close();
                                }
                            } catch (Throwable th6) {
                                th5 = th6;
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (Exception unused2) {
                                        throw th5;
                                    }
                                }
                                if (fileReader != null) {
                                    fileReader.close();
                                }
                                throw th5;
                            }
                        } catch (Exception unused3) {
                        }
                    } catch (Exception unused4) {
                        fileReader = null;
                    } catch (Throwable th7) {
                        fileReader = null;
                        th5 = th7;
                        bufferedReader = null;
                    }
                    fileReader.close();
                } catch (Exception unused5) {
                }
                if (f307810a == 0) {
                    return 1073741824L;
                }
            } catch (Throwable th8) {
                BufferedReader bufferedReader3 = bufferedReader2;
                th5 = th8;
                bufferedReader = bufferedReader3;
            }
        }
        return f307810a;
    }
}
