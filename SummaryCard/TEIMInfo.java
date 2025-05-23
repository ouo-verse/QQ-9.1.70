package SummaryCard;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

/* compiled from: P */
/* loaded from: classes.dex */
public final class TEIMInfo extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public int iBindCompanyEmailStatus;
    public String sBindCompanyEmail;

    public TEIMInfo() {
        this.iBindCompanyEmailStatus = 0;
        this.sBindCompanyEmail = "";
    }

    public String className() {
        return "SummaryCard.TEIMInfo";
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
        jceDisplayer.display(this.iBindCompanyEmailStatus, "iBindCompanyEmailStatus");
        jceDisplayer.display(this.sBindCompanyEmail, "sBindCompanyEmail");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.displaySimple(this.iBindCompanyEmailStatus, true);
        jceDisplayer.displaySimple(this.sBindCompanyEmail, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        TEIMInfo tEIMInfo = (TEIMInfo) obj;
        if (!JceUtil.equals(this.iBindCompanyEmailStatus, tEIMInfo.iBindCompanyEmailStatus) || !JceUtil.equals(this.sBindCompanyEmail, tEIMInfo.sBindCompanyEmail)) {
            return false;
        }
        return true;
    }

    public String fullClassName() {
        return "SummaryCard.TEIMInfo";
    }

    public int getIBindCompanyEmailStatus() {
        return this.iBindCompanyEmailStatus;
    }

    public String getSBindCompanyEmail() {
        return this.sBindCompanyEmail;
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
        this.iBindCompanyEmailStatus = jceInputStream.read(this.iBindCompanyEmailStatus, 0, false);
        this.sBindCompanyEmail = jceInputStream.readString(1, false);
    }

    public void setIBindCompanyEmailStatus(int i3) {
        this.iBindCompanyEmailStatus = i3;
    }

    public void setSBindCompanyEmail(String str) {
        this.sBindCompanyEmail = str;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iBindCompanyEmailStatus, 0);
        String str = this.sBindCompanyEmail;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public TEIMInfo(int i3, String str) {
        this.iBindCompanyEmailStatus = i3;
        this.sBindCompanyEmail = str;
    }
}
