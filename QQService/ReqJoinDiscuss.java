package QQService;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import org.apache.httpcore.HttpHeaders;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqJoinDiscuss extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public int From;
    public String Signature;

    public ReqJoinDiscuss() {
        this.Signature = "";
        this.From = 0;
    }

    public String className() {
        return "QQService.ReqJoinDiscuss";
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
        jceDisplayer.display(this.Signature, "Signature");
        jceDisplayer.display(this.From, HttpHeaders.FROM);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.displaySimple(this.Signature, true);
        jceDisplayer.displaySimple(this.From, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        ReqJoinDiscuss reqJoinDiscuss = (ReqJoinDiscuss) obj;
        if (!JceUtil.equals(this.Signature, reqJoinDiscuss.Signature) || !JceUtil.equals(this.From, reqJoinDiscuss.From)) {
            return false;
        }
        return true;
    }

    public String fullClassName() {
        return "QQService.ReqJoinDiscuss";
    }

    public int getFrom() {
        return this.From;
    }

    public String getSignature() {
        return this.Signature;
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
        this.Signature = jceInputStream.readString(0, false);
        this.From = jceInputStream.read(this.From, 1, false);
    }

    public void setFrom(int i3) {
        this.From = i3;
    }

    public void setSignature(String str) {
        this.Signature = str;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.Signature;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.From, 1);
    }

    public ReqJoinDiscuss(String str, int i3) {
        this.Signature = str;
        this.From = i3;
    }
}
