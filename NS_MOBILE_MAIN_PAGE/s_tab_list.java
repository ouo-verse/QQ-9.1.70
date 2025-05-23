package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_tab_list extends JceStruct {
    static ArrayList<s_tab_list_item> cache_lst_hide;
    static ArrayList<s_tab_list_item> cache_lst_show = new ArrayList<>();
    public ArrayList<s_tab_list_item> lst_hide;
    public ArrayList<s_tab_list_item> lst_show;

    static {
        cache_lst_show.add(new s_tab_list_item());
        cache_lst_hide = new ArrayList<>();
        cache_lst_hide.add(new s_tab_list_item());
    }

    public s_tab_list() {
        this.lst_show = null;
        this.lst_hide = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lst_show = (ArrayList) jceInputStream.read((JceInputStream) cache_lst_show, 0, true);
        this.lst_hide = (ArrayList) jceInputStream.read((JceInputStream) cache_lst_hide, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.lst_show, 0);
        jceOutputStream.write((Collection) this.lst_hide, 1);
    }

    public s_tab_list(ArrayList<s_tab_list_item> arrayList, ArrayList<s_tab_list_item> arrayList2) {
        this.lst_show = arrayList;
        this.lst_hide = arrayList2;
    }
}
