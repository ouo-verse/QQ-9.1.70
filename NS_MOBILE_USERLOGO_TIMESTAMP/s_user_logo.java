package NS_MOBILE_USERLOGO_TIMESTAMP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_user_logo extends JceStruct {

    /* renamed from: ip, reason: collision with root package name */
    public String f25052ip;
    public long timestamp;
    public long uin;

    public s_user_logo() {
        this.f25052ip = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        this.timestamp = jceInputStream.read(this.timestamp, 1, false);
        this.f25052ip = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.timestamp, 1);
        String str = this.f25052ip;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
    }

    public s_user_logo(long j3, long j16, String str) {
        this.uin = j3;
        this.timestamp = j16;
        this.f25052ip = str;
    }
}
