package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class stGetFirstPageMsgListRsp extends JceStruct {
    static ArrayList<stFirstPageSubjectInfo> cache_subjectList = new ArrayList<>();
    static Map<Integer, stMsgRedDotCount> cache_topRedCount;
    public boolean IsFinished;
    public String attachInfo;
    public ArrayList<stFirstPageSubjectInfo> subjectList;
    public Map<Integer, stMsgRedDotCount> topRedCount;

    static {
        cache_subjectList.add(new stFirstPageSubjectInfo());
        cache_topRedCount = new HashMap();
        cache_topRedCount.put(0, new stMsgRedDotCount());
    }

    public stGetFirstPageMsgListRsp() {
        this.attachInfo = "";
        this.IsFinished = true;
        this.subjectList = null;
        this.topRedCount = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.attachInfo = jceInputStream.readString(0, false);
        this.IsFinished = jceInputStream.read(this.IsFinished, 1, false);
        this.subjectList = (ArrayList) jceInputStream.read((JceInputStream) cache_subjectList, 2, false);
        this.topRedCount = (Map) jceInputStream.read((JceInputStream) cache_topRedCount, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.attachInfo;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.IsFinished, 1);
        ArrayList<stFirstPageSubjectInfo> arrayList = this.subjectList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        Map<Integer, stMsgRedDotCount> map = this.topRedCount;
        if (map != null) {
            jceOutputStream.write((Map) map, 3);
        }
    }

    public stGetFirstPageMsgListRsp(String str, boolean z16, ArrayList<stFirstPageSubjectInfo> arrayList, Map<Integer, stMsgRedDotCount> map) {
        this.attachInfo = str;
        this.IsFinished = z16;
        this.subjectList = arrayList;
        this.topRedCount = map;
    }
}
