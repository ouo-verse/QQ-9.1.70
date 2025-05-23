package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqSearch extends JceStruct {
    static ArrayList<byte[]> cache_vvReqServices;
    public int shVersion;
    public String strCountryCode;
    public String strKeyword;
    public ArrayList<byte[]> vvReqServices;

    public ReqSearch() {
        this.strKeyword = "";
        this.strCountryCode = "";
        this.shVersion = 0;
        this.vvReqServices = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strKeyword = jceInputStream.readString(0, true);
        this.strCountryCode = jceInputStream.readString(1, true);
        this.shVersion = jceInputStream.read(this.shVersion, 2, false);
        if (cache_vvReqServices == null) {
            ArrayList<byte[]> arrayList = new ArrayList<>();
            cache_vvReqServices = arrayList;
            arrayList.add(new byte[]{0});
        }
        this.vvReqServices = (ArrayList) jceInputStream.read((JceInputStream) cache_vvReqServices, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.strKeyword, 0);
        jceOutputStream.write(this.strCountryCode, 1);
        jceOutputStream.write(this.shVersion, 2);
        ArrayList<byte[]> arrayList = this.vvReqServices;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
    }

    public ReqSearch(String str, String str2, int i3, ArrayList<byte[]> arrayList) {
        this.strKeyword = str;
        this.strCountryCode = str2;
        this.shVersion = i3;
        this.vvReqServices = arrayList;
    }
}
