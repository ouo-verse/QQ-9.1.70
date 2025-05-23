package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class PrivilegeBaseInfo extends JceStruct {
    static ArrayList<PrivilegeInfo> cache_vClosePriv;
    static ArrayList<PrivilegeInfo> cache_vOpenPriv = new ArrayList<>();
    public String strJumpUrl;
    public String strMsg;
    public ArrayList<PrivilegeInfo> vClosePriv;
    public ArrayList<PrivilegeInfo> vOpenPriv;

    static {
        cache_vOpenPriv.add(new PrivilegeInfo());
        cache_vClosePriv = new ArrayList<>();
        cache_vClosePriv.add(new PrivilegeInfo());
    }

    public PrivilegeBaseInfo() {
        this.strMsg = "";
        this.strJumpUrl = "";
        this.vOpenPriv = null;
        this.vClosePriv = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strMsg = jceInputStream.readString(0, true);
        this.strJumpUrl = jceInputStream.readString(1, true);
        this.vOpenPriv = (ArrayList) jceInputStream.read((JceInputStream) cache_vOpenPriv, 2, false);
        this.vClosePriv = (ArrayList) jceInputStream.read((JceInputStream) cache_vClosePriv, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.strMsg, 0);
        jceOutputStream.write(this.strJumpUrl, 1);
        ArrayList<PrivilegeInfo> arrayList = this.vOpenPriv;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        ArrayList<PrivilegeInfo> arrayList2 = this.vClosePriv;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 3);
        }
    }

    public PrivilegeBaseInfo(String str, String str2, ArrayList<PrivilegeInfo> arrayList, ArrayList<PrivilegeInfo> arrayList2) {
        this.strMsg = str;
        this.strJumpUrl = str2;
        this.vOpenPriv = arrayList;
        this.vClosePriv = arrayList2;
    }
}
