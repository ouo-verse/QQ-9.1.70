package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class PfaFriendRsp extends JceStruct {
    static ArrayList<String> cache_vecPfaMsg;
    static ArrayList<PfaFriend> cache_vecRec = new ArrayList<>();
    static ArrayList<PfaFriend> cache_vecSpfaRec;
    public int ret = 0;
    public int use_default = 0;
    public ArrayList<PfaFriend> vecRec = null;
    public String pfa_msg_edition = "";
    public ArrayList<String> vecPfaMsg = null;
    public ArrayList<PfaFriend> vecSpfaRec = null;

    static {
        cache_vecRec.add(new PfaFriend());
        ArrayList<String> arrayList = new ArrayList<>();
        cache_vecPfaMsg = arrayList;
        arrayList.add("");
        cache_vecSpfaRec = new ArrayList<>();
        cache_vecSpfaRec.add(new PfaFriend());
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, true);
        this.use_default = jceInputStream.read(this.use_default, 1, true);
        this.vecRec = (ArrayList) jceInputStream.read((JceInputStream) cache_vecRec, 2, false);
        this.pfa_msg_edition = jceInputStream.readString(3, false);
        this.vecPfaMsg = (ArrayList) jceInputStream.read((JceInputStream) cache_vecPfaMsg, 4, false);
        this.vecSpfaRec = (ArrayList) jceInputStream.read((JceInputStream) cache_vecSpfaRec, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        jceOutputStream.write(this.use_default, 1);
        ArrayList<PfaFriend> arrayList = this.vecRec;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        String str = this.pfa_msg_edition;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        ArrayList<String> arrayList2 = this.vecPfaMsg;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 4);
        }
        ArrayList<PfaFriend> arrayList3 = this.vecSpfaRec;
        if (arrayList3 != null) {
            jceOutputStream.write((Collection) arrayList3, 5);
        }
    }
}
