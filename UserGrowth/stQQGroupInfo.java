package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stQQGroupInfo extends JceStruct {
    public String groupAuth;
    public String groupAvatar;
    public String groupCode;
    public String groupName;
    public String groupOpenID;
    public String openID;

    public stQQGroupInfo() {
        this.openID = "";
        this.groupCode = "";
        this.groupOpenID = "";
        this.groupName = "";
        this.groupAvatar = "";
        this.groupAuth = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.openID = jceInputStream.readString(0, false);
        this.groupCode = jceInputStream.readString(1, false);
        this.groupOpenID = jceInputStream.readString(2, false);
        this.groupName = jceInputStream.readString(3, false);
        this.groupAvatar = jceInputStream.readString(4, false);
        this.groupAuth = jceInputStream.readString(5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.openID;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.groupCode;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.groupOpenID;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.groupName;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
        String str5 = this.groupAvatar;
        if (str5 != null) {
            jceOutputStream.write(str5, 4);
        }
        String str6 = this.groupAuth;
        if (str6 != null) {
            jceOutputStream.write(str6, 5);
        }
    }

    public stQQGroupInfo(String str, String str2, String str3, String str4, String str5, String str6) {
        this.openID = str;
        this.groupCode = str2;
        this.groupOpenID = str3;
        this.groupName = str4;
        this.groupAvatar = str5;
        this.groupAuth = str6;
    }
}
