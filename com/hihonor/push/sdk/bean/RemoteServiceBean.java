package com.hihonor.push.sdk.bean;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes2.dex */
public class RemoteServiceBean {
    private String packageAction;
    private String packageName;
    private String packageServiceName;
    private String packageSignature;

    public boolean checkServiceInfo() {
        if ((!TextUtils.isEmpty(this.packageServiceName) || !TextUtils.isEmpty(this.packageAction)) && !TextUtils.isEmpty(this.packageName)) {
            return true;
        }
        return false;
    }

    public String getPackageAction() {
        return this.packageAction;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getPackageServiceName() {
        return this.packageServiceName;
    }

    public String getPackageSignature() {
        return this.packageSignature;
    }

    public void setPackageAction(String str) {
        this.packageAction = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setPackageServiceName(String str) {
        this.packageServiceName = str;
    }

    public void setPackageSignature(String str) {
        this.packageSignature = str;
    }

    public String toString() {
        return this.packageName + "|" + this.packageAction + "|" + this.packageServiceName;
    }
}
