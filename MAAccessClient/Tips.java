package MAAccessClient;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Tips extends JceStruct {
    public String button;
    public String content;
    public String title;

    public Tips() {
        this.title = "";
        this.button = "";
        this.content = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.title = jceInputStream.readString(0, true);
        this.button = jceInputStream.readString(1, true);
        this.content = jceInputStream.readString(2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.title, 0);
        jceOutputStream.write(this.button, 1);
        jceOutputStream.write(this.content, 2);
    }

    public Tips(String str, String str2, String str3) {
        this.title = str;
        this.button = str2;
        this.content = str3;
    }
}
