package NS_QQRADIO_KUOLIE_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetKuolieFavListReq extends JceStruct {
    static CommonInfo cache_commInfo = new CommonInfo();
    public CommonInfo commInfo;
    public String userId;

    public GetKuolieFavListReq() {
        this.commInfo = null;
        this.userId = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.commInfo = (CommonInfo) jceInputStream.read((JceStruct) cache_commInfo, 0, false);
        this.userId = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        CommonInfo commonInfo = this.commInfo;
        if (commonInfo != null) {
            jceOutputStream.write((JceStruct) commonInfo, 0);
        }
        String str = this.userId;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public GetKuolieFavListReq(CommonInfo commonInfo, String str) {
        this.commInfo = commonInfo;
        this.userId = str;
    }
}
