package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqAddDiscussMember extends JceStruct {
    static ArrayList<AddDiscussMemberInfo> cache_Members;
    public long DiscussUin;
    public ArrayList<AddDiscussMemberInfo> Members;

    public ReqAddDiscussMember() {
        this.DiscussUin = 0L;
        this.Members = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.DiscussUin = jceInputStream.read(this.DiscussUin, 0, true);
        if (cache_Members == null) {
            cache_Members = new ArrayList<>();
            cache_Members.add(new AddDiscussMemberInfo());
        }
        this.Members = (ArrayList) jceInputStream.read((JceInputStream) cache_Members, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.DiscussUin, 0);
        jceOutputStream.write((Collection) this.Members, 1);
    }

    public ReqAddDiscussMember(long j3, ArrayList<AddDiscussMemberInfo> arrayList) {
        this.DiscussUin = j3;
        this.Members = arrayList;
    }
}
