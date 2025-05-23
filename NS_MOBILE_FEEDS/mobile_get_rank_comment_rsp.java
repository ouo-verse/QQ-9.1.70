package NS_MOBILE_FEEDS;

import NS_MOBILE_COMM.OfficialComment;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_get_rank_comment_rsp extends JceStruct {
    static ArrayList<OfficialComment> cache_vcComments = new ArrayList<>();
    public ArrayList<OfficialComment> vcComments;

    static {
        cache_vcComments.add(new OfficialComment());
    }

    public mobile_get_rank_comment_rsp() {
        this.vcComments = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.vcComments = (ArrayList) jceInputStream.read((JceInputStream) cache_vcComments, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<OfficialComment> arrayList = this.vcComments;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
    }

    public mobile_get_rank_comment_rsp(ArrayList<OfficialComment> arrayList) {
        this.vcComments = arrayList;
    }
}
