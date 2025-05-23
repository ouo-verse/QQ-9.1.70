package NS_NEW_MOBILE_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class IOSTerminal extends JceStruct {
    public String idfa;
    public String mode;
    public String osVersion;

    /* renamed from: ua, reason: collision with root package name */
    public String f25062ua;
    public String uniqueId;

    public IOSTerminal() {
        this.idfa = "";
        this.osVersion = "";
        this.f25062ua = "";
        this.mode = "";
        this.uniqueId = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.idfa = jceInputStream.readString(0, false);
        this.osVersion = jceInputStream.readString(1, false);
        this.f25062ua = jceInputStream.readString(2, false);
        this.mode = jceInputStream.readString(3, false);
        this.uniqueId = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.idfa;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.osVersion;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.f25062ua;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.mode;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
        String str5 = this.uniqueId;
        if (str5 != null) {
            jceOutputStream.write(str5, 4);
        }
    }

    public IOSTerminal(String str, String str2, String str3, String str4, String str5) {
        this.idfa = str;
        this.osVersion = str2;
        this.f25062ua = str3;
        this.mode = str4;
        this.uniqueId = str5;
    }
}
