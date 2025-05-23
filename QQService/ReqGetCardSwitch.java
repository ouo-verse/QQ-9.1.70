package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqGetCardSwitch extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static ReqHead cache_stHeader;
    public ReqHead stHeader;

    public ReqGetCardSwitch() {
        this.stHeader = null;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return JceUtil.equals(this.stHeader, ((ReqGetCardSwitch) obj).stHeader);
    }

    public ReqHead getStHeader() {
        return this.stHeader;
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
        if (cache_stHeader == null) {
            cache_stHeader = new ReqHead();
        }
        this.stHeader = (ReqHead) jceInputStream.read((JceStruct) cache_stHeader, 0, true);
    }

    public void setStHeader(ReqHead reqHead) {
        this.stHeader = reqHead;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stHeader, 0);
    }

    public ReqGetCardSwitch(ReqHead reqHead) {
        this.stHeader = reqHead;
    }
}
