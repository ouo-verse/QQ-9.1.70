package acs;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ResCommon extends JceStruct {
    public byte cByte;
    public int cInt;
    public long cLong;
    public String cString;

    public ResCommon() {
        this.cByte = (byte) 0;
        this.cInt = 0;
        this.cLong = 0L;
        this.cString = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cByte = jceInputStream.read(this.cByte, 0, false);
        this.cInt = jceInputStream.read(this.cInt, 1, false);
        this.cLong = jceInputStream.read(this.cLong, 2, false);
        this.cString = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.cByte, 0);
        jceOutputStream.write(this.cInt, 1);
        jceOutputStream.write(this.cLong, 2);
        String str = this.cString;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
    }

    public ResCommon(byte b16, int i3, long j3, String str) {
        this.cByte = b16;
        this.cInt = i3;
        this.cLong = j3;
        this.cString = str;
    }
}
