package NS_QZONE_MQMSG;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class QzoneMessageBoxRsp extends JceStruct {
    static ArrayList<BottomContentItem> cache_bottomVec;
    static UnReadSummaryInfo cache_unread_info;
    static ArrayList<NewMQMsg> cache_vecNews = new ArrayList<>();
    public ArrayList<BottomContentItem> bottomVec;
    public boolean hasMore;
    public int isNewStyle;
    public String more_url;
    public long qzone_level;
    public long registered_days;
    public String sTraceInfo;
    public UnReadSummaryInfo unread_info;
    public ArrayList<NewMQMsg> vecNews;
    public long visitor_count;

    static {
        cache_vecNews.add(new NewMQMsg());
        cache_bottomVec = new ArrayList<>();
        cache_bottomVec.add(new BottomContentItem());
        cache_unread_info = new UnReadSummaryInfo();
    }

    public QzoneMessageBoxRsp() {
        this.vecNews = null;
        this.sTraceInfo = "";
        this.hasMore = true;
        this.registered_days = 0L;
        this.qzone_level = 0L;
        this.visitor_count = 0L;
        this.more_url = "";
        this.bottomVec = null;
        this.isNewStyle = 0;
        this.unread_info = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.vecNews = (ArrayList) jceInputStream.read((JceInputStream) cache_vecNews, 0, false);
        this.sTraceInfo = jceInputStream.readString(1, false);
        this.hasMore = jceInputStream.read(this.hasMore, 2, false);
        this.registered_days = jceInputStream.read(this.registered_days, 3, false);
        this.qzone_level = jceInputStream.read(this.qzone_level, 4, false);
        this.visitor_count = jceInputStream.read(this.visitor_count, 5, false);
        this.more_url = jceInputStream.readString(6, false);
        this.bottomVec = (ArrayList) jceInputStream.read((JceInputStream) cache_bottomVec, 7, false);
        this.isNewStyle = jceInputStream.read(this.isNewStyle, 8, false);
        this.unread_info = (UnReadSummaryInfo) jceInputStream.read((JceStruct) cache_unread_info, 9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<NewMQMsg> arrayList = this.vecNews;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        String str = this.sTraceInfo;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.hasMore, 2);
        jceOutputStream.write(this.registered_days, 3);
        jceOutputStream.write(this.qzone_level, 4);
        jceOutputStream.write(this.visitor_count, 5);
        String str2 = this.more_url;
        if (str2 != null) {
            jceOutputStream.write(str2, 6);
        }
        ArrayList<BottomContentItem> arrayList2 = this.bottomVec;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 7);
        }
        jceOutputStream.write(this.isNewStyle, 8);
        UnReadSummaryInfo unReadSummaryInfo = this.unread_info;
        if (unReadSummaryInfo != null) {
            jceOutputStream.write((JceStruct) unReadSummaryInfo, 9);
        }
    }

    public QzoneMessageBoxRsp(ArrayList<NewMQMsg> arrayList, String str, boolean z16, long j3, long j16, long j17, String str2, ArrayList<BottomContentItem> arrayList2, int i3, UnReadSummaryInfo unReadSummaryInfo) {
        this.vecNews = arrayList;
        this.sTraceInfo = str;
        this.hasMore = z16;
        this.registered_days = j3;
        this.qzone_level = j16;
        this.visitor_count = j17;
        this.more_url = str2;
        this.bottomVec = arrayList2;
        this.isNewStyle = i3;
        this.unread_info = unReadSummaryInfo;
    }
}
