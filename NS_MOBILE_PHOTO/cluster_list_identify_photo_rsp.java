package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cluster_list_identify_photo_rsp extends JceStruct {
    static faiss_search_result cache_result = new faiss_search_result();

    /* renamed from: msg, reason: collision with root package name */
    public String f25037msg;
    public faiss_search_result result;
    public int ret;

    public cluster_list_identify_photo_rsp() {
        this.ret = 0;
        this.f25037msg = "";
        this.result = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, false);
        this.f25037msg = jceInputStream.readString(1, false);
        this.result = (faiss_search_result) jceInputStream.read((JceStruct) cache_result, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        String str = this.f25037msg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        faiss_search_result faiss_search_resultVar = this.result;
        if (faiss_search_resultVar != null) {
            jceOutputStream.write((JceStruct) faiss_search_resultVar, 2);
        }
    }

    public cluster_list_identify_photo_rsp(int i3, String str, faiss_search_result faiss_search_resultVar) {
        this.ret = i3;
        this.f25037msg = str;
        this.result = faiss_search_resultVar;
    }
}
