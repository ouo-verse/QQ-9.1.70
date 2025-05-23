package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SyncReq extends JceStruct {
    static UserData cache_userData;
    static ArrayList<InfoItem> cache_vecReqPkg;
    public UserData userData;
    public ArrayList<InfoItem> vecReqPkg;

    public SyncReq() {
        this.vecReqPkg = null;
        this.userData = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_vecReqPkg == null) {
            cache_vecReqPkg = new ArrayList<>();
            cache_vecReqPkg.add(new InfoItem());
        }
        this.vecReqPkg = (ArrayList) jceInputStream.read((JceInputStream) cache_vecReqPkg, 0, true);
        if (cache_userData == null) {
            cache_userData = new UserData();
        }
        this.userData = (UserData) jceInputStream.read((JceStruct) cache_userData, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.vecReqPkg, 0);
        UserData userData = this.userData;
        if (userData != null) {
            jceOutputStream.write((JceStruct) userData, 1);
        }
    }

    public SyncReq(ArrayList<InfoItem> arrayList, UserData userData) {
        this.vecReqPkg = arrayList;
        this.userData = userData;
    }
}
