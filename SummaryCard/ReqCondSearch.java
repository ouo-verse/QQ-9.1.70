package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqCondSearch extends JceStruct {
    static byte[] cache_vCityId;
    static byte[] cache_vHomeId;
    public short cAge;
    public byte cConstellationId;
    public byte cGender;
    public short cMaxAge;
    public short cMinAge;
    public long dwFlag;
    public long dwSessionID;
    public int iOccupationId;
    public int iPage;
    public String strNick;
    public byte[] vCityId;
    public byte[] vHomeId;

    static {
        cache_vCityId = r1;
        byte[] bArr = {0};
        cache_vHomeId = r0;
        byte[] bArr2 = {0};
    }

    public ReqCondSearch() {
        this.iPage = 0;
        this.dwSessionID = 0L;
        this.dwFlag = 0L;
        this.strNick = "";
        this.cGender = (byte) 0;
        this.vCityId = null;
        this.cAge = (short) 0;
        this.vHomeId = null;
        this.cConstellationId = (byte) 0;
        this.iOccupationId = 0;
        this.cMinAge = (short) 18;
        this.cMaxAge = (short) 120;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iPage = jceInputStream.read(this.iPage, 0, true);
        this.dwSessionID = jceInputStream.read(this.dwSessionID, 1, true);
        this.dwFlag = jceInputStream.read(this.dwFlag, 2, true);
        this.strNick = jceInputStream.readString(3, false);
        this.cGender = jceInputStream.read(this.cGender, 4, false);
        this.vCityId = jceInputStream.read(cache_vCityId, 5, false);
        this.cAge = jceInputStream.read(this.cAge, 6, false);
        this.vHomeId = jceInputStream.read(cache_vHomeId, 7, false);
        this.cConstellationId = jceInputStream.read(this.cConstellationId, 8, false);
        this.iOccupationId = jceInputStream.read(this.iOccupationId, 9, false);
        this.cMinAge = jceInputStream.read(this.cMinAge, 10, false);
        this.cMaxAge = jceInputStream.read(this.cMaxAge, 11, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iPage, 0);
        jceOutputStream.write(this.dwSessionID, 1);
        jceOutputStream.write(this.dwFlag, 2);
        String str = this.strNick;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        jceOutputStream.write(this.cGender, 4);
        byte[] bArr = this.vCityId;
        if (bArr != null) {
            jceOutputStream.write(bArr, 5);
        }
        jceOutputStream.write(this.cAge, 6);
        byte[] bArr2 = this.vHomeId;
        if (bArr2 != null) {
            jceOutputStream.write(bArr2, 7);
        }
        jceOutputStream.write(this.cConstellationId, 8);
        jceOutputStream.write(this.iOccupationId, 9);
        jceOutputStream.write(this.cMinAge, 10);
        jceOutputStream.write(this.cMaxAge, 11);
    }

    public ReqCondSearch(int i3, long j3, long j16, String str, byte b16, byte[] bArr, short s16, byte[] bArr2, byte b17, int i16, short s17, short s18) {
        this.iPage = i3;
        this.dwSessionID = j3;
        this.dwFlag = j16;
        this.strNick = str;
        this.cGender = b16;
        this.vCityId = bArr;
        this.cAge = s16;
        this.vHomeId = bArr2;
        this.cConstellationId = b17;
        this.iOccupationId = i16;
        this.cMinAge = s17;
        this.cMaxAge = s18;
    }
}
