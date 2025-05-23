package com.tencent.aelight.camera.ae.download;

import com.tencent.aelight.camera.download.AEResManagerConfigBean;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEResBeanWrapper implements Serializable {
    private static final long serialVersionUID = 6728960802300604083L;
    public final String agentType;
    public String backupMd5;
    public String backupUrl;
    public final String bundleName;
    public boolean highPriority;
    public String md5;
    public final AEResManagerConfigBean.AEResBean originBean;
    public String url;
    public String version;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AEResBeanWrapper(AEResManagerConfigBean.AEResBean aEResBean, String str, String str2, String str3, String str4) {
        this.originBean = aEResBean;
        this.agentType = str;
        this.bundleName = str2;
        this.md5 = str3;
        this.url = str4;
        this.highPriority = false;
        this.backupMd5 = str3;
        this.backupUrl = str4;
        this.version = AEResManagerConfigBean.DEFAULT_VERSION;
    }

    public String toString() {
        return "AEResBeanWrapper{agentType='" + this.agentType + "', bundleName='" + this.bundleName + "', md5='" + this.md5 + "', url='" + this.url + "'}";
    }

    AEResBeanWrapper(AEResManagerConfigBean.AEResBean aEResBean, String str, String str2, String str3, String str4, String str5, String str6) {
        this.originBean = aEResBean;
        this.agentType = str;
        this.bundleName = str2;
        this.md5 = str3;
        this.url = str4;
        this.highPriority = false;
        this.backupMd5 = str5;
        this.backupUrl = str6;
        this.version = AEResManagerConfigBean.DEFAULT_VERSION;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AEResBeanWrapper(AEResManagerConfigBean.AEResBean aEResBean, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.originBean = aEResBean;
        this.agentType = str;
        this.bundleName = str2;
        this.md5 = str3;
        this.url = str4;
        this.highPriority = false;
        this.backupMd5 = str5;
        this.backupUrl = str6;
        this.version = str7;
    }
}
