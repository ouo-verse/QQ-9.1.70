package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GrpAlterInfo extends JceStruct {
    static ArrayList<GrpInfoItem> cache_AlterInfo;
    public ArrayList<GrpInfoItem> AlterInfo;
    public long GrpId;

    public GrpAlterInfo() {
        this.GrpId = 0L;
        this.AlterInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.GrpId = jceInputStream.read(this.GrpId, 0, true);
        if (cache_AlterInfo == null) {
            cache_AlterInfo = new ArrayList<>();
            cache_AlterInfo.add(new GrpInfoItem());
        }
        this.AlterInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_AlterInfo, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.GrpId, 0);
        jceOutputStream.write((Collection) this.AlterInfo, 1);
    }

    public GrpAlterInfo(long j3, ArrayList<GrpInfoItem> arrayList) {
        this.GrpId = j3;
        this.AlterInfo = arrayList;
    }
}
