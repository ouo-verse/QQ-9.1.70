package acs;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Software extends JceStruct {
    public String category;
    public String cpname;
    public String downloadCountDesc;
    public int nCommentCount;
    public int nDownloadCount;
    public int nFileId;
    public int nFileSize;
    public int nProductId;
    public byte nScore;
    public int nSoftId;
    public String sFee;
    public String sFeedesc;
    public String sFileuid;
    public String sFileurl;
    public String sFunction;
    public String sLogoUrl;
    public String sPrefix;
    public String sProductName;
    public String sPublishTime;
    public String sSoftName;
    public String sSoftVersion;
    public int supportdevice;

    public Software() {
        this.nProductId = 0;
        this.sProductName = "";
        this.sLogoUrl = "";
        this.nSoftId = 0;
        this.sSoftName = "";
        this.sSoftVersion = "";
        this.sFee = "";
        this.sPublishTime = "";
        this.nFileId = 0;
        this.nFileSize = 0;
        this.sFileurl = "";
        this.sFileuid = "";
        this.nScore = (byte) 0;
        this.nCommentCount = 0;
        this.nDownloadCount = 0;
        this.sFunction = "";
        this.sPrefix = "";
        this.sFeedesc = "";
        this.category = "";
        this.cpname = "";
        this.supportdevice = 0;
        this.downloadCountDesc = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.nProductId = jceInputStream.read(this.nProductId, 0, true);
        this.sProductName = jceInputStream.readString(1, true);
        this.sLogoUrl = jceInputStream.readString(2, true);
        this.nSoftId = jceInputStream.read(this.nSoftId, 3, true);
        this.sSoftName = jceInputStream.readString(4, true);
        this.sSoftVersion = jceInputStream.readString(5, true);
        this.sFee = jceInputStream.readString(6, true);
        this.sPublishTime = jceInputStream.readString(7, true);
        this.nFileId = jceInputStream.read(this.nFileId, 8, true);
        this.nFileSize = jceInputStream.read(this.nFileSize, 9, true);
        this.sFileurl = jceInputStream.readString(10, true);
        this.sFileuid = jceInputStream.readString(11, true);
        this.nScore = jceInputStream.read(this.nScore, 12, true);
        this.nCommentCount = jceInputStream.read(this.nCommentCount, 13, true);
        this.nDownloadCount = jceInputStream.read(this.nDownloadCount, 14, true);
        this.sFunction = jceInputStream.readString(15, true);
        this.sPrefix = jceInputStream.readString(16, true);
        this.sFeedesc = jceInputStream.readString(17, true);
        this.category = jceInputStream.readString(18, true);
        this.cpname = jceInputStream.readString(19, false);
        this.supportdevice = jceInputStream.read(this.supportdevice, 20, false);
        this.downloadCountDesc = jceInputStream.readString(21, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.nProductId, 0);
        jceOutputStream.write(this.sProductName, 1);
        jceOutputStream.write(this.sLogoUrl, 2);
        jceOutputStream.write(this.nSoftId, 3);
        jceOutputStream.write(this.sSoftName, 4);
        jceOutputStream.write(this.sSoftVersion, 5);
        jceOutputStream.write(this.sFee, 6);
        jceOutputStream.write(this.sPublishTime, 7);
        jceOutputStream.write(this.nFileId, 8);
        jceOutputStream.write(this.nFileSize, 9);
        jceOutputStream.write(this.sFileurl, 10);
        jceOutputStream.write(this.sFileuid, 11);
        jceOutputStream.write(this.nScore, 12);
        jceOutputStream.write(this.nCommentCount, 13);
        jceOutputStream.write(this.nDownloadCount, 14);
        jceOutputStream.write(this.sFunction, 15);
        jceOutputStream.write(this.sPrefix, 16);
        jceOutputStream.write(this.sFeedesc, 17);
        jceOutputStream.write(this.category, 18);
        String str = this.cpname;
        if (str != null) {
            jceOutputStream.write(str, 19);
        }
        jceOutputStream.write(this.supportdevice, 20);
        String str2 = this.downloadCountDesc;
        if (str2 != null) {
            jceOutputStream.write(str2, 21);
        }
    }

    public Software(int i3, String str, String str2, int i16, String str3, String str4, String str5, String str6, int i17, int i18, String str7, String str8, byte b16, int i19, int i26, String str9, String str10, String str11, String str12, String str13, int i27, String str14) {
        this.nProductId = i3;
        this.sProductName = str;
        this.sLogoUrl = str2;
        this.nSoftId = i16;
        this.sSoftName = str3;
        this.sSoftVersion = str4;
        this.sFee = str5;
        this.sPublishTime = str6;
        this.nFileId = i17;
        this.nFileSize = i18;
        this.sFileurl = str7;
        this.sFileuid = str8;
        this.nScore = b16;
        this.nCommentCount = i19;
        this.nDownloadCount = i26;
        this.sFunction = str9;
        this.sPrefix = str10;
        this.sFeedesc = str11;
        this.category = str12;
        this.cpname = str13;
        this.supportdevice = i27;
        this.downloadCountDesc = str14;
    }
}
