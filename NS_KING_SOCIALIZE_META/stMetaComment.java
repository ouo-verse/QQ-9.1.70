package NS_KING_SOCIALIZE_META;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stMetaComment extends JceStruct {
    static stMetaPerson cache_poster = new stMetaPerson();
    static stMetaPerson cache_receiver = new stMetaPerson();
    static ArrayList<stMetaReply> cache_replyList = new ArrayList<>();
    static Map<Integer, String> cache_reserve;
    public String beReplyCommendId;
    public int createtime;
    public long dingNum;
    public int essOpUin;
    public String feedId;
    public String feedOwnerId;

    /* renamed from: id, reason: collision with root package name */
    public String f24936id;
    public int isDing;
    public boolean isTempData;
    public int mask;
    public stMetaPerson poster;
    public String poster_id;
    public stMetaPerson receiver;
    public String receiver_id;
    public long replyIdNum;
    public ArrayList<stMetaReply> replyList;
    public long replyNum;
    public Map<Integer, String> reserve;
    public int robotMode;
    public String wording;

    static {
        cache_replyList.add(new stMetaReply());
        cache_reserve = new HashMap();
        cache_reserve.put(0, "");
    }

    public stMetaComment() {
        this.f24936id = "";
        this.wording = "";
        this.poster_id = "";
        this.poster = null;
        this.receiver_id = "";
        this.receiver = null;
        this.createtime = 0;
        this.mask = 0;
        this.robotMode = 0;
        this.beReplyCommendId = "";
        this.essOpUin = 0;
        this.dingNum = 0L;
        this.isDing = 0;
        this.replyList = null;
        this.replyNum = 0L;
        this.feedOwnerId = "";
        this.reserve = null;
        this.feedId = "";
        this.replyIdNum = 0L;
        this.isTempData = false;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f24936id = jceInputStream.readString(0, false);
        this.wording = jceInputStream.readString(1, false);
        this.poster_id = jceInputStream.readString(2, false);
        this.poster = (stMetaPerson) jceInputStream.read((JceStruct) cache_poster, 3, false);
        this.receiver_id = jceInputStream.readString(4, false);
        this.receiver = (stMetaPerson) jceInputStream.read((JceStruct) cache_receiver, 5, false);
        this.createtime = jceInputStream.read(this.createtime, 6, false);
        this.mask = jceInputStream.read(this.mask, 7, false);
        this.robotMode = jceInputStream.read(this.robotMode, 8, false);
        this.beReplyCommendId = jceInputStream.readString(9, false);
        this.essOpUin = jceInputStream.read(this.essOpUin, 10, false);
        this.dingNum = jceInputStream.read(this.dingNum, 11, false);
        this.isDing = jceInputStream.read(this.isDing, 12, false);
        this.replyList = (ArrayList) jceInputStream.read((JceInputStream) cache_replyList, 13, false);
        this.replyNum = jceInputStream.read(this.replyNum, 14, false);
        this.feedOwnerId = jceInputStream.readString(15, false);
        this.reserve = (Map) jceInputStream.read((JceInputStream) cache_reserve, 16, false);
        this.feedId = jceInputStream.readString(17, false);
        this.replyIdNum = jceInputStream.read(this.replyIdNum, 18, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.f24936id;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.wording;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.poster_id;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        stMetaPerson stmetaperson = this.poster;
        if (stmetaperson != null) {
            jceOutputStream.write((JceStruct) stmetaperson, 3);
        }
        String str4 = this.receiver_id;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
        stMetaPerson stmetaperson2 = this.receiver;
        if (stmetaperson2 != null) {
            jceOutputStream.write((JceStruct) stmetaperson2, 5);
        }
        jceOutputStream.write(this.createtime, 6);
        jceOutputStream.write(this.mask, 7);
        jceOutputStream.write(this.robotMode, 8);
        String str5 = this.beReplyCommendId;
        if (str5 != null) {
            jceOutputStream.write(str5, 9);
        }
        jceOutputStream.write(this.essOpUin, 10);
        jceOutputStream.write(this.dingNum, 11);
        jceOutputStream.write(this.isDing, 12);
        ArrayList<stMetaReply> arrayList = this.replyList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 13);
        }
        jceOutputStream.write(this.replyNum, 14);
        String str6 = this.feedOwnerId;
        if (str6 != null) {
            jceOutputStream.write(str6, 15);
        }
        Map<Integer, String> map = this.reserve;
        if (map != null) {
            jceOutputStream.write((Map) map, 16);
        }
        String str7 = this.feedId;
        if (str7 != null) {
            jceOutputStream.write(str7, 17);
        }
        jceOutputStream.write(this.replyIdNum, 18);
    }

    public stMetaComment(String str, String str2) {
        this.f24936id = "";
        this.poster = null;
        this.receiver_id = "";
        this.receiver = null;
        this.createtime = 0;
        this.mask = 0;
        this.robotMode = 0;
        this.beReplyCommendId = "";
        this.essOpUin = 0;
        this.dingNum = 0L;
        this.isDing = 0;
        this.replyList = null;
        this.replyNum = 0L;
        this.feedOwnerId = "";
        this.reserve = null;
        this.feedId = "";
        this.replyIdNum = 0L;
        this.isTempData = false;
        this.wording = str;
        this.poster_id = str2;
    }

    public stMetaComment(String str, String str2, String str3, stMetaPerson stmetaperson, String str4, stMetaPerson stmetaperson2, int i3, int i16, int i17, String str5, int i18, long j3, int i19, ArrayList<stMetaReply> arrayList, long j16, String str6, Map<Integer, String> map, String str7, long j17) {
        this.isTempData = false;
        this.f24936id = str;
        this.wording = str2;
        this.poster_id = str3;
        this.poster = stmetaperson;
        this.receiver_id = str4;
        this.receiver = stmetaperson2;
        this.createtime = i3;
        this.mask = i16;
        this.robotMode = i17;
        this.beReplyCommendId = str5;
        this.essOpUin = i18;
        this.dingNum = j3;
        this.isDing = i19;
        this.replyList = arrayList;
        this.replyNum = j16;
        this.feedOwnerId = str6;
        this.reserve = map;
        this.feedId = str7;
        this.replyIdNum = j17;
    }
}
