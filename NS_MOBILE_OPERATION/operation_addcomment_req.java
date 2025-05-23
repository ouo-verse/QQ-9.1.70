package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class operation_addcomment_req extends JceStruct {
    static Map<Integer, String> cache_busi_param = new HashMap();
    static Map<String, String> cache_bypass_param;
    static Map<String, byte[]> cache_bypass_param_binary;
    static MediaInfo cache_mediainfo;
    public int appid;
    public Map<Integer, String> busi_param;
    public Map<String, String> bypass_param;
    public Map<String, byte[]> bypass_param_binary;
    public String content;
    public int isPrivateComment;
    public int isverified;
    public int mediabittype;
    public MediaInfo mediainfo;
    public long ownuin;
    public String srcId;
    public String srcSubid;
    public long uin;

    static {
        cache_busi_param.put(0, "");
        cache_mediainfo = new MediaInfo();
        HashMap hashMap = new HashMap();
        cache_bypass_param = hashMap;
        hashMap.put("", "");
        HashMap hashMap2 = new HashMap();
        cache_bypass_param_binary = hashMap2;
        hashMap2.put("", new byte[]{0});
    }

    public operation_addcomment_req() {
        this.appid = 0;
        this.uin = 0L;
        this.ownuin = 0L;
        this.srcId = "";
        this.content = "";
        this.isverified = 0;
        this.busi_param = null;
        this.srcSubid = "";
        this.mediainfo = null;
        this.mediabittype = 0;
        this.isPrivateComment = 0;
        this.bypass_param = null;
        this.bypass_param_binary = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.appid = jceInputStream.read(this.appid, 0, false);
        this.uin = jceInputStream.read(this.uin, 1, false);
        this.ownuin = jceInputStream.read(this.ownuin, 2, false);
        this.srcId = jceInputStream.readString(3, false);
        this.content = jceInputStream.readString(4, false);
        this.isverified = jceInputStream.read(this.isverified, 5, false);
        this.busi_param = (Map) jceInputStream.read((JceInputStream) cache_busi_param, 6, false);
        this.srcSubid = jceInputStream.readString(7, false);
        this.mediainfo = (MediaInfo) jceInputStream.read((JceStruct) cache_mediainfo, 8, false);
        this.mediabittype = jceInputStream.read(this.mediabittype, 9, false);
        this.isPrivateComment = jceInputStream.read(this.isPrivateComment, 10, false);
        this.bypass_param = (Map) jceInputStream.read((JceInputStream) cache_bypass_param, 11, false);
        this.bypass_param_binary = (Map) jceInputStream.read((JceInputStream) cache_bypass_param_binary, 12, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.appid, 0);
        jceOutputStream.write(this.uin, 1);
        jceOutputStream.write(this.ownuin, 2);
        String str = this.srcId;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        String str2 = this.content;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        jceOutputStream.write(this.isverified, 5);
        Map<Integer, String> map = this.busi_param;
        if (map != null) {
            jceOutputStream.write((Map) map, 6);
        }
        String str3 = this.srcSubid;
        if (str3 != null) {
            jceOutputStream.write(str3, 7);
        }
        MediaInfo mediaInfo = this.mediainfo;
        if (mediaInfo != null) {
            jceOutputStream.write((JceStruct) mediaInfo, 8);
        }
        jceOutputStream.write(this.mediabittype, 9);
        jceOutputStream.write(this.isPrivateComment, 10);
        Map<String, String> map2 = this.bypass_param;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 11);
        }
        Map<String, byte[]> map3 = this.bypass_param_binary;
        if (map3 != null) {
            jceOutputStream.write((Map) map3, 12);
        }
    }

    public operation_addcomment_req(int i3, long j3, long j16, String str, String str2, int i16, Map<Integer, String> map, String str3, MediaInfo mediaInfo, int i17, int i18, Map<String, String> map2, Map<String, byte[]> map3) {
        this.appid = i3;
        this.uin = j3;
        this.ownuin = j16;
        this.srcId = str;
        this.content = str2;
        this.isverified = i16;
        this.busi_param = map;
        this.srcSubid = str3;
        this.mediainfo = mediaInfo;
        this.mediabittype = i17;
        this.isPrivateComment = i18;
        this.bypass_param = map2;
        this.bypass_param_binary = map3;
    }
}
