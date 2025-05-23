package com.tencent.biz.qcircleshadow.remotechecker;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import cooperation.qzone.QUA;
import java.io.Serializable;

@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "version")
/* loaded from: classes4.dex */
public class QCirclePluginInfo extends Entity implements Cloneable, Serializable {
    public String cookie;
    public boolean isInvalid;
    public boolean isReady;
    public long mUin;
    public String managerFileUrl;
    public long managerFilelength;
    public String pluginManagerPath;
    public String pluginZipPath;
    public String qua;

    @unique
    public int version;
    public long zipFileLength;
    public String zipFileUrl;

    public QCirclePluginInfo() {
    }

    protected Object clone() {
        return new QCirclePluginInfo(this.version, this.cookie, this.zipFileUrl, this.managerFileUrl, this.zipFileLength, this.managerFilelength, this.mUin);
    }

    public QCirclePluginInfo(int i3, String str, String str2, String str3, long j3, long j16, long j17) {
        this.version = i3;
        this.cookie = str;
        this.zipFileUrl = str2;
        this.managerFileUrl = str3;
        this.zipFileLength = j3;
        this.managerFilelength = j16;
        this.qua = QUA.getQUA3();
        this.mUin = j17;
    }
}
