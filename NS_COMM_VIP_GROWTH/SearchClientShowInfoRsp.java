package NS_COMM_VIP_GROWTH;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SearchClientShowInfoRsp extends JceStruct {
    static UserClientShowInfo cache_stUserClientShowInfo = new UserClientShowInfo();
    public int iCode;
    public UserClientShowInfo stUserClientShowInfo;

    public SearchClientShowInfoRsp() {
        this.iCode = 0;
        this.stUserClientShowInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iCode = jceInputStream.read(this.iCode, 0, true);
        this.stUserClientShowInfo = (UserClientShowInfo) jceInputStream.read((JceStruct) cache_stUserClientShowInfo, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iCode, 0);
        UserClientShowInfo userClientShowInfo = this.stUserClientShowInfo;
        if (userClientShowInfo != null) {
            jceOutputStream.write((JceStruct) userClientShowInfo, 1);
        }
    }

    public SearchClientShowInfoRsp(int i3, UserClientShowInfo userClientShowInfo) {
        this.iCode = i3;
        this.stUserClientShowInfo = userClientShowInfo;
    }
}
