package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_reply extends JceStruct {
    static Map<String, String> cache_extendInfo;
    static ArrayList<s_likeman> cache_likemans;
    public s_audio audio;
    public String content;
    public int date;
    public int displayflag;
    public Map<String, String> extendInfo;
    public boolean isDeleted;
    public int isliked;
    public int likeNum;
    public ArrayList<s_likeman> likemans;
    public String refer;
    public String replyLikeKey;
    public String replyid;
    public ArrayList<s_picdata> replypic;
    public s_user target;
    public s_user user;
    static s_user cache_user = new s_user();
    static s_audio cache_audio = new s_audio();
    static s_user cache_target = new s_user();
    static ArrayList<s_picdata> cache_replypic = new ArrayList<>();

    static {
        cache_replypic.add(new s_picdata());
        HashMap hashMap = new HashMap();
        cache_extendInfo = hashMap;
        hashMap.put("", "");
        cache_likemans = new ArrayList<>();
        cache_likemans.add(new s_likeman());
    }

    public s_reply() {
        this.replyid = "";
        this.user = null;
        this.content = "";
        this.date = 0;
        this.refer = "";
        this.audio = null;
        this.target = null;
        this.replypic = null;
        this.isDeleted = false;
        this.extendInfo = null;
        this.displayflag = 0;
        this.likeNum = 0;
        this.replyLikeKey = "";
        this.isliked = 0;
        this.likemans = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.replyid = jceInputStream.readString(0, false);
        this.user = (s_user) jceInputStream.read((JceStruct) cache_user, 1, false);
        this.content = jceInputStream.readString(2, false);
        this.date = jceInputStream.read(this.date, 3, false);
        this.refer = jceInputStream.readString(4, false);
        this.audio = (s_audio) jceInputStream.read((JceStruct) cache_audio, 5, false);
        this.target = (s_user) jceInputStream.read((JceStruct) cache_target, 6, false);
        this.replypic = (ArrayList) jceInputStream.read((JceInputStream) cache_replypic, 7, false);
        this.isDeleted = jceInputStream.read(this.isDeleted, 8, false);
        this.extendInfo = (Map) jceInputStream.read((JceInputStream) cache_extendInfo, 9, false);
        this.displayflag = jceInputStream.read(this.displayflag, 10, false);
        this.likeNum = jceInputStream.read(this.likeNum, 11, false);
        this.replyLikeKey = jceInputStream.readString(12, false);
        this.isliked = jceInputStream.read(this.isliked, 13, false);
        this.likemans = (ArrayList) jceInputStream.read((JceInputStream) cache_likemans, 14, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.replyid;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        s_user s_userVar = this.user;
        if (s_userVar != null) {
            jceOutputStream.write((JceStruct) s_userVar, 1);
        }
        String str2 = this.content;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        jceOutputStream.write(this.date, 3);
        String str3 = this.refer;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
        s_audio s_audioVar = this.audio;
        if (s_audioVar != null) {
            jceOutputStream.write((JceStruct) s_audioVar, 5);
        }
        s_user s_userVar2 = this.target;
        if (s_userVar2 != null) {
            jceOutputStream.write((JceStruct) s_userVar2, 6);
        }
        ArrayList<s_picdata> arrayList = this.replypic;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 7);
        }
        jceOutputStream.write(this.isDeleted, 8);
        Map<String, String> map = this.extendInfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 9);
        }
        jceOutputStream.write(this.displayflag, 10);
        jceOutputStream.write(this.likeNum, 11);
        String str4 = this.replyLikeKey;
        if (str4 != null) {
            jceOutputStream.write(str4, 12);
        }
        jceOutputStream.write(this.isliked, 13);
        ArrayList<s_likeman> arrayList2 = this.likemans;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 14);
        }
    }

    public s_reply(String str, s_user s_userVar, String str2, int i3, String str3, s_audio s_audioVar, s_user s_userVar2, ArrayList<s_picdata> arrayList, boolean z16, Map<String, String> map, int i16, int i17, String str4, int i18, ArrayList<s_likeman> arrayList2) {
        this.replyid = str;
        this.user = s_userVar;
        this.content = str2;
        this.date = i3;
        this.refer = str3;
        this.audio = s_audioVar;
        this.target = s_userVar2;
        this.replypic = arrayList;
        this.isDeleted = z16;
        this.extendInfo = map;
        this.displayflag = i16;
        this.likeNum = i17;
        this.replyLikeKey = str4;
        this.isliked = i18;
        this.likemans = arrayList2;
    }
}
