package com.tencent.mobileqq.data;

import com.tencent.qqnt.kernel.nativeinterface.CommonTabEmojiInfo;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class EmoticonResp {
    public List data;
    public int delEpId;
    public List<CommonTabEmojiInfo> emojiNewTabs;
    public String emoticonId;
    public int epId;
    public List<Integer> ids;
    public String keySeq;
    public List<EmoticonPackage> magicData;
    public boolean resetKeywordExpose;
    public int resultcode;
    public List<EmoticonPackage> smallEmoticonData;
    public List<String> tabOrderList;
    public String timeoutReason;
    public int timestamp;

    public String toString() {
        return "EmoticonResp{epId=" + this.epId + ", data=" + this.data + ", timestamp=" + this.timestamp + ", resultcode=" + this.resultcode + ", keySeq='" + this.keySeq + "', timeoutReason='" + this.timeoutReason + "', delEpId=" + this.delEpId + ", emoticonId='" + this.emoticonId + "'}";
    }
}
