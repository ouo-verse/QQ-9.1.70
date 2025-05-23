package NS_GROUP_COUNT;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_group_count_rsp extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static Map<String, String> cache_extendinfo;
    static ArrayList<Long> cache_vecUinList = new ArrayList<>();
    public Map<String, String> extendinfo;
    public int iNextTimeout;
    public int iShowRedPoint;
    public long stCount;
    public ArrayList<Long> vecUinList;

    static {
        cache_vecUinList.add(0L);
        HashMap hashMap = new HashMap();
        cache_extendinfo = hashMap;
        hashMap.put("", "");
    }

    public mobile_group_count_rsp() {
        this.stCount = 0L;
        this.vecUinList = null;
        this.iShowRedPoint = 0;
        this.iNextTimeout = 0;
        this.extendinfo = null;
    }

    public String className() {
        return "NS_GROUP_COUNT.mobile_group_count_rsp";
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
        jceDisplayer.display(this.stCount, "stCount");
        jceDisplayer.display((Collection) this.vecUinList, "vecUinList");
        jceDisplayer.display(this.iShowRedPoint, "iShowRedPoint");
        jceDisplayer.display(this.iNextTimeout, "iNextTimeout");
        jceDisplayer.display((Map) this.extendinfo, "extendinfo");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.displaySimple(this.stCount, true);
        jceDisplayer.displaySimple((Collection) this.vecUinList, true);
        jceDisplayer.displaySimple(this.iShowRedPoint, true);
        jceDisplayer.displaySimple(this.iNextTimeout, true);
        jceDisplayer.displaySimple((Map) this.extendinfo, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        mobile_group_count_rsp mobile_group_count_rspVar = (mobile_group_count_rsp) obj;
        if (!JceUtil.equals(this.stCount, mobile_group_count_rspVar.stCount) || !JceUtil.equals(this.vecUinList, mobile_group_count_rspVar.vecUinList) || !JceUtil.equals(this.iShowRedPoint, mobile_group_count_rspVar.iShowRedPoint) || !JceUtil.equals(this.iNextTimeout, mobile_group_count_rspVar.iNextTimeout) || !JceUtil.equals(this.extendinfo, mobile_group_count_rspVar.extendinfo)) {
            return false;
        }
        return true;
    }

    public String fullClassName() {
        return "protocolqzone.NS_GROUP_COUNT.mobile_group_count_rsp";
    }

    public Map<String, String> getExtendinfo() {
        return this.extendinfo;
    }

    public int getINextTimeout() {
        return this.iNextTimeout;
    }

    public int getIShowRedPoint() {
        return this.iShowRedPoint;
    }

    public long getStCount() {
        return this.stCount;
    }

    public ArrayList<Long> getVecUinList() {
        return this.vecUinList;
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
        this.stCount = jceInputStream.read(this.stCount, 0, false);
        this.vecUinList = (ArrayList) jceInputStream.read((JceInputStream) cache_vecUinList, 1, false);
        this.iShowRedPoint = jceInputStream.read(this.iShowRedPoint, 2, false);
        this.iNextTimeout = jceInputStream.read(this.iNextTimeout, 3, false);
        this.extendinfo = (Map) jceInputStream.read((JceInputStream) cache_extendinfo, 4, false);
    }

    public void setExtendinfo(Map<String, String> map) {
        this.extendinfo = map;
    }

    public void setINextTimeout(int i3) {
        this.iNextTimeout = i3;
    }

    public void setIShowRedPoint(int i3) {
        this.iShowRedPoint = i3;
    }

    public void setStCount(long j3) {
        this.stCount = j3;
    }

    public void setVecUinList(ArrayList<Long> arrayList) {
        this.vecUinList = arrayList;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.stCount, 0);
        ArrayList<Long> arrayList = this.vecUinList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        jceOutputStream.write(this.iShowRedPoint, 2);
        jceOutputStream.write(this.iNextTimeout, 3);
        Map<String, String> map = this.extendinfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 4);
        }
    }

    public mobile_group_count_rsp(long j3, ArrayList<Long> arrayList, int i3, int i16, Map<String, String> map) {
        this.stCount = j3;
        this.vecUinList = arrayList;
        this.iShowRedPoint = i3;
        this.iNextTimeout = i16;
        this.extendinfo = map;
    }
}
