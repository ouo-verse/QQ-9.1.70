package QQService;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

/* loaded from: classes.dex */
public final class ReqTmpChatPicDownload extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public byte getPicSize;
    public long lSeq;
    public long lUIN;
    public String strFlieKey;

    public ReqTmpChatPicDownload() {
        this.lUIN = 0L;
        this.lSeq = 0L;
        this.strFlieKey = "";
        this.getPicSize = (byte) 0;
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
        jceDisplayer.display(this.lUIN, "lUIN");
        jceDisplayer.display(this.lSeq, "lSeq");
        jceDisplayer.display(this.strFlieKey, "strFlieKey");
        jceDisplayer.display(this.getPicSize, "getPicSize");
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        ReqTmpChatPicDownload reqTmpChatPicDownload = (ReqTmpChatPicDownload) obj;
        if (!JceUtil.equals(this.lUIN, reqTmpChatPicDownload.lUIN) || !JceUtil.equals(this.lSeq, reqTmpChatPicDownload.lSeq) || !JceUtil.equals(this.strFlieKey, reqTmpChatPicDownload.strFlieKey) || !JceUtil.equals(this.getPicSize, reqTmpChatPicDownload.getPicSize)) {
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
        this.lUIN = jceInputStream.read(this.lUIN, 0, true);
        this.lSeq = jceInputStream.read(this.lSeq, 1, true);
        this.strFlieKey = jceInputStream.readString(2, true);
        this.getPicSize = jceInputStream.read(this.getPicSize, 3, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lUIN, 0);
        jceOutputStream.write(this.lSeq, 1);
        jceOutputStream.write(this.strFlieKey, 2);
        jceOutputStream.write(this.getPicSize, 3);
    }

    public ReqTmpChatPicDownload(long j3, long j16, String str, byte b16) {
        this.lUIN = j3;
        this.lSeq = j16;
        this.strFlieKey = str;
        this.getPicSize = b16;
    }
}
