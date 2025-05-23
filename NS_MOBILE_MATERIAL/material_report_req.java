package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class material_report_req extends JceStruct {
    public int iBannerType;
    public int iOperType;
    public int iSource;
    public long lUin;
    public String strQbossTraceinfo;

    public material_report_req() {
        this.lUin = 0L;
        this.iOperType = 0;
        this.iSource = 0;
        this.iBannerType = 0;
        this.strQbossTraceinfo = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lUin = jceInputStream.read(this.lUin, 0, true);
        this.iOperType = jceInputStream.read(this.iOperType, 1, true);
        this.iSource = jceInputStream.read(this.iSource, 2, false);
        this.iBannerType = jceInputStream.read(this.iBannerType, 3, false);
        this.strQbossTraceinfo = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lUin, 0);
        jceOutputStream.write(this.iOperType, 1);
        jceOutputStream.write(this.iSource, 2);
        jceOutputStream.write(this.iBannerType, 3);
        String str = this.strQbossTraceinfo;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
    }

    public material_report_req(long j3, int i3, int i16, int i17, String str) {
        this.lUin = j3;
        this.iOperType = i3;
        this.iSource = i16;
        this.iBannerType = i17;
        this.strQbossTraceinfo = str;
    }
}
