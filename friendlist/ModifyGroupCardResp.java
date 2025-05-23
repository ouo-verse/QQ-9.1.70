package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class ModifyGroupCardResp extends JceStruct {
    static int cache_result;
    static ArrayList<Long> cache_vecUin = new ArrayList<>();
    public String ErrorString;
    public long dwGroupCode;
    public long dwGroupUin;
    public int result;
    public ArrayList<Long> vecUin;

    static {
        cache_vecUin.add(0L);
    }

    public ModifyGroupCardResp() {
        this.result = 0;
        this.dwGroupUin = 0L;
        this.dwGroupCode = 0L;
        this.vecUin = null;
        this.ErrorString = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.result = jceInputStream.read(this.result, 0, true);
        this.dwGroupUin = jceInputStream.read(this.dwGroupUin, 1, true);
        this.dwGroupCode = jceInputStream.read(this.dwGroupCode, 2, true);
        this.vecUin = (ArrayList) jceInputStream.read((JceInputStream) cache_vecUin, 3, true);
        this.ErrorString = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.result, 0);
        jceOutputStream.write(this.dwGroupUin, 1);
        jceOutputStream.write(this.dwGroupCode, 2);
        jceOutputStream.write((Collection) this.vecUin, 3);
        String str = this.ErrorString;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
    }

    public ModifyGroupCardResp(int i3, long j3, long j16, ArrayList<Long> arrayList, String str) {
        this.result = i3;
        this.dwGroupUin = j3;
        this.dwGroupCode = j16;
        this.vecUin = arrayList;
        this.ErrorString = str;
    }
}
