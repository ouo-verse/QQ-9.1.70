package NS_GROUP_COUNT;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_group_count_req extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static Map<String, String> cache_extendinfo;
    public Map<String, String> extendinfo;
    public long uGroupid;

    static {
        HashMap hashMap = new HashMap();
        cache_extendinfo = hashMap;
        hashMap.put("", "");
    }

    public mobile_group_count_req() {
        this.uGroupid = 0L;
        this.extendinfo = null;
    }

    public String className() {
        return "NS_GROUP_COUNT.mobile_group_count_req";
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void display(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.display(this.uGroupid, "uGroupid");
        jceDisplayer.display((Map) this.extendinfo, "extendinfo");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.displaySimple(this.uGroupid, true);
        jceDisplayer.displaySimple((Map) this.extendinfo, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        mobile_group_count_req mobile_group_count_reqVar = (mobile_group_count_req) obj;
        if (!JceUtil.equals(this.uGroupid, mobile_group_count_reqVar.uGroupid) || !JceUtil.equals(this.extendinfo, mobile_group_count_reqVar.extendinfo)) {
            return false;
        }
        return true;
    }

    public String fullClassName() {
        return "protocolqzone.NS_GROUP_COUNT.mobile_group_count_req";
    }

    public Map<String, String> getExtendinfo() {
        return this.extendinfo;
    }

    public long getUGroupid() {
        return this.uGroupid;
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uGroupid = jceInputStream.read(this.uGroupid, 0, false);
        this.extendinfo = (Map) jceInputStream.read((JceInputStream) cache_extendinfo, 1, false);
    }

    public void setExtendinfo(Map<String, String> map) {
        this.extendinfo = map;
    }

    public void setUGroupid(long j3) {
        this.uGroupid = j3;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uGroupid, 0);
        Map<String, String> map = this.extendinfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 1);
        }
    }

    public mobile_group_count_req(long j3, Map<String, String> map) {
        this.uGroupid = j3;
        this.extendinfo = map;
    }
}
