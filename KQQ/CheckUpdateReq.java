package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CheckUpdateReq extends JceStruct {
    static ArrayList<ReqItem> cache_vecReqPkg;
    public boolean isSupportSubPack;
    public ArrayList<ReqItem> vecReqPkg;

    public CheckUpdateReq() {
        this.vecReqPkg = null;
        this.isSupportSubPack = false;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_vecReqPkg == null) {
            cache_vecReqPkg = new ArrayList<>();
            cache_vecReqPkg.add(new ReqItem());
        }
        this.vecReqPkg = (ArrayList) jceInputStream.read((JceInputStream) cache_vecReqPkg, 0, true);
        this.isSupportSubPack = jceInputStream.read(this.isSupportSubPack, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.vecReqPkg, 0);
        jceOutputStream.write(this.isSupportSubPack, 1);
    }

    public CheckUpdateReq(ArrayList<ReqItem> arrayList, boolean z16) {
        this.vecReqPkg = arrayList;
        this.isSupportSubPack = z16;
    }
}
