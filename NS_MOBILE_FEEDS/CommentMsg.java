package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CommentMsg extends JceStruct {
    public String dressIcon;

    /* renamed from: msg, reason: collision with root package name */
    public String f24978msg;
    public String nick;
    public String userId;

    public CommentMsg() {
        this.userId = "";
        this.nick = "";
        this.f24978msg = "";
        this.dressIcon = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.userId = jceInputStream.readString(0, false);
        this.nick = jceInputStream.readString(1, false);
        this.f24978msg = jceInputStream.readString(2, false);
        this.dressIcon = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.userId;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.nick;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.f24978msg;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.dressIcon;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
    }

    public CommentMsg(String str, String str2, String str3, String str4) {
        this.userId = str;
        this.nick = str2;
        this.f24978msg = str3;
        this.dressIcon = str4;
    }
}
