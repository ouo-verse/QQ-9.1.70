package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class ProfileInfoOperResp extends JceStruct {
    static ArrayList<ProfileInfoResp> cache_vecInfo;
    public byte cResult;
    public long uin;
    public ArrayList<ProfileInfoResp> vecInfo;

    public ProfileInfoOperResp() {
        this.uin = 0L;
        this.cResult = (byte) 0;
        this.vecInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.cResult = jceInputStream.read(this.cResult, 1, true);
        if (cache_vecInfo == null) {
            cache_vecInfo = new ArrayList<>();
            cache_vecInfo.add(new ProfileInfoResp());
        }
        this.vecInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vecInfo, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.cResult, 1);
        jceOutputStream.write((Collection) this.vecInfo, 2);
    }

    public ProfileInfoOperResp(long j3, byte b16, ArrayList<ProfileInfoResp> arrayList) {
        this.uin = j3;
        this.cResult = b16;
        this.vecInfo = arrayList;
    }
}
