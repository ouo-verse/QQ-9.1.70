package PayMQQ;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

/* loaded from: classes.dex */
public final class UniPayRequest extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public String sPlatform;
    public String sUin;

    public UniPayRequest() {
        this.sUin = "";
        this.sPlatform = "";
    }

    public String className() {
        return "MQQ.UniPayRequest";
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
        jceDisplayer.display(this.sUin, "sUin");
        jceDisplayer.display(this.sPlatform, "sPlatform");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.displaySimple(this.sUin, true);
        jceDisplayer.displaySimple(this.sPlatform, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        UniPayRequest uniPayRequest = (UniPayRequest) obj;
        if (!JceUtil.equals(this.sUin, uniPayRequest.sUin) || !JceUtil.equals(this.sPlatform, uniPayRequest.sPlatform)) {
            return false;
        }
        return true;
    }

    public String fullClassName() {
        return "MQQ.UniPayRequest";
    }

    public String getSPlatform() {
        return this.sPlatform;
    }

    public String getSUin() {
        return this.sUin;
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
        this.sUin = jceInputStream.readString(0, true);
        this.sPlatform = jceInputStream.readString(1, true);
    }

    public void setSPlatform(String str) {
        this.sPlatform = str;
    }

    public void setSUin(String str) {
        this.sUin = str;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.sUin, 0);
        jceOutputStream.write(this.sPlatform, 1);
    }

    public UniPayRequest(String str, String str2) {
        this.sUin = str;
        this.sPlatform = str2;
    }
}
