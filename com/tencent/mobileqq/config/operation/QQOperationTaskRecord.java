package com.tencent.mobileqq.config.operation;

import android.text.TextUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes10.dex */
public class QQOperationTaskRecord extends Entity {
    public int aioCount;
    public long recordTime;

    @unique
    public int taskid;
    public String showCount = "";
    public String hasShowedUins = "";

    public void addUinShowCount(String str) {
        if (!TextUtils.isEmpty(str)) {
            String str2 = Marker.ANY_NON_NULL_MARKER + str + "_";
            if (!TextUtils.isEmpty(this.showCount) && this.showCount.contains(str2)) {
                int indexOf = this.showCount.indexOf(str2);
                if (indexOf == -1) {
                    if (QLog.isColorLevel()) {
                        QLog.d("QQOperateVoIP", 2, "addUinShowCount  showCount = " + this.showCount + " uin = " + str);
                        return;
                    }
                    return;
                }
                String substring = this.showCount.substring(indexOf + str2.length());
                int indexOf2 = substring.indexOf("|");
                if (indexOf2 == -1) {
                    if (QLog.isColorLevel()) {
                        QLog.d("QQOperateVoIP", 2, "addUinShowCount  showCount = " + this.showCount + " uin = " + str);
                        return;
                    }
                    return;
                }
                int intValue = Integer.valueOf(substring.substring(0, indexOf2)).intValue();
                int i3 = intValue + 1;
                this.showCount = this.showCount.replace(str2 + intValue, str2 + i3);
                return;
            }
            this.showCount += str2 + "1|";
        }
    }

    public int getUinTotalShowCount(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        String str2 = Marker.ANY_NON_NULL_MARKER + str + "_";
        if (TextUtils.isEmpty(this.showCount) || !this.showCount.contains(str2)) {
            return 0;
        }
        int indexOf = this.showCount.indexOf(str2);
        if (indexOf == -1) {
            if (QLog.isColorLevel()) {
                QLog.d("QQOperateVoIP", 2, "getUinTotalShowCount  showCount = " + this.showCount + " uin = " + str);
            }
            return 0;
        }
        String substring = this.showCount.substring(indexOf + str2.length());
        int indexOf2 = substring.indexOf("|");
        if (indexOf2 == -1) {
            if (QLog.isColorLevel()) {
                QLog.d("QQOperateVoIP", 2, "getUinTotalShowCount  showCount = " + this.showCount + " uin = " + str);
            }
            return 0;
        }
        try {
            return Integer.valueOf(substring.substring(0, indexOf2)).intValue();
        } catch (Exception unused) {
            if (!QLog.isColorLevel()) {
                return 0;
            }
            QLog.d("QQOperateVoIP", 2, "getUinTotalShowCount  showCount = " + this.showCount + " uin = " + str);
            return 0;
        }
    }
}
