package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class InteRemarkInfo extends JceStruct {
    public long Source;
    public String StrValue;

    public InteRemarkInfo() {
        this.StrValue = "";
        this.Source = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.StrValue = jceInputStream.readString(0, true);
        this.Source = jceInputStream.read(this.Source, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.StrValue, 0);
        jceOutputStream.write(this.Source, 1);
    }

    public InteRemarkInfo(String str, long j3) {
        this.StrValue = str;
        this.Source = j3;
    }
}
