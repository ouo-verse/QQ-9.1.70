package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_feeds_piece_list extends JceStruct {
    static ArrayList<single_feed> cache_all_feeds_data = new ArrayList<>();
    public ArrayList<single_feed> all_feeds_data;
    public long offset;
    public String tlv_attach_info;

    static {
        cache_all_feeds_data.add(new single_feed());
    }

    public mobile_feeds_piece_list() {
        this.tlv_attach_info = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.all_feeds_data = (ArrayList) jceInputStream.read((JceInputStream) cache_all_feeds_data, 0, false);
        this.offset = jceInputStream.read(this.offset, 1, false);
        this.tlv_attach_info = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<single_feed> arrayList = this.all_feeds_data;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        jceOutputStream.write(this.offset, 1);
        String str = this.tlv_attach_info;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
    }

    public mobile_feeds_piece_list(ArrayList<single_feed> arrayList, long j3, String str) {
        this.all_feeds_data = arrayList;
        this.offset = j3;
        this.tlv_attach_info = str;
    }
}
