package NS_MOBILE_COMM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CommInteractive extends JceStruct {
    public Map<Integer, String> ext;
    public int iRet;
    public int interactiveType;
    public stOperaData opData;
    public String strErrToast;
    static stOperaData cache_opData = new stOperaData();
    static Map<Integer, String> cache_ext = new HashMap();

    static {
        cache_ext.put(0, "");
    }

    public CommInteractive() {
        this.iRet = 0;
        this.strErrToast = "";
        this.interactiveType = 0;
        this.opData = null;
        this.ext = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iRet = jceInputStream.read(this.iRet, 0, false);
        this.strErrToast = jceInputStream.readString(1, false);
        this.interactiveType = jceInputStream.read(this.interactiveType, 2, false);
        this.opData = (stOperaData) jceInputStream.read((JceStruct) cache_opData, 3, false);
        this.ext = (Map) jceInputStream.read((JceInputStream) cache_ext, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iRet, 0);
        String str = this.strErrToast;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.interactiveType, 2);
        stOperaData stoperadata = this.opData;
        if (stoperadata != null) {
            jceOutputStream.write((JceStruct) stoperadata, 3);
        }
        Map<Integer, String> map = this.ext;
        if (map != null) {
            jceOutputStream.write((Map) map, 4);
        }
    }

    public CommInteractive(int i3, String str, int i16, stOperaData stoperadata, Map<Integer, String> map) {
        this.iRet = i3;
        this.strErrToast = str;
        this.interactiveType = i16;
        this.opData = stoperadata;
        this.ext = map;
    }
}
