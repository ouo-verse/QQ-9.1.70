package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class DownloadChooseReq extends JceStruct {
    static ArrayList<ResInfo> cache_vecResInfo = new ArrayList<>();
    public int iActId = 1001;
    public int iPlatForm = 1;
    public long iUin = 0;
    public ArrayList<ResInfo> vecResInfo = null;

    static {
        cache_vecResInfo.add(new ResInfo());
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iActId = jceInputStream.read(this.iActId, 0, false);
        this.iPlatForm = jceInputStream.read(this.iPlatForm, 1, false);
        this.iUin = jceInputStream.read(this.iUin, 2, false);
        this.vecResInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vecResInfo, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iActId, 0);
        jceOutputStream.write(this.iPlatForm, 1);
        jceOutputStream.write(this.iUin, 2);
        ArrayList<ResInfo> arrayList = this.vecResInfo;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
    }
}
