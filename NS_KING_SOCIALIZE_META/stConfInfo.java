package NS_KING_SOCIALIZE_META;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stConfInfo extends JceStruct {
    public long bubbleEndTime;
    public long bubbleStartTime;
    public long collectTime;
    public int defaultFeedPosition;
    public int defaultTogetherFeed;
    public int exclusive;
    public int feedUseType;
    public String followFeed;
    public long iStartPos;
    public int iType;
    public int isCollected;
    public String strLabel;
    public String togetherFeed;
    public int togetherType;
    public int useCount;

    public stConfInfo() {
        this.iType = 0;
        this.iStartPos = 0L;
        this.strLabel = "";
        this.isCollected = 0;
        this.collectTime = 0L;
        this.exclusive = 0;
        this.followFeed = "";
        this.useCount = 0;
        this.togetherFeed = "";
        this.togetherType = 0;
        this.feedUseType = 0;
        this.defaultFeedPosition = 0;
        this.defaultTogetherFeed = 0;
        this.bubbleStartTime = 0L;
        this.bubbleEndTime = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iType = jceInputStream.read(this.iType, 0, false);
        this.iStartPos = jceInputStream.read(this.iStartPos, 1, false);
        this.strLabel = jceInputStream.readString(2, false);
        this.isCollected = jceInputStream.read(this.isCollected, 3, false);
        this.collectTime = jceInputStream.read(this.collectTime, 4, false);
        this.exclusive = jceInputStream.read(this.exclusive, 5, false);
        this.followFeed = jceInputStream.readString(6, false);
        this.useCount = jceInputStream.read(this.useCount, 7, false);
        this.togetherFeed = jceInputStream.readString(8, false);
        this.togetherType = jceInputStream.read(this.togetherType, 9, false);
        this.feedUseType = jceInputStream.read(this.feedUseType, 10, false);
        this.defaultFeedPosition = jceInputStream.read(this.defaultFeedPosition, 11, false);
        this.defaultTogetherFeed = jceInputStream.read(this.defaultTogetherFeed, 12, false);
        this.bubbleStartTime = jceInputStream.read(this.bubbleStartTime, 13, false);
        this.bubbleEndTime = jceInputStream.read(this.bubbleEndTime, 14, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iType, 0);
        jceOutputStream.write(this.iStartPos, 1);
        String str = this.strLabel;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        jceOutputStream.write(this.isCollected, 3);
        jceOutputStream.write(this.collectTime, 4);
        jceOutputStream.write(this.exclusive, 5);
        String str2 = this.followFeed;
        if (str2 != null) {
            jceOutputStream.write(str2, 6);
        }
        jceOutputStream.write(this.useCount, 7);
        String str3 = this.togetherFeed;
        if (str3 != null) {
            jceOutputStream.write(str3, 8);
        }
        jceOutputStream.write(this.togetherType, 9);
        jceOutputStream.write(this.feedUseType, 10);
        jceOutputStream.write(this.defaultFeedPosition, 11);
        jceOutputStream.write(this.defaultTogetherFeed, 12);
        jceOutputStream.write(this.bubbleStartTime, 13);
        jceOutputStream.write(this.bubbleEndTime, 14);
    }

    public stConfInfo(int i3, long j3, String str, int i16, long j16, int i17, String str2, int i18, String str3, int i19, int i26, int i27, int i28, long j17, long j18) {
        this.iType = i3;
        this.iStartPos = j3;
        this.strLabel = str;
        this.isCollected = i16;
        this.collectTime = j16;
        this.exclusive = i17;
        this.followFeed = str2;
        this.useCount = i18;
        this.togetherFeed = str3;
        this.togetherType = i19;
        this.feedUseType = i26;
        this.defaultFeedPosition = i27;
        this.defaultTogetherFeed = i28;
        this.bubbleStartTime = j17;
        this.bubbleEndTime = j18;
    }
}
