package NS_FAMOUS_SHARE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class get_famous_share_rsp extends JceStruct {
    static ArrayList<FeedsData> cache_cFeed = new ArrayList<>();
    static Map<Long, Integer> cache_fansAttention;
    static ArrayList<RelatedAccountInfo> cache_fansVec;
    static ArrayList<RelatedAccountInfo> cache_memberVec;
    public String adJumpUrl;
    public String adUrl;
    public ArrayList<FeedsData> cFeed;
    public Map<Long, Integer> fansAttention;
    public ArrayList<RelatedAccountInfo> fansVec;
    public String first_class;
    public ArrayList<RelatedAccountInfo> memberVec;
    public String sFamousDesc;
    public String sNick;
    public String second_class;
    public long uiFamousFansNum;
    public long uiVisitorCount;

    static {
        cache_cFeed.add(new FeedsData());
        cache_fansVec = new ArrayList<>();
        cache_fansVec.add(new RelatedAccountInfo());
        cache_memberVec = new ArrayList<>();
        cache_memberVec.add(new RelatedAccountInfo());
        cache_fansAttention = new HashMap();
        cache_fansAttention.put(0L, 0);
    }

    public get_famous_share_rsp() {
        this.sNick = "";
        this.sFamousDesc = "";
        this.first_class = "";
        this.second_class = "";
        this.uiFamousFansNum = 0L;
        this.uiVisitorCount = 0L;
        this.cFeed = null;
        this.fansVec = null;
        this.memberVec = null;
        this.adUrl = "";
        this.adJumpUrl = "";
        this.fansAttention = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.sNick = jceInputStream.readString(0, false);
        this.sFamousDesc = jceInputStream.readString(1, false);
        this.first_class = jceInputStream.readString(2, false);
        this.second_class = jceInputStream.readString(3, false);
        this.uiFamousFansNum = jceInputStream.read(this.uiFamousFansNum, 4, false);
        this.uiVisitorCount = jceInputStream.read(this.uiVisitorCount, 5, false);
        this.cFeed = (ArrayList) jceInputStream.read((JceInputStream) cache_cFeed, 6, false);
        this.fansVec = (ArrayList) jceInputStream.read((JceInputStream) cache_fansVec, 7, false);
        this.memberVec = (ArrayList) jceInputStream.read((JceInputStream) cache_memberVec, 8, false);
        this.adUrl = jceInputStream.readString(9, false);
        this.adJumpUrl = jceInputStream.readString(10, false);
        this.fansAttention = (Map) jceInputStream.read((JceInputStream) cache_fansAttention, 11, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.sNick;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.sFamousDesc;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.first_class;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.second_class;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
        jceOutputStream.write(this.uiFamousFansNum, 4);
        jceOutputStream.write(this.uiVisitorCount, 5);
        ArrayList<FeedsData> arrayList = this.cFeed;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 6);
        }
        ArrayList<RelatedAccountInfo> arrayList2 = this.fansVec;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 7);
        }
        ArrayList<RelatedAccountInfo> arrayList3 = this.memberVec;
        if (arrayList3 != null) {
            jceOutputStream.write((Collection) arrayList3, 8);
        }
        String str5 = this.adUrl;
        if (str5 != null) {
            jceOutputStream.write(str5, 9);
        }
        String str6 = this.adJumpUrl;
        if (str6 != null) {
            jceOutputStream.write(str6, 10);
        }
        Map<Long, Integer> map = this.fansAttention;
        if (map != null) {
            jceOutputStream.write((Map) map, 11);
        }
    }

    public get_famous_share_rsp(String str, String str2, String str3, String str4, long j3, long j16, ArrayList<FeedsData> arrayList, ArrayList<RelatedAccountInfo> arrayList2, ArrayList<RelatedAccountInfo> arrayList3, String str5, String str6, Map<Long, Integer> map) {
        this.sNick = str;
        this.sFamousDesc = str2;
        this.first_class = str3;
        this.second_class = str4;
        this.uiFamousFansNum = j3;
        this.uiVisitorCount = j16;
        this.cFeed = arrayList;
        this.fansVec = arrayList2;
        this.memberVec = arrayList3;
        this.adUrl = str5;
        this.adJumpUrl = str6;
        this.fansAttention = map;
    }
}
