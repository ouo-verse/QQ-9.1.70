package com.tencent.mobileqq.data.qzone;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "ownerUin")
/* loaded from: classes10.dex */
public class FeedInfo extends Entity {
    public int appid;
    public String content;
    public long feedTime;
    public int hasPic;

    @notColumn
    public boolean isExpose;
    public long ownerUin;
    public boolean showInTab = true;
    public String strImgUrl;
    public String strkey;
    public int typeId;

    public String toString() {
        return "ownerUin:" + this.ownerUin + "  appid:" + this.appid + "  typeid:" + this.typeId + "  feedTime:" + this.feedTime + "  strKey:" + this.strkey + "  hasPic:" + this.hasPic + "  content:" + this.content + "  strImgUrl:" + this.strImgUrl;
    }
}
