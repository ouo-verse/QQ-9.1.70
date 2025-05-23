package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SvcReqBindUin extends JceStruct {
    static ArrayList<BindUin> cache_vecBindUin;
    public byte cCmd;
    public ArrayList<BindUin> vecBindUin;

    public SvcReqBindUin() {
        this.cCmd = (byte) 0;
        this.vecBindUin = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cCmd = jceInputStream.read(this.cCmd, 0, true);
        if (cache_vecBindUin == null) {
            cache_vecBindUin = new ArrayList<>();
            cache_vecBindUin.add(new BindUin());
        }
        this.vecBindUin = (ArrayList) jceInputStream.read((JceInputStream) cache_vecBindUin, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.cCmd, 0);
        jceOutputStream.write((Collection) this.vecBindUin, 1);
    }

    public SvcReqBindUin(byte b16, ArrayList<BindUin> arrayList) {
        this.cCmd = b16;
        this.vecBindUin = arrayList;
    }
}
