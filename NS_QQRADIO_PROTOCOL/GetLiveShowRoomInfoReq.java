package NS_QQRADIO_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetLiveShowRoomInfoReq extends JceStruct {
    static CommonInfo cache_commonInfo = new CommonInfo();
    public CommonInfo commonInfo;
    public int infoType;
    public int isHlsUrlSign;
    public int pageType;
    public String roomID;
    public String uid;

    public GetLiveShowRoomInfoReq() {
        this.commonInfo = null;
        this.roomID = "";
        this.infoType = 0;
        this.uid = "";
        this.pageType = 0;
        this.isHlsUrlSign = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.commonInfo = (CommonInfo) jceInputStream.read((JceStruct) cache_commonInfo, 0, false);
        this.roomID = jceInputStream.readString(1, false);
        this.infoType = jceInputStream.read(this.infoType, 2, false);
        this.uid = jceInputStream.readString(3, false);
        this.pageType = jceInputStream.read(this.pageType, 4, false);
        this.isHlsUrlSign = jceInputStream.read(this.isHlsUrlSign, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        CommonInfo commonInfo = this.commonInfo;
        if (commonInfo != null) {
            jceOutputStream.write((JceStruct) commonInfo, 0);
        }
        String str = this.roomID;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.infoType, 2);
        String str2 = this.uid;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        jceOutputStream.write(this.pageType, 4);
        jceOutputStream.write(this.isHlsUrlSign, 5);
    }

    public GetLiveShowRoomInfoReq(CommonInfo commonInfo, String str, int i3, String str2, int i16, int i17) {
        this.commonInfo = commonInfo;
        this.roomID = str;
        this.infoType = i3;
        this.uid = str2;
        this.pageType = i16;
        this.isHlsUrlSign = i17;
    }
}
