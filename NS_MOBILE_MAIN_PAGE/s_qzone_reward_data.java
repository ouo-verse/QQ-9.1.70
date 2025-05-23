package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_qzone_reward_data extends JceStruct {
    static ArrayList<s_reward_node> cache_vec_nodes = new ArrayList<>();
    public boolean show_entry;
    public ArrayList<s_reward_node> vec_nodes;

    static {
        cache_vec_nodes.add(new s_reward_node());
    }

    public s_qzone_reward_data() {
        this.show_entry = true;
        this.vec_nodes = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.show_entry = jceInputStream.read(this.show_entry, 0, true);
        this.vec_nodes = (ArrayList) jceInputStream.read((JceInputStream) cache_vec_nodes, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.show_entry, 0);
        ArrayList<s_reward_node> arrayList = this.vec_nodes;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
    }

    public s_qzone_reward_data(boolean z16, ArrayList<s_reward_node> arrayList) {
        this.show_entry = z16;
        this.vec_nodes = arrayList;
    }
}
