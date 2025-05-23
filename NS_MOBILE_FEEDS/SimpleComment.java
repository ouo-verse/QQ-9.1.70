package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SimpleComment extends JceStruct {
    static ArrayList<Long> cache_reply_ids = new ArrayList<>();

    /* renamed from: id, reason: collision with root package name */
    public long f24981id;
    public ArrayList<Long> reply_ids;

    static {
        cache_reply_ids.add(0L);
    }

    public SimpleComment() {
        this.f24981id = 0L;
        this.reply_ids = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f24981id = jceInputStream.read(this.f24981id, 0, false);
        this.reply_ids = (ArrayList) jceInputStream.read((JceInputStream) cache_reply_ids, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f24981id, 0);
        ArrayList<Long> arrayList = this.reply_ids;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
    }

    public SimpleComment(long j3, ArrayList<Long> arrayList) {
        this.f24981id = j3;
        this.reply_ids = arrayList;
    }
}
