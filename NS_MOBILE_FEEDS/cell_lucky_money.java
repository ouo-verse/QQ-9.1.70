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
public final class cell_lucky_money extends JceStruct {
    static Map<String, String> cache_extendinfo;
    static ArrayList<s_user> cache_getLuckyMoneyMen = new ArrayList<>();
    public String actionUrl;
    public Map<String, String> extendinfo;
    public ArrayList<s_user> getLuckyMoneyMen;
    public int isGeted;
    public int isGrabEnd;
    public int luckyMoneyAllocType;
    public String luckyMoneyId;
    public String luckyMoneyPayId;
    public int luckyMoneyType;
    public int num;
    public int paswdShowComment;
    public long uiHbCreateTime;
    public long uiHbHostUin;

    static {
        cache_getLuckyMoneyMen.add(new s_user());
        HashMap hashMap = new HashMap();
        cache_extendinfo = hashMap;
        hashMap.put("", "");
    }

    public cell_lucky_money() {
        this.num = 0;
        this.isGeted = 0;
        this.getLuckyMoneyMen = null;
        this.actionUrl = "";
        this.extendinfo = null;
        this.luckyMoneyId = "";
        this.luckyMoneyPayId = "";
        this.isGrabEnd = 0;
        this.luckyMoneyType = 0;
        this.luckyMoneyAllocType = 0;
        this.paswdShowComment = 0;
        this.uiHbHostUin = 0L;
        this.uiHbCreateTime = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.num = jceInputStream.read(this.num, 0, false);
        this.isGeted = jceInputStream.read(this.isGeted, 1, false);
        this.getLuckyMoneyMen = (ArrayList) jceInputStream.read((JceInputStream) cache_getLuckyMoneyMen, 2, false);
        this.actionUrl = jceInputStream.readString(3, false);
        this.extendinfo = (Map) jceInputStream.read((JceInputStream) cache_extendinfo, 4, false);
        this.luckyMoneyId = jceInputStream.readString(5, false);
        this.luckyMoneyPayId = jceInputStream.readString(6, false);
        this.isGrabEnd = jceInputStream.read(this.isGrabEnd, 7, false);
        this.luckyMoneyType = jceInputStream.read(this.luckyMoneyType, 8, false);
        this.luckyMoneyAllocType = jceInputStream.read(this.luckyMoneyAllocType, 9, false);
        this.paswdShowComment = jceInputStream.read(this.paswdShowComment, 10, false);
        this.uiHbHostUin = jceInputStream.read(this.uiHbHostUin, 11, false);
        this.uiHbCreateTime = jceInputStream.read(this.uiHbCreateTime, 12, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.num, 0);
        jceOutputStream.write(this.isGeted, 1);
        ArrayList<s_user> arrayList = this.getLuckyMoneyMen;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        String str = this.actionUrl;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        Map<String, String> map = this.extendinfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 4);
        }
        String str2 = this.luckyMoneyId;
        if (str2 != null) {
            jceOutputStream.write(str2, 5);
        }
        String str3 = this.luckyMoneyPayId;
        if (str3 != null) {
            jceOutputStream.write(str3, 6);
        }
        jceOutputStream.write(this.isGrabEnd, 7);
        jceOutputStream.write(this.luckyMoneyType, 8);
        jceOutputStream.write(this.luckyMoneyAllocType, 9);
        jceOutputStream.write(this.paswdShowComment, 10);
        jceOutputStream.write(this.uiHbHostUin, 11);
        jceOutputStream.write(this.uiHbCreateTime, 12);
    }

    public cell_lucky_money(int i3, int i16, ArrayList<s_user> arrayList, String str, Map<String, String> map, String str2, String str3, int i17, int i18, int i19, int i26, long j3, long j16) {
        this.num = i3;
        this.isGeted = i16;
        this.getLuckyMoneyMen = arrayList;
        this.actionUrl = str;
        this.extendinfo = map;
        this.luckyMoneyId = str2;
        this.luckyMoneyPayId = str3;
        this.isGrabEnd = i17;
        this.luckyMoneyType = i18;
        this.luckyMoneyAllocType = i19;
        this.paswdShowComment = i26;
        this.uiHbHostUin = j3;
        this.uiHbCreateTime = j16;
    }
}
