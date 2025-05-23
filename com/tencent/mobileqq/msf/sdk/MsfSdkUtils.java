package com.tencent.mobileqq.msf.sdk;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.PowerManager;
import android.os.Process;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.net.NetContants;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import com.tencent.qqmini.minigame.plugins.AudioRecorderJsPlugin;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.TimeZone;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;
import oicq.wlogin_sdk.tools.util;
import org.jf.dexlib2.analysis.RegisterType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MsfSdkUtils {
    static IPatchRedirector $redirector_ = null;
    private static final int BUFF_LENGTH_BYTES = 4;
    public static final String BUSINESS_ID_VIP_CUSTOMIZE_ONLINE_STATUS = "bussiness_id_customize_online_status";
    public static final int MODE_ERR_MANU = -10003;
    public static final int MODE_ERR_SERVICE = -10001;
    public static final int MODE_EXCEPTION = -10000;
    public static final int MODE_LOW_END = -10002;
    public static final int MODE_UNINIT = -9999;
    private static final int OP_AUTO_START_MI_ABOVE_23 = 10008;
    private static final int OP_AUTO_START_MI_BELOW_23 = 50;
    public static final String TAG_COREUTIL_TOMSGE_UID = "__CoreUtil_toMsg_Uid";
    private static String currentProcessName = null;
    private static final String[] s_validBusId;
    private static final AtomicInteger seqFactory;
    private static final String tag = "MsfSdkUtils";
    public static final SimpleDateFormat timeFormatter;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27377);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        seqFactory = new AtomicInteger(new Random().nextInt(100000));
        timeFormatter = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        s_validBusId = new String[]{BUSINESS_ID_VIP_CUSTOMIZE_ONLINE_STATUS};
    }

    public MsfSdkUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static byte[] addByteLen(byte[] bArr) {
        int length = bArr.length + 4;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length).put(bArr).flip();
        return allocate.array();
    }

    public static void addFromMsgProcessName(String str, FromServiceMsg fromServiceMsg) {
        if (fromServiceMsg == null) {
            return;
        }
        fromServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_SENDERPROCESSNAME, str);
    }

    public static synchronized void addLoginSimpleAccount(String str, boolean z16) {
        String str2;
        synchronized (MsfSdkUtils.class) {
            com.tencent.mobileqq.msf.core.auth.k.a(str, com.tencent.mobileqq.msf.core.auth.k.f247492f);
            if (!isUinLong(str)) {
                QLog.d(tag, 1, "[addLoginSimpleAccount], get invalid uin: " + str);
                return;
            }
            QLog.d(tag, 1, "add login user ", getShortUin(str), "_", Boolean.valueOf(z16));
            File newAppUinStoreFile = getNewAppUinStoreFile();
            if (!newAppUinStoreFile.exists()) {
                newAppUinStoreFile.mkdirs();
            }
            if (newAppUinStoreFile.exists()) {
                if (isAccountFileExist(newAppUinStoreFile, str)) {
                    updateSimpleAccountNotCreate(str, true);
                    return;
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append(newAppUinStoreFile.getAbsolutePath());
                sb5.append("/u_");
                sb5.append(str);
                if (z16) {
                    str2 = "_t";
                } else {
                    str2 = "_f";
                }
                sb5.append(str2);
                try {
                    new File(sb5.toString()).createNewFile();
                } catch (Exception e16) {
                    QLog.e(tag, 1, "add user failed " + str, e16);
                }
            }
        }
    }

    public static synchronized void addSimpleAccount(String str) {
        synchronized (MsfSdkUtils.class) {
            com.tencent.mobileqq.msf.core.auth.k.a(str, com.tencent.mobileqq.msf.core.auth.k.f247492f);
            if (!isUinLong(str)) {
                QLog.d(tag, 1, "[updateSimpleUserInfoStore], get invalid uin: " + str);
                return;
            }
            QLog.d(tag, 1, "add user ", getShortUin(str));
            File newAppUinStoreFile = getNewAppUinStoreFile();
            if (!newAppUinStoreFile.exists()) {
                newAppUinStoreFile.mkdirs();
            }
            if (newAppUinStoreFile.exists()) {
                if (isAccountFileExist(newAppUinStoreFile, str)) {
                    return;
                }
                try {
                    new File(newAppUinStoreFile.getAbsolutePath() + "/u_" + str + "_f").createNewFile();
                    QLog.d(tag, 1, "add user succ " + str);
                } catch (Exception e16) {
                    QLog.e(tag, 1, "add user failed " + str, e16);
                }
            }
        }
    }

    public static void addToMsgProcessName(String str, ToServiceMsg toServiceMsg) {
        if (toServiceMsg == null) {
            return;
        }
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_SENDERPROCESSNAME, str);
    }

    public static FromServiceMsg constructResponse(String str, String str2, int i3, int i16, String str3, Object obj, int i17) {
        FromServiceMsg fromServiceMsg = new FromServiceMsg(str, str2);
        fromServiceMsg.setAppId(i3);
        if (i16 != 1000) {
            fromServiceMsg.setBusinessFail(i16, str3);
        } else {
            fromServiceMsg.setMsgSuccess();
        }
        if (obj != null) {
            fromServiceMsg.addAttribute(str2, obj);
        }
        fromServiceMsg.setRequestSsoSeq(i17);
        return fromServiceMsg;
    }

    public static int convertBytes2Int(byte[] bArr) {
        return ((bArr[3] << 0) & 255) | ((bArr[0] << 24) & (-16777216)) | ((bArr[1] << RegisterType.UNINIT_REF) & ITVKAsset.VOD_ASSET_MASK_BIT) | ((bArr[2] << 8) & 65280);
    }

    public static byte[] convertInt2Bytes(int i3) {
        return new byte[]{(byte) ((i3 >>> 24) & 255), (byte) ((i3 >>> 16) & 255), (byte) ((i3 >>> 8) & 255), (byte) (i3 & 255)};
    }

    public static HashSet<String> convertJsonArrayToSet(JSONArray jSONArray) {
        HashSet<String> hashSet = new HashSet<>();
        if (jSONArray != null && jSONArray.length() != 0) {
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                try {
                    hashSet.add(jSONArray.getString(i3));
                } catch (JSONException e16) {
                    QLog.d(tag, 1, "convertJsonArrayToSet with exception !", e16);
                }
            }
        }
        return hashSet;
    }

    public static Map<String, String> convertJsonToMap(String str) {
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                Object opt = jSONObject.opt(str2);
                if (opt != null) {
                    hashMap.put(str2, opt.toString());
                }
            }
        } catch (JSONException e16) {
            QLog.d(tag, 2, "convertJsonToMap with exception !", e16);
        }
        return hashMap;
    }

    public static synchronized void delSimpleAccount(String str) {
        synchronized (MsfSdkUtils.class) {
            com.tencent.mobileqq.msf.core.auth.k.a(str, com.tencent.mobileqq.msf.core.auth.k.f247492f);
            if (!isUinLong(str)) {
                QLog.d(tag, 1, "[delSimpleAccount], get invalid uin: " + str);
                return;
            }
            File newAppUinStoreFile = getNewAppUinStoreFile();
            if (newAppUinStoreFile.exists()) {
                for (String str2 : newAppUinStoreFile.list()) {
                    if (!str2.equals("u_" + str + "_f")) {
                        if (!str2.equals("u_" + str + "_t")) {
                        }
                    }
                    new File(newAppUinStoreFile.getPath(), str2).delete();
                    QLog.d(tag, 1, "del user succ " + str);
                }
            }
        }
    }

    public static String getAppBuildNum() {
        return BaseApplication.buildNum;
    }

    public static String getAppChannelId() {
        return BaseApplication.getContext().getChannelId();
    }

    public static File getAppUinBackStoreFile() {
        String wTUinStoreFileDirLastResort;
        try {
            wTUinStoreFileDirLastResort = BaseApplication.getContext().getFilesDir().getAbsolutePath();
        } catch (Exception unused) {
            wTUinStoreFileDirLastResort = BaseApplication.getContext().getMSFInterfaceAdapter().getWTUinStoreFileDirLastResort();
        }
        QLog.d(tag, 1, "getAppUinBackStoreFile get Application Path is " + wTUinStoreFileDirLastResort);
        try {
            return new File(wTUinStoreFileDirLastResort + "/simpleback.user");
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static File getAppUinStoreFile() {
        String wTUinStoreFileDirLastResort;
        try {
            wTUinStoreFileDirLastResort = BaseApplication.getContext().getFilesDir().getAbsolutePath();
        } catch (Exception unused) {
            wTUinStoreFileDirLastResort = BaseApplication.getContext().getMSFInterfaceAdapter().getWTUinStoreFileDirLastResort();
        }
        QLog.d(tag, 1, "getAppUinStoreFile get Application Path is " + wTUinStoreFileDirLastResort);
        try {
            return new File(wTUinStoreFileDirLastResort + "/simple.user");
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static String getAppVersion() {
        return BaseApplication.reportVersionName;
    }

    public static String getAppid() {
        return String.valueOf(BaseApplication.getContext().getAppId());
    }

    @TargetApi(19)
    public static int getAutoStartMode(Context context) {
        if (!CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_XIAOMI.equals(Build.MANUFACTURER)) {
            return -10003;
        }
        try {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            Class<?> cls = appOpsManager.getClass();
            Class<?> cls2 = Integer.TYPE;
            Method method = cls.getMethod(AudioRecorderJsPlugin.AudioManager.FUNCTION_NAME_CHECK_OP_NOT_THROW, cls2, cls2, String.class);
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            return ((Integer) method.invoke(appOpsManager, 10008, Integer.valueOf(applicationInfo.uid), applicationInfo.packageName)).intValue();
        } catch (Throwable th5) {
            QLog.d("MsfSdk", 1, "getAutoStartMode", th5);
            return -10000;
        }
    }

    public static String getCurrentThreadStackString() {
        StringBuilder sb5 = null;
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace != null) {
                sb5 = new StringBuilder(1024);
            }
            for (StackTraceElement stackTraceElement : stackTrace) {
                sb5.append(stackTraceElement.toString());
                sb5.append("#");
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (sb5 == null) {
            return "";
        }
        return sb5.toString();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:5|6|7|8|(6:10|(2:58|59)|12|13|(1:15)|16)(1:62)|(7:18|(1:20)|21|22|23|(1:25)|(1:30)(2:28|29))|(7:38|39|(2:41|(4:43|44|(1:46)|48))|22|23|(0)|(0)(0))|21|22|23|(0)|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ff, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0100, code lost:
    
        r6 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0044, code lost:
    
        if (r4.length() == 0) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00e3 A[Catch: Exception -> 0x00ff, TRY_LEAVE, TryCatch #0 {Exception -> 0x00ff, blocks: (B:23:0x00dd, B:25:0x00e3), top: B:22:0x00dd }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getIMEIForMain(String str) {
        String str2;
        TelephonyManager telephonyManager;
        String str3;
        int i3;
        if (!isValidBusId(str)) {
            return "";
        }
        try {
            telephonyManager = (TelephonyManager) BaseApplication.getContext().getSystemService("phone");
            str3 = null;
            if (new File(MsfCore.getIMEIPath()).exists()) {
                str2 = loadConfig(MsfCore.getIMEIPath()).getProperty("imei");
                if (str2 != null) {
                    try {
                    } catch (Exception e16) {
                        e = e16;
                        QLog.d(tag, 1, "read sys imei error " + e, e);
                        if (str2 != null) {
                        }
                    }
                }
                LockMethodProxy.sleep(200L);
                str2 = loadConfig(MsfCore.getIMEIPath()).getProperty("imei", null);
                if (QLog.isColorLevel()) {
                    QLog.d(tag, 2, "read imei from file " + MsfCore.getIMEIPath() + ", imei:" + str2 + ",with order:1");
                }
                i3 = 1;
            } else {
                i3 = 0;
                str2 = "";
            }
        } catch (Exception e17) {
            e = e17;
            str2 = "";
        }
        if (str2 != null) {
            if (str2.length() == 0) {
            }
            i3 = 1;
            if (QLog.isColorLevel()) {
                QLog.d(tag, 1, "save imei:" + str2 + ",with order:" + i3);
            }
            if (str2 != null) {
                return "";
            }
            return str2;
        }
        if (telephonyManager != null && com.tencent.mobileqq.msf.core.m.i().e()) {
            try {
                str3 = DeviceInfoMonitor.getDeviceId(telephonyManager);
            } catch (SecurityException e18) {
                if (QLog.isColorLevel()) {
                    QLog.d(tag, 2, "read sys imei SecurityException=", e18);
                }
            }
            if (str3 != null) {
                if (str3.length() > 0) {
                    try {
                        if (QLog.isColorLevel()) {
                            QLog.d(tag, 2, "read sys imei:" + str3);
                        }
                        i3 = 3;
                        str2 = str3;
                    } catch (Exception e19) {
                        e = e19;
                        str2 = str3;
                        QLog.d(tag, 1, "read sys imei error " + e, e);
                        if (str2 != null) {
                        }
                    }
                }
            }
            if (QLog.isColorLevel()) {
            }
            if (str2 != null) {
            }
        }
        i3 = 1;
        if (QLog.isColorLevel()) {
        }
        if (str2 != null) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static synchronized List<SimpleAccount> getLoginedAccountList(File file) {
        boolean hasNext;
        SimpleAccount parseSimpleAccount;
        synchronized (MsfSdkUtils.class) {
            Vector vector = new Vector();
            if (file != null && file.exists()) {
                Properties properties = new Properties();
                FileInputStream fileInputStream = null;
                fileInputStream = null;
                fileInputStream = null;
                try {
                } catch (IOException e16) {
                    e16.printStackTrace();
                }
                try {
                    try {
                        FileInputStream fileInputStream2 = new FileInputStream(file);
                        try {
                            properties.load(fileInputStream2);
                            Iterator it = properties.keySet().iterator();
                            while (true) {
                                hasNext = it.hasNext();
                                if (hasNext == 0) {
                                    break;
                                }
                                String str = (String) it.next();
                                String property = properties.getProperty(str);
                                if (property != null && (parseSimpleAccount = SimpleAccount.parseSimpleAccount(property)) != null) {
                                    if (isUinLong(parseSimpleAccount.getUin())) {
                                        vector.add(parseSimpleAccount);
                                    } else {
                                        QLog.d(tag, 1, "found invalid uin: " + str);
                                    }
                                }
                            }
                            fileInputStream2.close();
                            fileInputStream = hasNext;
                        } catch (Exception e17) {
                            e = e17;
                            fileInputStream = fileInputStream2;
                            e.printStackTrace();
                            if (fileInputStream != null) {
                                fileInputStream.close();
                                fileInputStream = fileInputStream;
                            }
                            return vector;
                        } catch (Throwable th5) {
                            th = th5;
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e18) {
                                    e18.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e19) {
                        e = e19;
                    }
                    return vector;
                } catch (Throwable th6) {
                    th = th6;
                }
            }
            return vector;
        }
    }

    public static String getMainProcessName() {
        return BaseApplication.getContext().getPackageName();
    }

    public static File getNewAppUinStoreFile() {
        String wTUinStoreFileDirLastResort;
        try {
            wTUinStoreFileDirLastResort = BaseApplication.getContext().getFilesDir().getAbsolutePath();
        } catch (Exception unused) {
            wTUinStoreFileDirLastResort = BaseApplication.getContext().getMSFInterfaceAdapter().getWTUinStoreFileDirLastResort();
        }
        QLog.d(tag, 1, "getNewAppUinStoreFile get Application Path is " + wTUinStoreFileDirLastResort);
        try {
            return new File(wTUinStoreFileDirLastResort + "/user/");
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(tag, 2, "get user file error " + wTUinStoreFileDirLastResort + " " + e16);
            }
            return null;
        }
    }

    public static synchronized int getNextAppSeq() {
        int incrementAndGet;
        synchronized (MsfSdkUtils.class) {
            AtomicInteger atomicInteger = seqFactory;
            incrementAndGet = atomicInteger.incrementAndGet();
            if (incrementAndGet > 1000000) {
                atomicInteger.set(new Random().nextInt(100000));
            }
            if (incrementAndGet == 50000) {
                incrementAndGet += 10000;
            }
        }
        return incrementAndGet;
    }

    public static String getProcessName(Context context) {
        if (!TextUtils.isEmpty(currentProcessName)) {
            return currentProcessName;
        }
        if (context == null) {
            return "unknown";
        }
        List<ActivityManager.RunningAppProcessInfo> list = null;
        try {
            list = SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY));
            if (list != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : list) {
                    if (runningAppProcessInfo != null && runningAppProcessInfo.pid == Process.myPid()) {
                        String str = runningAppProcessInfo.processName;
                        currentProcessName = str;
                        return str;
                    }
                }
            }
        } catch (Throwable th5) {
            try {
                QLog.d(tag, 1, "getProcessName error " + list, th5);
            } catch (Throwable unused) {
            }
        }
        String processName = getProcessName(Process.myPid());
        if (!TextUtils.isEmpty(processName) && !processName.equals("unknown")) {
            currentProcessName = processName;
        }
        return processName;
    }

    public static String getProcessNameIfNoPrivacyPolicy(Context context) {
        String processName;
        if (Build.VERSION.SDK_INT >= 28) {
            processName = Application.getProcessName();
            return processName;
        }
        try {
            return (String) Class.forName("android.app.ActivityThread").getDeclaredMethod("currentProcessName", new Class[0]).invoke(null, new Object[0]);
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    public static String getResolutionString(Context context) {
        int i3 = context.getResources().getDisplayMetrics().widthPixels;
        int i16 = context.getResources().getDisplayMetrics().heightPixels;
        if (context.getResources().getConfiguration().orientation == 2) {
            i16 = i3;
            i3 = i16;
        }
        return i3 + "X" + i16;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00c9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int getRoutingID(Context context) {
        String property;
        String str = (BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/testEnv") + "/testserver";
        File file = new File(str);
        if (!file.canRead()) {
            file = new File(str);
        }
        if (QLog.isColorLevel()) {
            QLog.i(tag, 2, "testserver path=" + file.getAbsolutePath() + " isFile=" + file.isFile() + " canRead=" + file.canRead() + " length=" + file.length());
        }
        Properties properties = new Properties();
        FileInputStream fileInputStream = null;
        try {
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        try {
            try {
                if (file.exists()) {
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        properties.load(fileInputStream2);
                        fileInputStream2.close();
                        fileInputStream = fileInputStream2;
                    } catch (Exception e17) {
                        e = e17;
                        fileInputStream = fileInputStream2;
                        e.printStackTrace();
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        property = properties.getProperty("id");
                        if (property != null) {
                        }
                        return -1;
                    } catch (Throwable th5) {
                        th = th5;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e18) {
                                e18.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception e19) {
                e = e19;
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            property = properties.getProperty("id");
            if (property != null) {
                try {
                    if (property.trim().length() > 0) {
                        return Integer.valueOf(property).intValue();
                    }
                } catch (Throwable th6) {
                    if (QLog.isColorLevel()) {
                        QLog.i(tag, 2, "parse routingid fail id = " + property, th6);
                    }
                }
            }
            return -1;
        } catch (Throwable th7) {
            th = th7;
        }
    }

    public static int getSendBatteryStatus(int i3, int i16) {
        int i17;
        if (i16 == 1) {
            i17 = i3 | 128;
        } else {
            i17 = i3;
        }
        if (QLog.isColorLevel()) {
            QLog.d(com.tencent.mobileqq.msf.core.push.g.f249686o, 2, "ret:", Integer.valueOf(i17), " batteryCapacity:", Integer.valueOf(i3), " powerConectStatus:", Integer.valueOf(i16));
        }
        return i17;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    public static String getServerConfig(String str, int i3, String str2) {
        InputStreamReader inputStreamReader;
        char[] cArr;
        File serverConfigFile = getServerConfigFile(str, i3, str2);
        if (serverConfigFile != null && serverConfigFile.exists()) {
            StringBuilder sb5 = new StringBuilder();
            ?? r46 = 0;
            InputStreamReader inputStreamReader2 = null;
            try {
                try {
                    inputStreamReader = new InputStreamReader(new FileInputStream(serverConfigFile), "UTF-8");
                    try {
                        cArr = new char[4096];
                    } catch (Exception e16) {
                        e = e16;
                        inputStreamReader2 = inputStreamReader;
                        e.printStackTrace();
                        if (inputStreamReader2 != null) {
                            inputStreamReader = inputStreamReader2;
                            r46 = inputStreamReader2;
                            try {
                                break;
                                inputStreamReader.close();
                            } catch (IOException unused) {
                            }
                        }
                        return sb5.toString();
                    } catch (Throwable th5) {
                        th = th5;
                        r46 = inputStreamReader;
                        if (r46 != 0) {
                            try {
                                r46.close();
                            } catch (IOException unused2) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception e17) {
                    e = e17;
                }
                while (true) {
                    int read = inputStreamReader.read(cArr);
                    r46 = read;
                    if (-1 != read) {
                        sb5.append(cArr, 0, read);
                    }
                    break;
                }
                inputStreamReader.close();
                return sb5.toString();
            } catch (Throwable th6) {
                th = th6;
            }
        } else {
            return "";
        }
    }

    public static File getServerConfigFile(String str, int i3, String str2) {
        String wTUinStoreFileDirLastResort;
        if (str == null) {
            return null;
        }
        String replaceAll = str.replaceAll(":", "_");
        try {
            wTUinStoreFileDirLastResort = BaseApplication.getContext().getFilesDir().getAbsolutePath();
        } catch (Exception unused) {
            wTUinStoreFileDirLastResort = BaseApplication.getContext().getMSFInterfaceAdapter().getWTUinStoreFileDirLastResort();
        }
        QLog.d(tag, 1, "getServerConfigFile get Application Path is " + wTUinStoreFileDirLastResort);
        if (i3 == 0) {
            return new File(wTUinStoreFileDirLastResort + "/" + replaceAll + "_common");
        }
        if (i3 == 1) {
            return new File(wTUinStoreFileDirLastResort + "/" + replaceAll + "_" + str2.hashCode() + "_user");
        }
        if (i3 != 2) {
            return null;
        }
        return new File(wTUinStoreFileDirLastResort + "/" + replaceAll + "_app");
    }

    public static String getShortHexKey(byte[] bArr) {
        if (bArr != null && bArr.length >= 4) {
            return Integer.toHexString(bArr[0]) + Integer.toHexString(bArr[1]) + Integer.toHexString(bArr[2]) + Integer.toHexString(bArr[3]);
        }
        return "*";
    }

    public static String getShortHexString(byte[] bArr, int i3) {
        if (bArr != null && bArr.length >= i3) {
            StringBuilder sb5 = new StringBuilder();
            for (int i16 = 0; i16 < i3; i16++) {
                sb5.append(Integer.toHexString(bArr[i16]));
            }
            return sb5.toString();
        }
        return "*";
    }

    public static String getShortKey(byte[] bArr) {
        if (bArr == null || bArr.length < 4) {
            return "*";
        }
        return MD5.toMD5(new String(bArr)).substring(0, 4) + "*";
    }

    public static String getShortStringKey(byte[] bArr) {
        if (bArr != null && bArr.length >= 4) {
            return new String(bArr, 0, 4);
        }
        return "*";
    }

    public static String getShortUin(String str) {
        if (!TextUtils.isEmpty(str) && str.length() >= 4) {
            return "*" + str.substring(str.length() - 4, str.length());
        }
        return str;
    }

    public static String getStackTraceString(Throwable th5) {
        if (th5 == null) {
            return "";
        }
        for (Throwable th6 = th5; th6 != null; th6 = th6.getCause()) {
            if (th6 instanceof UnknownHostException) {
                return "";
            }
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th5.printStackTrace(printWriter);
        printWriter.flush();
        return stringWriter.toString();
    }

    public static int getThreadCounts(String str) {
        int i3 = 0;
        try {
            Iterator<Thread> it = Thread.getAllStackTraces().keySet().iterator();
            while (it.hasNext()) {
                if (str.equals(it.next().getName())) {
                    i3++;
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0052 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getThreadStackString(String str) {
        Exception e16;
        StringBuilder sb5;
        Map<Thread, StackTraceElement[]> allStackTraces;
        StringBuilder sb6 = null;
        try {
            allStackTraces = Thread.getAllStackTraces();
        } catch (Exception e17) {
            e16 = e17;
            sb5 = null;
        }
        for (Thread thread : allStackTraces.keySet()) {
            if (str.equals(thread.getName())) {
                sb5 = new StringBuilder(1024);
                try {
                    for (StackTraceElement stackTraceElement : allStackTraces.get(thread)) {
                        sb5.append(stackTraceElement.toString());
                        sb5.append(" ");
                    }
                } catch (Exception e18) {
                    e16 = e18;
                    e16.printStackTrace();
                    sb6 = sb5;
                    if (sb6 == null) {
                    }
                }
                sb6 = sb5;
                if (sb6 == null) {
                    return "";
                }
                return sb6.toString();
            }
        }
        if (sb6 == null) {
        }
    }

    public static String getTotalMemory() {
        String str = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                str = readLine.trim();
            }
            bufferedReader.close();
            return str;
        } catch (IOException e16) {
            e16.printStackTrace();
            return str;
        }
    }

    public static String insertMtype(String str, String str2) {
        if (str2.contains("mType=")) {
            return str2;
        }
        if (str != null) {
            int indexOf = str2.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
            if (indexOf > 0) {
                int i3 = indexOf + 1;
                if (str2.length() == i3) {
                    return str2.substring(0, i3) + "mType=" + str;
                }
                int indexOf2 = str2.indexOf("#", indexOf);
                if (indexOf2 > -1) {
                    return str2.substring(0, indexOf2) + "&mType=" + str + str2.substring(indexOf2);
                }
                return str2 + "&mType=" + str;
            }
            if (str2.length() > 0) {
                return str2 + "?mType=" + str;
            }
            return str2;
        }
        return str2;
    }

    private static boolean isAccountFileExist(File file, String str) {
        String[] list = file.list();
        if (list != null && list.length > 0) {
            for (int i3 = 0; i3 < list.length; i3++) {
                String str2 = list[i3];
                if (str2 != null) {
                    if (!str2.equals("u_" + str + "_f")) {
                        if (list[i3].equals("u_" + str + "_t")) {
                            return true;
                        }
                    } else {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @TargetApi(17)
    public static boolean isAirplaneModeOn(Context context) {
        if (Settings.Global.getInt(context.getContentResolver(), "airplane_mode_on", 0) == 0) {
            return false;
        }
        return true;
    }

    public static boolean isBatteryOnlineStatus(PushRegisterInfo pushRegisterInfo) {
        boolean z16;
        Object valueOf;
        if (pushRegisterInfo != null && pushRegisterInfo.extStatus == 1000) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[2];
            objArr[0] = "isBatteryOnlineStatus extStatus:";
            if (pushRegisterInfo == null) {
                valueOf = "null";
            } else {
                valueOf = Long.valueOf(pushRegisterInfo.extStatus);
            }
            objArr[1] = valueOf;
            QLog.d(com.tencent.mobileqq.msf.core.push.g.f249686o, 1, objArr);
        }
        return z16;
    }

    public static boolean isBuildTestEnvValid() {
        if (!BaseApplication.getContext().getMSFInterfaceAdapter().isSwitchToTestEnv()) {
            return false;
        }
        return !BaseApplication.getContext().getSharedPreferences(NetContants.SharePref.KEY_ENABLE_IPV6, 4).getBoolean(NetContants.SharePref.KEY_SET_TEST_ENV, false);
    }

    public static boolean isExistMsfProcess(Context context) {
        ActivityManager activityManager;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context != null && (activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)) != null && (runningAppProcesses = SystemMethodProxy.getRunningAppProcesses(activityManager)) != null) {
            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
            while (it.hasNext()) {
                if (it.next().processName.equals("com.tencent.mobileqq:MSF")) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isMainProcess(String str) {
        return BaseApplication.getContext().getPackageName().equals(str);
    }

    public static boolean isProcessExist(Context context, String str) {
        ActivityManager activityManager;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context != null && !TextUtils.isEmpty(str) && (activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)) != null && (runningAppProcesses = SystemMethodProxy.getRunningAppProcesses(activityManager)) != null) {
            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(it.next().processName, str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isScreenOn(Context context) {
        if (context == null) {
            return false;
        }
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            return ((Boolean) powerManager.getClass().getMethod("isScreenOn", new Class[0]).invoke(powerManager, null)).booleanValue();
        } catch (Throwable th5) {
            QLog.d(tag, 1, "e = " + th5.toString());
            return true;
        }
    }

    public static boolean isTopActivity(Context context) {
        ComponentName componentName;
        if (context == null) {
            return false;
        }
        try {
            String packageName = context.getPackageName();
            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getRunningTasks(1);
            if (runningTasks != null && runningTasks.size() > 0) {
                componentName = runningTasks.get(0).topActivity;
                if (componentName.getPackageName().equals(packageName)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public static boolean isUinLong(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    private static boolean isValidBusId(String str) {
        boolean z16 = false;
        for (String str2 : s_validBusId) {
            if (str2.equals(str)) {
                z16 = true;
            }
        }
        return z16;
    }

    public static boolean killProcess(Context context, String str) {
        if (context != null && str != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY))) {
                if (runningAppProcessInfo.processName.equals(str)) {
                    SystemMethodProxy.killProcess(runningAppProcessInfo.pid);
                    return true;
                }
            }
        }
        return false;
    }

    public static Properties loadConfig(String str) throws Exception {
        FileInputStream fileInputStream;
        Properties properties = new Properties();
        if (str == null) {
            return properties;
        }
        try {
            fileInputStream = new FileInputStream(str);
        } catch (Throwable th5) {
            th = th5;
            fileInputStream = null;
        }
        try {
            properties.load(fileInputStream);
            fileInputStream.close();
            return properties;
        } catch (Throwable th6) {
            th = th6;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }

    public static void printBytes(String str, byte[] bArr, StringBuilder sb5) {
        sb5.append(str);
        if (bArr != null && bArr.length > 0) {
            sb5.append(bArr.length);
            sb5.append("|");
            sb5.append(util.buf_to_string(bArr, 1));
            return;
        }
        sb5.append("null");
    }

    public static void saveConfig(String str, Properties properties) throws Exception {
        FileOutputStream fileOutputStream;
        if (str != null && properties != null) {
            try {
                fileOutputStream = new FileOutputStream(str, false);
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream = null;
            }
            try {
                properties.store(fileOutputStream, "");
                fileOutputStream.close();
            } catch (Throwable th6) {
                th = th6;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        }
    }

    public static String timeMillisToDay(long j3) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd HH:mm:ss", Locale.CHINESE);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone(DateUtil.TIME_ZONE_8));
            return simpleDateFormat.format(new Date(j3));
        } catch (Exception e16) {
            QLog.e(tag, 1, "timeMillisToDay with exception!", e16);
            return "";
        }
    }

    public static synchronized void updateSimpleAccount(String str, boolean z16) {
        String str2;
        synchronized (MsfSdkUtils.class) {
            com.tencent.mobileqq.msf.core.auth.k.a(str, com.tencent.mobileqq.msf.core.auth.k.f247492f);
            if (!isUinLong(str)) {
                QLog.d(tag, 1, "[updateSimpleAccount], get invalid uin: " + str);
                return;
            }
            File newAppUinStoreFile = getNewAppUinStoreFile();
            if (newAppUinStoreFile.exists()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(newAppUinStoreFile.getAbsolutePath());
                sb5.append("/u_");
                sb5.append(str);
                if (z16) {
                    str2 = "_t";
                } else {
                    str2 = "_f";
                }
                sb5.append(str2);
                String sb6 = sb5.toString();
                File file = new File(sb6);
                if (file.exists()) {
                    file.delete();
                    QLog.d(tag, 1, "found want update user exists,del " + str + " " + z16);
                }
                File[] listFiles = newAppUinStoreFile.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        if (!file2.getName().equals("u_" + str + "_t")) {
                            if (!file2.getName().equals("u_" + str + "_f")) {
                            }
                        }
                        file2.renameTo(new File(sb6));
                        QLog.d(tag, 1, "update user succ " + str + " " + z16);
                        return;
                    }
                }
                try {
                    new File(sb6).createNewFile();
                    QLog.d(tag, 1, "update add user succ " + MD5.toMD5(str));
                } catch (Exception e16) {
                    QLog.d(tag, 1, "update add user failed " + MD5.toMD5(str) + " " + e16);
                }
            }
        }
    }

    public static synchronized void updateSimpleAccountNotCreate(String str, boolean z16) {
        String str2;
        synchronized (MsfSdkUtils.class) {
            com.tencent.mobileqq.msf.core.auth.k.a(str, com.tencent.mobileqq.msf.core.auth.k.f247492f);
            if (!isUinLong(str)) {
                QLog.d(tag, 1, "[updateSimpleAccountNotCreate], get invalid uin: " + str);
                return;
            }
            File newAppUinStoreFile = getNewAppUinStoreFile();
            if (newAppUinStoreFile.exists()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(newAppUinStoreFile.getAbsolutePath());
                sb5.append("/u_");
                sb5.append(str);
                if (z16) {
                    str2 = "_t";
                } else {
                    str2 = "_f";
                }
                sb5.append(str2);
                String sb6 = sb5.toString();
                new File(sb6);
                File[] listFiles = newAppUinStoreFile.listFiles();
                if (listFiles != null) {
                    for (File file : listFiles) {
                        if (!file.getName().equals("u_" + str + "_t")) {
                            if (!file.getName().equals("u_" + str + "_f")) {
                            }
                        }
                        file.renameTo(new File(sb6));
                        return;
                    }
                }
            }
        }
    }

    public static void writeServerConfig(String str, int i3, String str2, String str3) throws IOException {
        File serverConfigFile = getServerConfigFile(str, i3, str3);
        if (serverConfigFile != null) {
            if (!serverConfigFile.exists()) {
                serverConfigFile.createNewFile();
            }
            if (serverConfigFile.exists() && serverConfigFile.canWrite()) {
                OutputStreamWriter outputStreamWriter = null;
                try {
                    try {
                        try {
                            OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(new FileOutputStream(serverConfigFile), "UTF-8");
                            try {
                                outputStreamWriter2.write(str2);
                                outputStreamWriter2.flush();
                                outputStreamWriter2.close();
                            } catch (Exception e16) {
                                e = e16;
                                outputStreamWriter = outputStreamWriter2;
                                e.printStackTrace();
                                if (outputStreamWriter != null) {
                                    outputStreamWriter.close();
                                    return;
                                }
                                return;
                            } catch (Throwable th5) {
                                th = th5;
                                outputStreamWriter = outputStreamWriter2;
                                if (outputStreamWriter != null) {
                                    try {
                                        outputStreamWriter.close();
                                    } catch (IOException unused) {
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
                    return;
                } catch (IOException unused2) {
                    return;
                }
            }
            throw new IOException("can not create file " + serverConfigFile.getAbsolutePath());
        }
        throw new IOException("can not get configFile info ");
    }

    public static int convertBytes2Int(byte[] bArr, int i3) {
        return ((bArr[i3 + 3] << 0) & 255) | ((bArr[i3 + 0] << 24) & (-16777216)) | ((bArr[i3 + 1] << RegisterType.UNINIT_REF) & ITVKAsset.VOD_ASSET_MASK_BIT) | ((bArr[i3 + 2] << 8) & 65280);
    }

    public static boolean isScreenOn() {
        PowerManager powerManager = (PowerManager) BaseApplication.getContext().getSystemService("power");
        if (powerManager != null) {
            try {
                return powerManager.isScreenOn();
            } catch (NullPointerException unused) {
                QLog.d(tag, 1, "Maybe IPowerManager is null");
            }
        } else {
            QLog.d(tag, 1, "Get PowerService is null");
        }
        return false;
    }

    public static FromServiceMsg constructResponse(ToServiceMsg toServiceMsg, int i3, String str, Object obj) {
        if (toServiceMsg == null) {
            return new FromServiceMsg();
        }
        FromServiceMsg constructResponse = constructResponse(toServiceMsg.getUin(), toServiceMsg.getServiceCmd(), toServiceMsg.getAppId(), i3, str, obj, toServiceMsg.getRequestSsoSeq());
        constructResponse.setAppSeq(toServiceMsg.getAppSeq());
        return constructResponse;
    }

    public static String getStackTraceString(Throwable th5, int i3) {
        if (th5 == null) {
            return "";
        }
        StackTraceElement[] stackTrace = th5.getStackTrace();
        if (stackTrace == null) {
            return th5.toString();
        }
        StringBuilder sb5 = new StringBuilder(1024);
        int min = Math.min(i3, stackTrace.length);
        for (int i16 = 0; i16 < min; i16++) {
            sb5.append(stackTrace[i16]);
            sb5.append("\r\n");
        }
        return sb5.toString();
    }

    private static String getProcessName(int i3) {
        FileReader fileReader;
        try {
            fileReader = new FileReader("/proc/" + i3 + "/cmdline");
        } catch (Throwable th5) {
            th = th5;
            fileReader = null;
        }
        try {
            char[] cArr = new char[512];
            fileReader.read(cArr);
            int i16 = 0;
            while (i16 < 512 && cArr[i16] != 0) {
                i16++;
            }
            String substring = new String(cArr).substring(0, i16);
            try {
                fileReader.close();
            } catch (Throwable unused) {
            }
            return substring;
        } catch (Throwable th6) {
            th = th6;
            try {
                QLog.e(tag, 1, "getProcessName wrapper throw e", th);
            } catch (Throwable unused2) {
            }
            if (fileReader == null) {
                return "unknown";
            }
            try {
                fileReader.close();
                return "unknown";
            } catch (Throwable unused3) {
                return "unknown";
            }
        }
    }

    public static synchronized List<SimpleAccount> getLoginedAccountList() {
        synchronized (MsfSdkUtils.class) {
            File newAppUinStoreFile = getNewAppUinStoreFile();
            if (newAppUinStoreFile != null && newAppUinStoreFile.exists()) {
                String[] list = newAppUinStoreFile.list();
                Vector vector = new Vector();
                if (list == null) {
                    return vector;
                }
                for (String str : list) {
                    try {
                        if (str.startsWith("u_")) {
                            String handleTimUinStoreFile = BaseApplication.getContext().getMSFInterfaceAdapter().handleTimUinStoreFile(str, newAppUinStoreFile.getAbsolutePath());
                            String substring = handleTimUinStoreFile.substring(2, handleTimUinStoreFile.length() - 2);
                            boolean endsWith = handleTimUinStoreFile.endsWith("_t");
                            SimpleAccount simpleAccount = new SimpleAccount();
                            simpleAccount.setUin(substring);
                            simpleAccount.setAttribute(SimpleAccount._ISLOGINED, String.valueOf(endsWith));
                            if (isUinLong(substring)) {
                                vector.add(simpleAccount);
                                QLog.d(tag, 1, "getLoginedAccountList add account, uin = " + substring + ", isLogin = " + endsWith);
                            } else {
                                QLog.d(tag, 1, "found invalid uin: " + substring);
                                File file = new File(newAppUinStoreFile.getPath(), handleTimUinStoreFile);
                                if (file.exists()) {
                                    QLog.d(tag, 1, "delete invalid uin result: " + file.delete());
                                }
                            }
                        }
                    } catch (Exception e16) {
                        QLog.e(tag, 1, "parse user failed, fileName = " + str, e16);
                    }
                }
                return vector;
            }
            List<SimpleAccount> loginedAccountList = getLoginedAccountList(getAppUinStoreFile());
            if (loginedAccountList != null && loginedAccountList.size() != 0) {
                QLog.d(tag, 1, "load accountList " + loginedAccountList.size());
                return loginedAccountList;
            }
            loginedAccountList = getLoginedAccountList(getAppUinBackStoreFile());
            if (loginedAccountList != null) {
                QLog.d(tag, 1, "load accountList " + loginedAccountList.size() + " from backFile");
            }
            return loginedAccountList;
        }
    }
}
