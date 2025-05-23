package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UniBusiGetSimpleItemRsp extends JceStruct {
    static Map<Integer, ArrayList<UniBusiSimpleItemDetail>> cache_mAppidItemDetail = new HashMap();
    public String errmsg;
    public Map<Integer, ArrayList<UniBusiSimpleItemDetail>> mAppidItemDetail;
    public int ret;

    static {
        ArrayList<UniBusiSimpleItemDetail> arrayList = new ArrayList<>();
        arrayList.add(new UniBusiSimpleItemDetail());
        cache_mAppidItemDetail.put(0, arrayList);
    }

    public UniBusiGetSimpleItemRsp() {
        this.ret = 0;
        this.errmsg = "";
        this.mAppidItemDetail = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, false);
        this.errmsg = jceInputStream.readString(1, false);
        this.mAppidItemDetail = (Map) jceInputStream.read((JceInputStream) cache_mAppidItemDetail, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        String str = this.errmsg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        Map<Integer, ArrayList<UniBusiSimpleItemDetail>> map = this.mAppidItemDetail;
        if (map != null) {
            jceOutputStream.write((Map) map, 2);
        }
    }

    public UniBusiGetSimpleItemRsp(int i3, String str, Map<Integer, ArrayList<UniBusiSimpleItemDetail>> map) {
        this.ret = i3;
        this.errmsg = str;
        this.mAppidItemDetail = map;
    }
}
