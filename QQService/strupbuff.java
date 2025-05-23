package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class strupbuff extends JceStruct {
    static Map<String, ArrayList<byte[]>> cache_logstring;
    public byte encoding;
    public Map<String, ArrayList<byte[]>> logstring;
    public String prefix;
    public int seqno;

    public strupbuff() {
        this.logstring = null;
        this.prefix = "";
        this.encoding = (byte) 0;
        this.seqno = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_logstring == null) {
            cache_logstring = new HashMap();
            ArrayList<byte[]> arrayList = new ArrayList<>();
            arrayList.add(new byte[]{0});
            cache_logstring.put("", arrayList);
        }
        this.logstring = (Map) jceInputStream.read((JceInputStream) cache_logstring, 0, true);
        this.prefix = jceInputStream.readString(1, false);
        this.encoding = jceInputStream.read(this.encoding, 2, false);
        this.seqno = jceInputStream.read(this.seqno, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Map) this.logstring, 0);
        String str = this.prefix;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.encoding, 2);
        jceOutputStream.write(this.seqno, 3);
    }

    public strupbuff(Map<String, ArrayList<byte[]>> map, String str, byte b16, int i3) {
        this.logstring = map;
        this.prefix = str;
        this.encoding = b16;
        this.seqno = i3;
    }
}
