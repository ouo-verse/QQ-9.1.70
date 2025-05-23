package com.tencent.mobileqq.data;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.IGNORE, columnNames = "md5")
/* loaded from: classes10.dex */
public class EmoticonFromGroupEntity extends Entity implements Comparable {
    public static final String TAG = "EmoticonFromGroupEntity";
    public String bigURL;
    public int fromType;
    public boolean gifImg;
    public String md5;

    /* renamed from: msg, reason: collision with root package name */
    @notColumn
    public MessageForPic f203071msg;

    @notColumn
    public MsgElement msgElement;

    @notColumn
    public MsgRecord msgRecord;
    public long msgseq;

    @notColumn
    public int status = -1;
    public String thumbURL;
    public long timestamp;
    public String troopUin;

    @Override // java.lang.Comparable
    public int compareTo(@NonNull Object obj) {
        int i3;
        if (obj instanceof EmoticonFromGroupEntity) {
            long j3 = this.timestamp;
            long j16 = ((EmoticonFromGroupEntity) obj).timestamp;
            if (j3 < j16) {
                i3 = 1;
            } else {
                if (j3 == j16) {
                    return 0;
                }
                i3 = -1;
            }
            return i3;
        }
        if (!QLog.isColorLevel()) {
            return 0;
        }
        QLog.e(TAG, 2, "Class not correct in method compareTo.");
        return 0;
    }

    public void replaceEntity(EmoticonFromGroupEntity emoticonFromGroupEntity) {
        if (emoticonFromGroupEntity != null) {
            this.troopUin = emoticonFromGroupEntity.troopUin;
            this.fromType = emoticonFromGroupEntity.fromType;
            this.md5 = emoticonFromGroupEntity.md5;
            this.bigURL = emoticonFromGroupEntity.bigURL;
            this.thumbURL = emoticonFromGroupEntity.thumbURL;
            this.gifImg = emoticonFromGroupEntity.gifImg;
            this.timestamp = emoticonFromGroupEntity.timestamp;
            this.msgseq = emoticonFromGroupEntity.msgseq;
        }
    }

    public String toString() {
        return "md5:" + this.md5 + " thumbURL:" + this.thumbURL + " bigURL:" + this.bigURL + " timestamp:" + this.timestamp + " msgseq:" + this.msgseq + " troopUin:" + this.troopUin + " gifImg:" + this.gifImg;
    }
}
