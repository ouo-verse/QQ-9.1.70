package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stFriendFeedReq extends JceStruct {
    public String attachInfo;

    public stFriendFeedReq() {
        this.attachInfo = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.attachInfo = jceInputStream.readString(0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.attachInfo;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
    }

    public stFriendFeedReq(String str) {
        this.attachInfo = str;
    }
}
