package NS_MOBILE_MAIN_PAGE;

import NS_MOBILE_COMM.yellow_info;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_sub_get_cover_item_rsp extends JceStruct {
    static CoverItem cache_item;
    static yellow_info cache_yellowInfo;
    public CoverItem item;
    public yellow_info yellowInfo;

    public mobile_sub_get_cover_item_rsp() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_item == null) {
            cache_item = new CoverItem();
        }
        this.item = (CoverItem) jceInputStream.read((JceStruct) cache_item, 0, false);
        if (cache_yellowInfo == null) {
            cache_yellowInfo = new yellow_info();
        }
        this.yellowInfo = (yellow_info) jceInputStream.read((JceStruct) cache_yellowInfo, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        CoverItem coverItem = this.item;
        if (coverItem != null) {
            jceOutputStream.write((JceStruct) coverItem, 0);
        }
        yellow_info yellow_infoVar = this.yellowInfo;
        if (yellow_infoVar != null) {
            jceOutputStream.write((JceStruct) yellow_infoVar, 1);
        }
    }

    public mobile_sub_get_cover_item_rsp(CoverItem coverItem, yellow_info yellow_infoVar) {
        this.item = coverItem;
        this.yellowInfo = yellow_infoVar;
    }
}
