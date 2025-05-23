package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_space_event extends JceStruct {
    public int iAdID;
    public String strEventPic;
    public String strEventTxt;
    public String strJumpType;
    public String strJumpUrl;
    public String traceinfo;

    public s_space_event() {
        this.strEventPic = "";
        this.strJumpType = "";
        this.strJumpUrl = "";
        this.strEventTxt = "";
        this.traceinfo = "";
        this.iAdID = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strEventPic = jceInputStream.readString(0, false);
        this.strJumpType = jceInputStream.readString(1, false);
        this.strJumpUrl = jceInputStream.readString(2, false);
        this.strEventTxt = jceInputStream.readString(3, false);
        this.traceinfo = jceInputStream.readString(4, false);
        this.iAdID = jceInputStream.read(this.iAdID, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.strEventPic;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.strJumpType;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.strJumpUrl;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.strEventTxt;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
        String str5 = this.traceinfo;
        if (str5 != null) {
            jceOutputStream.write(str5, 4);
        }
        jceOutputStream.write(this.iAdID, 5);
    }

    public s_space_event(String str, String str2, String str3, String str4, String str5, int i3) {
        this.strEventPic = str;
        this.strJumpType = str2;
        this.strJumpUrl = str3;
        this.strEventTxt = str4;
        this.traceinfo = str5;
        this.iAdID = i3;
    }
}
