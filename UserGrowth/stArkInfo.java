package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stArkInfo extends JceStruct {
    static stArkMeta cache_meta = new stArkMeta();
    public String app;
    public stArkMeta meta;
    public String prompt;
    public String ver;
    public String view;

    public stArkInfo() {
        this.app = "";
        this.view = "";
        this.prompt = "";
        this.ver = "";
        this.meta = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.app = jceInputStream.readString(0, false);
        this.view = jceInputStream.readString(1, false);
        this.prompt = jceInputStream.readString(2, false);
        this.ver = jceInputStream.readString(3, false);
        this.meta = (stArkMeta) jceInputStream.read((JceStruct) cache_meta, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.app;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.view;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.prompt;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.ver;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
        stArkMeta starkmeta = this.meta;
        if (starkmeta != null) {
            jceOutputStream.write((JceStruct) starkmeta, 4);
        }
    }

    public stArkInfo(String str, String str2, String str3, String str4, stArkMeta starkmeta) {
        this.app = str;
        this.view = str2;
        this.prompt = str3;
        this.ver = str4;
        this.meta = starkmeta;
    }
}
