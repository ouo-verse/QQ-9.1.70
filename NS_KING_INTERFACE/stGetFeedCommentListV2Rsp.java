package NS_KING_INTERFACE;

import UserGrowth.stSimpleMetaComment;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stGetFeedCommentListV2Rsp extends JceStruct {
    static ArrayList<stSimpleMetaComment> cache_comments = new ArrayList<>();
    static ArrayList<stMetaExternPlatformInfo> cache_externPlatformInfos;
    static Map<String, String> cache_replyListAttachInfos;
    static Map<String, stReplyListInfo> cache_replyListInfos;
    public String attach_info;
    public ArrayList<stSimpleMetaComment> comments;
    public ArrayList<stMetaExternPlatformInfo> externPlatformInfos;
    public String feed_id;
    public int isGetAll;
    public boolean is_finished;
    public Map<String, String> replyListAttachInfos;
    public Map<String, stReplyListInfo> replyListInfos;
    public int total_comment_num;

    static {
        cache_comments.add(new stSimpleMetaComment());
        cache_externPlatformInfos = new ArrayList<>();
        cache_externPlatformInfos.add(new stMetaExternPlatformInfo());
        HashMap hashMap = new HashMap();
        cache_replyListAttachInfos = hashMap;
        hashMap.put("", "");
        cache_replyListInfos = new HashMap();
        cache_replyListInfos.put("", new stReplyListInfo());
    }

    public stGetFeedCommentListV2Rsp() {
        this.attach_info = "";
        this.comments = null;
        this.is_finished = true;
        this.total_comment_num = 0;
        this.feed_id = "";
        this.isGetAll = 0;
        this.externPlatformInfos = null;
        this.replyListAttachInfos = null;
        this.replyListInfos = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.attach_info = jceInputStream.readString(0, true);
        this.comments = (ArrayList) jceInputStream.read((JceInputStream) cache_comments, 1, true);
        this.is_finished = jceInputStream.read(this.is_finished, 2, true);
        this.total_comment_num = jceInputStream.read(this.total_comment_num, 3, false);
        this.feed_id = jceInputStream.readString(4, false);
        this.isGetAll = jceInputStream.read(this.isGetAll, 5, false);
        this.externPlatformInfos = (ArrayList) jceInputStream.read((JceInputStream) cache_externPlatformInfos, 6, false);
        this.replyListAttachInfos = (Map) jceInputStream.read((JceInputStream) cache_replyListAttachInfos, 7, false);
        this.replyListInfos = (Map) jceInputStream.read((JceInputStream) cache_replyListInfos, 8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.attach_info, 0);
        jceOutputStream.write((Collection) this.comments, 1);
        jceOutputStream.write(this.is_finished, 2);
        jceOutputStream.write(this.total_comment_num, 3);
        String str = this.feed_id;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
        jceOutputStream.write(this.isGetAll, 5);
        ArrayList<stMetaExternPlatformInfo> arrayList = this.externPlatformInfos;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 6);
        }
        Map<String, String> map = this.replyListAttachInfos;
        if (map != null) {
            jceOutputStream.write((Map) map, 7);
        }
        Map<String, stReplyListInfo> map2 = this.replyListInfos;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 8);
        }
    }

    public stGetFeedCommentListV2Rsp(String str, ArrayList<stSimpleMetaComment> arrayList, boolean z16, int i3, String str2, int i16, ArrayList<stMetaExternPlatformInfo> arrayList2, Map<String, String> map, Map<String, stReplyListInfo> map2) {
        this.attach_info = str;
        this.comments = arrayList;
        this.is_finished = z16;
        this.total_comment_num = i3;
        this.feed_id = str2;
        this.isGetAll = i16;
        this.externPlatformInfos = arrayList2;
        this.replyListAttachInfos = map;
        this.replyListInfos = map2;
    }
}
