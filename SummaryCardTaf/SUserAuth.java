package SummaryCardTaf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SUserAuth extends JceStruct {
    static int cache_keytype;
    public String keystr;
    public int keytype;

    public SUserAuth() {
        this.keytype = 0;
        this.keystr = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.keytype = jceInputStream.read(this.keytype, 0, true);
        this.keystr = jceInputStream.readString(1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.keytype, 0);
        jceOutputStream.write(this.keystr, 1);
    }

    public SUserAuth(int i3, String str) {
        this.keytype = i3;
        this.keystr = str;
    }
}
