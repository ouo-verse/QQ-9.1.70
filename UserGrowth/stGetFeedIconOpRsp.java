package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stGetFeedIconOpRsp extends JceStruct {
    public stBusinessIconInfo businessIcon;
    public stFeedIconOpConf feedIconOpConf;
    public stFeedOpInfo opInfo;
    public stFunctionalIconInfo shootIconInfo;
    static stFeedOpInfo cache_opInfo = new stFeedOpInfo();
    static stBusinessIconInfo cache_businessIcon = new stBusinessIconInfo();
    static stFunctionalIconInfo cache_shootIconInfo = new stFunctionalIconInfo();
    static stFeedIconOpConf cache_feedIconOpConf = new stFeedIconOpConf();

    public stGetFeedIconOpRsp() {
        this.opInfo = null;
        this.businessIcon = null;
        this.shootIconInfo = null;
        this.feedIconOpConf = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.opInfo = (stFeedOpInfo) jceInputStream.read((JceStruct) cache_opInfo, 0, false);
        this.businessIcon = (stBusinessIconInfo) jceInputStream.read((JceStruct) cache_businessIcon, 1, false);
        this.shootIconInfo = (stFunctionalIconInfo) jceInputStream.read((JceStruct) cache_shootIconInfo, 2, false);
        this.feedIconOpConf = (stFeedIconOpConf) jceInputStream.read((JceStruct) cache_feedIconOpConf, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        stFeedOpInfo stfeedopinfo = this.opInfo;
        if (stfeedopinfo != null) {
            jceOutputStream.write((JceStruct) stfeedopinfo, 0);
        }
        stBusinessIconInfo stbusinessiconinfo = this.businessIcon;
        if (stbusinessiconinfo != null) {
            jceOutputStream.write((JceStruct) stbusinessiconinfo, 1);
        }
        stFunctionalIconInfo stfunctionaliconinfo = this.shootIconInfo;
        if (stfunctionaliconinfo != null) {
            jceOutputStream.write((JceStruct) stfunctionaliconinfo, 2);
        }
        stFeedIconOpConf stfeediconopconf = this.feedIconOpConf;
        if (stfeediconopconf != null) {
            jceOutputStream.write((JceStruct) stfeediconopconf, 3);
        }
    }

    public stGetFeedIconOpRsp(stFeedOpInfo stfeedopinfo, stBusinessIconInfo stbusinessiconinfo, stFunctionalIconInfo stfunctionaliconinfo, stFeedIconOpConf stfeediconopconf) {
        this.opInfo = stfeedopinfo;
        this.businessIcon = stbusinessiconinfo;
        this.shootIconInfo = stfunctionaliconinfo;
        this.feedIconOpConf = stfeediconopconf;
    }
}
