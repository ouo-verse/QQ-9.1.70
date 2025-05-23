package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class InRoomMsg extends JceStruct {

    /* renamed from: msg, reason: collision with root package name */
    public String f24980msg;
    public String nick;
    public String userId;

    public InRoomMsg() {
        this.userId = "";
        this.f24980msg = "";
        this.nick = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.userId = jceInputStream.readString(0, false);
        this.f24980msg = jceInputStream.readString(1, false);
        this.nick = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.userId;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.f24980msg;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.nick;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
    }

    public InRoomMsg(String str, String str2, String str3) {
        this.userId = str;
        this.f24980msg = str2;
        this.nick = str3;
    }
}
