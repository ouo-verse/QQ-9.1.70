package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class clear_count_req extends JceStruct {
    public String LastUndealCountTime;
    public int clearType;

    public clear_count_req() {
        this.LastUndealCountTime = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.clearType = jceInputStream.read(this.clearType, 0, false);
        this.LastUndealCountTime = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.clearType, 0);
        String str = this.LastUndealCountTime;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public clear_count_req(int i3, String str) {
        this.clearType = i3;
        this.LastUndealCountTime = str;
    }
}
