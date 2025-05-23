package WMDBClientInterface;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stFlashScreen extends JceStruct {
    public String bgtime;
    public String edtime;
    public String furl;

    /* renamed from: id, reason: collision with root package name */
    public String f25139id;

    public stFlashScreen() {
        this.f25139id = "";
        this.furl = "";
        this.bgtime = "";
        this.edtime = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f25139id = jceInputStream.readString(0, true);
        this.furl = jceInputStream.readString(1, true);
        this.bgtime = jceInputStream.readString(2, true);
        this.edtime = jceInputStream.readString(3, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f25139id, 0);
        jceOutputStream.write(this.furl, 1);
        jceOutputStream.write(this.bgtime, 2);
        jceOutputStream.write(this.edtime, 3);
    }

    public stFlashScreen(String str, String str2, String str3, String str4) {
        this.f25139id = str;
        this.furl = str2;
        this.bgtime = str3;
        this.edtime = str4;
    }
}
