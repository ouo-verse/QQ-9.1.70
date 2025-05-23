package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CondFitUser extends JceStruct {
    static byte[] cache_vRichSign;
    public byte cConstellationId;
    public byte cSex;
    public long dwAge;
    public long dwCity;
    public long dwCountry;
    public long dwProvince;
    public int iOccupationId;
    public long lUIN;
    public String locDesc;
    public String personalSignature;
    public String strNick;
    public byte[] vRichSign;

    static {
        cache_vRichSign = r0;
        byte[] bArr = {0};
    }

    public CondFitUser() {
        this.lUIN = 0L;
        this.strNick = "";
        this.vRichSign = null;
        this.cSex = (byte) 0;
        this.dwAge = 0L;
        this.dwCountry = 0L;
        this.dwProvince = 0L;
        this.dwCity = 0L;
        this.cConstellationId = (byte) 0;
        this.iOccupationId = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lUIN = jceInputStream.read(this.lUIN, 0, true);
        this.strNick = jceInputStream.readString(1, false);
        this.vRichSign = jceInputStream.read(cache_vRichSign, 2, false);
        this.cSex = jceInputStream.read(this.cSex, 3, false);
        this.dwAge = jceInputStream.read(this.dwAge, 4, false);
        this.dwCountry = jceInputStream.read(this.dwCountry, 5, false);
        this.dwProvince = jceInputStream.read(this.dwProvince, 6, false);
        this.dwCity = jceInputStream.read(this.dwCity, 7, false);
        this.cConstellationId = jceInputStream.read(this.cConstellationId, 8, false);
        this.iOccupationId = jceInputStream.read(this.iOccupationId, 9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lUIN, 0);
        String str = this.strNick;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        byte[] bArr = this.vRichSign;
        if (bArr != null) {
            jceOutputStream.write(bArr, 2);
        }
        jceOutputStream.write(this.cSex, 3);
        jceOutputStream.write(this.dwAge, 4);
        jceOutputStream.write(this.dwCountry, 5);
        jceOutputStream.write(this.dwProvince, 6);
        jceOutputStream.write(this.dwCity, 7);
        jceOutputStream.write(this.cConstellationId, 8);
        jceOutputStream.write(this.iOccupationId, 9);
    }

    public CondFitUser(long j3, String str, byte[] bArr, byte b16, long j16, long j17, long j18, long j19, byte b17, int i3) {
        this.lUIN = j3;
        this.strNick = str;
        this.vRichSign = bArr;
        this.cSex = b16;
        this.dwAge = j16;
        this.dwCountry = j17;
        this.dwProvince = j18;
        this.dwCity = j19;
        this.cConstellationId = b17;
        this.iOccupationId = i3;
    }
}
