package WMDBClientInterface;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class stAndroidPush extends JceStruct {
    public String content;
    public String keyname;
    public int mode;
    public String sceneId;
    public String wmId;

    public stAndroidPush() {
        this.content = "";
        this.mode = 0;
        this.wmId = "";
        this.sceneId = "";
        this.keyname = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.content = jceInputStream.readString(0, true);
        this.mode = jceInputStream.read(this.mode, 1, true);
        this.wmId = jceInputStream.readString(2, true);
        this.sceneId = jceInputStream.readString(3, true);
        this.keyname = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.content, 0);
        jceOutputStream.write(this.mode, 1);
        jceOutputStream.write(this.wmId, 2);
        jceOutputStream.write(this.sceneId, 3);
        String str = this.keyname;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
    }

    public stAndroidPush(String str, int i3, String str2, String str3, String str4) {
        this.content = str;
        this.mode = i3;
        this.wmId = str2;
        this.sceneId = str3;
        this.keyname = str4;
    }
}
