package NS_MOBILE_QUN;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_quote_photo_info extends JceStruct {
    static Map<Integer, String> cache_mapAttr;
    public long chatDstUin;
    public long chatSrcUin;
    public String clientkey;
    public long groupUin;
    public Map<Integer, String> mapAttr;
    public long msgtime;
    public long qunPicFileID;
    public long upload_time;
    public String url;
    public String uuid;

    public s_quote_photo_info() {
        this.url = "";
        this.clientkey = "";
        this.uuid = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.url = jceInputStream.readString(0, false);
        this.clientkey = jceInputStream.readString(1, false);
        this.uuid = jceInputStream.readString(2, false);
        this.msgtime = jceInputStream.read(this.msgtime, 3, false);
        this.groupUin = jceInputStream.read(this.groupUin, 4, false);
        this.upload_time = jceInputStream.read(this.upload_time, 5, false);
        this.chatSrcUin = jceInputStream.read(this.chatSrcUin, 6, false);
        this.chatDstUin = jceInputStream.read(this.chatDstUin, 7, false);
        this.qunPicFileID = jceInputStream.read(this.qunPicFileID, 8, false);
        if (cache_mapAttr == null) {
            cache_mapAttr = new HashMap();
            cache_mapAttr.put(0, "");
        }
        this.mapAttr = (Map) jceInputStream.read((JceInputStream) cache_mapAttr, 9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.url;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.clientkey;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.uuid;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        jceOutputStream.write(this.msgtime, 3);
        jceOutputStream.write(this.groupUin, 4);
        jceOutputStream.write(this.upload_time, 5);
        jceOutputStream.write(this.chatSrcUin, 6);
        jceOutputStream.write(this.chatDstUin, 7);
        jceOutputStream.write(this.qunPicFileID, 8);
        Map<Integer, String> map = this.mapAttr;
        if (map != null) {
            jceOutputStream.write((Map) map, 9);
        }
    }

    public s_quote_photo_info(String str, String str2, String str3, long j3, long j16, long j17, long j18, long j19, long j26, Map<Integer, String> map) {
        this.url = str;
        this.clientkey = str2;
        this.uuid = str3;
        this.msgtime = j3;
        this.groupUin = j16;
        this.upload_time = j17;
        this.chatSrcUin = j18;
        this.chatDstUin = j19;
        this.qunPicFileID = j26;
        this.mapAttr = map;
    }
}
