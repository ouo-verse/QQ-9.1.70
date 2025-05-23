package com.tencent.mobileqq.msf.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;

/* compiled from: P */
/* loaded from: classes15.dex */
public class SettingCloneUtil {
    static IPatchRedirector $redirector_ = null;
    private static final String KEY_FILE = "set_sp";
    private static final String KEY_FILE_MULTI_PROCESS = "set_sp_mp";
    private static final HashSet<String> MULTIPROCESS_KEYS;
    private static Object locker = null;
    private static volatile boolean mHasInit = false;
    private static final HashMap<String, String> mapKv;
    private static final HashMap<String, String> tmpMapKv;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21019);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        locker = new Object();
        HashSet<String> hashSet = new HashSet<>(6);
        MULTIPROCESS_KEYS = hashSet;
        hashSet.add(AppConstants.QQSETTING_SCREENSHOT_KEY);
        hashSet.add(AppConstants.QQSETTING_NOTIFY_BLNCONTROL_KEY);
        hashSet.add(AppConstants.QQSETTING_LOCKSCREENMSG_WHENEXIST_KEY);
        hashSet.add(AppConstants.QQSETTING_AVCALL_NOTIFY_KEY);
        hashSet.add(AppConstants.QQSETTING_QRLOGIN_SET_MUTE);
        hashSet.add(AppConstants.QQSETTING_LOCALE_ID);
        hashSet.add(AppConstants.NEW_MSG_NOTIFICATION_KEY);
        mapKv = new HashMap<>();
        tmpMapKv = new HashMap<>();
    }

    public SettingCloneUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:15:0x0081
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1166)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:1022)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:55)
        */
    public static boolean firstInit(java.lang.String r5, java.lang.String r6, java.lang.String r7) {
        /*
            java.lang.Object r0 = com.tencent.mobileqq.msf.sdk.SettingCloneUtil.locker
            monitor-enter(r0)
            java.util.HashMap<java.lang.String, java.lang.String> r1 = com.tencent.mobileqq.msf.sdk.SettingCloneUtil.mapKv     // Catch: java.lang.Throwable -> L9b
            boolean r2 = r1.containsKey(r5)     // Catch: java.lang.Throwable -> L9b
            r3 = 2
            if (r2 == 0) goto L47
            java.lang.Object r6 = r1.get(r5)     // Catch: java.lang.Throwable -> L9b
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Throwable -> L9b
            boolean r1 = com.tencent.qphone.base.util.QLog.isColorLevel()     // Catch: java.lang.Throwable -> L9b
            if (r1 == 0) goto L42
            java.lang.String r1 = "set_sp"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9b
            r2.<init>()     // Catch: java.lang.Throwable -> L9b
            java.lang.String r4 = "containsKey is true, key="
            r2.append(r4)     // Catch: java.lang.Throwable -> L9b
            r2.append(r5)     // Catch: java.lang.Throwable -> L9b
            java.lang.String r4 = " v="
            r2.append(r4)     // Catch: java.lang.Throwable -> L9b
            r2.append(r6)     // Catch: java.lang.Throwable -> L9b
            java.lang.String r4 = " tag="
            r2.append(r4)     // Catch: java.lang.Throwable -> L9b
            r2.append(r7)     // Catch: java.lang.Throwable -> L9b
            java.lang.String r7 = r2.toString()     // Catch: java.lang.Throwable -> L9b
            com.tencent.qphone.base.util.QLog.d(r1, r3, r7)     // Catch: java.lang.Throwable -> L9b
        L42:
            boolean r6 = java.lang.Boolean.parseBoolean(r6)     // Catch: java.lang.Exception -> L81 java.lang.Throwable -> L9b
            goto L82
        L47:
            if (r5 == 0) goto L4c
            r1.put(r5, r6)     // Catch: java.lang.Throwable -> L9b
        L4c:
            boolean r1 = com.tencent.qphone.base.util.QLog.isColorLevel()     // Catch: java.lang.Throwable -> L9b
            if (r1 == 0) goto L7c
            java.lang.String r1 = "set_sp"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9b
            r2.<init>()     // Catch: java.lang.Throwable -> L9b
            java.lang.String r4 = "key is new, key="
            r2.append(r4)     // Catch: java.lang.Throwable -> L9b
            r2.append(r5)     // Catch: java.lang.Throwable -> L9b
            java.lang.String r4 = " v="
            r2.append(r4)     // Catch: java.lang.Throwable -> L9b
            r2.append(r6)     // Catch: java.lang.Throwable -> L9b
            java.lang.String r4 = " tag="
            r2.append(r4)     // Catch: java.lang.Throwable -> L9b
            r2.append(r7)     // Catch: java.lang.Throwable -> L9b
            java.lang.String r7 = r2.toString()     // Catch: java.lang.Throwable -> L9b
            com.tencent.qphone.base.util.QLog.d(r1, r3, r7)     // Catch: java.lang.Throwable -> L9b
        L7c:
            boolean r6 = java.lang.Boolean.parseBoolean(r6)     // Catch: java.lang.Exception -> L81 java.lang.Throwable -> L9b
            goto L82
        L81:
            r6 = 0
        L82:
            java.util.HashSet<java.lang.String> r7 = com.tencent.mobileqq.msf.sdk.SettingCloneUtil.MULTIPROCESS_KEYS     // Catch: java.lang.Throwable -> L9b
            boolean r7 = r7.contains(r5)     // Catch: java.lang.Throwable -> L9b
            if (r7 == 0) goto L99
            android.content.SharedPreferences r7 = getSharedPreferences()     // Catch: java.lang.Throwable -> L9b
            android.content.SharedPreferences$Editor r7 = r7.edit()     // Catch: java.lang.Throwable -> L9b
            android.content.SharedPreferences$Editor r5 = r7.putBoolean(r5, r6)     // Catch: java.lang.Throwable -> L9b
            r5.commit()     // Catch: java.lang.Throwable -> L9b
        L99:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L9b
            return r6
        L9b:
            r5 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L9b
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mobileqq.msf.sdk.SettingCloneUtil.firstInit(java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:15:0x007f
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1166)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:1022)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:55)
        */
    public static int firstInitForInt(java.lang.String r5, java.lang.String r6, java.lang.String r7) {
        /*
            java.lang.Object r0 = com.tencent.mobileqq.msf.sdk.SettingCloneUtil.locker
            monitor-enter(r0)
            java.util.HashMap<java.lang.String, java.lang.String> r1 = com.tencent.mobileqq.msf.sdk.SettingCloneUtil.mapKv     // Catch: java.lang.Throwable -> L82
            boolean r2 = r1.containsKey(r5)     // Catch: java.lang.Throwable -> L82
            r3 = 2
            if (r2 == 0) goto L47
            java.lang.Object r6 = r1.get(r5)     // Catch: java.lang.Throwable -> L82
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Throwable -> L82
            boolean r1 = com.tencent.qphone.base.util.QLog.isColorLevel()     // Catch: java.lang.Throwable -> L82
            if (r1 == 0) goto L42
            java.lang.String r1 = "set_sp"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L82
            r2.<init>()     // Catch: java.lang.Throwable -> L82
            java.lang.String r4 = "containsKey is true, key="
            r2.append(r4)     // Catch: java.lang.Throwable -> L82
            r2.append(r5)     // Catch: java.lang.Throwable -> L82
            java.lang.String r5 = " v="
            r2.append(r5)     // Catch: java.lang.Throwable -> L82
            r2.append(r6)     // Catch: java.lang.Throwable -> L82
            java.lang.String r5 = " tag="
            r2.append(r5)     // Catch: java.lang.Throwable -> L82
            r2.append(r7)     // Catch: java.lang.Throwable -> L82
            java.lang.String r5 = r2.toString()     // Catch: java.lang.Throwable -> L82
            com.tencent.qphone.base.util.QLog.d(r1, r3, r5)     // Catch: java.lang.Throwable -> L82
        L42:
            int r5 = java.lang.Integer.parseInt(r6)     // Catch: java.lang.Exception -> L7f java.lang.Throwable -> L82
            goto L80
        L47:
            r1.put(r5, r6)     // Catch: java.lang.Throwable -> L82
            boolean r1 = com.tencent.qphone.base.util.QLog.isColorLevel()     // Catch: java.lang.Throwable -> L82
            if (r1 == 0) goto L7a
            java.lang.String r1 = "set_sp"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L82
            r2.<init>()     // Catch: java.lang.Throwable -> L82
            java.lang.String r4 = "key is new, key="
            r2.append(r4)     // Catch: java.lang.Throwable -> L82
            r2.append(r5)     // Catch: java.lang.Throwable -> L82
            java.lang.String r5 = " v="
            r2.append(r5)     // Catch: java.lang.Throwable -> L82
            r2.append(r6)     // Catch: java.lang.Throwable -> L82
            java.lang.String r5 = " tag="
            r2.append(r5)     // Catch: java.lang.Throwable -> L82
            r2.append(r7)     // Catch: java.lang.Throwable -> L82
            java.lang.String r5 = r2.toString()     // Catch: java.lang.Throwable -> L82
            com.tencent.qphone.base.util.QLog.d(r1, r3, r5)     // Catch: java.lang.Throwable -> L82
        L7a:
            int r5 = java.lang.Integer.parseInt(r6)     // Catch: java.lang.Exception -> L7f java.lang.Throwable -> L82
            goto L80
        L7f:
            r5 = -1
        L80:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L82
            return r5
        L82:
            r5 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L82
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mobileqq.msf.sdk.SettingCloneUtil.firstInitForInt(java.lang.String, java.lang.String, java.lang.String):int");
    }

    public static String get(String str) {
        String str2;
        synchronized (locker) {
            HashMap<String, String> hashMap = mapKv;
            if (hashMap.containsKey(str)) {
                str2 = hashMap.get(str);
            } else {
                str2 = null;
            }
            if (str2 == null) {
                HashMap<String, String> hashMap2 = tmpMapKv;
                if (hashMap2.containsKey(str)) {
                    str2 = hashMap2.get(str);
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(KEY_FILE, 2, "get k=" + str + " v=" + str2);
        }
        return str2;
    }

    public static SharedPreferences getMMKVDefaultSharedPreferences() {
        String defaultSharedPreferencesName;
        BaseApplication context = BaseApplication.getContext();
        if (BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion() && (!com.tencent.mobileqq.msf.core.x.i.a().c() || !com.tencent.mobileqq.msf.core.x.i.a().b())) {
            return PreferenceManager.getDefaultSharedPreferences(context);
        }
        if (Build.VERSION.SDK_INT >= 24) {
            com.tencent.mobileqq.msf.core.b0.a b16 = com.tencent.mobileqq.msf.core.b0.a.b();
            defaultSharedPreferencesName = PreferenceManager.getDefaultSharedPreferencesName(context);
            return b16.b(defaultSharedPreferencesName, 0);
        }
        return com.tencent.mobileqq.msf.core.b0.a.b().b(context.getPackageName() + "_preferences", 0);
    }

    public static SharedPreferences getSharedPreferences() {
        if (BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion() && !com.tencent.mobileqq.msf.core.x.i.a().c()) {
            return SharedPreferencesProxyManager.getInstance().getProxy(KEY_FILE_MULTI_PROCESS, 4);
        }
        return com.tencent.mobileqq.msf.core.b0.a.b().b(KEY_FILE_MULTI_PROCESS, 4);
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x0124  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isContainValue(Context context, String str, String str2, String str3) {
        boolean z16 = false;
        if (context == null) {
            if (QLog.isColorLevel()) {
                QLog.d(KEY_FILE, 2, "isContainValue().ctx is null.");
            }
            return false;
        }
        if (str != null && str.length() > 0) {
            str3 = str3 + str;
        }
        if (isKeyFileExists(context)) {
            FileInputStream fileInputStream = null;
            try {
                if (QLog.isColorLevel()) {
                    QLog.d(KEY_FILE, 2, "isContainValue().load key_file ing...");
                }
                fileInputStream = context.openFileInput(KEY_FILE);
                Properties properties = new Properties();
                properties.load(fileInputStream);
                if (QLog.isColorLevel()) {
                    QLog.d(KEY_FILE, 2, "isContainValue().load key_file ok");
                }
                if (properties.containsKey(str3)) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                            return true;
                        } catch (Throwable th5) {
                            if (QLog.isColorLevel()) {
                                QLog.d(KEY_FILE, 2, "isContainValue().read finally. exception:" + String.valueOf(th5));
                            }
                            th5.printStackTrace();
                            return true;
                        }
                    }
                    return true;
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th6) {
                        th = th6;
                        if (QLog.isColorLevel()) {
                            QLog.d(KEY_FILE, 2, "isContainValue().read finally. exception:" + String.valueOf(th));
                        }
                        th.printStackTrace();
                        if (!TextUtils.isEmpty(str2)) {
                        }
                        return z16;
                    }
                }
            } catch (Throwable th7) {
                try {
                    if (QLog.isColorLevel()) {
                        QLog.d(KEY_FILE, 2, "isContainValue().read exception:" + String.valueOf(th7));
                    }
                    th7.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable th8) {
                            th = th8;
                            if (QLog.isColorLevel()) {
                                QLog.d(KEY_FILE, 2, "isContainValue().read finally. exception:" + String.valueOf(th));
                            }
                            th.printStackTrace();
                            if (!TextUtils.isEmpty(str2)) {
                            }
                            return z16;
                        }
                    }
                } catch (Throwable th9) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable th10) {
                            if (QLog.isColorLevel()) {
                                QLog.d(KEY_FILE, 2, "isContainValue().read finally. exception:" + String.valueOf(th10));
                            }
                            th10.printStackTrace();
                        }
                    }
                    throw th9;
                }
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            SharedPreferences mMKVDefaultSharedPreferences = getMMKVDefaultSharedPreferences();
            if (str != null && str.length() > 0) {
                str2 = str2 + str;
            }
            z16 = mMKVDefaultSharedPreferences.contains(str2);
            if (QLog.isColorLevel()) {
                QLog.d(KEY_FILE, 2, "isContainValue().read sp ok, ret =" + z16);
            }
        }
        return z16;
    }

    private static boolean isKeyFileExists(Context context) {
        boolean z16 = false;
        if (context != null && context.getFileStreamPath(KEY_FILE) != null && context.getFileStreamPath(KEY_FILE).exists()) {
            z16 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.d(KEY_FILE, 2, "file exist:" + z16);
        }
        return z16;
    }

    public static boolean put(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(KEY_FILE, 2, "put k=" + str + " v=" + str2);
        }
        synchronized (locker) {
            HashMap<String, String> hashMap = mapKv;
            String str3 = hashMap.get(str);
            if (str3 != null && str3.equals(str2)) {
                return false;
            }
            hashMap.put(str, str2);
            return true;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x008f -> B:23:0x009f). Please report as a decompilation issue!!! */
    private static String readFromFile(Context context, String str) {
        BufferedInputStream bufferedInputStream;
        String str2 = null;
        if (!mHasInit && isKeyFileExists(context)) {
            try {
                try {
                    bufferedInputStream = new BufferedInputStream(context.openFileInput(KEY_FILE));
                } catch (Throwable th5) {
                    th = th5;
                    bufferedInputStream = null;
                }
            } catch (Throwable th6) {
                QLog.e(KEY_FILE, 1, "", th6);
            }
            try {
                Properties properties = new Properties();
                properties.load(bufferedInputStream);
                if (TextUtils.isEmpty(str)) {
                    for (Object obj : properties.keySet()) {
                        if (obj instanceof String) {
                            String str3 = (String) obj;
                            String property = properties.getProperty(str3);
                            if (QLog.isColorLevel()) {
                                QLog.d(KEY_FILE, 2, "readFromFile first.key=" + str3 + ",kevalue= " + property);
                            }
                            mapKv.put(str3, property);
                        }
                    }
                    mHasInit = true;
                } else if (properties.containsKey(str)) {
                    str2 = properties.getProperty(str);
                }
                bufferedInputStream.close();
            } catch (Throwable th7) {
                th = th7;
                try {
                    QLog.e(KEY_FILE, 1, "", th);
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    return str2;
                } catch (Throwable th8) {
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Throwable th9) {
                            QLog.e(KEY_FILE, 1, "", th9);
                        }
                    }
                    throw th8;
                }
            }
        }
        return str2;
    }

    public static boolean readValue(Context context, String str, String str2, String str3, boolean z16) {
        String str4;
        if (context == null) {
            if (QLog.isColorLevel()) {
                QLog.d(KEY_FILE, 2, "read boolean. ctx is null.defV=" + z16);
            }
            return z16;
        }
        if (str == null || str.length() <= 0) {
            str4 = str3;
        } else {
            str4 = str3 + str;
        }
        HashSet<String> hashSet = MULTIPROCESS_KEYS;
        if (hashSet.contains(str3) && getSharedPreferences().contains(str4)) {
            return getSharedPreferences().getBoolean(str4, z16);
        }
        String str5 = get(str4);
        if (str5 != null) {
            boolean parseBoolean = Boolean.parseBoolean(str5);
            if (hashSet.contains(str4)) {
                getSharedPreferences().edit().putBoolean(str4, parseBoolean).commit();
            }
            return parseBoolean;
        }
        if (str4 != null) {
            synchronized (locker) {
                readFromFile(context, null);
            }
            String str6 = get(str4);
            if (str6 != null) {
                boolean parseBoolean2 = Boolean.parseBoolean(str6);
                if (hashSet.contains(str4)) {
                    getSharedPreferences().edit().putBoolean(str4, parseBoolean2).commit();
                }
                return parseBoolean2;
            }
        }
        if (TextUtils.isEmpty(str2)) {
            return z16;
        }
        QLog.d(KEY_FILE, 1, "read boolean value of key: " + str2 + " from DefaultSharedPreferences");
        SharedPreferences mMKVDefaultSharedPreferences = getMMKVDefaultSharedPreferences();
        if (str != null && str.length() > 0) {
            str2 = str2 + str;
        }
        if (!mMKVDefaultSharedPreferences.contains(str2)) {
            synchronized (locker) {
                tmpMapKv.put(str2, Boolean.toString(z16));
            }
            return z16;
        }
        boolean z17 = mMKVDefaultSharedPreferences.getBoolean(str2, z16);
        if (QLog.isColorLevel()) {
            QLog.d(KEY_FILE, 2, "read boolean. sp ok, k=" + str2 + " v=" + z17);
        }
        return firstInit(str4, Boolean.toString(z17), "sp");
    }

    public static int readValueForInt(Context context, String str, String str2, String str3, int i3) {
        String str4;
        if (context == null) {
            if (QLog.isColorLevel()) {
                QLog.d(KEY_FILE, 2, "read int.ctx is null.defV=" + i3);
            }
            return i3;
        }
        if (str != null && str.length() > 0) {
            str4 = str3 + str;
        } else {
            str4 = str3;
        }
        HashSet<String> hashSet = MULTIPROCESS_KEYS;
        if (hashSet.contains(str3) && getSharedPreferences().contains(str4)) {
            return getSharedPreferences().getInt(str4, i3);
        }
        String str5 = get(str4);
        if (str5 != null) {
            try {
                int parseInt = Integer.parseInt(str5);
                if (hashSet.contains(str4)) {
                    getSharedPreferences().edit().putInt(str4, parseInt).commit();
                }
                return parseInt;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(KEY_FILE, 2, "read int.parse int exception =" + String.valueOf(e16));
                }
            }
        }
        synchronized (locker) {
            readFromFile(context, null);
        }
        String str6 = get(str4);
        if (str6 != null) {
            try {
                int parseInt2 = Integer.parseInt(str6);
                if (MULTIPROCESS_KEYS.contains(str4)) {
                    getSharedPreferences().edit().putInt(str4, parseInt2).commit();
                }
                return parseInt2;
            } catch (NumberFormatException e17) {
                if (QLog.isColorLevel()) {
                    QLog.d(KEY_FILE, 2, "read int.parse int exception =" + String.valueOf(e17));
                }
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            SharedPreferences mMKVDefaultSharedPreferences = getMMKVDefaultSharedPreferences();
            if (str != null && str.length() > 0) {
                str2 = str2 + str;
            }
            int i16 = mMKVDefaultSharedPreferences.getInt(str2, i3);
            if (QLog.isColorLevel()) {
                QLog.d(KEY_FILE, 2, "read int.read sp ok, k=" + str2 + " v=" + i16);
            }
            return firstInitForInt(str4, Integer.toString(i16), "sp");
        }
        return i3;
    }

    private static Properties updateProperties() {
        Properties properties = new Properties();
        HashMap<String, String> hashMap = mapKv;
        if (hashMap != null) {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                properties.setProperty(entry.getKey(), entry.getValue());
            }
        }
        return properties;
    }

    public static void writeValue(Context context, String str, String str2, String str3, boolean z16) {
        String str4;
        FileOutputStream openFileOutput;
        if (context == null) {
            if (QLog.isColorLevel()) {
                QLog.d(KEY_FILE, 2, "write boolean. ctx is null");
                return;
            }
            return;
        }
        if (str == null || str.length() <= 0) {
            str4 = str3;
        } else {
            str4 = str3 + str;
        }
        if (MULTIPROCESS_KEYS.contains(str3)) {
            getSharedPreferences().edit().putBoolean(str4, z16).commit();
            return;
        }
        synchronized (locker) {
            if (put(str4, Boolean.toString(z16))) {
                Properties updateProperties = updateProperties();
                FileOutputStream fileOutputStream = null;
                try {
                    openFileOutput = context.openFileOutput(KEY_FILE, 0);
                } catch (Throwable th5) {
                    th = th5;
                }
                try {
                    updateProperties.store(openFileOutput, (String) null);
                    if (QLog.isColorLevel()) {
                        QLog.d(KEY_FILE, 2, "write boolean. write file ok.k=" + str4 + " v=" + z16);
                    }
                } catch (Throwable th6) {
                    th = th6;
                    fileOutputStream = openFileOutput;
                    try {
                        if (QLog.isColorLevel()) {
                            QLog.d(KEY_FILE, 2, "write boolean.01write exception:" + String.valueOf(th));
                        }
                        th.printStackTrace();
                        try {
                            if (!TextUtils.isEmpty(str2)) {
                                if (str != null && str.length() > 0) {
                                    str2 = str2 + str;
                                }
                                SharedPreferences mMKVDefaultSharedPreferences = getMMKVDefaultSharedPreferences();
                                if (mMKVDefaultSharedPreferences.contains(str2)) {
                                    SharedPreferences.Editor edit = mMKVDefaultSharedPreferences.edit();
                                    edit.remove(str2);
                                    edit.commit();
                                    if (QLog.isColorLevel()) {
                                        QLog.d(KEY_FILE, 2, "remove sp ok.k=" + str2);
                                    }
                                }
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                        } catch (Exception e16) {
                            e = e16;
                            if (QLog.isColorLevel()) {
                                QLog.d(KEY_FILE, 2, "02write exception:" + String.valueOf(e));
                            }
                            e.printStackTrace();
                        }
                    } finally {
                    }
                }
                try {
                    if (!TextUtils.isEmpty(str2)) {
                        if (str != null && str.length() > 0) {
                            str2 = str2 + str;
                        }
                        SharedPreferences mMKVDefaultSharedPreferences2 = getMMKVDefaultSharedPreferences();
                        if (mMKVDefaultSharedPreferences2.contains(str2)) {
                            SharedPreferences.Editor edit2 = mMKVDefaultSharedPreferences2.edit();
                            edit2.remove(str2);
                            edit2.commit();
                            if (QLog.isColorLevel()) {
                                QLog.d(KEY_FILE, 2, "remove sp ok.k=" + str2);
                            }
                        }
                    }
                    if (openFileOutput != null) {
                        openFileOutput.close();
                    }
                } catch (Exception e17) {
                    e = e17;
                    if (QLog.isColorLevel()) {
                        QLog.d(KEY_FILE, 2, "02write exception:" + String.valueOf(e));
                    }
                    e.printStackTrace();
                }
            }
        }
    }

    public static void writeValueForInt(Context context, String str, String str2, String str3, int i3) {
        String str4;
        FileOutputStream openFileOutput;
        if (context == null) {
            if (QLog.isColorLevel()) {
                QLog.d(KEY_FILE, 2, "write int. ctx is null");
                return;
            }
            return;
        }
        if (str == null || str.length() <= 0) {
            str4 = str3;
        } else {
            str4 = str3 + str;
        }
        if (MULTIPROCESS_KEYS.contains(str3)) {
            getSharedPreferences().edit().putInt(str4, i3).commit();
            return;
        }
        synchronized (locker) {
            if (put(str4, Integer.toString(i3))) {
                Properties updateProperties = updateProperties();
                FileOutputStream fileOutputStream = null;
                try {
                    openFileOutput = context.openFileOutput(KEY_FILE, 0);
                } catch (Throwable th5) {
                    th = th5;
                }
                try {
                    updateProperties.store(openFileOutput, (String) null);
                    if (QLog.isColorLevel()) {
                        QLog.d(KEY_FILE, 2, "write int. refresh properties ok.k=" + str4 + " v=" + i3);
                    }
                } catch (Throwable th6) {
                    th = th6;
                    fileOutputStream = openFileOutput;
                    try {
                        if (QLog.isColorLevel()) {
                            QLog.d(KEY_FILE, 2, "write int. 01write exception:" + String.valueOf(th));
                        }
                        th.printStackTrace();
                        try {
                            if (!TextUtils.isEmpty(str2)) {
                                if (str != null && str.length() > 0) {
                                    str2 = str2 + str;
                                }
                                SharedPreferences mMKVDefaultSharedPreferences = getMMKVDefaultSharedPreferences();
                                if (mMKVDefaultSharedPreferences.contains(str2)) {
                                    SharedPreferences.Editor edit = mMKVDefaultSharedPreferences.edit();
                                    edit.remove(str2);
                                    edit.commit();
                                    if (QLog.isColorLevel()) {
                                        QLog.d(KEY_FILE, 2, "remove sp ok.k=" + str2);
                                    }
                                }
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                        } catch (Exception e16) {
                            e = e16;
                            if (QLog.isColorLevel()) {
                                QLog.d(KEY_FILE, 2, "write int. 02write exception:" + String.valueOf(e));
                            }
                            e.printStackTrace();
                        }
                    } finally {
                    }
                }
                try {
                    if (!TextUtils.isEmpty(str2)) {
                        if (str != null && str.length() > 0) {
                            str2 = str2 + str;
                        }
                        SharedPreferences mMKVDefaultSharedPreferences2 = getMMKVDefaultSharedPreferences();
                        if (mMKVDefaultSharedPreferences2.contains(str2)) {
                            SharedPreferences.Editor edit2 = mMKVDefaultSharedPreferences2.edit();
                            edit2.remove(str2);
                            edit2.commit();
                            if (QLog.isColorLevel()) {
                                QLog.d(KEY_FILE, 2, "remove sp ok.k=" + str2);
                            }
                        }
                    }
                    if (openFileOutput != null) {
                        openFileOutput.close();
                    }
                } catch (Exception e17) {
                    e = e17;
                    if (QLog.isColorLevel()) {
                        QLog.d(KEY_FILE, 2, "write int. 02write exception:" + String.valueOf(e));
                    }
                    e.printStackTrace();
                }
            }
        }
    }

    public static String readValue(Context context, String str, String str2, String str3, String str4) {
        String str5;
        if (context == null) {
            if (QLog.isColorLevel()) {
                QLog.d(KEY_FILE, 2, "read String. ctx is null.defV=" + str4);
            }
            return str4;
        }
        if (str == null || str.length() <= 0) {
            str5 = str3;
        } else {
            str5 = str3 + str;
        }
        HashSet<String> hashSet = MULTIPROCESS_KEYS;
        if (hashSet.contains(str3) && getSharedPreferences().contains(str5)) {
            return getSharedPreferences().getString(str5, str4);
        }
        String str6 = get(str5);
        if (str6 != null) {
            if (hashSet.contains(str5)) {
                getSharedPreferences().edit().putString(str5, str6).commit();
            }
            return str6;
        }
        if (str5 != null) {
            synchronized (locker) {
                readFromFile(context, null);
            }
            String str7 = get(str5);
            if (str7 != null) {
                if (hashSet.contains(str5)) {
                    getSharedPreferences().edit().putString(str5, str7).commit();
                }
                return str7;
            }
        }
        return str4;
    }

    public static void writeValue(Context context, String str, String str2, String str3, String str4) {
        String str5;
        FileOutputStream openFileOutput;
        if (context == null) {
            if (QLog.isColorLevel()) {
                QLog.d(KEY_FILE, 2, "write string. ctx is null");
                return;
            }
            return;
        }
        if (str == null || str.length() <= 0) {
            str5 = str3;
        } else {
            str5 = str3 + str;
        }
        if (MULTIPROCESS_KEYS.contains(str3)) {
            getSharedPreferences().edit().putString(str5, str4).commit();
            return;
        }
        synchronized (locker) {
            if (put(str5, str4)) {
                Properties updateProperties = updateProperties();
                FileOutputStream fileOutputStream = null;
                try {
                    try {
                        openFileOutput = context.openFileOutput(KEY_FILE, 0);
                        try {
                            updateProperties.store(openFileOutput, (String) null);
                            if (QLog.isColorLevel()) {
                                QLog.d(KEY_FILE, 2, "write string. write file ok.k=" + str5 + " v=" + str4);
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d(KEY_FILE, 2, "write string.01write unknown exception");
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            fileOutputStream = openFileOutput;
                            try {
                                if (QLog.isColorLevel()) {
                                    QLog.d(KEY_FILE, 2, "write string.01write exception:" + String.valueOf(th));
                                }
                                th.printStackTrace();
                                if (QLog.isColorLevel()) {
                                    QLog.d(KEY_FILE, 2, "write string.01write unknown exception");
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                            } finally {
                            }
                        }
                    } catch (Throwable th6) {
                        th = th6;
                    }
                    if (openFileOutput != null) {
                        openFileOutput.close();
                    }
                } catch (IOException e16) {
                    QLog.e(KEY_FILE, 1, "close file exception", e16);
                }
            }
        }
    }
}
