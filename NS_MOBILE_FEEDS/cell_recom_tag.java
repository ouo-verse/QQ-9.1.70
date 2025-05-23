package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_recom_tag extends JceStruct {
    static byte[] cache_tianshuEntry;
    public int action_type;
    public String action_url;
    public int recomStyle;
    public String recomTitle;
    public ArrayList<s_event_tag> shaishaiTagData;
    public s_event_tag tagData;
    public byte[] tianshuEntry;
    static s_event_tag cache_tagData = new s_event_tag();
    static ArrayList<s_event_tag> cache_shaishaiTagData = new ArrayList<>();

    static {
        cache_shaishaiTagData.add(new s_event_tag());
        cache_tianshuEntry = r0;
        byte[] bArr = {0};
    }

    public cell_recom_tag() {
        this.tagData = null;
        this.action_type = 0;
        this.action_url = "";
        this.shaishaiTagData = null;
        this.tianshuEntry = null;
        this.recomTitle = "";
        this.recomStyle = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.tagData = (s_event_tag) jceInputStream.read((JceStruct) cache_tagData, 0, false);
        this.action_type = jceInputStream.read(this.action_type, 1, false);
        this.action_url = jceInputStream.readString(2, false);
        this.shaishaiTagData = (ArrayList) jceInputStream.read((JceInputStream) cache_shaishaiTagData, 3, false);
        this.tianshuEntry = jceInputStream.read(cache_tianshuEntry, 4, false);
        this.recomTitle = jceInputStream.readString(5, false);
        this.recomStyle = jceInputStream.read(this.recomStyle, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        s_event_tag s_event_tagVar = this.tagData;
        if (s_event_tagVar != null) {
            jceOutputStream.write((JceStruct) s_event_tagVar, 0);
        }
        jceOutputStream.write(this.action_type, 1);
        String str = this.action_url;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        ArrayList<s_event_tag> arrayList = this.shaishaiTagData;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
        byte[] bArr = this.tianshuEntry;
        if (bArr != null) {
            jceOutputStream.write(bArr, 4);
        }
        String str2 = this.recomTitle;
        if (str2 != null) {
            jceOutputStream.write(str2, 5);
        }
        jceOutputStream.write(this.recomStyle, 6);
    }

    public cell_recom_tag(s_event_tag s_event_tagVar, int i3, String str, ArrayList<s_event_tag> arrayList, byte[] bArr, String str2, int i16) {
        this.tagData = s_event_tagVar;
        this.action_type = i3;
        this.action_url = str;
        this.shaishaiTagData = arrayList;
        this.tianshuEntry = bArr;
        this.recomTitle = str2;
        this.recomStyle = i16;
    }
}
