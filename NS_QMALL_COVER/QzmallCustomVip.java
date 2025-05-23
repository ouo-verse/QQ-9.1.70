package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class QzmallCustomVip extends JceStruct {
    static int cache_eCustomVipType;
    public int eCustomVipType;
    public int iItemId;
    public String strGuestJumpUrl;
    public String strMasterJumpUrl;
    public String strSrcUrl;

    public QzmallCustomVip() {
        this.iItemId = -1;
        this.strSrcUrl = "";
        this.strMasterJumpUrl = "";
        this.strGuestJumpUrl = "";
        this.eCustomVipType = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iItemId = jceInputStream.read(this.iItemId, 0, true);
        this.strSrcUrl = jceInputStream.readString(1, false);
        this.strMasterJumpUrl = jceInputStream.readString(2, false);
        this.strGuestJumpUrl = jceInputStream.readString(3, false);
        this.eCustomVipType = jceInputStream.read(this.eCustomVipType, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iItemId, 0);
        String str = this.strSrcUrl;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.strMasterJumpUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.strGuestJumpUrl;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        jceOutputStream.write(this.eCustomVipType, 4);
    }

    public QzmallCustomVip(int i3, String str, String str2, String str3, int i16) {
        this.iItemId = i3;
        this.strSrcUrl = str;
        this.strMasterJumpUrl = str2;
        this.strGuestJumpUrl = str3;
        this.eCustomVipType = i16;
    }
}
