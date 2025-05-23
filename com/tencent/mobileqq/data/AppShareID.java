package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

/* compiled from: P */
/* loaded from: classes10.dex */
public class AppShareID extends Entity {
    public String appstorelink;
    public String bundleid;
    public String messagetail;
    public String officalwebsite;
    public short sLanType;
    public short sPriority;
    public short sResType;
    public String sourceUrl;

    @unique
    public String strPkgName;
    public String strResDesc;
    public String strResName;
    public String strResURLBig;
    public String strResURLSmall;
    public long uiNewVer;

    @unique
    public long uiResID;
    public long updateTime;

    public String toString() {
        StringBuilder sb5 = new StringBuilder(200);
        sb5.append("[strPkgName = ");
        sb5.append(this.strPkgName);
        sb5.append("; uiResID = ");
        sb5.append(this.uiResID);
        sb5.append("; uiNewVer = ");
        sb5.append(this.uiNewVer);
        sb5.append("; messagetail = ");
        sb5.append(this.messagetail);
        sb5.append("; bundleid = ");
        sb5.append(this.bundleid);
        sb5.append("; sourceUrl = ");
        sb5.append(this.sourceUrl);
        sb5.append("]");
        return sb5.toString();
    }
}
