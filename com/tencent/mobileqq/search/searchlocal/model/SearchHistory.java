package com.tencent.mobileqq.search.searchlocal.model;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qqnt.kernel.nativeinterface.cq;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SearchHistory extends Entity {
    public int count;
    public String displayName;
    public String extralInfo;

    @unique
    public String key;
    public long time;
    public String troopUin;
    public int type;
    public String uin;

    @NonNull
    public String toString() {
        return "SearchHistory{ id:" + getId() + " key:" + cq.w(this.key, 2) + " type:" + this.type + " uin:" + this.uin + " troopUin:" + this.troopUin + " displayName:" + cq.w(this.displayName, 2) + " count:" + this.count + " time:" + this.time + "(" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(this.time)) + ") }";
    }
}
