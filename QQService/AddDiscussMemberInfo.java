package QQService;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AddDiscussMemberInfo extends JceStruct {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public String RefStr;
    public long RefUin;
    public int Type;
    public long Uin;

    public AddDiscussMemberInfo() {
        this.Uin = 0L;
        this.Type = 0;
        this.RefUin = 0L;
        this.RefStr = "";
    }

    public String className() {
        return "QQService.AddDiscussMemberInfo";
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
        jceDisplayer.display(this.Uin, "Uin");
        jceDisplayer.display(this.Type, "Type");
        jceDisplayer.display(this.RefUin, "RefUin");
        jceDisplayer.display(this.RefStr, "RefStr");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.displaySimple(this.Uin, true);
        jceDisplayer.displaySimple(this.Type, true);
        jceDisplayer.displaySimple(this.RefUin, true);
        jceDisplayer.displaySimple(this.RefStr, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        AddDiscussMemberInfo addDiscussMemberInfo = (AddDiscussMemberInfo) obj;
        if (!JceUtil.equals(this.Uin, addDiscussMemberInfo.Uin) || !JceUtil.equals(this.Type, addDiscussMemberInfo.Type) || !JceUtil.equals(this.RefUin, addDiscussMemberInfo.RefUin) || !JceUtil.equals(this.RefStr, addDiscussMemberInfo.RefStr)) {
            return false;
        }
        return true;
    }

    public String fullClassName() {
        return "QQService.AddDiscussMemberInfo";
    }

    public long getUin() {
        return this.Uin;
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
        this.Uin = jceInputStream.read(this.Uin, 0, true);
        this.Type = jceInputStream.read(this.Type, 1, true);
        this.RefUin = jceInputStream.read(this.RefUin, 2, false);
        this.RefStr = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.Uin, 0);
        jceOutputStream.write(this.Type, 1);
        jceOutputStream.write(this.RefUin, 2);
        String str = this.RefStr;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
    }

    public AddDiscussMemberInfo(long j3, int i3, long j16, String str) {
        this.Uin = j3;
        this.Type = i3;
        this.RefUin = j16;
        this.RefStr = str;
    }
}
