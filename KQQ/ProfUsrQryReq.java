package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class ProfUsrQryReq extends JceStruct {
    static ArrayList<Long> cache_vUin;
    public byte cGetBusiCardFlag;
    public byte cGetDateNick;
    public byte cGetSig;
    public byte cGetSpecialFlag;
    public int iAppId;
    public int iGetLevel;
    public int iGetXManInfo;
    public int iGetXManInfoScene;
    public int iReloadFlag;
    public int iRetIncomPlete;
    public String strSessionKey;
    public ArrayList<Long> vUin;

    public ProfUsrQryReq() {
        this.iAppId = 0;
        this.strSessionKey = "";
        this.vUin = null;
        this.iRetIncomPlete = 0;
        this.iReloadFlag = 0;
        this.cGetSig = (byte) 0;
        this.iGetLevel = 0;
        this.iGetXManInfo = 0;
        this.cGetSpecialFlag = (byte) 0;
        this.cGetDateNick = (byte) 0;
        this.cGetBusiCardFlag = (byte) 0;
        this.iGetXManInfoScene = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iAppId = jceInputStream.read(this.iAppId, 1, true);
        this.strSessionKey = jceInputStream.readString(2, true);
        if (cache_vUin == null) {
            cache_vUin = new ArrayList<>();
            cache_vUin.add(0L);
        }
        this.vUin = (ArrayList) jceInputStream.read((JceInputStream) cache_vUin, 3, true);
        this.iRetIncomPlete = jceInputStream.read(this.iRetIncomPlete, 4, false);
        this.iReloadFlag = jceInputStream.read(this.iReloadFlag, 5, false);
        this.cGetSig = jceInputStream.read(this.cGetSig, 6, false);
        this.iGetLevel = jceInputStream.read(this.iGetLevel, 7, false);
        this.iGetXManInfo = jceInputStream.read(this.iGetXManInfo, 8, false);
        this.cGetSpecialFlag = jceInputStream.read(this.cGetSpecialFlag, 9, false);
        this.cGetDateNick = jceInputStream.read(this.cGetDateNick, 10, false);
        this.cGetBusiCardFlag = jceInputStream.read(this.cGetBusiCardFlag, 11, false);
        this.iGetXManInfoScene = jceInputStream.read(this.iGetXManInfoScene, 101, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iAppId, 1);
        jceOutputStream.write(this.strSessionKey, 2);
        jceOutputStream.write((Collection) this.vUin, 3);
        jceOutputStream.write(this.iRetIncomPlete, 4);
        jceOutputStream.write(this.iReloadFlag, 5);
        jceOutputStream.write(this.cGetSig, 6);
        jceOutputStream.write(this.iGetLevel, 7);
        jceOutputStream.write(this.iGetXManInfo, 8);
        jceOutputStream.write(this.cGetSpecialFlag, 9);
        jceOutputStream.write(this.cGetDateNick, 10);
        jceOutputStream.write(this.cGetBusiCardFlag, 11);
        jceOutputStream.write(this.iGetXManInfoScene, 101);
    }

    public ProfUsrQryReq(int i3, String str, ArrayList<Long> arrayList, int i16, int i17, byte b16, int i18, int i19, byte b17, byte b18, byte b19, int i26) {
        this.iAppId = i3;
        this.strSessionKey = str;
        this.vUin = arrayList;
        this.iRetIncomPlete = i16;
        this.iReloadFlag = i17;
        this.cGetSig = b16;
        this.iGetLevel = i18;
        this.iGetXManInfo = i19;
        this.cGetSpecialFlag = b17;
        this.cGetDateNick = b18;
        this.cGetBusiCardFlag = b19;
        this.iGetXManInfoScene = i26;
    }
}
