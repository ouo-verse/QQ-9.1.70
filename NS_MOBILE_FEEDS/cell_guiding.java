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
public final class cell_guiding extends JceStruct {
    static Map<Integer, String> cache_busi_param;
    static Map<String, String> cache_extendInfo;
    static int cache_guiding_type;
    static s_picdata cache_picdata = new s_picdata();
    static byte[] cache_tianshuEntry;
    static ArrayList<guide_button> cache_vecButton;
    static ArrayList<s_user> cache_vecUsers;
    public String action_url;
    public Map<Integer, String> busi_param;
    public String button_icon;
    public String button_title;
    public long cutLineJumpTime;
    public Map<String, String> extendInfo;
    public int guiding_type;
    public s_picdata picdata;
    public String strJsonClient;
    public String subsummary;
    public String summary;
    public byte[] tianshuEntry;
    public String title;
    public ArrayList<guide_button> vecButton;
    public ArrayList<s_user> vecUsers;

    static {
        HashMap hashMap = new HashMap();
        cache_extendInfo = hashMap;
        hashMap.put("", "");
        cache_guiding_type = 0;
        cache_vecUsers = new ArrayList<>();
        cache_vecUsers.add(new s_user());
        cache_vecButton = new ArrayList<>();
        cache_vecButton.add(new guide_button());
        cache_busi_param = new HashMap();
        cache_busi_param.put(0, "");
        cache_tianshuEntry = r1;
        byte[] bArr = {0};
    }

    public cell_guiding() {
        this.picdata = null;
        this.title = "";
        this.summary = "";
        this.button_title = "";
        this.action_url = "";
        this.extendInfo = null;
        this.guiding_type = 0;
        this.vecUsers = null;
        this.vecButton = null;
        this.subsummary = "";
        this.button_icon = "";
        this.strJsonClient = "";
        this.cutLineJumpTime = 0L;
        this.busi_param = null;
        this.tianshuEntry = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.picdata = (s_picdata) jceInputStream.read((JceStruct) cache_picdata, 0, false);
        this.title = jceInputStream.readString(1, false);
        this.summary = jceInputStream.readString(2, false);
        this.button_title = jceInputStream.readString(3, false);
        this.action_url = jceInputStream.readString(4, false);
        this.extendInfo = (Map) jceInputStream.read((JceInputStream) cache_extendInfo, 5, false);
        this.guiding_type = jceInputStream.read(this.guiding_type, 6, false);
        this.vecUsers = (ArrayList) jceInputStream.read((JceInputStream) cache_vecUsers, 7, false);
        this.vecButton = (ArrayList) jceInputStream.read((JceInputStream) cache_vecButton, 8, false);
        this.subsummary = jceInputStream.readString(9, false);
        this.button_icon = jceInputStream.readString(10, false);
        this.strJsonClient = jceInputStream.readString(11, false);
        this.cutLineJumpTime = jceInputStream.read(this.cutLineJumpTime, 12, false);
        this.busi_param = (Map) jceInputStream.read((JceInputStream) cache_busi_param, 13, false);
        this.tianshuEntry = jceInputStream.read(cache_tianshuEntry, 14, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        s_picdata s_picdataVar = this.picdata;
        if (s_picdataVar != null) {
            jceOutputStream.write((JceStruct) s_picdataVar, 0);
        }
        String str = this.title;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.summary;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.button_title;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        String str4 = this.action_url;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
        Map<String, String> map = this.extendInfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 5);
        }
        jceOutputStream.write(this.guiding_type, 6);
        ArrayList<s_user> arrayList = this.vecUsers;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 7);
        }
        ArrayList<guide_button> arrayList2 = this.vecButton;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 8);
        }
        String str5 = this.subsummary;
        if (str5 != null) {
            jceOutputStream.write(str5, 9);
        }
        String str6 = this.button_icon;
        if (str6 != null) {
            jceOutputStream.write(str6, 10);
        }
        String str7 = this.strJsonClient;
        if (str7 != null) {
            jceOutputStream.write(str7, 11);
        }
        jceOutputStream.write(this.cutLineJumpTime, 12);
        Map<Integer, String> map2 = this.busi_param;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 13);
        }
        byte[] bArr = this.tianshuEntry;
        if (bArr != null) {
            jceOutputStream.write(bArr, 14);
        }
    }

    public cell_guiding(s_picdata s_picdataVar, String str, String str2, String str3, String str4, Map<String, String> map, int i3, ArrayList<s_user> arrayList, ArrayList<guide_button> arrayList2, String str5, String str6, String str7, long j3, Map<Integer, String> map2, byte[] bArr) {
        this.picdata = s_picdataVar;
        this.title = str;
        this.summary = str2;
        this.button_title = str3;
        this.action_url = str4;
        this.extendInfo = map;
        this.guiding_type = i3;
        this.vecUsers = arrayList;
        this.vecButton = arrayList2;
        this.subsummary = str5;
        this.button_icon = str6;
        this.strJsonClient = str7;
        this.cutLineJumpTime = j3;
        this.busi_param = map2;
        this.tianshuEntry = bArr;
    }
}
