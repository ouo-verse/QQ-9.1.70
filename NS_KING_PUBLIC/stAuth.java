package NS_KING_PUBLIC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stAuth extends JceStruct {
    public int iAuthType;
    public String sAccessToken;
    public String sRefreshToken;
    public String sSessionKey;
    public String sThrAppid;
    public String sUid;

    public stAuth() {
        this.iAuthType = 0;
        this.sUid = "";
        this.sSessionKey = "";
        this.sRefreshToken = "";
        this.sAccessToken = "";
        this.sThrAppid = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iAuthType = jceInputStream.read(this.iAuthType, 0, false);
        this.sUid = jceInputStream.readString(1, false);
        this.sSessionKey = jceInputStream.readString(2, false);
        this.sRefreshToken = jceInputStream.readString(3, false);
        this.sAccessToken = jceInputStream.readString(4, false);
        this.sThrAppid = jceInputStream.readString(5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iAuthType, 0);
        String str = this.sUid;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.sSessionKey;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.sRefreshToken;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        String str4 = this.sAccessToken;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
        String str5 = this.sThrAppid;
        if (str5 != null) {
            jceOutputStream.write(str5, 5);
        }
    }

    public stAuth(int i3, String str, String str2) {
        this.sRefreshToken = "";
        this.sAccessToken = "";
        this.sThrAppid = "";
        this.iAuthType = i3;
        this.sUid = str;
        this.sSessionKey = str2;
    }

    public stAuth(int i3, String str, String str2, String str3, String str4, String str5) {
        this.iAuthType = i3;
        this.sUid = str;
        this.sSessionKey = str2;
        this.sRefreshToken = str3;
        this.sAccessToken = str4;
        this.sThrAppid = str5;
    }
}
