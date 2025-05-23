package com.tencent.qqlive.tvkplayer.vinfo.ckey;

import android.content.Context;
import android.content.pm.PackageManager;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.DeviceInfoUtil;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.LibLoadUtil;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.VsAppKeyBean;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.VsAppKeyUtil;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.VsAppKeyVerify;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.VsLog;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.VsReporter;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class CKeyFacade {
    private static final String KEYNAME = "tvkmedia.key";
    private static final String SONAME = "ckeygeneratorV2";
    private static final String TAG = "CKeyFacade|ckeygeneratorV2.so";
    static boolean bLoadSucc = false;
    private static CKeyBeaconReport cKeyBeaconReport = null;
    private static int flag_11 = 1;
    private static int flag_22 = 2;
    private static int flag_33 = 4;
    private static int flag_44 = 8;
    private static String mAppKey = "";
    private static String mBeaconID = "";
    private static String mBsGuid = "";
    private static Context mContext = null;
    private static String mExtInfo = "";
    private static String mGuid = "";
    private static int mHandler = 0;
    private static volatile CKeyFacade mInstance = null;
    public static String mJarVersion = "V3.0.015.5";
    private static String mOmgID = "";
    private static String mOpenID = "";
    private static String mPkgName = "";
    private static String mPlatform = "";
    private static String mSdtfrom = "";
    private static String mSoVersion = "";
    private static String mUin = "";
    private static String mVsKey = "";
    private static String mVuid = "";
    private boolean isInit = false;
    private boolean isMutiInit = false;

    CKeyFacade() {
    }

    private static String byteArrayToString(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            return new String(bArr, "UTF-8");
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    public static String ckBuildSignStr(Map<String, String> map) {
        StringBuilder sb5 = new StringBuilder();
        for (Map.Entry entry : new TreeMap(map).entrySet()) {
            if (sb5.length() != 0) {
                sb5.append(ContainerUtils.FIELD_DELIMITER);
            }
            sb5.append((String) entry.getKey());
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append((String) entry.getValue());
        }
        return sb5.toString();
    }

    public static String ckSign(int i3) {
        if (!bLoadSucc) {
            bLoadSucc = LibLoadUtil.loadso(mContext, "ckeygeneratorV2");
        }
        VsReporter.reportSign(mContext, mPlatform, mSdtfrom, mGuid, mBsGuid, mBeaconID, i3);
        return getencSS(i3);
    }

    public static String ckSignature(String str, long j3) {
        String[] split = str.split(ContainerUtils.FIELD_DELIMITER);
        HashMap hashMap = new HashMap();
        for (String str2 : split) {
            String[] split2 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
            if (split2.length != 2) {
                if (split2[0].length() > 0) {
                    hashMap.put(split2[0], "");
                }
            } else {
                hashMap.put(split2[0], split2[1]);
            }
        }
        return ckSignature_map(hashMap, j3);
    }

    public static String ckSignature_map(Map<String, String> map, long j3) {
        if (!bLoadSucc) {
            bLoadSucc = LibLoadUtil.loadso(mContext, "ckeygeneratorV2");
        }
        try {
            return new String(getSignature(ckBuildSignStr(map), j3));
        } catch (Throwable unused) {
            return "exception";
        }
    }

    public static String ckTaskEncrypt(String str, String str2, String str3, String str4, long j3, int i3, int i16, int i17, int i18, int i19, String str5) {
        if (!bLoadSucc) {
            bLoadSucc = LibLoadUtil.loadso(mContext, "ckeygeneratorV2");
        }
        VsReporter.reportTaskEncrypt(mContext, mPlatform, mSdtfrom, mGuid, mBsGuid, mBeaconID, str, str2, str3, str4, str5, i3, i16, i17, i18, i19);
        try {
            return taskEncrypt(str, str2, str3, str4, j3, i3, i16, i17, i18, i19, str5);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void ckeyMoudleInit(String str, String str2, String str3, Context context);

    private static native byte[] genCKey(long j3, int i3, String str, String str2, String str3, String str4, String str5, String str6, int[] iArr, int i16, String str7, String str8, String str9, String str10, byte[] bArr);

    public static String getAppVer(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:16|(3:17|18|(1:44))|22|(4:(8:27|28|29|30|31|32|33|34)|32|33|34)|43|28|29|30|31) */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x014d, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x014e, code lost:
    
        r20 = r15;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006d A[Catch: all -> 0x0153, TryCatch #0 {all -> 0x0153, blocks: (B:11:0x005f, B:13:0x006d, B:16:0x0076, B:18:0x00b7, B:20:0x00bb, B:22:0x00ca, B:24:0x00d0, B:28:0x00dc, B:44:0x00c1, B:46:0x00c8), top: B:10:0x005f, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0076 A[Catch: all -> 0x0153, TRY_LEAVE, TryCatch #0 {all -> 0x0153, blocks: (B:11:0x005f, B:13:0x006d, B:16:0x0076, B:18:0x00b7, B:20:0x00bb, B:22:0x00ca, B:24:0x00d0, B:28:0x00dc, B:44:0x00c1, B:46:0x00c8), top: B:10:0x005f, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getCKey(String str, long j3, String str2, String str3, String str4, String str5, int[] iArr, int i3, String str6) {
        String str7;
        String str8;
        VsAppKeyBean appKey;
        String str9;
        String str10;
        String str11 = "";
        if (!bLoadSucc) {
            bLoadSucc = LibLoadUtil.loadso(mContext, "ckeygeneratorV2");
        }
        StarTrailHelper.loadso(mContext);
        try {
            str7 = new Exception().getStackTrace()[1].getClassName();
            try {
                str8 = new Exception().getStackTrace()[1].getMethodName();
                VsLog.info(str7 + "  " + str8, new Object[0]);
            } catch (Throwable unused) {
                str8 = "catch";
                String str12 = str7;
                String str13 = str8;
                appKey = VsAppKeyUtil.getInstance().getAppKey(str4);
                if (appKey != null) {
                }
            }
        } catch (Throwable unused2) {
            str7 = "";
        }
        try {
            String str122 = str7;
            String str132 = str8;
            appKey = VsAppKeyUtil.getInstance().getAppKey(str4);
            if (appKey != null) {
                VsLog.error("init plz~~", new Object[0]);
                return "";
            }
            mBsGuid = str;
            String genGuard = CKeyGuard.genGuard(mContext);
            mGuid = "";
            byte[] stGetSign = StarTrailHelper.stGetSign(mContext, str, Thread.currentThread().getStackTrace()[2].getMethodName(), (j3 + "," + str2 + "," + mBeaconID).getBytes());
            try {
                String str14 = mBeaconID;
                if (str14 == null || str14.isEmpty()) {
                    mBeaconID = CKeyBeaconReport.getQIMEI();
                }
            } catch (Exception unused3) {
                mBeaconID = "0";
            }
            String qimei36 = DeviceInfoUtil.getQimei36();
            try {
                if (qimei36 != null && !qimei36.isEmpty()) {
                    str9 = qimei36;
                    String str15 = new String(genCKey(j3, Integer.parseInt(str4), str3, str2, getfd(str5), appKey.getVsKey(), str, mGuid, iArr, i3, str6, genGuard, str9, mBeaconID, stGetSign));
                    str10 = str15;
                    VsReporter.reportCKey(mContext, mPlatform, mSdtfrom, appKey.getVsKey(), mGuid, str, mBeaconID, 0, mPkgName, str4, str5, str2, j3, str15, str122 + "|" + str132, mExtInfo, genGuard);
                    return str10;
                }
                VsReporter.reportCKey(mContext, mPlatform, mSdtfrom, appKey.getVsKey(), mGuid, str, mBeaconID, 0, mPkgName, str4, str5, str2, j3, str15, str122 + "|" + str132, mExtInfo, genGuard);
                return str10;
            } catch (Throwable th5) {
                th = th5;
                str11 = str10;
                VsLog.error("getCKey: catch " + th.getMessage(), new Object[0]);
                return str11;
            }
            str9 = "0";
            String str152 = new String(genCKey(j3, Integer.parseInt(str4), str3, str2, getfd(str5), appKey.getVsKey(), str, mGuid, iArr, i3, str6, genGuard, str9, mBeaconID, stGetSign));
            str10 = str152;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private static native String getCKeyVersion();

    public static int getHandler() {
        return mHandler;
    }

    public static String getJarVersion() {
        return mJarVersion;
    }

    private static native byte[] getSignature(String str, long j3);

    public static String getSoVersion() {
        return mSoVersion;
    }

    public static String getVersion() {
        try {
            String cKeyVersion = getCKeyVersion();
            VsLog.info(TAG, "ver succ");
            return cKeyVersion;
        } catch (Throwable unused) {
            VsLog.info(TAG, "ver error");
            return "";
        }
    }

    private static native String getencSS(int i3);

    public static String getfd(String str) {
        try {
            if (str.length() <= 2) {
                return "null";
            }
            char[] charArray = str.substring(1).toCharArray();
            for (int i3 = 0; i3 < str.length() - 1; i3++) {
                charArray[i3] = (char) (charArray[i3] + '1' + i3 + i3);
            }
            return String.valueOf(charArray);
        } catch (Throwable unused) {
            return "null";
        }
    }

    public static String getmPlatform() {
        return mPlatform;
    }

    public static String getmSdtfrom() {
        return mSdtfrom;
    }

    public static synchronized CKeyFacade instance() {
        CKeyFacade cKeyFacade;
        synchronized (CKeyFacade.class) {
            if (mInstance == null) {
                mInstance = new CKeyFacade();
            }
            cKeyFacade = mInstance;
        }
        return cKeyFacade;
    }

    private static Boolean parseJson2IntA(String str, int[] iArr) {
        int i3;
        Boolean bool = Boolean.FALSE;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("extern1")) {
                iArr[0] = jSONObject.optInt("extern1", 0);
                i3 = flag_11 | 0;
                bool = Boolean.TRUE;
            } else {
                i3 = 0;
            }
            if (jSONObject.has("extern2")) {
                iArr[1] = jSONObject.optInt("extern2", 0);
                i3 |= flag_22;
                bool = Boolean.TRUE;
            }
            if (jSONObject.has("extern3")) {
                iArr[2] = jSONObject.optInt("extern3", 0);
                i3 |= flag_33;
                bool = Boolean.TRUE;
            }
            if (jSONObject.has("extern4")) {
                iArr[3] = jSONObject.optInt("extern4", 0);
                i3 |= flag_44;
                bool = Boolean.TRUE;
            }
            iArr[9] = i3;
            return bool;
        } catch (Exception unused) {
            return Boolean.FALSE;
        }
    }

    public static void setInterface(String str, String str2, BeaconInterface beaconInterface, ModuleUpdateInterface moduleUpdateInterface) {
        LibLoadUtil.setModuleLoadInterface(moduleUpdateInterface);
        cKeyBeaconReport = new CKeyBeaconReport(str, str2, beaconInterface);
    }

    public static void setSwitchReport(boolean z16) {
        CKeyBeaconReport.setSwitchReport(z16);
    }

    private static native String taskEncrypt(String str, String str2, String str3, String str4, long j3, int i3, int i16, int i17, int i18, int i19, String str5);

    public boolean addVsAppkey(Context context, String str) {
        boolean z16;
        if (VsAppKeyUtil.getInstance().getCount() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        VsAppKeyBean verifyVsAppKey = VsAppKeyVerify.getInstance().verifyVsAppKey(context, str);
        if (verifyVsAppKey == null) {
            return false;
        }
        if (z16) {
            return true;
        }
        initStartrail(verifyVsAppKey.getPlatform());
        return true;
    }

    public String getmExtInfo() {
        return mExtInfo;
    }

    public String getmOpenID() {
        return mOpenID;
    }

    public String getmUin() {
        return mUin;
    }

    public String getmVuid() {
        return mVuid;
    }

    public void init(Context context, String str, final String str2) {
        VsLog.info(TAG, "load ckeygeneratorV2.so init");
        if (!bLoadSucc) {
            bLoadSucc = LibLoadUtil.loadso(context, "ckeygeneratorV2");
        }
        StarTrailHelper.loadso(mContext);
        if (context == null) {
            return;
        }
        mContext = context.getApplicationContext();
        CKeyBeaconReport cKeyBeaconReport2 = cKeyBeaconReport;
        if (cKeyBeaconReport2 != null) {
            cKeyBeaconReport2.CKeyBeaconReportInit(context);
        }
        DeviceInfoUtil.updateQimei(mContext, CKeyBeaconReport.BeaconAppKey);
        final VsAppKeyBean verifyVsAppKey = VsAppKeyVerify.getInstance().verifyVsAppKey(mContext, str);
        if (verifyVsAppKey != null) {
            mPlatform = verifyVsAppKey.getPlatform();
            mPkgName = verifyVsAppKey.getPkgName();
            mSdtfrom = verifyVsAppKey.getSdtfrom();
            mVsKey = verifyVsAppKey.getVsKey();
        }
        if (!this.isInit && !this.isMutiInit) {
            CKeyGuard.guardInit(mContext);
            mSoVersion = getVersion();
            mBsGuid = str2;
            BaseThread baseThread = new BaseThread(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.vinfo.ckey.CKeyFacade.1
                @Override // java.lang.Runnable
                public void run() {
                    VsAppKeyBean vsAppKeyBean;
                    try {
                        if (CKeyFacade.mContext != null) {
                            CKeyFacade.ckeyMoudleInit(CKeyFacade.mBsGuid, CKeyFacade.mGuid, CKeyFacade.mVsKey, CKeyFacade.mContext);
                        }
                    } catch (Throwable th5) {
                        VsLog.error("ckeyMoudleInit failed!", new Object[0]);
                        th5.printStackTrace();
                        CKeyFacade.bLoadSucc = false;
                    }
                    try {
                        CKeyBeaconReport unused = CKeyFacade.cKeyBeaconReport;
                        String unused2 = CKeyFacade.mBeaconID = CKeyBeaconReport.getQIMEI();
                    } catch (Throwable th6) {
                        th6.printStackTrace();
                    }
                    String unused3 = CKeyFacade.mGuid = "";
                    Thread.currentThread().getStackTrace()[2].getMethodName();
                    VsReporter.reportInit(CKeyFacade.mContext, CKeyFacade.mPlatform, CKeyFacade.mSdtfrom, CKeyFacade.mVsKey, CKeyFacade.mGuid, str2, CKeyFacade.mBeaconID, 0, CKeyFacade.mPkgName);
                    DeviceInfoUtil.getQimei36();
                    if (CKeyFacade.mPlatform != null && !CKeyFacade.mPlatform.isEmpty() && (vsAppKeyBean = verifyVsAppKey) != null) {
                        CKeyFacade.this.initStartrail(vsAppKeyBean.getPlatform());
                    }
                }
            });
            baseThread.setName("TVK_guidthread");
            baseThread.start();
            this.isInit = true;
        }
    }

    public void initStartrail(String str) {
        String str2 = "dl_" + str;
        try {
            mBeaconID = CKeyBeaconReport.getQIMEI();
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        mGuid = "";
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        DeviceInfoUtil.getQimei36();
        Context context = mContext;
        mHandler = StarTrailHelper.stInitUp(context, str2, mBeaconID, mBsGuid, methodName, getAppVer(context));
    }

    public void setInfo(String str, String str2, String str3, String str4) {
        mUin = str;
        mOpenID = str2;
        mVuid = str3;
        mExtInfo = str4;
    }

    public static String getfd(byte[] bArr) {
        try {
            String byteArrayToString = byteArrayToString(bArr);
            StringBuilder sb5 = new StringBuilder("");
            if (byteArrayToString.length() <= 2) {
                return "ffff";
            }
            char[] charArray = byteArrayToString.substring(1).toCharArray();
            for (int i3 = 0; i3 < byteArrayToString.length() - 1; i3++) {
                sb5.append((char) (charArray[i3] + '1' + i3 + i3));
            }
            return sb5.toString();
        } catch (Throwable unused) {
            return "ffff";
        }
    }

    public static String getCKey(String str, long j3, String str2, String str3, String str4, String str5, String str6, String str7) {
        if (!bLoadSucc) {
            bLoadSucc = LibLoadUtil.loadso(mContext, "ckeygeneratorV2");
        }
        try {
            String[] split = str6.split(",");
            int length = split.length;
            int[] iArr = new int[length];
            for (int i3 = 0; i3 < length; i3++) {
                if (split[i3].length() == 0) {
                    iArr[i3] = -1;
                } else {
                    iArr[i3] = Integer.parseInt(split[i3]);
                }
            }
            return getCKey(str, j3, str2, str3, str4, str5, iArr, length, str7);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getCKey(int i3, long j3, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6) {
        if (!bLoadSucc) {
            bLoadSucc = LibLoadUtil.loadso(mContext, "ckeygeneratorV2");
        }
        return getCKey(byteArrayToString(bArr5), j3, byteArrayToString(bArr), byteArrayToString(bArr2), byteArrayToString(bArr3), byteArrayToString(bArr4), byteArrayToString(bArr6), "");
    }
}
