package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class event_group extends JceStruct {
    static ArrayList<event_card> cache_cards;
    static ArrayList<event_cloud_card> cache_cloudCards;
    static ArrayList<event_card_type> cache_types = new ArrayList<>();
    public ArrayList<event_card> cards;
    public ArrayList<event_cloud_card> cloudCards;
    public String groupid;
    public int type;
    public ArrayList<event_card_type> types;

    static {
        cache_types.add(new event_card_type());
        cache_cards = new ArrayList<>();
        cache_cards.add(new event_card());
        cache_cloudCards = new ArrayList<>();
        cache_cloudCards.add(new event_cloud_card());
    }

    public event_group() {
        this.groupid = "";
        this.types = null;
        this.cards = null;
        this.type = 0;
        this.cloudCards = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.groupid = jceInputStream.readString(0, true);
        this.types = (ArrayList) jceInputStream.read((JceInputStream) cache_types, 1, true);
        this.cards = (ArrayList) jceInputStream.read((JceInputStream) cache_cards, 2, false);
        this.type = jceInputStream.read(this.type, 3, false);
        this.cloudCards = (ArrayList) jceInputStream.read((JceInputStream) cache_cloudCards, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.groupid, 0);
        jceOutputStream.write((Collection) this.types, 1);
        ArrayList<event_card> arrayList = this.cards;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        jceOutputStream.write(this.type, 3);
        ArrayList<event_cloud_card> arrayList2 = this.cloudCards;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 4);
        }
    }

    public event_group(String str, ArrayList<event_card_type> arrayList, ArrayList<event_card> arrayList2, int i3, ArrayList<event_cloud_card> arrayList3) {
        this.groupid = str;
        this.types = arrayList;
        this.cards = arrayList2;
        this.type = i3;
        this.cloudCards = arrayList3;
    }
}
