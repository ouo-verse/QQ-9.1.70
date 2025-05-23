package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class ProfUsrFullInfoRes extends JceStruct {
    static Map<Long, String> cache_sRemarkInfo;
    static ArrayList<TagInfo> cache_sTagInfo;
    static ProfSmpInfoRes cache_strPfileSmpInfoRes;
    public Map<Long, String> sRemarkInfo;
    public String sSigInfo;
    public ArrayList<TagInfo> sTagInfo;
    public ProfSmpInfoRes strPfileSmpInfoRes;

    public ProfUsrFullInfoRes() {
        this.strPfileSmpInfoRes = null;
        this.sSigInfo = "";
        this.sRemarkInfo = null;
        this.sTagInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_strPfileSmpInfoRes == null) {
            cache_strPfileSmpInfoRes = new ProfSmpInfoRes();
        }
        this.strPfileSmpInfoRes = (ProfSmpInfoRes) jceInputStream.read((JceStruct) cache_strPfileSmpInfoRes, 1, true);
        this.sSigInfo = jceInputStream.readString(2, true);
        if (cache_sRemarkInfo == null) {
            cache_sRemarkInfo = new HashMap();
            cache_sRemarkInfo.put(0L, "");
        }
        this.sRemarkInfo = (Map) jceInputStream.read((JceInputStream) cache_sRemarkInfo, 3, true);
        if (cache_sTagInfo == null) {
            cache_sTagInfo = new ArrayList<>();
            cache_sTagInfo.add(new TagInfo());
        }
        this.sTagInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_sTagInfo, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.strPfileSmpInfoRes, 1);
        jceOutputStream.write(this.sSigInfo, 2);
        jceOutputStream.write((Map) this.sRemarkInfo, 3);
        ArrayList<TagInfo> arrayList = this.sTagInfo;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 4);
        }
    }

    public ProfUsrFullInfoRes(ProfSmpInfoRes profSmpInfoRes, String str, Map<Long, String> map, ArrayList<TagInfo> arrayList) {
        this.strPfileSmpInfoRes = profSmpInfoRes;
        this.sSigInfo = str;
        this.sRemarkInfo = map;
        this.sTagInfo = arrayList;
    }
}
