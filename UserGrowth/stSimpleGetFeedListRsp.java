package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stSimpleGetFeedListRsp extends JceStruct {
    static stGlobalConfig cache_config;
    static ArrayList<stSimpleMetaFeed> cache_feeds = new ArrayList<>();
    static Map<String, Integer> cache_followinfo;
    static stMyVideoInfo cache_my_vinfo;
    public String attach_info;
    public byte clearcache;
    public stGlobalConfig config;
    public ArrayList<stSimpleMetaFeed> feeds;
    public Map<String, Integer> followinfo;
    public String gdt_args;
    public boolean is_finished;
    public stMyVideoInfo my_vinfo;
    public String session;
    public String trace_id;

    static {
        cache_feeds.add(new stSimpleMetaFeed());
        cache_followinfo = new HashMap();
        cache_followinfo.put("", 0);
        cache_config = new stGlobalConfig();
        cache_my_vinfo = new stMyVideoInfo();
    }

    public stSimpleGetFeedListRsp() {
        this.attach_info = "";
        this.feeds = null;
        this.is_finished = true;
        this.followinfo = null;
        this.clearcache = (byte) 0;
        this.config = null;
        this.gdt_args = "";
        this.my_vinfo = null;
        this.session = "";
        this.trace_id = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.attach_info = jceInputStream.readString(0, false);
        this.feeds = (ArrayList) jceInputStream.read((JceInputStream) cache_feeds, 1, false);
        this.is_finished = jceInputStream.read(this.is_finished, 2, false);
        this.followinfo = (Map) jceInputStream.read((JceInputStream) cache_followinfo, 3, false);
        this.clearcache = jceInputStream.read(this.clearcache, 4, false);
        this.config = (stGlobalConfig) jceInputStream.read((JceStruct) cache_config, 5, false);
        this.gdt_args = jceInputStream.readString(6, false);
        this.my_vinfo = (stMyVideoInfo) jceInputStream.read((JceStruct) cache_my_vinfo, 7, false);
        this.session = jceInputStream.readString(8, false);
        this.trace_id = jceInputStream.readString(9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.attach_info;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        ArrayList<stSimpleMetaFeed> arrayList = this.feeds;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        jceOutputStream.write(this.is_finished, 2);
        Map<String, Integer> map = this.followinfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 3);
        }
        jceOutputStream.write(this.clearcache, 4);
        stGlobalConfig stglobalconfig = this.config;
        if (stglobalconfig != null) {
            jceOutputStream.write((JceStruct) stglobalconfig, 5);
        }
        String str2 = this.gdt_args;
        if (str2 != null) {
            jceOutputStream.write(str2, 6);
        }
        stMyVideoInfo stmyvideoinfo = this.my_vinfo;
        if (stmyvideoinfo != null) {
            jceOutputStream.write((JceStruct) stmyvideoinfo, 7);
        }
        String str3 = this.session;
        if (str3 != null) {
            jceOutputStream.write(str3, 8);
        }
        String str4 = this.trace_id;
        if (str4 != null) {
            jceOutputStream.write(str4, 9);
        }
    }

    public stSimpleGetFeedListRsp(String str, ArrayList<stSimpleMetaFeed> arrayList, boolean z16, Map<String, Integer> map, byte b16, stGlobalConfig stglobalconfig, String str2, stMyVideoInfo stmyvideoinfo, String str3, String str4) {
        this.attach_info = str;
        this.feeds = arrayList;
        this.is_finished = z16;
        this.followinfo = map;
        this.clearcache = b16;
        this.config = stglobalconfig;
        this.gdt_args = str2;
        this.my_vinfo = stmyvideoinfo;
        this.session = str3;
        this.trace_id = str4;
    }
}
