package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_pic_text extends JceStruct {
    static ArrayList<st_pic_text> cache_data_list = new ArrayList<>();
    public ArrayList<st_pic_text> data_list;
    public int data_num;

    static {
        cache_data_list.add(new st_pic_text());
    }

    public cell_pic_text() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.data_num = jceInputStream.read(this.data_num, 0, false);
        this.data_list = (ArrayList) jceInputStream.read((JceInputStream) cache_data_list, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.data_num, 0);
        ArrayList<st_pic_text> arrayList = this.data_list;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
    }

    public cell_pic_text(int i3, ArrayList<st_pic_text> arrayList) {
        this.data_num = i3;
        this.data_list = arrayList;
    }
}
