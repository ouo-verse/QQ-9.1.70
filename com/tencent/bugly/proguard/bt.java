package com.tencent.bugly.proguard;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.bugly.common.labels.VersionLabelWrapper;
import com.tencent.bugly.common.utils.FileUtil;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler;
import com.tencent.xweb.FileReaderHelper;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class bt {

    /* renamed from: a, reason: collision with root package name */
    private static List<File> f98345a = new ArrayList();

    /* JADX INFO: Access modifiers changed from: protected */
    public static String a(String str) {
        if (str == null) {
            return "";
        }
        String[] split = str.split("\n");
        if (split == null || split.length == 0) {
            return str;
        }
        StringBuilder sb5 = new StringBuilder();
        for (String str2 : split) {
            if (!str2.contains("java.lang.Thread.getStackTrace(")) {
                sb5.append(str2);
                sb5.append("\n");
            }
        }
        return sb5.toString();
    }

    private static String b(String str, String str2) {
        BufferedReader b16 = ba.b(str, "reg_record.txt");
        if (b16 == null) {
            return null;
        }
        try {
            StringBuilder sb5 = new StringBuilder();
            String readLine = b16.readLine();
            if (readLine != null && readLine.startsWith(str2)) {
                int i3 = 18;
                int i16 = 0;
                int i17 = 0;
                while (true) {
                    String readLine2 = b16.readLine();
                    if (readLine2 == null) {
                        break;
                    }
                    if (i16 % 4 == 0) {
                        if (i16 > 0) {
                            sb5.append("\n");
                        }
                        sb5.append("  ");
                    } else {
                        if (readLine2.length() > 16) {
                            i3 = 28;
                        }
                        sb5.append("                ".substring(0, i3 - i17));
                    }
                    i17 = readLine2.length();
                    sb5.append(readLine2);
                    i16++;
                }
                sb5.append("\n");
                return sb5.toString();
            }
            try {
                b16.close();
            } catch (Exception e16) {
                av.a(e16);
            }
            return null;
        } catch (Throwable th5) {
            try {
                av.a(th5);
                try {
                    b16.close();
                } catch (Exception e17) {
                    av.a(e17);
                }
                return null;
            } finally {
                try {
                    b16.close();
                } catch (Exception e18) {
                    av.a(e18);
                }
            }
        }
    }

    private static Map<String, Integer> c(String str) {
        if (str == null) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            for (String str2 : str.split(",")) {
                String[] split = str2.split(":");
                if (split.length != 2) {
                    av.e("error format at %s", str2);
                    return null;
                }
                hashMap.put(split[0], Integer.valueOf(Integer.parseInt(split[1])));
            }
            return hashMap;
        } catch (Exception e16) {
            av.e("error format intStateStr %s", str);
            e16.printStackTrace();
            return null;
        }
    }

    private static <KeyT, ValueT> ValueT a(Map<KeyT, ValueT> map, KeyT keyt, ValueT valuet) {
        ValueT valuet2;
        try {
            valuet2 = map.get(keyt);
        } catch (Exception e16) {
            av.a(e16);
        }
        return valuet2 != null ? valuet2 : valuet;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0031, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String a(BufferedInputStream bufferedInputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(1024);
            while (true) {
                try {
                    int read = bufferedInputStream.read();
                    if (read == -1) {
                        break;
                    }
                    if (read == 0) {
                        String str = new String(byteArrayOutputStream.toByteArray(), "UTf-8");
                        byteArrayOutputStream.close();
                        return str;
                    }
                    byteArrayOutputStream.write(read);
                } catch (Throwable th5) {
                    th = th5;
                    try {
                        av.a(th);
                    } finally {
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                    }
                }
            }
        } catch (Throwable th6) {
            th = th6;
            byteArrayOutputStream = null;
        }
    }

    private static String c(String str, String str2) {
        BufferedReader b16 = ba.b(str, "map_record.txt");
        if (b16 == null) {
            return null;
        }
        try {
            StringBuilder sb5 = new StringBuilder();
            String readLine = b16.readLine();
            if (readLine != null && readLine.startsWith(str2)) {
                while (true) {
                    String readLine2 = b16.readLine();
                    if (readLine2 == null) {
                        break;
                    }
                    sb5.append("  ");
                    sb5.append(readLine2);
                    sb5.append("\n");
                }
                return sb5.toString();
            }
            try {
                b16.close();
            } catch (Exception e16) {
                av.a(e16);
            }
            return null;
        } catch (Throwable th5) {
            try {
                av.a(th5);
                try {
                    b16.close();
                } catch (Exception e17) {
                    av.a(e17);
                }
                return null;
            } finally {
                try {
                    b16.close();
                } catch (Exception e18) {
                    av.a(e18);
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r7v3, types: [boolean] */
    public static CrashDetailBean a(Context context, String str, NativeExceptionHandler nativeExceptionHandler) {
        BufferedInputStream bufferedInputStream;
        String str2;
        String a16;
        BufferedInputStream bufferedInputStream2 = null;
        if (context != null && str != null && nativeExceptionHandler != null) {
            File file = new File(str, "rqd_record.eup");
            if (file.exists()) {
                ?? canRead = file.canRead();
                try {
                    if (canRead != 0) {
                        try {
                            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                        } catch (IOException e16) {
                            e = e16;
                            bufferedInputStream = null;
                        } catch (Throwable th5) {
                            th = th5;
                            if (bufferedInputStream2 != null) {
                                try {
                                    bufferedInputStream2.close();
                                } catch (IOException e17) {
                                    e17.printStackTrace();
                                }
                            }
                            throw th;
                        }
                        try {
                            String a17 = a(bufferedInputStream);
                            if (a17 != null && a17.equals("NATIVE_RQD_REPORT")) {
                                HashMap hashMap = new HashMap();
                                loop0: while (true) {
                                    str2 = null;
                                    while (true) {
                                        a16 = a(bufferedInputStream);
                                        if (a16 == null) {
                                            break loop0;
                                        }
                                        if (str2 == null) {
                                            str2 = a16;
                                        }
                                    }
                                    hashMap.put(str2, a16);
                                }
                                if (str2 != null) {
                                    av.e("record not pair! drop! %s", str2);
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e18) {
                                        e18.printStackTrace();
                                    }
                                    return null;
                                }
                                CrashDetailBean a18 = a(context, hashMap, nativeExceptionHandler);
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e19) {
                                    e19.printStackTrace();
                                }
                                return a18;
                            }
                            av.e("record read fail! %s", a17);
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e26) {
                                e26.printStackTrace();
                            }
                            return null;
                        } catch (IOException e27) {
                            e = e27;
                            e.printStackTrace();
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e28) {
                                    e28.printStackTrace();
                                }
                            }
                            return null;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    bufferedInputStream2 = canRead;
                }
            }
            return null;
        }
        av.e("get eup record file args error", new Object[0]);
        return null;
    }

    public static void b(String str) {
        File[] listFiles;
        if (str == null) {
            return;
        }
        try {
            File file = new File(str);
            if (file.canRead() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.canRead() && file2.canWrite() && file2.length() == 0) {
                        file2.delete();
                        av.c("Delete empty record file %s", file2.getAbsoluteFile());
                    }
                }
            }
        } catch (Throwable th5) {
            av.a(th5);
        }
    }

    private static long b(Map<String, String> map) {
        String str = map.get("launchTime");
        if (str == null) {
            return -1L;
        }
        av.c("[Native record info] launchTime: %s", str);
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e16) {
            if (av.a(e16)) {
                return -1L;
            }
            e16.printStackTrace();
            return -1L;
        }
    }

    public static String a(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        String b16 = b(str, str2);
        if (b16 != null && !b16.isEmpty()) {
            sb5.append("Register infos:\n");
            sb5.append(b16);
        }
        String c16 = c(str, str2);
        if (c16 != null && !c16.isEmpty()) {
            if (sb5.length() > 0) {
                sb5.append("\n");
            }
            sb5.append("System SO infos:\n");
            sb5.append(c16);
        }
        return sb5.toString();
    }

    public static void a(boolean z16, String str) {
        if (str != null) {
            f98345a.add(new File(str, "rqd_record.eup"));
            f98345a.add(new File(str, "reg_record.txt"));
            f98345a.add(new File(str, "map_record.txt"));
            if (z16) {
                b(str);
                b(FileUtil.getFileParentPath(str));
            }
        }
        List<File> list = f98345a;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (File file : f98345a) {
            if (file.exists() && file.canWrite()) {
                file.delete();
                av.c("Delete record file %s", file.getAbsoluteFile());
            }
        }
    }

    public static String a(String str, int i3, int i16, int i17, String str2, long j3) {
        if (j3 == -1) {
            av.c("No exception time, exit!", new Object[0]);
            return null;
        }
        if (str != null && i3 > 0) {
            File file = new File(str);
            if (file.exists() && file.canRead()) {
                av.a("Read system log from native record file(length: %s bytes): %s", Long.valueOf(file.length()), file.getAbsolutePath());
                f98345a.add(file);
                av.c("Add this record file to list for cleaning lastly.", new Object[0]);
                try {
                    return ba.a(new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8")), i3, i16, i17, str2, j3);
                } catch (Throwable th5) {
                    av.a(th5);
                }
            }
        }
        return null;
    }

    private static Map<String, String> a(Map<String, String> map) {
        String str = map.get("key-value");
        if (str == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str2 : str.split("\n")) {
            String[] split = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
            if (split.length == 2) {
                hashMap.put(split[0], split[1]);
            }
        }
        return hashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0047 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static CrashDetailBean a(Context context, Map<String, String> map, NativeExceptionHandler nativeExceptionHandler) {
        boolean z16;
        String str;
        String str2;
        String str3;
        String str4;
        boolean z17;
        if (ai.a(context) == null) {
            av.e("abnormal com info not created", new Object[0]);
        } else {
            String str5 = map.get("intStateStr");
            if (str5 != null && str5.trim().length() > 0) {
                z16 = true;
                if (z16) {
                    return null;
                }
                Map<String, Integer> c16 = c(map.get("intStateStr"));
                if (c16 == null) {
                    av.e("parse intSateMap fail", Integer.valueOf(map.size()));
                    return null;
                }
                try {
                    c16.get("sino").intValue();
                    c16.get("sud").intValue();
                    String str6 = map.get("soVersion");
                    if (TextUtils.isEmpty(str6)) {
                        av.e("error format at version", new Object[0]);
                        return null;
                    }
                    String str7 = (String) a(map, "codeMsg", "unknown");
                    String str8 = (String) a(map, "signalName", "unknown");
                    map.get("errnoMsg");
                    String str9 = (String) a(map, "stack", "unknown");
                    String str10 = map.get("jstack");
                    if (str10 != null) {
                        str9 = str9 + "java:\n" + str10;
                    }
                    String str11 = (String) a(map, "crashIdentify", "");
                    Integer num = c16.get("sico");
                    if (num == null || num.intValue() <= 0) {
                        str = str7;
                        str2 = str8;
                    } else {
                        str2 = str8 + "(" + str7 + ")";
                        str = "KERNEL";
                    }
                    String str12 = map.get("nativeLog");
                    byte[] a16 = (str12 == null || str12.isEmpty()) ? null : ba.a(str12, "BuglyNativeLog.txt");
                    String str13 = (String) a(map, "sendingProcess", "unknown");
                    Integer num2 = c16.get("spd");
                    if (num2 != null) {
                        str3 = str13 + "(" + num2 + ")";
                    } else {
                        str3 = str13;
                    }
                    String str14 = (String) a(map, "threadName", "unknown");
                    Integer num3 = c16.get(FileReaderHelper.ET_EXT);
                    if (num3 != null) {
                        str14 = str14 + "(" + num3 + ")";
                    }
                    String str15 = (String) a(map, "processName", "unknown");
                    Integer num4 = c16.get("ep");
                    if (num4 != null) {
                        str4 = str15 + "(" + num4 + ")";
                    } else {
                        str4 = str15;
                    }
                    Map<String, String> a17 = a(map);
                    long intValue = c16.get("ets").intValue();
                    String str16 = (String) a(map, "errorAddr", "unknown");
                    String a18 = a(str9);
                    String str17 = map.get("sysLogPath");
                    String str18 = map.get("jniLogPath");
                    long parseLong = Long.parseLong((String) a(map, "ramAvail", "-1"));
                    long parseLong2 = Long.parseLong((String) a(map, "romAvail", "-1"));
                    long parseLong3 = Long.parseLong((String) a(map, "sdAvail", "-1"));
                    long parseLong4 = Long.parseLong((String) a(map, "vss", "-1"));
                    CrashDetailBean packageCrashBasicDatas = nativeExceptionHandler.packageCrashBasicDatas(str14, (c16.get("etms").intValue() / 1000) + (intValue * 1000), str2, str16, a18, (String) a(map, "abortMsg", ""), str, str3, (String) a(map, "tombPath", "unknown"), str17, str18, str6);
                    if (packageCrashBasicDatas != null) {
                        nativeExceptionHandler.packageCrashDetailDatas(packageCrashBasicDatas, str4, a16, a17, false, parseLong, parseLong2, parseLong3, parseLong4);
                        String str19 = (String) a(map, "userId", packageCrashBasicDatas.f97895u);
                        packageCrashBasicDatas.f97895u = str19;
                        av.c("[Native record info] userId: %s", str19);
                        String str20 = (String) a(map, "appVersion", packageCrashBasicDatas.f97885k);
                        packageCrashBasicDatas.f97885k = str20;
                        av.c("[Native record info] appVersion: %s", str20);
                        String str21 = (String) a(map, "sdkVersion", packageCrashBasicDatas.f97884j);
                        packageCrashBasicDatas.f97884j = str21;
                        av.c("[Native record info] sdkVersion: %s", str21);
                        String str22 = (String) a(map, "hotPatchNum", "");
                        packageCrashBasicDatas.f97871al = str22;
                        av.c("[Native record info] hotPatchNum: %s", str22);
                        packageCrashBasicDatas.f97883i = (String) a(map, "deviceModel", packageCrashBasicDatas.f97883i);
                        packageCrashBasicDatas.f97882h = (String) a(map, Constants.SP_DEVICE_ID, packageCrashBasicDatas.f97882h);
                        packageCrashBasicDatas.f97886l = (String) a(map, "buildNum", packageCrashBasicDatas.f97886l);
                        packageCrashBasicDatas.f97887m = (String) a(map, "appChannel", packageCrashBasicDatas.f97887m);
                        packageCrashBasicDatas.E = (String) a(map, "sysLog", packageCrashBasicDatas.E);
                        String str23 = map.get("isFirstInstall");
                        packageCrashBasicDatas.f97881g = str23 != null ? str23.equalsIgnoreCase("true") : false;
                        String str24 = map.get("isAppForeground");
                        if (str24 != null) {
                            av.c("[Native record info] isAppForeground: %s", str24);
                            z17 = str24.equalsIgnoreCase("true");
                        } else {
                            z17 = false;
                        }
                        packageCrashBasicDatas.f97861ab = z17;
                        packageCrashBasicDatas.f97860aa = b(map);
                        packageCrashBasicDatas.H = null;
                        packageCrashBasicDatas.f97889o = null;
                        packageCrashBasicDatas.f97893s = true;
                        packageCrashBasicDatas.f97878d = str11;
                        packageCrashBasicDatas.a(VersionLabelWrapper.SHIPLY_VERSION_LABEL_KEY, (String) a(map, "shiplyVersionLabel", ""));
                        packageCrashBasicDatas.a("stage", (String) a(map, "stageLabel", ""));
                        packageCrashBasicDatas.a("testLabel", (String) a(map, "testLabel", ""));
                        packageCrashBasicDatas.a("caseLabel", (String) a(map, "caseLabel", ""));
                        bi.a(packageCrashBasicDatas);
                    }
                    return packageCrashBasicDatas;
                } catch (Throwable th5) {
                    av.e("error format\n".concat(String.valueOf(th5)), new Object[0]);
                    return null;
                }
            }
            av.e("no intStateStr", new Object[0]);
        }
        z16 = false;
        if (z16) {
        }
    }
}
