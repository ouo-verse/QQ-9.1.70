package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class operation_delreply_req extends JceStruct {
    static Map<String, String> cache_bypass_param;
    static Map<Integer, String> cache_mapBusiParam = new HashMap();
    public Map<String, String> bypass_param;
    public String ciphertext;
    public long iAppID;
    public long iCommentUin;
    public int iDelSource;
    public long iReplyUin;
    public long iSrcUin;
    public Map<Integer, String> mapBusiParam;
    public String strCommentID;
    public String strCommentUinOpenid;
    public String strReplyID;
    public String strReplyUinOpenid;
    public String strSrcID;
    public String strSrcUinOpenid;

    static {
        cache_mapBusiParam.put(0, "");
        HashMap hashMap = new HashMap();
        cache_bypass_param = hashMap;
        hashMap.put("", "");
    }

    public operation_delreply_req() {
        this.iAppID = 0L;
        this.iSrcUin = 0L;
        this.strSrcID = "";
        this.iCommentUin = 0L;
        this.strCommentID = "";
        this.iReplyUin = 0L;
        this.strReplyID = "";
        this.iDelSource = 0;
        this.mapBusiParam = null;
        this.strSrcUinOpenid = "";
        this.strCommentUinOpenid = "";
        this.strReplyUinOpenid = "";
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
        this.iReplyUin = jceInputStream.read(this.iReplyUin, 5, true);
        this.strReplyID = jceInputStream.readString(6, true);
        this.iDelSource = jceInputStream.read(this.iDelSource, 7, true);
        this.mapBusiParam = (Map) jceInputStream.read((JceInputStream) cache_mapBusiParam, 8, true);
        this.strSrcUinOpenid = jceInputStream.readString(9, false);
        this.strCommentUinOpenid = jceInputStream.readString(10, false);
        this.strReplyUinOpenid = jceInputStream.readString(11, false);
        this.ciphertext = jceInputStream.readString(12, false);
        this.bypass_param = (Map) jceInputStream.read((JceInputStream) cache_bypass_param, 13, false);
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
        jceOutputStream.write(this.iReplyUin, 5);
        String str3 = this.strReplyID;
        if (str3 != null) {
            jceOutputStream.write(str3, 6);
        }
        jceOutputStream.write(this.iDelSource, 7);
        jceOutputStream.write((Map) this.mapBusiParam, 8);
        String str4 = this.strSrcUinOpenid;
        if (str4 != null) {
            jceOutputStream.write(str4, 9);
        }
        String str5 = this.strCommentUinOpenid;
        if (str5 != null) {
            jceOutputStream.write(str5, 10);
        }
        String str6 = this.strReplyUinOpenid;
        if (str6 != null) {
            jceOutputStream.write(str6, 11);
        }
        String str7 = this.ciphertext;
        if (str7 != null) {
            jceOutputStream.write(str7, 12);
        }
        Map<String, String> map = this.bypass_param;
        if (map != null) {
            jceOutputStream.write((Map) map, 13);
        }
    }

    public operation_delreply_req(long j3, long j16, String str, long j17, String str2, long j18, String str3, int i3, Map<Integer, String> map, String str4, String str5, String str6, String str7, Map<String, String> map2) {
        this.iAppID = j3;
        this.iSrcUin = j16;
        this.strSrcID = str;
        this.iCommentUin = j17;
        this.strCommentID = str2;
        this.iReplyUin = j18;
        this.strReplyID = str3;
        this.iDelSource = i3;
        this.mapBusiParam = map;
        this.strSrcUinOpenid = str4;
        this.strCommentUinOpenid = str5;
        this.strReplyUinOpenid = str6;
        this.ciphertext = str7;
        this.bypass_param = map2;
    }
}
