package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class share_outsite_req extends JceStruct {
    static Map<Integer, String> cache_busi_param = new HashMap();
    public String albumid;
    public int appid;
    public String batchid;
    public Map<Integer, String> busi_param;
    public String cellid;
    public int iIsShareTo;
    public String lloc;
    public int shareScene;
    public String strMd5Key;
    public long uHostUin;
    public int ugc_type;

    static {
        cache_busi_param.put(0, "");
    }

    public share_outsite_req() {
        this.appid = 0;
        this.cellid = "";
        this.ugc_type = 0;
        this.albumid = "";
        this.lloc = "";
        this.batchid = "";
        this.uHostUin = 0L;
        this.iIsShareTo = 0;
        this.strMd5Key = "";
        this.shareScene = 0;
        this.busi_param = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.appid = jceInputStream.read(this.appid, 0, false);
        this.cellid = jceInputStream.readString(1, false);
        this.ugc_type = jceInputStream.read(this.ugc_type, 2, false);
        this.albumid = jceInputStream.readString(3, false);
        this.lloc = jceInputStream.readString(4, false);
        this.batchid = jceInputStream.readString(5, false);
        this.uHostUin = jceInputStream.read(this.uHostUin, 6, false);
        this.iIsShareTo = jceInputStream.read(this.iIsShareTo, 7, false);
        this.strMd5Key = jceInputStream.readString(8, false);
        this.shareScene = jceInputStream.read(this.shareScene, 9, false);
        this.busi_param = (Map) jceInputStream.read((JceInputStream) cache_busi_param, 10, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.appid, 0);
        String str = this.cellid;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.ugc_type, 2);
        String str2 = this.albumid;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        String str3 = this.lloc;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
        String str4 = this.batchid;
        if (str4 != null) {
            jceOutputStream.write(str4, 5);
        }
        jceOutputStream.write(this.uHostUin, 6);
        jceOutputStream.write(this.iIsShareTo, 7);
        String str5 = this.strMd5Key;
        if (str5 != null) {
            jceOutputStream.write(str5, 8);
        }
        jceOutputStream.write(this.shareScene, 9);
        Map<Integer, String> map = this.busi_param;
        if (map != null) {
            jceOutputStream.write((Map) map, 10);
        }
    }

    public share_outsite_req(int i3, String str, int i16, String str2, String str3, String str4, long j3, int i17, String str5, int i18, Map<Integer, String> map) {
        this.appid = i3;
        this.cellid = str;
        this.ugc_type = i16;
        this.albumid = str2;
        this.lloc = str3;
        this.batchid = str4;
        this.uHostUin = j3;
        this.iIsShareTo = i17;
        this.strMd5Key = str5;
        this.shareScene = i18;
        this.busi_param = map;
    }
}
