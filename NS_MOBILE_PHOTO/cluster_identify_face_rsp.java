package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cluster_identify_face_rsp extends JceStruct {
    static int cache_mode;
    static ArrayList<cluster_search_result> cache_results = new ArrayList<>();
    public boolean has_identify;
    public int mode;

    /* renamed from: msg, reason: collision with root package name */
    public String f25036msg;
    public ArrayList<cluster_search_result> results;
    public int ret;
    public String url;

    static {
        cache_results.add(new cluster_search_result());
    }

    public cluster_identify_face_rsp() {
        this.ret = 0;
        this.f25036msg = "";
        this.has_identify = false;
        this.mode = 1;
        this.results = null;
        this.url = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, false);
        this.f25036msg = jceInputStream.readString(1, false);
        this.has_identify = jceInputStream.read(this.has_identify, 2, false);
        this.mode = jceInputStream.read(this.mode, 3, false);
        this.results = (ArrayList) jceInputStream.read((JceInputStream) cache_results, 4, false);
        this.url = jceInputStream.readString(5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        String str = this.f25036msg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.has_identify, 2);
        jceOutputStream.write(this.mode, 3);
        ArrayList<cluster_search_result> arrayList = this.results;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 4);
        }
        String str2 = this.url;
        if (str2 != null) {
            jceOutputStream.write(str2, 5);
        }
    }

    public cluster_identify_face_rsp(int i3, String str, boolean z16, int i16, ArrayList<cluster_search_result> arrayList, String str2) {
        this.ret = i3;
        this.f25036msg = str;
        this.has_identify = z16;
        this.mode = i16;
        this.results = arrayList;
        this.url = str2;
    }
}
