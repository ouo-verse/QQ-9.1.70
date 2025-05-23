package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class DataReturnFlag extends JceStruct {
    public int has_priv_base;
    public String trace_info;

    public DataReturnFlag() {
        this.trace_info = "";
        this.has_priv_base = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.trace_info = jceInputStream.readString(0, false);
        this.has_priv_base = jceInputStream.read(this.has_priv_base, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.trace_info;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.has_priv_base, 1);
    }

    public DataReturnFlag(String str, int i3) {
        this.trace_info = str;
        this.has_priv_base = i3;
    }
}
