package QQService;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

/* loaded from: classes.dex */
public final class RespTmpChatPicDownload extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public int lReplyCode;
    public long lSeq;
    public long lUIN;
    public String strDownloadURL;
    public String strResult;

    public RespTmpChatPicDownload() {
        this.lUIN = 0L;
        this.lSeq = 0L;
        this.lReplyCode = 0;
        this.strResult = "";
        this.strDownloadURL = "";
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
        jceDisplayer.display(this.lReplyCode, "lReplyCode");
        jceDisplayer.display(this.strResult, "strResult");
        jceDisplayer.display(this.strDownloadURL, "strDownloadURL");
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        RespTmpChatPicDownload respTmpChatPicDownload = (RespTmpChatPicDownload) obj;
        if (!JceUtil.equals(this.lUIN, respTmpChatPicDownload.lUIN) || !JceUtil.equals(this.lSeq, respTmpChatPicDownload.lSeq) || !JceUtil.equals(this.lReplyCode, respTmpChatPicDownload.lReplyCode) || !JceUtil.equals(this.strResult, respTmpChatPicDownload.strResult) || !JceUtil.equals(this.strDownloadURL, respTmpChatPicDownload.strDownloadURL)) {
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
        this.lReplyCode = jceInputStream.read(this.lReplyCode, 2, true);
        this.strResult = jceInputStream.readString(3, true);
        this.strDownloadURL = jceInputStream.readString(4, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lUIN, 0);
        jceOutputStream.write(this.lSeq, 1);
        jceOutputStream.write(this.lReplyCode, 2);
        jceOutputStream.write(this.strResult, 3);
        jceOutputStream.write(this.strDownloadURL, 4);
    }

    public RespTmpChatPicDownload(long j3, long j16, int i3, String str, String str2) {
        this.lUIN = j3;
        this.lSeq = j16;
        this.lReplyCode = i3;
        this.strResult = str;
        this.strDownloadURL = str2;
    }
}
