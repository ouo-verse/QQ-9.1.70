package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UniBusiGetSimpleItemReq extends JceStruct {
    public Map<Integer, ArrayList<Integer>> mAppidItems;
    public LoginInfo stLogin;
    static LoginInfo cache_stLogin = new LoginInfo();
    static Map<Integer, ArrayList<Integer>> cache_mAppidItems = new HashMap();

    static {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(0);
        cache_mAppidItems.put(0, arrayList);
    }

    public UniBusiGetSimpleItemReq() {
        this.stLogin = null;
        this.mAppidItems = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stLogin = (LoginInfo) jceInputStream.read((JceStruct) cache_stLogin, 0, false);
        this.mAppidItems = (Map) jceInputStream.read((JceInputStream) cache_mAppidItems, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        LoginInfo loginInfo = this.stLogin;
        if (loginInfo != null) {
            jceOutputStream.write((JceStruct) loginInfo, 0);
        }
        Map<Integer, ArrayList<Integer>> map = this.mAppidItems;
        if (map != null) {
            jceOutputStream.write((Map) map, 1);
        }
    }

    public UniBusiGetSimpleItemReq(LoginInfo loginInfo, Map<Integer, ArrayList<Integer>> map) {
        this.stLogin = loginInfo;
        this.mAppidItems = map;
    }
}
