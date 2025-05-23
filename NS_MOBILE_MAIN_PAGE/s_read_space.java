package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_read_space extends JceStruct {
    static ArrayList<s_user> cache_detailreadspace;
    public int allnum;
    public ArrayList<s_user> detailreadspace;
    public int unreadnum;

    public s_read_space() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.allnum = jceInputStream.read(this.allnum, 0, false);
        this.unreadnum = jceInputStream.read(this.unreadnum, 1, false);
        if (cache_detailreadspace == null) {
            cache_detailreadspace = new ArrayList<>();
            cache_detailreadspace.add(new s_user());
        }
        this.detailreadspace = (ArrayList) jceInputStream.read((JceInputStream) cache_detailreadspace, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.allnum, 0);
        jceOutputStream.write(this.unreadnum, 1);
        ArrayList<s_user> arrayList = this.detailreadspace;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
    }

    public s_read_space(int i3, int i16, ArrayList<s_user> arrayList) {
        this.allnum = i3;
        this.unreadnum = i16;
        this.detailreadspace = arrayList;
    }
}
