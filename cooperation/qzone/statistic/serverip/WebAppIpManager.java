package cooperation.qzone.statistic.serverip;

import QMF_PROTOCAL.QmfClientIpInfo;
import QMF_PROTOCAL.QmfServerInfo;
import android.os.Parcel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import common.config.service.QzoneConfig;
import cooperation.qzone.statistic.AccManager;
import cooperation.qzone.statistic.Singleton;
import cooperation.qzone.statistic.serverip.WebAppIpRecord;
import cooperation.qzone.util.FileUtils;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* compiled from: P */
/* loaded from: classes28.dex */
public class WebAppIpManager {
    public static final String FILE_CACH = "webapp_iplist";
    public static final String TAG = "WebAppIpManager";
    private static final Singleton<WebAppIpManager, Void> sSingleton = new Singleton<WebAppIpManager, Void>() { // from class: cooperation.qzone.statistic.serverip.WebAppIpManager.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // cooperation.qzone.statistic.Singleton
        public WebAppIpManager create(Void r16) {
            return new WebAppIpManager();
        }
    };
    private LinkedHashMap<Long, WebAppIpRecord> webAppIpMap;

    private File createFile() throws IOException {
        File file = new File(((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getInternalCacheDir() + File.separator + FILE_CACH);
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                if (file.getParentFile().mkdirs()) {
                    file.createNewFile();
                }
            } else {
                file.createNewFile();
            }
        }
        return file;
    }

    private LinkedHashMap<Long, WebAppIpRecord> filterIpRecord(LinkedHashMap<Long, WebAppIpRecord> linkedHashMap, long j3) {
        if (linkedHashMap != null && !linkedHashMap.isEmpty() && j3 != 0) {
            WebAppIpRecord[] webAppIpRecordArr = (WebAppIpRecord[]) linkedHashMap.values().toArray(new WebAppIpRecord[linkedHashMap.size()]);
            long currentTimeMillis = System.currentTimeMillis();
            for (WebAppIpRecord webAppIpRecord : webAppIpRecordArr) {
                WebAppIpRecord.FixedSizeLinkedHashMap<Integer, Long> fixedSizeLinkedHashMap = webAppIpRecord.serverIpMap;
                if (!fixedSizeLinkedHashMap.isEmpty()) {
                    Integer[] numArr = (Integer[]) fixedSizeLinkedHashMap.keySet().toArray(new Integer[fixedSizeLinkedHashMap.size()]);
                    int length = numArr.length;
                    for (int i3 = 0; i3 < length; i3++) {
                        Integer num = numArr[i3];
                        if (currentTimeMillis - fixedSizeLinkedHashMap.get(num).longValue() > j3) {
                            fixedSizeLinkedHashMap.remove(num);
                        }
                        if (i3 == length - 1 && fixedSizeLinkedHashMap.isEmpty()) {
                            linkedHashMap.remove(Long.valueOf(webAppIpRecord.serverChangeTime));
                        }
                    }
                }
            }
        }
        return linkedHashMap;
    }

    public static WebAppIpManager getInstance() {
        return sSingleton.get(null);
    }

    public static boolean isValidServerInfo(QmfServerInfo qmfServerInfo) {
        QmfClientIpInfo qmfClientIpInfo;
        if (qmfServerInfo == null || (qmfClientIpInfo = qmfServerInfo.ipWebapp) == null || qmfServerInfo.changeTime == 0 || qmfClientIpInfo.ClientIpv4 == 0) {
            return false;
        }
        return true;
    }

    public synchronized void addWebAppIpRecord(QmfServerInfo qmfServerInfo) {
        if (QZLog.isColorLevel()) {
            QZLog.d(TAG, 2, "addWebAppIpRecord--changeTime:" + qmfServerInfo.changeTime + ", Ipv4:" + qmfServerInfo.ipWebapp.ClientIpv4);
        }
        if (this.webAppIpMap == null) {
            this.webAppIpMap = new LinkedHashMap<>();
        }
        WebAppIpRecord webAppIpRecord = this.webAppIpMap.get(Long.valueOf(qmfServerInfo.changeTime));
        if (webAppIpRecord == null) {
            webAppIpRecord = new WebAppIpRecord();
            this.webAppIpMap.put(Long.valueOf(qmfServerInfo.changeTime), webAppIpRecord);
        }
        webAppIpRecord.serverChangeTime = qmfServerInfo.changeTime;
        webAppIpRecord.addIpAdress(qmfServerInfo.ipWebapp.ClientIpv4);
    }

