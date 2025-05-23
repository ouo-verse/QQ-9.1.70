package UserGrowth;

import NS_KING_SOCIALIZE_META.stShareInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class stGetPersonalInfoRsp extends JceStruct {
    static stSimpleMetaPerson cache_info = new stSimpleMetaPerson();
    static stShareInfo cache_share_info = new stShareInfo();
    public stSimpleMetaPerson info;
    public int isShowPraisedFeed;
    public stShareInfo share_info;

    public stGetPersonalInfoRsp() {
        this.info = null;
        this.isShowPraisedFeed = 0;
        this.share_info = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.info = (stSimpleMetaPerson) jceInputStream.read((JceStruct) cache_info, 0, false);
        this.isShowPraisedFeed = jceInputStream.read(this.isShowPraisedFeed, 1, false);
        this.share_info = (stShareInfo) jceInputStream.read((JceStruct) cache_share_info, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        stSimpleMetaPerson stsimplemetaperson = this.info;
        if (stsimplemetaperson != null) {
            jceOutputStream.write((JceStruct) stsimplemetaperson, 0);
        }
        jceOutputStream.write(this.isShowPraisedFeed, 1);
        stShareInfo stshareinfo = this.share_info;
        if (stshareinfo != null) {
            jceOutputStream.write((JceStruct) stshareinfo, 2);
        }
    }

    public stGetPersonalInfoRsp(stSimpleMetaPerson stsimplemetaperson, int i3, stShareInfo stshareinfo) {
        this.info = stsimplemetaperson;
        this.isShowPraisedFeed = i3;
        this.share_info = stshareinfo;
    }
}
