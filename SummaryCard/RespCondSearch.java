package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RespCondSearch extends JceStruct {
    static ArrayList<CondFitUser> cache_vUserList;
    public byte cEndFlag;
    public long dwSessionID;
    public int iPage;
    public ArrayList<CondFitUser> vUserList;

    public RespCondSearch() {
        this.cEndFlag = (byte) 0;
        this.iPage = 0;
        this.dwSessionID = 0L;
        this.vUserList = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cEndFlag = jceInputStream.read(this.cEndFlag, 0, true);
        this.iPage = jceInputStream.read(this.iPage, 1, true);
        this.dwSessionID = jceInputStream.read(this.dwSessionID, 2, true);
        if (cache_vUserList == null) {
            cache_vUserList = new ArrayList<>();
            cache_vUserList.add(new CondFitUser());
        }
        this.vUserList = (ArrayList) jceInputStream.read((JceInputStream) cache_vUserList, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.cEndFlag, 0);
        jceOutputStream.write(this.iPage, 1);
        jceOutputStream.write(this.dwSessionID, 2);
        ArrayList<CondFitUser> arrayList = this.vUserList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
    }

    public RespCondSearch(byte b16, int i3, long j3, ArrayList<CondFitUser> arrayList) {
        this.cEndFlag = b16;
        this.iPage = i3;
        this.dwSessionID = j3;
        this.vUserList = arrayList;
    }
}
