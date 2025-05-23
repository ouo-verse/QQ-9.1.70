package MAAccessClient;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class CheckSinglePkgSigRsp extends JceStruct {
    static ArrayList<NoCheckMarket> cache_vtMarket = new ArrayList<>();
    public String pageUrl;
    public String pkgSig;
    public int ret;
    public int sigVersionCode;
    public String tmastUrl;
    public ArrayList<NoCheckMarket> vtMarket;

    static {
        cache_vtMarket.add(new NoCheckMarket());
    }

    public CheckSinglePkgSigRsp() {
        this.ret = 0;
        this.vtMarket = null;
        this.pkgSig = "";
        this.sigVersionCode = 0;
        this.tmastUrl = "";
        this.pageUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, true);
        this.vtMarket = (ArrayList) jceInputStream.read((JceInputStream) cache_vtMarket, 1, false);
        this.pkgSig = jceInputStream.readString(2, false);
        this.sigVersionCode = jceInputStream.read(this.sigVersionCode, 3, false);
        this.tmastUrl = jceInputStream.readString(4, false);
        this.pageUrl = jceInputStream.readString(5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        ArrayList<NoCheckMarket> arrayList = this.vtMarket;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        String str = this.pkgSig;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        jceOutputStream.write(this.sigVersionCode, 3);
        String str2 = this.tmastUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        String str3 = this.pageUrl;
        if (str3 != null) {
            jceOutputStream.write(str3, 5);
        }
    }

    public CheckSinglePkgSigRsp(int i3, ArrayList<NoCheckMarket> arrayList, String str, int i16, String str2, String str3) {
        this.ret = i3;
        this.vtMarket = arrayList;
        this.pkgSig = str;
        this.sigVersionCode = i16;
        this.tmastUrl = str2;
        this.pageUrl = str3;
    }
}
