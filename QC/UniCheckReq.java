package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UniCheckReq extends JceStruct {
    static LoginInfo cache_stLogin = new LoginInfo();
    static ArrayList<UniBusinessItem> cache_uniBusinessItemList = new ArrayList<>();
    public LoginInfo stLogin;
    public ArrayList<UniBusinessItem> uniBusinessItemList;

    static {
        cache_uniBusinessItemList.add(new UniBusinessItem());
    }

    public UniCheckReq() {
        this.stLogin = null;
        this.uniBusinessItemList = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stLogin = (LoginInfo) jceInputStream.read((JceStruct) cache_stLogin, 0, false);
        this.uniBusinessItemList = (ArrayList) jceInputStream.read((JceInputStream) cache_uniBusinessItemList, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        LoginInfo loginInfo = this.stLogin;
        if (loginInfo != null) {
            jceOutputStream.write((JceStruct) loginInfo, 0);
        }
        ArrayList<UniBusinessItem> arrayList = this.uniBusinessItemList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
    }

    public UniCheckReq(LoginInfo loginInfo, ArrayList<UniBusinessItem> arrayList) {
        this.stLogin = loginInfo;
        this.uniBusinessItemList = arrayList;
    }
}
