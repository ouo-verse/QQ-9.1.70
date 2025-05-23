package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stDramaInfo extends JceStruct {
    public String coverImg;
    public int curPublishedFeedNum;
    public String curWatchedFeedID;
    public int curWatchedFeedNum;

    /* renamed from: id, reason: collision with root package name */
    public String f25116id;
    public boolean isFollowed;
    public boolean isPublishCompleted;
    public String name;
    public long playCount;
    public String recmdDesc;
    public String tag;

    public stDramaInfo() {
        this.f25116id = "";
        this.name = "";
        this.recmdDesc = "";
        this.coverImg = "";
        this.tag = "";
        this.isPublishCompleted = true;
        this.isFollowed = true;
        this.playCount = 0L;
        this.curPublishedFeedNum = 0;
        this.curWatchedFeedNum = 0;
        this.curWatchedFeedID = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f25116id = jceInputStream.readString(0, false);
        this.name = jceInputStream.readString(1, false);
        this.recmdDesc = jceInputStream.readString(2, false);
        this.coverImg = jceInputStream.readString(3, false);
        this.tag = jceInputStream.readString(4, false);
        this.isPublishCompleted = jceInputStream.read(this.isPublishCompleted, 5, false);
        this.isFollowed = jceInputStream.read(this.isFollowed, 6, false);
        this.playCount = jceInputStream.read(this.playCount, 7, false);
        this.curPublishedFeedNum = jceInputStream.read(this.curPublishedFeedNum, 8, false);
        this.curWatchedFeedNum = jceInputStream.read(this.curWatchedFeedNum, 9, false);
        this.curWatchedFeedID = jceInputStream.readString(10, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.f25116id;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.name;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.recmdDesc;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.coverImg;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
        String str5 = this.tag;
        if (str5 != null) {
            jceOutputStream.write(str5, 4);
        }
        jceOutputStream.write(this.isPublishCompleted, 5);
        jceOutputStream.write(this.isFollowed, 6);
        jceOutputStream.write(this.playCount, 7);
        jceOutputStream.write(this.curPublishedFeedNum, 8);
        jceOutputStream.write(this.curWatchedFeedNum, 9);
        String str6 = this.curWatchedFeedID;
        if (str6 != null) {
            jceOutputStream.write(str6, 10);
        }
    }

    public stDramaInfo(String str, String str2, String str3, String str4, String str5, boolean z16, boolean z17, long j3, int i3, int i16, String str6) {
        this.f25116id = str;
        this.name = str2;
        this.recmdDesc = str3;
        this.coverImg = str4;
        this.tag = str5;
        this.isPublishCompleted = z16;
        this.isFollowed = z17;
        this.playCount = j3;
        this.curPublishedFeedNum = i3;
        this.curWatchedFeedNum = i16;
        this.curWatchedFeedID = str6;
    }
}
