package com.tencent.mobileqq.mini.apkgEntity;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "link,linkType")
/* loaded from: classes33.dex */
public class MiniAppInfoByLinkEntity extends Entity {
    public byte[] appInfo;
    public String link;
    public int linkType;
    public String shareTicket;
    public long timeStamp;

    public String toString() {
        return "MiniAppInfoByLinkEntity{link='" + this.link + "'linkType='" + this.linkType + "'linkType='" + this.shareTicket + "', timeStamp='" + this.timeStamp + "'}";
    }
}
