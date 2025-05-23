package ResPackage;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ResUpdate extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static Map<String, String> cache_AttrMap;
    static int cache_OpType;
    public Map<String, String> AttrMap;
    public int OpType;
    public String Path;
    public String ResURL;

    public ResUpdate() {
        this.Path = "";
        this.OpType = 0;
        this.ResURL = "";
        this.AttrMap = null;
    }

    public String className() {
        return "ResPackage.ResUpdate";
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
        jceDisplayer.display(this.Path, "Path");
        jceDisplayer.display(this.OpType, "OpType");
        jceDisplayer.display(this.ResURL, "ResURL");
        jceDisplayer.display((Map) this.AttrMap, "AttrMap");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.displaySimple(this.Path, true);
        jceDisplayer.displaySimple(this.OpType, true);
        jceDisplayer.displaySimple(this.ResURL, true);
        jceDisplayer.displaySimple((Map) this.AttrMap, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        ResUpdate resUpdate = (ResUpdate) obj;
        if (!JceUtil.equals(this.Path, resUpdate.Path) || !JceUtil.equals(this.OpType, resUpdate.OpType) || !JceUtil.equals(this.ResURL, resUpdate.ResURL) || !JceUtil.equals(this.AttrMap, resUpdate.AttrMap)) {
            return false;
        }
        return true;
    }

    public String fullClassName() {
        return "ResPackage.ResUpdate";
    }

    public Map<String, String> getAttrMap() {
        return this.AttrMap;
    }

    public int getOpType() {
        return this.OpType;
    }

    public String getPath() {
        return this.Path;
    }

    public String getResURL() {
        return this.ResURL;
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
        this.Path = jceInputStream.readString(0, true);
        this.OpType = jceInputStream.read(this.OpType, 1, true);
        this.ResURL = jceInputStream.readString(2, false);
        if (cache_AttrMap == null) {
            HashMap hashMap = new HashMap();
            cache_AttrMap = hashMap;
            hashMap.put("", "");
        }
        this.AttrMap = (Map) jceInputStream.read((JceInputStream) cache_AttrMap, 3, false);
    }

    public void setAttrMap(Map<String, String> map) {
        this.AttrMap = map;
    }

    public void setOpType(int i3) {
        this.OpType = i3;
    }

    public void setPath(String str) {
        this.Path = str;
    }

    public void setResURL(String str) {
        this.ResURL = str;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.Path, 0);
        jceOutputStream.write(this.OpType, 1);
        String str = this.ResURL;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        Map<String, String> map = this.AttrMap;
        if (map != null) {
            jceOutputStream.write((Map) map, 3);
        }
    }

    public ResUpdate(String str, int i3, String str2, Map<String, String> map) {
        this.Path = str;
        this.OpType = i3;
        this.ResURL = str2;
        this.AttrMap = map;
    }
}
