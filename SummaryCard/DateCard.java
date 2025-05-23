package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class DateCard extends JceStruct {
    static byte[] cache_vActivityList;
    static byte[] cache_vDateInfo;
    static byte[] cache_vFaces;
    static byte[] cache_vGroupList;
    static byte[] cache_vNearbyInfo;
    public byte bConstellation;
    public byte bMarriage;
    public long lTinyId;
    public String strCompany;
    public String strDistance;
    public String strElapse;
    public String strSchool;
    public long uHomeCity;
    public long uHomeCountry;
    public long uHomeProvince;
    public long uHomeZone;
    public long uProfession;
    public long uSchoolId;
    public byte[] vActivityList;
    public byte[] vDateInfo;
    public byte[] vFaces;
    public byte[] vGroupList;
    public byte[] vNearbyInfo;

    static {
        cache_vFaces = r1;
        byte[] bArr = {0};
        cache_vDateInfo = r1;
        byte[] bArr2 = {0};
        cache_vGroupList = r1;
        byte[] bArr3 = {0};
        cache_vNearbyInfo = r1;
        byte[] bArr4 = {0};
        cache_vActivityList = r0;
        byte[] bArr5 = {0};
    }

    public DateCard() {
        this.vFaces = null;
        this.bConstellation = (byte) 0;
        this.uProfession = 0L;
        this.strCompany = "";
        this.strSchool = "";
        this.uHomeCountry = 0L;
        this.uHomeProvince = 0L;
        this.uHomeCity = 0L;
        this.vDateInfo = null;
        this.strDistance = "";
        this.strElapse = "";
        this.bMarriage = (byte) 0;
        this.uHomeZone = 0L;
        this.lTinyId = 0L;
        this.uSchoolId = 0L;
        this.vGroupList = null;
        this.vNearbyInfo = null;
        this.vActivityList = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.vFaces = jceInputStream.read(cache_vFaces, 0, false);
        this.bConstellation = jceInputStream.read(this.bConstellation, 1, false);
        this.uProfession = jceInputStream.read(this.uProfession, 2, false);
        this.strCompany = jceInputStream.readString(3, false);
        this.strSchool = jceInputStream.readString(4, false);
        this.uHomeCountry = jceInputStream.read(this.uHomeCountry, 5, false);
        this.uHomeProvince = jceInputStream.read(this.uHomeProvince, 6, false);
        this.uHomeCity = jceInputStream.read(this.uHomeCity, 7, false);
        this.vDateInfo = jceInputStream.read(cache_vDateInfo, 8, false);
        this.strDistance = jceInputStream.readString(9, false);
        this.strElapse = jceInputStream.readString(10, false);
        this.bMarriage = jceInputStream.read(this.bMarriage, 11, false);
        this.uHomeZone = jceInputStream.read(this.uHomeZone, 12, false);
        this.lTinyId = jceInputStream.read(this.lTinyId, 13, false);
        this.uSchoolId = jceInputStream.read(this.uSchoolId, 14, false);
        this.vGroupList = jceInputStream.read(cache_vGroupList, 15, false);
        this.vNearbyInfo = jceInputStream.read(cache_vNearbyInfo, 16, false);
        this.vActivityList = jceInputStream.read(cache_vActivityList, 17, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        byte[] bArr = this.vFaces;
        if (bArr != null) {
            jceOutputStream.write(bArr, 0);
        }
        jceOutputStream.write(this.bConstellation, 1);
        jceOutputStream.write(this.uProfession, 2);
        String str = this.strCompany;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        String str2 = this.strSchool;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        jceOutputStream.write(this.uHomeCountry, 5);
        jceOutputStream.write(this.uHomeProvince, 6);
        jceOutputStream.write(this.uHomeCity, 7);
        byte[] bArr2 = this.vDateInfo;
        if (bArr2 != null) {
            jceOutputStream.write(bArr2, 8);
        }
        String str3 = this.strDistance;
        if (str3 != null) {
            jceOutputStream.write(str3, 9);
        }
        String str4 = this.strElapse;
        if (str4 != null) {
            jceOutputStream.write(str4, 10);
        }
        jceOutputStream.write(this.bMarriage, 11);
        jceOutputStream.write(this.uHomeZone, 12);
        jceOutputStream.write(this.lTinyId, 13);
        jceOutputStream.write(this.uSchoolId, 14);
        byte[] bArr3 = this.vGroupList;
        if (bArr3 != null) {
            jceOutputStream.write(bArr3, 15);
        }
        byte[] bArr4 = this.vNearbyInfo;
        if (bArr4 != null) {
            jceOutputStream.write(bArr4, 16);
        }
        byte[] bArr5 = this.vActivityList;
        if (bArr5 != null) {
            jceOutputStream.write(bArr5, 17);
        }
    }

    public DateCard(byte[] bArr, byte b16, long j3, String str, String str2, long j16, long j17, long j18, byte[] bArr2, String str3, String str4, byte b17, long j19, long j26, long j27, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        this.vFaces = bArr;
        this.bConstellation = b16;
        this.uProfession = j3;
        this.strCompany = str;
        this.strSchool = str2;
        this.uHomeCountry = j16;
        this.uHomeProvince = j17;
        this.uHomeCity = j18;
        this.vDateInfo = bArr2;
        this.strDistance = str3;
        this.strElapse = str4;
        this.bMarriage = b17;
        this.uHomeZone = j19;
        this.lTinyId = j26;
        this.uSchoolId = j27;
        this.vGroupList = bArr3;
        this.vNearbyInfo = bArr4;
        this.vActivityList = bArr5;
    }
}
