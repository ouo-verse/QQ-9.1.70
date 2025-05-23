package QQService;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RespHead extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public int iReplyCode;
    public int iSeq;
    public long lUIN;
    public short shVersion;
    public String strResult;

    public RespHead() {
        this.shVersion = (short) 0;
        this.iSeq = 0;
        this.lUIN = 0L;
        this.iReplyCode = 0;
        this.strResult = "";
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void display(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.display(this.shVersion, "shVersion");
        jceDisplayer.display(this.iSeq, "iSeq");
        jceDisplayer.display(this.lUIN, "lUIN");
        jceDisplayer.display(this.iReplyCode, "iReplyCode");
        jceDisplayer.display(this.strResult, "strResult");
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        RespHead respHead = (RespHead) obj;
        if (!JceUtil.equals(this.shVersion, respHead.shVersion) || !JceUtil.equals(this.iSeq, respHead.iSeq) || !JceUtil.equals(this.lUIN, respHead.lUIN) || !JceUtil.equals(this.iReplyCode, respHead.iReplyCode) || !JceUtil.equals(this.strResult, respHead.strResult)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.shVersion = jceInputStream.read(this.shVersion, 0, true);
        this.iSeq = jceInputStream.read(this.iSeq, 1, true);
        this.lUIN = jceInputStream.read(this.lUIN, 2, true);
        this.iReplyCode = jceInputStream.read(this.iReplyCode, 3, true);
        this.strResult = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.shVersion, 0);
        jceOutputStream.write(this.iSeq, 1);
        jceOutputStream.write(this.lUIN, 2);
        jceOutputStream.write(this.iReplyCode, 3);
        String str = this.strResult;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
    }

    public RespHead(short s16, int i3, long j3, int i16, String str) {
        this.shVersion = s16;
        this.iSeq = i3;
        this.lUIN = j3;
        this.iReplyCode = i16;
        this.strResult = str;
    }
}
