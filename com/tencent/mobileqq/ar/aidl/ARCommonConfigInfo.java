package com.tencent.mobileqq.ar.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Xml;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.ARRecognition;
import com.tencent.mobileqq.ar.ARRelationShipAIOMsg;
import com.tencent.mobileqq.ar.ARScanAR;
import com.tencent.mobileqq.ar.i;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ARCommonConfigInfo implements Parcelable, Serializable {
    public static final Parcelable.Creator<ARCommonConfigInfo> CREATOR = new a();
    public static final long DEFAULT_AR_CLOUD_UPLOAD_CHECK_TIMEOUT = 5000;
    public static final long DEFAULT_AR_CLOUD_UPLOAD_DELAY = 2000;
    public static final long DEFAULT_AR_LOCAL_START_DELAY = 0;
    public static final long DEFAULT_NO_RESULT_CHECK_TIMEOUT = 8000;
    public static final int LBS_LOCATION_CLOSE = 0;
    public static final int LBS_LOCATION_OPEN = 1;
    public static final String TAG = "AREngine_ARCommonConfigInfo";
    public long aRCloudBegin;
    public long aRCloudCacheExpireTime;
    public long aRCloudEnd;
    public ArrayList<ARScanAR> arControllers;
    public long isEnableVideoRecord;
    public long mARCloudUploadCheckTime;
    public long mARCloudUploadDelayTime;
    public long mARLocalStartDelay;
    public long mARNoResultCheckTime;
    public ARRelationShipAIOMsg mARRelationShipAIOMsg;
    public ArrayList<NativeSoRes> nativeSoResList;
    public String osId;
    public ArrayList<ARRecognition> recognitions;
    public int switchLBSLocation;
    public int switchRecogOpen;
    public String versionId;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements Parcelable.Creator<ARCommonConfigInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ARCommonConfigInfo createFromParcel(Parcel parcel) {
            return new ARCommonConfigInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ARCommonConfigInfo[] newArray(int i3) {
            return new ARCommonConfigInfo[i3];
        }
    }

    public ARCommonConfigInfo() {
        this.aRCloudBegin = 0L;
        this.aRCloudEnd = 0L;
        this.aRCloudCacheExpireTime = 0L;
        this.isEnableVideoRecord = 1L;
        this.arControllers = new ArrayList<>();
        this.switchLBSLocation = 0;
        this.recognitions = new ArrayList<>();
        this.nativeSoResList = new ArrayList<>();
    }

    public static void deleteConfigFile(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "deleteConfigFile. dir = " + str + ", filename = " + str2);
        }
        if (str == null || str.equals("") || str2 == null || str2.equals("")) {
            return;
        }
        File file = new File(str, str2);
        if (file.exists()) {
            file.delete();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00cf  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x0090 -> B:26:0x00c9). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ARCommonConfigInfo loadConfigFromFile(String str, String str2) {
        FileInputStream fileInputStream;
        BufferedInputStream bufferedInputStream;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "loadConfigFromFile. dir = " + str + ", filename = " + str2);
        }
        ARCommonConfigInfo aRCommonConfigInfo = null;
        if (str != null && !str.equals("") && str2 != null && !str2.equals("")) {
            File file = new File(str, str2);
            try {
            } catch (IOException e16) {
                e16.printStackTrace();
            }
            if (file.exists()) {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        bufferedInputStream = new BufferedInputStream(fileInputStream);
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedInputStream = null;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    fileInputStream = null;
                    bufferedInputStream = null;
                }
                try {
                    byte[] bArr = new byte[fileInputStream.available()];
                    bufferedInputStream.read(bArr);
                    String str3 = new String(bArr, "UTF-8");
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "read content is:" + str3);
                    }
                    aRCommonConfigInfo = parseArConfig(str3);
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e17) {
                        e17.printStackTrace();
                    }
                    fileInputStream.close();
                } catch (Throwable th7) {
                    th = th7;
                    try {
                        file.delete();
                        if (QLog.isColorLevel()) {
                            QLog.e(TAG, 2, "ReadFileException:" + th);
                        }
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e18) {
                                e18.printStackTrace();
                            }
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (QLog.isColorLevel()) {
                        }
                        return aRCommonConfigInfo;
                    } finally {
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "loadConfigFromFile= " + aRCommonConfigInfo);
                }
            }
        }
        return aRCommonConfigInfo;
    }

    /* JADX WARN: Removed duplicated region for block: B:398:0x05c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ARCommonConfigInfo parseArConfig(String str) {
        int eventType;
        XmlPullParser newPullParser = Xml.newPullParser();
        ARCommonConfigInfo aRCommonConfigInfo = new ARCommonConfigInfo();
        int i3 = 2;
        try {
            newPullParser.setInput(new ByteArrayInputStream(str.getBytes()), "UTF-8");
            eventType = newPullParser.getEventType();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
            }
            return null;
        }
        while (eventType != 1) {
            if (eventType == i3) {
                String name = newPullParser.getName();
                if (name.equalsIgnoreCase("VersionID")) {
                    aRCommonConfigInfo.versionId = newPullParser.nextText();
                } else if (name.equalsIgnoreCase("OSId")) {
                    aRCommonConfigInfo.osId = newPullParser.nextText();
                } else {
                    if (name.equalsIgnoreCase("ARNoResultCheckTime")) {
                        try {
                            aRCommonConfigInfo.mARNoResultCheckTime = Long.valueOf(newPullParser.nextText()).longValue() * 1000;
                        } catch (Exception unused) {
                            aRCommonConfigInfo.mARNoResultCheckTime = 8000L;
                        }
                    } else if (name.equalsIgnoreCase("ARLocalStartDelay")) {
                        try {
                            aRCommonConfigInfo.mARLocalStartDelay = Long.valueOf(newPullParser.nextText()).longValue() * 1000;
                        } catch (Exception unused2) {
                            aRCommonConfigInfo.mARLocalStartDelay = 0L;
                        }
                    } else if (name.equalsIgnoreCase("ScanAR")) {
                        ARScanAR aRScanAR = new ARScanAR();
                        int next = newPullParser.next();
                        while (true) {
                            if (next == 1) {
                                break;
                            }
                            if (next == 2) {
                                String name2 = newPullParser.getName();
                                if (name2.equalsIgnoreCase("EntryType")) {
                                    aRScanAR.f197345d = Integer.valueOf(newPullParser.nextText()).intValue();
                                } else if (name2.equalsIgnoreCase("Begin")) {
                                    aRScanAR.f197346e = i.b(newPullParser.nextText());
                                } else if (name2.equalsIgnoreCase("End")) {
                                    aRScanAR.f197347f = i.b(newPullParser.nextText());
                                } else if (name2.equalsIgnoreCase("UserGuideBeginTime")) {
                                    aRScanAR.f197348h = i.b(newPullParser.nextText());
                                } else if (name2.equalsIgnoreCase("UserGuideEndTime")) {
                                    aRScanAR.f197349i = i.b(newPullParser.nextText());
                                } else if (name2.equalsIgnoreCase("ActType")) {
                                    aRScanAR.f197350m = Integer.valueOf(newPullParser.nextText()).intValue();
                                } else if (name2.equalsIgnoreCase("UserGuideShowCount")) {
                                    try {
                                        aRScanAR.C = Integer.valueOf(newPullParser.nextText()).intValue();
                                    } catch (Exception e17) {
                                        aRScanAR.C = 0;
                                        if (QLog.isColorLevel()) {
                                            QLog.e(TAG, 2, "UserGuideShowCount error", e17);
                                        }
                                    }
                                } else if (name2.equalsIgnoreCase("ScanIconImg")) {
                                    aRScanAR.D = newPullParser.nextText();
                                } else if (name2.equalsIgnoreCase("ScanIconMd5")) {
                                    aRScanAR.E = newPullParser.nextText();
                                } else if (name2.equalsIgnoreCase("ScanIconPressed")) {
                                    aRScanAR.F = newPullParser.nextText();
                                } else if (name2.equalsIgnoreCase("ScanIconPressedMd5")) {
                                    aRScanAR.G = newPullParser.nextText();
                                } else if (name2.equalsIgnoreCase("ScanIconText")) {
                                    aRScanAR.H = newPullParser.nextText();
                                } else if (name2.equalsIgnoreCase("Scan_Line1")) {
                                    aRScanAR.I = newPullParser.nextText();
                                } else if (name2.equalsIgnoreCase("Scan_Line2")) {
                                    aRScanAR.J = newPullParser.nextText();
                                } else if (name2.equalsIgnoreCase("Scan_Line3")) {
                                    aRScanAR.K = newPullParser.nextText();
                                } else if (name2.equalsIgnoreCase("Scan_Line3_URL")) {
                                    aRScanAR.L = newPullParser.nextText();
                                } else if (name2.equalsIgnoreCase("What2ScanURL")) {
                                    aRScanAR.M = newPullParser.nextText();
                                } else if (name2.equalsIgnoreCase("UserGuideWording")) {
                                    aRScanAR.N = newPullParser.nextText();
                                } else if (name2.equalsIgnoreCase("UserGuideType")) {
                                    aRScanAR.P = newPullParser.nextText();
                                }
                            } else if (next == 3 && newPullParser.getName().equalsIgnoreCase("ScanAR")) {
                                aRCommonConfigInfo.arControllers.add(aRScanAR);
                                break;
                            }
                            next = newPullParser.next();
                        }
                    } else if (name.equalsIgnoreCase("switchRecogOpen")) {
                        aRCommonConfigInfo.switchRecogOpen = Integer.valueOf(newPullParser.nextText()).intValue();
                    } else if (name.equalsIgnoreCase("switchLBSLocation")) {
                        aRCommonConfigInfo.switchLBSLocation = Integer.valueOf(newPullParser.nextText()).intValue();
                    } else if (name.equalsIgnoreCase("Recognition")) {
                        ARRecognition aRRecognition = new ARRecognition();
                        int next2 = newPullParser.next();
                        while (true) {
                            if (next2 == 1) {
                                break;
                            }
                            if (next2 == 2) {
                                String name3 = newPullParser.getName();
                                if (name3.equalsIgnoreCase("Type")) {
                                    aRRecognition.f196956d = Integer.valueOf(newPullParser.nextText()).intValue();
                                } else if (name3.equalsIgnoreCase("CloudRecogOpen")) {
                                    try {
                                        aRRecognition.f196957e = Integer.valueOf(newPullParser.nextText()).intValue();
                                    } catch (Exception e18) {
                                        e18.printStackTrace();
                                        aRRecognition.f196957e = 1;
                                    }
                                } else if (name3.equalsIgnoreCase("LocalRecogOpen")) {
                                    try {
                                        aRRecognition.f196958f = Integer.valueOf(newPullParser.nextText()).intValue();
                                    } catch (Exception e19) {
                                        e19.printStackTrace();
                                        aRRecognition.f196958f = 1;
                                    }
                                } else if (name3.equalsIgnoreCase("Priority")) {
                                    try {
                                        aRRecognition.f196959h = Integer.valueOf(newPullParser.nextText()).intValue();
                                    } catch (Exception e26) {
                                        e26.printStackTrace();
                                        aRRecognition.f196959h = 5;
                                    }
                                } else if (name3.equalsIgnoreCase("Wait_ms")) {
                                    try {
                                        aRRecognition.f196960i = Long.valueOf(newPullParser.nextText()).longValue();
                                    } catch (Exception e27) {
                                        e27.printStackTrace();
                                        aRRecognition.f196960i = 3000L;
                                    }
                                } else if (name3.equalsIgnoreCase("ImagePreprocess")) {
                                    for (int next3 = newPullParser.next(); next3 != 1; next3 = newPullParser.next()) {
                                        if (next3 == 2) {
                                            if (newPullParser.getName().equalsIgnoreCase("Open")) {
                                                aRRecognition.f196961m = Integer.valueOf(newPullParser.nextText()).intValue();
                                            }
                                        } else if (next3 == 3 && newPullParser.getName().equalsIgnoreCase("ImagePreprocess")) {
                                            break;
                                        }
                                    }
                                }
                            } else if (next2 == 3 && newPullParser.getName().equalsIgnoreCase("Recognition")) {
                                aRCommonConfigInfo.recognitions.add(aRRecognition);
                                break;
                            }
                            next2 = newPullParser.next();
                        }
                    } else if (name.equalsIgnoreCase("ARVideoRecordSwitch")) {
                        for (int next4 = newPullParser.next(); next4 != 1; next4 = newPullParser.next()) {
                            if (next4 == 2) {
                                if (newPullParser.getName().equalsIgnoreCase("Enable")) {
                                    aRCommonConfigInfo.isEnableVideoRecord = Long.valueOf(newPullParser.nextText()).longValue();
                                }
                            } else if (next4 == 3 && newPullParser.getName().equalsIgnoreCase("ARVideoRecordSwitch")) {
                                break;
                            }
                        }
                    } else if (name.equalsIgnoreCase("Cloud")) {
                        for (int next5 = newPullParser.next(); next5 != 1; next5 = newPullParser.next()) {
                            if (next5 == 2) {
                                String name4 = newPullParser.getName();
                                if (name4.equalsIgnoreCase("Begin")) {
                                    aRCommonConfigInfo.aRCloudBegin = i.b(newPullParser.nextText());
                                } else if (name4.equalsIgnoreCase("End")) {
                                    aRCommonConfigInfo.aRCloudEnd = i.b(newPullParser.nextText());
                                } else if (name4.equalsIgnoreCase("CacheExpireTime")) {
                                    try {
                                        aRCommonConfigInfo.aRCloudCacheExpireTime = Long.valueOf(newPullParser.nextText()).longValue();
                                    } catch (Exception unused3) {
                                        aRCommonConfigInfo.aRCloudCacheExpireTime = 1440L;
                                    }
                                } else if (name4.equalsIgnoreCase("ARCloudUploadCheckTime")) {
                                    try {
                                        aRCommonConfigInfo.mARCloudUploadCheckTime = Long.valueOf(newPullParser.nextText()).longValue() * 1000;
                                    } catch (Exception unused4) {
                                        aRCommonConfigInfo.mARCloudUploadCheckTime = 5000L;
                                    }
                                } else if (name4.equalsIgnoreCase("ARCloudUploadDelayTime")) {
                                    try {
                                        aRCommonConfigInfo.mARCloudUploadDelayTime = Long.valueOf(newPullParser.nextText()).longValue() * 1000;
                                    } catch (Exception unused5) {
                                        aRCommonConfigInfo.mARCloudUploadDelayTime = 2000L;
                                    }
                                }
                            } else if (next5 == 3 && newPullParser.getName().equalsIgnoreCase("Cloud")) {
                                break;
                            }
                        }
                    } else if (name.equalsIgnoreCase("NativeSoRes")) {
                        NativeSoRes nativeSoRes = new NativeSoRes();
                        int next6 = newPullParser.next();
                        while (true) {
                            if (next6 == 1) {
                                break;
                            }
                            if (next6 == 2) {
                                String name5 = newPullParser.getName();
                                if (name5.equalsIgnoreCase("Name")) {
                                    nativeSoRes.f197685d = newPullParser.nextText();
                                } else if (name5.equalsIgnoreCase("Version")) {
                                    nativeSoRes.f197686e = newPullParser.nextText();
                                } else if (name5.equalsIgnoreCase("Url")) {
                                    nativeSoRes.f197687f = newPullParser.nextText();
                                } else if (name5.equalsIgnoreCase("Md5")) {
                                    nativeSoRes.f197688h = newPullParser.nextText();
                                } else if (name5.equalsIgnoreCase("Size")) {
                                    try {
                                        nativeSoRes.f197689i = Long.valueOf(newPullParser.nextText()).longValue();
                                    } catch (Exception e28) {
                                        e28.printStackTrace();
                                        nativeSoRes.f197689i = 0L;
                                    }
                                }
                            } else if (next6 == 3 && newPullParser.getName().equalsIgnoreCase("NativeSoRes")) {
                                aRCommonConfigInfo.nativeSoResList.add(nativeSoRes);
                                break;
                            }
                            next6 = newPullParser.next();
                        }
                    } else if (name.equalsIgnoreCase("ARRelationShipAIOMsg")) {
                        ARRelationShipAIOMsg aRRelationShipAIOMsg = new ARRelationShipAIOMsg();
                        int next7 = newPullParser.next();
                        while (true) {
                            if (next7 == 1) {
                                break;
                            }
                            if (next7 == 2) {
                                String name6 = newPullParser.getName();
                                if ("AIOMsgSourceName".equalsIgnoreCase(name6)) {
                                    aRRelationShipAIOMsg.f197069d = newPullParser.nextText();
                                } else if ("AIOMsgSourceIconUrl".equalsIgnoreCase(name6)) {
                                    aRRelationShipAIOMsg.f197070e = newPullParser.nextText();
                                } else if ("AIOMsgSourceAction".equalsIgnoreCase(name6)) {
                                    aRRelationShipAIOMsg.f197071f = newPullParser.nextText();
                                } else if ("AIOMsgSourceActionData".equalsIgnoreCase(name6)) {
                                    aRRelationShipAIOMsg.f197072h = newPullParser.nextText();
                                } else if ("AIOMsgSourceUrl".equalsIgnoreCase(name6)) {
                                    aRRelationShipAIOMsg.f197073i = newPullParser.nextText();
                                }
                            } else if (next7 == 3 && "ARRelationShipAIOMsg".equalsIgnoreCase(newPullParser.getName())) {
                                aRCommonConfigInfo.mARRelationShipAIOMsg = aRRelationShipAIOMsg;
                                break;
                            }
                            next7 = newPullParser.next();
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.e(TAG, 2, str, e16);
                    }
                    return null;
                }
            }
            eventType = newPullParser.next();
            i3 = 2;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "parseConfig success|config=" + aRCommonConfigInfo);
            return aRCommonConfigInfo;
        }
        return aRCommonConfigInfo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00be A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00de A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r6v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean saveArConfigToFile(String str, String str2, String str3) {
        String str4;
        FileOutputStream fileOutputStream;
        BufferedOutputStream bufferedOutputStream;
        IOException e16;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "saveArConfigToFile. dir = " + str2 + ", filename = " + str3);
        }
        if (str == null || str2 == null || str2.equals("") || str3 == null || str3.equals("")) {
            return false;
        }
        File file = new File(str2, str3);
        ?? sb5 = new StringBuilder();
        sb5.append(str3);
        sb5.append(".tmp");
        String sb6 = sb5.toString();
        File file2 = new File(str2, sb6);
        byte[] bArr = new byte[0];
        try {
            sb6 = "UTF-8";
            bArr = str.getBytes("UTF-8");
            str4 = sb6;
        } catch (UnsupportedEncodingException e17) {
            e17.printStackTrace();
            str4 = sb6;
        }
        File parentFile = file.getParentFile();
        ?? r65 = str4;
        if (parentFile != null) {
            boolean exists = parentFile.exists();
            r65 = exists;
            if (!exists) {
                parentFile.mkdir();
                r65 = exists;
            }
        }
        if (file2.exists()) {
            file2.delete();
        }
        try {
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                } catch (IOException e18) {
                    e = e18;
                    bufferedOutputStream = null;
                    fileOutputStream = fileOutputStream;
                    e16 = e;
                    e16.printStackTrace();
                    if (bufferedOutputStream != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    sb5 = 0;
                    r65 = fileOutputStream;
                    th = th;
                    if (sb5 != 0) {
                    }
                    if (r65 == 0) {
                    }
                }
            } catch (IOException e19) {
                e = e19;
                fileOutputStream = null;
                bufferedOutputStream = null;
            } catch (Throwable th6) {
                th = th6;
                r65 = 0;
                sb5 = 0;
            }
            try {
                bufferedOutputStream.write(bArr);
                bufferedOutputStream.flush();
                boolean renameFile = FileUtils.renameFile(file2, file);
                try {
                    bufferedOutputStream.close();
                } catch (IOException e26) {
                    e26.printStackTrace();
                }
                try {
                    fileOutputStream.close();
                } catch (IOException e27) {
                    e27.printStackTrace();
                }
                return renameFile;
            } catch (IOException e28) {
                e16 = e28;
                e16.printStackTrace();
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e29) {
                        e29.printStackTrace();
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e36) {
                        e36.printStackTrace();
                    }
                }
                return false;
            }
        } catch (Throwable th7) {
            th = th7;
            if (sb5 != 0) {
                try {
                    sb5.close();
                } catch (IOException e37) {
                    e37.printStackTrace();
                }
            }
            if (r65 == 0) {
                try {
                    r65.close();
                    throw th;
                } catch (IOException e38) {
                    e38.printStackTrace();
                    throw th;
                }
            }
            throw th;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean isEnableARCloud() {
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        boolean z16 = false;
        if (this.aRCloudBegin <= serverTimeMillis && serverTimeMillis <= this.aRCloudEnd && this.recognitions != null) {
            int i3 = 0;
            while (true) {
                if (i3 >= this.recognitions.size()) {
                    break;
                }
                if (this.recognitions.get(i3).f196957e != 0) {
                    z16 = true;
                    break;
                }
                i3++;
            }
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss.SSS");
        QLog.i(TAG, 1, "isEnableARCloud = " + z16 + ", aRCloudBegin = " + this.aRCloudBegin + ", aRCloudEnd = " + this.aRCloudEnd + ", timeBeginStr = " + simpleDateFormat.format(new Date(this.aRCloudBegin)) + ", timeEndStr = " + simpleDateFormat.format(new Date(this.aRCloudEnd)));
        return z16;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("CommonConfigInfo{");
        stringBuffer.append("versionId='");
        stringBuffer.append(this.versionId);
        stringBuffer.append('\'');
        stringBuffer.append(", aRCloudBegin=");
        stringBuffer.append(this.aRCloudBegin);
        stringBuffer.append(", aRCloudCacheExpireTime=");
        stringBuffer.append(this.aRCloudCacheExpireTime);
        stringBuffer.append(", aRCloudEnd=");
        stringBuffer.append(this.aRCloudEnd);
        stringBuffer.append(", arControllers=");
        stringBuffer.append(this.arControllers);
        stringBuffer.append(", switchRecogOpen=");
        stringBuffer.append(this.switchRecogOpen);
        stringBuffer.append(", recognitions=");
        stringBuffer.append(this.recognitions);
        stringBuffer.append(", nativeSoResList = ");
        stringBuffer.append(this.nativeSoResList);
        stringBuffer.append(", mARNoResultCheckTime = ");
        stringBuffer.append(this.mARNoResultCheckTime);
        stringBuffer.append(", mARCloudUploadCheckTime = ");
        stringBuffer.append(this.mARCloudUploadCheckTime);
        stringBuffer.append(", mARCloudUploadDelayTime = ");
        stringBuffer.append(this.mARCloudUploadDelayTime);
        stringBuffer.append(", mARLocalStartDelay = ");
        stringBuffer.append(this.mARLocalStartDelay);
        stringBuffer.append(", isOpenVideoRecordSwitch = ");
        stringBuffer.append(this.isEnableVideoRecord);
        stringBuffer.append(", switchLBSLocation = ");
        stringBuffer.append(this.switchLBSLocation);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.versionId);
        parcel.writeString(this.osId);
        parcel.writeLong(this.aRCloudBegin);
        parcel.writeLong(this.aRCloudEnd);
        parcel.writeLong(this.aRCloudCacheExpireTime);
        parcel.writeList(this.arControllers);
        parcel.writeInt(this.switchRecogOpen);
        parcel.writeList(this.recognitions);
        parcel.writeList(this.nativeSoResList);
        parcel.writeLong(this.mARNoResultCheckTime);
        parcel.writeLong(this.mARCloudUploadCheckTime);
        parcel.writeLong(this.mARCloudUploadDelayTime);
        parcel.writeLong(this.mARLocalStartDelay);
        parcel.writeLong(this.isEnableVideoRecord);
        parcel.writeParcelable(this.mARRelationShipAIOMsg, i3);
        parcel.writeInt(this.switchLBSLocation);
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class NativeSoRes implements Parcelable {
        public static final Parcelable.Creator<NativeSoRes> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name */
        public String f197685d;

        /* renamed from: e, reason: collision with root package name */
        public String f197686e;

        /* renamed from: f, reason: collision with root package name */
        public String f197687f;

        /* renamed from: h, reason: collision with root package name */
        public String f197688h;

        /* renamed from: i, reason: collision with root package name */
        public long f197689i;

        /* compiled from: P */
        /* loaded from: classes11.dex */
        class a implements Parcelable.Creator<NativeSoRes> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public NativeSoRes createFromParcel(Parcel parcel) {
                return new NativeSoRes(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public NativeSoRes[] newArray(int i3) {
                return new NativeSoRes[i3];
            }
        }

        public NativeSoRes() {
            this.f197685d = "";
            this.f197686e = "";
            this.f197687f = "";
            this.f197688h = "";
            this.f197689i = 0L;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("NativeSoRes{");
            stringBuffer.append("name = '");
            stringBuffer.append(this.f197685d);
            stringBuffer.append('\'');
            stringBuffer.append(", version = '");
            stringBuffer.append(this.f197686e);
            stringBuffer.append('\'');
            stringBuffer.append(", url = '");
            stringBuffer.append(this.f197687f);
            stringBuffer.append('\'');
            stringBuffer.append(", md5 = '");
            stringBuffer.append(this.f197688h);
            stringBuffer.append('\'');
            stringBuffer.append(", size = ");
            stringBuffer.append(this.f197689i);
            stringBuffer.append('}');
            return stringBuffer.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.f197685d);
            parcel.writeString(this.f197686e);
            parcel.writeString(this.f197687f);
            parcel.writeString(this.f197688h);
            parcel.writeLong(this.f197689i);
        }

        public NativeSoRes(Parcel parcel) {
            this.f197685d = "";
            this.f197686e = "";
            this.f197687f = "";
            this.f197688h = "";
            this.f197689i = 0L;
            this.f197685d = parcel.readString();
            this.f197686e = parcel.readString();
            this.f197687f = parcel.readString();
            this.f197688h = parcel.readString();
            this.f197689i = parcel.readLong();
        }
    }

    public static void deleteConfigFile(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "deleteConfigFile. uin = " + str);
        }
        if (str == null) {
            return;
        }
        deleteConfigFile(BaseApplicationImpl.sApplication.getFilesDir().getPath(), "common_file_config" + str);
    }

    public ARCommonConfigInfo(Parcel parcel) {
        this.aRCloudBegin = 0L;
        this.aRCloudEnd = 0L;
        this.aRCloudCacheExpireTime = 0L;
        this.isEnableVideoRecord = 1L;
        this.arControllers = new ArrayList<>();
        this.switchLBSLocation = 0;
        this.recognitions = new ArrayList<>();
        this.nativeSoResList = new ArrayList<>();
        this.versionId = parcel.readString();
        this.osId = parcel.readString();
        this.aRCloudBegin = parcel.readLong();
        this.aRCloudEnd = parcel.readLong();
        this.aRCloudCacheExpireTime = parcel.readLong();
        try {
            ArrayList arrayList = new ArrayList();
            parcel.readList(arrayList, ARScanAR.class.getClassLoader());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ARScanAR aRScanAR = (ARScanAR) it.next();
                if (aRScanAR != null) {
                    this.arControllers.add(aRScanAR);
                }
            }
            this.switchRecogOpen = parcel.readInt();
            ArrayList arrayList2 = new ArrayList();
            parcel.readList(arrayList2, ARRecognition.class.getClassLoader());
            Iterator it5 = arrayList2.iterator();
            while (it5.hasNext()) {
                ARRecognition aRRecognition = (ARRecognition) it5.next();
                if (aRRecognition != null) {
                    this.recognitions.add(aRRecognition);
                }
            }
            ArrayList arrayList3 = new ArrayList();
            parcel.readList(arrayList3, NativeSoRes.class.getClassLoader());
            Iterator it6 = arrayList3.iterator();
            while (it6.hasNext()) {
                NativeSoRes nativeSoRes = (NativeSoRes) it6.next();
                if (nativeSoRes != null) {
                    this.nativeSoResList.add(nativeSoRes);
                }
            }
            this.mARNoResultCheckTime = parcel.readLong();
            this.mARCloudUploadCheckTime = parcel.readLong();
            this.mARCloudUploadDelayTime = parcel.readLong();
            this.mARLocalStartDelay = parcel.readLong();
            this.isEnableVideoRecord = parcel.readLong();
            this.mARRelationShipAIOMsg = (ARRelationShipAIOMsg) parcel.readParcelable(ARRelationShipAIOMsg.class.getClassLoader());
            this.switchLBSLocation = parcel.readInt();
        } catch (Error | Exception unused) {
        }
    }

    public static ARCommonConfigInfo loadConfigFromFile(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "loadConfigFromFile. uin = " + str);
        }
        if (str == null) {
            return null;
        }
        return loadConfigFromFile(BaseApplicationImpl.sApplication.getFilesDir().getPath(), "common_file_config" + str);
    }

    public static boolean saveArConfigToFile(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "saveArConfigToFile. uin = " + str2);
        }
        if (str2 == null) {
            return false;
        }
        return saveArConfigToFile(str, BaseApplicationImpl.sApplication.getFilesDir().getPath(), "common_file_config" + str2);
    }
}
