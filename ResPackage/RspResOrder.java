package ResPackage;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RspResOrder extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static int cache_Ret;
    public String ButtonDesc;
    public String ButtonUrl;
    public String ErrMsg;
    public int Ret;
    public int SeqID;
    public String Title;

    public RspResOrder() {
        this.Ret = 0;
        this.SeqID = 0;
        this.Title = "";
        this.ErrMsg = "";
        this.ButtonDesc = "";
        this.ButtonUrl = "";
    }

    public String className() {
        return "ResPackage.RspResOrder";
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
        jceDisplayer.display(this.Ret, "Ret");
        jceDisplayer.display(this.SeqID, "SeqID");
        jceDisplayer.display(this.Title, "Title");
        jceDisplayer.display(this.ErrMsg, "ErrMsg");
        jceDisplayer.display(this.ButtonDesc, "ButtonDesc");
        jceDisplayer.display(this.ButtonUrl, "ButtonUrl");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.displaySimple(this.Ret, true);
        jceDisplayer.displaySimple(this.SeqID, true);
        jceDisplayer.displaySimple(this.Title, true);
        jceDisplayer.displaySimple(this.ErrMsg, true);
        jceDisplayer.displaySimple(this.ButtonDesc, true);
        jceDisplayer.displaySimple(this.ButtonUrl, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        RspResOrder rspResOrder = (RspResOrder) obj;
        if (!JceUtil.equals(this.Ret, rspResOrder.Ret) || !JceUtil.equals(this.SeqID, rspResOrder.SeqID) || !JceUtil.equals(this.Title, rspResOrder.Title) || !JceUtil.equals(this.ErrMsg, rspResOrder.ErrMsg) || !JceUtil.equals(this.ButtonDesc, rspResOrder.ButtonDesc) || !JceUtil.equals(this.ButtonUrl, rspResOrder.ButtonUrl)) {
            return false;
        }
        return true;
    }

    public String fullClassName() {
        return "ResPackage.RspResOrder";
    }

    public String getButtonDesc() {
        return this.ButtonDesc;
    }

    public String getButtonUrl() {
        return this.ButtonUrl;
    }

    public String getErrMsg() {
        return this.ErrMsg;
    }

    public int getRet() {
        return this.Ret;
    }

    public int getSeqID() {
        return this.SeqID;
    }

    public String getTitle() {
        return this.Title;
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
        this.Ret = jceInputStream.read(this.Ret, 0, true);
        this.SeqID = jceInputStream.read(this.SeqID, 1, true);
        this.Title = jceInputStream.readString(2, false);
        this.ErrMsg = jceInputStream.readString(3, false);
        this.ButtonDesc = jceInputStream.readString(4, false);
        this.ButtonUrl = jceInputStream.readString(5, false);
    }

    public void setButtonDesc(String str) {
        this.ButtonDesc = str;
    }

    public void setButtonUrl(String str) {
        this.ButtonUrl = str;
    }

    public void setErrMsg(String str) {
        this.ErrMsg = str;
    }

    public void setRet(int i3) {
        this.Ret = i3;
    }

    public void setSeqID(int i3) {
        this.SeqID = i3;
    }

    public void setTitle(String str) {
        this.Title = str;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.Ret, 0);
        jceOutputStream.write(this.SeqID, 1);
        String str = this.Title;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.ErrMsg;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        String str3 = this.ButtonDesc;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
        String str4 = this.ButtonUrl;
        if (str4 != null) {
            jceOutputStream.write(str4, 5);
        }
    }

    public RspResOrder(int i3, int i16, String str, String str2, String str3, String str4) {
        this.Ret = i3;
        this.SeqID = i16;
        this.Title = str;
        this.ErrMsg = str2;
        this.ButtonDesc = str3;
        this.ButtonUrl = str4;
    }
}
