package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CheckUpdateResp extends JceStruct {
    static ArrayList<RespItem> cache_vecResPkg;
    public long dwSsoSeq;
    public boolean isEnd;
    public byte result;
    public ArrayList<RespItem> vecResPkg;

    public CheckUpdateResp() {
        this.result = (byte) 0;
        this.vecResPkg = null;
        this.isEnd = true;
        this.dwSsoSeq = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.result = jceInputStream.read(this.result, 0, true);
        if (cache_vecResPkg == null) {
            cache_vecResPkg = new ArrayList<>();
            cache_vecResPkg.add(new RespItem());
        }
        this.vecResPkg = (ArrayList) jceInputStream.read((JceInputStream) cache_vecResPkg, 1, true);
        this.isEnd = jceInputStream.read(this.isEnd, 2, false);
        this.dwSsoSeq = jceInputStream.read(this.dwSsoSeq, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.result, 0);
        jceOutputStream.write((Collection) this.vecResPkg, 1);
        jceOutputStream.write(this.isEnd, 2);
        jceOutputStream.write(this.dwSsoSeq, 3);
    }

    public CheckUpdateResp(byte b16, ArrayList<RespItem> arrayList, boolean z16, long j3) {
        this.result = b16;
        this.vecResPkg = arrayList;
        this.isEnd = z16;
        this.dwSsoSeq = j3;
    }
}
