package PersonalState;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.richstatus.RichStatus;

/* loaded from: classes.dex */
public final class UserProfile extends JceStruct {
    static stRishState cache_oRishState;
    static byte[] cache_vSig;
    public byte bAge;
    public byte bSex;
    public int iDistance;
    public int iLat;
    public int iLon;
    public long lEctID;
    public long nPicNum;
    public long nStatus;
    public stRishState oRishState;
    public long richTime;

    /* renamed from: rs, reason: collision with root package name */
    public RichStatus f25082rs;
    public String strDesc;
    public String strLocation;
    public String strNick;
    public byte[] vSig;
    public short wFace;

    public UserProfile() {
        this.lEctID = 0L;
        this.wFace = (short) 0;
        this.bSex = (byte) 2;
        this.bAge = (byte) -1;
        this.strNick = "";
        this.oRishState = null;
        this.vSig = null;
        this.strLocation = "";
        this.strDesc = "";
        this.iDistance = -1;
        this.iLat = 900000000;
        this.iLon = 900000000;
        this.nPicNum = 0L;
        this.nStatus = 0L;
    }

    public RichStatus getRichStatus() {
        if (this.f25082rs == null) {
            RichStatus parseStatus = RichStatus.parseStatus(this.oRishState.vState);
            this.f25082rs = parseStatus;
            parseStatus.time = this.oRishState.uModifyTime;
        }
        return this.f25082rs;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lEctID = jceInputStream.read(this.lEctID, 0, true);
        this.wFace = jceInputStream.read(this.wFace, 1, true);
        this.bSex = jceInputStream.read(this.bSex, 2, true);
        this.bAge = jceInputStream.read(this.bAge, 3, true);
        this.strNick = jceInputStream.readString(4, true);
        if (cache_oRishState == null) {
            cache_oRishState = new stRishState();
        }
        this.oRishState = (stRishState) jceInputStream.read((JceStruct) cache_oRishState, 5, false);
        if (cache_vSig == null) {
            cache_vSig = r0;
            byte[] bArr = {0};
        }
        this.vSig = jceInputStream.read(cache_vSig, 6, false);
        this.strLocation = jceInputStream.readString(7, false);
        this.strDesc = jceInputStream.readString(8, false);
        this.iDistance = jceInputStream.read(this.iDistance, 9, false);
        this.iLat = jceInputStream.read(this.iLat, 10, false);
        this.iLon = jceInputStream.read(this.iLon, 11, false);
        this.nPicNum = jceInputStream.read(this.nPicNum, 12, false);
        this.nStatus = jceInputStream.read(this.nStatus, 13, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lEctID, 0);
        jceOutputStream.write(this.wFace, 1);
        jceOutputStream.write(this.bSex, 2);
        jceOutputStream.write(this.bAge, 3);
        jceOutputStream.write(this.strNick, 4);
        stRishState strishstate = this.oRishState;
        if (strishstate != null) {
            jceOutputStream.write((JceStruct) strishstate, 5);
        }
        byte[] bArr = this.vSig;
        if (bArr != null) {
            jceOutputStream.write(bArr, 6);
        }
        String str = this.strLocation;
        if (str != null) {
            jceOutputStream.write(str, 7);
        }
        String str2 = this.strDesc;
        if (str2 != null) {
            jceOutputStream.write(str2, 8);
        }
        jceOutputStream.write(this.iDistance, 9);
        jceOutputStream.write(this.iLat, 10);
        jceOutputStream.write(this.iLon, 11);
        jceOutputStream.write(this.nPicNum, 12);
        jceOutputStream.write(this.nStatus, 13);
    }

    public UserProfile(long j3, short s16, byte b16, byte b17, String str, stRishState strishstate, byte[] bArr, String str2, String str3, int i3, int i16, int i17, long j16, long j17) {
        this.lEctID = j3;
        this.wFace = s16;
        this.bSex = b16;
        this.bAge = b17;
        this.strNick = str;
        this.oRishState = strishstate;
        this.vSig = bArr;
        this.strLocation = str2;
        this.strDesc = str3;
        this.iDistance = i3;
        this.iLat = i16;
        this.iLon = i17;
        this.nPicNum = j16;
        this.nStatus = j17;
    }
}
