package acs;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqGetSoftwaresOnTop extends JceStruct {
    public int pageno;
    public int pagesize;
    public byte sorttype;

    public ReqGetSoftwaresOnTop() {
        this.sorttype = (byte) 0;
        this.pageno = 0;
        this.pagesize = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.sorttype = jceInputStream.read(this.sorttype, 0, true);
        this.pageno = jceInputStream.read(this.pageno, 1, false);
        this.pagesize = jceInputStream.read(this.pagesize, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.sorttype, 0);
        jceOutputStream.write(this.pageno, 1);
        jceOutputStream.write(this.pagesize, 2);
    }

    public ReqGetSoftwaresOnTop(byte b16, int i3, int i16) {
        this.sorttype = b16;
        this.pageno = i3;
        this.pagesize = i16;
    }
}
