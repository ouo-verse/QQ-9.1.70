package SummaryCard;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RespSearch extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static int cache_eEimKeyType;
    static ArrayList<SearchInfo> cache_vRecords = new ArrayList<>();
    static byte[] cache_vSecureSig;
    static ArrayList<byte[]> cache_vvRespServices;
    static byte[] cache_weiguang;
    public int eEimKeyType;
    public int result;
    public ArrayList<SearchInfo> vRecords;
    public byte[] vSecureSig;
    public ArrayList<byte[]> vvRespServices;
    public byte[] weiguang;

    static {
        cache_vRecords.add(new SearchInfo());
        cache_vSecureSig = r1;
        byte[] bArr = {0};
        ArrayList<byte[]> arrayList = new ArrayList<>();
        cache_vvRespServices = arrayList;
        arrayList.add(new byte[]{0});
        cache_eEimKeyType = 0;
        cache_weiguang = r0;
        byte[] bArr2 = {0};
    }

    public RespSearch() {
        this.vRecords = null;
        this.vSecureSig = null;
        this.vvRespServices = null;
        this.eEimKeyType = 0;
        this.result = 0;
        this.weiguang = null;
    }

    public String className() {
        return "SummaryCard.RespSearch";
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
        jceDisplayer.display((Collection) this.vRecords, "vRecords");
        jceDisplayer.display(this.vSecureSig, "vSecureSig");
        jceDisplayer.display((Collection) this.vvRespServices, "vvRespServices");
        jceDisplayer.display(this.eEimKeyType, "eEimKeyType");
        jceDisplayer.display(this.result, "result");
        jceDisplayer.display(this.weiguang, "weiguang");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.displaySimple((Collection) this.vRecords, true);
        jceDisplayer.displaySimple(this.vSecureSig, true);
        jceDisplayer.displaySimple((Collection) this.vvRespServices, true);
        jceDisplayer.displaySimple(this.eEimKeyType, true);
        jceDisplayer.displaySimple(this.result, true);
        jceDisplayer.displaySimple(this.weiguang, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        RespSearch respSearch = (RespSearch) obj;
        if (!JceUtil.equals(this.vRecords, respSearch.vRecords) || !JceUtil.equals(this.vSecureSig, respSearch.vSecureSig) || !JceUtil.equals(this.vvRespServices, respSearch.vvRespServices) || !JceUtil.equals(this.eEimKeyType, respSearch.eEimKeyType) || !JceUtil.equals(this.result, respSearch.result) || !JceUtil.equals(this.weiguang, respSearch.weiguang)) {
            return false;
        }
        return true;
    }

    public String fullClassName() {
        return "SummaryCard.RespSearch";
    }

    public int getEEimKeyType() {
        return this.eEimKeyType;
    }

    public int getResult() {
        return this.result;
    }

    public ArrayList<SearchInfo> getVRecords() {
        return this.vRecords;
    }

    public byte[] getVSecureSig() {
        return this.vSecureSig;
    }

    public ArrayList<byte[]> getVvRespServices() {
        return this.vvRespServices;
    }

    public byte[] getWeiguang() {
        return this.weiguang;
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
        this.vRecords = (ArrayList) jceInputStream.read((JceInputStream) cache_vRecords, 0, true);
        this.vSecureSig = jceInputStream.read(cache_vSecureSig, 1, false);
        this.vvRespServices = (ArrayList) jceInputStream.read((JceInputStream) cache_vvRespServices, 2, false);
        this.eEimKeyType = jceInputStream.read(this.eEimKeyType, 3, false);
        this.result = jceInputStream.read(this.result, 4, false);
        this.weiguang = jceInputStream.read(cache_weiguang, 5, false);
    }

    public void setEEimKeyType(int i3) {
        this.eEimKeyType = i3;
    }

    public void setResult(int i3) {
        this.result = i3;
    }

    public void setVRecords(ArrayList<SearchInfo> arrayList) {
        this.vRecords = arrayList;
    }

    public void setVSecureSig(byte[] bArr) {
        this.vSecureSig = bArr;
    }

    public void setVvRespServices(ArrayList<byte[]> arrayList) {
        this.vvRespServices = arrayList;
    }

    public void setWeiguang(byte[] bArr) {
        this.weiguang = bArr;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.vRecords, 0);
        byte[] bArr = this.vSecureSig;
        if (bArr != null) {
            jceOutputStream.write(bArr, 1);
        }
        ArrayList<byte[]> arrayList = this.vvRespServices;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        jceOutputStream.write(this.eEimKeyType, 3);
        jceOutputStream.write(this.result, 4);
        byte[] bArr2 = this.weiguang;
        if (bArr2 != null) {
            jceOutputStream.write(bArr2, 5);
        }
    }

    public RespSearch(ArrayList<SearchInfo> arrayList, byte[] bArr, ArrayList<byte[]> arrayList2, int i3, int i16, byte[] bArr2) {
        this.vRecords = arrayList;
        this.vSecureSig = bArr;
        this.vvRespServices = arrayList2;
        this.eEimKeyType = i3;
        this.result = i16;
        this.weiguang = bArr2;
    }
}
