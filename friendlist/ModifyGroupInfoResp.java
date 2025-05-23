package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class ModifyGroupInfoResp extends JceStruct {
    static int cache_result;
    public long dwGroupCode;
    public int result;

    public ModifyGroupInfoResp() {
        this.result = 0;
        this.dwGroupCode = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.result = jceInputStream.read(this.result, 0, true);
        this.dwGroupCode = jceInputStream.read(this.dwGroupCode, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.result, 0);
        jceOutputStream.write(this.dwGroupCode, 1);
    }

    public ModifyGroupInfoResp(int i3, long j3) {
        this.result = i3;
        this.dwGroupCode = j3;
    }
}
