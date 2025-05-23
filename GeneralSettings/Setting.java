package GeneralSettings;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Setting extends JceStruct {
    public String Path;
    public String Value;

    public Setting() {
        this.Path = "";
        this.Value = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.Path = jceInputStream.readString(0, true);
        this.Value = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.Path, 0);
        String str = this.Value;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public Setting(String str, String str2) {
        this.Path = str;
        this.Value = str2;
    }
}
