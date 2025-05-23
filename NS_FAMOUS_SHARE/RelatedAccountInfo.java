package NS_FAMOUS_SHARE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RelatedAccountInfo extends JceStruct {
    public String first_class;
    public String nick;
    public String sFamousDesc;
    public String secong_class;
    public long uiFamousFansNum;
    public long uiVisitorCount;
    public long uin;

    public RelatedAccountInfo() {
        this.uin = 0L;
        this.nick = "";
        this.first_class = "";
        this.secong_class = "";
        this.uiFamousFansNum = 0L;
        this.uiVisitorCount = 0L;
        this.sFamousDesc = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.nick = jceInputStream.readString(1, false);
        this.first_class = jceInputStream.readString(2, false);
        this.secong_class = jceInputStream.readString(3, false);
        this.uiFamousFansNum = jceInputStream.read(this.uiFamousFansNum, 4, false);
        this.uiVisitorCount = jceInputStream.read(this.uiVisitorCount, 5, false);
        this.sFamousDesc = jceInputStream.readString(6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        String str = this.nick;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.first_class;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.secong_class;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        jceOutputStream.write(this.uiFamousFansNum, 4);
        jceOutputStream.write(this.uiVisitorCount, 5);
        String str4 = this.sFamousDesc;
        if (str4 != null) {
            jceOutputStream.write(str4, 6);
        }
    }

    public RelatedAccountInfo(long j3, String str, String str2, String str3, long j16, long j17, String str4) {
        this.uin = j3;
        this.nick = str;
        this.first_class = str2;
        this.secong_class = str3;
        this.uiFamousFansNum = j16;
        this.uiVisitorCount = j17;
        this.sFamousDesc = str4;
    }
}
