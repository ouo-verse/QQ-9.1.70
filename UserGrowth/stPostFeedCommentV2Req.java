package UserGrowth;

import NS_KING_SOCIALIZE_META.stMetaReportDataItem;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class stPostFeedCommentV2Req extends JceStruct {
    static ArrayList<String> cache_atUserQQ;
    static stSimpleMetaComment cache_comment = new stSimpleMetaComment();
    static ArrayList<stMetaReportDataItem> cache_data = new ArrayList<>();
    public ArrayList<String> atUserQQ;
    public stSimpleMetaComment comment;
    public ArrayList<stMetaReportDataItem> data;
    public String feed_id;
    public int hadMancheked;

    static {
        cache_data.add(new stMetaReportDataItem());
        ArrayList<String> arrayList = new ArrayList<>();
        cache_atUserQQ = arrayList;
        arrayList.add("");
    }

    public stPostFeedCommentV2Req() {
        this.feed_id = "";
        this.comment = null;
        this.data = null;
        this.hadMancheked = 0;
        this.atUserQQ = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.feed_id = jceInputStream.readString(0, true);
        this.comment = (stSimpleMetaComment) jceInputStream.read((JceStruct) cache_comment, 1, true);
        this.data = (ArrayList) jceInputStream.read((JceInputStream) cache_data, 2, false);
        this.hadMancheked = jceInputStream.read(this.hadMancheked, 3, false);
        this.atUserQQ = (ArrayList) jceInputStream.read((JceInputStream) cache_atUserQQ, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public String toString() {
        return "stPostFeedCommentV2Req{feed_id='" + this.feed_id + "', comment=" + this.comment + ", data=" + this.data + ", hadMancheked=" + this.hadMancheked + ", atUserQQ=" + this.atUserQQ.toString() + '}';
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.feed_id, 0);
        jceOutputStream.write((JceStruct) this.comment, 1);
        ArrayList<stMetaReportDataItem> arrayList = this.data;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        jceOutputStream.write(this.hadMancheked, 3);
        ArrayList<String> arrayList2 = this.atUserQQ;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 4);
        }
    }

    public stPostFeedCommentV2Req(String str, stSimpleMetaComment stsimplemetacomment) {
        this.data = null;
        this.hadMancheked = 0;
        this.atUserQQ = null;
        this.feed_id = str;
        this.comment = stsimplemetacomment;
    }

    public stPostFeedCommentV2Req(String str, stSimpleMetaComment stsimplemetacomment, ArrayList<stMetaReportDataItem> arrayList, int i3, ArrayList<String> arrayList2) {
        this.feed_id = str;
        this.comment = stsimplemetacomment;
        this.data = arrayList;
        this.hadMancheked = i3;
        this.atUserQQ = arrayList2;
    }
}
