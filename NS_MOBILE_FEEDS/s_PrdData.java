package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class s_PrdData extends JceStruct {
    public int iType;
    public String strColorBegin;
    public String strColorEnd;
    public String strResUrl;

    public s_PrdData() {
        this.iType = 0;
        this.strResUrl = "";
        this.strColorBegin = "";
        this.strColorEnd = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iType = jceInputStream.read(this.iType, 0, false);
        this.strResUrl = jceInputStream.readString(1, false);
        this.strColorBegin = jceInputStream.readString(2, false);
        this.strColorEnd = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iType, 0);
        String str = this.strResUrl;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.strColorBegin;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.strColorEnd;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
    }

    public s_PrdData(int i3, String str, String str2, String str3) {
        this.iType = i3;
        this.strResUrl = str;
        this.strColorBegin = str2;
        this.strColorEnd = str3;
    }
}
