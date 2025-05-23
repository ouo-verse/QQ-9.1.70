package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UniBusiGetOneItemWithCheckRsp extends JceStruct {
    static UniBusiSimpleItemDetail cache_stDetail = new UniBusiSimpleItemDetail();
    public String errmsg;
    public int ret;
    public UniBusiSimpleItemDetail stDetail;

    public UniBusiGetOneItemWithCheckRsp() {
        this.ret = 0;
        this.errmsg = "";
        this.stDetail = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, false);
        this.errmsg = jceInputStream.readString(1, false);
        this.stDetail = (UniBusiSimpleItemDetail) jceInputStream.read((JceStruct) cache_stDetail, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        String str = this.errmsg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        UniBusiSimpleItemDetail uniBusiSimpleItemDetail = this.stDetail;
        if (uniBusiSimpleItemDetail != null) {
            jceOutputStream.write((JceStruct) uniBusiSimpleItemDetail, 2);
        }
    }

    public UniBusiGetOneItemWithCheckRsp(int i3, String str, UniBusiSimpleItemDetail uniBusiSimpleItemDetail) {
        this.ret = i3;
        this.errmsg = str;
        this.stDetail = uniBusiSimpleItemDetail;
    }
}
