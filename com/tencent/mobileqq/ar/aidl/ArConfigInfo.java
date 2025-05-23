package com.tencent.mobileqq.ar.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Xml;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.ar.i;
import com.tencent.mobileqq.ar.model.ArAwardInfo;
import com.tencent.mobileqq.ar.model.ArFeatureInfo;
import com.tencent.mobileqq.ar.model.ArModelResource;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.mobileqq.ar.model.ArWebInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArConfigInfo implements Parcelable, Serializable {
    public static final Parcelable.Creator<ArConfigInfo> CREATOR = new a();
    public static final String TAG = "ArConfigInfo";
    public static final int VERSION_700 = 10;
    public static final int VERSION_710 = 11;
    public static final int VERSION_715 = 12;
    public static final int VERSION_718 = 13;
    public static final int VERSION_720 = 14;
    public static final int VERSION_739 = 19;
    public static final int VERSION_760 = 20;
    public long aRBegin;
    public long aRCloudBegin;
    public long aRCloudCacheExpireTime;
    public long aRCloudEnd;
    public long aREnd;
    public ArrayList<ArCloudConfigInfo> mArCloudConfigInfos;
    public boolean saveConfig;
    public String scanLine1;
    public String scanLine2;
    public String scanLineLink;
    public String scanLinkUrl;
    public int version;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements Parcelable.Creator<ArConfigInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArConfigInfo createFromParcel(Parcel parcel) {
            return new ArConfigInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ArConfigInfo[] newArray(int i3) {
            return new ArConfigInfo[i3];
        }
    }

    public ArConfigInfo() {
        this.mArCloudConfigInfos = new ArrayList<>();
        this.aRCloudBegin = 0L;
        this.aRCloudEnd = 0L;
        this.aRCloudCacheExpireTime = 0L;
        this.saveConfig = true;
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

    /* JADX WARN: Removed duplicated region for block: B:42:0x0101  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArConfigInfo loadConfigFromFile(String str, String str2) {
        FileInputStream fileInputStream;
        BufferedInputStream bufferedInputStream;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "loadConfigFromFile. dir = " + str + ", filename = " + str2);
        }
        ArConfigInfo arConfigInfo = null;
        if (str != null && !str.equals("") && str2 != null && !str2.equals("")) {
            File file = new File(str, str2);
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
                    int available = fileInputStream.available();
                    byte[] bArr = new byte[available];
                    bufferedInputStream.read(bArr);
                    Parcel obtain = Parcel.obtain();
                    obtain.unmarshall(bArr, 0, available);
                    obtain.setDataPosition(0);
                    ArConfigInfo createFromParcel = CREATOR.createFromParcel(obtain);
                    try {
                        new ArrayList();
                        ArrayList<ArCloudConfigInfo> arrayList = createFromParcel.mArCloudConfigInfos;
                        Iterator<ArCloudConfigInfo> it = arrayList.iterator();
                        while (it.hasNext()) {
                            ArCloudConfigInfo next = it.next();
                            if (!next.K) {
                                arrayList.remove(next);
                            }
                        }
                        createFromParcel.mArCloudConfigInfos = arrayList;
                    } catch (Exception e16) {
                        QLog.i(TAG, 1, "createFromParcel:" + e16.getMessage());
                    }
                    OaidMonitor.parcelRecycle(obtain);
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e17) {
                        e17.printStackTrace();
                    }
                    try {
                        fileInputStream.close();
                    } catch (IOException e18) {
                        e18.printStackTrace();
                    }
                    arConfigInfo = createFromParcel;
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
                            } catch (IOException e19) {
                                e19.printStackTrace();
                            }
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e26) {
                                e26.printStackTrace();
                            }
                        }
                        if (QLog.isColorLevel()) {
                        }
                        return arConfigInfo;
                    } finally {
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "loadConfigFromFile= " + arConfigInfo);
                }
            }
        }
        return arConfigInfo;
    }

    public static ArConfigInfo parseArConfig(String str) {
        String str2;
        int eventType;
        String str3;
        boolean z16;
        int i3;
        boolean z17;
        boolean z18;
        String str4 = TAG;
        QLog.i(TAG, 1, "parseArConfig. xmlConfigContent:" + str);
        XmlPullParser newPullParser = Xml.newPullParser();
        ArConfigInfo arConfigInfo = new ArConfigInfo();
        try {
            newPullParser.setInput(new ByteArrayInputStream(str.getBytes()), "UTF-8");
            eventType = newPullParser.getEventType();
        } catch (Exception e16) {
            e = e16;
            str2 = str4;
        }
        for (int i16 = 1; eventType != i16; i16 = 1) {
            if (eventType != 2) {
                str3 = str4;
            } else {
                String name = newPullParser.getName();
                str3 = str4;
                if (name.equalsIgnoreCase("ScanAR")) {
                    try {
                        for (int next = newPullParser.next(); next != 1; next = newPullParser.next()) {
                            if (next == 2) {
                                String name2 = newPullParser.getName();
                                if (name2.equalsIgnoreCase("Begin")) {
                                    arConfigInfo.aRBegin = i.b(newPullParser.nextText());
                                } else if (name2.equalsIgnoreCase("End")) {
                                    arConfigInfo.aREnd = i.b(newPullParser.nextText());
                                } else if (name2.equalsIgnoreCase("Scan_Line1")) {
                                    arConfigInfo.scanLine1 = newPullParser.nextText();
                                } else if (name2.equalsIgnoreCase("Scan_Line2")) {
                                    arConfigInfo.scanLine2 = newPullParser.nextText();
                                } else if (name2.equalsIgnoreCase("Scan_Line3")) {
                                    arConfigInfo.scanLineLink = newPullParser.nextText();
                                } else if (name2.equalsIgnoreCase("Scan_Line3_URL")) {
                                    arConfigInfo.scanLinkUrl = newPullParser.nextText();
                                }
                            } else if (next == 3 && newPullParser.getName().equalsIgnoreCase("ScanAR")) {
                                break;
                            }
                        }
                    } catch (Exception e17) {
                        e = e17;
                        str2 = str3;
                    }
                } else if (name.equalsIgnoreCase("Task")) {
                    ArCloudConfigInfo arCloudConfigInfo = new ArCloudConfigInfo();
                    int next2 = newPullParser.next();
                    int i17 = 0;
                    boolean z19 = false;
                    while (true) {
                        if (next2 == 1) {
                            break;
                        }
                        if (next2 == 2) {
                            String name3 = newPullParser.getName();
                            if (name3.equalsIgnoreCase("BusinessId")) {
                                try {
                                    arCloudConfigInfo.f197698d = Integer.parseInt(newPullParser.nextText());
                                } catch (NumberFormatException unused) {
                                    arCloudConfigInfo.f197698d = i17;
                                }
                                z16 = z19;
                                i3 = i17;
                            } else if (name3.equalsIgnoreCase("LotterySet")) {
                                try {
                                    arCloudConfigInfo.C = Integer.parseInt(newPullParser.nextText());
                                } catch (NumberFormatException unused2) {
                                    arCloudConfigInfo.C = i17;
                                }
                                z16 = z19;
                                i3 = i17;
                            } else {
                                if (name3.equalsIgnoreCase("PicId")) {
                                    arCloudConfigInfo.f197703m = newPullParser.nextText();
                                } else if (name3.equalsIgnoreCase("SDKVersion")) {
                                    arCloudConfigInfo.f197699e = newPullParser.nextText();
                                } else if (name3.equalsIgnoreCase("TrackMode")) {
                                    try {
                                        arCloudConfigInfo.f197701h = Integer.parseInt(newPullParser.nextText());
                                    } catch (NumberFormatException unused3) {
                                        arCloudConfigInfo.f197701h = i17;
                                    }
                                } else if (name3.equalsIgnoreCase("Type")) {
                                    try {
                                        arCloudConfigInfo.f197702i = Integer.parseInt(newPullParser.nextText());
                                    } catch (NumberFormatException unused4) {
                                        arCloudConfigInfo.f197702i = i17;
                                    }
                                } else {
                                    z16 = z19;
                                    if (name3.equalsIgnoreCase("Feature")) {
                                        ArFeatureInfo arFeatureInfo = new ArFeatureInfo();
                                        int next3 = newPullParser.next();
                                        while (true) {
                                            if (next3 == 1) {
                                                break;
                                            }
                                            if (next3 == 2) {
                                                String name4 = newPullParser.getName();
                                                if (name4.equalsIgnoreCase("FeatureMD5")) {
                                                    arFeatureInfo.f198409d = newPullParser.nextText();
                                                } else if (name4.equalsIgnoreCase("FeatureSize")) {
                                                    try {
                                                        arFeatureInfo.f198410e = Long.parseLong(newPullParser.nextText());
                                                    } catch (NumberFormatException unused5) {
                                                        arFeatureInfo.f198410e = 0L;
                                                    }
                                                } else if (name4.equalsIgnoreCase("FeatureUrl")) {
                                                    arFeatureInfo.f198411f = newPullParser.nextText();
                                                }
                                                z16 = true;
                                            } else if (next3 == 3 && newPullParser.getName().equalsIgnoreCase("Feature")) {
                                                arCloudConfigInfo.E = arFeatureInfo;
                                                break;
                                            }
                                            next3 = newPullParser.next();
                                        }
                                        i3 = 0;
                                    } else if (name3.equalsIgnoreCase(GdtLog.WEB_TAG)) {
                                        ArWebInfo arWebInfo = new ArWebInfo();
                                        int next4 = newPullParser.next();
                                        while (true) {
                                            if (next4 == 1) {
                                                break;
                                            }
                                            if (next4 == 2) {
                                                String name5 = newPullParser.getName();
                                                if (name5.equalsIgnoreCase("IsUrlTransparent")) {
                                                    try {
                                                        if (Integer.parseInt(newPullParser.nextText()) == 1) {
                                                            z17 = true;
                                                        } else {
                                                            z17 = false;
                                                        }
                                                        arWebInfo.f198433e = z17;
                                                    } catch (NumberFormatException unused6) {
                                                        arWebInfo.f198433e = false;
                                                    }
                                                } else if (name5.equalsIgnoreCase("IsUrlAutoJump")) {
                                                    try {
                                                        if (Integer.parseInt(newPullParser.nextText()) == 1) {
                                                            z18 = true;
                                                        } else {
                                                            z18 = false;
                                                        }
                                                        arWebInfo.f198432d = z18;
                                                    } catch (NumberFormatException unused7) {
                                                        arWebInfo.f198432d = false;
                                                    }
                                                } else if (name5.equalsIgnoreCase("WebJumpUrl")) {
                                                    arWebInfo.f198434f = newPullParser.nextText();
                                                }
                                            } else if (next4 == 3 && newPullParser.getName().equalsIgnoreCase(GdtLog.WEB_TAG)) {
                                                arCloudConfigInfo.H = arWebInfo;
                                                break;
                                            }
                                            next4 = newPullParser.next();
                                        }
                                        i3 = 0;
                                    } else if (name3.equalsIgnoreCase("ModelResource")) {
                                        ArModelResource arModelResource = new ArModelResource();
                                        int next5 = newPullParser.next();
                                        while (true) {
                                            if (next5 == 1) {
                                                break;
                                            }
                                            if (next5 == 2) {
                                                String name6 = newPullParser.getName();
                                                if (name6.equalsIgnoreCase("ModelResourceSize")) {
                                                    try {
                                                        arModelResource.f198420d = Integer.parseInt(newPullParser.nextText());
                                                    } catch (NumberFormatException unused8) {
                                                        arModelResource.f198420d = 0L;
                                                    }
                                                } else if (name6.equalsIgnoreCase("ModelRepeatTimes")) {
                                                    try {
                                                        arModelResource.f198425m = Integer.parseInt(newPullParser.nextText());
                                                    } catch (NumberFormatException unused9) {
                                                        arModelResource.f198425m = 0;
                                                    }
                                                } else if (name6.equalsIgnoreCase("ModelResourceMD5")) {
                                                    arModelResource.f198421e = newPullParser.nextText();
                                                } else if (name6.equalsIgnoreCase("ModelResourceUrl")) {
                                                    arModelResource.f198422f = newPullParser.nextText();
                                                } else if (name6.equalsIgnoreCase("ModelResourceBgMusic")) {
                                                    arModelResource.f198423h = newPullParser.nextText();
                                                } else if (name6.equalsIgnoreCase("ModelConfigFile")) {
                                                    arModelResource.f198424i = newPullParser.nextText();
                                                }
                                            } else if (next5 == 3 && newPullParser.getName().equalsIgnoreCase("ModelResource")) {
                                                arCloudConfigInfo.F = arModelResource;
                                                break;
                                            }
                                            next5 = newPullParser.next();
                                        }
                                        i3 = 0;
                                    } else if (name3.equalsIgnoreCase("Award")) {
                                        ArAwardInfo arAwardInfo = new ArAwardInfo();
                                        int next6 = newPullParser.next();
                                        while (true) {
                                            if (next6 == 1) {
                                                break;
                                            }
                                            if (next6 == 2) {
                                                String name7 = newPullParser.getName();
                                                if (name7.equalsIgnoreCase("AwardDistance")) {
                                                    try {
                                                        arAwardInfo.f198399d = Integer.parseInt(newPullParser.nextText());
                                                    } catch (NumberFormatException unused10) {
                                                        arAwardInfo.f198399d = 0;
                                                    }
                                                } else if (name7.equalsIgnoreCase("NotPlayModel")) {
                                                    if (Integer.parseInt(newPullParser.nextText()) == 1) {
                                                        arAwardInfo.f198404m = 0;
                                                    } else {
                                                        arAwardInfo.f198404m = 1;
                                                    }
                                                } else if (name7.equalsIgnoreCase("BusinessBanner")) {
                                                    arAwardInfo.f198400e = newPullParser.nextText();
                                                } else if (name7.equalsIgnoreCase("BusinessLogo")) {
                                                    arAwardInfo.f198401f = newPullParser.nextText();
                                                } else if (name7.equalsIgnoreCase("BusinessName")) {
                                                    arAwardInfo.f198402h = newPullParser.nextText();
                                                } else if (name7.equalsIgnoreCase("BusinessWishing")) {
                                                    arAwardInfo.f198403i = newPullParser.nextText();
                                                }
                                            } else if (next6 == 3 && newPullParser.getName().equalsIgnoreCase("Award")) {
                                                arCloudConfigInfo.G = arAwardInfo;
                                                break;
                                            }
                                            next6 = newPullParser.next();
                                        }
                                        i3 = 0;
                                    } else {
                                        if (name3.equalsIgnoreCase("VideoResource")) {
                                            ArVideoResourceInfo arVideoResourceInfo = new ArVideoResourceInfo();
                                            for (int next7 = newPullParser.next(); next7 != 1; next7 = newPullParser.next()) {
                                                if (next7 == 2) {
                                                    String name8 = newPullParser.getName();
                                                    if (name8.equalsIgnoreCase("VideoConnectType")) {
                                                        try {
                                                            arVideoResourceInfo.f198426d = Integer.parseInt(newPullParser.nextText());
                                                        } catch (NumberFormatException unused11) {
                                                            arVideoResourceInfo.f198426d = 0;
                                                        }
                                                    } else if (name8.equalsIgnoreCase("VideoTrackMode")) {
                                                        try {
                                                            arVideoResourceInfo.C = Integer.parseInt(newPullParser.nextText());
                                                        } catch (NumberFormatException unused12) {
                                                            arVideoResourceInfo.C = 0;
                                                        }
                                                    } else if (name8.equalsIgnoreCase("VideoKeyingConfig")) {
                                                        arVideoResourceInfo.f198428f = newPullParser.nextText();
                                                    } else if (name8.equalsIgnoreCase("VideoLayout")) {
                                                        arVideoResourceInfo.f198429h = newPullParser.nextText();
                                                    } else if (name8.equalsIgnoreCase("VideoMD5")) {
                                                        arVideoResourceInfo.f198430i = newPullParser.nextText();
                                                    } else if (name8.equalsIgnoreCase("VideoUrl")) {
                                                        arVideoResourceInfo.E = newPullParser.nextText();
                                                    } else if (name8.equalsIgnoreCase("VideoRepeatTimes")) {
                                                        try {
                                                            arVideoResourceInfo.f198431m = Integer.parseInt(newPullParser.nextText());
                                                        } catch (NumberFormatException unused13) {
                                                            arVideoResourceInfo.f198431m = 0;
                                                        }
                                                    } else if (name8.equalsIgnoreCase("VideoType")) {
                                                        try {
                                                            arVideoResourceInfo.D = Integer.parseInt(newPullParser.nextText());
                                                        } catch (NumberFormatException unused14) {
                                                            arVideoResourceInfo.D = 0;
                                                        }
                                                    } else if (name8.equalsIgnoreCase("VideoSize")) {
                                                        try {
                                                            arVideoResourceInfo.f198427e = Long.parseLong(newPullParser.nextText());
                                                        } catch (NumberFormatException unused15) {
                                                            arVideoResourceInfo.f198427e = 0L;
                                                        }
                                                    } else if (name8.equalsIgnoreCase("VideoTrackMode")) {
                                                        try {
                                                            arVideoResourceInfo.C = Integer.parseInt(newPullParser.nextText());
                                                        } catch (NumberFormatException unused16) {
                                                            arVideoResourceInfo.C = 0;
                                                        }
                                                    }
                                                } else {
                                                    i3 = 0;
                                                    if (next7 == 3 && newPullParser.getName().equalsIgnoreCase("VideoResource")) {
                                                        arCloudConfigInfo.D.add(arVideoResourceInfo);
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                        i3 = 0;
                                    }
                                }
                                z16 = z19;
                                i3 = i17;
                            }
                            e = e17;
                            str2 = str3;
                            if (QLog.isColorLevel()) {
                                QLog.e(str2, 2, str, e);
                            }
                            return null;
                        }
                        z16 = z19;
                        i3 = i17;
                        if (next2 == 3 && newPullParser.getName().equalsIgnoreCase("Task")) {
                            if (z16) {
                                arConfigInfo.mArCloudConfigInfos.add(arCloudConfigInfo);
                            }
                        }
                        next2 = newPullParser.next();
                        i17 = i3;
                        z19 = z16;
                    }
                } else if (name.equalsIgnoreCase("Cloud")) {
                    for (int next8 = newPullParser.next(); next8 != 1; next8 = newPullParser.next()) {
                        if (next8 == 2) {
                            String name9 = newPullParser.getName();
                            if (name9.equalsIgnoreCase("Begin")) {
                                arConfigInfo.aRCloudBegin = i.b(newPullParser.nextText());
                            } else if (name9.equalsIgnoreCase("End")) {
                                arConfigInfo.aRCloudEnd = i.b(newPullParser.nextText());
                            } else if (name9.equalsIgnoreCase("CacheExpireTime")) {
                                try {
                                    arConfigInfo.aRCloudCacheExpireTime = Long.valueOf(newPullParser.nextText()).longValue();
                                } catch (Exception unused17) {
                                    arConfigInfo.aRCloudCacheExpireTime = 1440L;
                                }
                            }
                        } else if (next8 == 3 && newPullParser.getName().equalsIgnoreCase("Cloud")) {
                            break;
                        }
                    }
                }
            }
            eventType = newPullParser.next();
            str4 = str3;
        }
        str3 = str4;
        if (QLog.isColorLevel()) {
            str2 = str3;
            try {
                QLog.d(str2, 2, "parseConfig success|config=" + arConfigInfo);
                return arConfigInfo;
            } catch (Exception e18) {
                e = e18;
            }
        } else {
            return arConfigInfo;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.io.OutputStream, java.io.FileOutputStream] */
    public static boolean saveArConfigToFile(ArConfigInfo arConfigInfo, String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "saveArConfigToFile. dir = " + str + ", filename = " + str2);
        }
        if (arConfigInfo == null || str == null || str.equals("") || str2 == null || str2.equals("")) {
            return false;
        }
        File file = new File(str, str2);
        File file2 = new File(str, str2 + ".tmp");
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        arConfigInfo.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        File parentFile = file.getParentFile();
        ?? exists = parentFile.exists();
        if (exists == 0) {
            parentFile.mkdir();
        }
        if (file2.exists()) {
            file2.delete();
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                exists = new FileOutputStream(file2);
                try {
                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(exists);
                    try {
                        bufferedOutputStream2.write(marshall);
                        bufferedOutputStream2.flush();
                        boolean renameFile = FileUtils.renameFile(file2, file);
                        OaidMonitor.parcelRecycle(obtain);
                        try {
                            bufferedOutputStream2.close();
                        } catch (IOException e16) {
                            e16.printStackTrace();
                        }
                        try {
                            exists.close();
                        } catch (IOException e17) {
                            e17.printStackTrace();
                        }
                        return renameFile;
                    } catch (IOException e18) {
                        e = e18;
                        bufferedOutputStream = bufferedOutputStream2;
                        e.printStackTrace();
                        OaidMonitor.parcelRecycle(obtain);
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException e19) {
                                e19.printStackTrace();
                            }
                        }
                        if (exists != 0) {
                            try {
                                exists.close();
                            } catch (IOException e26) {
                                e26.printStackTrace();
                            }
                        }
                        return false;
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedOutputStream = bufferedOutputStream2;
                        OaidMonitor.parcelRecycle(obtain);
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException e27) {
                                e27.printStackTrace();
                            }
                        }
                        if (exists != 0) {
                            try {
                                exists.close();
                                throw th;
                            } catch (IOException e28) {
                                e28.printStackTrace();
                                throw th;
                            }
                        }
                        throw th;
                    }
                } catch (IOException e29) {
                    e = e29;
                }
            } catch (IOException e36) {
                e = e36;
                exists = 0;
            } catch (Throwable th6) {
                th = th6;
                exists = 0;
            }
        } catch (Throwable th7) {
            th = th7;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ArCloudConfigInfo getModelResByMd5(String str) {
        if (str == null) {
            return null;
        }
        try {
            Iterator<ArCloudConfigInfo> it = this.mArCloudConfigInfos.iterator();
            while (it.hasNext()) {
                ArCloudConfigInfo next = it.next();
                ArModelResource arModelResource = next.F;
                if (arModelResource != null && !TextUtils.isEmpty(arModelResource.f198421e) && str.equals(next.F.f198421e)) {
                    return next;
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("ArConfigInfo{");
        stringBuffer.append("version='");
        stringBuffer.append(this.version);
        stringBuffer.append('\'');
        stringBuffer.append(", aRBegin=");
        stringBuffer.append(this.aRBegin);
        stringBuffer.append(", aREnd=");
        stringBuffer.append(this.aREnd);
        stringBuffer.append(", scanLine1='");
        stringBuffer.append(this.scanLine1);
        stringBuffer.append('\'');
        stringBuffer.append(", scanLine2='");
        stringBuffer.append(this.scanLine2);
        stringBuffer.append('\'');
        stringBuffer.append(", scanLineLink='");
        stringBuffer.append(this.scanLineLink);
        stringBuffer.append('\'');
        stringBuffer.append(", scanLinkUrl='");
        stringBuffer.append(this.scanLinkUrl);
        stringBuffer.append('\'');
        stringBuffer.append(", aRCloudBegin=");
        stringBuffer.append(this.aRCloudBegin);
        stringBuffer.append('\'');
        stringBuffer.append(", mArCloudConfigInfos=");
        stringBuffer.append(this.mArCloudConfigInfos);
        stringBuffer.append('\'');
        stringBuffer.append(", aRCloudCacheExpireTime=");
        stringBuffer.append(this.aRCloudCacheExpireTime);
        stringBuffer.append('\'');
        stringBuffer.append(", aRCloudEnd=");
        stringBuffer.append(this.aRCloudEnd);
        stringBuffer.append('\'');
        stringBuffer.append(", saveConfig=");
        stringBuffer.append(this.saveConfig);
        stringBuffer.append('\'');
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(20);
        parcel.writeInt(this.version);
        parcel.writeLong(this.aRBegin);
        parcel.writeLong(this.aREnd);
        parcel.writeString(this.scanLine1);
        parcel.writeString(this.scanLine2);
        parcel.writeString(this.scanLineLink);
        parcel.writeString(this.scanLinkUrl);
        parcel.writeTypedList(this.mArCloudConfigInfos);
        parcel.writeLong(this.aRCloudBegin);
        parcel.writeLong(this.aRCloudEnd);
        parcel.writeLong(this.aRCloudCacheExpireTime);
        parcel.writeByte(this.saveConfig ? (byte) 1 : (byte) 0);
    }

    protected ArConfigInfo(Parcel parcel) {
        this.mArCloudConfigInfos = new ArrayList<>();
        this.aRCloudBegin = 0L;
        this.aRCloudEnd = 0L;
        this.aRCloudCacheExpireTime = 0L;
        this.saveConfig = true;
        try {
            int readInt = parcel.readInt();
            ArCloudConfigInfo.N = readInt;
            if (readInt >= 10) {
                this.version = parcel.readInt();
            }
            if (readInt < 14) {
                this.version = 0;
            } else {
                this.version = readInt;
            }
            this.aRBegin = parcel.readLong();
            this.aREnd = parcel.readLong();
            this.scanLine1 = parcel.readString();
            this.scanLine2 = parcel.readString();
            this.scanLineLink = parcel.readString();
            this.scanLinkUrl = parcel.readString();
            this.mArCloudConfigInfos = parcel.createTypedArrayList(ArCloudConfigInfo.CREATOR);
            this.aRCloudBegin = parcel.readLong();
            this.aRCloudEnd = parcel.readLong();
            this.aRCloudCacheExpireTime = parcel.readLong();
            this.saveConfig = parcel.readByte() != 0;
        } catch (Exception e16) {
            QLog.i(TAG, 1, "ArConfigInfo read fail" + e16.getMessage());
        }
    }

    public static void deleteConfigFile(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "deleteConfigFile. uin = " + str);
        }
        if (str == null) {
            return;
        }
        deleteConfigFile(BaseApplicationImpl.sApplication.getFilesDir().getPath(), "ar_file_config_v739_" + str);
    }

    public static boolean saveArConfigToFile(ArConfigInfo arConfigInfo, String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "saveArConfigToFile. uin = " + str);
        }
        if (str == null) {
            return false;
        }
        return saveArConfigToFile(arConfigInfo, BaseApplicationImpl.sApplication.getFilesDir().getPath(), "ar_file_config_v739_" + str);
    }

    public static ArConfigInfo loadConfigFromFile(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "loadConfigFromFile. uin = " + str);
        }
        if (str == null) {
            return null;
        }
        return loadConfigFromFile(BaseApplicationImpl.sApplication.getFilesDir().getPath(), "ar_file_config_v739_" + str);
    }
}
