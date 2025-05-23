package NS_KING_INTERFACE;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stDelCommentReplyRsp extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public String nothing;

    public stDelCommentReplyRsp() {
        this.nothing = "";
    }

    public String className() {
        return "NS_KING_INTERFACE.stDelCommentReplyRsp";
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
        new JceDisplayer(sb5, i3).display(this.nothing, "nothing");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        new JceDisplayer(sb5, i3).displaySimple(this.nothing, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return JceUtil.equals(this.nothing, ((stDelCommentReplyRsp) obj).nothing);
    }

    public String fullClassName() {
        return "NS_KING_INTERFACE.stDelCommentReplyRsp";
    }

    public String getNothing() {
        return this.nothing;
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
        this.nothing = jceInputStream.readString(0, false);
    }

    public void setNothing(String str) {
        this.nothing = str;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.nothing;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
    }

    public stDelCommentReplyRsp(String str) {
        this.nothing = str;
    }
}
