package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stNotificationReq extends JceStruct {
    static stLinkStragegyArgs cache_linkStrategyArgs = new stLinkStragegyArgs();
    public stLinkStragegyArgs linkStrategyArgs;
    public String personid;
    public String push_info;

    public stNotificationReq() {
        this.personid = "";
        this.linkStrategyArgs = null;
        this.push_info = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.personid = jceInputStream.readString(0, false);
        this.linkStrategyArgs = (stLinkStragegyArgs) jceInputStream.read((JceStruct) cache_linkStrategyArgs, 1, false);
        this.push_info = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.personid;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        stLinkStragegyArgs stlinkstragegyargs = this.linkStrategyArgs;
        if (stlinkstragegyargs != null) {
            jceOutputStream.write((JceStruct) stlinkstragegyargs, 1);
        }
        String str2 = this.push_info;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
    }

    public stNotificationReq(String str, stLinkStragegyArgs stlinkstragegyargs, String str2) {
        this.personid = str;
        this.linkStrategyArgs = stlinkstragegyargs;
        this.push_info = str2;
    }
}
