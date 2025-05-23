package ResPackage;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqResOrder extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static byte[] cache_PkgInfo;
    static int cache_ResID;
    public String Path;
    public byte[] PkgInfo;
    public int ResID;

    public ReqResOrder() {
        this.ResID = 0;
        this.Path = "";
        this.PkgInfo = null;
    }

    public String className() {
        return "ResPackage.ReqResOrder";
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
        jceDisplayer.display(this.ResID, "ResID");
        jceDisplayer.display(this.Path, "Path");
        jceDisplayer.display(this.PkgInfo, "PkgInfo");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.displaySimple(this.ResID, true);
        jceDisplayer.displaySimple(this.Path, true);
        jceDisplayer.displaySimple(this.PkgInfo, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        ReqResOrder reqResOrder = (ReqResOrder) obj;
        if (!JceUtil.equals(this.ResID, reqResOrder.ResID) || !JceUtil.equals(this.Path, reqResOrder.Path) || !JceUtil.equals(this.PkgInfo, reqResOrder.PkgInfo)) {
            return false;
        }
        return true;
    }

    public String fullClassName() {
        return "ResPackage.ReqResOrder";
    }

    public String getPath() {
        return this.Path;
    }

    public byte[] getPkgInfo() {
        return this.PkgInfo;
    }

    public int getResID() {
        return this.ResID;
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
        this.ResID = jceInputStream.read(this.ResID, 0, true);
        this.Path = jceInputStream.readString(1, true);
        if (cache_PkgInfo == null) {
            cache_PkgInfo = r0;
            byte[] bArr = {0};
        }
        this.PkgInfo = jceInputStream.read(cache_PkgInfo, 2, false);
    }

    public void setPath(String str) {
        this.Path = str;
    }

    public void setPkgInfo(byte[] bArr) {
        this.PkgInfo = bArr;
    }

    public void setResID(int i3) {
        this.ResID = i3;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ResID, 0);
        jceOutputStream.write(this.Path, 1);
        byte[] bArr = this.PkgInfo;
        if (bArr != null) {
            jceOutputStream.write(bArr, 2);
        }
    }

    public ReqResOrder(int i3, String str, byte[] bArr) {
        this.ResID = i3;
        this.Path = str;
        this.PkgInfo = bArr;
    }
}
