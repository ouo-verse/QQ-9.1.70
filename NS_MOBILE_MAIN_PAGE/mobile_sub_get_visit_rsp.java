package NS_MOBILE_MAIN_PAGE;

import NS_MOBILE_AD_BANNER.QueryADBannerUnit;
import NS_MOBILE_COMM.ParasiticUnit;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_sub_get_visit_rsp extends JceStruct {
    static ArrayList<QueryADBannerUnit> cache_vecAdBanner;
    static ArrayList<ParasiticUnit> cache_vecParasiticUnit;
    static s_visit cache_visit;
    public boolean end;
    public int nextTimeInterval;
    public String page;
    public ArrayList<QueryADBannerUnit> vecAdBanner;
    public ArrayList<ParasiticUnit> vecParasiticUnit;
    public s_visit visit;

    public mobile_sub_get_visit_rsp() {
        this.page = "";
        this.end = true;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_visit == null) {
            cache_visit = new s_visit();
        }
        this.visit = (s_visit) jceInputStream.read((JceStruct) cache_visit, 0, false);
        this.page = jceInputStream.readString(1, false);
        this.end = jceInputStream.read(this.end, 2, false);
        if (cache_vecAdBanner == null) {
            cache_vecAdBanner = new ArrayList<>();
            cache_vecAdBanner.add(new QueryADBannerUnit());
        }
        this.vecAdBanner = (ArrayList) jceInputStream.read((JceInputStream) cache_vecAdBanner, 3, false);
        if (cache_vecParasiticUnit == null) {
            cache_vecParasiticUnit = new ArrayList<>();
            cache_vecParasiticUnit.add(new ParasiticUnit());
        }
        this.vecParasiticUnit = (ArrayList) jceInputStream.read((JceInputStream) cache_vecParasiticUnit, 4, false);
        this.nextTimeInterval = jceInputStream.read(this.nextTimeInterval, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        s_visit s_visitVar = this.visit;
        if (s_visitVar != null) {
            jceOutputStream.write((JceStruct) s_visitVar, 0);
        }
        String str = this.page;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.end, 2);
        ArrayList<QueryADBannerUnit> arrayList = this.vecAdBanner;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
        ArrayList<ParasiticUnit> arrayList2 = this.vecParasiticUnit;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 4);
        }
        jceOutputStream.write(this.nextTimeInterval, 5);
    }

    public mobile_sub_get_visit_rsp(s_visit s_visitVar, String str, boolean z16, ArrayList<QueryADBannerUnit> arrayList, ArrayList<ParasiticUnit> arrayList2, int i3) {
        this.visit = s_visitVar;
        this.page = str;
        this.end = z16;
        this.vecAdBanner = arrayList;
        this.vecParasiticUnit = arrayList2;
        this.nextTimeInterval = i3;
    }
}
