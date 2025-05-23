package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stGetSimpleCommentListRsp extends JceStruct {
    static ArrayList<stSimpleMetaComment> cache_comments = new ArrayList<>();
    public String attachInfo;
    public ArrayList<stSimpleMetaComment> comments;
    public int intervalTime;
    public boolean isFinished;
    public int limit;
    public int total;

    static {
        cache_comments.add(new stSimpleMetaComment());
    }

    public stGetSimpleCommentListRsp() {
        this.attachInfo = "";
        this.comments = null;
        this.isFinished = true;
        this.total = 0;
        this.limit = 0;
        this.intervalTime = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.attachInfo = jceInputStream.readString(0, false);
        this.comments = (ArrayList) jceInputStream.read((JceInputStream) cache_comments, 1, false);
        this.isFinished = jceInputStream.read(this.isFinished, 2, false);
        this.total = jceInputStream.read(this.total, 3, false);
        this.limit = jceInputStream.read(this.limit, 4, false);
        this.intervalTime = jceInputStream.read(this.intervalTime, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.attachInfo;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        ArrayList<stSimpleMetaComment> arrayList = this.comments;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        jceOutputStream.write(this.isFinished, 2);
        jceOutputStream.write(this.total, 3);
        jceOutputStream.write(this.limit, 4);
        jceOutputStream.write(this.intervalTime, 5);
    }

    public stGetSimpleCommentListRsp(String str, ArrayList<stSimpleMetaComment> arrayList, boolean z16, int i3, int i16, int i17) {
        this.attachInfo = str;
        this.comments = arrayList;
        this.isFinished = z16;
        this.total = i3;
        this.limit = i16;
        this.intervalTime = i17;
    }
}
