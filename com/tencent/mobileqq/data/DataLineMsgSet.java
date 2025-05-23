package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.service.message.e;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes10.dex */
public class DataLineMsgSet implements Cloneable {
    public static String TAG = "dataline.DataLineMsgSet";
    private int groupId;
    private int groupType = 0;
    private long nLastId = 0;
    private long nFirstId = 0;
    private DataLineMsgRecord mFirstCome = null;
    private long mFirstArriveTime = 0;
    private long mLastArriveTime = 0;
    private DataLineMsgRecord[] mSet = null;
    private ArrayList<DataLineMsgRecord> mComeList = new ArrayList<>();
    private boolean mIsNewCome = false;
    private boolean mIsPaused = false;
    public boolean isReportPause = false;
    public long mUpdateProcessTick = 0;
    public long mUpdateMutiViewTick = 0;

    public DataLineMsgSet(int i3) {
        this.groupId = 0;
        this.groupId = i3;
    }

    public static boolean isCanceled(DataLineMsgRecord dataLineMsgRecord) {
        return dataLineMsgRecord != null && dataLineMsgRecord.fileMsgStatus == 2;
    }

    public static boolean isCompleted(DataLineMsgRecord dataLineMsgRecord) {
        if (dataLineMsgRecord != null && dataLineMsgRecord.issuc && dataLineMsgRecord.progress == 1.0f && dataLineMsgRecord.fileMsgStatus == 0) {
            return true;
        }
        return false;
    }

