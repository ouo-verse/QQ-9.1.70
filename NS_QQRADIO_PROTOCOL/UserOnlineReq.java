package NS_QQRADIO_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UserOnlineReq extends JceStruct {
    public String anchorId;
    public int relativeTime;
    public String roomId;
    public int type;
    public String uid;

    public UserOnlineReq() {
        this.uid = "";
        this.roomId = "";
        this.type = 0;
        this.relativeTime = 0;
        this.anchorId = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uid = jceInputStream.readString(0, false);
        this.roomId = jceInputStream.readString(1, false);
        this.type = jceInputStream.read(this.type, 2, false);
        this.relativeTime = jceInputStream.read(this.relativeTime, 3, false);
        this.anchorId = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.uid;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.roomId;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        jceOutputStream.write(this.type, 2);
        jceOutputStream.write(this.relativeTime, 3);
        String str3 = this.anchorId;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
    }

    public UserOnlineReq(String str, String str2, int i3, int i16, String str3) {
        this.uid = str;
        this.roomId = str2;
        this.type = i3;
        this.relativeTime = i16;
        this.anchorId = str3;
    }
}
