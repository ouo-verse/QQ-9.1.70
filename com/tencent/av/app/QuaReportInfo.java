package com.tencent.av.app;

import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QuaReportInfo implements Serializable {
    public int busytype;
    public String peerUin;
    public String selfUin;
    public int uintype;

    public QuaReportInfo toObject(String str) {
        try {
            String[] split = str.split("_");
            if (split[0].equals("null")) {
                this.selfUin = null;
            } else {
                this.selfUin = split[0];
            }
            if (split[1].equals("null")) {
                this.peerUin = null;
            } else {
                this.peerUin = split[1];
            }
            this.busytype = Integer.valueOf(split[2]).intValue();
            this.uintype = Integer.valueOf(split[3]).intValue();
            return this;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("QuaReportInfo", 2, "deserialization failed! exception = " + e16);
            }
            return null;
        }
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        String str = this.selfUin;
        String str2 = "null";
        if (str == null) {
            str = "null";
        }
        sb5.append(str);
        sb5.append("_");
        String str3 = this.peerUin;
        if (str3 != null) {
            str2 = str3;
        }
        sb5.append(str2);
        sb5.append("_");
        sb5.append(this.busytype);
        sb5.append("_");
        sb5.append(this.uintype);
        return sb5.toString();
    }
}