    public static boolean isSingle(int i3, int i16) {
        return i16 == 0 || i3 != 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DataLineMsgSet)) {
            return false;
        }
        DataLineMsgSet dataLineMsgSet = (DataLineMsgSet) obj;
        if (dataLineMsgSet.getTotalCount() != getTotalCount()) {
            return false;
        }
        if (dataLineMsgSet.isSingle()) {
            if (dataLineMsgSet.mSet[0].sessionid != this.mSet[0].sessionid) {
                return false;
            }
        } else if (dataLineMsgSet.getGroupId() != getGroupId()) {
            return false;
        }
        return true;
    }

    public DataLineMsgRecord getAt(int i3) {
        return this.mSet[i3];
    }

    public int getComeCount() {
        int i3 = 0;
        for (DataLineMsgRecord dataLineMsgRecord : this.mSet) {
            if (dataLineMsgRecord != null) {
                i3++;
            }
        }
        return i3;
    }

    public int getCompletedCount() {
        int i3 = 0;
        for (DataLineMsgRecord dataLineMsgRecord : this.mSet) {
            if (dataLineMsgRecord != null && dataLineMsgRecord.issuc && dataLineMsgRecord.progress == 1.0f) {
                i3++;
            }
        }
        return i3;
    }

    public String getFileNames() {
        DataLineMsgRecord[] dataLineMsgRecordArr;
        StringBuilder sb5 = new StringBuilder();
        int i3 = 0;
        while (true) {
            dataLineMsgRecordArr = this.mSet;
            if (i3 >= dataLineMsgRecordArr.length - 1) {
                break;
            }
            DataLineMsgRecord dataLineMsgRecord = dataLineMsgRecordArr[i3];
            if (dataLineMsgRecord != null) {
                sb5.append(dataLineMsgRecord.filename);
                sb5.append("\u3001");
            }
            i3++;
        }
        DataLineMsgRecord dataLineMsgRecord2 = dataLineMsgRecordArr[dataLineMsgRecordArr.length - 1];
        if (dataLineMsgRecord2 != null) {
            sb5.append(dataLineMsgRecord2.filename);
        }
        return sb5.toString();
    }

    public long getFileTotalSize() {
        long j3 = 0;
        for (DataLineMsgRecord dataLineMsgRecord : this.mSet) {
            if (dataLineMsgRecord != null) {
                j3 += dataLineMsgRecord.filesize;
            }
        }
        return j3;
    }

    public long getFirstId() {
        return this.nFirstId;
    }

    public DataLineMsgRecord getFirstItem() {
        for (DataLineMsgRecord dataLineMsgRecord : this.mSet) {
            if (dataLineMsgRecord != null) {
                return dataLineMsgRecord;
            }
        }
        return null;
    }

    public int getGroupId() {
        return this.groupId;
    }

    public int getGroupType() {
        return this.groupType;
    }

    public DataLineMsgRecord getItemBySessionId(long j3) {
        for (DataLineMsgRecord dataLineMsgRecord : this.mSet) {
            if (dataLineMsgRecord != null && dataLineMsgRecord.sessionid == j3) {
                return dataLineMsgRecord;
            }
        }
        return null;
    }

    public long getLastId() {
        return this.nLastId;
    }

    public DataLineMsgRecord getLastItem() {
        for (int length = this.mSet.length - 1; length >= 0; length--) {
            DataLineMsgRecord dataLineMsgRecord = this.mSet[length];
            if (dataLineMsgRecord != null) {
                return dataLineMsgRecord;
            }
        }
        return null;
    }

    public long getMsgId() {
        return this.mFirstCome.msgId;
    }

    public int getOpType() {
        return this.mFirstCome.nOpType;
    }

    public long getTime() {
        return this.mFirstArriveTime;
    }

    public int getTotalCount() {
        return this.mSet.length;
    }

    public float getTotalProcess() {
        float f16 = 0.0f;
        for (DataLineMsgRecord dataLineMsgRecord : this.mSet) {
            if (dataLineMsgRecord != null && dataLineMsgRecord.issuc && dataLineMsgRecord.fileMsgStatus == 0) {
                f16 += dataLineMsgRecord.progress;
            }
        }
        if (getTotalCount() == 0) {
            return 0.0f;
        }
        return f16 / getTotalCount();
    }

    public boolean hasFailed() {
        for (DataLineMsgRecord dataLineMsgRecord : this.mSet) {
            if (dataLineMsgRecord == null && isTimeOut()) {
                return true;
            }
            if (dataLineMsgRecord != null && !dataLineMsgRecord.issuc && dataLineMsgRecord.fileMsgStatus != 1) {
                return true;
            }
        }
        return false;
    }

    public boolean hasSendingOrRecving() {
        for (DataLineMsgRecord dataLineMsgRecord : this.mSet) {
            if (dataLineMsgRecord != null && dataLineMsgRecord.issuc && dataLineMsgRecord.progress != 1.0f) {
                long j3 = dataLineMsgRecord.fileMsgStatus;
                if (j3 != 1 && j3 != 2) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasWaiting() {
        for (DataLineMsgRecord dataLineMsgRecord : this.mSet) {
            if (dataLineMsgRecord == null && !isTimeOut()) {
                return true;
            }
        }
        return false;
    }

    public boolean isAllCompleted() {
        for (DataLineMsgRecord dataLineMsgRecord : this.mSet) {
            if (dataLineMsgRecord == null) {
                return false;
            }
            if (dataLineMsgRecord.issuc && dataLineMsgRecord.progress != 1.0f) {
                return false;
            }
        }
        return true;
    }

    public boolean isCanReciveOrResend() {
        Iterator<DataLineMsgRecord> it = values().iterator();
        while (it.hasNext()) {
            DataLineMsgRecord next = it.next();
            if (next.issuc) {
                long j3 = next.fileMsgStatus;
                if (j3 != 1 && j3 != 2) {
                }
            }
            return true;
        }
        return false;
    }

    public boolean isFileComing() {
        for (DataLineMsgRecord dataLineMsgRecord : this.mSet) {
            if (dataLineMsgRecord == null && isTimeOut()) {
                return false;
            }
            if (dataLineMsgRecord != null && dataLineMsgRecord.fileMsgStatus != 1) {
                return false;
            }
        }
        return true;
    }

    public boolean isFileType() {
        int i3 = this.groupType;
        return i3 == -2000 || i3 == -2005 || i3 == -2009 || i3 == -2335;
    }

    public boolean isSendFromLocal() {
        return this.mFirstCome.isSendFromLocal();
    }

    public boolean isTimeOut() {
        if (e.K0() - this.mLastArriveTime > 90) {
            return true;
        }
        return false;
    }

    public synchronized void printlog() {
        if (!QLog.isColorLevel()) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("\u72b6\u6001\u6c47\u603b: groupId[");
        sb5.append(this.groupId);
        sb5.append("]; size[");
        sb5.append(getTotalCount());
        sb5.append("]; isTimeOut[");
        sb5.append(isTimeOut());
        sb5.append("]; mLastArriveTime[");
        sb5.append(this.mLastArriveTime);
        sb5.append("]; ");
        int i3 = 0;
        for (DataLineMsgRecord dataLineMsgRecord : this.mSet) {
            if (dataLineMsgRecord == null) {
                sb5.append("{index[");
                sb5.append(i3);
                sb5.append("]; \u672a\u6709session}; ");
            } else {
                sb5.append("{index[");
                sb5.append(i3);
                sb5.append("/");
                sb5.append(dataLineMsgRecord.groupIndex);
                sb5.append("]; sessionid[");
                sb5.append(dataLineMsgRecord.sessionid);
                sb5.append("]; issuc[");
                sb5.append(dataLineMsgRecord.issuc);
                sb5.append("]; progress[");
                sb5.append(dataLineMsgRecord.progress);
                sb5.append("]; fileMsgStatus[");
                sb5.append(dataLineMsgRecord.fileMsgStatus);
                sb5.append("]; time[");
                sb5.append(dataLineMsgRecord.time);
                sb5.append("]}; ");
            }
            i3++;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, sb5.toString());
        }
    }

    public synchronized DataLineMsgRecord put(Integer num, DataLineMsgRecord dataLineMsgRecord) {
        int i3;
        DataLineMsgRecord dataLineMsgRecord2;
        long j3 = this.nLastId;
        if (j3 == 0 || dataLineMsgRecord.msgId > j3) {
            this.nLastId = dataLineMsgRecord.msgId;
        }
        long j16 = this.nFirstId;
        if (j16 == 0 || dataLineMsgRecord.msgId < j16) {
            this.nFirstId = dataLineMsgRecord.msgId;
        }
        long j17 = this.mFirstArriveTime;
        if (j17 == 0 || j17 > dataLineMsgRecord.time) {
            this.mFirstArriveTime = dataLineMsgRecord.time;
            this.mFirstCome = dataLineMsgRecord;
        }
        long j18 = this.mLastArriveTime;
        if (j18 == 0 || j18 < dataLineMsgRecord.time) {
            this.mLastArriveTime = dataLineMsgRecord.time;
        }
        int i16 = this.groupType;
        if (i16 == 0) {
            this.groupType = dataLineMsgRecord.msgtype;
        } else if (i16 == -2000 && ((i3 = dataLineMsgRecord.msgtype) == -2005 || i3 == -2009)) {
            this.groupType = -2005;
        }
        this.mIsNewCome = true;
        if (isSingle(dataLineMsgRecord)) {
            if (this.mSet == null) {
                this.mSet = new DataLineMsgRecord[1];
            }
            DataLineMsgRecord[] dataLineMsgRecordArr = this.mSet;
            dataLineMsgRecord2 = dataLineMsgRecordArr[0];
            dataLineMsgRecordArr[0] = dataLineMsgRecord;
        } else {
            if (this.mSet == null) {
                this.mSet = new DataLineMsgRecord[dataLineMsgRecord.groupSize];
            }
            int i17 = dataLineMsgRecord.groupIndex;
            if (i17 < dataLineMsgRecord.groupSize) {
                DataLineMsgRecord[] dataLineMsgRecordArr2 = this.mSet;
                dataLineMsgRecord2 = dataLineMsgRecordArr2[i17];
                dataLineMsgRecordArr2[i17] = dataLineMsgRecord;
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "\u63d2\u5165Session[" + dataLineMsgRecord.sessionid + "], groupIndex[" + dataLineMsgRecord.groupIndex + "], fileMsgStatus[" + dataLineMsgRecord.fileMsgStatus + "], time[" + dataLineMsgRecord.time + "], mLastArriveTime[" + this.mLastArriveTime + "]", new Throwable());
                }
            } else {
                dataLineMsgRecord2 = null;
            }
        }
        return dataLineMsgRecord2;
    }

    public synchronized void setPaused(boolean z16) {
        this.mIsPaused = z16;
    }

    public void setTimeOut() {
        this.mLastArriveTime = e.K0() - 95;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "\u8bbe\u7f6etimeOut, mLastArriveTime[" + this.mLastArriveTime);
        }
    }

    public synchronized ArrayList<DataLineMsgRecord> values() {
        if (this.mIsNewCome) {
            this.mIsNewCome = false;
            this.mComeList.clear();
            for (DataLineMsgRecord dataLineMsgRecord : this.mSet) {
                if (dataLineMsgRecord != null) {
                    this.mComeList.add(dataLineMsgRecord);
                }
            }
        }
        return this.mComeList;
    }

    public static boolean isFileType(DataLineMsgRecord dataLineMsgRecord) {
        int i3 = dataLineMsgRecord.msgtype;
        return i3 == -2000 || i3 == -2005 || i3 == -2009 || i3 == -2335;
    }

    public boolean isCanceled() {
        int i3 = 0;
        for (DataLineMsgRecord dataLineMsgRecord : this.mSet) {
            if (isCanceled(dataLineMsgRecord)) {
                i3++;
            } else if ((dataLineMsgRecord == null || dataLineMsgRecord.fileMsgStatus != 1) && !isCompleted(dataLineMsgRecord)) {
                return false;
            }
        }
        return i3 > 0;
    }

    public boolean isSingle() {
        int i3;
        return this.groupId == 0 || (i3 = this.groupType) == -2005 || i3 == -2009;
    }

    public static boolean isCanReciveOrResend(DataLineMsgRecord dataLineMsgRecord) {
        boolean z16 = dataLineMsgRecord.issuc;
        if (z16) {
            long j3 = dataLineMsgRecord.fileMsgStatus;
            if (j3 != 1 && j3 != 2) {
                if (dataLineMsgRecord.progress == 1.0f && z16) {
                    return TextUtils.isEmpty(dataLineMsgRecord.path) || !q.p(dataLineMsgRecord.path);
                }
                return false;
            }
        }
        return true;
    }

    public static boolean isSingle(DataLineMsgRecord dataLineMsgRecord) {
        int i3;
        return dataLineMsgRecord.groupId == 0 || (i3 = dataLineMsgRecord.msgtype) == -2005 || i3 == -2009;
    }
}
