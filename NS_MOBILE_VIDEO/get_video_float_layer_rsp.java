package NS_MOBILE_VIDEO;

import NS_MOBILE_FEEDS.single_feed;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class get_video_float_layer_rsp extends JceStruct {
    static WeishiAggregatePageRsp cache_aggregate_page_rsp;
    static ArrayList<single_feed> cache_all_after_paster_adv;
    static ArrayList<single_feed> cache_all_videolist_data = new ArrayList<>();
    static byte[] cache_busi_binary_data;
    static Map<Integer, String> cache_busi_param;
    static Map<String, String> cache_extend_info;
    static QzoneWeisiReqcommendRsp cache_qzone_weisi_rsp;
    static video_floating_layer_search_bar cache_search_bar;
    public WeishiAggregatePageRsp aggregate_page_rsp;
    public ArrayList<single_feed> all_after_paster_adv;
    public ArrayList<single_feed> all_videolist_data;
    public String attach_info;
    public byte[] busi_binary_data;
    public Map<Integer, String> busi_param;
    public Map<String, String> extend_info;
    public int hasmore;
    public QzoneWeisiReqcommendRsp qzone_weisi_rsp;
    public video_floating_layer_search_bar search_bar;

    static {
        cache_all_videolist_data.add(new single_feed());
        cache_busi_param = new HashMap();
        cache_busi_param.put(0, "");
        HashMap hashMap = new HashMap();
        cache_extend_info = hashMap;
        hashMap.put("", "");
        cache_search_bar = new video_floating_layer_search_bar();
        cache_all_after_paster_adv = new ArrayList<>();
        cache_all_after_paster_adv.add(new single_feed());
        cache_qzone_weisi_rsp = new QzoneWeisiReqcommendRsp();
        cache_aggregate_page_rsp = new WeishiAggregatePageRsp();
        cache_busi_binary_data = r1;
        byte[] bArr = {0};
    }

    public get_video_float_layer_rsp() {
        this.all_videolist_data = null;
        this.busi_param = null;
        this.extend_info = null;
        this.hasmore = 0;
        this.attach_info = "";
        this.search_bar = null;
        this.all_after_paster_adv = null;
        this.qzone_weisi_rsp = null;
        this.aggregate_page_rsp = null;
        this.busi_binary_data = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.all_videolist_data = (ArrayList) jceInputStream.read((JceInputStream) cache_all_videolist_data, 0, false);
        this.busi_param = (Map) jceInputStream.read((JceInputStream) cache_busi_param, 1, false);
        this.extend_info = (Map) jceInputStream.read((JceInputStream) cache_extend_info, 2, false);
        this.hasmore = jceInputStream.read(this.hasmore, 3, false);
        this.attach_info = jceInputStream.readString(4, false);
        this.search_bar = (video_floating_layer_search_bar) jceInputStream.read((JceStruct) cache_search_bar, 5, false);
        this.all_after_paster_adv = (ArrayList) jceInputStream.read((JceInputStream) cache_all_after_paster_adv, 6, false);
        this.qzone_weisi_rsp = (QzoneWeisiReqcommendRsp) jceInputStream.read((JceStruct) cache_qzone_weisi_rsp, 7, false);
        this.aggregate_page_rsp = (WeishiAggregatePageRsp) jceInputStream.read((JceStruct) cache_aggregate_page_rsp, 8, false);
        this.busi_binary_data = jceInputStream.read(cache_busi_binary_data, 9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<single_feed> arrayList = this.all_videolist_data;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        Map<Integer, String> map = this.busi_param;
        if (map != null) {
            jceOutputStream.write((Map) map, 1);
        }
        Map<String, String> map2 = this.extend_info;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 2);
        }
        jceOutputStream.write(this.hasmore, 3);
        String str = this.attach_info;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
        video_floating_layer_search_bar video_floating_layer_search_barVar = this.search_bar;
        if (video_floating_layer_search_barVar != null) {
            jceOutputStream.write((JceStruct) video_floating_layer_search_barVar, 5);
        }
        ArrayList<single_feed> arrayList2 = this.all_after_paster_adv;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 6);
        }
        QzoneWeisiReqcommendRsp qzoneWeisiReqcommendRsp = this.qzone_weisi_rsp;
        if (qzoneWeisiReqcommendRsp != null) {
            jceOutputStream.write((JceStruct) qzoneWeisiReqcommendRsp, 7);
        }
        WeishiAggregatePageRsp weishiAggregatePageRsp = this.aggregate_page_rsp;
        if (weishiAggregatePageRsp != null) {
            jceOutputStream.write((JceStruct) weishiAggregatePageRsp, 8);
        }
        byte[] bArr = this.busi_binary_data;
        if (bArr != null) {
            jceOutputStream.write(bArr, 9);
        }
    }

    public get_video_float_layer_rsp(ArrayList<single_feed> arrayList, Map<Integer, String> map, Map<String, String> map2, int i3, String str, video_floating_layer_search_bar video_floating_layer_search_barVar, ArrayList<single_feed> arrayList2, QzoneWeisiReqcommendRsp qzoneWeisiReqcommendRsp, WeishiAggregatePageRsp weishiAggregatePageRsp, byte[] bArr) {
        this.all_videolist_data = arrayList;
        this.busi_param = map;
        this.extend_info = map2;
        this.hasmore = i3;
        this.attach_info = str;
        this.search_bar = video_floating_layer_search_barVar;
        this.all_after_paster_adv = arrayList2;
        this.qzone_weisi_rsp = qzoneWeisiReqcommendRsp;
        this.aggregate_page_rsp = weishiAggregatePageRsp;
        this.busi_binary_data = bArr;
    }
}
