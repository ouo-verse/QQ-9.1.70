package FACADE_DIY;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class BatchGetFacadeReq extends JceStruct {
    static Map<Long, GetFacadeReqExt> cache_ext;
    static ArrayList<Long> cache_uins = new ArrayList<>();
    public Map<Long, GetFacadeReqExt> ext;
    public long loginUin;
    public int needElementInfo;
    public String qua;
    public ArrayList<Long> uins;

    static {
        cache_uins.add(0L);
        cache_ext = new HashMap();
        cache_ext.put(0L, new GetFacadeReqExt());
    }

    public BatchGetFacadeReq() {
        this.uins = null;
        this.qua = "";
        this.needElementInfo = 0;
        this.ext = null;
        this.loginUin = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uins = (ArrayList) jceInputStream.read((JceInputStream) cache_uins, 0, false);
        this.qua = jceInputStream.readString(1, false);
        this.needElementInfo = jceInputStream.read(this.needElementInfo, 2, false);
        this.ext = (Map) jceInputStream.read((JceInputStream) cache_ext, 3, false);
        this.loginUin = jceInputStream.read(this.loginUin, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<Long> arrayList = this.uins;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        String str = this.qua;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.needElementInfo, 2);
        Map<Long, GetFacadeReqExt> map = this.ext;
        if (map != null) {
            jceOutputStream.write((Map) map, 3);
        }
        jceOutputStream.write(this.loginUin, 4);
    }

    public BatchGetFacadeReq(ArrayList<Long> arrayList, String str, int i3, Map<Long, GetFacadeReqExt> map, long j3) {
        this.uins = arrayList;
        this.qua = str;
        this.needElementInfo = i3;
        this.ext = map;
        this.loginUin = j3;
    }
}
