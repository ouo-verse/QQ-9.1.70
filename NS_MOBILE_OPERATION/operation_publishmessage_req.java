package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class operation_publishmessage_req extends JceStruct {
    static Map<Integer, String> cache_busi_param;
    static MediaInfo cache_mediainfo;
    public Map<Integer, String> busi_param;
    public String content;
    public int iMsgType;
    public boolean isverified;
    public int mediabittype;
    public MediaInfo mediainfo;
    public long ownuin;
    public long uin;

    public operation_publishmessage_req() {
        this.content = "";
        this.isverified = true;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        this.ownuin = jceInputStream.read(this.ownuin, 1, false);
        this.content = jceInputStream.readString(2, false);
        this.isverified = jceInputStream.read(this.isverified, 3, false);
        this.mediabittype = jceInputStream.read(this.mediabittype, 4, false);
        if (cache_mediainfo == null) {
            cache_mediainfo = new MediaInfo();
        }
        this.mediainfo = (MediaInfo) jceInputStream.read((JceStruct) cache_mediainfo, 5, false);
        if (cache_busi_param == null) {
            cache_busi_param = new HashMap();
            cache_busi_param.put(0, "");
        }
        this.busi_param = (Map) jceInputStream.read((JceInputStream) cache_busi_param, 6, false);
        this.iMsgType = jceInputStream.read(this.iMsgType, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.ownuin, 1);
        String str = this.content;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        jceOutputStream.write(this.isverified, 3);
        jceOutputStream.write(this.mediabittype, 4);
        MediaInfo mediaInfo = this.mediainfo;
        if (mediaInfo != null) {
            jceOutputStream.write((JceStruct) mediaInfo, 5);
        }
        Map<Integer, String> map = this.busi_param;
        if (map != null) {
            jceOutputStream.write((Map) map, 6);
        }
        jceOutputStream.write(this.iMsgType, 7);
    }

    public operation_publishmessage_req(long j3, long j16, String str, boolean z16, int i3, MediaInfo mediaInfo, Map<Integer, String> map, int i16) {
        this.uin = j3;
        this.ownuin = j16;
        this.content = str;
        this.isverified = z16;
        this.mediabittype = i3;
        this.mediainfo = mediaInfo;
        this.busi_param = map;
        this.iMsgType = i16;
    }
}
