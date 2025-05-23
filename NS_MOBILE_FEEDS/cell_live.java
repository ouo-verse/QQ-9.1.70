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
public final class cell_live extends JceStruct {
    static Map<String, String> cache_extendInfo;
    static Map<Integer, String> cache_mapExtendInfo;
    static ArrayList<SpecialMsg> cache_vctCommentList;
    static ArrayList<liveUser> cache_vctLiveUserList;
    public String exception_tips;
    public Map<String, String> extendInfo;
    public int giftNum;
    public int likeNum;
    public int liveType;
    public int livetime;
    public Map<Integer, String> mapExtendInfo;
    public String roomid;
    public int roomstat;
    public String tipsMessage;
    public int usercount;
    public ArrayList<SpecialMsg> vctCommentList;
    public ArrayList<liveUser> vctLiveUserList;

    static {
        HashMap hashMap = new HashMap();
        cache_extendInfo = hashMap;
        hashMap.put("", "");
        cache_vctCommentList = new ArrayList<>();
        cache_vctCommentList.add(new SpecialMsg());
        cache_vctLiveUserList = new ArrayList<>();
        cache_vctLiveUserList.add(new liveUser());
        cache_mapExtendInfo = new HashMap();
        cache_mapExtendInfo.put(0, "");
    }

    public cell_live() {
        this.roomid = "";
        this.roomstat = 0;
        this.usercount = 0;
        this.livetime = 0;
        this.giftNum = 0;
        this.likeNum = 0;
        this.tipsMessage = "";
        this.extendInfo = null;
        this.exception_tips = "";
        this.vctCommentList = null;
        this.vctLiveUserList = null;
        this.liveType = 0;
        this.mapExtendInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.roomid = jceInputStream.readString(0, false);
        this.roomstat = jceInputStream.read(this.roomstat, 1, false);
        this.usercount = jceInputStream.read(this.usercount, 2, false);
        this.livetime = jceInputStream.read(this.livetime, 3, false);
        this.giftNum = jceInputStream.read(this.giftNum, 5, false);
        this.likeNum = jceInputStream.read(this.likeNum, 6, false);
        this.tipsMessage = jceInputStream.readString(7, false);
        this.extendInfo = (Map) jceInputStream.read((JceInputStream) cache_extendInfo, 8, false);
        this.exception_tips = jceInputStream.readString(9, false);
        this.vctCommentList = (ArrayList) jceInputStream.read((JceInputStream) cache_vctCommentList, 10, false);
        this.vctLiveUserList = (ArrayList) jceInputStream.read((JceInputStream) cache_vctLiveUserList, 11, false);
        this.liveType = jceInputStream.read(this.liveType, 12, false);
        this.mapExtendInfo = (Map) jceInputStream.read((JceInputStream) cache_mapExtendInfo, 13, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.roomid;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.roomstat, 1);
        jceOutputStream.write(this.usercount, 2);
        jceOutputStream.write(this.livetime, 3);
        jceOutputStream.write(this.giftNum, 5);
        jceOutputStream.write(this.likeNum, 6);
        String str2 = this.tipsMessage;
        if (str2 != null) {
            jceOutputStream.write(str2, 7);
        }
        Map<String, String> map = this.extendInfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 8);
        }
        String str3 = this.exception_tips;
        if (str3 != null) {
            jceOutputStream.write(str3, 9);
        }
        ArrayList<SpecialMsg> arrayList = this.vctCommentList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 10);
        }
        ArrayList<liveUser> arrayList2 = this.vctLiveUserList;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 11);
        }
        jceOutputStream.write(this.liveType, 12);
        Map<Integer, String> map2 = this.mapExtendInfo;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 13);
        }
    }

    public cell_live(String str, int i3, int i16, int i17, int i18, int i19, String str2, Map<String, String> map, String str3, ArrayList<SpecialMsg> arrayList, ArrayList<liveUser> arrayList2, int i26, Map<Integer, String> map2) {
        this.roomid = str;
        this.roomstat = i3;
        this.usercount = i16;
        this.livetime = i17;
        this.giftNum = i18;
        this.likeNum = i19;
        this.tipsMessage = str2;
        this.extendInfo = map;
        this.exception_tips = str3;
        this.vctCommentList = arrayList;
        this.vctLiveUserList = arrayList2;
        this.liveType = i26;
        this.mapExtendInfo = map2;
    }
}