    public synchronized void persistence() {
        IOException e16;
        int i3;
        LinkedHashMap<Long, WebAppIpRecord> linkedHashMap = this.webAppIpMap;
        if (linkedHashMap != null && !linkedHashMap.isEmpty()) {
            if (QZLog.isColorLevel()) {
                QZLog.d(TAG, 2, "---persistence--mapsize:" + this.webAppIpMap.size());
            }
            FileOutputStream fileOutputStream = null;
            try {
                LinkedHashMap<Long, WebAppIpRecord> filterIpRecord = filterIpRecord(this.webAppIpMap, QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_LATEST_WEBAPP_IP_RECORD_SECONDS, 60) * 1000);
                if (QZLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("---persistence--filterIpRecord after mapsize:");
                    if (filterIpRecord != null) {
                        i3 = filterIpRecord.size();
                    } else {
                        i3 = 0;
                    }
                    sb5.append(i3);
                    QZLog.d(TAG, 2, sb5.toString());
                }
                int config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_LATEST_WEBAPP_TIMESTAMP_COUNT, 3);
                Long[] lArr = (Long[]) filterIpRecord.keySet().toArray(new Long[filterIpRecord.size()]);
                Arrays.sort(lArr);
                int length = lArr.length;
                if (config > length) {
                    config = length;
                }
                ArrayList arrayList = new ArrayList();
                for (int i16 = length - 1; i16 >= length - config; i16--) {
                    arrayList.add(filterIpRecord.get(lArr[i16]));
                }
                Parcel obtain = Parcel.obtain();
                obtain.setDataPosition(0);
                obtain.writeInt(arrayList.size());
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    WebAppIpRecord webAppIpRecord = (WebAppIpRecord) it.next();
                    if (QZLog.isColorLevel()) {
                        QZLog.i(TAG, 2, "persistence record--changetime: " + webAppIpRecord.serverChangeTime + ", ip:" + webAppIpRecord.serverIpMap.toString());
                    }
                    webAppIpRecord.writeToParcel(obtain, 0);
                }
                byte[] marshall = obtain.marshall();
                OaidMonitor.parcelRecycle(obtain);
                File createFile = createFile();
                if (createFile != null) {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(createFile);
                    try {
                        fileOutputStream2.write(marshall);
                        fileOutputStream = fileOutputStream2;
                    } catch (Throwable th5) {
                        th = th5;
                        fileOutputStream = fileOutputStream2;
                        try {
                            QZLog.w(th);
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e17) {
                                    e16 = e17;
                                    e16.printStackTrace();
                                }
                            }
                        } finally {
                        }
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e18) {
                        e16 = e18;
                        e16.printStackTrace();
                    }
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00cf A[Catch: all -> 0x013a, TryCatch #11 {, blocks: (B:15:0x004a, B:18:0x004f, B:86:0x009b, B:37:0x00a3, B:39:0x00cf, B:40:0x00d3, B:42:0x00d9, B:45:0x00e1, B:48:0x00e6, B:49:0x00ee, B:51:0x00f4, B:53:0x0100, B:55:0x0123, B:89:0x00a0, B:67:0x00c2, B:70:0x00c7, B:79:0x0136, B:75:0x0142, B:76:0x0145, B:82:0x013d), top: B:3:0x0003, inners: #4, #7, #10, #12 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0142 A[Catch: all -> 0x013a, TryCatch #11 {, blocks: (B:15:0x004a, B:18:0x004f, B:86:0x009b, B:37:0x00a3, B:39:0x00cf, B:40:0x00d3, B:42:0x00d9, B:45:0x00e1, B:48:0x00e6, B:49:0x00ee, B:51:0x00f4, B:53:0x0100, B:55:0x0123, B:89:0x00a0, B:67:0x00c2, B:70:0x00c7, B:79:0x0136, B:75:0x0142, B:76:0x0145, B:82:0x013d), top: B:3:0x0003, inners: #4, #7, #10, #12 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:? A[Catch: all -> 0x013a, SYNTHETIC, TRY_LEAVE, TryCatch #11 {, blocks: (B:15:0x004a, B:18:0x004f, B:86:0x009b, B:37:0x00a3, B:39:0x00cf, B:40:0x00d3, B:42:0x00d9, B:45:0x00e1, B:48:0x00e6, B:49:0x00ee, B:51:0x00f4, B:53:0x0100, B:55:0x0123, B:89:0x00a0, B:67:0x00c2, B:70:0x00c7, B:79:0x0136, B:75:0x0142, B:76:0x0145, B:82:0x013d), top: B:3:0x0003, inners: #4, #7, #10, #12 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0136 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void report() {
        Parcel parcel;
        ArrayList arrayList;
        WebAppIpRecord.FixedSizeLinkedHashMap<Integer, Long> fixedSizeLinkedHashMap;
        byte[] bArr;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            File file = new File(((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getInternalCacheDir() + File.separator + FILE_CACH);
            if (file.exists()) {
                bArr = new byte[(int) file.length()];
                fileInputStream = new FileInputStream(file);
                try {
                    fileInputStream.read(bArr);
                    FileUtils.deleteFile(file);
                } catch (Exception e16) {
                    e = e16;
                    parcel = null;
                    arrayList = null;
                    fileInputStream2 = fileInputStream;
                    try {
                        QZLog.w(e);
                        if (fileInputStream2 != null) {
                        }
                        if (parcel != null) {
                        }
                        if (arrayList != null) {
                        }
                        return;
                    } catch (Throwable th5) {
                        th = th5;
                        if (fileInputStream2 != null) {
                        }
                        if (parcel != null) {
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    parcel = null;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                    }
                    if (parcel != null) {
                    }
                }
            } else {
                bArr = null;
                fileInputStream = null;
            }
        } catch (Exception e17) {
            e = e17;
            parcel = null;
            arrayList = null;
        } catch (Throwable th7) {
            th = th7;
            parcel = null;
        }
        if (bArr == null) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e18) {
                    QZLog.w(e18);
                }
            }
            return;
        }
        parcel = Parcel.obtain();
        try {
            try {
                parcel.unmarshall(bArr, 0, bArr.length);
                parcel.setDataPosition(0);
                int readInt = parcel.readInt();
                if (QZLog.isColorLevel()) {
                    QZLog.i(TAG, 2, "report--count : " + readInt);
                }
                arrayList = new ArrayList();
                for (int i3 = 0; i3 < readInt; i3++) {
                    try {
                        arrayList.add(WebAppIpRecord.CREATOR.createFromParcel(parcel));
                    } catch (Exception e19) {
                        e = e19;
                        fileInputStream2 = fileInputStream;
                        QZLog.w(e);
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e26) {
                                QZLog.w(e26);
                            }
                        }
                        if (parcel != null) {
                            OaidMonitor.parcelRecycle(parcel);
                        }
                        if (arrayList != null) {
                        }
                        return;
                    }
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e27) {
                        QZLog.w(e27);
                    }
                }
            } catch (Throwable th8) {
                th = th8;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e28) {
                        QZLog.w(e28);
                    }
                }
                if (parcel != null) {
                    OaidMonitor.parcelRecycle(parcel);
                    throw th;
                }
                throw th;
            }
        } catch (Exception e29) {
            e = e29;
            arrayList = null;
        }
        OaidMonitor.parcelRecycle(parcel);
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                WebAppIpRecord webAppIpRecord = (WebAppIpRecord) it.next();
                if (webAppIpRecord != null && (fixedSizeLinkedHashMap = webAppIpRecord.serverIpMap) != null) {
                    for (Integer num : fixedSizeLinkedHashMap.keySet()) {
                        if (QZLog.isColorLevel()) {
                            QZLog.i(TAG, 2, "reportCrashRelatedServerIP--ip : " + num + ", serverChangeTime:" + webAppIpRecord.serverChangeTime);
                        }
                        AccManager.reportCrashRelatedServerIP(num.intValue(), String.valueOf(webAppIpRecord.serverChangeTime));
                    }
                }
            }
        }
        return;
    }
}
