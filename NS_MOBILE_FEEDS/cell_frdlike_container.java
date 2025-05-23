package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_frdlike_container extends JceStruct {
    public int blank_actiontype;
    public String right_desc;
    public int right_desc_actiontype;

    public cell_frdlike_container() {
        this.blank_actiontype = 0;
        this.right_desc = "";
        this.right_desc_actiontype = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.blank_actiontype = jceInputStream.read(this.blank_actiontype, 0, false);
        this.right_desc = jceInputStream.readString(1, false);
        this.right_desc_actiontype = jceInputStream.read(this.right_desc_actiontype, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.blank_actiontype, 0);
        String str = this.right_desc;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.right_desc_actiontype, 2);
    }

    public cell_frdlike_container(int i3, String str, int i16) {
        this.blank_actiontype = i3;
        this.right_desc = str;
        this.right_desc_actiontype = i16;
    }
}
