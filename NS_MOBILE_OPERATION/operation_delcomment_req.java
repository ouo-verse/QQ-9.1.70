package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class operation_delcomment_req extends JceStruct {
    static Map<String, String> cache_bypass_param;
    static Map<Integer, String> cache_mapBusiParam = new HashMap();
    public Map<String, String> bypass_param;
    public String ciphertext;
    public long iAppID;
    public long iCommentUin;
    public int iDelSource;
    public long iSrcUin;
    public Map<Integer, String> mapBusiParam;
    public String strCommentID;
    public String strCommentUinOpenid;
    public String strSrcID;
    public String strSrcUinOpenid;

    static {
        cache_mapBusiParam.put(0, "");
        HashMap hashMap = new HashMap();
        cache_bypass_param = hashMap;
        hashMap.put("", "");
    }

    public operation_delcomment_req() {
        this.iAppID = 0L;
        this.iSrcUin = 0L;
        this.strSrcID = "";
        this.iCommentUin = 0L;
        this.strCommentID = "";
        this.iDelSource = 0;
        this.mapBusiParam = null;
        this.strSrcUinOpenid = "";
        this.strCommentUinOpenid = "";
        this.ciphertext = "";
        this.bypass_param = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iAppID = jceInputStream.read(this.iAppID, 0, true);
        this.iSrcUin = jceInputStream.read(this.iSrcUin, 1, true);
        this.strSrcID = jceInputStream.readString(2, true);
        this.iCommentUin = jceInputStream.read(this.iCommentUin, 3, true);
        this.strCommentID = jceInputStream.readString(4, true);
        this.iDelSource = jceInputStream.read(this.iDelSource, 5, true);
        this.mapBusiParam = (Map) jceInputStream.read((JceInputStream) cache_mapBusiParam, 6, true);
        this.strSrcUinOpenid = jceInputStream.readString(7, false);
        this.strCommentUinOpenid = jceInputStream.readString(8, false);
        this.ciphertext = jceInputStream.readString(9, false);
        this.bypass_param = (Map) jceInputStream.read((JceInputStream) cache_bypass_param, 10, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iAppID, 0);
        jceOutputStream.write(this.iSrcUin, 1);
        String str = this.strSrcID;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        jceOutputStream.write(this.iCommentUin, 3);
        String str2 = this.strCommentID;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        jceOutputStream.write(this.iDelSource, 5);
        jceOutputStream.write((Map) this.mapBusiParam, 6);
        String str3 = this.strSrcUinOpenid;
        if (str3 != null) {
            jceOutputStream.write(str3, 7);
        }
        String str4 = this.strCommentUinOpenid;
        if (str4 != null) {
            jceOutputStream.write(str4, 8);
        }
        String str5 = this.ciphertext;
        if (str5 != null) {
            jceOutputStream.write(str5, 9);
        }
        Map<String, String> map = this.bypass_param;
        if (map != null) {
            jceOutputStream.write((Map) map, 10);
        }
    }

    public operation_delcomment_req(long j3, long j16, String str, long j17, String str2, int i3, Map<Integer, String> map, String str3, String str4, String str5, Map<String, String> map2) {
        this.iAppID = j3;
        this.iSrcUin = j16;
        this.strSrcID = str;
        this.iCommentUin = j17;
        this.strCommentID = str2;
        this.iDelSource = i3;
        this.mapBusiParam = map;
        this.strSrcUinOpenid = str3;
        this.strCommentUinOpenid = str4;
        this.ciphertext = str5;
        this.bypass_param = map2;
    }
}
