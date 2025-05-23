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
public final class stSimpleGetFeedListReq extends JceStruct {
    static ArrayList<String> cache_context_feedids;
    static ArrayList<stExposureFeedInfo> cache_exposureFeedList;
    static Map<String, Integer> cache_feedsVideoType;
    static stLinkStragegyArgs cache_linkStragetyArgs;
    static ArrayList<String> cache_local_feeds;
    static Map<String, String> cache_request_ext;
    static byte[] cache_waterAdReq;
    public String attach_info;
    public String channel_info;
    public ArrayList<String> context_feedids;
    public ArrayList<stExposureFeedInfo> exposureFeedList;
    public Map<String, Integer> feedsVideoType;
    public String gdt_args;
    public byte isfirst;
    public byte isrefresh;
    public stLinkStragegyArgs linkStragetyArgs;
    public ArrayList<String> local_feeds;
    public String push_info;
    public String qqNum;
    public Map<String, String> request_ext;
    public String rowkey;
    public int scene;
    public String session;
    public String subTabID;
    public byte[] waterAdReq;

    static {
        HashMap hashMap = new HashMap();
        cache_request_ext = hashMap;
        hashMap.put("", "");
        ArrayList<String> arrayList = new ArrayList<>();
        cache_local_feeds = arrayList;
        arrayList.add("");
        ArrayList<String> arrayList2 = new ArrayList<>();
        cache_context_feedids = arrayList2;
        arrayList2.add("");
        cache_linkStragetyArgs = new stLinkStragegyArgs();
        cache_exposureFeedList = new ArrayList<>();
        cache_exposureFeedList.add(new stExposureFeedInfo());
        cache_feedsVideoType = new HashMap();
        cache_feedsVideoType.put("", 0);
        cache_waterAdReq = r1;
        byte[] bArr = {0};
    }

    public stSimpleGetFeedListReq() {
        this.attach_info = "";
        this.isrefresh = (byte) 0;
        this.isfirst = (byte) 0;
        this.channel_info = "";
        this.request_ext = null;
        this.local_feeds = null;
        this.context_feedids = null;
        this.scene = 0;
        this.gdt_args = "";
        this.rowkey = "";
        this.session = "";
        this.push_info = "";
        this.linkStragetyArgs = null;
        this.qqNum = "";
        this.subTabID = "";
        this.exposureFeedList = null;
        this.feedsVideoType = null;
        this.waterAdReq = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.attach_info = jceInputStream.readString(0, false);
        this.isrefresh = jceInputStream.read(this.isrefresh, 1, false);
        this.isfirst = jceInputStream.read(this.isfirst, 2, false);
        this.channel_info = jceInputStream.readString(4, false);
        this.request_ext = (Map) jceInputStream.read((JceInputStream) cache_request_ext, 5, false);
        this.local_feeds = (ArrayList) jceInputStream.read((JceInputStream) cache_local_feeds, 6, false);
        this.context_feedids = (ArrayList) jceInputStream.read((JceInputStream) cache_context_feedids, 7, false);
        this.scene = jceInputStream.read(this.scene, 8, false);
        this.gdt_args = jceInputStream.readString(9, false);
        this.rowkey = jceInputStream.readString(10, false);
        this.session = jceInputStream.readString(11, false);
        this.push_info = jceInputStream.readString(12, false);
        this.linkStragetyArgs = (stLinkStragegyArgs) jceInputStream.read((JceStruct) cache_linkStragetyArgs, 13, false);
        this.qqNum = jceInputStream.readString(14, false);
        this.subTabID = jceInputStream.readString(15, false);
        this.exposureFeedList = (ArrayList) jceInputStream.read((JceInputStream) cache_exposureFeedList, 16, false);
        this.feedsVideoType = (Map) jceInputStream.read((JceInputStream) cache_feedsVideoType, 17, false);
        this.waterAdReq = jceInputStream.read(cache_waterAdReq, 18, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.attach_info;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.isrefresh, 1);
        jceOutputStream.write(this.isfirst, 2);
        String str2 = this.channel_info;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        Map<String, String> map = this.request_ext;
        if (map != null) {
            jceOutputStream.write((Map) map, 5);
        }
        ArrayList<String> arrayList = this.local_feeds;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 6);
        }
        ArrayList<String> arrayList2 = this.context_feedids;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 7);
        }
        jceOutputStream.write(this.scene, 8);
        String str3 = this.gdt_args;
        if (str3 != null) {
            jceOutputStream.write(str3, 9);
        }
        String str4 = this.rowkey;
        if (str4 != null) {
            jceOutputStream.write(str4, 10);
        }
        String str5 = this.session;
        if (str5 != null) {
            jceOutputStream.write(str5, 11);
        }
        String str6 = this.push_info;
        if (str6 != null) {
            jceOutputStream.write(str6, 12);
        }
        stLinkStragegyArgs stlinkstragegyargs = this.linkStragetyArgs;
        if (stlinkstragegyargs != null) {
            jceOutputStream.write((JceStruct) stlinkstragegyargs, 13);
        }
        String str7 = this.qqNum;
        if (str7 != null) {
            jceOutputStream.write(str7, 14);
        }
        String str8 = this.subTabID;
        if (str8 != null) {
            jceOutputStream.write(str8, 15);
        }
        ArrayList<stExposureFeedInfo> arrayList3 = this.exposureFeedList;
        if (arrayList3 != null) {
            jceOutputStream.write((Collection) arrayList3, 16);
        }
        Map<String, Integer> map2 = this.feedsVideoType;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 17);
        }
        byte[] bArr = this.waterAdReq;
        if (bArr != null) {
            jceOutputStream.write(bArr, 18);
        }
    }

    public stSimpleGetFeedListReq(String str, byte b16, byte b17, String str2, Map<String, String> map, ArrayList<String> arrayList, ArrayList<String> arrayList2, int i3, String str3, String str4, String str5, String str6, stLinkStragegyArgs stlinkstragegyargs, String str7, String str8, ArrayList<stExposureFeedInfo> arrayList3, Map<String, Integer> map2, byte[] bArr) {
        this.attach_info = str;
        this.isrefresh = b16;
        this.isfirst = b17;
        this.channel_info = str2;
        this.request_ext = map;
        this.local_feeds = arrayList;
        this.context_feedids = arrayList2;
        this.scene = i3;
        this.gdt_args = str3;
        this.rowkey = str4;
        this.session = str5;
        this.push_info = str6;
        this.linkStragetyArgs = stlinkstragegyargs;
        this.qqNum = str7;
        this.subTabID = str8;
        this.exposureFeedList = arrayList3;
        this.feedsVideoType = map2;
        this.waterAdReq = bArr;
    }
}
