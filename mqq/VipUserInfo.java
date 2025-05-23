package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class VipUserInfo extends JceStruct {
    static ArrayList<Long> cache_vSendList = new ArrayList<>();
    public int bUpdate;
    public int iCanUseRed;
    public int iCheckFreq;
    public int iGrowthSpeed;
    public int iGrowthValue;
    public int iHomeType;
    public int iOpenSVip;
    public int iOpenVip;
    public int iRedDisable;
    public int iRedPackId;
    public int iSendDisable;
    public int iUpdateFreq;
    public long iUpdateTime;
    public int iVipLevel;
    public int iVipType;
    public String sGrayTail;
    public String sRedPackRemard;
    public String sUri;
    public ArrayList<Long> vSendList;

    static {
        cache_vSendList.add(0L);
    }

    public VipUserInfo() {
        this.iOpenVip = -1;
        this.iOpenSVip = -1;
        this.iVipLevel = -1;
        this.iVipType = -1;
        this.iGrowthValue = -1;
        this.iGrowthSpeed = -1;
        this.iUpdateTime = -1L;
        this.iUpdateFreq = -1;
        this.sUri = "";
        this.iCanUseRed = -1;
        this.iRedDisable = -1;
        this.iSendDisable = -1;
        this.iCheckFreq = -1;
        this.sGrayTail = "";
        this.vSendList = null;
        this.iRedPackId = -1;
        this.sRedPackRemard = "";
        this.bUpdate = 0;
        this.iHomeType = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iOpenVip = jceInputStream.read(this.iOpenVip, 1, true);
        this.iOpenSVip = jceInputStream.read(this.iOpenSVip, 2, true);
        this.iVipLevel = jceInputStream.read(this.iVipLevel, 3, true);
        this.iVipType = jceInputStream.read(this.iVipType, 4, true);
        this.iGrowthValue = jceInputStream.read(this.iGrowthValue, 5, true);
        this.iGrowthSpeed = jceInputStream.read(this.iGrowthSpeed, 6, true);
        this.iUpdateTime = jceInputStream.read(this.iUpdateTime, 7, false);
        this.iUpdateFreq = jceInputStream.read(this.iUpdateFreq, 8, false);
        this.sUri = jceInputStream.readString(9, false);
        this.iCanUseRed = jceInputStream.read(this.iCanUseRed, 10, false);
        this.iRedDisable = jceInputStream.read(this.iRedDisable, 11, false);
        this.iSendDisable = jceInputStream.read(this.iSendDisable, 12, false);
        this.iCheckFreq = jceInputStream.read(this.iCheckFreq, 13, false);
        this.sGrayTail = jceInputStream.readString(14, false);
        this.vSendList = (ArrayList) jceInputStream.read((JceInputStream) cache_vSendList, 15, false);
        this.iRedPackId = jceInputStream.read(this.iRedPackId, 16, false);
        this.sRedPackRemard = jceInputStream.readString(17, false);
        this.bUpdate = jceInputStream.read(this.bUpdate, 18, false);
        this.iHomeType = jceInputStream.read(this.iHomeType, 19, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iOpenVip, 1);
        jceOutputStream.write(this.iOpenSVip, 2);
        jceOutputStream.write(this.iVipLevel, 3);
        jceOutputStream.write(this.iVipType, 4);
        jceOutputStream.write(this.iGrowthValue, 5);
        jceOutputStream.write(this.iGrowthSpeed, 6);
        jceOutputStream.write(this.iUpdateTime, 7);
        jceOutputStream.write(this.iUpdateFreq, 8);
        String str = this.sUri;
        if (str != null) {
            jceOutputStream.write(str, 9);
        }
        jceOutputStream.write(this.iCanUseRed, 10);
        jceOutputStream.write(this.iRedDisable, 11);
        jceOutputStream.write(this.iSendDisable, 12);
        jceOutputStream.write(this.iCheckFreq, 13);
        String str2 = this.sGrayTail;
        if (str2 != null) {
            jceOutputStream.write(str2, 14);
        }
        ArrayList<Long> arrayList = this.vSendList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 15);
        }
        jceOutputStream.write(this.iRedPackId, 16);
        String str3 = this.sRedPackRemard;
        if (str3 != null) {
            jceOutputStream.write(str3, 17);
        }
        jceOutputStream.write(this.bUpdate, 18);
        jceOutputStream.write(this.iHomeType, 19);
    }

    public VipUserInfo(int i3, int i16, int i17, int i18, int i19, int i26, long j3, int i27, String str, int i28, int i29, int i36, int i37, String str2, ArrayList<Long> arrayList, int i38, String str3, int i39, int i46) {
        this.iOpenVip = i3;
        this.iOpenSVip = i16;
        this.iVipLevel = i17;
        this.iVipType = i18;
        this.iGrowthValue = i19;
        this.iGrowthSpeed = i26;
        this.iUpdateTime = j3;
        this.iUpdateFreq = i27;
        this.sUri = str;
        this.iCanUseRed = i28;
        this.iRedDisable = i29;
        this.iSendDisable = i36;
        this.iCheckFreq = i37;
        this.sGrayTail = str2;
        this.vSendList = arrayList;
        this.iRedPackId = i38;
        this.sRedPackRemard = str3;
        this.bUpdate = i39;
        this.iHomeType = i46;
    }
}
