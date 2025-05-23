package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetConciseThemeRsp extends JceStruct {
    static CommonRsp cache_stRet = new CommonRsp();
    static ArrayList<ItemDisDetail> cache_vItems = new ArrayList<>();
    public CommonRsp stRet;
    public ArrayList<ItemDisDetail> vItems;

    static {
        cache_vItems.add(new ItemDisDetail());
    }

    public GetConciseThemeRsp() {
        this.stRet = null;
        this.vItems = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stRet = (CommonRsp) jceInputStream.read((JceStruct) cache_stRet, 0, false);
        this.vItems = (ArrayList) jceInputStream.read((JceInputStream) cache_vItems, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        CommonRsp commonRsp = this.stRet;
        if (commonRsp != null) {
            jceOutputStream.write((JceStruct) commonRsp, 0);
        }
        ArrayList<ItemDisDetail> arrayList = this.vItems;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
    }

    public GetConciseThemeRsp(CommonRsp commonRsp, ArrayList<ItemDisDetail> arrayList) {
        this.stRet = commonRsp;
        this.vItems = arrayList;
    }
}
