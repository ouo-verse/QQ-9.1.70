package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_tab_list_tmem extends JceStruct {
    static ArrayList<Integer> cache_user_list = new ArrayList<>();
    public ArrayList<Integer> user_list;

    static {
        cache_user_list.add(0);
    }

    public s_tab_list_tmem() {
        this.user_list = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.user_list = (ArrayList) jceInputStream.read((JceInputStream) cache_user_list, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.user_list, 0);
    }

    public s_tab_list_tmem(ArrayList<Integer> arrayList) {
        this.user_list = arrayList;
    }
}
