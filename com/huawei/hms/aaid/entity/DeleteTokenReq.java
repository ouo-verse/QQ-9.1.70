package com.huawei.hms.aaid.entity;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* compiled from: P */
/* loaded from: classes2.dex */
public class DeleteTokenReq implements IMessageEntity {

    @Packed
    public String appId;

    @Packed
    public String pkgName;

    @Packed
    public String projectId;

    @Packed
    public String scope;

    @Packed
    public String subjectId;

    @Packed
    public String token;

    @Packed
    public boolean isMultiSender = false;

    @Packed
    public int deleteType = 0;

    @Packed
    public boolean isFastApp = false;

    public String getAppId() {
        return this.appId;
    }

    public int getDeleteType() {
        return this.deleteType;
    }

    public String getPkgName() {
        return this.pkgName;
    }

    public String getProjectId() {
        return this.projectId;
    }

    public String getScope() {
        return this.scope;
    }

    public String getSubjectId() {
        return this.subjectId;
    }

    public String getToken() {
        return this.token;
    }

    public boolean isFastApp() {
        return this.isFastApp;
    }

    public boolean isMultiSender() {
        return this.isMultiSender;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setDeleteType(int i3) {
        this.deleteType = i3;
    }

    public void setFastApp(boolean z16) {
        this.isFastApp = z16;
    }

    public void setMultiSender(boolean z16) {
        this.isMultiSender = z16;
    }

    public void setPkgName(String str) {
        this.pkgName = str;
    }

    public void setProjectId(String str) {
        this.projectId = str;
    }

    public void setScope(String str) {
        this.scope = str;
    }

    public void setSubjectId(String str) {
        this.subjectId = str;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(DeleteTokenReq.class.getName());
        stringBuffer.append("{");
        stringBuffer.append("pkgName: ");
        stringBuffer.append(this.pkgName);
        stringBuffer.append(",scope:");
        stringBuffer.append(this.scope);
        stringBuffer.append(",appId:");
        stringBuffer.append(this.appId);
        stringBuffer.append(",projectId:");
        stringBuffer.append(this.projectId);
        stringBuffer.append(",subjectId:");
        stringBuffer.append(this.subjectId);
        stringBuffer.append(",subjectId:");
        stringBuffer.append(this.subjectId);
        stringBuffer.append("}");
        return stringBuffer.toString();
    }
}
