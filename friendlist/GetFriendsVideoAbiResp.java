package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class GetFriendsVideoAbiResp extends JceStruct {
    static ArrayList<UserVideoAbi> cache_finfo;
    static int cache_result;
    public short errorCode;
    public ArrayList<UserVideoAbi> finfo;
    public int result;
    public long uin;

    public GetFriendsVideoAbiResp() {
        this.uin = 0L;
        this.finfo = null;
        this.result = 0;
        this.errorCode = (short) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        if (cache_finfo == null) {
            cache_finfo = new ArrayList<>();
            cache_finfo.add(new UserVideoAbi());
        }
        this.finfo = (ArrayList) jceInputStream.read((JceInputStream) cache_finfo, 1, true);
        this.result = jceInputStream.read(this.result, 2, true);
        this.errorCode = jceInputStream.read(this.errorCode, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write((Collection) this.finfo, 1);
        jceOutputStream.write(this.result, 2);
        jceOutputStream.write(this.errorCode, 3);
    }

    public GetFriendsVideoAbiResp(long j3, ArrayList<UserVideoAbi> arrayList, int i3, short s16) {
        this.uin = j3;
        this.finfo = arrayList;
        this.result = i3;
        this.errorCode = s16;
    }
}
