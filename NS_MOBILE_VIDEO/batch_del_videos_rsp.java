package NS_MOBILE_VIDEO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class batch_del_videos_rsp extends JceStruct {
    static ArrayList<DelVideoSummary> cache_summarys;

    /* renamed from: msg, reason: collision with root package name */
    public String f25055msg;
    public int ret;
    public ArrayList<DelVideoSummary> summarys;

    public batch_del_videos_rsp() {
        this.f25055msg = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, false);
        this.f25055msg = jceInputStream.readString(1, false);
        if (cache_summarys == null) {
            cache_summarys = new ArrayList<>();
            cache_summarys.add(new DelVideoSummary());
        }
        this.summarys = (ArrayList) jceInputStream.read((JceInputStream) cache_summarys, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        String str = this.f25055msg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        ArrayList<DelVideoSummary> arrayList = this.summarys;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
    }

    public batch_del_videos_rsp(int i3, String str, ArrayList<DelVideoSummary> arrayList) {
        this.ret = i3;
        this.f25055msg = str;
        this.summarys = arrayList;
    }
}
