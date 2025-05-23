package NS_MOBILE_BITMAP_4TH;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class bmp4_set_req extends JceStruct {
    static bmp4_values cache_map_kv = new bmp4_values();
    public int bitmap_id;
    public bmp4_values map_kv;
    public long uin;

    public bmp4_set_req() {
        this.uin = 0L;
        this.map_kv = null;
        this.bitmap_id = 4;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        this.map_kv = (bmp4_values) jceInputStream.read((JceStruct) cache_map_kv, 1, false);
        this.bitmap_id = jceInputStream.read(this.bitmap_id, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        bmp4_values bmp4_valuesVar = this.map_kv;
        if (bmp4_valuesVar != null) {
            jceOutputStream.write((JceStruct) bmp4_valuesVar, 1);
        }
        jceOutputStream.write(this.bitmap_id, 2);
    }

    public bmp4_set_req(long j3, bmp4_values bmp4_valuesVar, int i3) {
        this.uin = j3;
        this.map_kv = bmp4_valuesVar;
        this.bitmap_id = i3;
    }
}
