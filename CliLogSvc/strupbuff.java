package CliLogSvc;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class strupbuff extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static Map<String, ArrayList<byte[]>> cache_logstring;
    public Map<String, ArrayList<byte[]>> logstring = null;
    public String prefix = "";

    public strupbuff() {
        setLogstring(null);
        setPrefix(this.prefix);
    }

    public String className() {
        return "strupbuff";
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
        jceDisplayer.display((Map) this.logstring, "logstring");
        jceDisplayer.display(this.prefix, "prefix");
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        strupbuff strupbuffVar = (strupbuff) obj;
        if (!JceUtil.equals(this.logstring, strupbuffVar.logstring) || !JceUtil.equals(this.prefix, strupbuffVar.prefix)) {
            return false;
        }
        return true;
    }

    public String fullClassName() {
        return "CliLogSvc.strupbuff";
    }

    public Map<String, ArrayList<byte[]>> getLogstring() {
        return this.logstring;
    }

    public String getPrefix() {
        return this.prefix;
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
        if (cache_logstring == null) {
            cache_logstring = new HashMap();
            ArrayList<byte[]> arrayList = new ArrayList<>();
            arrayList.add(new byte[]{0});
            cache_logstring.put("", arrayList);
        }
        setLogstring((Map) jceInputStream.read((JceInputStream) cache_logstring, 0, true));
        setPrefix(jceInputStream.readString(1, false));
    }

    public void setLogstring(Map<String, ArrayList<byte[]>> map) {
        this.logstring = map;
    }

    public void setPrefix(String str) {
        this.prefix = str;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Map) this.logstring, 0);
        String str = this.prefix;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public strupbuff(Map<String, ArrayList<byte[]>> map, String str) {
        setLogstring(map);
        setPrefix(str);
    }
}
