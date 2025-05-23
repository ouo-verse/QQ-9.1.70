package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class ProfileInfoOperReq extends JceStruct {
    static ArrayList<ProfileInfoReq> cache_vecInfo;
    public long uin;
    public ArrayList<ProfileInfoReq> vecInfo;

    public ProfileInfoOperReq() {
        this.uin = 0L;
        this.vecInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        if (cache_vecInfo == null) {
            cache_vecInfo = new ArrayList<>();
            cache_vecInfo.add(new ProfileInfoReq());
        }
        this.vecInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vecInfo, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write((Collection) this.vecInfo, 1);
    }

    public ProfileInfoOperReq(long j3, ArrayList<ProfileInfoReq> arrayList) {
        this.uin = j3;
        this.vecInfo = arrayList;
    }
}
