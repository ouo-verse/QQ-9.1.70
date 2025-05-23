package com.tencent.biz.qqcircle.tedgers2.bean;

import com.tencent.mobileqq.persistence.Entity;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSRerankDbEntity extends Entity {
    public long insertTime = 0;
    public String dataType = "";
    public String dataId = "";
    public byte[] data = new byte[0];
    public String ext1 = "";
    public String ext2 = "";
    public String ext3 = "";
    public String ext4 = "";

    public String toString() {
        return "QFSRerankDbEntity{insertTime=" + this.insertTime + ", dataType='" + this.dataType + "', dataId='" + this.dataId + "', data=" + Arrays.toString(this.data) + ", ext1='" + this.ext1 + "', ext2='" + this.ext2 + "', ext3='" + this.ext3 + "', ext4='" + this.ext4 + "'}";
    }
}
