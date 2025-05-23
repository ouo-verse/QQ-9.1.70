package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stCommentJumpText extends JceStruct {
    public String h5_url;
    public int index;
    public String schema_url;
    public String text;

    public stCommentJumpText() {
        this.text = "";
        this.index = 0;
        this.h5_url = "";
        this.schema_url = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.text = jceInputStream.readString(0, false);
        this.index = jceInputStream.read(this.index, 1, false);
        this.h5_url = jceInputStream.readString(2, false);
        this.schema_url = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.text;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.index, 1);
        String str2 = this.h5_url;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.schema_url;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
    }

    public stCommentJumpText(String str, int i3, String str2, String str3) {
        this.text = str;
        this.index = i3;
        this.h5_url = str2;
        this.schema_url = str3;
    }
}
