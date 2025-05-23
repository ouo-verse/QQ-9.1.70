package QMF_PROTOCAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class QmfTokenInfo extends JceStruct {
    static byte[] cache_Key;
    static Map<Integer, byte[]> cache_ext_key;
    public byte[] Key;
    public int Type;
    public Map<Integer, byte[]> ext_key;

    public QmfTokenInfo() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.Type = jceInputStream.read(this.Type, 0, true);
        if (cache_Key == null) {
            cache_Key = r0;
            byte[] bArr = {0};
        }
        this.Key = jceInputStream.read(cache_Key, 1, true);
        if (cache_ext_key == null) {
            cache_ext_key = new HashMap();
            cache_ext_key.put(0, new byte[]{0});
        }
        this.ext_key = (Map) jceInputStream.read((JceInputStream) cache_ext_key, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.Type, 0);
        jceOutputStream.write(this.Key, 1);
        Map<Integer, byte[]> map = this.ext_key;
        if (map != null) {
            jceOutputStream.write((Map) map, 2);
        }
    }

    public QmfTokenInfo(int i3, byte[] bArr, Map<Integer, byte[]> map) {
        this.Type = i3;
        this.Key = bArr;
        this.ext_key = map;
    }
}
