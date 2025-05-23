package NS_KING_INTERFACE;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class stMetaExternPlatformInfo extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static stAction cache_action = new stAction();
    static Map<Integer, String> cache_reserve = new HashMap();
    public stAction action;
    public int count;
    public String icon;
    public String infoName;
    public String name;
    public Map<Integer, String> reserve;
    public int show;

    static {
        cache_reserve.put(0, "");
    }

    public stMetaExternPlatformInfo() {
        this.name = "";
        this.icon = "";
        this.infoName = "";
        this.action = null;
        this.count = 0;
        this.show = 0;
        this.reserve = null;
    }

    public String className() {
        return "NS_KING_INTERFACE.stMetaExternPlatformInfo";
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
        jceDisplayer.display(this.name, "name");
        jceDisplayer.display(this.icon, "icon");
        jceDisplayer.display(this.infoName, "infoName");
        jceDisplayer.display((JceStruct) this.action, "action");
        jceDisplayer.display(this.count, "count");
        jceDisplayer.display(this.show, "show");
        jceDisplayer.display((Map) this.reserve, "reserve");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.displaySimple(this.name, true);
        jceDisplayer.displaySimple(this.icon, true);
        jceDisplayer.displaySimple(this.infoName, true);
        jceDisplayer.displaySimple((JceStruct) this.action, true);
        jceDisplayer.displaySimple(this.count, true);
        jceDisplayer.displaySimple(this.show, true);
        jceDisplayer.displaySimple((Map) this.reserve, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        stMetaExternPlatformInfo stmetaexternplatforminfo = (stMetaExternPlatformInfo) obj;
        if (!JceUtil.equals(this.name, stmetaexternplatforminfo.name) || !JceUtil.equals(this.icon, stmetaexternplatforminfo.icon) || !JceUtil.equals(this.infoName, stmetaexternplatforminfo.infoName) || !JceUtil.equals(this.action, stmetaexternplatforminfo.action) || !JceUtil.equals(this.count, stmetaexternplatforminfo.count) || !JceUtil.equals(this.show, stmetaexternplatforminfo.show) || !JceUtil.equals(this.reserve, stmetaexternplatforminfo.reserve)) {
            return false;
        }
        return true;
    }

    public String fullClassName() {
        return "NS_KING_INTERFACE.stMetaExternPlatformInfo";
    }

    public stAction getAction() {
        return this.action;
    }

    public int getCount() {
        return this.count;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getInfoName() {
        return this.infoName;
    }

    public String getName() {
        return this.name;
    }

    public Map<Integer, String> getReserve() {
        return this.reserve;
    }

    public int getShow() {
        return this.show;
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
        this.name = jceInputStream.readString(0, false);
        this.icon = jceInputStream.readString(1, false);
        this.infoName = jceInputStream.readString(2, false);
        this.action = (stAction) jceInputStream.read((JceStruct) cache_action, 3, false);
        this.count = jceInputStream.read(this.count, 4, false);
        this.show = jceInputStream.read(this.show, 5, false);
        this.reserve = (Map) jceInputStream.read((JceInputStream) cache_reserve, 6, false);
    }

    public void setAction(stAction staction) {
        this.action = staction;
    }

    public void setCount(int i3) {
        this.count = i3;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setInfoName(String str) {
        this.infoName = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setReserve(Map<Integer, String> map) {
        this.reserve = map;
    }

    public void setShow(int i3) {
        this.show = i3;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.name;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.icon;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.infoName;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        stAction staction = this.action;
        if (staction != null) {
            jceOutputStream.write((JceStruct) staction, 3);
        }
        jceOutputStream.write(this.count, 4);
        jceOutputStream.write(this.show, 5);
        Map<Integer, String> map = this.reserve;
        if (map != null) {
            jceOutputStream.write((Map) map, 6);
        }
    }

    public stMetaExternPlatformInfo(String str, String str2, String str3, stAction staction, int i3, int i16, Map<Integer, String> map) {
        this.name = str;
        this.icon = str2;
        this.infoName = str3;
        this.action = staction;
        this.count = i3;
        this.show = i16;
        this.reserve = map;
    }
}
