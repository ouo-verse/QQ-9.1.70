package PayMQQ;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class UniPayResponse extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static Map<String, String> cache_mapResponse;
    public int iShowOpen;
    public int iUniPayType;
    public Map<String, String> mapResponse;
    public String sProductID;
    public String sUin;

    public UniPayResponse() {
        this.sUin = "";
        this.iShowOpen = 0;
        this.iUniPayType = 0;
        this.sProductID = "";
        this.mapResponse = null;
    }

    public String className() {
        return "MQQ.UniPayResponse";
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
        jceDisplayer.display(this.sUin, "sUin");
        jceDisplayer.display(this.iShowOpen, "iShowOpen");
        jceDisplayer.display(this.iUniPayType, "iUniPayType");
        jceDisplayer.display(this.sProductID, "sProductID");
        jceDisplayer.display((Map) this.mapResponse, "mapResponse");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.displaySimple(this.sUin, true);
        jceDisplayer.displaySimple(this.iShowOpen, true);
        jceDisplayer.displaySimple(this.iUniPayType, true);
        jceDisplayer.displaySimple(this.sProductID, true);
        jceDisplayer.displaySimple((Map) this.mapResponse, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        UniPayResponse uniPayResponse = (UniPayResponse) obj;
        if (!JceUtil.equals(this.sUin, uniPayResponse.sUin) || !JceUtil.equals(this.iShowOpen, uniPayResponse.iShowOpen) || !JceUtil.equals(this.iUniPayType, uniPayResponse.iUniPayType) || !JceUtil.equals(this.sProductID, uniPayResponse.sProductID) || !JceUtil.equals(this.mapResponse, uniPayResponse.mapResponse)) {
            return false;
        }
        return true;
    }

    public String fullClassName() {
        return "MQQ.UniPayResponse";
    }

    public int getIShowOpen() {
        return this.iShowOpen;
    }

    public int getIUniPayType() {
        return this.iUniPayType;
    }

    public Map<String, String> getMapResponse() {
        return this.mapResponse;
    }

    public String getSProductID() {
        return this.sProductID;
    }

    public String getSUin() {
        return this.sUin;
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
        this.sUin = jceInputStream.readString(0, true);
        this.iShowOpen = jceInputStream.read(this.iShowOpen, 1, true);
        this.iUniPayType = jceInputStream.read(this.iUniPayType, 2, true);
        this.sProductID = jceInputStream.readString(3, true);
        if (cache_mapResponse == null) {
            HashMap hashMap = new HashMap();
            cache_mapResponse = hashMap;
            hashMap.put("", "");
        }
        this.mapResponse = (Map) jceInputStream.read((JceInputStream) cache_mapResponse, 4, true);
    }

    public void setIShowOpen(int i3) {
        this.iShowOpen = i3;
    }

    public void setIUniPayType(int i3) {
        this.iUniPayType = i3;
    }

    public void setMapResponse(Map<String, String> map) {
        this.mapResponse = map;
    }

    public void setSProductID(String str) {
        this.sProductID = str;
    }

    public void setSUin(String str) {
        this.sUin = str;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.sUin, 0);
        jceOutputStream.write(this.iShowOpen, 1);
        jceOutputStream.write(this.iUniPayType, 2);
        jceOutputStream.write(this.sProductID, 3);
        jceOutputStream.write((Map) this.mapResponse, 4);
    }

    public UniPayResponse(String str, int i3, int i16, String str2, Map<String, String> map) {
        this.sUin = str;
        this.iShowOpen = i3;
        this.iUniPayType = i16;
        this.sProductID = str2;
        this.mapResponse = map;
    }
}
