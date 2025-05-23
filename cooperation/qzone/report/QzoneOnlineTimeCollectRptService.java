package cooperation.qzone.report;

import NS_MOBILE_FEEDS.mobile_online_report_item;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQzoneReq;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QzoneOnlineTimeCollectRptService {
    private static final int DEFAULT_INTERVAL_TIME = 3600;
    private static final int DEFAULT_MAX_NUM = 1;
    private static final int DEFAULT_TIME_INTERVAL = 10000;
    private static final String KEY_ONLINETIME = "QZonlinetime";
    private static final String KEY_ONLINETIME_LASTRECORD = "QZonlinetimeLastRecord";
    private static final String KEY_ONLINETIME_LASTRECORD_PICTURE = "QZonlinetimeLastRecord_picture";
    private static final String KEY_ONLINETIME_LASTRECORD_VIDEO = "QZonlinetimeLastRecord_video";
    private static final String KEY_ONLINETIME_LASTRECORD_WEB = "QZonlinetimeLastRecord_web";
    private static final String KEY_ONLINETIME_PICTURE = "QZonlinetime_picture";
    private static final String KEY_ONLINETIME_VIDEO = "QZonlinetime_video";
    private static final String KEY_ONLINETIME_WEB = "QZonlinetime_web";
    public static final int KEY_PICTURE = 3;
    public static final int KEY_QZONE = 0;
    public static final int KEY_VIDEO = 4;
    public static final int KEY_WEB = 1;
    private static final String TAG = "QzoneOnlineTimeCollectRptService";
    private static QzoneOnlineTimeCollectRptService mInstance;
    private mobile_online_report_item mRecord;
    private ArrayList<mobile_online_report_item> mReportItems = new ArrayList<>();
    private ArrayList<mobile_online_report_item> mBackupItems = new ArrayList<>();
    private String mKeyOnlineSp = KEY_ONLINETIME;
    private String mKeyOnlineUpdateSp = KEY_ONLINETIME_LASTRECORD;
    private volatile boolean isForeground = false;
    private int mDelay = 10000;
    long mUin = 0;
    private Runnable mOnlineTimeCheckTraceRunnable = new Runnable() { // from class: cooperation.qzone.report.QzoneOnlineTimeCollectRptService.3
        @Override // java.lang.Runnable
        public void run() {
            ThreadManager.getSubThreadHandler().removeCallbacks(QzoneOnlineTimeCollectRptService.this.mOnlineTimeCheckTraceRunnable);
            if (QLog.isColorLevel()) {
                QLog.d(QzoneOnlineTimeCollectRptService.TAG, 2, "mOnlineTimeCheckTraceRunnable run");
            }
            QzoneOnlineTimeCollectRptService.this.updateRecord();
            ThreadManager.getSubThreadHandler().postDelayed(this, QzoneOnlineTimeCollectRptService.this.mDelay);
        }
    };
    int mRetryTimes = 0;
    private long mLastReportTime = 0;

    QzoneOnlineTimeCollectRptService() {
    }

    private synchronized void checkToReport() {
        QLog.d(TAG, 1, "isNeedToReport=" + isNeedToReport());
        if (isNeedToReport()) {
            if (this.mBackupItems.size() > 0) {
                this.mBackupItems.clear();
            }
            this.mBackupItems.addAll(this.mReportItems);
            this.mReportItems.clear();
            if (this.mUin != 0) {
                report(this.mBackupItems);
            }
        }
    }

    public static final QzoneOnlineTimeCollectRptService getInstance() {
        if (mInstance == null) {
            mInstance = new QzoneOnlineTimeCollectRptService();
        }
        return mInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        int i3;
        long j3 = this.mUin;
        if (j3 == 0) {
            return;
        }
        String string = LocalMultiProcConfig.getString(this.mKeyOnlineSp + "_" + j3, "");
        String string2 = LocalMultiProcConfig.getString(this.mKeyOnlineUpdateSp + "_" + j3, "");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("key_sp_qzone_crash_time_");
        sb5.append(j3);
        long j16 = LocalMultiProcConfig.getLong(sb5.toString(), 0L);
        QLog.d(TAG, 1, "sp:" + this.mKeyOnlineSp + " lost time:" + string2 + " sp:" + this.mKeyOnlineUpdateSp + " crash time:" + j16);
        if (!TextUtils.isEmpty(string2)) {
            if (j16 != 0 && this.mKeyOnlineSp.equals(KEY_ONLINETIME)) {
                string2 = string2.substring(0, string2.lastIndexOf(";")) + ";" + j16;
            }
            if (!TextUtils.isEmpty(string)) {
                string = string + ";" + string2;
            } else {
                string = string2;
            }
            LocalMultiProcConfig.putString(this.mKeyOnlineSp + "_" + j3, string);
            LocalMultiProcConfig.putString(this.mKeyOnlineUpdateSp + "_" + j3, "");
        }
        LocalMultiProcConfig.putLong("key_sp_qzone_crash_time_" + j3, 0L);
        QLog.d(TAG, 1, "s:" + string);
        String[] split = string.split(";");
        if (split != null && split.length > 1) {
            for (int i16 = 0; i16 < split.length; i16 += 2) {
                try {
                    this.mReportItems.add(new mobile_online_report_item(j3, Long.parseLong(split[i16]), Long.parseLong(split[i16 + 1])));
                } catch (Exception e16) {
                    i3 = 1;
                    QLog.e(TAG, 1, "e:" + e16.toString());
                }
            }
            i3 = 1;
            if (this.mReportItems.size() >= i3 && this.mReportItems.get(0) != null) {
                this.mLastReportTime = this.mReportItems.get(0).uptime;
            }
            checkToReport();
        }
    }

    private boolean isNeedToReport() {
        QzoneConfig qzoneConfig = QzoneConfig.getInstance();
        if (this.mLastReportTime != 0) {
            if ((System.currentTimeMillis() / 1000) - this.mLastReportTime <= qzoneConfig.getConfig("ClientReport", QzoneConfig.SECONDARY_ONLINE_REPORT_INTEVAL, 3600) && this.mReportItems.size() < qzoneConfig.getConfig("ClientReport", QzoneConfig.SECONDARY_ONLINE_REPORT_FREQUENCY, 1)) {
                return false;
            }
            return true;
        }
        if (this.mReportItems.size() < qzoneConfig.getConfig("ClientReport", QzoneConfig.SECONDARY_ONLINE_REPORT_FREQUENCY, 1)) {
            return false;
        }
        return true;
    }

    private void report(ArrayList<mobile_online_report_item> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            this.mLastReportTime = System.currentTimeMillis();
            ((IQzoneReq) QRoute.api(IQzoneReq.class)).sentOnlineTimeServlet(new ArrayList<>(arrayList));
            return;
        }
        QLog.e(TAG, 1, "There is no record to report!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveData() {
        ArrayList<mobile_online_report_item> arrayList = this.mReportItems;
        if (arrayList != null && arrayList.size() != 0) {
            StringBuilder sb5 = new StringBuilder();
            Iterator<mobile_online_report_item> it = this.mReportItems.iterator();
            while (it.hasNext()) {
                mobile_online_report_item next = it.next();
                if (next != null) {
                    sb5.append(next.uptime + ";" + next.downtime + ";");
                }
            }
            if (sb5.length() != 0) {
                sb5.deleteCharAt(sb5.length() - 1);
                LocalMultiProcConfig.putString(this.mKeyOnlineSp + "_" + this.mUin, sb5.toString());
                QLog.d(TAG, 1, "saveData mReportItems size:" + this.mReportItems.size() + " mLastReportTime:" + this.mLastReportTime + " re:" + sb5.toString());
                this.mReportItems.clear();
            } else {
                QLog.w(TAG, 1, "re length:0");
            }
        }
        LocalMultiProcConfig.putString(this.mKeyOnlineUpdateSp + "_" + this.mUin, "");
    }

    public void addRecord(mobile_online_report_item mobile_online_report_itemVar) {
        if (mobile_online_report_itemVar != null && mobile_online_report_itemVar.uptime != 0 && mobile_online_report_itemVar.downtime != 0) {
            this.mReportItems.add(mobile_online_report_itemVar);
        }
        checkToReport();
    }

    public synchronized void beginRecord() {
        mobile_online_report_item mobile_online_report_itemVar = this.mRecord;
        if (mobile_online_report_itemVar == null) {
            this.mRecord = new mobile_online_report_item();
        } else {
            mobile_online_report_itemVar.downtime = 0L;
            mobile_online_report_itemVar.loginuin = 0L;
            mobile_online_report_itemVar.uptime = 0L;
        }
        this.mRecord.uptime = System.currentTimeMillis() / 1000;
    }

    public void beginTrace(int i3) {
        beginTrace(i3, false);
    }

    public synchronized void closeRecord() {
        mobile_online_report_item mobile_online_report_itemVar = this.mRecord;
        if (mobile_online_report_itemVar != null) {
            mobile_online_report_itemVar.downtime = System.currentTimeMillis() / 1000;
            mobile_online_report_item mobile_online_report_itemVar2 = this.mRecord;
            mobile_online_report_itemVar2.loginuin = this.mUin;
            addRecord(mobile_online_report_itemVar2);
        }
    }

    public void closeTrace() {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: cooperation.qzone.report.QzoneOnlineTimeCollectRptService.2
            @Override // java.lang.Runnable
            public void run() {
                QLog.d(QzoneOnlineTimeCollectRptService.TAG, 1, "closeTrace isForeground:" + QzoneOnlineTimeCollectRptService.this.isForeground);
                if (QzoneOnlineTimeCollectRptService.this.isForeground) {
                    ThreadManager.getSubThreadHandler().removeCallbacks(QzoneOnlineTimeCollectRptService.this.mOnlineTimeCheckTraceRunnable);
                    QzoneOnlineTimeCollectRptService.this.closeRecord();
                    QzoneOnlineTimeCollectRptService.this.saveData();
                    LocalMultiProcConfig.putBool(QZoneHelper.Constants.KEY_SP_QZONE_ISFOREGROUND, false);
                    QzoneOnlineTimeCollectRptService.this.isForeground = false;
                }
            }
        });
    }

    public boolean isForeground() {
        return this.isForeground;
    }

    public void onTaskResponse(int i3) {
        if (i3 != 1000) {
            QLog.w(TAG, 1, "QzoneOnlineTimeCollectRptService report failure resultCode:" + i3 + " RetryTimes:" + this.mRetryTimes);
            int i16 = this.mRetryTimes;
            if (i16 < 2) {
                this.mRetryTimes = i16 + 1;
                report(this.mBackupItems);
                return;
            }
            return;
        }
        QLog.d(TAG, 1, "QzoneOnlineTimeCollectRptService task succeed!");
        this.mRetryTimes = 0;
        ArrayList<mobile_online_report_item> arrayList = this.mBackupItems;
        if (arrayList != null && arrayList.size() > 0) {
            for (int i17 = 0; i17 < this.mBackupItems.size(); i17++) {
                QLog.d(TAG, 1, "sp:" + this.mKeyOnlineSp + " report uptime:" + this.mBackupItems.get(i17).uptime + " downtime:" + this.mBackupItems.get(i17).downtime);
            }
            this.mBackupItems.clear();
        }
        LocalMultiProcConfig.putString(this.mKeyOnlineSp + "_" + this.mUin, "");
        LocalMultiProcConfig.putString(this.mKeyOnlineUpdateSp + "_" + this.mUin, "");
    }

    public void setType(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        this.mKeyOnlineSp = KEY_ONLINETIME_VIDEO;
                        this.mKeyOnlineUpdateSp = KEY_ONLINETIME_LASTRECORD_VIDEO;
                        return;
                    }
                    return;
                }
                this.mKeyOnlineSp = KEY_ONLINETIME_PICTURE;
                this.mKeyOnlineUpdateSp = KEY_ONLINETIME_LASTRECORD_PICTURE;
                return;
            }
            this.mKeyOnlineSp = KEY_ONLINETIME_WEB;
            this.mKeyOnlineUpdateSp = KEY_ONLINETIME_LASTRECORD_WEB;
            return;
        }
        this.mKeyOnlineSp = KEY_ONLINETIME;
        this.mKeyOnlineUpdateSp = KEY_ONLINETIME_LASTRECORD;
    }

    public void updateRecord() {
        mobile_online_report_item mobile_online_report_itemVar = this.mRecord;
        if (mobile_online_report_itemVar != null) {
            if (mobile_online_report_itemVar.uptime > 0) {
                mobile_online_report_itemVar.downtime = System.currentTimeMillis() / 1000;
                mobile_online_report_item mobile_online_report_itemVar2 = this.mRecord;
                long j3 = mobile_online_report_itemVar2.uptime;
                long j16 = mobile_online_report_itemVar2.downtime;
                if (j3 == j16) {
                    mobile_online_report_itemVar2.downtime = j16 + 1;
                }
            } else {
                mobile_online_report_itemVar.uptime = System.currentTimeMillis() / 1000;
                mobile_online_report_item mobile_online_report_itemVar3 = this.mRecord;
                mobile_online_report_itemVar3.downtime = mobile_online_report_itemVar3.uptime + 1;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "update sp:" + this.mKeyOnlineUpdateSp + " last time:" + this.mRecord.downtime);
            }
            LocalMultiProcConfig.putString(this.mKeyOnlineUpdateSp + "_" + this.mUin, this.mRecord.uptime + ";" + this.mRecord.downtime);
        }
    }

    public void beginTrace(int i3, final boolean z16) {
        setType(i3);
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: cooperation.qzone.report.QzoneOnlineTimeCollectRptService.1
            @Override // java.lang.Runnable
            public void run() {
                QLog.d(QzoneOnlineTimeCollectRptService.TAG, 1, "beginTrace isForeground:" + QzoneOnlineTimeCollectRptService.this.isForeground + ", isActiveTrigger:" + z16);
                if (!QzoneOnlineTimeCollectRptService.this.isForeground || z16) {
                    try {
                        QzoneOnlineTimeCollectRptService.this.mUin = Long.parseLong(MobileQQ.sMobileQQ.peekAppRuntime().getAccount());
                    } catch (Exception e16) {
                        QLog.e(QzoneOnlineTimeCollectRptService.TAG, 2, "beginTrace:" + e16.toString());
                    }
                    QzoneOnlineTimeCollectRptService.this.mDelay = QzoneConfig.getInstance().getConfig("ClientReport", QzoneConfig.SECONDARY_ONLINE_LOACL_SAVE_FREQUENCY, 10000);
                    QzoneOnlineTimeCollectRptService.this.beginRecord();
                    if (!QZoneHelper.getSimpleQZoneUISwitch()) {
                        QzoneOnlineTimeCollectRptService.this.initData();
                    } else {
                        QLog.w(QzoneOnlineTimeCollectRptService.TAG, 1, "qzone is SimpleUI not to get updateTime");
                    }
                    QzoneOnlineTimeCollectRptService.this.isForeground = true;
                    LocalMultiProcConfig.putBool(QZoneHelper.Constants.KEY_SP_QZONE_ISFOREGROUND, true);
                    if (QzoneOnlineTimeCollectRptService.this.mDelay != 0) {
                        ThreadManager.getSubThreadHandler().post(QzoneOnlineTimeCollectRptService.this.mOnlineTimeCheckTraceRunnable);
                    }
                }
            }
        });
    }
}
