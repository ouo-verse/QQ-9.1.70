package SWU;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class SWUploadPicReq extends JceStruct {
    static int cache_eFileType;
    static int cache_eUseType;
    static byte[] cache_wnskey;
    public String device;
    public String duration;
    public int eFileType;
    public int eUseType;
    public String emojitype;
    public long iBatchID;
    public int iCurPicNum;
    public int iFromQZone;
    public int iPicHight;
    public int iPicWidth;
    public int iPictotalNum;
    public int isShareFeeds;
    public String itemid;
    public int keyType;
    public String localid;

    /* renamed from: os, reason: collision with root package name */
    public String f25099os;
    public String osver;
    public String pic_url;
    public String sAddress;
    public String sAlbumID;
    public String sClientip;
    public String sPicDesc;
    public String sPicPath;
    public String sPicTitle;
    public String sUserAgent;
    public String ver;
    public byte[] wnskey;

    public SWUploadPicReq() {
        this.sPicTitle = "";
        this.sPicDesc = "";
        this.eUseType = 0;
        this.sAlbumID = "";
        this.iBatchID = 0L;
        this.eFileType = 0;
        this.sPicPath = "";
        this.iPicWidth = 0;
        this.iPicHight = 0;
        this.sClientip = "";
        this.isShareFeeds = 0;
        this.sUserAgent = "";
        this.sAddress = "";
        this.iPictotalNum = 0;
        this.iCurPicNum = 0;
        this.iFromQZone = 0;
        this.pic_url = "";
        this.localid = "";
        this.f25099os = "";
        this.device = "";
        this.osver = "";
        this.ver = "";
        this.keyType = 0;
        this.wnskey = null;
        this.duration = "";
        this.itemid = "";
        this.emojitype = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.sPicTitle = jceInputStream.readString(0, false);
        this.sPicDesc = jceInputStream.readString(1, false);
        this.eUseType = jceInputStream.read(this.eUseType, 2, false);
        this.sAlbumID = jceInputStream.readString(3, false);
        this.iBatchID = jceInputStream.read(this.iBatchID, 4, false);
        this.eFileType = jceInputStream.read(this.eFileType, 5, false);
        this.sPicPath = jceInputStream.readString(6, false);
        this.iPicWidth = jceInputStream.read(this.iPicWidth, 7, false);
        this.iPicHight = jceInputStream.read(this.iPicHight, 8, false);
        this.sClientip = jceInputStream.readString(9, false);
        this.isShareFeeds = jceInputStream.read(this.isShareFeeds, 10, false);
        this.sUserAgent = jceInputStream.readString(11, false);
        this.sAddress = jceInputStream.readString(12, false);
        this.iPictotalNum = jceInputStream.read(this.iPictotalNum, 13, false);
        this.iCurPicNum = jceInputStream.read(this.iCurPicNum, 14, false);
        this.iFromQZone = jceInputStream.read(this.iFromQZone, 15, false);
        this.pic_url = jceInputStream.readString(16, false);
        this.localid = jceInputStream.readString(17, false);
        this.f25099os = jceInputStream.readString(18, false);
        this.device = jceInputStream.readString(19, false);
        this.osver = jceInputStream.readString(20, false);
        this.ver = jceInputStream.readString(21, false);
        this.keyType = jceInputStream.read(this.keyType, 22, false);
        if (cache_wnskey == null) {
            cache_wnskey = r1;
            byte[] bArr = {0};
        }
        this.wnskey = jceInputStream.read(cache_wnskey, 23, false);
        this.duration = jceInputStream.readString(24, false);
        this.itemid = jceInputStream.readString(25, false);
        this.emojitype = jceInputStream.readString(26, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.sPicTitle;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.sPicDesc;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        jceOutputStream.write(this.eUseType, 2);
        String str3 = this.sAlbumID;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        jceOutputStream.write(this.iBatchID, 4);
        jceOutputStream.write(this.eFileType, 5);
        String str4 = this.sPicPath;
        if (str4 != null) {
            jceOutputStream.write(str4, 6);
        }
        jceOutputStream.write(this.iPicWidth, 7);
        jceOutputStream.write(this.iPicHight, 8);
        String str5 = this.sClientip;
        if (str5 != null) {
            jceOutputStream.write(str5, 9);
        }
        jceOutputStream.write(this.isShareFeeds, 10);
        String str6 = this.sUserAgent;
        if (str6 != null) {
            jceOutputStream.write(str6, 11);
        }
        String str7 = this.sAddress;
        if (str7 != null) {
            jceOutputStream.write(str7, 12);
        }
        jceOutputStream.write(this.iPictotalNum, 13);
        jceOutputStream.write(this.iCurPicNum, 14);
        jceOutputStream.write(this.iFromQZone, 15);
        String str8 = this.pic_url;
        if (str8 != null) {
            jceOutputStream.write(str8, 16);
        }
        String str9 = this.localid;
        if (str9 != null) {
            jceOutputStream.write(str9, 17);
        }
        String str10 = this.f25099os;
        if (str10 != null) {
            jceOutputStream.write(str10, 18);
        }
        String str11 = this.device;
        if (str11 != null) {
            jceOutputStream.write(str11, 19);
        }
        String str12 = this.osver;
        if (str12 != null) {
            jceOutputStream.write(str12, 20);
        }
        String str13 = this.ver;
        if (str13 != null) {
            jceOutputStream.write(str13, 21);
        }
        jceOutputStream.write(this.keyType, 22);
        byte[] bArr = this.wnskey;
        if (bArr != null) {
            jceOutputStream.write(bArr, 23);
        }
        String str14 = this.duration;
        if (str14 != null) {
            jceOutputStream.write(str14, 24);
        }
        String str15 = this.itemid;
        if (str15 != null) {
            jceOutputStream.write(str15, 25);
        }
        String str16 = this.emojitype;
        if (str16 != null) {
            jceOutputStream.write(str16, 26);
        }
    }

    public SWUploadPicReq(String str, String str2, int i3, String str3, long j3, int i16, String str4, int i17, int i18, String str5, int i19, String str6, String str7, int i26, int i27, int i28, String str8, String str9, String str10, String str11, String str12, String str13, int i29, byte[] bArr, String str14, String str15, String str16) {
        this.sPicTitle = str;
        this.sPicDesc = str2;
        this.eUseType = i3;
        this.sAlbumID = str3;
        this.iBatchID = j3;
        this.eFileType = i16;
        this.sPicPath = str4;
        this.iPicWidth = i17;
        this.iPicHight = i18;
        this.sClientip = str5;
        this.isShareFeeds = i19;
        this.sUserAgent = str6;
        this.sAddress = str7;
        this.iPictotalNum = i26;
        this.iCurPicNum = i27;
        this.iFromQZone = i28;
        this.pic_url = str8;
        this.localid = str9;
        this.f25099os = str10;
        this.device = str11;
        this.osver = str12;
        this.ver = str13;
        this.keyType = i29;
        this.wnskey = bArr;
        this.duration = str14;
        this.itemid = str15;
        this.emojitype = str16;
    }
}
