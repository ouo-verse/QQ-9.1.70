package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class ProfFullUsrQryReq extends JceStruct {
    static ArrayList<Long> cache_vFriendUin;
    public int iAppId;
    public int iGetTagFlag;
    public int iReloadFlag;
    public int iRetIncomPlete;
    public String strSessionKey;
    public long usruin;
    public ArrayList<Long> vFriendUin;

    public ProfFullUsrQryReq() {
        this.iAppId = 0;
        this.strSessionKey = "";
        this.usruin = 0L;
        this.vFriendUin = null;
        this.iRetIncomPlete = 0;
        this.iReloadFlag = 0;
        this.iGetTagFlag = -1;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iAppId = jceInputStream.read(this.iAppId, 1, true);
        this.strSessionKey = jceInputStream.readString(2, true);
        this.usruin = jceInputStream.read(this.usruin, 3, true);
        if (cache_vFriendUin == null) {
            cache_vFriendUin = new ArrayList<>();
            cache_vFriendUin.add(0L);
        }
        this.vFriendUin = (ArrayList) jceInputStream.read((JceInputStream) cache_vFriendUin, 4, false);
        this.iRetIncomPlete = jceInputStream.read(this.iRetIncomPlete, 5, false);
        this.iReloadFlag = jceInputStream.read(this.iReloadFlag, 6, false);
        this.iGetTagFlag = jceInputStream.read(this.iGetTagFlag, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iAppId, 1);
        jceOutputStream.write(this.strSessionKey, 2);
        jceOutputStream.write(this.usruin, 3);
        ArrayList<Long> arrayList = this.vFriendUin;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 4);
        }
        jceOutputStream.write(this.iRetIncomPlete, 5);
        jceOutputStream.write(this.iReloadFlag, 6);
        jceOutputStream.write(this.iGetTagFlag, 7);
    }

    public ProfFullUsrQryReq(int i3, String str, long j3, ArrayList<Long> arrayList, int i16, int i17, int i18) {
        this.iAppId = i3;
        this.strSessionKey = str;
        this.usruin = j3;
        this.vFriendUin = arrayList;
        this.iRetIncomPlete = i16;
        this.iReloadFlag = i17;
        this.iGetTagFlag = i18;
    }
}
