package NS_UNDEAL_COUNT;

import NS_MOBILE_COMM.OfficialComment;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stNuanNuanComment extends JceStruct {
    static ArrayList<OfficialComment> cache_vcComments;
    static ArrayList<String> cache_vcFirstComments;
    static ArrayList<String> cache_vcOtherComments;
    public int iPageCount;
    public int iStatus;
    public ArrayList<OfficialComment> vcComments;
    public ArrayList<String> vcFirstComments;
    public ArrayList<String> vcOtherComments;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_vcFirstComments = arrayList;
        arrayList.add("");
        ArrayList<String> arrayList2 = new ArrayList<>();
        cache_vcOtherComments = arrayList2;
        arrayList2.add("");
        cache_vcComments = new ArrayList<>();
        cache_vcComments.add(new OfficialComment());
    }

    public stNuanNuanComment() {
        this.iStatus = 0;
        this.iPageCount = 5;
        this.vcFirstComments = null;
        this.vcOtherComments = null;
        this.vcComments = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iStatus = jceInputStream.read(this.iStatus, 0, true);
        this.iPageCount = jceInputStream.read(this.iPageCount, 1, false);
        this.vcFirstComments = (ArrayList) jceInputStream.read((JceInputStream) cache_vcFirstComments, 2, false);
        this.vcOtherComments = (ArrayList) jceInputStream.read((JceInputStream) cache_vcOtherComments, 3, false);
        this.vcComments = (ArrayList) jceInputStream.read((JceInputStream) cache_vcComments, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iStatus, 0);
        jceOutputStream.write(this.iPageCount, 1);
        ArrayList<String> arrayList = this.vcFirstComments;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        ArrayList<String> arrayList2 = this.vcOtherComments;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 3);
        }
        ArrayList<OfficialComment> arrayList3 = this.vcComments;
        if (arrayList3 != null) {
            jceOutputStream.write((Collection) arrayList3, 4);
        }
    }

    public stNuanNuanComment(int i3, int i16, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<OfficialComment> arrayList3) {
        this.iStatus = i3;
        this.iPageCount = i16;
        this.vcFirstComments = arrayList;
        this.vcOtherComments = arrayList2;
        this.vcComments = arrayList3;
    }
}
