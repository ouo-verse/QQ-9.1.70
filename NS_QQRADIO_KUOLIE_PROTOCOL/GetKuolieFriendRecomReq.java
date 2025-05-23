package NS_QQRADIO_KUOLIE_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetKuolieFriendRecomReq extends JceStruct {
    static CommonInfo cache_commInfo = new CommonInfo();
    public CommonInfo commInfo;
    public String roomId;
    public String userId;

    public GetKuolieFriendRecomReq() {
        this.commInfo = null;
        this.roomId = "";
        this.userId = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.commInfo = (CommonInfo) jceInputStream.read((JceStruct) cache_commInfo, 0, false);
        this.roomId = jceInputStream.readString(1, false);
        this.userId = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        CommonInfo commonInfo = this.commInfo;
        if (commonInfo != null) {
            jceOutputStream.write((JceStruct) commonInfo, 0);
        }
        String str = this.roomId;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.userId;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
    }

    public GetKuolieFriendRecomReq(CommonInfo commonInfo, String str, String str2) {
        this.commInfo = commonInfo;
        this.roomId = str;
        this.userId = str2;
    }
}
