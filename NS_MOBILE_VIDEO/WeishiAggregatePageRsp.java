package NS_MOBILE_VIDEO;

import NS_MOBILE_FEEDS.s_button;
import NS_MOBILE_FEEDS.s_outshare;
import NS_MOBILE_FEEDS.s_weishi;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class WeishiAggregatePageRsp extends JceStruct {
    static int cache_page_type;
    public s_button bottom_button;

    /* renamed from: id, reason: collision with root package name */
    public String f25054id;
    public long like_num;
    public int page_type;
    public s_outshare share_info;
    public String shot_page_title;
    public String summary;
    public String title;
    public long video_num;
    public s_weishi weishi_info;
    static s_button cache_bottom_button = new s_button();
    static s_outshare cache_share_info = new s_outshare();
    static s_weishi cache_weishi_info = new s_weishi();

    public WeishiAggregatePageRsp() {
        this.title = "";
        this.f25054id = "";
        this.page_type = 0;
        this.summary = "";
        this.video_num = 0L;
        this.like_num = 0L;
        this.shot_page_title = "";
        this.bottom_button = null;
        this.share_info = null;
        this.weishi_info = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.title = jceInputStream.readString(0, false);
        this.f25054id = jceInputStream.readString(1, false);
        this.page_type = jceInputStream.read(this.page_type, 2, false);
        this.summary = jceInputStream.readString(3, false);
        this.video_num = jceInputStream.read(this.video_num, 4, false);
        this.like_num = jceInputStream.read(this.like_num, 5, false);
        this.shot_page_title = jceInputStream.readString(6, false);
        this.bottom_button = (s_button) jceInputStream.read((JceStruct) cache_bottom_button, 7, false);
        this.share_info = (s_outshare) jceInputStream.read((JceStruct) cache_share_info, 8, false);
        this.weishi_info = (s_weishi) jceInputStream.read((JceStruct) cache_weishi_info, 9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.title;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.f25054id;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        jceOutputStream.write(this.page_type, 2);
        String str3 = this.summary;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        jceOutputStream.write(this.video_num, 4);
        jceOutputStream.write(this.like_num, 5);
        String str4 = this.shot_page_title;
        if (str4 != null) {
            jceOutputStream.write(str4, 6);
        }
        s_button s_buttonVar = this.bottom_button;
        if (s_buttonVar != null) {
            jceOutputStream.write((JceStruct) s_buttonVar, 7);
        }
        s_outshare s_outshareVar = this.share_info;
        if (s_outshareVar != null) {
            jceOutputStream.write((JceStruct) s_outshareVar, 8);
        }
        s_weishi s_weishiVar = this.weishi_info;
        if (s_weishiVar != null) {
            jceOutputStream.write((JceStruct) s_weishiVar, 9);
        }
    }

    public WeishiAggregatePageRsp(String str, String str2, int i3, String str3, long j3, long j16, String str4, s_button s_buttonVar, s_outshare s_outshareVar, s_weishi s_weishiVar) {
        this.title = str;
        this.f25054id = str2;
        this.page_type = i3;
        this.summary = str3;
        this.video_num = j3;
        this.like_num = j16;
        this.shot_page_title = str4;
        this.bottom_button = s_buttonVar;
        this.share_info = s_outshareVar;
        this.weishi_info = s_weishiVar;
    }
}
