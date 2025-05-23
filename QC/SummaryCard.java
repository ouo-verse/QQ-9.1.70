package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SummaryCard extends JceStruct {
    public int bgid;
    public int color;
    public int styleid;
    public String url;

    public SummaryCard() {
        this.styleid = 0;
        this.bgid = 0;
        this.url = "";
        this.color = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.styleid = jceInputStream.read(this.styleid, 0, false);
        this.bgid = jceInputStream.read(this.bgid, 1, false);
        this.url = jceInputStream.readString(2, false);
        this.color = jceInputStream.read(this.color, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.styleid, 0);
        jceOutputStream.write(this.bgid, 1);
        String str = this.url;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        jceOutputStream.write(this.color, 3);
    }

    public SummaryCard(int i3, int i16, String str, int i17) {
        this.styleid = i3;
        this.bgid = i16;
        this.url = str;
        this.color = i17;
    }
}
