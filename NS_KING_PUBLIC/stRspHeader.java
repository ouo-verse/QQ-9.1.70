package NS_KING_PUBLIC;

import android.support.annotation.Nullable;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stRspHeader extends JceStruct {
    static Map<String, String> cache_mapExt;
    public int iRet;

    @Nullable
    public Map<String, String> mapExt;
    public String sErrmsg;

    static {
        HashMap hashMap = new HashMap();
        cache_mapExt = hashMap;
        hashMap.put("", "");
    }

    public stRspHeader() {
        this.iRet = 0;
        this.sErrmsg = "";
        this.mapExt = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iRet = jceInputStream.read(this.iRet, 0, true);
        this.sErrmsg = jceInputStream.readString(1, true);
        this.mapExt = (Map) jceInputStream.read((JceInputStream) cache_mapExt, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iRet, 0);
        jceOutputStream.write(this.sErrmsg, 1);
        Map<String, String> map = this.mapExt;
        if (map != null) {
            jceOutputStream.write((Map) map, 2);
        }
    }

    public stRspHeader(int i3, String str) {
        this.mapExt = null;
        this.iRet = i3;
        this.sErrmsg = str;
    }

    public stRspHeader(int i3, String str, Map<String, String> map) {
        this.iRet = i3;
        this.sErrmsg = str;
        this.mapExt = map;
    }
}
