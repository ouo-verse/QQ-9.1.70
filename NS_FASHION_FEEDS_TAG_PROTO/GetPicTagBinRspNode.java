package NS_FASHION_FEEDS_TAG_PROTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class GetPicTagBinRspNode extends JceStruct {
    static PicTagInfo cache_stPicTagInfo = new PicTagInfo();
    public PicTagInfo stPicTagInfo;

    public GetPicTagBinRspNode() {
        this.stPicTagInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stPicTagInfo = (PicTagInfo) jceInputStream.read((JceStruct) cache_stPicTagInfo, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        PicTagInfo picTagInfo = this.stPicTagInfo;
        if (picTagInfo != null) {
            jceOutputStream.write((JceStruct) picTagInfo, 0);
        }
    }

    public GetPicTagBinRspNode(PicTagInfo picTagInfo) {
        this.stPicTagInfo = picTagInfo;
    }
}
