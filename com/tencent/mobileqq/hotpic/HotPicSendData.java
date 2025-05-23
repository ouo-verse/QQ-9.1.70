package com.tencent.mobileqq.hotpic;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "md5")
/* loaded from: classes9.dex */
public class HotPicSendData extends HotPicData implements Comparable<HotPicSendData> {
    static IPatchRedirector $redirector_;
    public long sendTime;

    public HotPicSendData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static HotPicSendData build(HotPicData hotPicData) {
        HotPicSendData hotPicSendData = new HotPicSendData();
        hotPicSendData.md5 = hotPicData.md5;
        hotPicSendData.fileType = hotPicData.fileType;
        hotPicSendData.fileSize = hotPicData.fileSize;
        hotPicSendData.width = hotPicData.width;
        hotPicSendData.height = hotPicData.height;
        hotPicSendData.url = hotPicData.url;
        hotPicSendData.picIndex = hotPicData.picIndex;
        hotPicSendData.sourceType = hotPicData.sourceType;
        hotPicSendData.appid = hotPicData.appid;
        hotPicSendData.iconUrl = hotPicData.iconUrl;
        hotPicSendData.name = hotPicData.name;
        hotPicSendData.filePath = hotPicData.filePath;
        hotPicSendData.version = hotPicData.version;
        hotPicSendData.originalMD5 = hotPicData.originalMD5;
        hotPicSendData.oringinalSize = hotPicData.oringinalSize;
        hotPicSendData.originalWidth = hotPicData.originalWidth;
        hotPicSendData.originalHeight = hotPicData.originalHeight;
        hotPicSendData.originalUrl = hotPicData.originalUrl;
        hotPicSendData.tag = -20;
        return hotPicSendData;
    }

    @Override // java.lang.Comparable
    public int compareTo(HotPicSendData hotPicSendData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) hotPicSendData)).intValue();
        }
        long j3 = this.sendTime;
        long j16 = hotPicSendData.sendTime;
        if (j3 > j16) {
            return 1;
        }
        return j3 == j16 ? 0 : -1;
    }
}
