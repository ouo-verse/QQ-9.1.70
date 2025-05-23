package AccostSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class QQRobertInfo extends JceStruct {
    public String actionUrl;
    public String nickname;

    public QQRobertInfo() {
        this.nickname = "";
        this.actionUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.nickname = jceInputStream.readString(0, true);
        this.actionUrl = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.nickname, 0);
        String str = this.actionUrl;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public QQRobertInfo(String str, String str2) {
        this.nickname = str;
        this.actionUrl = str2;
    }
}
