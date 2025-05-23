package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes10.dex */
public class TroopFileData extends Entity implements Serializable {
    public static final long serialVersionUID = 0;
    public int duration;
    public long entitySessionId;
    public int fromScene;
    public int height;
    public int width;
    public String yybApkIconUrl;
    public String yybApkName;
    public String yybApkPackageName;
    public String dspFileSize = null;
    public String dspFileName = null;
    public int bisID = 0;

    @unique
    public String fileUrl = null;
    public String sha1 = null;
    public String md5 = null;
    public String fileName = null;
    public long lfileSize = 0;
    public String uuid = null;
    public String FromUin = null;
    public long lastTime = 0;

    public String toString() {
        return "TroopFileData{dspFileSize='" + this.dspFileSize + "', dspFileName='" + this.dspFileName + "', bisID=" + this.bisID + ", fileUrl='" + this.fileUrl + "', fileName='" + this.fileName + "', lfileSize=" + this.lfileSize + ", uuid='" + this.uuid + "', fromUin='" + this.FromUin + "', lastTime=" + this.lastTime + ", entitySessionId=" + this.entitySessionId + "39, fromScene=" + this.fromScene + '}';
    }
}
