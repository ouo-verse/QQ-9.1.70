package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stFeedOpInfo extends JceStruct {
    public stBusinessAdInfo businessAdInfo;
    public String feedId;
    public int iconType;
    public int isRequesting;
    public stFunctionalIconInfo shootIconInfo;
    public String traceId;
    public int videoType;
    static stFunctionalIconInfo cache_shootIconInfo = new stFunctionalIconInfo();
    static stBusinessAdInfo cache_businessAdInfo = new stBusinessAdInfo();

    public stFeedOpInfo() {
        this.feedId = "";
        this.videoType = 0;
        this.traceId = "";
        this.iconType = 0;
        this.shootIconInfo = null;
        this.businessAdInfo = null;
        this.isRequesting = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.feedId = jceInputStream.readString(0, false);
        this.videoType = jceInputStream.read(this.videoType, 1, false);
        this.traceId = jceInputStream.readString(2, false);
        this.iconType = jceInputStream.read(this.iconType, 3, false);
        this.shootIconInfo = (stFunctionalIconInfo) jceInputStream.read((JceStruct) cache_shootIconInfo, 4, false);
        this.businessAdInfo = (stBusinessAdInfo) jceInputStream.read((JceStruct) cache_businessAdInfo, 5, false);
        this.isRequesting = jceInputStream.read(this.isRequesting, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public String toString() {
        return "stFeedOpInfo{feedId='" + this.feedId + "', videoType=" + this.videoType + ", traceId='" + this.traceId + "', iconType=" + this.iconType + ", shootIconInfo=" + this.shootIconInfo + ", businessAdInfo=" + this.businessAdInfo + ", isRequesting=" + this.isRequesting + '}';
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.feedId;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.videoType, 1);
        String str2 = this.traceId;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        jceOutputStream.write(this.iconType, 3);
        stFunctionalIconInfo stfunctionaliconinfo = this.shootIconInfo;
        if (stfunctionaliconinfo != null) {
            jceOutputStream.write((JceStruct) stfunctionaliconinfo, 4);
        }
        stBusinessAdInfo stbusinessadinfo = this.businessAdInfo;
        if (stbusinessadinfo != null) {
            jceOutputStream.write((JceStruct) stbusinessadinfo, 5);
        }
        jceOutputStream.write(this.isRequesting, 6);
    }

    public stFeedOpInfo(String str, int i3, String str2, int i16, stFunctionalIconInfo stfunctionaliconinfo, stBusinessAdInfo stbusinessadinfo, int i17) {
        this.feedId = str;
        this.videoType = i3;
        this.traceId = str2;
        this.iconType = i16;
        this.shootIconInfo = stfunctionaliconinfo;
        this.businessAdInfo = stbusinessadinfo;
        this.isRequesting = i17;
    }
}
