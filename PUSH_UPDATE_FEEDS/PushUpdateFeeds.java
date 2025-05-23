package PUSH_UPDATE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class PushUpdateFeeds extends JceStruct {
    static Map<Integer, String> cache_cell_checksum;
    static Map<Integer, String> cache_cell_infos;
    static CommentReplyInfo cache_commmet_reply_info;
    static Map<String, String> cache_extendinfo;
    static Map<Integer, byte[]> cache_feeds_data = new HashMap();
    public boolean all_pull;
    public Map<Integer, String> cell_checksum;
    public Map<Integer, String> cell_infos;
    public CommentReplyInfo commmet_reply_info;
    public Map<String, String> extendinfo;
    public Map<Integer, byte[]> feeds_data;
    public long feeds_update_time;
    public boolean need_pull;
    public String ugc_key;

    static {
        cache_feeds_data.put(0, new byte[]{0});
        HashMap hashMap = new HashMap();
        cache_extendinfo = hashMap;
        hashMap.put("", "");
        cache_cell_infos = new HashMap();
        cache_cell_infos.put(0, "");
        cache_commmet_reply_info = new CommentReplyInfo();
        cache_cell_checksum = new HashMap();
        cache_cell_checksum.put(0, "");
    }

    public PushUpdateFeeds() {
        this.ugc_key = "";
        this.feeds_data = null;
        this.extendinfo = null;
        this.cell_infos = null;
        this.commmet_reply_info = null;
        this.feeds_update_time = 0L;
        this.need_pull = true;
        this.cell_checksum = null;
        this.all_pull = true;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ugc_key = jceInputStream.readString(0, false);
        this.feeds_data = (Map) jceInputStream.read((JceInputStream) cache_feeds_data, 1, false);
        this.extendinfo = (Map) jceInputStream.read((JceInputStream) cache_extendinfo, 2, false);
        this.cell_infos = (Map) jceInputStream.read((JceInputStream) cache_cell_infos, 3, false);
        this.commmet_reply_info = (CommentReplyInfo) jceInputStream.read((JceStruct) cache_commmet_reply_info, 4, false);
        this.feeds_update_time = jceInputStream.read(this.feeds_update_time, 5, false);
        this.need_pull = jceInputStream.read(this.need_pull, 6, false);
        this.cell_checksum = (Map) jceInputStream.read((JceInputStream) cache_cell_checksum, 7, false);
        this.all_pull = jceInputStream.read(this.all_pull, 8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.ugc_key;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        Map<Integer, byte[]> map = this.feeds_data;
        if (map != null) {
            jceOutputStream.write((Map) map, 1);
        }
        Map<String, String> map2 = this.extendinfo;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 2);
        }
        Map<Integer, String> map3 = this.cell_infos;
        if (map3 != null) {
            jceOutputStream.write((Map) map3, 3);
        }
        CommentReplyInfo commentReplyInfo = this.commmet_reply_info;
        if (commentReplyInfo != null) {
            jceOutputStream.write((JceStruct) commentReplyInfo, 4);
        }
        jceOutputStream.write(this.feeds_update_time, 5);
        jceOutputStream.write(this.need_pull, 6);
        Map<Integer, String> map4 = this.cell_checksum;
        if (map4 != null) {
            jceOutputStream.write((Map) map4, 7);
        }
        jceOutputStream.write(this.all_pull, 8);
    }

    public PushUpdateFeeds(String str, Map<Integer, byte[]> map, Map<String, String> map2, Map<Integer, String> map3, CommentReplyInfo commentReplyInfo, long j3, boolean z16, Map<Integer, String> map4, boolean z17) {
        this.ugc_key = str;
        this.feeds_data = map;
        this.extendinfo = map2;
        this.cell_infos = map3;
        this.commmet_reply_info = commentReplyInfo;
        this.feeds_update_time = j3;
        this.need_pull = z16;
        this.cell_checksum = map4;
        this.all_pull = z17;
    }
}
