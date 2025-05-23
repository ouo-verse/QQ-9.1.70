package com.tencent.mobileqq.mini.apkgEntity;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import java.util.Arrays;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "link,linkType")
@Deprecated
/* loaded from: classes33.dex */
public class MiniAppByLinkEntity extends Entity {
    public String appId;
    public String extData;
    public byte[] extInfo;
    public String extendData;
    public byte[] first;
    public String link;
    public int linkType;
    public byte[] mDebug;
    public byte[] operInfo;
    public String prepayId;
    public String shareTicket;
    public long timeStamp;

    public String toString() {
        return "MiniAppByLinkEntity{link='" + this.link + "', linkType=" + this.linkType + ", appId='" + this.appId + "', timeStamp='" + this.timeStamp + "', shareTicket='" + this.shareTicket + "', first=" + Arrays.toString(this.first) + ", mDebug=" + Arrays.toString(this.mDebug) + ", extData='" + this.extData + "', operInfo=" + Arrays.toString(this.operInfo) + ", extInfo=" + Arrays.toString(this.extInfo) + ", extendData='" + this.extendData + "', prepayId='" + this.prepayId + "'}";
    }
}
