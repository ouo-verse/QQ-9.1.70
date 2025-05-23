package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_limit_page_card extends JceStruct {
    static ArrayList<s_limit_page_card_item> cache_lst_data = new ArrayList<>();
    public ArrayList<s_limit_page_card_item> lst_data;

    static {
        cache_lst_data.add(new s_limit_page_card_item());
    }

    public s_limit_page_card() {
        this.lst_data = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lst_data = (ArrayList) jceInputStream.read((JceInputStream) cache_lst_data, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.lst_data, 0);
    }

    public s_limit_page_card(ArrayList<s_limit_page_card_item> arrayList) {
        this.lst_data = arrayList;
    }
}
