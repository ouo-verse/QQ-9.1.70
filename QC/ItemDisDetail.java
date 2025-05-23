package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ItemDisDetail extends JceStruct {
    public int appId;
    public AuthResultInfo authResult;
    public ExtraAppInfo extraappinfo;
    public ExtraImageInfo extraimage;
    public UniBusiExtraInfo extrainfo;
    public int feeType;
    public String image;
    public int isSetup;
    public String itemBgColor;
    public int itemId;
    public String name;
    public long validlast;
    static UniBusiExtraInfo cache_extrainfo = new UniBusiExtraInfo();
    static ExtraImageInfo cache_extraimage = new ExtraImageInfo();
    static ExtraAppInfo cache_extraappinfo = new ExtraAppInfo();
    static AuthResultInfo cache_authResult = new AuthResultInfo();

    public ItemDisDetail() {
        this.appId = 0;
        this.itemId = 0;
        this.name = "";
        this.feeType = 0;
        this.image = "";
        this.itemBgColor = "";
        this.extrainfo = null;
        this.validlast = 0L;
        this.isSetup = 0;
        this.extraimage = null;
        this.extraappinfo = null;
        this.authResult = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.appId = jceInputStream.read(this.appId, 0, false);
        this.itemId = jceInputStream.read(this.itemId, 1, false);
        this.name = jceInputStream.readString(2, false);
        this.feeType = jceInputStream.read(this.feeType, 3, false);
        this.image = jceInputStream.readString(4, false);
        this.itemBgColor = jceInputStream.readString(5, false);
        this.extrainfo = (UniBusiExtraInfo) jceInputStream.read((JceStruct) cache_extrainfo, 6, false);
        this.validlast = jceInputStream.read(this.validlast, 7, false);
        this.isSetup = jceInputStream.read(this.isSetup, 8, false);
        this.extraimage = (ExtraImageInfo) jceInputStream.read((JceStruct) cache_extraimage, 9, false);
        this.extraappinfo = (ExtraAppInfo) jceInputStream.read((JceStruct) cache_extraappinfo, 10, false);
        this.authResult = (AuthResultInfo) jceInputStream.read((JceStruct) cache_authResult, 11, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.appId, 0);
        jceOutputStream.write(this.itemId, 1);
        String str = this.name;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        jceOutputStream.write(this.feeType, 3);
        String str2 = this.image;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        String str3 = this.itemBgColor;
        if (str3 != null) {
            jceOutputStream.write(str3, 5);
        }
        UniBusiExtraInfo uniBusiExtraInfo = this.extrainfo;
        if (uniBusiExtraInfo != null) {
            jceOutputStream.write((JceStruct) uniBusiExtraInfo, 6);
        }
        jceOutputStream.write(this.validlast, 7);
        jceOutputStream.write(this.isSetup, 8);
        ExtraImageInfo extraImageInfo = this.extraimage;
        if (extraImageInfo != null) {
            jceOutputStream.write((JceStruct) extraImageInfo, 9);
        }
        ExtraAppInfo extraAppInfo = this.extraappinfo;
        if (extraAppInfo != null) {
            jceOutputStream.write((JceStruct) extraAppInfo, 10);
        }
        AuthResultInfo authResultInfo = this.authResult;
        if (authResultInfo != null) {
            jceOutputStream.write((JceStruct) authResultInfo, 11);
        }
    }

    public ItemDisDetail(int i3, int i16, String str, int i17, String str2, String str3, UniBusiExtraInfo uniBusiExtraInfo, long j3, int i18, ExtraImageInfo extraImageInfo, ExtraAppInfo extraAppInfo, AuthResultInfo authResultInfo) {
        this.appId = i3;
        this.itemId = i16;
        this.name = str;
        this.feeType = i17;
        this.image = str2;
        this.itemBgColor = str3;
        this.extrainfo = uniBusiExtraInfo;
        this.validlast = j3;
        this.isSetup = i18;
        this.extraimage = extraImageInfo;
        this.extraappinfo = extraAppInfo;
        this.authResult = authResultInfo;
    }
}
