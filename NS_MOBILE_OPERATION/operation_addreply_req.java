package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class operation_addreply_req extends JceStruct {
    static Map<Integer, String> cache_busi_param = new HashMap();
    static Map<String, String> cache_bypass_param;
    static MediaInfo cache_mediainfo;
    public int appid;
    public Map<Integer, String> busi_param;
    public Map<String, String> bypass_param;
    public String commentid;
    public long commentuin;
    public String content;
    public int isverified;
    public int mediabittype;
    public MediaInfo mediainfo;
    public long ownuin;
    public String srcId;
    public long uin;

    static {
        cache_busi_param.put(0, "");
        cache_mediainfo = new MediaInfo();
        HashMap hashMap = new HashMap();
        cache_bypass_param = hashMap;
        hashMap.put("", "");
    }

    public operation_addreply_req() {
        this.appid = 0;
        this.uin = 0L;
        this.ownuin = 0L;
        this.commentuin = 0L;
        this.srcId = "";
        this.commentid = "";
        this.content = "";
        this.isverified = 0;
        this.busi_param = null;
        this.mediainfo = null;
        this.mediabittype = 0;
        this.bypass_param = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.appid = jceInputStream.read(this.appid, 0, false);
        this.uin = jceInputStream.read(this.uin, 1, false);
        this.ownuin = jceInputStream.read(this.ownuin, 2, false);
        this.commentuin = jceInputStream.read(this.commentuin, 3, false);
        this.srcId = jceInputStream.readString(4, false);
        this.commentid = jceInputStream.readString(5, false);
        this.content = jceInputStream.readString(6, false);
        this.isverified = jceInputStream.read(this.isverified, 7, false);
        this.busi_param = (Map) jceInputStream.read((JceInputStream) cache_busi_param, 8, false);
        this.mediainfo = (MediaInfo) jceInputStream.read((JceStruct) cache_mediainfo, 9, false);
        this.mediabittype = jceInputStream.read(this.mediabittype, 10, false);
        this.bypass_param = (Map) jceInputStream.read((JceInputStream) cache_bypass_param, 11, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.appid, 0);
        jceOutputStream.write(this.uin, 1);
        jceOutputStream.write(this.ownuin, 2);
        jceOutputStream.write(this.commentuin, 3);
        String str = this.srcId;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
        String str2 = this.commentid;
        if (str2 != null) {
            jceOutputStream.write(str2, 5);
        }
        String str3 = this.content;
        if (str3 != null) {
            jceOutputStream.write(str3, 6);
        }
        jceOutputStream.write(this.isverified, 7);
        Map<Integer, String> map = this.busi_param;
        if (map != null) {
            jceOutputStream.write((Map) map, 8);
        }
        MediaInfo mediaInfo = this.mediainfo;
        if (mediaInfo != null) {
            jceOutputStream.write((JceStruct) mediaInfo, 9);
        }
        jceOutputStream.write(this.mediabittype, 10);
        Map<String, String> map2 = this.bypass_param;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 11);
        }
    }

    public operation_addreply_req(int i3, long j3, long j16, long j17, String str, String str2, String str3, int i16, Map<Integer, String> map, MediaInfo mediaInfo, int i17, Map<String, String> map2) {
        this.appid = i3;
        this.uin = j3;
        this.ownuin = j16;
        this.commentuin = j17;
        this.srcId = str;
        this.commentid = str2;
        this.content = str3;
        this.isverified = i16;
        this.busi_param = map;
        this.mediainfo = mediaInfo;
        this.mediabittype = i17;
        this.bypass_param = map2;
    }
}
