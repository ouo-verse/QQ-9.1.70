package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Text extends JceStruct {
    public String Content;
    public int Id;

    public Text() {
        this.Id = 0;
        this.Content = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.Id = jceInputStream.read(this.Id, 0, false);
        this.Content = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.Id, 0);
        String str = this.Content;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public Text(int i3, String str) {
        this.Id = i3;
        this.Content = str;
    }
}
