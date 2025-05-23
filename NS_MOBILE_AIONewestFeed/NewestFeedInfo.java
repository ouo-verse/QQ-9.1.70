package NS_MOBILE_AIONewestFeed;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class NewestFeedInfo extends JceStruct {
    static Map<String, String> cache_mapEx;
    static ArrayList<Media_Data> cache_mediaData = new ArrayList<>();
    public Map<String, String> mapEx;
    public ArrayList<Media_Data> mediaData;
    public String strContent;
    public String strImgUrl;
    public String strJmpUrl;
    public String strLBSInfo;
    public String strSummary;
    public String strTitle;
    public long uAppid;
    public long uCommentNum;
    public long uHostUin;
    public long uImgCount;
    public long uLikeNum;
    public long uTime;

    static {
        cache_mediaData.add(new Media_Data());
        HashMap hashMap = new HashMap();
        cache_mapEx = hashMap;
        hashMap.put("", "");
    }

    public NewestFeedInfo() {
        this.uAppid = 0L;
        this.uHostUin = 0L;
        this.uTime = 0L;
        this.strLBSInfo = "";
        this.strSummary = "";
        this.strTitle = "";
        this.strContent = "";
        this.strImgUrl = "";
        this.uImgCount = 0L;
        this.strJmpUrl = "";
        this.mediaData = null;
        this.uLikeNum = 0L;
        this.uCommentNum = 0L;
        this.mapEx = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uAppid = jceInputStream.read(this.uAppid, 0, false);
        this.uHostUin = jceInputStream.read(this.uHostUin, 1, false);
        this.uTime = jceInputStream.read(this.uTime, 2, false);
        this.strLBSInfo = jceInputStream.readString(3, false);
        this.strSummary = jceInputStream.readString(4, false);
        this.strTitle = jceInputStream.readString(5, false);
        this.strContent = jceInputStream.readString(6, false);
        this.strImgUrl = jceInputStream.readString(7, false);
        this.uImgCount = jceInputStream.read(this.uImgCount, 8, false);
        this.strJmpUrl = jceInputStream.readString(9, false);
        this.mediaData = (ArrayList) jceInputStream.read((JceInputStream) cache_mediaData, 10, false);
        this.uLikeNum = jceInputStream.read(this.uLikeNum, 11, false);
        this.uCommentNum = jceInputStream.read(this.uCommentNum, 12, false);
        this.mapEx = (Map) jceInputStream.read((JceInputStream) cache_mapEx, 13, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uAppid, 0);
        jceOutputStream.write(this.uHostUin, 1);
        jceOutputStream.write(this.uTime, 2);
        String str = this.strLBSInfo;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        String str2 = this.strSummary;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        String str3 = this.strTitle;
        if (str3 != null) {
            jceOutputStream.write(str3, 5);
        }
        String str4 = this.strContent;
        if (str4 != null) {
            jceOutputStream.write(str4, 6);
        }
        String str5 = this.strImgUrl;
        if (str5 != null) {
            jceOutputStream.write(str5, 7);
        }
        jceOutputStream.write(this.uImgCount, 8);
        String str6 = this.strJmpUrl;
        if (str6 != null) {
            jceOutputStream.write(str6, 9);
        }
        ArrayList<Media_Data> arrayList = this.mediaData;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 10);
        }
        jceOutputStream.write(this.uLikeNum, 11);
        jceOutputStream.write(this.uCommentNum, 12);
        Map<String, String> map = this.mapEx;
        if (map != null) {
            jceOutputStream.write((Map) map, 13);
        }
    }

    public NewestFeedInfo(long j3, long j16, long j17, String str, String str2, String str3, String str4, String str5, long j18, String str6, ArrayList<Media_Data> arrayList, long j19, long j26, Map<String, String> map) {
        this.uAppid = j3;
        this.uHostUin = j16;
        this.uTime = j17;
        this.strLBSInfo = str;
        this.strSummary = str2;
        this.strTitle = str3;
        this.strContent = str4;
        this.strImgUrl = str5;
        this.uImgCount = j18;
        this.strJmpUrl = str6;
        this.mediaData = arrayList;
        this.uLikeNum = j19;
        this.uCommentNum = j26;
        this.mapEx = map;
    }
}
