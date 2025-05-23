package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CGetMoreRsp extends JceStruct {
    static Map<String, String> cache_extParams;
    static ArrayList<ItemDisDetail> cache_itemList = new ArrayList<>();
    public String errmsg;
    public Map<String, String> extParams;
    public int isListEnd;
    public ArrayList<ItemDisDetail> itemList;
    public int nextIndex;
    public int ret;
    public long ruleid;

    static {
        cache_itemList.add(new ItemDisDetail());
        HashMap hashMap = new HashMap();
        cache_extParams = hashMap;
        hashMap.put("", "");
    }

    public CGetMoreRsp() {
        this.ret = 0;
        this.errmsg = "";
        this.nextIndex = 0;
        this.isListEnd = 0;
        this.itemList = null;
        this.ruleid = 0L;
        this.extParams = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, false);
        this.errmsg = jceInputStream.readString(1, false);
        this.nextIndex = jceInputStream.read(this.nextIndex, 2, false);
        this.isListEnd = jceInputStream.read(this.isListEnd, 3, false);
        this.itemList = (ArrayList) jceInputStream.read((JceInputStream) cache_itemList, 4, false);
        this.ruleid = jceInputStream.read(this.ruleid, 5, false);
        this.extParams = (Map) jceInputStream.read((JceInputStream) cache_extParams, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        String str = this.errmsg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.nextIndex, 2);
        jceOutputStream.write(this.isListEnd, 3);
        ArrayList<ItemDisDetail> arrayList = this.itemList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 4);
        }
        jceOutputStream.write(this.ruleid, 5);
        Map<String, String> map = this.extParams;
        if (map != null) {
            jceOutputStream.write((Map) map, 6);
        }
    }

    public CGetMoreRsp(int i3, String str, int i16, int i17, ArrayList<ItemDisDetail> arrayList, long j3, Map<String, String> map) {
        this.ret = i3;
        this.errmsg = str;
        this.nextIndex = i16;
        this.isListEnd = i17;
        this.itemList = arrayList;
        this.ruleid = j3;
        this.extParams = map;
    }
}
