package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class material_pay_present_live_item_req extends JceStruct {
    static LiveInfo cache_stLiveInfo = new LiveInfo();
    public int iAppid;
    public long lPayUin;
    public long lPresentUin;
    public LiveInfo stLiveInfo;
    public String strItemId;
    public String strQua;
    public String strSerialNo;

    public material_pay_present_live_item_req() {
        this.lPayUin = 0L;
        this.lPresentUin = 0L;
        this.iAppid = 0;
        this.strItemId = "";
        this.strSerialNo = "";
        this.strQua = "";
        this.stLiveInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lPayUin = jceInputStream.read(this.lPayUin, 0, true);
        this.lPresentUin = jceInputStream.read(this.lPresentUin, 1, true);
        this.iAppid = jceInputStream.read(this.iAppid, 2, true);
        this.strItemId = jceInputStream.readString(3, true);
        this.strSerialNo = jceInputStream.readString(4, false);
        this.strQua = jceInputStream.readString(5, false);
        this.stLiveInfo = (LiveInfo) jceInputStream.read((JceStruct) cache_stLiveInfo, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lPayUin, 0);
        jceOutputStream.write(this.lPresentUin, 1);
        jceOutputStream.write(this.iAppid, 2);
        jceOutputStream.write(this.strItemId, 3);
        String str = this.strSerialNo;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
        String str2 = this.strQua;
        if (str2 != null) {
            jceOutputStream.write(str2, 5);
        }
        LiveInfo liveInfo = this.stLiveInfo;
        if (liveInfo != null) {
            jceOutputStream.write((JceStruct) liveInfo, 6);
        }
    }

    public material_pay_present_live_item_req(long j3, long j16, int i3, String str, String str2, String str3, LiveInfo liveInfo) {
        this.lPayUin = j3;
        this.lPresentUin = j16;
        this.iAppid = i3;
        this.strItemId = str;
        this.strSerialNo = str2;
        this.strQua = str3;
        this.stLiveInfo = liveInfo;
    }
}
