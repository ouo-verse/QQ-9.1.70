package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class DownloadChooseRsp extends JceStruct {
    static ArrayList<ResInfo> cache_vecResInfo = new ArrayList<>();
    public ArrayList<ResInfo> vecResInfo = null;

    static {
        cache_vecResInfo.add(new ResInfo());
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.vecResInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vecResInfo, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<ResInfo> arrayList = this.vecResInfo;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
    }
}
