package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UniGetReq extends JceStruct {
    public ArrayList<Integer> appidList;
    public int oidbType;
    public LoginInfo stLogin;
    static LoginInfo cache_stLogin = new LoginInfo();
    static ArrayList<Integer> cache_appidList = new ArrayList<>();

    static {
        cache_appidList.add(0);
    }

    public UniGetReq() {
        this.stLogin = null;
        this.appidList = null;
        this.oidbType = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stLogin = (LoginInfo) jceInputStream.read((JceStruct) cache_stLogin, 0, true);
        this.appidList = (ArrayList) jceInputStream.read((JceInputStream) cache_appidList, 1, true);
        this.oidbType = jceInputStream.read(this.oidbType, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stLogin, 0);
        jceOutputStream.write((Collection) this.appidList, 1);
        jceOutputStream.write(this.oidbType, 2);
    }

    public UniGetReq(LoginInfo loginInfo, ArrayList<Integer> arrayList, int i3) {
        this.stLogin = loginInfo;
        this.appidList = arrayList;
        this.oidbType = i3;
    }
}
