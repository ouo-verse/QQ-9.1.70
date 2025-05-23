package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_recomm_footer extends JceStruct {
    public String text;

    public cell_recomm_footer() {
        this.text = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.text = jceInputStream.readString(0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.text;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
    }

    public cell_recomm_footer(String str) {
        this.text = str;
    }
}
