package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SDKUpgradeReq extends JceStruct {
    static ArrayList<Integer> cache_vAppid;
    static ArrayList<String> cache_vUin;
    public byte bJailbreak;
    public boolean bSdkUpdateFlag;
    public byte cProtocolVer;
    public int iActionType;
    public int iHeight;
    public int iWidth;
    public ArrayList<Integer> vAppid;
    public ArrayList<String> vUin;

    public SDKUpgradeReq() {
        this.cProtocolVer = (byte) 0;
        this.vUin = null;
        this.bSdkUpdateFlag = true;
        this.vAppid = null;
        this.iActionType = 0;
        this.iWidth = 0;
        this.iHeight = 0;
        this.bJailbreak = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cProtocolVer = jceInputStream.read(this.cProtocolVer, 1, true);
        if (cache_vUin == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            cache_vUin = arrayList;
            arrayList.add("");
        }
        this.vUin = (ArrayList) jceInputStream.read((JceInputStream) cache_vUin, 2, true);
        this.bSdkUpdateFlag = jceInputStream.read(this.bSdkUpdateFlag, 3, false);
        if (cache_vAppid == null) {
            cache_vAppid = new ArrayList<>();
            cache_vAppid.add(0);
        }
        this.vAppid = (ArrayList) jceInputStream.read((JceInputStream) cache_vAppid, 4, false);
        this.iActionType = jceInputStream.read(this.iActionType, 5, false);
        this.iWidth = jceInputStream.read(this.iWidth, 6, false);
        this.iHeight = jceInputStream.read(this.iHeight, 7, false);
        this.bJailbreak = jceInputStream.read(this.bJailbreak, 8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.cProtocolVer, 1);
        jceOutputStream.write((Collection) this.vUin, 2);
        jceOutputStream.write(this.bSdkUpdateFlag, 3);
        ArrayList<Integer> arrayList = this.vAppid;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 4);
        }
        jceOutputStream.write(this.iActionType, 5);
        jceOutputStream.write(this.iWidth, 6);
        jceOutputStream.write(this.iHeight, 7);
        jceOutputStream.write(this.bJailbreak, 8);
    }

    public SDKUpgradeReq(byte b16, ArrayList<String> arrayList, boolean z16, ArrayList<Integer> arrayList2, int i3, int i16, int i17, byte b17) {
        this.cProtocolVer = b16;
        this.vUin = arrayList;
        this.bSdkUpdateFlag = z16;
        this.vAppid = arrayList2;
        this.iActionType = i3;
        this.iWidth = i16;
        this.iHeight = i17;
        this.bJailbreak = b17;
    }
}
