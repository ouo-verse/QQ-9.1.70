package NS_KING_SOCIALIZE_META;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stSqArk extends JceStruct {
    static stShareBody cache_shareBody = new stShareBody();
    public String arkData;
    public String coverProto;
    public stShareBody shareBody;

    public stSqArk() {
        this.arkData = "";
        this.shareBody = null;
        this.coverProto = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.arkData = jceInputStream.readString(0, false);
        this.shareBody = (stShareBody) jceInputStream.read((JceStruct) cache_shareBody, 1, false);
        this.coverProto = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.arkData;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        stShareBody stsharebody = this.shareBody;
        if (stsharebody != null) {
            jceOutputStream.write((JceStruct) stsharebody, 1);
        }
        String str2 = this.coverProto;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
    }

    public stSqArk(String str, stShareBody stsharebody, String str2) {
        this.arkData = str;
        this.shareBody = stsharebody;
        this.coverProto = str2;
    }
}
