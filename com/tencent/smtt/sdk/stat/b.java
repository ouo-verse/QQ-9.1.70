package com.tencent.smtt.sdk.stat;

import MTT.ThirdAppInfoNew;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.mobileqq.qwallet.preload.IPreloadResource;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsCoreLoadStat;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.TbsLogReport;
import com.tencent.smtt.sdk.TbsPVConfig;
import com.tencent.smtt.sdk.TbsShareManager;
import com.tencent.smtt.utils.AppUtil;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.i;
import com.tencent.smtt.utils.m;
import com.tencent.smtt.utils.p;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static byte[] f369514a;

    /* renamed from: b, reason: collision with root package name */
    private static ThirdAppInfoNew f369515b;

    /* renamed from: c, reason: collision with root package name */
    private static Map<String, String> f369516c;

    static {
        try {
            f369514a = "65dRa93L".getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
        }
    }

    public static void a(ThirdAppInfoNew thirdAppInfoNew, Context context) {
        String str;
        String str2;
        String str3;
        byte[] a16;
        AppUtil.saveGuid(context, thirdAppInfoNew.sGuid);
        thirdAppInfoNew.sCpu = AppUtil.getDeviceCpuabi();
        JSONObject jSONObject = null;
        if (f369514a == null) {
            try {
                f369514a = "65dRa93L".getBytes("utf-8");
            } catch (UnsupportedEncodingException unused) {
                f369514a = null;
                TbsLog.e("sdkreport", "Post failed -- get POST_DATA_KEY failed!");
            }
        }
        if (f369514a == null) {
            TbsLog.e("sdkreport", "Post failed -- POST_DATA_KEY is null!");
            return;
        }
        String string = TbsDownloadConfig.getInstance(context).mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_DESkEY_TOKEN, "");
        if (TextUtils.isEmpty(string)) {
            str = "";
            str2 = str;
        } else {
            str2 = string.substring(0, string.indexOf(ContainerUtils.FIELD_DELIMITER));
            str = string.substring(string.indexOf(ContainerUtils.FIELD_DELIMITER) + 1, string.length());
        }
        boolean z16 = TextUtils.isEmpty(str2) || str2.length() != 96 || TextUtils.isEmpty(str) || str.length() != 24;
        try {
            p a17 = p.a();
            if (z16) {
                str3 = a17.b() + i.a().b();
            } else {
                str3 = a17.e() + str2;
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str3).openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setConnectTimeout(20000);
            httpURLConnection.setRequestProperty("Connection", "close");
            try {
                jSONObject = b(thirdAppInfoNew, context);
            } catch (Exception e16) {
                TbsLog.i(e16);
            }
            if (jSONObject == null) {
                TbsLog.e("sdkreport", "post -- jsonData is null!");
                return;
            }
            try {
                TbsLog.i("sdkreport", "Post jsonData.toString() is " + jSONObject.toString());
                byte[] bytes = jSONObject.toString().getBytes("utf-8");
                if (z16) {
                    a16 = i.a().a(bytes);
                } else {
                    a16 = i.a(bytes, str);
                }
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection.setRequestProperty("Content-Length", String.valueOf(a16.length));
                try {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    outputStream.write(a16);
                    outputStream.flush();
                    if (httpURLConnection.getResponseCode() == 200) {
                        TbsLog.i("SDKPVReport", "Post successful!");
                        a(context, a(httpURLConnection, str, z16));
                    } else {
                        TbsLog.e("SDKPVReport", "Post failed -- not 200 code is " + httpURLConnection.getResponseCode());
                        TbsLogReport.TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(context).tbsLogInfo();
                        tbsLogInfo.setErrorCode(126);
                        tbsLogInfo.setFailDetail("" + httpURLConnection.getResponseCode());
                        TbsLogReport.getInstance(context).eventReport(TbsLogReport.EventType.TYPE_PV_UPLOAD_STAT, tbsLogInfo);
                    }
                } catch (Throwable th5) {
                    TbsLog.e("SDKPVReport", "Post failed -- exceptions:" + th5.getMessage());
                    TbsLogReport.TbsLogInfo tbsLogInfo2 = TbsLogReport.getInstance(context).tbsLogInfo();
                    tbsLogInfo2.setErrorCode(126);
                    tbsLogInfo2.setFailDetail(th5);
                    TbsLogReport.getInstance(context).eventReport(TbsLogReport.EventType.TYPE_PV_UPLOAD_STAT, tbsLogInfo2);
                }
            } catch (Throwable unused2) {
            }
        } catch (IOException e17) {
            TbsLog.e("sdkreport", "Post failed -- IOException:" + e17);
        } catch (AssertionError e18) {
            TbsLog.e("sdkreport", "Post failed -- AssertionError:" + e18);
        } catch (Exception e19) {
            TbsLog.e("sdkreport", "Post failed -- Exception:" + e19);
        } catch (NoClassDefFoundError e26) {
            TbsLog.e("sdkreport", "Post failed -- NoClassDefFoundError:" + e26);
        }
    }

    private static JSONObject b(ThirdAppInfoNew thirdAppInfoNew, Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("APPNAME", thirdAppInfoNew.sAppName);
            jSONObject.put("TIME", thirdAppInfoNew.sTime);
            jSONObject.put("QUA2", thirdAppInfoNew.sQua2);
            jSONObject.put("LC", thirdAppInfoNew.sLc);
            jSONObject.put("GUID", thirdAppInfoNew.sGuid);
            jSONObject.put(Global.TRACKING_IMEI, thirdAppInfoNew.sImei);
            jSONObject.put("IMSI", thirdAppInfoNew.sImsi);
            jSONObject.put(Global.TRACKING_MAC, thirdAppInfoNew.sMac);
            jSONObject.put("PV", thirdAppInfoNew.iPv);
            jSONObject.put("CORETYPE", thirdAppInfoNew.iCoreType);
            jSONObject.put("APPVN", thirdAppInfoNew.sAppVersionName);
            jSONObject.put("APPMETADATA", thirdAppInfoNew.sMetaData);
            jSONObject.put("VERSION_CODE", thirdAppInfoNew.sVersionCode);
            jSONObject.put(PreDownloadConstants.RPORT_KEY_CPU, thirdAppInfoNew.sCpu);
            String str = thirdAppInfoNew.sAppSignature;
            if (str == null) {
                jSONObject.put("SIGNATURE", "0");
            } else {
                jSONObject.put("SIGNATURE", str);
            }
            String a16 = a(context);
            TbsLog.i("sdkreport", "addInfo is " + a16);
            if (!TextUtils.isEmpty(a16)) {
                jSONObject.put("EXT_INFO", a16);
            }
            jSONObject.put("PROTOCOL_VERSION", 3);
            jSONObject.put("ANDROID_ID", thirdAppInfoNew.sAndroidID);
            jSONObject.put("HOST_COREVERSION", 0);
            jSONObject.put("DECOUPLE_COREVERSION", 0);
            jSONObject.put("WIFICONNECTEDTIME", thirdAppInfoNew.sWifiConnectedTime);
            jSONObject.put("CORE_EXIST", thirdAppInfoNew.localCoreVersion);
            int loadErrorCode = TbsCoreLoadStat.getLoadErrorCode();
            if (thirdAppInfoNew.localCoreVersion <= 0) {
                jSONObject.put("TBS_ERROR_CODE", TbsDownloadConfig.getInstance(context).getDownloadInterruptCode());
            } else {
                jSONObject.put("TBS_ERROR_CODE", loadErrorCode);
            }
            if (loadErrorCode == -1) {
                TbsLog.e("sdkreport", "ATTENTION: Load errorCode missed!");
            }
            try {
                if (QbSdk.getTID() != null) {
                    if (thirdAppInfoNew.sAppName.equals("com.tencent.mobileqq")) {
                        jSONObject.put("TID", QbSdk.getTID());
                        jSONObject.put("TIDTYPE", 0);
                    } else if (thirdAppInfoNew.sAppName.equals("com.tencent.mm")) {
                        jSONObject.put("TID", QbSdk.getTID());
                        jSONObject.put("TIDTYPE", 0);
                    }
                }
            } catch (Exception unused) {
            }
            return jSONObject;
        } catch (Exception unused2) {
            TbsLog.e("sdkreport", "getPostData exception!");
            return null;
        }
    }

    private static int c(Context context) {
        Map<String, String> map = f369516c;
        if (map != null && map.size() != 0) {
            Map<String, String> pVCLocal = TbsPVConfig.getInstance(context).getPVCLocal();
            TbsLog.i("HttpUtils", "getCommandForUpdatePVC, mMapPVCLocal is " + pVCLocal.toString());
            if (pVCLocal.size() == 0 || !a(f369516c, pVCLocal)) {
                return 2;
            }
            return 0;
        }
        return 1;
    }

    private static void d(Context context) {
        SharedPreferences.Editor edit = TbsDownloadConfig.getInstance(context).mPreferences.edit();
        edit.putLong(TbsDownloadConfig.TbsConfigKey.KEY_LAST_CHECK, 0L);
        edit.apply();
    }

    private static String b(Context context) {
        try {
            byte[] byteArray = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 64).signatures[0].toByteArray();
            if (byteArray != null) {
                MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA1);
                messageDigest.update(byteArray);
                byte[] digest = messageDigest.digest();
                if (digest != null) {
                    StringBuilder sb5 = new StringBuilder("");
                    if (digest.length <= 0) {
                        return null;
                    }
                    for (int i3 = 0; i3 < digest.length; i3++) {
                        String upperCase = Integer.toHexString(digest[i3] & 255).toUpperCase();
                        if (i3 > 0) {
                            sb5.append(":");
                        }
                        if (upperCase.length() < 2) {
                            sb5.append(0);
                        }
                        sb5.append(upperCase);
                    }
                    return sb5.toString();
                }
            }
        } catch (Exception e16) {
            TbsLog.i(e16);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001e A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String a(Context context) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        try {
            jSONObject = new JSONObject();
        } catch (Throwable unused) {
        }
        try {
            jSONObject.put("cpuabi", AppUtil.is64BitImpl() ? IPreloadResource.ABI_64 : "32");
        } catch (Throwable unused2) {
            jSONObject2 = jSONObject;
            jSONObject = jSONObject2;
            if (jSONObject != null) {
            }
        }
        return jSONObject != null ? "" : jSONObject.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00c1 A[Catch: all -> 0x0148, TryCatch #0 {all -> 0x0148, blocks: (B:22:0x007a, B:24:0x00c1, B:25:0x00c3, B:27:0x00c7, B:28:0x00d2, B:30:0x00e6, B:32:0x00ec, B:34:0x00f0, B:36:0x00f6, B:37:0x00f8, B:39:0x00fe, B:41:0x0102, B:43:0x0108, B:44:0x010a, B:47:0x0117, B:49:0x011b, B:50:0x012c, B:52:0x0136, B:53:0x013e, B:56:0x011e, B:59:0x0124, B:62:0x012a, B:63:0x00cc), top: B:21:0x007a }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c7 A[Catch: all -> 0x0148, TryCatch #0 {all -> 0x0148, blocks: (B:22:0x007a, B:24:0x00c1, B:25:0x00c3, B:27:0x00c7, B:28:0x00d2, B:30:0x00e6, B:32:0x00ec, B:34:0x00f0, B:36:0x00f6, B:37:0x00f8, B:39:0x00fe, B:41:0x0102, B:43:0x0108, B:44:0x010a, B:47:0x0117, B:49:0x011b, B:50:0x012c, B:52:0x0136, B:53:0x013e, B:56:0x011e, B:59:0x0124, B:62:0x012a, B:63:0x00cc), top: B:21:0x007a }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00fe A[Catch: all -> 0x0148, TryCatch #0 {all -> 0x0148, blocks: (B:22:0x007a, B:24:0x00c1, B:25:0x00c3, B:27:0x00c7, B:28:0x00d2, B:30:0x00e6, B:32:0x00ec, B:34:0x00f0, B:36:0x00f6, B:37:0x00f8, B:39:0x00fe, B:41:0x0102, B:43:0x0108, B:44:0x010a, B:47:0x0117, B:49:0x011b, B:50:0x012c, B:52:0x0136, B:53:0x013e, B:56:0x011e, B:59:0x0124, B:62:0x012a, B:63:0x00cc), top: B:21:0x007a }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0136 A[Catch: all -> 0x0148, TryCatch #0 {all -> 0x0148, blocks: (B:22:0x007a, B:24:0x00c1, B:25:0x00c3, B:27:0x00c7, B:28:0x00d2, B:30:0x00e6, B:32:0x00ec, B:34:0x00f0, B:36:0x00f6, B:37:0x00f8, B:39:0x00fe, B:41:0x0102, B:43:0x0108, B:44:0x010a, B:47:0x0117, B:49:0x011b, B:50:0x012c, B:52:0x0136, B:53:0x013e, B:56:0x011e, B:59:0x0124, B:62:0x012a, B:63:0x00cc), top: B:21:0x007a }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00cc A[Catch: all -> 0x0148, TryCatch #0 {all -> 0x0148, blocks: (B:22:0x007a, B:24:0x00c1, B:25:0x00c3, B:27:0x00c7, B:28:0x00d2, B:30:0x00e6, B:32:0x00ec, B:34:0x00f0, B:36:0x00f6, B:37:0x00f8, B:39:0x00fe, B:41:0x0102, B:43:0x0108, B:44:0x010a, B:47:0x0117, B:49:0x011b, B:50:0x012c, B:52:0x0136, B:53:0x013e, B:56:0x011e, B:59:0x0124, B:62:0x012a, B:63:0x00cc), top: B:21:0x007a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context, String str, String str2, String str3, int i3, boolean z16, long j3, boolean z17) {
        String str4;
        ThirdAppInfoNew thirdAppInfoNew;
        String appMetadata;
        String macAddress;
        String sdkuid;
        String imsi;
        String androidID;
        if (QbSdk.getSettings() != null && QbSdk.getSettings().containsKey(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD) && QbSdk.getSettings().get(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")) {
            TbsLog.i("sdkreport", "[HttpUtils.doReport] -- SET_SENDREQUEST_AND_UPLOAD is false");
            return;
        }
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if ("com.tencent.mobileqq".equals(applicationInfo.packageName)) {
                str4 = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), applicationInfo.packageName, 0).versionName;
                try {
                    if (!TextUtils.isEmpty(QbSdk.getQQBuildNumber())) {
                        str4 = str4 + "." + QbSdk.getQQBuildNumber();
                    }
                } catch (Exception e16) {
                    e = e16;
                    TbsLog.i(e);
                    thirdAppInfoNew = new ThirdAppInfoNew();
                    thirdAppInfoNew.sAppName = context.getApplicationContext().getApplicationInfo().packageName;
                    p.a(context);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08"));
                    thirdAppInfoNew.sTime = simpleDateFormat.format(Calendar.getInstance().getTime());
                    thirdAppInfoNew.sVersionCode = AppUtil.getAppVersionCode(context);
                    appMetadata = AppUtil.getAppMetadata(context, TbsDownloader.TBS_METADATA);
                    if (!TextUtils.isEmpty(appMetadata)) {
                    }
                    thirdAppInfoNew.sGuid = str;
                    if (!z16) {
                    }
                    thirdAppInfoNew.sLc = str3;
                    macAddress = AppUtil.getMacAddress(context);
                    sdkuid = AppUtil.getSDKUID(context);
                    imsi = AppUtil.getImsi(context);
                    androidID = AppUtil.getAndroidID(context);
                    if (sdkuid != null) {
                        thirdAppInfoNew.sImei = sdkuid;
                    }
                    if (imsi != null) {
                        thirdAppInfoNew.sImsi = imsi;
                    }
                    if (!TextUtils.isEmpty(androidID)) {
                    }
                    if (macAddress != null) {
                        thirdAppInfoNew.sMac = macAddress;
                    }
                    thirdAppInfoNew.iPv = i3;
                    if (TbsShareManager.isThirdPartyApp(context)) {
                    }
                    thirdAppInfoNew.sAppVersionName = str4;
                    thirdAppInfoNew.sAppSignature = b(context);
                    if (!z16) {
                    }
                    f369515b = thirdAppInfoNew;
                    a(thirdAppInfoNew, context.getApplicationContext());
                }
            } else {
                str4 = "";
            }
        } catch (Exception e17) {
            e = e17;
            str4 = "";
        }
        try {
            thirdAppInfoNew = new ThirdAppInfoNew();
            thirdAppInfoNew.sAppName = context.getApplicationContext().getApplicationInfo().packageName;
            p.a(context);
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("GMT+08"));
            thirdAppInfoNew.sTime = simpleDateFormat2.format(Calendar.getInstance().getTime());
            thirdAppInfoNew.sVersionCode = AppUtil.getAppVersionCode(context);
            appMetadata = AppUtil.getAppMetadata(context, TbsDownloader.TBS_METADATA);
            if (!TextUtils.isEmpty(appMetadata)) {
                thirdAppInfoNew.sMetaData = appMetadata;
            }
            thirdAppInfoNew.sGuid = str;
            if (!z16) {
                thirdAppInfoNew.sQua2 = str2;
                thirdAppInfoNew.bIsSandboxMode = z17;
            } else {
                thirdAppInfoNew.sQua2 = m.a(context);
            }
            thirdAppInfoNew.sLc = str3;
            macAddress = AppUtil.getMacAddress(context);
            sdkuid = AppUtil.getSDKUID(context);
            imsi = AppUtil.getImsi(context);
            androidID = AppUtil.getAndroidID(context);
            if (sdkuid != null && !"".equals(sdkuid)) {
                thirdAppInfoNew.sImei = sdkuid;
            }
            if (imsi != null && !"".equals(imsi)) {
                thirdAppInfoNew.sImsi = imsi;
            }
            if (!TextUtils.isEmpty(androidID)) {
                thirdAppInfoNew.sAndroidID = androidID;
            }
            if (macAddress != null && !"".equals(macAddress)) {
                thirdAppInfoNew.sMac = macAddress;
            }
            thirdAppInfoNew.iPv = i3;
            if (TbsShareManager.isThirdPartyApp(context)) {
                thirdAppInfoNew.iCoreType = z16 ? 1 : 0;
                if (z16 && z17) {
                    thirdAppInfoNew.iCoreType = 3;
                }
            } else if (z16) {
                thirdAppInfoNew.iCoreType = 1;
                if (z17) {
                    thirdAppInfoNew.iCoreType = 3;
                }
            } else {
                thirdAppInfoNew.iCoreType = 0;
            }
            thirdAppInfoNew.sAppVersionName = str4;
            thirdAppInfoNew.sAppSignature = b(context);
            if (!z16) {
                thirdAppInfoNew.sWifiConnectedTime = j3;
                thirdAppInfoNew.localCoreVersion = QbSdk.getTbsVersion(context);
            }
            f369515b = thirdAppInfoNew;
            a(thirdAppInfoNew, context.getApplicationContext());
        } catch (Throwable th5) {
            TbsLog.i(th5);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:(15:(1:71)|9|10|11|12|13|(2:14|(1:16)(1:17))|18|(1:(1:33)(2:34|35))(1:20)|21|22|23|24|25|26)(1:7)|9|10|11|12|13|(3:14|(0)(0)|16)|18|(0)(0)|21|22|23|24|25|26) */
    /* JADX WARN: Can't wrap try/catch for region: R(20:1|2|3|(15:(1:71)|9|10|11|12|13|(2:14|(1:16)(1:17))|18|(1:(1:33)(2:34|35))(1:20)|21|22|23|24|25|26)(1:7)|8|9|10|11|12|13|(3:14|(0)(0)|16)|18|(0)(0)|21|22|23|24|25|26|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x008a, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008b, code lost:
    
        com.tencent.smtt.utils.TbsLog.i(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x009b, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x009c, code lost:
    
        r2 = r7;
        r7 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00a6, code lost:
    
        com.tencent.smtt.utils.TbsLog.i(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a9, code lost:
    
        if (r2 != null) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b3, code lost:
    
        if (r3 != null) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00b5, code lost:
    
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ab, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00af, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00b0, code lost:
    
        com.tencent.smtt.utils.TbsLog.i(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0097, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0098, code lost:
    
        r2 = r7;
        r7 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00d8, code lost:
    
        if (r2 != null) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00e2, code lost:
    
        if (r3 != null) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00e4, code lost:
    
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:?, code lost:
    
        throw r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00e8, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00e9, code lost:
    
        com.tencent.smtt.utils.TbsLog.i(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00ec, code lost:
    
        throw r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:?, code lost:
    
        throw r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00da, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00de, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00df, code lost:
    
        com.tencent.smtt.utils.TbsLog.i(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x009f, code lost:
    
        r7 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0048 A[Catch: all -> 0x0097, Exception -> 0x009b, LOOP:0: B:14:0x0041->B:16:0x0048, LOOP_END, TryCatch #10 {Exception -> 0x009b, all -> 0x0097, blocks: (B:13:0x003f, B:14:0x0041, B:16:0x0048, B:18:0x0062, B:33:0x006d, B:34:0x007c), top: B:12:0x003f }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0062 A[EDGE_INSN: B:17:0x0062->B:18:0x0062 BREAK  A[LOOP:0: B:14:0x0041->B:16:0x0048], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x0093 -> B:23:0x00b8). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String a(HttpURLConnection httpURLConnection, String str, boolean z16) {
        InputStream inputStream;
        String contentEncoding;
        InputStream inflaterInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr;
        int read;
        byte[] byteArray;
        String str2 = "";
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            try {
                inputStream = httpURLConnection.getInputStream();
                contentEncoding = httpURLConnection.getContentEncoding();
            } catch (Exception e16) {
                e = e16;
                inputStream = null;
            } catch (Throwable th5) {
                th = th5;
                inputStream = null;
            }
        } catch (IOException e17) {
            TbsLog.i(e17);
        }
        try {
            if (contentEncoding != null && contentEncoding.equalsIgnoreCase("gzip")) {
                inflaterInputStream = new GZIPInputStream(inputStream);
            } else {
                if (contentEncoding != null && contentEncoding.equalsIgnoreCase("deflate")) {
                    inflaterInputStream = new InflaterInputStream(inputStream, new Inflater(true));
                }
                byteArrayOutputStream = new ByteArrayOutputStream();
                bArr = new byte[128];
                while (true) {
                    read = inputStream.read(bArr);
                    if (read != -1) {
                        break;
                    }
                    TbsLog.i("HttpUtils", "getResponseFromConnection len is " + read);
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byteArray = byteArrayOutputStream.toByteArray();
                if (byteArray.length != 7) {
                    if (z16) {
                        str2 = new String(i.a().c(byteArray));
                    } else {
                        str2 = new String(i.b(byteArray, str));
                    }
                }
                byteArrayOutputStream.close();
                inputStream.close();
                TbsLog.i("HttpUtils", "getResponseFromConnection,response=" + str2 + ";isUseRSA=" + z16);
                return str2;
            }
            byteArrayOutputStream = new ByteArrayOutputStream();
            bArr = new byte[128];
            while (true) {
                read = inputStream.read(bArr);
                if (read != -1) {
                }
                TbsLog.i("HttpUtils", "getResponseFromConnection len is " + read);
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byteArray = byteArrayOutputStream.toByteArray();
            if (byteArray.length != 7) {
            }
            byteArrayOutputStream.close();
            inputStream.close();
            TbsLog.i("HttpUtils", "getResponseFromConnection,response=" + str2 + ";isUseRSA=" + z16);
            return str2;
        } catch (Throwable th6) {
            th = th6;
        }
        inputStream = inflaterInputStream;
    }

    private static void a(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                a(context, 1);
                return;
            }
            f369516c = new HashMap();
            for (String str2 : str.split("\\|")) {
                try {
                    String[] split = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                    if (split.length == 2) {
                        a(context, split[0], split[1]);
                    }
                } catch (Exception e16) {
                    TbsLog.i(e16);
                }
            }
            int c16 = c(context);
            TbsLog.i("HttpUtils", "readResponse, after processSwitchKeyValue mMapFromResponse is " + f369516c.toString() + " commandForUpdatePVC is " + c16);
            a(context, c16);
        } catch (Exception e17) {
            TbsLog.i(e17);
        }
    }

    private static boolean a(Map<String, String> map, Map<String, String> map2) {
        if (map.size() != map2.size()) {
            return false;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!(entry.getValue() == null ? "" : entry.getValue()).equals(map2.get(entry.getKey()) != null ? map2.get(entry.getKey()) : "")) {
                return false;
            }
        }
        return true;
    }

    private static void a(Context context, int i3) {
        TbsLog.i("HttpUtils", "updatePVConfig command is " + i3);
        if (i3 == 1) {
            TbsPVConfig.getInstance(context).clear();
        }
        if (i3 == 2) {
            TbsPVConfig.getInstance(context).update(f369516c);
        }
    }

    private static void a(Context context, String str, String str2) {
        TbsLog.i("HttpUtils", "PV Config Receive. Key: " + str + ", value: " + str2);
        if ("reset".equals(str) && "true".equals(str2)) {
            QbSdk.reset(context);
        } else if ("resetCfg24".equals(str) && "true".equals(str2)) {
            d(context);
        } else {
            f369516c.put(str, str2);
        }
    }
}
