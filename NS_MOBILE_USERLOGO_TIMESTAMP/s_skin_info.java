package NS_MOBILE_USERLOGO_TIMESTAMP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_skin_info extends JceStruct {

    /* renamed from: id, reason: collision with root package name */
    public String f25051id;
    public long timestamp;
    public String url;

    public s_skin_info() {
        this.f25051id = "";
        this.url = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f25051id = jceInputStream.readString(0, true);
        this.url = jceInputStream.readString(1, false);
        this.timestamp = jceInputStream.read(this.timestamp, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f25051id, 0);
        String str = this.url;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.timestamp, 2);
    }

    public s_skin_info(String str, String str2, long j3) {
        this.f25051id = str;
        this.url = str2;
        this.timestamp = j3;
    }
}
