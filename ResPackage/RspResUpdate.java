package ResPackage;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RspResUpdate extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static int cache_ResID;
    static ArrayList<ResUpdate> cache_ResInfo;
    static int cache_Ret;
    public int ResID;
    public ArrayList<ResUpdate> ResInfo;
    public int Ret;
    public long SeqID;

    public RspResUpdate() {
        this.Ret = 0;
        this.SeqID = 0L;
        this.ResInfo = null;
        this.ResID = 0;
    }

    public String className() {
        return "ResPackage.RspResUpdate";
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
        jceDisplayer.display((Collection) this.ResInfo, "ResInfo");
        jceDisplayer.display(this.ResID, "ResID");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.displaySimple(this.Ret, true);
        jceDisplayer.displaySimple(this.SeqID, true);
        jceDisplayer.displaySimple((Collection) this.ResInfo, true);
        jceDisplayer.displaySimple(this.ResID, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        RspResUpdate rspResUpdate = (RspResUpdate) obj;
        if (!JceUtil.equals(this.Ret, rspResUpdate.Ret) || !JceUtil.equals(this.SeqID, rspResUpdate.SeqID) || !JceUtil.equals(this.ResInfo, rspResUpdate.ResInfo) || !JceUtil.equals(this.ResID, rspResUpdate.ResID)) {
            return false;
        }
        return true;
    }

    public String fullClassName() {
        return "ResPackage.RspResUpdate";
    }

    public int getResID() {
        return this.ResID;
    }

    public ArrayList<ResUpdate> getResInfo() {
        return this.ResInfo;
    }

    public int getRet() {
        return this.Ret;
    }

    public long getSeqID() {
        return this.SeqID;
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
        if (cache_ResInfo == null) {
            cache_ResInfo = new ArrayList<>();
            cache_ResInfo.add(new ResUpdate());
        }
        this.ResInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_ResInfo, 2, false);
        this.ResID = jceInputStream.read(this.ResID, 3, false);
    }

    public void setResID(int i3) {
        this.ResID = i3;
    }

    public void setResInfo(ArrayList<ResUpdate> arrayList) {
        this.ResInfo = arrayList;
    }

    public void setRet(int i3) {
        this.Ret = i3;
    }

    public void setSeqID(long j3) {
        this.SeqID = j3;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.Ret, 0);
        jceOutputStream.write(this.SeqID, 1);
        ArrayList<ResUpdate> arrayList = this.ResInfo;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        jceOutputStream.write(this.ResID, 3);
    }

    public RspResUpdate(int i3, long j3, ArrayList<ResUpdate> arrayList, int i16) {
        this.Ret = i3;
        this.SeqID = j3;
        this.ResInfo = arrayList;
        this.ResID = i16;
    }
}
