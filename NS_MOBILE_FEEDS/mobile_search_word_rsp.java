package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_search_word_rsp extends JceStruct {
    static ArrayList<s_search_word> cache_vec_hotword;
    static ArrayList<s_search_word> cache_vec_tab = new ArrayList<>();
    public int iRetCode;
    public ArrayList<s_search_word> vec_hotword;
    public ArrayList<s_search_word> vec_tab;

    static {
        cache_vec_tab.add(new s_search_word());
        cache_vec_hotword = new ArrayList<>();
        cache_vec_hotword.add(new s_search_word());
    }

    public mobile_search_word_rsp() {
        this.iRetCode = 0;
        this.vec_tab = null;
        this.vec_hotword = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iRetCode = jceInputStream.read(this.iRetCode, 0, false);
        this.vec_tab = (ArrayList) jceInputStream.read((JceInputStream) cache_vec_tab, 1, false);
        this.vec_hotword = (ArrayList) jceInputStream.read((JceInputStream) cache_vec_hotword, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iRetCode, 0);
        ArrayList<s_search_word> arrayList = this.vec_tab;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        ArrayList<s_search_word> arrayList2 = this.vec_hotword;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 2);
        }
    }

    public mobile_search_word_rsp(int i3, ArrayList<s_search_word> arrayList, ArrayList<s_search_word> arrayList2) {
        this.iRetCode = i3;
        this.vec_tab = arrayList;
        this.vec_hotword = arrayList2;
    }
}
