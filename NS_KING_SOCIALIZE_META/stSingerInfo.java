package NS_KING_SOCIALIZE_META;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stSingerInfo extends JceStruct {
    public String strMid;
    public String strName;
    public String strPic;
    public long uiId;

    public stSingerInfo() {
        this.uiId = 0L;
        this.strMid = "";
        this.strName = "";
        this.strPic = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uiId = jceInputStream.read(this.uiId, 0, false);
        this.strMid = jceInputStream.readString(1, false);
        this.strName = jceInputStream.readString(2, false);
        this.strPic = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uiId, 0);
        String str = this.strMid;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.strName;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.strPic;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
    }

    public stSingerInfo(long j3, String str, String str2, String str3) {
        this.uiId = j3;
        this.strMid = str;
        this.strName = str2;
        this.strPic = str3;
    }
}
