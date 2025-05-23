package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SyncReqCookie extends JceStruct {
    static byte[] cache_vCookie;
    static ArrayList<Long> cache_vServiceId;
    public byte[] vCookie;
    public ArrayList<Long> vServiceId;

    public SyncReqCookie() {
        this.vServiceId = null;
        this.vCookie = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_vServiceId == null) {
            cache_vServiceId = new ArrayList<>();
            cache_vServiceId.add(0L);
        }
        this.vServiceId = (ArrayList) jceInputStream.read((JceInputStream) cache_vServiceId, 0, true);
        if (cache_vCookie == null) {
            cache_vCookie = r0;
            byte[] bArr = {0};
        }
        this.vCookie = jceInputStream.read(cache_vCookie, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.vServiceId, 0);
        byte[] bArr = this.vCookie;
        if (bArr != null) {
            jceOutputStream.write(bArr, 1);
        }
    }

    public SyncReqCookie(ArrayList<Long> arrayList, byte[] bArr) {
        this.vServiceId = arrayList;
        this.vCookie = bArr;
    }
}
