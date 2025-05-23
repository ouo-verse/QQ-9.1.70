package NS_KING_SOCIALIZE_META;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stMetaNumericSys extends JceStruct {
    static ArrayList<String> cache_fri_follow_avatar;
    public int fans_num;
    public int feed_num;
    public int frdonly_feed_num;
    public ArrayList<String> fri_follow_avatar;
    public int fri_follow_num;
    public int interest_num;
    public int is_followed;
    public int praise_num;
    public int priv_feed_num;
    public int receivepraise_num;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_fri_follow_avatar = arrayList;
        arrayList.add("");
    }

    public stMetaNumericSys() {
        this.feed_num = 0;
        this.praise_num = 0;
        this.fans_num = 0;
        this.interest_num = 0;
        this.receivepraise_num = 0;
        this.is_followed = 0;
        this.priv_feed_num = 0;
        this.fri_follow_num = 0;
        this.frdonly_feed_num = 0;
        this.fri_follow_avatar = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.feed_num = jceInputStream.read(this.feed_num, 0, false);
        this.praise_num = jceInputStream.read(this.praise_num, 1, false);
        this.fans_num = jceInputStream.read(this.fans_num, 2, false);
        this.interest_num = jceInputStream.read(this.interest_num, 3, false);
        this.receivepraise_num = jceInputStream.read(this.receivepraise_num, 4, false);
        this.is_followed = jceInputStream.read(this.is_followed, 5, false);
        this.priv_feed_num = jceInputStream.read(this.priv_feed_num, 6, false);
        this.fri_follow_num = jceInputStream.read(this.fri_follow_num, 7, false);
        this.frdonly_feed_num = jceInputStream.read(this.frdonly_feed_num, 8, false);
        this.fri_follow_avatar = (ArrayList) jceInputStream.read((JceInputStream) cache_fri_follow_avatar, 9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.feed_num, 0);
        jceOutputStream.write(this.praise_num, 1);
        jceOutputStream.write(this.fans_num, 2);
        jceOutputStream.write(this.interest_num, 3);
        jceOutputStream.write(this.receivepraise_num, 4);
        jceOutputStream.write(this.is_followed, 5);
        jceOutputStream.write(this.priv_feed_num, 6);
        jceOutputStream.write(this.fri_follow_num, 7);
        jceOutputStream.write(this.frdonly_feed_num, 8);
        ArrayList<String> arrayList = this.fri_follow_avatar;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 9);
        }
    }

    public stMetaNumericSys(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, ArrayList<String> arrayList) {
        this.feed_num = i3;
        this.praise_num = i16;
        this.fans_num = i17;
        this.interest_num = i18;
        this.receivepraise_num = i19;
        this.is_followed = i26;
        this.priv_feed_num = i27;
        this.fri_follow_num = i28;
        this.frdonly_feed_num = i29;
        this.fri_follow_avatar = arrayList;
    }
}
