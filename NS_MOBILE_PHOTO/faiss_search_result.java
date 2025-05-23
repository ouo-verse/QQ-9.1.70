package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class faiss_search_result extends JceStruct {
    static comm_page_info cache_page_info;
    static ArrayList<Photo> cache_photolist = new ArrayList<>();
    public String categoryid;
    public comm_page_info page_info;
    public ArrayList<Photo> photolist;

    static {
        cache_photolist.add(new Photo());
        cache_page_info = new comm_page_info();
    }

    public faiss_search_result() {
        this.photolist = null;
        this.page_info = null;
        this.categoryid = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.photolist = (ArrayList) jceInputStream.read((JceInputStream) cache_photolist, 0, false);
        this.page_info = (comm_page_info) jceInputStream.read((JceStruct) cache_page_info, 1, false);
        this.categoryid = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<Photo> arrayList = this.photolist;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        comm_page_info comm_page_infoVar = this.page_info;
        if (comm_page_infoVar != null) {
            jceOutputStream.write((JceStruct) comm_page_infoVar, 1);
        }
        String str = this.categoryid;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
    }

    public faiss_search_result(ArrayList<Photo> arrayList, comm_page_info comm_page_infoVar, String str) {
        this.photolist = arrayList;
        this.page_info = comm_page_infoVar;
        this.categoryid = str;
    }
}
