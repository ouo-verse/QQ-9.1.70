package SLICE_UPLOAD;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UploadTouchuanReq extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static byte[] cache_vReqData;
    public int iUploadType;
    public byte[] vReqData;

    static {
        cache_vReqData = r0;
        byte[] bArr = {0};
    }

    public UploadTouchuanReq() {
        this.iUploadType = 0;
        this.vReqData = null;
    }

    public String className() {
        return "SLICE_UPLOAD.UploadTouchuanReq";
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
        jceDisplayer.display(this.iUploadType, "iUploadType");
        jceDisplayer.display(this.vReqData, "vReqData");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.displaySimple(this.iUploadType, true);
        jceDisplayer.displaySimple(this.vReqData, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        UploadTouchuanReq uploadTouchuanReq = (UploadTouchuanReq) obj;
        if (!JceUtil.equals(this.iUploadType, uploadTouchuanReq.iUploadType) || !JceUtil.equals(this.vReqData, uploadTouchuanReq.vReqData)) {
            return false;
        }
        return true;
    }

    public String fullClassName() {
        return "SLICE_UPLOAD.UploadTouchuanReq";
    }

    public int getIUploadType() {
        return this.iUploadType;
    }

    public byte[] getVReqData() {
        return this.vReqData;
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
        this.iUploadType = jceInputStream.read(this.iUploadType, 0, true);
        this.vReqData = jceInputStream.read(cache_vReqData, 1, true);
    }

    public void setIUploadType(int i3) {
        this.iUploadType = i3;
    }

    public void setVReqData(byte[] bArr) {
        this.vReqData = bArr;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iUploadType, 0);
        jceOutputStream.write(this.vReqData, 1);
    }

    public UploadTouchuanReq(int i3, byte[] bArr) {
        this.iUploadType = i3;
        this.vReqData = bArr;
    }
}
