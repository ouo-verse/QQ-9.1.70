package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_comment_essence extends JceStruct {
    static ArrayList<s_commment> cache_commments = new ArrayList<>();
    public ArrayList<s_commment> commments;
    public int displayflag;
    public int num;
    public String txt;

    static {
        cache_commments.add(new s_commment());
    }

    public cell_comment_essence() {
        this.num = 0;
        this.commments = null;
        this.displayflag = 0;
        this.txt = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.num = jceInputStream.read(this.num, 0, false);
        this.commments = (ArrayList) jceInputStream.read((JceInputStream) cache_commments, 1, false);
        this.displayflag = jceInputStream.read(this.displayflag, 2, false);
        this.txt = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.num, 0);
        ArrayList<s_commment> arrayList = this.commments;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        jceOutputStream.write(this.displayflag, 2);
        jceOutputStream.write(this.txt, 4);
    }

    public cell_comment_essence(int i3, ArrayList<s_commment> arrayList, int i16, String str) {
        this.num = i3;
        this.commments = arrayList;
        this.displayflag = i16;
        this.txt = str;
    }
}
