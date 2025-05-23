package MessageSvcPack;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class RequestBatchPushFStatus extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static ArrayList<RequestPushFStatus> cache_vBatchFStatusReq;
    public ArrayList<RequestPushFStatus> vBatchFStatusReq = null;

    public RequestBatchPushFStatus() {
        setVBatchFStatusReq(null);
    }

    public String className() {
        return "MessageSvcPack.RequestBatchPushFStatus";
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
        new JceDisplayer(sb5, i3).display((Collection) this.vBatchFStatusReq, "vBatchFStatusReq");
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return JceUtil.equals(this.vBatchFStatusReq, ((RequestBatchPushFStatus) obj).vBatchFStatusReq);
    }

    public String fullClassName() {
        return "MessageSvcPack.RequestBatchPushFStatus";
    }

    public ArrayList<RequestPushFStatus> getVBatchFStatusReq() {
        return this.vBatchFStatusReq;
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
        if (cache_vBatchFStatusReq == null) {
            cache_vBatchFStatusReq = new ArrayList<>();
            cache_vBatchFStatusReq.add(new RequestPushFStatus());
        }
        setVBatchFStatusReq((ArrayList) jceInputStream.read((JceInputStream) cache_vBatchFStatusReq, 0, true));
    }

    public void setVBatchFStatusReq(ArrayList<RequestPushFStatus> arrayList) {
        this.vBatchFStatusReq = arrayList;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.vBatchFStatusReq, 0);
    }

    public RequestBatchPushFStatus(ArrayList<RequestPushFStatus> arrayList) {
        setVBatchFStatusReq(arrayList);
    }
}
