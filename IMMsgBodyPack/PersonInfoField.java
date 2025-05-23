package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class PersonInfoField extends JceStruct {
    public long uField;

    public PersonInfoField() {
        this.uField = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uField = jceInputStream.read(this.uField, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uField, 0);
    }

    public PersonInfoField(long j3) {
        this.uField = j3;
    }
}
