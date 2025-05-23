package com.tencent.mobileqq.qcircle.tempapi.avatar;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import java.io.Serializable;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "mUin,mTimestamp,mDownLoadUrl")
/* loaded from: classes16.dex */
public class QCircleAvatarInfo extends Entity implements Cloneable, Serializable {
    private static final long serialVersionUID = -4357612325647192547L;
    public byte dwFaceFlag;
    public String mDownLoadUrl;
    public String mTimestamp;

    @unique
    public String mUin;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getDownLoadUrl() {
        return this.mDownLoadUrl;
    }

    public String getTimestamp() {
        return this.mTimestamp;
    }

    public String getUin() {
        return this.mUin;
    }

    public QCircleAvatarInfo setDownLoadUrl(String str) {
        this.mDownLoadUrl = str;
        return this;
    }

    public QCircleAvatarInfo setTimestamp(String str) {
        this.mTimestamp = str;
        return this;
    }

    public QCircleAvatarInfo setUin(String str) {
        this.mUin = str;
        return this;
    }

    public String toString() {
        return "QCircleAvatarInfo{mUin='" + this.mUin + "', mTimestamp='" + this.mTimestamp + "', mDownLoadUrl='" + this.mDownLoadUrl + "'}";
    }
}
