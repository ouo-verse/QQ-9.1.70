package NS_KING_INTERFACE;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stReplyListInfo extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public String attach_info;
    public boolean isFinished;
    public boolean isRFinished;

    public stReplyListInfo() {
        this.isFinished = true;
        this.isRFinished = true;
        this.attach_info = "";
    }

    public String className() {
        return "NS_KING_INTERFACE.stReplyListInfo";
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
        jceDisplayer.display(this.isFinished, "isFinished");
        jceDisplayer.display(this.isRFinished, "isRFinished");
        jceDisplayer.display(this.attach_info, "attach_info");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.displaySimple(this.isFinished, true);
        jceDisplayer.displaySimple(this.isRFinished, true);
        jceDisplayer.displaySimple(this.attach_info, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        stReplyListInfo streplylistinfo = (stReplyListInfo) obj;
        if (!JceUtil.equals(this.isFinished, streplylistinfo.isFinished) || !JceUtil.equals(this.isRFinished, streplylistinfo.isRFinished) || !JceUtil.equals(this.attach_info, streplylistinfo.attach_info)) {
            return false;
        }
        return true;
    }

    public String fullClassName() {
        return "NS_KING_INTERFACE.stReplyListInfo";
    }

    public String getAttach_info() {
        return this.attach_info;
    }

    public boolean getIsFinished() {
        return this.isFinished;
    }

    public boolean getIsRFinished() {
        return this.isRFinished;
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
        this.isFinished = jceInputStream.read(this.isFinished, 0, false);
        this.isRFinished = jceInputStream.read(this.isRFinished, 1, false);
        this.attach_info = jceInputStream.readString(2, false);
    }

    public void setAttach_info(String str) {
        this.attach_info = str;
    }

    public void setIsFinished(boolean z16) {
        this.isFinished = z16;
    }

    public void setIsRFinished(boolean z16) {
        this.isRFinished = z16;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.isFinished, 0);
        jceOutputStream.write(this.isRFinished, 1);
        String str = this.attach_info;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
    }

    public stReplyListInfo(boolean z16, boolean z17, String str) {
        this.isFinished = z16;
        this.isRFinished = z17;
        this.attach_info = str;
    }
}
