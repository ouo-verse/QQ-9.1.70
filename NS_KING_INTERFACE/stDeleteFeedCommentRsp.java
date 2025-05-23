package NS_KING_INTERFACE;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stDeleteFeedCommentRsp extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public int ret;

    public stDeleteFeedCommentRsp() {
        this.ret = 0;
    }

    public String className() {
        return "NS_KING_INTERFACE.stDeleteFeedCommentRsp";
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
        new JceDisplayer(sb5, i3).display(this.ret, "ret");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        new JceDisplayer(sb5, i3).displaySimple(this.ret, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return JceUtil.equals(this.ret, ((stDeleteFeedCommentRsp) obj).ret);
    }

    public String fullClassName() {
        return "NS_KING_INTERFACE.stDeleteFeedCommentRsp";
    }

    public int getRet() {
        return this.ret;
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
        this.ret = jceInputStream.read(this.ret, 0, true);
    }

    public void setRet(int i3) {
        this.ret = i3;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
    }

    public stDeleteFeedCommentRsp(int i3) {
        this.ret = i3;
    }
}
